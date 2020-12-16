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

// our main activity class - we add activity main as its layout (where we pager in xml)
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initiating ViewPager we created in activity_main.xml and assigning the pager container we created to it
        final ViewPager2 viewPager = findViewById(R.id.viewPager);

        // Here we create ArrayList of maps
        List<Map<String, Object>> mapList = new ArrayList<>();

        /* Maps in java are something like dictionary, but we can only
           add two parameters <K,V>. They map unique keys (indexes) to values where
           key is an object that you use to retrieve a value at a later date */

        Map<String, Object> firstFragmentMap = setTabTitleAndFragment("First", new FirstFragment());
        Map<String, Object> secondFragmentMap = setTabTitleAndFragment("Second", new SecondFragment());
        Map<String, Object> thirdFragmentMap = setTabTitleAndFragment("Third", new ThirdFragment());

        // Adding created maps to ArrayList
        mapList.add(firstFragmentMap);
        mapList.add(secondFragmentMap);
        mapList.add(thirdFragmentMap);

        final ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this, mapList);
        viewPager.setAdapter(viewPagerAdapter);

        // Initiating tabLayout we created in activity_main.xml
        TabLayout tabLayout = findViewById(R.id.tabLayout);

        /* TabLayoutMediator is used to link TabLayout (our menu) with
           ViewPager2 (our view container). The mediator will synchronize the
           ViewPager2's position with the selected tab when a tab is selected,
           and the TabLayout's scroll position when the user drags the ViewPager */

        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(viewPagerAdapter.getTitle(position));
            }
        }).attach();

    }

    // Creating method which returns a map with the fragments title and instance
    Map<String, Object> setTabTitleAndFragment(String title, Fragment fragment){

        /* Hash map is something like ArrayList, but
           instead of accessing items by number (integer),
           we can access them by their key (e.g. String).
           Then we can do something like: fragmentWithTitleMap.get("fragmentTitle"); */

        Map<String, Object> fragmentWithTitleMap = new HashMap<>();

        fragmentWithTitleMap.put("fragmentTitle", title);
        fragmentWithTitleMap.put("fragment", fragment);

        return fragmentWithTitleMap;
    }
}