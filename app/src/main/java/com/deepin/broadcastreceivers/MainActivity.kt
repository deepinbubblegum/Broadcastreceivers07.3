package com.deepin.broadcastreceivers

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val mReceiver = CustomReceiver()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val filter = IntentFilter()
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED)
        filter.addAction(Intent.ACTION_POWER_CONNECTED)
        this.registerReceiver(mReceiver, filter)
    }

    override fun onDestroy() {
        this.unregisterReceiver(mReceiver)
        super.onDestroy()
    }
}
