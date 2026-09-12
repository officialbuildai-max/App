package com.cloud.hisavana.sdk.api.adx;

import a7.c;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.cloud.hisavana.sdk.G;
import com.cloud.hisavana.sdk.api.adx.ViewApi;
import com.cloud.hisavana.sdk.api.listener.g;
import com.cloud.hisavana.sdk.e4;
import com.cloud.hisavana.sdk.i1;
import com.cloud.hisavana.sdk.q3;

/* loaded from: classes3.dex */
public class TSplashView extends ViewApi {

    /* renamed from: m, reason: collision with root package name */
    private RelativeLayout f21663m;

    /* renamed from: n, reason: collision with root package name */
    private View f21664n;

    /* renamed from: o, reason: collision with root package name */
    private g f21665o;

    /* renamed from: p, reason: collision with root package name */
    private Context f21666p;

    /* renamed from: q, reason: collision with root package name */
    private String f21667q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f21668r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f21669s;

    /* renamed from: t, reason: collision with root package name */
    private Float f21670t;

    /* loaded from: classes3.dex */
    private static class a extends ViewApi.a {
        a(TSplashView tSplashView) {
            super(tSplashView);
        }

        @Override // com.cloud.hisavana.sdk.api.listener.AdCallback
        public g f() {
            ViewApi viewApi = this.f21683a;
            if (viewApi instanceof TSplashView) {
                return ((TSplashView) viewApi).f21665o;
            }
            return null;
        }
    }

    public TSplashView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TSplashView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f21668r = false;
        this.f21669s = false;
        this.f21666p = context;
    }

    public TSplashView(Context context, String str) {
        super(context, str);
        this.f21668r = false;
        this.f21669s = false;
        this.f21666p = context;
    }

    private void d() {
        try {
            RelativeLayout relativeLayout = this.f21663m;
            if (relativeLayout != null) {
                removeView(relativeLayout);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.cloud.hisavana.sdk.api.adx.ViewApi
    public void destroy() {
        d();
        super.destroy();
        this.f21664n = null;
        this.f21663m = null;
    }

    public void loadAd() {
        if (this.f21668r) {
            c.s(this.f21666p, this.f21667q, this.f21669s);
        }
        if (b()) {
            i1 i1Var = new i1(new q3.b().i(4).e(this.f21672b).r(this.f21673c).l(this.f21674d).j(this.f21675e).c(this.f21680j).o(this.f21677g).v(this.f21678h).b(this.f21679i).g());
            i1Var.g(new a(this));
            i1Var.E();
        }
    }

    public TSplashView setLiteInit(String str, boolean z10) {
        this.f21668r = true;
        this.f21667q = str;
        this.f21669s = z10;
        return this;
    }

    public void setLogoLayout(View view) {
        this.f21664n = view;
    }

    public void setLogoLayoutHeightRatio(Float f11) {
        this.f21670t = f11;
    }

    public void setSkipListener(g gVar) {
        this.f21665o = gVar;
    }

    public void show() {
        G g11 = this.f21671a;
        if (g11 == null || !(g11 instanceof i1)) {
            return;
        }
        try {
            d();
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            this.f21663m = relativeLayout;
            addView(relativeLayout, -1, -1);
            ((i1) this.f21671a).l0(this.f21663m);
            ((i1) this.f21671a).g0(this.f21670t);
            ((i1) this.f21671a).k0(this.f21664n);
            this.f21681k.add(this.f21671a);
        } catch (Throwable th2) {
            e4.b().w("ssp", "TSplashView show error: " + th2.getMessage());
        }
        ((i1) this.f21671a).j0(this.f21666p);
    }
}
