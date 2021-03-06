package com.abhi.firstapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class AlertCustom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_custom);
    }

    public void simpleAlert(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Simple Alert");
        builder.setMessage("We have a message");
        builder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),
                                "Ok was clicked",
                                Toast.LENGTH_SHORT).show();
                    }
                });
        builder.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),
                        android.R.string.no, Toast.LENGTH_SHORT).show();
            }
        });
        builder.setCancelable(false);
        builder.show();
    }


    public void withItems(View view) {
        final String[] items = {"Apple", "Banana", "Grape", "Orange", "Pineapple"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("List of Fruits").setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), items[which] + " is clicked", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setPositiveButton("OK", null);
        builder.setNegativeButton("CANCEL", null);
        builder.setNeutralButton("NEUTRAL", null);
        builder.setPositiveButtonIcon(getResources().getDrawable(android.R.drawable.btn_plus, getTheme()));
        builder.setIcon(getResources().getDrawable(android.R.drawable.ic_delete, getTheme()));

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        Button b = alertDialog.getButton(DialogInterface.BUTTON_POSITIVE);
        b.setBackgroundColor(Color.BLACK);
        b.setPadding(0, 0, 20, 0);
        b.setTextColor(Color.WHITE);
    }

    public void withMultiChoiceIte(View view) {
        final String[] items = {"Beeshma", "Aarattu", "Hridayam", "Narathan", "Super sharannya"};
        final ArrayList<Integer> selectedList = new ArrayList<>();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("New Malayalam movies List");
        builder.setMultiChoiceItems(items, null,
                new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i, boolean isChecked) {
                        if (isChecked) {
                            Log.d("API123", "which " + i);
                            selectedList.add(i);
                        } else if (selectedList.contains(i)) {
                            selectedList.remove(Integer.valueOf(i));
                        }
                    }
                });

        builder.setPositiveButton("DONE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ArrayList<String> selectedString = new ArrayList<>();
                for (int j = 0; j < selectedList.size(); j++) {
                    selectedString.add(items[selectedList.get(j)]);
                }
                Toast.makeText(getApplicationContext(), "Items selected are : " + Arrays.toString(selectedString.toArray()), Toast.LENGTH_SHORT).show();
                ;
            }
        });
        builder.show();
       }
          public void withEditText(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("With Edit Text");

                 final EditText input = new EditText(AlertCustom.this);
                   LinearLayout.LayoutParams ip = new LinearLayout.LayoutParams(
                   LinearLayout.LayoutParams.MATCH_PARENT,
                   LinearLayout.LayoutParams.MATCH_PARENT);
           input.setLayoutParams(ip);
           builder.setView(input);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
          @Override
               public void onClick(DialogInterface dialogInterface, int i) {
                   Toast.makeText(getApplicationContext(), "Text entered is " + input.getText().toString(), Toast.LENGTH_SHORT).show();
               }
           });
      builder.show();
    }
public void withImageView(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
    LayoutInflater inflater =  getLayoutInflater();
    View dialogLayout = inflater.inflate(R.layout.alert_dialog_with_imageview,null);
    builder.setPositiveButton("OK", null);
    builder.setView(dialogLayout);
    builder.show();
}
public void withSeekBar(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("With SeekBar");
        final SeekBar seekBar = new SeekBar(AlertCustom.this);
        LinearLayout.LayoutParams ip = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        seekBar.setLayoutParams(ip);
        builder.setView(seekBar);
        builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                Toast.makeText(getApplicationContext(),"Alert Dialog is Dismissed", Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
}
public void withRatingBar(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        builder.setTitle("With RatingBar");
    View dialogLayout = inflater.inflate(R.layout.alert_dialog_with_ratingbar, null);
    final RatingBar ratingBar = dialogLayout.findViewById(R.id.ratingBar2);
    builder.setView(dialogLayout);
    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            Toast.makeText(getApplicationContext(), "Rating is "+ ratingBar.getRating(), Toast.LENGTH_SHORT).show();
        }
    });
    builder.show();
}

}
