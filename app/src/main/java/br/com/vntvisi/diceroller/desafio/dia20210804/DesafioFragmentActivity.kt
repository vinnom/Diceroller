package br.com.vntvisi.diceroller.desafio.dia20210804

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.vntvisi.diceroller.R

class DesafioFragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_desafio_fragment)
        title = "Desafio Fragment"
    }
}