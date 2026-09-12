package com.transsion.commercialization.gameres.aha;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private Integer f43837a;

    /* renamed from: b, reason: collision with root package name */
    private String f43838b;

    /* renamed from: c, reason: collision with root package name */
    private Long f43839c;

    /* renamed from: d, reason: collision with root package name */
    private c f43840d;

    public b() {
        this(null, null, null, null, 15, null);
    }

    public b(Integer num, String str, Long l11, c cVar) {
        this.f43837a = num;
        this.f43838b = str;
        this.f43839c = l11;
        this.f43840d = cVar;
    }

    public /* synthetic */ b(Integer num, String str, Long l11, c cVar, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : num, (i11 & 2) != 0 ? null : str, (i11 & 4) != 0 ? null : l11, (i11 & 8) != 0 ? null : cVar);
    }

    public final Integer a() {
        return this.f43837a;
    }

    public final c b() {
        return this.f43840d;
    }

    public final String c() {
        return this.f43838b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Intrinsics.c(this.f43837a, bVar.f43837a) && Intrinsics.c(this.f43838b, bVar.f43838b) && Intrinsics.c(this.f43839c, bVar.f43839c) && Intrinsics.c(this.f43840d, bVar.f43840d);
    }

    public int hashCode() {
        Integer num = this.f43837a;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.f43838b;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Long l11 = this.f43839c;
        int hashCode3 = (hashCode2 + (l11 == null ? 0 : l11.hashCode())) * 31;
        c cVar = this.f43840d;
        return hashCode3 + (cVar != null ? cVar.hashCode() : 0);
    }

    public String toString() {
        return "AHAGameResDto(code=" + this.f43837a + ", message=" + this.f43838b + ", timestamp=" + this.f43839c + ", data=" + this.f43840d + ")";
    }
}
