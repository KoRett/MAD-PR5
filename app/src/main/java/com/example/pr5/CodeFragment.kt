package com.example.pr5

import android.content.Context
import android.graphics.Typeface
import android.os.Bundle
import android.text.util.Linkify
import android.util.TypedValue
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar


class CodeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val constraintLayout = ConstraintLayout(requireContext())
        val margin20dp =
            TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20F, resources.displayMetrics)
                .toInt()

        val textView = TextView(context)
        textView.setBackgroundColor(-0x17150a)
        textView.setTextColor(-0xa39440)
        textView.id = View.generateViewId()
        textView.isAllCaps = true
        textView.textAlignment = TextView.TEXT_ALIGNMENT_CENTER
        textView.text = "Посетите сайт https://www.mirea.ru\n\nНомер: +7 (123) 456-78-90"
        textView.typeface = Typeface.create("casual", Typeface.NORMAL)
        textView.textSize = 16f
        Linkify.addLinks(textView, Linkify.WEB_URLS)
        Linkify.addLinks(textView, Linkify.PHONE_NUMBERS)

        val layoutParams = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.WRAP_CONTENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        )

        layoutParams.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID
        layoutParams.rightToRight = ConstraintLayout.LayoutParams.PARENT_ID
        layoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID
        textView.layoutParams = layoutParams

        val etFirst = EditText(context)
        etFirst.id = View.generateViewId()
        etFirst.hint = "Введите что-нибудь (1)"
        etFirst.isSingleLine = true
        val layoutParams1 = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.WRAP_CONTENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        )
        layoutParams1.topToBottom = textView.id
        layoutParams1.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID
        layoutParams1.rightToRight = ConstraintLayout.LayoutParams.PARENT_ID
        layoutParams1.setMargins(0, margin20dp, 0, 0)
        etFirst.layoutParams = layoutParams1

        val etSecond = EditText(context)
        etSecond.id = View.generateViewId()
        etSecond.hint = "Введите что-нибудь (2)"
        etSecond.isSingleLine = false
        val layoutParams2 = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.WRAP_CONTENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        )
        layoutParams2.topToBottom = etFirst.id
        layoutParams2.leftToLeft = etFirst.id
        layoutParams2.rightToRight = etFirst.id
        layoutParams2.setMargins(0, margin20dp, 0, 0)
        etSecond.layoutParams = layoutParams2

        etFirst.doAfterTextChanged { etSecond.text = etFirst.text }

        val button = Button(context)
        button.id = View.generateViewId()
        button.text = "Ввод"
        button.setOnClickListener {
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
        val layoutParams3 = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.WRAP_CONTENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        )
        layoutParams3.setMargins(0, margin20dp, 0, 0)
        layoutParams3.rightToRight = ConstraintLayout.LayoutParams.PARENT_ID
        layoutParams3.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID
        layoutParams3.topToBottom = etSecond.id
        button.layoutParams = layoutParams3

        val toggleButton = ToggleButton(context)
        toggleButton.textOff = "Выключено"
        toggleButton.textOn = "Включено"
        toggleButton.text = "Выключено"
        toggleButton.setOnClickListener {
            if (toggleButton.isChecked)
                Toast.makeText(context, "Свет включен", Toast.LENGTH_LONG).show()
            else
                Toast.makeText(context, "Свет выключен!", Toast.LENGTH_LONG).show()
        }
        val layoutParams4 = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.WRAP_CONTENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        )
        layoutParams4.setMargins(0, margin20dp, 0, 0)
        layoutParams4.topToBottom = button.id
        layoutParams4.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID
        layoutParams4.rightToRight = ConstraintLayout.LayoutParams.PARENT_ID
        toggleButton.layoutParams = layoutParams4

        constraintLayout.addView(textView)
        constraintLayout.addView(etFirst)
        constraintLayout.addView(etSecond)
        constraintLayout.addView(button)
        constraintLayout.addView(toggleButton)
        return constraintLayout
    }
}