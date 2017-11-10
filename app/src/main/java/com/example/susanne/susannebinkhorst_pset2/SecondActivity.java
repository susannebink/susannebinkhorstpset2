package com.example.susanne.susannebinkhorst_pset2;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    public String[] stories = {"madlib0_simple.txt", "madlib1_tarzan.txt", "madlib2_university.txt", "madlib3_clothes.txt", "madlib4_dance.txt"};
    public String choose_story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void goToStory(View view) {
        Intent intent = new Intent(this, ThirdActivity.class);

        switch (view.getId()){
            case R.id.dance:
                choose_story = stories[4];
                break;
            case R.id.tarzan:
                choose_story = stories[1];
                break;
            case R.id.university:
                choose_story = stories[2];
                break;
            case R.id.simple:
                choose_story = stories[0];
                break;
            case R.id.random:
                List<Integer> index = Arrays.asList(0,1,2,3,4);
                Random rand = new Random();
                int random_index = index.get(rand.nextInt(index.size()));

                choose_story = stories[random_index];
                break;
            case R.id.clothes:
                choose_story = stories[3];
                break;
        }

        intent.putExtra("Story", choose_story);
        startActivity(intent);
    }
}
