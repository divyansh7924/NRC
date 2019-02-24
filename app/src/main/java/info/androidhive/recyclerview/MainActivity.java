package info.androidhive.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Center> centerList = new ArrayList<>();
    private RecyclerView recyclerView;
    private CentersAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new CentersAdapter(centerList);

        recyclerView.setHasFixedSize(true);

        // vertical RecyclerView
        // keep center_list_row.xml width to `match_parent`
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());

        // horizontal RecyclerView
        // keep center_list_row.xml width to `wrap_content`
        // RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(mLayoutManager);

        // adding inbuilt divider line
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        // adding custom divider line with padding 16dp
        // recyclerView.addItemDecoration(new MyDividerItemDecoration(this, LinearLayoutManager.HORIZONTAL, 16));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(mAdapter);

        // row click listener
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Center center = centerList.get(position);
                Toast.makeText(getApplicationContext(), center.getTitle() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        prepareCenterData();
    }

    /**
     * Prepares sample data to provide data set to adapter
     */
    private void prepareCenterData() {
        Center center = new Center("NRC mumbai", "166,luarem ipsum, andheri", "8 km");
        centerList.add(center);

        center = new Center("NRC mumbai", "166,luarem ipsum, andheri", "8 km");
        centerList.add(center);

        center = new Center("NRC mumbai", "166,luarem ipsum, andheri", "8 km");
        centerList.add(center);

        center = new Center("NRC mumbai", "166,luarem ipsum, andheri", "8 km");
        centerList.add(center);

        center = new Center("NRC mumbai", "166,luarem ipsum, andheri", "8 km");
        centerList.add(center);

        center = new Center("NRC mumbai", "166,luarem ipsum, andheri", "8 km");
        centerList.add(center);

        center = new Center("NRC mumbai", "166,luarem ipsum, andheri", "8 km");
        centerList.add(center);

        center = new Center("NRC mumbai", "166,luarem ipsum, andheri", "8 km");
        centerList.add(center);

        center = new Center("NRC mumbai", "166,luarem ipsum, andheri", "8 km");
        centerList.add(center);

        center = new Center("NRC mumbai", "166,luarem ipsum, andheri", "8 km");
        centerList.add(center);

        center = new Center("NRC mumbai", "166,luarem ipsum, andheri", "8 km");
        centerList.add(center);

        // notify adapter about data set changes
        // so that it will render the list with new data
        mAdapter.notifyDataSetChanged();
    }

}
