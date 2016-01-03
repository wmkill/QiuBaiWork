package com.dever.qiubaiwork.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dever.qiubaiwork.CircleTransform;
import com.dever.qiubaiwork.R;
import com.dever.qiubaiwork.entity.Item;
import com.dever.qiubaiwork.entity.VideoBean;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by admin on 2015/12/29.
 */
public class ListArticleAdapter extends BaseAdapter {

    private Context context;
    private int netType;
    private List<VideoBean.ItemsEntity> list;
    private View.OnClickListener onClickListener;

    public void setOnClickListener(View.OnClickListener onClickListener){
        this.onClickListener = onClickListener;
    }
    public ListArticleAdapter(Context context){
        this.context = context;
        list = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.list_article,parent,false);
            convertView.setTag(new ViewHolder(convertView));
        }

        VideoBean.ItemsEntity item = list.get(position);
        ViewHolder holder = (ViewHolder) convertView.getTag();

        if(item.getUser()!=null){
            holder.user_icons.setImageURI(Uri.parse(getIconUrl(item.getUser().getIcon(),item.getUser().getId())));
            //Picasso.with(context).load(getIconUrl(item.getUser().getIcon(),item.getUser().getId())).transform(new CircleTransform()).into(holder.user_icons);
            holder.user_name.setText(item.getUser().getLogin());
        }else{
            //Picasso.with(context).load(R.mipmap.qb_mask).transform(new CircleTransform()).into(holder.user_icons);
            holder.user_name.setText("匿名用户");
        }

        if(item.getContent()!=null){
            holder.content.setText(item.getContent());
        }

        if(item.getFormat().equals("video")){
            if(item.getPic_url()!=null){
                holder.image.setVisibility(View.VISIBLE);
                Picasso.with(context)
                        .load(item.getPic_url())
                        //.resize(parent.getWidth(),0)
                        .placeholder(R.mipmap.fail_img)
                        .error(R.mipmap.fail_img)
                        .into(holder.image);
            }else{
                holder.image.setVisibility(View.GONE);
            }
        }else if(item.getFormat().equals("image")){
            if(item.getImage()!=null){
                holder.image.setVisibility(View.VISIBLE);
                Picasso.with(context)
                        .load(getImageUrl((String) item.getImage()))
                                //.resize(parent.getWidth(),200)
                        .placeholder(R.mipmap.fail_img)
                        .error(R.mipmap.fail_img)
                        .into(holder.image);
            }else{
                holder.image.setVisibility(View.GONE);
            }
        }else{
            holder.image.setVisibility(View.GONE);
        }


        holder.happy.setText("好笑 "+item.getVotes().getUp());
        holder.talk.setText("评论 " + item.getComments_count());
        holder.share.setText("分享 " + item.getShare_count());

        holder.layout.setTag(position);
        holder.operation_more.setTag(position);

        return convertView;
    }

    private String getImgSize(){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        String imgSize = "small";
        // TODO: 2015/12/29  网络状态监测
        if(activeNetworkInfo.getType()==ConnectivityManager.TYPE_WIFI){
            imgSize = "medium";//wifi网络
        }else{
            imgSize = "small";//手机网络
        }
        return imgSize;
    }

    public String getImageUrl(String image) {
        String url = "http://pic.qiushibaike.com/system/pictures/%s/%s/%s/%s";
        Pattern pattern = Pattern.compile("(\\d+)\\d{4}");
        Matcher matcher = pattern.matcher(image);
        matcher.find();

        return String.format(url,matcher.group(1),matcher.group(),getImgSize(),image);
    }

    public static String getIconUrl(String icon,int id){
        String url = "http://pic.qiushibaike.com/system/avtnew/%s/%s/thumb/%s";
        return String.format(url,id/10000,id,icon);
    }
    public class ViewHolder{
        private TextView user_name,content,happy,talk,share;
        private ImageView user_icons,image,operation_more;
        private LinearLayout layout;

        public ViewHolder(View view){
            user_name = (TextView) view.findViewById(R.id.user_name);
            user_icons = (ImageView) view.findViewById(R.id.user_icons);
            content = (TextView) view.findViewById(R.id.content);
            image = (ImageView) view.findViewById(R.id.image);
            happy = (TextView) view.findViewById(R.id.happy);
            talk = (TextView) view.findViewById(R.id.talk);
            share = (TextView) view.findViewById(R.id.share);
            layout = (LinearLayout) view.findViewById(R.id.content_click);
            operation_more = (ImageView) view.findViewById(R.id.operation_more);
            layout.setOnClickListener(onClickListener);
            operation_more.setOnClickListener(onClickListener);
        }
    }
    public void addAll(Collection<? extends VideoBean.ItemsEntity> collection){
        list.addAll(collection);
        notifyDataSetChanged();
    }

    public void clear(){
        list.clear();
        notifyDataSetChanged();
    }
}
