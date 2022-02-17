package com.example.menu;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class MainActivity2 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ImageView imageView2 = (ImageView)findViewById(R.id.imageView2);
        Intent intent = getIntent();
        String message = intent.getStringExtra("message");
        String message1 = intent.getStringExtra("message1");
        String message2 = intent.getStringExtra("message2");
        String message3 = intent.getStringExtra("message3");
        Uri uri;
        uri = Uri.parse(message3);
        InputStream imageStream = null;
        try {
            imageStream = getContentResolver().openInputStream(uri);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
        imageView2.setImageBitmap(selectedImage);

        TextView messageText = (TextView) findViewById(R.id.textView);
        messageText.setText(message);
        TextView messageText1 = (TextView) findViewById(R.id.textView2);
        messageText1.setText(message1);
        TextView messageText2 = (TextView) findViewById(R.id.textView3);
        messageText2.setText(message2);

    }





}