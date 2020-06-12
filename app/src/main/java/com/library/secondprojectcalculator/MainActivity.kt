package com.library.secondprojectcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonClick(view: View) {
        val buttonClick = view as Button
        if (isNewExperssion) {
            editText_values.setText("");
        }
        isNewExperssion = false
        var buttonClickedText: String = editText_values.text.toString();
        when (buttonClick.id) {
            R.id.button_0 -> buttonClickedText += "0"
            R.id.button_1 -> buttonClickedText += "1"
            R.id.button_2 -> buttonClickedText += "2"
            R.id.button_3 -> buttonClickedText += "3"
            R.id.button_4 -> buttonClickedText += "4"
            R.id.button_5 -> buttonClickedText += "5"
            R.id.button_6 -> buttonClickedText += "6"
            R.id.button_7 -> buttonClickedText += "7"
            R.id.button_8 -> buttonClickedText += "8"
            R.id.button_9 -> buttonClickedText += "9"
            R.id.button_plus_and_minus -> "-" + buttonClickedText

        }
        editText_values.setText(buttonClickedText)
    }

    var op = "*"
    var oldnumber = ""
    var isNewExperssion = true
    fun buttonClickMathOp(view: View) {
        val buttonClickMathOp = view as Button
        when (buttonClickMathOp.id) {
            R.id.button_multiply -> op = "*"
            R.id.button_divide -> op = "/"
            R.id.button_plus -> op = "+"
            R.id.button_minus -> op = "-"
        }
        oldnumber = editText_values.text.toString()
        isNewExperssion = true
    }

    fun buttonClickEqual(view: View) {
        var newnumber = ""
        var finalNumber: Double? = null
        newnumber = editText_values.text.toString()

        when (op) {
            "*" -> {
                finalNumber = oldnumber.toDouble() * newnumber.toDouble()
            }
            "/" -> {
                finalNumber = oldnumber.toDouble() / newnumber.toDouble()
            }
            "+" -> {
                finalNumber = oldnumber.toDouble() + newnumber.toDouble()
            }
            "-" -> {
                finalNumber = oldnumber.toDouble() - newnumber.toDouble()
            }
        }
        editText_values.setText(finalNumber.toString())
        isNewExperssion = true
    }

    fun buPercent(view:View){
        val number:Double=editText_values.text.toString().toDouble()/100

        editText_values.setText(number.toString())
        isNewExperssion=true

    }

    fun buClean(view:View){
        editText_values.setText("0")
        isNewExperssion=true
    }
}
