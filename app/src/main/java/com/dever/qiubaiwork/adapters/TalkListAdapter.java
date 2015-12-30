package com.dever.qiubaiwork.adapters;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.dever.qiubaiwork.R;
import com.dever.qiubaiwork.entity.TalkList;
import com.dever.qiubaiwork.entity.VideoBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by admin on 2015/12/30.
 */
public class TalkListAdapter extends BaseAdapter {

    private List<TalkList.ItemsEntity> lists;
    private Context context;

    public TalkListAdapter(Context context) {
        this.context = context;
        lists = new ArrayList<TalkList.ItemsEntity>();
    }


    @Override
    public int getCount() {
        Log.d("getFormat", "" + lists.size());
        return lists.size();
    }

    @Override
    public Object getItem(int position) {
        return lists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.talk_item,parent,false);
            convertView.setTag(new ViewHolder(convertView));
        }
        TalkList.ItemsEntity item = lists.get(position);
        ViewHolder holder = (ViewHolder) convertView.getTag();

        holder.talk_icon.setImageURI(Uri.parse(getIconUrl(item.getUser().getIcon(), item.getUser().getId())));
        holder.talk_user.setText(item.getUser().getLogin());
        holder.talk_content.setText(item.getContent());

        long l = System.currentTimeMillis()/1000-item.getCreated_at();
        String str = "";
        /*l/=1000;
        if(l>0){
            str = l+"秒前";
        }*/
        l/=60;
        if(l>0){
            str = l+"分前";
        }
        l/=60;
        if(l>0){
            str = l+"小时前";
        }
        l/=24;
        if(l>0){
            str = l+"天前";
        }
        holder.talk_time.setText(str);
        holder.talk_floor.setText(String.valueOf(item.getFloor()));
        return convertView;
    }

    public class ViewHolder{
        private SimpleDraweeView talk_icon;
        private TextView talk_user,talk_floor,talk_content,talk_time;

        public ViewHolder(View view){
            talk_icon = (SimpleDraweeView) view.findViewById(R.id.talk_icon);
            talk_user = (TextView) view.findViewById(R.id.talk_user);
            talk_content = (TextView) view.findViewById(R.id.talk_content);
            talk_floor = (TextView) view.findViewById(R.id.talk_floor);
            talk_time = (TextView) view.findViewById(R.id.talk_time);
        }
    }
    public static String getIconUrl(String icon,int id){
        String url = "http://pic.qiushibaike.com/system/avtnew/%s/%s/thumb/%s";
        return String.format(url,id/10000,id,icon);
    }

    public void addAll(Collection<? extends TalkList.ItemsEntity> collection){
        lists.addAll(collection);
        notifyDataSetChanged();
    }
}
