package com.learn.designpatterns;

/*
 * ########################################## Adaptor Design Pattern #################################################### 
 * Two non compatible interfaces to work together with the help of an adaptor class which works between them to help.
 * MediaPlayer and AdvancedMediaPlayer are the two interfaces and both are non compatible with each other. 
 * Methods -
 * 			MediaPlayer - play(file, format)
 * 			AdvancedMediaPlayer - playVLC(file), playMP4()
 * 
 * AudioPlayer class extends MediaPlayer, which can only support mp3 format, but not vlc or mp4.
 * But already we have AdavancedMediaPlayer interface which deliver those features. 
 * Our objective here is to change AudioPlayer to support those existing functionalities (mp4 and vlc) for code re-usability 
 * with the help of Adaptor class, PlayerAdaptor.
 * ***********************************************************************************************************************
 */

public class Adaptor {

	public static void main(String[] args) {
		
		AudioPlayer player=new AudioPlayer();
		player.play("Vivegam_Theme", "mp3");
		player.play("Dheena_Sollamal", "mp4");
		player.play("Innisai_Alabedaiye", "mpeg");
		player.play("Veera_vinayaga", "vlc");
	}

}

interface MediaPlayer {
	public void play(String file, String format);
}


interface AdvancedMediaPlayer {
	public void playVLC(String file);
	public void playMP4(String file);
}

class VLCPlayer implements AdvancedMediaPlayer {

	@Override
	public void playVLC(String file) {
		System.out.println("Playing "+file+".vlc");
	}

	@Override
	public void playMP4(String file) {
	}
}

class MP4Player implements AdvancedMediaPlayer {

	@Override
	public void playVLC(String file) {
	}

	@Override
	public void playMP4(String file) {
		System.out.println("Playing "+file+".mp4");
	}
	
}
class AudioPlayer implements MediaPlayer {

	PlayerAdaptor adaptor;
	
	@Override
	public void play(String file, String format) {
		if(format.equals("mp3"))
			System.out.println("Playing "+file+".mp3");
		else if(format.equals("vlc") || format.equals("mp4")) {
			adaptor=new PlayerAdaptor(format);
			adaptor.play(file, format);
		} else {
			System.out.println("File format not supported other than .mp3, .mp4 and .vlc");
		}
	}	
}

class PlayerAdaptor implements MediaPlayer {

	AdvancedMediaPlayer adPlayer;
	
	PlayerAdaptor(String format) {
		if(format.equals("vlc"))
			this.adPlayer=new VLCPlayer();
		else if(format.equals("mp4"))
			this.adPlayer=new MP4Player();
	}
	
	@Override
	public void play(String file, String format) {

		if(format.equals("vlc")) 
			this.adPlayer.playVLC(file);
		else if(format.equals("mp4")) 
			this.adPlayer.playMP4(file);
	}
	
}
