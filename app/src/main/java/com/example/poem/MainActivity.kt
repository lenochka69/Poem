package com.example.poem

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.poem.databinding.ActivityBinding

private const val TAG = "MainActivity"
private const val MY_FILTER_TAG = "myfilter"
private const val KEY = "KEY"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBinding
    private lateinit var buttonclick: Button
    private lateinit var textwrite: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        textwrite =findViewById(R.id.Write)
        buttonclick=findViewById(R.id.Click)

        if (savedInstanceState != null)
            textwrite.text=savedInstanceState.getString(KEY)


        buttonclick.setOnClickListener{
            textwrite.text = "My homework number 2"
        }

        Log.d(MY_FILTER_TAG,"onCreate(Ты видел деву на скале\n" +
                "В одежде белой над волнами)")

    }

    override fun onStart() {
        super.onStart()
        Log.d(MY_FILTER_TAG,"onStart(Когда, бушуя в бурной мгле,\n" +
                "Играло море с берегами,)")
    }

    override fun onResume() {
        super.onResume()
        Log.d(MY_FILTER_TAG,"onResume(Когда луч молний озарял\n" +
                "Ее всечасно блеском алым)")
    }

    override fun onPause() {
        super.onPause()
        Log.d(MY_FILTER_TAG,"onPause(И ветер бился и летал\n" +
                "С ее летучим покрывалом?)")
    }

    override fun onStop() {
        super.onStop()
        Log.d(MY_FILTER_TAG,"onStop(Прекрасно море в бурной мгле\n" +
                "И небо в блесках без лазури;)")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(MY_FILTER_TAG,"onRestart(Но верь мне: дева на скале\n" +
                "Прекрасней волн, небес и бури.)")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(MY_FILTER_TAG,"onDestroy(Но верь мне: дева на скале\n" +
                "Прекрасней волн, небес и бури.")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(KEY,textwrite.text.toString())
    }
    }



