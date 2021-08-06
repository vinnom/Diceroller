package br.com.vntvisi.diceroller.desafio.dia20210806

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.com.vntvisi.diceroller.R


private const val KEY_TEXTO_PERSISTIDO = "TextoPersistido"
class DesafioRotacaoTelaActivity : AppCompatActivity() {

    private var contador: Int = 0
    private val tvContador by lazy { findViewById<TextView>(R.id.desafio_rotacao_de_tela_textview) }
    private val btContador by lazy {
        findViewById<Button>(R.id.desafio_rotacao_de_tela_botao_incrementa)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_desafio_rotacao_tela)

        savedInstanceState?.let {
            contador = it.getString(KEY_TEXTO_PERSISTIDO)?.toInt() ?: 0
            tvContador.text = contador.toString()
        }

        val texto = savedInstanceState?.getString(KEY_TEXTO_PERSISTIDO) ?: contador.toString()

        btContador.setOnClickListener {
            incrementa()
            tvContador.text = contador.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        val textoASerPersistido = tvContador.text.toString()
        outState.putString(KEY_TEXTO_PERSISTIDO, textoASerPersistido)
    }

    fun incrementa() {
        contador++
    }
}