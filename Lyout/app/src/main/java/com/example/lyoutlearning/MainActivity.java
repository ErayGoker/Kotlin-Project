package com.example.lyoutlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ChangeImage(View view){
        ImageView image=findViewById(R.id.imageView);
        image.setImageResource(R.drawable.yasmin2);


    }

}