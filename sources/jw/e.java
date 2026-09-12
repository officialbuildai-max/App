package jw;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final String f66448a;

    /* renamed from: b, reason: collision with root package name */
    private final String f66449b;

    /* renamed from: c, reason: collision with root package name */
    private final String f66450c;

    /* renamed from: d, reason: collision with root package name */
    private final int f66451d;

    /* renamed from: e, reason: collision with root package name */
    private final int f66452e;

    public e(String str, String name, String str2, int i11, int i12) {
        Intrinsics.h(name, "name");
        this.f66448a = str;
        this.f66449b = name;
        this.f66450c = str2;
        this.f66451d = i11;
        this.f66452e = i12;
    }

    public final int a() {
        return this.f66451d;
    }

    public final String b() {
        return this.f66450c;
    }

    public final String c() {
        return this.f66448a;
    }

    public final String d() {
        return this.f66449b;
    }

    public final int e() {
        return this.f66452e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return Intrinsics.c(this.f66448a, eVar.f66448a) && Intrinsics.c(this.f66449b, eVar.f66449b) && Intrinsics.c(this.f66450c, eVar.f66450c) && this.f66451d == eVar.f66451d && this.f66452e == eVar.f66452e;
    }

    public int hashCode() {
        String str = this.f66448a;
        int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.f66449b.hashCode()) * 31;
        String str2 = this.f66450c;
        return ((((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f66451d) * 31) + this.f66452e;
    }

    public String toString() {
        return "UpgradeRightUiModel(iconUrl=" + this.f66448a + ", name=" + this.f66449b + ", featureLink=" + this.f66450c + ", basicCount=" + this.f66451d + ", proCount=" + this.f66452e + ")";
    }
}
