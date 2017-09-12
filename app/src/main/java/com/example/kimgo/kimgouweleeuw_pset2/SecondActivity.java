package com.example.kimgo.kimgouweleeuw_pset2;

import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    private Story story;
    private EditText editPlace;
    private TextView textPlace;
    private TextView wordCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        try {
            getStory();
        } catch (IOException e) {
            e.printStackTrace();
        }

        editPlace = (EditText) findViewById(R.id.edit);
        textPlace = (TextView) findViewById(R.id.textView2);
        wordCount = (TextView) findViewById(R.id.textView3);

        editPlace.setHint(story.getNextPlaceholder());

        Resources res = getResources();

        String count = res.getString(R.string.nwords, story.getPlaceholderRemainingCount());
        wordCount.setText(count);

        String text = res.getString(R.string.placeholder, story.getNextPlaceholder());
        textPlace.setText(text);
    }


    private void getStory() throws IOException {
        InputStream stream = null;
        Random r = new Random();
        int storyNumber = r.nextInt(5);

        switch (storyNumber) {
            case(0):
                stream = getAssets().open("madlib0_simple.txt", AssetManager.ACCESS_UNKNOWN);
                break;
            case(1):
                stream = getAssets().open("madlib1_tarzan.txt", AssetManager.ACCESS_UNKNOWN);
                break;
            case(2):
                stream = getAssets().open("madlib2_university.txt", AssetManager.ACCESS_UNKNOWN);
                break;
            case(3):
                stream = getAssets().open("madlib3_clothes.txt", AssetManager.ACCESS_UNKNOWN);
                break;
            case(4):
                stream = getAssets().open("madlib4_dance.txt", AssetManager.ACCESS_UNKNOWN);
                break;
        }
        story = new Story(stream);
    }


    public void goToStory(View view) throws IOException {
        Intent intent = new Intent(this, ThirdActivity.class);
        Bundle bundle = new Bundle();

        bundle.putSerializable("ourStory", story);
        intent.putExtras(bundle);

        startActivity(intent);
        finish();
    }


    public void goToNext(View view) throws IOException {
        story.fillInPlaceholder(editPlace.getText().toString());
        editPlace.setText("");
        editPlace.setHint(story.getNextPlaceholder());

        Resources res = getResources();

        String count = res.getString(R.string.nwords, story.getPlaceholderRemainingCount());
        wordCount.setText(count);

        String text = res.getString(R.string.placeholder, story.getNextPlaceholder());
        textPlace.setText(text);

        if (story.isFilledIn()) {
            goToStory(view);
        }
    }

}
