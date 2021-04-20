package com.ajws.aquajoss.ui

import android.content.Context
import com.ajws.aquajoss.BuildConfig
import com.ajws.aquajoss.data.entities.MyObjectBox
import com.ajws.aquajoss.data.entities.Order
import com.ajws.aquajoss.data.entities.Product
import com.ajws.aquajoss.data.entities.ProductOrder
import com.ajws.aquajoss.data.local.AccountPrefStore
import com.ajws.aquajoss.data.local.LocalPreferences
import com.ajws.aquajoss.data.manager.DatabaseManager
import com.facebook.flipper.android.AndroidFlipperClient
import com.facebook.flipper.android.utils.FlipperUtils
import com.facebook.soloader.SoLoader
import com.google.gson.Gson
import com.tencent.mmkv.MMKV
import io.objectbox.Box
import io.objectbox.BoxStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.core.qualifier.named
import org.koin.dsl.module

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

fun initCoroutineScope(): CoroutineScope =
    CoroutineScope(Dispatchers.IO + SupervisorJob())


val modules = module {
    //SharedPreferences
    single { Gson() }
    single { initMmvk(get()) }
    factory { LocalPreferences(get(), get()) }
    factory { AccountPrefStore(get()) }

    // ObjectBox
    single { MyObjectBox.builder().androidContext(get<Context>()).build() }
    factory(named("orderBox")) { get<BoxStore>().boxFor(Order::class.java) as Box<Order> }
    factory(named("productBox")) { get<BoxStore>().boxFor(Product::class.java) as Box<Product> }
    factory(named("productOrderBox")) { get<BoxStore>().boxFor(ProductOrder::class.java) as Box<ProductOrder> }

    single {
        DatabaseManager(
            get(named("orderBox")),
            get(named("productBox")),
            get(named("productOrderBox"))
        )
    }
}
