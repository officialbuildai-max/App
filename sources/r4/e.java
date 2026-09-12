package r4;

import android.graphics.Path;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.model.content.GradientType;

/* loaded from: classes2.dex */
public class e implements c {

    /* renamed from: a, reason: collision with root package name */
    private final GradientType f74221a;

    /* renamed from: b, reason: collision with root package name */
    private final Path.FillType f74222b;

    /* renamed from: c, reason: collision with root package name */
    private final q4.c f74223c;

    /* renamed from: d, reason: collision with root package name */
    private final q4.d f74224d;

    /* renamed from: e, reason: collision with root package name */
    private final q4.f f74225e;

    /* renamed from: f, reason: collision with root package name */
    private final q4.f f74226f;

    /* renamed from: g, reason: collision with root package name */
    private final String f74227g;

    /* renamed from: h, reason: collision with root package name */
    private final q4.b f74228h;

    /* renamed from: i, reason: collision with root package name */
    private final q4.b f74229i;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f74230j;

    public e(String str, GradientType gradientType, Path.FillType fillType, q4.c cVar, q4.d dVar, q4.f fVar, q4.f fVar2, q4.b bVar, q4.b bVar2, boolean z10) {
        this.f74221a = gradientType;
        this.f74222b = fillType;
        this.f74223c = cVar;
        this.f74224d = dVar;
        this.f74225e = fVar;
        this.f74226f = fVar2;
        this.f74227g = str;
        this.f74228h = bVar;
        this.f74229i = bVar2;
        this.f74230j = z10;
    }

    @Override // r4.c
    public m4.c a(LottieDrawable lottieDrawable, com.airbnb.lottie.h hVar, com.airbnb.lottie.model.layer.a aVar) {
        return new m4.h(lottieDrawable, hVar, aVar, this);
    }

    public q4.f b() {
        return this.f74226f;
    }

    public Path.FillType c() {
        return this.f74222b;
    }

    public q4.c d() {
        return this.f74223c;
    }

    public GradientType e() {
        return this.f74221a;
    }

    public String f() {
        return this.f74227g;
    }

    public q4.d g() {
        return this.f74224d;
    }

    public q4.f h() {
        return this.f74225e;
    }

    public boolean i() {
        return this.f74230j;
    }
}
