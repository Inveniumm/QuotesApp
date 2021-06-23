package com.example.mvvmtodo.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FakeQuoteDao {
    private var quotes = arrayListOf<Quote>()

    fun addQuote(quote: Quote) {
        quotes.add(quote)
    }

    fun getQuotes() = quotes as List<Quote>
}