package cf.sadhu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;

/**
 * Created by sadhu on 2017/10/15.
 * 描述: 三角形
 */
public class TriangleDrawable extends Drawable {
    private Paint mPaint;
    private Path mPath;
    private int width;
    private int height;

    public TriangleDrawable(@ColorRes int colorRes, float width, float height, Context ctx) {
        this.width = UIUtils.dp2px(width, ctx);
        this.height = UIUtils.dp2px(height, ctx);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(ContextCompat.getColor(ctx, colorRes));
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPath = new Path();

    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        Rect bounds = getBounds();
        this.mPath.reset();
        this.mPath.moveTo(bounds.left, bounds.top);
        this.mPath.lineTo(bounds.left + width / 2, bounds.top + height);
        this.mPath.lineTo(bounds.left + width, bounds.top);
        this.mPath.close();
        canvas.drawPath(this.mPath, this.mPaint);
    }

    @Override
    public void setAlpha(int alpha) {
        mPaint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        mPaint.setColorFilter(colorFilter);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSPARENT;
    }

    @Override
    public int getIntrinsicHeight() {
        return height;
    }

    @Override
    public int getIntrinsicWidth() {
        return width;
    }
}
