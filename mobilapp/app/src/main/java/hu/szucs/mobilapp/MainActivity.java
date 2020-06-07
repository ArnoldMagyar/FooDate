package hu.szucs.mobilapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button Settings;
    private Button LetsEat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Settings = (Button) findViewById(R.id.beallitasBtn);
        Settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBeallitasActivity();
            }
        });
        LetsEat = (Button) findViewById(R.id.keresBtn);
        LetsEat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLetsEat();
            }
        });
    }
    public void openBeallitasActivity(){
        Intent intent = new Intent(this, BeallitasActivity.class);
        startActivity(intent);
    }
    public void openLetsEat(){
        Intent intent = new Intent(this, LetsEat.class);
        startActivity(intent);
    }
}
