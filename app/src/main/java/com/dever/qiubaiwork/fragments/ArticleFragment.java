package com.dever.qiubaiwork.fragments;


import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArticleFragment extends Fragment implements Callback<Item>, AdapterView.OnItemClickListener {

    private ListView lv;
    private Call<Item> call;
    private ListArticleAdapter adapter;

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

        lv = (ListView) view.findViewById(R.id.lv);

        adapter = new ListArticleAdapter(getContext());
        lv.setAdapter(adapter);
        Retrofit build = new Retrofit.Builder().baseUrl("http://m2.qiushibaike.com").addConverterFactory(GsonConverterFactory.create()).build();
        QsService service = build.create(QsService.class);

        Bundle bundle = getArguments();
        String name = bundle.getString("name");
        String type = "suggest";
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
        call = service.getList(type, 1);
        call.enqueue(this);

        lv.setOnItemClickListener(this);
    }

    @Override
    public void onResponse(Response<Item> response, Retrofit retrofit) {
        adapter.addAll(response.body().getItems());
    }

    @Override
    public void onFailure(Throwable t) {
        t.printStackTrace();
        Toast.makeText(getContext(),"网络问题",Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Item.ItemsEntity item = (Item.ItemsEntity) adapter.getItem(position);
        Intent intent = new Intent(getActivity(), InfoActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("id",item.getId());
        intent.putExtras(bundle);
        startActivity(intent);

    }
}
