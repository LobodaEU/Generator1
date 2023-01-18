package com.loboda.generator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;

public class ActivitySecond extends AppCompatActivity {
Button closeButton;
TextView textViewCoulDown;
Button button5;
Button button6;

private AdView mAdView;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        closeButton = (Button) findViewById(R.id.closeButton);
        textViewCoulDown = (TextView)  findViewById(R.id.textViewCoulDown);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //Обратный отсчет
        new CountDownTimer(15000, 1000){
            String time = new String();

            @Override
            public void onTick(long l) {
                //в процесс отсчета
                time = Long.toString(l/1000);
                textViewCoulDown.setText(time);

                //Toast toast = Toast.makeText(getApplicationContext(),time, Toast.LENGTH_SHORT);
                //toast.show();

            }

            @Override
            public void onFinish() {
                // по окончании оотсчета
                textViewCoulDown.setVisibility(TextView.GONE);
                closeButton.setVisibility(Button.VISIBLE);
            }

        }.start();

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(@NonNull View View) {
                //обработка нажатий
                switch (View.getId()) {
                    //кнопка "закрыть"
                    case R.id.closeButton:
                        ActivitySecond.this.finish();
                        //сообщеине о закрытии
                        /*Toast toast = Toast.makeText(getApplicationContext(),
                                getResources().getString(R.string.closetext), Toast.LENGTH_SHORT);
                        toast.show();*/
                        break;
                        //Кнопка оценить
                    case R.id.button5:
                        Uri uriUrl = Uri.parse("https://play.google.com/store/apps/details?id=com.loboda.generator");
                        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                        startActivity(launchBrowser);
                        break;
                    case R.id.button6:
                        Uri uriUr2 = Uri.parse("https://yoomoney.ru/to/41001259458713");
                        Intent launchBrowser2 = new Intent(Intent.ACTION_VIEW, uriUr2);
                        startActivity(launchBrowser2);

                        break;
                }
            }
        };
        //обработка нажатия баннера
        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }

            @Override
            public void onAdFailedToLoad(LoadAdError adError) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdImpression() {
                // Code to be executed when an impression is recorded
                // for an ad.
            }

            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }
        });
        closeButton.setOnClickListener(onClickListener);
        button5.setOnClickListener(onClickListener);
        button6.setOnClickListener(onClickListener);

    }
}