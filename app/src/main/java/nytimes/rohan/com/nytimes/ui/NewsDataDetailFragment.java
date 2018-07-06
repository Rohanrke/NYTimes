package nytimes.rohan.com.nytimes.ui;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import nytimes.rohan.com.nytimes.R;
import nytimes.rohan.com.nytimes.constants.Constants;
import nytimes.rohan.com.nytimes.data.NewsData;
import nytimes.rohan.com.nytimes.databinding.NewsdataDetailBinding;


/**
 * A fragment representing a single NewsData detail screen.
 * This fragment is either contained in a {@link NewsDataListActivity}
 * in two-pane mode (on tablets) or a {@link NewsDataDetailActivity}
 * on handsets.
 */
public class NewsDataDetailFragment extends Fragment {


    private NewsData data;




    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public NewsDataDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (getArguments()!=null && getArguments().containsKey(Constants.ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            data = getArguments().getParcelable(Constants.ITEM_ID);

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(data.getTitle());
            }

            ImageView imageView = appBarLayout.findViewById(R.id.image);

            Picasso.with(getActivity()).load(data.getMedia().get(0).getMediaMetaData().get(0).getUrl())
                    .into(imageView);



        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        NewsdataDetailBinding mBnding = DataBindingUtil.inflate(getLayoutInflater(),R.layout.newsdata_detail,container,false);

        // Show the dummy content as text in a TextView.
        if (data != null) {
            mBnding.newsdataDetail.setText(data.getAbst());
        }

        return mBnding.getRoot();
    }
}
