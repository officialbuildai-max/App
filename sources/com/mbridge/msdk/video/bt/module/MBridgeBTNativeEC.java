package com.mbridge.msdk.video.bt.module;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.g0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.video.module.listener.impl.j;
import com.mbridge.msdk.video.signal.impl.k;
import com.mbridge.msdk.videocommon.view.RoundImageView;
import com.mbridge.msdk.videocommon.view.StarLevelView;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class MBridgeBTNativeEC extends MBridgeBTNativeECDiff {
    private TextView A;
    private StarLevelView B;
    private boolean C;
    private boolean D;
    private int E;
    private Runnable F;
    private boolean G;
    private View H;
    private String I;
    private k J;
    private WebView K;

    /* renamed from: p, reason: collision with root package name */
    private ViewGroup f38941p;

    /* renamed from: q, reason: collision with root package name */
    private ViewGroup f38942q;

    /* renamed from: r, reason: collision with root package name */
    private RelativeLayout f38943r;

    /* renamed from: s, reason: collision with root package name */
    private ImageView f38944s;

    /* renamed from: t, reason: collision with root package name */
    private RoundImageView f38945t;

    /* renamed from: u, reason: collision with root package name */
    private ImageView f38946u;

    /* renamed from: v, reason: collision with root package name */
    private ImageView f38947v;

    /* renamed from: w, reason: collision with root package name */
    private ImageView f38948w;

    /* renamed from: x, reason: collision with root package name */
    private ImageView f38949x;

    /* renamed from: y, reason: collision with root package name */
    private TextView f38950y;

    /* renamed from: z, reason: collision with root package name */
    private TextView f38951z;

    /* loaded from: classes5.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MBridgeBTNativeEC.this.D = true;
            if (MBridgeBTNativeEC.this.H != null) {
                MBridgeBTNativeEC.this.H.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MBridgeBTNativeEC.this.C) {
                MBridgeBTNativeEC.this.a(1, view.getContext());
                MBridgeBTNativeEC.this.a(view.getX(), view.getY());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MBridgeBTNativeEC.this.K != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", MBridgeBTNativeEC.this.f38868d);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("unitId", MBridgeBTNativeEC.this.I);
                    jSONObject.put("data", jSONObject2);
                    o0.a(BTBaseView.TAG, "NativeEC Call H5 onCloseBtnClicked " + jSONObject.toString());
                } catch (JSONException e11) {
                    o0.a(BTBaseView.TAG, e11.getMessage());
                }
                com.mbridge.msdk.mbsignalcommon.windvane.f.a().a(MBridgeBTNativeEC.this.K, "onCloseBtnClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class d extends com.mbridge.msdk.widget.a {
        d() {
        }

        @Override // com.mbridge.msdk.widget.a
        protected void a(View view) {
            MBridgeBTNativeEC.this.a(0, view.getContext());
            MBridgeBTNativeEC.this.a(view.getX(), view.getY());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class e extends com.mbridge.msdk.widget.a {
        e() {
        }

        @Override // com.mbridge.msdk.widget.a
        protected void a(View view) {
            if (!com.mbridge.msdk.util.b.a()) {
                MBridgeBTNativeEC.this.a(0, view.getContext());
            } else if (MBridgeBTNativeEC.this.checkChinaProgressBarStatus()) {
                MBridgeBTNativeEC.this.a(0, view.getContext());
            }
            MBridgeBTNativeEC.this.a(view.getX(), view.getY());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class f extends com.mbridge.msdk.widget.a {
        f() {
        }

        @Override // com.mbridge.msdk.widget.a
        protected void a(View view) {
            if (!com.mbridge.msdk.util.b.a()) {
                MBridgeBTNativeEC.this.a(0, view.getContext());
            } else if (MBridgeBTNativeEC.this.checkChinaProgressBarStatus()) {
                MBridgeBTNativeEC.this.a(0, view.getContext());
            }
            MBridgeBTNativeEC.this.a(view.getX(), view.getY());
        }
    }

    public MBridgeBTNativeEC(Context context) {
        super(context);
        this.C = false;
        this.D = false;
        this.E = 0;
        this.G = false;
    }

    public MBridgeBTNativeEC(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.C = false;
        this.D = false;
        this.E = 0;
        this.G = false;
    }

    private Bitmap a(Drawable drawable) {
        try {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            drawable.draw(canvas);
            return createBitmap;
        } catch (Throwable th2) {
            o0.a(BTBaseView.TAG, th2.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f11, float f12) {
        if (this.K != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("code", BTBaseView.f38863n);
                jSONObject.put("id", this.f38868d);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("x", String.valueOf(f11));
                jSONObject2.put("y", String.valueOf(f12));
                jSONObject.put("data", jSONObject2);
                com.mbridge.msdk.mbsignalcommon.windvane.f.a().a(this.K, "onClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            } catch (Exception unused) {
                com.mbridge.msdk.video.bt.component.d.c().a(this.K, "onClicked", this.f38868d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001c A[Catch: all -> 0x000f, TryCatch #2 {all -> 0x000f, blocks: (B:2:0x0000, B:4:0x0005, B:5:0x0018, B:7:0x001c, B:9:0x0022, B:10:0x0027, B:12:0x002b, B:13:0x0032, B:21:0x0015), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(int r3, android.content.Context r4) {
        /*
            r2 = this;
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Throwable -> Lf org.json.JSONException -> L13
            r0.<init>()     // Catch: java.lang.Throwable -> Lf org.json.JSONException -> L13
            java.lang.String r1 = com.mbridge.msdk.foundation.same.a.f35392j     // Catch: java.lang.Throwable -> Lf org.json.JSONException -> L11
            org.json.JSONObject r3 = r2.a(r3)     // Catch: java.lang.Throwable -> Lf org.json.JSONException -> L11
            r0.put(r1, r3)     // Catch: java.lang.Throwable -> Lf org.json.JSONException -> L11
            goto L18
        Lf:
            r3 = move-exception
            goto L37
        L11:
            r3 = move-exception
            goto L15
        L13:
            r3 = move-exception
            r0 = 0
        L15:
            r3.printStackTrace()     // Catch: java.lang.Throwable -> Lf
        L18:
            com.mbridge.msdk.video.signal.impl.k r3 = r2.J     // Catch: java.lang.Throwable -> Lf
            if (r3 == 0) goto L40
            boolean r3 = com.mbridge.msdk.util.b.a()     // Catch: java.lang.Throwable -> Lf
            if (r3 == 0) goto L27
            com.mbridge.msdk.video.signal.impl.k r3 = r2.J     // Catch: java.lang.Throwable -> Lf
            r2.doChinaJumpClick(r4, r3)     // Catch: java.lang.Throwable -> Lf
        L27:
            com.mbridge.msdk.video.signal.impl.k r3 = r2.J     // Catch: java.lang.Throwable -> Lf
            if (r0 == 0) goto L30
            java.lang.String r4 = r0.toString()     // Catch: java.lang.Throwable -> Lf
            goto L32
        L30:
            java.lang.String r4 = ""
        L32:
            r0 = 1
            r3.click(r0, r4)     // Catch: java.lang.Throwable -> Lf
            goto L40
        L37:
            java.lang.String r3 = r3.getMessage()
            java.lang.String r4 = "BTBaseView"
            com.mbridge.msdk.foundation.tools.o0.a(r4, r3)
        L40:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.bt.module.MBridgeBTNativeEC.a(int, android.content.Context):void");
    }

    private boolean a(View view) {
        try {
            this.f38943r = (RelativeLayout) view.findViewById(findID("mbridge_native_ec_layout"));
            this.f38944s = (ImageView) view.findViewById(findID("mbridge_iv_adbanner_bg"));
            this.f38945t = (RoundImageView) view.findViewById(findID("mbridge_iv_adbanner"));
            this.f38946u = (ImageView) view.findViewById(findID("mbridge_iv_icon"));
            this.f38947v = (ImageView) view.findViewById(findID("mbridge_iv_flag"));
            this.f38948w = (ImageView) view.findViewById(findID("mbridge_iv_link"));
            this.f38950y = (TextView) view.findViewById(findID("mbridge_tv_apptitle"));
            this.f38951z = (TextView) view.findViewById(findID("mbridge_tv_appdesc"));
            this.A = (TextView) view.findViewById(findID("mbridge_tv_number"));
            this.B = (StarLevelView) view.findViewById(findID("mbridge_sv_starlevel"));
            this.H = view.findViewById(findID("mbridge_iv_close"));
            this.ctaView = view.findViewById(findID("mbridge_tv_cta"));
            this.f38949x = (ImageView) view.findViewById(findID("mbridge_iv_logo"));
            return isNotNULL(this.f38944s, this.f38945t, this.f38946u, this.f38950y, this.f38951z, this.A, this.B, this.H, this.ctaView);
        } catch (Throwable th2) {
            o0.b(BTBaseView.TAG, th2.getMessage(), th2);
            return false;
        }
    }

    private void b(View view) {
        if (view == null) {
            init(this.f38865a);
            preLoadData();
            return;
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        addView(view);
        a(view);
        b();
    }

    private boolean b(int i11) {
        if (isLandscape()) {
            ViewGroup viewGroup = (ViewGroup) this.f38870f.inflate(i11, (ViewGroup) null);
            this.f38942q = viewGroup;
            addView(viewGroup);
            return a(this.f38942q);
        }
        ViewGroup viewGroup2 = (ViewGroup) this.f38870f.inflate(i11, (ViewGroup) null);
        this.f38941p = viewGroup2;
        addView(viewGroup2);
        return a(this.f38941p);
    }

    private int c() {
        return findLayout(isLandscape() ? "mbridge_reward_endcard_native_land" : "mbridge_reward_endcard_native_hor");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mbridge.msdk.video.bt.module.BTBaseView
    public void b() {
        if (this.f38872h) {
            this.f38943r.setOnClickListener(new b());
            this.H.setOnClickListener(new c());
            this.ctaView.setOnClickListener(new d());
            this.f38946u.setOnClickListener(new e());
            this.f38945t.setOnClickListener(new f());
        }
    }

    @TargetApi(17)
    public Bitmap blurBitmap(Bitmap bitmap) {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            RenderScript create = RenderScript.create(this.f38865a.getApplicationContext());
            ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
            Allocation createFromBitmap = Allocation.createFromBitmap(create, bitmap);
            Allocation createFromBitmap2 = Allocation.createFromBitmap(create, createBitmap);
            create2.setRadius(10.0f);
            create2.setInput(createFromBitmap);
            create2.forEach(createFromBitmap2);
            createFromBitmap2.copyTo(createBitmap);
            bitmap.recycle();
            create.destroy();
            return createBitmap;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.mbridge.msdk.video.bt.module.MBridgeBTNativeECDiff, com.mbridge.msdk.video.bt.module.BTBaseView
    public void init(Context context) {
        int c11 = c();
        if (g0.a(c11)) {
            this.f38872h = b(c11);
            b();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.F == null) {
            this.F = new a();
        }
        Runnable runnable = this.F;
        if (runnable != null) {
            postDelayed(runnable, this.E * 1000);
        }
        if (!this.f38872h && this.K != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", this.f38868d);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("unitId", this.I);
                jSONObject.put("data", jSONObject2);
                o0.a(BTBaseView.TAG, "NativeEC Call H5 onCloseBtnClicked " + jSONObject.toString());
            } catch (JSONException e11) {
                o0.a(BTBaseView.TAG, e11.getMessage());
            }
            com.mbridge.msdk.mbsignalcommon.windvane.f.a().a(this.K, "onCloseBtnClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        }
        if (this.K != null) {
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("id", this.f38868d);
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("unitId", this.I);
                jSONObject3.put("data", jSONObject4);
                o0.a(BTBaseView.TAG, "NativeEC Call H5 onEndCardShow " + jSONObject3.toString());
            } catch (JSONException e12) {
                o0.a(BTBaseView.TAG, e12.getMessage());
            }
            com.mbridge.msdk.mbsignalcommon.windvane.f.a().a(this.K, "onNativeECShow", Base64.encodeToString(jSONObject3.toString().getBytes(), 2));
        }
    }

    @Override // com.mbridge.msdk.video.bt.module.MBridgeBTNativeECDiff, com.mbridge.msdk.video.bt.module.BTBaseView
    public void onDestory() {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.F;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    @Override // com.mbridge.msdk.video.bt.module.BTBaseView
    public void onSelfConfigurationChanged(Configuration configuration) {
        super.onSelfConfigurationChanged(configuration);
        int i11 = configuration.orientation;
        this.f38871g = i11;
        if (i11 == 2) {
            removeView(this.f38941p);
            b(this.f38942q);
        } else {
            removeView(this.f38942q);
            b(this.f38941p);
        }
    }

    public void preLoadData() {
        Bitmap blurBitmap;
        try {
            CampaignEx campaignEx = this.f38866b;
            if (campaignEx == null || !this.f38872h) {
                return;
            }
            if (campaignEx.getCbd() > -2) {
                this.E = this.f38866b.getCbd();
            } else {
                com.mbridge.msdk.videocommon.setting.c cVar = this.f38869e;
                if (cVar != null) {
                    this.E = cVar.i();
                }
            }
            com.mbridge.msdk.foundation.same.image.b.a(this.f38865a.getApplicationContext()).a(this.f38866b.getImageUrl(), new com.mbridge.msdk.video.module.listener.impl.e(this.f38945t, this.f38866b, this.I));
            com.mbridge.msdk.foundation.same.image.b.a(this.f38865a.getApplicationContext()).a(this.f38866b.getIconUrl(), new j(this.f38946u, t0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 8.0f)));
            this.f38950y.setText(this.f38866b.getAppName());
            this.f38951z.setText(this.f38866b.getAppDesc());
            this.A.setText(this.f38866b.getNumberRating() + ")");
            this.B.removeAllViews();
            if (com.mbridge.msdk.util.b.a()) {
                setChinaCTAData(this.f38866b);
            }
            double rating = this.f38866b.getRating();
            if (rating <= 0.0d) {
                rating = 5.0d;
            }
            this.B.initScore(rating);
            try {
                Bitmap a11 = a(this.f38945t.getDrawable());
                if (a11 != null && (blurBitmap = blurBitmap(a11)) != null) {
                    this.f38944s.setImageBitmap(blurBitmap);
                }
            } catch (Throwable unused) {
                this.f38944s.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.f38866b.getendcard_url()) && this.f38866b.getendcard_url().contains("alecfc=1")) {
                this.C = true;
            }
            if (!TextUtils.isEmpty(this.f38866b.getendcard_url()) && this.f38866b.getendcard_url().contains("wlgo=1")) {
                this.G = true;
            }
            String language = Locale.getDefault().getLanguage();
            if (TextUtils.isEmpty(language) || !language.equals("zh")) {
                this.f38947v.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("mbridge_reward_flag_en", "drawable", com.mbridge.msdk.foundation.controller.c.m().h())));
            } else {
                this.f38947v.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("mbridge_reward_flag_cn", "drawable", com.mbridge.msdk.foundation.controller.c.m().h())));
            }
            if (!this.G) {
                this.f38947v.setVisibility(4);
                this.f38949x.setVisibility(4);
            }
            t0.a(2, this.f38948w, this.f38866b, this.f38865a, true, null);
            if (this.D) {
                return;
            }
            this.H.setVisibility(8);
        } catch (Throwable th2) {
            o0.a(BTBaseView.TAG, th2.getMessage());
        }
    }

    public void setCreateWebView(WebView webView) {
        this.K = webView;
    }

    public void setJSCommon(k kVar) {
        this.J = kVar;
    }

    @Override // com.mbridge.msdk.video.bt.module.BTBaseView
    public void setUnitId(String str) {
        this.I = str;
    }
}
