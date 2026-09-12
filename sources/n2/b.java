package n2;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.media3.common.ParserException;
import androidx.media3.common.r;
import androidx.media3.common.util.j0;
import androidx.media3.common.util.u;
import androidx.media3.common.y;
import com.google.common.collect.r4;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import i3.s;
import java.util.ArrayList;
import java.util.List;
import l2.l0;
import l2.m0;
import l2.q;
import l2.r;
import l2.s0;
import l2.t;

/* loaded from: classes2.dex */
public final class b implements r {

    /* renamed from: a, reason: collision with root package name */
    private final j0 f70244a;

    /* renamed from: b, reason: collision with root package name */
    private final c f70245b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f70246c;

    /* renamed from: d, reason: collision with root package name */
    private final s.a f70247d;

    /* renamed from: e, reason: collision with root package name */
    private int f70248e;

    /* renamed from: f, reason: collision with root package name */
    private t f70249f;

    /* renamed from: g, reason: collision with root package name */
    private n2.c f70250g;

    /* renamed from: h, reason: collision with root package name */
    private long f70251h;

    /* renamed from: i, reason: collision with root package name */
    private e[] f70252i;

    /* renamed from: j, reason: collision with root package name */
    private long f70253j;

    /* renamed from: k, reason: collision with root package name */
    private e f70254k;

    /* renamed from: l, reason: collision with root package name */
    private int f70255l;

    /* renamed from: m, reason: collision with root package name */
    private long f70256m;

    /* renamed from: n, reason: collision with root package name */
    private long f70257n;

    /* renamed from: o, reason: collision with root package name */
    private int f70258o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f70259p;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n2.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0872b implements m0 {

        /* renamed from: a, reason: collision with root package name */
        private final long f70260a;

        public C0872b(long j11) {
            this.f70260a = j11;
        }

        @Override // l2.m0
        public long getDurationUs() {
            return this.f70260a;
        }

        @Override // l2.m0
        public m0.a getSeekPoints(long j11) {
            m0.a i11 = b.this.f70252i[0].i(j11);
            for (int i12 = 1; i12 < b.this.f70252i.length; i12++) {
                m0.a i13 = b.this.f70252i[i12].i(j11);
                if (i13.f68767a.f68774b < i11.f68767a.f68774b) {
                    i11 = i13;
                }
            }
            return i11;
        }

        @Override // l2.m0
        public boolean isSeekable() {
            return true;
        }
    }

    /* loaded from: classes2.dex */
    private static class c {

        /* renamed from: a, reason: collision with root package name */
        public int f70262a;

        /* renamed from: b, reason: collision with root package name */
        public int f70263b;

        /* renamed from: c, reason: collision with root package name */
        public int f70264c;

        private c() {
        }

        public void a(j0 j0Var) {
            this.f70262a = j0Var.u();
            this.f70263b = j0Var.u();
            this.f70264c = 0;
        }

        public void b(j0 j0Var) {
            a(j0Var);
            if (this.f70262a == 1414744396) {
                this.f70264c = j0Var.u();
                return;
            }
            throw ParserException.createForMalformedContainer("LIST expected, found: " + this.f70262a, null);
        }
    }

    @Deprecated
    public b() {
        this(1, s.a.f65046a);
    }

    public b(int i11, s.a aVar) {
        this.f70247d = aVar;
        this.f70246c = (i11 & 1) == 0;
        this.f70244a = new j0(12);
        this.f70245b = new c();
        this.f70249f = new l2.j0();
        this.f70252i = new e[0];
        this.f70256m = -1L;
        this.f70257n = -1L;
        this.f70255l = -1;
        this.f70251h = C.TIME_UNSET;
    }

    private static void g(l2.s sVar) {
        if ((sVar.getPosition() & 1) == 1) {
            sVar.skipFully(1);
        }
    }

    private e h(int i11) {
        for (e eVar : this.f70252i) {
            if (eVar.j(i11)) {
                return eVar;
            }
        }
        return null;
    }

