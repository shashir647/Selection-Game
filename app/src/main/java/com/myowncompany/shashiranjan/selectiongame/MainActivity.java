package com.myowncompany.shashiranjan.selectiongame;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends Activity {
    GridView grid;

    int finalitem;
    int finalcount;

    ArrayList<Integer> al=new ArrayList<>();
    String[] web = {
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""};
    Integer[] imageId = {
            R.drawable.apple,
            R.drawable.tomato,
            R.drawable.mango,
            R.drawable.apple,
            R.drawable.tomato,
            R.drawable.mango,
            R.drawable.apple,
            R.drawable.tomato,
            R.drawable.strawberry,
            R.drawable.apple,
            R.drawable.lemon,
            R.drawable.strawberry,
            R.drawable.lemon,
            R.drawable.lemon,
            R.drawable.peach,
            R.drawable.mango,
            R.drawable.strawberry,
            R.drawable.peach,
            R.drawable.mango,
            R.drawable.tomato,
            R.drawable.apple,
            R.drawable.peach,
            R.drawable.strawberry,
            R.drawable.lemon,
            R.drawable.peach

    };

    int itemm;
     TextView item,count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadApps();
        setContentView(R.layout.activity_main);
        final Button button= (Button) findViewById(R.id.button_exit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
                System.exit(0);
            }
        });


        al=new ArrayList<>();
        for (int i=0;i<imageId.length;i++){

            al.add(getRandom(imageId));

        }

        Log.d("al=====","   "+al.size());
         CustomGrid adapter = new CustomGrid(MainActivity.this, web, al);
        grid = (GridView) findViewById(R.id.grid);

        Button button1= (Button) findViewById(R.id.button_reset);
         item= (TextView) findViewById(R.id.text_item);
         count= (TextView) findViewById(R.id.count);
         itemm=getRandom(imageId);

        switch (itemm){

            case R.drawable.apple:
                item.setText("Apple");
                finalitem=itemm;
                break;
            case R.drawable.lemon:
                item.setText("Lemon");
                finalitem=itemm;
                break;

            case R.drawable.mango:
                item.setText("Mango");
                finalitem=itemm;
                break;

            case R.drawable.peach:
                item.setText("Peach");
                finalitem=itemm;
                break;
            case R.drawable.strawberry:
                item.setText("Strawberry");
                finalitem=itemm;
                break;
            case R.drawable.tomato:
                item.setText("Tomato");
                finalitem=itemm;
                break;

        }
        for (int i=0;i<al.size();i++){
            if (al.get(i)==finalitem)
                finalcount++;

        }

        count.setText(Integer.toString(finalcount));

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                refresh();
                           }


        });

        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if (al.get(position)==finalitem && finalcount>0){

                       finalcount--;
                        if (finalcount==0){
                            AlertDialog.Builder dialog=new AlertDialog.Builder(MainActivity.this);
                            dialog.setTitle("Found all Fruits");

                            dialog.setMessage("Congratulations !! You have found all the given fruits !!");

                            dialog.setNegativeButton("New Game", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                            dialog.show();
                            count.setText(Integer.toString(finalcount));
                            refresh();
                        } else
                              count.setText(Integer.toString(finalcount));
                    }
                else
                    if (al.get(position)!=finalitem) {
                        Toast.makeText(MainActivity.this, "Wrong Choice", Toast.LENGTH_SHORT).show();
                    } else
                        Toast.makeText(MainActivity.this, "completed", Toast.LENGTH_SHORT).show();

            }
        });

    }
    private List<ResolveInfo> mApps;
        private void loadApps() {
            Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
            mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);

            mApps = getPackageManager().queryIntentActivities(mainIntent, 0);
        }

    public static int getRandom(Integer[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }


    public void refresh(){

        finalcount=0;
        al.clear();
        for (int i=0;i<imageId.length;i++){

            al.add(getRandom(imageId));
            itemm=getRandom(imageId);

            switch (itemm){

                case R.drawable.apple:
                    item.setText("Apple");
                    finalitem=itemm;
                    break;
                case R.drawable.lemon:
                    item.setText("Lemon");
                    finalitem=itemm;
                    break;

                case R.drawable.mango:
                    item.setText("Mango");
                    finalitem=itemm;
                    break;

                case R.drawable.peach:
                    item.setText("Peach");
                    finalitem=itemm;
                    break;
                case R.drawable.strawberry:
                    item.setText("Strawberry");
                    finalitem=itemm;
                    break;
                case R.drawable.tomato:
                    item.setText("Tomato");
                    finalitem=itemm;
                    break;

            }

        }

        CustomGrid adapter = new CustomGrid(MainActivity.this, web, al);

        grid.setAdapter(adapter);
        for (int i=0;i<al.size();i++){

            if (al.get(i)==finalitem)
                finalcount++;

        }
        count.setText(Integer.toString(finalcount));

    }
}
