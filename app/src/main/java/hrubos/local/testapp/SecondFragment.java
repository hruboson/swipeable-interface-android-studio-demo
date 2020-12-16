package hrubos.local.testapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import hrubos.local.testapp.R;

// every fragment has its own class - same as view or screen - here we can add controller function (for example add button functions)
public class SecondFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.second_fragment, container, false); // Inflate the layout for this fragment

    }
}