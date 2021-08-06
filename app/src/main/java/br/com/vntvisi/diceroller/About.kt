package br.com.vntvisi.diceroller

import android.content.Intent
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import br.com.vntvisi.diceroller.desafio.dia20210730.DesafioIntentActivity

class About : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)



        val tvDesafioIntent = findViewById<TextView>(R.id.desafio_intent)
        tvDesafioIntent.paintFlags = tvDesafioIntent.paintFlags or Paint.UNDERLINE_TEXT_FLAG

        tvDesafioIntent.setOnClickListener {
            startActivity(Intent(this, DesafioIntentActivity::class.java))
        }

    }
}