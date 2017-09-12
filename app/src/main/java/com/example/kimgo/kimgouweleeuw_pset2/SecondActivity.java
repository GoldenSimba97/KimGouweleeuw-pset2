package com.example.kimgo.kimgouweleeuw_pset2;

import android.content.Intent;
import android.content.res.AssetManager;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        try {
            getStory();
        } catch (IOException e) {
            e.printStackTrace();
        }

        EditText editText = (EditText) findViewById(R.id.edit);
        editText.setText(story.getNextPlaceholder());
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
        EditText editText = (EditText) findViewById(R.id.edit);
        story.fillInPlaceholder(editText.getText().toString());
        editText.setText(story.getNextPlaceholder());

        if (story.isFilledIn()) {
            goToStory(view);
        }
    }

    //    private void fillInStory() {
//        String place = story.getNextPlaceholder();
//        EditText edittext = (EditText) findViewById(R.id.edit);
////        edittext.setText(place);
//
//        story.fillInPlaceholder(edittext.getText().toString());
//
////        EditText edittext = (EditText) findViewById(R.id.editText);
////        String text = edittext.getText().toString();
//
////        TextView textView = (TextView) findViewById(R.id.textView2);
////        textView.setText(place);
//
//    }

}
