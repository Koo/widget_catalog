package com.memazou.android.widgets;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class AutoCompleteTextViewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.auto_complete_text_view);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, CITYS);
        AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.AutoCompleteTextView01);
        textView.setAdapter(adapter);

	}

    static final String[] CITYS = new String[] {
    	"Tokyo", "Osaka", "Saitama", "Nagoya"
    };
}
