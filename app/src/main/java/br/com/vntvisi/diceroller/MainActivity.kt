package br.com.vntvisi.diceroller

import android.content.Intent
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

private const val D4 = 4
private const val D6 = 6
private const val D8 = 8
private const val D10 = 10
private const val D12 = 12
private const val D20 = 20
private const val D100 = 100


class MainActivity : AppCompatActivity() {

    private val rolagemDescricao by lazy {
        findViewById<TextView>(R.id.activity_main_textview_descricao_rolagem)
    }
    private val botao1d4 by lazy { findViewById<Button>(R.id.botao_1d4) }
    private val botao1d6 by lazy { findViewById<Button>(R.id.botao_1d6) }
    private val botao1d8 by lazy { findViewById<Button>(R.id.botao_1d8) }
    private val botao1d10 by lazy { findViewById<Button>(R.id.botao_1d10) }
    private val botao1d12 by lazy { findViewById<Button>(R.id.botao_1d12) }
    private val botao1d20 by lazy { findViewById<Button>(R.id.botao_1d20) }
    private val botao1d100 by lazy { findViewById<Button>(R.id.botao_1d100) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val resultadoTextView = findViewById<TextView>(R.id.activity_main_resultado)
        val multiplicadorEditText =
            findViewById<EditText>(R.id.activity_main_edittext_multiplicador)
        val somaEditText = findViewById<EditText>(R.id.activity_main_edittext_soma)

        botao1d4.setOnClickListener {
            rolaODado(multiplicadorEditText, somaEditText, resultadoTextView, D4)
        }
        botao1d6.setOnClickListener {
            rolaODado(multiplicadorEditText, somaEditText, resultadoTextView, D6)
        }
        botao1d8.setOnClickListener {
            rolaODado(multiplicadorEditText, somaEditText, resultadoTextView, D8)
        }
        botao1d10.setOnClickListener {
            rolaODado(multiplicadorEditText, somaEditText, resultadoTextView, D10)
        }
        botao1d12.setOnClickListener {
            rolaODado(multiplicadorEditText, somaEditText, resultadoTextView, D12)
        }
        botao1d20.setOnClickListener {
            rolaODado(multiplicadorEditText, somaEditText, resultadoTextView, D20)
        }
        botao1d100.setOnClickListener {
            rolaODado(multiplicadorEditText, somaEditText, resultadoTextView, D100)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_about, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.home_about -> {
                startActivity(Intent(this, About::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun rolaODado(
        multiplicadorEditText: EditText,
        somaEditText: EditText,
        resultadoTextView: TextView,
        quantidadeDeFaces: Int
    ) {
        val dado = Random.nextInt(1, quantidadeDeFaces + 1)
        val multiplicadorText = multiplicadorEditText.text.toString()
        val somaText = somaEditText.text.toString()
        var multiplicador = 1
        var soma = 0

        if (multiplicadorText.isNotEmpty()) {
            val multiplicadorInt = multiplicadorText.toInt()
            if (multiplicadorInt > 0) {
                multiplicador = multiplicadorInt
            } else {
                Toast.makeText(
                    this,
                    "Multiplicador tem que ser maior que zero",
                    Toast.LENGTH_SHORT
                ).show()
                resultadoTextView.text = (0).toString()
                rolagemDescricao.text = ""
                return
            }
        }
        if (somaText.isNotEmpty()) {
            soma = Integer.parseInt(somaText)
        }
        rolagemDescricao.text =
            getString(R.string.texto_rolagem, multiplicador, quantidadeDeFaces, soma)
        resultadoTextView.text = ((dado * multiplicador) + soma).toString()
    }
}