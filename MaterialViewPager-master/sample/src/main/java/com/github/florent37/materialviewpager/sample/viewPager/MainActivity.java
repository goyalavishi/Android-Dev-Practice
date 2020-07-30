package com.github.florent37.materialviewpager.sample.viewPager;

import android.annotation.TargetApi;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;
import com.github.florent37.materialviewpager.sample.R;
import com.github.florent37.materialviewpager.sample.bookcrow.BookDataBase;
import com.github.florent37.materialviewpager.sample.bookcrow.Search;
import com.github.florent37.materialviewpager.sample.bookcrow.TableData;
import com.github.florent37.materialviewpager.sample.fragment.ProfilePageFragment;
import com.github.florent37.materialviewpager.sample.fragment.RecyclerViewFragment;
import com.github.florent37.materialviewpager.sample.fragment.ScrollFragment;

import java.util.ArrayList;

public class MainActivity extends DrawerActivity implements SearchView.OnQueryTextListener {

    private MaterialViewPager mViewPager;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BookDataBase b=new BookDataBase(this);
        Cursor c=b.getInfo();
        if(c.getCount()==1)
        {
            //b.insert("Shruti Katyal","Lalala",100,0);
            b.insert("J.K. Rowling","Harry Potter And The Goblet Of Fire",150,3);
            b.insert("Sydney Sheldon","Tell me your dreams",100,6);
            b.insert("Tejas Raheja","Anything for you ma'am",75,0);
            b.insert("Cormenn","Algorithms",350,1);
            b.insert("Kleinberg","Algorithms",200,1);
            b.insert("Steven Skiena","Algorithms",180,1);
            b.insert("Donald Knuth","algorithms",150,1);
            b.insert("Pearson","Operating Systems",120,1);
            b.insert("Sumita Arora","C++",120,1);
        }
        setTitle("");

        mViewPager = (MaterialViewPager) findViewById(R.id.materialViewPager);

        toolbar = mViewPager.getToolbar();

        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        mViewPager.getViewPager().setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                switch (position )
                {
                    case 1:
                        return RecyclerViewFragment.newInstance();
                    case 2:
                       return ProfilePageFragment.newInstance();

                }
                return ScrollFragment.newInstance();
            }

            @Override
            public int getCount() {
                return 4;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position % 4) {
                    case 0:
                        return "Trending";
                    case 1:
                        return "Favourites";
                    case 2:
                        return "My Profile";
                }
                return "";
            }
        });

        mViewPager.setMaterialViewPagerListener(new MaterialViewPager.Listener() {
            @Override
            public HeaderDesign getHeaderDesign(int page) {
                switch (page) {
                    case 0:
                        return HeaderDesign.fromColorResAndUrl(
                            R.color.cyan,
                            "http://tvxs.gr/sites/default/files/article/2016/20/202498-symmetro_photo13.jpg");
                    case 1:
                        return HeaderDesign.fromColorResAndUrl(
                            R.color.cyan,
                            "http://cdn1.tnwcdn.com/wp-content/blogs.dir/1/files/2014/06/wallpaper_51.jpg");
                    case 2:
                        return HeaderDesign.fromColorResAndUrl(
                            R.color.cyan,
                            "http://www.droid-life.com/wp-content/uploads/2014/10/lollipop-wallpapers10.jpg");

                }
                //execute others actions if needed (ex : modify your header logo)
                return null;
            }
        });

        mViewPager.getViewPager().setOffscreenPageLimit(mViewPager.getViewPager().getAdapter().getCount());
        mViewPager.getPagerTitleStrip().setViewPager(mViewPager.getViewPager());

        View logo = findViewById(R.id.logo_white);
        if (logo != null) {
            logo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mViewPager.notifyHeaderChanged();
                    Toast.makeText(getApplicationContext(), "Yes, the title is clickable", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.msearch).getActionView();
        int searchSrcTextId = getResources().getIdentifier("android:id/search_src_text", null, null);
        EditText searchEditText = (EditText) searchView.findViewById(searchSrcTextId);
        if(searchEditText!=null)
        searchEditText.setHintTextColor(Color.WHITE);
        searchView.setOnQueryTextListener(this);
        return super.onCreateOptionsMenu(menu);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.msearch)
        {
            //SearchView searchView = (SearchView) item.getActionView();
          //  if (searchView != null)
        //        searchView.setOnQueryTextListener(this);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
       // Toast.makeText(MainActivity.this, "Ts", Toast.LENGTH_SHORT).show();
        BookDataBase book=new BookDataBase(this);
        Cursor c=book.getInfo();
        ArrayList<Integer> pos=new ArrayList<Integer>();
        if(c.getCount()!=0)
        {
            c.moveToFirst();
            do {
                    if(c.getString(0).equalsIgnoreCase(query))
                        pos.add(c.getPosition());
            }while(c.moveToNext());
        }

        if(pos.isEmpty())
            Toast.makeText(this,"No such book exists",Toast.LENGTH_SHORT).show();
        else{

            Intent i=new Intent(this,Search.class);
            i.putExtra("positions",pos);
            startActivity(i);
        }
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
//        Toast.makeText(MainActivity.this, "Tc", Toast.LENGTH_SHORT).show();
        return false;
    }
}
