package wein2d;

import java.io.*;
import javax.sound.sampled.*;

public class Sound
{
    // Variables ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private Clip sound;
    private FloatControl volume;
    float range;
    // Constructor ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Sound(String filePath)
    {
        // store full path as string
        String fullFilePath = System.getProperty("user.dir") + "/" + filePath;
        // replace all leftover backslashes with foreward slashes
        fullFilePath = fullFilePath.replace("\\", "/");
        // print if the sound file does even exist
        if (!(new File(fullFilePath).exists()))
        {
          System.out.println("Error when loading a sound: sound at '" + fullFilePath + "' doesn't exist.");
        }
        // load Clip
        try
        {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("./testSound.wav").getAbsoluteFile());
            sound = AudioSystem.getClip();
    		sound.open(audioStream);
        }
        catch(Exception e)
        {}
        // set up volume control
        volume = (FloatControl) sound.getControl(FloatControl.Type.MASTER_GAIN);
        range = volume.getMaximum() - volume.getMinimum();
    }
    // Set Loudness ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void setVolume(double loudness)
    {
        volume.setValue((float) (range * loudness) + volume.getMinimum());
    }
    // Play ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void play()
    {
        sound.start();
    }
    // Loop ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void loop(boolean looping)
    {
        if (looping)
        {
            sound.loop(Clip.LOOP_CONTINUOUSLY);
        }
        else
        {
            sound.loop(0);
        }
    }
    // Stop ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void stop()
    {
        sound.stop();
    }
}
