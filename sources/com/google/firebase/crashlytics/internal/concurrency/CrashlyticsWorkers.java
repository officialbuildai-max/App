package com.google.firebase.crashlytics.internal.concurrency;

import android.os.Looper;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ob.g;

/* loaded from: classes4.dex */
public final class CrashlyticsWorkers {

    /* renamed from: e, reason: collision with root package name */
    public static final Companion f31349e = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    private static boolean f31350f;

    /* renamed from: a, reason: collision with root package name */
    public final e f31351a;

    /* renamed from: b, reason: collision with root package name */
    public final e f31352b;

    /* renamed from: c, reason: collision with root package name */
    public final e f31353c;

    /* renamed from: d, reason: collision with root package name */
    public final e f31354d;

    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void h(Function0 function0, Function0 function02) {
            if (((Boolean) function0.invoke()).booleanValue()) {
                return;
            }
            g.f().b((String) function02.invoke());
            i();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String j() {
            return Thread.currentThread().getName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean k() {
            String threadName = j();
            Intrinsics.g(threadName, "threadName");
            return StringsKt.c0(threadName, "Firebase Background Thread #", false, 2, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean l() {
            String threadName = j();
            Intrinsics.g(threadName, "threadName");
            return StringsKt.c0(threadName, "Firebase Blocking Thread #", false, 2, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean m() {
            return !Looper.getMainLooper().isCurrentThread();
        }

        public final void e() {
            h(new CrashlyticsWorkers$Companion$checkBackgroundThread$1(this), new Function0<String>() { // from class: com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers$Companion$checkBackgroundThread$2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String j11;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Must be called on a background thread, was called on ");
                    j11 = CrashlyticsWorkers.f31349e.j();
                    sb2.append(j11);
                    sb2.append('.');
                    return sb2.toString();
                }
            });
        }

        public final void f() {
            h(new CrashlyticsWorkers$Companion$checkBlockingThread$1(this), new Function0<String>() { // from class: com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers$Companion$checkBlockingThread$2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String j11;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Must be called on a blocking thread, was called on ");
                    j11 = CrashlyticsWorkers.f31349e.j();
                    sb2.append(j11);
                    sb2.append('.');
                    return sb2.toString();
                }
            });
        }

        public final void g() {
            h(new CrashlyticsWorkers$Companion$checkNotMainThread$1(this), new Function0<String>() { // from class: com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers$Companion$checkNotMainThread$2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String j11;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Must not be called on a main thread, was called on ");
                    j11 = CrashlyticsWorkers.f31349e.j();
                    sb2.append(j11);
                    sb2.append('.');
                    return sb2.toString();
                }
            });
        }

        public final boolean i() {
            return CrashlyticsWorkers.f31350f;
        }

        public final void n(boolean z10) {
            CrashlyticsWorkers.f31350f = z10;
        }
    }

    public CrashlyticsWorkers(ExecutorService backgroundExecutorService, ExecutorService blockingExecutorService) {
        Intrinsics.h(backgroundExecutorService, "backgroundExecutorService");
        Intrinsics.h(blockingExecutorService, "blockingExecutorService");
        this.f31351a = new e(backgroundExecutorService);
        this.f31352b = new e(backgroundExecutorService);
        this.f31353c = new e(backgroundExecutorService);
        this.f31354d = new e(blockingExecutorService);
    }

    public static final void c() {
        f31349e.e();
    }

    public static final void d() {
        f31349e.f();
    }

    public static final void e() {
        f31349e.g();
    }

    public static final void f(boolean z10) {
        f31349e.n(z10);
    }
}
