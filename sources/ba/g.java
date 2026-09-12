package ba;

import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/* loaded from: classes3.dex */
public final class g implements j {

    /* renamed from: a, reason: collision with root package name */
    private final c f16370a = new c();

    /* renamed from: b, reason: collision with root package name */
    private final m f16371b = new m();

    /* renamed from: c, reason: collision with root package name */
    private final Deque f16372c = new ArrayDeque();

    /* renamed from: d, reason: collision with root package name */
    private int f16373d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f16374e;

    /* loaded from: classes3.dex */
    class a extends n {
        a() {
        }

        @Override // com.google.android.exoplayer2.decoder.f
        public void l() {
            g.this.e(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class b implements i {

        /* renamed from: a, reason: collision with root package name */
        private final long f16376a;

        /* renamed from: b, reason: collision with root package name */
        private final ImmutableList f16377b;

        public b(long j11, ImmutableList immutableList) {
            this.f16376a = j11;
            this.f16377b = immutableList;
        }

        @Override // ba.i
        public List getCues(long j11) {
            return j11 >= this.f16376a ? this.f16377b : ImmutableList.of();
        }

        @Override // ba.i
        public long getEventTime(int i11) {
            com.google.android.exoplayer2.util.a.a(i11 == 0);
            return this.f16376a;
        }

        @Override // ba.i
        public int getEventTimeCount() {
            return 1;
        }

        @Override // ba.i
        public int getNextEventTimeIndex(long j11) {
            return this.f16376a > j11 ? 0 : -1;
        }
    }

    public g() {
        for (int i11 = 0; i11 < 2; i11++) {
            this.f16372c.addFirst(new a());
        }
        this.f16373d = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(n nVar) {
        com.google.android.exoplayer2.util.a.g(this.f16372c.size() < 2);
        com.google.android.exoplayer2.util.a.a(!this.f16372c.contains(nVar));
        nVar.b();
        this.f16372c.addFirst(nVar);
    }

    @Override // com.google.android.exoplayer2.decoder.d
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public m dequeueInputBuffer() {
        com.google.android.exoplayer2.util.a.g(!this.f16374e);
        if (this.f16373d != 0) {
            return null;
        }
        this.f16373d = 1;
        return this.f16371b;
    }

    @Override // com.google.android.exoplayer2.decoder.d
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public n dequeueOutputBuffer() {
        com.google.android.exoplayer2.util.a.g(!this.f16374e);
        if (this.f16373d != 2 || this.f16372c.isEmpty()) {
            return null;
        }
        n nVar = (n) this.f16372c.removeFirst();
        if (this.f16371b.h()) {
            nVar.a(4);
        } else {
            m mVar = this.f16371b;
            nVar.m(this.f16371b.f24899e, new b(mVar.f24899e, this.f16370a.a(((ByteBuffer) com.google.android.exoplayer2.util.a.e(mVar.f24897c)).array())), 0L);
        }
        this.f16371b.b();
        this.f16373d = 0;
        return nVar;
    }

    @Override // com.google.android.exoplayer2.decoder.d
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void queueInputBuffer(m mVar) {
        com.google.android.exoplayer2.util.a.g(!this.f16374e);
        com.google.android.exoplayer2.util.a.g(this.f16373d == 1);
        com.google.android.exoplayer2.util.a.a(this.f16371b == mVar);
        this.f16373d = 2;
    }

    @Override // com.google.android.exoplayer2.decoder.d
    public void flush() {
        com.google.android.exoplayer2.util.a.g(!this.f16374e);
        this.f16371b.b();
        this.f16373d = 0;
    }

    @Override // com.google.android.exoplayer2.decoder.d
    public void release() {
        this.f16374e = true;
    }

    @Override // ba.j
    public void setPositionUs(long j11) {
    }
}
