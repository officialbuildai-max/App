package h2;

import android.util.SparseArray;
import androidx.media3.common.r;
import androidx.media3.common.util.a1;
import androidx.media3.common.util.j0;
import androidx.media3.common.y;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import h2.f;
import i3.s;
import java.util.List;
import java.util.Objects;
import l2.l0;
import l2.m0;
import l2.r;
import l2.r0;
import l2.s0;
import l2.t;
import y1.f4;

/* loaded from: classes2.dex */
public final class d implements t, f {

    /* renamed from: j, reason: collision with root package name */
    public static final b f64398j = new b();

    /* renamed from: k, reason: collision with root package name */
    private static final l0 f64399k = new l0();

    /* renamed from: a, reason: collision with root package name */
    private final r f64400a;

    /* renamed from: b, reason: collision with root package name */
    private final int f64401b;

    /* renamed from: c, reason: collision with root package name */
    private final androidx.media3.common.r f64402c;

    /* renamed from: d, reason: collision with root package name */
    private final SparseArray f64403d = new SparseArray();

    /* renamed from: e, reason: collision with root package name */
    private boolean f64404e;

    /* renamed from: f, reason: collision with root package name */
    private f.b f64405f;

    /* renamed from: g, reason: collision with root package name */
    private long f64406g;

    /* renamed from: h, reason: collision with root package name */
    private m0 f64407h;

    /* renamed from: i, reason: collision with root package name */
    private androidx.media3.common.r[] f64408i;

    /* loaded from: classes2.dex */
    private static final class a implements s0 {

        /* renamed from: a, reason: collision with root package name */
        private final int f64409a;

        /* renamed from: b, reason: collision with root package name */
        private final int f64410b;

        /* renamed from: c, reason: collision with root package name */
        private final androidx.media3.common.r f64411c;

        /* renamed from: d, reason: collision with root package name */
        private final l2.n f64412d = new l2.n();

        /* renamed from: e, reason: collision with root package name */
        public androidx.media3.common.r f64413e;

        /* renamed from: f, reason: collision with root package name */
        private s0 f64414f;

        /* renamed from: g, reason: collision with root package name */
        private long f64415g;

        public a(int i11, int i12, androidx.media3.common.r rVar) {
            this.f64409a = i11;
            this.f64410b = i12;
            this.f64411c = rVar;
        }

        @Override // l2.s0
        public void a(j0 j0Var, int i11, int i12) {
            ((s0) a1.i(this.f64414f)).b(j0Var, i11);
        }

        @Override // l2.s0
        public /* synthetic */ void b(j0 j0Var, int i11) {
            r0.c(this, j0Var, i11);
        }

        @Override // l2.s0
        public void c(androidx.media3.common.r rVar) {
            androidx.media3.common.r rVar2 = this.f64411c;
            if (rVar2 != null) {
                rVar = rVar.j(rVar2);
            }
            this.f64413e = rVar;
            ((s0) a1.i(this.f64414f)).c(this.f64413e);
        }

        @Override // l2.s0
        public void d(long j11, int i11, int i12, int i13, s0.a aVar) {
            long j12 = this.f64415g;
            if (j12 != C.TIME_UNSET && j11 >= j12) {
                this.f64414f = this.f64412d;
            }
            ((s0) a1.i(this.f64414f)).d(j11, i11, i12, i13, aVar);
        }

        @Override // l2.s0
        public /* synthetic */ int e(androidx.media3.common.j jVar, int i11, boolean z10) {
            return r0.b(this, jVar, i11, z10);
        }

        @Override // l2.s0
        public /* synthetic */ void f(long j11) {
            r0.a(this, j11);
        }

        @Override // l2.s0
        public int g(androidx.media3.common.j jVar, int i11, boolean z10, int i12) {
            return ((s0) a1.i(this.f64414f)).e(jVar, i11, z10);
        }

