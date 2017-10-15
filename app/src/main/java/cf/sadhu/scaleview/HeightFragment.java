package cf.sadhu.scaleview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by sadhu on 2017/10/15.
 * 描述: 选择身高fragment
 */
public class HeightFragment extends Fragment {

    private TextView tv_value;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.frag_height, container, false);

        ScaleView scaleview = inflate.findViewById(R.id.sacleview);
        scaleview.setIndicatorDrawable(new TriangleDrawable(R.color.white, 20, 9.5f, getContext()));
        tv_value = inflate.findViewById(R.id.tv_value);
        scaleview.setOnGraduationValueChange(new ScaleView.OnGraduationValueChangeListener() {
            @Override
            public void onChange(int value, float stepHelper) {
                tv_value.setText(getString(R.string.height_value, value / stepHelper));
            }
        });
        inflate.findViewById(R.id.tv_next_step).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return inflate;
    }
}
