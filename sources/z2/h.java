package z2;

import androidx.media3.common.util.a1;
import androidx.media3.common.util.i0;
import androidx.media3.common.util.j0;
import androidx.media3.common.util.u;
import androidx.media3.common.x;
import androidx.media3.common.y;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/* loaded from: classes2.dex */
public final class h extends u2.c {

    /* renamed from: b, reason: collision with root package name */
    public static final a f79310b = new a() { // from class: z2.g
        @Override // z2.h.a
        public final boolean evaluate(int i11, int i12, int i13, int i14, int i15) {
            boolean A;
            A = h.A(i11, i12, i13, i14, i15);
            return A;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final a f79311a;

    /* loaded from: classes2.dex */
    public interface a {
        boolean evaluate(int i11, int i12, int i13, int i14, int i15);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final int f79312a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f79313b;

        /* renamed from: c, reason: collision with root package name */
        private final int f79314c;

        public b(int i11, boolean z10, int i12) {
            this.f79312a = i11;
            this.f79313b = z10;
            this.f79314c = i12;
        }
    }

    public h() {
        this(null);
    }

    public h(a aVar) {
        this.f79311a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean A(int i11, int i12, int i13, int i14, int i15) {
        return false;
    }

    private static int B(j0 j0Var, int i11) {
        byte[] e11 = j0Var.e();
        int f11 = j0Var.f();
        int i12 = f11;
        while (true) {
            int i13 = i12 + 1;
            if (i13 >= f11 + i11) {
                return i11;
            }
            if ((e11[i12] & 255) == 255 && e11[i13] == 0) {
                System.arraycopy(e11, i12 + 2, e11, i13, (i11 - (i12 - f11)) - 2);
                i11--;
            }
            i12 = i13;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0079, code lost:
    
        if ((r10 & 1) != 0) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007c, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0089, code lost:
    
        if ((r10 & 128) != 0) goto L45;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean C(androidx.media3.common.util.j0 r18, int r19, int r20, boolean r21) {
        /*
            r1 = r18
            r0 = r19
            int r2 = r18.f()
        L8:
            int r3 = r18.a()     // Catch: java.lang.Throwable -> L22
            r4 = 1
            r5 = r20
            if (r3 < r5) goto Lae
            r3 = 3
            r6 = 0
            if (r0 < r3) goto L25
            int r7 = r18.q()     // Catch: java.lang.Throwable -> L22
            long r8 = r18.J()     // Catch: java.lang.Throwable -> L22
            int r10 = r18.P()     // Catch: java.lang.Throwable -> L22
            goto L2f
        L22:
            r0 = move-exception
            goto Lb2
        L25:
            int r7 = r18.K()     // Catch: java.lang.Throwable -> L22
            int r8 = r18.K()     // Catch: java.lang.Throwable -> L22
            long r8 = (long) r8
            r10 = r6
        L2f:
            r11 = 0
            if (r7 != 0) goto L3d
            int r7 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r7 != 0) goto L3d
            if (r10 != 0) goto L3d
            r1.W(r2)
            return r4
        L3d:
            r7 = 4
            if (r0 != r7) goto L6e
            if (r21 != 0) goto L6e
            r13 = 8421504(0x808080, double:4.160776E-317)
            long r13 = r13 & r8
            int r11 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r11 == 0) goto L4e
            r1.W(r2)
            return r6
        L4e:
            r11 = 255(0xff, double:1.26E-321)
            long r13 = r8 & r11
            r15 = 8
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 7
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 16
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 14
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 24
            long r8 = r8 >> r15
            long r8 = r8 & r11
            r11 = 21
            long r8 = r8 << r11
            long r8 = r8 | r13
        L6e:
            if (r0 != r7) goto L7e
            r3 = r10 & 64
            if (r3 == 0) goto L76
            r3 = r4
            goto L77
        L76:
            r3 = r6
        L77:
            r7 = r10 & 1
            if (r7 == 0) goto L7c
            goto L8e
        L7c:
            r4 = r6
            goto L8e
        L7e:
            if (r0 != r3) goto L8c
            r3 = r10 & 32
            if (r3 == 0) goto L86
            r3 = r4
            goto L87
        L86:
            r3 = r6
        L87:
            r7 = r10 & 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L7c
            goto L8e
        L8c:
            r3 = r6
            r4 = r3
        L8e:
            if (r4 == 0) goto L92
            int r3 = r3 + 4
        L92:
            long r3 = (long) r3
            int r3 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r3 >= 0) goto L9b
            r1.W(r2)
            return r6
        L9b:
            int r3 = r18.a()     // Catch: java.lang.Throwable -> L22
            long r3 = (long) r3
            int r3 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r3 >= 0) goto La8
            r1.W(r2)
            return r6
        La8:
            int r3 = (int) r8
            r1.X(r3)     // Catch: java.lang.Throwable -> L22
            goto L8
        Lae:
            r1.W(r2)
            return r4
        Lb2:
            r1.W(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: z2.h.C(androidx.media3.common.util.j0, int, int, boolean):boolean");
    }

    private static byte[] d(byte[] bArr, int i11, int i12) {
        return i12 <= i11 ? a1.f10437f : Arrays.copyOfRange(bArr, i11, i12);
    }

    private static z2.a f(j0 j0Var, int i11, int i12) {
        int z10;
        String str;
        int H = j0Var.H();
        Charset w11 = w(H);
        int i13 = i11 - 1;
        byte[] bArr = new byte[i13];
        j0Var.l(bArr, 0, i13);
        if (i12 == 2) {
            str = "image/" + com.google.common.base.a.e(new String(bArr, 0, 3, StandardCharsets.ISO_8859_1));
            if ("image/jpg".equals(str)) {
                str = "image/jpeg";
            }
            z10 = 2;
        } else {
            z10 = z(bArr, 0);
            String e11 = com.google.common.base.a.e(new String(bArr, 0, z10, StandardCharsets.ISO_8859_1));
            if (e11.indexOf(47) == -1) {
                str = "image/" + e11;
            } else {
                str = e11;
            }
        }
        int i14 = bArr[z10 + 1] & 255;
        int i15 = z10 + 2;
        int y10 = y(bArr, i15, H);
        return new z2.a(str, new String(bArr, i15, y10 - i15, w11), i14, d(bArr, y10 + v(H), i13));
    }

    private static z2.b g(j0 j0Var, int i11, String str) {
        byte[] bArr = new byte[i11];
        j0Var.l(bArr, 0, i11);
        return new z2.b(str, bArr);
    }

    private static c h(j0 j0Var, int i11, int i12, boolean z10, int i13, a aVar) {
        int f11 = j0Var.f();
        int z11 = z(j0Var.e(), f11);
        String str = new String(j0Var.e(), f11, z11 - f11, StandardCharsets.ISO_8859_1);
        j0Var.W(z11 + 1);
        int q11 = j0Var.q();
        int q12 = j0Var.q();
        long J = j0Var.J();
        long j11 = J == 4294967295L ? -1L : J;
        long J2 = j0Var.J();
        long j12 = J2 == 4294967295L ? -1L : J2;
        ArrayList arrayList = new ArrayList();
        int i14 = f11 + i11;
        while (j0Var.f() < i14) {
            i k11 = k(i12, j0Var, z10, i13, aVar);
            if (k11 != null) {
                arrayList.add(k11);
            }
        }
        return new c(str, q11, q12, j11, j12, (i[]) arrayList.toArray(new i[0]));
    }

    private static d i(j0 j0Var, int i11, int i12, boolean z10, int i13, a aVar) {
        int f11 = j0Var.f();
        int z11 = z(j0Var.e(), f11);
        String str = new String(j0Var.e(), f11, z11 - f11, StandardCharsets.ISO_8859_1);
        j0Var.W(z11 + 1);
        int H = j0Var.H();
        boolean z12 = (H & 2) != 0;
        boolean z13 = (H & 1) != 0;
        int H2 = j0Var.H();
        String[] strArr = new String[H2];
        for (int i14 = 0; i14 < H2; i14++) {
            int f12 = j0Var.f();
            int z14 = z(j0Var.e(), f12);
            strArr[i14] = new String(j0Var.e(), f12, z14 - f12, StandardCharsets.ISO_8859_1);
            j0Var.W(z14 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i15 = f11 + i11;
        while (j0Var.f() < i15) {
            i k11 = k(i12, j0Var, z10, i13, aVar);
            if (k11 != null) {
                arrayList.add(k11);
            }
        }
        return new d(str, z12, z13, strArr, (i[]) arrayList.toArray(new i[0]));
    }

    private static e j(j0 j0Var, int i11) {
        if (i11 < 4) {
            return null;
        }
        int H = j0Var.H();
        Charset w11 = w(H);
        byte[] bArr = new byte[3];
        j0Var.l(bArr, 0, 3);
        String str = new String(bArr, 0, 3);
        int i12 = i11 - 4;
        byte[] bArr2 = new byte[i12];
        j0Var.l(bArr2, 0, i12);
        int y10 = y(bArr2, 0, H);
        String str2 = new String(bArr2, 0, y10, w11);
        int v11 = y10 + v(H);
        return new e(str, str2, p(bArr2, v11, y(bArr2, v11, H), w11));
    }

    /* JADX WARN: Code restructure failed: missing block: B:127:0x0193, code lost:
    
        if (r13 == 67) goto L136;
     */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0208  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static z2.i k(int r20, androidx.media3.common.util.j0 r21, boolean r22, int r23, z2.h.a r24) {
        /*
            Method dump skipped, instructions count: 564
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z2.h.k(int, androidx.media3.common.util.j0, boolean, int, z2.h$a):z2.i");
    }

    private static f l(j0 j0Var, int i11) {
        int H = j0Var.H();
        Charset w11 = w(H);
        int i12 = i11 - 1;
        byte[] bArr = new byte[i12];
        j0Var.l(bArr, 0, i12);
        int z10 = z(bArr, 0);
        String u11 = y.u(new String(bArr, 0, z10, StandardCharsets.ISO_8859_1));
        int i13 = z10 + 1;
        int y10 = y(bArr, i13, H);
        String p11 = p(bArr, i13, y10, w11);
        int v11 = y10 + v(H);
        int y11 = y(bArr, v11, H);
        return new f(u11, p11, p(bArr, v11, y11, w11), d(bArr, y11 + v(H), i12));
    }

    private static b m(j0 j0Var) {
        boolean z10 = false;
        if (j0Var.a() < 10) {
            u.h("Id3Decoder", "Data too short to be an ID3 tag");
            return null;
        }
        int K = j0Var.K();
        if (K != 4801587) {
            u.h("Id3Decoder", "Unexpected first three bytes of ID3 tag header: 0x" + String.format("%06X", Integer.valueOf(K)));
            return null;
        }
        int H = j0Var.H();
        j0Var.X(1);
        int H2 = j0Var.H();
        int G = j0Var.G();
        if (H == 2) {
            if ((H2 & 64) != 0) {
                u.h("Id3Decoder", "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                return null;
            }
        } else if (H == 3) {
            if ((H2 & 64) != 0) {
                int q11 = j0Var.q();
                j0Var.X(q11);
                G -= q11 + 4;
            }
        } else {
            if (H != 4) {
                u.h("Id3Decoder", "Skipped ID3 tag with unsupported majorVersion=" + H);
                return null;
            }
            if ((H2 & 64) != 0) {
                int G2 = j0Var.G();
                j0Var.X(G2 - 4);
                G -= G2;
            }
            if ((H2 & 16) != 0) {
                G -= 10;
            }
        }
        if (H < 4 && (H2 & 128) != 0) {
            z10 = true;
        }
        return new b(H, z10, G);
    }

    private static l n(j0 j0Var, int i11) {
        int P = j0Var.P();
        int K = j0Var.K();
        int K2 = j0Var.K();
        int H = j0Var.H();
        int H2 = j0Var.H();
        i0 i0Var = new i0();
        i0Var.m(j0Var);
        int i12 = ((i11 - 10) * 8) / (H + H2);
        int[] iArr = new int[i12];
        int[] iArr2 = new int[i12];
        for (int i13 = 0; i13 < i12; i13++) {
            int h11 = i0Var.h(H);
            int h12 = i0Var.h(H2);
            iArr[i13] = h11;
            iArr2[i13] = h12;
        }
        return new l(P, K, K2, iArr, iArr2);
    }

    private static m o(j0 j0Var, int i11) {
        byte[] bArr = new byte[i11];
        j0Var.l(bArr, 0, i11);
        int z10 = z(bArr, 0);
        return new m(new String(bArr, 0, z10, StandardCharsets.ISO_8859_1), d(bArr, z10 + 1, i11));
    }

    private static String p(byte[] bArr, int i11, int i12, Charset charset) {
        return (i12 <= i11 || i12 > bArr.length) ? "" : new String(bArr, i11, i12 - i11, charset);
    }

    private static n q(j0 j0Var, int i11, String str) {
        if (i11 < 1) {
            return null;
        }
        int H = j0Var.H();
        int i12 = i11 - 1;
        byte[] bArr = new byte[i12];
        j0Var.l(bArr, 0, i12);
        return new n(str, null, r(bArr, H, 0));
    }

    private static ImmutableList r(byte[] bArr, int i11, int i12) {
        if (i12 >= bArr.length) {
            return ImmutableList.of("");
        }
        ImmutableList.a builder = ImmutableList.builder();
        int y10 = y(bArr, i12, i11);
        while (i12 < y10) {
            builder.a(new String(bArr, i12, y10 - i12, w(i11)));
            i12 = v(i11) + y10;
            y10 = y(bArr, i12, i11);
        }
        ImmutableList e11 = builder.e();
        return e11.isEmpty() ? ImmutableList.of("") : e11;
    }

    private static n s(j0 j0Var, int i11) {
        if (i11 < 1) {
            return null;
        }
        int H = j0Var.H();
        int i12 = i11 - 1;
        byte[] bArr = new byte[i12];
        j0Var.l(bArr, 0, i12);
        int y10 = y(bArr, 0, H);
        return new n("TXXX", new String(bArr, 0, y10, w(H)), r(bArr, H, y10 + v(H)));
    }

    private static o t(j0 j0Var, int i11, String str) {
        byte[] bArr = new byte[i11];
        j0Var.l(bArr, 0, i11);
        return new o(str, null, new String(bArr, 0, z(bArr, 0), StandardCharsets.ISO_8859_1));
    }

    private static o u(j0 j0Var, int i11) {
        if (i11 < 1) {
            return null;
        }
        int H = j0Var.H();
        int i12 = i11 - 1;
        byte[] bArr = new byte[i12];
        j0Var.l(bArr, 0, i12);
        int y10 = y(bArr, 0, H);
        String str = new String(bArr, 0, y10, w(H));
        int v11 = y10 + v(H);
        return new o("WXXX", str, p(bArr, v11, z(bArr, v11), StandardCharsets.ISO_8859_1));
    }

    private static int v(int i11) {
        return (i11 == 0 || i11 == 3) ? 1 : 2;
    }

    private static Charset w(int i11) {
        return i11 != 1 ? i11 != 2 ? i11 != 3 ? StandardCharsets.ISO_8859_1 : StandardCharsets.UTF_8 : StandardCharsets.UTF_16BE : StandardCharsets.UTF_16;
    }

    private static String x(int i11, int i12, int i13, int i14, int i15) {
        return i11 == 2 ? String.format(Locale.US, "%c%c%c", Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14)) : String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14), Integer.valueOf(i15));
    }

    private static int y(byte[] bArr, int i11, int i12) {
        int z10 = z(bArr, i11);
        if (i12 == 0 || i12 == 3) {
            return z10;
        }
        while (z10 < bArr.length - 1) {
            if ((z10 - i11) % 2 == 0 && bArr[z10 + 1] == 0) {
                return z10;
            }
            z10 = z(bArr, z10 + 1);
        }
        return bArr.length;
    }

    private static int z(byte[] bArr, int i11) {
        while (i11 < bArr.length) {
            if (bArr[i11] == 0) {
                return i11;
            }
            i11++;
        }
        return bArr.length;
    }

    @Override // u2.c
    protected x b(u2.b bVar, ByteBuffer byteBuffer) {
        return e(byteBuffer.array(), byteBuffer.limit());
    }

    public x e(byte[] bArr, int i11) {
        ArrayList arrayList = new ArrayList();
        j0 j0Var = new j0(bArr, i11);
        b m11 = m(j0Var);
        if (m11 == null) {
            return null;
        }
        int f11 = j0Var.f();
        int i12 = m11.f79312a == 2 ? 6 : 10;
        int i13 = m11.f79314c;
        if (m11.f79313b) {
            i13 = B(j0Var, m11.f79314c);
        }
        j0Var.V(f11 + i13);
        boolean z10 = false;
        if (!C(j0Var, m11.f79312a, i12, false)) {
            if (m11.f79312a != 4 || !C(j0Var, 4, i12, true)) {
                u.h("Id3Decoder", "Failed to validate ID3 tag with majorVersion=" + m11.f79312a);
                return null;
            }
            z10 = true;
        }
        while (j0Var.a() >= i12) {
            i k11 = k(m11.f79312a, j0Var, z10, i12, this.f79311a);
            if (k11 != null) {
                arrayList.add(k11);
            }
        }
        return new x(arrayList);
    }
}
