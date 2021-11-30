package com.example.navigationcomponent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.navigationcomponent.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private val mBinding by lazy {
        FragmentSecondBinding.inflate(layoutInflater)
    }
    private val args: SecondFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val userName = arguments?.getSerializable("user") as User?
        val user = args.user

        mBinding.txtName.text = user.userName
        mBinding.txtAge.text = user.age.toString()

        val controller = findNavController()
        mBinding.btnOpenFragment3.setOnClickListener {
            //id destination
            controller.navigate(R.id.thirdFragment)
        }

    }
}