package com.archer.frescochatimage;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;


/**
 * 图片加载适配器
 * Created by 84113 on 2017/2/18.
 */

 class MyAdapter extends RecyclerView.Adapter<MyAdapter.ImageViewHolder> {

    private static final int TYPE_LEFT = 0;
    private static final int TYPE_RIGHT = 1;
    List<String> list;

    public MyAdapter(Context mContext, List<String> list) {
        this.list = list;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent , int viewType) {
        final LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
        final View sView;
        switch (viewType) {
            case TYPE_LEFT:
                sView = mInflater.inflate(R.layout.image_item_left, parent, false);
                return new LeftImageViewHolder(sView);
            case TYPE_RIGHT:
                sView = mInflater.inflate(R.layout.image_item_right, parent, false);
                return new RightImageViewHolder(sView);
            default:
                sView = mInflater.inflate(R.layout.image_item_left, parent, false);
                return new LeftImageViewHolder(sView);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(position % 2 == 0) {
            return TYPE_LEFT;
        } else {
            return TYPE_RIGHT;
        }
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        Uri uri = Uri.parse(list.get(position));
        holder.simpleDraweeView.setImageURI(uri);

        if(holder instanceof LeftImageViewHolder) {
            holder.headSimple.setImageURI(Uri.parse("http://imgsrc.baidu.com/forum/w%3D580/sign=253480f8352ac65c6" +
                    "705667bcbf3b21d/f6eaaf51f3deb48f93e7fd46f01f3a292cf578af.jpg"));
        } else {
            holder.headSimple.setImageURI(Uri.parse("http://www.ce.cn/xwzx/gjss/gjtu/200711/16/W020" +
                    "071116360307599557.jpg"));
        }

        holder.simpleDraweeView.setImageURI(uri);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ImageViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView simpleDraweeView, headSimple;
        ImageViewHolder(View itemView) {
            super(itemView);
            headSimple = (SimpleDraweeView) itemView.findViewById(R.id.head);
            simpleDraweeView = (SimpleDraweeView) itemView.findViewById(R.id.simple_drawee_view);
        }
    }

    private class LeftImageViewHolder extends ImageViewHolder {
        LeftImageViewHolder(View view) {
            super(view);
        }
    }

    private class RightImageViewHolder extends ImageViewHolder {
        RightImageViewHolder(View view) {
            super(view);
        }
    }

}