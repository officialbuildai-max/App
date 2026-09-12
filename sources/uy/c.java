package uy;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final String f77074a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f77075b;

    /* renamed from: c, reason: collision with root package name */
    private final String f77076c;

    public c(String subjectId, boolean z10, String str) {
        Intrinsics.h(subjectId, "subjectId");
        this.f77074a = subjectId;
        this.f77075b = z10;
        this.f77076c = str;
    }

    public final boolean a() {
        return this.f77075b;
    }

    public final String b() {
        return this.f77076c;
    }

    public final String c() {
        return this.f77074a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Intrinsics.c(this.f77074a, cVar.f77074a) && this.f77075b == cVar.f77075b && Intrinsics.c(this.f77076c, cVar.f77076c);
    }

    public int hashCode() {
        int hashCode = ((this.f77074a.hashCode() * 31) + androidx.compose.foundation.e.a(this.f77075b)) * 31;
        String str = this.f77076c;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "FavoriteEvent(subjectId=" + this.f77074a + ", favorite=" + this.f77075b + ", favoriteNum=" + this.f77076c + ")";
    }
}
