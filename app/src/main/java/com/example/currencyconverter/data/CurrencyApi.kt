package com.example.currencyconverter.data

import com.example.currencyconverter.data.models.CurrencyResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyApi {

    @GET("/v1/latest")
    suspend fun getRates(
        @Query("base")
        base: String,
        @Query("access_key")
        apiKey: String
    ) : Response<CurrencyResponse>

}