package com.example.mohith.mquiz;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;

public class English1 extends AppCompatActivity {
 Button previous, next, main_menu;
 RadioButton r1,r2,r3,r4;

    SQLiteDatabase s;

    English2 e=new English2();
    int x=e.x;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.english1);

        previous =(Button)findViewById(R.id.button3);
        next =(Button)findViewById(R.id.button4);
        main_menu =(Button)findViewById(R.id.button5);
        r1 =(RadioButton)findViewById(R.id.radioButton2);
        r2 =(RadioButton)findViewById(R.id.radioButton4);
        r3 =(RadioButton)findViewById(R.id.radioButton3);
        r4 =(RadioButton)findViewById(R.id.radioButton);

        final Intent i=new Intent(English1.this, MainActivity.class);
        final Intent j=new Intent(English1.this, English1.class);

        s=openOrCreateDatabase("Scoretab",Context.MODE_PRIVATE,null);
        s.execSQL("CREATE TABLE IF NOT EXISTS score(English INTEGER, Maths INTEGER, Chem INTEGER, Comp INTEGER, Physics INTEGER, Bio INTEGER);");



        if(x==1) {
            previous.setBackgroundTintMode(PorterDuff.Mode.LIGHTEN);
            previous.setClickable(false);


            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    if (r1.isClickable() && r2.isClickable() && r3.isClickable() && r4.isClickable()) {
                        showbox("None of the options clicked!", "Are you sure you want to continue?", j);
                    } else {
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
                    s.execSQL("INSERT INTO score VALUES('1', 'null', 'null', 'null', 'null', 'null');");
                }
            });


            r2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    r1.setChecked(false);
                    r3.setChecked(false);
                    r4.setChecked(false);


                }
            });

            r3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    r2.setChecked(false);
                    r1.setChecked(false);
                    r4.setChecked(false);


                }
            });

            r4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    r2.setChecked(false);
                    r3.setChecked(false);
                    r1.setChecked(false);


                }
            });

        }



        else
        {
            next.setClickable(false);
            previous.setClickable(false);
            main_menu.setClickable(false);
            r1.setClickable(false);
            r2.setClickable(false);
            r3.setClickable(false);
            r4.setClickable(false);
         }
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
