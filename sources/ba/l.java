package ba;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import com.google.common.primitives.Ints;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import g9.a0;
import g9.e0;
import g9.z;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class l implements g9.l {

    /* renamed from: a, reason: collision with root package name */
    private final j f16381a;

    /* renamed from: d, reason: collision with root package name */
    private final o1 f16384d;

    /* renamed from: g, reason: collision with root package name */
    private g9.n f16387g;

    /* renamed from: h, reason: collision with root package name */
    private e0 f16388h;

    /* renamed from: i, reason: collision with root package name */
    private int f16389i;

    /* renamed from: b, reason: collision with root package name */
    private final d f16382b = new d();

    /* renamed from: c, reason: collision with root package name */
    private final d0 f16383c = new d0();

    /* renamed from: e, reason: collision with root package name */
    private final List f16385e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private final List f16386f = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    private int f16390j = 0;

    /* renamed from: k, reason: collision with root package name */
    private long f16391k = C.TIME_UNSET;

    public l(j jVar, o1 o1Var) {
        this.f16381a = jVar;
        this.f16384d = o1Var.b().e0("text/x-exoplayer-cues").I(o1Var.f25550l).E();
    }

    private void a() {
        try {
            m mVar = (m) this.f16381a.dequeueInputBuffer();
            while (mVar == null) {
                Thread.sleep(5L);
                mVar = (m) this.f16381a.dequeueInputBuffer();
            }
            mVar.m(this.f16389i);
            mVar.f24897c.put(this.f16383c.d(), 0, this.f16389i);
            mVar.f24897c.limit(this.f16389i);
            this.f16381a.queueInputBuffer(mVar);
            n nVar = (n) this.f16381a.dequeueOutputBuffer();
            while (nVar == null) {
                Thread.sleep(5L);
                nVar = (n) this.f16381a.dequeueOutputBuffer();
            }
            for (int i11 = 0; i11 < nVar.getEventTimeCount(); i11++) {
                byte[] a11 = this.f16382b.a(nVar.getCues(nVar.getEventTime(i11)));
                this.f16385e.add(Long.valueOf(nVar.getEventTime(i11)));
                this.f16386f.add(new d0(a11));
            }
            nVar.l();
        } catch (SubtitleDecoderException e11) {
            throw ParserException.createForMalformedContainer("SubtitleDecoder failed.", e11);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    private boolean e(g9.m mVar) {
        int b11 = this.f16383c.b();
        int i11 = this.f16389i;
        if (b11 == i11) {
            this.f16383c.c(i11 + 1024);
        }
        int read = mVar.read(this.f16383c.d(), this.f16389i, this.f16383c.b() - this.f16389i);
        if (read != -1) {
            this.f16389i += read;
        }
        long length = mVar.getLength();
        return (length != -1 && ((long) this.f16389i) == length) || read == -1;
    }

    private boolean f(g9.m mVar) {
        return mVar.skip((mVar.getLength() > (-1L) ? 1 : (mVar.getLength() == (-1L) ? 0 : -1)) != 0 ? Ints.d(mVar.getLength()) : 1024) == -1;
    }

    private void g() {
        com.google.android.exoplayer2.util.a.i(this.f16388h);
        com.google.android.exoplayer2.util.a.g(this.f16385e.size() == this.f16386f.size());
        long j11 = this.f16391k;
        for (int g11 = j11 == C.TIME_UNSET ? 0 : p0.g(this.f16385e, Long.valueOf(j11), true, true); g11 < this.f16386f.size(); g11++) {
            d0 d0Var = (d0) this.f16386f.get(g11);
            d0Var.P(0);
            int length = d0Var.d().length;
            this.f16388h.c(d0Var, length);
            this.f16388h.d(((Long) this.f16385e.get(g11)).longValue(), 1, length, 0, null);
        }
    }

    @Override // g9.l
    public void b(g9.n nVar) {
        com.google.android.exoplayer2.util.a.g(this.f16390j == 0);
        this.f16387g = nVar;
        this.f16388h = nVar.track(0, 3);
        this.f16387g.endTracks();
        this.f16387g.d(new z(new long[]{0}, new long[]{0}, C.TIME_UNSET));
        this.f16388h.e(this.f16384d);
        this.f16390j = 1;
    }

    @Override // g9.l
    public int c(g9.m mVar, a0 a0Var) {
        int i11 = this.f16390j;
        com.google.android.exoplayer2.util.a.g((i11 == 0 || i11 == 5) ? false : true);
        if (this.f16390j == 1) {
            this.f16383c.L(mVar.getLength() != -1 ? Ints.d(mVar.getLength()) : 1024);
            this.f16389i = 0;
            this.f16390j = 2;
        }
        if (this.f16390j == 2 && e(mVar)) {
            a();
            g();
            this.f16390j = 4;
        }
        if (this.f16390j == 3 && f(mVar)) {
            g();
            this.f16390j = 4;
        }
        return this.f16390j == 4 ? -1 : 0;
    }

    @Override // g9.l
    public boolean d(g9.m mVar) {
        return true;
    }

    @Override // g9.l
    public void release() {
        if (this.f16390j == 5) {
            return;
        }
        this.f16381a.release();
        this.f16390j = 5;
    }

    @Override // g9.l
    public void seek(long j11, long j12) {
        int i11 = this.f16390j;
        com.google.android.exoplayer2.util.a.g((i11 == 0 || i11 == 5) ? false : true);
        this.f16391k = j12;
        if (this.f16390j == 2) {
            this.f16390j = 1;
        }
        if (this.f16390j == 4) {
            this.f16390j = 3;
        }
    }
}
