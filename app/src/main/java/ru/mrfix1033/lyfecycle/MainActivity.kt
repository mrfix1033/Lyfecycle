package ru.mrfix1033.lyfecycle

import android.content.Intent
import android.os.Bundle
import android.provider.Telephony.Mms.Intents
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import kotlin.math.pow
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    lateinit var editTextHeight: EditText
    lateinit var editTextWeight: EditText
    lateinit var buttonCalculate: Button
    lateinit var textViewError: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextHeight = findViewById(R.id.editTextHeight)
        editTextWeight = findViewById(R.id.editTextWeight)
        buttonCalculate = findViewById(R.id.buttonCalculate)
        textViewError = findViewById(R.id.textViewError)

        buttonCalculate.setOnClickListener {
            val weight = editTextWeight.text.toString().toFloatOrNull()
            val height = editTextHeight.text.toString().toFloatOrNull()
            if (weight == null || height == null) {
                textViewError.isVisible = true
                return@setOnClickListener
            }
            textViewError.isVisible = false
            val bmi = (weight / (height / 100).pow(2) * 10).roundToInt() / 10F

            val intent = Intent(this, BMIActivity::class.java)
            intent.putExtra("bmi", bmi)
            startActivity(intent)
        }
    }
}