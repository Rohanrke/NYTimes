package nytimes.rohan.com.nytimes.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;
import nytimes.rohan.com.nytimes.R;
import nytimes.rohan.com.nytimes.data.NewsData;
import nytimes.rohan.com.nytimes.ui.delegates.OnNewsClickedListener;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.ViewHolder> {


    private Context context;
    private List<NewsData> data;
    private boolean mTwoPane;

    private OnNewsClickedListener listener;


    public NewsListAdapter(Context context,List<NewsData> liveData,boolean mTwoPane){

        this.context = context;
        this.data = liveData;
        this.mTwoPane = mTwoPane;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.newsdata_list_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {


        if (!TextUtils.isEmpty(data.get(position).getMedia().get(0).getMediaMetaData().get(0).getUrl())){
            Picasso.with(context)
                    .load(data.get(position).getMedia().get(0).getMediaMetaData().get(0).getUrl())
                    .transform(new CropCircleTransformation())
                    .into(holder.image);
         }


         holder.title.setText(data.get(position).getTitle());
        holder.content.setText(data.get(position).getByline());
        holder.time.setText(data.get(position).getPublishedDate());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener!=null){
                    listener.onNewsClicked(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
         TextView title,content,time;
         ImageView image;
         RelativeLayout layout;

        ViewHolder(View view) {
            super(view);
            title =  view.findViewById(R.id.title);
            content =  view.findViewById(R.id.content);
            time = view.findViewById(R.id.time);
            image =  view.findViewById(R.id.image);
            layout =  view.findViewById(R.id.parent);

        }
    }

    public void setOnNewsClickedListener(OnNewsClickedListener listener){

        this.listener = listener;
    }
}