    private void i(j0 j0Var) {
        f c11 = f.c(1819436136, j0Var);
        if (c11.getType() != 1819436136) {
            throw ParserException.createForMalformedContainer("Unexpected header list type " + c11.getType(), null);
        }
        n2.c cVar = (n2.c) c11.b(n2.c.class);
        if (cVar == null) {
            throw ParserException.createForMalformedContainer("AviHeader not found", null);
        }
        this.f70250g = cVar;
        this.f70251h = cVar.f70267c * cVar.f70265a;
        ArrayList arrayList = new ArrayList();
        r4 it = c11.f70290a.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            n2.a aVar = (n2.a) it.next();
            if (aVar.getType() == 1819440243) {
                int i12 = i11 + 1;
                e l11 = l((f) aVar, i11);
                if (l11 != null) {
                    arrayList.add(l11);
                }
                i11 = i12;
            }
        }
        this.f70252i = (e[]) arrayList.toArray(new e[0]);
        this.f70249f.endTracks();
    }

    private void j(j0 j0Var) {
        int i11;
        long k11 = k(j0Var);
        while (true) {
            if (j0Var.a() < 16) {
                break;
            }
            int u11 = j0Var.u();
            int u12 = j0Var.u();
            long u13 = j0Var.u() + k11;
            j0Var.X(4);
            e h11 = h(u11);
            if (h11 != null) {
                h11.b(u13, (u12 & 16) == 16);
            }
        }
        for (e eVar : this.f70252i) {
            eVar.c();
        }
        this.f70259p = true;
        if (this.f70252i.length == 0) {
            this.f70249f.f(new m0.b(this.f70251h));
        } else {
            this.f70249f.f(new C0872b(this.f70251h));
        }
    }

    private long k(j0 j0Var) {
        if (j0Var.a() < 16) {
            return 0L;
        }
        int f11 = j0Var.f();
        j0Var.X(8);
        long u11 = j0Var.u();
        long j11 = this.f70256m;
        long j12 = u11 <= j11 ? j11 + 8 : 0L;
        j0Var.W(f11);
        return j12;
    }

    private e l(f fVar, int i11) {
        d dVar = (d) fVar.b(d.class);
        g gVar = (g) fVar.b(g.class);
        if (dVar == null) {
            u.h("AviExtractor", "Missing Stream Header");
            return null;
        }
        if (gVar == null) {
            u.h("AviExtractor", "Missing Stream Format");
            return null;
        }
        long a11 = dVar.a();
        androidx.media3.common.r rVar = gVar.f70292a;
        r.b b11 = rVar.b();
        b11.e0(i11);
        int i12 = dVar.f70274f;
        if (i12 != 0) {
            b11.k0(i12);
        }
        h hVar = (h) fVar.b(h.class);
        if (hVar != null) {
            b11.h0(hVar.f70293a);
        }
        int k11 = y.k(rVar.f10243o);
        if (k11 != 1 && k11 != 2) {
            return null;
        }
        s0 track = this.f70249f.track(i11, k11);
        track.c(b11.N());
        track.f(a11);
        this.f70251h = Math.max(this.f70251h, a11);
        return new e(i11, dVar, track);
    }

    private int m(l2.s sVar) {
        if (sVar.getPosition() >= this.f70257n) {
            return -1;
        }
        e eVar = this.f70254k;
        if (eVar == null) {
            g(sVar);
            sVar.peekFully(this.f70244a.e(), 0, 12);
            this.f70244a.W(0);
            int u11 = this.f70244a.u();
            if (u11 == 1414744396) {
                this.f70244a.W(8);
                sVar.skipFully(this.f70244a.u() != 1769369453 ? 8 : 12);
                sVar.resetPeekPosition();
                return 0;
            }
            int u12 = this.f70244a.u();
            if (u11 == 1263424842) {
                this.f70253j = sVar.getPosition() + u12 + 8;
                return 0;
            }
            sVar.skipFully(8);
            sVar.resetPeekPosition();
            e h11 = h(u11);
            if (h11 == null) {
                this.f70253j = sVar.getPosition() + u12;
                return 0;
            }
            h11.n(u12);
            this.f70254k = h11;
        } else if (eVar.m(sVar)) {
            this.f70254k = null;
        }
        return 0;
    }

    private boolean n(l2.s sVar, l0 l0Var) {
        boolean z10;
        if (this.f70253j != -1) {
            long position = sVar.getPosition();
            long j11 = this.f70253j;
            if (j11 < position || j11 > PlaybackStateCompat.ACTION_SET_REPEAT_MODE + position) {
                l0Var.f68743a = j11;
                z10 = true;
                this.f70253j = -1L;
                return z10;
            }
            sVar.skipFully((int) (j11 - position));
        }
        z10 = false;
        this.f70253j = -1L;
        return z10;
    }

    @Override // l2.r
    public void b(t tVar) {
        this.f70248e = 0;
        if (this.f70246c) {
            tVar = new i3.t(tVar, this.f70247d);
        }
        this.f70249f = tVar;
        this.f70253j = -1L;
    }

    @Override // l2.r
    public int c(l2.s sVar, l0 l0Var) {
        if (n(sVar, l0Var)) {
            return 1;
        }
        switch (this.f70248e) {
            case 0:
                if (!d(sVar)) {
                    throw ParserException.createForMalformedContainer("AVI Header List not found", null);
                }
                sVar.skipFully(12);
                this.f70248e = 1;
                return 0;
            case 1:
                sVar.readFully(this.f70244a.e(), 0, 12);
                this.f70244a.W(0);
                this.f70245b.b(this.f70244a);
                c cVar = this.f70245b;
                if (cVar.f70264c == 1819436136) {
                    this.f70255l = cVar.f70263b;
                    this.f70248e = 2;
                    return 0;
                }
                throw ParserException.createForMalformedContainer("hdrl expected, found: " + this.f70245b.f70264c, null);
            case 2:
                int i11 = this.f70255l - 4;
                j0 j0Var = new j0(i11);
                sVar.readFully(j0Var.e(), 0, i11);
                i(j0Var);
                this.f70248e = 3;
                return 0;
            case 3:
                if (this.f70256m != -1) {
                    long position = sVar.getPosition();
                    long j11 = this.f70256m;
                    if (position != j11) {
                        this.f70253j = j11;
                        return 0;
                    }
                }
                sVar.peekFully(this.f70244a.e(), 0, 12);
                sVar.resetPeekPosition();
                this.f70244a.W(0);
                this.f70245b.a(this.f70244a);
                int u11 = this.f70244a.u();
                int i12 = this.f70245b.f70262a;
                if (i12 == 1179011410) {
                    sVar.skipFully(12);
                    return 0;
                }
                if (i12 != 1414744396 || u11 != 1769369453) {
                    this.f70253j = sVar.getPosition() + this.f70245b.f70263b + 8;
                    return 0;
                }
                long position2 = sVar.getPosition();
                this.f70256m = position2;
                this.f70257n = position2 + this.f70245b.f70263b + 8;
                if (!this.f70259p) {
                    if (((n2.c) androidx.media3.common.util.a.e(this.f70250g)).a()) {
                        this.f70248e = 4;
                        this.f70253j = this.f70257n;
                        return 0;
                    }
                    this.f70249f.f(new m0.b(this.f70251h));
                    this.f70259p = true;
                }
                this.f70253j = sVar.getPosition() + 12;
                this.f70248e = 6;
                return 0;
            case 4:
                sVar.readFully(this.f70244a.e(), 0, 8);
                this.f70244a.W(0);
                int u12 = this.f70244a.u();
                int u13 = this.f70244a.u();
                if (u12 == 829973609) {
                    this.f70248e = 5;
                    this.f70258o = u13;
                } else {
                    this.f70253j = sVar.getPosition() + u13;
                }
                return 0;
            case 5:
                j0 j0Var2 = new j0(this.f70258o);
                sVar.readFully(j0Var2.e(), 0, this.f70258o);
                j(j0Var2);
                this.f70248e = 6;
                this.f70253j = this.f70256m;
                return 0;
            case 6:
                return m(sVar);
            default:
                throw new AssertionError();
        }
    }

    @Override // l2.r
    public boolean d(l2.s sVar) {
        sVar.peekFully(this.f70244a.e(), 0, 12);
        this.f70244a.W(0);
        if (this.f70244a.u() != 1179011410) {
            return false;
        }
        this.f70244a.X(4);
        return this.f70244a.u() == 541677121;
    }

    @Override // l2.r
    public /* synthetic */ l2.r e() {
        return q.b(this);
    }

    @Override // l2.r
    public /* synthetic */ List f() {
        return q.a(this);
    }

    @Override // l2.r
    public void release() {
    }

    @Override // l2.r
    public void seek(long j11, long j12) {
        this.f70253j = -1L;
        this.f70254k = null;
        for (e eVar : this.f70252i) {
            eVar.o(j11);
        }
        if (j11 != 0) {
            this.f70248e = 6;
        } else if (this.f70252i.length == 0) {
            this.f70248e = 0;
        } else {
            this.f70248e = 3;
        }
    }
}
