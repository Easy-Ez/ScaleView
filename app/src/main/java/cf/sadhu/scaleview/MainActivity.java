package cf.sadhu.scaleview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private TextView tv_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ScaleView scaleview = findViewById(R.id.sacleview);
        tv_value = findViewById(R.id.tv_value);
        scaleview.setOnGraduationValueChange(new ScaleView.OnGraduationValueChangeListener() {
            @Override
            public void onChange(int value, float stepHelper) {
                // Log.i(TAG, "onChange value: " + value + ";stepHelper:" + stepHelper);
                tv_value.setText(String.valueOf(value / stepHelper));
            }
        });
    }
}
