package br.com.hawkbank

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.FileReader
import java.io.FileWriter
import java.io.IOException

class PersistenceManager {
    private val FILE_PATH = "data.json"
    private val gson = Gson()

    fun saveData(data: List<Conta>) {
        try {
            FileWriter(FILE_PATH).use { writer -> gson.toJson(data, writer) }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    fun loadData(): List<Conta>? {
        return try {
            FileReader(FILE_PATH).use { reader -> gson.fromJson(reader, object : TypeToken<List<Conta>>() {}.type) }
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }
}