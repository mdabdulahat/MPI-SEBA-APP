package com.mpi.mpiseba;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.BuildConfig;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.navigation.NavigationView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;



public class MainActivity extends AppCompatActivity {








    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;

    ImageView imageMenu;
    LinearLayout Notice;


    TextView tv,tvDate;
CardView Button1,Button2,Button3,Button4,Button5,Button6,Button7,Button8,Button9,Button10,Button11,Button12;
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,R.color.app_themecolor));

        Notice=findViewById(R.id.marqe);

        Button1=findViewById(R.id.Button1);
        Button2=findViewById(R.id.Button2);
        Button3=findViewById(R.id.Button3);
        Button4=findViewById(R.id.Button4);
        Button5=findViewById(R.id.Button5);
        Button6=findViewById(R.id.Button6);
        Button7=findViewById(R.id.Button7);
        Button8=findViewById(R.id.Button8);
        Button9=findViewById(R.id.Button9);
        Button10=findViewById(R.id.Button10);
        Button11=findViewById(R.id.Button11);
        Button12=findViewById(R.id.Button12);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if (!prefs.getBoolean("firstTime", false)) {
            DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which) {
                        case DialogInterface.BUTTON_POSITIVE:
                            break;

                        case DialogInterface.BUTTON_NEGATIVE:
                            Intent intent = new Intent(MainActivity.this, SignupActivity.class);
                            startActivity(intent);
                            break;
                    }
                }
            };
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("আপনি কি ”ময়মনসিংহ পলিটেকনিক” অ্যাপস এ ছাত্র প্রোফাইল করেছেন? যদি না করে থাকেন তাহলে ‘না’ দিয়ে সঠিক তথ্য দিয়ে করে নিন। আর করে থাকেলে ‘হ্যা’ দিন। ").setPositiveButton("হ্যা", dialogClickListener)
                    .setNegativeButton("না", dialogClickListener).show();
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("firstTime", true);
            editor.commit();
        }



        /*
//===============================PUSH NOTIFICATION=====================================//

        // Enable verbose OneSignal logging to debug issues if needed.
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);

        // OneSignal Initialization
        OneSignal.initWithContext(this);
        OneSignal.setAppId(ONESIGNAL_APP_ID);

        // promptForPushNotifications will show the native Android notification permission prompt.
        // We recommend removing the following code and instead using an In-App Message to prompt for notification permission (See step 7)
        OneSignal.promptForPushNotifications();



        //===========================================================================//
*/


        tv = (TextView) this.findViewById(R.id.mywidget);
        tv.setSelected(true);  // Set focus to the textview

        tvDate=findViewById(R.id.tvDate);
        //Set Date For Cover Section
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yy", Locale.US);
        formatter.setTimeZone(TimeZone.getDefault());
        Date date1 = new Date();
        String s_date = formatter.format(date1);
        tvDate.setText(s_date);

