package com.example.kimgo.kimgouweleeuw_pset2;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        try {
            getStory();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private void getStory() throws IOException {
        InputStream stream = null;
        Random r = new Random();
        int storyNumber = r.nextInt(5);

        switch (storyNumber) {
            case(0): {
                stream = getAssets().open("madlib0_simple.txt", AssetManager.ACCESS_UNKNOWN);
                break;
            }
            case(1): {
                stream = getAssets().open("madlib1_tarzan.txt", AssetManager.ACCESS_UNKNOWN);
                break;
            }
            case(2): {
                stream = getAssets().open("madlib2_university.txt", AssetManager.ACCESS_UNKNOWN);
                break;
            }
            case(3): {
                stream = getAssets().open("madlib3_clothes.txt", AssetManager.ACCESS_UNKNOWN);
                break;
            }
            case(4): {
                stream = getAssets().open("madlib4_dance.txt", AssetManager.ACCESS_UNKNOWN);
                break;
            }
        }
        Story story = new Story(stream);
    }




    public void goToNext(View view) {
        EditText edittext = (EditText) findViewById(R.id.editText);
        String text = edittext.getText().toString();



        Intent intent = new Intent(this, ThirdActivity.class);
        intent.putExtra("ourString", text);
        startActivity(intent);
        finish();
    }

    public void printText(View view) {
//        String content = null;
//        try {
//            content = new Scanner(new File("madlib0_simple.txt")).useDelimiter("\\Z").next();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        Toast.makeText(getApplicationContext(),"hallo",Toast.LENGTH_SHORT).show();
    }
}
