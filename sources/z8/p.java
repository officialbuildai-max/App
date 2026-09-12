package z8;

import android.content.Context;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public final class p implements u8.b {

    /* renamed from: a, reason: collision with root package name */
    private final uz.a f79466a;

    /* renamed from: b, reason: collision with root package name */
    private final uz.a f79467b;

    /* renamed from: c, reason: collision with root package name */
    private final uz.a f79468c;

    /* renamed from: d, reason: collision with root package name */
    private final uz.a f79469d;

    /* renamed from: e, reason: collision with root package name */
    private final uz.a f79470e;

    /* renamed from: f, reason: collision with root package name */
    private final uz.a f79471f;

    /* renamed from: g, reason: collision with root package name */
    private final uz.a f79472g;

    /* renamed from: h, reason: collision with root package name */
    private final uz.a f79473h;

    /* renamed from: i, reason: collision with root package name */
    private final uz.a f79474i;

    public p(uz.a aVar, uz.a aVar2, uz.a aVar3, uz.a aVar4, uz.a aVar5, uz.a aVar6, uz.a aVar7, uz.a aVar8, uz.a aVar9) {
        this.f79466a = aVar;
        this.f79467b = aVar2;
        this.f79468c = aVar3;
        this.f79469d = aVar4;
        this.f79470e = aVar5;
        this.f79471f = aVar6;
        this.f79472g = aVar7;
        this.f79473h = aVar8;
        this.f79474i = aVar9;
    }

    public static p a(uz.a aVar, uz.a aVar2, uz.a aVar3, uz.a aVar4, uz.a aVar5, uz.a aVar6, uz.a aVar7, uz.a aVar8, uz.a aVar9) {
        return new p(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9);
    }

    public static o c(Context context, t8.d dVar, a9.d dVar2, u uVar, Executor executor, b9.a aVar, c9.a aVar2, c9.a aVar3, a9.c cVar) {
        return new o(context, dVar, dVar2, uVar, executor, aVar, aVar2, aVar3, cVar);
    }

    @Override // uz.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public o get() {
        return c((Context) this.f79466a.get(), (t8.d) this.f79467b.get(), (a9.d) this.f79468c.get(), (u) this.f79469d.get(), (Executor) this.f79470e.get(), (b9.a) this.f79471f.get(), (c9.a) this.f79472g.get(), (c9.a) this.f79473h.get(), (a9.c) this.f79474i.get());
    }
}
