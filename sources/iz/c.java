package iz;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final int f65801a;

    /* renamed from: b, reason: collision with root package name */
    private final String f65802b;

    /* renamed from: c, reason: collision with root package name */
    private final String f65803c;

    /* renamed from: d, reason: collision with root package name */
    private final String f65804d;

    /* renamed from: e, reason: collision with root package name */
    private final int f65805e;

    public c(int i11, String str, String codecName, String str2, int i12) {
        Intrinsics.h(codecName, "codecName");
        this.f65801a = i11;
        this.f65802b = str;
        this.f65803c = codecName;
        this.f65804d = str2;
        this.f65805e = i12;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f65801a == cVar.f65801a && Intrinsics.c(this.f65802b, cVar.f65802b) && Intrinsics.c(this.f65803c, cVar.f65803c) && Intrinsics.c(this.f65804d, cVar.f65804d) && this.f65805e == cVar.f65805e;
    }

    public int hashCode() {
        int i11 = this.f65801a * 31;
        String str = this.f65802b;
        int hashCode = (((i11 + (str == null ? 0 : str.hashCode())) * 31) + this.f65803c.hashCode()) * 31;
        String str2 = this.f65804d;
        return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f65805e;
    }

    public String toString() {
        return "SubtitleStream(index=" + this.f65801a + ", title=" + this.f65802b + ", codecName=" + this.f65803c + ", language=" + this.f65804d + ", disposition=" + this.f65805e + ")";
    }
}
