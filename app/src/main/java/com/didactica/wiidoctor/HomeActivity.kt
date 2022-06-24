package com.didactica.wiidoctor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*

enum class providerType {
    Basic
}

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Setup
        val bundle: Bundle? = intent.extras
        val email :String?   = bundle?.getString("email")
        val provider :String? =  bundle?.getString("provider")
        setup(email ?:"", provider ?:"")
    }
    private fun setup(email: String, provider: String){
        title = "Inicio"
        usuariotext.text= email

        logoutBtn.setOnClickListener {
            onBackPressed()
        }

    }
}