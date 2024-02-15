package com.mpi.mpiseba;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.ByteArrayOutputStream;

public class SignupActivity extends AppCompatActivity {

    private boolean passwordShowing = false;

    EditText signupName, signupUsername, signupEmail, signupPassword, signupSemister, signupDepartment, signupShift;
    TextView loginRedirectText;
    Button signupButton;
    FirebaseDatabase database;
    ImageView image;
    Button button;
    DatabaseReference reference;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        image=findViewById(R.id.khonfa);
        button=findViewById(R.id.profileupload);
        button.setOnClickListener(v->{
            ImagePicker.with(this)
                    .crop()
                    .compress(1024)
                    .maxResultSize(1080, 1080)
                    .start();
            image.setVisibility(View.VISIBLE);
        });
        final ImageView passwordIcon = findViewById(R.id.passwordIcon);
        final EditText signup_password = findViewById(R.id.signup_password);

        passwordIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passwordShowing){
                    passwordShowing = false;

                    signup_password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    passwordIcon.setImageResource(R.drawable.password_show);
                }
                else {
                    passwordShowing = true;
                    signup_password.setInputType((InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD));
                    passwordIcon.setImageResource(R.drawable.password_hidden);
                }

                signup_password.setSelection(signup_password.length());
            }
        });



        signupName = findViewById(R.id.signup_name);
        signupEmail = findViewById(R.id.signup_email);
        signupUsername = findViewById(R.id.signup_username);
        signupPassword = findViewById(R.id.signup_password);
        loginRedirectText = findViewById(R.id.loginRedirectText);
        signupButton = findViewById(R.id.signup_button);
        signupSemister = findViewById(R.id.signup_semister);
        signupDepartment = findViewById(R.id.signup_department);
        signupShift = findViewById(R.id.signup_shift);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                chekCrededentials();
                databasess();
            }
        });


        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void databasess() {
        DBHelper dbHelper=new DBHelper(this);
        Bitmap bitmap = ((BitmapDrawable) image.getDrawable()).getBitmap();
        dbHelper.insertImage(bitmap);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Uri uri=data.getData();
        image.setImageURI(uri);
    }

    private void chekCrededentials() {
        String name = signupName.getText().toString();
        String email = signupEmail.getText().toString();
        String username = signupUsername.getText().toString();
        String password = signupPassword.getText().toString();
        String semister = signupSemister.getText().toString();
        String department = signupDepartment.getText().toString();
        String shift = signupShift.getText().toString();

        if (username.isEmpty() || username.length()<6)
        {
            showError(signupUsername,"Your roll is not valid!");
        }
        else if (password.isEmpty() || password.length()<4)
        {
            showError(signupPassword,"Password must be 4 Character");
        }
        else
        {

            database = FirebaseDatabase.getInstance();
            reference = database.getReference("users");

            HelperClass helperClass = new HelperClass(name, email, username, password, semister, department, shift);
            reference.child(username).setValue(helperClass);

            Toast.makeText(SignupActivity.this, "You have signup successfully!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(SignupActivity.this, SucsesPage.class);
            startActivity(intent);
        }

    }

    private void showError(EditText input, String r) {
        signupUsername.setError(r);
        input.setError(r);
        input.requestFocus();
    }


}