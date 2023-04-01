package com.example.pr5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TimePicker.OnTimeChangedListener
import androidx.fragment.app.Fragment
import com.example.pr5.databinding.FragmentXMLSecondBinding


class XMLSecondFragment : Fragment() {

    private var _binding: FragmentXMLSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentXMLSecondBinding.inflate(inflater, container, false)

        binding.radios.setOnCheckedChangeListener { _, id ->
            val selection = binding.selection
            when (id) {
                binding.java.id -> selection.text = "Выбрана Java"
                binding.kotlin.id -> selection.text = "Выбран Kotlin"
                else -> {}
            }
        }

        binding.datePicker.init(2023, 4, 1) { view, _, _, _ ->
            binding.dateTextView.text =
                "Дата: " + view.dayOfMonth + "/" + (view.month + 1) + "/" + view.year
        }


        binding.timePicker.setOnTimeChangedListener{ _, hourOfDay, minute ->
            binding.timeTextView.text = "Время: $hourOfDay:$minute"
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}