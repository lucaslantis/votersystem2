package com.example.votersystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.votersystem.data.model.usermodel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity {
Button registerbutton,loginbtn;
    EditText emailId, password,testtext;

    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       registerbutton = findViewById(R.id.registerbtn);
        emailId = findViewById(R.id.username);

        loginbtn=findViewById(R.id.loginbutton);
        password = findViewById(R.id.editpassword);
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseAuth=FirebaseAuth.getInstance();
        registerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intSignUp = new Intent(MainActivity.this, register.class);
                intSignUp.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intSignUp);
            }});
        /*mAuthStateListener = new FirebaseAuth.AuthStateListener() {
                    @Override
                    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                        FirebaseUser mFirebaseUser = firebaseAuth.getCurrentUser();
                        if(mFirebaseUser != null){
                            moveToPage(mFirebaseUser);
                        }else
                        {

                        }
                    }};*/
        loginbtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String email = emailId.getText().toString();
                            String pwd = password.getText().toString();

                            if (email.isEmpty()) {
                                emailId.setError("Please provide email");
                                emailId.requestFocus();
                            } else if (pwd.isEmpty()) {
                                password.setError("Please provide password");
                                password.requestFocus();
                            } else if (!(email.isEmpty() && pwd.isEmpty())){
                            firebaseAuth.signInWithEmailAndPassword(email, pwd)
                                    .addOnCompleteListener(MainActivity.this,
                                            new OnCompleteListener<AuthResult>() {
                                                @Override
                                                public void onComplete(@NonNull Task<AuthResult> task) {
                                                    if (!task.isSuccessful()) {

                                                        testtext.setText("error");
                                                    } else {
                                                        FirebaseUser mFirebaseUser = firebaseAuth.getCurrentUser();
                                                        firebaseDatabase.getReference().child(mFirebaseUser.getUid()).addValueEventListener(new ValueEventListener(){
                                                            @Override
                                                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                                                usermodel usermodel = snapshot.getValue(usermodel.class);
                                                                //String name = usermodel.getFullname() ;
                                                                int usertype= usermodel.getType();
                                                                testtext.setText("2");
                                                                if(usertype==1)
                                                                {
                                                                    startActivity(new Intent(getApplicationContext(),votepage.class));}
                                                                if(usertype==2)
                                                                {
                                                                    startActivity(new Intent(getApplicationContext(),admin.class));
                                                                    //   i.putExtra("name", name);
                                                                }
                                                        }
                                                            @Override
                                                            public void onCancelled(@NonNull DatabaseError error) {


                                                            }
                                                        });

                                                       // moveToPage(task.getResult().getUser());
                                                    }
                                                }
                                            });}


                    }
                });
                };


    /*private void moveToPage(FirebaseUser mFirebaseUser) {

        firebaseDatabase.getReference().child(mFirebaseUser.getUid())
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        usermodel usermodel = snapshot.getValue(usermodel.class);
                        String name = usermodel.getFullname() ;
                        int usertype= usermodel.getType();
                        if(usertype==1)
                        {
                            startActivity(new Intent(getApplicationContext(),votepage.class));}
                        if(usertype==2)
                        {
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                            //   i.putExtra("name", name);

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {


                    }
                });
    }
*/

            }

