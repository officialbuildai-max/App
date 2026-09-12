package com.mbridge.msdk.mbbid.out;

import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.k0;

/* loaded from: classes5.dex */
public class SplashBidRequestParams extends BannerBidRequestParams {

    /* renamed from: g, reason: collision with root package name */
    private static int f36281g = 1;

    /* renamed from: h, reason: collision with root package name */
    private static int f36282h;

    /* renamed from: i, reason: collision with root package name */
    private static int f36283i;

    /* renamed from: f, reason: collision with root package name */
    private boolean f36284f;

    public SplashBidRequestParams(String str, String str2) {
        this(str, str2, "");
    }

    public SplashBidRequestParams(String str, String str2, String str3) {
        this(str, str2, str3, false, f36281g, f36283i, f36282h);
    }

    public SplashBidRequestParams(String str, String str2, String str3, boolean z10, int i11, int i12, int i13) {
        super(str, str2, str3, 0, 0);
        this.f36284f = false;
        f36281g = i11;
        a(i12, i13);
        this.f36284f = z10;
    }

    public SplashBidRequestParams(String str, String str2, boolean z10, int i11, int i12, int i13) {
        this(str, str2, "", z10, i11, i13, i12);
    }

    private void a(int i11, int i12) {
        int n11 = k0.n(c.m().d());
        int m11 = k0.m(c.m().d());
        int i13 = f36281g;
        if (i13 == 1) {
            if (m11 > i12 * 4) {
                setHeight(m11 - i12);
                setWidth(n11);
                return;
            } else {
                setHeight(0);
                setWidth(0);
                return;
            }
        }
        if (i13 == 2) {
            if (n11 > i11 * 4) {
                setWidth(n11 - i11);
                setHeight(m11);
            } else {
                setHeight(0);
                setWidth(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a() {
        return this.f36284f;
    }

    public int getOrientation() {
        return f36281g;
    }
}
