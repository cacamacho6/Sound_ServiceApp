package co.devbeerloper.sound_serviceapp;

import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ArrayList<Integer> songs = new ArrayList<>();
    int current=0;
    public Button b1;
    public Button b2;
    boolean state = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        songs.add((Integer) R.raw.aaa);
        songs.add((Integer)R.raw.bbb);
        songs.add((Integer)R.raw.ccc);
        songs.add((Integer)R.raw.ddd);


    }


    public void next (View v ){
       current = (current + 1) % songs.size();
            stopServiceOnClick(v);
            startServiceOnClick(v);

    }

    public void prev(View v){
        current = (current+ songs.size() -1) % songs.size();
            stopServiceOnClick(v);
            startServiceOnClick(v);

    }
    public void startServiceOnClick (View view){

        if(state){
            Intent intent = new Intent(this, AudioService.class);
            intent.putExtra("cancion",songs.get(current));
            startService(intent);
            state = false;
        }


    }


    public void stopServiceOnClick (View view){
            Intent intent = new Intent(this, AudioService.class);
            intent.putExtra("cancion",songs.get(current));
            stopService(intent);
            state = true;
        }


    }
