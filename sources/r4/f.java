package r4;

import com.airbnb.lottie.LottieDrawable;
import q4.o;

/* loaded from: classes2.dex */
public class f implements c {

    /* renamed from: a, reason: collision with root package name */
    private final String f74231a;

    /* renamed from: b, reason: collision with root package name */
    private final o f74232b;

    /* renamed from: c, reason: collision with root package name */
    private final o f74233c;

    /* renamed from: d, reason: collision with root package name */
    private final q4.b f74234d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f74235e;

    public f(String str, o oVar, o oVar2, q4.b bVar, boolean z10) {
        this.f74231a = str;
        this.f74232b = oVar;
        this.f74233c = oVar2;
        this.f74234d = bVar;
        this.f74235e = z10;
    }

    @Override // r4.c
    public m4.c a(LottieDrawable lottieDrawable, com.airbnb.lottie.h hVar, com.airbnb.lottie.model.layer.a aVar) {
        return new m4.o(lottieDrawable, aVar, this);
    }

    public q4.b b() {
        return this.f74234d;
    }

    public String c() {
        return this.f74231a;
    }

    public o d() {
        return this.f74232b;
    }

    public o e() {
        return this.f74233c;
    }

    public boolean f() {
        return this.f74235e;
    }

    public String toString() {
        return "RectangleShape{position=" + this.f74232b + ", size=" + this.f74233c + '}';
    }
}
