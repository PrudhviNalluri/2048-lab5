package com.twofoureight.twentyfortyeight;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.twofoureight.twentyfortyeightgame.TwentyFortyEightGame;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;


class GameGestureDetector extends GestureDetector.SimpleOnGestureListener {
	
	private TwentyFortyEightGame game;
	private TwentyFortyEightView view;
	public GameGestureDetector(TwentyFortyEightView view){
		this.view = view;
		this.game = view.getGame();
	}
	
	@Override
	public boolean onDown(MotionEvent e) {
		return true;
	}
	
	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
float x= velocityX;
		try{
			
			if (x==1)
			{
				Log.i("MOVE", "Going left!");
			game.moveLeft();
			}
			else if(x==2)
			{
				Log.i("MOVE", "Going Right!");
			game.moveRight();
			}
			else if(x==3)
			{
				Log.i("MOVE", "Going Up!");
			game.moveUp();
			}
			else if(x==4)
			{
				Log.i("MOVE", "Going Down!");
			game.moveDown();
			}
			
		}
		
		/*float xDiff = e1.getX() - e2.getX();;
		float yDiff = e1.getY() - e2.getY();;
	
		try {
		// are we doing x things
		if (Math.abs(xDiff) >= Math.abs(yDiff)) {
			// going left
			if (xDiff >= 0) {
				Log.i("MOVE", "Going left!");
				game.moveLeft();
			}
			else { // going right
				Log.i("MOVE", "Going right!");
				game.moveRight();
			}
		}
		else { // nope we are doing y things
			// going up
			if (yDiff >= 0) {
				Log.i("MOVE", "Going up!");
				game.moveUp();
			}
			else { // going down
				Log.i("MOVE", "Going down!");
				game.moveDown();
			}
		}
		view.reDraw();
		}*/
		catch (Exception e) {
			Log.i("ERROR", "Where are we going?");
			e.printStackTrace();
		}
		return true;
	}
}
/*
	private BroadcastReceiver receiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			Bundle bundle = intent.getExtras();
			if (bundle!=null) {
				 
				//extra data inserted into the fired intent
				String data = bundle.getString("data");
				Log.i("data in main class", data);
				
				
				if ("stomp".equalsIgnoreCase(data)) {
					try {
						game.moveRight();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
				}
				
				//Toast.makeText(getApplicationContext(), "Ok", Toast.LENGTH_SHORT).show();
			}else{
				Log.i("data in main class", "bundle null");
				//Toast.makeText(getApplicationContext(), "not", Toast.LENGTH_SHORT).show();
			}
			//handleResult(bundle);
		}

	

		
	};
	

protected void onResume() {
	
		
		
		//create a register   myproject is the same key used in connectionservice
		Intent registerReceiver = Context.registerReceiver(receiver, new IntentFilter("myproject"));
	}
}*/
	