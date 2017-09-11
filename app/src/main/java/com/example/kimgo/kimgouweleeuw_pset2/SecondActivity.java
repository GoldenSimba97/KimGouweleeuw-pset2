package com.example.kimgo.kimgouweleeuw_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static java.nio.charset.StandardCharsets.UTF_8;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String content = null;
//        try {
//            content = new Scanner(new File("madlib0_simple.txt")).useDelimiter("\\Z").next();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

        try(BufferedReader br = new BufferedReader(new FileReader("madlib0_simple.txt"))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            content = sb.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(content);
//        System.out.println(content);
//
//        InputStream stream = null;
//        if (content != null) {
//            stream = new ByteArrayInputStream(content.getBytes());
//        }
//
//        Story story = new Story(stream);
//        String text = toString();
//        System.out.println(text);
    }

    public void goToNext(View view) {
        EditText edittext = (EditText) findViewById(R.id.editText);
        String text = edittext.getText().toString();



        Intent intent = new Intent(this, ThirdActivity.class);
        intent.putExtra("ourString", text);
        startActivity(intent);
        finish();
    }
}
