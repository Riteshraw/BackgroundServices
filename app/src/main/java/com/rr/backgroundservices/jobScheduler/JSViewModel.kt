package com.rr.backgroundservices.jobScheduler

import android.app.Application
import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel

class JSViewModel(application: Application) : AndroidViewModel(application) {
    private val jobScheduler = application.getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler

    fun startJob() {
        val componentName = ComponentName(getApplication(), NetJobService::class.java)
        val jobInfo = JobInfo.Builder(1, componentName)
            .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
            .build()
        jobScheduler.schedule(jobInfo)
    }

}