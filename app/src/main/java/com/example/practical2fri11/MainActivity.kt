package com.example.practical2fri11

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.practical2fri11.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var myName2: MyName = MyName("BAIT")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //setContentView(R.layout.activity_main)
        binding.myName1 = myName2
        binding.doneButton.setOnClickListener{//findViewById<Button>(R.id.done_button).setOnClickListener (ALTERNATIVE WAY)
            addNickname(it)
        }
        binding.doneButton.setOnClickListener{
            updateNickName(it)
        }
    }

    private fun addNickname(view: View){
    //    val editText:TextView = findViewById(R.id.nickname_edit)
    //    val nicknameTextView = findViewById<TextView>(R.id.nickname_text)
      //  binding.nicknameText.text = binding.nicknameEdit.text.toString()
      //  binding.nicknameEdit.visibility = View.GONE
     //   binding.doneButton.visibility = View.GONE
      //  binding.nicknameText.visibility = View.VISIBLE

        binding.apply {
            nicknameText.text = binding.nicknameEdit.text.toString()
            invalidateAll()
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }

      /*  nicknameTextView.text = editText.text
        editText.visibility = View.GONE
        view.visibility = View.GONE
        nicknameTextView.visibility = View.VISIBLE*/

        //Hide the keyboard.
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE)
            as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken,0)
    }

    private fun updateNickName(view: View){
        //val editText = findViewById<EditText>(R.id.nickname_edit)
       // val doneButton = findViewById<Button>(R.id.done_button)

        binding.apply {
            nicknameEdit.visibility = View.VISIBLE
            doneButton.visibility = View.VISIBLE
            nicknameText.visibility = View.GONE
        }
        /*editText.visibility = View.VISIBLE
        doneButton.visibility = View.VISIBLE
        view.visibility = View.GONE*/
    }
}