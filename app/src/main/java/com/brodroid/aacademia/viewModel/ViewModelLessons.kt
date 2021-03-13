package com.brodroid.aacademia.viewModel

import android.app.Application
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.brodroid.aacademia.*
import com.google.firebase.database.*

class ViewModelLessons(application: Application) : AndroidViewModel(application) {

    private var firebaseDatabase: FirebaseDatabase? = null
    private var databaseReference: DatabaseReference? = null

    val liveDataLessonList = MutableLiveData<List<Lesson>>()

    init {
        firebaseDatabase =
            FirebaseDatabase.getInstance()
        firebaseDatabase?.let {
            databaseReference = it.getReference("lessons")

            getValuesFromFireBase()
        }
    }

    private fun getValuesFromFireBase() {
        var lessonsCount = 0
        databaseReference?.let { databaseReference ->
            databaseReference?.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    Log.d("ListenerForSingleValue", snapshot.childrenCount.toString())
                    lessonsCount = snapshot.childrenCount.toInt()
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })

            databaseReference.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    // this method is call to get the realtime
                    // updates in the data.
                    // this method is called when the data is
                    // changed in our Firebase console.
                    // below line is for getting the data from
                    // snapshot of our database.
                    val lessons: MutableList<Lesson> = mutableListOf()
                    snapshot.children.mapNotNullTo(lessons) {
                        it.getValue(Lesson::class.java)
                    }
                    if (lessons.isNotEmpty()) {
                        liveDataLessonList.postValue(lessons)
                        if(lessons.size > lessonsCount) {
                            val notification: Notification = NewLessonNotification(getApplication())
                            notification.showNotification(lessons.last())
                        }
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    // calling on cancelled method when we receive
                    // any error or we are not able to get the data.
                    Toast.makeText(getApplication(), "Fail to get data.", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}