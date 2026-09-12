package com.google.zxing.datamatrix.encoder;

import java.nio.charset.StandardCharsets;

/* loaded from: classes4.dex */
final class f {

    /* renamed from: a, reason: collision with root package name */
    private final String f32946a;

    /* renamed from: b, reason: collision with root package name */
    private SymbolShapeHint f32947b;

    /* renamed from: c, reason: collision with root package name */
    private final StringBuilder f32948c;

    /* renamed from: d, reason: collision with root package name */
    int f32949d;

    /* renamed from: e, reason: collision with root package name */
    private int f32950e;

    /* renamed from: f, reason: collision with root package name */
    private nd.d f32951f;

    /* renamed from: g, reason: collision with root package name */
    private int f32952g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.ISO_8859_1);
        StringBuilder sb2 = new StringBuilder(bytes.length);
        int length = bytes.length;
        for (int i11 = 0; i11 < length; i11++) {
            char c11 = (char) (bytes[i11] & 255);
            if (c11 == '?' && str.charAt(i11) != '?') {
                throw new IllegalArgumentException("Message contains characters outside ISO-8859-1 encoding.");
            }
            sb2.append(c11);
        }
        this.f32946a = sb2.toString();
        this.f32947b = SymbolShapeHint.FORCE_NONE;
        this.f32948c = new StringBuilder(str.length());
        this.f32950e = -1;
    }

    private int h() {
        return this.f32946a.length() - this.f32952g;
    }

    public int a() {
        return this.f32948c.length();
    }

    public StringBuilder b() {
        return this.f32948c;
    }

    public char c() {
        return this.f32946a.charAt(this.f32949d);
    }

    public String d() {
        return this.f32946a;
    }

    public int e() {
        return this.f32950e;
    }

    public int f() {
        return h() - this.f32949d;
    }

    public nd.d g() {
        return this.f32951f;
    }

    public boolean i() {
        return this.f32949d < h();
    }

    public void j() {
        this.f32950e = -1;
    }

    public void k() {
        this.f32951f = null;
    }

    public void l(com.google.zxing.c cVar, com.google.zxing.c cVar2) {
    }

    public void m(int i11) {
        this.f32952g = i11;
    }

    public void n(SymbolShapeHint symbolShapeHint) {
        this.f32947b = symbolShapeHint;
    }

    public void o(int i11) {
        this.f32950e = i11;
    }

    public void p() {
        q(a());
    }

    public void q(int i11) {
        nd.d dVar = this.f32951f;
        if (dVar == null || i11 > dVar.a()) {
            this.f32951f = nd.d.l(i11, this.f32947b, null, null, true);
        }
    }

    public void r(char c11) {
        this.f32948c.append(c11);
    }

    public void s(String str) {
        this.f32948c.append(str);
    }
}
