package com.mbridge.msdk.dycreator.baseview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.same.image.b;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;

/* loaded from: classes5.dex */
public class MBSplashClickView extends MBRelativeLayout {
    public final int TYPE_SPLASH_BTN_CLICK;
    public final int TYPE_SPLASH_BTN_GO;
    public final int TYPE_SPLASH_BTN_OPEN;

    /* renamed from: f, reason: collision with root package name */
    private final String f34557f;

    /* renamed from: g, reason: collision with root package name */
    private final String f34558g;

    /* renamed from: h, reason: collision with root package name */
    private final String f34559h;

    /* renamed from: i, reason: collision with root package name */
    private final String f34560i;

    /* renamed from: j, reason: collision with root package name */
    private final String f34561j;

    /* renamed from: k, reason: collision with root package name */
    private final String f34562k;

    /* renamed from: l, reason: collision with root package name */
    private final String f34563l;

    /* renamed from: m, reason: collision with root package name */
    private final String f34564m;

    /* renamed from: n, reason: collision with root package name */
    private final String f34565n;

    /* renamed from: o, reason: collision with root package name */
    private final String f34566o;

    /* renamed from: p, reason: collision with root package name */
    private final String f34567p;

    /* renamed from: q, reason: collision with root package name */
    private final String f34568q;

    /* renamed from: r, reason: collision with root package name */
    private String f34569r;

    /* renamed from: s, reason: collision with root package name */
    private int f34570s;

    /* renamed from: t, reason: collision with root package name */
    private ImageView f34571t;

    /* renamed from: u, reason: collision with root package name */
    private ImageView f34572u;

    /* renamed from: v, reason: collision with root package name */
    private final RectF f34573v;

    /* renamed from: w, reason: collision with root package name */
    private final Paint f34574w;

    /* renamed from: x, reason: collision with root package name */
    private final Paint f34575x;

    public MBSplashClickView(Context context) {
        super(context);
        this.f34557f = "浏览第三方应用";
        this.f34558g = "View";
        this.f34559h = "打开第三方应用";
        this.f34560i = "Open";
        this.f34561j = "下载第三方应用";
        this.f34562k = "Install";
        this.f34563l = "mbridge_splash_btn_arrow_right";
        this.f34564m = "mbridge_splash_btn_circle";
        this.f34565n = "mbridge_splash_btn_finger";
        this.f34566o = "mbridge_splash_btn_go";
        this.f34567p = "mbridge_splash_btn_light";
        this.f34568q = "mbridge_expand_data";
        this.TYPE_SPLASH_BTN_OPEN = 1;
        this.TYPE_SPLASH_BTN_GO = 2;
        this.TYPE_SPLASH_BTN_CLICK = 3;
        this.f34573v = new RectF();
        this.f34574w = new Paint();
        this.f34575x = new Paint();
        a();
    }

