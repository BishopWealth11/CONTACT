package com.bishop.Contact.models

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bishop.Contact.databinding.ContactsItemBinding

class ContactAdapter (var phone: List<Contact>, val clicker: (Contact) -> Unit ):RecyclerView.Adapter<ContactAdapter.ContactViewHolder>(){
    inner class ContactViewHolder(private val binding: ContactsItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bindContact (contact :Contact){
            binding.apply {
                idShow.text = contact.id.toString()
                NameShow.text = contact.fName
                phoneShow.text = contact.PhoneNo.toString()
                root.setOnClickListener { clicker(contact) }
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        var binding = ContactsItemBinding.inflate(LayoutInflater.from(parent.context))
        return ContactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
      holder.bindContact(phone [position])
    }

    override fun getItemCount(): Int {
      return phone.size
    }
}