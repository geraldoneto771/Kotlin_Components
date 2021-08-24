package com.example.myapplication

import android.graphics.Color
import android.icu.lang.UCharacter.IndicPositionalCategory.TOP
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.*
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener, SeekBar.OnSeekBarChangeListener,
    CompoundButton.OnCheckedChangeListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_toast.setOnClickListener(this)
        button_snack.setOnClickListener(this)

        button_get_seekbar.setOnClickListener(this)
        button_set_seekbar.setOnClickListener(this)

        seekbar.setOnSeekBarChangeListener(this)

        //switch
        switch_on_off.setOnCheckedChangeListener(this)

        // chekbox
        check_on_off.setOnCheckedChangeListener(this)

        // RadioButtom
        radio_on.setOnCheckedChangeListener(this)
        radio_off.setOnCheckedChangeListener(this)

        // progress



    }

    override fun onClick(v: View) {
        when (v.id) {
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

    private fun toast(str: String) {
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

    //switch
    override fun onCheckedChanged(buttonView: CompoundButton, isChecked: Boolean) {
        when (buttonView.id) {
            R.id.switch_on_off -> {
                // switch_on_off.isChecked = true
                toast("Switch ${if (isChecked) "true" else "false"}")

                progress.visibility = View.GONE
            }

            //ckeckbox
            R.id.check_on_off -> {
                toast("Checkbox ${if (isChecked) "true" else "false"}")
                check_on_off.isChecked = true
            }

            // RadioButtom
            R.id.radio_on -> {
                toast("Radio on: ${if (isChecked) "true" else "false"}")
            }

            // RadioButtom
            R.id.radio_off -> {
                toast("Radio off: ${if (isChecked) "true" else "false"}")
            }

        }
    }
}