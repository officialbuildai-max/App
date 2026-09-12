package androidx.work.impl.model;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    private final String f15834a;

    /* renamed from: b, reason: collision with root package name */
    private final Long f15835b;

    public h(String key, Long l11) {
        Intrinsics.h(key, "key");
        this.f15834a = key;
        this.f15835b = l11;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h(String key, boolean z10) {
        this(key, Long.valueOf(z10 ? 1L : 0L));
        Intrinsics.h(key, "key");
    }

    public final String a() {
        return this.f15834a;
    }

    public final Long b() {
        return this.f15835b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return Intrinsics.c(this.f15834a, hVar.f15834a) && Intrinsics.c(this.f15835b, hVar.f15835b);
    }

    public int hashCode() {
        int hashCode = this.f15834a.hashCode() * 31;
        Long l11 = this.f15835b;
        return hashCode + (l11 == null ? 0 : l11.hashCode());
    }

    public String toString() {
        return "Preference(key=" + this.f15834a + ", value=" + this.f15835b + ')';
    }
}
