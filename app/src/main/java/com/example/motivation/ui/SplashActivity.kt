package com.example.motivation.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.motivation.R
import com.example.motivation.infra.MotivationConstants
import com.example.motivation.infra.SecuriryPreferences
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var mSecuriryPreferences: SecuriryPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar!!.hide()

        mSecuriryPreferences = SecuriryPreferences(this)

        buttonSave.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        val id = v.id
        if (id == R.id.buttonSave) {
            handleSave()
        }
    }

    private fun handleSave() {
        val name = editName.text.toString()

        if (name != "") {
            mSecuriryPreferences.storeString(MotivationConstants.KEY.PERSON_NAME, name)
            startActivity(Intent(this, MainActivity::class.java))
        } else {
            Toast.makeText(this, "Informe seu nome", Toast.LENGTH_SHORT).show()
        }
    }
}