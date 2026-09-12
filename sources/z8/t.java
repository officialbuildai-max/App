package z8;

import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public final class t implements u8.b {

    /* renamed from: a, reason: collision with root package name */
    private final uz.a f79481a;

    /* renamed from: b, reason: collision with root package name */
    private final uz.a f79482b;

    /* renamed from: c, reason: collision with root package name */
    private final uz.a f79483c;

    /* renamed from: d, reason: collision with root package name */
    private final uz.a f79484d;

    public t(uz.a aVar, uz.a aVar2, uz.a aVar3, uz.a aVar4) {
        this.f79481a = aVar;
        this.f79482b = aVar2;
        this.f79483c = aVar3;
        this.f79484d = aVar4;
    }

    public static t a(uz.a aVar, uz.a aVar2, uz.a aVar3, uz.a aVar4) {
        return new t(aVar, aVar2, aVar3, aVar4);
    }

    public static s c(Executor executor, a9.d dVar, u uVar, b9.a aVar) {
        return new s(executor, dVar, uVar, aVar);
    }

    @Override // uz.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public s get() {
        return c((Executor) this.f79481a.get(), (a9.d) this.f79482b.get(), (u) this.f79483c.get(), (b9.a) this.f79484d.get());
    }
}
