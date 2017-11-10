package com.example.susanne.susannebinkhorst_pset2;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

public class ThirdActivity extends AppCompatActivity {
    public Story story;
    public TextView word_counter;
    public EditText placeholder;

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("story", story);
    }

    public void onRestoreInstanceState(Bundle inState){
        super.onRestoreInstanceState(inState);
        story = (Story) inState.getSerializable("story");

        word_counter.setText(story.getPlaceholderRemainingCount() + " words to go!");
        placeholder.setText(null);
        placeholder.setHint(story.getNextPlaceholder().toString());

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Intent intent = getIntent();
        String story_name = intent.getStringExtra("Story");

        AssetManager assets = getAssets();
        InputStream input = null;
        try {
            input = assets.open(story_name);
        }
        catch (IOException e){
            Log.e("message:", e.getMessage());
        }
        story = new Story(input);

        placeholder = findViewById(R.id.placeholder);
        placeholder.setHint(story.getNextPlaceholder().toString());

        word_counter = findViewById(R.id.word_counter);
        word_counter.setText(story.getPlaceholderCount() + " words to go!");

    }

    public void fillInPlaceholder(View view){

        EditText word = findViewById(R.id.placeholder);
        if (word.getText().length() == 0){
            Toast.makeText(getApplicationContext(), "Please enter a word", Toast.LENGTH_SHORT).show();
        }
        else{
            String new_word = word.getText().toString();
            story.fillInPlaceholder(new_word);

            if (story.isFilledIn()){
                Intent intent2 = new Intent(this, FourthActivity.class);
                String finished_story = story.toString();
                intent2.putExtra("story", finished_story);
                startActivity(intent2);
                finish();
            }

            else{
                placeholder = findViewById(R.id.placeholder);
                placeholder.setText(null);
                placeholder.setHint(story.getNextPlaceholder().toString());

                word_counter = findViewById(R.id.word_counter);
                word_counter.setText(story.getPlaceholderRemainingCount() + " words to go!");
            }
        }

    }
}
