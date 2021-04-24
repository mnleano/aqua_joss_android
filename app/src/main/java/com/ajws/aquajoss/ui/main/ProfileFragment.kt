package com.ajws.aquajoss.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ajws.aquajoss.R
import com.ajws.aquajoss.data.viewModels.ProfileViewModel
import com.ajws.aquajoss.databinding.FragmentProfileBinding
import com.ajws.aquajoss.ui.intro.IntroActivity
import com.ajws.aquajoss.ui.widget.DialogUtil
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileFragment : Fragment() {

    private val vm: ProfileViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentProfileBinding.inflate(inflater, container, false)

        binding.lifecycleOwner = this
        binding.vm = vm

        vm.logOutClickEvent.observe(viewLifecycleOwner, {
            DialogUtil.show(
                requireActivity(),
                getString(R.string.log_out_confirmation),
                getString(R.string.log_out),
                { dialog, _ ->
                    dialog.dismiss()
                    vm.logOut()
                },
                getString(R.string.cancel)
            )
        })

        vm.logOutSuccessfulEvent.observe(viewLifecycleOwner, {
            requireActivity().apply {
                startActivity(Intent(this, IntroActivity::class.java))
                finish()
            }
        })

        return binding.root
    }
}