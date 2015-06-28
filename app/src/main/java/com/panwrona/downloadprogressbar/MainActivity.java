package com.panwrona.downloadprogressbar;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.panwrona.downloadprogressbar.library.DownloadProgressBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DownloadProgressBar downloadProgressView = (DownloadProgressBar)findViewById(R.id.dpv3);
        final TextView successTextView = (TextView)findViewById(R.id.success_text_view);
        Typeface robotoFont=Typeface.createFromAsset(getAssets(), "fonts/Roboto-Light.ttf");
        successTextView.setTypeface(robotoFont);

        downloadProgressView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadProgressView.playToSuccess();
            }
        });
        downloadProgressView.setOnProgressUpdateListener(new DownloadProgressBar.OnProgressUpdateListener() {
            @Override
            public void onProgressUpdate(float currentPlayTime) {
                successTextView.setText(Math.round(currentPlayTime / 3.6) + " %");
            }

            @Override
            public void onAnimationStarted() {
                downloadProgressView.setEnabled(false);
            }

            @Override
            public void onAnimationEnded() {
                successTextView.setText("Click to download");
                downloadProgressView.setEnabled(true);
            }

            @Override
            public void onAnimationSuccess() {
                successTextView.setText("Downloaded!");
            }

            @Override
            public void onAnimationError() {

            }
        });


    }
}
