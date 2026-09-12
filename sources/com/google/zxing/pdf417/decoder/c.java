package com.google.zxing.pdf417.decoder;

import com.google.zxing.NotFoundException;
import com.google.zxing.k;

/* loaded from: classes4.dex */
final class c {

    /* renamed from: a, reason: collision with root package name */
    private final id.b f33012a;

    /* renamed from: b, reason: collision with root package name */
    private final k f33013b;

    /* renamed from: c, reason: collision with root package name */
    private final k f33014c;

    /* renamed from: d, reason: collision with root package name */
    private final k f33015d;

    /* renamed from: e, reason: collision with root package name */
    private final k f33016e;

    /* renamed from: f, reason: collision with root package name */
    private final int f33017f;

    /* renamed from: g, reason: collision with root package name */
    private final int f33018g;

    /* renamed from: h, reason: collision with root package name */
    private final int f33019h;

    /* renamed from: i, reason: collision with root package name */
    private final int f33020i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(c cVar) {
        this.f33012a = cVar.f33012a;
        this.f33013b = cVar.f33013b;
        this.f33014c = cVar.f33014c;
        this.f33015d = cVar.f33015d;
        this.f33016e = cVar.f33016e;
        this.f33017f = cVar.f33017f;
        this.f33018g = cVar.f33018g;
        this.f33019h = cVar.f33019h;
        this.f33020i = cVar.f33020i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(id.b bVar, k kVar, k kVar2, k kVar3, k kVar4) {
        boolean z10 = kVar == null || kVar2 == null;
        boolean z11 = kVar3 == null || kVar4 == null;
        if (z10 && z11) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (z10) {
            kVar = new k(0.0f, kVar3.d());
            kVar2 = new k(0.0f, kVar4.d());
        } else if (z11) {
            kVar3 = new k(bVar.n() - 1, kVar.d());
            kVar4 = new k(bVar.n() - 1, kVar2.d());
        }
        this.f33012a = bVar;
        this.f33013b = kVar;
        this.f33014c = kVar2;
        this.f33015d = kVar3;
        this.f33016e = kVar4;
        this.f33017f = (int) Math.min(kVar.c(), kVar2.c());
        this.f33018g = (int) Math.max(kVar3.c(), kVar4.c());
        this.f33019h = (int) Math.min(kVar.d(), kVar3.d());
        this.f33020i = (int) Math.max(kVar2.d(), kVar4.d());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c j(c cVar, c cVar2) {
        return cVar == null ? cVar2 : cVar2 == null ? cVar : new c(cVar.f33012a, cVar.f33013b, cVar.f33014c, cVar2.f33015d, cVar2.f33016e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.zxing.pdf417.decoder.c a(int r13, int r14, boolean r15) {
        /*
            r12 = this;
            com.google.zxing.k r0 = r12.f33013b
            com.google.zxing.k r1 = r12.f33014c
            com.google.zxing.k r2 = r12.f33015d
            com.google.zxing.k r3 = r12.f33016e
            if (r13 <= 0) goto L2a
            if (r15 == 0) goto Le
            r4 = r0
            goto Lf
        Le:
            r4 = r2
        Lf:
            float r5 = r4.d()
            int r5 = (int) r5
            int r5 = r5 - r13
            if (r5 >= 0) goto L18
            r5 = 0
        L18:
            com.google.zxing.k r13 = new com.google.zxing.k
            float r4 = r4.c()
            float r5 = (float) r5
            r13.<init>(r4, r5)
            if (r15 == 0) goto L27
            r8 = r13
        L25:
            r10 = r2
            goto L2c
        L27:
            r10 = r13
            r8 = r0
            goto L2c
        L2a:
            r8 = r0
            goto L25
        L2c:
            if (r14 <= 0) goto L5d
            if (r15 == 0) goto L33
            com.google.zxing.k r13 = r12.f33014c
            goto L35
        L33:
            com.google.zxing.k r13 = r12.f33016e
        L35:
            float r0 = r13.d()
            int r0 = (int) r0
            int r0 = r0 + r14
            id.b r14 = r12.f33012a
            int r14 = r14.k()
            if (r0 < r14) goto L4b
            id.b r14 = r12.f33012a
            int r14 = r14.k()
            int r0 = r14 + (-1)
        L4b:
            com.google.zxing.k r14 = new com.google.zxing.k
            float r13 = r13.c()
            float r0 = (float) r0
            r14.<init>(r13, r0)
            if (r15 == 0) goto L5a
            r9 = r14
        L58:
            r11 = r3
            goto L5f
        L5a:
            r11 = r14
            r9 = r1
            goto L5f
        L5d:
            r9 = r1
            goto L58
        L5f:
            com.google.zxing.pdf417.decoder.c r13 = new com.google.zxing.pdf417.decoder.c
            id.b r7 = r12.f33012a
            r6 = r13
            r6.<init>(r7, r8, r9, r10, r11)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.c.a(int, int, boolean):com.google.zxing.pdf417.decoder.c");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k b() {
        return this.f33014c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k c() {
        return this.f33016e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.f33018g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f33020i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.f33017f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.f33019h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k h() {
        return this.f33013b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k i() {
        return this.f33015d;
    }
}
