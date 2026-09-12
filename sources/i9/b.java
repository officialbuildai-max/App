package i9;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.s;
import com.google.android.exoplayer2.util.w;
import com.google.common.collect.r4;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import g9.a0;
import g9.b0;
import g9.e0;
import g9.j;
import g9.l;
import g9.m;
import g9.n;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class b implements l {

    /* renamed from: c, reason: collision with root package name */
    private int f65159c;

    /* renamed from: e, reason: collision with root package name */
    private i9.c f65161e;

    /* renamed from: h, reason: collision with root package name */
    private long f65164h;

    /* renamed from: i, reason: collision with root package name */
    private e f65165i;

    /* renamed from: m, reason: collision with root package name */
    private int f65169m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f65170n;

    /* renamed from: a, reason: collision with root package name */
    private final d0 f65157a = new d0(12);

    /* renamed from: b, reason: collision with root package name */
    private final c f65158b = new c();

    /* renamed from: d, reason: collision with root package name */
    private n f65160d = new j();

    /* renamed from: g, reason: collision with root package name */
    private e[] f65163g = new e[0];

    /* renamed from: k, reason: collision with root package name */
    private long f65167k = -1;

    /* renamed from: l, reason: collision with root package name */
    private long f65168l = -1;

    /* renamed from: j, reason: collision with root package name */
    private int f65166j = -1;

    /* renamed from: f, reason: collision with root package name */
    private long f65162f = C.TIME_UNSET;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i9.b$b, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0815b implements b0 {

        /* renamed from: a, reason: collision with root package name */
        private final long f65171a;

        public C0815b(long j11) {
            this.f65171a = j11;
        }

        @Override // g9.b0
        public long getDurationUs() {
            return this.f65171a;
        }

        @Override // g9.b0
        public b0.a getSeekPoints(long j11) {
            b0.a i11 = b.this.f65163g[0].i(j11);
            for (int i12 = 1; i12 < b.this.f65163g.length; i12++) {
                b0.a i13 = b.this.f65163g[i12].i(j11);
                if (i13.f63493a.f63499b < i11.f63493a.f63499b) {
                    i11 = i13;
                }
            }
            return i11;
        }

        @Override // g9.b0
        public boolean isSeekable() {
            return true;
        }
    }

    /* loaded from: classes4.dex */
    private static class c {

        /* renamed from: a, reason: collision with root package name */
        public int f65173a;

        /* renamed from: b, reason: collision with root package name */
        public int f65174b;

        /* renamed from: c, reason: collision with root package name */
        public int f65175c;

        private c() {
        }

        public void a(d0 d0Var) {
            this.f65173a = d0Var.q();
            this.f65174b = d0Var.q();
            this.f65175c = 0;
        }

        public void b(d0 d0Var) {
            a(d0Var);
            if (this.f65173a == 1414744396) {
                this.f65175c = d0Var.q();
                return;
            }
            throw ParserException.createForMalformedContainer("LIST expected, found: " + this.f65173a, null);
        }
    }

    private static void e(m mVar) {
        if ((mVar.getPosition() & 1) == 1) {
            mVar.skipFully(1);
        }
    }

    private e f(int i11) {
        for (e eVar : this.f65163g) {
            if (eVar.j(i11)) {
                return eVar;
            }
        }
        return null;
    }

    private void g(d0 d0Var) {
        f c11 = f.c(1819436136, d0Var);
        if (c11.getType() != 1819436136) {
            throw ParserException.createForMalformedContainer("Unexpected header list type " + c11.getType(), null);
        }
        i9.c cVar = (i9.c) c11.b(i9.c.class);
        if (cVar == null) {
            throw ParserException.createForMalformedContainer("AviHeader not found", null);
        }
        this.f65161e = cVar;
        this.f65162f = cVar.f65178c * cVar.f65176a;
        ArrayList arrayList = new ArrayList();
        r4 it = c11.f65198a.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            i9.a aVar = (i9.a) it.next();
            if (aVar.getType() == 1819440243) {
                int i12 = i11 + 1;
                e j11 = j((f) aVar, i11);
                if (j11 != null) {
                    arrayList.add(j11);
                }
                i11 = i12;
            }
        }
        this.f65163g = (e[]) arrayList.toArray(new e[0]);
        this.f65160d.endTracks();
    }

    private void h(d0 d0Var) {
        long i11 = i(d0Var);
        while (d0Var.a() >= 16) {
            int q11 = d0Var.q();
            int q12 = d0Var.q();
            long q13 = d0Var.q() + i11;
            d0Var.q();
            e f11 = f(q11);
            if (f11 != null) {
                if ((q12 & 16) == 16) {
                    f11.b(q13);
                }
                f11.k();
            }
        }
        for (e eVar : this.f65163g) {
            eVar.c();
        }
        this.f65170n = true;
        this.f65160d.d(new C0815b(this.f65162f));
    }

    private long i(d0 d0Var) {
        if (d0Var.a() < 16) {
            return 0L;
        }
        int e11 = d0Var.e();
        d0Var.Q(8);
        long q11 = d0Var.q();
        long j11 = this.f65167k;
        long j12 = q11 <= j11 ? j11 + 8 : 0L;
        d0Var.P(e11);
        return j12;
    }

    private e j(f fVar, int i11) {
        d dVar = (d) fVar.b(d.class);
        g gVar = (g) fVar.b(g.class);
        if (dVar == null) {
            s.i("AviExtractor", "Missing Stream Header");
            return null;
        }
        if (gVar == null) {
            s.i("AviExtractor", "Missing Stream Format");
            return null;
        }
        long a11 = dVar.a();
        o1 o1Var = gVar.f65200a;
        o1.b b11 = o1Var.b();
        b11.R(i11);
        int i12 = dVar.f65185f;
        if (i12 != 0) {
            b11.W(i12);
        }
        h hVar = (h) fVar.b(h.class);
        if (hVar != null) {
            b11.U(hVar.f65201a);
        }
        int l11 = w.l(o1Var.f25550l);
        if (l11 != 1 && l11 != 2) {
            return null;
        }
        e0 track = this.f65160d.track(i11, l11);
        track.e(b11.E());
        e eVar = new e(i11, l11, a11, dVar.f65184e, track);
        this.f65162f = a11;
        return eVar;
    }

    private int k(m mVar) {
        if (mVar.getPosition() >= this.f65168l) {
            return -1;
        }
        e eVar = this.f65165i;
        if (eVar == null) {
            e(mVar);
            mVar.peekFully(this.f65157a.d(), 0, 12);
            this.f65157a.P(0);
            int q11 = this.f65157a.q();
            if (q11 == 1414744396) {
                this.f65157a.P(8);
                mVar.skipFully(this.f65157a.q() != 1769369453 ? 8 : 12);
                mVar.resetPeekPosition();
                return 0;
            }
            int q12 = this.f65157a.q();
            if (q11 == 1263424842) {
                this.f65164h = mVar.getPosition() + q12 + 8;
                return 0;
            }
            mVar.skipFully(8);
            mVar.resetPeekPosition();
            e f11 = f(q11);
            if (f11 == null) {
                this.f65164h = mVar.getPosition() + q12;
                return 0;
            }
            f11.n(q12);
            this.f65165i = f11;
        } else if (eVar.m(mVar)) {
            this.f65165i = null;
        }
        return 0;
    }

    private boolean l(m mVar, a0 a0Var) {
        boolean z10;
        if (this.f65164h != -1) {
            long position = mVar.getPosition();
            long j11 = this.f65164h;
            if (j11 < position || j11 > PlaybackStateCompat.ACTION_SET_REPEAT_MODE + position) {
                a0Var.f63492a = j11;
                z10 = true;
                this.f65164h = -1L;
                return z10;
            }
            mVar.skipFully((int) (j11 - position));
        }
        z10 = false;
        this.f65164h = -1L;
        return z10;
    }

    @Override // g9.l
    public void b(n nVar) {
        this.f65159c = 0;
        this.f65160d = nVar;
        this.f65164h = -1L;
    }

    @Override // g9.l
    public int c(m mVar, a0 a0Var) {
        if (l(mVar, a0Var)) {
            return 1;
        }
        switch (this.f65159c) {
            case 0:
                if (!d(mVar)) {
                    throw ParserException.createForMalformedContainer("AVI Header List not found", null);
                }
                mVar.skipFully(12);
                this.f65159c = 1;
                return 0;
            case 1:
                mVar.readFully(this.f65157a.d(), 0, 12);
                this.f65157a.P(0);
                this.f65158b.b(this.f65157a);
                c cVar = this.f65158b;
                if (cVar.f65175c == 1819436136) {
                    this.f65166j = cVar.f65174b;
                    this.f65159c = 2;
                    return 0;
                }
                throw ParserException.createForMalformedContainer("hdrl expected, found: " + this.f65158b.f65175c, null);
            case 2:
                int i11 = this.f65166j - 4;
                d0 d0Var = new d0(i11);
                mVar.readFully(d0Var.d(), 0, i11);
                g(d0Var);
                this.f65159c = 3;
                return 0;
            case 3:
                if (this.f65167k != -1) {
                    long position = mVar.getPosition();
                    long j11 = this.f65167k;
                    if (position != j11) {
                        this.f65164h = j11;
                        return 0;
                    }
                }
                mVar.peekFully(this.f65157a.d(), 0, 12);
                mVar.resetPeekPosition();
                this.f65157a.P(0);
                this.f65158b.a(this.f65157a);
                int q11 = this.f65157a.q();
                int i12 = this.f65158b.f65173a;
                if (i12 == 1179011410) {
                    mVar.skipFully(12);
                    return 0;
                }
                if (i12 != 1414744396 || q11 != 1769369453) {
                    this.f65164h = mVar.getPosition() + this.f65158b.f65174b + 8;
                    return 0;
                }
                long position2 = mVar.getPosition();
                this.f65167k = position2;
                this.f65168l = position2 + this.f65158b.f65174b + 8;
                if (!this.f65170n) {
                    if (((i9.c) com.google.android.exoplayer2.util.a.e(this.f65161e)).a()) {
                        this.f65159c = 4;
                        this.f65164h = this.f65168l;
                        return 0;
                    }
                    this.f65160d.d(new b0.b(this.f65162f));
                    this.f65170n = true;
                }
                this.f65164h = mVar.getPosition() + 12;
                this.f65159c = 6;
                return 0;
            case 4:
                mVar.readFully(this.f65157a.d(), 0, 8);
                this.f65157a.P(0);
                int q12 = this.f65157a.q();
                int q13 = this.f65157a.q();
                if (q12 == 829973609) {
                    this.f65159c = 5;
                    this.f65169m = q13;
                } else {
                    this.f65164h = mVar.getPosition() + q13;
                }
                return 0;
            case 5:
                d0 d0Var2 = new d0(this.f65169m);
                mVar.readFully(d0Var2.d(), 0, this.f65169m);
                h(d0Var2);
                this.f65159c = 6;
                this.f65164h = this.f65167k;
                return 0;
            case 6:
                return k(mVar);
            default:
                throw new AssertionError();
        }
    }

    @Override // g9.l
    public boolean d(m mVar) {
        mVar.peekFully(this.f65157a.d(), 0, 12);
        this.f65157a.P(0);
        if (this.f65157a.q() != 1179011410) {
            return false;
        }
        this.f65157a.Q(4);
        return this.f65157a.q() == 541677121;
    }

    @Override // g9.l
    public void release() {
    }

    @Override // g9.l
    public void seek(long j11, long j12) {
        this.f65164h = -1L;
        this.f65165i = null;
        for (e eVar : this.f65163g) {
            eVar.o(j11);
        }
        if (j11 != 0) {
            this.f65159c = 6;
        } else if (this.f65163g.length == 0) {
            this.f65159c = 0;
        } else {
            this.f65159c = 3;
        }
    }
}
