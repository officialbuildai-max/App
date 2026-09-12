package com.transsion.json.b;

/* loaded from: classes.dex */
public class o extends a {

    /* renamed from: a, reason: collision with root package name */
    protected final n f46087a;

    public o(n nVar) {
        this.f46087a = nVar;
    }

    @Override // com.transsion.json.b.a, com.transsion.json.b.g
    public Boolean a() {
        n nVar = this.f46087a;
        return Boolean.valueOf((nVar instanceof g) && ((g) nVar).a().booleanValue());
    }

    @Override // com.transsion.json.b.n
    public void a(Object obj) {
        b().t().addFirst(obj);
        this.f46087a.a(obj);
        b().t().removeFirst();
    }
}
