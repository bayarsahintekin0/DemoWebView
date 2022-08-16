package com.bayarsahintekin.stars.util

import android.content.Context
import android.util.Log
import android.widget.Toast

fun showToast(context: Context,message: String, duration: Int){
    Toast.makeText(context,message,duration).show()
}

fun logInfo(tag: String,message: String){
    Log.i(tag,message)
}

fun logError(tag: String,message: String){
    Log.e(tag,message)
}

fun logVerbose(tag: String,message: String){
    Log.v(tag,message)
}

fun logDebug(tag: String,message: String){
    Log.d(tag,message)
}