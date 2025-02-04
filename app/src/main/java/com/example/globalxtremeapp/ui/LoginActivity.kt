package com.example.globalxtremeapp.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.globalxtremeapp.SessionManager
import com.example.globalxtremeapp.databinding.ActivityLoginBinding
import org.koin.android.ext.android.inject

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val sessionManager: SessionManager by inject()

    private val userEmail = "qa@gmail.com"
    private val userPassword = "qa123456789"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val email = binding.tilEmail.editText?.text.toString().trim()
            val password = binding.tilPassword.editText?.text.toString().trim()

            if (email.isEmpty()) {
                Toast.makeText(this, "Email tak boleh kosong", Toast.LENGTH_SHORT).show()
            } else if (password.isEmpty()) {
                Toast.makeText(this, "Password tak boleh kosong", Toast.LENGTH_SHORT).show()
            }

            if (email != userEmail && password != userPassword) {
                Toast.makeText(this, "Email atau Password salah", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, DashboardActivity::class.java)
                startActivity(intent)
                finish()
            }


        }

    }

//    private fun isLoggedIn() {
//        Handler(Looper.myLooper()!!).postDelayed({
//            if (!sessionManager.isTokenExp()) {
//                startActivity(Intent(this, DashboardActivity::class.java))
//                finishAffinity()
//            } else {
//                startActivity(Intent(this, AuthActivity::class.java))
//                finishAffinity()
//            }
//        }, 2000)
//    }

}