package com.sakebook.android.sample.kuromojisample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import android.widget.TextView

import com.atilika.kuromoji.TokenizerBase

import com.atilika.kuromoji.ipadic.Tokenizer

class MainActivity : AppCompatActivity() {

//    val tokenizer = Tokenizer()
//    val tokenizer = Tokenizer.builder().build()
val tokenizer = Tokenizer.Builder().mode(TokenizerBase.Mode.NORMAL).build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById(R.id.edit_text) as EditText
        val text = findViewById(R.id.text) as TextView
        editText.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun afterTextChanged(s: Editable) {
                text.text = ""
                val tokens = tokenizer.tokenize(s.toString());
                tokens.forEach {
                    Log.d("Kuromoji", "${it.allFeatures}")
                    text.append("${it.allFeatures}\n")
                }
            }
        })
        editText.text.append("我輩は猫である。名前はまだない。")
    }
}
