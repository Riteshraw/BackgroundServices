package com.rr.backgroundservices.jobScheduler

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.job.JobParameters
import android.app.job.JobService
import android.content.Context
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.rr.backgroundservices.R

class NetJobService : JobService() {
    private val CHANNEL_ID: String = "Jobservice_Notification"

    override fun onStartJob(params: JobParameters?): Boolean {
        Log.i("BS", "This is job service start")
        Toast.makeText(applicationContext, "This is job service start", Toast.LENGTH_SHORT).show()

        createNotification()

        return false
    }

    override fun onStopJob(params: JobParameters?): Boolean {
        Log.i("BS", "This is job service stop")
        return false
    }

    fun createNotification() {
        val builder = NotificationCompat.Builder(applicationContext, CHANNEL_ID)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentText("Content text")
            .setContentTitle("Content title")
            .build()

        createNiotificaitonChannel()

        with(NotificationManagerCompat.from(this)) {
            // notificationId is a unique int for each notification that you must define
            notify(1, builder)
        }

    }

    private fun createNiotificaitonChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelName = "ChannelName"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val descriptionText = "Channel description"
            val notificationChannel = NotificationChannel(CHANNEL_ID, channelName, importance).apply {
                description = descriptionText
            }

            // Register the channel with the system
            val notificationManager: NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(notificationChannel)
        }
    }
}