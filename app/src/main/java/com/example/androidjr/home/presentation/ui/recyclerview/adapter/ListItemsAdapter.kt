package com.example.androidjr.home.presentation.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidjr.databinding.FragmentRoleItemBinding
import com.example.androidjr.home.domain.entity.RoleItemEntity


class ListItemsAdapter(
    private val context: Context,
    items : List<RoleItemEntity>
) : RecyclerView.Adapter<ListItemsAdapter.ViewHolder>() {

    private val items = items.toMutableList()


    class ViewHolder(private val binding: FragmentRoleItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: RoleItemEntity) {
            val title = binding.textTitle
            title.text = item.title
            val image = binding.imageLogoTitle
            image.imageAlpha = item.image



        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = FragmentRoleItemBinding.inflate(inflater,parent,false)
        return ViewHolder(binding)
    }


    override fun getItemCount(): Int = items.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }


}
