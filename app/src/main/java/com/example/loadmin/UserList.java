package com.example.loadmin;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserList extends AppCompatActivity {

    TextView txtEmail,txtUniqueNumber,txtTicketNumber;
    EditText edtEmail,edtUniqueNumber,edtTicketNumber;
    Button btnRetrieve;

    FirebaseAuth auth;
    FirebaseUser user;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        auth=FirebaseAuth.getInstance();
        user=auth.getCurrentUser();


        txtEmail=findViewById(R.id.textViewEmail);
        txtUniqueNumber=findViewById(R.id.textViewUniqueNumber);
        txtTicketNumber=findViewById(R.id.textViewTicketNumber);


        edtEmail=findViewById(R.id.edtEmail);
        edtUniqueNumber=findViewById(R.id.edtuniqueNumber);
        edtTicketNumber=findViewById(R.id.edtticketNumber);

        btnRetrieve=findViewById(R.id.btnretrieveData);


        btnRetrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference= FirebaseDatabase.getInstance().getReference().child("Zhon Lottery Email And TicketNumber");
//                databaseReference= FirebaseDatabase.getInstance().getReference().child("Zhon Lottery Email And TicketNumber").push();
//                databaseReference= FirebaseDatabase.getInstance().getReference().child("Zhon Lottery Email And TicketNumber").getPath();
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String email=dataSnapshot.child("email").getValue().toString();
                        String uniquNumber=dataSnapshot.child("ticktNumber").getValue().toString();
                        String ticketNumber=dataSnapshot.child("uniquqNumber").getValue().toString();

                        edtEmail.setText(email);
                        edtTicketNumber.setText(ticketNumber);
                        edtUniqueNumber.setText(uniquNumber);




                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}
