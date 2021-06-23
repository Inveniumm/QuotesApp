package com.example.mvvmtodo.ui.quotes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmtodo.data.Quote
import com.example.mvvmtodo.data.QuoteRepository



class QuotesViewModel(private val quoteRepository: QuoteRepository)
    : ViewModel() {

    private val _quotes = MutableLiveData<List<Quote>>()
    val quotes : LiveData<List<Quote>> = _quotes

    fun getQuotesList() {
        var result = quoteRepository.getQuotes()
        _quotes.value = result
    }

    fun addQuote(quote: Quote) {
        quoteRepository.addQuote(quote)
        getQuotesList()
    }
}