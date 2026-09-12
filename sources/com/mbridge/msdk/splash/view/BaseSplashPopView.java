package com.mbridge.msdk.splash.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.mbridge.msdk.click.j;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.n0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.s0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.foundation.tools.y;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.MBridgeIds;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes5.dex */
public class BaseSplashPopView extends RelativeLayout {
    public static final int TYPE_POP_DEFAULT = 1;
    public static final int TYPE_POP_LARGE = 4;
    public static final int TYPE_POP_MEDIUM = 3;
    public static final int TYPE_POP_SMALL = 2;

    /* renamed from: v, reason: collision with root package name */
    private static final AtomicInteger f37709v = new AtomicInteger(1);

    /* renamed from: a, reason: collision with root package name */
    protected String f37710a;

    /* renamed from: b, reason: collision with root package name */
    protected String f37711b;

    /* renamed from: c, reason: collision with root package name */
    private int f37712c;

    /* renamed from: d, reason: collision with root package name */
    private CampaignEx f37713d;

    /* renamed from: e, reason: collision with root package name */
    protected com.mbridge.msdk.splash.middle.d f37714e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f37715f;

    /* renamed from: g, reason: collision with root package name */
    private ImageView f37716g;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f37717h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f37718i;

    /* renamed from: j, reason: collision with root package name */
    private TextView f37719j;

    /* renamed from: k, reason: collision with root package name */
    private TextView f37720k;

    /* renamed from: l, reason: collision with root package name */
    private TextView f37721l;

    /* renamed from: m, reason: collision with root package name */
    private int f37722m;

    /* renamed from: n, reason: collision with root package name */
    protected Handler f37723n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f37724o;

    /* renamed from: p, reason: collision with root package name */
    protected com.mbridge.msdk.click.a f37725p;

    /* renamed from: q, reason: collision with root package name */
    private j f37726q;

    /* renamed from: r, reason: collision with root package name */
    private Runnable f37727r;

    /* renamed from: s, reason: collision with root package name */
    private Runnable f37728s;

    /* renamed from: t, reason: collision with root package name */
    View.OnClickListener f37729t;

    /* renamed from: u, reason: collision with root package name */
    View.OnClickListener f37730u;

    /* loaded from: classes5.dex */
    class a implements j {
        a() {
        }

        @Override // com.mbridge.msdk.out.BaseTrackingListener
        public void onFinishRedirection(Campaign campaign, String str) {
            if (campaign == null) {
                return;
            }
            s0.a(campaign, BaseSplashPopView.this);
        }

        @Override // com.mbridge.msdk.out.BaseTrackingListener
        public void onRedirectionFailed(Campaign campaign, String str) {
            if (campaign == null) {
                return;
            }
            s0.a(campaign, BaseSplashPopView.this);
        }

