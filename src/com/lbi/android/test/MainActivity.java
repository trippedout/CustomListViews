package com.lbi.android.test;

import java.util.ArrayList;

import com.lbi.android.test.adapters.FeaturedItemArrayAdapter;
import com.lbi.android.test.model.FeaturedItem;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MainActivity extends Activity implements OnItemClickListener, OnScrollListener {
	
    private static final String TAG = "MainActivity";
	private static final int TOTAL_ITEMS = 15;
    
	private ListView mListView;
	private FeaturedItemArrayAdapter mAdapter;

	private int mFirstVisibleItem;
	private int mVisibleItemCount;
	private int mScrollState;

	@Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        initListView();
    }

	private void initListView() 
	{
		ArrayList<FeaturedItem> featuredItems = new ArrayList<FeaturedItem>();
		
		for( int i = 0; i < TOTAL_ITEMS; ++i )
		{
			FeaturedItem fi = new FeaturedItem();
			
			fi.setContentType("music");
			fi.setImgUrl("http://www.trippedout.net/image" + i + ".png");
			fi.setSubTitle("Happening on June " + (i+5) + "!");
			fi.setTitle("USHER LIVE " + (i+1) + " streaming concert");
			
			featuredItems.add(fi);
		}
		
		mListView		=	(ListView) findViewById(R.id.lv_mainList);
		mAdapter		=	new FeaturedItemArrayAdapter(this, R.layout.custom_list_item, featuredItems);
		mListView.setAdapter(mAdapter);
		
		mListView.setOnItemClickListener(this);
		mListView.setOnScrollListener(this);
		
		mFirstVisibleItem		=	((AbsListView)mListView).getFirstVisiblePosition();
		mVisibleItemCount		=	((AbsListView)mListView).getLastVisiblePosition() - mFirstVisibleItem;
		
		Log.d(TAG, "mFirstVisibleItem: " + mFirstVisibleItem + " mVisibleItemCount:" + mVisibleItemCount);
	}

	// ------------------------------------------------------------------------------------------------------------------------------
	// event handlers
	// ------------------------------------------------------------------------------------------------------------------------------
	

	public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) 
	{
		Log.d(TAG, "onItemClick() adapter: " + adapterView + " view: " + view + " position: " + position + " id:" + id); 
	}

	public void onScroll(AbsListView arg0, int firstVisibleItem, int arg2, int arg3) 
	{
		Log.d(TAG, "onScroll() + view: " + arg0 + " firstVisibleItem: " + firstVisibleItem + " visibleItemCount: " + arg2 + " totalItems: " + arg3 );
		
		if( firstVisibleItem != mFirstVisibleItem )
		{
			mFirstVisibleItem = firstVisibleItem;
			notifyScrollingUpdate();
		}
	}

	public void onScrollStateChanged(AbsListView view, int state) 
	{
		Log.d(TAG, "onScroll() + view: " + view + " state: " + state );
		
		mScrollState = state;
		notifyScrollingUpdate();
	}

	private void notifyScrollingUpdate() 
	{
		Log.d(TAG, "notifyScrollingUpdate() state: " + mScrollState + " firstVis: " + mFirstVisibleItem);
		
		switch(mScrollState)
		{
		case AbsListView.OnScrollListener.SCROLL_STATE_FLING:
			break;
		case AbsListView.OnScrollListener.SCROLL_STATE_IDLE:
			break;
		case AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL:
			break;
		}
	}

}