package dev.gl.calc;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author gl
 */
public class AudioPlayer {

    private File click = new File(".\\src\\main\\resources_sounds\\click2.wav");
    private File wrongState = new File(".\\src\\main\\resources_sounds\\wrongState.wav");
    private Clip clickSound;
    private Clip wrongStateSound;

    public AudioPlayer() {

        try {
            // loading click sound
            AudioInputStream ais = AudioSystem.getAudioInputStream(click);
            Clip clip = AudioSystem.getClip();
            clip.open(ais);
            clickSound = clip;
            
            // loading wrongState sound
            ais = AudioSystem.getAudioInputStream(wrongState);
            clip = AudioSystem.getClip();
            clip.open(ais);
            wrongStateSound = clip;
            
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }

    }

    public void playClickSound() {
        if (Configuration.soundIsOn) {
            clickSound.start();
            clickSound.setMicrosecondPosition(0);
        }
    }
    
    public void playWrongStateSound() {
        if (Configuration.soundIsOn) {
            wrongStateSound.start();
            wrongStateSound.setMicrosecondPosition(0);
        }
    }
}
