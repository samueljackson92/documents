package uk.ac.aber.dcs.slj11.tempconverter;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private static final double ABSOLUTE_ZERO_IN_CELSIUS = -273.15;
	private static final String TEXT_STRING_KEY = "SAVED_TEXT";
	private static final String TEXT_COLOR_KEY = "SAVED_COLOR";
	private TextView output;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// get the object to which we will write the converted value
		output = (TextView)findViewById(R.id.textViewConvertedTemp);
		// retrieve and saved display values and re-set them

		if(savedInstanceState != null) {
			if(savedInstanceState.containsKey(TEXT_STRING_KEY)) {
				output.setText(savedInstanceState.getString(TEXT_STRING_KEY));
			}
			if(savedInstanceState.containsKey(TEXT_COLOR_KEY)) {
		      output.setTextColor(savedInstanceState.getInt(TEXT_COLOR_KEY));
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	/**
	 * User has clicked the button to convert from Farenheit to Celsius
	 */
	public void convertToCelsiusClicked(View v) {
		double farenheitValue = getEnteredFarenheitTemp();

		double celsiusValue = convertFToC(farenheitValue);

		// create the string or the Celsius temperature,
		// retrieving the 'units' from the string resources
		String celsiusSymbol = getString(R.string.celsiusLabel);
		String convertedText = String.format("%.1f%s", celsiusValue,
				celsiusSymbol);

		// and write the output to the screen
		output.setText(convertedText);
		setTextColor(celsiusValue);
	}
	/**

	 * The user has clicked the button to convert

	 * from Farenheit to Kelvin

	 */

	public void convertToKelvinClicked(View v)

	{
	      double farenheitValue = getEnteredFarenheitTemp();
	      double celsiusValue = convertFToC(farenheitValue);

	      // the Kelvin temperature is the difference
	      // between the Celsius value and absolute zero.
	      double kelvinValue = celsiusValue - ABSOLUTE_ZERO_IN_CELSIUS;

	      // create the string or the Celsius temperature,
	      // retrieving the 'units' from the string resources
	      String kelvinSymbol = getString(R.string.kelvinLabel);
	      String convertedText = String.format("%.1f%s", kelvinValue, kelvinSymbol);

	      // and write the output to the screen
	      output.setText(convertedText);
	      setTextColor(celsiusValue);

	}
	
	private void setTextColor(double celsiusTemp){
		if (celsiusTemp < 10.0) {                      
			output.setTextColor(getResources().
			getColor(R.color.ColorCold));

		} else if (celsiusTemp > 26.0) {          
			output.setTextColor(getResources().
			getColor(R.color.ColorHot));
		} else {
			output.setTextColor(getResources().getColor(R.color.ColorMidTemp));
		} 
	}

	/**
	 * 
	 * Retrieve the value from the farenheit box as a double.
	 * If no value is present, or there is an error,
	 * this defaults to zero
	 */
	private double getEnteredFarenheitTemp() {
		double farenheitValue = 0.0;
		
		try {
			EditText et = (EditText)findViewById(R.id.editTextFarenheitTemp);
			farenheitValue = Double.valueOf(et.getText().toString());
        } catch (Exception e) {
                // failed to get the farenheit value
                Toast.makeText(getApplicationContext(), "No Farenheit value specified", Toast.LENGTH_SHORT).show();

          }
          return farenheitValue;

    }
	
	private static double convertFToC(double farenheitTemp) {
		return (farenheitTemp -32.0)*(5.0/9.0);
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt(TEXT_COLOR_KEY, output.getCurrentTextColor());
		outState.putString(TEXT_STRING_KEY, output.getText().toString());
	}
}
