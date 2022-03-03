package com.example.userposttodo_jig_feb15.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.userposttodo_jig_feb15.data.local.entity.user.User
import com.example.userposttodo_jig_feb15.databinding.UserRowItemBinding

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private val userList = mutableListOf<User>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            UserRowItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    override fun getItemCount(): Int = userList.size

    fun submitList(users: List<User>){
        userList.clear()
        userList.addAll(users)
        notifyDataSetChanged()
    }
    class UserViewHolder(private val binding: UserRowItemBinding) :
            RecyclerView.ViewHolder(binding.root) {
                fun bind(user: User) = with(binding) {
                    idTv.text = user.id.toString()
                    nameTv.text = user.name
                    usernameTv.text = user.username
                    emailTv.text = user.email
                    streetTv.text = user.address.street
                    suiteTv.text = user.address.suite
                    cityTv.text = user.address.city
                    zipvodeTv.text = user.address.zipcode
                    latitudeTv.text = user.address.geo.lat
                    longitudeTv.text = user.address.geo.lng
                    phoneTv.text = user.phone
                    websiteTv.text = user.website
                    companyNameTv.text = user.company.name
                    catchPhraseTv.text = user.company.catchPhrase
                    bsTv.text = user.company.bs
                }
            }
}