/*
Graylog - Android Client

Copyright 2009 Sebastian Kaspari

This file is part of Graylog (Android Client).

Graylog (Android Client) is free software: you can redistribute it
and/or modify it under the terms of the GNU General Public License
as published by the Free Software Foundation, either version 3 of
the License, or (at your option) any later version.

Graylog (Android Client) is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Graylog (Android Client). If not, see <http://www.gnu.org/licenses/>.
*/
package com.jimdo.graylog.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.jimdo.graylog.R;
import com.jimdo.graylog.model.Filter;

/**
 * Activity for Filter "Search"
 * 
 * @author Sebastian Kaspari <s.kaspari@googlemail.com>
 */
public class FilterActivity extends Activity implements OnClickListener {
	@Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filter);
        
        // Set filter if used before
        Filter filter = (Filter) getIntent().getExtras().get("filter");
        if (filter != null) {
        	((TextView) findViewById(R.id.host)).setText(filter.getHost());
        	((TextView) findViewById(R.id.message)).setText(filter.getMessage());
        }
        
        findViewById(R.id.filter).setOnClickListener(this);
    }
	
	/**
	 * On filter..
	 */
	public void onClick(View v) {
		Filter filter = new Filter();
		filter.setHost(((TextView) findViewById(R.id.host)).getText().toString());
		filter.setMessage(((TextView) findViewById(R.id.message)).getText().toString());
		
		Intent intent = new Intent();
		intent.putExtra("filter", filter);
		
		setResult(RESULT_OK, intent);
		
		this.finish();
	}
}
