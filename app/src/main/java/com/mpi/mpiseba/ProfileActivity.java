package com.mpi.mpiseba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity {

    TextView profileName, profileEmail, profileUsername, profilePassword, profileSemister, profileDepartment, profileShift;
    TextView titleName, titleUsername;
    Button editProfile, homeButton;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        imageView=findViewById(R.id.profileImg);
        makdoom();
        profileName = findViewById(R.id.profileName);
        profileEmail = findViewById(R.id.profileEmail);
        profileUsername = findViewById(R.id.profileUsername);
        profilePassword = findViewById(R.id.profilePassword);
        profileSemister = findViewById(R.id.profileSemister);
        profileDepartment = findViewById(R.id.profileDepartment);
        profileShift = findViewById(R.id.profileShift);
        editProfile = findViewById(R.id.editButton);
        homeButton = findViewById(R.id.homeButton);

        titleName = findViewById(R.id.titleName);
        titleUsername = findViewById(R.id.titleUsername);


        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextActivity = new Intent(ProfileActivity.this, MainActivity.class);
                startActivity(nextActivity);

            }
        });


        showAllUserData();

        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passUserData();
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Uri uri=data.getData();
        imageView.setImageURI(uri);
    }
    private void makdoom() {
        DBHelper dbHelper=new DBHelper(this);
        Bitmap images= dbHelper.getImage();
        imageView.setImageBitmap(images);
    }

    public void showAllUserData(){
        Intent intent = getIntent();
        String nameUser = intent.getStringExtra("name");
        String emailUser = intent.getStringExtra("phone");
        String usernameUser = intent.getStringExtra("roll");
        String passwordUser = intent.getStringExtra("password");
        String semisterUser = intent.getStringExtra("semister");
        String departmentUser = intent.getStringExtra("department");
        String shiftUser = intent.getStringExtra("shift");

        titleName.setText(nameUser);
        titleUsername.setText(departmentUser);
        profileName.setText(nameUser);
        profileEmail.setText(emailUser);
        profileUsername.setText(usernameUser);
        profilePassword.setText(passwordUser);
        profileSemister.setText(semisterUser);
        profileShift.setText(shiftUser);
        profileDepartment.setText(departmentUser);
    }

    public void passUserData(){
        String userUsername = profileUsername.getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUserDatabase = reference.orderByChild("roll").equalTo(userUsername);

        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()){

                    String nameFromDB = snapshot.child(userUsername).child("name").getValue(String.class);
                    String emailFromDB = snapshot.child(userUsername).child("phone").getValue(String.class);
                    String usernameFromDB = snapshot.child(userUsername).child("roll").getValue(String.class);
                    String passwordFromDB = snapshot.child(userUsername).child("password").getValue(String.class);
                    String semisterFromDB = snapshot.child(userUsername).child("semister").getValue(String.class);
                    String departmentFromDB = snapshot.child(userUsername).child("department").getValue(String.class);
                    String shiftFromDB = snapshot.child(userUsername).child("shift").getValue(String.class);

                    Intent intent = new Intent(ProfileActivity.this, EditProfileActivity.class);

                    intent.putExtra("name", nameFromDB);
                    intent.putExtra("phone", emailFromDB);
                    intent.putExtra("roll", usernameFromDB);
                    intent.putExtra("password", passwordFromDB);
                    intent.putExtra("semister", semisterFromDB);
                    intent.putExtra("department", departmentFromDB);
                    intent.putExtra("shift", shiftFromDB);

                    startActivity(intent);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}