package com.benxiang.noodles;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.benxiang.noodles.base.BaseActivity;
import com.squareup.picasso.Picasso;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.wrapper.EmptyWrapper;
import com.zhy.adapter.recyclerview.wrapper.HeaderAndFooterWrapper;
import com.zhy.adapter.recyclerview.wrapper.LoadmoreWrapper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 刘圣如 on 2017/9/1.
 */

public class TestActivity extends BaseActivity {
    @BindView(R.id.iv_test)
    ImageView view;
    @BindView(R.id.tv_test)
    TextView tv_test;
    private List<String> mDatas = new ArrayList<>();


    private RecyclerView mRecyclerView;
    private CommonAdapter<String> mAdapter;
    private HeaderAndFooterWrapper mHeaderAndFooterWrapper;
    private EmptyWrapper mEmptyWrapper;
    private LoadmoreWrapper mLoadMoreWrapper;
    private String merhod = "ClearRecord";
    private String account = "emian";
    private String token = "Token";
    private String tokenType = "xor";
    private String URL = "http://112.124.121.3:8022/";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.testcolor);
        ButterKnife.bind(this);
        tv_test.setText(Html.fromHtml(getString(R.string.noodles_make_competle,1,"啦啦面")));
        Picasso.with(AppApplication.getAppContext())
                .load(R.drawable.code_bg)
                .resize(200, 200)
                .centerCrop()
                .into(view);
        showWarningDialog("确定",getString(R.string.noodles_make_competle,1,"啦啦面"),true,false);

       /* ReParameterTest test=new ReParameterTest();
        test.shopCode = "0001";
        Log.e("LALAL ", "encrypt: "+JsonHelper.getGson().toJson(test) );
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), JsonHelper.getGson().toJson(test));
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MediaType.parse("multipart/form-data"));
     *//*   builder.addFormDataPart("Method",merhod);
        builder.addFormDataPart("account", account);
        builder.addFormDataPart("Token",encrypt(jiabmi(),"1234567812345678"));
        builder.addFormDataPart("TokenType",tokenType);*//*
        builder.addFormDataPart("Method","ClearRecord");
        builder.addFormDataPart("account", "emian");
        builder.addFormDataPart("Token",encrypt(jiabmi(),"1234567812345678"));
        builder.addFormDataPart("TokenType","xor");
        builder.addFormDataPart("ReParameter",JsonHelper.getGson().toJson(test));
        MultipartBody multipartBody = builder.build();


        //map

        HashMap<String, String> map = new HashMap<>();
        map.put("Method",merhod);
        map.put("account", account);
        map.put("Token",encrypt(jiabmi(),"1234567812345678"));
        map.put("TokenType",tokenType);
        map.put("ReParameter",JsonHelper.getGson().toJson(test));
        ApiFactory.getInitchargingPieApi()
                .uploadGuestInfo(map)
                .compose(RxUtil.<CommonModel>toMain())
                .subscribe(new DefaultObserver<CommonModel>() {
                    @Override
                    public void onNext(CommonModel merchantModel) {

                            Log.e("啦啦啦", "onNext: "+merchantModel.status+">>>>"+merchantModel.strRes );

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });*/


    }

    @Override
    public int getContentViewID() {
        return R.layout.testcolor;
    }

    @Override
    protected void afterContentViewSet() {

    }

    public String jiabmi() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currentTime = new Date();
        String dateString = formatter.format(currentTime);
//        System.out.println(dateString.replace(":", "").replace("-", ""));
//        System.out.println(dateString);
//        return dateString.replace(":", "").replace("-", "");
        Log.e(">>>", "jiabmi: " + dateString);
        return dateString;
    }

    public String encrypt(String data, String key) {
        byte[] bytes = data.getBytes();
        byte[] bytekey = key.getBytes();
        if (bytes == null) {
            return null;
        }

        int len = bytes.length;
        String result = "";
        int j = 0;
        for (int i = 0; i < len; i++) {
//            result+=Integer.toHexString(bytes[i]^bytekey[j]);
            result += String.format("%02x", bytes[i] ^ bytekey[j]).toUpperCase();
            j = (j + 1) % 8;
        }
        Log.e("LALAL ", "encrypt: " + result);
//        System.out.println(result);

        return result;
    }

    private void initDatas() {
        for (int i = 0; i <= 100; i++) {
            mDatas.add(i + "");
        }
    }

    /* private void initDatas()
     {
         for (int i = 'A'; i <= 'z'; i++)
         {
             mDatas.add((char) i + "");
         }
     }*/
    private void initHeaderAndFooter() {
        mHeaderAndFooterWrapper = new HeaderAndFooterWrapper(mAdapter);

      /*  TextView t1 = new TextView(this);
        t1.setText("Header 1");
        TextView t2 = new TextView(this);
        t2.setText("Header 2");
        mHeaderAndFooterWrapper.addHeaderView(t1);
        mHeaderAndFooterWrapper.addHeaderView(t2);*/
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
