package com.felight.felight;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends Activity {
	private static final int READ_BLOCK_SIZE = 50;
	private static final String TAG = "CalculatorActivity";
	EditText etFirstNumber;
	EditText etSecondNumber;
	TextView tvResult;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.calculator_layout);
		
		etFirstNumber = (EditText) findViewById(R.id.etFirstNumber);
		etSecondNumber = (EditText) findViewById(R.id.etSecondNumber);
		tvResult = (TextView) findViewById(R.id.tvResult);
		
		Intent intent = getIntent();
		tvResult.setText(intent.getStringExtra("catgeory"));
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		try {
			FileInputStream fIn = openFileInput("preferences.txt");
			InputStreamReader isr = new InputStreamReader(fIn);

			char[] inputBuffer = new char[READ_BLOCK_SIZE];
			String s = "";

			int charRead;
			while ((charRead = isr.read(inputBuffer)) > 0) {
				// -- convert the chars to a String --
				String readString = String.copyValueOf(inputBuffer, 0,
						charRead);
				s += readString;
				inputBuffer = new char[READ_BLOCK_SIZE];
			}
			Log.i(TAG,"data present in file is " + s); 
			// -- set the edit text to the text that has been read --
			
			
			
			
			Toast.makeText(getBaseContext(),
					"File loaded successfully!", Toast.LENGTH_SHORT)
					.show();

		} catch (IOException iOE) {
			iOE.printStackTrace();
			Log.i(TAG, "file not found");
		}
	}
	
	public void calculate(View view){
		double num1 = 0;
		double num2 = 0;
		if(etFirstNumber.getText().toString() != null && etSecondNumber.getText().toString() != null){
			num1 = Double.parseDouble(etFirstNumber.getText().toString());
			num2 = Double.parseDouble(etSecondNumber.getText().toString());
			//Toast.makeText(getBaseContext(), "not null", Toast.LENGTH_LONG).show();
		}
		 
		switch(view.getId()){
		case R.id.btnAddition:
			tvResult.setText((num1 + num2) + "");
			break;
		case R.id.btnSubtration:
			tvResult.setText((num1 - num2) + "");
			break;
		case R.id.btnDivision:
			tvResult.setText((num1 / num2) + "");
			break;
		case R.id.btnMultiplication:
			tvResult.setText((num1 * num2) + "");
			break;
		case R.id.btnModulus:
			tvResult.setText((num1 % num2) + "");
			break;
		}
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		FileOutputStream fileOutputStream=null;
		OutputStreamWriter osw=null;
		try {
			Log.i(TAG, "in Try before sd card");
			File sdCard = Environment.getExternalStorageDirectory();
			Log.i(TAG, "in Try got  sd card" + sdCard.toString());
			File directory = new File(sdCard.getAbsolutePath()
					+ "/calcData");
			Log.i(TAG, "in Try before make dir and file path is : "+ directory.toString());
			directory.mkdirs();
			Log.i(TAG, "in Try after sd card");
			File file = new File(directory, "textfile.txt");
			Log.i(TAG, "in Try after file");
			FileOutputStream fOut = new FileOutputStream(file);
			Log.i(TAG, "After fileoutstream ");
			OutputStreamWriter osw1 = new OutputStreamWriter(fOut);
			Log.i(TAG, "after osw1 ");
			String num1 = etFirstNumber.getText().toString();
			String num2 = etSecondNumber.getText().toString();
			osw1.write("num1: "+num1);
			osw1.write("\nnum2: " + num2);
			osw1.flush();
			osw1.close();
			Log.i(TAG, "writting is successful");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			
		}
		
	}
}
