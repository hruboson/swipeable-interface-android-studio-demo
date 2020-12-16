package hrubos.local.testapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonMainOnClick(View sourceView) {
        Button sourceButton = (Button) sourceView;
        sourceView.setBackgroundColor(ContextCompat.getColor(this, R.color.shiny));
    }

}