package ru.tsibin.countryinfo.data

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

const val NAME = "name"
const val SYMBOL = "symbol"

object GsonCurrencyConverter : JsonDeserializer<Currency> {


    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext?
    ): Currency {
            val name = json.asJsonObject.get(NAME).asString
            val symbol = json.asJsonObject.get(SYMBOL).asString
        return Currency(name, symbol)
    }

}