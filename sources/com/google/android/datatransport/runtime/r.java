package com.google.android.datatransport.runtime;

/* loaded from: classes3.dex */
final class r implements r8.h {

    /* renamed from: a, reason: collision with root package name */
    private final o f24470a;

    /* renamed from: b, reason: collision with root package name */
    private final String f24471b;

    /* renamed from: c, reason: collision with root package name */
    private final r8.c f24472c;

    /* renamed from: d, reason: collision with root package name */
    private final r8.g f24473d;

    /* renamed from: e, reason: collision with root package name */
    private final s f24474e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(o oVar, String str, r8.c cVar, r8.g gVar, s sVar) {
        this.f24470a = oVar;
        this.f24471b = str;
        this.f24472c = cVar;
        this.f24473d = gVar;
        this.f24474e = sVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(Exception exc) {
    }

    @Override // r8.h
    public void a(r8.d dVar, r8.j jVar) {
        this.f24474e.a(n.a().e(this.f24470a).c(dVar).f(this.f24471b).d(this.f24473d).b(this.f24472c).a(), jVar);
    }

    @Override // r8.h
    public void b(r8.d dVar) {
        a(dVar, new r8.j() { // from class: com.google.android.datatransport.runtime.q
            @Override // r8.j
            public final void a(Exception exc) {
                r.e(exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o d() {
        return this.f24470a;
    }
}
