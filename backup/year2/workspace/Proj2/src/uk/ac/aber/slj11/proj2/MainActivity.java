package uk.ac.aber.slj11.proj2;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends Activity {

	private static final String NAME_COLOUR_KEY = null;
	private static final CharSequence DEFAULT_TEXT = null;
	private static final CharSequence DEFUALT_TEXT = null;
	private static final int DISPLAY_NAME_COLOUR_SCREEN_REQUEST_CODE = 0;
	private TextView namedColour;
	private SeekBar redBar, blueBar, greenBar;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		View screen = (View) findViewById(R.id.screen);
		namedColour = (TextView) findViewById(R.id.backgroundColour);

		if (savedInstanceState != null) {
			if (savedInstanceState.containsKey(NAME_COLOUR_KEY)) {
				namedColour.setText(savedInstanceState
						.getString(NAME_COLOUR_KEY));

			}

		}

		if (namedColour.getText().length() == 0)
			namedColour.setText(DEFAULT_TEXT);

		Colour screenColour = new Colour();
		redBar = (SeekBar) findViewById(R.id.seekBarRed);
		redBar.setOnSeekBarChangeListener(new ColourChangeListener(screen,
				RGBType.RED, screenColour));
		greenBar = (SeekBar) findViewById(R.id.seekBarGreen);
		greenBar.setOnSeekBarChangeListener(new ColourChangeListener(screen,
				RGBType.GREEN, screenColour));

		blueBar = (SeekBar) findViewById(R.id.seekBarBlue);
		blueBar.setOnSeekBarChangeListener(new ColourChangeListener(screen,
				RGBType.BLUE, screenColour));

		initialise();

	}

	private void initialise() {
		redBar.setProgress(redBar.getMax() / 2);
		blueBar.setProgress(blueBar.getMax() / 2);
		greenBar.setProgress(greenBar.getMax() / 2);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (requestCode == DISPLAY_NAME_COLOUR_SCREEN_REQUEST_CODE) {
			if (resultCode == RESULT_OK) {
				namedColour.setText(data.getStringExtra(NameColourActivity.NAMED_COLOUR));
			}

		}

	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putString(NAME_COLOUR_KEY, namedColour.getText().toString());
	}
	
	public void displayNameColourScreen(View v) {
		Intent displayNameColourIntent = new Intent(this,
				NameColourActivity.class);
		this.startActivityForResult(displayNameColourIntent,
				DISPLAY_NAME_COLOUR_SCREEN_REQUEST_CODE);
	}

	public void resetBackground(View v) {
		initialise();
		namedColour.setText(DEFUALT_TEXT);
	}
}
