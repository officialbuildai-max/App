package tl;

import androidx.compose.foundation.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private String f76400a;

    /* renamed from: b, reason: collision with root package name */
    private String f76401b;

    /* renamed from: c, reason: collision with root package name */
    private String f76402c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f76403d;

    /* renamed from: e, reason: collision with root package name */
    private String f76404e;

    public a(String filterValue, String filterName, String filterType, boolean z10, String str) {
        Intrinsics.h(filterValue, "filterValue");
        Intrinsics.h(filterName, "filterName");
        Intrinsics.h(filterType, "filterType");
        this.f76400a = filterValue;
        this.f76401b = filterName;
        this.f76402c = filterType;
        this.f76403d = z10;
        this.f76404e = str;
    }

    public /* synthetic */ a(String str, String str2, String str3, boolean z10, String str4, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, z10, (i11 & 16) != 0 ? null : str4);
    }

    public final String a() {
        return this.f76401b;
    }

    public final String b() {
        return this.f76402c;
    }

    public final String c() {
        return this.f76400a;
    }

    public final boolean d() {
        return this.f76403d;
    }

    public final void e(boolean z10) {
        this.f76403d = z10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.c(this.f76400a, aVar.f76400a) && Intrinsics.c(this.f76401b, aVar.f76401b) && Intrinsics.c(this.f76402c, aVar.f76402c) && this.f76403d == aVar.f76403d && Intrinsics.c(this.f76404e, aVar.f76404e);
    }

    public int hashCode() {
        int hashCode = ((((((this.f76400a.hashCode() * 31) + this.f76401b.hashCode()) * 31) + this.f76402c.hashCode()) * 31) + e.a(this.f76403d)) * 31;
        String str = this.f76404e;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "FilterItem(filterValue=" + this.f76400a + ", filterName=" + this.f76401b + ", filterType=" + this.f76402c + ", isSelected=" + this.f76403d + ", filterRangeValue=" + this.f76404e + ")";
    }
}
