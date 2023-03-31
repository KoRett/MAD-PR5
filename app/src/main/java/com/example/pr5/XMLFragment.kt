package com.example.pr5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pr5.databinding.FragmentXMLBinding

class XMLFragment : Fragment() {

    private var _binding: FragmentXMLBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentXMLBinding.inflate(inflater, container, false)
        return binding.root
    }
}