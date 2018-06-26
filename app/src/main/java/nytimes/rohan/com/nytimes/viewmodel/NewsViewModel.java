package nytimes.rohan.com.nytimes.viewmodel;

import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;

import nytimes.rohan.com.nytimes.data.NewsData;
import nytimes.rohan.com.nytimes.repo.HeadLineRepository;

public class NewsViewModel extends ViewModel {

    private LiveData<List<NewsData>> news;

    HeadLineRepository newsRepo;




    public NewsViewModel(){
        newsRepo = new HeadLineRepository();
    }


    public NewsViewModel(HeadLineRepository newsRepo) {
        this.newsRepo = newsRepo;
    }

    public LiveData<List<NewsData>> getNewsData(){
        return news;
    }


    public void init(){
        if (this.news!=null){
            return;
        }
        this.news = newsRepo.getHeadLineData();
    }
}
