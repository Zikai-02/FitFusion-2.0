package com.example.fitfusion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class   Nutrition extends AppCompatActivity {

    private Button Back;
    private EditText editText1, editText2, editText3;
    private FloatingActionButton saveButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition);
        editText1=(EditText)findViewById(R.id.proteinView);
        editText1.setText(Open("Note3.txt"));
        editText2=(EditText)findViewById(R.id.carbsView);
        editText2.setText(Open2("Note4.txt"));
        editText3=(EditText)findViewById(R.id.fatsView);
        editText3.setText(Open3("Note5.txt"));

        saveButton = (FloatingActionButton) findViewById(R.id.nutritionsavebutton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // When saveButton is clicked, "Save" function is called.
                Save("Note3.txt");
                Save2("Note4.txt");
                Save3("Note5.txt");
            }
        });

        //assign button to XML ID
        Back = (Button)findViewById(R.id.backButton);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //intent basically used to go from one activity to another
                //source and destination parameters, .this for source and .class for destination
                Intent backIntent = new Intent(Nutrition.this, SecondActivity.class);
                startActivity(backIntent);
            }
        });

    }
    public void Save(String fileName) {
        try {
            OutputStreamWriter out =
                    new OutputStreamWriter(openFileOutput(fileName, 0));
            out.write(editText1.getText().toString());
            out.close();
            // A toast is a view containing a quick little message for the user.
            Toast.makeText(this, "Note Saved!", Toast.LENGTH_SHORT).show();
        } catch (Throwable t) {
            Toast.makeText(this, "Exception: " + t.toString(), Toast.LENGTH_LONG).show();
        }
    }public void Save2(String fileName2) {
        try {
            OutputStreamWriter out =
                    new OutputStreamWriter(openFileOutput(fileName2, 0));
            out.write(editText2.getText().toString());
            out.close();

            Toast.makeText(this, "Note Saved!", Toast.LENGTH_SHORT).show();
        } catch (Throwable t) {
            Toast.makeText(this, "Exception: " + t.toString(), Toast.LENGTH_LONG).show();
        }
    }
    public void Save3(String fileName3) {
        try {
            OutputStreamWriter out =
                    new OutputStreamWriter(openFileOutput(fileName3, 0));
            out.write(editText3.getText().toString());
            out.close();
            // A toast is a view containing a quick little message for the user.
            Toast.makeText(this, "Note Saved!", Toast.LENGTH_SHORT).show();
        } catch (Throwable t) {
            Toast.makeText(this, "Exception: " + t.toString(), Toast.LENGTH_LONG).show();
        }
    }
    public String Open(String fileName) {
        String content = "";
        if (FileExists(fileName)) {
            try {
                InputStream in = openFileInput(fileName);
                if ( in != null) {
                    InputStreamReader tmp = new InputStreamReader( in );
                    BufferedReader reader = new BufferedReader(tmp);
                    String str;
                    StringBuilder buf = new StringBuilder();
                    while ((str = reader.readLine()) != null) {
                        buf.append(str + "\n");
                    } in .close();
                    content = buf.toString();
                }
            } catch (java.io.FileNotFoundException e) {} catch (Throwable t) {
                Toast.makeText(this, "Exception: " + t.toString(), Toast.LENGTH_LONG).show();
            }
        }
        return content;
    }
    public String Open2(String fileName2) {
        String content = "";
        if (FileExists2(fileName2)) {
            try {
                InputStream in = openFileInput(fileName2);
                if ( in != null) {
                    InputStreamReader tmp = new InputStreamReader( in );
                    BufferedReader reader = new BufferedReader(tmp);
                    String str;
                    StringBuilder buf = new StringBuilder();
                    while ((str = reader.readLine()) != null) {
                        buf.append(str + "\n");
                    } in .close();
                    content = buf.toString();
                }
            } catch (java.io.FileNotFoundException e) {} catch (Throwable t) {
                Toast.makeText(this, "Exception: " + t.toString(), Toast.LENGTH_LONG).show();
            }
        }
        return content;
    }
    public String Open3(String fileName3) {
        String content = "";
        if (FileExists3(fileName3)) {
            try {
                InputStream in = openFileInput(fileName3);
                if ( in != null) {
                    InputStreamReader tmp = new InputStreamReader( in );
                    BufferedReader reader = new BufferedReader(tmp);
                    String str;
                    StringBuilder buf = new StringBuilder();
                    while ((str = reader.readLine()) != null) {
                        buf.append(str + "\n");
                    } in .close();
                    content = buf.toString();
                }
            } catch (java.io.FileNotFoundException e) {} catch (Throwable t) {
                Toast.makeText(this, "Exception: " + t.toString(), Toast.LENGTH_LONG).show();
            }
        }
        return content;
    }

    public boolean FileExists(String fname){
        File file = getBaseContext().getFileStreamPath(fname);
        return file.exists();
    }
    public boolean FileExists2(String fname){
        File file = getBaseContext().getFileStreamPath(fname);
        return file.exists();
    }   public boolean FileExists3(String fname){
        File file = getBaseContext().getFileStreamPath(fname);
        return file.exists();
    }
}