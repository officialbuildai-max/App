package com.mbridge.msdk.dycreator.baseview.cusview;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.mbridge.msdk.foundation.tools.g0;
import com.mbridge.msdk.foundation.tools.o0;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class MBridgeSegmentsProgressBar extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private final String f34683a;

    /* renamed from: b, reason: collision with root package name */
    private int f34684b;

    /* renamed from: c, reason: collision with root package name */
    private int f34685c;

    /* renamed from: d, reason: collision with root package name */
    private int f34686d;

    /* renamed from: e, reason: collision with root package name */
    private int f34687e;

    /* renamed from: f, reason: collision with root package name */
    private int f34688f;

    /* renamed from: g, reason: collision with root package name */
    private int f34689g;

    /* renamed from: h, reason: collision with root package name */
    private int f34690h;

    /* renamed from: i, reason: collision with root package name */
    private List<ProgressBar> f34691i;

    /* renamed from: j, reason: collision with root package name */
    private TextView f34692j;

    /* renamed from: k, reason: collision with root package name */
    private String f34693k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f34694l;

    public MBridgeSegmentsProgressBar(Context context) {
        super(context);
        this.f34683a = "MBridgeSegmentsProgressBar";
        this.f34685c = 1;
        this.f34686d = 20;
        this.f34687e = 10;
        this.f34688f = 1;
        this.f34689g = -1711276033;
        this.f34690h = -1;
        this.f34691i = new ArrayList();
        this.f34694l = false;
    }

    public MBridgeSegmentsProgressBar(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f34683a = "MBridgeSegmentsProgressBar";
        this.f34685c = 1;
        this.f34686d = 20;
        this.f34687e = 10;
        this.f34688f = 1;
        this.f34689g = -1711276033;
        this.f34690h = -1;
        this.f34691i = new ArrayList();
        this.f34694l = false;
    }

    public MBridgeSegmentsProgressBar(Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f34683a = "MBridgeSegmentsProgressBar";
        this.f34685c = 1;
        this.f34686d = 20;
        this.f34687e = 10;
        this.f34688f = 1;
        this.f34689g = -1711276033;
        this.f34690h = -1;
        this.f34691i = new ArrayList();
        this.f34694l = false;
    }

    public MBridgeSegmentsProgressBar(Context context, @Nullable AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        this.f34683a = "MBridgeSegmentsProgressBar";
        this.f34685c = 1;
        this.f34686d = 20;
        this.f34687e = 10;
        this.f34688f = 1;
        this.f34689g = -1711276033;
        this.f34690h = -1;
        this.f34691i = new ArrayList();
        this.f34694l = false;
    }

    private StringBuilder a(int i11) {
        StringBuilder sb2 = new StringBuilder();
        try {
            sb2.append(String.format(this.f34693k, Integer.valueOf(i11), Integer.valueOf(this.f34684b)));
        } catch (Throwable th2) {
            sb2.append(this.f34684b);
            sb2.append("videos, the");
            sb2.append(i11);
            sb2.append(" is playing.");
            o0.b("MBridgeSegmentsProgressBar", th2.getMessage());
        }
        return sb2;
    }

    private void a() {
        Drawable drawable;
        try {
            this.f34694l = getContext().getResources().getConfiguration().locale.getLanguage().contains("zh");
        } catch (Throwable th2) {
            o0.b("MBridgeSegmentsProgressBar", th2.getMessage());
        }
        try {
            if (this.f34685c == 1) {
                setOrientation(1);
                if (TextUtils.isEmpty(this.f34693k)) {
                    this.f34693k = this.f34694l ? "正在播放第%s个，共%s个视频" : "The %s is playing, %s videos.";
                }
            }
            if (this.f34685c == 2) {
                setOrientation(0);
                if (TextUtils.isEmpty(this.f34693k)) {
                    this.f34693k = this.f34694l ? "广告 %s/%s" : "ADS %s/%s";
                }
            }
            this.f34691i.clear();
            removeAllViews();
            setBackground(getBackgroundDrawable());
            TextView textView = new TextView(getContext());
            this.f34692j = textView;
            textView.setTextColor(-1);
            this.f34692j.setTextSize(12.0f);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            this.f34692j.setLayoutParams(layoutParams);
            if (this.f34685c == 1) {
                layoutParams.gravity = 5;
                TextView textView2 = this.f34692j;
                int i11 = this.f34686d;
                textView2.setPadding(i11 / 2, 15, i11 / 2, 5);
            }
            if (this.f34685c == 2) {
                this.f34692j.setGravity(16);
                TextView textView3 = this.f34692j;
                int i12 = this.f34686d;
                textView3.setPadding(i12 / 2, 0, i12 / 2, 0);
            }
            try {
                int a11 = g0.a(getContext(), "mbridge_reward_video_icon", "drawable");
                if (g0.a(a11) && (drawable = getContext().getResources().getDrawable(a11)) != null) {
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    this.f34692j.setCompoundDrawables(drawable, null, null, null);
                    this.f34692j.setCompoundDrawablePadding(5);
                }
            } catch (Throwable th3) {
                o0.b("MBridgeSegmentsProgressBar", th3.getMessage());
            }
            this.f34692j.setText(a(this.f34688f));
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(0);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 25);
            linearLayout.setLayoutParams(layoutParams2);
            for (int i13 = 0; i13 < this.f34684b; i13++) {
                ProgressBar progressBar = new ProgressBar(getContext(), null, R.attr.progressBarStyleHorizontal);
                progressBar.setMax(100);
                progressBar.setProgress(0);
                progressBar.setProgressDrawable(getSegmentLayerDrawable());
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, 20, 1.0f);
                int i14 = this.f34686d;
                layoutParams3.leftMargin = i14 / 2;
                layoutParams3.rightMargin = i14 / 2;
                progressBar.setLayoutParams(layoutParams3);
                linearLayout.addView(progressBar);
                this.f34691i.add(progressBar);
            }
            int i15 = this.f34685c;
            if (i15 == 1) {
                setPadding(15, 10, 15, 25);
                addView(this.f34692j);
                addView(linearLayout);
            } else {
                if (i15 != 2) {
                    addView(linearLayout);
                    return;
                }
                setPadding(15, 0, 15, 25);
                layoutParams2.gravity = 16;
                layoutParams2.weight = 1.0f;
                addView(linearLayout);
                addView(this.f34692j);
            }
        } catch (Throwable th4) {
            o0.b("MBridgeSegmentsProgressBar", th4.getMessage());
        }
    }

    private GradientDrawable getBackgroundDrawable() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setGradientType(0);
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        gradientDrawable.setDither(true);
        gradientDrawable.setColors(new int[]{0, 1291845632});
        return gradientDrawable;
    }

    private LayerDrawable getSegmentLayerDrawable() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(this.f34687e);
        gradientDrawable.setColor(this.f34689g);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setCornerRadius(this.f34687e);
        gradientDrawable2.setColor(this.f34690h);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gradientDrawable, new ScaleDrawable(gradientDrawable2, 3, 1.0f, -1.0f)});
        layerDrawable.setId(0, R.id.background);
        layerDrawable.setId(1, R.id.progress);
        return layerDrawable;
    }

    public void dismiss() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(1000L);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.mbridge.msdk.dycreator.baseview.cusview.MBridgeSegmentsProgressBar.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                MBridgeSegmentsProgressBar.this.setVisibility(8);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        startAnimation(alphaAnimation);
    }

    public void init(int i11, int i12) {
        this.f34684b = i11;
        this.f34685c = i12;
        a();
    }

    public void init(int i11, int i12, int i13, int i14) {
        this.f34684b = i11;
        this.f34685c = i12;
        this.f34690h = i13;
        this.f34689g = i14;
        a();
    }

    public void init(int i11, int i12, int i13, int i14, int i15, int i16) {
        this.f34684b = i11;
        this.f34685c = i12;
        this.f34690h = i13;
        this.f34689g = i14;
        this.f34686d = i15;
        this.f34687e = i16;
        a();
    }

    public void setIndicatorText(String str) {
        this.f34693k = str;
    }

    public void setProgress(int i11, int i12) {
        try {
            if (this.f34691i.size() == 0) {
                return;
            }
            if (i12 < this.f34691i.size()) {
                this.f34691i.get(i12).setProgress(i11);
            }
            int i13 = i12 + 1;
            if (i13 > this.f34688f) {
                this.f34688f = i13;
                TextView textView = this.f34692j;
                if (textView != null) {
                    textView.setText(a(i13));
                }
            }
        } catch (Throwable th2) {
            o0.b("MBridgeSegmentsProgressBar", th2.getMessage());
        }
    }
}
