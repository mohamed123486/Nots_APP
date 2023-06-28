package com.example.not_bad.Manger;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.not_bad.DataBase.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Manger {

    Context context;
    SharedPreferences preference;
    public Manger(Context context){
        this.context=context;
        preference= context.getSharedPreferences("ok",Context.MODE_PRIVATE);

    }
    //علي شان احفظ الجوك
    public void savejoks(model cardModel){
        SharedPreferences.Editor editor=preference.edit();
        editor.putBoolean(cardModel.getMsg(),cardModel.isLiked());
        editor.apply();

    }
    //علي شان احذف الجوك
    public void  del(model cardModel){
        if (preference.contains(cardModel.getMsg())){   //الكود دع معناه اني البريفرنس لو جواهاه الي انا حاطه جوه ده
            SharedPreferences.Editor editor=preference.edit();
            editor.remove(cardModel.getMsg()).commit();
        }

    }
    public List<model> retriv(){

        Map<String,?> data=preference.getAll();// انا بعمل اكسس علي جميع البيانات الي في الشيرد برفرنس
        List<model>cardModels=new ArrayList<>();
        for (Map.Entry<String,?>entry:data.entrySet()) {
            model model =new model(entry.getKey(), (boolean) entry.getValue());
            if (entry.getKey().matches("variations_seed_native_stored")){
                continue;

            }
            cardModels.add(model);

        }
        return cardModels;
}

}
