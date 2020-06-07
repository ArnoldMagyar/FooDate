package hu.szucs.mobilapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class LetsEat extends AppCompatActivity {
    private Button Menu;
    private Button Nemtetszett;
    private Button Tetszett;
    final Random rnd = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lets_eat);
        Menu = (Button) findViewById(R.id.menuBtn);
        Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity();
            }
        });
        Nemtetszett = (Button) findViewById(R.id.beallitasBtn);
        Nemtetszett.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getNewImage();
            }
        });
        Tetszett = (Button) findViewById(R.id.tetszettBtn);
        Tetszett.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getNewImage();
            }
        });
        final ImageView img = (ImageView) findViewById(R.id.rndView);
        // I have 3 images named img_0 to img_2, so...
        final String str = "img_" + rnd.nextInt(4);
        img.setImageDrawable
                (
                        getResources().getDrawable(getResourceID(str, "drawable",
                                getApplicationContext()))
                );
    }


    public void getNewImage(){
        final ImageView img = (ImageView) findViewById(R.id.rndView);
        // I have 3 images named img_0 to img_2, so...
        final String str = "img_" + rnd.nextInt(4);
        img.setImageDrawable
                (
                        getResources().getDrawable(getResourceID(str, "drawable",
                                getApplicationContext()))
                );
    }
    public void openMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    protected final static int getResourceID
            (final String resName, final String resType, final Context ctx)
    {
        final int ResourceID =
                ctx.getResources().getIdentifier(resName, resType,
                        ctx.getApplicationInfo().packageName);
        if (ResourceID == 0)
        {
            throw new IllegalArgumentException
                    (
                            "No resource string found with name " + resName
                    );
        }
        else
        {
            return ResourceID;
        }
    }
}