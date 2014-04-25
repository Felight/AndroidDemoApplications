package com.felight.felight;

import java.util.Arrays;

import com.felight.felight.utils.Calculator;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class BenchMarkActivity extends Activity {
	
	static int[] array;
	EditText etArraySize;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.benchmark_layout);
		etArraySize = (EditText) findViewById(R.id.etArraySize);
	}
	
	public void generateRandomArray(View view){
		array = Calculator.generateRandomIntArray(Integer.parseInt(etArraySize.getText().toString()));
	}
	
	@SuppressLint("NewApi") public void sortArray(View view){
		switch(view.getId()){
		case R.id.btnBubbleSort:
			int[] myArray = Arrays.copyOf(array, array.length);
			long start = System.currentTimeMillis();
			Calculator.bubbleSort(myArray);
			long timeTaken = System.currentTimeMillis() - start;
			((TextView)findViewById(R.id.tvBubbleSortResult)).setText(timeTaken+"");
			break;
		case R.id.btnSelectionSort:
			
			int[] myArray2 = Arrays.copyOf(array, array.length);
			long start1 = System.currentTimeMillis();
			Calculator.selectionSort(myArray2);
			long timeTaken1 = System.currentTimeMillis() - start1;
			((TextView)findViewById(R.id.tvSelectionSortResult)).setText(timeTaken1+"");
			
			break;
		}
	}
}
