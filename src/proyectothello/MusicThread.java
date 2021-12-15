/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectothello;

import java.io.InputStream;
import static java.lang.Thread.sleep;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author jybra
 */
public class MusicThread extends Thread {

    private boolean shouldExit = false;
    AudioStream BGM;

    public void setShouldExit(boolean shouldExit) {
        this.shouldExit = shouldExit;
        AudioPlayer.player.stop(BGM);
    }

    @Override
    public void run() {
        while (!shouldExit) {
            try {
                ClassLoader CLDR = this.getClass().getClassLoader();
                InputStream soundName = CLDR.getResourceAsStream("proyectothello/bgm.wav");
                BGM = new AudioStream(soundName);
                AudioPlayer play = AudioPlayer.player;

                play.start(BGM);

                sleep(115000);
            } catch (Exception e) {
                System.out.println("ERROR:" + e);
            }
        }
    }
}
