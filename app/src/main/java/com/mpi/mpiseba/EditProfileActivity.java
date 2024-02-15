package com.mpi.mpiseba;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.ByteArrayOutputStream;

public class
EditProfileActivity extends AppCompatActivity {

    EditText editName, editEmail, editUsername, editPassword, editSemister, editDepartment, editshift;
    Button saveButton,button;
    String nameUser, emailUser, usernameUser, passwordUser, semisterUser, departmentUser, shiftUser;
    ImageView image;
    boolean angu=false;
    DatabaseReference reference;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        image=findViewById(R.id.khonfa);
        button=findViewById(R.id.profileupload);
        reference = FirebaseDatabase.getInstance().getReference("users");
        button.setOnClickListener(v->{
            angu=true;
            ImagePicker.with(this)
                    .crop()
                    .compress(1024)
                    .maxResultSize(1080, 1080)
                    .start();
            image.setVisibility(View.VISIBLE);
        });
        editName = findViewById(R.id.editName);
        editEmail = findViewById(R.id.editEmail);
        editUsername = findViewById(R.id.editUsername);
        editPassword = findViewById(R.id.editPassword);
        editSemister = findViewById(R.id.editSemister);
        editDepartment = findViewById(R.id.editDepartment);
        editshift = findViewById(R.id.editShift);

        saveButton = findViewById(R.id.saveButton);

        showData();

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databasess();
                if (angu || isNameChanged() || isPasswordChanged() || isEmailChanged() || isSemisterChanged() || isDepartmentChanged() || isShiftChanged()){
                    Toast.makeText(EditProfileActivity.this, "Saved", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(EditProfileActivity.this, "No Changes Found", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isNameChanged() {
        if (!nameUser.equals(editName.getText().toString())){
            reference.child(usernameUser).child("name").setValue(editName.getText().toString());
            nameUser = editName.getText().toString();
            return true;
        } else {
            return false;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Uri uri=data.getData();
        image.setImageURI(uri);
    }
    private void databasess() {
        DBHelper dbHelper=new DBHelper(this);
        Bitmap bitmap = ((BitmapDrawable) image.getDrawable()).getBitmap();
        dbHelper.insertImage(bitmap);
    }

    private boolean isEmailChanged() {
        if (!emailUser.equals(editEmail.getText().toString())){
            reference.child(usernameUser).child("phone").setValue(editEmail.getText().toString());
            emailUser = editEmail.getText().toString();
            return true;
        } else {
            return false;
        }
    }


    private boolean isPasswordChanged() {
        if (!passwordUser.equals(editPassword.getText().toString())){
            reference.child(usernameUser).child("password").setValue(editPassword.getText().toString());
            passwordUser = editPassword.getText().toString();
            return true;
        } else {
            return false;
        }
    }

    private boolean isSemisterChanged() {
        if (!semisterUser.equals(editSemister.getText().toString())) {
            reference.child(semisterUser).child("semister").setValue(editSemister.getText().toString());
            semisterUser = editSemister.getText().toString();
            return true;
        } else {
            return false;
        }
    }

    private boolean isDepartmentChanged() {
        if (!departmentUser.equals(editDepartment.getText().toString())) {
            reference.child(departmentUser).child("department").setValue(editDepartment.getText().toString());
            departmentUser = editDepartment.getText().toString();
            return true;
        } else {
            return false;
        }
    }

    private boolean isShiftChanged() {
        if (!shiftUser.equals(editshift.getText().toString())) {
            reference.child(shiftUser).child("shift").setValue(editshift.getText().toString());
            shiftUser = editshift.getText().toString();
            return true;
        } else {
            return false;
        }
    }

    public void showData(){

        Intent intent = getIntent();

        nameUser = intent.getStringExtra("name");
        emailUser = intent.getStringExtra("phone");
        usernameUser = intent.getStringExtra("roll");
        passwordUser = intent.getStringExtra("password");
        semisterUser = intent.getStringExtra("semister");
        departmentUser = intent.getStringExtra("department");
        shiftUser = intent.getStringExtra("shift");

        editName.setText(nameUser);
        editEmail.setText(emailUser);
        editUsername.setText(usernameUser);
        editPassword.setText(passwordUser);
        editSemister.setText(semisterUser);
        editDepartment.setText(departmentUser);
        editshift.setText(shiftUser);
    }
}
