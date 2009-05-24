package com.memazou.android.widgets;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class TimePickerActivity extends Activity {

	private static final int TIME_PICKER_DIALOG_ID = 1;
	private TextView timeTextView;
	private TimePickerDialog.OnTimeSetListener dialogListener = new TimePickerDialog.OnTimeSetListener() {

		@Override
		public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
			NumberFormat nf = new DecimalFormat("00");
			timeTextView.setText(nf.format(hourOfDay) + ":" + nf.format(minute));
		}
	};

	private View.OnClickListener listener = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			showDialog(TIME_PICKER_DIALOG_ID);
		}
	};

	@Override
	protected Dialog onCreateDialog(int id) {
		TimePickerDialog dialog = new TimePickerDialog(TimePickerActivity.this,
				dialogListener, 0, 0, true);
		return dialog;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.time_picker);

		Button b = (Button) findViewById(R.id.dialogButton);
		b.setOnClickListener(listener);
		
		timeTextView = (TextView) findViewById(R.id.timeTextView);
	}
}
