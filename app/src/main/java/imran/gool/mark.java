package imran.gool;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;



public class mark extends AppCompatActivity {


    Button rent,list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myactivity);
        rent=(Button)  findViewById(R.id.rent);
        final MediaPlayer ren= MediaPlayer.create(this, R.raw.but);

        list = (Button) findViewById(R.id.list);
        rent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                Intent myintend=new Intent(v.getContext(), SampleActivity.class);
                startActivityForResult(myintend,0);
                ren.start();




            }

        });
        list.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent myintend=new Intent(v.getContext(), MainActivity.class);
                startActivityForResult(myintend,0);

                ren.start();
            }
        });

    }


}

