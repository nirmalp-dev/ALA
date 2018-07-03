package com.ala.android.ala;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegActivity extends AppCompatActivity {
    EditText name1,name2,name3;
    Button reg;
    SharedPreferences sharedpreferences;

    public static final String MyPREFERENCES = "GroupPrefs" ;
    public static final String Name1 = "name1Key";
    public static final String Name2 = "name2Key";
    public static final String Name3 = "name3Key";
    public static final String GroupID = "groupKey";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        name1=(EditText)findViewById(R.id.name1);
        name2=(EditText)findViewById(R.id.name2);
        name3=(EditText)findViewById(R.id.name3);
        reg=(Button)findViewById(R.id.regbutton);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor data = sharedpreferences.edit();
                data.putString(Name1,name1.getText().toString());
                data.putString(Name2,name2.getText().toString());
                data.putString(Name3,name3.getText().toString());
                data.putString(GroupID,"Group 1");
                data.commit();
            }
        });

    }
}
