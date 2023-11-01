import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Song {

	Clip clip;
	URL link;
	
	public Song() {
		
		link = getClass().getClassLoader().getResource("song.wav");
		
	}
	
	public void play() {
		
		setFile();
		clip.start();
	}
	
	public void setFile() {
	    try {
	        AudioInputStream ais = AudioSystem.getAudioInputStream(link);
	        this.clip = AudioSystem.getClip();
	        this.clip.open(ais);
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public void stop() {
		
		clip.stop();
	}
	
	public void loop() {
		
		clip.loop(Clip.LOOP_CONTINUOUSLY);
		
	}
	
}