    public MBSplashClickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f34557f = "浏览第三方应用";
        this.f34558g = "View";
        this.f34559h = "打开第三方应用";
        this.f34560i = "Open";
        this.f34561j = "下载第三方应用";
        this.f34562k = "Install";
        this.f34563l = "mbridge_splash_btn_arrow_right";
        this.f34564m = "mbridge_splash_btn_circle";
        this.f34565n = "mbridge_splash_btn_finger";
        this.f34566o = "mbridge_splash_btn_go";
        this.f34567p = "mbridge_splash_btn_light";
        this.f34568q = "mbridge_expand_data";
        this.TYPE_SPLASH_BTN_OPEN = 1;
        this.TYPE_SPLASH_BTN_GO = 2;
        this.TYPE_SPLASH_BTN_CLICK = 3;
        this.f34573v = new RectF();
        this.f34574w = new Paint();
        this.f34575x = new Paint();
        a();
    }

    public MBSplashClickView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f34557f = "浏览第三方应用";
        this.f34558g = "View";
        this.f34559h = "打开第三方应用";
        this.f34560i = "Open";
        this.f34561j = "下载第三方应用";
        this.f34562k = "Install";
        this.f34563l = "mbridge_splash_btn_arrow_right";
        this.f34564m = "mbridge_splash_btn_circle";
        this.f34565n = "mbridge_splash_btn_finger";
        this.f34566o = "mbridge_splash_btn_go";
        this.f34567p = "mbridge_splash_btn_light";
        this.f34568q = "mbridge_expand_data";
        this.TYPE_SPLASH_BTN_OPEN = 1;
        this.TYPE_SPLASH_BTN_GO = 2;
        this.TYPE_SPLASH_BTN_CLICK = 3;
        this.f34573v = new RectF();
        this.f34574w = new Paint();
        this.f34575x = new Paint();
        a();
    }

    private View a(ViewGroup viewGroup, String str) {
        if (viewGroup != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    if (viewGroup.getId() == str.hashCode()) {
                        return viewGroup;
                    }
                    int childCount = viewGroup.getChildCount();
                    for (int i11 = 0; i11 < childCount; i11++) {
                        View childAt = viewGroup.getChildAt(i11);
                        if (childAt.getId() == str.hashCode()) {
                            return childAt;
                        }
                        if (childAt instanceof ViewGroup) {
                            a((ViewGroup) childAt, str);
                        }
                    }
                    return null;
                }
            } catch (Exception e11) {
                o0.b("MBSplashClickView", e11.getMessage());
            }
        }
        return null;
    }

    private void a() {
        this.f34574w.setAntiAlias(true);
        this.f34574w.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        this.f34575x.setAntiAlias(true);
        this.f34575x.setColor(-1);
    }

    private void a(final ImageView imageView, String str, final int i11) {
        if (imageView == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                imageView.setBackgroundResource(i11);
            }
            b.a(c.m().d()).a(str, new com.mbridge.msdk.foundation.same.image.c() { // from class: com.mbridge.msdk.dycreator.baseview.MBSplashClickView.4
                @Override // com.mbridge.msdk.foundation.same.image.c
                public void onFailedLoad(String str2, String str3) {
                    ImageView imageView2 = imageView;
                    if (imageView2 != null) {
                        imageView2.setBackgroundResource(i11);
                    }
                }

                @Override // com.mbridge.msdk.foundation.same.image.c
                public void onSuccessLoad(Bitmap bitmap, String str2) {
                    if (imageView != null) {
                        if (bitmap == null || bitmap.isRecycled()) {
                            imageView.setBackgroundResource(i11);
                            return;
                        }
                        if (MBSplashClickView.this.f34572u != null) {
                            MBSplashClickView mBSplashClickView = MBSplashClickView.this;
                            mBSplashClickView.removeView(mBSplashClickView.f34572u);
                        }
                        imageView.setImageBitmap(bitmap);
                    }
                }
            });
        } catch (Exception e11) {
            o0.a("MBSplashClickView", e11.getMessage());
            imageView.setBackgroundResource(i11);
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:21:0x0051. Please report as an issue. */
    private boolean a(String str) {
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
            case 3:
                this.f34570s = 3;
                return true;
            case 1:
            case 4:
                this.f34570s = 1;
                return true;
            case 2:
            case 5:
                this.f34570s = 2;
                return true;
            default:
                return false;
        }
    }

    private void b() {
        RelativeLayout.LayoutParams layoutParams;
        int i11;
        View a11;
        if (!a(this.f34569r)) {
            boolean contains = getContext().getResources().getConfiguration().locale.getLanguage().contains("zh");
            if (TextUtils.isEmpty(this.f34569r)) {
                this.f34569r = contains ? "浏览第三方应用" : "View";
            }
            this.f34570s = 2;
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        String charSequence = (viewGroup == null || (a11 = a(viewGroup, "mbridge_expand_data")) == null || !(a11 instanceof TextView)) ? "" : ((TextView) a11).getText().toString();
        setBgDrawable(this.f34570s);
        TextView textView = new TextView(getContext());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(15);
        textView.setLayoutParams(layoutParams2);
        textView.setGravity(17);
        textView.setTextSize(20.0f);
        textView.setTextColor(-1);
        textView.setText(this.f34569r);
        this.f34571t = new ImageView(getContext());
        int i12 = this.f34570s;
        if (i12 == 2) {
            i11 = getResources().getIdentifier("mbridge_splash_btn_go", "drawable", c.m().h());
            layoutParams = new RelativeLayout.LayoutParams(t0.a(getContext(), 35.0f), t0.a(getContext(), 35.0f));
            layoutParams.addRule(11);
            layoutParams.addRule(15);
            layoutParams.rightMargin = t0.a(getContext(), 10.0f);
        } else if (i12 == 1) {
            i11 = getResources().getIdentifier("mbridge_splash_btn_light", "drawable", c.m().h());
            layoutParams = new RelativeLayout.LayoutParams(-2, -1);
            layoutParams.leftMargin = 20;
            layoutParams.rightMargin = 20;
            ImageView imageView = new ImageView(getContext());
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -1);
            layoutParams3.addRule(11);
            layoutParams3.addRule(15);
            layoutParams3.rightMargin = t0.a(getContext(), 50.0f);
            imageView.setImageResource(getResources().getIdentifier("mbridge_splash_btn_arrow_right", "drawable", c.m().h()));
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            imageView.setLayoutParams(layoutParams3);
            addView(imageView);
        } else if (i12 == 3) {
            i11 = getResources().getIdentifier("mbridge_splash_btn_finger", "drawable", c.m().h());
            layoutParams = new RelativeLayout.LayoutParams(t0.a(getContext(), 25.0f), t0.a(getContext(), 25.0f));
            layoutParams.addRule(11);
            layoutParams.rightMargin = t0.a(getContext(), 50.0f);
            layoutParams.topMargin = t0.a(getContext(), 18.0f);
            this.f34572u = new ImageView(getContext());
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(t0.a(getContext(), 30.0f), t0.a(getContext(), 30.0f));
            layoutParams4.addRule(11);
            layoutParams4.rightMargin = t0.a(getContext(), 50.0f);
            layoutParams4.topMargin = t0.a(getContext(), 5.0f);
            this.f34572u.setLayoutParams(layoutParams4);
            this.f34572u.setImageResource(getResources().getIdentifier("mbridge_splash_btn_circle", "drawable", c.m().h()));
            addView(this.f34572u);
        } else {
            layoutParams = null;
            i11 = 0;
        }
        this.f34571t.setLayoutParams(layoutParams);
        if (TextUtils.isEmpty(charSequence)) {
            this.f34571t.setImageResource(i11);
        } else {
            a(this.f34571t, charSequence, i11);
        }
        addView(textView);
        addView(this.f34571t);
        invalidate();
    }

    private void c() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.7f, 1.0f, 0.7f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(1000L);
        scaleAnimation.setRepeatCount(-1);
        scaleAnimation.setRepeatMode(2);
        final ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 0.5f, 0.0f, 0.5f, 1, 0.5f, 1, 0.5f);
        scaleAnimation2.setDuration(400L);
        scaleAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.mbridge.msdk.dycreator.baseview.MBSplashClickView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                MBSplashClickView.this.f34572u.setVisibility(4);
                MBSplashClickView.this.f34572u.postDelayed(new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.MBSplashClickView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MBSplashClickView.this.f34572u.startAnimation(scaleAnimation2);
                    }
                }, 1600L);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                MBSplashClickView.this.f34572u.setVisibility(0);
            }
        });
        this.f34572u.setVisibility(4);
        this.f34571t.startAnimation(scaleAnimation);
        this.f34572u.postDelayed(new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.MBSplashClickView.2
            @Override // java.lang.Runnable
            public void run() {
                MBSplashClickView.this.f34572u.startAnimation(scaleAnimation2);
            }
        }, 800L);
    }

    private void d() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 0.8f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(500L);
        scaleAnimation.setRepeatCount(-1);
        scaleAnimation.setRepeatMode(2);
        this.f34571t.startAnimation(scaleAnimation);
    }

    private void e() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0, -100.0f, 0, 1000.0f, 0, 0.0f, 0, 0.0f);
        translateAnimation.setDuration(1000L);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.mbridge.msdk.dycreator.baseview.MBSplashClickView.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(final Animation animation) {
                MBSplashClickView.this.f34571t.setVisibility(4);
                MBSplashClickView.this.f34571t.postDelayed(new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.MBSplashClickView.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MBSplashClickView.this.f34571t.startAnimation(animation);
                    }
                }, 2000L);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                MBSplashClickView.this.f34571t.setVisibility(0);
            }
        });
        this.f34571t.startAnimation(translateAnimation);
    }

    private void setBgDrawable(int i11) {
        int parseColor = Color.parseColor("#666666");
        int parseColor2 = Color.parseColor("#8FC31F");
        int parseColor3 = Color.parseColor("#000000");
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (i11 == 2) {
            gradientDrawable.setColor(parseColor2);
        } else {
            gradientDrawable.setColor(parseColor3);
            gradientDrawable.setStroke(2, parseColor);
        }
        gradientDrawable.setCornerRadius(200);
        setBackground(gradientDrawable);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        canvas.saveLayer(this.f34573v, this.f34575x, 31);
        canvas.drawRoundRect(this.f34573v, 200.0f, 200.0f, this.f34575x);
        canvas.saveLayer(this.f34573v, this.f34574w, 31);
        super.draw(canvas);
        canvas.restore();
    }

    public void initView(String str) {
        this.f34569r = str;
        b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mbridge.msdk.dycreator.baseview.MBRelativeLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        int i11 = this.f34570s;
        if (i11 == 2) {
            d();
        } else if (i11 == 1) {
            e();
        } else if (i11 == 3) {
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mbridge.msdk.dycreator.baseview.MBRelativeLayout, android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i11, int i12, int i13, int i14) {
        super.onLayout(z10, i11, i12, i13, i14);
        this.f34573v.set(0.0f, 0.0f, getWidth(), getHeight());
    }
}
