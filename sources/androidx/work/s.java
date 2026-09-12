package androidx.work;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public abstract class s {

    /* renamed from: a, reason: collision with root package name */
    private Context f16128a;

    /* renamed from: b, reason: collision with root package name */
    private WorkerParameters f16129b;

    /* renamed from: c, reason: collision with root package name */
    private final AtomicInteger f16130c = new AtomicInteger(InputDeviceCompat.SOURCE_ANY);

    /* renamed from: d, reason: collision with root package name */
    private boolean f16131d;

    /* loaded from: classes2.dex */
    public static abstract class a {

        /* renamed from: androidx.work.s$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0144a extends a {

            /* renamed from: a, reason: collision with root package name */
            private final f f16132a;

            public C0144a() {
                this(f.f15566c);
            }

            public C0144a(f fVar) {
                this.f16132a = fVar;
            }

            public f d() {
                return this.f16132a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || C0144a.class != obj.getClass()) {
                    return false;
                }
                return this.f16132a.equals(((C0144a) obj).f16132a);
            }

            public int hashCode() {
                return (C0144a.class.getName().hashCode() * 31) + this.f16132a.hashCode();
            }

            public String toString() {
                return "Failure {mOutputData=" + this.f16132a + '}';
            }
        }

        /* loaded from: classes2.dex */
        public static final class b extends a {
            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && b.class == obj.getClass();
            }

            public int hashCode() {
                return b.class.getName().hashCode();
            }

            public String toString() {
                return "Retry";
            }
        }

        /* loaded from: classes2.dex */
        public static final class c extends a {

            /* renamed from: a, reason: collision with root package name */
            private final f f16133a;

            public c() {
                this(f.f15566c);
            }

            public c(f fVar) {
                this.f16133a = fVar;
            }

            public f d() {
                return this.f16133a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || c.class != obj.getClass()) {
                    return false;
                }
                return this.f16133a.equals(((c) obj).f16133a);
            }

            public int hashCode() {
                return (c.class.getName().hashCode() * 31) + this.f16133a.hashCode();
            }

            public String toString() {
                return "Success {mOutputData=" + this.f16133a + '}';
            }
        }

        a() {
        }

        public static a a() {
            return new C0144a();
        }

        public static a b() {
            return new b();
        }

        public static a c() {
            return new c();
        }
    }

    public s(Context context, WorkerParameters workerParameters) {
        if (context == null) {
            throw new IllegalArgumentException("Application Context is null");
        }
        if (workerParameters == null) {
            throw new IllegalArgumentException("WorkerParameters is null");
        }
        this.f16128a = context;
        this.f16129b = workerParameters;
    }

    public final Context a() {
        return this.f16128a;
    }

    public Executor b() {
        return this.f16129b.a();
    }

    public abstract com.google.common.util.concurrent.r c();

    public final UUID d() {
        return this.f16129b.c();
    }

    public final f e() {
        return this.f16129b.d();
    }

    public final int f() {
        return this.f16130c.get();
    }

    public m0 g() {
        return this.f16129b.g();
    }

    public final boolean h() {
        return this.f16130c.get() != -256;
    }

    public final boolean i() {
        return this.f16131d;
    }

    public void j() {
    }

    public final void k() {
        this.f16131d = true;
    }

    public abstract com.google.common.util.concurrent.r l();

    public final void m(int i11) {
        if (this.f16130c.compareAndSet(InputDeviceCompat.SOURCE_ANY, i11)) {
            j();
        }
    }
}
