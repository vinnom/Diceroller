package br.com.vntvisi.diceroller.desafio.dia20210730

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import br.com.vntvisi.diceroller.R

class DesafioIntentActivity : AppCompatActivity() {
    // TODO: implementar desafio
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_desafio_intent)
        title = "Desafio Intent"

        findViewById<Button>(R.id.desafio_intent_botao_envia).setOnClickListener {
            val etEnviaTexto = findViewById<EditText>(R.id.desafio_intent_edittext)
            val textoASerEnviado = etEnviaTexto.text.toString()
            Log.d("DesafioIntentActivity", "onCreate: $textoASerEnviado")
            if (textoASerEnviado.isNotBlank()) {
                val intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, textoASerEnviado)
                    type = "text/plain"
                }
//                Intent.createChooser(intent, null)
                startActivity(intent)
            }
        }
    }
}