package com.xidian.xienong.adapter;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.xidian.xienong.R;
import com.xidian.xienong.model.MachineImage;

import java.util.List;

public class MachineDetailImageAdapter extends BaseAdapter{
	private Context mContext;
	private List<MachineImage> list;
	private LayoutInflater mInflater;
	private boolean isShowDelete;
	
	public MachineDetailImageAdapter(Context mContext, List<MachineImage> list) {
		super();
		this.mContext = mContext;
		this.list = list;
		mInflater = LayoutInflater.from(mContext);
	}
	
	public void setList(List<MachineImage> lists) {
		this.list = lists;
	}
	
	public void setIsShowDelete(boolean isShowDelete) {
		this.isShowDelete = isShowDelete;
		notifyDataSetChanged();
		Log.i("kmj","--setIsShowDelete---"+ isShowDelete);
	}
	

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.machine_image_item_2, parent, false);
			holder.image = (ImageView) convertView.findViewById(R.id.item_machine_image_2);
			holder.clearButton = (ImageView)convertView.findViewById(R.id.item_clear);
			
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.clearButton.setVisibility(isShowDelete ? View.VISIBLE : View.GONE);
		Glide.with(mContext).load(list.get(position).getUrl()).centerCrop().placeholder(R.drawable.empty_picture).into(holder.image);
		return convertView;
	}
	
	
	class ViewHolder {
		ImageView image;
		ImageView clearButton;
	}

}