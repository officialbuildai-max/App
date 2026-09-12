package com.mbridge.msdk.dycreator.baseview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.t0;

/* loaded from: classes5.dex */
public class MBSplashShakeView extends MBLinearLayout {

    /* renamed from: f, reason: collision with root package name */
    private final String f34587f;

    /* renamed from: g, reason: collision with root package name */
    private final String f34588g;

    /* renamed from: h, reason: collision with root package name */
    private final String f34589h;

    /* renamed from: i, reason: collision with root package name */
    private final String f34590i;

    /* renamed from: j, reason: collision with root package name */
    private final String f34591j;

    /* renamed from: k, reason: collision with root package name */
    private final String f34592k;

    /* renamed from: l, reason: collision with root package name */
    private ImageView f34593l;

    /* renamed from: m, reason: collision with root package name */
    private Animation f34594m;

    public MBSplashShakeView(Context context) {
        super(context);
        this.f34587f = "浏览第三方应用";
        this.f34588g = "View";
        this.f34589h = "打开第三方应用";
        this.f34590i = "Open";
        this.f34591j = "下载第三方应用";
        this.f34592k = "Install";
    }

    public MBSplashShakeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f34587f = "浏览第三方应用";
        this.f34588g = "View";
        this.f34589h = "打开第三方应用";
        this.f34590i = "Open";
        this.f34591j = "下载第三方应用";
        this.f34592k = "Install";
    }

    public MBSplashShakeView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f34587f = "浏览第三方应用";
        this.f34588g = "View";
        this.f34589h = "打开第三方应用";
        this.f34590i = "Open";
        this.f34591j = "下载第三方应用";
        this.f34592k = "Install";
    }

    private String a(String str) {
        if (!TextUtils.isEmpty(str)) {
            str.hashCode();
            char c11 = 65535;
            switch (str.hashCode()) {
                case -672744069:
                    if (str.equals("Install")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case 2464362:
                    if (str.equals("Open")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 2666181:
                    if (str.equals("View")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 855294846:
                    if (str.equals("下载第三方应用")) {
                        c11 = 3;
                        break;
                    }
                    break;
                case 1383132195:
                    if (str.equals("打开第三方应用")) {
                        c11 = 4;
                        break;
                    }
                    break;
                case 1681333335:
                    if (str.equals("浏览第三方应用")) {
                        c11 = 5;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    return str;
            }
        }
        return getContext().getResources().getConfiguration().locale.getLanguage().contains("zh") ? "浏览第三方应用" : "View";
    }

    private void a() {
        RotateAnimation rotateAnimation = new RotateAnimation(-10.0f, 10.0f, 1, 0.5f, 1, 0.5f);
        this.f34594m = rotateAnimation;
        rotateAnimation.setDuration(100L);
        this.f34594m.setRepeatMode(2);
        this.f34594m.setRepeatCount(-1);
        this.f34593l.startAnimation(this.f34594m);
    }

    private void setBgDrawable(View view) {
        int parseColor = Color.parseColor("#60000000");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(parseColor);
        gradientDrawable.setCornerRadius(200);
        view.setBackground(gradientDrawable);
    }

    public void initView(String str) {
        setOrientation(1);
        setGravity(1);
        View imageView = new ImageView(getContext());
        imageView.setLayoutParams(new LinearLayout.LayoutParams(t0.a(getContext(), 80.0f), t0.a(getContext(), 80.0f)));
        setBgDrawable(imageView);
        this.f34593l = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(t0.a(getContext(), 40.0f), t0.a(getContext(), 40.0f));
        layoutParams.gravity = 17;
        this.f34593l.setLayoutParams(layoutParams);
        this.f34593l.setImageResource(getResources().getIdentifier("mbridge_cm_btn_shake", "drawable", c.m().h()));
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        frameLayout.addView(imageView);
        frameLayout.addView(this.f34593l);
        TextView textView = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = t0.a(getContext(), 10.0f);
        textView.setLayoutParams(layoutParams2);
        textView.setGravity(17);
        textView.setText("Shake your phone");
        textView.setTextSize(16.0f);
        textView.setTextColor(-1);
        String a11 = a(str);
        TextView textView2 = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = t0.a(getContext(), 5.0f);
        textView2.setLayoutParams(layoutParams3);
        textView2.setGravity(17);
        textView2.setText(a11);
        textView2.setTextSize(12.0f);
        textView2.setTextColor(-1);
        addView(frameLayout);
        addView(textView);
        addView(textView2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mbridge.msdk.dycreator.baseview.MBLinearLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f34593l != null) {
            a();
        }
    }
}
