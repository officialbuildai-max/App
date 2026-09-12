package j9;

import g9.a;
import g9.m;
import g9.s;
import g9.v;
import java.util.Objects;

/* loaded from: classes4.dex */
final class b extends g9.a {

    /* renamed from: j9.b$b, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static final class C0827b implements a.f {

        /* renamed from: a, reason: collision with root package name */
        private final v f66077a;

        /* renamed from: b, reason: collision with root package name */
        private final int f66078b;

        /* renamed from: c, reason: collision with root package name */
        private final s.a f66079c;

        private C0827b(v vVar, int i11) {
            this.f66077a = vVar;
            this.f66078b = i11;
            this.f66079c = new s.a();
        }

        private long c(m mVar) {
            while (mVar.getPeekPosition() < mVar.getLength() - 6 && !s.h(mVar, this.f66077a, this.f66078b, this.f66079c)) {
                mVar.advancePeekPosition(1);
            }
            if (mVar.getPeekPosition() < mVar.getLength() - 6) {
                return this.f66079c.f63578a;
            }
            mVar.advancePeekPosition((int) (mVar.getLength() - mVar.getPeekPosition()));
            return this.f66077a.f63591j;
        }

        @Override // g9.a.f
        public /* synthetic */ void a() {
            g9.b.a(this);
        }

        @Override // g9.a.f
        public a.e b(m mVar, long j11) {
            long position = mVar.getPosition();
            long c11 = c(mVar);
            long peekPosition = mVar.getPeekPosition();
            mVar.advancePeekPosition(Math.max(6, this.f66077a.f63584c));
            long c12 = c(mVar);
            return (c11 > j11 || c12 <= j11) ? c12 <= j11 ? a.e.f(c12, mVar.getPeekPosition()) : a.e.d(c11, position) : a.e.e(peekPosition);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(final v vVar, int i11, long j11, long j12) {
        super(new a.d() { // from class: j9.a
            @Override // g9.a.d
            public final long a(long j13) {
                return v.this.i(j13);
            }
        }, new C0827b(vVar, i11), vVar.f(), 0L, vVar.f63591j, j11, j12, vVar.d(), Math.max(6, vVar.f63584c));
        Objects.requireNonNull(vVar);
    }
}
