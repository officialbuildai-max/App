package q4;

import com.airbnb.lottie.LottieDrawable;

/* loaded from: classes2.dex */
public class n implements r4.c {

    /* renamed from: a, reason: collision with root package name */
    private final e f73224a;

    /* renamed from: b, reason: collision with root package name */
    private final o f73225b;

    /* renamed from: c, reason: collision with root package name */
    private final g f73226c;

    /* renamed from: d, reason: collision with root package name */
    private final b f73227d;

    /* renamed from: e, reason: collision with root package name */
    private final d f73228e;

    /* renamed from: f, reason: collision with root package name */
    private final b f73229f;

    /* renamed from: g, reason: collision with root package name */
    private final b f73230g;

    /* renamed from: h, reason: collision with root package name */
    private final b f73231h;

    /* renamed from: i, reason: collision with root package name */
    private final b f73232i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f73233j;

    public n() {
        this(null, null, null, null, null, null, null, null, null);
    }

    public n(e eVar, o oVar, g gVar, b bVar, d dVar, b bVar2, b bVar3, b bVar4, b bVar5) {
        this.f73233j = false;
        this.f73224a = eVar;
        this.f73225b = oVar;
        this.f73226c = gVar;
        this.f73227d = bVar;
        this.f73228e = dVar;
        this.f73231h = bVar2;
        this.f73232i = bVar3;
        this.f73229f = bVar4;
        this.f73230g = bVar5;
    }

    @Override // r4.c
    public m4.c a(LottieDrawable lottieDrawable, com.airbnb.lottie.h hVar, com.airbnb.lottie.model.layer.a aVar) {
        return null;
    }

    public n4.p b() {
        return new n4.p(this);
    }

    public e c() {
        return this.f73224a;
    }

    public b d() {
        return this.f73232i;
    }

    public d e() {
        return this.f73228e;
    }

    public o f() {
        return this.f73225b;
    }

    public b g() {
        return this.f73227d;
    }

    public g h() {
        return this.f73226c;
    }

    public b i() {
        return this.f73229f;
    }

    public b j() {
        return this.f73230g;
    }

    public b k() {
        return this.f73231h;
    }

    public boolean l() {
        return this.f73233j;
    }

    public void m(boolean z10) {
        this.f73233j = z10;
    }
}
