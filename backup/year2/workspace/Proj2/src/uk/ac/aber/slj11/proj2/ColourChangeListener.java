package uk.ac.aber.slj11.proj2;

import android.view.View;
import android.widget.SeekBar;

public class ColourChangeListener implements SeekBar.OnSeekBarChangeListener {
	
	private View caller;
	private RGBType kind;
	private Colour colour;

	public ColourChangeListener(View caller, RGBType kind, Colour colour) {
		this.caller = caller;
		this.kind = kind;
		this.colour = colour;
	}

	public void onProgressChanged(SeekBar seekBar, int value, boolean fromUser) {
		switch (kind) {
		case RED:
			colour.setRed(value);
			break;
		case GREEN:
			colour.setGreen(value);
			break;
		case BLUE:
			colour.setBlue(value);
			break;
		case ALPHA:
			colour.setAlpha(value);
		}
		int colourValue = colour.getColour();
		caller.setBackgroundColor(colourValue);

	}

	public void onStartTrackingTouch(SeekBar seekBar) {

	}

	public void onStopTrackingTouch(SeekBar seekBar) {

	}

}
