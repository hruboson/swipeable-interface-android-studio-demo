package hrubos.local.testapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;
import java.util.Map;

// Class which populates the pages inside of ViewPager2. Manages each page (our Fragments).
public class ViewPagerAdapter extends FragmentStateAdapter {

    // Here we initiate List of maps
    List<Map<String, Object>> mapList;

    // Constructor for our class
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity, List<Map<String, Object>> mapList) {
        super(fragmentActivity);
        this.mapList = mapList;
    }

    @NonNull
    @Override
    /* Provide a new Fragment associated with the specified position.
       Adapter will be responsible for Fragments lifecycle (display, destroy).
       We overwrite this method, so it gets Fragment from our List. */

    public Fragment createFragment(int position) {
        return (Fragment) mapList.get(position).get("fragment");
    }

    @Override
    // Overwriting method so it gets size from our List.
    public int getItemCount() {
        return mapList.size();
    }

    // Method which returns the title of Fragment as String. If null returns "No title".
    String getTitle(int position){

        String title = (String) mapList.get(position).get("fragmentTitle");

        if(title == null) {
            title = "No Title";
        }

        return title;
    }
}
