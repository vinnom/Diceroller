package br.com.vntvisi.diceroller

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.vntvisi.diceroller.databinding.ActivityMainBinding
import kotlin.random.Random

private const val D4 = 4
private const val D6 = 6
private const val D8 = 8
private const val D10 = 10
private const val D12 = 12
private const val D20 = 20
private const val D100 = 100


class MainActivity : AppCompatActivity() {

    private val mainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mainBinding.root)
    }

    override fun onResume() {
        super.onResume()

        mainBinding.botao1d4.setOnClickListener {
            Dado(D4).rola()
        }
        mainBinding.botao1d6.setOnClickListener {
            Dado(D6).rola()
        }
        mainBinding.botao1d8.setOnClickListener {
            Dado(D8).rola()
        }
        mainBinding.botao1d10.setOnClickListener {
            Dado(D10).rola()
        }
        mainBinding.botao1d12.setOnClickListener {
            Dado(D12).rola()
        }
        mainBinding.botao1d20.setOnClickListener {
            Dado(D20).rola()
        }
        mainBinding.botao1d100.setOnClickListener {
            Dado(D100).rola()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_about, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.home_about -> {
                startActivity(Intent(this, About::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    inner class Dado(private val quantidadeDeFaces: Int) {

        fun rola() {
            val multiplicadorText = mainBinding.activityMainEdittextMultiplicador.text.toString()
            val somaText = mainBinding.activityMainEdittextSoma.text.toString()
            val lista = mutableListOf<Int>()
            var multiplicador = 1
            var soma = 0

            if (multiplicadorText.isNotEmpty()) {
                val multiplicadorInt = multiplicadorText.toInt()
                if (multiplicadorInt > 0) {
                    multiplicador = multiplicadorInt
                    repeat(multiplicador) {
                        lista.add(Random.nextInt(1, quantidadeDeFaces + 1))
                    }
                } else {
                    Toast.makeText(
                        this@MainActivity,
                        "Multiplicador tem que ser maior que zero",
                        Toast.LENGTH_SHORT
                    ).show()
                    mainBinding.activityMainResultado.text = 0.toString()
                    mainBinding.activityMainTextviewDescricaoRolagem.text = ""
                    mainBinding.activityMainTextviewDetalheRolagem.text = ""
                    return
                }
            } else {
                lista.add(Random.nextInt(1, quantidadeDeFaces + 1))
            }
            if (somaText.isNotEmpty()) {
                soma = Integer.parseInt(somaText)
            }
            var resultado = 0
            val detalheBuilder = StringBuilder("(")
            for (i in lista) {
                resultado += i
                detalheBuilder.append(i.toString())
                detalheBuilder.append(",")
            }
            detalheBuilder.deleteCharAt(detalheBuilder.lastIndex)
            detalheBuilder.append(")")
            if (soma > 0) {
                detalheBuilder.append("+${soma}")
            } else if (soma < 0) {
                detalheBuilder.append("$soma")
            }

            val detalhe = detalheBuilder.toString()

            mainBinding.activityMainTextviewDescricaoRolagem.text =
                this@MainActivity.getString(
                    R.string.texto_rolagem,
                    multiplicador,
                    quantidadeDeFaces,
                    soma
                )
            mainBinding.activityMainResultado.text = (resultado + soma).toString()
            mainBinding.activityMainTextviewDetalheRolagem.text = detalhe
        }

    }
}