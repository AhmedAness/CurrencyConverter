package com.AhmedAnis.currencyconverter.main

import com.AhmedAnis.currencyconverter.data.CurrencyApi
import com.AhmedAnis.currencyconverter.data.models.CurrencyResponse
import com.AhmedAnis.currencyconverter.util.Resource
import javax.inject.Inject

class DefaultMainRepository @Inject constructor(
    private val api: CurrencyApi
) : MainRepository {

    override suspend fun getRates(header: String,symbols: String,base: String): Resource<CurrencyResponse> {
        return try {
            val response = api.getRates(header,symbols,base)
            val result = response.body()
            if(response.isSuccessful && result != null) {
                Resource.Success(result)
            } else {
                Resource.Error(response.message())
            }
        } catch(e: Exception) {
            Resource.Error(e.message ?: "An error occured")
        }
    }
}