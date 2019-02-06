/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TTS;

import com.sun.speech.freetts.VoiceManager;

/**
 *
 * @author Ayudantía
 */
public class freeTTS {
    
    private final String name;
    private final com.sun.speech.freetts.Voice voice;
    
    public freeTTS(String name){
        this.name = name;
        this.voice = VoiceManager.getInstance().getVoice(this.name);
        this.voice.allocate();
    }
    
    public void speak(String message){
        this.voice.speak(message);
    }
    
    public static void main(String[] args){
        freeTTS kevin = new freeTTS("kevin16");
        kevin.speak("medley");
    }
}
