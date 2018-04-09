package com.example.dz.mockdatabinding.viewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.content.Context
import com.example.dz.mockdatabinding.data.DBHelper
import com.example.dz.mockdatabinding.data.DataManager
import com.example.dz.mockdatabinding.data.model.Item
import com.example.dz.mockdatabinding.data.table.User

class MainViewModel : ViewModel() {
    var item = MutableLiveData<List<Item>>()
    var dataManager: DataManager = DataManager()
    private var dbHelper: DBHelper? = null

    init {
        item.value = dataManager.generateList()
    }

    fun getData(): LiveData<List<Item>> {
        return item
    }

    fun getDBHelper(context: Context) {
        dbHelper = DBHelper.getInstance(context)
    }

    fun insertUser(user: User) {
        dbHelper?.insertUser(user)
    }

    fun getUsers(): List<User> {
        return dbHelper?.getUsers()!!
    }
}