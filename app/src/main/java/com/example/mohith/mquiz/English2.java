package com.example.mohith.mquiz;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;

public class English2 extends AppCompatActivity {
 Button previous, next, main_menu;
 RadioButton r1,r2,r3,r4;

    int x=1;



    SQLiteDatabase s;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.english2);

        previous = (Button) findViewById(R.id.button3);
        next = (Button) findViewById(R.id.button4);
        main_menu = (Button) findViewById(R.id.button5);
        r1 = (RadioButton) findViewById(R.id.radioButton2);
        r2 = (RadioButton) findViewById(R.id.radioButton4);
        r3 = (RadioButton) findViewById(R.id.radioButton3);
        r4 = (RadioButton) findViewById(R.id.radioButton);

        final Intent i = new Intent(English2.this, MainActivity.class);
        final Intent j = new Intent(English2.this, English3.class);

        s=openOrCreateDatabase("Scoretab",Context.MODE_PRIVATE,null);
        String query= "SELECT FROM * "
        Cursor c= s.rawQuery("Scoretab",)


        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (s.) {



                }
            }
        });


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //int z=e.z;
                //if(z==1)z=1;

                if (r1.isClickable() && r2.isClickable() && r3.isClickable() && r4.isClickable()) {
                    showmessage("None of the options clicked!", "Are you sure you want to continue?", j);
                } else {
                    x = 1;
                    startActivity(j);
                }

            }
        });

        main_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showmessage("WARNING!", "Are you sure you want to continue?", i);
            }
        });

        r1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                r2.setChecked(false);
                r3.setChecked(false);
                r4.setChecked(false);
                x = 1;
                et.putString("English2", String.valueOf(x));
                et.commit();
            }
        });


        r2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                r1.setChecked(false);
                r3.setChecked(false);
                r4.setChecked(false);
                x = 1;
                et.putString("English2", String.valueOf(x));
                et.commit();

            }
        });

        r3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                r2.setChecked(false);
                r1.setChecked(false);
                r4.setChecked(false);
                x = 1;
                et.putString("English2", String.valueOf(x));
                et.commit();
            }
        });

        r4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                r2.setChecked(false);
                r3.setChecked(false);
                r1.setChecked(false);
                x = 1;
                et.putString("English2", String.valueOf(x));
                et.commit();
            }
        });

    }


    void showbox(String title, String message, final Intent intent)
    {
        AlertDialog.Builder a=new AlertDialog.Builder(getApplicationContext());
        a.setTitle(title);
        a.setMessage(message);
        a.setIcon(R.mipmap.warning);
        a.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"Redirecting...",Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
        a.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }

        });
        a.show();


    }

    void showmessage(String title, String message, final Intent intent)
    {
        AlertDialog.Builder a=new AlertDialog.Builder(getApplicationContext());
        a.setTitle(title);
        a.setMessage(message);
        a.setIcon(R.mipmap.clown);
        a.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"Redirecting...",Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
        a.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }

        });
        a.show();


    }


}
