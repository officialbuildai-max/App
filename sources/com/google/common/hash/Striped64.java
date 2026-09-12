package com.google.common.hash;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Random;
import sun.misc.Unsafe;

/* loaded from: classes4.dex */
abstract class Striped64 extends Number {

    /* renamed from: a, reason: collision with root package name */
    private static final Unsafe f30925a;

    /* renamed from: b, reason: collision with root package name */
    private static final long f30926b;

    /* renamed from: c, reason: collision with root package name */
    private static final long f30927c;
    volatile transient long base;
    volatile transient int busy;
    volatile transient b[] cells;
    static final ThreadLocal<int[]> threadHashCode = new ThreadLocal<>();
    static final Random rng = new Random();
    static final int NCPU = Runtime.getRuntime().availableProcessors();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements PrivilegedExceptionAction {
        a() {
        }

        @Override // java.security.PrivilegedExceptionAction
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unsafe run() {
            for (Field field : Unsafe.class.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj = field.get(null);
                if (Unsafe.class.isInstance(obj)) {
                    return (Unsafe) Unsafe.class.cast(obj);
                }
            }
            throw new NoSuchFieldError("the Unsafe");
        }
    }

    /* loaded from: classes4.dex */
    static final class b {

        /* renamed from: b, reason: collision with root package name */
        private static final Unsafe f30928b;

        /* renamed from: c, reason: collision with root package name */
        private static final long f30929c;

        /* renamed from: a, reason: collision with root package name */
        volatile long f30930a;

        static {
            try {
                Unsafe access$000 = Striped64.access$000();
                f30928b = access$000;
                f30929c = access$000.objectFieldOffset(b.class.getDeclaredField("a"));
            } catch (Exception e11) {
                throw new Error(e11);
            }
        }

        b(long j11) {
            this.f30930a = j11;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final boolean a(long j11, long j12) {
            return f30928b.compareAndSwapLong(this, f30929c, j11, j12);
        }
    }

    static {
        try {
            Unsafe a11 = a();
            f30925a = a11;
            f30926b = a11.objectFieldOffset(Striped64.class.getDeclaredField("base"));
            f30927c = a11.objectFieldOffset(Striped64.class.getDeclaredField("busy"));
        } catch (Exception e11) {
            throw new Error(e11);
        }
    }

    private static Unsafe a() {
        try {
            try {
                return Unsafe.getUnsafe();
            } catch (PrivilegedActionException e11) {
                throw new RuntimeException("Could not initialize intrinsics", e11.getCause());
            }
        } catch (SecurityException unused) {
            return (Unsafe) AccessController.doPrivileged(new a());
        }
    }

    static /* synthetic */ Unsafe access$000() {
        return a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean casBase(long j11, long j12) {
        return f30925a.compareAndSwapLong(this, f30926b, j11, j12);
    }

    final boolean casBusy() {
        return f30925a.compareAndSwapInt(this, f30927c, 0, 1);
    }

    abstract long fn(long j11, long j12);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void internalReset(long j11) {
        b[] bVarArr = this.cells;
        this.base = j11;
        if (bVarArr != null) {
            for (b bVar : bVarArr) {
                if (bVar != null) {
                    bVar.f30930a = j11;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:106:0x00f1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0023 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void retryUpdate(long r17, int[] r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 242
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.hash.Striped64.retryUpdate(long, int[], boolean):void");
    }
}
