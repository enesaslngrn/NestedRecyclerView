package com.example.nestedrecyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nestedrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val parentList = ArrayList<ParentData>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dummyData()
        val adapter = ParentAdapter(parentList)
        binding.mainRecyclerView.adapter = adapter
        binding.mainRecyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
    }

    private fun dummyData(){
        val childList1 = arrayListOf(
            ChildData("C#",R.drawable.csharp),
            ChildData("C++",R.drawable.cplusplus),
            ChildData("Java",R.drawable.java),
        )
        parentList.add(ParentData("Game Dev",childList1))

        val childList2 = arrayListOf(
            ChildData("Kotlin",R.drawable.kotlin),
            ChildData("Java",R.drawable.java),
        )
        parentList.add(ParentData("Android Dev",childList2))

        val childList3 = arrayListOf(
            ChildData("HTML",R.drawable.html),
            ChildData("JavaScript",R.drawable.javascript),
        )
        parentList.add(ParentData("FrontEnd",childList3))

        val childList4 = arrayListOf(
            ChildData("Python",R.drawable.python),
            ChildData("Kotlin",R.drawable.kotlin),
            ChildData("Java",R.drawable.java),
            ChildData("C++",R.drawable.cplusplus),
            ChildData("Swift",R.drawable.swift)
        )
        parentList.add(ParentData("BackEnd",childList4))
    }
}