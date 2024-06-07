package com.example.mar

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.mar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar) // Define a toolbar como a action bar


        val textIntroElement = findViewById<TextView>(R.id.text_intro)

        // Texto normal
        val textoNormalIntro = "Na MAR, você pode facilmente marcar áreas marítimas para pesca autorizada, identificar zonas de risco e locais com grande acúmulo de lixo."

        // Texto em negrito
        val textoNegritoIntro = "Tudo isso de forma rápida, sem complicações e totalmente gratuita, direto pelo app"

        // Concatenando o texto normal com o texto em negrito
        val textoCompletoIntro = textoNormalIntro + textoNegritoIntro

        // Criando uma SpannableString
        val spannableStringIntro = SpannableString(textoCompletoIntro)

        // Definindo o estilo negrito apenas para a última linha
        spannableStringIntro.setSpan(
            StyleSpan(Typeface.BOLD),
            textoNormalIntro.length + 1,
            textoCompletoIntro.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        spannableStringIntro.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, R.color.orange)),
            textoNormalIntro.length,
            textoCompletoIntro.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        spannableStringIntro.setSpan(
                ForegroundColorSpan(Color.WHITE),
        0,
        textoNormalIntro.length,
        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        val textFinalElement = findViewById<TextView>(R.id.text_final)

        // Texto normal
        val textoNormalFinal = "Na MAR, você pode facilmente marcar áreas marítimas para pesca autorizada,"
        // Texto em negrito
        val textoNegritoFinal =   " identificar zonas de risco e locais com grande acúmulo de lixo."

        // Concatenando o texto normal com o texto em negrito
        val textoCompletoFinal = textoNormalFinal + textoNegritoFinal

        // Criando uma SpannableString
        val spannableStringFinal = SpannableString(textoCompletoFinal)

        // Definindo o estilo negrito apenas para a última linha
        spannableStringFinal.setSpan(
            StyleSpan(Typeface.BOLD),
            textoNormalFinal.length + 1,
            textoCompletoFinal.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        spannableStringFinal.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, R.color.orange)),
            textoNormalFinal.length,
            textoCompletoFinal.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        spannableStringFinal.setSpan(
            ForegroundColorSpan(Color.WHITE),
            0,
            textoNormalFinal.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        val textFinalComplementElement = findViewById<TextView>(R.id.text_complement_final)

        // Texto normal
        val textoNormalComplementFinal = "Origem terrestre do lixo marinho é uma realidade triste."
        // Texto em negrito
        val textoNegritoComplementFinal =   "Adotemos práticas sustentáveis para proteger os oceanos e seus recursos."

        // Concatenando o texto normal com o texto em negrito
        val textoCompletoComplementFinal = textoNormalComplementFinal + textoNegritoComplementFinal

        // Criando uma SpannableString
        val spannableStringComplementFinal = SpannableString(textoCompletoComplementFinal)

        // Definindo o estilo negrito apenas para a última linha
        spannableStringComplementFinal.setSpan(
            StyleSpan(Typeface.BOLD),
            textoNormalComplementFinal.length + 1,
            textoCompletoComplementFinal.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        spannableStringComplementFinal.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, R.color.orange)),
            textoNormalComplementFinal.length,
            textoCompletoComplementFinal.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        spannableStringComplementFinal.setSpan(
            ForegroundColorSpan(Color.WHITE),
            0,
            textoNormalComplementFinal.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )




        // Definindo o texto estilizado para o TextView
        textIntroElement.text = spannableStringIntro
        textFinalElement.text = spannableStringFinal
        textFinalComplementElement.text= spannableStringComplementFinal
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.request -> {
                // Redireciona para a tela de solicitação
                Toast.makeText(this, "Feature em desenvolvimento", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.login -> {
                // Redireciona para a tela de login
                val loginIntent = Intent(this, LoginActivity::class.java)
                startActivity(loginIntent)
                true
            }
            R.id.register -> {
                // Redireciona para a tela de registro
                val registerIntent = Intent(this, RegisterActivity::class.java)
                startActivity(registerIntent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
