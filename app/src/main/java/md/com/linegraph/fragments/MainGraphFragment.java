package md.com.linegraph.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.Viewport;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import md.com.linegraph.MainActivity;
import md.com.linegraph.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainGraphFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainGraphFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public MainGraphFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainGraphFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainGraphFragment newInstance(String param1, String param2) {
        MainGraphFragment fragment = new MainGraphFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_graph, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        GraphView graph = (GraphView) getActivity().findViewById(R.id.graph);
        MainActivity.set(1,1,1,1);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(-MainActivity.a, 0),
                new DataPoint(0, 1),
                new DataPoint(MainActivity.b, 1),
                new DataPoint(MainActivity.b,0)

        });
        graph.getViewport().setMinX(-((MainActivity.a)+1));
        graph.getGridLabelRenderer().setHumanRounding(false);
        graph.getViewport().setMaxX((MainActivity.b)+1);
        graph.getViewport().setMinY(-2);
        graph.getViewport().setMaxY(2);
        graph.getGridLabelRenderer().setHorizontalAxisTitle("t");
        graph.getGridLabelRenderer().setHorizontalLabelsVisible(true);
        graph.getGridLabelRenderer().setVerticalLabelsVisible(true);
        graph.getGridLabelRenderer().setHighlightZeroLines(true);
        graph.getGridLabelRenderer().setGridStyle(GridLabelRenderer.GridStyle.BOTH);
        graph.getGridLabelRenderer().setVerticalAxisTitle("f(ct+d)");
        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setXAxisBoundsManual(true);
        series.setAnimated(true);
        series.setDrawDataPoints(true);


        graph.addSeries(series);


        series.setTitle("Line Graph");
    }
}
