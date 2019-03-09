package com.krish.Krishnan_Ex10;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;

public class MyActivity extends Activity {
    Button b1,b2,b3,b4;
    ImageView img1;
    MediaPlayer m;
    final int CAMERA_REQUEST=1888;
    Bitmap photo;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        b4=(Button)findViewById(R.id.button4);
        img1=(ImageView)findViewById(R.id.imageView);
        m=MediaPlayer.create(MyActivity.this,R.raw.audio);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(in,CAMERA_REQUEST);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               try{
                   getApplicationContext().setWallpaper(photo);
               } catch (Exception e) {
                   e.printStackTrace();
               }
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m.start();
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m.stop();
            }
        });

    }

    protected void onActivityResult(int requestcode,int resultcode,Intent data){
        if(requestcode==CAMERA_REQUEST){
            photo=(Bitmap)data.getExtras().get("data");
            img1.setImageBitmap(photo);
        }
    }
}
