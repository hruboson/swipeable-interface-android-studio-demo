package hrubos.local.testapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ViewPager2 viewPager = findViewById(R.id.viewPager);

        List<Map<String, Object>> mapList = new ArrayList<>();

        Map<String, Object> firstFragmentMap = setTabTitleAndFragment("First", new FirstFragment());
        Map<String, Object> secondFragmentMap = setTabTitleAndFragment("Second", new SecondFragment());
        Map<String, Object> thirdFragmentMap = setTabTitleAndFragment("Third", new ThirdFragment());

        mapList.add(firstFragmentMap);
        mapList.add(secondFragmentMap);
        mapList.add(thirdFragmentMap);

        final ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this, mapList);
        viewPager.setAdapter(viewPagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tabLayout);

        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(viewPagerAdapter.getTitle(position));
            }
        }).attach();

    }

    Map<String, Object> setTabTitleAndFragment(String title, Fragment fragment){

        Map<String, Object> fragmentWithTitleMap = new HashMap<>();

        fragmentWithTitleMap.put("fragmentTitle", title);
        fragmentWithTitleMap.put("fragment", fragment);

        return fragmentWithTitleMap;
    }
}