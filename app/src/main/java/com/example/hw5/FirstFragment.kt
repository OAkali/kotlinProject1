package com.example.hw5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hw5.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private lateinit var binding:FragmentFirstBinding

    private var num=0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentFirstBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btn.setOnClickListener {
            num++
            binding.zeroTv.text=num.toString()
            if (binding.zeroTv.text.toString().equals("10")){
                binding.btn.text="-"
                binding.btn.setOnClickListener {
                    num--
                    binding.zeroTv.text=num.toString()
                    if (binding.zeroTv.text.toString().equals("0")){
                        val bundle=Bundle()
                        bundle.putString("key1",binding.zeroTv.text.toString())
                        var second=SecondFragment()
                        second.arguments=bundle
                        requireActivity().supportFragmentManager.beginTransaction().replace(R.id.fL,second).commit()
                    }
                }
            }
        }
    }


}