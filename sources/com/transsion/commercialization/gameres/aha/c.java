package com.transsion.commercialization.gameres.aha;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private String f43841a;

    /* renamed from: b, reason: collision with root package name */
    private String f43842b;

    /* renamed from: c, reason: collision with root package name */
    private Double f43843c;

    /* renamed from: d, reason: collision with root package name */
    private String f43844d;

    /* renamed from: e, reason: collision with root package name */
    private String f43845e;

    /* renamed from: f, reason: collision with root package name */
    private String f43846f;

    public c() {
        this(null, null, null, null, null, null, 63, null);
    }

    public c(String str, String str2, Double d11, String str3, String str4, String str5) {
        this.f43841a = str;
        this.f43842b = str2;
        this.f43843c = d11;
        this.f43844d = str3;
        this.f43845e = str4;
        this.f43846f = str5;
    }

    public /* synthetic */ c(String str, String str2, Double d11, String str3, String str4, String str5, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : d11, (i11 & 8) != 0 ? null : str3, (i11 & 16) != 0 ? null : str4, (i11 & 32) != 0 ? null : str5);
    }

    public final String a() {
        return this.f43846f;
    }

    public final String b() {
        return this.f43845e;
    }

    public final String c() {
        return this.f43842b;
    }

    public final String d() {
        return this.f43844d;
    }

    public final Double e() {
        return this.f43843c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Intrinsics.c(this.f43841a, cVar.f43841a) && Intrinsics.c(this.f43842b, cVar.f43842b) && Intrinsics.c(this.f43843c, cVar.f43843c) && Intrinsics.c(this.f43844d, cVar.f43844d) && Intrinsics.c(this.f43845e, cVar.f43845e) && Intrinsics.c(this.f43846f, cVar.f43846f);
    }

    public final String f() {
        return this.f43841a;
    }

    public int hashCode() {
        String str = this.f43841a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f43842b;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Double d11 = this.f43843c;
        int hashCode3 = (hashCode2 + (d11 == null ? 0 : d11.hashCode())) * 31;
        String str3 = this.f43844d;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f43845e;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.f43846f;
        return hashCode5 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "AHAGameResInfo(title=" + this.f43841a + ", icon=" + this.f43842b + ", star=" + this.f43843c + ", size=" + this.f43844d + ", category=" + this.f43845e + ", appLink=" + this.f43846f + ")";
    }
}
