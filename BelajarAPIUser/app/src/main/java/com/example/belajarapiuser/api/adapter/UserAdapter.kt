package com.example.belajarapiuser.api.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.motion.widget.MotionScene.Transition.TransitionOnClick
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.belajarapiuser.R
import com.example.belajarapiuser.api.model.Users

class UserAdapter(private val onClick: (Users) -> Unit) :
    ListAdapter<Users,UserAdapter.UserViewHolder>(UserCallBack) {
    class UserViewHolder(itemView: View, val onClick: (Users) -> Unit) :
        RecyclerView.ViewHolder(itemView){
        private val image: ImageView = itemView.findViewById(R.id.image)
        private val firstLastName: TextView = itemView.findViewById(R.id.firstLastName)
        private val email: TextView = itemView.findViewById(R.id.email)
        private val phone: TextView = itemView.findViewById(R.id.phone)

        private var currentUser: Users? = null

        init {
            itemView.setOnClickListener{
                currentUser?.let {
                    onClick(it)
                }
            }
        }

        fun bind(user: Users){
            currentUser = user

            firstLastName.text = user.firstName
            email.text = user.email
            phone.text = user.phone

            Glide.with(itemView).load(user.image).centerCrop().into(image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.row_users,parent,false)
        return UserViewHolder(view,onClick)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = getItem(position)
        holder.bind(user)
    }
}

object UserCallBack : DiffUtil.ItemCallback<Users>(){
    override fun areItemsTheSame(oldItem: Users, newItem: Users): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Users, newItem: Users): Boolean {
        return oldItem.id == newItem.id
    }

}