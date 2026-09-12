package b3;

import androidx.media3.common.util.j0;
import androidx.media3.common.util.p0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class d extends b3.b {

    /* renamed from: a, reason: collision with root package name */
    public final long f16262a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f16263b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f16264c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f16265d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f16266e;

    /* renamed from: f, reason: collision with root package name */
    public final long f16267f;

    /* renamed from: g, reason: collision with root package name */
    public final long f16268g;

    /* renamed from: h, reason: collision with root package name */
    public final List f16269h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f16270i;

    /* renamed from: j, reason: collision with root package name */
    public final long f16271j;

    /* renamed from: k, reason: collision with root package name */
    public final int f16272k;

    /* renamed from: l, reason: collision with root package name */
    public final int f16273l;

    /* renamed from: m, reason: collision with root package name */
    public final int f16274m;

    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f16275a;

        /* renamed from: b, reason: collision with root package name */
        public final long f16276b;

        /* renamed from: c, reason: collision with root package name */
        public final long f16277c;

        private b(int i11, long j11, long j12) {
            this.f16275a = i11;
            this.f16276b = j11;
            this.f16277c = j12;
        }
    }

    private d(long j11, boolean z10, boolean z11, boolean z12, boolean z13, long j12, long j13, List list, boolean z14, long j14, int i11, int i12, int i13) {
        this.f16262a = j11;
        this.f16263b = z10;
        this.f16264c = z11;
        this.f16265d = z12;
        this.f16266e = z13;
        this.f16267f = j12;
        this.f16268g = j13;
        this.f16269h = Collections.unmodifiableList(list);
        this.f16270i = z14;
        this.f16271j = j14;
        this.f16272k = i11;
        this.f16273l = i12;
        this.f16274m = i13;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d b(j0 j0Var, long j11, p0 p0Var) {
        List list;
        boolean z10;
        boolean z11;
        long j12;
        boolean z12;
        long j13;
        int i11;
        int i12;
        int i13;
        boolean z13;
        boolean z14;
        long j14;
        long J = j0Var.J();
        boolean z15 = (j0Var.H() & 128) != 0;
        List emptyList = Collections.emptyList();
        if (z15) {
            list = emptyList;
            z10 = false;
            z11 = false;
            j12 = C.TIME_UNSET;
            z12 = false;
            j13 = C.TIME_UNSET;
            i11 = 0;
            i12 = 0;
            i13 = 0;
            z13 = false;
        } else {
            int H = j0Var.H();
            boolean z16 = (H & 128) != 0;
            boolean z17 = (H & 64) != 0;
            boolean z18 = (H & 32) != 0;
            boolean z19 = (H & 16) != 0;
            long c11 = (!z17 || z19) ? C.TIME_UNSET : g.c(j0Var, j11);
            if (!z17) {
                int H2 = j0Var.H();
                ArrayList arrayList = new ArrayList(H2);
                for (int i14 = 0; i14 < H2; i14++) {
                    int H3 = j0Var.H();
                    long c12 = !z19 ? g.c(j0Var, j11) : C.TIME_UNSET;
                    arrayList.add(new b(H3, c12, p0Var.b(c12)));
                }
                emptyList = arrayList;
            }
            if (z18) {
                long H4 = j0Var.H();
                boolean z20 = (128 & H4) != 0;
                j14 = ((((H4 & 1) << 32) | j0Var.J()) * 1000) / 90;
                z14 = z20;
            } else {
                z14 = false;
                j14 = C.TIME_UNSET;
            }
            i11 = j0Var.P();
            z13 = z17;
            i12 = j0Var.H();
            i13 = j0Var.H();
            list = emptyList;
            long j15 = c11;
            z12 = z14;
            j13 = j14;
            z11 = z19;
            z10 = z16;
            j12 = j15;
        }
        return new d(J, z15, z10, z13, z11, j12, p0Var.b(j12), list, z12, j13, i11, i12, i13);
    }

    @Override // b3.b
    public String toString() {
        return "SCTE-35 SpliceInsertCommand { programSplicePts=" + this.f16267f + ", programSplicePlaybackPositionUs= " + this.f16268g + " }";
    }
}
