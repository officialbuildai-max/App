package org.brotli.dec;

import java.io.InputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class j {
    byte[] A;
    int B;
    int C;
    int D;
    int E;
    int F;
    int G;
    byte[] H;
    int I;
    int J;
    int K;
    int L;
    int M;
    int N;
    int O;
    int P;
    int U;
    int V;
    int W;
    int X;
    int Y;
    byte[] Z;

    /* renamed from: b, reason: collision with root package name */
    int f71771b;

    /* renamed from: d, reason: collision with root package name */
    byte[] f71773d;

    /* renamed from: g, reason: collision with root package name */
    int f71776g;

    /* renamed from: h, reason: collision with root package name */
    boolean f71777h;

    /* renamed from: i, reason: collision with root package name */
    boolean f71778i;

    /* renamed from: j, reason: collision with root package name */
    boolean f71779j;

    /* renamed from: w, reason: collision with root package name */
    int f71792w;

    /* renamed from: x, reason: collision with root package name */
    int f71793x;

    /* renamed from: y, reason: collision with root package name */
    int f71794y;

    /* renamed from: z, reason: collision with root package name */
    byte[] f71795z;

    /* renamed from: a, reason: collision with root package name */
    int f71770a = 0;

    /* renamed from: c, reason: collision with root package name */
    final a f71772c = new a();

    /* renamed from: e, reason: collision with root package name */
    final int[] f71774e = new int[3240];

    /* renamed from: f, reason: collision with root package name */
    final int[] f71775f = new int[3240];

    /* renamed from: k, reason: collision with root package name */
    final g f71780k = new g();

    /* renamed from: l, reason: collision with root package name */
    final g f71781l = new g();

    /* renamed from: m, reason: collision with root package name */
    final g f71782m = new g();

    /* renamed from: n, reason: collision with root package name */
    final int[] f71783n = new int[3];

    /* renamed from: o, reason: collision with root package name */
    final int[] f71784o = new int[3];

    /* renamed from: p, reason: collision with root package name */
    final int[] f71785p = new int[6];

    /* renamed from: q, reason: collision with root package name */
    final int[] f71786q = {16, 15, 11, 4};

    /* renamed from: r, reason: collision with root package name */
    int f71787r = 0;

    /* renamed from: s, reason: collision with root package name */
    int f71788s = 0;

    /* renamed from: t, reason: collision with root package name */
    int f71789t = 0;

    /* renamed from: u, reason: collision with root package name */
    boolean f71790u = false;

    /* renamed from: v, reason: collision with root package name */
    int f71791v = 0;
    int Q = 0;
    long R = 0;
    byte[] S = new byte[0];
    int T = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(j jVar) {
        int i11 = jVar.f71770a;
        if (i11 == 0) {
            throw new IllegalStateException("State MUST be initialized");
        }
        if (i11 == 11) {
            return;
        }
        jVar.f71770a = 11;
        a.b(jVar.f71772c);
    }

    private static int b(a aVar) {
        if (a.i(aVar, 1) == 0) {
            return 16;
        }
        int i11 = a.i(aVar, 3);
        if (i11 != 0) {
            return i11 + 17;
        }
        int i12 = a.i(aVar, 3);
        if (i12 != 0) {
            return i12 + 8;
        }
        return 17;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(j jVar, InputStream inputStream) {
        if (jVar.f71770a != 0) {
            throw new IllegalStateException("State MUST be uninitialized");
        }
        a.e(jVar.f71772c, inputStream);
        int b11 = b(jVar.f71772c);
        if (b11 == 9) {
            throw new BrotliRuntimeException("Invalid 'windowBits' code");
        }
        int i11 = 1 << b11;
        jVar.P = i11;
        jVar.O = i11 - 16;
        jVar.f71770a = 1;
    }
}
