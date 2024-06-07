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
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.example.mar.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar: Toolbar = binding.toolbarLayout.toolbar
        setSupportActionBar(toolbar)// Define a toolbar como a action bar

        // Estilizar os textos
        val textIntroElement = findViewById<TextView>(R.id.text_intro)
        val textFinalElement = findViewById<TextView>(R.id.text_final)
        val textFinalComplementElement = findViewById<TextView>(R.id.text_complement_final)

        val textoIntro = Pair(
            "Na MAR, você pode facilmente marcar áreas marítimas para pesca autorizada, identificar zonas de risco e locais com grande acúmulo de lixo.",
            "Tudo isso de forma rápida, sem complicações e totalmente gratuita, direto pelo app"
        )
        val textoFinal = Pair(
            "Na MAR, você pode facilmente marcar áreas marítimas para pesca autorizada,",
            " identificar zonas de risco e locais com grande acúmulo de lixo."
        )
        val textoFinalComplement = Pair(
            "Origem terrestre do lixo marinho é uma realidade triste.",
            "Adotemos práticas sustentáveis para proteger os oceanos e seus recursos."
        )

        // Aplicar estilo
        textIntroElement.text = getStyledText(textoIntro.first, textoIntro.second)
        textFinalElement.text = getStyledText(textoFinal.first, textoFinal.second)
        textFinalComplementElement.text = getStyledText(textoFinalComplement.first, textoFinalComplement.second)
    }

    private fun getStyledText(normalText: String, boldText: String): SpannableString {
        val fullText = normalText + boldText
        val spannableString = SpannableString(fullText)

        // Aplicar estilo
        spannableString.setSpan(
            ForegroundColorSpan(Color.WHITE),
            0,
            normalText.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        spannableString.setSpan(
            StyleSpan(Typeface.BOLD),
            normalText.length,
            fullText.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        spannableString.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, R.color.orange)),
            normalText.length,
            fullText.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        return spannableString
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
