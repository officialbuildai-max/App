package ry;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private String f74883a;

    /* renamed from: b, reason: collision with root package name */
    private String f74884b;

    /* renamed from: c, reason: collision with root package name */
    private int f74885c;

    /* renamed from: d, reason: collision with root package name */
    private long f74886d;

    /* renamed from: e, reason: collision with root package name */
    private int f74887e;

    /* renamed from: f, reason: collision with root package name */
    private int f74888f;

    public g(String str, String str2, int i11) {
        this.f74883a = str;
        this.f74884b = str2;
        this.f74885c = i11;
    }

    public final int a() {
        return this.f74888f;
    }

    public final int b() {
        return this.f74887e;
    }

    public final long c() {
        return this.f74886d;
    }

    public final void d(int i11) {
        this.f74888f = i11;
    }

    public final void e(int i11) {
        this.f74887e = i11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return Intrinsics.c(this.f74883a, gVar.f74883a) && Intrinsics.c(this.f74884b, gVar.f74884b) && this.f74885c == gVar.f74885c;
    }

    public final void f(long j11) {
        this.f74886d = j11;
    }

    public int hashCode() {
        String str = this.f74883a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f74884b;
        return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f74885c;
    }

    public String toString() {
        return "DownloadStat(url=" + this.f74883a + ", taskId=" + this.f74884b + ", status=" + this.f74885c + ")";
    }
}
