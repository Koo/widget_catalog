package com.memazou.android.widgets;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class ImageSwitcherActivity extends Activity {

	private ImageSwitcher imageSwitcher;
	private Button flipButton;
	private boolean flip;
	private Drawable drawable1;
	private Drawable drawable2;

	private View.OnClickListener flipListener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			if (flip) {
				imageSwitcher.setImageDrawable(drawable1);
			} else {
				imageSwitcher.setImageDrawable(drawable2);
			}
			flip = !flip;
		}
	};
	
	private ViewSwitcher.ViewFactory viewFactory = new ViewSwitcher.ViewFactory() {
		@Override
		public View makeView() {
	        ImageView view = new ImageView(ImageSwitcherActivity.this);
	        view.setScaleType(ImageView.ScaleType.FIT_XY);
	        return view;
		}
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.image_switcher);
		
		imageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);
        imageSwitcher.setFactory(viewFactory);

        drawable1 = getResources().getDrawable(R.drawable.neko1);
        drawable2 = getResources().getDrawable(R.drawable.neko2);

        Animation in = AnimationUtils.loadAnimation(this,
				android.R.anim.fade_in);
        in.setDuration(10000);
        Animation out = AnimationUtils.loadAnimation(this,
                android.R.anim.fade_out);
        out.setDuration(10000);
        imageSwitcher.setInAnimation(in);
        imageSwitcher.setOutAnimation(out);

		flipButton = (Button) findViewById(R.id.flipButton);
        flipButton.setOnClickListener(flipListener);
        
        imageSwitcher.setImageDrawable(drawable1);
        flip = false;
	}
}
