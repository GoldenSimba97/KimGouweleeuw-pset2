package com.example.kimgo.kimgouweleeuw_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Intent intent = getIntent();
//        String recievedText = intent.getStringExtra("ourStory");

        Story story = (Story) getIntent().getExtras().getSerializable("ourStory");
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(story.toString());
    }

    public void goToFirst(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
