package a9;

/* loaded from: classes3.dex */
public final class n0 implements u8.b {

    /* renamed from: a, reason: collision with root package name */
    private final uz.a f502a;

    /* renamed from: b, reason: collision with root package name */
    private final uz.a f503b;

    /* renamed from: c, reason: collision with root package name */
    private final uz.a f504c;

    /* renamed from: d, reason: collision with root package name */
    private final uz.a f505d;

    /* renamed from: e, reason: collision with root package name */
    private final uz.a f506e;

    public n0(uz.a aVar, uz.a aVar2, uz.a aVar3, uz.a aVar4, uz.a aVar5) {
        this.f502a = aVar;
        this.f503b = aVar2;
        this.f504c = aVar3;
        this.f505d = aVar4;
        this.f506e = aVar5;
    }

    public static n0 a(uz.a aVar, uz.a aVar2, uz.a aVar3, uz.a aVar4, uz.a aVar5) {
        return new n0(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static m0 c(c9.a aVar, c9.a aVar2, Object obj, Object obj2, uz.a aVar3) {
        return new m0(aVar, aVar2, (e) obj, (v0) obj2, aVar3);
    }

    @Override // uz.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public m0 get() {
        return c((c9.a) this.f502a.get(), (c9.a) this.f503b.get(), this.f504c.get(), this.f505d.get(), this.f506e);
    }
}
