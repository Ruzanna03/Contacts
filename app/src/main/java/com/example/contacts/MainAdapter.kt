package com.example.contacts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.models.UserModel

class MainAdapter(
    private val userModelList: MutableList<UserModel>,
    private val onItemClick: (userModel: UserModel) -> Unit
) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.users, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tempUserModel = userModelList[position]
        holder.bind(tempUserModel)
    }

    override fun getItemCount(): Int = userModelList.size
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvFirstName = itemView.findViewById<TextView>(R.id.tv_first_name)
        val tvLastName = itemView.findViewById<TextView>(R.id.tv_last_name)
        val tvPhoneNumber = itemView.findViewById<TextView>(R.id.tv_phone_number)
        val imgAvatar = itemView.findViewById<ImageView>(R.id.img_user_avatar)
        fun bind(userModel: UserModel) {
            tvFirstName.text = userModel.firstName
            tvLastName.text = userModel.lastName
            tvPhoneNumber.text = userModel.phoneNumber
            imgAvatar.setImageResource(userModel.imageId)
            imgAvatar.setOnClickListener {
                onItemClick.invoke(userModel)
            }
        }
    }
}
