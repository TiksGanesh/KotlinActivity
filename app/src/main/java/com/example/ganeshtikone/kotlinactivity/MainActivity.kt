package com.example.ganeshtikone.kotlinactivity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.AppCompatButton
import android.util.Log
import android.view.View

class MainActivity : AppCompatActivity() {

    private val LOG_TAG = MainActivity::class.simpleName
    private lateinit var buttonNavigation: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(LOG_TAG, "onCreate method executed")

        // Init UI
        initUI()
        setClickListenerOnButton()
    }

    /**
     * Setting event delegation on Button
     * To handle event on button
     * using lambda expression
     */
    private fun setClickListenerOnButton() {
        buttonNavigation.setOnClickListener(View.OnClickListener { gotoChildActivity() })
    }

    /**
     * Initialise User Interface with findViewById method
     * This method by default available in Activity class or it's subclass
     */
    private fun initUI() {
        buttonNavigation = findViewById(R.id.buttonNavigation)
    }

    /**
     * Using of Intent Concept
     * Explicit Intent
     * We specify class to which navigation should occure
     *
     */
    private fun gotoChildActivity() {

        val navigationIntent = Intent(this, ChildActivity::class.java)
        startActivity(navigationIntent)
    }

    override fun onStart() {
        super.onStart()
        Log.d(LOG_TAG, "onStart method executed")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LOG_TAG, "onResume method executed")
    }


    override fun onPause() {

        Log.d(LOG_TAG, "onPause method executed")
        super.onPause()
    }

    override fun onStop() {
        Log.d(LOG_TAG, "onStop method executed")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d(LOG_TAG, "onDestroy method executed")
        super.onDestroy()
    }

    override fun onRestart() {
        Log.d(LOG_TAG, "onRestart method executed")
        super.onRestart()
    }
}
