package com.example.currencyconverter.main

import com.example.currencyconverter.data.CurrencyApi
import com.example.currencyconverter.data.models.CurrencyResponse
import com.example.currencyconverter.util.Resource
import retrofit2.Response
import javax.inject.Inject

class DefaultMainRepository @Inject constructor(
    private val api: CurrencyApi
) : MainRepository{

    private val apiKey = "YOUR API KEY"

    override suspend fun getRates(
        base: String
    ): Resource<CurrencyResponse> {
        return try {
            val response = api.getRates(
                base,
                apiKey
            )
            val result = response.body()
            if(response.isSuccessful && result!=null){
                Resource.Success(result)
            }
            else{
                Resource.Error(response.message())
            }
        } catch (e: Exception){
            Resource.Error(e.message?:"An error occured")
        }
    }

}