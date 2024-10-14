package com.example.basiccalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var textResult: TextView

    var state: Int = 1 // 1 means input for first operand, 2 for second
    var op: Int = 0 // Operation: 0 = none, 1 = add, 2 = subtract, 3 = multiply, 4 = divide
    var op1: Int = 0 // First operand
    var op2: Int = 0 // Second operand

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textResult = findViewById(R.id.text_result)

        // Set click listeners for all buttons
        findViewById<Button>(R.id.btn0).setOnClickListener(this)
        findViewById<Button>(R.id.btn1).setOnClickListener(this)
        findViewById<Button>(R.id.btn2).setOnClickListener(this)
        findViewById<Button>(R.id.btn3).setOnClickListener(this)
        findViewById<Button>(R.id.btn4).setOnClickListener(this)
        findViewById<Button>(R.id.btn5).setOnClickListener(this)
        findViewById<Button>(R.id.btn6).setOnClickListener(this)
        findViewById<Button>(R.id.btn7).setOnClickListener(this)
        findViewById<Button>(R.id.btn8).setOnClickListener(this)
        findViewById<Button>(R.id.btn9).setOnClickListener(this)

        findViewById<Button>(R.id.btnAdd).setOnClickListener(this)
        findViewById<Button>(R.id.btnMinus).setOnClickListener(this)
        findViewById<Button>(R.id.btnMultiple).setOnClickListener(this)
        findViewById<Button>(R.id.btnDivide).setOnClickListener(this)
        findViewById<Button>(R.id.btnEqual).setOnClickListener(this)
        findViewById<Button>(R.id.btnClear).setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        val id = p0?.id
        when (id) {
            R.id.btn0 -> addDigit(0)
            R.id.btn1 -> addDigit(1)
            R.id.btn2 -> addDigit(2)
            R.id.btn3 -> addDigit(3)
            R.id.btn4 -> addDigit(4)
            R.id.btn5 -> addDigit(5)
            R.id.btn6 -> addDigit(6)
            R.id.btn7 -> addDigit(7)
            R.id.btn8 -> addDigit(8)
            R.id.btn9 -> addDigit(9)

            R.id.btnAdd -> {
                op = 1 // Addition
                state = 2
            }
            R.id.btnMinus -> {
                op = 2 // Subtraction
                state = 2
            }
            R.id.btnMultiple -> {
                op = 3 // Multiplication
                state = 2
            }
            R.id.btnDivide -> {
                op = 4 // Division
                state = 2
            }
            R.id.btnEqual -> {
                var result = 0
                when (op) {
                    1 -> result = op1 + op2
                    2 -> result = op1 - op2
                    3 -> result = op1 * op2
                    4 -> result = if (op2 != 0) op1 / op2 else 0 // Prevent division by 0
                }
                textResult.text = "$result"
                resetState() // Reset the state after calculation
            }
            R.id.btnClear -> {
                resetState()
                textResult.text = "0"
            }
        }
    }

    fun addDigit(c: Int) {
        if (state == 1) {
            op1 = op1 * 10 + c
            textResult.text = "$op1"
        } else {
            op2 = op2 * 10 + c
            textResult.text = "$op2"
        }
    }

    fun resetState() {
        state = 1
        op1 = 0
        op2 = 0
        op = 0
    }
}