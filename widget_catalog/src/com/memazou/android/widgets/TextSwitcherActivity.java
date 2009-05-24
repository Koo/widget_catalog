package com.memazou.android.widgets;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class TextSwitcherActivity extends Activity {

	private TextSwitcher textSwitcher;
	private Button flipButton;
	private boolean flip;

	private View.OnClickListener flipListener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			if (flip) {
				textSwitcher.setText(getText(R.string.text_switcher_01));
			} else {
				textSwitcher.setText(getText(R.string.text_switcher_02));
			}
			flip = !flip;
		}
	};
	
	private ViewSwitcher.ViewFactory viewFactory = new ViewSwitcher.ViewFactory() {
		@Override
		public View makeView() {
	        TextView t = new TextView(TextSwitcherActivity.this);
	        t.setTextSize(48);
	        return t;
		}
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.text_switcher);
		
		textSwitcher = (TextSwitcher) findViewById(R.id.textSwitcher);
        textSwitcher.setFactory(viewFactory);

        Animation in = AnimationUtils.loadAnimation(this,
				android.R.anim.fade_in);
        in.setDuration(10000);
        Animation out = AnimationUtils.loadAnimation(this,
                android.R.anim.fade_out);
        out.setDuration(10000);
        textSwitcher.setInAnimation(in);
        textSwitcher.setOutAnimation(out);

		flipButton = (Button) findViewById(R.id.flipButton);
        flipButton.setOnClickListener(flipListener);
        
        textSwitcher.setText(getText(R.string.text_switcher_01));
        flip = false;
	}
}
