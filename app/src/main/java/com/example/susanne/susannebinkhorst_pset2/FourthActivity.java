package com.example.susanne.susannebinkhorst_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

public class FourthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        Intent intent = getIntent();
        String story = intent.getStringExtra("story");

        TextView print_story = findViewById(R.id.story);
        print_story.setText(Html.fromHtml(story));
    }

    public void createNew(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
        finish();
    }
}
