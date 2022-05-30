package id.dipoengoro.barvolume

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var editLength: EditText
    private lateinit var editWidth: EditText
    private lateinit var editHeight: EditText
    private lateinit var textResult: TextView
    private lateinit var buttonCalculate: Button

    companion object {
        private const val STATE_RESULT = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editLength = findViewById(R.id.edit_length)
        editWidth = findViewById(R.id.edit_width)
        editHeight = findViewById(R.id.edit_height)
        textResult = findViewById(R.id.text_result)
        buttonCalculate = findViewById(R.id.button_calculate)

        buttonCalculate.setOnClickListener(this)

        if (savedInstanceState != null) {
            val result = savedInstanceState.getString(STATE_RESULT)
            textResult.text = result
        }
    }

    override fun onClick(view: View?) {
        if (view?.id == R.id.button_calculate) {
            val inputLength = editLength.text.toString().trim()
            val inputWidth = editWidth.text.toString().trim()
            val inputHeight = editHeight.text.toString().trim()

            var isEmptyFields = false

            if (inputLength.isEmpty()) {
                isEmptyFields = true
                editLength.error = "Kolom ini tidak boleh kosong"
            } else if (inputWidth.isEmpty()) {
                isEmptyFields = true
                editWidth.error = "Kolom ini tidak boleh kosong"
            } else if (inputHeight.isEmpty()) {
                isEmptyFields = true
                editHeight.error = "Kolom ini tidak boleh kosong"
            }

            if (!isEmptyFields) {
                val volume = inputLength.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()
                textResult.text = volume.toString()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, textResult.text.toString())
    }
}