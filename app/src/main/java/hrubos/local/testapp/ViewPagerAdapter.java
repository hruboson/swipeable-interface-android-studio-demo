package hrubos.local.testapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;
import java.util.Map;

public class ViewPagerAdapter extends FragmentStateAdapter {

    List<Map<String, Object>> mapList;

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity, List<Map<String, Object>> mapList) {
        super(fragmentActivity);
        this.mapList = mapList;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return (Fragment) mapList.get(position).get("fragment");
    }

    @Override
    public int getItemCount() {
        return mapList.size();
    }

    String getTitle(int position){

        String title = (String) mapList.get(position).get("fragmentTitle");

        if(title == null) title = "No Title";

        return title;
    }
}
