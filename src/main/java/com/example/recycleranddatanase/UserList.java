package com.example.recycleranddatanase;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserList extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String> name,email,age;
    DBHelper DB;
    MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        DB=new DBHelper(this);
        name=new ArrayList<>();
        email=new ArrayList<>();
        age=new ArrayList<>();

        //for add new data (Short method)
        findViewById(R.id.btnAddNewData).setOnClickListener(v -> {
            Intent intent=new Intent(UserList.this,MainActivity.class);
            startActivity(intent);
        });


        //get data from database
        //find id of recycler view from layout
        recyclerView=findViewById(R.id.recyclerView);

        adapter=new MyAdapter(this,name,email,age);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();

    }
    //for display data using cursor
    private void displaydata(){

        Cursor cursor=DB.getData();
        if(cursor.getCount()==0){
            Toast.makeText(this, "No entry Exists", Toast.LENGTH_SHORT).show();

        }else{
            while(cursor.moveToNext()){
                name.add(cursor.getString(0));
                email.add(cursor.getString(1));
                age.add(cursor.getString(2));
            }
        }
    }
}