package com.bishop.Contact.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bishop.Contact.models.Contact
import com.bishop.Contact.models.ContactDatabase

class MainActivityViewModel : ViewModel() {

     val contactLiveData = MutableLiveData<List<Contact>>()

    fun getContact(database: ContactDatabase) {
        contactLiveData.postValue(database.contactDao().getAllContact())
    }

    fun addContact(database: ContactDatabase, contact: Contact) {
        database.contactDao().addContact(contact)
        getContact(database)
    }
}