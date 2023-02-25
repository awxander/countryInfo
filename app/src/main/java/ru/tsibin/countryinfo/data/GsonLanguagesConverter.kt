package ru.tsibin.countryinfo.data

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

object GsonLanguagesConverter : JsonDeserializer<LanguagesResponse> {


    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext?
    ): LanguagesResponse {
        val keySet = json.asJsonObject.keySet()
        val languages = mutableListOf<String>()

        for (key in keySet) {
            languages.add(json.asJsonObject.get(key).asString)
        }

        return LanguagesResponse(languages)
    }

}