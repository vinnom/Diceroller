package br.com.vntvisi.diceroller

import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.com.vntvisi.diceroller.desafio.dia20210730.DesafioIntentActivity
import br.com.vntvisi.diceroller.desafio.dia20210804.DesafioFragmentActivity
import br.com.vntvisi.diceroller.desafio.dia20210806.DesafioRotacaoTelaActivity
import br.com.vntvisi.diceroller.desafio.dia20210811.DesafioRecyclerViewActivity
import br.com.vntvisi.diceroller.desafio.dia20210820.DesafioSharedPreferencesActivity

class About : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)


        val tvDesafioIntent = findViewById<TextView>(R.id.desafio_intent)
        tvDesafioIntent.paintFlags = tvDesafioIntent.paintFlags or Paint.UNDERLINE_TEXT_FLAG

        tvDesafioIntent.setOnClickListener {
            startActivity(Intent(this, DesafioIntentActivity::class.java))
        }

        val tvDesafioFragment = findViewById<TextView>(R.id.desafio_fragment)
        tvDesafioFragment.paintFlags = tvDesafioFragment.paintFlags or Paint.UNDERLINE_TEXT_FLAG

        tvDesafioFragment.setOnClickListener {
            startActivity(Intent(this, DesafioFragmentActivity::class.java))
        }

        val tvDesafioRotacao = findViewById<TextView>(R.id.desafio_rotacao_de_tela)
        tvDesafioRotacao.paintFlags = tvDesafioRotacao.paintFlags or Paint.UNDERLINE_TEXT_FLAG

        tvDesafioRotacao.setOnClickListener {
            startActivity(Intent(this, DesafioRotacaoTelaActivity::class.java))
        }

        val tvDesafioRecyclerView = findViewById<TextView>(R.id.desafio_recycler_view_list)
        tvDesafioRecyclerView.paintFlags =
            tvDesafioRecyclerView.paintFlags or Paint.UNDERLINE_TEXT_FLAG

        tvDesafioRecyclerView.setOnClickListener {
            startActivity(Intent(this, DesafioRecyclerViewActivity::class.java))
        }

        val tvDesafioSharedPreferences = findViewById<TextView>(R.id.desafio_shared_preferences)
        tvDesafioSharedPreferences.paintFlags =
            tvDesafioSharedPreferences.paintFlags or Paint.UNDERLINE_TEXT_FLAG

        tvDesafioSharedPreferences.setOnClickListener {
            startActivity(Intent(this, DesafioSharedPreferencesActivity::class.java))
        }

    }
}