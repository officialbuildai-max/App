package m6;

import androidx.recyclerview.widget.DiffUtil;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final Executor f69458a;

    /* renamed from: b, reason: collision with root package name */
    private final Executor f69459b;

    /* renamed from: c, reason: collision with root package name */
    private final DiffUtil.e f69460c;

    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: d, reason: collision with root package name */
        public static final C0864a f69461d = new C0864a(null);

        /* renamed from: e, reason: collision with root package name */
        private static final Object f69462e = new Object();

        /* renamed from: f, reason: collision with root package name */
        private static Executor f69463f;

        /* renamed from: a, reason: collision with root package name */
        private final DiffUtil.e f69464a;

        /* renamed from: b, reason: collision with root package name */
        private Executor f69465b;

        /* renamed from: c, reason: collision with root package name */
        private Executor f69466c;

        /* renamed from: m6.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0864a {
            private C0864a() {
            }

            public /* synthetic */ C0864a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public a(DiffUtil.e mDiffCallback) {
            Intrinsics.h(mDiffCallback, "mDiffCallback");
            this.f69464a = mDiffCallback;
        }

        public final d a() {
            if (this.f69466c == null) {
                synchronized (f69462e) {
                    try {
                        if (f69463f == null) {
                            f69463f = Executors.newFixedThreadPool(2);
                        }
                        Unit unit = Unit.f67184a;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                this.f69466c = f69463f;
            }
            Executor executor = this.f69465b;
            Executor executor2 = this.f69466c;
            Intrinsics.e(executor2);
            return new d(executor, executor2, this.f69464a);
        }
    }

    public d(Executor executor, Executor backgroundThreadExecutor, DiffUtil.e diffCallback) {
        Intrinsics.h(backgroundThreadExecutor, "backgroundThreadExecutor");
        Intrinsics.h(diffCallback, "diffCallback");
        this.f69458a = executor;
        this.f69459b = backgroundThreadExecutor;
        this.f69460c = diffCallback;
    }

    public final Executor a() {
        return this.f69459b;
    }

    public final DiffUtil.e b() {
        return this.f69460c;
    }

    public final Executor c() {
        return this.f69458a;
    }
}
