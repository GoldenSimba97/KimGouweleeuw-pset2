package com.example.kimgo.kimgouweleeuw_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
//import android.widget.PopupMenu;

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

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.actions, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle item selection
//        switch (item.getItemId()) {
//            case R.id.simple:
//                Intent intent = new Intent(this, SecondActivity.class);
//                intent.putExtra("selected", 0);
//                startActivity(intent);
//                return true;
////                break;
//            case R.id.tarzan:
//                Intent intent2 = new Intent(this, SecondActivity.class);
//                intent2.putExtra("selected", 1);
//                startActivity(intent2);
//                return true;
////                break;
////            case R.id.uni:
////
////                return true;
////            case R.id.clothes:
////
////                return true;
////            case R.id.dance:
////
////                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }

    public void chooseStory(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.simple:
                Intent intent = new Intent(this, SecondActivity.class);
                intent.putExtra("selected", 0);
                startActivity(intent);
//                return true;
                break;
            case R.id.tarzan:
                Intent intent2 = new Intent(this, SecondActivity.class);
                intent2.putExtra("selected", 1);
                startActivity(intent2);
//                return true;
                break;
        }
    }
}
