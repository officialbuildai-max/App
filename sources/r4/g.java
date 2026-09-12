package r4;

import com.airbnb.lottie.LottieDrawable;
import m4.p;
import q4.n;

/* loaded from: classes2.dex */
public class g implements c {

    /* renamed from: a, reason: collision with root package name */
    private final String f74236a;

    /* renamed from: b, reason: collision with root package name */
    private final q4.b f74237b;

    /* renamed from: c, reason: collision with root package name */
    private final q4.b f74238c;

    /* renamed from: d, reason: collision with root package name */
    private final n f74239d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f74240e;

    public g(String str, q4.b bVar, q4.b bVar2, n nVar, boolean z10) {
        this.f74236a = str;
        this.f74237b = bVar;
        this.f74238c = bVar2;
        this.f74239d = nVar;
        this.f74240e = z10;
    }

    @Override // r4.c
    public m4.c a(LottieDrawable lottieDrawable, com.airbnb.lottie.h hVar, com.airbnb.lottie.model.layer.a aVar) {
        return new p(lottieDrawable, aVar, this);
    }

    public q4.b b() {
        return this.f74237b;
    }

    public String c() {
        return this.f74236a;
    }

    public q4.b d() {
        return this.f74238c;
    }

    public n e() {
        return this.f74239d;
    }

    public boolean f() {
        return this.f74240e;
    }
}
