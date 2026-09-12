package com.mbridge.msdk.splash.view.nativeview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mbridge.msdk.foundation.tools.t0;

/* loaded from: classes5.dex */
public class MBSplashClickView extends RelativeLayout {
    public final int TYPE_SPLASH_BTN_CLICK;
    public final int TYPE_SPLASH_BTN_GO;
    public final int TYPE_SPLASH_BTN_OPEN;

    /* renamed from: a, reason: collision with root package name */
    private final String f37774a;

    /* renamed from: b, reason: collision with root package name */
    private final String f37775b;

    /* renamed from: c, reason: collision with root package name */
    private final String f37776c;

    /* renamed from: d, reason: collision with root package name */
    private final String f37777d;

    /* renamed from: e, reason: collision with root package name */
    private final String f37778e;

    /* renamed from: f, reason: collision with root package name */
    private final String f37779f;

    /* renamed from: g, reason: collision with root package name */
    private final String f37780g;

    /* renamed from: h, reason: collision with root package name */
    private final String f37781h;

    /* renamed from: i, reason: collision with root package name */
    private final String f37782i;

    /* renamed from: j, reason: collision with root package name */
    private final String f37783j;

    /* renamed from: k, reason: collision with root package name */
    private final String f37784k;

    /* renamed from: l, reason: collision with root package name */
    private String f37785l;

    /* renamed from: m, reason: collision with root package name */
    private int f37786m;

    /* renamed from: n, reason: collision with root package name */
    private ImageView f37787n;

    /* renamed from: o, reason: collision with root package name */
    private ImageView f37788o;

    /* renamed from: p, reason: collision with root package name */
    private final RectF f37789p;

    /* renamed from: q, reason: collision with root package name */
    private final Paint f37790q;

    /* renamed from: r, reason: collision with root package name */
    private final Paint f37791r;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements Animation.AnimationListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ScaleAnimation f37792a;

        /* renamed from: com.mbridge.msdk.splash.view.nativeview.MBSplashClickView$a$a, reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        class RunnableC0548a implements Runnable {
            RunnableC0548a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MBSplashClickView.this.f37788o.startAnimation(a.this.f37792a);
            }
        }

        a(ScaleAnimation scaleAnimation) {
            this.f37792a = scaleAnimation;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            MBSplashClickView.this.f37788o.setVisibility(4);
            MBSplashClickView.this.f37788o.postDelayed(new RunnableC0548a(), 700L);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            MBSplashClickView.this.f37788o.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ScaleAnimation f37795a;

        b(ScaleAnimation scaleAnimation) {
            this.f37795a = scaleAnimation;
        }

        @Override // java.lang.Runnable
        public void run() {
            MBSplashClickView.this.f37788o.startAnimation(this.f37795a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c implements Animation.AnimationListener {

        /* loaded from: classes5.dex */
        class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Animation f37798a;

            a(Animation animation) {
                this.f37798a = animation;
            }

