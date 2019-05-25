package com.example.loadmin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.loadmin.Model.ZhonPostModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PostZhonWinningNumber extends AppCompatActivity {
    Button btnPost;
    EditText edtLotteryNumber;

    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_zhon_winning_number);

        btnPost=findViewById(R.id.btnZhonPost);
        edtLotteryNumber=findViewById(R.id.edtZhonWinningNumber);



        reference= FirebaseDatabase.getInstance().getReference().child("Zhon Won Ticket Number");

        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String zhonNumber=edtLotteryNumber.getText().toString();
                ZhonPostModel zhonPostModel=new ZhonPostModel(zhonNumber);
                reference.push().setValue(zhonPostModel);

            }
        });
    }
}
