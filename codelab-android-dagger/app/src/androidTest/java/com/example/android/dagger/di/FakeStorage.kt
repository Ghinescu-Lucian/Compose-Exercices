package com.example.android.dagger.di


import com.example.android.dagger.storage.Storage
import javax.inject.Inject

public class FakeStorage  @Inject constructor(): Storage {

    private val map = mutableMapOf<String, String>()

    override fun setString(key: String, value: String) {
        map[key] = value
    }

    override fun getString(key: String): String {
        return map[key].orEmpty()
    }
}
