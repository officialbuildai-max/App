package com.google.android.datatransport.runtime;

/* loaded from: classes3.dex */
public final class v implements u8.b {

    /* renamed from: a, reason: collision with root package name */
    private final uz.a f24490a;

    /* renamed from: b, reason: collision with root package name */
    private final uz.a f24491b;

    /* renamed from: c, reason: collision with root package name */
    private final uz.a f24492c;

    /* renamed from: d, reason: collision with root package name */
    private final uz.a f24493d;

    /* renamed from: e, reason: collision with root package name */
    private final uz.a f24494e;

    public v(uz.a aVar, uz.a aVar2, uz.a aVar3, uz.a aVar4, uz.a aVar5) {
        this.f24490a = aVar;
        this.f24491b = aVar2;
        this.f24492c = aVar3;
        this.f24493d = aVar4;
        this.f24494e = aVar5;
    }

    public static v a(uz.a aVar, uz.a aVar2, uz.a aVar3, uz.a aVar4, uz.a aVar5) {
        return new v(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static t c(c9.a aVar, c9.a aVar2, y8.e eVar, z8.o oVar, z8.s sVar) {
        return new t(aVar, aVar2, eVar, oVar, sVar);
    }

    @Override // uz.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public t get() {
        return c((c9.a) this.f24490a.get(), (c9.a) this.f24491b.get(), (y8.e) this.f24492c.get(), (z8.o) this.f24493d.get(), (z8.s) this.f24494e.get());
    }
}
