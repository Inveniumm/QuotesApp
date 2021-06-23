package com.example.mvvmtodo.utilities

import com.example.mvvmtodo.data.FakeDatabase
import com.example.mvvmtodo.data.QuoteRepository
import com.example.mvvmtodo.ui.quotes.QuotesViewModelFactory




object InjectorUtils {

    fun provideQuotesViewModelFactory(): QuotesViewModelFactory {
        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }
}