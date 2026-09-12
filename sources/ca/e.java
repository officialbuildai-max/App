package ca;

import ba.i;
import ba.j;
import ba.m;
import ba.n;
import ca.e;
import com.google.android.exoplayer2.decoder.f;
import com.google.android.exoplayer2.util.p0;
import java.util.ArrayDeque;
import java.util.PriorityQueue;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public abstract class e implements j {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayDeque f17180a = new ArrayDeque();

    /* renamed from: b, reason: collision with root package name */
    private final ArrayDeque f17181b;

    /* renamed from: c, reason: collision with root package name */
    private final PriorityQueue f17182c;

    /* renamed from: d, reason: collision with root package name */
    private b f17183d;

    /* renamed from: e, reason: collision with root package name */
    private long f17184e;

    /* renamed from: f, reason: collision with root package name */
    private long f17185f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class b extends m implements Comparable {

        /* renamed from: j, reason: collision with root package name */
        private long f17186j;

        private b() {
        }

        @Override // java.lang.Comparable
        /* renamed from: s, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            if (h() != bVar.h()) {
                return h() ? 1 : -1;
            }
            long j11 = this.f24899e - bVar.f24899e;
            if (j11 == 0) {
                j11 = this.f17186j - bVar.f17186j;
                if (j11 == 0) {
                    return 0;
                }
            }
            return j11 > 0 ? 1 : -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class c extends n {

        /* renamed from: f, reason: collision with root package name */
        private f.a f17187f;

        public c(f.a aVar) {
            this.f17187f = aVar;
        }

        @Override // com.google.android.exoplayer2.decoder.f
        public final void l() {
            this.f17187f.a(this);
        }
    }

    public e() {
        for (int i11 = 0; i11 < 10; i11++) {
            this.f17180a.add(new b());
        }
        this.f17181b = new ArrayDeque();
        for (int i12 = 0; i12 < 2; i12++) {
            this.f17181b.add(new c(new f.a() { // from class: ca.d
                @Override // com.google.android.exoplayer2.decoder.f.a
                public final void a(com.google.android.exoplayer2.decoder.f fVar) {
                    e.this.j((e.c) fVar);
                }
            }));
        }
        this.f17182c = new PriorityQueue();
    }

    private void i(b bVar) {
        bVar.b();
        this.f17180a.add(bVar);
    }

    protected abstract i a();

    protected abstract void b(m mVar);

    @Override // com.google.android.exoplayer2.decoder.d
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public m dequeueInputBuffer() {
        com.google.android.exoplayer2.util.a.g(this.f17183d == null);
        if (this.f17180a.isEmpty()) {
            return null;
        }
        b bVar = (b) this.f17180a.pollFirst();
        this.f17183d = bVar;
        return bVar;
    }

    @Override // com.google.android.exoplayer2.decoder.d
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public n dequeueOutputBuffer() {
        if (this.f17181b.isEmpty()) {
            return null;
        }
        while (!this.f17182c.isEmpty() && ((b) p0.j((b) this.f17182c.peek())).f24899e <= this.f17184e) {
            b bVar = (b) p0.j((b) this.f17182c.poll());
            if (bVar.h()) {
                n nVar = (n) p0.j((n) this.f17181b.pollFirst());
                nVar.a(4);
                i(bVar);
                return nVar;
            }
            b(bVar);
            if (g()) {
                i a11 = a();
                n nVar2 = (n) p0.j((n) this.f17181b.pollFirst());
                nVar2.m(bVar.f24899e, a11, Long.MAX_VALUE);
                i(bVar);
                return nVar2;
            }
            i(bVar);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final n e() {
        return (n) this.f17181b.pollFirst();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long f() {
        return this.f17184e;
    }

    @Override // com.google.android.exoplayer2.decoder.d
    public void flush() {
        this.f17185f = 0L;
        this.f17184e = 0L;
        while (!this.f17182c.isEmpty()) {
            i((b) p0.j((b) this.f17182c.poll()));
        }
        b bVar = this.f17183d;
        if (bVar != null) {
            i(bVar);
            this.f17183d = null;
        }
    }

    protected abstract boolean g();

    @Override // com.google.android.exoplayer2.decoder.d
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void queueInputBuffer(m mVar) {
        com.google.android.exoplayer2.util.a.a(mVar == this.f17183d);
        b bVar = (b) mVar;
        if (bVar.g()) {
            i(bVar);
        } else {
            long j11 = this.f17185f;
            this.f17185f = 1 + j11;
            bVar.f17186j = j11;
            this.f17182c.add(bVar);
        }
        this.f17183d = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(n nVar) {
        nVar.b();
        this.f17181b.add(nVar);
    }

    @Override // com.google.android.exoplayer2.decoder.d
    public void release() {
    }

    @Override // ba.j
    public void setPositionUs(long j11) {
        this.f17184e = j11;
    }
}
