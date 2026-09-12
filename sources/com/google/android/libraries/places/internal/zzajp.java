package com.google.android.libraries.places.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* loaded from: classes4.dex */
public abstract class zzajp<V> extends zzake implements zzaka<V> {
    static final boolean zza;
    static final zzajz zzb;
    private static final zza zzc;
    private static final Object zzd;
    private volatile zzd listeners;
    private volatile Object value;
    private volatile zzj waiters;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public abstract class zza {
        /* synthetic */ zza(zzajo zzajoVar) {
        }

        abstract zzd zza(zzajp zzajpVar, zzd zzdVar);

        abstract zzj zzb(zzajp zzajpVar, zzj zzjVar);

        abstract void zzc(zzj zzjVar, zzj zzjVar2);

        abstract void zzd(zzj zzjVar, Thread thread);

        abstract boolean zze(zzajp zzajpVar, zzd zzdVar, zzd zzdVar2);

        abstract boolean zzf(zzajp zzajpVar, Object obj, Object obj2);

        abstract boolean zzg(zzajp zzajpVar, zzj zzjVar, zzj zzjVar2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public final class zzb {
        static final zzb zza;
        static final zzb zzb;
        final boolean zzc;
        final Throwable zzd;

        static {
            if (zzajp.zza) {
                zzb = null;
                zza = null;
            } else {
                zzb = new zzb(false, null);
                zza = new zzb(true, null);
            }
        }

        zzb(boolean z10, Throwable th2) {
            this.zzc = z10;
            this.zzd = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public final class zzc {
        static final zzc zza = new zzc(new Throwable("Failure occurred while trying to finish a future.") { // from class: com.google.android.libraries.places.internal.zzajp.zzc.1
            {
                super("Failure occurred while trying to finish a future.");
            }

            @Override // java.lang.Throwable
            public final synchronized Throwable fillInStackTrace() {
                return this;
            }
        });
        final Throwable zzb;

        zzc(Throwable th2) {
            th2.getClass();
            this.zzb = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public final class zzd {
        static final zzd zza = new zzd();
        zzd next;
        final Runnable zzb;
        final Executor zzc;

        zzd() {
            this.zzb = null;
            this.zzc = null;
        }

        zzd(Runnable runnable, Executor executor) {
            this.zzb = runnable;
            this.zzc = executor;
        }
    }

    /* loaded from: classes4.dex */
    final class zze extends zza {
        final AtomicReferenceFieldUpdater<zzj, Thread> zza;
        final AtomicReferenceFieldUpdater<zzj, zzj> zzb;
        final AtomicReferenceFieldUpdater<zzajp, zzj> zzc;
        final AtomicReferenceFieldUpdater<zzajp, zzd> zzd;
        final AtomicReferenceFieldUpdater<zzajp, Object> zze;

        zze(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
            super(null);
            this.zza = atomicReferenceFieldUpdater;
            this.zzb = atomicReferenceFieldUpdater2;
            this.zzc = atomicReferenceFieldUpdater3;
            this.zzd = atomicReferenceFieldUpdater4;
            this.zze = atomicReferenceFieldUpdater5;
        }

        @Override // com.google.android.libraries.places.internal.zzajp.zza
        final zzd zza(zzajp zzajpVar, zzd zzdVar) {
            return this.zzd.getAndSet(zzajpVar, zzdVar);
        }

        @Override // com.google.android.libraries.places.internal.zzajp.zza
        final zzj zzb(zzajp zzajpVar, zzj zzjVar) {
            return this.zzc.getAndSet(zzajpVar, zzjVar);
        }

        @Override // com.google.android.libraries.places.internal.zzajp.zza
        final void zzc(zzj zzjVar, zzj zzjVar2) {
            this.zzb.lazySet(zzjVar, zzjVar2);
        }

        @Override // com.google.android.libraries.places.internal.zzajp.zza
        final void zzd(zzj zzjVar, Thread thread) {
            this.zza.lazySet(zzjVar, thread);
        }

        @Override // com.google.android.libraries.places.internal.zzajp.zza
        final boolean zze(zzajp zzajpVar, zzd zzdVar, zzd zzdVar2) {
            return zzajq.zza(this.zzd, zzajpVar, zzdVar, zzdVar2);
        }

        @Override // com.google.android.libraries.places.internal.zzajp.zza
        final boolean zzf(zzajp zzajpVar, Object obj, Object obj2) {
            return zzajq.zza(this.zze, zzajpVar, obj, obj2);
        }

        @Override // com.google.android.libraries.places.internal.zzajp.zza
        final boolean zzg(zzajp zzajpVar, zzj zzjVar, zzj zzjVar2) {
            return zzajq.zza(this.zzc, zzajpVar, zzjVar, zzjVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public final class zzf<V> implements Runnable {
        final zzajp<V> zza;
        final zzaka<? extends V> zzb;

        @Override // java.lang.Runnable
        public final void run() {
            throw null;
        }
    }

    /* loaded from: classes4.dex */
    final class zzg extends zza {
        private zzg() {
            throw null;
        }

        /* synthetic */ zzg(zzajr zzajrVar) {
            super(null);
        }

        @Override // com.google.android.libraries.places.internal.zzajp.zza
        final zzd zza(zzajp zzajpVar, zzd zzdVar) {
            zzd zzdVar2;
            synchronized (zzajpVar) {
                try {
                    zzdVar2 = zzajpVar.listeners;
                    if (zzdVar2 != zzdVar) {
                        zzajpVar.listeners = zzdVar;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return zzdVar2;
        }

        @Override // com.google.android.libraries.places.internal.zzajp.zza
        final zzj zzb(zzajp zzajpVar, zzj zzjVar) {
            zzj zzjVar2;
            synchronized (zzajpVar) {
                try {
                    zzjVar2 = zzajpVar.waiters;
                    if (zzjVar2 != zzjVar) {
                        zzajpVar.waiters = zzjVar;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return zzjVar2;
        }

        @Override // com.google.android.libraries.places.internal.zzajp.zza
        final void zzc(zzj zzjVar, zzj zzjVar2) {
            zzjVar.next = zzjVar2;
        }

        @Override // com.google.android.libraries.places.internal.zzajp.zza
        final void zzd(zzj zzjVar, Thread thread) {
            zzjVar.thread = thread;
        }

        @Override // com.google.android.libraries.places.internal.zzajp.zza
        final boolean zze(zzajp zzajpVar, zzd zzdVar, zzd zzdVar2) {
            synchronized (zzajpVar) {
                try {
                    if (zzajpVar.listeners != zzdVar) {
                        return false;
                    }
                    zzajpVar.listeners = zzdVar2;
                    return true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // com.google.android.libraries.places.internal.zzajp.zza
        final boolean zzf(zzajp zzajpVar, Object obj, Object obj2) {
            synchronized (zzajpVar) {
                try {
                    if (zzajpVar.value != obj) {
                        return false;
                    }
                    zzajpVar.value = obj2;
                    return true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // com.google.android.libraries.places.internal.zzajp.zza
        final boolean zzg(zzajp zzajpVar, zzj zzjVar, zzj zzjVar2) {
            synchronized (zzajpVar) {
                try {
                    if (zzajpVar.waiters != zzjVar) {
                        return false;
                    }
                    zzajpVar.waiters = zzjVar2;
                    return true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface zzh<V> extends zzaka<V> {
    }

    /* loaded from: classes4.dex */
    final class zzi extends zza {
        static final Unsafe zza;
        static final long zzb;
        static final long zzc;
        static final long zzd;
        static final long zze;
        static final long zzf;

        static {
            Unsafe unsafe;
            try {
                try {
                    unsafe = Unsafe.getUnsafe();
                } catch (PrivilegedActionException e11) {
                    throw new RuntimeException("Could not initialize intrinsics", e11.getCause());
                }
            } catch (SecurityException unused) {
                unsafe = (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: com.google.android.libraries.places.internal.zzajp.zzi.1
                    @Override // java.security.PrivilegedExceptionAction
                    public final /* bridge */ /* synthetic */ Unsafe run() throws Exception {
                        for (Field field : Unsafe.class.getDeclaredFields()) {
                            field.setAccessible(true);
                            Object obj = field.get(null);
                            if (Unsafe.class.isInstance(obj)) {
                                return (Unsafe) Unsafe.class.cast(obj);
                            }
                        }
                        throw new NoSuchFieldError("the Unsafe");
                    }
                });
            }
            try {
                zzc = unsafe.objectFieldOffset(zzajp.class.getDeclaredField("waiters"));
                zzb = unsafe.objectFieldOffset(zzajp.class.getDeclaredField("listeners"));
                zzd = unsafe.objectFieldOffset(zzajp.class.getDeclaredField(AppMeasurementSdk.ConditionalUserProperty.VALUE));
                zze = unsafe.objectFieldOffset(zzj.class.getDeclaredField("thread"));
                zzf = unsafe.objectFieldOffset(zzj.class.getDeclaredField("next"));
                zza = unsafe;
            } catch (NoSuchFieldException e12) {
                throw new RuntimeException(e12);
            }
        }

        private zzi() {
            throw null;
        }

        /* synthetic */ zzi(zzajt zzajtVar) {
            super(null);
        }

        @Override // com.google.android.libraries.places.internal.zzajp.zza
        final zzd zza(zzajp zzajpVar, zzd zzdVar) {
            zzd zzdVar2;
            do {
                zzdVar2 = zzajpVar.listeners;
                if (zzdVar == zzdVar2) {
                    break;
                }
            } while (!zze(zzajpVar, zzdVar2, zzdVar));
            return zzdVar2;
        }

        @Override // com.google.android.libraries.places.internal.zzajp.zza
        final zzj zzb(zzajp zzajpVar, zzj zzjVar) {
            zzj zzjVar2;
            do {
                zzjVar2 = zzajpVar.waiters;
                if (zzjVar == zzjVar2) {
                    break;
                }
            } while (!zzg(zzajpVar, zzjVar2, zzjVar));
            return zzjVar2;
        }

        @Override // com.google.android.libraries.places.internal.zzajp.zza
        final void zzc(zzj zzjVar, zzj zzjVar2) {
            zza.putObject(zzjVar, zzf, zzjVar2);
        }

        @Override // com.google.android.libraries.places.internal.zzajp.zza
        final void zzd(zzj zzjVar, Thread thread) {
            zza.putObject(zzjVar, zze, thread);
        }

        @Override // com.google.android.libraries.places.internal.zzajp.zza
        final boolean zze(zzajp zzajpVar, zzd zzdVar, zzd zzdVar2) {
            return zzajs.zza(zza, zzajpVar, zzb, zzdVar, zzdVar2);
        }

        @Override // com.google.android.libraries.places.internal.zzajp.zza
        final boolean zzf(zzajp zzajpVar, Object obj, Object obj2) {
            return zzajs.zza(zza, zzajpVar, zzd, obj, obj2);
        }

        @Override // com.google.android.libraries.places.internal.zzajp.zza
        final boolean zzg(zzajp zzajpVar, zzj zzjVar, zzj zzjVar2) {
            return zzajs.zza(zza, zzajpVar, zzc, zzjVar, zzjVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public final class zzj {
        static final zzj zza = new zzj(false);
        volatile zzj next;
        volatile Thread thread;

        zzj() {
            zzajp.zzc.zzd(this, Thread.currentThread());
        }

        zzj(boolean z10) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        boolean z10;
        Throwable th2;
        Throwable th3;
        zza zzgVar;
        try {
            z10 = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z10 = false;
        }
        zza = z10;
        zzb = new zzajz(zzajp.class);
        Object[] objArr = 0;
        try {
            zzgVar = new zzi(null);
            th3 = null;
            th2 = null;
        } catch (Error | Exception e11) {
            try {
                th2 = null;
                th3 = e11;
                zzgVar = new zze(AtomicReferenceFieldUpdater.newUpdater(zzj.class, Thread.class, "thread"), AtomicReferenceFieldUpdater.newUpdater(zzj.class, zzj.class, "next"), AtomicReferenceFieldUpdater.newUpdater(zzajp.class, zzj.class, "waiters"), AtomicReferenceFieldUpdater.newUpdater(zzajp.class, zzd.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(zzajp.class, Object.class, AppMeasurementSdk.ConditionalUserProperty.VALUE));
            } catch (Error | Exception e12) {
                th2 = e12;
                th3 = e11;
                zzgVar = new zzg(objArr == true ? 1 : 0);
            }
        }
        zzc = zzgVar;
        if (th2 != null) {
            zzajz zzajzVar = zzb;
            Logger zza2 = zzajzVar.zza();
            Level level = Level.SEVERE;
            zza2.logp(level, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "UnsafeAtomicHelper is broken!", th3);
            zzajzVar.zza().logp(level, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "SafeAtomicHelper is broken!", th2);
        }
        zzd = new Object();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Object zzn(zzaka zzakaVar) {
        Throwable zzf2;
        if (zzakaVar instanceof zzh) {
            Object obj = ((zzajp) zzakaVar).value;
            if (obj instanceof zzb) {
                zzb zzbVar = (zzb) obj;
                if (zzbVar.zzc) {
                    Throwable th2 = zzbVar.zzd;
                    obj = th2 != null ? new zzb(false, th2) : zzb.zzb;
                }
            }
            Objects.requireNonNull(obj);
            return obj;
        }
        if ((zzakaVar instanceof zzake) && (zzf2 = ((zzake) zzakaVar).zzf()) != null) {
            return new zzc(zzf2);
        }
        boolean isCancelled = zzakaVar.isCancelled();
        if ((!zza) && isCancelled) {
            zzb zzbVar2 = zzb.zzb;
            Objects.requireNonNull(zzbVar2);
            return zzbVar2;
        }
        try {
            Object zzo = zzo(zzakaVar);
            if (!isCancelled) {
                return zzo == null ? zzd : zzo;
            }
            return new zzb(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + String.valueOf(zzakaVar)));
        } catch (Error e11) {
            e = e11;
            return new zzc(e);
        } catch (CancellationException e12) {
            return !isCancelled ? new zzc(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: ".concat(String.valueOf(zzakaVar)), e12)) : new zzb(false, e12);
        } catch (ExecutionException e13) {
            return isCancelled ? new zzb(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: ".concat(String.valueOf(zzakaVar)), e13)) : new zzc(e13.getCause());
        } catch (Exception e14) {
            e = e14;
            return new zzc(e);
        }
    }

    private static Object zzo(Future future) throws ExecutionException {
        Object obj;
        boolean z10 = false;
        while (true) {
            try {
                obj = future.get();
                break;
            } catch (InterruptedException unused) {
                z10 = true;
            } catch (Throwable th2) {
                if (z10) {
                    Thread.currentThread().interrupt();
                }
                throw th2;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    private final void zzp(StringBuilder sb2) {
        try {
            Object zzo = zzo(this);
            sb2.append("SUCCESS, result=[");
            if (zzo == null) {
                sb2.append("null");
            } else if (zzo == this) {
                sb2.append("this future");
            } else {
                sb2.append(zzo.getClass().getName());
                sb2.append("@");
                sb2.append(Integer.toHexString(System.identityHashCode(zzo)));
            }
            sb2.append("]");
        } catch (CancellationException unused) {
            sb2.append("CANCELLED");
        } catch (ExecutionException e11) {
            sb2.append("FAILURE, cause=[");
            sb2.append(e11.getCause());
            sb2.append("]");
        } catch (Exception e12) {
            sb2.append("UNKNOWN, cause=[");
            sb2.append(e12.getClass());
            sb2.append(" thrown from get()]");
        }
    }

    private final void zzq(StringBuilder sb2) {
        String concat;
        int length = sb2.length();
        sb2.append("PENDING");
        Object obj = this.value;
        if (obj instanceof zzf) {
            sb2.append(", setFuture=[");
            zzr(sb2, ((zzf) obj).zzb);
            sb2.append("]");
        } else {
            try {
                concat = zznb.zza(zze());
            } catch (Exception | StackOverflowError e11) {
                concat = "Exception thrown from implementation: ".concat(String.valueOf(e11.getClass()));
            }
            if (concat != null) {
                sb2.append(", info=[");
                sb2.append(concat);
                sb2.append("]");
            }
        }
        if (isDone()) {
            sb2.delete(length, sb2.length());
            zzp(sb2);
        }
    }

    private final void zzr(StringBuilder sb2, Object obj) {
        try {
            if (obj == this) {
                sb2.append("this future");
            } else {
                sb2.append(obj);
            }
        } catch (Exception e11) {
            e = e11;
            sb2.append("Exception thrown from implementation: ");
            sb2.append(e.getClass());
        } catch (StackOverflowError e12) {
            e = e12;
            sb2.append("Exception thrown from implementation: ");
            sb2.append(e.getClass());
        }
    }

    private static void zzs(zzajp zzajpVar, boolean z10) {
        zzd zzdVar = null;
        while (true) {
            for (zzj zzb2 = zzc.zzb(zzajpVar, zzj.zza); zzb2 != null; zzb2 = zzb2.next) {
                Thread thread = zzb2.thread;
                if (thread != null) {
                    zzb2.thread = null;
                    LockSupport.unpark(thread);
                }
            }
            if (z10) {
                zzajpVar.zzk();
            }
            zzd zzdVar2 = zzdVar;
            zzd zza2 = zzc.zza(zzajpVar, zzd.zza);
            zzd zzdVar3 = zzdVar2;
            while (zza2 != null) {
                zzd zzdVar4 = zza2.next;
                zza2.next = zzdVar3;
                zzdVar3 = zza2;
                zza2 = zzdVar4;
            }
            while (zzdVar3 != null) {
                Runnable runnable = zzdVar3.zzb;
                zzdVar = zzdVar3.next;
                Objects.requireNonNull(runnable);
                Runnable runnable2 = runnable;
                if (runnable2 instanceof zzf) {
                    zzf zzfVar = (zzf) runnable2;
                    zzajpVar = zzfVar.zza;
                    if (zzajpVar.value == zzfVar) {
                        if (zzc.zzf(zzajpVar, zzfVar, zzn(zzfVar.zzb))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    Executor executor = zzdVar3.zzc;
                    Objects.requireNonNull(executor);
                    zzt(runnable2, executor);
                }
                zzdVar3 = zzdVar;
            }
            return;
            z10 = false;
        }
    }

    private static void zzt(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (Exception e11) {
            zzb.zza().logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "executeListener", "RuntimeException while executing runnable " + String.valueOf(runnable) + " with executor " + String.valueOf(executor), (Throwable) e11);
        }
    }

    private final void zzu(zzj zzjVar) {
        zzjVar.thread = null;
        while (true) {
            zzj zzjVar2 = this.waiters;
            if (zzjVar2 != zzj.zza) {
                zzj zzjVar3 = null;
                while (zzjVar2 != null) {
                    zzj zzjVar4 = zzjVar2.next;
                    if (zzjVar2.thread != null) {
                        zzjVar3 = zzjVar2;
                    } else if (zzjVar3 != null) {
                        zzjVar3.next = zzjVar4;
                        if (zzjVar3.thread == null) {
                            break;
                        }
                    } else if (!zzc.zzg(this, zzjVar2, zzjVar4)) {
                        break;
                    }
                    zzjVar2 = zzjVar4;
                }
                return;
            }
            return;
        }
    }

    private static final Object zzv(Object obj) throws ExecutionException {
        if (obj instanceof zzb) {
            Throwable th2 = ((zzb) obj).zzd;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th2);
            throw cancellationException;
        }
        if (obj instanceof zzc) {
            throw new ExecutionException(((zzc) obj).zzb);
        }
        if (obj == zzd) {
            return null;
        }
        return obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:?, code lost:
    
        return true;
     */
    @Override // java.util.concurrent.Future
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean cancel(boolean r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.value
            boolean r1 = r0 instanceof com.google.android.libraries.places.internal.zzajp.zzf
            r2 = 0
            r3 = 1
            if (r0 != 0) goto La
            r4 = r3
            goto Lb
        La:
            r4 = r2
        Lb:
            r1 = r1 | r4
            if (r1 == 0) goto L60
            boolean r1 = com.google.android.libraries.places.internal.zzajp.zza
            if (r1 == 0) goto L1f
            com.google.android.libraries.places.internal.zzajp$zzb r1 = new com.google.android.libraries.places.internal.zzajp$zzb
            java.util.concurrent.CancellationException r4 = new java.util.concurrent.CancellationException
            java.lang.String r5 = "Future.cancel() was called."
            r4.<init>(r5)
            r1.<init>(r8, r4)
            goto L29
        L1f:
            if (r8 == 0) goto L24
            com.google.android.libraries.places.internal.zzajp$zzb r1 = com.google.android.libraries.places.internal.zzajp.zzb.zza
            goto L26
        L24:
            com.google.android.libraries.places.internal.zzajp$zzb r1 = com.google.android.libraries.places.internal.zzajp.zzb.zzb
        L26:
            java.util.Objects.requireNonNull(r1)
        L29:
            r4 = r7
            r5 = r2
        L2b:
            com.google.android.libraries.places.internal.zzajp$zza r6 = com.google.android.libraries.places.internal.zzajp.zzc
            boolean r6 = r6.zzf(r4, r0, r1)
            if (r6 == 0) goto L59
            zzs(r4, r8)
            boolean r4 = r0 instanceof com.google.android.libraries.places.internal.zzajp.zzf
            if (r4 == 0) goto L53
            com.google.android.libraries.places.internal.zzajp$zzf r0 = (com.google.android.libraries.places.internal.zzajp.zzf) r0
            com.google.android.libraries.places.internal.zzaka<? extends V> r0 = r0.zzb
            boolean r4 = r0 instanceof com.google.android.libraries.places.internal.zzajp.zzh
            if (r4 == 0) goto L55
            r4 = r0
            com.google.android.libraries.places.internal.zzajp r4 = (com.google.android.libraries.places.internal.zzajp) r4
            java.lang.Object r0 = r4.value
            if (r0 != 0) goto L4b
            r5 = r3
            goto L4c
        L4b:
            r5 = r2
        L4c:
            boolean r6 = r0 instanceof com.google.android.libraries.places.internal.zzajp.zzf
            r5 = r5 | r6
            if (r5 == 0) goto L53
            r5 = r3
            goto L2b
        L53:
            r2 = r3
            goto L60
        L55:
            r0.cancel(r8)
            goto L53
        L59:
            java.lang.Object r0 = r4.value
            boolean r6 = r0 instanceof com.google.android.libraries.places.internal.zzajp.zzf
            if (r6 != 0) goto L2b
            r2 = r5
        L60:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzajp.cancel(boolean):boolean");
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws InterruptedException, ExecutionException {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.value;
        if ((obj2 != null) && (!(obj2 instanceof zzf))) {
            return zzv(obj2);
        }
        zzj zzjVar = this.waiters;
        if (zzjVar != zzj.zza) {
            zzj zzjVar2 = new zzj();
            do {
                zza zzaVar = zzc;
                zzaVar.zzc(zzjVar2, zzjVar);
                if (zzaVar.zzg(this, zzjVar, zzjVar2)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            zzu(zzjVar2);
                            throw new InterruptedException();
                        }
                        obj = this.value;
                    } while (!((obj != null) & (!(obj instanceof zzf))));
                    return zzv(obj);
                }
                zzjVar = this.waiters;
            } while (zzjVar != zzj.zza);
        }
        Object obj3 = this.value;
        Objects.requireNonNull(obj3);
        return zzv(obj3);
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j11, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        long nanos = timeUnit.toNanos(j11);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.value;
        boolean z10 = true;
        if ((obj != null) && (!(obj instanceof zzf))) {
            return zzv(obj);
        }
        long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            zzj zzjVar = this.waiters;
            if (zzjVar != zzj.zza) {
                zzj zzjVar2 = new zzj();
                do {
                    zza zzaVar = zzc;
                    zzaVar.zzc(zzjVar2, zzjVar);
                    if (zzaVar.zzg(this, zzjVar, zzjVar2)) {
                        do {
                            LockSupport.parkNanos(this, Math.min(nanos, 2147483647999999999L));
                            if (Thread.interrupted()) {
                                zzu(zzjVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.value;
                            if ((obj2 != null) && (!(obj2 instanceof zzf))) {
                                return zzv(obj2);
                            }
                            nanos = nanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        zzu(zzjVar2);
                    } else {
                        zzjVar = this.waiters;
                    }
                } while (zzjVar != zzj.zza);
            }
            Object obj3 = this.value;
            Objects.requireNonNull(obj3);
            return zzv(obj3);
        }
        while (nanos > 0) {
            Object obj4 = this.value;
            if ((obj4 != null) && (!(obj4 instanceof zzf))) {
                return zzv(obj4);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = nanoTime - System.nanoTime();
        }
        String zzajpVar = toString();
        String obj5 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = obj5.toLowerCase(locale);
        String str = "Waited " + j11 + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String concat = str.concat(" (plus ");
            long j12 = -nanos;
            long convert = timeUnit.convert(j12, TimeUnit.NANOSECONDS);
            long nanos2 = j12 - timeUnit.toNanos(convert);
            if (convert != 0 && nanos2 <= 1000) {
                z10 = false;
            }
            if (convert > 0) {
                String str2 = concat + convert + " " + lowerCase;
                if (z10) {
                    str2 = str2.concat(",");
                }
                concat = str2.concat(" ");
            }
            if (z10) {
                concat = concat + nanos2 + " nanoseconds ";
            }
            str = concat.concat("delay)");
        }
        if (isDone()) {
            throw new TimeoutException(str.concat(" but future completed as timeout expired"));
        }
        throw new TimeoutException(str + " for " + zzajpVar);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.value instanceof zzb;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return (this.value != null) & (!(r0 instanceof zzf));
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (getClass().getName().startsWith("com.google.common.util.concurrent.")) {
            sb2.append(getClass().getSimpleName());
        } else {
            sb2.append(getClass().getName());
        }
        sb2.append('@');
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append("[status=");
        if (this.value instanceof zzb) {
            sb2.append("CANCELLED");
        } else if (isDone()) {
            zzp(sb2);
        } else {
            zzq(sb2);
        }
        sb2.append("]");
        return sb2.toString();
    }

    protected String zze() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.libraries.places.internal.zzake
    public final Throwable zzf() {
        if (!(this instanceof zzh)) {
            return null;
        }
        Object obj = this.value;
        if (obj instanceof zzc) {
            return ((zzc) obj).zzb;
        }
        return null;
    }

    @Override // com.google.android.libraries.places.internal.zzaka
    public final void zzj(Runnable runnable, Executor executor) {
        zzd zzdVar;
        zzmt.zzc(executor, "Executor was null.");
        if (!isDone() && (zzdVar = this.listeners) != zzd.zza) {
            zzd zzdVar2 = new zzd(runnable, executor);
            do {
                zzdVar2.next = zzdVar;
                if (zzc.zze(this, zzdVar, zzdVar2)) {
                    return;
                } else {
                    zzdVar = this.listeners;
                }
            } while (zzdVar != zzd.zza);
        }
        zzt(runnable, executor);
    }

    protected void zzk() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean zzl(Object obj) {
        if (obj == null) {
            obj = zzd;
        }
        if (!zzc.zzf(this, null, obj)) {
            return false;
        }
        zzs(this, false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean zzm(Throwable th2) {
        if (!zzc.zzf(this, null, new zzc(th2))) {
            return false;
        }
        zzs(this, false);
        return true;
    }
}
