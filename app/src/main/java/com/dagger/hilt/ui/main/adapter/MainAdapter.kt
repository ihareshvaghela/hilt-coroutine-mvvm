package com.dagger.hilt.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dagger.hilt.data.model.User
import com.dagger.hilt.databinding.ItemLayoutBinding

class MainAdapter(private val users: ArrayList<User>) :
    RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    lateinit var context: Context

    inner class MainViewHolder(val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        context = parent.context
        return MainViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        with(holder) {
            binding.textViewUserName.text = users[position].name
            binding.textViewUserEmail.text = users[position].email
            Glide.with(context).load(users[position].avatar).into(binding.imageViewAvatar)
        }
    }

    fun addData(list: List<User>) {
        users.addAll(list)
    }

}