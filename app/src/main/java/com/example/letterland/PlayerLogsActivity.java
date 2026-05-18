package com.example.letterland;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class PlayerLogsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // This attaches the Java file to the XML layout you made earlier!
        setContentView(R.layout.activity_player_logs);

        // Make the back button work so we don't get trapped on this screen
        findViewById(R.id.btnBackPlayerLogs).setOnClickListener(v -> {
            SoundManager.getInstance(this).playClick();
            finish();
        });

        // Note: We will add the database filtering and restoring logic here later!
    }
}