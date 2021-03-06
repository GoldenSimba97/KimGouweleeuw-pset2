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

    /* Either loads the selected story or selects a story at random. The user will be asked to
     * fill in the correct placeholder and is also shown how many words still need to be filled. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        int selectedStory = 10;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            selectedStory = extras.getInt("selected");
        }

        if (selectedStory != 10) {
            try {
                choosestory(selectedStory);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                getStory();
            } catch (IOException e) {
                e.printStackTrace();
            }
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

    /* Create bundle when onSaveInstanceState is called. */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        int count = story.getPlaceholderRemainingCount();
        String placeholder = story.getNextPlaceholder();
        outState.putInt("count",count);
        outState.putString("placeholder", placeholder);

        outState.putSerializable("story", story);
    }

    /* Everyting already filled in the story will be restored and the story itself too. */
    @Override
    public void onRestoreInstanceState(Bundle inState) {
        super.onRestoreInstanceState(inState);

        int counter = inState.getInt("count",-1);
        String placeholder = inState.getString("placeholder");

        Resources res = getResources();

        editPlace.setHint(placeholder);

        String count = res.getString(R.string.nwords, counter);
        wordCount.setText(count);

        String text = res.getString(R.string.placeholder, placeholder);
        textPlace.setText(text);

        story = (Story) inState.getSerializable("story");
    }

    /* The selected story will be loaded. */
    private void choosestory(int selectedStory) throws IOException {
        InputStream stream = null;
        switch (selectedStory) {
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

    /* A story will be loaded at random. */
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


    /* Passes the filled in story to the last screen where it will be displayed. */
    public void goToStory(View view) throws IOException {
        Intent intent = new Intent(this, ThirdActivity.class);
        Bundle bundle = new Bundle();

        bundle.putSerializable("ourStory", story);
        intent.putExtras(bundle);

        startActivity(intent);
        finish();
    }

    /* Fills the placeholder and shows how many words still need to be filled in everytime the
     * button is clicked. If the story is completely filled in goToStory will be called. */
    public void goToNext(View view) throws IOException {
        String string = editPlace.getText().toString();
        if (!string.isEmpty()) {
            story.fillInPlaceholder(editPlace.getText().toString());
            editPlace.setText("");
            editPlace.setHint(story.getNextPlaceholder());

            Resources res = getResources();

            String count = res.getString(R.string.nwords, story.getPlaceholderRemainingCount());
            wordCount.setText(count);

            String text = res.getString(R.string.placeholder, story.getNextPlaceholder());
            textPlace.setText(text);
        }

        if (story.isFilledIn()) {
            goToStory(view);
        }
    }

}
