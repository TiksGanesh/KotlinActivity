package com.example.ganeshtikone.kotlinactivity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.AppCompatButton
import android.support.v7.widget.AppCompatEditText
import android.util.Log
import android.view.View

class MainActivity : AppCompatActivity() {

    private val LOG_TAG = MainActivity::class.simpleName
    private lateinit var buttonNavigation: AppCompatButton
    private lateinit var editTextInput: AppCompatEditText
    private lateinit var buttonCallCustomerCare: AppCompatButton

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
        buttonNavigation.setOnClickListener(View.OnClickListener {


            // Get text from EditText
            val data = editTextInput.text.toString()

            // Pass data to method
            gotoChildActivityWithData(data)
        })

        buttonCallCustomerCare.setOnClickListener(View.OnClickListener {
            callCustomerCare()
        })
    }

    /**
     * Use of Implicit Intent
     * Implicit Intent use when open existing system application
     */
    private fun callCustomerCare() {
        val callImplicitIntent = Intent(Intent.ACTION_DIAL)
        callImplicitIntent.data = (Uri.parse("tel:0123456789"))
        startActivity(callImplicitIntent)
    }

    /**
     * Initialise User Interface with findViewById method
     * This method by default available in Activity class or it's subclass
     */
    private fun initUI() {
        buttonNavigation = findViewById(R.id.buttonNavigation)
        editTextInput = findViewById(R.id.editTextInput)
        buttonCallCustomerCare = findViewById(R.id.buttonCallCustomerCare)
    }

    /**
     * Using of Intent Concept
     * Explicit Intent
     * We specify class to which navigation should occure
     * Pass Data
     *
     */
    private fun gotoChildActivityWithData(data: String) {

        val navigationIntent = Intent(this, ChildActivity::class.java)
        navigationIntent.putExtra("key_data", data)
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
        clearEditText()
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

    private fun clearEditText() {
        editTextInput.setText("")
    }
}
