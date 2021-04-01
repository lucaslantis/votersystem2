package com.example.votersystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.votersystem.data.model.usermodel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class register extends AppCompatActivity {
    EditText qfullName, qEmail, qphone, qpassword;
    Button qregisterBtn;
    TextView qbacklog;
    FirebaseAuth mFirebaseAuth;
    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        qEmail = findViewById(R.id.Email);
        qfullName = findViewById(R.id.fullName);
        qphone = findViewById(R.id.phone);
        qpassword = findViewById(R.id.password);
        qregisterBtn = findViewById(R.id.registerBtn);
        qbacklog = findViewById(R.id.backlog);
        mFirebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        qregisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = qEmail.getText().toString();
                final String name = qfullName.getText().toString();

                final String pho = qphone.getText().toString();
                final String pwd = qpassword.getText().toString();
                if (email.isEmpty()) {
                    qEmail.setError("Please provide email id");
                } else if (name.isEmpty()) {
                    qfullName.setError("Please provide your first name");

                } else if (pho.isEmpty()) {
                    qphone.setError("Please provide your last name");

                } else if (pwd.isEmpty()) {
                    qpassword.setError("Please provide password");

                } else if (!(email.isEmpty()) && !(pwd.isEmpty())) {
                    mFirebaseAuth.createUserWithEmailAndPassword(email, pwd)
                            .addOnCompleteListener(register.this, new OnCompleteListener<AuthResult>() {
                                        @Override
                                        public void onComplete(@NonNull Task<AuthResult> task) {
                                            usermodel userModel1 = new usermodel(email, name, pho, 0, 1);
                                            String uid = task.getResult().getUser().getUid();
                                            firebaseDatabase.getReference(uid).setValue(userModel1);
                         /*   .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Intent intent = new Intent(register.this,
                                            HomeActivity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                                            Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    intent.putExtra("name", fName + " " + lName);
                                    startActivity(intent);*/


                                        }
                                    }
                            );

                }

            }
        });
    }
}