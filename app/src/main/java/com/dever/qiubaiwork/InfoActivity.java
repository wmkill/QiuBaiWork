package com.dever.qiubaiwork;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.dever.qiubaiwork.adapters.ListArticleAdapter;
import com.dever.qiubaiwork.adapters.TalkListAdapter;
import com.dever.qiubaiwork.entity.ItemInfo;
import com.dever.qiubaiwork.entity.TalkList;
import com.dever.qiubaiwork.fragments.ArticleFragment;
import com.squareup.picasso.Picasso;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class InfoActivity extends AppCompatActivity {
    private TextView info_name,info_content,info_happy,info_talk,info_share;
    private ImageView info_image,info_icon;
    private ListView lv;
    private TalkListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        info_name = (TextView) findViewById(R.id.info_name);
        info_icon = (ImageView) findViewById(R.id.info_icon);
        info_content = (TextView) findViewById(R.id.info_content);
        info_image = (ImageView) findViewById(R.id.info_image);
        info_happy = (TextView) findViewById(R.id.info_happy);
        info_talk = (TextView) findViewById(R.id.info_talk);
        info_share = (TextView) findViewById(R.id.info_share);
        lv = (ListView) findViewById(R.id.list_talk);
        adapter = new TalkListAdapter(this);
        lv.setAdapter(adapter);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int id = bundle.getInt("id");
        /*Toast.makeText(this,""+id,Toast.LENGTH_SHORT).show();*/
        Retrofit build = new Retrofit.Builder().baseUrl("http://m2.qiushibaike.com").addConverterFactory(GsonConverterFactory.create()).build();
        QsService qsService = build.create(QsService.class);
        Call<ItemInfo> info = qsService.getInfo(String.valueOf(id));
        info.enqueue(new Callback<ItemInfo>() {
            @Override
            public void onResponse(Response<ItemInfo> response, Retrofit retrofit) {
                ItemInfo.ArticleEntity article = response.body().getArticle();
                if(article.getUser()!=null){
                    info_name.setText(article.getUser().getLogin());
                    Picasso.with(getApplication()).load(ListArticleAdapter.getIconUrl(article.getUser().getIcon(), article.getUser().getId())).transform(new CircleTransform()).into(info_icon);
                }else{
                    info_name.setText("匿名用户");
                    Picasso.with(getApplication()).load(R.mipmap.qb_mask).transform(new CircleTransform()).into(info_icon);
                }
                if(article.getContent()!=null){
                    info_content.setText(article.getContent());
                }else{
                    info_content.setVisibility(View.GONE);
                }

                if(article.getFormat().equals("video")){
                    if(article.getPic_url()!=null){
                        info_image.setVisibility(View.VISIBLE);
                        Picasso.with(getApplication())
                                .load(article.getPic_url())
                                        //.resize(parent.getWidth(),0)
                                .placeholder(R.mipmap.fail_img)
                                .error(R.mipmap.fail_img)
                                .into(info_image);
                    }else{
                        info_image.setVisibility(View.GONE);
                    }
                }else if(article.getFormat().equals("image")){
                    if(article.getImage()!=null){
                        info_image.setVisibility(View.VISIBLE);
                        Picasso.with(getApplication())
                                .load(getImageUrl((String) article.getImage()))
                                        //.resize(parent.getWidth(),200)
                                .placeholder(R.mipmap.fail_img)
                                .error(R.mipmap.fail_img)
                                .into(info_image);
                    }else{

                    }
                }else{
                    info_image.setVisibility(View.GONE);
                }

                info_happy.setText("好笑 "+article.getVotes().getUp());
                info_talk.setText("评论 "+article.getComments_count());
                info_share.setText("分享 " + article.getShare_count());
            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
                Toast.makeText(getApplication(),"网络问题",Toast.LENGTH_SHORT).show();
            }
        });


        Call<TalkList> talkListCall = qsService.getTalk(String.valueOf(id),1);
        talkListCall.enqueue(new Callback<TalkList>() {
            @Override
            public void onResponse(Response<TalkList> response, Retrofit retrofit) {
                adapter.addAll(response.body().getItems());
            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
                Toast.makeText(getApplication(),"网络问题",Toast.LENGTH_SHORT).show();
            }
        });

    }

    private String getImgSize(){
        ConnectivityManager connectivityManager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
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

        return String.format(url, matcher.group(1), matcher.group(), getImgSize(), image);
    }
}
