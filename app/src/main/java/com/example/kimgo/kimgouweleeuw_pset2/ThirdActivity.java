package com.example.kimgo.kimgouweleeuw_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

//    private Button anotherStory = (Button) findViewById(R.id.anotherstory);
//    private View.OnClickListener toStart = new myListener();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

//        Intent intent = getIntent();
//        String recievedText = intent.getStringExtra("ourStory");

        Story story = (Story) getIntent().getExtras().getSerializable("ourStory");
        TextView textView = (TextView) findViewById(R.id.textView);
        if (story != null) {
            textView.setText(story.toString());
        }

        findViewById(R.id.anotherstory).setOnClickListener(new myListener());
    }

    private class myListener implements View.OnClickListener {
        @Override public void onClick(View view) {
            Intent intent = new Intent(view.getContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

//    public void goToFirst(View view) {
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
//        finish();
//    }
}
