package badgecustomview;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.altafshaikh.badgecustomview.R;


public class CustomBadge extends FrameLayout {
    private ImageView imageView;
    private TextView textView;
    protected int back_ground;
    protected Drawable drawMain;
    protected Drawable drawBadgeCircle;
    protected ShapeDrawable bgShape;

    protected int badgeSize_Width;
    protected int badgeSize_Height;
    int background_badgecolor;


    public CustomBadge(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.badge_style);
//        back_ground = typedArray.getInteger(R.styleable.badge_style_icon_main, 0);

        drawMain = typedArray.getDrawable(R.styleable.badge_style_icon_main);
        drawBadgeCircle = typedArray.getDrawable(R.styleable.badge_style_icon_badge);
        badgeSize_Width = typedArray.getInteger(R.styleable.badge_style_badgeSize_Width, 20);
        badgeSize_Height = typedArray.getInteger(R.styleable.badge_style_badgeSize_Height, 20);
        background_badgecolor = typedArray.getColor(R.styleable.badge_style_background_badgecolor, 0xff0000ff);
        typedArray.recycle();

        drawBadgeCircle = context.getResources().getDrawable(R.drawable.circle);

        imageView = new ImageView(context, attrs);
        textView = new TextView(context, attrs);

        //set textview badget top of right
        FrameLayout.LayoutParams param_textview = new FrameLayout.LayoutParams(
                convertDIPToPixels(context, badgeSize_Width),
                convertDIPToPixels(context, badgeSize_Height));

        param_textview.gravity = Gravity.TOP | Gravity.RIGHT;
        textView.setLayoutParams(param_textview);
        textView.setGravity(Gravity.CENTER);
        if (drawBadgeCircle != null)
            textView.setBackgroundDrawable(drawBadgeCircle);

        LayerDrawable bgDrawable = (LayerDrawable) textView.getBackground();
        GradientDrawable shape = (GradientDrawable) bgDrawable.findDrawableByLayerId(R.id.badg_id_);
        shape.setColor(background_badgecolor);

        imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
//        bgShape.getPaint().setColor(Color.BLUE);
        if (drawMain != null)
            imageView.setBackgroundDrawable(drawMain);
        this.addView(imageView);
        this.addView(textView);
        textView.setText("4");
        setClickable(true);
        setFocusable(true);
    }


    public CustomBadge(Context context) {
        super(context);
    }

    public CustomBadge(Context context, AttributeSet attrs, int defaultStyle) {
        super(context, attrs, defaultStyle);
    }


    /**
     * Clear text after click on view
     */
    public void clearTextBadge() {
        textView.setText("");
        textView.setVisibility(View.GONE);
    }

    /**
     * TextView set and visibilty one
     *
     * @param title string to set
     */
    public void setTextBadge(String title) {
        textView.setVisibility(View.VISIBLE);
        textView.setText(title);
    }

    /**
     * Converts the given device independent pixels (DIP) value into the
     * corresponding pixels value for the current screen.
     *
     * @param context Context instance
     * @param dip     The DIP value to convert
     * @return The pixels value for the current screen of the given DIP value.
     */
    public static int convertDIPToPixels(Context context, int dip) {
        DisplayMetrics displayMetrics = context.getResources()
                .getDisplayMetrics();
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dip, displayMetrics);
    }

    public void setGradientColors(int bottomColor, int topColor) {
        GradientDrawable gradient = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]
                {bottomColor, topColor});
        gradient.setShape(GradientDrawable.OVAL);
        gradient.setCornerRadius(1.f);
        this.setBackgroundDrawable(gradient);
    }

}