        public void h(f.b bVar, long j11) {
            if (bVar == null) {
                this.f64414f = this.f64412d;
                return;
            }
            this.f64415g = j11;
            s0 track = bVar.track(this.f64409a, this.f64410b);
            this.f64414f = track;
            androidx.media3.common.r rVar = this.f64413e;
            if (rVar != null) {
                track.c(rVar);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements f.a {

        /* renamed from: a, reason: collision with root package name */
        private s.a f64416a = new i3.h();

        /* renamed from: b, reason: collision with root package name */
        private boolean f64417b;

        /* renamed from: c, reason: collision with root package name */
        private int f64418c;

        @Override // h2.f.a
        public androidx.media3.common.r d(androidx.media3.common.r rVar) {
            String str;
            if (!this.f64417b || !this.f64416a.a(rVar)) {
                return rVar;
            }
            r.b W = rVar.b().u0("application/x-media3-cues").W(this.f64416a.b(rVar));
            StringBuilder sb2 = new StringBuilder();
            sb2.append(rVar.f10243o);
            if (rVar.f10239k != null) {
                str = " " + rVar.f10239k;
            } else {
                str = "";
            }
            sb2.append(str);
            return W.S(sb2.toString()).y0(Long.MAX_VALUE).N();
        }

        @Override // h2.f.a
        public f e(int i11, androidx.media3.common.r rVar, boolean z10, List list, s0 s0Var, f4 f4Var) {
            l2.r hVar;
            String str = rVar.f10242n;
            if (!y.s(str)) {
                if (y.r(str)) {
                    hVar = new d3.e(this.f64416a, this.f64417b ? 1 : 3);
                } else if (Objects.equals(str, "image/jpeg")) {
                    hVar = new t2.a(1);
                } else if (Objects.equals(str, "image/png")) {
                    hVar = new h3.a();
                } else {
                    int i12 = z10 ? 4 : 0;
                    if (!this.f64417b) {
                        i12 |= 32;
                    }
                    hVar = new f3.h(this.f64416a, i12 | f3.h.j(this.f64418c), null, null, list, s0Var);
                }
            } else {
                if (!this.f64417b) {
                    return null;
                }
                hVar = new i3.n(this.f64416a.c(rVar), rVar);
            }
            return new d(hVar, i11, rVar);
        }

        @Override // h2.f.a
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public b c(boolean z10) {
            this.f64417b = z10;
            return this;
        }

        @Override // h2.f.a
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public b b(int i11) {
            this.f64418c = i11;
            return this;
        }

        @Override // h2.f.a
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public b a(s.a aVar) {
            this.f64416a = (s.a) androidx.media3.common.util.a.e(aVar);
            return this;
        }
    }

    public d(l2.r rVar, int i11, androidx.media3.common.r rVar2) {
        this.f64400a = rVar;
        this.f64401b = i11;
        this.f64402c = rVar2;
    }

    @Override // h2.f
    public boolean a(l2.s sVar) {
        int c11 = this.f64400a.c(sVar, f64399k);
        androidx.media3.common.util.a.g(c11 != 1);
        return c11 == 0;
    }

    @Override // h2.f
    public l2.h b() {
        m0 m0Var = this.f64407h;
        if (m0Var instanceof l2.h) {
            return (l2.h) m0Var;
        }
        return null;
    }

    @Override // h2.f
    public androidx.media3.common.r[] c() {
        return this.f64408i;
    }

    @Override // h2.f
    public void d(f.b bVar, long j11, long j12) {
        this.f64405f = bVar;
        this.f64406g = j12;
        if (!this.f64404e) {
            this.f64400a.b(this);
            if (j11 != C.TIME_UNSET) {
                this.f64400a.seek(0L, j11);
            }
            this.f64404e = true;
            return;
        }
        l2.r rVar = this.f64400a;
        if (j11 == C.TIME_UNSET) {
            j11 = 0;
        }
        rVar.seek(0L, j11);
        for (int i11 = 0; i11 < this.f64403d.size(); i11++) {
            ((a) this.f64403d.valueAt(i11)).h(bVar, j12);
        }
    }

    @Override // l2.t
    public void endTracks() {
        androidx.media3.common.r[] rVarArr = new androidx.media3.common.r[this.f64403d.size()];
        for (int i11 = 0; i11 < this.f64403d.size(); i11++) {
            rVarArr[i11] = (androidx.media3.common.r) androidx.media3.common.util.a.i(((a) this.f64403d.valueAt(i11)).f64413e);
        }
        this.f64408i = rVarArr;
    }

    @Override // l2.t
    public void f(m0 m0Var) {
        this.f64407h = m0Var;
    }

    @Override // h2.f
    public void release() {
        this.f64400a.release();
    }

    @Override // l2.t
    public s0 track(int i11, int i12) {
        a aVar = (a) this.f64403d.get(i11);
        if (aVar == null) {
            androidx.media3.common.util.a.g(this.f64408i == null);
            aVar = new a(i11, i12, i12 == this.f64401b ? this.f64402c : null);
            aVar.h(this.f64405f, this.f64406g);
            this.f64403d.put(i11, aVar);
        }
        return aVar;
    }
}
