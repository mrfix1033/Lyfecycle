package ru.mrfix1033.lyfecycle

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BMIActivity : AppCompatActivity() {

    lateinit var textViewBMI: TextView
    lateinit var imageViewHuman: ImageView
    lateinit var textViewRecommendation: TextView
    lateinit var buttonBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi)

        textViewBMI = findViewById(R.id.textViewBMI)
        imageViewHuman = findViewById(R.id.imageViewHuman)
        textViewRecommendation = findViewById(R.id.textViewRecommendation)
        buttonBack = findViewById(R.id.buttonBack)

        buttonBack.setOnClickListener {
            finish()
        }

        val bmi = intent.getFloatExtra("bmi", -1F)
        textViewBMI.text = getString(R.string.bmi).format(bmi.toString())
        val (imageViewId: Int, recommendationId: Int) = when {
            bmi <= 16 -> {
                arrayOf(R.drawable.drysh, R.string.very_low_bmi)
            }

            bmi < 18.5 -> {
                arrayOf(R.drawable.normal_human, R.string.low_bmi)
            }

            bmi < 25 -> {
                arrayOf(R.drawable.normal_human, R.string.normal_bmi)
            }

            bmi < 35 -> {
                arrayOf(R.drawable.normal_human, R.string.high_bmi)
            }

            else -> {
                arrayOf(
                    R.drawable.stas_bareckiy,
                    R.string.very_high_bmi
                )
            }
        }

//        if (imageViewId == R.drawable.normal_human)
//            imageViewHuman.layoutParams.width = (196 * bmi / 21).toInt()
        imageViewHuman.setImageResource(imageViewId)
        textViewRecommendation.setText(recommendationId)
    }
}