package com.example.android.android_me.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.android.android_me.R;

public class MainActivity extends AppCompatActivity implements Master_list_fragment.OnImageClickListener {

    private int headIndex;
    private int bodyIndex;
    private int legIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void onImageSelected(int position){
        Toast.makeText(getApplicationContext(),"Position clicked "+position, Toast.LENGTH_SHORT).show();
        // Total parts are 36, so each get 12.
        // 0-11:head, 12:23:body, 24:35:legs
        int bodyPartNumber = position/12;

        int listIndex = position-12*bodyPartNumber;

        switch (bodyPartNumber){
            case 0:headIndex = listIndex;
            break;

            case 1:bodyIndex = listIndex;
            break;

            case 2:legIndex = listIndex;
            break;

            default:break;
        }

        Bundle b = new Bundle();
        b.putInt("headIndex", headIndex);
        b.putInt("bodyIndex", bodyIndex);
        b.putInt("legIndex", legIndex);

        final Intent intent = new Intent(this, AndroidMeActivity.class);
        intent.putExtras(b);

        Button nextButton = (Button) findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

    }

}
