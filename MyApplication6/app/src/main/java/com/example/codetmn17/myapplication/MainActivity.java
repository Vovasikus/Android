package com.example.codetmn17.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int k;
    private Button[][] buts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        k = 0;
        buts = new Button[3][3];
        buts[0][0] = (Button)findViewById(R.id.button11);
        buts[0][1] = (Button)findViewById(R.id.button12);
        buts[0][2] = (Button)findViewById(R.id.button13);
        buts[1][0] = (Button)findViewById(R.id.button21);
        buts[1][1] = (Button)findViewById(R.id.button22);
        buts[1][2] = (Button)findViewById(R.id.button23);
        buts[2][0] = (Button)findViewById(R.id.button31);
        buts[2][1] = (Button)findViewById(R.id.button32);
        buts[2][2] = (Button)findViewById(R.id.button33);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_start) {
            onClickStart(null);
            return true;
        }

        return super.onOptionsItemSelected(item);

    }

    public int TestGame(){
        int[][] t = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++){
                if (buts[i][j].getText().toString().equals("X")){
                    t[i][j] = 1;
                }
                else if (buts[i][j].getText().toString().equals("0")){
                    t[i][j] = 2;
                }
                else {
                    t[i][j] = 0;
                }
            }
        }

        if ((t[0][0] == t[0][1]) && (t[0][1] == t[0][2]) && (t[0][0] != 0)){
            return t[0][0];
        }
        if ((t[1][0] == t[1][1]) && (t[1][1] == t[1][2]) && (t[1][0] != 0)){
            return t[1][0];
        }
        if ((t[2][0] == t[2][1]) && (t[2][1] == t[2][2]) && (t[2][0] != 0)){
            return t[2][0];
        }
        if ((t[0][0] == t[1][0]) && (t[1][0] == t[2][0]) && (t[0][0] != 0)){
            return t[0][0];
        }
        if ((t[0][1] == t[1][1]) && (t[1][1] == t[2][1]) && (t[0][1] != 0)){
            return t[0][1];
        }
        if ((t[0][2] == t[1][2]) && (t[1][2] == t[2][2]) && (t[0][2] != 0)){
            return t[0][2];
        }
        if ((t[0][0] == t[1][1]) && (t[1][1] == t[2][2]) && (t[0][0] != 0)){
            return t[0][0];
        }
        if ((t[0][2] == t[1][1]) && (t[1][1] == t[2][0]) && (t[2][0] != 0)){
            return t[2][0];
        }

        if (k == 9)
            return 0;
        return -1;
    }

    public void onClickCheck(View view) {
        if (k % 2 == 0)
            ((Button) view).setText("X");
        else
            ((Button) view).setText("0");
        ((Button) view).setEnabled(false);
        k++;
        int rez = TestGame();
        if (rez == 1){
            Toast toast = Toast.makeText(
                    getApplicationContext(),
                    "Победили крестики!",
                    Toast.LENGTH_LONG
            );
            toast.setGravity(Gravity.CENTER, 0, 0);
            LinearLayout toastCont = (LinearLayout)toast.getView();
            ImageView Im = new ImageView(getApplicationContext());
            Im.setImageResource(R.drawable.krest);
            toastCont.addView(Im, 0);
            toast.show();
            EndGame();
        }
        else if (rez == 2){
            Toast toast = Toast.makeText(
                    getApplicationContext(),
                    "Победили нолики!",
                    Toast.LENGTH_LONG
            );
            toast.setGravity(Gravity.CENTER, 0, 0);
            LinearLayout toastCont = (LinearLayout)toast.getView();
            ImageView Im = new ImageView(getApplicationContext());
            Im.setImageResource(R.drawable.nol);
            toastCont.addView(Im, 0);
            toast.show();
            EndGame();
        }
        else if (rez == 0){
            Toast toast = Toast.makeText(
                    getApplicationContext(),
                    "Ничья!",
                    Toast.LENGTH_LONG
            );
            toast.setGravity(Gravity.CENTER, 0, 0);
            LinearLayout toastCont = (LinearLayout)toast.getView();
            ImageView Im = new ImageView(getApplicationContext());
            Im.setImageResource(R.drawable.draw);
            toastCont.addView(Im, 0);
            toast.show();
            EndGame();
        }
    }

    public void onClickStart(View view) {
        k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++){
                buts[i][j].setEnabled(true);
                buts[i][j].setText("");
            }
        }
    }

    public void EndGame() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++){
                buts[i][j].setEnabled(false);
            }
        }
    }
}
