package com.mbridge.msdk.dycreator.baseview.cusview;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.same.image.b;
import com.mbridge.msdk.foundation.tools.g0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;

/* loaded from: classes5.dex */
public class MBridgeBaitClickView extends RelativeLayout {
    public static final int ANIMATION_TYPE_DOUBLE_CLICK = 4;
    public static final int ANIMATION_TYPE_FAST_SCALE = 1;
    public static final int ANIMATION_TYPE_ROTATE = 5;
    public static final int ANIMATION_TYPE_SLOW_SCALE = 2;
    public static final int ANIMATION_TYPE_SLOW_SCALE_WITH_PAUSE = 3;

    /* renamed from: a, reason: collision with root package name */
    private MBridgeDyImageView f34641a;

    /* renamed from: b, reason: collision with root package name */
    private MBridgeDyImageView f34642b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f34643c;

    /* renamed from: d, reason: collision with root package name */
    private String f34644d;

    /* renamed from: e, reason: collision with root package name */
    private String f34645e;

    /* renamed from: f, reason: collision with root package name */
    private String f34646f;

    /* renamed from: g, reason: collision with root package name */
    private int f34647g;

    /* renamed from: h, reason: collision with root package name */
    private int f34648h;

    /* renamed from: i, reason: collision with root package name */
    private Animation f34649i;

    /* renamed from: j, reason: collision with root package name */
    private Animation f34650j;

    /* renamed from: k, reason: collision with root package name */
    private Animation f34651k;

    /* renamed from: l, reason: collision with root package name */
    private Animation f34652l;

    public MBridgeBaitClickView(@NonNull Context context) {
        super(context);
        this.f34644d = "";
        this.f34645e = "";
        this.f34646f = "Click now for details";
        this.f34647g = 1;
        this.f34648h = 1342177280;
    }

