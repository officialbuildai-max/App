package com.transsion.player.longvideo.helper;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.tools.zip.UnixStat;

/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final String f48015a;

    /* renamed from: b, reason: collision with root package name */
    private final String f48016b;

    /* renamed from: c, reason: collision with root package name */
    private final String f48017c;

    /* renamed from: d, reason: collision with root package name */
    private final String f48018d;

    /* renamed from: e, reason: collision with root package name */
    private final String f48019e;

    /* renamed from: f, reason: collision with root package name */
    private final String f48020f;

    /* renamed from: g, reason: collision with root package name */
    private final String f48021g;

    /* renamed from: h, reason: collision with root package name */
    private final String f48022h;

    /* renamed from: i, reason: collision with root package name */
    private final int f48023i;

    /* renamed from: j, reason: collision with root package name */
    private final int f48024j;

    /* renamed from: k, reason: collision with root package name */
    private final int f48025k;

    /* renamed from: l, reason: collision with root package name */
    private final int f48026l;

    public b() {
        this(null, null, null, null, null, null, null, null, 0, 0, 0, 0, UnixStat.PERM_MASK, null);
    }

    public b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i11, int i12, int i13, int i14) {
        this.f48015a = str;
        this.f48016b = str2;
        this.f48017c = str3;
        this.f48018d = str4;
        this.f48019e = str5;
        this.f48020f = str6;
        this.f48021g = str7;
        this.f48022h = str8;
        this.f48023i = i11;
        this.f48024j = i12;
        this.f48025k = i13;
        this.f48026l = i14;
    }

    public /* synthetic */ b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i11, int i12, int i13, int i14, int i15, DefaultConstructorMarker defaultConstructorMarker) {
        this((i15 & 1) != 0 ? null : str, (i15 & 2) != 0 ? null : str2, (i15 & 4) != 0 ? null : str3, (i15 & 8) != 0 ? null : str4, (i15 & 16) != 0 ? null : str5, (i15 & 32) != 0 ? null : str6, (i15 & 64) != 0 ? null : str7, (i15 & 128) == 0 ? str8 : null, (i15 & 256) != 0 ? 3 : i11, (i15 & 512) == 0 ? i12 : 3, (i15 & 1024) != 0 ? 24 : i13, (i15 & 2048) != 0 ? 10 : i14);
    }

    public final String a() {
        return this.f48020f;
    }

    public final String b() {
        return this.f48021g;
    }

    public final int c() {
        return this.f48025k;
    }

    public final int d() {
        return this.f48024j;
    }

    public final String e() {
        return this.f48017c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Intrinsics.c(this.f48015a, bVar.f48015a) && Intrinsics.c(this.f48016b, bVar.f48016b) && Intrinsics.c(this.f48017c, bVar.f48017c) && Intrinsics.c(this.f48018d, bVar.f48018d) && Intrinsics.c(this.f48019e, bVar.f48019e) && Intrinsics.c(this.f48020f, bVar.f48020f) && Intrinsics.c(this.f48021g, bVar.f48021g) && Intrinsics.c(this.f48022h, bVar.f48022h) && this.f48023i == bVar.f48023i && this.f48024j == bVar.f48024j && this.f48025k == bVar.f48025k && this.f48026l == bVar.f48026l;
    }

    public final String f() {
        return this.f48016b;
    }

    public final String g() {
        return this.f48015a;
    }

    public final String h() {
        return this.f48022h;
    }

    public int hashCode() {
        String str = this.f48015a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f48016b;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f48017c;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f48018d;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.f48019e;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.f48020f;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.f48021g;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.f48022h;
        return ((((((((hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31) + this.f48023i) * 31) + this.f48024j) * 31) + this.f48025k) * 31) + this.f48026l;
    }

    public final int i() {
        return this.f48023i;
    }

    public final int j() {
        return this.f48026l;
    }

    public final String k() {
        return this.f48019e;
    }

    public final String l() {
        return this.f48018d;
    }

    public String toString() {
        return "DataOperator(layoutTitle=" + this.f48015a + ", layoutTips=" + this.f48016b + ", layoutButton=" + this.f48017c + ", title=" + this.f48018d + ", tips=" + this.f48019e + ", button=" + this.f48020f + ", buttonIcon=" + this.f48021g + ", link=" + this.f48022h + ", normalDelay=" + this.f48023i + ", fullscreenDelay=" + this.f48024j + ", displayInterval=" + this.f48025k + ", showDuration=" + this.f48026l + ")";
    }
}
