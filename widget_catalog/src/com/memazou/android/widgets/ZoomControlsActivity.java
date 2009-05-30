package com.memazou.android.widgets;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ZoomControls;

public class ZoomControlsActivity extends Activity {

	private ZoomControls zoomControls;
	
	private View.OnClickListener zoomInListener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			Log.d("ZoomControlsActivity", "zoom in !!");
		}
	};
	private View.OnClickListener zoomOutListener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			Log.d("ZoomControlsActivity", "zoom out !!");
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.zoom_controls);
		
		zoomControls = (ZoomControls) findViewById(R.id.zoomControls);
		zoomControls.setOnZoomInClickListener(zoomInListener);
		zoomControls.setOnZoomOutClickListener(zoomOutListener);
	}
}
