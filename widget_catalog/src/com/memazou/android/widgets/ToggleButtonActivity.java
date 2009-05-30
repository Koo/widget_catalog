package com.memazou.android.widgets;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class ToggleButtonActivity extends Activity {
	private ToggleButton b;

	private CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() {
		@Override
		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked) {
			CharSequence message;
			if (isChecked) {
				message = "button is checked";
			} else {
				message = "button is unchecked";
			}
			Toast.makeText(ToggleButtonActivity.this, message , Toast.LENGTH_LONG).show();
		}
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.toggle_button);
		
		b = (ToggleButton) findViewById(R.id.toggleButton);
		b.setOnCheckedChangeListener(listener);
	}
}
