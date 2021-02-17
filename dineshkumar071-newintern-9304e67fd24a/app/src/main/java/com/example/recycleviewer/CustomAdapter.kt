package com.example.recycleviewer

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(
    var c: Context,
    val userList: ArrayList<user>,
    var itemClickListener1: ItemClickInterfaces
) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //@SuppressLint("WrongViewCast")
        val textviewName = itemView.findViewById(R.id.textName) as TextView
        val texViewDescription = itemView.findViewById(R.id.Description) as TextView
        val textviewcategory = itemView.findViewById(R.id.category) as TextView
        val textviewsize = itemView.findViewById(R.id.size) as TextView
        val buttonview = itemView.findViewById(R.id.update) as Button
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user1: user = userList[position]
        holder.textviewName.text = user1.name
        holder.texViewDescription.text = user1.Description
        holder.textviewcategory.text = user1.Category
        holder.textviewsize.text = user1.Size
        holder.buttonview.text = user1.bt
        holder.buttonview.setOnClickListener {
            if (holder.buttonview.text.equals("update")) {
                user1.bt = "Open"
            } else {
                itemClickListener1.itemClick()
            }
            notifyDataSetChanged()
        }

    }

    interface ItemClickInterfaces {
        fun itemClick()
    }
}