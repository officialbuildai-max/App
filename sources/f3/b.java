package f3;

import android.util.Pair;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.ParserException;
import androidx.media3.common.i;
import androidx.media3.common.r;
import androidx.media3.common.util.a1;
import androidx.media3.common.util.i0;
import androidx.media3.common.util.j0;
import androidx.media3.common.x;
import androidx.media3.common.y;
import androidx.media3.container.d;
import androidx.media3.container.g;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Ints;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import f3.d;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import l2.e0;
import l2.f0;

/* loaded from: classes2.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f62271a = a1.u0("OpusHead");

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final long f62272a;

        /* renamed from: b, reason: collision with root package name */
        private final long f62273b;

        public a(long j11, long j12) {
            this.f62272a = j11;
            this.f62273b = j12;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f3.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0779b {

        /* renamed from: a, reason: collision with root package name */
        public final int f62274a;

        /* renamed from: b, reason: collision with root package name */
        public int f62275b;

        /* renamed from: c, reason: collision with root package name */
        public int f62276c;

        /* renamed from: d, reason: collision with root package name */
        public long f62277d;

        /* renamed from: e, reason: collision with root package name */
        private final boolean f62278e;

        /* renamed from: f, reason: collision with root package name */
        private final j0 f62279f;

        /* renamed from: g, reason: collision with root package name */
        private final j0 f62280g;

        /* renamed from: h, reason: collision with root package name */
        private int f62281h;

        /* renamed from: i, reason: collision with root package name */
        private int f62282i;

        public C0779b(j0 j0Var, j0 j0Var2, boolean z10) {
            this.f62280g = j0Var;
            this.f62279f = j0Var2;
            this.f62278e = z10;
            j0Var2.W(12);
            this.f62274a = j0Var2.L();
            j0Var.W(12);
            this.f62282i = j0Var.L();
            l2.u.a(j0Var.q() == 1, "first_chunk must be 1");
            this.f62275b = -1;
        }

        public boolean a() {
            int i11 = this.f62275b + 1;
            this.f62275b = i11;
            if (i11 == this.f62274a) {
                return false;
            }
            this.f62277d = this.f62278e ? this.f62279f.O() : this.f62279f.J();
            if (this.f62275b == this.f62281h) {
                this.f62276c = this.f62280g.L();
                this.f62280g.X(4);
                int i12 = this.f62282i - 1;
                this.f62282i = i12;
                this.f62281h = i12 > 0 ? this.f62280g.L() - 1 : -1;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        private final String f62283a;

        /* renamed from: b, reason: collision with root package name */
        private final byte[] f62284b;

        /* renamed from: c, reason: collision with root package name */
        private final long f62285c;

        /* renamed from: d, reason: collision with root package name */
        private final long f62286d;

        public c(String str, byte[] bArr, long j11, long j12) {
            this.f62283a = str;
            this.f62284b = bArr;
            this.f62285c = j11;
            this.f62286d = j12;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        private final g f62287a;

        public d(g gVar) {
            this.f62287a = gVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        private final long f62288a;

        /* renamed from: b, reason: collision with root package name */
        private final long f62289b;

        /* renamed from: c, reason: collision with root package name */
        private final String f62290c;

        public e(long j11, long j12, String str) {
            this.f62288a = j11;
            this.f62289b = j12;
            this.f62290c = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface f {
        int a();

        int getSampleCount();

        int readNextSampleSize();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class g {

        /* renamed from: a, reason: collision with root package name */
        private final boolean f62291a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f62292b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f62293c;

        public g(boolean z10, boolean z11, boolean z12) {
            this.f62291a = z10;
            this.f62292b = z11;
            this.f62293c = z12;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class h {

        /* renamed from: a, reason: collision with root package name */
        public final u[] f62294a;

        /* renamed from: b, reason: collision with root package name */
        public androidx.media3.common.r f62295b;

        /* renamed from: c, reason: collision with root package name */
        public int f62296c;

        /* renamed from: d, reason: collision with root package name */
        public int f62297d = 0;

        public h(int i11) {
            this.f62294a = new u[i11];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class i implements f {

        /* renamed from: a, reason: collision with root package name */
        private final int f62298a;

        /* renamed from: b, reason: collision with root package name */
        private final int f62299b;

        /* renamed from: c, reason: collision with root package name */
        private final j0 f62300c;

        public i(d.c cVar, androidx.media3.common.r rVar) {
            j0 j0Var = cVar.f10669b;
            this.f62300c = j0Var;
            j0Var.W(12);
            int L = j0Var.L();
            if (MimeTypes.AUDIO_RAW.equals(rVar.f10243o)) {
                int k02 = a1.k0(rVar.G, rVar.E);
                if (L == 0 || L % k02 != 0) {
                    androidx.media3.common.util.u.h("BoxParsers", "Audio sample size mismatch. stsd sample size: " + k02 + ", stsz sample size: " + L);
                    L = k02;
                }
            }
            this.f62298a = L == 0 ? -1 : L;
            this.f62299b = j0Var.L();
        }

        @Override // f3.b.f
        public int a() {
            return this.f62298a;
        }

        @Override // f3.b.f
        public int getSampleCount() {
            return this.f62299b;
        }

        @Override // f3.b.f
        public int readNextSampleSize() {
            int i11 = this.f62298a;
            return i11 == -1 ? this.f62300c.L() : i11;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class j implements f {

        /* renamed from: a, reason: collision with root package name */
        private final j0 f62301a;

        /* renamed from: b, reason: collision with root package name */
        private final int f62302b;

        /* renamed from: c, reason: collision with root package name */
        private final int f62303c;

        /* renamed from: d, reason: collision with root package name */
        private int f62304d;

        /* renamed from: e, reason: collision with root package name */
        private int f62305e;

        public j(d.c cVar) {
            j0 j0Var = cVar.f10669b;
            this.f62301a = j0Var;
            j0Var.W(12);
            this.f62303c = j0Var.L() & 255;
            this.f62302b = j0Var.L();
        }

        @Override // f3.b.f
        public int a() {
            return -1;
        }

        @Override // f3.b.f
        public int getSampleCount() {
            return this.f62302b;
        }

        @Override // f3.b.f
        public int readNextSampleSize() {
            int i11 = this.f62303c;
            if (i11 == 8) {
                return this.f62301a.H();
            }
            if (i11 == 16) {
                return this.f62301a.P();
            }
            int i12 = this.f62304d;
            this.f62304d = i12 + 1;
            if (i12 % 2 != 0) {
                return this.f62305e & 15;
            }
            int H = this.f62301a.H();
            this.f62305e = H;
            return (H & 240) >> 4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class k {

        /* renamed from: a, reason: collision with root package name */
        private final int f62306a;

        /* renamed from: b, reason: collision with root package name */
        private final long f62307b;

        /* renamed from: c, reason: collision with root package name */
        private final int f62308c;

        /* renamed from: d, reason: collision with root package name */
        private final int f62309d;

        public k(int i11, long j11, int i12, int i13) {
            this.f62306a = i11;
            this.f62307b = j11;
            this.f62308c = i12;
            this.f62309d = i13;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class l {

        /* renamed from: a, reason: collision with root package name */
        private final d f62310a;

        public l(d dVar) {
            this.f62310a = dVar;
        }

        public boolean b() {
            d dVar = this.f62310a;
            return dVar != null && dVar.f62287a.f62291a && this.f62310a.f62287a.f62292b;
        }
    }

    public static w A(t tVar, d.b bVar, e0 e0Var) {
        f jVar;
        boolean z10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        long[] jArr;
        int[] iArr;
        long[] jArr2;
        int[] iArr2;
        int i16;
        int i17;
        boolean z11;
        int i18;
        t tVar2;
        int[] iArr3;
        long[] jArr3;
        int[] iArr4;
        long j11;
        long j12;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int[] iArr5;
        long[] jArr4;
        int[] iArr6;
        int[] iArr7;
        int[] iArr8;
        int i25;
        long[] jArr5;
        int i26;
        t tVar3 = tVar;
        d.c e11 = bVar.e(1937011578);
        if (e11 != null) {
            jVar = new i(e11, tVar3.f62420g);
        } else {
            d.c e12 = bVar.e(1937013298);
            if (e12 == null) {
                throw ParserException.createForMalformedContainer("Track has no sample table size information", null);
            }
            jVar = new j(e12);
        }
        int sampleCount = jVar.getSampleCount();
        if (sampleCount == 0) {
            return new w(tVar, new long[0], new int[0], 0, new long[0], new int[0], 0L);
        }
        if (tVar3.f62415b == 2) {
            long j13 = tVar3.f62419f;
            if (j13 > 0) {
                tVar3 = tVar3.a(tVar3.f62420g.b().b0(sampleCount / (((float) j13) / 1000000.0f)).N());
            }
        }
        d.c e13 = bVar.e(1937007471);
        if (e13 == null) {
            e13 = (d.c) androidx.media3.common.util.a.e(bVar.e(1668232756));
            z10 = true;
        } else {
            z10 = false;
        }
        j0 j0Var = e13.f10669b;
        j0 j0Var2 = ((d.c) androidx.media3.common.util.a.e(bVar.e(1937011555))).f10669b;
        j0 j0Var3 = ((d.c) androidx.media3.common.util.a.e(bVar.e(1937011827))).f10669b;
        d.c e14 = bVar.e(1937011571);
        j0 j0Var4 = e14 != null ? e14.f10669b : null;
        d.c e15 = bVar.e(1668576371);
        j0 j0Var5 = e15 != null ? e15.f10669b : null;
        C0779b c0779b = new C0779b(j0Var2, j0Var, z10);
        j0Var3.W(12);
        int L = j0Var3.L() - 1;
        int L2 = j0Var3.L();
        int L3 = j0Var3.L();
        if (j0Var5 != null) {
            j0Var5.W(12);
            i11 = j0Var5.L();
        } else {
            i11 = 0;
        }
        if (j0Var4 != null) {
            j0Var4.W(12);
            i13 = j0Var4.L();
            if (i13 > 0) {
                i12 = j0Var4.L() - 1;
            } else {
                i12 = -1;
                j0Var4 = null;
            }
        } else {
            i12 = -1;
            i13 = 0;
        }
        int a11 = jVar.a();
        String str = tVar3.f62420g.f10243o;
        if (a11 != -1 && (MimeTypes.AUDIO_RAW.equals(str) || MimeTypes.AUDIO_MLAW.equals(str) || MimeTypes.AUDIO_ALAW.equals(str)) && L == 0 && i11 == 0 && i13 == 0) {
            int i27 = c0779b.f62274a;
            long[] jArr6 = new long[i27];
            int[] iArr9 = new int[i27];
            while (c0779b.a()) {
                int i28 = c0779b.f62275b;
                jArr6[i28] = c0779b.f62277d;
                iArr9[i28] = c0779b.f62276c;
            }
            d.b a12 = f3.d.a(a11, jArr6, iArr9, L3);
            jArr = a12.f62315a;
            int[] iArr10 = a12.f62316b;
            int i29 = a12.f62317c;
            long[] jArr7 = a12.f62318d;
            int[] iArr11 = a12.f62319e;
            long j14 = a12.f62320f;
            j12 = a12.f62321g;
            tVar2 = tVar3;
            iArr3 = iArr10;
            i14 = i29;
            jArr3 = jArr7;
            iArr4 = iArr11;
            j11 = j14;
        } else {
            long[] jArr8 = new long[sampleCount];
            int[] iArr12 = new int[sampleCount];
            long[] jArr9 = new long[sampleCount];
            int[] iArr13 = new int[sampleCount];
            int i30 = L;
            int i31 = i12;
            int i32 = i11;
            i14 = 0;
            int i33 = 0;
            int i34 = 0;
            int i35 = 0;
            long j15 = 0;
            long j16 = 0;
            long j17 = 0;
            t tVar4 = tVar3;
            int i36 = 0;
            while (true) {
                if (i36 >= sampleCount) {
                    i15 = i13;
                    jArr = jArr8;
                    iArr = iArr12;
                    jArr2 = jArr9;
                    iArr2 = iArr13;
                    i16 = i33;
                    i17 = i34;
                    break;
                }
                long j18 = j16;
                int i37 = i33;
                boolean z12 = true;
                while (i37 == 0) {
                    z12 = c0779b.a();
                    if (!z12) {
                        break;
                    }
                    int i38 = L3;
                    long j19 = c0779b.f62277d;
                    i37 = c0779b.f62276c;
                    j18 = j19;
                    L3 = i38;
                    i13 = i13;
                    sampleCount = sampleCount;
                }
                int i39 = sampleCount;
                int i40 = L3;
                i15 = i13;
                if (!z12) {
                    androidx.media3.common.util.u.h("BoxParsers", "Unexpected end of chunk data");
                    long[] copyOf = Arrays.copyOf(jArr8, i36);
                    int[] copyOf2 = Arrays.copyOf(iArr12, i36);
                    jArr2 = Arrays.copyOf(jArr9, i36);
                    iArr2 = Arrays.copyOf(iArr13, i36);
                    jArr = copyOf;
                    iArr = copyOf2;
                    i17 = i34;
                    sampleCount = i36;
                    i16 = i37;
                    break;
                }
                if (j0Var5 != null) {
                    while (i35 == 0 && i32 > 0) {
                        i35 = j0Var5.L();
                        i34 = j0Var5.q();
                        i32--;
                    }
                    i35--;
                }
                int i41 = i34;
                jArr8[i36] = j18;
                int readNextSampleSize = jVar.readNextSampleSize();
                iArr12[i36] = readNextSampleSize;
                C0779b c0779b2 = c0779b;
                f fVar = jVar;
                j17 += readNextSampleSize;
                if (readNextSampleSize > i14) {
                    i14 = readNextSampleSize;
                }
                jArr9[i36] = j15 + i41;
                iArr13[i36] = j0Var4 == null ? 1 : 0;
                if (i36 == i31) {
                    iArr13[i36] = 1;
                    i22 = i15 - 1;
                    if (i22 > 0) {
                        i31 = ((j0) androidx.media3.common.util.a.e(j0Var4)).L() - 1;
                    }
                    i19 = i31;
                    i20 = i41;
                    i21 = i40;
                } else {
                    i19 = i31;
                    i20 = i41;
                    i21 = i40;
                    i22 = i15;
                }
                j15 += i21;
                L2--;
                if (L2 != 0 || i30 <= 0) {
                    i23 = i21;
                    i24 = i30;
                } else {
                    int L4 = j0Var3.L();
                    i23 = j0Var3.q();
                    i24 = i30 - 1;
                    L2 = L4;
                }
                int i42 = i23;
                long j20 = j18 + iArr12[i36];
                i33 = i37 - 1;
                i36++;
                j16 = j20;
                i34 = i20;
                i31 = i19;
                sampleCount = i39;
                c0779b = c0779b2;
                int i43 = i24;
                L3 = i42;
                i30 = i43;
                i13 = i22;
                jVar = fVar;
            }
            long j21 = j15 + i17;
            if (j0Var5 != null) {
                while (i32 > 0) {
                    if (j0Var5.L() != 0) {
                        z11 = false;
                        break;
                    }
                    j0Var5.q();
                    i32--;
                }
            }
            z11 = true;
            if (i15 == 0 && L2 == 0 && i16 == 0 && i30 == 0) {
                i18 = i35;
                if (i18 == 0 && z11) {
                    tVar2 = tVar4;
                    iArr3 = iArr;
                    jArr3 = jArr2;
                    iArr4 = iArr2;
                    j11 = j21;
                    j12 = j17;
                }
            } else {
                i18 = i35;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Inconsistent stbl box for track ");
            tVar2 = tVar4;
            sb2.append(tVar2.f62414a);
            sb2.append(": remainingSynchronizationSamples ");
            sb2.append(i15);
            sb2.append(", remainingSamplesAtTimestampDelta ");
            sb2.append(L2);
            sb2.append(", remainingSamplesInChunk ");
            sb2.append(i16);
            sb2.append(", remainingTimestampDeltaChanges ");
            sb2.append(i30);
            sb2.append(", remainingSamplesAtTimestampOffset ");
            sb2.append(i18);
            sb2.append(!z11 ? ", ctts invalid" : "");
            androidx.media3.common.util.u.h("BoxParsers", sb2.toString());
            iArr3 = iArr;
            jArr3 = jArr2;
            iArr4 = iArr2;
            j11 = j21;
            j12 = j17;
        }
        long j22 = tVar2.f62419f;
        if (j22 > 0) {
            long g12 = a1.g1(j12 * 8, 1000000L, j22, RoundingMode.HALF_DOWN);
            if (g12 > 0 && g12 < 2147483647L) {
                tVar2 = tVar2.a(tVar2.f62420g.b().Q((int) g12).N());
            }
        }
        int[] iArr14 = iArr4;
        long e16 = a1.e1(j11, 1000000L, tVar2.f62416c);
        long[] jArr10 = tVar2.f62422i;
        if (jArr10 == null) {
            a1.f1(jArr3, 1000000L, tVar2.f62416c);
            return new w(tVar2, jArr, iArr3, i14, jArr3, iArr14, e16);
        }
        if (jArr10.length == 1 && tVar2.f62415b == 1 && jArr3.length >= 2) {
            long j23 = ((long[]) androidx.media3.common.util.a.e(tVar2.f62423j))[0];
            iArr5 = iArr14;
            long e17 = a1.e1(tVar2.f62422i[0], tVar2.f62416c, tVar2.f62417d) + j23;
            if (b(jArr3, j11, j23, e17)) {
                long j24 = j11 - e17;
                long e18 = a1.e1(j23 - jArr3[0], tVar2.f62420g.F, tVar2.f62416c);
                long e19 = a1.e1(j24, tVar2.f62420g.F, tVar2.f62416c);
                if ((e18 != 0 || e19 != 0) && e18 <= 2147483647L && e19 <= 2147483647L) {
                    e0Var.f68688a = (int) e18;
                    e0Var.f68689b = (int) e19;
                    a1.f1(jArr3, 1000000L, tVar2.f62416c);
                    return new w(tVar2, jArr, iArr3, i14, jArr3, iArr5, a1.e1(tVar2.f62422i[0], 1000000L, tVar2.f62417d));
                }
            }
        } else {
            iArr5 = iArr14;
        }
        long[] jArr11 = tVar2.f62422i;
        if (jArr11.length == 1 && jArr11[0] == 0) {
            long j25 = ((long[]) androidx.media3.common.util.a.e(tVar2.f62423j))[0];
            for (int i44 = 0; i44 < jArr3.length; i44++) {
                jArr3[i44] = a1.e1(jArr3[i44] - j25, 1000000L, tVar2.f62416c);
            }
            return new w(tVar2, jArr, iArr3, i14, jArr3, iArr5, a1.e1(j11 - j25, 1000000L, tVar2.f62416c));
        }
        boolean z13 = tVar2.f62415b == 1;
        int[] iArr15 = new int[jArr11.length];
        int[] iArr16 = new int[jArr11.length];
        long[] jArr12 = (long[]) androidx.media3.common.util.a.e(tVar2.f62423j);
        boolean z14 = false;
        int i45 = 0;
        int i46 = 0;
        int i47 = 0;
        while (true) {
            long[] jArr13 = tVar2.f62422i;
            if (i45 >= jArr13.length) {
                break;
            }
            int i48 = i14;
            long j26 = jArr12[i45];
            if (j26 != -1) {
                long j27 = jArr13[i45];
                iArr8 = iArr3;
                i25 = sampleCount;
                jArr5 = jArr12;
                boolean z15 = z14;
                long e110 = a1.e1(j27, tVar2.f62416c, tVar2.f62417d);
                iArr15[i45] = a1.h(jArr3, j26, true, true);
                long j28 = j26 + e110;
                iArr16[i45] = a1.d(jArr3, j28, z13, false);
                int i49 = iArr15[i45];
                while (true) {
                    i26 = iArr15[i45];
                    if (i26 < 0 || (iArr5[i26] & 1) != 0) {
                        break;
                    }
                    iArr15[i45] = i26 - 1;
                }
                if (i26 < 0) {
                    iArr15[i45] = i49;
                    while (true) {
                        int i50 = iArr15[i45];
                        if (i50 >= iArr16[i45] || (iArr5[i50] & 1) != 0) {
                            break;
                        }
                        iArr15[i45] = i50 + 1;
                    }
                }
                if (tVar2.f62415b == 2 && iArr15[i45] != iArr16[i45]) {
                    while (true) {
                        int i51 = iArr16[i45];
                        if (i51 >= jArr3.length - 1 || jArr3[i51 + 1] > j28) {
                            break;
                        }
                        iArr16[i45] = i51 + 1;
                    }
                }
                int i52 = iArr16[i45];
                int i53 = iArr15[i45];
                i46 += i52 - i53;
                z14 = z15 | (i47 != i53);
                i47 = i52;
            } else {
                iArr8 = iArr3;
                i25 = sampleCount;
                jArr5 = jArr12;
            }
            i45++;
            jArr12 = jArr5;
            iArr3 = iArr8;
            i14 = i48;
            sampleCount = i25;
        }
        int[] iArr17 = iArr3;
        int i54 = i14;
        int i55 = 0;
        boolean z16 = z14 | (i46 != sampleCount);
        long[] jArr14 = z16 ? new long[i46] : jArr;
        int[] iArr18 = z16 ? new int[i46] : iArr17;
        int i56 = z16 ? 0 : i54;
        int[] iArr19 = z16 ? new int[i46] : iArr5;
        long[] jArr15 = new long[i46];
        boolean z17 = false;
        int i57 = 0;
        int i58 = i56;
        long j29 = 0;
        while (i55 < tVar2.f62422i.length) {
            long j30 = tVar2.f62423j[i55];
            int i59 = iArr15[i55];
            int[] iArr20 = iArr15;
            int i60 = iArr16[i55];
            if (z16) {
                iArr6 = iArr16;
                int i61 = i60 - i59;
                System.arraycopy(jArr, i59, jArr14, i57, i61);
                System.arraycopy(iArr17, i59, iArr18, i57, i61);
                jArr4 = jArr;
                iArr7 = iArr5;
                System.arraycopy(iArr7, i59, iArr19, i57, i61);
            } else {
                jArr4 = jArr;
                iArr6 = iArr16;
                iArr7 = iArr5;
            }
            boolean z18 = z17;
            iArr5 = iArr7;
            int i62 = i58;
            while (i59 < i60) {
                int i63 = i60;
                int i64 = i55;
                long e111 = a1.e1(j29, 1000000L, tVar2.f62417d);
                long j31 = j29;
                long e112 = a1.e1(jArr3[i59] - j30, 1000000L, tVar2.f62416c);
                if (e112 < 0) {
                    z18 = true;
                }
                jArr15[i57] = e111 + e112;
                if (z16 && iArr18[i57] > i62) {
                    i62 = iArr17[i59];
                }
                i57++;
                i59++;
                j29 = j31;
                i55 = i64;
                i60 = i63;
            }
            int i65 = i55;
            j29 += tVar2.f62422i[i65];
            i55 = i65 + 1;
            i58 = i62;
            z17 = z18;
            iArr15 = iArr20;
            iArr16 = iArr6;
            jArr = jArr4;
        }
        long e113 = a1.e1(j29, 1000000L, tVar2.f62417d);
        if (z17) {
            tVar2 = tVar2.a(tVar2.f62420g.b().c0(true).N());
        }
        return new w(tVar2, jArr14, iArr18, i58, jArr15, iArr19, e113);
    }

    private static d B(j0 j0Var, int i11, int i12) {
        j0Var.W(i11 + 8);
        int f11 = j0Var.f();
        while (f11 - i11 < i12) {
            j0Var.W(f11);
            int q11 = j0Var.q();
            l2.u.a(q11 > 0, "childAtomSize must be positive");
            if (j0Var.q() == 1937011305) {
                j0Var.X(4);
                int H = j0Var.H();
                return new d(new g((H & 1) == 1, (H & 2) == 2, (H & 8) == 8));
            }
            f11 += q11;
        }
        return null;
    }

    private static h C(j0 j0Var, int i11, int i12, String str, DrmInitData drmInitData, boolean z10) {
        int i13;
        j0Var.W(12);
        int q11 = j0Var.q();
        h hVar = new h(q11);
        for (int i14 = 0; i14 < q11; i14++) {
            int f11 = j0Var.f();
            int q12 = j0Var.q();
            l2.u.a(q12 > 0, "childAtomSize must be positive");
            int q13 = j0Var.q();
            if (q13 == 1635148593 || q13 == 1635148595 || q13 == 1701733238 || q13 == 1831958048 || q13 == 1836070006 || q13 == 1752589105 || q13 == 1751479857 || q13 == 1932670515 || q13 == 1211250227 || q13 == 1748121139 || q13 == 1987063864 || q13 == 1987063865 || q13 == 1635135537 || q13 == 1685479798 || q13 == 1685479729 || q13 == 1685481573 || q13 == 1685481521 || q13 == 1634760241) {
                i13 = f11;
                K(j0Var, q13, i13, q12, i11, str, i12, drmInitData, hVar, i14);
            } else if (q13 == 1836069985 || q13 == 1701733217 || q13 == 1633889587 || q13 == 1700998451 || q13 == 1633889588 || q13 == 1835823201 || q13 == 1685353315 || q13 == 1685353317 || q13 == 1685353320 || q13 == 1685353324 || q13 == 1685353336 || q13 == 1935764850 || q13 == 1935767394 || q13 == 1819304813 || q13 == 1936684916 || q13 == 1953984371 || q13 == 778924082 || q13 == 778924083 || q13 == 1835557169 || q13 == 1835560241 || q13 == 1634492771 || q13 == 1634492791 || q13 == 1970037111 || q13 == 1332770163 || q13 == 1716281667 || q13 == 1767992678) {
                i13 = f11;
                h(j0Var, q13, f11, q12, i11, str, z10, drmInitData, hVar, i14);
            } else {
                if (q13 == 1414810956 || q13 == 1954034535 || q13 == 2004251764 || q13 == 1937010800 || q13 == 1664495672) {
                    D(j0Var, q13, f11, q12, i11, str, hVar);
                } else if (q13 == 1835365492) {
                    u(j0Var, q13, f11, i11, hVar);
                } else if (q13 == 1667329389) {
                    hVar.f62295b = new r.b().e0(i11).u0(MimeTypes.APPLICATION_CAMERA_MOTION).N();
                }
                i13 = f11;
            }
            j0Var.W(i13 + q12);
        }
        return hVar;
    }

    private static void D(j0 j0Var, int i11, int i12, int i13, int i14, String str, h hVar) {
        j0Var.W(i12 + 16);
        String str2 = MimeTypes.APPLICATION_TTML;
        ImmutableList immutableList = null;
        long j11 = Long.MAX_VALUE;
        if (i11 != 1414810956) {
            if (i11 == 1954034535) {
                int i15 = i13 - 16;
                byte[] bArr = new byte[i15];
                j0Var.l(bArr, 0, i15);
                immutableList = ImmutableList.of(bArr);
                str2 = MimeTypes.APPLICATION_TX3G;
            } else if (i11 == 2004251764) {
                str2 = MimeTypes.APPLICATION_MP4VTT;
            } else if (i11 == 1937010800) {
                j11 = 0;
            } else {
                if (i11 != 1664495672) {
                    throw new IllegalStateException();
                }
                hVar.f62297d = 1;
                str2 = MimeTypes.APPLICATION_MP4CEA608;
            }
        }
        hVar.f62295b = new r.b().e0(i14).u0(str2).j0(str).y0(j11).g0(immutableList).N();
    }

    private static k E(j0 j0Var) {
        long j11;
        j0Var.W(8);
        int p11 = p(j0Var.q());
        j0Var.X(p11 == 0 ? 8 : 16);
        int q11 = j0Var.q();
        j0Var.X(4);
        int f11 = j0Var.f();
        int i11 = p11 == 0 ? 4 : 8;
        int i12 = 0;
        while (true) {
            j11 = C.TIME_UNSET;
            if (i12 >= i11) {
                j0Var.X(i11);
                break;
            }
            if (j0Var.e()[f11 + i12] != -1) {
                long J = p11 == 0 ? j0Var.J() : j0Var.O();
                if (J != 0) {
                    j11 = J;
                }
            } else {
                i12++;
            }
        }
        j0Var.X(10);
        int P = j0Var.P();
        j0Var.X(4);
        int q12 = j0Var.q();
        int q13 = j0Var.q();
        j0Var.X(4);
        int q14 = j0Var.q();
        int q15 = j0Var.q();
        return new k(q11, j11, P, (q12 == 0 && q13 == 65536 && q14 == -65536 && q15 == 0) ? 90 : (q12 == 0 && q13 == -65536 && q14 == 65536 && q15 == 0) ? 270 : (q12 == -65536 && q13 == 0 && q14 == 0 && q15 == -65536) ? 180 : 0);
    }

    public static t F(d.b bVar, d.c cVar, long j11, DrmInitData drmInitData, boolean z10, boolean z11) {
        d.c cVar2;
        long j12;
        long[] jArr;
        long[] jArr2;
        androidx.media3.common.r rVar;
        d.b d11;
        Pair l11;
        d.b bVar2 = (d.b) androidx.media3.common.util.a.e(bVar.d(1835297121));
        int e11 = e(q(((d.c) androidx.media3.common.util.a.e(bVar2.e(1751411826))).f10669b));
        if (e11 == -1) {
            return null;
        }
        k E = E(((d.c) androidx.media3.common.util.a.e(bVar.e(1953196132))).f10669b);
        long j13 = C.TIME_UNSET;
        if (j11 == C.TIME_UNSET) {
            cVar2 = cVar;
            j12 = E.f62307b;
        } else {
            cVar2 = cVar;
            j12 = j11;
        }
        long j14 = v(cVar2.f10669b).f10674c;
        if (j12 != C.TIME_UNSET) {
            j13 = a1.e1(j12, 1000000L, j14);
        }
        long j15 = j13;
        d.b bVar3 = (d.b) androidx.media3.common.util.a.e(((d.b) androidx.media3.common.util.a.e(bVar2.d(1835626086))).d(1937007212));
        e s11 = s(((d.c) androidx.media3.common.util.a.e(bVar2.e(1835296868))).f10669b);
        d.c e12 = bVar3.e(1937011556);
        if (e12 == null) {
            throw ParserException.createForMalformedContainer("Malformed sample table (stbl) missing sample description (stsd)", null);
        }
        h C = C(e12.f10669b, E.f62306a, E.f62309d, s11.f62290c, drmInitData, z11);
        if (z10 || (d11 = bVar.d(1701082227)) == null || (l11 = l(d11)) == null) {
            jArr = null;
            jArr2 = null;
        } else {
            long[] jArr3 = (long[]) l11.first;
            jArr2 = (long[]) l11.second;
            jArr = jArr3;
        }
        if (C.f62295b == null) {
            return null;
        }
        if (E.f62308c != 0) {
            androidx.media3.container.c cVar3 = new androidx.media3.container.c(E.f62308c);
            r.b b11 = C.f62295b.b();
            androidx.media3.common.x xVar = C.f62295b.f10240l;
            rVar = b11.n0(xVar != null ? xVar.a(cVar3) : new androidx.media3.common.x(cVar3)).N();
        } else {
            rVar = C.f62295b;
        }
        return new t(E.f62306a, e11, s11.f62288a, j14, j15, s11.f62289b, rVar, C.f62297d, C.f62294a, C.f62296c, jArr, jArr2);
    }

    public static List G(d.b bVar, e0 e0Var, long j11, DrmInitData drmInitData, boolean z10, boolean z11, com.google.common.base.f fVar) {
        t tVar;
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < bVar.f10668d.size(); i11++) {
            d.b bVar2 = (d.b) bVar.f10668d.get(i11);
            if (bVar2.f10665a == 1953653099 && (tVar = (t) fVar.apply(F(bVar2, (d.c) androidx.media3.common.util.a.e(bVar.e(1836476516)), j11, drmInitData, z10, z11))) != null) {
                arrayList.add(A(tVar, (d.b) androidx.media3.common.util.a.e(((d.b) androidx.media3.common.util.a.e(((d.b) androidx.media3.common.util.a.e(bVar2.d(1835297121))).d(1835626086))).d(1937007212)), e0Var));
            }
        }
        return arrayList;
    }

    public static androidx.media3.common.x H(d.c cVar) {
        j0 j0Var = cVar.f10669b;
        j0Var.W(8);
        androidx.media3.common.x xVar = new androidx.media3.common.x(new x.a[0]);
        while (j0Var.a() >= 8) {
            int f11 = j0Var.f();
            int q11 = j0Var.q();
            int q12 = j0Var.q();
            if (q12 == 1835365473) {
                j0Var.W(f11);
                xVar = xVar.b(I(j0Var, f11 + q11));
            } else if (q12 == 1936553057) {
                j0Var.W(f11);
                xVar = xVar.b(r.b(j0Var, f11 + q11));
            } else if (q12 == -1451722374) {
                xVar = xVar.b(L(j0Var));
            }
            j0Var.W(f11 + q11);
        }
        return xVar;
    }

    private static androidx.media3.common.x I(j0 j0Var, int i11) {
        j0Var.X(8);
        f(j0Var);
        while (j0Var.f() < i11) {
            int f11 = j0Var.f();
            int q11 = j0Var.q();
            if (j0Var.q() == 1768715124) {
                j0Var.W(f11);
                return r(j0Var, f11 + q11);
            }
            j0Var.W(f11 + q11);
        }
        return null;
    }

    static l J(j0 j0Var, int i11, int i12) {
        j0Var.W(i11 + 8);
        int f11 = j0Var.f();
        d dVar = null;
        while (f11 - i11 < i12) {
            j0Var.W(f11);
            int q11 = j0Var.q();
            l2.u.a(q11 > 0, "childAtomSize must be positive");
            if (j0Var.q() == 1702454643) {
                dVar = B(j0Var, f11, q11);
            }
            f11 += q11;
        }
        if (dVar == null) {
            return null;
        }
        return new l(dVar);
    }

    private static void K(j0 j0Var, int i11, int i12, int i13, int i14, String str, int i15, DrmInitData drmInitData, h hVar, int i16) {
        String str2;
        DrmInitData drmInitData2;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        float f11;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26 = i12;
        int i27 = i13;
        DrmInitData drmInitData3 = drmInitData;
        h hVar2 = hVar;
        j0Var.W(i26 + 16);
        j0Var.X(16);
        int P = j0Var.P();
        int P2 = j0Var.P();
        j0Var.X(50);
        int f12 = j0Var.f();
        int i28 = i11;
        if (i28 == 1701733238) {
            Pair y10 = y(j0Var, i26, i27);
            if (y10 != null) {
                i28 = ((Integer) y10.first).intValue();
                drmInitData3 = drmInitData3 == null ? null : drmInitData3.copyWithSchemeType(((u) y10.second).f62427b);
                hVar2.f62294a[i16] = (u) y10.second;
            }
            j0Var.W(f12);
        }
        String str3 = MimeTypes.VIDEO_H263;
        String str4 = i28 == 1831958048 ? MimeTypes.VIDEO_MPEG : i28 == 1211250227 ? MimeTypes.VIDEO_H263 : null;
        float f13 = 1.0f;
        int i29 = 8;
        int i30 = 8;
        List list = null;
        String str5 = null;
        byte[] bArr = null;
        int i31 = -1;
        int i32 = -1;
        int i33 = -1;
        int i34 = -1;
        int i35 = -1;
        int i36 = -1;
        ByteBuffer byteBuffer = null;
        a aVar = null;
        c cVar = null;
        g.k kVar = null;
        boolean z10 = false;
        while (f12 - i26 < i27) {
            j0Var.W(f12);
            int f14 = j0Var.f();
            int q11 = j0Var.q();
            if (q11 == 0) {
                str2 = str3;
                if (j0Var.f() - i26 == i27) {
                    break;
                }
            } else {
                str2 = str3;
            }
            l2.u.a(q11 > 0, "childAtomSize must be positive");
            int q12 = j0Var.q();
            if (q12 == 1635148611) {
                l2.u.a(str4 == null, null);
                j0Var.W(f14 + 8);
                l2.d b11 = l2.d.b(j0Var);
                List list2 = b11.f68651a;
                hVar2.f62296c = b11.f68652b;
                if (!z10) {
                    f13 = b11.f68661k;
                }
                String str6 = b11.f68662l;
                int i37 = b11.f68660j;
                int i38 = b11.f68657g;
                int i39 = b11.f68658h;
                int i40 = b11.f68659i;
                int i41 = b11.f68655e;
                int i42 = b11.f68656f;
                drmInitData2 = drmInitData3;
                i19 = P2;
                i20 = i28;
                i32 = i37;
                i35 = i39;
                i36 = i40;
                i29 = i41;
                list = list2;
                str4 = MimeTypes.VIDEO_H264;
                str5 = str6;
                i17 = i38;
                i30 = i42;
            } else {
                if (q12 == 1752589123) {
                    l2.u.a(str4 == null, null);
                    j0Var.W(f14 + 8);
                    f0 a11 = f0.a(j0Var);
                    List list3 = a11.f68690a;
                    hVar2.f62296c = a11.f68691b;
                    if (!z10) {
                        f13 = a11.f68701l;
                    }
                    int i43 = a11.f68702m;
                    int i44 = a11.f68692c;
                    String str7 = a11.f68703n;
                    int i45 = a11.f68700k;
                    list = list3;
                    if (i45 != -1) {
                        i31 = i45;
                    }
                    int i46 = a11.f68697h;
                    int i47 = a11.f68698i;
                    int i48 = a11.f68699j;
                    int i49 = a11.f68695f;
                    int i50 = a11.f68696g;
                    kVar = a11.f68704o;
                    drmInitData2 = drmInitData3;
                    i19 = P2;
                    i20 = i28;
                    i35 = i47;
                    i36 = i48;
                    i29 = i49;
                    i32 = i43;
                    str4 = MimeTypes.VIDEO_H265;
                    i33 = i44;
                    i17 = i46;
                    str5 = str7;
                    i30 = i50;
                } else {
                    drmInitData2 = drmInitData3;
                    if (q12 == 1818785347) {
                        l2.u.a(MimeTypes.VIDEO_H265.equals(str4), "lhvC must follow hvcC atom");
                        g.k kVar2 = kVar;
                        l2.u.a(kVar2 != null && kVar2.f10728b.size() >= 2, "must have at least two layers");
                        j0Var.W(f14 + 8);
                        f0 c11 = f0.c(j0Var, (g.k) androidx.media3.common.util.a.e(kVar2));
                        l2.u.a(hVar2.f62296c == c11.f68691b, "nalUnitLengthFieldLength must be same for both hvcC and lhvC atoms");
                        int i51 = c11.f68697h;
                        i17 = i34;
                        if (i51 != -1) {
                            l2.u.a(i17 == i51, "colorSpace must be the same for both views");
                        }
                        int i52 = c11.f68698i;
                        int i53 = i35;
                        if (i52 != -1) {
                            l2.u.a(i53 == i52, "colorRange must be the same for both views");
                        }
                        int i54 = c11.f68699j;
                        if (i54 != -1) {
                            int i55 = i36;
                            i25 = i55;
                            l2.u.a(i55 == i54, "colorTransfer must be the same for both views");
                        } else {
                            i25 = i36;
                        }
                        l2.u.a(i29 == c11.f68695f, "bitdepthLuma must be the same for both views");
                        l2.u.a(i30 == c11.f68696g, "bitdepthChroma must be the same for both views");
                        List list4 = list;
                        if (list4 != null) {
                            list = ImmutableList.builder().l(list4).l(c11.f68690a).e();
                        } else {
                            list = list4;
                            l2.u.a(false, "initializationData must be already set from hvcC atom");
                        }
                        kVar = kVar2;
                        str4 = "video/mv-hevc";
                        i19 = P2;
                        i20 = i28;
                        i35 = i53;
                        i36 = i25;
                        str5 = c11.f68703n;
                    } else {
                        List list5 = list;
                        i17 = i34;
                        int i56 = i35;
                        int i57 = i36;
                        g.k kVar3 = kVar;
                        if (q12 == 1986361461) {
                            l J = J(j0Var, f14, q11);
                            if (J != null && J.f62310a != null) {
                                if (kVar3 == null || kVar3.f10728b.size() < 2) {
                                    i24 = i31;
                                    if (i24 == -1) {
                                        i31 = J.f62310a.f62287a.f62293c ? 5 : 4;
                                        kVar = kVar3;
                                        i19 = P2;
                                        i20 = i28;
                                        list = list5;
                                        i35 = i56;
                                        i36 = i57;
                                    }
                                    i31 = i24;
                                    kVar = kVar3;
                                    i19 = P2;
                                    i20 = i28;
                                    list = list5;
                                    i35 = i56;
                                    i36 = i57;
                                } else {
                                    l2.u.a(J.b(), "both eye views must be marked as available");
                                    l2.u.a(!J.f62310a.f62287a.f62293c, "for MV-HEVC, eye_views_reversed must be set to false");
                                }
                            }
                            i24 = i31;
                            i31 = i24;
                            kVar = kVar3;
                            i19 = P2;
                            i20 = i28;
                            list = list5;
                            i35 = i56;
                            i36 = i57;
                        } else {
                            int i58 = i31;
                            if (q12 == 1685480259 || q12 == 1685485123) {
                                i18 = i58;
                                i19 = P2;
                                i20 = i28;
                                i21 = i30;
                                f11 = f13;
                                i22 = i29;
                                i23 = i57;
                                l2.o a12 = l2.o.a(j0Var);
                                if (a12 != null) {
                                    str4 = "video/dolby-vision";
                                    str5 = a12.f68777c;
                                }
                            } else if (q12 == 1987076931) {
                                l2.u.a(str4 == null, null);
                                String str8 = i28 == 1987063864 ? MimeTypes.VIDEO_VP8 : MimeTypes.VIDEO_VP9;
                                j0Var.W(f14 + 12);
                                byte H = (byte) j0Var.H();
                                byte H2 = (byte) j0Var.H();
                                int H3 = j0Var.H();
                                i30 = H3 >> 4;
                                byte b12 = (byte) ((H3 >> 1) & 7);
                                if (str8.equals(MimeTypes.VIDEO_VP9)) {
                                    list5 = androidx.media3.common.util.j.h(H, H2, (byte) i30, b12);
                                }
                                boolean z11 = (H3 & 1) != 0;
                                int H4 = j0Var.H();
                                int H5 = j0Var.H();
                                int j11 = androidx.media3.common.i.j(H4);
                                i35 = z11 ? 1 : 2;
                                i36 = androidx.media3.common.i.k(H5);
                                str4 = str8;
                                i19 = P2;
                                i29 = i30;
                                kVar = kVar3;
                                i17 = j11;
                                list = list5;
                                i31 = i58;
                                i20 = i28;
                            } else if (q12 == 1635135811) {
                                int i59 = q11 - 8;
                                byte[] bArr2 = new byte[i59];
                                j0Var.l(bArr2, 0, i59);
                                list = ImmutableList.of(bArr2);
                                j0Var.W(f14 + 8);
                                androidx.media3.common.i i60 = i(j0Var);
                                int i61 = i60.f10157e;
                                int i62 = i60.f10158f;
                                i17 = i60.f10153a;
                                int i63 = i60.f10154b;
                                i36 = i60.f10155c;
                                i29 = i61;
                                i19 = P2;
                                i20 = i28;
                                i35 = i63;
                                kVar = kVar3;
                                i31 = i58;
                                i30 = i62;
                                str4 = "video/av01";
                            } else if (q12 == 1668050025) {
                                if (byteBuffer == null) {
                                    byteBuffer = a();
                                }
                                ByteBuffer byteBuffer2 = byteBuffer;
                                byteBuffer2.position(21);
                                byteBuffer2.putShort(j0Var.D());
                                byteBuffer2.putShort(j0Var.D());
                                byteBuffer = byteBuffer2;
                                i19 = P2;
                                i20 = i28;
                                kVar = kVar3;
                                list = list5;
                                i35 = i56;
                                i36 = i57;
                                i31 = i58;
                            } else {
                                if (q12 == 1835295606) {
                                    if (byteBuffer == null) {
                                        byteBuffer = a();
                                    }
                                    ByteBuffer byteBuffer3 = byteBuffer;
                                    short D = j0Var.D();
                                    short D2 = j0Var.D();
                                    i20 = i28;
                                    short D3 = j0Var.D();
                                    short D4 = j0Var.D();
                                    int i64 = i30;
                                    short D5 = j0Var.D();
                                    int i65 = i29;
                                    short D6 = j0Var.D();
                                    i18 = i58;
                                    short D7 = j0Var.D();
                                    float f15 = f13;
                                    short D8 = j0Var.D();
                                    long J2 = j0Var.J();
                                    long J3 = j0Var.J();
                                    i19 = P2;
                                    byteBuffer3.position(1);
                                    byteBuffer3.putShort(D5);
                                    byteBuffer3.putShort(D6);
                                    byteBuffer3.putShort(D);
                                    byteBuffer3.putShort(D2);
                                    byteBuffer3.putShort(D3);
                                    byteBuffer3.putShort(D4);
                                    byteBuffer3.putShort(D7);
                                    byteBuffer3.putShort(D8);
                                    byteBuffer3.putShort((short) (J2 / 10000));
                                    byteBuffer3.putShort((short) (J3 / 10000));
                                    byteBuffer = byteBuffer3;
                                    i30 = i64;
                                    i29 = i65;
                                    list = list5;
                                    i35 = i56;
                                    i36 = i57;
                                    f13 = f15;
                                } else {
                                    i18 = i58;
                                    i19 = P2;
                                    i20 = i28;
                                    i21 = i30;
                                    f11 = f13;
                                    i22 = i29;
                                    if (q12 == 1681012275) {
                                        l2.u.a(str4 == null, null);
                                        str4 = str2;
                                    } else if (q12 == 1702061171) {
                                        l2.u.a(str4 == null, null);
                                        cVar = m(j0Var, f14);
                                        String str9 = cVar.f62283a;
                                        byte[] bArr3 = cVar.f62284b;
                                        list = bArr3 != null ? ImmutableList.of(bArr3) : list5;
                                        str4 = str9;
                                        i30 = i21;
                                        i29 = i22;
                                        i35 = i56;
                                        i36 = i57;
                                        f13 = f11;
                                    } else if (q12 == 1651798644) {
                                        aVar = j(j0Var, f14);
                                    } else {
                                        if (q12 == 1885434736) {
                                            f13 = w(j0Var, f14);
                                            i30 = i21;
                                            i29 = i22;
                                            list = list5;
                                            i35 = i56;
                                            i36 = i57;
                                            z10 = true;
                                        } else if (q12 == 1937126244) {
                                            bArr = x(j0Var, f14, q11);
                                        } else if (q12 == 1936995172) {
                                            int H6 = j0Var.H();
                                            j0Var.X(3);
                                            if (H6 == 0) {
                                                int H7 = j0Var.H();
                                                if (H7 == 0) {
                                                    i18 = 0;
                                                } else if (H7 == 1) {
                                                    i18 = 1;
                                                } else if (H7 == 2) {
                                                    i18 = 2;
                                                } else if (H7 == 3) {
                                                    i18 = 3;
                                                }
                                            }
                                        } else if (q12 == 1634760259) {
                                            int i66 = q11 - 12;
                                            byte[] bArr4 = new byte[i66];
                                            j0Var.W(f14 + 12);
                                            j0Var.l(bArr4, 0, i66);
                                            list = ImmutableList.of(bArr4);
                                            androidx.media3.common.i g11 = g(new j0(bArr4));
                                            int i67 = g11.f10157e;
                                            int i68 = g11.f10158f;
                                            int i69 = g11.f10153a;
                                            int i70 = g11.f10154b;
                                            i36 = g11.f10155c;
                                            i29 = i67;
                                            i30 = i68;
                                            i35 = i70;
                                            f13 = f11;
                                            i17 = i69;
                                            str4 = "video/apv";
                                            kVar = kVar3;
                                            i31 = i18;
                                        } else if (q12 == 1668246642) {
                                            i23 = i57;
                                            if (i17 == -1 && i23 == -1) {
                                                int q13 = j0Var.q();
                                                if (q13 == 1852009592 || q13 == 1852009571) {
                                                    int P3 = j0Var.P();
                                                    int P4 = j0Var.P();
                                                    j0Var.X(2);
                                                    boolean z12 = q11 == 19 && (j0Var.H() & 128) != 0;
                                                    int j12 = androidx.media3.common.i.j(P3);
                                                    int i71 = z12 ? 1 : 2;
                                                    i30 = i21;
                                                    i29 = i22;
                                                    list = list5;
                                                    f13 = f11;
                                                    i36 = androidx.media3.common.i.k(P4);
                                                    i35 = i71;
                                                    i17 = j12;
                                                } else {
                                                    androidx.media3.common.util.u.h("BoxParsers", "Unsupported color type: " + androidx.media3.container.d.a(q13));
                                                }
                                            }
                                        } else {
                                            i23 = i57;
                                        }
                                        int i72 = i18;
                                        kVar = kVar3;
                                        i31 = i72;
                                    }
                                    i30 = i21;
                                    i29 = i22;
                                    list = list5;
                                    i35 = i56;
                                    i36 = i57;
                                    f13 = f11;
                                }
                                int i722 = i18;
                                kVar = kVar3;
                                i31 = i722;
                            }
                            i30 = i21;
                            i29 = i22;
                            list = list5;
                            i35 = i56;
                            f13 = f11;
                            i36 = i23;
                            int i7222 = i18;
                            kVar = kVar3;
                            i31 = i7222;
                        }
                    }
                }
                f12 += q11;
                i26 = i12;
                i27 = i13;
                hVar2 = hVar;
                i28 = i20;
                drmInitData3 = drmInitData2;
                P2 = i19;
                i34 = i17;
                str3 = str2;
            }
            f12 += q11;
            i26 = i12;
            i27 = i13;
            hVar2 = hVar;
            i28 = i20;
            drmInitData3 = drmInitData2;
            P2 = i19;
            i34 = i17;
            str3 = str2;
        }
        DrmInitData drmInitData4 = drmInitData3;
        int i73 = P2;
        float f16 = f13;
        List list6 = list;
        int i74 = i31;
        int i75 = i34;
        int i76 = i35;
        int i77 = i36;
        int i78 = i30;
        int i79 = i29;
        if (str4 == null) {
            return;
        }
        r.b T = new r.b().e0(i14).u0(str4).S(str5).B0(P).d0(i73).q0(f16).t0(i15).r0(bArr).x0(i74).g0(list6).l0(i32).m0(i33).Y(drmInitData4).j0(str).T(new i.b().d(i75).c(i76).e(i77).f(byteBuffer != null ? byteBuffer.array() : null).g(i79).b(i78).a());
        if (aVar != null) {
            T.Q(Ints.n(aVar.f62272a)).p0(Ints.n(aVar.f62273b));
        } else if (cVar != null) {
            T.Q(Ints.n(cVar.f62285c)).p0(Ints.n(cVar.f62286d));
        }
        hVar.f62295b = T.N();
    }

    private static androidx.media3.common.x L(j0 j0Var) {
        short D = j0Var.D();
        j0Var.X(2);
        String E = j0Var.E(D);
        int max = Math.max(E.lastIndexOf(43), E.lastIndexOf(45));
        try {
            return new androidx.media3.common.x(new androidx.media3.container.e(Float.parseFloat(E.substring(0, max)), Float.parseFloat(E.substring(max, E.length() - 1))));
        } catch (IndexOutOfBoundsException | NumberFormatException unused) {
            return null;
        }
    }

    private static ByteBuffer a() {
        return ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
    }

    private static boolean b(long[] jArr, long j11, long j12, long j13) {
        int length = jArr.length - 1;
        return jArr[0] <= j12 && j12 < jArr[a1.p(4, 0, length)] && jArr[a1.p(jArr.length - 4, 0, length)] < j13 && j13 <= j11;
    }

    private static int c(j0 j0Var, int i11, int i12, int i13) {
        int f11 = j0Var.f();
        l2.u.a(f11 >= i12, null);
        while (f11 - i12 < i13) {
            j0Var.W(f11);
            int q11 = j0Var.q();
            l2.u.a(q11 > 0, "childAtomSize must be positive");
            if (j0Var.q() == i11) {
                return f11;
            }
            f11 += q11;
        }
        return -1;
    }

    private static String d(int i11) {
        char[] cArr = {(char) (((i11 >> 10) & 31) + 96), (char) (((i11 >> 5) & 31) + 96), (char) ((i11 & 31) + 96)};
        for (int i12 = 0; i12 < 3; i12++) {
            char c11 = cArr[i12];
            if (c11 < 'a' || c11 > 'z') {
                return null;
            }
        }
        return new String(cArr);
    }

    private static int e(int i11) {
        if (i11 == 1936684398) {
            return 1;
        }
        if (i11 == 1986618469) {
            return 2;
        }
        if (i11 == 1952807028 || i11 == 1935832172 || i11 == 1937072756 || i11 == 1668047728) {
            return 3;
        }
        return i11 == 1835365473 ? 5 : -1;
    }

    public static void f(j0 j0Var) {
        int f11 = j0Var.f();
        j0Var.X(4);
        if (j0Var.q() != 1751411826) {
            f11 += 4;
        }
        j0Var.W(f11);
    }

    private static androidx.media3.common.i g(j0 j0Var) {
        i.b bVar = new i.b();
        i0 i0Var = new i0(j0Var.e());
        i0Var.p(j0Var.f() * 8);
        i0Var.s(1);
        int h11 = i0Var.h(8);
        for (int i11 = 0; i11 < h11; i11++) {
            i0Var.s(1);
            int h12 = i0Var.h(8);
            for (int i12 = 0; i12 < h12; i12++) {
                i0Var.r(6);
                boolean g11 = i0Var.g();
                i0Var.q();
                i0Var.s(11);
                i0Var.r(4);
                int h13 = i0Var.h(4) + 8;
                bVar.g(h13);
                bVar.b(h13);
                i0Var.s(1);
                if (g11) {
                    int h14 = i0Var.h(8);
                    int h15 = i0Var.h(8);
                    i0Var.s(1);
                    bVar.d(androidx.media3.common.i.j(h14)).c(i0Var.g() ? 1 : 2).e(androidx.media3.common.i.k(h15));
                }
            }
        }
        return bVar.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:138:0x047e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:147:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01e0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void h(androidx.media3.common.util.j0 r27, int r28, int r29, int r30, int r31, java.lang.String r32, boolean r33, androidx.media3.common.DrmInitData r34, f3.b.h r35, int r36) {
        /*
            Method dump skipped, instructions count: 1253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.b.h(androidx.media3.common.util.j0, int, int, int, int, java.lang.String, boolean, androidx.media3.common.DrmInitData, f3.b$h, int):void");
    }

    private static androidx.media3.common.i i(j0 j0Var) {
        i.b bVar = new i.b();
        i0 i0Var = new i0(j0Var.e());
        i0Var.p(j0Var.f() * 8);
        i0Var.s(1);
        int h11 = i0Var.h(3);
        i0Var.r(6);
        boolean g11 = i0Var.g();
        boolean g12 = i0Var.g();
        if (h11 == 2 && g11) {
            bVar.g(g12 ? 12 : 10);
            bVar.b(g12 ? 12 : 10);
        } else if (h11 <= 2) {
            bVar.g(g11 ? 10 : 8);
            bVar.b(g11 ? 10 : 8);
        }
        i0Var.r(13);
        i0Var.q();
        int h12 = i0Var.h(4);
        if (h12 != 1) {
            androidx.media3.common.util.u.f("BoxParsers", "Unsupported obu_type: " + h12);
            return bVar.a();
        }
        if (i0Var.g()) {
            androidx.media3.common.util.u.f("BoxParsers", "Unsupported obu_extension_flag");
            return bVar.a();
        }
        boolean g13 = i0Var.g();
        i0Var.q();
        if (g13 && i0Var.h(8) > 127) {
            androidx.media3.common.util.u.f("BoxParsers", "Excessive obu_size");
            return bVar.a();
        }
        int h13 = i0Var.h(3);
        i0Var.q();
        if (i0Var.g()) {
            androidx.media3.common.util.u.f("BoxParsers", "Unsupported reduced_still_picture_header");
            return bVar.a();
        }
        if (i0Var.g()) {
            androidx.media3.common.util.u.f("BoxParsers", "Unsupported timing_info_present_flag");
            return bVar.a();
        }
        if (i0Var.g()) {
            androidx.media3.common.util.u.f("BoxParsers", "Unsupported initial_display_delay_present_flag");
            return bVar.a();
        }
        int h14 = i0Var.h(5);
        boolean z10 = false;
        for (int i11 = 0; i11 <= h14; i11++) {
            i0Var.r(12);
            if (i0Var.h(5) > 7) {
                i0Var.q();
            }
        }
        int h15 = i0Var.h(4);
        int h16 = i0Var.h(4);
        i0Var.r(h15 + 1);
        i0Var.r(h16 + 1);
        if (i0Var.g()) {
            i0Var.r(7);
        }
        i0Var.r(7);
        boolean g14 = i0Var.g();
        if (g14) {
            i0Var.r(2);
        }
        if ((i0Var.g() ? 2 : i0Var.h(1)) > 0 && !i0Var.g()) {
            i0Var.r(1);
        }
        if (g14) {
            i0Var.r(3);
        }
        i0Var.r(3);
        boolean g15 = i0Var.g();
        if (h13 == 2 && g15) {
            i0Var.q();
        }
        if (h13 != 1 && i0Var.g()) {
            z10 = true;
        }
        if (i0Var.g()) {
            int h17 = i0Var.h(8);
            int h18 = i0Var.h(8);
            bVar.d(androidx.media3.common.i.j(h17)).c(((z10 || h17 != 1 || h18 != 13 || i0Var.h(8) != 0) ? i0Var.h(1) : 1) != 1 ? 2 : 1).e(androidx.media3.common.i.k(h18));
        }
        return bVar.a();
    }

    private static a j(j0 j0Var, int i11) {
        j0Var.W(i11 + 8);
        j0Var.X(4);
        return new a(j0Var.J(), j0Var.J());
    }

    static Pair k(j0 j0Var, int i11, int i12) {
        int i13 = i11 + 8;
        int i14 = -1;
        int i15 = 0;
        String str = null;
        Integer num = null;
        while (i13 - i11 < i12) {
            j0Var.W(i13);
            int q11 = j0Var.q();
            int q12 = j0Var.q();
            if (q12 == 1718775137) {
                num = Integer.valueOf(j0Var.q());
            } else if (q12 == 1935894637) {
                j0Var.X(4);
                str = j0Var.E(4);
            } else if (q12 == 1935894633) {
                i14 = i13;
                i15 = q11;
            }
            i13 += q11;
        }
        if (!C.CENC_TYPE_cenc.equals(str) && !C.CENC_TYPE_cbc1.equals(str) && !C.CENC_TYPE_cens.equals(str) && !C.CENC_TYPE_cbcs.equals(str)) {
            return null;
        }
        l2.u.a(num != null, "frma atom is mandatory");
        l2.u.a(i14 != -1, "schi atom is mandatory");
        u z10 = z(j0Var, i14, i15, str);
        l2.u.a(z10 != null, "tenc atom is mandatory");
        return Pair.create(num, (u) a1.i(z10));
    }

    private static Pair l(d.b bVar) {
        d.c e11 = bVar.e(1701606260);
        if (e11 == null) {
            return null;
        }
        j0 j0Var = e11.f10669b;
        j0Var.W(8);
        int p11 = p(j0Var.q());
        int L = j0Var.L();
        long[] jArr = new long[L];
        long[] jArr2 = new long[L];
        for (int i11 = 0; i11 < L; i11++) {
            jArr[i11] = p11 == 1 ? j0Var.O() : j0Var.J();
            jArr2[i11] = p11 == 1 ? j0Var.A() : j0Var.q();
            if (j0Var.D() != 1) {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
            j0Var.X(2);
        }
        return Pair.create(jArr, jArr2);
    }

    private static c m(j0 j0Var, int i11) {
        j0Var.W(i11 + 12);
        j0Var.X(1);
        n(j0Var);
        j0Var.X(2);
        int H = j0Var.H();
        if ((H & 128) != 0) {
            j0Var.X(2);
        }
        if ((H & 64) != 0) {
            j0Var.X(j0Var.H());
        }
        if ((H & 32) != 0) {
            j0Var.X(2);
        }
        j0Var.X(1);
        n(j0Var);
        String h11 = y.h(j0Var.H());
        if (MimeTypes.AUDIO_MPEG.equals(h11) || MimeTypes.AUDIO_DTS.equals(h11) || MimeTypes.AUDIO_DTS_HD.equals(h11)) {
            return new c(h11, null, -1L, -1L);
        }
        j0Var.X(4);
        long J = j0Var.J();
        long J2 = j0Var.J();
        j0Var.X(1);
        int n11 = n(j0Var);
        byte[] bArr = new byte[n11];
        j0Var.l(bArr, 0, n11);
        return new c(h11, bArr, J2 > 0 ? J2 : -1L, J > 0 ? J : -1L);
    }

    private static int n(j0 j0Var) {
        int H = j0Var.H();
        int i11 = H & 127;
        while ((H & 128) == 128) {
            H = j0Var.H();
            i11 = (i11 << 7) | (H & 127);
        }
        return i11;
    }

    public static int o(int i11) {
        return i11 & 16777215;
    }

    public static int p(int i11) {
        return (i11 >> 24) & 255;
    }

    private static int q(j0 j0Var) {
        j0Var.W(16);
        return j0Var.q();
    }

    private static androidx.media3.common.x r(j0 j0Var, int i11) {
        j0Var.X(8);
        ArrayList arrayList = new ArrayList();
        while (j0Var.f() < i11) {
            x.a d11 = f3.j.d(j0Var);
            if (d11 != null) {
                arrayList.add(d11);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new androidx.media3.common.x(arrayList);
    }

    private static e s(j0 j0Var) {
        long j11;
        j0Var.W(8);
        int p11 = p(j0Var.q());
        j0Var.X(p11 == 0 ? 8 : 16);
        long J = j0Var.J();
        int f11 = j0Var.f();
        int i11 = p11 == 0 ? 4 : 8;
        int i12 = 0;
        while (true) {
            if (i12 >= i11) {
                j0Var.X(i11);
                break;
            }
            if (j0Var.e()[f11 + i12] != -1) {
                long J2 = p11 == 0 ? j0Var.J() : j0Var.O();
                if (J2 != 0) {
                    j11 = a1.e1(J2, 1000000L, J);
                }
            } else {
                i12++;
            }
        }
        j11 = -9223372036854775807L;
        return new e(J, j11, d(j0Var.P()));
    }

    public static androidx.media3.common.x t(d.b bVar) {
        d.c e11 = bVar.e(1751411826);
        d.c e12 = bVar.e(1801812339);
        d.c e13 = bVar.e(1768715124);
        if (e11 == null || e12 == null || e13 == null || q(e11.f10669b) != 1835299937) {
            return null;
        }
        j0 j0Var = e12.f10669b;
        j0Var.W(12);
        int q11 = j0Var.q();
        String[] strArr = new String[q11];
        for (int i11 = 0; i11 < q11; i11++) {
            int q12 = j0Var.q();
            j0Var.X(4);
            strArr[i11] = j0Var.E(q12 - 8);
        }
        j0 j0Var2 = e13.f10669b;
        j0Var2.W(8);
        ArrayList arrayList = new ArrayList();
        while (j0Var2.a() > 8) {
            int f11 = j0Var2.f();
            int q13 = j0Var2.q();
            int q14 = j0Var2.q() - 1;
            if (q14 < 0 || q14 >= q11) {
                androidx.media3.common.util.u.h("BoxParsers", "Skipped metadata with unknown key index: " + q14);
            } else {
                androidx.media3.container.b i12 = f3.j.i(j0Var2, f11 + q13, strArr[q14]);
                if (i12 != null) {
                    arrayList.add(i12);
                }
            }
            j0Var2.W(f11 + q13);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new androidx.media3.common.x(arrayList);
    }

    private static void u(j0 j0Var, int i11, int i12, int i13, h hVar) {
        j0Var.W(i12 + 16);
        if (i11 == 1835365492) {
            j0Var.B();
            String B = j0Var.B();
            if (B != null) {
                hVar.f62295b = new r.b().e0(i13).u0(B).N();
            }
        }
    }

    public static androidx.media3.container.f v(j0 j0Var) {
        long A;
        long A2;
        j0Var.W(8);
        if (p(j0Var.q()) == 0) {
            A = j0Var.J();
            A2 = j0Var.J();
        } else {
            A = j0Var.A();
            A2 = j0Var.A();
        }
        return new androidx.media3.container.f(A, A2, j0Var.J());
    }

    private static float w(j0 j0Var, int i11) {
        j0Var.W(i11 + 8);
        return j0Var.L() / j0Var.L();
    }

    private static byte[] x(j0 j0Var, int i11, int i12) {
        int i13 = i11 + 8;
        while (i13 - i11 < i12) {
            j0Var.W(i13);
            int q11 = j0Var.q();
            if (j0Var.q() == 1886547818) {
                return Arrays.copyOfRange(j0Var.e(), i13, q11 + i13);
            }
            i13 += q11;
        }
        return null;
    }

    private static Pair y(j0 j0Var, int i11, int i12) {
        Pair k11;
        int f11 = j0Var.f();
        while (f11 - i11 < i12) {
            j0Var.W(f11);
            int q11 = j0Var.q();
            l2.u.a(q11 > 0, "childAtomSize must be positive");
            if (j0Var.q() == 1936289382 && (k11 = k(j0Var, f11, q11)) != null) {
                return k11;
            }
            f11 += q11;
        }
        return null;
    }

    private static u z(j0 j0Var, int i11, int i12, String str) {
        int i13;
        int i14;
        int i15 = i11 + 8;
        while (true) {
            byte[] bArr = null;
            if (i15 - i11 >= i12) {
                return null;
            }
            j0Var.W(i15);
            int q11 = j0Var.q();
            if (j0Var.q() == 1952804451) {
                int p11 = p(j0Var.q());
                j0Var.X(1);
                if (p11 == 0) {
                    j0Var.X(1);
                    i14 = 0;
                    i13 = 0;
                } else {
                    int H = j0Var.H();
                    i13 = H & 15;
                    i14 = (H & 240) >> 4;
                }
                boolean z10 = j0Var.H() == 1;
                int H2 = j0Var.H();
                byte[] bArr2 = new byte[16];
                j0Var.l(bArr2, 0, 16);
                if (z10 && H2 == 0) {
                    int H3 = j0Var.H();
                    bArr = new byte[H3];
                    j0Var.l(bArr, 0, H3);
                }
                return new u(z10, str, H2, bArr2, i14, i13, bArr);
            }
            i15 += q11;
        }
    }
}
