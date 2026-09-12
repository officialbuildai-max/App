package androidx.room;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public abstract class d0 implements e0 {

    /* renamed from: a, reason: collision with root package name */
    private final int f14733a;

    /* renamed from: b, reason: collision with root package name */
    private final String f14734b;

    /* renamed from: c, reason: collision with root package name */
    private final String f14735c;

    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f14736a;

        /* renamed from: b, reason: collision with root package name */
        public final String f14737b;

        public a(boolean z10, String str) {
            this.f14736a = z10;
            this.f14737b = str;
        }
    }

    public d0(int i11, String identityHash, String legacyIdentityHash) {
        Intrinsics.h(identityHash, "identityHash");
        Intrinsics.h(legacyIdentityHash, "legacyIdentityHash");
        this.f14733a = i11;
        this.f14734b = identityHash;
        this.f14735c = legacyIdentityHash;
    }

    public abstract void a(z3.b bVar);

    public abstract void b(z3.b bVar);

    public final String c() {
        return this.f14734b;
    }

    public final String d() {
        return this.f14735c;
    }

    public final int e() {
        return this.f14733a;
    }

    public abstract void f(z3.b bVar);

    public abstract void g(z3.b bVar);

    public abstract void h(z3.b bVar);

    public abstract void i(z3.b bVar);

    public abstract a j(z3.b bVar);
}
