package br.com.becaeveris.movieajax.helper

import android.content.Context
import android.os.Build.VERSION_CODES.O

class SharedPreferences(context: Context) {

    private val mSharedPreferences = context.getSharedPreferences("MOVIEAJAX", Context.MODE_PRIVATE)

    companion object{
        const val KEY_COUNT = "br.com.becaeveris.movieajax.MOVIEAJAX"
        const val DEFAULT_VALUE = 0
    }

    fun storeBoolean(key: String, Value: Boolean) {
        mSharedPreferences.edit().putBoolean(key,Value).apply()
    }

    fun getBoolean(key: String): Boolean {
        return mSharedPreferences.getBoolean(key,false)?: false
    }
}