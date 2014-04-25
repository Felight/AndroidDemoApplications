package com.felight.felight;


import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	Button btnOk;
	EditText etName;
	TextView tvResult;
	private static boolean isPlaying;
	MediaPlayer mediaPlayer;
	
	public void playAudio(View view){
			mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.air_horn);
			mediaPlayer.setLooping(true);
			mediaPlayer.start();
		
	}
	
	

	public void stopAudio(View view){
			mediaPlayer.stop();
		
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);

		
	}
	
	public void gotToRandomJokesActivity(View view){
		Log.i("vinay", "goto called");
		Intent intnet = new Intent(getBaseContext(), RandomJokes.class);
		Log.i("vinay", "goto called n bfr starting activity");
		startActivity(intnet);
		Log.i("vinay", "after starting random activty");
	}
	
	public void goToBechMark(View view){
		Intent intent = new Intent(getBaseContext(), BenchMarkActivity.class);
		startActivity(intent);
	}

	public void goToBasicCalculator(View view){
		Intent intent = new Intent(getBaseContext(), CalculatorActivity.class);
		intent.putExtra("catgeory", "All News");
		startActivity(intent);
		
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
		case R.id.itemAbout:
			Intent intent = new Intent(getBaseContext(), CalculatorActivity.class);
			startActivity(intent);
			break;
		case R.id.itemHelp:
			Toast toast = Toast.makeText(getBaseContext(), "Help Selected", Toast.LENGTH_LONG);
			toast.setGravity(Gravity.TOP, -300, 0);
			toast.show();
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		MenuInflater inflator = getMenuInflater();
		inflator.inflate(R.menu.main, menu);
		
//		menu.add("Themes");
//		menu.add("Font Colors");
		return super.onCreateOptionsMenu(menu);
	}

}
