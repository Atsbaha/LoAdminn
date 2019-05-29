package com.example.loadmin;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

//import com.google.android.gms.tasks.OnCompleteListener;

public class LoginActivity extends AppCompatActivity {
    public EditText loginEmailText,loginPasswordText;
    public Button loginBtn,loginRegBtn,toAllOperations;

//    private ProgressBar  loginProgress;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth=FirebaseAuth.getInstance();
        loginEmailText=findViewById(R.id.login_email);
        loginPasswordText=findViewById(R.id.login_password);
        loginBtn=findViewById(R.id.login_btn);
        loginRegBtn=findViewById(R.id.login_reg_btn);




        loginEmailText.addTextChangedListener(loginTextWatcher);
        loginPasswordText.addTextChangedListener(loginTextWatcher);

//        toAllOperations=findViewById(R.id.toAllOperations);

//        loginProgress=findViewById(R.id.login_progress);



      /*  loginRegBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
//                finish();
            }
        });*/

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String loginEmail=loginEmailText.getText().toString().trim();
                String loginPass=loginPasswordText.getText().toString().trim();





                //check if the email and password are not empty
                if(!TextUtils.isEmpty(loginEmail) && !TextUtils.isEmpty(loginPass))
                {
//                    loginProgress.setVisibility(View.VISIBLE);
                    mAuth.signInWithEmailAndPassword(loginEmail,loginPass).addOnCompleteListener(new OnCompleteListener<AuthResult>(){


                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task)
                        {
                            //if we login successfully go to activity you want
                            if(task.isSuccessful())
                            {
                                //write an activity here you want to go but for the time being let us use toast message

//                                sendToMain();

//                                Toast.makeText(LoginActivity.this,"successfull",Toast.LENGTH_LONG).show();

                                //i added this see it
                                Intent intent=new Intent(LoginActivity.this,IntentToOperations.class);
                                startActivity(intent);
                            }else{
                                String errorMessage=task.getException().getMessage();
                                Toast.makeText(LoginActivity.this,"error :"+errorMessage,Toast.LENGTH_LONG).show();
                            }

//                            loginProgress.setVisibility(View.VISIBLE);//after successfull login
                        }


                    });
                }



            }
        });


    }






    private TextWatcher loginTextWatcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String loginEmail=loginEmailText.getText().toString().trim();
            String loginPass=loginPasswordText.getText().toString().trim();
            loginBtn.setEnabled(!loginEmail.isEmpty() && !loginPass.isEmpty());



        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
  /*@Override
    public void onStart(){
        super.onStart();
        FirebaseUser currentUser=mAuth.getCurrentUser();
        if(currentUser != null)
        {
           sendToMain();
        }
    }

    private void sendToMain() {
        Intent mainIntent=new Intent(LoginActivity.this,MainActivity.class);
        startActivity(mainIntent);
        finish();
    }*/
}
