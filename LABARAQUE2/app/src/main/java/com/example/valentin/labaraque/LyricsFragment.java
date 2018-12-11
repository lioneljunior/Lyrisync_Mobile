package com.example.valentin.labaraque;


import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class LyricsFragment extends Fragment implements View.OnClickListener {

    private MediaPlayer mPlayer = null;
    private Button jouer,arreter,pause;
    private TextView affichelyric;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lyrics, container, false);


        jouer = (Button) view.findViewById(R.id.jouermusique);
        arreter = (Button) view.findViewById(R.id.jouermusiquestop);
        pause = (Button) view.findViewById(R.id.jouermusiquepause);
        affichelyric = (TextView) view.findViewById(R.id.affichelyrics);

        jouer.setOnClickListener(this);
        arreter.setOnClickListener(this);
        pause.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.jouermusique:
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
                break;
            case R.id.jouermusiquestop:
                mPlayer.stop();
                mPlayer.release();
                break;
            case R.id.jouermusiquepause:
                pause();
                break;
        }
    }

    private void pause(){
        if (mPlayer.isPlaying()){
            mPlayer.pause();
        }

    }

    private void playSound(int resId) {
        if(mPlayer != null) {
            mPlayer.start();
            mPlayer.release();
        }
        mPlayer = MediaPlayer.create(getContext(), resId);
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
}
