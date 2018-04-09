package com.example.dz.mockdatabinding.feature.main

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dz.mockdatabinding.R
import com.example.dz.mockdatabinding.data.model.Item


class MainAdapter : RecyclerView.Adapter<MainViewHolder>() {
    private var items: List<Item>? = null

    init {
        items = emptyList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        var dataBindingUtil = DataBindingUtil.inflate<ViewDataBinding>(
                LayoutInflater.from(parent.context),
                R.layout.item,
                parent,
                false
        )
        return MainViewHolder(dataBindingUtil)
    }

    override fun getItemCount(): Int {
        return items?.size as Int
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(items?.get(position) as Item)
    }

    fun setItems(items: List<Item>) {
        this.items = items
    }

}