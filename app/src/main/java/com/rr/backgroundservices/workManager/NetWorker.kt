package com.rr.backgroundservices.workManager

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.work.Worker
import androidx.work.WorkerParameters

class NetWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    override fun doWork(): Result {
        Log.i("BS","Inside WM doWork()")
        //Toast.makeText(applicationContext,"toast message",Toast.LENGTH_SHORT).show()
        return Result.success()
    }
}