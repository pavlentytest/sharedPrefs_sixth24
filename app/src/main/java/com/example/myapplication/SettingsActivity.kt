package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceManager

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings_activity)
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.settings, SettingsFragment())
                .commit()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this)
        val map: Map<String,*> = sharedPrefs.all
        map.forEach { e ->
            Log.d("RRR","${e.key} -> ${e.value}")
        }
        val sharedPref2 = getSharedPreferences("filename", MODE_PRIVATE)
        val editor = sharedPref2.edit().putString("key","value123")
        editor.apply()
    }

    class SettingsFragment : PreferenceFragmentCompat() {
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey)
        }
    }
}