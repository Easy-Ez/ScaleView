package cf.sadhu.scaleview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.SuperscriptSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by sadhu on 2017/10/15.
 * 描述: 体重fragment
 */
public class WeightFragment extends Fragment {

    private ScaleView mScaleview;
    private TextView mTvValue;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.frag_weight, container, false);
        mTvValue = inflate.findViewById(R.id.tv_value);
        mScaleview = inflate.findViewById(R.id.sacleview);
        // // TODO: 2017/10/16  根据身高计算体重最大最小值
        mScaleview.initialData(46.4f, 200f, 0.1f, 10, 70f);
        mScaleview.setOnGraduationValueChange(new ScaleView.OnGraduationValueChangeListener() {
            @Override
            public void onChange(int value, float stepHelper) {
                mTvValue.setText(getWeightStr(value, stepHelper));
            }
        });
        inflate.findViewById(R.id.tv_prev_step).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).prevStep();
            }
        });
        return inflate;
    }

    private SpannableStringBuilder getWeightStr(int value, float stepHelper) {
        String string = getString(R.string.weight_value, value / stepHelper);
        SpannableStringBuilder ssb = new SpannableStringBuilder(string);
        SuperscriptSpan superscripSpan = new SuperscriptSpan();
        AbsoluteSizeSpan sizeSpan = new AbsoluteSizeSpan(14,true);
        ssb.setSpan(superscripSpan, string.indexOf("kg"), string.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ssb.setSpan(sizeSpan, string.indexOf("kg"), string.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return ssb;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mScaleview.setOnGraduationValueChange(null);
    }
}
