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
/**
 * Created by dima- on 14.04.2016.
 */
public class ShitActivity extends AppCompatActivity implements View.OnClickListener
{

    ViewGroup m_my_list;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        m_my_list = (ViewGroup)findViewById(R.id.list);

        LayoutInflater l = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        Vector<String> strings = new Vector<String>();

        strings.add("All news");
        strings.add("Lviv news");
        strings.add("Policy");

        for(String s : strings)
        {
            View item = l.inflate( R.layout.list_item, null);
            ((TextView)item.findViewById(R.id.itemtext)).setText(s);
            item.findViewById(R.id.morebutton).setOnClickListener(this);
            m_my_list.addView(item);
        }

;
    }

    @Override
    public void onClick(View v) {

    }
}
