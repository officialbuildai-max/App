package l2;

import androidx.media3.common.ParserException;
import com.google.logging.type.LogSeverity;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f68638a = {2002, 2000, 1920, 1601, 1600, 1001, 1000, 960, LogSeverity.EMERGENCY_VALUE, LogSeverity.EMERGENCY_VALUE, 480, 400, 400, 2048};

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public boolean f68639a;

        /* renamed from: b, reason: collision with root package name */
        public int f68640b;

        /* renamed from: c, reason: collision with root package name */
        public int f68641c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f68642d;

        /* renamed from: e, reason: collision with root package name */
        public int f68643e;

        /* renamed from: f, reason: collision with root package name */
        public int f68644f;

        private b() {
            this.f68639a = true;
            this.f68640b = -1;
            this.f68641c = -1;
            this.f68642d = true;
            this.f68643e = 2;
            this.f68644f = 0;
        }
    }

    /* renamed from: l2.c$c, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0852c {

        /* renamed from: a, reason: collision with root package name */
        public final int f68645a;

        /* renamed from: b, reason: collision with root package name */
        public final int f68646b;

        /* renamed from: c, reason: collision with root package name */
        public final int f68647c;

        /* renamed from: d, reason: collision with root package name */
        public final int f68648d;

        /* renamed from: e, reason: collision with root package name */
        public final int f68649e;

        private C0852c(int i11, int i12, int i13, int i14, int i15) {
            this.f68645a = i11;
            this.f68647c = i12;
            this.f68646b = i13;
            this.f68648d = i14;
            this.f68649e = i15;
        }
    }

    public static void a(int i11, androidx.media3.common.util.j0 j0Var) {
        j0Var.S(7);
        byte[] e11 = j0Var.e();
        e11[0] = -84;
        e11[1] = 64;
        e11[2] = -1;
        e11[3] = -1;
        e11[4] = (byte) ((i11 >> 16) & 255);
        e11[5] = (byte) ((i11 >> 8) & 255);
        e11[6] = (byte) (i11 & 255);
    }

    private static int b(int i11, boolean z10, int i12) {
        int c11 = c(i11);
        if (i11 != 11 && i11 != 12 && i11 != 13 && i11 != 14) {
            return c11;
        }
        if (!z10) {
            c11 -= 2;
        }
        return i12 != 0 ? i12 != 1 ? c11 : c11 - 2 : c11 - 4;
    }

    private static int c(int i11) {
        switch (i11) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 5;
            case 4:
                return 6;
            case 5:
            case 7:
            case 9:
                return 7;
            case 6:
            case 8:
            case 10:
                return 8;
            case 11:
                return 11;
            case 12:
                return 12;
            case 13:
                return 13;
            case 14:
                return 14;
            case 15:
                return 24;
            default:
                return -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:75:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0274  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.media3.common.r d(androidx.media3.common.util.j0 r18, java.lang.String r19, java.lang.String r20, androidx.media3.common.DrmInitData r21) {
        /*
            Method dump skipped, instructions count: 716
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l2.c.d(androidx.media3.common.util.j0, java.lang.String, java.lang.String, androidx.media3.common.DrmInitData):androidx.media3.common.r");
    }

    public static int e(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[16];
        int position = byteBuffer.position();
        byteBuffer.get(bArr);
        byteBuffer.position(position);
        return f(new androidx.media3.common.util.i0(bArr)).f68649e;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0080, code lost:
    
        if (r11 != 11) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0088, code lost:
    
        if (r11 != 11) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x008d, code lost:
    
        if (r11 != 8) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static l2.c.C0852c f(androidx.media3.common.util.i0 r11) {
        /*
            r0 = 16
            int r1 = r11.h(r0)
            int r0 = r11.h(r0)
            r2 = 65535(0xffff, float:9.1834E-41)
            r3 = 4
            if (r0 != r2) goto L18
            r0 = 24
            int r0 = r11.h(r0)
            r2 = 7
            goto L19
        L18:
            r2 = r3
        L19:
            int r0 = r0 + r2
            r2 = 44097(0xac41, float:6.1793E-41)
            if (r1 != r2) goto L21
            int r0 = r0 + 2
        L21:
            r8 = r0
            r0 = 2
            int r1 = r11.h(r0)
            r2 = 3
            if (r1 != r2) goto L2f
            int r4 = j(r11, r0)
            int r1 = r1 + r4
        L2f:
            r5 = r1
            r1 = 10
            int r1 = r11.h(r1)
            boolean r4 = r11.g()
            if (r4 == 0) goto L45
            int r4 = r11.h(r2)
            if (r4 <= 0) goto L45
            r11.r(r0)
        L45:
            boolean r4 = r11.g()
            r6 = 44100(0xac44, float:6.1797E-41)
            r7 = 48000(0xbb80, float:6.7262E-41)
            if (r4 == 0) goto L53
            r9 = r7
            goto L54
        L53:
            r9 = r6
        L54:
            int r11 = r11.h(r3)
            if (r9 != r6) goto L63
            r4 = 13
            if (r11 != r4) goto L63
            int[] r0 = l2.c.f68638a
            r11 = r0[r11]
            goto L91
        L63:
            if (r9 != r7) goto L90
            int[] r4 = l2.c.f68638a
            int r6 = r4.length
            if (r11 >= r6) goto L90
            r4 = r4[r11]
            int r1 = r1 % 5
            r6 = 8
            r7 = 1
            if (r1 == r7) goto L8b
            r7 = 11
            if (r1 == r0) goto L86
            if (r1 == r2) goto L8b
            if (r1 == r3) goto L7c
            goto L84
        L7c:
            if (r11 == r2) goto L82
            if (r11 == r6) goto L82
            if (r11 != r7) goto L84
        L82:
            int r4 = r4 + 1
        L84:
            r11 = r4
            goto L91
        L86:
            if (r11 == r6) goto L82
            if (r11 != r7) goto L84
            goto L82
        L8b:
            if (r11 == r2) goto L82
            if (r11 != r6) goto L84
            goto L82
        L90:
            r11 = 0
        L91:
            l2.c$c r0 = new l2.c$c
            r6 = 2
            r10 = 0
            r4 = r0
            r7 = r9
            r9 = r11
            r4.<init>(r5, r6, r7, r8, r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: l2.c.f(androidx.media3.common.util.i0):l2.c$c");
    }

    public static int g(byte[] bArr, int i11) {
        int i12 = 7;
        if (bArr.length < 7) {
            return -1;
        }
        int i13 = ((bArr[2] & 255) << 8) | (bArr[3] & 255);
        if (i13 == 65535) {
            i13 = ((bArr[4] & 255) << 16) | ((bArr[5] & 255) << 8) | (bArr[6] & 255);
        } else {
            i12 = 4;
        }
        if (i11 == 44097) {
            i12 += 2;
        }
        return i13 + i12;
    }

    private static void h(androidx.media3.common.util.i0 i0Var, b bVar) {
        int h11 = i0Var.h(5);
        i0Var.r(2);
        if (i0Var.g()) {
            i0Var.r(5);
        }
        if (h11 >= 7 && h11 <= 10) {
            i0Var.q();
        }
        if (i0Var.g()) {
            int h12 = i0Var.h(3);
            if (bVar.f68640b == -1 && h11 >= 0 && h11 <= 15 && (h12 == 0 || h12 == 1)) {
                bVar.f68640b = h11;
            }
            if (i0Var.g()) {
                l(i0Var);
            }
        }
    }

    private static void i(androidx.media3.common.util.i0 i0Var, b bVar) {
        i0Var.r(2);
        boolean g11 = i0Var.g();
        int h11 = i0Var.h(8);
        for (int i11 = 0; i11 < h11; i11++) {
            i0Var.r(2);
            if (i0Var.g()) {
                i0Var.r(5);
            }
            if (g11) {
                i0Var.r(24);
            } else {
                if (i0Var.g()) {
                    if (!i0Var.g()) {
                        i0Var.r(4);
                    }
                    bVar.f68641c = i0Var.h(6) + 1;
                }
                i0Var.r(4);
            }
        }
        if (i0Var.g()) {
            i0Var.r(3);
            if (i0Var.g()) {
                l(i0Var);
            }
        }
    }

    private static int j(androidx.media3.common.util.i0 i0Var, int i11) {
        int i12 = 0;
        while (true) {
            int h11 = i12 + i0Var.h(i11);
            if (!i0Var.g()) {
                return h11;
            }
            i12 = (h11 + 1) << i11;
        }
    }

    private static boolean k(androidx.media3.common.util.i0 i0Var) {
        if (i0Var.b() < 66) {
            return false;
        }
        i0Var.r(66);
        return true;
    }

    private static void l(androidx.media3.common.util.i0 i0Var) {
        int h11 = i0Var.h(6);
        if (h11 < 2 || h11 > 42) {
            throw ParserException.createForUnsupportedContainerFeature(String.format("Invalid language tag bytes number: %d. Must be between 2 and 42.", Integer.valueOf(h11)));
        }
        i0Var.r(h11 * 8);
    }
}
