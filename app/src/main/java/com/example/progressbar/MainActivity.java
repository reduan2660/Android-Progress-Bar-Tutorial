package com.example.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
        layout = findViewById(R.id.home);

        // Hiding Layout & Showing Progress Bar
        layout.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                // Hiding Progress Bar & Showing Layout
                layout.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.GONE);
            }
        }, 2000);

        Button btn = findViewById(R.id.gamebutton);
        ProgressBar horizontalProgressBar = findViewById(R.id.progress_horizontal);

        // Current Progress Container
        int[] currentProgress = {0};

        // On button click update progress bar
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // check for build version
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {

                    // updating the progress bar
                    if(currentProgress[0] < 100){
                        currentProgress[0] += 20;
                        horizontalProgressBar.setProgress(currentProgress[0], true);
                    }
                }
            }
        });

    }
}
