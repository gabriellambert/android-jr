package com.example.androidjr.home.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidjr.R
import com.example.androidjr.databinding.FragmentRoleItemBinding
import com.example.androidjr.home.domain.entity.RoleItemEntity


class ListItemsAdapter(
    private val context: Context,
    var items: List<RoleItemEntity>
) : RecyclerView.Adapter<ListItemsAdapter.ViewHolder>() {

    var newList = items.toMutableList()

    //gdhjsagdjhsagdjhsa

    class ViewHolder(binding: FragmentRoleItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val tvTitle = binding.textTitle
        val tvDescription = binding.textDescription
        val imgExpand = binding.imageExpand
        val imgTitle = binding.imageTitle
        val imgLocation = binding.imageLocation
        val imgCompany = binding.imageCompany
        val imgPayment = binding.imagePayment
        val imgBookmark = binding.icBookmarksExpand
        val btnApply = binding.bottonApply
        val tvLocation = binding.textLocationSaopaulo
        val tvCompany = binding.textCompanyGoogle
        val tvPayment = binding.textPaymentValue

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = FragmentRoleItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return newList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = newList[position]
        holder.tvTitle.text = item.title
        holder.tvDescription.text = item.description
        holder.imgTitle.setImageResource(item.image)
        holder.tvLocation.text = item.location
        holder.tvCompany.text = item.company
        holder.tvPayment.text = item.payment.toPlainString()

        holder.imgExpand.setOnClickListener {

            if (holder.tvDescription.visibility == View.GONE){
                holder.tvDescription.visibility = View.VISIBLE
                holder.imgLocation.visibility = View.VISIBLE
                holder.imgCompany.visibility = View.VISIBLE
                holder.imgPayment.visibility = View.VISIBLE
                holder.imgBookmark.visibility = View.VISIBLE
                holder.btnApply.visibility = View.VISIBLE
                holder.tvLocation.visibility = View.VISIBLE
                holder.tvCompany.visibility = View.VISIBLE
                holder.tvPayment.visibility = View.VISIBLE

                holder.imgExpand.setImageResource(R.drawable.baseline_arrow_drop_up_24)
            }else{
                holder.tvDescription.visibility = View.GONE
                holder.imgLocation.visibility = View.GONE
                holder.imgCompany.visibility = View.GONE
                holder.imgPayment.visibility = View.GONE
                holder.imgExpand.setImageResource(R.drawable.ic_arrow_right)
                holder.imgBookmark.visibility = View.GONE
                holder.btnApply.visibility = View.GONE
                holder.tvLocation.visibility = View.GONE
                holder.tvCompany.visibility = View.GONE
                holder.tvPayment.visibility = View.GONE


            }
        }
    }

    fun filterList(position: Int) {
        newList.clear()
        when (position) {
            1 -> newList.addAll(items.filter { it.title.contains("Android") })
            2 -> newList.addAll(items.filter { it.title.contains("Apple")})
            3 -> newList.addAll(items.filter { it.title.contains("Flutter")})
            else -> newList.addAll(items)
        }
    }
}




