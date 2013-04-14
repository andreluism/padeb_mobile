package utils;

import java.util.HashMap;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.speech.tts.TextToSpeech;

public class Talker extends TextToSpeech{
	
	public static final int RECOGNIZE_AFTER_SPEECH = 1;
	public static final int DO_NOTHING = 0;
	public static final int NEW_SPEECH_AFTER_COMPLETE = 3;
	private Handler handler;
	public Talker(Context context, OnInitListener listener, Handler _handler) {
		super(context, listener);
		handler = _handler;
	}
	
	public int speak(String text, int queueMode, HashMap<String, String> params, int codigo){
		int r = super.speak(text, queueMode, params);
		if(codigo != DO_NOTHING)
			enviaMensagem(codigo);
		return r;
	}
	
	private void enviaMensagem(final int codigo){
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				while(isSpeaking()){
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				Message msg = new Message();
				msg.arg1 = codigo;
				handler.sendMessage(msg);
			}
		});
		t.start();
	}
	

}
