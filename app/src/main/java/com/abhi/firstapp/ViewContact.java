//package com.abhi.firstapp;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//
//public class ViewContact extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_view_contact);
//
//        recyclerView = (RecyclerView) findViewById(R.id.recyclerContact);
//        contactModelArrayList = new ArrayList<>();
//        myHandler = new MyHandler(ViewContact.this);
//
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewContact.this,RecyclerView.VERTICAL,false);
//        recyclerView.setLayoutManager(linearLayoutManager);
//
//        contactModelArrayList = myHandler.readContact();
//        courseAdapter = new CourseAdapter(contactModelArrayList,ViewContact.this);
//        recyclerView.setAdapter(courseAdapter);
//    }
//}