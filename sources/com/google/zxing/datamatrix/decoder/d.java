package com.google.zxing.datamatrix.decoder;

import com.cloud.tmc.offline.download.model.TaskResultKt;
import com.google.zxing.FormatException;
import com.vungle.ads.internal.protos.Sdk$SDKError;

/* loaded from: classes4.dex */
public final class d {

    /* renamed from: h, reason: collision with root package name */
    private static final d[] f32919h = a();

    /* renamed from: a, reason: collision with root package name */
    private final int f32920a;

    /* renamed from: b, reason: collision with root package name */
    private final int f32921b;

    /* renamed from: c, reason: collision with root package name */
    private final int f32922c;

    /* renamed from: d, reason: collision with root package name */
    private final int f32923d;

    /* renamed from: e, reason: collision with root package name */
    private final int f32924e;

    /* renamed from: f, reason: collision with root package name */
    private final c f32925f;

    /* renamed from: g, reason: collision with root package name */
    private final int f32926g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final int f32927a;

        /* renamed from: b, reason: collision with root package name */
        private final int f32928b;

        private b(int i11, int i12) {
            this.f32927a = i11;
            this.f32928b = i12;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int a() {
            return this.f32927a;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int b() {
            return this.f32928b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        private final int f32929a;

        /* renamed from: b, reason: collision with root package name */
        private final b[] f32930b;

        private c(int i11, b bVar) {
            this.f32929a = i11;
            this.f32930b = new b[]{bVar};
        }

        private c(int i11, b bVar, b bVar2) {
            this.f32929a = i11;
            this.f32930b = new b[]{bVar, bVar2};
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b[] a() {
            return this.f32930b;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int b() {
            return this.f32929a;
        }
    }

    private d(int i11, int i12, int i13, int i14, int i15, c cVar) {
        this.f32920a = i11;
        this.f32921b = i12;
        this.f32922c = i13;
        this.f32923d = i14;
        this.f32924e = i15;
        this.f32925f = cVar;
        int b11 = cVar.b();
        int i16 = 0;
        for (b bVar : cVar.a()) {
            i16 += bVar.a() * (bVar.b() + b11);
        }
        this.f32926g = i16;
    }

    private static d[] a() {
        int i11 = 1;
        int i12 = 5;
        d dVar = new d(1, 10, 10, 8, 8, new c(i12, new b(i11, 3)));
        int i13 = 12;
        d dVar2 = new d(2, 12, 12, 10, 10, new c(7, new b(i11, i12)));
        d dVar3 = new d(3, 14, 14, 12, 12, new c(10, new b(i11, 8)));
        d dVar4 = new d(4, 16, 16, 14, 14, new c(i13, new b(i11, i13)));
        int i14 = 18;
        d dVar5 = new d(5, 18, 18, 16, 16, new c(14, new b(i11, i14)));
        d dVar6 = new d(6, 20, 20, 18, 18, new c(i14, new b(i11, 22)));
        d dVar7 = new d(7, 22, 22, 20, 20, new c(20, new b(i11, 30)));
        int i15 = 36;
        d dVar8 = new d(8, 24, 24, 22, 22, new c(24, new b(i11, i15)));
        d dVar9 = new d(9, 26, 26, 24, 24, new c(28, new b(i11, 44)));
        d dVar10 = new d(10, 32, 32, 14, 14, new c(i15, new b(i11, 62)));
        int i16 = 2;
        int i17 = 4;
        int i18 = 6;
        return new d[]{dVar, dVar2, dVar3, dVar4, dVar5, dVar6, dVar7, dVar8, dVar9, dVar10, new d(11, 36, 36, 16, 16, new c(42, new b(i11, 86))), new d(12, 40, 40, 18, 18, new c(48, new b(i11, Sdk$SDKError.Reason.ASSET_WRITE_ERROR_VALUE))), new d(13, 44, 44, 20, 20, new c(56, new b(i11, 144))), new d(14, 48, 48, 22, 22, new c(68, new b(i11, 174))), new d(15, 52, 52, 24, 24, new c(42, new b(i16, 102))), new d(16, 64, 64, 14, 14, new c(56, new b(i16, 140))), new d(17, 72, 72, 16, 16, new c(36, new b(i17, 92))), new d(18, 80, 80, 18, 18, new c(48, new b(i17, Sdk$SDKError.Reason.ASSET_WRITE_ERROR_VALUE))), new d(19, 88, 88, 20, 20, new c(56, new b(i17, 144))), new d(20, 96, 96, 22, 22, new c(68, new b(i17, 174))), new d(21, 104, 104, 24, 24, new c(56, new b(i18, Sdk$SDKError.Reason.PRIVACY_URL_ERROR_VALUE))), new d(22, 120, 120, 18, 18, new c(68, new b(i18, 175))), new d(23, Sdk$SDKError.Reason.OMSDK_DOWNLOAD_JS_ERROR_VALUE, Sdk$SDKError.Reason.OMSDK_DOWNLOAD_JS_ERROR_VALUE, 20, 20, new c(62, new b(8, 163))), new d(24, 144, 144, 22, 22, new c(62, new b(8, 156), new b(2, 155))), new d(25, 8, 18, 6, 16, new c(7, new b(1, 5))), new d(26, 8, 32, 6, 14, new c(11, new b(1, 10))), new d(27, 12, 26, 10, 24, new c(14, new b(1, 16))), new d(28, 12, 36, 10, 16, new c(18, new b(1, 22))), new d(29, 16, 36, 14, 16, new c(24, new b(1, 32))), new d(30, 16, 48, 14, 22, new c(28, new b(1, 49))), new d(31, 8, 48, 6, 22, new c(15, new b(1, 18))), new d(32, 8, 64, 6, 14, new c(18, new b(1, 24))), new d(33, 8, 80, 6, 18, new c(22, new b(1, 32))), new d(34, 8, 96, 6, 22, new c(28, new b(1, 38))), new d(35, 8, 120, 6, 18, new c(32, new b(1, 49))), new d(36, 8, 144, 6, 22, new c(36, new b(1, 63))), new d(37, 12, 64, 10, 14, new c(27, new b(1, 43))), new d(38, 12, 88, 10, 20, new c(36, new b(1, 64))), new d(39, 16, 64, 14, 14, new c(36, new b(1, 62))), new d(40, 20, 36, 18, 16, new c(28, new b(1, 44))), new d(41, 20, 44, 18, 20, new c(34, new b(1, 56))), new d(42, 20, 64, 18, 14, new c(42, new b(1, 84))), new d(43, 22, 48, 20, 22, new c(38, new b(1, 72))), new d(44, 24, 48, 22, 22, new c(41, new b(1, 80))), new d(45, 24, 64, 22, 14, new c(46, new b(1, TaskResultKt.ERROR_LOAD_RESPONSE_STR_EMPTY))), new d(46, 26, 40, 24, 18, new c(38, new b(1, 70))), new d(47, 26, 48, 24, 22, new c(42, new b(1, 90))), new d(48, 26, 64, 24, 14, new c(50, new b(1, Sdk$SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE)))};
    }

    public static d h(int i11, int i12) {
        if ((i11 & 1) != 0 || (i12 & 1) != 0) {
            throw FormatException.getFormatInstance();
        }
        for (d dVar : f32919h) {
            if (dVar.f32921b == i11 && dVar.f32922c == i12) {
                return dVar;
            }
        }
        throw FormatException.getFormatInstance();
    }

    public int b() {
        return this.f32924e;
    }

    public int c() {
        return this.f32923d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c d() {
        return this.f32925f;
    }

    public int e() {
        return this.f32922c;
    }

    public int f() {
        return this.f32921b;
    }

    public int g() {
        return this.f32926g;
    }

    public int i() {
        return this.f32920a;
    }

    public String toString() {
        return String.valueOf(this.f32920a);
    }
}
