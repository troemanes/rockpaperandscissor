package com.example.firebase3

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    var enemyscore = 0
    var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tas = findViewById<Button>(R.id.tas)
        val kagit = findViewById<Button>(R.id.kagit)
        val makas = findViewById<Button>(R.id.makas)
        val sonucText = findViewById<TextView>(R.id.textView)
        val score1 = findViewById<TextView>(R.id.score)
        val enemyscore1 = findViewById<TextView>(R.id.enemy)

        tas.setOnClickListener {
            if (score == 2 && enemyscore == 0) {
                sonucText.text = "Rakip Kağıt Yaptı. Kaybettiniz"
                sonucText.setTextColor(Color.RED) // Kırmızı
                enemyscore++
                enemyscore1.text = "Rakibin Puanı: $enemyscore"
            } else {
            when ((1..3).random()) {
                1 -> {sonucText.text = "Rakip de Taş Yaptı. Berabere"
                sonucText.setTextColor(Color.parseColor("#e49b0f")) // Turuncu
            }
                2 -> {
                    sonucText.text = "Rakip Makas Yaptı. Kazandınız!"
                    sonucText.setTextColor(Color.BLUE) // Mavi
                    score++
                    score1.text = "Senin Puanın: $score"
                }
                3 -> {
                    sonucText.text = "Rakip Kağıt Yaptı. Kaybettiniz"
                    sonucText.setTextColor(Color.RED)
                    enemyscore++
                    enemyscore1.text = "Rakibin Puanı: $enemyscore"
                }
            }}
            restart()
        }

        kagit.setOnClickListener {
            if (score == 2 && enemyscore == 0) {
                sonucText.text = "Rakip Makas Yaptı. Kaybettiniz"
                sonucText.setTextColor(Color.RED) // Kırmızı
                enemyscore++
                enemyscore1.text = "Rakibin Puanı: $enemyscore"
            } else {
            when ((1..3).random()) {
                1 -> {sonucText.text = "Rakip de Kağıt Yaptı. Beraber"
                sonucText.setTextColor(Color.parseColor("#e49b0f")) // Turuncu
            }
                2 -> {
                    sonucText.text = "Rakip Taş Yaptı. Kazandınız!"
                    sonucText.setTextColor(Color.BLUE) // Mavi
                    score++
                    score1.text = "Senin Puanın: $score"
                }
                3 -> {
                    sonucText.text = "Rakip Makas Yaptı. Kaybettiniz."
                    sonucText.setTextColor(Color.RED)
                    enemyscore++
                    enemyscore1.text = "Rakibin Puanı: $enemyscore"
                }
            }
            restart()
        }}

        makas.setOnClickListener {
            if (score == 2 && enemyscore == 0) {
                sonucText.text = "Rakip Taş Yaptı. Kaybettiniz"
                sonucText.setTextColor(Color.RED) // Kırmızı
                enemyscore++
                enemyscore1.text = "Rakibin Puanı: $enemyscore"
            } else {
                when ((1..3).random()) {
                    1 -> {
                        sonucText.text = "Rakip Kağıt Yaptı. Kazandınız!"
                        sonucText.setTextColor(Color.BLUE) // Mavi
                        score++
                        score1.text = "Senin Puanın: $score"
                    }
                    2 -> {
                        sonucText.text = "Rakip de Makas Yaptı. Berabere"
                        sonucText.setTextColor(Color.parseColor("#e49b0f")) // Turuncu
                    }
                    3 -> {
                        sonucText.text = "Rakip Taş Yaptı. Kaybettiniz"
                        sonucText.setTextColor(Color.RED) // Kırmızı
                        enemyscore++
                        enemyscore1.text = "Rakibin Puanı: $enemyscore"
                    }
                }
            }
            restart()
        }
    }
    fun restart() {
        if (score == 3) {
            showAlert("$score-$enemyscore OYUNU KAZANDINIZ TEBRİKLER!!")
            resetScores()
        }

        if (enemyscore == 3) {
            showAlert("$score-$enemyscore OYUNU KAYBETTİNİZ!!")
            resetScores()
        }
    }


    fun showAlert(message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setMessage(message)
            .setPositiveButton("Tekrar Oyna") { dialog, id ->
                dialog.dismiss()
            }
        val alertDialog = builder.create()
        alertDialog.show()
    }

    fun resetScores() {
        score = 0
        enemyscore = 0
        findViewById<TextView>(R.id.score).text = "Senin Puanın: $score"
        findViewById<TextView>(R.id.enemy).text = "Rakibin Puanı: $enemyscore"
    }
}
