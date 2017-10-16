# ScaleView
定制性较高的横向滑动的卷尺

![test](http://7xt745.com1.z0.glb.clouddn.com/2017_10_16_14_16_38_14_57_50.gif)

# Example 

`ScaleView`具有较高的可定制性,宽高支持`match_parent`, `wrap_content`以及具体值.


```xml

    <cf.sadhu.ScaleView
        android:id="@+id/sacleview"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:background="@color/color_background"
        app:decimalFormat="0.0"
        app:graduationLineColor="@color/white"
        app:graduationLineHeight="38dp"
        app:graduationLineMargin="10dp"
        app:graduationLineWidth="4dp"
        app:graduationStep="0.01"
        app:graduationStepHelper="100"
        app:graduationTextColor="@color/white"
        app:graduationTextMargin="12dp"
        app:graduationTextSize="17sp"
        app:indicator="@drawable/bg_indicator"
        app:initialValue="100.9"
        app:maxVaule="230.1"
        app:minValue="100"/>
        
```
下图是上面xml展示的样式

<img src="http://7xt745.com1.z0.glb.clouddn.com/layout-2017-10-16-154100.png" width="384" height="640">


下表是所有属性及其含义

|Attribute                   | Type           | Summary  |
| -------------------------- |:------------- | :------------------------------|
| minValue                   | float| 卷尺的最小值|
| maxVaule                   | float | 卷尺的最大值|
| initialValue               | float | 卷尺的初始值,默认为最小,最大值间的中位数|
| indicator                  | reference  | 指示器drawable,xml中的shape如果没有指定宽高,indicator的宽高则与长刻度线的宽高相同                         |
| graduationStep          | float  | 刻度尺的最小刻度,默认是1|
| graduationStepHelper| integer  | 将最小刻度变为整数需要乘的数,默认是1|
| graduationLineMargin| dimension  | 刻度间的间距|
| graduationTextColor| color  | 刻度值文字的颜色|
| graduationTextSize| dimension  | 刻度值文字的大小|
| graduationTextMargin| dimension  | 刻度值文字距离长刻度线的间距|
| graduationLineColor| color  | 长刻度线的颜色|
| graduationLineWidth| dimension  | 长刻度线的宽,短刻度线为长刻度线的一半|
| graduationLineHeight| dimension  | 长刻度线的高,短刻度线为长刻度线的一半|
| decimalFormat| dimension  | 刻度值文字的格式,可参考java中的`DecimalFormat`类,默认值是"0"|

下表是公开方法及其含义

|Method       |  Summary  |
| -------------------------- |:------------- |
| setIndicatorDrawable(Drawable indicatorDrawable)|设置指示器drawable|
| initialData(float minValue, float maxValue, float step, int stepHelper,float initialValue)|设置卷尺的最小/最大值,初始值,刻度值,以及stepHelper|
| initialData(float minValue, float maxValue, float step, int stepHelper)|设置卷尺的最小/最大值,刻度值,以及stepHelper,初始值默认为最小/最大值的中位数|
| setOnGraduationValueChange(OnGraduationValueChangeListener listener) | 设置刻度值选中时候的回调|


