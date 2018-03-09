package com.example.peanut.reviewmyskill.activities;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;


import com.example.peanut.reviewmyskill.R;
import com.example.peanut.reviewmyskill.adptor.Fragment_adapter;
import com.example.peanut.reviewmyskill.fragment_1.Fragment_center;
import com.example.peanut.reviewmyskill.fragment_1.Fragment_mine;
import com.example.peanut.reviewmyskill.fragment_1.Fragment_relations;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {


    private Fragment_adapter fragment_adapter;
    private ViewPager viewPager;
    private List<Fragment> fragmentList=new ArrayList<>();

    private Fragment_mine fragment_mine=new Fragment_mine();
    private Fragment_center fragment_center=new Fragment_center();
    private Fragment_relations fragment_relations=new Fragment_relations();

    private ImageButton actionbar_mine,actiongbar_center,actionbar_relasions,drawer_switch;

    private DrawerLayout drawerLayout;

    private LinearLayout msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initial();
        initialFragmentList();

        fragment_adapter =new Fragment_adapter(getSupportFragmentManager(),fragmentList);
        viewPager.setAdapter(fragment_adapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                InitialActionbarImg();
                switch (position){
                    case 0:actionbar_mine.setImageResource(R.drawable.icon_mine_press);break;
                    case 1:actiongbar_center.setImageResource(R.drawable.icon_center_press);break;
                    case 2:actionbar_relasions.setImageResource(R.drawable.icon_relasions_press);break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        actionbar_mine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(0);
            }
        });
        actiongbar_center.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(1);
            }
        });
        actionbar_relasions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(2);
            }
        });


        drawer_switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });

        msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"我的消息",Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawers();

            }
        });

    }
    //初始化控件
    public void initial(){
        viewPager=findViewById(R.id.viewpager_main);

        actionbar_mine=findViewById(R.id.actionbar_mine);
        actiongbar_center=findViewById(R.id.actionbar_center);
        actionbar_relasions=findViewById(R.id.actionbar_relations);

        drawer_switch=findViewById(R.id.actionbar_darwer);
        drawerLayout=findViewById(R.id.drawer_layout);

        msg=findViewById(R.id.menu_msg);

        actionbar_mine.setImageResource(R.drawable.icon_mine_press);
    }

    //添加fragment
    public void initialFragmentList(){
        fragmentList.add(fragment_mine);
        fragmentList.add(fragment_center);
        fragmentList.add(fragment_relations);
    }

    //重置顶部图片状态
    public void InitialActionbarImg(){
        actionbar_mine.setImageResource(R.drawable.icon_mine);
        actiongbar_center.setImageResource(R.drawable.icon_center);
        actionbar_relasions.setImageResource(R.drawable.icon_relasions);
    }

}
