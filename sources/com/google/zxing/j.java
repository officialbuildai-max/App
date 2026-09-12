package com.google.zxing;

import java.util.EnumMap;
import java.util.Map;

/* loaded from: classes4.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    private final String f32964a;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f32965b;

    /* renamed from: c, reason: collision with root package name */
    private final int f32966c;

    /* renamed from: d, reason: collision with root package name */
    private k[] f32967d;

    /* renamed from: e, reason: collision with root package name */
    private final BarcodeFormat f32968e;

    /* renamed from: f, reason: collision with root package name */
    private Map f32969f;

    /* renamed from: g, reason: collision with root package name */
    private final long f32970g;

    public j(String str, byte[] bArr, int i11, k[] kVarArr, BarcodeFormat barcodeFormat, long j11) {
        this.f32964a = str;
        this.f32965b = bArr;
        this.f32966c = i11;
        this.f32967d = kVarArr;
        this.f32968e = barcodeFormat;
        this.f32969f = null;
        this.f32970g = j11;
    }

    public j(String str, byte[] bArr, k[] kVarArr, BarcodeFormat barcodeFormat) {
        this(str, bArr, kVarArr, barcodeFormat, System.currentTimeMillis());
    }

    public j(String str, byte[] bArr, k[] kVarArr, BarcodeFormat barcodeFormat, long j11) {
        this(str, bArr, bArr == null ? 0 : bArr.length * 8, kVarArr, barcodeFormat, j11);
    }

    public void a(k[] kVarArr) {
        k[] kVarArr2 = this.f32967d;
        if (kVarArr2 == null) {
            this.f32967d = kVarArr;
            return;
        }
        if (kVarArr == null || kVarArr.length <= 0) {
            return;
        }
        k[] kVarArr3 = new k[kVarArr2.length + kVarArr.length];
        System.arraycopy(kVarArr2, 0, kVarArr3, 0, kVarArr2.length);
        System.arraycopy(kVarArr, 0, kVarArr3, kVarArr2.length, kVarArr.length);
        this.f32967d = kVarArr3;
    }

    public BarcodeFormat b() {
        return this.f32968e;
    }

    public byte[] c() {
        return this.f32965b;
    }

    public Map d() {
        return this.f32969f;
    }

    public k[] e() {
        return this.f32967d;
    }

    public String f() {
        return this.f32964a;
    }

    public void g(Map map) {
        if (map != null) {
            Map map2 = this.f32969f;
            if (map2 == null) {
                this.f32969f = map;
            } else {
                map2.putAll(map);
            }
        }
    }

    public void h(ResultMetadataType resultMetadataType, Object obj) {
        if (this.f32969f == null) {
            this.f32969f = new EnumMap(ResultMetadataType.class);
        }
        this.f32969f.put(resultMetadataType, obj);
    }

    public String toString() {
        return this.f32964a;
    }
}
