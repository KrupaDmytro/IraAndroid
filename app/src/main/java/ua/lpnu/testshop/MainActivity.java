package ua.lpnu.testshop;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;

import java.util.Vector;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    ViewGroup m_my_list;
    LocalDatabase m_local_db;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        m_my_list = (ViewGroup)findViewById(R.id.list);
        m_local_db = new LocalDatabase(getApplicationContext());

        LayoutInflater l = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        Vector<String> strings = m_local_db.getItems();
        if(strings.isEmpty()) {
            strings.add("Requirements for the Ukrainian currency transfers decreased");
            strings.add("The end of the dream of Europe");
            strings.add("How take photograph people who are asleep.");
            m_local_db.fillDb(strings);
        }

        for(String s : strings)
        {
            View item = l.inflate( R.layout.list_item, null);
            ((TextView)item.findViewById(R.id.itemtext)).setText(s);
            item.findViewById(R.id.morebutton).setOnClickListener(this);
            m_my_list.addView(item);
        }

        findViewById(R.id.detail).setOnClickListener(this);

        findViewById(R.id.detail).setOnClickListener(this);
        ((Button) findViewById(R.id.shitbatton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShitActivity.class);
                startActivity(intent);
              }
        });
    }

    public void onClick(View v)
    {

        if (v.getId() == R.id.morebutton)
        {
            View detailview = findViewById(R.id.detail);
            float width = findViewById(R.id.main_layout).getWidth();
            TranslateAnimation anim = new TranslateAnimation(width, 0.0f, 0.0f, 0.0f);
            anim.setDuration(300);
            anim.setFillAfter(true);
            detailview.bringToFront();
            detailview.startAnimation(anim);
            detailview.setVisibility(View.VISIBLE);
            detailview.setEnabled(true);
        }
        else if (v.getId() == R.id.detail)
        {
            View detailview = v;
            TranslateAnimation anim = new TranslateAnimation(0.0f, detailview.getWidth(), 0.0f, 0.0f);
            anim.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {}

                @Override
                public void onAnimationEnd(Animation animation) {
                    findViewById(R.id.listview).bringToFront();
                }

                @Override
                public void onAnimationRepeat(Animation animation) {}
            });
            anim.setDuration(300);
            anim.setFillAfter(true);
            detailview.startAnimation(anim);
            detailview.setEnabled(false);
        }

    }
}
