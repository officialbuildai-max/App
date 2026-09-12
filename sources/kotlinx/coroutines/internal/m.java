package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes7.dex */
public final class m {

    /* renamed from: e, reason: collision with root package name */
    public static final a f67990e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f67991f = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "_next$volatile");

    /* renamed from: g, reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f67992g = AtomicLongFieldUpdater.newUpdater(m.class, "_state$volatile");

    /* renamed from: h, reason: collision with root package name */
    public static final z f67993h = new z("REMOVE_FROZEN");
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ long _state$volatile;

    /* renamed from: a, reason: collision with root package name */
    private final int f67994a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f67995b;

    /* renamed from: c, reason: collision with root package name */
    private final int f67996c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ AtomicReferenceArray f67997d;

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a(long j11) {
            return (j11 & 2305843009213693952L) != 0 ? 2 : 1;
        }

        public final long b(long j11, int i11) {
            return d(j11, 1073741823L) | i11;
        }

        public final long c(long j11, int i11) {
            return d(j11, 1152921503533105152L) | (i11 << 30);
        }

        public final long d(long j11, long j12) {
            return j11 & (~j12);
        }
    }

    /* loaded from: classes7.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f67998a;

        public b(int i11) {
            this.f67998a = i11;
        }
    }

    public m(int i11, boolean z10) {
        this.f67994a = i11;
        this.f67995b = z10;
        int i12 = i11 - 1;
        this.f67996c = i12;
        this.f67997d = new AtomicReferenceArray(i11);
        if (i12 > 1073741823) {
            throw new IllegalStateException("Check failed.");
        }
        if ((i11 & i12) != 0) {
            throw new IllegalStateException("Check failed.");
        }
    }

    private final m b(long j11) {
        m mVar = new m(this.f67994a * 2, this.f67995b);
        int i11 = (int) (1073741823 & j11);
        int i12 = (int) ((1152921503533105152L & j11) >> 30);
        while (true) {
            int i13 = this.f67996c;
            if ((i11 & i13) == (i13 & i12)) {
                f67992g.set(mVar, f67990e.d(j11, 1152921504606846976L));
                return mVar;
            }
            Object obj = f().get(this.f67996c & i11);
            if (obj == null) {
                obj = new b(i11);
            }
            mVar.f().set(mVar.f67996c & i11, obj);
            i11++;
        }
    }

    private final m c(long j11) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f67991f;
        while (true) {
            m mVar = (m) atomicReferenceFieldUpdater.get(this);
            if (mVar != null) {
                return mVar;
            }
            androidx.concurrent.futures.a.a(f67991f, this, null, b(j11));
        }
    }

    private final m e(int i11, Object obj) {
        Object obj2 = f().get(this.f67996c & i11);
        if (!(obj2 instanceof b) || ((b) obj2).f67998a != i11) {
            return null;
        }
        f().set(i11 & this.f67996c, obj);
        return this;
    }

    private final /* synthetic */ AtomicReferenceArray f() {
        return this.f67997d;
    }

    private final long k() {
        long j11;
        long j12;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f67992g;
        do {
            j11 = atomicLongFieldUpdater.get(this);
            if ((j11 & 1152921504606846976L) != 0) {
                return j11;
            }
            j12 = j11 | 1152921504606846976L;
        } while (!atomicLongFieldUpdater.compareAndSet(this, j11, j12));
        return j12;
    }

    private final m n(int i11, int i12) {
        long j11;
        int i13;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f67992g;
        do {
            j11 = atomicLongFieldUpdater.get(this);
            i13 = (int) (1073741823 & j11);
            if ((1152921504606846976L & j11) != 0) {
                return l();
            }
        } while (!f67992g.compareAndSet(this, j11, f67990e.b(j11, i12)));
        f().set(this.f67996c & i13, null);
        return null;
    }

    public final int a(Object obj) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f67992g;
        while (true) {
            long j11 = atomicLongFieldUpdater.get(this);
            if ((3458764513820540928L & j11) != 0) {
                return f67990e.a(j11);
            }
            int i11 = (int) (1073741823 & j11);
            int i12 = (int) ((1152921503533105152L & j11) >> 30);
            int i13 = this.f67996c;
            if (((i12 + 2) & i13) == (i11 & i13)) {
                return 1;
            }
            if (!this.f67995b && f().get(i12 & i13) != null) {
                int i14 = this.f67994a;
                if (i14 < 1024 || ((i12 - i11) & 1073741823) > (i14 >> 1)) {
                    break;
                }
            } else if (f67992g.compareAndSet(this, j11, f67990e.c(j11, (i12 + 1) & 1073741823))) {
                f().set(i12 & i13, obj);
                m mVar = this;
                while ((f67992g.get(mVar) & 1152921504606846976L) != 0 && (mVar = mVar.l().e(i12, obj)) != null) {
                }
                return 0;
            }
        }
        return 1;
    }

    public final boolean d() {
        long j11;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f67992g;
        do {
            j11 = atomicLongFieldUpdater.get(this);
            if ((j11 & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j11) != 0) {
                return false;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j11, j11 | 2305843009213693952L));
        return true;
    }

    public final int g() {
        long j11 = f67992g.get(this);
        return (((int) ((j11 & 1152921503533105152L) >> 30)) - ((int) (1073741823 & j11))) & 1073741823;
    }

    public final boolean j() {
        long j11 = f67992g.get(this);
        return ((int) (1073741823 & j11)) == ((int) ((j11 & 1152921503533105152L) >> 30));
    }

    public final m l() {
        return c(k());
    }

    public final Object m() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f67992g;
        while (true) {
            long j11 = atomicLongFieldUpdater.get(this);
            if ((1152921504606846976L & j11) != 0) {
                return f67993h;
            }
            int i11 = (int) (1073741823 & j11);
            int i12 = this.f67996c;
            if ((((int) ((1152921503533105152L & j11) >> 30)) & i12) == (i12 & i11)) {
                return null;
            }
            Object obj = f().get(this.f67996c & i11);
            if (obj == null) {
                if (this.f67995b) {
                    return null;
                }
            } else {
                if (obj instanceof b) {
                    return null;
                }
                int i13 = (i11 + 1) & 1073741823;
                if (f67992g.compareAndSet(this, j11, f67990e.b(j11, i13))) {
                    f().set(this.f67996c & i11, null);
                    return obj;
                }
                if (this.f67995b) {
                    m mVar = this;
                    do {
                        mVar = mVar.n(i11, i13);
                    } while (mVar != null);
                    return obj;
                }
            }
        }
    }
}
