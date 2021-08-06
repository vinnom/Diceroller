package br.com.vntvisi.diceroller.desafio.dia20210804

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import br.com.vntvisi.diceroller.R

/**
 * A simple [Fragment] subclass.
 * Use the [SecondFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondFragment : Fragment(R.layout.fragment_second) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let { bundle ->
            view
                .findViewById<TextView>(R.id.desafio_fragment_textview)
                .text = bundle.getString("texto")
        }
    }

}