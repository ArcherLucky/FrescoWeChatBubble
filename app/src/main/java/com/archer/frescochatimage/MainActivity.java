package com.archer.frescochatimage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        List<String> list = new ArrayList<>();
        for(int i = 0; i < 100; i++) {
            if(i % 2 == 0) {
                list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1" +
                        "487425883994&di=12a5c8a764325de8f3048566d4d466c6&imgtype=0&src=http%3A%2F%2Fg" +
                        ".hiphotos.baidu.com%2Fimgad%2Fpic%2Fitem%2Ff603918fa0ec08fa9f0b7dd85eee3d6d55fbda42.jpg");
            } else {
                list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1487425" +
                        "943259&di=edf6a494a3f0b9c52e17cdfeda9925f1&imgtype=0&src=http%3A%2F%2Fimg01.qulishi." +
                        "com%2F2016-08%2F16%2F57b30121%2F57b301210a54c9dc1859161c%2F1471349217075_886463.jpg");
            }
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(), list));

    }
}
