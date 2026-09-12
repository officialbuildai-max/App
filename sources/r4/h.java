package r4;

import com.airbnb.lottie.LottieDrawable;
import m4.q;
import q4.o;

/* loaded from: classes2.dex */
public class h implements c {

    /* renamed from: a, reason: collision with root package name */
    private final String f74241a;

    /* renamed from: b, reason: collision with root package name */
    private final o f74242b;

    public h(String str, o oVar) {
        this.f74241a = str;
        this.f74242b = oVar;
    }

    @Override // r4.c
    public m4.c a(LottieDrawable lottieDrawable, com.airbnb.lottie.h hVar, com.airbnb.lottie.model.layer.a aVar) {
        return new q(lottieDrawable, aVar, this);
    }

    public o b() {
        return this.f74242b;
    }

    public String c() {
        return this.f74241a;
    }
}
