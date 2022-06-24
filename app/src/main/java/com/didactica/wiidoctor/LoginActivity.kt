package com.didactica.wiidoctor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //setup
        setup()
    }

    private fun setup(){
        title = "Autenticacion"

        loginBtn.setOnClickListener {

        if (emailLogin.text.isNotEmpty() && passwordLogin.text.isNotEmpty()){

            var usuario = "temporal"
            var correo = emailLogin.text
            println("a logeado")
            showHome(email = correo, provider = usuario)


        } else  {
            showAlert()
        }

    }
}
    private fun showAlert(){
        val builder = AlertDialog.Builder(  this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error al ingresar")
        builder.setPositiveButton("aceptar",null)
        val dialog:AlertDialog = builder.create()
        dialog.show()




    }

    private fun showHome(email: Editable, provider: String) {
        val homeIntent = Intent(this, HomeActivity::class.java).apply {

            putExtra("email", email)
            putExtra("provider",provider)
        }
        startActivity(homeIntent)

    }
}