package y8;

import java.util.concurrent.Executor;
import z8.u;

/* loaded from: classes4.dex */
public final class d implements u8.b {

    /* renamed from: a, reason: collision with root package name */
    private final uz.a f79061a;

    /* renamed from: b, reason: collision with root package name */
    private final uz.a f79062b;

    /* renamed from: c, reason: collision with root package name */
    private final uz.a f79063c;

    /* renamed from: d, reason: collision with root package name */
    private final uz.a f79064d;

    /* renamed from: e, reason: collision with root package name */
    private final uz.a f79065e;

    public d(uz.a aVar, uz.a aVar2, uz.a aVar3, uz.a aVar4, uz.a aVar5) {
        this.f79061a = aVar;
        this.f79062b = aVar2;
        this.f79063c = aVar3;
        this.f79064d = aVar4;
        this.f79065e = aVar5;
    }

    public static d a(uz.a aVar, uz.a aVar2, uz.a aVar3, uz.a aVar4, uz.a aVar5) {
        return new d(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static c c(Executor executor, t8.d dVar, u uVar, a9.d dVar2, b9.a aVar) {
        return new c(executor, dVar, uVar, dVar2, aVar);
    }

    @Override // uz.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c get() {
        return c((Executor) this.f79061a.get(), (t8.d) this.f79062b.get(), (u) this.f79063c.get(), (a9.d) this.f79064d.get(), (b9.a) this.f79065e.get());
    }
}
