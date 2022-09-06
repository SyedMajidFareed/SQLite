package com.example.sql_example;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class StudentAdapter extends ArrayAdapter<Student> {
    int click=0;
    public StudentAdapter(@NonNull Context context, ArrayList<Student> ListViewArray) {
        super(context, R.layout.customlistview, ListViewArray);
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Student list = getItem(position);
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.customlistview, parent, false);
        TextView Name = convertView.findViewById(R.id.listnametxtview);
        TextView Rollnum = convertView.findViewById(R.id.listrolltxtview);
        //TextView EditName = convertView.findViewById(R.id.EditName);
        Button del = convertView.findViewById(R.id.delbtn);
        Button Update = convertView.findViewById(R.id.upbtn);
        //Button Cancel= convertView.findViewById(R.id.cancel);
        //TextView EditRollnum = convertView.findViewById(R.id.EditRollNum);
        //TextView status = convertView.findViewById(R.id.Status);
        //Switch EditStatus = convertView.findViewById(R.id.EditSwitch);
        ImageView img = convertView.findViewById(R.id.imageView);
        Name.setText(list.getStudent_Name());
        //String roll=list.getStudent_Roll();
        Rollnum.setText(list.getStudent_Roll();
        img.setImageResource(R.drawable.av);
        if (list.isEnroll()) {
            status.setText("Enrolled");
        } else {
            status.setText("Not Enrolled");
        }
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("sgasjcsachshcasjcksklcl",getContext().toString());
                Log.d("sgasjcsasjcksklclhsdjh",StudentAdapter.this.toString());
                Log.e("roll",Rollnum.toString());
                DBHelper dbHelper = new DBHelper(getContext());
                Log.d("roll",roll);
                dbHelper.Delete(roll);
                remove(list);
            }
        });
        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click+=1;
                if(click==1){
                    Name.setVisibility(View.INVISIBLE);
                    Rollnum.setVisibility(View.INVISIBLE);
                    status.setVisibility(View.INVISIBLE);
                    del.setVisibility(View.INVISIBLE);
                    EditName.setVisibility(View.VISIBLE);
                    EditRollnum.setVisibility(View.VISIBLE);
                    EditStatus.setVisibility(View.VISIBLE);
                    Cancel.setVisibility(View.VISIBLE);
                    EditName.setText(list.getName());
                    EditRollnum.setText(roll);
                }
                else if(click==2){
                    Name.setVisibility(View.VISIBLE);
                    Rollnum.setVisibility(View.VISIBLE);
                    status.setVisibility(View.VISIBLE);
                    del.setVisibility(View.VISIBLE);
                    EditName.setVisibility(View.INVISIBLE);
                    EditRollnum.setVisibility(View.INVISIBLE);
                    EditStatus.setVisibility(View.INVISIBLE);
                    Cancel.setVisibility(View.INVISIBLE);
                    Name.setText(EditName.getText().toString());
                    StudentModel model;
                    if (EditStatus.isChecked()) {
                        status.setText("Enrolled");
                        model= new StudentModel(Name.getText().toString(),Integer.valueOf(Rollnum.getText().toString()),true);
                    } else {
                        status.setText("Not Enrolled");
                        model= new StudentModel(Name.getText().toString(),Integer.valueOf(Rollnum.getText().toString()),false);
                    }

                    DBHelper db = new DBHelper(getContext());
                    db.Update(model);
                    click=0;
                }
            }
        });
        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Name.setVisibility(View.VISIBLE);
                Rollnum.setVisibility(View.VISIBLE);
                status.setVisibility(View.VISIBLE);
                del.setVisibility(View.VISIBLE);
                EditName.setVisibility(View.INVISIBLE);
                EditRollnum.setVisibility(View.INVISIBLE);
                EditStatus.setVisibility(View.INVISIBLE);
                Cancel.setVisibility(View.INVISIBLE);
                click=0;
            }
        });
        return convertView;
    }
}