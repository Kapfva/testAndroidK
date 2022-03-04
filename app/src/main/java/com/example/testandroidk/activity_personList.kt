package com.example.testandroidk

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testandroidk.model.Person
import com.google.firebase.database.*
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class activity_personList : AppCompatActivity() {

    private val db = Firebase.firestore
    private lateinit var personRecyclerView: RecyclerView
    private lateinit var personMutableList: MutableList<Person>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person_list)

        personRecyclerView = findViewById<RecyclerView>(R.id.rvPersonItems)
        personRecyclerView.layoutManager= LinearLayoutManager(this)
        personRecyclerView.setHasFixedSize(true)

        personMutableList= mutableListOf<Person>()
        getPersonData()
    }

    private fun getPersonData() {

        val dbref = db.collection("users")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {

                }
            }
            .addOnFailureListener { exception ->
            }

    }
}