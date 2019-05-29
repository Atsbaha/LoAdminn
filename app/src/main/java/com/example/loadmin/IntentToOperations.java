package com.example.loadmin;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class IntentToOperations extends AppCompatActivity {

    Button btnPostWinningNumber,btnManageUsers,btnLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_to_operations);

        btnPostWinningNumber=findViewById(R.id.btnWinningNumber);
        btnManageUsers=findViewById(R.id.btnManageUsers);
        btnLoading=findViewById(R.id.btnLoading);



        btnPostWinningNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(IntentToOperations.this,PostZhonWinningNumber.class);
                startActivity(intent);
            }
        });

        btnManageUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(IntentToOperations.this,UserList.class);
                startActivity(intent);
            }
        });


        btnLoading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(IntentToAllFetanLottery.this,NationalLottery.class);
//                startActivity(intent);
            }
        });
    }
}
