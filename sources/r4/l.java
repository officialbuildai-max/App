package r4;

import com.airbnb.lottie.LottieDrawable;
import m4.r;

/* loaded from: classes2.dex */
public class l implements c {

    /* renamed from: a, reason: collision with root package name */
    private final String f74255a;

    /* renamed from: b, reason: collision with root package name */
    private final int f74256b;

    /* renamed from: c, reason: collision with root package name */
    private final q4.h f74257c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f74258d;

    public l(String str, int i11, q4.h hVar, boolean z10) {
        this.f74255a = str;
        this.f74256b = i11;
        this.f74257c = hVar;
        this.f74258d = z10;
    }

    @Override // r4.c
    public m4.c a(LottieDrawable lottieDrawable, com.airbnb.lottie.h hVar, com.airbnb.lottie.model.layer.a aVar) {
        return new r(lottieDrawable, aVar, this);
    }

    public String b() {
        return this.f74255a;
    }

    public q4.h c() {
        return this.f74257c;
    }

    public boolean d() {
        return this.f74258d;
    }

    public String toString() {
        return "ShapePath{name=" + this.f74255a + ", index=" + this.f74256b + '}';
    }
}
