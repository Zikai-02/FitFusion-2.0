package com.example.fitfusion;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    // Declaring variables.
    private Button Nutrition;
    private Button Workout;
    private Button Notes;
    private Button Timer;
    private Button Stopwatch;
    private ImageView developerImageView,aboutImageView;
    private FloatingActionButton Logout;
    private AlertDialog.Builder alartDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        developerImageView=(ImageView)findViewById(R.id.developerImageViewId);
        aboutImageView=(ImageView)findViewById(R.id.aboutImageViewId);
        developerImageView.setOnClickListener(this);
        aboutImageView.setOnClickListener(this);

        // Assigning variables to ID's defined in XML layout
        Nutrition = (Button)findViewById(R.id.btnNutrition);
        Workout = (Button)findViewById(R.id.btnWorkout);
        Notes = (Button)findViewById(R.id.btnNotes);
        Timer = (Button)findViewById(R.id.btnTimer);
        Logout = (FloatingActionButton)findViewById(R.id.btnLogout);
        Stopwatch = (Button)findViewById(R.id.btnStopwatch);

        // Setting listeners for buttons:
        Nutrition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent basically used to go from one activity to another.
                // Source and destination parameters, .this for source and .class for destination.
                Intent nutritionIntent = new Intent(SecondActivity.this, Nutrition.class);
                startActivity(nutritionIntent);
            }
        });

        // Clicking workout button will redirect user to Workout activity.
        Workout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent workoutIntent = new Intent(SecondActivity.this, Workout.class);
                startActivity(workoutIntent);
            }
        });

        // Clicking Notes button will redirect user to Notes activity.
        Notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent notesIntent = new Intent(SecondActivity.this, Notes.class);
                startActivity(notesIntent);
            }
        });

        // Clicking Timer button will redirect user to Timer activity.
        Timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent timerIntent = new Intent(SecondActivity.this, Timer.class);
                startActivity(timerIntent);
            }
        });

        // Clicking Stopwatch button will redirect user to Stopwatch activity.
        Stopwatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent stopwatchIntent = new Intent(SecondActivity.this, Stopwatch.class);
                startActivity(stopwatchIntent);
            }
        });

        // Clicking the top right logout button brings user to Login screen.
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                alartDialog = new AlertDialog.Builder(SecondActivity.this);
                alartDialog.setTitle("FIT FUSION");
                alartDialog.setMessage("Do you want to log out?");
                alartDialog.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(SecondActivity.this,MainActivity.class);
                        finish();
                        startActivity(intent);

                    }
                });
                alartDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(SecondActivity.this,"You have clicked on no button.",Toast.LENGTH_SHORT).show();

                    }
                });
                alartDialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(SecondActivity.this,"You have clicked on cancel button.",Toast.LENGTH_SHORT).show();
                    }
                });

                AlertDialog alertDialog = alartDialog.create();
                alertDialog.show();

            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.developerImageViewId){
            alartDialog = new AlertDialog.Builder(SecondActivity.this);
            alartDialog.setTitle("Assembled By");
            alartDialog.setMessage(R.string.developer);
            alartDialog.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            AlertDialog alertDialog = alartDialog.create();
            alartDialog.show();
        } else if (v.getId()==R.id.aboutImageViewId) {
            alartDialog = new AlertDialog.Builder(SecondActivity.this);
            alartDialog.setTitle("About Fit Fusion (1.0)");
            alartDialog.setMessage(R.string.about);
            alartDialog.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            AlertDialog alertDialog = alartDialog.create();
            alartDialog.show();
        }
    }
}