package com.lbi.android.test.adapters;

import java.util.ArrayList;

import com.lbi.android.test.R;
import com.lbi.android.test.model.FeaturedItem;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class FeaturedItemArrayAdapter extends ArrayAdapter<FeaturedItem> 
{

	private Context mContext; 
	private int mLayoutResourceId;    
	private ArrayList<FeaturedItem> mItems = null;
    
	public FeaturedItemArrayAdapter(Context context, int layoutResourceId, ArrayList<FeaturedItem> objects) 
	{
		super(context, layoutResourceId, objects);
		
		mContext = context;
		mLayoutResourceId = layoutResourceId;
		mItems = objects;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) 
	{
		View row = convertView;
        ItemHolder holder = null;
        
        if(row == null)
        {
            LayoutInflater inflater = ((Activity)mContext).getLayoutInflater();
            row = inflater.inflate(mLayoutResourceId, parent, false);
            
            holder = new ItemHolder();
            holder.ivImage 		= (ImageView)row.findViewById(R.id.li_ivImage);
            holder.tvTitle 		= (TextView)row.findViewById(R.id.li_tvTitle);
            holder.tvSubTitle 	= (TextView)row.findViewById(R.id.li_tvSubTitle);
            holder.ivIcon		= (ImageView)row.findViewById(R.id.li_ivMediaTypeIcon);
            
            row.setTag(holder);
        }
        else
        {
            holder = (ItemHolder)row.getTag();
        }
        
        FeaturedItem featuredItem = mItems.get(position);
        holder.tvTitle.setText(featuredItem.getTitle());
        holder.tvSubTitle.setText(featuredItem.getSubTitle());
//        holder.ivImage.setImageResource(R.id.yourResourceId); //use reference to your image grabbed from a string-array or other source passed in on creation
        
        
        return row;
	}
	
	static class ItemHolder
    {
        ImageView ivImage;
        TextView tvTitle;
        TextView tvSubTitle;
        ImageView ivIcon;
    }

}
