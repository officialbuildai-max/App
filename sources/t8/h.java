package t8;

import android.content.Context;

/* loaded from: classes4.dex */
public final class h implements u8.b {

    /* renamed from: a, reason: collision with root package name */
    private final uz.a f76205a;

    /* renamed from: b, reason: collision with root package name */
    private final uz.a f76206b;

    /* renamed from: c, reason: collision with root package name */
    private final uz.a f76207c;

    public h(uz.a aVar, uz.a aVar2, uz.a aVar3) {
        this.f76205a = aVar;
        this.f76206b = aVar2;
        this.f76207c = aVar3;
    }

    public static h a(uz.a aVar, uz.a aVar2, uz.a aVar3) {
        return new h(aVar, aVar2, aVar3);
    }

    public static g c(Context context, c9.a aVar, c9.a aVar2) {
        return new g(context, aVar, aVar2);
    }

    @Override // uz.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public g get() {
        return c((Context) this.f76205a.get(), (c9.a) this.f76206b.get(), (c9.a) this.f76207c.get());
    }
}
