package com.dever.qiubaiwork.fragments;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.dever.qiubaiwork.InfoActivity;
import com.dever.qiubaiwork.QsService;
import com.dever.qiubaiwork.R;
import com.dever.qiubaiwork.adapters.ListArticleAdapter;
import com.dever.qiubaiwork.entity.Item;
import com.dever.qiubaiwork.entity.VideoBean;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import in.srain.cube.views.ptr.header.StoreHouseHeader;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArticleFragment extends Fragment implements Callback<VideoBean>, AdapterView.OnItemClickListener, View.OnClickListener,PullToRefreshListView.OnRefreshListener2<ListView>{

    private PullToRefreshListView lv;
    private Call<VideoBean> call;
    private ListArticleAdapter adapter;
    private QsService service;
    private String type = "suggest";
    private int page =1;

    public ArticleFragment() {
        // Required empty public constructor
    }

    public static ArticleFragment newInstance() {

        Bundle args = new Bundle();

        ArticleFragment fragment = new ArticleFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_article, container, false);
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        lv = (PullToRefreshListView) view.findViewById(R.id.lv);

        adapter = new ListArticleAdapter(getContext());
        lv.setAdapter(adapter);
        adapter.setOnClickListener(this);
        Retrofit build = new Retrofit.Builder().baseUrl("http://m2.qiushibaike.com").addConverterFactory(GsonConverterFactory.create()).build();
        service = build.create(QsService.class);

        Bundle bundle = getArguments();
        String name = bundle.getString("name");

        switch (name){
            case "专享":
                type = "suggest";
                break;
            case "视频":
                type = "video";
                break;
            case "纯文":
                type = "text";
                break;
            case "纯图":
                type = "image";
                break;
            case "最新":
                type = "latest";
                break;
        }
        call = service.getList(type, page);
        call.enqueue(this);
        lv.setMode(PullToRefreshBase.Mode.BOTH);
        lv.setOnRefreshListener(this);
        //lv.setOnItemClickListener(this);
    }

    @Override
    public void onResponse(Response<VideoBean> response, Retrofit retrofit) {
        if(page==1){
            adapter.clear();
        }
        adapter.addAll(response.body().getItems());
        lv.onRefreshComplete();

    }

    @Override
    public void onFailure(Throwable t) {
        t.printStackTrace();
        Toast.makeText(getContext(),"网络问题",Toast.LENGTH_SHORT).show();
        lv.onRefreshComplete();
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        VideoBean.ItemsEntity item = (VideoBean.ItemsEntity) adapter.getItem(position);
        Intent intent = new Intent(getActivity(), InfoActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("id",item.getId());
        intent.putExtras(bundle);
        startActivity(intent);

    }

    @Override
    public void onClick(View v) {
        Object tag = v.getTag();
        int position =-1;
        if(tag!=null&&tag instanceof Integer){
            position = (int)tag;
        }
        VideoBean.ItemsEntity item = (VideoBean.ItemsEntity) adapter.getItem(position);
        Intent intent = new Intent(getActivity(), InfoActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("id",item.getId());
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
        service.getList(type,page).enqueue(this);
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
        service.getList(type,(page++)).enqueue(this);
    }
}
