package uk.ac.aber.slj11.proj2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class NameColourActivity extends Activity {

	public static final String NAMED_COLOUR = "uk.ac.aber.androidcourse.proj2.NAMED_COLOUR";
	private TextView colour;

	/**
	 * Called when the activity is first created.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.name_colour_screen);
		colour = (TextView) findViewById(R.id.setColourTextInput);
	}

	public void setColourClick(View v) {
		Intent data = new Intent();
		String namedColour = colour.getText().toString();
		data.putExtra(NAMED_COLOUR, namedColour);
		setResult(RESULT_OK, data);
		finish();
	}

}
