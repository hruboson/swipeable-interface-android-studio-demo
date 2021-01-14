package hrubos.local.testapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import hrubos.local.testapp.R;

// every fragment has its own class - same as view or screen - here we can add controller function (for example add button functions)
public class SecondFragment extends Fragment implements View.OnClickListener{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.second_fragment, container, false); // Inflate the layout for this fragment

    }

    @Override // How to handle buttons - we implement View.OnClickListener to our fragments
    public void onClick(View v){
        switch(v.getId()){
            case R.id.button: // this is id of our button
                showToast("Button was pressed"); // what is supposed to happen
                break;
            // we can have multiple buttons here:
            // case R.id.button2: ...
            // case R.id.button3: ...
        }
    }

    protected void showToast(String text){
        Toast.makeText(this.getActivity(), text, Toast.LENGTH_LONG).show(); // if we want to pass activity to method, we call method getActivity()
    }

}