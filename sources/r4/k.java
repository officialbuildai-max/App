package r4;

import com.airbnb.lottie.LottieDrawable;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public class k implements c {

    /* renamed from: a, reason: collision with root package name */
    private final String f74252a;

    /* renamed from: b, reason: collision with root package name */
    private final List f74253b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f74254c;

    public k(String str, List list, boolean z10) {
        this.f74252a = str;
        this.f74253b = list;
        this.f74254c = z10;
    }

    @Override // r4.c
    public m4.c a(LottieDrawable lottieDrawable, com.airbnb.lottie.h hVar, com.airbnb.lottie.model.layer.a aVar) {
        return new m4.d(lottieDrawable, aVar, this, hVar);
    }

    public List b() {
        return this.f74253b;
    }

    public String c() {
        return this.f74252a;
    }

    public boolean d() {
        return this.f74254c;
    }

    public String toString() {
        return "ShapeGroup{name='" + this.f74252a + "' Shapes: " + Arrays.toString(this.f74253b.toArray()) + '}';
    }
}
