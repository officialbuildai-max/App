package com.wecloud.load.lib;

import androidx.collection.s;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class n {

    /* renamed from: m, reason: collision with root package name */
    public static final a f60975m = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final String f60976a;

    /* renamed from: b, reason: collision with root package name */
    private final String f60977b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f60978c;

    /* renamed from: d, reason: collision with root package name */
    private final int f60979d;

    /* renamed from: e, reason: collision with root package name */
    private final String f60980e;

    /* renamed from: f, reason: collision with root package name */
    private final String f60981f;

    /* renamed from: g, reason: collision with root package name */
    private final int f60982g;

    /* renamed from: h, reason: collision with root package name */
    private final Map f60983h;

    /* renamed from: i, reason: collision with root package name */
    private final String f60984i;

    /* renamed from: j, reason: collision with root package name */
    private final long f60985j;

    /* renamed from: k, reason: collision with root package name */
    private final long f60986k;

    /* renamed from: l, reason: collision with root package name */
    private final String f60987l;

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public n(String url, String method, boolean z10, int i11, String serverIp, String errorMessage, int i12, Map httpHeaders, String httpBody, long j11, long j12, String httpProtocol) {
        Intrinsics.h(url, "url");
        Intrinsics.h(method, "method");
        Intrinsics.h(serverIp, "serverIp");
        Intrinsics.h(errorMessage, "errorMessage");
        Intrinsics.h(httpHeaders, "httpHeaders");
        Intrinsics.h(httpBody, "httpBody");
        Intrinsics.h(httpProtocol, "httpProtocol");
        this.f60976a = url;
        this.f60977b = method;
        this.f60978c = z10;
        this.f60979d = i11;
        this.f60980e = serverIp;
        this.f60981f = errorMessage;
        this.f60982g = i12;
        this.f60983h = httpHeaders;
        this.f60984i = httpBody;
        this.f60985j = j11;
        this.f60986k = j12;
        this.f60987l = httpProtocol;
    }

    public final n a(String url, String method, boolean z10, int i11, String serverIp, String errorMessage, int i12, Map httpHeaders, String httpBody, long j11, long j12, String httpProtocol) {
        Intrinsics.h(url, "url");
        Intrinsics.h(method, "method");
        Intrinsics.h(serverIp, "serverIp");
        Intrinsics.h(errorMessage, "errorMessage");
        Intrinsics.h(httpHeaders, "httpHeaders");
        Intrinsics.h(httpBody, "httpBody");
        Intrinsics.h(httpProtocol, "httpProtocol");
        return new n(url, method, z10, i11, serverIp, errorMessage, i12, httpHeaders, httpBody, j11, j12, httpProtocol);
    }

    public final long c() {
        return this.f60986k;
    }

    public final int d() {
        return this.f60982g;
    }

    public final String e() {
        return this.f60981f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return Intrinsics.c(this.f60976a, nVar.f60976a) && Intrinsics.c(this.f60977b, nVar.f60977b) && this.f60978c == nVar.f60978c && this.f60979d == nVar.f60979d && Intrinsics.c(this.f60980e, nVar.f60980e) && Intrinsics.c(this.f60981f, nVar.f60981f) && this.f60982g == nVar.f60982g && Intrinsics.c(this.f60983h, nVar.f60983h) && Intrinsics.c(this.f60984i, nVar.f60984i) && this.f60985j == nVar.f60985j && this.f60986k == nVar.f60986k && Intrinsics.c(this.f60987l, nVar.f60987l);
    }

    public final String f() {
        return this.f60984i;
    }

    public final Map g() {
        return this.f60983h;
    }

    public final String h() {
        return this.f60987l;
    }

    public int hashCode() {
        return (((((((((((((((((((((this.f60976a.hashCode() * 31) + this.f60977b.hashCode()) * 31) + androidx.compose.foundation.e.a(this.f60978c)) * 31) + this.f60979d) * 31) + this.f60980e.hashCode()) * 31) + this.f60981f.hashCode()) * 31) + this.f60982g) * 31) + this.f60983h.hashCode()) * 31) + this.f60984i.hashCode()) * 31) + s.a(this.f60985j)) * 31) + s.a(this.f60986k)) * 31) + this.f60987l.hashCode();
    }

    public final String i() {
        return this.f60977b;
    }

    public final long j() {
        return this.f60985j;
    }

    public final String k() {
        return this.f60980e;
    }

    public final int l() {
        return this.f60979d;
    }

    public final boolean m() {
        return this.f60978c;
    }

    public final String n() {
        return this.f60976a;
    }

    public String toString() {
        return "ProbeResult(url=" + this.f60976a + ", method=" + this.f60977b + ", success=" + this.f60978c + ", statusCode=" + this.f60979d + ", serverIp=" + this.f60980e + ", errorMessage=" + this.f60981f + ", errorCode=" + this.f60982g + ", httpHeaders=" + this.f60983h + ", httpBody=" + this.f60984i + ", requestTime=" + this.f60985j + ", duration=" + this.f60986k + ", httpProtocol=" + this.f60987l + ")";
    }
}
