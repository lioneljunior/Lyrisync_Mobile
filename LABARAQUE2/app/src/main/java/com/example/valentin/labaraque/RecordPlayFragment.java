package com.example.valentin.labaraque;


import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecordPlayFragment extends Fragment implements View.OnClickListener {


    private Button play, stop, record;
    private MediaRecorder myAudioRecorder;
    private String outputFile = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_record_play, container, false);


        play = (Button) view.findViewById(R.id.record_play);
        stop = (Button) view.findViewById(R.id.record_stop);
        record = (Button) view.findViewById(R.id.record_record);

        play.setOnClickListener(this);
        stop.setOnClickListener(this);
        record.setOnClickListener(this);

        Long tsLong = System.currentTimeMillis()/1000;
                String ts = tsLong.toString();
                //outputFile = Environment.getExternalStorageDirectory().getAbsolutePath() + ";/nlabz-recording;+ts"+";.3gp";
        outputFile= Environment.getExternalStorageDirectory().getAbsolutePath()+"/recording_LYRISYNC"+System.currentTimeMillis()+".mp3";
        myAudioRecorder=new MediaRecorder();

        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.RECORD_AUDIO)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[] { Manifest.permission.RECORD_AUDIO },
                    10);
        } else {


            myAudioRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            myAudioRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            myAudioRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
            myAudioRecorder.setOutputFile(outputFile);
        }


        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.record_play:
                MediaPlayer m = new MediaPlayer();
              try {
                    m.setDataSource(outputFile);
            }
               catch (IOException e) {
                    e.printStackTrace();
            }
              try {
                    m.prepare();
            }
               catch (IOException e) {
                    e.printStackTrace();
            }
                m.start();
                break;

            case R.id.record_record:
                try {
                        //myAudioRecorder=new MediaRecorder();
                        myAudioRecorder.prepare();
                        myAudioRecorder.start();
                } catch (IllegalStateException e) {
                        // TODO Auto-generated catch block<br />
                        e.printStackTrace();
                } catch (IOException e) {
                        // TODO Auto-generated catch block<br />
                        e.printStackTrace();
                }
                    record.setEnabled(false);
                    stop.setEnabled(true);
                Toast.makeText(getContext(),"record startded",Toast.LENGTH_LONG).show();

                break;

            case R.id.record_stop:

                myAudioRecorder.stop();
                record.setEnabled(true);
                myAudioRecorder.release();
                //myAudioRecorder=null;
                stop.setEnabled(false);
                play.setEnabled(true);
                Toast.makeText(getContext(),"recorded audio",Toast.LENGTH_LONG).show();

                break;
        }
    }
}
