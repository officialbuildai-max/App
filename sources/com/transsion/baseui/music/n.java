package com.transsion.baseui.music;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes5.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    private String f43544a;

    /* renamed from: b, reason: collision with root package name */
    private String f43545b;

    /* renamed from: c, reason: collision with root package name */
    private String f43546c;

    /* renamed from: d, reason: collision with root package name */
    private long f43547d;

    /* renamed from: e, reason: collision with root package name */
    private long f43548e;

    /* renamed from: f, reason: collision with root package name */
    private long f43549f;

    /* renamed from: g, reason: collision with root package name */
    private long f43550g;

    /* renamed from: h, reason: collision with root package name */
    private long f43551h;

    /* renamed from: i, reason: collision with root package name */
    private int f43552i;

    /* renamed from: j, reason: collision with root package name */
    private int f43553j;

    public n() {
        this(null, null, null, 0L, 0L, 0L, 0L, 0L, 0, 0, 1023, null);
    }

    public n(String str, String str2, String str3, long j11, long j12, long j13, long j14, long j15, int i11, int i12) {
        this.f43544a = str;
        this.f43545b = str2;
        this.f43546c = str3;
        this.f43547d = j11;
        this.f43548e = j12;
        this.f43549f = j13;
        this.f43550g = j14;
        this.f43551h = j15;
        this.f43552i = i11;
        this.f43553j = i12;
    }

    public /* synthetic */ n(String str, String str2, String str3, long j11, long j12, long j13, long j14, long j15, int i11, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this((i13 & 1) != 0 ? null : str, (i13 & 2) != 0 ? null : str2, (i13 & 4) == 0 ? str3 : null, (i13 & 8) != 0 ? 0L : j11, (i13 & 16) != 0 ? 0L : j12, (i13 & 32) != 0 ? 0L : j13, (i13 & 64) != 0 ? 0L : j14, (i13 & 128) == 0 ? j15 : 0L, (i13 & 256) != 0 ? 0 : i11, (i13 & 512) == 0 ? i12 : 0);
    }

    public final int a() {
        return this.f43553j;
    }

    public final long b() {
        return this.f43550g;
    }

    public final long c() {
        return this.f43551h;
    }

    public final String d() {
        return this.f43544a;
    }

    public final String e() {
        return this.f43545b;
    }

    public final long f() {
        return this.f43548e;
    }

    public final long g() {
        return this.f43547d;
    }

    public final String h() {
        return this.f43546c;
    }

    public final long i() {
        return this.f43549f;
    }

    public final int j() {
        return this.f43552i;
    }

    public final void k(int i11) {
        this.f43553j = i11;
    }

    public final void l(long j11) {
        this.f43550g = j11;
    }

    public final void m(long j11) {
        this.f43551h = j11;
    }

    public final void n(String str) {
        this.f43545b = str;
    }

    public final void o(long j11) {
        this.f43548e = j11;
    }

    public final void p(long j11) {
        this.f43547d = j11;
    }

    public final void q(String str) {
        this.f43546c = str;
    }

    public final void r(long j11) {
        this.f43549f = j11;
    }

    public final void s(int i11) {
        this.f43552i = i11;
    }
}
