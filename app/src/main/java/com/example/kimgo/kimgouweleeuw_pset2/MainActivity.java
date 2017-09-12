package com.example.kimgo.kimgouweleeuw_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToNext(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    public void showPopUp(View view) {
        PopupMenu popup = new PopupMenu(this, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.actions, popup.getMenu());
        popup.show();
    }

    public void chooseStory(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.simple:
                Intent intent = new Intent(this, SecondActivity.class);
                int simple = 0;
                intent.putExtra("selected", simple);
                startActivity(intent);
                finish();
                break;
            case R.id.tarzan:
                Intent intent1 = new Intent(this, SecondActivity.class);
                int tarzan = 1;
                intent1.putExtra("selected", tarzan);
                startActivity(intent1);
                finish();
                break;
            case R.id.uni:
                Intent intent2 = new Intent(this, SecondActivity.class);
                int uni = 2;
                intent2.putExtra("selected", uni);
                startActivity(intent2);
                finish();
                break;
            case R.id.clothes:
                Intent intent3 = new Intent(this, SecondActivity.class);
                int clothes = 3;
                intent3.putExtra("selected", clothes);
                startActivity(intent3);
                finish();
                break;
            case R.id.dance:
                Intent intent4 = new Intent(this, SecondActivity.class);
                int dance = 4;
                intent4.putExtra("selected", dance);
                startActivity(intent4);
                finish();
                break;
        }
    }
}
