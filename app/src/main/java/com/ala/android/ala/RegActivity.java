package com.ala.android.ala;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegActivity extends AppCompatActivity {
    EditText name1,name2,name3,en1,en2,en3,mail,batch;
    Button reg;
    SharedPreferences sharedpreferences;

    public static final String MyPREFERENCES = "GroupPrefs" ;
    public static final String Name1 = "name1Key";
    public static final String Name2 = "name2Key";
    public static final String Name3 = "name3Key";
    public static final String En1 = "en1Key";
    public static final String En2 = "en2Key";
    public static final String En3 = "en3Key";
    public static final String GroupID = "groupKey";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        name1=(EditText)findViewById(R.id.name1);
        name2=(EditText)findViewById(R.id.name2);
        name3=(EditText)findViewById(R.id.name3);
        en1=(EditText)findViewById(R.id.en1);
        en2=(EditText)findViewById(R.id.en2);
        en3=(EditText)findViewById(R.id.en3);
        mail=(EditText)findViewById(R.id.email);
        batch=(EditText)findViewById(R.id.batch);
        reg=(Button)findViewById(R.id.regbutton);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor data = sharedpreferences.edit();
                data.putString(Name1,name1.getText().toString());
                data.putString(Name2,name2.getText().toString());
                data.putString(Name3,name3.getText().toString());
                data.putString(En1,en1.getText().toString());
                data.putString(En2,en2.getText().toString());
                data.putString(En3,en3.getText().toString());

                String s1,s2,s3;
                s1=en1.getText().toString();
                s2=en2.getText().toString();
                s3=en3.getText().toString();

                if(s1.length()!=12 || s2.length() !=12 || s3.length()!=12)
                {
                    Toast.makeText(getApplicationContext(),"Enter valid Enrollment no.",Toast.LENGTH_SHORT).show();
                }
                else {
                    String id=s1.substring(10)+s2.substring(10)+s3.substring(10);
                    data.putString(GroupID, id);
                    data.commit();
                    Intent up=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(up);
                }
            }
        });

    }
}
