package com.example.nourah.myapplication;

import android.content.Intent;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.VideoView;

public class Arrangement_words extends AppCompatActivity {
    ImageButton button;
    TextView t1,t2;
    Menu menu;
    private Uri imageUri;
    Button clk;
    VideoView vi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_arrangement_words);
        t1=(TextView)findViewById(R.id.textView) ;
        t2=(TextView)findViewById(R.id.textView2) ;
        vi = (VideoView) findViewById(R.id.videoView);
        String vidiop = "android.resource://com.example.nourah.myapplication/"+R.raw.order_words;
            Uri uri2 = Uri.parse(vidiop);
            vi.setVideoURI(uri2);
            vi.seekTo(100);}

    public void videoplay(View view){

        if(vi.isPlaying()) {
            vi.pause();}
        else{

            vi.start();}
    }
    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();

        if(id==R.id.share){

            Intent intent=new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.setType("image/*");

            intent.putExtra(Intent.EXTRA_SUBJECT,t1.getText());
            intent.putExtra(Intent.EXTRA_TEXT,t2.getText());


            startActivity(Intent.createChooser(intent,"Share using"));
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        getMenuInflater().inflate(R.menu.share, menu);
        menu.findItem(R.id.share).setEnabled(true);
        return super.onCreateOptionsMenu(menu);
    }


}

