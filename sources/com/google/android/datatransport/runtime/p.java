package com.google.android.datatransport.runtime;

import java.util.Set;

/* loaded from: classes3.dex */
final class p implements r8.i {

    /* renamed from: a, reason: collision with root package name */
    private final Set f24467a;

    /* renamed from: b, reason: collision with root package name */
    private final o f24468b;

    /* renamed from: c, reason: collision with root package name */
    private final s f24469c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(Set set, o oVar, s sVar) {
        this.f24467a = set;
        this.f24468b = oVar;
        this.f24469c = sVar;
    }

    @Override // r8.i
    public r8.h a(String str, Class cls, r8.g gVar) {
        return b(str, cls, r8.c.b("proto"), gVar);
    }

    @Override // r8.i
    public r8.h b(String str, Class cls, r8.c cVar, r8.g gVar) {
        if (this.f24467a.contains(cVar)) {
            return new r(this.f24468b, str, cVar, gVar, this.f24469c);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", cVar, this.f24467a));
    }
}
