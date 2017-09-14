package com.example.kimgo.kimgouweleeuw_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    /* Gets the story after it has been filled in and prints it. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Story story = (Story) getIntent().getExtras().getSerializable("ourStory");
        TextView textView = (TextView) findViewById(R.id.textView);
        if (story != null) {
            textView.setText(story.toString());
        }

        findViewById(R.id.anotherstory).setOnClickListener(new myListener());
    }

    /* Sends to back to the start screen after clicking the button. */
    private class myListener implements View.OnClickListener {
        @Override public void onClick(View view) {
            Intent intent = new Intent(view.getContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

}
