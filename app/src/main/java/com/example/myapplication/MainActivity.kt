package com.example.myapplication

import android.graphics.Color
import android.icu.lang.UCharacter.IndicPositionalCategory.TOP
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_toast.setOnClickListener(this)
        button_snack.setOnClickListener(this)

        button_get_seekbar.setOnClickListener(this)
        button_set_seekbar.setOnClickListener(this)

        seekbar.setOnSeekBarChangeListener(this)
    }

    override fun onClick(v: View) {
        when (v.id){
            // toast
            R.id.button_toast -> {
                val toast = Toast.makeText(this, "TOAST", Toast.LENGTH_LONG)

                /*val textView = toast.view?.findViewById<TextView>(android.R.id.message)
                textView.setTextColor(Color.RED)*/

                val layout = layoutInflater.inflate(R.layout.toast_layout, null)
                toast.view = layout
                toast.setGravity(Gravity.TOP, 0, 250)

                toast.show()
            }

            // snack com ação
            R.id.button_snack -> {
                val snack = Snackbar.make(linear_root, "Snack", Snackbar.LENGTH_SHORT)

                snack.setAction("Desfazer", View.OnClickListener {
                    toast("Desfeito!")
                })

                // Setando aparencia
                snack.setActionTextColor(Color.BLUE)
                snack.setBackgroundTint(Color.GRAY)

                snack.show()
            }

            // Seekbar
            R.id.button_get_seekbar -> {
                toast("Seekbar: ${seekbar.progress}")
            }
            R.id.button_set_seekbar -> {
                seekbar.progress = 15
            }
        }
    }

    private fun toast(str: String){
        Toast.makeText(this, str, Toast.LENGTH_LONG).show()
    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        text_seekbar_value.text = "valor seekbar: $progress"
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {
        toast("Track started")
    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {
        toast("Track stoped")
    }
}