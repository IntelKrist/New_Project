package com.example.menu;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
    import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class MainActivity extends Activity {

    //Объявляем используемые переменные:
    private ImageView imageView;
    private final int Pick_image = 1;
    public Uri imageUri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView)findViewById(R.id.imageView);
        Button PickImage = (Button) findViewById(R.id.button);
        PickImage.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, Pick_image);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        switch(requestCode) {
            case Pick_image:
                if(resultCode == RESULT_OK){
                    try {

                        imageUri = imageReturnedIntent.getData();
                        final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                        final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                        imageView.setImageBitmap(selectedImage);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
        }}
    public void send(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        EditText editText = (EditText) findViewById(R.id.editTextTextPersonName);
        EditText editText1 = (EditText) findViewById(R.id.editTextTextPersonName1);
        EditText editText2 = (EditText) findViewById(R.id.editTextTextPersonName2);
        String mes3;
        mes3 = imageUri.toString();
        String mes = editText.getText().toString();
        String mes1 = editText1.getText().toString();
        String mes2 = editText2.getText().toString();
        intent.putExtra("message", mes);
        intent.putExtra("message1", mes1);
        intent.putExtra("message2", mes2);
        intent.putExtra("message3", mes3);
        startActivity(intent);
    }


}