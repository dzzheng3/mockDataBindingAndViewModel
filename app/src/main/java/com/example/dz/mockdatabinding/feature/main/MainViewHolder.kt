package com.example.dz.mockdatabinding.feature.main

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import com.example.dz.mockdatabinding.BR
import com.example.dz.mockdatabinding.data.model.Item

class MainViewHolder constructor(val viewDataBinding:ViewDataBinding): RecyclerView.ViewHolder(viewDataBinding.root){
    fun bind(item: Item){
        viewDataBinding.setVariable(BR.item,item)
        viewDataBinding.executePendingBindings()
    }
}