        @Override // com.mbridge.msdk.out.BaseTrackingListener
        public void onStartRedirection(Campaign campaign, String str) {
            int i11;
            int i12;
            if (BaseSplashPopView.this.f37712c == 1) {
                int min = Math.min(BaseSplashPopView.this.getWidth(), BaseSplashPopView.this.getHeight());
                int a11 = (t0.a(BaseSplashPopView.this.getContext(), 60.0f) - Math.min(Math.max(min / 4, 70), min)) / 2;
                i11 = t0.a(BaseSplashPopView.this.getContext(), 23.0f) + a11;
                i12 = t0.a(BaseSplashPopView.this.getContext(), 10.0f) + a11;
            } else {
                i11 = 0;
                i12 = 0;
            }
            s0.a(campaign, BaseSplashPopView.this, i11, i12);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements com.mbridge.msdk.foundation.same.image.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f37732a;

        b(boolean z10) {
            this.f37732a = z10;
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onFailedLoad(String str, String str2) {
            o0.b("MBSplashPopView", str);
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onSuccessLoad(Bitmap bitmap, String str) {
            try {
                if (bitmap.isRecycled()) {
                    return;
                }
                Bitmap b11 = this.f37732a ? n0.b(bitmap) : n0.a(bitmap, 1, 16);
                ImageView imageView = BaseSplashPopView.this.f37715f;
                if (b11 != null) {
                    bitmap = b11;
                }
                imageView.setImageBitmap(bitmap);
            } catch (Throwable th2) {
                o0.b("MBSplashPopView", th2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c implements com.mbridge.msdk.foundation.same.image.c {
        c() {
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onFailedLoad(String str, String str2) {
            o0.b("MBSplashPopView", str);
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onSuccessLoad(Bitmap bitmap, String str) {
            try {
                if (bitmap.isRecycled()) {
                    return;
                }
                BaseSplashPopView.this.f37717h.setImageBitmap(y.a(bitmap, 10));
            } catch (Throwable th2) {
                o0.b("MBSplashPopView", th2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class d implements com.mbridge.msdk.foundation.same.image.c {
        d() {
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onFailedLoad(String str, String str2) {
            o0.b("MBSplashPopView", str);
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onSuccessLoad(Bitmap bitmap, String str) {
            try {
                if (bitmap.isRecycled()) {
                    return;
                }
                BaseSplashPopView.this.f37716g.setImageBitmap(n0.a(bitmap, 1, 16));
            } catch (Throwable th2) {
                o0.b("MBSplashPopView", th2.getMessage());
            }
        }
    }

    /* loaded from: classes5.dex */
    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (BaseSplashPopView.this.f37721l != null) {
                if (BaseSplashPopView.this.f37722m != 0) {
                    BaseSplashPopView.g(BaseSplashPopView.this);
                    BaseSplashPopView.this.f37721l.setText(String.valueOf(BaseSplashPopView.this.f37722m));
                    BaseSplashPopView baseSplashPopView = BaseSplashPopView.this;
                    baseSplashPopView.f37723n.postDelayed(baseSplashPopView.f37727r, 1000L);
                    return;
                }
                BaseSplashPopView.this.f37722m = -1;
                BaseSplashPopView.this.g();
                BaseSplashPopView baseSplashPopView2 = BaseSplashPopView.this;
                baseSplashPopView2.f37723n.removeCallbacks(baseSplashPopView2.f37727r);
                BaseSplashPopView baseSplashPopView3 = BaseSplashPopView.this;
                com.mbridge.msdk.splash.middle.d dVar = baseSplashPopView3.f37714e;
                if (dVar != null) {
                    dVar.a(new MBridgeIds(baseSplashPopView3.f37710a, baseSplashPopView3.f37711b), 5);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseSplashPopView baseSplashPopView = BaseSplashPopView.this;
            com.mbridge.msdk.splash.middle.d dVar = baseSplashPopView.f37714e;
            if (dVar != null) {
                dVar.a(new MBridgeIds(baseSplashPopView.f37710a, baseSplashPopView.f37711b), BaseSplashPopView.this.getWidth(), BaseSplashPopView.this.getHeight(), BaseSplashPopView.this.f37712c);
            }
        }
    }

    /* loaded from: classes5.dex */
    class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BaseSplashPopView baseSplashPopView = BaseSplashPopView.this;
            if (baseSplashPopView.f37714e != null) {
                baseSplashPopView.b(baseSplashPopView.f37713d);
            }
        }
    }

    /* loaded from: classes5.dex */
    class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BaseSplashPopView baseSplashPopView;
            com.mbridge.msdk.splash.middle.d dVar;
            if (BaseSplashPopView.this.f37722m <= 0 && (dVar = (baseSplashPopView = BaseSplashPopView.this).f37714e) != null) {
                dVar.a(new MBridgeIds(baseSplashPopView.f37710a, baseSplashPopView.f37711b), 4);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class i {

        /* renamed from: a, reason: collision with root package name */
        private String f37740a;

        /* renamed from: b, reason: collision with root package name */
        private String f37741b;

        /* renamed from: c, reason: collision with root package name */
        private int f37742c;

        /* renamed from: d, reason: collision with root package name */
        private CampaignEx f37743d;

        public i(String str, String str2, int i11, CampaignEx campaignEx) {
            this.f37740a = str;
            this.f37741b = str2;
            this.f37742c = i11;
            this.f37743d = campaignEx;
        }

        public CampaignEx a() {
            return this.f37743d;
        }

        public String b() {
            return this.f37740a;
        }

        public String c() {
            return this.f37741b;
        }

        public int d() {
            return this.f37742c;
        }
    }

    public BaseSplashPopView(Context context) {
        super(context);
        this.f37712c = 1;
        this.f37722m = -1;
        this.f37723n = new Handler();
        this.f37724o = false;
        this.f37726q = new a();
        this.f37727r = new e();
        this.f37728s = new f();
        this.f37729t = new g();
        this.f37730u = new h();
        this.f37712c = 1;
        o0.c("MBSplashPopView", "Please call setPopViewType() to init.");
    }

    public BaseSplashPopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f37712c = 1;
        this.f37722m = -1;
        this.f37723n = new Handler();
        this.f37724o = false;
        this.f37726q = new a();
        this.f37727r = new e();
        this.f37728s = new f();
        this.f37729t = new g();
        this.f37730u = new h();
        this.f37712c = 1;
        o0.c("MBSplashPopView", "Please call setPopViewType() to init.");
    }

    public BaseSplashPopView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f37712c = 1;
        this.f37722m = -1;
        this.f37723n = new Handler();
        this.f37724o = false;
        this.f37726q = new a();
        this.f37727r = new e();
        this.f37728s = new f();
        this.f37729t = new g();
        this.f37730u = new h();
        this.f37712c = 1;
        o0.c("MBSplashPopView", "Please call setPopViewType() to init.");
    }

    public BaseSplashPopView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        this.f37712c = 1;
        this.f37722m = -1;
        this.f37723n = new Handler();
        this.f37724o = false;
        this.f37726q = new a();
        this.f37727r = new e();
        this.f37728s = new f();
        this.f37729t = new g();
        this.f37730u = new h();
        this.f37712c = 1;
        o0.c("MBSplashPopView", "Please call setPopViewType() to init.");
    }

    public BaseSplashPopView(Context context, i iVar, com.mbridge.msdk.splash.middle.d dVar) {
        super(context);
        this.f37712c = 1;
        this.f37722m = -1;
        this.f37723n = new Handler();
        this.f37724o = false;
        this.f37726q = new a();
        this.f37727r = new e();
        this.f37728s = new f();
        this.f37729t = new g();
        this.f37730u = new h();
        if (iVar == null) {
            throw new IllegalArgumentException("Parameters is NULL, can't gen view.");
        }
        this.f37711b = iVar.c();
        this.f37710a = iVar.b();
        this.f37712c = iVar.d();
        this.f37713d = iVar.a();
        this.f37714e = dVar;
        a();
    }

    private void a() {
        if (this.f37713d == null) {
            return;
        }
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        int i11 = this.f37712c;
        if (i11 == 1) {
            c();
            return;
        }
        if (i11 == 2) {
            f();
        } else if (i11 == 3) {
            e();
        } else {
            if (i11 != 4) {
                return;
            }
            d();
        }
    }

    private void a(String str, boolean z10) {
        com.mbridge.msdk.foundation.same.image.b.a(com.mbridge.msdk.foundation.controller.c.m().d()).a(str, new b(z10));
    }

    private void b() {
        String str;
        this.f37718i = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(t0.a(getContext(), 32.0f), t0.a(getContext(), 13.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(8, this.f37715f.getId());
        this.f37718i.setLayoutParams(layoutParams);
        try {
            str = getResources().getConfiguration().locale.getLanguage();
        } catch (Throwable th2) {
            o0.b("MBSplashPopView", th2.getMessage());
            str = "ZH";
        }
        this.f37718i.setBackgroundResource((str.toUpperCase().equals("CN") || str.toUpperCase().equals("ZH")) ? getResources().getIdentifier("mbridge_splash_pop_ad", "drawable", com.mbridge.msdk.foundation.controller.c.m().h()) : getResources().getIdentifier("mbridge_splash_pop_ad_en", "drawable", com.mbridge.msdk.foundation.controller.c.m().h()));
        addView(this.f37718i);
    }

    private void c() {
        View imageView = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(t0.a(getContext(), 80.0f), t0.a(getContext(), 80.0f));
        layoutParams.addRule(9);
        layoutParams.topMargin = t0.a(getContext(), 16.0f);
        imageView.setId(generateViewId());
        imageView.setLayoutParams(layoutParams);
        imageView.setBackgroundResource(getResources().getIdentifier("mbridge_splash_popview_default", "drawable", com.mbridge.msdk.foundation.controller.c.m().h()));
        this.f37715f = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(t0.a(getContext(), 60.0f), t0.a(getContext(), 60.0f));
        layoutParams2.addRule(6, imageView.getId());
        layoutParams2.topMargin = t0.a(getContext(), 7.0f);
        layoutParams2.leftMargin = t0.a(getContext(), 10.0f);
        this.f37715f.setId(generateViewId());
        this.f37715f.setLayoutParams(layoutParams2);
        this.f37715f.setScaleType(ImageView.ScaleType.FIT_CENTER);
        CampaignEx campaignEx = this.f37713d;
        if (campaignEx != null && !TextUtils.isEmpty(campaignEx.getIconUrl())) {
            a(this.f37713d.getIconUrl(), true);
        }
        this.f37721l = new TextView(getContext());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(5, imageView.getId());
        layoutParams3.addRule(8, imageView.getId());
        layoutParams3.leftMargin = t0.a(getContext(), 62.0f);
        layoutParams3.bottomMargin = t0.a(getContext(), 70.0f);
        this.f37721l.setId(generateViewId());
        this.f37721l.setTextSize(10.0f);
        this.f37721l.setTextColor(-1);
        this.f37721l.setGravity(17);
        this.f37721l.setMinWidth(t0.a(getContext(), 16.0f));
        this.f37721l.setMaxHeight(t0.a(getContext(), 16.0f));
        this.f37721l.setLayoutParams(layoutParams3);
        this.f37721l.setBackgroundResource(getResources().getIdentifier("mbridge_cm_circle_50black", "drawable", com.mbridge.msdk.foundation.controller.c.m().h()));
        addView(imageView);
        addView(this.f37721l);
        addView(this.f37715f);
        CampaignEx campaignEx2 = this.f37713d;
        if (campaignEx2 != null && campaignEx2.getFlbSkipTime() <= 0) {
            g();
        }
        setOnClickListener(this.f37729t);
        this.f37721l.setOnClickListener(this.f37730u);
    }

    private void d() {
        this.f37717h = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, t0.a(getContext(), 131.0f));
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        this.f37717h.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f37717h.setId(generateViewId());
        this.f37717h.setLayoutParams(layoutParams);
        setBackgroundImage(this.f37713d.getImageUrl());
        this.f37716g = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, t0.a(getContext(), 131.0f));
        layoutParams2.addRule(10);
        layoutParams2.addRule(14);
        this.f37716g.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.f37716g.setId(generateViewId());
        this.f37716g.setLayoutParams(layoutParams2);
        setForegroundImage(this.f37713d.getImageUrl());
        this.f37715f = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(t0.a(getContext(), 50.0f), t0.a(getContext(), 50.0f));
        layoutParams3.addRule(9);
        layoutParams3.addRule(3, this.f37717h.getId());
        layoutParams3.topMargin = 20;
        this.f37715f.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.f37715f.setId(generateViewId());
        this.f37715f.setLayoutParams(layoutParams3);
        a(this.f37713d.getIconUrl(), false);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams4.addRule(1, this.f37715f.getId());
        layoutParams4.addRule(6, this.f37715f.getId());
        layoutParams4.addRule(8, this.f37715f.getId());
        layoutParams4.leftMargin = t0.a(getContext(), 8.0f);
        layoutParams4.rightMargin = t0.a(getContext(), 8.0f);
        relativeLayout.setLayoutParams(layoutParams4);
        relativeLayout.setGravity(16);
        TextView textView = new TextView(getContext());
        this.f37719j = textView;
        textView.setId(generateViewId());
        this.f37719j.setGravity(16);
        this.f37719j.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        this.f37719j.setTextSize(12.0f);
        this.f37719j.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        TextView textView2 = this.f37719j;
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.MARQUEE;
        textView2.setEllipsize(truncateAt);
        this.f37719j.setMarqueeRepeatLimit(-1);
        this.f37719j.setSelected(true);
        this.f37719j.setSingleLine(true);
        this.f37719j.setText(this.f37713d.getAppName());
        TextView textView3 = new TextView(getContext());
        this.f37720k = textView3;
        textView3.setId(generateViewId());
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(5, this.f37719j.getId());
        layoutParams5.addRule(3, this.f37719j.getId());
        layoutParams5.topMargin = t0.a(getContext(), 4.0f);
        layoutParams5.rightMargin = t0.a(getContext(), 36.0f);
        this.f37720k.setGravity(16);
        this.f37720k.setLayoutParams(layoutParams5);
        this.f37720k.setTextSize(8.0f);
        this.f37720k.setTextColor(-10066330);
        this.f37720k.setEllipsize(truncateAt);
        this.f37720k.setMarqueeRepeatLimit(-1);
        this.f37720k.setSelected(true);
        this.f37720k.setSingleLine(true);
        this.f37720k.setText(this.f37713d.getAppDesc());
        relativeLayout.addView(this.f37719j);
        relativeLayout.addView(this.f37720k);
        addView(this.f37717h);
        addView(this.f37716g);
        addView(this.f37715f);
        addView(relativeLayout);
        b();
        setOnClickListener(this.f37729t);
    }

    private void e() {
        int a11 = t0.a(getContext(), 4.0f);
        this.f37715f = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(t0.a(getContext(), 50.0f), t0.a(getContext(), 50.0f));
        layoutParams.addRule(9);
        this.f37715f.setId(generateViewId());
        this.f37715f.setLayoutParams(layoutParams);
        this.f37715f.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.f37715f.setPadding(a11, a11, a11, a11);
        a(this.f37713d.getIconUrl(), false);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(1, this.f37715f.getId());
        layoutParams2.addRule(6, this.f37715f.getId());
        layoutParams2.addRule(8, this.f37715f.getId());
        layoutParams2.leftMargin = t0.a(getContext(), 8.0f);
        layoutParams2.rightMargin = t0.a(getContext(), 8.0f);
        relativeLayout.setLayoutParams(layoutParams2);
        relativeLayout.setGravity(16);
        TextView textView = new TextView(getContext());
        this.f37719j = textView;
        textView.setId(generateViewId());
        this.f37719j.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        this.f37719j.setGravity(16);
        this.f37719j.setTextSize(12.0f);
        this.f37719j.setSelected(true);
        TextView textView2 = this.f37719j;
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.MARQUEE;
        textView2.setEllipsize(truncateAt);
        this.f37719j.setMarqueeRepeatLimit(-1);
        this.f37719j.setSingleLine(true);
        this.f37719j.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.f37719j.setText(this.f37713d.getAppName());
        TextView textView3 = new TextView(getContext());
        this.f37720k = textView3;
        textView3.setId(generateViewId());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(5, this.f37719j.getId());
        layoutParams3.addRule(3, this.f37719j.getId());
        layoutParams3.topMargin = t0.a(getContext(), 4.0f);
        layoutParams3.rightMargin = t0.a(getContext(), 36.0f);
        this.f37720k.setGravity(16);
        this.f37720k.setLayoutParams(layoutParams3);
        this.f37720k.setTextSize(8.0f);
        this.f37720k.setTextColor(-10066330);
        this.f37720k.setEllipsize(truncateAt);
        this.f37720k.setMarqueeRepeatLimit(-1);
        this.f37720k.setSelected(true);
        this.f37720k.setSingleLine(true);
        this.f37720k.setText(this.f37713d.getAppDesc());
        relativeLayout.addView(this.f37719j);
        relativeLayout.addView(this.f37720k);
        setBackgroundResource(getResources().getIdentifier("mbridge_shape_corners_bg", "drawable", com.mbridge.msdk.foundation.controller.c.m().h()));
        addView(this.f37715f);
        addView(relativeLayout);
        b();
        setOnClickListener(this.f37729t);
    }

    private void f() {
        int a11 = t0.a(getContext(), 4.0f);
        this.f37715f = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(t0.a(getContext(), 28.0f), t0.a(getContext(), 28.0f));
        layoutParams.addRule(9);
        this.f37715f.setId(generateViewId());
        this.f37715f.setLayoutParams(layoutParams);
        this.f37715f.setPadding(a11, a11, a11, a11);
        this.f37715f.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        a(this.f37713d.getIconUrl(), false);
        TextView textView = new TextView(getContext());
        this.f37719j = textView;
        textView.setId(generateViewId());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(1, this.f37715f.getId());
        layoutParams2.addRule(6, this.f37715f.getId());
        layoutParams2.addRule(8, this.f37715f.getId());
        layoutParams2.leftMargin = t0.a(getContext(), 4.0f);
        layoutParams2.rightMargin = t0.a(getContext(), 40.0f);
        this.f37719j.setLayoutParams(layoutParams2);
        this.f37719j.setGravity(16);
        this.f37719j.setTextSize(10.0f);
        this.f37719j.setSelected(true);
        this.f37719j.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.f37719j.setMarqueeRepeatLimit(-1);
        this.f37719j.setSingleLine(true);
        this.f37719j.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.f37719j.setText(this.f37713d.getAppName());
        setBackgroundResource(getResources().getIdentifier("mbridge_shape_corners_bg", "drawable", com.mbridge.msdk.foundation.controller.c.m().h()));
        addView(this.f37715f);
        addView(this.f37719j);
        b();
        setOnClickListener(this.f37729t);
    }

    static /* synthetic */ int g(BaseSplashPopView baseSplashPopView) {
        int i11 = baseSplashPopView.f37722m;
        baseSplashPopView.f37722m = i11 - 1;
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        TextView textView = this.f37721l;
        if (textView != null) {
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            layoutParams.width = t0.a(getContext(), 16.0f);
            layoutParams.height = t0.a(getContext(), 16.0f);
            this.f37721l.setLayoutParams(layoutParams);
            this.f37721l.setText("");
            this.f37721l.setSelected(true);
            this.f37721l.setBackgroundResource(getResources().getIdentifier("mbridge_splash_popview_close", "drawable", com.mbridge.msdk.foundation.controller.c.m().h()));
        }
    }

    public static int generateViewId() {
        AtomicInteger atomicInteger;
        int i11;
        int i12;
        do {
            atomicInteger = f37709v;
            i11 = atomicInteger.get();
            i12 = i11 + 1;
            if (i12 > 16777215) {
                i12 = 1;
            }
        } while (!atomicInteger.compareAndSet(i11, i12));
        return i11;
    }

    private void setBackgroundImage(String str) {
        com.mbridge.msdk.foundation.same.image.b.a(com.mbridge.msdk.foundation.controller.c.m().d()).a(str, new c());
    }

    private void setForegroundImage(String str) {
        com.mbridge.msdk.foundation.same.image.b.a(com.mbridge.msdk.foundation.controller.c.m().d()).a(str, new d());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(CampaignEx campaignEx) {
        if (this.f37725p == null) {
            com.mbridge.msdk.click.a aVar = new com.mbridge.msdk.click.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.f37711b);
            this.f37725p = aVar;
            aVar.a(this.f37726q);
        }
        campaignEx.setCampaignUnitId(this.f37711b);
        this.f37725p.a(campaignEx);
        if (!campaignEx.isReportClick()) {
            campaignEx.setReportClick(true);
            com.mbridge.msdk.splash.report.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), campaignEx);
        }
        com.mbridge.msdk.splash.middle.d dVar = this.f37714e;
        if (dVar != null) {
            dVar.a(new MBridgeIds(this.f37710a, this.f37711b));
            this.f37714e.a(new MBridgeIds(this.f37710a, this.f37711b), 6);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(CampaignEx campaignEx) {
        com.mbridge.msdk.splash.report.a.a(campaignEx, this.f37711b);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f37714e != null) {
            postDelayed(this.f37728s, 500L);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        release();
    }

    public void pauseCountDown() {
        this.f37724o = true;
        if (this.f37721l != null) {
            this.f37723n.removeCallbacks(this.f37727r);
        }
    }

    public void reStartCountDown() {
        if (this.f37724o) {
            this.f37724o = false;
            int i11 = this.f37722m;
            if (i11 == -1 || i11 == 0) {
                g();
                return;
            }
            TextView textView = this.f37721l;
            if (textView != null) {
                textView.setText(String.valueOf(i11));
                this.f37723n.postDelayed(this.f37727r, 1000L);
            }
        }
    }

    public void release() {
        try {
            this.f37723n.removeCallbacks(this.f37728s);
            this.f37723n.removeCallbacks(this.f37727r);
            this.f37727r = null;
            detachAllViewsFromParent();
            this.f37713d = null;
            this.f37714e = null;
        } catch (Exception e11) {
            o0.b("MBSplashPopView", e11.getMessage());
        }
    }

    public void setPopViewType(i iVar, com.mbridge.msdk.splash.middle.d dVar) {
        if (iVar == null) {
            throw new IllegalArgumentException("Parameters is NULL, can't gen view.");
        }
        this.f37711b = iVar.c();
        this.f37710a = iVar.b();
        this.f37712c = iVar.d();
        this.f37713d = iVar.a();
        this.f37714e = dVar;
        a();
    }

    public void startCountDown() {
        this.f37723n.removeCallbacks(this.f37727r);
        CampaignEx campaignEx = this.f37713d;
        if (campaignEx == null || this.f37712c != 1) {
            return;
        }
        int flbSkipTime = campaignEx.getFlbSkipTime();
        if (flbSkipTime <= 0) {
            g();
            return;
        }
        this.f37722m = flbSkipTime;
        TextView textView = this.f37721l;
        if (textView != null) {
            textView.setText(String.valueOf(flbSkipTime));
            this.f37723n.postDelayed(this.f37727r, 1000L);
        }
    }
}
