package com.AhmedAnis.currencyconverter.data

import com.AhmedAnis.currencyconverter.data.models.CurrencyResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface CurrencyApi {

    @GET("/latest")
    suspend fun getRates(@Header("apikey")header: String,@Query("symbols") symbols: String,@Query("base") base: String): Response<CurrencyResponse>
}