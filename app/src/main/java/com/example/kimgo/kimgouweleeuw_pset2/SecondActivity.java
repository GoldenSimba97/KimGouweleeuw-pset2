package com.example.kimgo.kimgouweleeuw_pset2;

import android.content.Intent;
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
import java.util.Scanner;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Scanner scanner = null;
        String text = null;
        try {
            scanner = new Scanner( new File("madlib0_simple.txt") );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (scanner != null) {
            text = scanner.useDelimiter("\\A").next();
        }
        scanner.close();
        Toast.makeText(getApplicationContext(),text,Toast.LENGTH_SHORT).show();


//        InputStream targetStream = null;
//        throws IOException {
//            File initialFile = new File("src/main/resources/values/madlib0_simple.txt");
//            try {
//                targetStream = new FileInputStream(initialFile);
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
//        }
//        Story story = new Story(targetStream);
//        String text = toString();
//        System.out.println(text);

//        String content = null;
//        try {
//            content = new Scanner(new File("madlib0_simple.txt")).useDelimiter("\\Z").next();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

//        try(BufferedReader br = new BufferedReader(new FileReader("madlib0_simple.txt"))) {
//            StringBuilder sb = new StringBuilder();
//            String line = br.readLine();
//
//            while (line != null) {
//                sb.append(line);
//                sb.append(System.lineSeparator());
//                line = br.readLine();
//            }
//            content = sb.toString();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        System.out.println(content);
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


//    public void toInputStream() throws IOException {
//        InputStream targetStream = null;
//        File initialFile = new File("src/main/resources/values/madlib0_simple.txt");
//        try {
//            targetStream = new FileInputStream(initialFile);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        Story story = new Story(targetStream);
//        String text = toString();
//        System.out.println(text);
//    }






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
