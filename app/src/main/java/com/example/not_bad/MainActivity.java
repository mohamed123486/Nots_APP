package com.example.not_bad;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.not_bad.Adbter.AD;
import com.example.not_bad.DataBase.Data_Acsess;
import com.example.not_bad.DataBase.model;
import com.example.not_bad.Manger.Manger;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AD.in {
   private RecyclerView res;
   private AD ad;
   private ArrayList<model> ll=new ArrayList<>();
   private FloatingActionButton add;
  private   Toolbar tool;
  int id;
  Manger manger;
   private Data_Acsess a;
   AD.in i;
   public  static String id_itemRes="id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a = Data_Acsess.instans(getApplicationContext());
        add = findViewById(R.id.add);
        manger=new Manger(this);
        res = findViewById(R.id.res);
        tool = findViewById(R.id.tool);
        setSupportActionBar(tool);
        a.open();
        ll.add(new model("عن التطبيق","تم ان شاء هذا الطتبيق يوم الحد الموافق 28/5/2023 "));
        ll.addAll(a.getall());
        a.close();
        ad = new AD(ll);
        res.setLayoutManager(new LinearLayoutManager(this));
        res.setAdapter(ad);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Add_Nots.class);
                l.launch(i);

            }
        });
    }
    ActivityResultLauncher<Intent> l = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode()==RESULT_OK) {
                Toast.makeText(getApplicationContext(), "تمت الاضافه", Toast.LENGTH_SHORT).show();
                a.open();
                ll.clear();
                ll.addAll(a.getall());
                ad.notifyDataSetChanged();
                a.close();
            }
            else if(result.getResultCode()==20){
                a.open();
                ll.clear();
                ll.addAll(a.getall());
                ad.notifyDataSetChanged();
                a.close();

            }else  if(result.getResultCode()==30){
                a.open();
                ll.clear();
                ll.addAll(a.getall());
                ad.notifyDataSetChanged();
                a.close();
            }

        }
    });

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v    , ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.mn,menu);

    }
    @Override
    public void item_Menu(View v,model p) {
        registerForContextMenu(v);
    }

    @Override
    public void item_id(int id) {
        Intent i=new Intent(getApplicationContext(),Add_Nots.class);
        i.putExtra("id", id);
        l.launch(i);

    }

    @Override
    public void lil(model m) {
        if (m.isLiked()){
            manger.savejoks(m);

        }else {
            manger.del(m);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item)  {
        switch (item.getItemId()){
            case R.id.del:
                switch (item.getItemId()) {
                    case R.id.del:
                        Toast.makeText(this, "Sorry this option not work right now", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.Edit:
                        Toast.makeText(this, "Sorry this option not work right now", Toast.LENGTH_SHORT).show();
                        break;
                }



                //Toast.makeText(this, "Sorry this option not work right now", Toast.LENGTH_SHORT).show();
                break;
            case R.id.Edit:
                Toast.makeText(this, "Sorry this option not work right now", Toast.LENGTH_SHORT).show();break;
        }
        return true;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.op,menu);
        return true;
    }
    // المنوي انا كنت عامل البرنامج بحيث اني لما اضغط علي الزرار يخليلي النوتس في المفضله بس انا شيلتهاه

//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        startActivity(new Intent(getApplicationContext(),MainActivity2.class));
//        return super.onOptionsItemSelected(item);
//    }
}
