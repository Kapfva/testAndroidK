package com.example.testandroidk

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testandroidk.model.Person
import com.google.firebase.database.*
import com.google.firebase.firestore.*
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class activity_personList : AppCompatActivity() {

    private lateinit var db : FirebaseFirestore
    private lateinit var personRecyclerView: RecyclerView
    private lateinit var personMutableList: MutableList<Person>
    private lateinit var personAdapter: PersonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person_list)

        personRecyclerView = findViewById<RecyclerView>(R.id.rvPersonItems)
        personRecyclerView.layoutManager= LinearLayoutManager(this)
        personRecyclerView.setHasFixedSize(true)

        personMutableList= mutableListOf<Person>()

        personAdapter = PersonAdapter(personMutableList)

        personRecyclerView.adapter = personAdapter

    }

    private fun EventChangeListener(){

        db = FirebaseFirestore.getInstance()
        db.collection("users").
                addSnapshotListener(object :EventListener<QuerySnapshot>{
                    override fun onEvent(
                        value: QuerySnapshot?,
                        error: FirebaseFirestoreException?
                    ) {
                       if (error != null){
                           Log.e("FirestoreError", error.message.toString())
                           return

                       }
                        for (dc: DocumentChange in value?.documentChanges!!){

                            if(dc.type == DocumentChange.Type.ADDED){
                                personMutableList.add(dc.document.toObject(Person::class.java))
                            }
                        }
                        personAdapter.notifyDataSetChanged()
                    }

                })
    }
}