package com.example.androidjr.home.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidjr.R
import com.example.androidjr.databinding.FragmentRoleItemBinding
import com.example.androidjr.home.domain.entity.RoleItemEntity


class RoleItemAdapter(
    private val context: Context,
    private var items: List<RoleItemEntity>
) : RecyclerView.Adapter<RoleItemAdapter.RoleViewHolder>() {

    private var newList = items.toMutableList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoleViewHolder {
        val binding = FragmentRoleItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return RoleViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return newList.size
    }

    override fun onBindViewHolder(holder: RoleViewHolder, position: Int) {
        val item = newList[position]
        holder.run {
            tvTitle.text = item.title
            tvDescription.text = item.description
            imgTitle.setImageResource(item.image)
            tvLocation.text = item.location
            tvCompany.text = item.company
            tvPayment.text = item.payment.toPlainString()

            imgExpand.setOnClickListener {
                if (tvDescription.visibility == View.GONE){
                    tvDescription.visibility = View.VISIBLE
                    imgLocation.visibility = View.VISIBLE
                    imgCompany.visibility = View.VISIBLE
                    imgPayment.visibility = View.VISIBLE
                    imgBookmark.visibility = View.VISIBLE
                    btnApply.visibility = View.VISIBLE
                    tvLocation.visibility = View.VISIBLE
                    tvCompany.visibility = View.VISIBLE
                    tvPayment.visibility = View.VISIBLE

                    imgExpand.setImageResource(R.drawable.baseline_arrow_drop_up_24)
                }else{
                    tvDescription.visibility = View.GONE
                    imgLocation.visibility = View.GONE
                    imgCompany.visibility = View.GONE
                    imgPayment.visibility = View.GONE
                    imgExpand.setImageResource(R.drawable.ic_arrow_right)
                    imgBookmark.visibility = View.GONE
                    btnApply.visibility = View.GONE
                    tvLocation.visibility = View.GONE
                    tvCompany.visibility = View.GONE
                    tvPayment.visibility = View.GONE
                }
            }
        }
    }

    inner class RoleViewHolder(binding: FragmentRoleItemBinding) :
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

