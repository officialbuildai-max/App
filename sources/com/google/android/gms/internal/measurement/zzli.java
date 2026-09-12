package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzli<T> implements zzlu<T> {
    private final zzlc zza;
    private final zzmk<?, ?> zzb;
    private final boolean zzc;
    private final zzji<?> zzd;

    private zzli(zzmk<?, ?> zzmkVar, zzji<?> zzjiVar, zzlc zzlcVar) {
        this.zzb = zzmkVar;
        this.zzc = zzjiVar.zza(zzlcVar);
        this.zzd = zzjiVar;
        this.zza = zzlcVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> zzli<T> zza(zzmk<?, ?> zzmkVar, zzji<?> zzjiVar, zzlc zzlcVar) {
        return new zzli<>(zzmkVar, zzjiVar, zzlcVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzlu
    public final int zza(T t11) {
        zzmk<?, ?> zzmkVar = this.zzb;
        int zzb = zzmkVar.zzb(zzmkVar.zzd(t11));
        return this.zzc ? zzb + this.zzd.zza(t11).zza() : zzb;
    }

    @Override // com.google.android.gms.internal.measurement.zzlu
    public final T zza() {
        zzlc zzlcVar = this.zza;
        return zzlcVar instanceof zzjt ? (T) ((zzjt) zzlcVar).zzce() : (T) zzlcVar.zzci().zzaj();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0087 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[LOOP:0: B:2:0x000c->B:20:?, LOOP_END, SYNTHETIC] */
    @Override // com.google.android.gms.internal.measurement.zzlu
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(T r11, com.google.android.gms.internal.measurement.zzlr r12, com.google.android.gms.internal.measurement.zzjg r13) throws java.io.IOException {
        /*
            r10 = this;
            com.google.android.gms.internal.measurement.zzmk<?, ?> r0 = r10.zzb
            com.google.android.gms.internal.measurement.zzji<?> r1 = r10.zzd
            java.lang.Object r2 = r0.zzc(r11)
            com.google.android.gms.internal.measurement.zzjm r3 = r1.zzb(r11)
        Lc:
            int r4 = r12.zzc()     // Catch: java.lang.Throwable -> L35
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 != r5) goto L19
            r0.zzb(r11, r2)
            return
        L19:
            int r4 = r12.zzd()     // Catch: java.lang.Throwable -> L35
            r6 = 11
            r7 = 0
            if (r4 == r6) goto L41
            r5 = r4 & 7
            r6 = 2
            if (r5 != r6) goto L3c
            com.google.android.gms.internal.measurement.zzlc r5 = r10.zza     // Catch: java.lang.Throwable -> L35
            int r4 = r4 >>> 3
            java.lang.Object r4 = r1.zza(r13, r5, r4)     // Catch: java.lang.Throwable -> L35
            if (r4 == 0) goto L37
            r1.zza(r12, r4, r13, r3)     // Catch: java.lang.Throwable -> L35
            goto L84
        L35:
            r12 = move-exception
            goto L90
        L37:
            boolean r4 = r0.zza(r2, r12, r7)     // Catch: java.lang.Throwable -> L35
            goto L85
        L3c:
            boolean r4 = r12.zzt()     // Catch: java.lang.Throwable -> L35
            goto L85
        L41:
            r4 = 0
            r6 = r4
        L43:
            int r8 = r12.zzc()     // Catch: java.lang.Throwable -> L35
            if (r8 == r5) goto L71
            int r8 = r12.zzd()     // Catch: java.lang.Throwable -> L35
            r9 = 16
            if (r8 != r9) goto L5c
            int r7 = r12.zzj()     // Catch: java.lang.Throwable -> L35
            com.google.android.gms.internal.measurement.zzlc r4 = r10.zza     // Catch: java.lang.Throwable -> L35
            java.lang.Object r4 = r1.zza(r13, r4, r7)     // Catch: java.lang.Throwable -> L35
            goto L43
        L5c:
            r9 = 26
            if (r8 != r9) goto L6b
            if (r4 == 0) goto L66
            r1.zza(r12, r4, r13, r3)     // Catch: java.lang.Throwable -> L35
            goto L43
        L66:
            com.google.android.gms.internal.measurement.zzik r6 = r12.zzp()     // Catch: java.lang.Throwable -> L35
            goto L43
        L6b:
            boolean r8 = r12.zzt()     // Catch: java.lang.Throwable -> L35
            if (r8 != 0) goto L43
        L71:
            int r5 = r12.zzd()     // Catch: java.lang.Throwable -> L35
            r8 = 12
            if (r5 != r8) goto L8b
            if (r6 == 0) goto L84
            if (r4 == 0) goto L81
            r1.zza(r6, r4, r13, r3)     // Catch: java.lang.Throwable -> L35
            goto L84
        L81:
            r0.zza(r2, r7, r6)     // Catch: java.lang.Throwable -> L35
        L84:
            r4 = 1
        L85:
            if (r4 != 0) goto Lc
            r0.zzb(r11, r2)
            return
        L8b:
            com.google.android.gms.internal.measurement.zzkb r12 = com.google.android.gms.internal.measurement.zzkb.zzb()     // Catch: java.lang.Throwable -> L35
            throw r12     // Catch: java.lang.Throwable -> L35
        L90:
            r0.zzb(r11, r2)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzli.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzlr, com.google.android.gms.internal.measurement.zzjg):void");
    }

    @Override // com.google.android.gms.internal.measurement.zzlu
    public final void zza(T t11, zznb zznbVar) throws IOException {
        Iterator<Map.Entry<?, Object>> zzd = this.zzd.zza(t11).zzd();
        while (zzd.hasNext()) {
            Map.Entry<?, Object> next = zzd.next();
            zzjo zzjoVar = (zzjo) next.getKey();
            if (zzjoVar.zzc() != zzmz.MESSAGE || zzjoVar.zze() || zzjoVar.zzd()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (next instanceof zzkf) {
                zznbVar.zza(zzjoVar.zza(), (Object) ((zzkf) next).zza().zzb());
            } else {
                zznbVar.zza(zzjoVar.zza(), next.getValue());
            }
        }
        zzmk<?, ?> zzmkVar = this.zzb;
        zzmkVar.zza((zzmk<?, ?>) zzmkVar.zzd(t11), zznbVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzlu
    public final void zza(T t11, T t12) {
        zzlw.zza(this.zzb, t11, t12);
        if (this.zzc) {
            zzlw.zza(this.zzd, t11, t12);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0099 A[EDGE_INSN: B:24:0x0099->B:25:0x0099 BREAK  A[LOOP:1: B:10:0x0053->B:18:0x0053], SYNTHETIC] */
    @Override // com.google.android.gms.internal.measurement.zzlu
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(T r10, byte[] r11, int r12, int r13, com.google.android.gms.internal.measurement.zzij r14) throws java.io.IOException {
        /*
            r9 = this;
            r0 = r10
            com.google.android.gms.internal.measurement.zzjt r0 = (com.google.android.gms.internal.measurement.zzjt) r0
            com.google.android.gms.internal.measurement.zzmj r1 = r0.zzb
            com.google.android.gms.internal.measurement.zzmj r2 = com.google.android.gms.internal.measurement.zzmj.zzc()
            if (r1 != r2) goto L11
            com.google.android.gms.internal.measurement.zzmj r1 = com.google.android.gms.internal.measurement.zzmj.zzd()
            r0.zzb = r1
        L11:
            com.google.android.gms.internal.measurement.zzjt$zzd r10 = (com.google.android.gms.internal.measurement.zzjt.zzd) r10
            r10.zza()
            r10 = 0
            r0 = r10
        L18:
            if (r12 >= r13) goto La4
            int r4 = com.google.android.gms.internal.measurement.zzig.zzc(r11, r12, r14)
            int r2 = r14.zza
            r12 = 11
            r3 = 2
            if (r2 == r12) goto L51
            r12 = r2 & 7
            if (r12 != r3) goto L4c
            com.google.android.gms.internal.measurement.zzji<?> r12 = r9.zzd
            com.google.android.gms.internal.measurement.zzjg r0 = r14.zzd
            com.google.android.gms.internal.measurement.zzlc r3 = r9.zza
            int r5 = r2 >>> 3
            java.lang.Object r12 = r12.zza(r0, r3, r5)
            r0 = r12
            com.google.android.gms.internal.measurement.zzjt$zzf r0 = (com.google.android.gms.internal.measurement.zzjt.zzf) r0
            if (r0 != 0) goto L43
            r3 = r11
            r5 = r13
            r6 = r1
            r7 = r14
            int r12 = com.google.android.gms.internal.measurement.zzig.zza(r2, r3, r4, r5, r6, r7)
            goto L18
        L43:
            com.google.android.gms.internal.measurement.zzlq.zza()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L4c:
            int r12 = com.google.android.gms.internal.measurement.zzig.zza(r2, r11, r4, r13, r14)
            goto L18
        L51:
            r12 = 0
            r2 = r10
        L53:
            if (r4 >= r13) goto L99
            int r4 = com.google.android.gms.internal.measurement.zzig.zzc(r11, r4, r14)
            int r5 = r14.zza
            int r6 = r5 >>> 3
            r7 = r5 & 7
            if (r6 == r3) goto L7b
            r8 = 3
            if (r6 == r8) goto L65
            goto L90
        L65:
            if (r0 != 0) goto L72
            if (r7 != r3) goto L90
            int r4 = com.google.android.gms.internal.measurement.zzig.zza(r11, r4, r14)
            java.lang.Object r2 = r14.zzc
            com.google.android.gms.internal.measurement.zzik r2 = (com.google.android.gms.internal.measurement.zzik) r2
            goto L53
        L72:
            com.google.android.gms.internal.measurement.zzlq.zza()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L7b:
            if (r7 != 0) goto L90
            int r4 = com.google.android.gms.internal.measurement.zzig.zzc(r11, r4, r14)
            int r12 = r14.zza
            com.google.android.gms.internal.measurement.zzji<?> r0 = r9.zzd
            com.google.android.gms.internal.measurement.zzjg r5 = r14.zzd
            com.google.android.gms.internal.measurement.zzlc r6 = r9.zza
            java.lang.Object r0 = r0.zza(r5, r6, r12)
            com.google.android.gms.internal.measurement.zzjt$zzf r0 = (com.google.android.gms.internal.measurement.zzjt.zzf) r0
            goto L53
        L90:
            r6 = 12
            if (r5 == r6) goto L99
            int r4 = com.google.android.gms.internal.measurement.zzig.zza(r5, r11, r4, r13, r14)
            goto L53
        L99:
            if (r2 == 0) goto La1
            int r12 = r12 << 3
            r12 = r12 | r3
            r1.zza(r12, r2)
        La1:
            r12 = r4
            goto L18
        La4:
            if (r12 != r13) goto La7
            return
        La7:
            com.google.android.gms.internal.measurement.zzkb r10 = com.google.android.gms.internal.measurement.zzkb.zzg()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzli.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.measurement.zzij):void");
    }

    @Override // com.google.android.gms.internal.measurement.zzlu
    public final int zzb(T t11) {
        int hashCode = this.zzb.zzd(t11).hashCode();
        return this.zzc ? (hashCode * 53) + this.zzd.zza(t11).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.measurement.zzlu
    public final boolean zzb(T t11, T t12) {
        if (!this.zzb.zzd(t11).equals(this.zzb.zzd(t12))) {
            return false;
        }
        if (this.zzc) {
            return this.zzd.zza(t11).equals(this.zzd.zza(t12));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzlu
    public final void zzd(T t11) {
        this.zzb.zzf(t11);
        this.zzd.zzc(t11);
    }

    @Override // com.google.android.gms.internal.measurement.zzlu
    public final boolean zze(T t11) {
        return this.zzd.zza(t11).zzg();
    }
}
