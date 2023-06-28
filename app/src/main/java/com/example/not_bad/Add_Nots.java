package com.example.not_bad;

import static com.example.not_bad.MainActivity.id_itemRes;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.not_bad.DataBase.Data_Acsess;
import com.example.not_bad.DataBase.model;
import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Add_Nots extends AppCompatActivity {
    TextInputEditText title,msg;
    Data_Acsess a=Data_Acsess. instans(this);
    Button add,Edit,Delete,save;
    int id;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_nots);
        title=findViewById(R.id.title);
        add=findViewById(R.id.add);
        Edit=findViewById(R.id.Edit);
        save=findViewById(R.id.save);
        save.setVisibility(View.GONE);
        Delete=findViewById(R.id.Delete);
        msg=findViewById(R.id.msg);
        Data_Acsess d=Data_Acsess.instans(this);
        Intent i=getIntent();
        String t=title.getText().toString();
        String ms=msg.getText().toString();
        id=i.getIntExtra(id_itemRes,-1);
        if (id!=-1){
            add.setVisibility(View.GONE);
            title.setEnabled(false);
            msg.setEnabled(false);

            d.open();
           model  m= d.getone(id);
            d.close();
           if (m!=null) {
               title.setText(m.getTitel());
               msg.setText(m.getMsg());
           }
        }else {
            Edit.setVisibility(View.GONE);
            Delete.setVisibility(View.GONE);
        }

        add.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View v) {
                ins();
                setResult(RESULT_OK);
                finish();
            }
        });
        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a.open();
              model m=new model(id,null,null,null);
                a.del(m);
                a.close();
                setResult(20);
                finish();
            }
        });
        Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Delete.setVisibility(View.GONE);
                Edit.setVisibility(View.GONE);
                save.setVisibility(View.VISIBLE);
                title.setEnabled(true);
                msg.setEnabled(true);
                a.open();
              model p = new model(id,t,ms);
                a.update(p);
                a.close();
                setResult(30);
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String to=title.getText().toString();
                String mso=msg.getText().toString();
                a.open();
                model p = new model(id,to,mso);
                a.update(p);
                a.close();
                setResult(30);
                finish();
            }
        });
    }

    public void ins(){
        a.open();
        String t=title.getText().toString();
        String ms=msg.getText().toString();
        model m=new model(id,t,ms);
        a.insert(m);
        a.close();
    }
}