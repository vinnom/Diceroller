package br.com.vntvisi.diceroller.desafio.dia20210820

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.vntvisi.diceroller.databinding.ActivityDesafioSharedPreferencesBinding

class DesafioSharedPreferencesActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityDesafioSharedPreferencesBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        when(primeiroAcesso()) {
            true -> {
                atualizarPrimeiroAcesso()
                binding.desafioSharedPreferencesTextview.text = "Primeiro acesso. Bem-vindo!"
            }
            false -> binding.desafioSharedPreferencesTextview.text = "Acessou novamente. Bem-vindo de volta!"
        }
    }

    private fun primeiroAcesso(): Boolean {
        val sharedPref = getPreferences(Context.MODE_PRIVATE)
        return sharedPref.getBoolean(CHAVE_PRIMEIRO_ACESSO, true)
    }

    private fun atualizarPrimeiroAcesso() {
        val sharedPref = getPreferences(Context.MODE_PRIVATE)
        with(sharedPref.edit()) {
            putBoolean(CHAVE_PRIMEIRO_ACESSO, false)
            apply()
        }
    }

    private companion object {

        private const val CHAVE_PRIMEIRO_ACESSO = "CHAVE_PRIMEIRO_ACESSO"
    }

}