package com.dever.qiubaiwork;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.dever.qiubaiwork.fragments.ArticleFragment;

public class InfoActivity extends AppCompatActivity {
    private TextView info_name,info_content,info_happy,info_talk,info_share;
    private ImageView info_image,info_icon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        info_name = (TextView) findViewById(R.id.info_name);
        info_icon = (ImageView) findViewById(R.id.info_icon);
        info_content = (TextView) findViewById(R.id.info_content);
        info_image = (ImageView) findViewById(R.id.info_image);
        info_happy = (TextView) findViewById(R.id.info_happy);
        info_talk = (TextView) findViewById(R.id.info_talk);
        info_share = (TextView) findViewById(R.id.info_share);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

    }

}
