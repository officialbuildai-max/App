package q2;

import java.util.Objects;
import l2.b0;
import l2.e;
import l2.f;
import l2.s;
import l2.y;

/* loaded from: classes2.dex */
final class b extends e {

    /* renamed from: q2.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static final class C0916b implements e.f {

        /* renamed from: a, reason: collision with root package name */
        private final b0 f73177a;

        /* renamed from: b, reason: collision with root package name */
        private final int f73178b;

        /* renamed from: c, reason: collision with root package name */
        private final y.a f73179c;

        private C0916b(b0 b0Var, int i11) {
            this.f73177a = b0Var;
            this.f73178b = i11;
            this.f73179c = new y.a();
        }

        private long c(s sVar) {
            while (sVar.getPeekPosition() < sVar.getLength() - 6 && !y.h(sVar, this.f73177a, this.f73178b, this.f73179c)) {
                sVar.advancePeekPosition(1);
            }
            if (sVar.getPeekPosition() < sVar.getLength() - 6) {
                return this.f73179c.f68836a;
            }
            sVar.advancePeekPosition((int) (sVar.getLength() - sVar.getPeekPosition()));
            return this.f73177a.f68633j;
        }

        @Override // l2.e.f
        public /* synthetic */ void a() {
            f.a(this);
        }

        @Override // l2.e.f
        public e.C0853e b(s sVar, long j11) {
            long position = sVar.getPosition();
            long c11 = c(sVar);
            long peekPosition = sVar.getPeekPosition();
            sVar.advancePeekPosition(Math.max(6, this.f73177a.f68626c));
            long c12 = c(sVar);
            return (c11 > j11 || c12 <= j11) ? c12 <= j11 ? e.C0853e.f(c12, sVar.getPeekPosition()) : e.C0853e.d(c11, position) : e.C0853e.e(peekPosition);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(final b0 b0Var, int i11, long j11, long j12) {
        super(new e.d() { // from class: q2.a
            @Override // l2.e.d
            public final long a(long j13) {
                return b0.this.i(j13);
            }
        }, new C0916b(b0Var, i11), b0Var.f(), 0L, b0Var.f68633j, j11, j12, b0Var.d(), Math.max(6, b0Var.f68626c));
        Objects.requireNonNull(b0Var);
    }
}
