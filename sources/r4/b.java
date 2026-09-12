package r4;

import com.airbnb.lottie.LottieDrawable;
import q4.o;

/* loaded from: classes2.dex */
public class b implements c {

    /* renamed from: a, reason: collision with root package name */
    private final String f74214a;

    /* renamed from: b, reason: collision with root package name */
    private final o f74215b;

    /* renamed from: c, reason: collision with root package name */
    private final q4.f f74216c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f74217d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f74218e;

    public b(String str, o oVar, q4.f fVar, boolean z10, boolean z11) {
        this.f74214a = str;
        this.f74215b = oVar;
        this.f74216c = fVar;
        this.f74217d = z10;
        this.f74218e = z11;
    }

    @Override // r4.c
    public m4.c a(LottieDrawable lottieDrawable, com.airbnb.lottie.h hVar, com.airbnb.lottie.model.layer.a aVar) {
        return new m4.f(lottieDrawable, aVar, this);
    }

    public String b() {
        return this.f74214a;
    }

    public o c() {
        return this.f74215b;
    }

    public q4.f d() {
        return this.f74216c;
    }

    public boolean e() {
        return this.f74218e;
    }

    public boolean f() {
        return this.f74217d;
    }
}
