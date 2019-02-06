/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TTS;

import com.darkprograms.speech.synthesiser.SynthesiserV2;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

/**
 *
 * @author Ayudantía
 */
public class googleTTS{

    SynthesiserV2 synt = new SynthesiserV2("AIzaSyBOti4mM-6x9WDnZIjIeyEU21OpBXqWBgw");
    private Thread thread;

    public googleTTS(String message) {
        speak(message);
    }

    public void speak(final String message) {
        System.out.println(message);
        this.thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    AdvancedPlayer player = new AdvancedPlayer(synt.getMP3Data(message));
                    player.play();

                    System.out.println("Successfully Reproduced");
                } catch (JavaLayerException | IOException ex) {
                    Logger.getLogger(googleTTS.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        this.thread.setDaemon(false);
        this.thread.start();
    }

    public static void main(String[] args) {
        new googleTTS("Hola me llamo Samuel");
    }
}
