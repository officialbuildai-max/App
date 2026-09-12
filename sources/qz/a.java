package qz;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.schedulers.IoScheduler;
import io.reactivex.rxjava3.internal.schedulers.TrampolineScheduler;
import java.util.concurrent.Executor;
import lz.k;

/* loaded from: classes7.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    static final Scheduler f74022a = pz.a.i(new h());

    /* renamed from: b, reason: collision with root package name */
    static final Scheduler f74023b = pz.a.f(new b());

    /* renamed from: c, reason: collision with root package name */
    static final Scheduler f74024c = pz.a.g(new c());

    /* renamed from: d, reason: collision with root package name */
    static final Scheduler f74025d = TrampolineScheduler.g();

    /* renamed from: e, reason: collision with root package name */
    static final Scheduler f74026e = pz.a.h(new f());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: qz.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0926a {

        /* renamed from: a, reason: collision with root package name */
        static final Scheduler f74027a = new io.reactivex.rxjava3.internal.schedulers.a();
    }

    /* loaded from: classes7.dex */
    static final class b implements k {
        b() {
        }

        @Override // lz.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Scheduler get() {
            return C0926a.f74027a;
        }
    }

    /* loaded from: classes7.dex */
    static final class c implements k {
        c() {
        }

        @Override // lz.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Scheduler get() {
            return d.f74028a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        static final Scheduler f74028a = new IoScheduler();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        static final Scheduler f74029a = new io.reactivex.rxjava3.internal.schedulers.d();
    }

    /* loaded from: classes7.dex */
    static final class f implements k {
        f() {
        }

        @Override // lz.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Scheduler get() {
            return e.f74029a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class g {

        /* renamed from: a, reason: collision with root package name */
        static final Scheduler f74030a = new io.reactivex.rxjava3.internal.schedulers.h();
    }

    /* loaded from: classes7.dex */
    static final class h implements k {
        h() {
        }

        @Override // lz.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Scheduler get() {
            return g.f74030a;
        }
    }

    public static Scheduler a(Executor executor) {
        return b(executor, false, false);
    }

    public static Scheduler b(Executor executor, boolean z10, boolean z11) {
        return pz.a.e(executor, z10, z11);
    }

    public static Scheduler c() {
        return pz.a.s(f74024c);
    }

    public static Scheduler d() {
        return pz.a.u(f74022a);
    }
}
