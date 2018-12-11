package com.example.valentin.labaraque;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LectureActivity extends AppCompatActivity implements View.OnClickListener {

    private MediaPlayer mPlayer = null;
    private Button jouer,arreter;
    private TextView affichelyric;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture);

        setVolumeControlStream(AudioManager.STREAM_MUSIC);

        jouer = (Button) findViewById(R.id.jouermusique);
        arreter = (Button) findViewById(R.id.jouermusiquestop);
        affichelyric = (TextView) findViewById(R.id.affichelyrics);

        jouer.setOnClickListener(this);
        arreter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlayer.stop();
            }
        });
    }

    private void playSound(int resId) {
        if(mPlayer != null) {
            mPlayer.stop();
            mPlayer.release();
        }
        mPlayer = MediaPlayer.create(this, resId);
        mPlayer.start();
    }

    @Override
    public void onPause() {
        super.onPause();
        if(mPlayer != null) {
            mPlayer.stop();
            mPlayer.release();
        }
    }

    @Override
    public void onClick(View v) {



        playSound(R.raw.menteuse);

        affichelyric.setText("Elle c'est une menteuse elle est là pour plaisanter \n" +
                "J'l'avais senti qu'elle plaisantait \n" +
                "Elle c'est une menteuse elle est là pour plaisanter \n" +
                "J'l'avais senti qu'elle plaisantait \n" +
                "\n" +
                "C'est elle que je voulais à la base mais j'ai laissé tombé\n" +
                "Elle disait qu'elle m'aimait mais pour moi elle a pris les condés\n" +
                "Et à la base tout allait bien une famille on voulait fonder\n" +
                "Manque de pot pour moi j'suis tombé sur l'fruit défendu\n" +
                "Je n'suis pas un voleur, encore moins un menteur\n" +
                "Elle est dans une longueur, à bon entendeur\n" +
                "Je n'suis pas un voleur, encore moins un menteur\n" +
                "Elle est dans une longueur, tout c'que j'voulais c'est son bonheur\n" +
                "\n" +
                "Elle c'est une menteuse elle est là pour plaisanter\n" +
                "J'l'avais senti qu'elle plaisantait\n" +
                "Elle c'est une menteuse elle est là pour plaisanter\n" +
                "J'l'avais senti qu'elle plaisantait\n" +
                "Oh-nana, oh-nana, oh-nana, oh-nana\n" +
                "\n" +
                "Mais putain de réputation me colle à la peau\n" +
                "Elle m'invente des histoires mais je n'suis pas un collabo'\n" +
                "Et ça y est les blablas, le changements d'humeur je les paie\n" +
                "Et devant la ligne d'arrivée, j'ai perdu l'envie de t'aimer\n" +
                "Je n'suis pas un voleur, encore moins un menteur\n" +
                "Elle est dans une longueur, à bon entendeur\n" +
                "Je n'suis pas un voleur, encore moins un menteur\n" +
                "Elle est dans une longueur, tout c'que j'voulais c'est son bonheur\n" +
                "\n" +
                "Elle c'est une menteuse elle est là pour plaisanter\n" +
                "J'l'avais senti qu'elle plaisantait\n" +
                "Elle c'est une menteuse elle est là pour plaisanter\n" +
                "J'l'avais senti qu'elle plaisantait\n" +
                "Oh-nana, oh-nana, oh-nana, oh-nana");

    }
}
