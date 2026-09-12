package org.brotli.dec;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes7.dex */
final class a {

    /* renamed from: d, reason: collision with root package name */
    private InputStream f71738d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f71739e;

    /* renamed from: f, reason: collision with root package name */
    long f71740f;

    /* renamed from: g, reason: collision with root package name */
    int f71741g;

    /* renamed from: h, reason: collision with root package name */
    private int f71742h;

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f71735a = new byte[4160];

    /* renamed from: b, reason: collision with root package name */
    private final int[] f71736b = new int[1040];

    /* renamed from: c, reason: collision with root package name */
    private final h f71737c = new h();

    /* renamed from: i, reason: collision with root package name */
    private int f71743i = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(a aVar, boolean z10) {
        if (aVar.f71739e) {
            int i11 = ((aVar.f71742h << 2) + ((aVar.f71741g + 7) >> 3)) - 8;
            int i12 = aVar.f71743i;
            if (i11 > i12) {
                throw new BrotliRuntimeException("Read after end");
            }
            if (z10 && i11 != i12) {
                throw new BrotliRuntimeException("Unused bytes after end");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(a aVar) {
        InputStream inputStream = aVar.f71738d;
        aVar.f71738d = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(a aVar, byte[] bArr, int i11, int i12) {
        if ((aVar.f71741g & 7) != 0) {
            throw new BrotliRuntimeException("Unaligned copyBytes");
        }
        while (true) {
            int i13 = aVar.f71741g;
            if (i13 == 64 || i12 == 0) {
                break;
            }
            bArr[i11] = (byte) (aVar.f71740f >>> i13);
            aVar.f71741g = i13 + 8;
            i12--;
            i11++;
        }
        if (i12 == 0) {
            return;
        }
        int min = Math.min(f(aVar), i12 >> 2);
        if (min > 0) {
            int i14 = min << 2;
            System.arraycopy(aVar.f71735a, aVar.f71742h << 2, bArr, i11, i14);
            i11 += i14;
            i12 -= i14;
            aVar.f71742h += min;
        }
        if (i12 == 0) {
            return;
        }
        if (f(aVar) <= 0) {
            while (i12 > 0) {
                try {
                    int read = aVar.f71738d.read(bArr, i11, i12);
                    if (read == -1) {
                        throw new BrotliRuntimeException("Unexpected end of input");
                    }
                    i11 += read;
                    i12 -= read;
                } catch (IOException e11) {
                    throw new BrotliRuntimeException("Failed to read input", e11);
                }
            }
            return;
        }
        d(aVar);
        while (i12 != 0) {
            long j11 = aVar.f71740f;
            int i15 = aVar.f71741g;
            bArr[i11] = (byte) (j11 >>> i15);
            aVar.f71741g = i15 + 8;
            i12--;
            i11++;
        }
        a(aVar, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(a aVar) {
        int i11 = aVar.f71741g;
        if (i11 >= 32) {
            int[] iArr = aVar.f71736b;
            aVar.f71742h = aVar.f71742h + 1;
            aVar.f71740f = (iArr[r3] << 32) | (aVar.f71740f >>> 32);
            aVar.f71741g = i11 - 32;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(a aVar, InputStream inputStream) {
        if (aVar.f71738d != null) {
            throw new IllegalStateException("Bit reader already has associated input stream");
        }
        h.b(aVar.f71737c, aVar.f71735a, aVar.f71736b);
        aVar.f71738d = inputStream;
        aVar.f71740f = 0L;
        aVar.f71741g = 64;
        aVar.f71742h = 1024;
        aVar.f71739e = false;
        h(aVar);
    }

    static int f(a aVar) {
        return (aVar.f71739e ? (aVar.f71743i + 3) >> 2 : 1024) - aVar.f71742h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void g(a aVar) {
        int i11 = (64 - aVar.f71741g) & 7;
        if (i11 != 0 && i(aVar, i11) != 0) {
            throw new BrotliRuntimeException("Corrupted padding bits");
        }
    }

    private static void h(a aVar) {
        j(aVar);
        a(aVar, false);
        d(aVar);
        d(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i(a aVar, int i11) {
        d(aVar);
        long j11 = aVar.f71740f;
        int i12 = aVar.f71741g;
        int i13 = ((int) (j11 >>> i12)) & ((1 << i11) - 1);
        aVar.f71741g = i12 + i11;
        return i13;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0037, code lost:
    
        r4.f71739e = true;
        r4.f71743i = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003c, code lost:
    
        r1 = r1 + 3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void j(org.brotli.dec.a r4) {
        /*
            int r0 = r4.f71742h
            r1 = 1015(0x3f7, float:1.422E-42)
            if (r0 > r1) goto L7
            return
        L7:
            boolean r1 = r4.f71739e
            if (r1 == 0) goto L1b
            int r4 = f(r4)
            r0 = -2
            if (r4 < r0) goto L13
            return
        L13:
            org.brotli.dec.BrotliRuntimeException r4 = new org.brotli.dec.BrotliRuntimeException
            java.lang.String r0 = "No more input"
            r4.<init>(r0)
            throw r4
        L1b:
            int r0 = r0 << 2
            int r1 = 4096 - r0
            byte[] r2 = r4.f71735a
            r3 = 0
            java.lang.System.arraycopy(r2, r0, r2, r3, r1)
            r4.f71742h = r3
        L27:
            r0 = 4096(0x1000, float:5.74E-42)
            if (r1 >= r0) goto L4b
            java.io.InputStream r0 = r4.f71738d     // Catch: java.io.IOException -> L3f
            byte[] r2 = r4.f71735a     // Catch: java.io.IOException -> L3f
            int r3 = 4096 - r1
            int r0 = r0.read(r2, r1, r3)     // Catch: java.io.IOException -> L3f
            if (r0 > 0) goto L41
            r0 = 1
            r4.f71739e = r0     // Catch: java.io.IOException -> L3f
            r4.f71743i = r1     // Catch: java.io.IOException -> L3f
            int r1 = r1 + 3
            goto L4b
        L3f:
            r4 = move-exception
            goto L43
        L41:
            int r1 = r1 + r0
            goto L27
        L43:
            org.brotli.dec.BrotliRuntimeException r0 = new org.brotli.dec.BrotliRuntimeException
            java.lang.String r1 = "Failed to read input"
            r0.<init>(r1, r4)
            throw r0
        L4b:
            org.brotli.dec.h r4 = r4.f71737c
            int r0 = r1 >> 2
            org.brotli.dec.h.a(r4, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.brotli.dec.a.j(org.brotli.dec.a):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void k(a aVar) {
        if (aVar.f71741g == 64) {
            h(aVar);
        }
    }
}
