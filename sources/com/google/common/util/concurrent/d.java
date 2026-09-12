package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractFuture;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;

/* loaded from: classes4.dex */
abstract class d extends AbstractFuture.h {

    /* renamed from: c, reason: collision with root package name */
    private static final b f31075c;

    /* renamed from: d, reason: collision with root package name */
    private static final q f31076d = new q(d.class);

    /* renamed from: a, reason: collision with root package name */
    private volatile Set f31077a;

    /* renamed from: b, reason: collision with root package name */
    private volatile int f31078b;

    /* loaded from: classes4.dex */
    private static abstract class b {
        private b() {
        }
    }

    /* loaded from: classes4.dex */
    private static final class c extends b {

        /* renamed from: a, reason: collision with root package name */
        final AtomicReferenceFieldUpdater f31079a;

        /* renamed from: b, reason: collision with root package name */
        final AtomicIntegerFieldUpdater f31080b;

        c(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
            super();
            this.f31079a = atomicReferenceFieldUpdater;
            this.f31080b = atomicIntegerFieldUpdater;
        }
    }

    /* renamed from: com.google.common.util.concurrent.d$d, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static final class C0419d extends b {
        private C0419d() {
            super();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        b c0419d;
        Throwable th2 = null;
        Object[] objArr = 0;
        try {
            c0419d = new c(AtomicReferenceFieldUpdater.newUpdater(d.class, Set.class, "a"), AtomicIntegerFieldUpdater.newUpdater(d.class, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B));
        } catch (Throwable th3) {
            c0419d = new C0419d();
            th2 = th3;
        }
        f31075c = c0419d;
        if (th2 != null) {
            f31076d.a().log(Level.SEVERE, "SafeAtomicHelper is broken!", th2);
        }
    }
}
