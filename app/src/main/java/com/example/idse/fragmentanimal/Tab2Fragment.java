package com.example.idse.fragmentanimal;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

public class Tab2Fragment extends Fragment {

    private ImageView imgView;
    private Vibrator mVibrator;
    private MediaPlayer mMediaPlayer;
    private String data;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub

        data="Chien";
        View view = inflater.inflate(R.layout.tab2, container, false);
        imgView=(ImageView)view.findViewById(R.id.imgView);
        mMediaPlayer=new MediaPlayer();
        mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release();
                mMediaPlayer=null;
            }
        });
        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mVibrator = (Vibrator) getActivity().getSystemService(getActivity().VIBRATOR_SERVICE);
                mVibrator.vibrate(500);

                if(mMediaPlayer!=null)
                {
                    mMediaPlayer.release();
                    mMediaPlayer=null;
                }
                switch (data)
                {
                    case "Chien":
                        mMediaPlayer=MediaPlayer.create(getActivity(), R.raw.chien);
                        break;
                    case "Chat":
                        mMediaPlayer=MediaPlayer.create(getActivity(), R.raw.chat);
                        break;
                    case "Poisson":
                        mMediaPlayer=MediaPlayer.create(getActivity(), R.raw.poisson);
                        break;
                    case "Lapin":
                        mMediaPlayer=MediaPlayer.create(getActivity(),R.raw.lapin);
                        break;
                }
                mMediaPlayer.start();
            }

        });
        return view;

    }



    public void changeData(String data)
    {
        this.data=data;
        int resId = getResources().getIdentifier(data.toLowerCase(), "drawable", getContext().getPackageName());
        imgView.setImageResource(resId);
    }

}
