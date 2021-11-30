package com.example.navigationcomponent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navigationcomponent.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private val mBinding by lazy { FragmentFirstBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val controller = findNavController()

        mBinding.btnOpenFragment2.setOnClickListener {
//            val bundle = bundleOf(
//                "userName" to mBinding.edtName.text.toString()
//            )

            if (mBinding.edtName.text.toString().isNotEmpty() && mBinding.edtAge.text.toString()
                    .isNotEmpty()
            ) {
                val user =
                    User(mBinding.edtName.text.toString(), mBinding.edtAge.text.toString().toInt())
                val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment2(user)
//                val bundle = bundleOf("user" to user)
                controller.navigate(action)
            }
//            controller.navigate(R.id.secondFragment)
        }
        mBinding.btnOpenFragment3.setOnClickListener {
            controller.navigate(R.id.thirdFragment)
        }
        mBinding.btnOpenDialog.setOnClickListener {
            controller.navigate(R.id.myDialog)
        }
    }
}