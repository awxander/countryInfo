package ru.tsibin.countryinfo.data

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

const val NAME = "name"
const val SYMBOL = "symbol"

object GsonCurrenciesConverter : JsonDeserializer<CurrenciesResponse> {


    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext?
    ): CurrenciesResponse {
        val keySet = json.asJsonObject.keySet()
        val currencies = mutableListOf<Currency>()

        for (key in keySet) {
            val innerJson = json.asJsonObject.get(key).asJsonObject
            val name = innerJson.get(NAME).asString
            val symbol = innerJson.get(SYMBOL).asString
            currencies.add(Currency(name, symbol))
        }

        return CurrenciesResponse(currencies)
    }

}