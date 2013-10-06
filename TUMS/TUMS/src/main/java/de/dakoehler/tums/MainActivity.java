package de.dakoehler.tums;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
public class MainActivity extends Activity {

    Button stat, dyn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonListener();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    protected void buttonListener(){
        dyn = (Button) findViewById(R.id.button3);
        final Intent i = new Intent(this, DynmapActivity.class);
        dyn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(i);
            }
        });
        stat = (Button) findViewById(R.id.button1);
        final Intent in = new Intent(this, StatusActivity.class);
        stat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(in);
            }
        });
    }
}
