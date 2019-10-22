package br.com.miguelriquelme.navegadorandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var link : String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView.settings.javaScriptEnabled = true

        pesquisar()
        atualizar()
        voltar()
        avancar()
    }
    fun pesquisar(){
        botaoPesquisar.setOnClickListener {
            link = barraPesquisa.text.toString()
            webView.loadUrl("https://"+link)
            barraPesquisa.setText(link)

        }
    }
    fun atualizar(){
        botaoRecarregar.setOnClickListener{
            webView.reload()
        }
    }
    fun voltar(){
        botaoVoltar.setOnClickListener{
            webView.goBack()
            barraPesquisa.setText(link)
        }
    }
    fun avancar(){
        botaoAvancar.setOnClickListener{
            if(webView.canGoForward()) {
                webView.goForward()
                barraPesquisa.setText(link)
            }
        }
    }
}
