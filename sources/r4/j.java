package r4;

import android.graphics.Path;
import com.airbnb.lottie.LottieDrawable;

/* loaded from: classes2.dex */
public class j implements c {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f74246a;

    /* renamed from: b, reason: collision with root package name */
    private final Path.FillType f74247b;

    /* renamed from: c, reason: collision with root package name */
    private final String f74248c;

    /* renamed from: d, reason: collision with root package name */
    private final q4.a f74249d;

    /* renamed from: e, reason: collision with root package name */
    private final q4.d f74250e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f74251f;

    public j(String str, boolean z10, Path.FillType fillType, q4.a aVar, q4.d dVar, boolean z11) {
        this.f74248c = str;
        this.f74246a = z10;
        this.f74247b = fillType;
        this.f74249d = aVar;
        this.f74250e = dVar;
        this.f74251f = z11;
    }

    @Override // r4.c
    public m4.c a(LottieDrawable lottieDrawable, com.airbnb.lottie.h hVar, com.airbnb.lottie.model.layer.a aVar) {
        return new m4.g(lottieDrawable, aVar, this);
    }

    public q4.a b() {
        return this.f74249d;
    }

    public Path.FillType c() {
        return this.f74247b;
    }

    public String d() {
        return this.f74248c;
    }

    public q4.d e() {
        return this.f74250e;
    }

    public boolean f() {
        return this.f74251f;
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.f74246a + '}';
    }
}
