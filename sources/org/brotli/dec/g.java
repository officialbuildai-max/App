package org.brotli.dec;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private int f71757a;

    /* renamed from: b, reason: collision with root package name */
    int[] f71758b;

    /* renamed from: c, reason: collision with root package name */
    int[] f71759c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, a aVar) {
        int length = gVar.f71759c.length;
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            gVar.f71759c[i12] = i11;
            d.n(gVar.f71757a, gVar.f71758b, i11, aVar);
            i11 += 1080;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(g gVar, int i11, int i12) {
        gVar.f71757a = i11;
        gVar.f71758b = new int[i12 * 1080];
        gVar.f71759c = new int[i12];
    }
}