//=====================================navigation drawer=======================================//




        // Navagation Drawar------------------------------

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_View);
        imageMenu = findViewById(R.id.imageMenu);


        toggle = new ActionBarDrawerToggle(MainActivity.this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Drawar click event
        // Drawer item Click event ------
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.Developer:
                        Intent nextActivity = new Intent(MainActivity.this, Developer.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("VAL", 100);
                        nextActivity.putExtras(bundle);
                        startActivity(nextActivity);

                        drawerLayout.closeDrawers();
                        break;


                    case R.id.mAbout:
                        Intent nextActivity1 = new Intent(MainActivity.this, About_app.class);
                        Bundle bundle1 = new Bundle();
                        bundle1.putInt("VAL", 0);
                        nextActivity1.putExtras(bundle1);
                        startActivity(nextActivity1);

                        drawerLayout.closeDrawers();
                        break;


                    case R.id.Login:
                        Intent nextActivity2 = new Intent(MainActivity.this, LoginActivity.class);
                        Bundle bundle2 = new Bundle();
                        bundle2.putInt("VAL", 0);
                        nextActivity2.putExtras(bundle2);
                        startActivity(nextActivity2);

                        drawerLayout.closeDrawers();
                        break;

                    case R.id.registation:
                        Intent nextActivity3 = new Intent(MainActivity.this, SignupActivity.class);
                        Bundle bundle3 = new Bundle();
                        bundle3.putInt("VAL", 0);
                        nextActivity3.putExtras(bundle3);
                        startActivity(nextActivity3);

                        drawerLayout.closeDrawers();
                        break;


                    case R.id.account:
                        Intent nextActivity4 = new Intent(MainActivity.this, LoginActivity.class);
                        Bundle bundle4 = new Bundle();
                        bundle4.putInt("VAL", 0);
                        nextActivity4.putExtras(bundle4);
                        startActivity(nextActivity4);

                        drawerLayout.closeDrawers();
                        break;



                    case R.id.privecy:
                        Intent nextActivity5 = new Intent(MainActivity.this, Privecy.class);
                        Bundle bundle5 = new Bundle();
                        bundle5.putInt("VAL", 0);
                        nextActivity5.putExtras(bundle5);
                        startActivity(nextActivity5);
                        drawerLayout.closeDrawers();
                        break;

                        


                    case R.id.jobFind:
                        try {
                            Web_browser.WEBSITE_LINK="https://www.bdjobs.com/";
                            Web_browser.WEBSITE_TITLE="Find Jobs";
                            Intent myIntent=new Intent(MainActivity.this,Web_browser.class);
                            startActivity(myIntent);
                        }catch (ActivityNotFoundException e){
                            Web_browser.WEBSITE_LINK="https://www.bdjobs.com/";
                            Web_browser.WEBSITE_TITLE="Find Jobs";
                            Intent myIntent=new Intent(MainActivity.this,Web_browser.class);
                            startActivity(myIntent);
                        }
                        drawerLayout.closeDrawers();
                        break;


                    case R.id.website:

                        try {
                            Web_browser.WEBSITE_LINK="https://mpi.polytech.gov.bd/";
                            Web_browser.WEBSITE_TITLE="MPI Officel Site";
                            Intent myIntent=new Intent(MainActivity.this,Web_browser.class);
                            startActivity(myIntent);
                        }catch (ActivityNotFoundException e){
                            Web_browser.WEBSITE_LINK="https://mpi.polytech.gov.bd/";
                            Web_browser.WEBSITE_TITLE="MPI Officel Site";
                            Intent myIntent=new Intent(MainActivity.this,Web_browser.class);
                            startActivity(myIntent);
                        }
                        drawerLayout.closeDrawers();
                        break;


                    case R.id.facebook:

                        try {
                            Web_browser.WEBSITE_LINK="https://www.facebook.com/mpimymen";
                            Web_browser.WEBSITE_TITLE="MPI Officel Page";
                            Intent myIntent=new Intent(MainActivity.this,Web_browser.class);
                            startActivity(myIntent);
                        }catch (ActivityNotFoundException e){
                            Web_browser.WEBSITE_LINK="https://www.facebook.com/mpimymen";
                            Web_browser.WEBSITE_TITLE="MPI Officel Page";
                            Intent myIntent=new Intent(MainActivity.this,Web_browser.class);
                            startActivity(myIntent);
                        }
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.youtube:

                        try {
                            Web_browser.WEBSITE_LINK="https://www.youtube.com/@MymensinghPolytechnicInstitute";
                            Web_browser.WEBSITE_TITLE="MPI Officel Chanel";
                            Intent myIntent=new Intent(MainActivity.this,Web_browser.class);
                            startActivity(myIntent);
                        }catch (ActivityNotFoundException e){
                            Web_browser.WEBSITE_LINK="https://www.youtube.com/@MymensinghPolytechnicInstitute";
                            Web_browser.WEBSITE_TITLE="MPI Officel Chanel";
                            Intent myIntent=new Intent(MainActivity.this,Web_browser.class);
                            startActivity(myIntent);
                        }
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.viewresult:

                        try {
                            Web_browser.WEBSITE_LINK="https://btebresulthub.vercel.app/results";
                            Web_browser.WEBSITE_TITLE="Individual Result Check";
                            Intent myIntent=new Intent(MainActivity.this,Web_browser.class);
                            startActivity(myIntent);
                        }catch (ActivityNotFoundException e) {
                            Web_browser.WEBSITE_LINK = "https://btebresulthub.vercel.app/results";
                            Web_browser.WEBSITE_TITLE = "Individual Result Check";
                            Intent myIntent = new Intent(MainActivity.this, Web_browser.class);
                            startActivity(myIntent);
                        }

                        drawerLayout.closeDrawers();
                        break;




                   case R.id.mRate:

                       try {
                           Uri uri = Uri.parse("market://details?id="+getPackageName()+"");
                           Intent goMarket = new Intent(Intent.ACTION_VIEW, uri);
                           startActivity(goMarket);
                       }catch (ActivityNotFoundException e){
                           Uri uri = Uri.parse("https://play.google.com/store/apps/details?id="+getPackageName()+"");
                           Intent goMarket = new Intent(Intent.ACTION_VIEW, uri);
                           startActivity(goMarket);
                       }
                       drawerLayout.closeDrawers();
                       break;



                    case R.id.mShare:

                        try {
                            Intent shareIntent = new Intent(Intent.ACTION_SEND);
                            shareIntent.setType("text/plain");
                            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name");
                            String shareMessage= "\nLet me recommend you this application\n\n";
                            shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.BUILD_TYPE +"\n\n";
                            shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                            startActivity(Intent.createChooser(shareIntent, "choose one"));
                        } catch(Exception e) {
                            //e.toString();
                        }
                        drawerLayout.closeDrawers();
                        break;


                    case R.id.mExit:

                        new AlertDialog.Builder(MainActivity.this).setIcon(R.drawable.warning).setTitle("বাহির!")
                                .setMessage("আপনি কি বের হতে চান?")
                                .setPositiveButton("হ্যাঁ", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                        Intent intent = new Intent(Intent.ACTION_MAIN);
                                        intent.addCategory(Intent.CATEGORY_HOME);
                                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(intent);

                                    }
                                }).setNegativeButton("না", null).show();

                        drawerLayout.closeDrawers();
                        break;

                }
                return false;
            }

        });
        //------------------------------

        // ------------------------
        // App Bar Click Event
        imageMenu = findViewById(R.id.imageMenu);

        imageMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Code Here
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });


        // ------------------------





        //====================end=======================================================//
        //===========Image Slider=========================//



        ImageSlider imageSlider;


        imageSlider =findViewById(R.id.image_slider);

        ArrayList<SlideModel> imageList = new ArrayList<>();


        imageList.add(new SlideModel(R.drawable.mym, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.student, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.rubat, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.rubat2, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner1, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner2,ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner3,ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner4,ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner5,ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner7, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner8,ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner9,ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner10,ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner11,ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner12, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner13,ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner14,ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner15,ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner16,ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner17, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner18,ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner19,ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner20,ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner21,ScaleTypes.FIT));



        imageSlider.setImageList(imageList);


        //==================end==================================//


        Notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Web_browser.WEBSITE_LINK="https://bteb.gov.bd/site/view/notices";
                Web_browser.WEBSITE_TITLE="সকল নোটিশ";
                Intent myIntent=new Intent(MainActivity.this,Web_browser.class);
                startActivity(myIntent);

            }
        });


        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Button 1
                Intent nextActivity = new Intent(MainActivity.this, Information.class);
                startActivity(nextActivity);

            }
        });

        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Button 1
                Intent nextActivity = new Intent(MainActivity.this, Service_2.class);
                startActivity(nextActivity);

            }
        });


        Button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Button 1
                Intent nextActivity = new Intent(MainActivity.this, Service_3.class);
                startActivity(nextActivity);

            }
        });

        Button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Button 1
                Intent nextActivity = new Intent(MainActivity.this, Service_4.class);
                startActivity(nextActivity);

            }
        });


        Button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Button 1
                Intent nextActivity = new Intent(MainActivity.this, Service_5.class);
                startActivity(nextActivity);

            }
        });

        Button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Button 1
                Intent nextActivity = new Intent(MainActivity.this, Service_6.class);

                startActivity(nextActivity);
            }
        });


        Button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Button 1
                Intent nextActivity = new Intent(MainActivity.this, Service_7.class);

                startActivity(nextActivity);
            }
        });


        Button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Button 1
                Intent nextActivity = new Intent(MainActivity.this, Service_8.class);
                startActivity(nextActivity);
            }
        });
        Button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Button 1
                Intent nextActivity = new Intent(MainActivity.this, Service_9.class);
                startActivity(nextActivity);
            }
        });
        Button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Button 1
                Intent nextActivity = new Intent(MainActivity.this, Service_10.class);
                startActivity(nextActivity);
            }
        });

        Button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextActivity = new Intent(MainActivity.this, Rubat.class);
                startActivity(nextActivity);
            }
        });

        Button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextActivity = new Intent(MainActivity.this, allCaptain.class);
                startActivity(nextActivity);
            }
        });


    }






    //................................back presses exit======================================//

    ///====================================================
    private static final int TIME_INTERVAL = 2000; // # milliseconds, desired
    private long mBackPressed;

    // When user click bakpress button this method is called
    @Override
    public void onBackPressed() {
        // When user press back button

        super.onBackPressed();
        if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis()) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);

        } else {

            Toast.makeText(getBaseContext(), "Press again to exit",
                    Toast.LENGTH_SHORT).show();
        }

        mBackPressed = System.currentTimeMillis();


    } // end of onBackpressed method

    //#############################################################################################





}