    public MBridgeBaitClickView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f34644d = "";
        this.f34645e = "";
        this.f34646f = "Click now for details";
        this.f34647g = 1;
        this.f34648h = 1342177280;
    }

    public MBridgeBaitClickView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f34644d = "";
        this.f34645e = "";
        this.f34646f = "Click now for details";
        this.f34647g = 1;
        this.f34648h = 1342177280;
    }

    public MBridgeBaitClickView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        this.f34644d = "";
        this.f34645e = "";
        this.f34646f = "Click now for details";
        this.f34647g = 1;
        this.f34648h = 1342177280;
    }

    private void a() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 0.8f, 1.0f, 1, 0.5f, 1, 0.5f);
        this.f34649i = scaleAnimation;
        scaleAnimation.setDuration(200L);
        this.f34649i.setRepeatCount(1);
        this.f34649i.setAnimationListener(new Animation.AnimationListener() { // from class: com.mbridge.msdk.dycreator.baseview.cusview.MBridgeBaitClickView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                MBridgeBaitClickView.this.postDelayed(new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.cusview.MBridgeBaitClickView.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (MBridgeBaitClickView.this.f34641a != null) {
                            MBridgeBaitClickView.this.f34641a.startAnimation(MBridgeBaitClickView.this.f34649i);
                        }
                    }
                }, 1000L);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        MBridgeDyImageView mBridgeDyImageView = this.f34641a;
        if (mBridgeDyImageView != null) {
            mBridgeDyImageView.startAnimation(this.f34649i);
        }
    }

    private void b() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.7f, 1.0f, 0.7f, 1, 0.5f, 1, 0.5f);
        this.f34649i = scaleAnimation;
        scaleAnimation.setDuration(200L);
        this.f34649i.setRepeatCount(-1);
        this.f34649i.setRepeatMode(2);
        MBridgeDyImageView mBridgeDyImageView = this.f34641a;
        if (mBridgeDyImageView != null) {
            mBridgeDyImageView.startAnimation(this.f34649i);
        }
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.2f, 0.0f, 1.2f, 1, 0.5f, 1, 0.5f);
        this.f34650j = scaleAnimation2;
        scaleAnimation2.setDuration(400L);
        this.f34650j.setRepeatCount(-1);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.3f);
        this.f34651k = alphaAnimation;
        alphaAnimation.setDuration(400L);
        this.f34651k.setRepeatCount(-1);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(this.f34650j);
        animationSet.addAnimation(this.f34651k);
        MBridgeDyImageView mBridgeDyImageView2 = this.f34642b;
        if (mBridgeDyImageView2 != null) {
            mBridgeDyImageView2.startAnimation(animationSet);
        }
    }

    private void c() {
        RotateAnimation rotateAnimation = new RotateAnimation(-10.0f, 30.0f, 1, 0.5f, 1, 0.5f);
        this.f34652l = rotateAnimation;
        rotateAnimation.setDuration(300L);
        this.f34652l.setRepeatMode(2);
        this.f34652l.setRepeatCount(-1);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.2f, 0.0f, 1.2f, 1, 0.5f, 1, 0.5f);
        this.f34650j = scaleAnimation;
        scaleAnimation.setDuration(600L);
        this.f34650j.setRepeatCount(-1);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        this.f34651k = alphaAnimation;
        alphaAnimation.setDuration(600L);
        this.f34651k.setRepeatCount(-1);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(this.f34650j);
        animationSet.addAnimation(this.f34651k);
        MBridgeDyImageView mBridgeDyImageView = this.f34641a;
        if (mBridgeDyImageView != null) {
            mBridgeDyImageView.startAnimation(this.f34652l);
        }
        MBridgeDyImageView mBridgeDyImageView2 = this.f34642b;
        if (mBridgeDyImageView2 != null) {
            mBridgeDyImageView2.startAnimation(animationSet);
        }
    }

    private void d() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.7f, 1.0f, 0.7f, 1, 0.5f, 1, 0.5f);
        this.f34649i = scaleAnimation;
        scaleAnimation.setDuration(500L);
        this.f34649i.setRepeatCount(-1);
        this.f34649i.setRepeatMode(2);
        MBridgeDyImageView mBridgeDyImageView = this.f34641a;
        if (mBridgeDyImageView != null) {
            mBridgeDyImageView.startAnimation(this.f34649i);
        }
    }

    private void e() {
        MBridgeDyImageView mBridgeDyImageView = this.f34642b;
        if (mBridgeDyImageView != null) {
            mBridgeDyImageView.setVisibility(4);
        }
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.7f, 1.0f, 0.7f, 1, 0.5f, 1, 0.5f);
        this.f34649i = scaleAnimation;
        scaleAnimation.setDuration(500L);
        this.f34649i.setRepeatCount(1);
        this.f34649i.setRepeatMode(2);
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.5f, 0.0f, 1.5f, 1, 0.5f, 1, 0.5f);
        this.f34650j = scaleAnimation2;
        scaleAnimation2.setDuration(1000L);
        this.f34650j.setRepeatCount(0);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        this.f34651k = alphaAnimation;
        alphaAnimation.setDuration(1000L);
        this.f34651k.setRepeatCount(0);
        final AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(this.f34650j);
        animationSet.addAnimation(this.f34651k);
        this.f34650j.setAnimationListener(new Animation.AnimationListener() { // from class: com.mbridge.msdk.dycreator.baseview.cusview.MBridgeBaitClickView.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (MBridgeBaitClickView.this.f34642b != null) {
                    MBridgeBaitClickView.this.f34642b.setVisibility(4);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (MBridgeBaitClickView.this.f34642b != null) {
                    MBridgeBaitClickView.this.f34642b.setVisibility(0);
                }
            }
        });
        this.f34649i.setAnimationListener(new Animation.AnimationListener() { // from class: com.mbridge.msdk.dycreator.baseview.cusview.MBridgeBaitClickView.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                MBridgeBaitClickView.this.postDelayed(new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.cusview.MBridgeBaitClickView.4.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (MBridgeBaitClickView.this.f34641a != null) {
                            MBridgeBaitClickView.this.f34641a.startAnimation(MBridgeBaitClickView.this.f34649i);
                        }
                    }
                }, 1000L);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                MBridgeBaitClickView.this.postDelayed(new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.cusview.MBridgeBaitClickView.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (MBridgeBaitClickView.this.f34642b != null) {
                            MBridgeBaitClickView.this.f34642b.startAnimation(animationSet);
                        }
                    }
                }, 550L);
            }
        });
        MBridgeDyImageView mBridgeDyImageView2 = this.f34641a;
        if (mBridgeDyImageView2 != null) {
            mBridgeDyImageView2.startAnimation(this.f34649i);
        }
    }

    private void getDefaultClickText() {
        try {
            this.f34646f = getContext().getResources().getConfiguration().locale.getLanguage().contains("zh") ? "点击查看详情" : "Click now for details";
        } catch (Throwable th2) {
            o0.b("MBridgeAnimationClickView", th2.getMessage());
        }
    }

    public void init() {
        try {
            setBackgroundColor(this.f34648h);
            getDefaultClickText();
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            int a11 = t0.a(getContext(), 55.0f);
            int a12 = t0.a(getContext(), 33.0f);
            this.f34642b = new MBridgeDyImageView(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a11, a11);
            layoutParams.setMargins(a12, a12, 0, 0);
            this.f34642b.setLayoutParams(layoutParams);
            final int a13 = g0.a(getContext(), "mbridge_icon_click_circle", "drawable");
            if (TextUtils.isEmpty(this.f34645e)) {
                this.f34642b.setImageResource(a13);
            } else {
                b.a(c.m().d()).a(this.f34644d, new com.mbridge.msdk.foundation.same.image.c() { // from class: com.mbridge.msdk.dycreator.baseview.cusview.MBridgeBaitClickView.1
                    @Override // com.mbridge.msdk.foundation.same.image.c
                    public void onFailedLoad(String str, String str2) {
                        MBridgeBaitClickView.this.f34642b.setImageResource(a13);
                    }

                    @Override // com.mbridge.msdk.foundation.same.image.c
                    public void onSuccessLoad(Bitmap bitmap, String str) {
                        if (bitmap.isRecycled()) {
                            return;
                        }
                        MBridgeBaitClickView.this.f34642b.setImageBitmap(bitmap);
                    }
                });
            }
            int a14 = t0.a(getContext(), 108.0f);
            int a15 = t0.a(getContext(), 35.0f);
            int a16 = t0.a(getContext(), 43.0f);
            this.f34641a = new MBridgeDyImageView(getContext());
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(a14, a14);
            layoutParams2.setMargins(a15, a16, 0, 0);
            this.f34641a.setLayoutParams(layoutParams2);
            final int a17 = g0.a(getContext(), "mbridge_icon_click_hand", "drawable");
            if (TextUtils.isEmpty(this.f34644d)) {
                this.f34641a.setImageResource(a17);
            } else {
                b.a(c.m().d()).a(this.f34644d, new com.mbridge.msdk.foundation.same.image.c() { // from class: com.mbridge.msdk.dycreator.baseview.cusview.MBridgeBaitClickView.2
                    @Override // com.mbridge.msdk.foundation.same.image.c
                    public void onFailedLoad(String str, String str2) {
                        MBridgeBaitClickView.this.f34641a.setImageResource(a17);
                    }

                    @Override // com.mbridge.msdk.foundation.same.image.c
                    public void onSuccessLoad(Bitmap bitmap, String str) {
                        if (bitmap.isRecycled()) {
                            return;
                        }
                        MBridgeBaitClickView.this.f34641a.setImageBitmap(bitmap);
                    }
                });
            }
            relativeLayout.addView(this.f34642b);
            relativeLayout.addView(this.f34641a);
            LinearLayout linearLayout = new LinearLayout(getContext());
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.addRule(13);
            linearLayout.setLayoutParams(layoutParams3);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(1);
            linearLayout.addView(relativeLayout);
            this.f34643c = new TextView(getContext());
            this.f34643c.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            this.f34643c.setText(this.f34646f);
            this.f34643c.setTextColor(-1);
            this.f34643c.setGravity(14);
            linearLayout.addView(this.f34643c);
            addView(linearLayout);
        } catch (Throwable th2) {
            o0.b("MBridgeAnimationClickView", th2.getMessage());
        }
    }

    public void init(int i11) {
        this.f34647g = i11;
        init();
    }

    public void init(int i11, int i12) {
        this.f34648h = i11;
        this.f34647g = i12;
        init();
    }

    public void init(int i11, int i12, String str, String str2, String str3) {
        this.f34648h = i11;
        this.f34647g = i12;
        this.f34644d = str;
        this.f34645e = str2;
        this.f34646f = str3;
        init();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        clearAnimation();
        Animation animation = this.f34649i;
        if (animation != null) {
            animation.cancel();
        }
        Animation animation2 = this.f34650j;
        if (animation2 != null) {
            animation2.cancel();
        }
        Animation animation3 = this.f34651k;
        if (animation3 != null) {
            animation3.cancel();
        }
        Animation animation4 = this.f34652l;
        if (animation4 != null) {
            animation4.cancel();
        }
    }

    public void startAnimation() {
        int i11 = this.f34647g;
        if (i11 == 2) {
            this.f34642b.setVisibility(4);
            d();
            return;
        }
        if (i11 == 3) {
            e();
            return;
        }
        if (i11 == 4) {
            this.f34642b.setVisibility(4);
            a();
        } else if (i11 != 5) {
            b();
        } else {
            c();
        }
    }
}
