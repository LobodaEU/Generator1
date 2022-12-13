package com.loboda.generator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
Button button;
Button button2;
TextView textView;
TextInputEditText textInputEditText;
Spinner spinner;
Spinner spinner2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        textView = (TextView)  findViewById(R.id.textView);
        textInputEditText = (TextInputEditText)  findViewById(R.id.textInputEditText);
        spinner = (Spinner) findViewById(R.id.spinner) ;
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        String[] nogti = new String[]{};
        String[] parikmaherskaya = new String[]{};
        String[] prikoli = new String[]{"#music","#genre","#song","#songs","#TagsForLikes","#melody","#hiphop","#rnb","#pop","#love","#rap","#dubstep","#instagood","#beat","#beats","#jam","#myjam","#party","#partymusic","#newsong","#lovethissong","#remix","#favoritesong","#bestsong","#photooftheday","#bumpin","#repeat","#listentothis","#goodmusic","#instamusic","#movies","#theatre","#video","#TagsForLikes","#movie","#film","#films","#videos","#actor","#actress","#cinema","#dvd","#amc","#instamovies","#star","#moviestar","#photooftheday","#hollywood","#goodmovie","#instagood","#flick","#flicks","#instaflick","#instaflicks","#videogames","#games","#gamer","#TagsForLikes","#gaming","#instagaming","#instagamer","#playinggames","#online","#photooftheday","#onlinegaming","#videogameaddict","#instagame","#instagood","#gamestagram","#gamerguy","#gamergirl","#gamin","#video","#game","#igaddict","#winning","#play","#playing","#актер","#актриса","#беспризорник","#бессмертных","#биения","#бить","#варенье","#видео","#видео","#видео","#видеодиск","#видеоигры","#восстание","#геймер","#голливудский","#дабстеп","#жанр","#звезда","#игра","#игра","#играть","#игрище","#игровой","#интернете","#кино","#кино","#любовь","#мелодия","#музыка","#останавливает","#песни","#песня","#победивший","#повторять","#поп","#Последователи","#ремикс","#рит","#рэп","#сторона","#театр","#фильм","#фильмы","#хип-хоп","#цифровой","#юмор","#смешноевидео","#прикол","#прикольноевидео","#видос","#видеоролик","#шутка","#пранк","#розыгрыш","#арена","#цирк","#искуство","#театр","#спектакль","#микс","#комикс","#поржать","#смех"};
        String[] novosti = new String[]{};
        String[] svoi_massiv = new String[]{};
        String svoi_text = new String();


        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View View) {
                switch(View.getId()) {
                    case R.id.button:
                        String svoi_text = textInputEditText.getText().toString();
                        String[] svoi_massiv = svoi_text.split(" ");
                        String hashteg = new String();
                        Integer ostatok = new Integer(0);


                            for (int i = 0; i < svoi_massiv.length; i++) {
                                hashteg = "#" + svoi_massiv[i] + " " + hashteg;
                            }
                           // if (hashteg.length() < 2 ){hashteg = "";}
                        switch(spinner2.getSelectedItem().toString()){
                            case "15":
                                if (svoi_massiv.length < 15) {
                                    ostatok = (15 -  svoi_massiv.length);
                                }
                                else {
                                    ostatok = 0;
                                }
                            case "20":
                                if (svoi_massiv.length < 20) {
                                    ostatok = (20 -  svoi_massiv.length);
                                }
                                else {
                                    ostatok = 0;}

                            case "30" :
                                if (svoi_massiv.length < 30) {
                                    ostatok = (30 -  svoi_massiv.length);
                                }
                                else {
                                    ostatok = 0;}
                            case "40":
                                if (svoi_massiv.length < 40) {
                                    ostatok = (40 -  svoi_massiv.length);
                                }
                                else {
                                    ostatok = 0;}

                        }
                        switch(spinner.getSelectedItem().toString()){
                            case "Ноготочки":
                                if (nogti.length > 0) {

                                    for (int j = 0; j < ostatok; j++) {
                                        hashteg = hashteg + nogti[new Random().nextInt(nogti.length + 1)];
                                    }
                                }                                break;
                            case "Парикмахерская":
                                if (parikmaherskaya.length > 0) {
                                    for (int j = 0; j < ostatok; j++) {
                                        int rnd = new Random().nextInt(parikmaherskaya.length + 1);
                                        if (rnd  > 0 ){rnd = (rnd - 1); }
                                        hashteg = hashteg + parikmaherskaya[rnd];
                                    }
                                }
                                break;
                            case "Приколы":
                                if (prikoli.length > 0) {
                                    for (int j = 0; j < ostatok; j++) {
                                        int rnd = new Random().nextInt(prikoli.length + 1);
                                        if (rnd  > 0 ){rnd = (rnd - 1); }
                                        hashteg = hashteg + prikoli[rnd];
                                    }
                                }
                                break;

                            case "Новости":
                                if (novosti.length > 0) {
                                for (int j = 0; j < ostatok; j++) {
                                    hashteg = hashteg + novosti[new Random().nextInt(novosti.length + 1)] ;}
                                }
                                break;

                        }
                        textView.setText("Кнопка 1. генератор");
                        textView.setText(hashteg);
                        break;
                    case R.id.button2:
                        textView.setText("Кнопка 2. Копирование");
                        break;

                }

            }
            };
        button.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        }




    }
