package com.example.pr5

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import com.example.pr5.databinding.FragmentXMLFirstBinding
import com.google.android.material.snackbar.Snackbar


class XMLFirstFragment : Fragment() {

    private var _binding: FragmentXMLFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentXMLFirstBinding.inflate(inflater, container, false)
        val etFirst = binding.etFirst
        val etSecond = binding.etSecond
        etFirst.doAfterTextChanged { etSecond.text = etFirst.text }


        binding.btEnter.setOnClickListener {
            val text = etFirst.text.toString()
            etFirst.text.clear()
            etSecond.setText(text)
            val snackbar = Snackbar.make(it, "Hello!", Snackbar.LENGTH_SHORT)
            snackbar.setTextColor(-0xa39440)
            snackbar.setBackgroundTint(-0x17150a)
            snackbar.setAction("Next...") {
                val toast = Toast.makeText(requireContext(), "Click!", Toast.LENGTH_SHORT)
                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.show()
            }
            snackbar.show()
        }

        binding.java.setOnClickListener {
            var selectedItems = ""
            if (binding.java.isChecked) selectedItems += binding.java.text.toString() + " "
            if (binding.kotlin.isChecked) selectedItems += binding.kotlin.text
            binding.selection.text = selectedItems
        }
        binding.kotlin.setOnCheckedChangeListener { compoundButton, b ->
            var selectedItems = ""
            if (binding.java.isChecked) selectedItems += binding.java.text.toString() + " "
            if (b) selectedItems += binding.kotlin.text
            binding.selection.text = selectedItems
        }

        binding.toggle.setOnClickListener {
            if (binding.toggle.isChecked)
                Toast.makeText(context, "Свет включен!", Toast.LENGTH_LONG).show()
            else
                Toast.makeText(context, "Свет выключен!", Toast.LENGTH_LONG).show()
        }

        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                binding.seekBarValue.text = p1.toString()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

        })

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}