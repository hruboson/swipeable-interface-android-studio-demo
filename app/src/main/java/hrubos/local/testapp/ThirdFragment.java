package hrubos.local.testapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

// every fragment has its own class - same as view or screen - here we can add controller function (for example add button functions)
public class ThirdFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.third_fragment, container, false); // Inflate the layout for this fragment

    }
}