package com.rr.backgroundservices.jobScheduler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rr.backgroundservices.R
import android.view.View
import androidx.lifecycle.ViewModelProviders


class JobSchActivity : AppCompatActivity() {
    private lateinit var jsViewModel: JSViewModel

    override
    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_sch)

        jsViewModel = ViewModelProviders.of(this).get(JSViewModel::class.java)

    }

    fun onJSClick(view: View) {
        jsViewModel.startJob()
    }
}
