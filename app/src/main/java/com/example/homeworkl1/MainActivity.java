package com.example.homeworkl1;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        TextView mytextView = findViewById(R.id.textView);
        mytextView.setText("French Teacher App");


        Button btnBlack = findViewById(R.id.button);
        Button btnGreen = findViewById(R.id.button2);
        Button btnPurple = findViewById(R.id.button3);
        Button btnRed = findViewById(R.id.button4);
        Button btnYellow = findViewById(R.id.button5);


        btnBlack.setOnClickListener(v -> playSound(R.raw.noir));
        btnGreen.setOnClickListener(v -> playSound(R.raw.vert));
        btnPurple.setOnClickListener(v -> playSound(R.raw.violet));
        btnRed.setOnClickListener(v -> playSound(R.raw.rouge));
        btnYellow.setOnClickListener(v -> playSound(R.raw.jaune));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    private void playSound(int soundResource) {
        //
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }


        mediaPlayer = MediaPlayer.create(this, soundResource);
        if (mediaPlayer != null) {
            mediaPlayer.start();


            mediaPlayer.setOnCompletionListener(mp -> {
                mp.release();
                mediaPlayer = null;
            });
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}