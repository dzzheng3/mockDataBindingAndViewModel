package com.example.dz.mockdatabinding.feature.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.dz.mockdatabinding.R
import com.example.dz.mockdatabinding.data.table.User
import com.example.dz.mockdatabinding.databinding.ActivityMainBinding
import com.example.dz.mockdatabinding.viewModel.MainViewModel
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    lateinit var mainAdapter: MainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var activityMainBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        mainAdapter = MainAdapter()
        mainViewModel.getData().observe(this, Observer {
            mainAdapter.setItems(it!!)
            mainAdapter.notifyDataSetChanged()

        })
        rv.layoutManager = LinearLayoutManager(this)

        rv.adapter = mainAdapter

        activityMainBinding.setLifecycleOwner(this)
        mainViewModel.getDBHelper(this)
        RxView.clicks(bt).throttleFirst(2, TimeUnit.SECONDS).subscribeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    var user = User()
                    user.name = "test"
                    user.createDate = Date()
                    mainViewModel.insertUser(user)
                })
        RxView.clicks(bt_list).throttleFirst(2, TimeUnit.SECONDS).subscribeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    var i = 0
                    for (user in mainViewModel.getUsers()) {
                        Toast.makeText(this, user.name + i++, Toast.LENGTH_SHORT).show()
                    }
                })
    }
}
