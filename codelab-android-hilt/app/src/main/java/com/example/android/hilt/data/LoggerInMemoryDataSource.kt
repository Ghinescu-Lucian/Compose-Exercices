package com.example.android.hilt.data

import dagger.hilt.android.scopes.ActivityScoped
import java.util.LinkedList
import javax.inject.Inject

@ActivityScoped
class LoggerInMemoryDataSource @Inject constructor(): LoggerDataSource {

    private val logs = LinkedList<Log>()

    override fun addLog(msg: String) {
//        TODO("Not yet implemented")
        logs.add(Log(msg, System.currentTimeMillis()))
    }

    override fun getAllLogs(callback: (List<Log>) -> Unit) {
//        TODO("Not yet implemented")
        callback(logs)
    }

    override fun removeLogs() {
//        TODO("Not yet implemented")
        logs.clear()
    }
}