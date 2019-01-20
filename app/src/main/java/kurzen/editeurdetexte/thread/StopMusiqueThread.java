package kurzen.editeurdetexte.thread;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;

public class StopMusiqueThread extends Thread{
    private MediaPlayer musique;
    private Context context;

    public StopMusiqueThread(Context context, MediaPlayer musique) {
        super();
        this.musique = musique;
        this.context = context;
    }

    public void run(){
        AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);

        int volumeMax = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int volume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        int volumeTmp = volume;

        while(0 < volumeTmp )
        {
            float son = (float) volumeTmp/volumeMax;
            musique.setVolume(son, son);
            volumeTmp--;

            try {
                sleep(2500/volume);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        musique.stop();
        musique.release();
        musique = null;
    }
}
