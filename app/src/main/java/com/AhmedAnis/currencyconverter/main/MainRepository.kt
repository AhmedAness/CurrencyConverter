package com.AhmedAnis.currencyconverter.main

import com.AhmedAnis.currencyconverter.data.models.CurrencyResponse
import com.AhmedAnis.currencyconverter.util.Resource

interface MainRepository {

    suspend fun getRates(header:String,symbols: String,base: String): Resource<CurrencyResponse>
}