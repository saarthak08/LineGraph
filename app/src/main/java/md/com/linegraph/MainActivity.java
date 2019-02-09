package md.com.linegraph;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import md.com.linegraph.fragments.MainGraphFragment;

public class MainActivity extends AppCompatActivity {
    public static double a,b,c,d;
    public TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int i;
        super.onCreate(savedInstanceState);
        textView=findViewById(R.id.textView);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().add(R.id.frame_layout,new MainGraphFragment()).commit();
    }
    public static void set(int w,int x,int y,int z)
    {
        a=w;
        b=x;
        c=y;
        d=z;
    }
}
