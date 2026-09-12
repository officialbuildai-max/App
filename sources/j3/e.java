package j3;

import androidx.media3.common.util.a1;
import androidx.media3.decoder.h;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import i3.k;
import i3.l;
import i3.o;
import i3.p;
import j3.e;
import java.util.ArrayDeque;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class e implements l {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayDeque f66053a = new ArrayDeque();

    /* renamed from: b, reason: collision with root package name */
    private final ArrayDeque f66054b;

    /* renamed from: c, reason: collision with root package name */
    private final ArrayDeque f66055c;

    /* renamed from: d, reason: collision with root package name */
    private b f66056d;

    /* renamed from: e, reason: collision with root package name */
    private long f66057e;

    /* renamed from: f, reason: collision with root package name */
    private long f66058f;

    /* renamed from: g, reason: collision with root package name */
    private long f66059g;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b extends o implements Comparable {

        /* renamed from: j, reason: collision with root package name */
        private long f66060j;

        private b() {
        }

        @Override // java.lang.Comparable
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            if (isEndOfStream() != bVar.isEndOfStream()) {
                return isEndOfStream() ? 1 : -1;
            }
            long j11 = this.f11002e - bVar.f11002e;
            if (j11 == 0) {
                j11 = this.f66060j - bVar.f66060j;
                if (j11 == 0) {
                    return 0;
                }
            }
            return j11 > 0 ? 1 : -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class c extends p {

        /* renamed from: c, reason: collision with root package name */
        private h.a f66061c;

        public c(h.a aVar) {
            this.f66061c = aVar;
        }

        @Override // androidx.media3.decoder.h
        public final void release() {
            this.f66061c.a(this);
        }
    }

    public e() {
        for (int i11 = 0; i11 < 10; i11++) {
            this.f66053a.add(new b());
        }
        this.f66054b = new ArrayDeque();
        for (int i12 = 0; i12 < 2; i12++) {
            this.f66054b.add(new c(new h.a() { // from class: j3.d
                @Override // androidx.media3.decoder.h.a
                public final void a(h hVar) {
                    e.this.l((e.c) hVar);
                }
            }));
        }
        this.f66055c = new ArrayDeque();
        this.f66059g = C.TIME_UNSET;
    }

    private void k(b bVar) {
        bVar.clear();
        this.f66053a.add(bVar);
    }

    @Override // androidx.media3.decoder.g
    public final void a(long j11) {
        this.f66059g = j11;
    }

    protected abstract k c();

    protected abstract void d(o oVar);

    @Override // androidx.media3.decoder.g
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public o dequeueInputBuffer() {
        androidx.media3.common.util.a.g(this.f66056d == null);
        if (this.f66053a.isEmpty()) {
            return null;
        }
        b bVar = (b) this.f66053a.pollFirst();
        this.f66056d = bVar;
        return bVar;
    }

    @Override // androidx.media3.decoder.g
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public p dequeueOutputBuffer() {
        if (this.f66054b.isEmpty()) {
            return null;
        }
        while (!this.f66055c.isEmpty() && ((b) a1.i((b) this.f66055c.peek())).f11002e <= this.f66057e) {
            b bVar = (b) a1.i((b) this.f66055c.poll());
            if (bVar.isEndOfStream()) {
                p pVar = (p) a1.i((p) this.f66054b.pollFirst());
                pVar.addFlag(4);
                k(bVar);
                return pVar;
            }
            d(bVar);
            if (i()) {
                k c11 = c();
                p pVar2 = (p) a1.i((p) this.f66054b.pollFirst());
                pVar2.a(bVar.f11002e, c11, Long.MAX_VALUE);
                k(bVar);
                return pVar2;
            }
            k(bVar);
        }
        return null;
    }

    @Override // androidx.media3.decoder.g
    public void flush() {
        this.f66058f = 0L;
        this.f66057e = 0L;
        while (!this.f66055c.isEmpty()) {
            k((b) a1.i((b) this.f66055c.poll()));
        }
        b bVar = this.f66056d;
        if (bVar != null) {
            k(bVar);
            this.f66056d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final p g() {
        return (p) this.f66054b.pollFirst();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long h() {
        return this.f66057e;
    }

    protected abstract boolean i();

    @Override // androidx.media3.decoder.g
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void queueInputBuffer(o oVar) {
        androidx.media3.common.util.a.a(oVar == this.f66056d);
        b bVar = (b) oVar;
        if (!bVar.isEndOfStream()) {
            long j11 = bVar.f11002e;
            if (j11 != Long.MIN_VALUE) {
                long j12 = this.f66059g;
                if (j12 != C.TIME_UNSET && j11 < j12) {
                    k(bVar);
                    this.f66056d = null;
                }
            }
        }
        long j13 = this.f66058f;
        this.f66058f = 1 + j13;
        bVar.f66060j = j13;
        this.f66055c.add(bVar);
        this.f66056d = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(p pVar) {
        pVar.clear();
        this.f66054b.add(pVar);
    }

    @Override // androidx.media3.decoder.g
    public void release() {
    }

    @Override // i3.l
    public void setPositionUs(long j11) {
        this.f66057e = j11;
    }
}
