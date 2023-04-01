package com.example.pr5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.pr5.databinding.FragmentStartBinding

class StartFragment : Fragment() {

    private var _binding: FragmentStartBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStartBinding.inflate(inflater, container, false)
        binding.btCode.setOnClickListener { findNavController().navigate(R.id.codeFragment) }
        binding.btXmlFirst.setOnClickListener { findNavController().navigate(R.id.XMLFirstFragment) }
        binding.btXmlSecond.setOnClickListener { findNavController().navigate(R.id.XMLSecondFragment) }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}