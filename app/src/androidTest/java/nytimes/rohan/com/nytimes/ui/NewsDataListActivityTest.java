package nytimes.rohan.com.nytimes.ui;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import android.support.test.rule.ActivityTestRule;


import nytimes.rohan.com.nytimes.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;;
import static android.support.test.espresso.matcher.ViewMatchers.withId;



@RunWith(AndroidJUnit4.class)
public class NewsDataListActivityTest {

    @Rule
    public ActivityTestRule<NewsDataListActivity> mActivityRule = new ActivityTestRule<>(
            NewsDataListActivity.class);




    @Before
    public void addData(){



    }

    @Test
    public void testClickNewsRow(){

        onView(withId(R.id.newsdata_list)).perform(RecyclerViewActions.actionOnItemAtPosition(0,click()));
    }



}
