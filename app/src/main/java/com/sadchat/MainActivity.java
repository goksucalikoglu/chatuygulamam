package com.sadchat;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.sadchat.databinding.ActivityMainBinding;
import com.sadchat.menü.DurumlarFragment;
import com.sadchat.menü.KisilerFragment;
import com.sadchat.menü.SohbetlerFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_main);

        setUpViewPager(binding.viewPager);
        binding.tabLayout.setupWithViewPager(binding.viewPager);
        setSupportActionBar(binding.toolbar);

        binding.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                fabIkonDegistir(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void fabIkonDegistir(final int index) {
        binding.fabAction.hide();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (index){
                    case 0:
                        binding.fabAction.setImageDrawable(getDrawable(R.drawable.ic_baseline_chat_24));
                        break;
                    case 1:
                        binding.fabAction.setImageDrawable(getDrawable(R.drawable.ic_baseline_call_24));
                        break;
                    case 2:
                        binding.fabAction.setImageDrawable(getDrawable(R.drawable.ic_baseline_photo_camera_24));
                        break;
                }
                binding.fabAction.show();
            }
        },400);
    }

    private void setUpViewPager(ViewPager viewPager){
        MainActivity.SectionsPagerAdapter adapter=new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new SohbetlerFragment(),"Sohbetler");
        adapter.addFragment(new KisilerFragment(),"Kişiler");
        adapter.addFragment(new DurumlarFragment(),"Durumlar");

        viewPager.setAdapter(adapter);

    }
    private static class SectionsPagerAdapter extends FragmentPagerAdapter
    {
        private final List<Fragment> aFragmentList= new ArrayList<>();
        private final List<String> aFragmentTitleList= new ArrayList<>();

        public SectionsPagerAdapter (FragmentManager manager){
            super(manager);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return aFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return aFragmentList.size();
        }

        public void addFragment (Fragment fragment,String title)
        {
            aFragmentList.add(fragment);
            aFragmentTitleList.add(title);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return aFragmentTitleList.get(position);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        switch (id)
        {
            case R.id.menu_arama:
                Toast.makeText(this,"Arama",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_secenekler:
                Toast.makeText(this,"Secenekler",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}