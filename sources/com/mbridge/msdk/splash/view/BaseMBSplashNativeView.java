package com.mbridge.msdk.splash.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.g0;
import com.mbridge.msdk.foundation.tools.n0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.shake.MBShakeView;
import com.mbridge.msdk.splash.view.nativeview.MBNoRecycledCrashImageView;
import com.mbridge.msdk.splash.view.nativeview.MBSplashClickView;
import com.mbridge.msdk.widget.FeedBackButton;

/* loaded from: classes5.dex */
public class BaseMBSplashNativeView extends RelativeLayout {
    private int A;
    private int B;
    private int C;
    private float D;
    private float E;
    private boolean F;
    private boolean G;
    protected boolean H;
    protected boolean I;
    protected boolean J;
    protected String K;
    private String L;
    protected MBSplashView M;
    protected CampaignEx N;
    protected MBShakeView O;
    private String P;
    private String Q;
    private String R;
    protected com.mbridge.msdk.shake.b S;

    /* renamed from: a, reason: collision with root package name */
    private MBNoRecycledCrashImageView f37676a;

    /* renamed from: b, reason: collision with root package name */
    private MBNoRecycledCrashImageView f37677b;

    /* renamed from: c, reason: collision with root package name */
    private RelativeLayout f37678c;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f37679d;

    /* renamed from: e, reason: collision with root package name */
    private FeedBackButton f37680e;

    /* renamed from: f, reason: collision with root package name */
    protected TextView f37681f;

    /* renamed from: g, reason: collision with root package name */
    private RelativeLayout f37682g;

    /* renamed from: h, reason: collision with root package name */
    private MBNoRecycledCrashImageView f37683h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f37684i;

    /* renamed from: j, reason: collision with root package name */
    private MBNoRecycledCrashImageView f37685j;

    /* renamed from: k, reason: collision with root package name */
    private TextView f37686k;

    /* renamed from: l, reason: collision with root package name */
    private TextView f37687l;

    /* renamed from: m, reason: collision with root package name */
    protected RelativeLayout f37688m;

    /* renamed from: n, reason: collision with root package name */
    protected TextView f37689n;

    /* renamed from: o, reason: collision with root package name */
    protected TextView f37690o;

    /* renamed from: p, reason: collision with root package name */
    protected TextView f37691p;

    /* renamed from: q, reason: collision with root package name */
    protected TextView f37692q;

    /* renamed from: r, reason: collision with root package name */
    protected MBSplashClickView f37693r;

    /* renamed from: s, reason: collision with root package name */
    protected int f37694s;

    /* renamed from: t, reason: collision with root package name */
    private int f37695t;

    /* renamed from: u, reason: collision with root package name */
    private int f37696u;

    /* renamed from: v, reason: collision with root package name */
    private int f37697v;

    /* renamed from: w, reason: collision with root package name */
    protected int f37698w;

    /* renamed from: x, reason: collision with root package name */
    protected int f37699x;

    /* renamed from: y, reason: collision with root package name */
    protected int f37700y;

