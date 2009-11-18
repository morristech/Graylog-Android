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

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.jimdo.graylog.LogListAdapter;
import com.jimdo.graylog.R;

/**
 * Shows a list of log messages
 * 
 * @author Sebastian Kaspari <s.kaspari@googlemail.com>
 */
public class MessagesActivity extends ListActivity {
	private LogListAdapter adapter;
	
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        
        String baseUrl = getIntent().getExtras().getString("baseUrl");
        
        adapter = new LogListAdapter(baseUrl);
        setListAdapter(adapter);
		
        setContentView(R.layout.logs);
    }
    
	/**
	 * Options Menu
	 * 
	 * @param menu 
	 */
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.messages, menu);

	    return true;
	}
    
    /**
     * On options item selected
     * 
     * @param item
     */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.refresh:
				adapter.refresh();
				break;
		}
		return true;
	}
}