package com.felight.felight;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class RandomJokes extends Activity implements SensorEventListener {
	TextView tvJokes;
	List<String> jokesList;
	ListIterator iterator;
	static int previousRandomNum = 0;
	private SensorManager mSensorManager;
	private Sensor accelerometer;

	private float mAccel; // acceleration apart from gravity
	private float mAccelCurrent; // current acceleration including gravity
	private float mAccelLast; // last acceleration including gravity

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.i("vinay", "on create random joke started");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.random_jokes_layout);
		tvJokes = (TextView) findViewById(R.id.tvJokes);
		mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		accelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		mAccel = 0.00f;
		mAccelCurrent = SensorManager.GRAVITY_EARTH;
	    mAccelLast = SensorManager.GRAVITY_EARTH;
	    
	    
		jokesList = Arrays.asList(getResources().getStringArray(
				R.array.jokesArray));
		iterator = jokesList.listIterator();
		Log.i("vinay", "on create random joke ends");
	}

	@Override
	protected void onResume() {
		super.onResume();
		mSensorManager.registerListener(this,accelerometer , SensorManager.SENSOR_DELAY_NORMAL);
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		mSensorManager.unregisterListener(this, accelerometer);
	}
	public void changeJoke(View view) {

		switch (view.getId()) {
		case R.id.btnNext:
			if (iterator.hasNext()) {
				tvJokes.setText(iterator.next().toString());
			} else {
				tvJokes.setText("Dear user.. you reached the end.. Nothing is left in my basket.. will release new jokes soon.. thanks for your patience");
			}

			break;
		case R.id.btnPrevious:
			if (iterator.hasPrevious()) {
				tvJokes.setText(iterator.previous().toString());
			} else {
				tvJokes.setText("Dear user.. you reached the Beginning.. Nothing is left in my basket.. will release new jokes soon.. thanks for your patience");
			}
			break;
		case R.id.btnRandom:
			randomizeJoke();
			break;
		}
	}
	
	public void randomizeJoke(){
		Random random = new Random();
		int randomNumber = random.nextInt(5 - 1) + 1;
		tvJokes.setText(jokesList.get(randomNumber).toString());
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		float x = event.values[0];
		float y = event.values[1];
		float z = event.values[2];
		mAccelLast = mAccelCurrent;
		mAccelCurrent = (float) Math.sqrt((double) (x * x + y * y + z * z));
		float delta = mAccelCurrent - mAccelLast;
		mAccel = mAccel * 0.9f + delta; // perform low-cut filter
		
		if(mAccel>=2){
			Toast.makeText(getApplicationContext(), "shake detected", Toast.LENGTH_LONG).show();
			randomizeJoke();
		}
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub

	}

}
