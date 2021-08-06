package br.com.vntvisi.diceroller.desafio.dia20210804

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import br.com.vntvisi.diceroller.R

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment(R.layout.fragment_first) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.desafio_fragment_botao_envia).setOnClickListener {
            val textoASerEnviado = view
                .findViewById<EditText>(R.id.desafio_fragment_edittext).text.toString()

            if (textoASerEnviado.isNotBlank()) {
                val bundle = Bundle().apply { putString("texto", textoASerEnviado) }
                val fragment = SecondFragment().apply {
                    arguments = bundle
                }
                parentFragmentManager.beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.container_fragment, fragment)
                    .commit()
            }
        }
    }
}