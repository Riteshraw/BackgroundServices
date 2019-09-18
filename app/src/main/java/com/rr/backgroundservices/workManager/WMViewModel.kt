package com.rr.backgroundservices.workManager

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.work.*

class WMViewModel(application: Application) : AndroidViewModel(application) {
    private val workManager = WorkManager.getInstance(application)

    init {
        // Gets reference to WordDao from WordRoomDatabase to construct
        // the correct WordRepository.
        //val wordsDao = WordRoomDatabase.getDatabase(application).wordDao()
        //repository = WordRepository(wordsDao)
        //allWords = repository.allWords
    }

    fun startWM() {
        val oneTimeWorkRequest = OneTimeWorkRequestBuilder<NetWorker>()
            .setConstraints(Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build())
            .build()

        workManager.enqueue(oneTimeWorkRequest)
    }
}
