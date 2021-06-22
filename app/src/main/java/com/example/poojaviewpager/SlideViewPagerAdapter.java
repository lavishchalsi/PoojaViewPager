package com.example.poojaviewpager;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import org.jetbrains.annotations.NotNull;

public class SlideViewPagerAdapter  extends PagerAdapter {
    public SlideViewPagerAdapter(Context ctx) {
        this.ctx = ctx;
    }

    Context ctx;
    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(@NonNull @NotNull View view, @NonNull @NotNull Object object) {
        return view==object;
    }

    @NonNull
    @NotNull
    @Override//instantiate method is called when we slide the screen
    public Object instantiateItem(@NonNull @NotNull ViewGroup container, int position) {
        LayoutInflater layoutInflater=(LayoutInflater)ctx.getSystemService(ctx.LAYOUT_INFLATER_SERVICE);
 View view=layoutInflater.inflate(R.layout.slide_screen,container,false);

        ImageView logo=view.findViewById(R.id.logo);

        ImageView ind1=view.findViewById(R.id.ind1);
        ImageView ind2=view.findViewById(R.id.ind2);
        ImageView ind3=view.findViewById(R.id.ind3);


        TextView title=view.findViewById(R.id.title);
        TextView desc=view.findViewById(R.id.desc);
        ImageView next=view.findViewById(R.id.next);
        ImageView back=view.findViewById(R.id.back);
        TextView skip =view.findViewById(R.id.textView_skip);
        skip.setOnClickListener(v -> {
            Intent intent=new Intent(ctx,MainActivity.class);
             intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
             ctx.startActivity(intent);
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SlideActivity.viewPager.setCurrentItem(position+1);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SlideActivity.viewPager.setCurrentItem(position-1);
            }
        });
switch (position){
    case 0:
logo.setImageResource(R.drawable.yarleyumpic);
ind1.setImageResource(R.drawable.selected);
ind2.setImageResource(R.drawable.unselected);
ind3.setImageResource(R.drawable.unselected);
back.setVisibility(View.GONE);
next.setVisibility(View.VISIBLE);
title.setText("YarleYum");
desc.setText("A puff manufacturing company with 100% assured quality products");
break;
case 1:
        logo.setImageResource(R.drawable.yarleyumpic);
        ind1.setImageResource(R.drawable.unselected);
        ind2.setImageResource(R.drawable.selected);
        ind3.setImageResource(R.drawable.unselected);

        title.setText("YarleYum");
        desc.setText("A platform where you can place order for products");
        back.setVisibility(View.VISIBLE);
        next.setVisibility(View.VISIBLE);
        break;
    case 2:
        logo.setImageResource(R.drawable.yarleyumpic);
        ind1.setImageResource(R.drawable.unselected);
        ind2.setImageResource(R.drawable.unselected);
        ind3.setImageResource(R.drawable.selected);

        title.setText("YarleYum");
        desc.setText("A Platform where you can get knowledge about our products and company.");
        back.setVisibility(View.VISIBLE);
        next.setVisibility(View.GONE);
        break;
}

     container.addView(view);
       return view;

    }

    @Override
    public void destroyItem(@NonNull @NotNull ViewGroup container, int position, @NonNull @NotNull Object object) {
        container.removeView((View)object);
    }
}
