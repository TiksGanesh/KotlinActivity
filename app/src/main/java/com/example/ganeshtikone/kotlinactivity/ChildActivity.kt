package com.example.ganeshtikone.kotlinactivity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.AppCompatButton
import android.support.v7.widget.AppCompatTextView
import android.util.Log
import android.view.View

class ChildActivity : AppCompatActivity(), View.OnClickListener {


    private val LOG_TAG = ChildActivity::class.simpleName
    private lateinit var buttonBack: AppCompatButton
    private lateinit var resultTextView: AppCompatTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_child)
        Log.d(LOG_TAG, "onCreate method executed")
        handleBackEvent()
        initUI()
        setClickListenerOnButton()
        getDataFromParent()
    }

    private fun getDataFromParent() {
        val data = intent.getStringExtra("key_data")
        resultTextView.setText(data)
    }

    private fun setClickListenerOnButton() {
        buttonBack.setOnClickListener(this)
    }

    private fun initUI() {
        buttonBack = findViewById(R.id.buttonBack)
        resultTextView = findViewById(R.id.textViewResult)
    }

    /**
     * Show back button on ActionBar
     * with help of support library
     */
    private fun handleBackEvent() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onStart() {
        super.onStart()
        Log.d(LOG_TAG, "onStart method executed")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LOG_TAG, "onResum method executed")
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
        super.onRestart()
        Log.d(LOG_TAG, "onRestart method executed")
    }

    override fun onClick(view: View?) {
        if (view?.id == R.id.buttonBack){
            finish()
        }
    }
}
