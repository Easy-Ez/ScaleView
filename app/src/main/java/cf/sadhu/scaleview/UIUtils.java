package cf.sadhu.scaleview;

import android.content.Context;
import android.util.TypedValue;

/**
 * Created by sadhu on 2017/10/15.
 * 描述:
 */
public class UIUtils {

    public static float dp2pxF(float value, Context ctx) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, ctx.getResources().getDisplayMetrics());
    }

    public static int dp2px(float value, Context ctx) {
        return (int) (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, ctx.getResources().getDisplayMetrics()) + 0.5f);
    }
}
