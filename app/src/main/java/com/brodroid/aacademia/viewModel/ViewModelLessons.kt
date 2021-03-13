package com.brodroid.aacademia.viewModel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.brodroid.aacademia.Lesson
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
        databaseReference?.let { databaseReference ->
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
                        // after getting the value we are setting
                        // our value to our text view in below line.
                    }
                    if (lessons.isNotEmpty()) {
                        liveDataLessonList.postValue(lessons)
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