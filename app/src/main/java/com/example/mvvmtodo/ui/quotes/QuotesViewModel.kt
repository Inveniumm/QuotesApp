package com.example.mvvmtodo.ui.quotes

import androidx.lifecycle.ViewModel
import com.example.mvvmtodo.data.Quote
import com.example.mvvmtodo.data.QuoteRepository



class QuotesViewModel(private val quoteRepository: QuoteRepository)
    : ViewModel() {

    fun getQuotes() = quoteRepository.getQuotes()

    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)
}