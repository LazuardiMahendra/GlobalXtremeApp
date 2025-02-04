package com.example.globalxtremeapp

import android.content.Context
import android.content.SharedPreferences

class SessionManager(context: Context) {
    private var prefs: SharedPreferences =
        context.getSharedPreferences("globalxtreme", Context.MODE_PRIVATE)


}