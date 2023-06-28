package com.example.not_bad.Adbter;
import android.annotation.SuppressLint;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.not_bad.DataBase.model;
import com.example.not_bad.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;

public class AD extends RecyclerView.Adapter<AD.ViewHolder> {
    ArrayList<model>ll;
    boolean b=true;
   public static in item_;
   model model;
  static in i;
    public AD() {
    }

    public ArrayList<model> getLl() {
        return ll;
    }
    public void setLl(ArrayList<model> ll) {
        this.ll = ll;
    }
    public AD(ArrayList<model> ll) {
        this.ll = ll;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AD.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.ll,parent,false));
    }

    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(@NonNull AD.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        item_= (in) holder.itemView.getContext();
        i= (in) holder.itemView.getContext();

        model m=ll.get(position);
        holder.tx_title.setText(m.getTitel());
        Calendar calendar = Calendar.getInstance();
//        int hour = calendar.get(Calendar.HOUR_OF_DAY);
//        int minute = calendar.get(Calendar.MINUTE);
//        int day = calendar.get(Calendar.DAY_OF_MONTH);
//        int month = calendar.get(Calendar.MONTH) + 1; // يتم تعيين قيمة الشهر من 0 إلى 11، لذلك نحتاج إلى إضافة 1
//        int year = calendar.get(Calendar.YEAR);
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss  dd/MM/yyyy", Locale.getDefault());
        String dateTime = dateFormat.format(calendar.getTime());

        holder.tx_time.setText(dateTime);
        holder.tx_msg.setText(m.getMsg());
        TypedArray t=holder.card.getResources().obtainTypedArray(R.array.color_array);
        Random r=new Random();
        int a=r.nextInt(t.length());
        int color = t.getColor(a, 0);
        holder.card.setCardBackgroundColor(color);

               t.recycle();


               holder.itemView.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       item_.item_id(m.getId());

                   }
               });

               holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                   @Override
                   public boolean onLongClick(View v) {

                       item_.item_Menu(v,m);
                       return false;
                   }
               });
               holder.like.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       if (b){
                           holder.like.setImageResource(R.drawable.heart_svgrepo_com);
                           b=false;
                           model=new model(true,ll.get(position).getTitel(),ll.get(position).getMsg(),ll.get(position).getTime());
                           i.lil(model);
                       }else {
                           holder.like.setImageResource(R.drawable.ic_baseline_thumb_up_alt_24);
                           b=true;
                           model=new model(false,ll.get(position).getTitel(),ll.get(position).getMsg(),ll.get(position).getTime());
                           i.lil(model);
                       }



                   }
               });

    }

    @Override
    public int getItemCount() {
        return ll.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tx_title,tx_time,tx_msg;
        CardView card;
        ImageButton like;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_= (in) itemView.getContext();
            i= (in) itemView.getContext();
            tx_msg=itemView.findViewById(R.id.tx_msg);
            tx_time=itemView.findViewById(R.id.tx_time);
            tx_title=itemView.findViewById(R.id.tx_title);
            card=itemView.findViewById(R.id.card);
            like=itemView.findViewById(R.id.like);
        }
    }

    public interface  in{
        void item_Menu(View v,model p);
        void item_id(int id);
        void lil(model m);
    }
}

