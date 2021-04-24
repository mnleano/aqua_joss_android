package com.ajws.aquajoss.ui

import android.content.Context
import com.ajws.aquajoss.BuildConfig
import com.ajws.aquajoss.data.entities.*
import com.ajws.aquajoss.data.local.AccountPrefStore
import com.ajws.aquajoss.data.local.LocalPreferences
import com.ajws.aquajoss.data.manager.DatabaseManager
import com.ajws.aquajoss.data.remote.AuthenticationService
import com.ajws.aquajoss.data.remote.BearerInterceptor
import com.ajws.aquajoss.data.repository.AuthenticationRepository
import com.ajws.aquajoss.data.repository.ProductRepository
import com.ajws.aquajoss.data.viewModels.*
import com.facebook.flipper.android.AndroidFlipperClient
import com.facebook.flipper.android.utils.FlipperUtils
import com.facebook.soloader.SoLoader
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.tencent.mmkv.MMKV
import io.objectbox.Box
import io.objectbox.BoxStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

fun initMmvk(context: Context): MMKV {
    MMKV.initialize(context)
    val mmkv = MMKV.defaultMMKV(MMKV.SINGLE_PROCESS_MODE, "TODO: key-for-encryption")!!
    SoLoader.init(context, false)
    if (BuildConfig.DEBUG && FlipperUtils.shouldEnableFlipper(context)) {
        with(AndroidFlipperClient.getInstance(context)) {
//            this.addPlugin(
//                MMKVFlipperPlugin(
//                    MMKV.defaultMMKV()!!.mmapID()
//                )
//            ) // mmkv viewer plugin supports
            this.start()
        }
    }
    return mmkv
}

private fun initOkHttpClient(bearerInterceptor: BearerInterceptor): OkHttpClient {
    val okHttpClientBuilder = OkHttpClient.Builder()
        .addInterceptor(bearerInterceptor)
        .addInterceptor(
            HttpLoggingInterceptor().setLevel(
                if (BuildConfig.DEBUG)
                    HttpLoggingInterceptor.Level.BODY
                else HttpLoggingInterceptor.Level.NONE
            )
        )
        .connectTimeout(60, TimeUnit.SECONDS).readTimeout(60, TimeUnit.SECONDS)
        .writeTimeout(60, TimeUnit.SECONDS)
        .retryOnConnectionFailure(true)
    return okHttpClientBuilder.build()
}

fun initGson(): Gson = GsonBuilder().setLenient().create()

fun initCoroutineScope(): CoroutineScope =
    CoroutineScope(Dispatchers.IO + SupervisorJob())


val modules = module {

    // Web service
    single { BearerInterceptor(get()) }
    single { initOkHttpClient(get()) }
    single {
        Retrofit
            .Builder()
            .client(get())
            .addConverterFactory(GsonConverterFactory.create(initGson()))
            .baseUrl(BuildConfig.BASE_URL)
            .build()
    }

    single { initCoroutineScope() }

    //SharedPreferences
    single { Gson() }
    single { initMmvk(get()) }
    factory { LocalPreferences(get(), get()) }
    factory { AccountPrefStore(get()) }

    // ObjectBox
    single { MyObjectBox.builder().androidContext(get<Context>()).build() }
    factory(named("cartProductBox")) { get<BoxStore>().boxFor(CartProduct::class.java) as Box<CartProduct> }
    factory(named("orderHistoryBox")) { get<BoxStore>().boxFor(OrderHistory::class.java) as Box<OrderHistory> }
    factory(named("orderProductBox")) { get<BoxStore>().boxFor(OrderProduct::class.java) as Box<OrderProduct> }
    factory(named("userBox")) { get<BoxStore>().boxFor(User::class.java) as Box<User> }

    single {
        DatabaseManager(
            get(named("cartProductBox")),
            get(named("orderHistoryBox")),
            get(named("orderProductBox")),
            get(named("userBox")),
        )
    }

    // Services
    single { get<Retrofit>().create(AuthenticationService::class.java) as AuthenticationService }

    // Repository
    single { AuthenticationRepository(get(), get(), get()) }
    single { ProductRepository(get()) }

    // ViewModel
    viewModel { BaseViewModel() }
    viewModel { LoginViewModel(get()) }
    viewModel { SignUpViewModel(get()) }
    viewModel { ProductViewModel(get()) }
    viewModel { ProfileViewModel(get()) }
    viewModel { OrderViewModel(get()) }

}

