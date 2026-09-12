package bf;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final String f16538a;

    /* renamed from: b, reason: collision with root package name */
    private final String f16539b;

    /* renamed from: c, reason: collision with root package name */
    private final String f16540c;

    /* renamed from: d, reason: collision with root package name */
    private final Integer f16541d;

    /* renamed from: e, reason: collision with root package name */
    private final Integer f16542e;

    public a() {
        this(null, null, null, null, null, 31, null);
    }

    public a(String str, String str2, String str3, Integer num, Integer num2) {
        this.f16538a = str;
        this.f16539b = str2;
        this.f16540c = str3;
        this.f16541d = num;
        this.f16542e = num2;
    }

    public /* synthetic */ a(String str, String str2, String str3, Integer num, Integer num2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3, (i11 & 8) != 0 ? null : num, (i11 & 16) != 0 ? null : num2);
    }

    public final String a() {
        return this.f16540c;
    }

    public final Integer b() {
        return this.f16542e;
    }

    public final Integer c() {
        return this.f16541d;
    }

    public final String d() {
        return this.f16539b;
    }

    public final String e() {
        return this.f16538a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.c(this.f16538a, aVar.f16538a) && Intrinsics.c(this.f16539b, aVar.f16539b) && Intrinsics.c(this.f16540c, aVar.f16540c) && Intrinsics.c(this.f16541d, aVar.f16541d) && Intrinsics.c(this.f16542e, aVar.f16542e);
    }

    public int hashCode() {
        String str = this.f16538a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f16539b;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f16540c;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.f16541d;
        int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.f16542e;
        return hashCode4 + (num2 != null ? num2.hashCode() : 0);
    }

    public String toString() {
        return "DialogInfo(title=" + this.f16538a + ", subtitle=" + this.f16539b + ", buttonText=" + this.f16540c + ", iconResId=" + this.f16541d + ", iconBgColorResId=" + this.f16542e + ")";
    }
}
