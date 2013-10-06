package de.dakoehler.tums;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Max on 19.05.13.
 */
public class StatusActivity extends Activity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstaceState){
        super.onCreate(savedInstaceState);
        setContentView(R.layout.activity_status);
        final Intent intent = new Intent(this, MainActivity.class);
        button =(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
