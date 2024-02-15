package com.mpi.mpiseba;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    private boolean passwordShowing = false;
    private FirebaseAuth firebaseAuth;

    EditText loginUsername, loginPassword;
    Button loginButton;
    TextView signupRedirectText, forgetpassText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();

        final ImageView passwordIcon = findViewById(R.id.passwordIcon);
        final EditText login_password = findViewById(R.id.login_password);

        passwordIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passwordShowing){
                    passwordShowing = false;
                    login_password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    passwordIcon.setImageResource(R.drawable.password_show);
                } else {
                    passwordShowing = true;
                    login_password.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    passwordIcon.setImageResource(R.drawable.password_hidden);
                }

                login_password.setSelection(login_password.length());
            }
        });

        loginUsername = findViewById(R.id.login_username);
        loginPassword = findViewById(R.id.login_password);
        loginButton = findViewById(R.id.login_button);
        signupRedirectText = findViewById(R.id.signupRedirectText);
        forgetpassText = findViewById(R.id.fogetpassText);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!validateUsername() | !validatePassword()) {

                } else {
                    checkUser();
                }
            }
        });

        signupRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });

        forgetpassText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, ForgetPassword.class);
                startActivity(intent);
            }
        });

        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        if (currentUser != null) {
            redirectToProfile();
        } else {
            attemptAutoLogin();
        }
    }

    public Boolean validateUsername() {
        String val = loginUsername.getText().toString();
        if (val.isEmpty()) {
            loginUsername.setError("Username cannot be empty");
            return false;
        } else {
            loginUsername.setError(null);
            return true;
        }
    }

    public Boolean validatePassword(){
        String val = loginPassword.getText().toString();
        if (val.isEmpty()) {
            loginPassword.setError("Password cannot be empty");
            return false;
        } else {
            loginPassword.setError(null);
            return true;
        }
    }

    public void checkUser() {
        String userUsername = loginUsername.getText().toString().trim();
        String userPassword = loginPassword.getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUserDatabase = reference.orderByChild("roll").equalTo(userUsername);

        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    loginUsername.setError(null);
                    String passwordFromDB = snapshot.child(userUsername).child("password").getValue(String.class);
                    if (passwordFromDB.equals(userPassword)) {
                        loginUsername.setError(null);
                        saveUserCredentialsLocally(userUsername, userPassword);

                        String nameFromDB = snapshot.child(userUsername).child("name").getValue(String.class);
                        String emailFromDB = snapshot.child(userUsername).child("phone").getValue(String.class);
                        String usernameFromDB = snapshot.child(userUsername).child("roll").getValue(String.class);
                        String semisterFromDB = snapshot.child(userUsername).child("semister").getValue(String.class);
                        String departmentFromDB = snapshot.child(userUsername).child("department").getValue(String.class);
                        String shiftFromDB = snapshot.child(userUsername).child("shift").getValue(String.class);

                        Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);
                        intent.putExtra("name", nameFromDB);
                        intent.putExtra("phone", emailFromDB);
                        intent.putExtra("roll", usernameFromDB);
                        intent.putExtra("semister", semisterFromDB);
                        intent.putExtra("department", departmentFromDB);
                        intent.putExtra("shift", shiftFromDB);
                        startActivity(intent);
                    } else {
                        loginPassword.setError("Invalid Credentials");
                        loginPassword.requestFocus();
                    }
                } else {
                    loginUsername.setError("User does not exist");
                    loginUsername.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void saveUserCredentialsLocally(String username, String password) {
        SharedPreferences preferences = getSharedPreferences("user_creds", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username", username);
        editor.putString("password", password);
        editor.apply();
    }

    private void attemptAutoLogin() {
        SharedPreferences preferences = getSharedPreferences("user_creds", MODE_PRIVATE);
        String savedUsername = preferences.getString("username", null);
        String savedPassword = preferences.getString("password", null);

        if (savedUsername != null && savedPassword != null) {
            loginWithSavedCredentials(savedUsername, savedPassword);
        }
    }

    private void loginWithSavedCredentials(String username, String password) {
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUserDatabase = reference.orderByChild("roll").equalTo(username);

        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    String passwordFromDB = snapshot.child(username).child("password").getValue(String.class);
                    if (passwordFromDB.equals(password)) {
                        loginUsername.setError(null);

                        String nameFromDB = snapshot.child(username).child("name").getValue(String.class);
                        String emailFromDB = snapshot.child(username).child("phone").getValue(String.class);
                        String semisterFromDB = snapshot.child(username).child("semister").getValue(String.class);
                        String departmentFromDB = snapshot.child(username).child("department").getValue(String.class);
                        String shiftFromDB = snapshot.child(username).child("shift").getValue(String.class);

                        Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);
                        intent.putExtra("name", nameFromDB);
                        intent.putExtra("phone", emailFromDB);
                        intent.putExtra("roll", username);
                        intent.putExtra("semister", semisterFromDB);
                        intent.putExtra("department", departmentFromDB);
                        intent.putExtra("shift", shiftFromDB);
                        startActivity(intent);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void redirectToProfile() {
        Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);
        startActivity(intent);
        finish();
    }
}
