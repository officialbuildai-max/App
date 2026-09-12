package com.google.android.gms.internal.measurement;

import com.google.android.libraries.places.api.model.PlaceTypes;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzml {
    static final boolean zza;
    private static final Unsafe zzb;
    private static final Class<?> zzc;
    private static final boolean zzd;
    private static final boolean zze;
    private static final zzb zzf;
    private static final boolean zzg;
    private static final boolean zzh;
    private static final long zzi;

    /* loaded from: classes4.dex */
    private static final class zza extends zzb {
        zza(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.measurement.zzml.zzb
        public final double zza(Object obj, long j11) {
            return Double.longBitsToDouble(zze(obj, j11));
        }

        @Override // com.google.android.gms.internal.measurement.zzml.zzb
        public final void zza(Object obj, long j11, byte b11) {
            if (zzml.zza) {
                zzml.zzc(obj, j11, b11);
            } else {
                zzml.zzd(obj, j11, b11);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzml.zzb
        public final void zza(Object obj, long j11, double d11) {
            zza(obj, j11, Double.doubleToLongBits(d11));
        }

        @Override // com.google.android.gms.internal.measurement.zzml.zzb
        public final void zza(Object obj, long j11, float f11) {
            zza(obj, j11, Float.floatToIntBits(f11));
        }

        @Override // com.google.android.gms.internal.measurement.zzml.zzb
        public final void zza(Object obj, long j11, boolean z10) {
            if (zzml.zza) {
                zzml.zza(obj, j11, z10);
            } else {
                zzml.zzb(obj, j11, z10);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzml.zzb
        public final float zzb(Object obj, long j11) {
            return Float.intBitsToFloat(zzd(obj, j11));
        }

        @Override // com.google.android.gms.internal.measurement.zzml.zzb
        public final boolean zzc(Object obj, long j11) {
            return zzml.zza ? zzml.zzf(obj, j11) : zzml.zzg(obj, j11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static abstract class zzb {
        Unsafe zza;

        zzb(Unsafe unsafe) {
            this.zza = unsafe;
        }

        public abstract double zza(Object obj, long j11);

        public abstract void zza(Object obj, long j11, byte b11);

        public abstract void zza(Object obj, long j11, double d11);

        public abstract void zza(Object obj, long j11, float f11);

        public final void zza(Object obj, long j11, int i11) {
            this.zza.putInt(obj, j11, i11);
        }

        public final void zza(Object obj, long j11, long j12) {
            this.zza.putLong(obj, j11, j12);
        }

        public abstract void zza(Object obj, long j11, boolean z10);

        public final boolean zza() {
            Unsafe unsafe = this.zza;
            if (unsafe == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                cls.getMethod("arrayBaseOffset", Class.class);
                cls.getMethod("arrayIndexScale", Class.class);
                Class<?> cls2 = Long.TYPE;
                cls.getMethod("getInt", Object.class, cls2);
                cls.getMethod("putInt", Object.class, cls2, Integer.TYPE);
                cls.getMethod("getLong", Object.class, cls2);
                cls.getMethod("putLong", Object.class, cls2, cls2);
                cls.getMethod("getObject", Object.class, cls2);
                cls.getMethod("putObject", Object.class, cls2, Object.class);
                return true;
            } catch (Throwable th2) {
                zzml.zza(th2);
                return false;
            }
        }

        public abstract float zzb(Object obj, long j11);

        public final boolean zzb() {
            Unsafe unsafe = this.zza;
            if (unsafe == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                cls.getMethod("getLong", Object.class, Long.TYPE);
                return zzml.zza() != null;
            } catch (Throwable th2) {
                zzml.zza(th2);
                return false;
            }
        }

        public abstract boolean zzc(Object obj, long j11);

        public final int zzd(Object obj, long j11) {
            return this.zza.getInt(obj, j11);
        }

        public final long zze(Object obj, long j11) {
            return this.zza.getLong(obj, j11);
        }
    }

    /* loaded from: classes4.dex */
    private static final class zzc extends zzb {
        zzc(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.measurement.zzml.zzb
        public final double zza(Object obj, long j11) {
            return Double.longBitsToDouble(zze(obj, j11));
        }

        @Override // com.google.android.gms.internal.measurement.zzml.zzb
        public final void zza(Object obj, long j11, byte b11) {
            if (zzml.zza) {
                zzml.zzc(obj, j11, b11);
            } else {
                zzml.zzd(obj, j11, b11);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzml.zzb
        public final void zza(Object obj, long j11, double d11) {
            zza(obj, j11, Double.doubleToLongBits(d11));
        }

        @Override // com.google.android.gms.internal.measurement.zzml.zzb
        public final void zza(Object obj, long j11, float f11) {
            zza(obj, j11, Float.floatToIntBits(f11));
        }

        @Override // com.google.android.gms.internal.measurement.zzml.zzb
        public final void zza(Object obj, long j11, boolean z10) {
            if (zzml.zza) {
                zzml.zza(obj, j11, z10);
            } else {
                zzml.zzb(obj, j11, z10);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzml.zzb
        public final float zzb(Object obj, long j11) {
            return Float.intBitsToFloat(zzd(obj, j11));
        }

        @Override // com.google.android.gms.internal.measurement.zzml.zzb
        public final boolean zzc(Object obj, long j11) {
            return zzml.zza ? zzml.zzf(obj, j11) : zzml.zzg(obj, j11);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0034  */
    static {
        /*
            sun.misc.Unsafe r0 = zzb()
            com.google.android.gms.internal.measurement.zzml.zzb = r0
            java.lang.Class r1 = com.google.android.gms.internal.measurement.zzih.zza()
            com.google.android.gms.internal.measurement.zzml.zzc = r1
            java.lang.Class r1 = java.lang.Long.TYPE
            boolean r1 = zzd(r1)
            com.google.android.gms.internal.measurement.zzml.zzd = r1
            java.lang.Class r2 = java.lang.Integer.TYPE
            boolean r2 = zzd(r2)
            com.google.android.gms.internal.measurement.zzml.zze = r2
            if (r0 == 0) goto L2e
            if (r1 == 0) goto L26
            com.google.android.gms.internal.measurement.zzml$zzc r1 = new com.google.android.gms.internal.measurement.zzml$zzc
            r1.<init>(r0)
            goto L2f
        L26:
            if (r2 == 0) goto L2e
            com.google.android.gms.internal.measurement.zzml$zza r1 = new com.google.android.gms.internal.measurement.zzml$zza
            r1.<init>(r0)
            goto L2f
        L2e:
            r1 = 0
        L2f:
            com.google.android.gms.internal.measurement.zzml.zzf = r1
            r0 = 0
            if (r1 != 0) goto L36
            r2 = r0
            goto L3a
        L36:
            boolean r2 = r1.zzb()
        L3a:
            com.google.android.gms.internal.measurement.zzml.zzg = r2
            if (r1 != 0) goto L40
            r2 = r0
            goto L44
        L40:
            boolean r2 = r1.zza()
        L44:
            com.google.android.gms.internal.measurement.zzml.zzh = r2
            java.lang.Class<byte[]> r2 = byte[].class
            int r2 = zzb(r2)
            long r2 = (long) r2
            com.google.android.gms.internal.measurement.zzml.zzi = r2
            java.lang.Class<boolean[]> r2 = boolean[].class
            zzb(r2)
            zzc(r2)
            java.lang.Class<int[]> r2 = int[].class
            zzb(r2)
            zzc(r2)
            java.lang.Class<long[]> r2 = long[].class
            zzb(r2)
            zzc(r2)
            java.lang.Class<float[]> r2 = float[].class
            zzb(r2)
            zzc(r2)
            java.lang.Class<double[]> r2 = double[].class
            zzb(r2)
            zzc(r2)
            java.lang.Class<java.lang.Object[]> r2 = java.lang.Object[].class
            zzb(r2)
            zzc(r2)
            java.lang.reflect.Field r2 = zze()
            if (r2 == 0) goto L8d
            if (r1 != 0) goto L88
            goto L8d
        L88:
            sun.misc.Unsafe r1 = r1.zza
            r1.objectFieldOffset(r2)
        L8d:
            java.nio.ByteOrder r1 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r2 = java.nio.ByteOrder.BIG_ENDIAN
            if (r1 != r2) goto L96
            r0 = 1
        L96:
            com.google.android.gms.internal.measurement.zzml.zza = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzml.<clinit>():void");
    }

    private zzml() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double zza(Object obj, long j11) {
        return zzf.zza(obj, j11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T zza(Class<T> cls) {
        try {
            return (T) zzb.allocateInstance(cls);
        } catch (InstantiationException e11) {
            throw new IllegalStateException(e11);
        }
    }

    static /* synthetic */ Field zza() {
        return zze();
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(Object obj, long j11, double d11) {
        zzf.zza(obj, j11, d11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(Object obj, long j11, float f11) {
        zzf.zza(obj, j11, f11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(Object obj, long j11, int i11) {
        zzf.zza(obj, j11, i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(Object obj, long j11, long j12) {
        zzf.zza(obj, j11, j12);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(Object obj, long j11, Object obj2) {
        zzf.zza.putObject(obj, j11, obj2);
    }

    static /* synthetic */ void zza(Object obj, long j11, boolean z10) {
        zzc(obj, j11, z10 ? (byte) 1 : (byte) 0);
    }

    static /* synthetic */ void zza(Throwable th2) {
        Logger.getLogger(zzml.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: " + String.valueOf(th2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(byte[] bArr, long j11, byte b11) {
        zzf.zza((Object) bArr, zzi + j11, b11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float zzb(Object obj, long j11) {
        return zzf.zzb(obj, j11);
    }

    private static int zzb(Class<?> cls) {
        if (zzh) {
            return zzf.zza.arrayBaseOffset(cls);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Unsafe zzb() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzmn());
        } catch (Throwable unused) {
            return null;
        }
    }

    static /* synthetic */ void zzb(Object obj, long j11, boolean z10) {
        zzd(obj, j11, z10 ? (byte) 1 : (byte) 0);
    }

    private static int zzc(Class<?> cls) {
        if (zzh) {
            return zzf.zza.arrayIndexScale(cls);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(Object obj, long j11) {
        return zzf.zzd(obj, j11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzc(Object obj, long j11, byte b11) {
        long j12 = (-4) & j11;
        int zzc2 = zzc(obj, j12);
        int i11 = ((~((int) j11)) & 3) << 3;
        zza(obj, j12, ((255 & b11) << i11) | (zzc2 & (~(255 << i11))));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzc(Object obj, long j11, boolean z10) {
        zzf.zza(obj, j11, z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzc() {
        return zzh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long zzd(Object obj, long j11) {
        return zzf.zze(obj, j11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzd(Object obj, long j11, byte b11) {
        long j12 = (-4) & j11;
        int i11 = (((int) j11) & 3) << 3;
        zza(obj, j12, ((255 & b11) << i11) | (zzc(obj, j12) & (~(255 << i11))));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzd() {
        return zzg;
    }

    private static boolean zzd(Class<?> cls) {
        try {
            Class<?> cls2 = zzc;
            Class<?> cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class<?> cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zze(Object obj, long j11) {
        return zzf.zza.getObject(obj, j11);
    }

    private static Field zze() {
        Field zza2 = zza((Class<?>) Buffer.class, "effectiveDirectAddress");
        if (zza2 != null) {
            return zza2;
        }
        Field zza3 = zza((Class<?>) Buffer.class, PlaceTypes.ADDRESS);
        if (zza3 == null || zza3.getType() != Long.TYPE) {
            return null;
        }
        return zza3;
    }

    static /* synthetic */ boolean zzf(Object obj, long j11) {
        return ((byte) (zzc(obj, (-4) & j11) >>> ((int) (((~j11) & 3) << 3)))) != 0;
    }

    static /* synthetic */ boolean zzg(Object obj, long j11) {
        return ((byte) (zzc(obj, (-4) & j11) >>> ((int) ((j11 & 3) << 3)))) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzh(Object obj, long j11) {
        return zzf.zzc(obj, j11);
    }
}
