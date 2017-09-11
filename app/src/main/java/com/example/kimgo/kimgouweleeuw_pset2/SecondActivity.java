package com.example.kimgo.kimgouweleeuw_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
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
