package com.example.calcgui;

import MainPackage.Calculator;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button calculate = (Button)findViewById(R.id.button1);
		
		calculate.setOnClickListener(new View.OnClickListener(){
			public void onClick(View view){
				EditText editText1 = (EditText)findViewById(R.id.editText1);
				EditText editText2 = (EditText)findViewById(R.id.editText2);
				EditText editText3 = (EditText)findViewById(R.id.editText3);
				EditText editText4 = (EditText)findViewById(R.id.editText4);
				String eT1String = editText1.getText().toString();
				double eT1double = Double.parseDouble(eT1String);
				String eT2String = editText2.getText().toString();
				int eT2Int = Integer.parseInt(eT2String);
				String eT3String = editText3.getText().toString();
				double eT3double = Double.parseDouble(eT3String);
				Calculator calc = new Calculator(eT1double, eT2Int, eT3double);
				double future_value = Calculator.round2Places(calc.calculate());
				String future_value_string = String.valueOf(future_value);
				editText4.setText(future_value_string);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
