package com.example.navigationcomponent

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.navigationcomponent.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {
    private val mBinding by lazy {
        FragmentThirdBinding.inflate(layoutInflater)
    }
    private val args: ThirdFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val name = args.username
        mBinding.name.text = name
        Log.e("onViewCreated: ", name + "")
    }
}