package com.namMysuruData;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.namMysuruData.Adapter.PagerAdapterTab;
import com.namMysuruData.Fragments.GeneralNews;
import com.namMysuruData.Fragments.PDFNews;
import com.namMysuruData.Fragments.ShareMarket;
import com.namMysuruData.Fragments.SportsNews;
import com.namMysuruData.Fragments.Weather;
import com.namMysuruData.Fragments.YoutubeChannelsNews;
import com.namMysuruData.Fragments.namMysuruData;

public class MainActivity extends AppCompatActivity {


    private DrawerLayout mdrawerLayout;
    private NavigationView mnavigationView;
    private Toolbar mtoolbar;

    private GeneralNews generalNewsFragment;
    private namMysuruData namMysuruDataFragment;
    private PDFNews pdfNewsFragment;
    private ShareMarket shareMarketFragment;
    private SportsNews sportsNewsFragment;
    private Weather weatherFragment;
    private YoutubeChannelsNews youtubeChannelsNewsFragment;


    private TabLayout tabLayout;
    private ViewPager viewPager;
    private PagerAdapterTab pagerAdapterTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_drawer_layout);
        intializeViews();
        intiliazeFragments();
        /**
         * If we use this toolbar after the addHamburgerSymbol() navigation click won t work.Check what is the issue..
         */
        useToolbar();
        addHamburgerSymbol();
        setUpViewPager();// imortant Step
        intializePagerAdapter();
        addAllFragments();
        setViewPagerToApater();// imortant Step
    }

    private void intializeViews() {
        mdrawerLayout = findViewById(R.id.drawerlayout);
        mnavigationView = (NavigationView) findViewById(R.id.navigation_view);
        mtoolbar = (Toolbar) findViewById(R.id.mainActivity_toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.mainActivity_viewpager);
    }

    private void intiliazeFragments() {
        generalNewsFragment=new GeneralNews();
        namMysuruDataFragment=new namMysuruData();
        pdfNewsFragment=new PDFNews();
        shareMarketFragment=new ShareMarket();
        sportsNewsFragment=new SportsNews();
        weatherFragment=new Weather();
        youtubeChannelsNewsFragment=new YoutubeChannelsNews();
    }

    private void addHamburgerSymbol() {
        ActionBarDrawerToggle loc_actionBarDrawerToggle = new ActionBarDrawerToggle(
                this,
                mdrawerLayout,
                mtoolbar,
                R.string.close_navigation_Drawer,
                R.string.open_navigation_Drawer
        );

        mdrawerLayout.addDrawerListener(loc_actionBarDrawerToggle);
        loc_actionBarDrawerToggle.syncState();
    }

    private void useToolbar() {
        setSupportActionBar(mtoolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items, menu);
        return super.onCreateOptionsMenu(menu);
    }
    private void setUpViewPager(){
        tabLayout.setupWithViewPager(viewPager);
    }

    private void intializePagerAdapter(){
        pagerAdapterTab =new PagerAdapterTab(getSupportFragmentManager(),0);
    }
    private void addAllFragments(){
        pagerAdapterTab.addFragment(generalNewsFragment,"General News");
        pagerAdapterTab.addFragment(namMysuruDataFragment,"namMysuru Data");
        pagerAdapterTab.addFragment(pdfNewsFragment,"PDF");
        pagerAdapterTab.addFragment(shareMarketFragment,"Share Market");
        pagerAdapterTab.addFragment(sportsNewsFragment,"Sports");
        pagerAdapterTab.addFragment(weatherFragment,"Weather");
        pagerAdapterTab.addFragment(youtubeChannelsNewsFragment,"YouTube");
    }
    private void setViewPagerToApater(){
        viewPager.setAdapter(pagerAdapterTab);
    }
}
