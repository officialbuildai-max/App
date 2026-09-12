package b3;

import androidx.media3.common.util.j0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class f extends b3.b {

    /* renamed from: a, reason: collision with root package name */
    public final List f16278a;

    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f16279a;

        /* renamed from: b, reason: collision with root package name */
        public final long f16280b;

        private b(int i11, long j11) {
            this.f16279a = i11;
            this.f16280b = j11;
        }
    }

    /* loaded from: classes2.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final long f16281a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f16282b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f16283c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f16284d;

        /* renamed from: e, reason: collision with root package name */
        public final long f16285e;

        /* renamed from: f, reason: collision with root package name */
        public final List f16286f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f16287g;

        /* renamed from: h, reason: collision with root package name */
        public final long f16288h;

        /* renamed from: i, reason: collision with root package name */
        public final int f16289i;

        /* renamed from: j, reason: collision with root package name */
        public final int f16290j;

        /* renamed from: k, reason: collision with root package name */
        public final int f16291k;

        private c(long j11, boolean z10, boolean z11, boolean z12, List list, long j12, boolean z13, long j13, int i11, int i12, int i13) {
            this.f16281a = j11;
            this.f16282b = z10;
            this.f16283c = z11;
            this.f16284d = z12;
            this.f16286f = Collections.unmodifiableList(list);
            this.f16285e = j12;
            this.f16287g = z13;
            this.f16288h = j13;
            this.f16289i = i11;
            this.f16290j = i12;
            this.f16291k = i13;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static c b(j0 j0Var) {
            ArrayList arrayList;
            boolean z10;
            long j11;
            boolean z11;
            long j12;
            int i11;
            int i12;
            int i13;
            boolean z12;
            boolean z13;
            long j13;
            long J = j0Var.J();
            boolean z14 = (j0Var.H() & 128) != 0;
            ArrayList arrayList2 = new ArrayList();
            if (z14) {
                arrayList = arrayList2;
                z10 = false;
                j11 = C.TIME_UNSET;
                z11 = false;
                j12 = C.TIME_UNSET;
                i11 = 0;
                i12 = 0;
                i13 = 0;
                z12 = false;
            } else {
                int H = j0Var.H();
                boolean z15 = (H & 128) != 0;
                boolean z16 = (H & 64) != 0;
                boolean z17 = (H & 32) != 0;
                long J2 = z16 ? j0Var.J() : C.TIME_UNSET;
                if (!z16) {
                    int H2 = j0Var.H();
                    ArrayList arrayList3 = new ArrayList(H2);
                    for (int i14 = 0; i14 < H2; i14++) {
                        arrayList3.add(new b(j0Var.H(), j0Var.J()));
                    }
                    arrayList2 = arrayList3;
                }
                if (z17) {
                    long H3 = j0Var.H();
                    boolean z18 = (128 & H3) != 0;
                    j13 = ((((H3 & 1) << 32) | j0Var.J()) * 1000) / 90;
                    z13 = z18;
                } else {
                    z13 = false;
                    j13 = C.TIME_UNSET;
                }
                int P = j0Var.P();
                int H4 = j0Var.H();
                z12 = z16;
                i13 = j0Var.H();
                j12 = j13;
                arrayList = arrayList2;
                long j14 = J2;
                i11 = P;
                i12 = H4;
                j11 = j14;
                boolean z19 = z15;
                z11 = z13;
                z10 = z19;
            }
            return new c(J, z14, z10, z12, arrayList, j11, z11, j12, i11, i12, i13);
        }
    }

    private f(List list) {
        this.f16278a = Collections.unmodifiableList(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static f b(j0 j0Var) {
        int H = j0Var.H();
        ArrayList arrayList = new ArrayList(H);
        for (int i11 = 0; i11 < H; i11++) {
            arrayList.add(c.b(j0Var));
        }
        return new f(arrayList);
    }
}
