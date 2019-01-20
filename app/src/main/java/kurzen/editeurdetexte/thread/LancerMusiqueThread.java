package kurzen.editeurdetexte.thread;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;

public class LancerMusiqueThread extends Thread{
    private MediaPlayer musique;
    private Context context;

    public LancerMusiqueThread(Context context, MediaPlayer musique) {
        super();
        this.musique = musique;
        this.context = context;
    }

    public void run(){
        System.out.println("lancer musique");
        AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);

        int volumeMax = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int volume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        int volumeTmp = 0;

        musique.setLooping(true);
        musique.start();

        while(volumeTmp < volume )
        {
            float son = (float) volumeTmp/volumeMax;
            musique.setVolume(son, son);
            volumeTmp++;

            try {
                sleep(2500/volume);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
