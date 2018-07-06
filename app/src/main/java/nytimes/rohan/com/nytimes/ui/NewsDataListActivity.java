package nytimes.rohan.com.nytimes.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import nytimes.rohan.com.nytimes.R;
import nytimes.rohan.com.nytimes.constants.Constants;
import nytimes.rohan.com.nytimes.data.NewsData;
import nytimes.rohan.com.nytimes.databinding.ActivityNewsdataListBinding;
import nytimes.rohan.com.nytimes.ui.delegates.OnNewsClickedListener;
import nytimes.rohan.com.nytimes.viewmodel.NewsViewModel;

/**
 * An activity representing a list of NewsData. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link NewsDataDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class NewsDataListActivity extends AppCompatActivity implements OnNewsClickedListener {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;
    private ArrayList<NewsData> list;


    private NewsViewModel viewModel;
    private ActivityNewsdataListBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_newsdata_list);
        viewModel = ViewModelProviders.of(this).get(NewsViewModel.class);
        viewModel.init();
        setSupportActionBar(mBinding.toolbar);
        mBinding.toolbar.setTitle(getTitle());
        mBinding.progress.pbrActivityHome.setVisibility(View.VISIBLE);


        if (findViewById(R.id.newsdata_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
        }

        View recyclerView = findViewById(R.id.newsdata_list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);
    }


    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {

        list = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        final NewsListAdapter adapter = new NewsListAdapter(this,list, mTwoPane);
        recyclerView.setAdapter(adapter);
        adapter.setOnNewsClickedListener(this);
        viewModel.getNewsData().observe(this, new Observer<List<NewsData>>() {
            @Override
            public void onChanged(@Nullable List<NewsData> newsData) {
                if (newsData!=null) {
                    list.clear();
                    list.addAll(newsData);
                    mBinding.progress.pbrActivityHome.setVisibility(View.GONE);
                    adapter.notifyDataSetChanged();

                }else {
                    Toast.makeText(NewsDataListActivity.this, "Failure ", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public void onNewsClicked(int position) {
        if (mTwoPane) {
            Bundle arguments = new Bundle();
            arguments.putParcelable(Constants.ITEM_ID, list.get(position));
            NewsDataDetailFragment fragment = new NewsDataDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.newsdata_detail_container, fragment)
                    .commit();
        } else {
            Intent intent = new Intent(this, NewsDataDetailActivity.class);
            intent.putExtra(Constants.ITEM_ID, list.get(position));
            startActivity(intent);
        }

    }



}
