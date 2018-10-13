/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionarynetbean.newpackage.Swing;

/**
 *
 * @author VX15
 */
import com.sun.speech.freetts.VoiceManager;
public class Speaking {
    public void speak(String text) {
        VoiceManager vm = VoiceManager.getInstance();
        com.sun.speech.freetts.Voice syntheticVoice = vm.getVoice("kevin16");
        syntheticVoice.allocate();
        syntheticVoice.speak(text);
        syntheticVoice.deallocate();
    }
    
}