            @Override // java.lang.Runnable
            public void run() {
                MBSplashClickView.this.f37787n.startAnimation(this.f37798a);
            }
        }

        c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            MBSplashClickView.this.f37787n.setVisibility(4);
            MBSplashClickView.this.f37787n.postDelayed(new a(animation), 2000L);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            MBSplashClickView.this.f37787n.setVisibility(0);
        }
    }

    public MBSplashClickView(Context context) {
        super(context);
        this.f37774a = "浏览第三方应用";
        this.f37775b = "View";
        this.f37776c = "打开第三方应用";
        this.f37777d = "Open";
        this.f37778e = "下载第三方应用";
        this.f37779f = "Install";
        this.f37780g = "mbridge_splash_btn_arrow_right";
        this.f37781h = "mbridge_splash_btn_circle";
        this.f37782i = "mbridge_splash_btn_finger";
        this.f37783j = "mbridge_splash_btn_go";
        this.f37784k = "mbridge_splash_btn_light";
        this.TYPE_SPLASH_BTN_OPEN = 1;
        this.TYPE_SPLASH_BTN_GO = 2;
        this.TYPE_SPLASH_BTN_CLICK = 3;
        this.f37789p = new RectF();
        this.f37790q = new Paint();
        this.f37791r = new Paint();
        a();
    }

    public MBSplashClickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f37774a = "浏览第三方应用";
        this.f37775b = "View";
        this.f37776c = "打开第三方应用";
        this.f37777d = "Open";
        this.f37778e = "下载第三方应用";
        this.f37779f = "Install";
        this.f37780g = "mbridge_splash_btn_arrow_right";
        this.f37781h = "mbridge_splash_btn_circle";
        this.f37782i = "mbridge_splash_btn_finger";
        this.f37783j = "mbridge_splash_btn_go";
        this.f37784k = "mbridge_splash_btn_light";
        this.TYPE_SPLASH_BTN_OPEN = 1;
        this.TYPE_SPLASH_BTN_GO = 2;
        this.TYPE_SPLASH_BTN_CLICK = 3;
        this.f37789p = new RectF();
        this.f37790q = new Paint();
        this.f37791r = new Paint();
        a();
    }

    public MBSplashClickView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f37774a = "浏览第三方应用";
        this.f37775b = "View";
        this.f37776c = "打开第三方应用";
        this.f37777d = "Open";
        this.f37778e = "下载第三方应用";
        this.f37779f = "Install";
        this.f37780g = "mbridge_splash_btn_arrow_right";
        this.f37781h = "mbridge_splash_btn_circle";
        this.f37782i = "mbridge_splash_btn_finger";
        this.f37783j = "mbridge_splash_btn_go";
        this.f37784k = "mbridge_splash_btn_light";
        this.TYPE_SPLASH_BTN_OPEN = 1;
        this.TYPE_SPLASH_BTN_GO = 2;
        this.TYPE_SPLASH_BTN_CLICK = 3;
        this.f37789p = new RectF();
        this.f37790q = new Paint();
        this.f37791r = new Paint();
        a();
    }

    public MBSplashClickView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        this.f37774a = "浏览第三方应用";
        this.f37775b = "View";
        this.f37776c = "打开第三方应用";
        this.f37777d = "Open";
        this.f37778e = "下载第三方应用";
        this.f37779f = "Install";
        this.f37780g = "mbridge_splash_btn_arrow_right";
        this.f37781h = "mbridge_splash_btn_circle";
        this.f37782i = "mbridge_splash_btn_finger";
        this.f37783j = "mbridge_splash_btn_go";
        this.f37784k = "mbridge_splash_btn_light";
        this.TYPE_SPLASH_BTN_OPEN = 1;
        this.TYPE_SPLASH_BTN_GO = 2;
        this.TYPE_SPLASH_BTN_CLICK = 3;
        this.f37789p = new RectF();
        this.f37790q = new Paint();
        this.f37791r = new Paint();
    }

    private void a() {
        this.f37790q.setAntiAlias(true);
        this.f37790q.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        this.f37791r.setAntiAlias(true);
        this.f37791r.setColor(-1);
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
                this.f37786m = 3;
                return true;
            case 1:
            case 4:
                this.f37786m = 1;
                return true;
            case 2:
            case 5:
                this.f37786m = 2;
                return true;
            default:
                return false;
        }
    }

    private void b() {
        RelativeLayout.LayoutParams layoutParams;
        int i11;
        if (!a(this.f37785l)) {
            boolean contains = getContext().getResources().getConfiguration().locale.getLanguage().contains("zh");
            if (TextUtils.isEmpty(this.f37785l)) {
                this.f37785l = contains ? "浏览第三方应用" : "View";
            }
            this.f37786m = 2;
        }
        setBgDrawable(this.f37786m);
        TextView textView = new TextView(getContext());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(15);
        textView.setLayoutParams(layoutParams2);
        textView.setGravity(17);
        textView.setTextSize(20.0f);
        textView.setTextColor(-1);
        textView.setText(this.f37785l);
        this.f37787n = new ImageView(getContext());
        int i12 = this.f37786m;
        if (i12 == 2) {
            i11 = getResources().getIdentifier("mbridge_splash_btn_go", "drawable", com.mbridge.msdk.foundation.controller.c.m().h());
            layoutParams = new RelativeLayout.LayoutParams(t0.a(getContext(), 35.0f), t0.a(getContext(), 35.0f));
            layoutParams.addRule(11);
            layoutParams.addRule(15);
            layoutParams.rightMargin = t0.a(getContext(), 10.0f);
        } else if (i12 == 1) {
            i11 = getResources().getIdentifier("mbridge_splash_btn_light", "drawable", com.mbridge.msdk.foundation.controller.c.m().h());
            layoutParams = new RelativeLayout.LayoutParams(-2, -1);
            layoutParams.leftMargin = 20;
            layoutParams.rightMargin = 20;
            ImageView imageView = new ImageView(getContext());
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -1);
            layoutParams3.addRule(11);
            layoutParams3.addRule(15);
            layoutParams3.rightMargin = t0.a(getContext(), 50.0f);
            imageView.setImageResource(getResources().getIdentifier("mbridge_splash_btn_arrow_right", "drawable", com.mbridge.msdk.foundation.controller.c.m().h()));
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            imageView.setLayoutParams(layoutParams3);
            addView(imageView);
        } else if (i12 == 3) {
            i11 = getResources().getIdentifier("mbridge_splash_btn_finger", "drawable", com.mbridge.msdk.foundation.controller.c.m().h());
            layoutParams = new RelativeLayout.LayoutParams(t0.a(getContext(), 25.0f), t0.a(getContext(), 25.0f));
            layoutParams.addRule(11);
            layoutParams.rightMargin = t0.a(getContext(), 50.0f);
            layoutParams.topMargin = t0.a(getContext(), 18.0f);
            this.f37788o = new ImageView(getContext());
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(t0.a(getContext(), 30.0f), t0.a(getContext(), 30.0f));
            layoutParams4.addRule(11);
            layoutParams4.rightMargin = t0.a(getContext(), 50.0f);
            layoutParams4.topMargin = t0.a(getContext(), 5.0f);
            this.f37788o.setLayoutParams(layoutParams4);
            this.f37788o.setImageResource(getResources().getIdentifier("mbridge_splash_btn_circle", "drawable", com.mbridge.msdk.foundation.controller.c.m().h()));
            addView(this.f37788o);
        } else {
            layoutParams = null;
            i11 = 0;
        }
        this.f37787n.setLayoutParams(layoutParams);
        this.f37787n.setImageResource(i11);
        addView(textView);
        addView(this.f37787n);
        invalidate();
    }

    private void c() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.7f, 1.0f, 0.7f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(400L);
        scaleAnimation.setRepeatCount(-1);
        scaleAnimation.setRepeatMode(2);
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 0.5f, 0.0f, 0.5f, 1, 0.5f, 1, 0.5f);
        scaleAnimation2.setDuration(200L);
        scaleAnimation2.setAnimationListener(new a(scaleAnimation2));
        this.f37788o.setVisibility(4);
        this.f37787n.startAnimation(scaleAnimation);
        this.f37788o.postDelayed(new b(scaleAnimation2), 500L);
    }

    private void d() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 0.8f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(500L);
        scaleAnimation.setRepeatCount(-1);
        scaleAnimation.setRepeatMode(2);
        this.f37787n.startAnimation(scaleAnimation);
    }

    private void e() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0, -100.0f, 0, 1000.0f, 0, 0.0f, 0, 0.0f);
        translateAnimation.setDuration(1000L);
        translateAnimation.setAnimationListener(new c());
        this.f37787n.startAnimation(translateAnimation);
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
        canvas.saveLayer(this.f37789p, this.f37791r, 31);
        canvas.drawRoundRect(this.f37789p, 200.0f, 200.0f, this.f37791r);
        canvas.saveLayer(this.f37789p, this.f37790q, 31);
        super.draw(canvas);
        canvas.restore();
    }

    public void initView(String str) {
        this.f37785l = str;
        b();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        int i11 = this.f37786m;
        if (i11 == 2) {
            d();
        } else if (i11 == 1) {
            e();
        } else if (i11 == 3) {
            c();
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i11, int i12, int i13, int i14) {
        super.onLayout(z10, i11, i12, i13, i14);
        this.f37789p.set(0.0f, 0.0f, getWidth(), getHeight());
    }
}
