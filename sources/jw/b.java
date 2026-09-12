package jw;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final String f66431a;

    /* renamed from: b, reason: collision with root package name */
    private final String f66432b;

    /* renamed from: c, reason: collision with root package name */
    private final String f66433c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f66434d;

    /* renamed from: e, reason: collision with root package name */
    private final int f66435e;

    /* renamed from: f, reason: collision with root package name */
    private final int f66436f;

    /* renamed from: g, reason: collision with root package name */
    private final List f66437g;

    /* renamed from: h, reason: collision with root package name */
    private final String f66438h;

    /* renamed from: i, reason: collision with root package name */
    private final List f66439i;

    public b(String userName, String str, String str2, boolean z10, int i11, int i12, List rights, String str3, List devices) {
        Intrinsics.h(userName, "userName");
        Intrinsics.h(rights, "rights");
        Intrinsics.h(devices, "devices");
        this.f66431a = userName;
        this.f66432b = str;
        this.f66433c = str2;
        this.f66434d = z10;
        this.f66435e = i11;
        this.f66436f = i12;
        this.f66437g = rights;
        this.f66438h = str3;
        this.f66439i = devices;
    }

    public final String a() {
        return this.f66432b;
    }

    public final int b() {
        return this.f66435e;
    }

    public final String c() {
        return this.f66438h;
    }

    public final List d() {
        return this.f66439i;
    }

    public final String e() {
        return this.f66433c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Intrinsics.c(this.f66431a, bVar.f66431a) && Intrinsics.c(this.f66432b, bVar.f66432b) && Intrinsics.c(this.f66433c, bVar.f66433c) && this.f66434d == bVar.f66434d && this.f66435e == bVar.f66435e && this.f66436f == bVar.f66436f && Intrinsics.c(this.f66437g, bVar.f66437g) && Intrinsics.c(this.f66438h, bVar.f66438h) && Intrinsics.c(this.f66439i, bVar.f66439i);
    }

    public final int f() {
        return this.f66436f;
    }

    public final List g() {
        return this.f66437g;
    }

    public final String h() {
        return this.f66431a;
    }

    public int hashCode() {
        int hashCode = this.f66431a.hashCode() * 31;
        String str = this.f66432b;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f66433c;
        int hashCode3 = (((((((((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + androidx.compose.foundation.e.a(this.f66434d)) * 31) + this.f66435e) * 31) + this.f66436f) * 31) + this.f66437g.hashCode()) * 31;
        String str3 = this.f66438h;
        return ((hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.f66439i.hashCode();
    }

    public final boolean i() {
        return this.f66434d;
    }

    public String toString() {
        return "DeviceManagementUiModel(userName=" + this.f66431a + ", avatarUrl=" + this.f66432b + ", memberExpiryDate=" + this.f66433c + ", isPro=" + this.f66434d + ", basicLinkedDevice=" + this.f66435e + ", proLinkedDevice=" + this.f66436f + ", rights=" + this.f66437g + ", bottomDescription=" + this.f66438h + ", devices=" + this.f66439i + ")";
    }
}
