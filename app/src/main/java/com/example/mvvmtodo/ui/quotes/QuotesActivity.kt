package com.example.mvvmtodo.ui.quotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmtodo.R
import com.example.mvvmtodo.data.Quote
import com.example.mvvmtodo.utilities.InjectorUtils
import kotlinx.android.synthetic.main.activity_quotes.*

class QuotesActivity : AppCompatActivity() {

    private lateinit var viewModel : QuotesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)
        val factory = InjectorUtils.provideQuotesViewModelFactory()
        viewModel = ViewModelProviders.of(this, factory)
            .get(QuotesViewModel::class.java)

        setListeners()
        setObservers()

        viewModel.getQuotesList()
    }

    private fun setListeners() {
        button_add_quote.setOnClickListener{
            val quote = Quote(editText_quote.text.toString(), editText_author.text.toString())
            viewModel.addQuote(quote)
            editText_quote.text.clear()
            editText_author.text.clear()
        }
    }

    private fun setObservers(){
        viewModel.quotes.observe(this, { quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach{ quote ->
                stringBuilder.append("$quote\n\n")
            }
            textView_quotes.text = stringBuilder.toString()
        })
    }

}