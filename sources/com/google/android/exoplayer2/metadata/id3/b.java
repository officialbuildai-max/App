package com.google.android.exoplayer2.metadata.id3;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.d;
import com.google.android.exoplayer2.metadata.g;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.s;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class b extends g {

    /* renamed from: b, reason: collision with root package name */
    public static final a f25490b = new a() { // from class: com.google.android.exoplayer2.metadata.id3.a
        @Override // com.google.android.exoplayer2.metadata.id3.b.a
        public final boolean evaluate(int i11, int i12, int i13, int i14, int i15) {
            boolean z10;
            z10 = b.z(i11, i12, i13, i14, i15);
            return z10;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final a f25491a;

    /* loaded from: classes3.dex */
    public interface a {
        boolean evaluate(int i11, int i12, int i13, int i14, int i15);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.google.android.exoplayer2.metadata.id3.b$b, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0369b {

        /* renamed from: a, reason: collision with root package name */
        private final int f25492a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f25493b;

        /* renamed from: c, reason: collision with root package name */
        private final int f25494c;

        public C0369b(int i11, boolean z10, int i12) {
            this.f25492a = i11;
            this.f25493b = z10;
            this.f25494c = i12;
        }
    }

    public b() {
        this(null);
    }

    public b(a aVar) {
        this.f25491a = aVar;
    }

    private static int A(d0 d0Var, int i11) {
        byte[] d11 = d0Var.d();
        int e11 = d0Var.e();
        int i12 = e11;
        while (true) {
            int i13 = i12 + 1;
            if (i13 >= e11 + i11) {
                return i11;
            }
            if ((d11[i12] & 255) == 255 && d11[i13] == 0) {
                System.arraycopy(d11, i12 + 2, d11, i13, (i11 - (i12 - e11)) - 2);
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
    private static boolean B(com.google.android.exoplayer2.util.d0 r18, int r19, int r20, boolean r21) {
        /*
            r1 = r18
            r0 = r19
            int r2 = r18.e()
        L8:
            int r3 = r18.a()     // Catch: java.lang.Throwable -> L22
            r4 = 1
            r5 = r20
            if (r3 < r5) goto Lae
            r3 = 3
            r6 = 0
            if (r0 < r3) goto L25
            int r7 = r18.n()     // Catch: java.lang.Throwable -> L22
            long r8 = r18.F()     // Catch: java.lang.Throwable -> L22
            int r10 = r18.J()     // Catch: java.lang.Throwable -> L22
            goto L2f
        L22:
            r0 = move-exception
            goto Lb2
        L25:
            int r7 = r18.G()     // Catch: java.lang.Throwable -> L22
            int r8 = r18.G()     // Catch: java.lang.Throwable -> L22
            long r8 = (long) r8
            r10 = r6
        L2f:
            r11 = 0
            if (r7 != 0) goto L3d
            int r7 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r7 != 0) goto L3d
            if (r10 != 0) goto L3d
            r1.P(r2)
            return r4
        L3d:
            r7 = 4
            if (r0 != r7) goto L6e
            if (r21 != 0) goto L6e
            r13 = 8421504(0x808080, double:4.160776E-317)
            long r13 = r13 & r8
            int r11 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r11 == 0) goto L4e
            r1.P(r2)
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
            r1.P(r2)
            return r6
        L9b:
            int r3 = r18.a()     // Catch: java.lang.Throwable -> L22
            long r3 = (long) r3
            int r3 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r3 >= 0) goto La8
            r1.P(r2)
            return r6
        La8:
            int r3 = (int) r8
            r1.Q(r3)     // Catch: java.lang.Throwable -> L22
            goto L8
        Lae:
            r1.P(r2)
            return r4
        Lb2:
            r1.P(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.metadata.id3.b.B(com.google.android.exoplayer2.util.d0, int, int, boolean):boolean");
    }

    private static byte[] d(byte[] bArr, int i11, int i12) {
        return i12 <= i11 ? p0.f27685f : Arrays.copyOfRange(bArr, i11, i12);
    }

    private static ApicFrame f(d0 d0Var, int i11, int i12) {
        int y10;
        String e11;
        int D = d0Var.D();
        String v11 = v(D);
        int i13 = i11 - 1;
        byte[] bArr = new byte[i13];
        d0Var.j(bArr, 0, i13);
        if (i12 == 2) {
            e11 = "image/" + com.google.common.base.a.e(new String(bArr, 0, 3, "ISO-8859-1"));
            if ("image/jpg".equals(e11)) {
                e11 = "image/jpeg";
            }
            y10 = 2;
        } else {
            y10 = y(bArr, 0);
            e11 = com.google.common.base.a.e(new String(bArr, 0, y10, "ISO-8859-1"));
            if (e11.indexOf(47) == -1) {
                e11 = "image/" + e11;
            }
        }
        int i14 = bArr[y10 + 1] & 255;
        int i15 = y10 + 2;
        int x10 = x(bArr, i15, D);
        return new ApicFrame(e11, new String(bArr, i15, x10 - i15, v11), i14, d(bArr, x10 + u(D), i13));
    }

    private static BinaryFrame g(d0 d0Var, int i11, String str) {
        byte[] bArr = new byte[i11];
        d0Var.j(bArr, 0, i11);
        return new BinaryFrame(str, bArr);
    }

    private static ChapterFrame h(d0 d0Var, int i11, int i12, boolean z10, int i13, a aVar) {
        int e11 = d0Var.e();
        int y10 = y(d0Var.d(), e11);
        String str = new String(d0Var.d(), e11, y10 - e11, "ISO-8859-1");
        d0Var.P(y10 + 1);
        int n11 = d0Var.n();
        int n12 = d0Var.n();
        long F = d0Var.F();
        long j11 = F == 4294967295L ? -1L : F;
        long F2 = d0Var.F();
        long j12 = F2 == 4294967295L ? -1L : F2;
        ArrayList arrayList = new ArrayList();
        int i14 = e11 + i11;
        while (d0Var.e() < i14) {
            Id3Frame k11 = k(i12, d0Var, z10, i13, aVar);
            if (k11 != null) {
                arrayList.add(k11);
            }
        }
        return new ChapterFrame(str, n11, n12, j11, j12, (Id3Frame[]) arrayList.toArray(new Id3Frame[0]));
    }

    private static ChapterTocFrame i(d0 d0Var, int i11, int i12, boolean z10, int i13, a aVar) {
        int e11 = d0Var.e();
        int y10 = y(d0Var.d(), e11);
        String str = new String(d0Var.d(), e11, y10 - e11, "ISO-8859-1");
        d0Var.P(y10 + 1);
        int D = d0Var.D();
        boolean z11 = (D & 2) != 0;
        boolean z12 = (D & 1) != 0;
        int D2 = d0Var.D();
        String[] strArr = new String[D2];
        for (int i14 = 0; i14 < D2; i14++) {
            int e12 = d0Var.e();
            int y11 = y(d0Var.d(), e12);
            strArr[i14] = new String(d0Var.d(), e12, y11 - e12, "ISO-8859-1");
            d0Var.P(y11 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i15 = e11 + i11;
        while (d0Var.e() < i15) {
            Id3Frame k11 = k(i12, d0Var, z10, i13, aVar);
            if (k11 != null) {
                arrayList.add(k11);
            }
        }
        return new ChapterTocFrame(str, z11, z12, strArr, (Id3Frame[]) arrayList.toArray(new Id3Frame[0]));
    }

    private static CommentFrame j(d0 d0Var, int i11) {
        if (i11 < 4) {
            return null;
        }
        int D = d0Var.D();
        String v11 = v(D);
        byte[] bArr = new byte[3];
        d0Var.j(bArr, 0, 3);
        String str = new String(bArr, 0, 3);
        int i12 = i11 - 4;
        byte[] bArr2 = new byte[i12];
        d0Var.j(bArr2, 0, i12);
        int x10 = x(bArr2, 0, D);
        String str2 = new String(bArr2, 0, x10, v11);
        int u11 = x10 + u(D);
        return new CommentFrame(str, str2, p(bArr2, u11, x(bArr2, u11, D), v11));
    }

    /* JADX WARN: Code restructure failed: missing block: B:127:0x0190, code lost:
    
        if (r13 == 67) goto L132;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.google.android.exoplayer2.metadata.id3.Id3Frame k(int r19, com.google.android.exoplayer2.util.d0 r20, boolean r21, int r22, com.google.android.exoplayer2.metadata.id3.b.a r23) {
        /*
            Method dump skipped, instructions count: 558
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.metadata.id3.b.k(int, com.google.android.exoplayer2.util.d0, boolean, int, com.google.android.exoplayer2.metadata.id3.b$a):com.google.android.exoplayer2.metadata.id3.Id3Frame");
    }

    private static GeobFrame l(d0 d0Var, int i11) {
        int D = d0Var.D();
        String v11 = v(D);
        int i12 = i11 - 1;
        byte[] bArr = new byte[i12];
        d0Var.j(bArr, 0, i12);
        int y10 = y(bArr, 0);
        String str = new String(bArr, 0, y10, "ISO-8859-1");
        int i13 = y10 + 1;
        int x10 = x(bArr, i13, D);
        String p11 = p(bArr, i13, x10, v11);
        int u11 = x10 + u(D);
        int x11 = x(bArr, u11, D);
        return new GeobFrame(str, p11, p(bArr, u11, x11, v11), d(bArr, x11 + u(D), i12));
    }

    private static C0369b m(d0 d0Var) {
        boolean z10 = false;
        if (d0Var.a() < 10) {
            s.i("Id3Decoder", "Data too short to be an ID3 tag");
            return null;
        }
        int G = d0Var.G();
        if (G != 4801587) {
            s.i("Id3Decoder", "Unexpected first three bytes of ID3 tag header: 0x" + String.format("%06X", Integer.valueOf(G)));
            return null;
        }
        int D = d0Var.D();
        d0Var.Q(1);
        int D2 = d0Var.D();
        int C = d0Var.C();
        if (D == 2) {
            if ((D2 & 64) != 0) {
                s.i("Id3Decoder", "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                return null;
            }
        } else if (D == 3) {
            if ((D2 & 64) != 0) {
                int n11 = d0Var.n();
                d0Var.Q(n11);
                C -= n11 + 4;
            }
        } else {
            if (D != 4) {
                s.i("Id3Decoder", "Skipped ID3 tag with unsupported majorVersion=" + D);
                return null;
            }
            if ((D2 & 64) != 0) {
                int C2 = d0Var.C();
                d0Var.Q(C2 - 4);
                C -= C2;
            }
            if ((D2 & 16) != 0) {
                C -= 10;
            }
        }
        if (D < 4 && (D2 & 128) != 0) {
            z10 = true;
        }
        return new C0369b(D, z10, C);
    }

    private static MlltFrame n(d0 d0Var, int i11) {
        int J = d0Var.J();
        int G = d0Var.G();
        int G2 = d0Var.G();
        int D = d0Var.D();
        int D2 = d0Var.D();
        c0 c0Var = new c0();
        c0Var.m(d0Var);
        int i12 = ((i11 - 10) * 8) / (D + D2);
        int[] iArr = new int[i12];
        int[] iArr2 = new int[i12];
        for (int i13 = 0; i13 < i12; i13++) {
            int h11 = c0Var.h(D);
            int h12 = c0Var.h(D2);
            iArr[i13] = h11;
            iArr2[i13] = h12;
        }
        return new MlltFrame(J, G, G2, iArr, iArr2);
    }

    private static PrivFrame o(d0 d0Var, int i11) {
        byte[] bArr = new byte[i11];
        d0Var.j(bArr, 0, i11);
        int y10 = y(bArr, 0);
        return new PrivFrame(new String(bArr, 0, y10, "ISO-8859-1"), d(bArr, y10 + 1, i11));
    }

    private static String p(byte[] bArr, int i11, int i12, String str) {
        return (i12 <= i11 || i12 > bArr.length) ? "" : new String(bArr, i11, i12 - i11, str);
    }

    private static TextInformationFrame q(d0 d0Var, int i11, String str) {
        if (i11 < 1) {
            return null;
        }
        int D = d0Var.D();
        String v11 = v(D);
        int i12 = i11 - 1;
        byte[] bArr = new byte[i12];
        d0Var.j(bArr, 0, i12);
        return new TextInformationFrame(str, null, new String(bArr, 0, x(bArr, 0, D), v11));
    }

    private static TextInformationFrame r(d0 d0Var, int i11) {
        if (i11 < 1) {
            return null;
        }
        int D = d0Var.D();
        String v11 = v(D);
        int i12 = i11 - 1;
        byte[] bArr = new byte[i12];
        d0Var.j(bArr, 0, i12);
        int x10 = x(bArr, 0, D);
        String str = new String(bArr, 0, x10, v11);
        int u11 = x10 + u(D);
        return new TextInformationFrame("TXXX", str, p(bArr, u11, x(bArr, u11, D), v11));
    }

    private static UrlLinkFrame s(d0 d0Var, int i11, String str) {
        byte[] bArr = new byte[i11];
        d0Var.j(bArr, 0, i11);
        return new UrlLinkFrame(str, null, new String(bArr, 0, y(bArr, 0), "ISO-8859-1"));
    }

    private static UrlLinkFrame t(d0 d0Var, int i11) {
        if (i11 < 1) {
            return null;
        }
        int D = d0Var.D();
        String v11 = v(D);
        int i12 = i11 - 1;
        byte[] bArr = new byte[i12];
        d0Var.j(bArr, 0, i12);
        int x10 = x(bArr, 0, D);
        String str = new String(bArr, 0, x10, v11);
        int u11 = x10 + u(D);
        return new UrlLinkFrame("WXXX", str, p(bArr, u11, y(bArr, u11), "ISO-8859-1"));
    }

    private static int u(int i11) {
        return (i11 == 0 || i11 == 3) ? 1 : 2;
    }

    private static String v(int i11) {
        return i11 != 1 ? i11 != 2 ? i11 != 3 ? "ISO-8859-1" : "UTF-8" : "UTF-16BE" : C.UTF16_NAME;
    }

    private static String w(int i11, int i12, int i13, int i14, int i15) {
        return i11 == 2 ? String.format(Locale.US, "%c%c%c", Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14)) : String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14), Integer.valueOf(i15));
    }

    private static int x(byte[] bArr, int i11, int i12) {
        int y10 = y(bArr, i11);
        if (i12 == 0 || i12 == 3) {
            return y10;
        }
        while (y10 < bArr.length - 1) {
            if ((y10 - i11) % 2 == 0 && bArr[y10 + 1] == 0) {
                return y10;
            }
            y10 = y(bArr, y10 + 1);
        }
        return bArr.length;
    }

    private static int y(byte[] bArr, int i11) {
        while (i11 < bArr.length) {
            if (bArr[i11] == 0) {
                return i11;
            }
            i11++;
        }
        return bArr.length;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean z(int i11, int i12, int i13, int i14, int i15) {
        return false;
    }

    @Override // com.google.android.exoplayer2.metadata.g
    protected Metadata b(d dVar, ByteBuffer byteBuffer) {
        return e(byteBuffer.array(), byteBuffer.limit());
    }

    public Metadata e(byte[] bArr, int i11) {
        ArrayList arrayList = new ArrayList();
        d0 d0Var = new d0(bArr, i11);
        C0369b m11 = m(d0Var);
        if (m11 == null) {
            return null;
        }
        int e11 = d0Var.e();
        int i12 = m11.f25492a == 2 ? 6 : 10;
        int i13 = m11.f25494c;
        if (m11.f25493b) {
            i13 = A(d0Var, m11.f25494c);
        }
        d0Var.O(e11 + i13);
        boolean z10 = false;
        if (!B(d0Var, m11.f25492a, i12, false)) {
            if (m11.f25492a != 4 || !B(d0Var, 4, i12, true)) {
                s.i("Id3Decoder", "Failed to validate ID3 tag with majorVersion=" + m11.f25492a);
                return null;
            }
            z10 = true;
        }
        while (d0Var.a() >= i12) {
            Id3Frame k11 = k(m11.f25492a, d0Var, z10, i12, this.f25491a);
            if (k11 != null) {
                arrayList.add(k11);
            }
        }
        return new Metadata(arrayList);
    }
}
