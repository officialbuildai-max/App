package com.pgl.ssdk;

import android.content.Context;

/* loaded from: classes5.dex */
public class l0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private Context f40233a;

    /* renamed from: b, reason: collision with root package name */
    private int f40234b;

    /* renamed from: c, reason: collision with root package name */
    private Object[] f40235c;

    public l0(Context context, int i11, Object[] objArr) {
        this.f40233a = context;
        this.f40234b = i11;
        this.f40235c = objArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.f40234b == 222) {
                h0.a(this.f40233a).a();
            }
            byte[] bArr = (byte[]) com.pgl.ssdk.ces.a.meta(this.f40234b, this.f40233a, this.f40235c);
            if (bArr == null || bArr.length <= 0) {
                return;
            }
            new m0(this.f40233a, this.f40234b).a(1, 2, bArr);
        } catch (Throwable unused) {
        }
    }
}