    /* renamed from: z, reason: collision with root package name */
    protected int f37701z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements com.mbridge.msdk.foundation.same.image.c {
        a() {
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onFailedLoad(String str, String str2) {
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onSuccessLoad(Bitmap bitmap, String str) {
            if (bitmap != null) {
                try {
                    if (bitmap.isRecycled()) {
                        return;
                    }
                    if (bitmap.getWidth() < bitmap.getHeight()) {
                        BaseMBSplashNativeView.this.G = true;
                        BaseMBSplashNativeView.this.f37682g.setVisibility(4);
                        BaseMBSplashNativeView.this.f37677b.setScaleType(ImageView.ScaleType.FIT_CENTER);
                        BaseMBSplashNativeView.this.f37677b.setImageBitmap(bitmap);
                    } else if (BaseMBSplashNativeView.this.A == 1) {
                        BaseMBSplashNativeView.this.f37682g.setVisibility(0);
                        try {
                            Bitmap a11 = n0.a(bitmap, 1, t0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 10.0f));
                            if (a11 != null && !a11.isRecycled()) {
                                BaseMBSplashNativeView.this.f37685j.setScaleType(ImageView.ScaleType.FIT_XY);
                                BaseMBSplashNativeView.this.f37685j.setImageBitmap(a11);
                            }
                        } catch (Throwable th2) {
                            try {
                                o0.b("MBSplashNativeView", th2.getMessage());
                                BaseMBSplashNativeView.this.f37685j.setImageBitmap(bitmap);
                            } catch (Throwable th3) {
                                o0.b("MBSplashNativeView", th3.getMessage());
                            }
                        }
                        BaseMBSplashNativeView.this.f37684i.setText(BaseMBSplashNativeView.this.N.getAppName());
                        BaseMBSplashNativeView.this.f();
                        try {
                            try {
                                Bitmap a12 = n0.a(bitmap);
                                if (a12 != null && !a12.isRecycled()) {
                                    BaseMBSplashNativeView.this.f37677b.setScaleType(ImageView.ScaleType.CENTER_CROP);
                                    BaseMBSplashNativeView.this.f37677b.setImageBitmap(a12);
                                }
                            } catch (Throwable th4) {
                                o0.b("MBSplashNativeView", th4.getMessage());
                            }
                        } catch (Throwable unused) {
                            BaseMBSplashNativeView.this.f37677b.setImageBitmap(bitmap);
                        }
                    } else {
                        BaseMBSplashNativeView.this.f37682g.setVisibility(4);
                        BaseMBSplashNativeView.this.f37677b.setScaleType(ImageView.ScaleType.FIT_CENTER);
                        BaseMBSplashNativeView.this.f37677b.setImageBitmap(bitmap);
                    }
                    try {
                        Bitmap a13 = n0.a(bitmap);
                        if (a13 == null || a13.isRecycled()) {
                            return;
                        }
                        BaseMBSplashNativeView.this.f37676a.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        BaseMBSplashNativeView.this.f37676a.setImageBitmap(a13);
                    } catch (Throwable unused2) {
                        BaseMBSplashNativeView.this.f37677b.setImageBitmap(bitmap);
                    }
                } catch (Throwable th5) {
                    o0.b("MBSplashNativeView", th5.getMessage());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements com.mbridge.msdk.foundation.same.image.c {
        b() {
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onFailedLoad(String str, String str2) {
            BaseMBSplashNativeView.this.f37683h.setVisibility(4);
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onSuccessLoad(Bitmap bitmap, String str) {
            Bitmap a11;
            if (bitmap != null) {
                try {
                    if (bitmap.isRecycled()) {
                        return;
                    }
                    try {
                        if (BaseMBSplashNativeView.this.f37683h == null || (a11 = n0.a(bitmap, 1, t0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 40.0f))) == null || a11.isRecycled()) {
                            return;
                        }
                        BaseMBSplashNativeView.this.f37683h.setImageBitmap(a11);
                    } catch (Throwable th2) {
                        o0.b("MBSplashNativeView", th2.getMessage());
                        BaseMBSplashNativeView.this.f37683h.setImageBitmap(bitmap);
                    }
                } catch (Throwable th3) {
                    o0.b("MBSplashNativeView", th3.getMessage());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c implements com.mbridge.msdk.foundation.feedback.a {
        c() {
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a() {
            BaseMBSplashNativeView baseMBSplashNativeView = BaseMBSplashNativeView.this;
            baseMBSplashNativeView.J = true;
            baseMBSplashNativeView.setCountDownStatus(false);
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a(String str) {
            BaseMBSplashNativeView baseMBSplashNativeView = BaseMBSplashNativeView.this;
            baseMBSplashNativeView.J = false;
            baseMBSplashNativeView.setCountDownStatus(true);
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void close() {
            BaseMBSplashNativeView baseMBSplashNativeView = BaseMBSplashNativeView.this;
            baseMBSplashNativeView.J = false;
            baseMBSplashNativeView.setCountDownStatus(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BaseMBSplashNativeView.this.a(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BaseMBSplashNativeView.this.a(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BaseMBSplashNativeView baseMBSplashNativeView = BaseMBSplashNativeView.this;
            if (baseMBSplashNativeView.H) {
                if (baseMBSplashNativeView.M.getSplashSignalCommunicationImpl() != null && BaseMBSplashNativeView.this.M.getSplashSignalCommunicationImpl().a() != null) {
                    BaseMBSplashNativeView.this.M.getSplashSignalCommunicationImpl().a().close();
                }
                BaseMBSplashNativeView.this.f37681f.setVisibility(4);
                BaseMBSplashNativeView.this.f37681f.setEnabled(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class g implements com.mbridge.msdk.foundation.feedback.a {
        g() {
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a() {
            BaseMBSplashNativeView baseMBSplashNativeView = BaseMBSplashNativeView.this;
            baseMBSplashNativeView.J = true;
            baseMBSplashNativeView.setCountDownStatus(false);
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a(String str) {
            BaseMBSplashNativeView baseMBSplashNativeView = BaseMBSplashNativeView.this;
            baseMBSplashNativeView.J = false;
            baseMBSplashNativeView.setCountDownStatus(true);
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void close() {
            BaseMBSplashNativeView baseMBSplashNativeView = BaseMBSplashNativeView.this;
            baseMBSplashNativeView.J = false;
            baseMBSplashNativeView.setCountDownStatus(true);
        }
    }

    public BaseMBSplashNativeView(Context context) {
        super(context);
        this.I = false;
        this.J = false;
    }

    public BaseMBSplashNativeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseMBSplashNativeView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.I = false;
        this.J = false;
    }

    public BaseMBSplashNativeView(Context context, MBSplashView mBSplashView, com.mbridge.msdk.splash.common.c cVar) {
        super(context);
        this.I = false;
        this.J = false;
        if (cVar == null) {
            throw new IllegalArgumentException("Parameters is NULL, can't gen view.");
        }
        this.K = cVar.l();
        this.L = cVar.h();
        this.N = cVar.b();
        this.M = mBSplashView;
        this.f37694s = cVar.d();
        this.f37697v = cVar.c();
        this.f37696u = cVar.f();
        this.f37698w = cVar.a();
        this.f37699x = cVar.i();
        this.f37700y = cVar.j();
        this.f37701z = cVar.k();
        this.A = cVar.g();
        this.H = cVar.m();
        this.B = cVar.e();
        d();
        c();
    }

    private void a() {
        CampaignEx campaignEx = this.N;
        if (campaignEx != null) {
            campaignEx.setCampaignUnitId(this.K);
            com.mbridge.msdk.foundation.feedback.b.b().a(this.K, 3);
            com.mbridge.msdk.foundation.feedback.b.b().a(this.K, this.N);
        }
        if (com.mbridge.msdk.foundation.feedback.b.b().a()) {
            com.mbridge.msdk.foundation.feedback.b.b().a(this.K, new g());
            com.mbridge.msdk.foundation.feedback.b.b().a(this.K, this.f37680e);
            com.mbridge.msdk.foundation.feedback.b.b().a(this.K, 3);
            com.mbridge.msdk.foundation.feedback.b.b().a(this.K, this.N);
            return;
        }
        FeedBackButton feedBackButton = this.f37680e;
        if (feedBackButton != null) {
            feedBackButton.setVisibility(8);
        }
    }

    private void c() {
        try {
            this.F = getContext().getResources().getConfiguration().locale.getLanguage().contains("zh");
        } catch (Throwable th2) {
            o0.b("MBSplashNativeView", th2.getMessage());
        }
        a();
        g();
        h();
        e();
        i();
        j();
        b();
        updateCountDown(this.f37694s);
    }

    private void d() {
        try {
            View inflate = LayoutInflater.from(getContext()).inflate(this.A == 1 ? g0.a(getContext().getApplicationContext(), "mbridge_splash_portrait", TtmlNode.TAG_LAYOUT) : g0.a(getContext().getApplicationContext(), "mbridge_splash_landscape", TtmlNode.TAG_LAYOUT), (ViewGroup) null);
            addView(inflate);
            this.f37676a = (MBNoRecycledCrashImageView) inflate.findViewById(g0.a(getContext().getApplicationContext(), "mbridge_splash_iv_image_bg", "id"));
            this.f37677b = (MBNoRecycledCrashImageView) inflate.findViewById(g0.a(getContext().getApplicationContext(), "mbridge_splash_iv_image", "id"));
            this.f37678c = (RelativeLayout) inflate.findViewById(g0.a(getContext().getApplicationContext(), "mbridge_splash_topcontroller", "id"));
            this.f37679d = (ImageView) inflate.findViewById(g0.a(getContext().getApplicationContext(), "mbridge_splash_iv_link", "id"));
            this.f37680e = (FeedBackButton) inflate.findViewById(g0.a(getContext().getApplicationContext(), "mbridge_splash_feedback", "id"));
            this.f37681f = (TextView) inflate.findViewById(g0.a(getContext().getApplicationContext(), "mbridge_splash_tv_skip", "id"));
            this.f37682g = (RelativeLayout) inflate.findViewById(g0.a(getContext().getApplicationContext(), "mbridge_splash_landscape_foreground", "id"));
            this.f37683h = (MBNoRecycledCrashImageView) inflate.findViewById(g0.a(getContext().getApplicationContext(), "mbridge_splash_iv_icon", "id"));
            this.f37684i = (TextView) inflate.findViewById(g0.a(getContext().getApplicationContext(), "mbridge_splash_tv_title", "id"));
            this.f37685j = (MBNoRecycledCrashImageView) inflate.findViewById(g0.a(getContext().getApplicationContext(), "mbridge_splash_iv_foregroundimage", "id"));
            this.f37686k = (TextView) inflate.findViewById(g0.a(getContext().getApplicationContext(), "mbridge_splash_tv_adrect", "id"));
            this.f37688m = (RelativeLayout) inflate.findViewById(g0.a(getContext().getApplicationContext(), "mbridge_splash_layout_appinfo", "id"));
            this.f37689n = (TextView) inflate.findViewById(g0.a(getContext().getApplicationContext(), "mbridge_splash_tv_appinfo", "id"));
            this.f37690o = (TextView) inflate.findViewById(g0.a(getContext().getApplicationContext(), "mbridge_splash_tv_privacy", "id"));
            this.f37691p = (TextView) inflate.findViewById(g0.a(getContext().getApplicationContext(), "mbridge_splash_tv_permission", "id"));
            this.f37692q = (TextView) inflate.findViewById(g0.a(getContext().getApplicationContext(), "mbridge_splash_tv_app_desc", "id"));
            this.f37693r = (MBSplashClickView) inflate.findViewById(g0.a(getContext().getApplicationContext(), "mbridge_splash_tv_click", "id"));
            this.f37687l = (TextView) inflate.findViewById(g0.a(getContext().getApplicationContext(), "mbridge_splash_tv_adcircle", "id"));
            int a11 = g0.a(getContext().getApplicationContext(), "mbridge_splash_count_time_can_skip", "string");
            int a12 = g0.a(getContext().getApplicationContext(), "mbridge_splash_count_time_can_skip_not", "string");
            int a13 = g0.a(getContext().getApplicationContext(), "mbridge_splash_count_time_can_skip_s", "string");
            this.Q = getContext().getResources().getString(a11);
            this.R = getContext().getResources().getString(a12);
            this.P = getContext().getResources().getString(a13);
            this.C = t0.a(getContext(), 9.0f);
        } catch (Throwable th2) {
            o0.b("MBSplashNativeView", th2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (TextUtils.isEmpty(this.N.getIconUrl())) {
            this.f37683h.setVisibility(4);
        } else {
            com.mbridge.msdk.foundation.same.image.b.a(com.mbridge.msdk.foundation.controller.c.m().d()).a(this.N.getIconUrl(), new b());
        }
    }

    private void g() {
        if (TextUtils.isEmpty(this.N.getImageUrl())) {
            this.f37677b.setVisibility(4);
        } else {
            com.mbridge.msdk.foundation.same.image.b.a(com.mbridge.msdk.foundation.controller.c.m().d()).a(this.N.getImageUrl(), new a());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void h() {
        /*
            r7 = this;
            android.widget.ImageView r1 = r7.f37679d
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = r7.N
            android.content.Context r3 = r7.getContext()
            com.mbridge.msdk.splash.view.BaseMBSplashNativeView$c r5 = new com.mbridge.msdk.splash.view.BaseMBSplashNativeView$c
            r5.<init>()
            r0 = 3
            r4 = 1
            com.mbridge.msdk.foundation.tools.t0.a(r0, r1, r2, r3, r4, r5)
            android.content.Context r0 = r7.getContext()
            android.content.Context r0 = r0.getApplicationContext()
            java.lang.String r1 = "mbridge_splash_m_circle"
            java.lang.String r2 = "drawable"
            int r0 = com.mbridge.msdk.foundation.tools.g0.a(r0, r1, r2)
            r1 = 0
            android.content.res.Resources r2 = r7.getResources()     // Catch: java.lang.Throwable -> L44
            android.graphics.drawable.Drawable r0 = r2.getDrawable(r0)     // Catch: java.lang.Throwable -> L44
            android.content.Context r2 = r7.getContext()     // Catch: java.lang.Throwable -> L42
            r3 = 1092616192(0x41200000, float:10.0)
            int r2 = com.mbridge.msdk.foundation.tools.t0.a(r2, r3)     // Catch: java.lang.Throwable -> L42
            android.content.Context r4 = r7.getContext()     // Catch: java.lang.Throwable -> L42
            int r3 = com.mbridge.msdk.foundation.tools.t0.a(r4, r3)     // Catch: java.lang.Throwable -> L42
            r4 = 0
            r0.setBounds(r4, r4, r2, r3)     // Catch: java.lang.Throwable -> L42
            goto L4f
        L42:
            r2 = move-exception
            goto L46
        L44:
            r2 = move-exception
            r0 = r1
        L46:
            java.lang.String r2 = r2.getMessage()
            java.lang.String r3 = "MBSplashNativeView"
            com.mbridge.msdk.foundation.tools.o0.b(r3, r2)
        L4f:
            int r2 = r7.A
            r3 = 1
            r4 = 4
            java.lang.String r5 = "AD"
            java.lang.String r6 = "广告"
            if (r2 != r3) goto L78
            boolean r2 = r7.G
            if (r2 == 0) goto L78
            int r2 = r7.B
            if (r2 == 0) goto L68
            if (r0 == 0) goto L68
            android.widget.TextView r2 = r7.f37687l
            r2.setCompoundDrawables(r0, r1, r1, r1)
        L68:
            android.widget.TextView r0 = r7.f37687l
            boolean r1 = r7.F
            if (r1 == 0) goto L6f
            r5 = r6
        L6f:
            r0.setText(r5)
            android.widget.TextView r0 = r7.f37686k
            r0.setVisibility(r4)
            goto L92
        L78:
            int r2 = r7.B
            if (r2 == 0) goto L83
            if (r0 == 0) goto L83
            android.widget.TextView r2 = r7.f37686k
            r2.setCompoundDrawables(r0, r1, r1, r1)
        L83:
            android.widget.TextView r0 = r7.f37686k
            boolean r1 = r7.F
            if (r1 == 0) goto L8a
            r5 = r6
        L8a:
            r0.setText(r5)
            android.widget.TextView r0 = r7.f37687l
            r0.setVisibility(r4)
        L92:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.splash.view.BaseMBSplashNativeView.h():void");
    }

    private void i() {
        if (this.f37697v == 1) {
            this.f37693r.setVisibility(8);
        } else if (this.f37699x == 1) {
            this.f37693r.setVisibility(8);
        } else {
            this.f37693r.initView(this.N.getAdCall());
        }
    }

    private void j() {
        if (this.f37696u == 1) {
            setOnClickListener(new d());
        } else {
            this.f37693r.setOnClickListener(new e());
        }
        this.f37681f.setOnClickListener(new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCountDownStatus(boolean z10) {
        if (this.M.getSplashSignalCommunicationImpl() == null || this.M.getSplashSignalCommunicationImpl().a() == null) {
            return;
        }
        this.M.getSplashSignalCommunicationImpl().a().a(z10 ? 2 : 1, this.f37695t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i11) {
        if (this.M.getSplashSignalCommunicationImpl() == null || this.M.getSplashSignalCommunicationImpl().a() == null) {
            return;
        }
        try {
            this.M.getSplashSignalCommunicationImpl().a().a(com.mbridge.msdk.splash.common.util.a.a(com.mbridge.msdk.splash.common.util.a.a(i11, this.D, this.E), this.N));
        } catch (Throwable th2) {
            o0.b("MBSplashNativeView", th2.getMessage());
            this.M.getSplashSignalCommunicationImpl().a().a(this.N);
        }
    }

    protected void b() {
    }

    protected void e() {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        try {
            if (this.f37699x != 1 || this.O == null || this.S == null) {
                return;
            }
            com.mbridge.msdk.shake.a.a().a(this.S);
        } catch (Throwable th2) {
            o0.b("MBSplashNativeView", th2.getMessage());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        release();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.D = motionEvent.getRawX();
        this.E = motionEvent.getRawY();
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void release() {
        try {
            if (this.S != null) {
                com.mbridge.msdk.shake.a.a().b(this.S);
                this.S = null;
            }
            com.mbridge.msdk.foundation.feedback.b.b().d(this.K);
            detachAllViewsFromParent();
        } catch (Exception e11) {
            o0.b("MBSplashNativeView", e11.getMessage());
        }
    }

    public void setIsPause(boolean z10) {
        this.I = z10;
    }

    public void setNotchPadding(int i11, int i12, int i13, int i14) {
        try {
            RelativeLayout relativeLayout = this.f37678c;
            if (relativeLayout == null) {
                return;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
            int i15 = this.C;
            layoutParams.leftMargin = i11 + i15;
            layoutParams.rightMargin = i12 + i15;
            layoutParams.topMargin = i13 + i15;
            layoutParams.bottomMargin = i15 + i14;
        } catch (Throwable th2) {
            o0.b("MBSplashNativeView", th2.getMessage());
        }
    }

    public void updateCountDown(int i11) {
        String str;
        if (this.f37681f != null) {
            this.f37695t = i11;
            if (this.H) {
                str = this.Q + " " + i11 + this.P;
            } else {
                str = i11 + this.P + " " + this.R;
            }
            this.f37681f.setText(str);
        }
    }
}
