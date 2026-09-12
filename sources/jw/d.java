package jw;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final String f66443a;

    /* renamed from: b, reason: collision with root package name */
    private final String f66444b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f66445c;

    /* renamed from: d, reason: collision with root package name */
    private final String f66446d;

    /* renamed from: e, reason: collision with root package name */
    private final int f66447e;

    public d(String name, String str, boolean z10, String str2, int i11) {
        Intrinsics.h(name, "name");
        this.f66443a = name;
        this.f66444b = str;
        this.f66445c = z10;
        this.f66446d = str2;
        this.f66447e = i11;
    }

    public final String a() {
        return this.f66446d;
    }

    public final String b() {
        return this.f66444b;
    }

    public final int c() {
        return this.f66447e;
    }

    public final String d() {
        return this.f66443a;
    }

    public final boolean e() {
        return this.f66445c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return Intrinsics.c(this.f66443a, dVar.f66443a) && Intrinsics.c(this.f66444b, dVar.f66444b) && this.f66445c == dVar.f66445c && Intrinsics.c(this.f66446d, dVar.f66446d) && this.f66447e == dVar.f66447e;
    }

    public int hashCode() {
        int hashCode = this.f66443a.hashCode() * 31;
        String str = this.f66444b;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + androidx.compose.foundation.e.a(this.f66445c)) * 31;
        String str2 = this.f66446d;
        return ((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f66447e;
    }

    public String toString() {
        return "LinkedDeviceUiModel(name=" + this.f66443a + ", lastLoginTime=" + this.f66444b + ", isCurrentDevice=" + this.f66445c + ", iconUrl=" + this.f66446d + ", localIconRes=" + this.f66447e + ")";
    }
}
