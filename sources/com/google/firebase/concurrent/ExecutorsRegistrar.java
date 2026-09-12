package com.google.firebase.concurrent;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.StrictMode;
import com.google.firebase.components.ComponentRegistrar;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import mb.b0;

@SuppressLint({"ThreadPoolCreation"})
/* loaded from: classes.dex */
public class ExecutorsRegistrar implements ComponentRegistrar {

    /* renamed from: a, reason: collision with root package name */
    static final mb.u f31124a = new mb.u(new ic.b() { // from class: com.google.firebase.concurrent.r
        @Override // ic.b
        public final Object get() {
            ScheduledExecutorService p11;
            p11 = ExecutorsRegistrar.p();
            return p11;
        }
    });

    /* renamed from: b, reason: collision with root package name */
    static final mb.u f31125b = new mb.u(new ic.b() { // from class: com.google.firebase.concurrent.s
        @Override // ic.b
        public final Object get() {
            ScheduledExecutorService q11;
            q11 = ExecutorsRegistrar.q();
            return q11;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    static final mb.u f31126c = new mb.u(new ic.b() { // from class: com.google.firebase.concurrent.t
        @Override // ic.b
        public final Object get() {
            ScheduledExecutorService r11;
            r11 = ExecutorsRegistrar.r();
            return r11;
        }
    });

    /* renamed from: d, reason: collision with root package name */
    static final mb.u f31127d = new mb.u(new ic.b() { // from class: com.google.firebase.concurrent.u
        @Override // ic.b
        public final Object get() {
            ScheduledExecutorService s11;
            s11 = ExecutorsRegistrar.s();
            return s11;
        }
    });

    private static StrictMode.ThreadPolicy i() {
        StrictMode.ThreadPolicy.Builder detectNetwork = new StrictMode.ThreadPolicy.Builder().detectNetwork();
        int i11 = Build.VERSION.SDK_INT;
        detectNetwork.detectResourceMismatches();
        if (i11 >= 26) {
            detectNetwork.detectUnbufferedIo();
        }
        return detectNetwork.penaltyLog().build();
    }

    private static ThreadFactory j(String str, int i11) {
        return new b(str, i11, null);
    }

    private static ThreadFactory k(String str, int i11, StrictMode.ThreadPolicy threadPolicy) {
        return new b(str, i11, threadPolicy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ScheduledExecutorService l(mb.e eVar) {
        return (ScheduledExecutorService) f31124a.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ScheduledExecutorService m(mb.e eVar) {
        return (ScheduledExecutorService) f31126c.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ScheduledExecutorService n(mb.e eVar) {
        return (ScheduledExecutorService) f31125b.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Executor o(mb.e eVar) {
        return UiExecutor.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ScheduledExecutorService p() {
        return u(Executors.newFixedThreadPool(4, k("Firebase Background", 10, i())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ScheduledExecutorService q() {
        return u(Executors.newFixedThreadPool(Math.max(2, Runtime.getRuntime().availableProcessors()), k("Firebase Lite", 0, t())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ScheduledExecutorService r() {
        return u(Executors.newCachedThreadPool(j("Firebase Blocking", 11)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ScheduledExecutorService s() {
        return Executors.newSingleThreadScheduledExecutor(j("Firebase Scheduler", 0));
    }

    private static StrictMode.ThreadPolicy t() {
        return new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build();
    }

    private static ScheduledExecutorService u(ExecutorService executorService) {
        return new o(executorService, (ScheduledExecutorService) f31127d.get());
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List getComponents() {
        return Arrays.asList(mb.c.f(b0.a(lb.a.class, ScheduledExecutorService.class), b0.a(lb.a.class, ExecutorService.class), b0.a(lb.a.class, Executor.class)).f(new mb.h() { // from class: com.google.firebase.concurrent.v
            @Override // mb.h
            public final Object a(mb.e eVar) {
                ScheduledExecutorService l11;
                l11 = ExecutorsRegistrar.l(eVar);
                return l11;
            }
        }).d(), mb.c.f(b0.a(lb.b.class, ScheduledExecutorService.class), b0.a(lb.b.class, ExecutorService.class), b0.a(lb.b.class, Executor.class)).f(new mb.h() { // from class: com.google.firebase.concurrent.w
            @Override // mb.h
            public final Object a(mb.e eVar) {
                ScheduledExecutorService m11;
                m11 = ExecutorsRegistrar.m(eVar);
                return m11;
            }
        }).d(), mb.c.f(b0.a(lb.c.class, ScheduledExecutorService.class), b0.a(lb.c.class, ExecutorService.class), b0.a(lb.c.class, Executor.class)).f(new mb.h() { // from class: com.google.firebase.concurrent.x
            @Override // mb.h
            public final Object a(mb.e eVar) {
                ScheduledExecutorService n11;
                n11 = ExecutorsRegistrar.n(eVar);
                return n11;
            }
        }).d(), mb.c.e(b0.a(lb.d.class, Executor.class)).f(new mb.h() { // from class: com.google.firebase.concurrent.y
            @Override // mb.h
            public final Object a(mb.e eVar) {
                Executor o11;
                o11 = ExecutorsRegistrar.o(eVar);
                return o11;
            }
        }).d());
    }
}
