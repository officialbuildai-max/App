package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzjb implements zzlr {
    private final zziw zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    private zzjb(zziw zziwVar) {
        zziw zziwVar2 = (zziw) zzjv.zza(zziwVar, "input");
        this.zza = zziwVar2;
        zziwVar2.zzc = this;
    }

    public static zzjb zza(zziw zziwVar) {
        zzjb zzjbVar = zziwVar.zzc;
        return zzjbVar != null ? zzjbVar : new zzjb(zziwVar);
    }

    private final <T> T zza(zzlu<T> zzluVar, zzjg zzjgVar) throws IOException {
        T zza = zzluVar.zza();
        zzc(zza, zzluVar, zzjgVar);
        zzluVar.zzd(zza);
        return zza;
    }

    private final Object zza(zzms zzmsVar, Class<?> cls, zzjg zzjgVar) throws IOException {
        switch (zzja.zza[zzmsVar.ordinal()]) {
            case 1:
                return Boolean.valueOf(zzs());
            case 2:
                return zzp();
            case 3:
                return Double.valueOf(zza());
            case 4:
                return Integer.valueOf(zze());
            case 5:
                return Integer.valueOf(zzf());
            case 6:
                return Long.valueOf(zzk());
            case 7:
                return Float.valueOf(zzb());
            case 8:
                return Integer.valueOf(zzg());
            case 9:
                return Long.valueOf(zzl());
            case 10:
                zzb(2);
                return zzb(zzlq.zza().zza((Class) cls), zzjgVar);
            case 11:
                return Integer.valueOf(zzh());
            case 12:
                return Long.valueOf(zzm());
            case 13:
                return Integer.valueOf(zzi());
            case 14:
                return Long.valueOf(zzn());
            case 15:
                return zzr();
            case 16:
                return Integer.valueOf(zzj());
            case 17:
                return Long.valueOf(zzo());
            default:
                throw new IllegalArgumentException("unsupported field type.");
        }
    }

    private final void zza(int i11) throws IOException {
        if (this.zza.zzc() != i11) {
            throw zzkb.zzi();
        }
    }

    private final void zza(List<String> list, boolean z10) throws IOException {
        int zzi;
        int zzi2;
        if ((this.zzb & 7) != 2) {
            throw zzkb.zza();
        }
        if (!(list instanceof zzkj) || z10) {
            do {
                list.add(z10 ? zzr() : zzq());
                if (this.zza.zzt()) {
                    return;
                } else {
                    zzi = this.zza.zzi();
                }
            } while (zzi == this.zzb);
            this.zzd = zzi;
            return;
        }
        zzkj zzkjVar = (zzkj) list;
        do {
            zzkjVar.zza(zzp());
            if (this.zza.zzt()) {
                return;
            } else {
                zzi2 = this.zza.zzi();
            }
        } while (zzi2 == this.zzb);
        this.zzd = zzi2;
    }

    private final <T> T zzb(zzlu<T> zzluVar, zzjg zzjgVar) throws IOException {
        T zza = zzluVar.zza();
        zzd(zza, zzluVar, zzjgVar);
        zzluVar.zzd(zza);
        return zza;
    }

    private final void zzb(int i11) throws IOException {
        if ((this.zzb & 7) != i11) {
            throw zzkb.zza();
        }
    }

    private static void zzc(int i11) throws IOException {
        if ((i11 & 3) != 0) {
            throw zzkb.zzg();
        }
    }

    private final <T> void zzc(T t11, zzlu<T> zzluVar, zzjg zzjgVar) throws IOException {
        int i11 = this.zzc;
        this.zzc = ((this.zzb >>> 3) << 3) | 4;
        try {
            zzluVar.zza(t11, this, zzjgVar);
            if (this.zzb == this.zzc) {
            } else {
                throw zzkb.zzg();
            }
        } finally {
            this.zzc = i11;
        }
    }

    private static void zzd(int i11) throws IOException {
        if ((i11 & 7) != 0) {
            throw zzkb.zzg();
        }
    }

    private final <T> void zzd(T t11, zzlu<T> zzluVar, zzjg zzjgVar) throws IOException {
        int zzj = this.zza.zzj();
        zziw zziwVar = this.zza;
        if (zziwVar.zza >= zziwVar.zzb) {
            throw zzkb.zzh();
        }
        int zzb = zziwVar.zzb(zzj);
        this.zza.zza++;
        zzluVar.zza(t11, this, zzjgVar);
        this.zza.zzc(0);
        r5.zza--;
        this.zza.zzd(zzb);
    }

    @Override // com.google.android.gms.internal.measurement.zzlr
    public final double zza() throws IOException {
        zzb(1);
        return this.zza.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzlr
    public final <T> void zza(T t11, zzlu<T> zzluVar, zzjg zzjgVar) throws IOException {
        zzb(3);
        zzc(t11, zzluVar, zzjgVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzlr
    public final void zza(List<Boolean> list) throws IOException {
        int zzi;
        int zzi2;
        if (!(list instanceof zzii)) {
            int i11 = this.zzb & 7;
            if (i11 != 0) {
                if (i11 != 2) {
                    throw zzkb.zza();
                }
                int zzc = this.zza.zzc() + this.zza.zzj();
                do {
                    list.add(Boolean.valueOf(this.zza.zzu()));
                } while (this.zza.zzc() < zzc);
                zza(zzc);
                return;
            }
            do {
                list.add(Boolean.valueOf(this.zza.zzu()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    zzi = this.zza.zzi();
                }
            } while (zzi == this.zzb);
            this.zzd = zzi;
            return;
        }
        zzii zziiVar = (zzii) list;
        int i12 = this.zzb & 7;
        if (i12 != 0) {
            if (i12 != 2) {
                throw zzkb.zza();
            }
            int zzc2 = this.zza.zzc() + this.zza.zzj();
            do {
                zziiVar.zza(this.zza.zzu());
            } while (this.zza.zzc() < zzc2);
            zza(zzc2);
            return;
        }
        do {
            zziiVar.zza(this.zza.zzu());
            if (this.zza.zzt()) {
                return;
            } else {
                zzi2 = this.zza.zzi();
            }
        } while (zzi2 == this.zzb);
        this.zzd = zzi2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzlr
    @Deprecated
    public final <T> void zza(List<T> list, zzlu<T> zzluVar, zzjg zzjgVar) throws IOException {
        int zzi;
        int i11 = this.zzb;
        if ((i11 & 7) != 3) {
            throw zzkb.zza();
        }
        do {
            list.add(zza(zzluVar, zzjgVar));
            if (this.zza.zzt() || this.zzd != 0) {
                return;
            } else {
                zzi = this.zza.zzi();
            }
        } while (zzi == i11);
        this.zzd = zzi;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x005d, code lost:
    
        r8.put(r2, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0060, code lost:
    
        r7.zza.zzd(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0065, code lost:
    
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzlr
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final <K, V> void zza(java.util.Map<K, V> r8, com.google.android.gms.internal.measurement.zzkt<K, V> r9, com.google.android.gms.internal.measurement.zzjg r10) throws java.io.IOException {
        /*
            r7 = this;
            r0 = 2
            r7.zzb(r0)
            com.google.android.gms.internal.measurement.zziw r1 = r7.zza
            int r1 = r1.zzj()
            com.google.android.gms.internal.measurement.zziw r2 = r7.zza
            int r1 = r2.zzb(r1)
            K r2 = r9.zzb
            V r3 = r9.zzd
        L14:
            int r4 = r7.zzc()     // Catch: java.lang.Throwable -> L39
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L5d
            com.google.android.gms.internal.measurement.zziw r5 = r7.zza     // Catch: java.lang.Throwable -> L39
            boolean r5 = r5.zzt()     // Catch: java.lang.Throwable -> L39
            if (r5 != 0) goto L5d
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L48
            if (r4 == r0) goto L3b
            boolean r4 = r7.zzt()     // Catch: java.lang.Throwable -> L39 com.google.android.gms.internal.measurement.zzke -> L50
            if (r4 == 0) goto L33
            goto L14
        L33:
            com.google.android.gms.internal.measurement.zzkb r4 = new com.google.android.gms.internal.measurement.zzkb     // Catch: java.lang.Throwable -> L39 com.google.android.gms.internal.measurement.zzke -> L50
            r4.<init>(r6)     // Catch: java.lang.Throwable -> L39 com.google.android.gms.internal.measurement.zzke -> L50
            throw r4     // Catch: java.lang.Throwable -> L39 com.google.android.gms.internal.measurement.zzke -> L50
        L39:
            r8 = move-exception
            goto L66
        L3b:
            com.google.android.gms.internal.measurement.zzms r4 = r9.zzc     // Catch: java.lang.Throwable -> L39 com.google.android.gms.internal.measurement.zzke -> L50
            V r5 = r9.zzd     // Catch: java.lang.Throwable -> L39 com.google.android.gms.internal.measurement.zzke -> L50
            java.lang.Class r5 = r5.getClass()     // Catch: java.lang.Throwable -> L39 com.google.android.gms.internal.measurement.zzke -> L50
            java.lang.Object r3 = r7.zza(r4, r5, r10)     // Catch: java.lang.Throwable -> L39 com.google.android.gms.internal.measurement.zzke -> L50
            goto L14
        L48:
            com.google.android.gms.internal.measurement.zzms r4 = r9.zza     // Catch: java.lang.Throwable -> L39 com.google.android.gms.internal.measurement.zzke -> L50
            r5 = 0
            java.lang.Object r2 = r7.zza(r4, r5, r5)     // Catch: java.lang.Throwable -> L39 com.google.android.gms.internal.measurement.zzke -> L50
            goto L14
        L50:
            boolean r4 = r7.zzt()     // Catch: java.lang.Throwable -> L39
            if (r4 == 0) goto L57
            goto L14
        L57:
            com.google.android.gms.internal.measurement.zzkb r8 = new com.google.android.gms.internal.measurement.zzkb     // Catch: java.lang.Throwable -> L39
            r8.<init>(r6)     // Catch: java.lang.Throwable -> L39
            throw r8     // Catch: java.lang.Throwable -> L39
        L5d:
            r8.put(r2, r3)     // Catch: java.lang.Throwable -> L39
            com.google.android.gms.internal.measurement.zziw r8 = r7.zza
            r8.zzd(r1)
            return
        L66:
            com.google.android.gms.internal.measurement.zziw r9 = r7.zza
            r9.zzd(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjb.zza(java.util.Map, com.google.android.gms.internal.measurement.zzkt, com.google.android.gms.internal.measurement.zzjg):void");
    }

    @Override // com.google.android.gms.internal.measurement.zzlr
    public final float zzb() throws IOException {
        zzb(5);
        return this.zza.zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzlr
    public final <T> void zzb(T t11, zzlu<T> zzluVar, zzjg zzjgVar) throws IOException {
        zzb(2);
        zzd(t11, zzluVar, zzjgVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzlr
    public final void zzb(List<zzik> list) throws IOException {
        int zzi;
        if ((this.zzb & 7) != 2) {
            throw zzkb.zza();
        }
        do {
            list.add(zzp());
            if (this.zza.zzt()) {
                return;
            } else {
                zzi = this.zza.zzi();
            }
        } while (zzi == this.zzb);
        this.zzd = zzi;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzlr
    public final <T> void zzb(List<T> list, zzlu<T> zzluVar, zzjg zzjgVar) throws IOException {
        int zzi;
        int i11 = this.zzb;
        if ((i11 & 7) != 2) {
            throw zzkb.zza();
        }
        do {
            list.add(zzb(zzluVar, zzjgVar));
            if (this.zza.zzt() || this.zzd != 0) {
                return;
            } else {
                zzi = this.zza.zzi();
            }
        } while (zzi == i11);
        this.zzd = zzi;
    }

    @Override // com.google.android.gms.internal.measurement.zzlr
    public final int zzc() throws IOException {
        int i11 = this.zzd;
        if (i11 != 0) {
            this.zzb = i11;
            this.zzd = 0;
        } else {
            this.zzb = this.zza.zzi();
        }
        int i12 = this.zzb;
        if (i12 == 0 || i12 == this.zzc) {
            return Integer.MAX_VALUE;
        }
        return i12 >>> 3;
    }

    @Override // com.google.android.gms.internal.measurement.zzlr
    public final void zzc(List<Double> list) throws IOException {
        int zzi;
        int zzi2;
        if (!(list instanceof zzje)) {
            int i11 = this.zzb & 7;
            if (i11 != 1) {
                if (i11 != 2) {
                    throw zzkb.zza();
                }
                int zzj = this.zza.zzj();
                zzd(zzj);
                int zzc = this.zza.zzc() + zzj;
                do {
                    list.add(Double.valueOf(this.zza.zza()));
                } while (this.zza.zzc() < zzc);
                return;
            }
            do {
                list.add(Double.valueOf(this.zza.zza()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    zzi = this.zza.zzi();
                }
            } while (zzi == this.zzb);
            this.zzd = zzi;
            return;
        }
        zzje zzjeVar = (zzje) list;
        int i12 = this.zzb & 7;
        if (i12 != 1) {
            if (i12 != 2) {
                throw zzkb.zza();
            }
            int zzj2 = this.zza.zzj();
            zzd(zzj2);
            int zzc2 = this.zza.zzc() + zzj2;
            do {
                zzjeVar.zza(this.zza.zza());
            } while (this.zza.zzc() < zzc2);
            return;
        }
        do {
            zzjeVar.zza(this.zza.zza());
            if (this.zza.zzt()) {
                return;
            } else {
                zzi2 = this.zza.zzi();
            }
        } while (zzi2 == this.zzb);
        this.zzd = zzi2;
    }

    @Override // com.google.android.gms.internal.measurement.zzlr
    public final int zzd() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.measurement.zzlr
    public final void zzd(List<Integer> list) throws IOException {
        int zzi;
        int zzi2;
        if (!(list instanceof zzjw)) {
            int i11 = this.zzb & 7;
            if (i11 != 0) {
                if (i11 != 2) {
                    throw zzkb.zza();
                }
                int zzc = this.zza.zzc() + this.zza.zzj();
                do {
                    list.add(Integer.valueOf(this.zza.zzd()));
                } while (this.zza.zzc() < zzc);
                zza(zzc);
                return;
            }
            do {
                list.add(Integer.valueOf(this.zza.zzd()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    zzi = this.zza.zzi();
                }
            } while (zzi == this.zzb);
            this.zzd = zzi;
            return;
        }
        zzjw zzjwVar = (zzjw) list;
        int i12 = this.zzb & 7;
        if (i12 != 0) {
            if (i12 != 2) {
                throw zzkb.zza();
            }
            int zzc2 = this.zza.zzc() + this.zza.zzj();
            do {
                zzjwVar.zzd(this.zza.zzd());
            } while (this.zza.zzc() < zzc2);
            zza(zzc2);
            return;
        }
        do {
            zzjwVar.zzd(this.zza.zzd());
            if (this.zza.zzt()) {
                return;
            } else {
                zzi2 = this.zza.zzi();
            }
        } while (zzi2 == this.zzb);
        this.zzd = zzi2;
    }

    @Override // com.google.android.gms.internal.measurement.zzlr
    public final int zze() throws IOException {
        zzb(0);
        return this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.measurement.zzlr
    public final void zze(List<Integer> list) throws IOException {
        int zzi;
        int zzi2;
        if (!(list instanceof zzjw)) {
            int i11 = this.zzb & 7;
            if (i11 == 2) {
                int zzj = this.zza.zzj();
                zzc(zzj);
                int zzc = this.zza.zzc() + zzj;
                do {
                    list.add(Integer.valueOf(this.zza.zze()));
                } while (this.zza.zzc() < zzc);
                return;
            }
            if (i11 != 5) {
                throw zzkb.zza();
            }
            do {
                list.add(Integer.valueOf(this.zza.zze()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    zzi = this.zza.zzi();
                }
            } while (zzi == this.zzb);
            this.zzd = zzi;
            return;
        }
        zzjw zzjwVar = (zzjw) list;
        int i12 = this.zzb & 7;
        if (i12 == 2) {
            int zzj2 = this.zza.zzj();
            zzc(zzj2);
            int zzc2 = this.zza.zzc() + zzj2;
            do {
                zzjwVar.zzd(this.zza.zze());
            } while (this.zza.zzc() < zzc2);
            return;
        }
        if (i12 != 5) {
            throw zzkb.zza();
        }
        do {
            zzjwVar.zzd(this.zza.zze());
            if (this.zza.zzt()) {
                return;
            } else {
                zzi2 = this.zza.zzi();
            }
        } while (zzi2 == this.zzb);
        this.zzd = zzi2;
    }

    @Override // com.google.android.gms.internal.measurement.zzlr
    public final int zzf() throws IOException {
        zzb(5);
        return this.zza.zze();
    }

    @Override // com.google.android.gms.internal.measurement.zzlr
    public final void zzf(List<Long> list) throws IOException {
        int zzi;
        int zzi2;
        if (!(list instanceof zzkn)) {
            int i11 = this.zzb & 7;
            if (i11 != 1) {
                if (i11 != 2) {
                    throw zzkb.zza();
                }
                int zzj = this.zza.zzj();
                zzd(zzj);
                int zzc = this.zza.zzc() + zzj;
                do {
                    list.add(Long.valueOf(this.zza.zzk()));
                } while (this.zza.zzc() < zzc);
                return;
            }
            do {
                list.add(Long.valueOf(this.zza.zzk()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    zzi = this.zza.zzi();
                }
            } while (zzi == this.zzb);
            this.zzd = zzi;
            return;
        }
        zzkn zzknVar = (zzkn) list;
        int i12 = this.zzb & 7;
        if (i12 != 1) {
            if (i12 != 2) {
                throw zzkb.zza();
            }
            int zzj2 = this.zza.zzj();
            zzd(zzj2);
            int zzc2 = this.zza.zzc() + zzj2;
            do {
                zzknVar.zza(this.zza.zzk());
            } while (this.zza.zzc() < zzc2);
            return;
        }
        do {
            zzknVar.zza(this.zza.zzk());
            if (this.zza.zzt()) {
                return;
            } else {
                zzi2 = this.zza.zzi();
            }
        } while (zzi2 == this.zzb);
        this.zzd = zzi2;
    }

    @Override // com.google.android.gms.internal.measurement.zzlr
    public final int zzg() throws IOException {
        zzb(0);
        return this.zza.zzf();
    }

    @Override // com.google.android.gms.internal.measurement.zzlr
    public final void zzg(List<Float> list) throws IOException {
        int zzi;
        int zzi2;
        if (!(list instanceof zzjs)) {
            int i11 = this.zzb & 7;
            if (i11 == 2) {
                int zzj = this.zza.zzj();
                zzc(zzj);
                int zzc = this.zza.zzc() + zzj;
                do {
                    list.add(Float.valueOf(this.zza.zzb()));
                } while (this.zza.zzc() < zzc);
                return;
            }
            if (i11 != 5) {
                throw zzkb.zza();
            }
            do {
                list.add(Float.valueOf(this.zza.zzb()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    zzi = this.zza.zzi();
                }
            } while (zzi == this.zzb);
            this.zzd = zzi;
            return;
        }
        zzjs zzjsVar = (zzjs) list;
        int i12 = this.zzb & 7;
        if (i12 == 2) {
            int zzj2 = this.zza.zzj();
            zzc(zzj2);
            int zzc2 = this.zza.zzc() + zzj2;
            do {
                zzjsVar.zza(this.zza.zzb());
            } while (this.zza.zzc() < zzc2);
            return;
        }
        if (i12 != 5) {
            throw zzkb.zza();
        }
        do {
            zzjsVar.zza(this.zza.zzb());
            if (this.zza.zzt()) {
                return;
            } else {
                zzi2 = this.zza.zzi();
            }
        } while (zzi2 == this.zzb);
        this.zzd = zzi2;
    }

    @Override // com.google.android.gms.internal.measurement.zzlr
    public final int zzh() throws IOException {
        zzb(5);
        return this.zza.zzg();
    }

    @Override // com.google.android.gms.internal.measurement.zzlr
    public final void zzh(List<Integer> list) throws IOException {
        int zzi;
        int zzi2;
        if (!(list instanceof zzjw)) {
            int i11 = this.zzb & 7;
            if (i11 != 0) {
                if (i11 != 2) {
                    throw zzkb.zza();
                }
                int zzc = this.zza.zzc() + this.zza.zzj();
                do {
                    list.add(Integer.valueOf(this.zza.zzf()));
                } while (this.zza.zzc() < zzc);
                zza(zzc);
                return;
            }
            do {
                list.add(Integer.valueOf(this.zza.zzf()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    zzi = this.zza.zzi();
                }
            } while (zzi == this.zzb);
            this.zzd = zzi;
            return;
        }
        zzjw zzjwVar = (zzjw) list;
        int i12 = this.zzb & 7;
        if (i12 != 0) {
            if (i12 != 2) {
                throw zzkb.zza();
            }
            int zzc2 = this.zza.zzc() + this.zza.zzj();
            do {
                zzjwVar.zzd(this.zza.zzf());
            } while (this.zza.zzc() < zzc2);
            zza(zzc2);
            return;
        }
        do {
            zzjwVar.zzd(this.zza.zzf());
            if (this.zza.zzt()) {
                return;
            } else {
                zzi2 = this.zza.zzi();
            }
        } while (zzi2 == this.zzb);
        this.zzd = zzi2;
    }

    @Override // com.google.android.gms.internal.measurement.zzlr
    public final int zzi() throws IOException {
        zzb(0);
        return this.zza.zzh();
    }

    @Override // com.google.android.gms.internal.measurement.zzlr
    public final void zzi(List<Long> list) throws IOException {
        int zzi;
        int zzi2;
        if (!(list instanceof zzkn)) {
            int i11 = this.zzb & 7;
            if (i11 != 0) {
                if (i11 != 2) {
                    throw zzkb.zza();
                }
                int zzc = this.zza.zzc() + this.zza.zzj();
                do {
                    list.add(Long.valueOf(this.zza.zzl()));
                } while (this.zza.zzc() < zzc);
                zza(zzc);
                return;
            }
            do {
                list.add(Long.valueOf(this.zza.zzl()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    zzi = this.zza.zzi();
                }
            } while (zzi == this.zzb);
            this.zzd = zzi;
            return;
        }
        zzkn zzknVar = (zzkn) list;
        int i12 = this.zzb & 7;
        if (i12 != 0) {
            if (i12 != 2) {
                throw zzkb.zza();
            }
            int zzc2 = this.zza.zzc() + this.zza.zzj();
            do {
                zzknVar.zza(this.zza.zzl());
            } while (this.zza.zzc() < zzc2);
            zza(zzc2);
            return;
        }
        do {
            zzknVar.zza(this.zza.zzl());
            if (this.zza.zzt()) {
                return;
            } else {
                zzi2 = this.zza.zzi();
            }
        } while (zzi2 == this.zzb);
        this.zzd = zzi2;
    }

    @Override // com.google.android.gms.internal.measurement.zzlr
    public final int zzj() throws IOException {
        zzb(0);
        return this.zza.zzj();
    }

    @Override // com.google.android.gms.internal.measurement.zzlr
    public final void zzj(List<Integer> list) throws IOException {
        int zzi;
        int zzi2;
        if (!(list instanceof zzjw)) {
            int i11 = this.zzb & 7;
            if (i11 == 2) {
                int zzj = this.zza.zzj();
                zzc(zzj);
                int zzc = this.zza.zzc() + zzj;
                do {
                    list.add(Integer.valueOf(this.zza.zzg()));
                } while (this.zza.zzc() < zzc);
                return;
            }
            if (i11 != 5) {
                throw zzkb.zza();
            }
            do {
                list.add(Integer.valueOf(this.zza.zzg()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    zzi = this.zza.zzi();
                }
            } while (zzi == this.zzb);
            this.zzd = zzi;
            return;
        }
        zzjw zzjwVar = (zzjw) list;
        int i12 = this.zzb & 7;
        if (i12 == 2) {
            int zzj2 = this.zza.zzj();
            zzc(zzj2);
            int zzc2 = this.zza.zzc() + zzj2;
            do {
                zzjwVar.zzd(this.zza.zzg());
            } while (this.zza.zzc() < zzc2);
            return;
        }
        if (i12 != 5) {
            throw zzkb.zza();
        }
        do {
            zzjwVar.zzd(this.zza.zzg());
            if (this.zza.zzt()) {
                return;
            } else {
                zzi2 = this.zza.zzi();
            }
        } while (zzi2 == this.zzb);
        this.zzd = zzi2;
    }

    @Override // com.google.android.gms.internal.measurement.zzlr
    public final long zzk() throws IOException {
        zzb(1);
        return this.zza.zzk();
    }

    @Override // com.google.android.gms.internal.measurement.zzlr
    public final void zzk(List<Long> list) throws IOException {
        int zzi;
        int zzi2;
        if (!(list instanceof zzkn)) {
            int i11 = this.zzb & 7;
            if (i11 != 1) {
                if (i11 != 2) {
                    throw zzkb.zza();
                }
                int zzj = this.zza.zzj();
                zzd(zzj);
                int zzc = this.zza.zzc() + zzj;
                do {
                    list.add(Long.valueOf(this.zza.zzn()));
                } while (this.zza.zzc() < zzc);
                return;
            }
            do {
                list.add(Long.valueOf(this.zza.zzn()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    zzi = this.zza.zzi();
                }
            } while (zzi == this.zzb);
            this.zzd = zzi;
            return;
        }
        zzkn zzknVar = (zzkn) list;
        int i12 = this.zzb & 7;
        if (i12 != 1) {
            if (i12 != 2) {
                throw zzkb.zza();
            }
            int zzj2 = this.zza.zzj();
            zzd(zzj2);
            int zzc2 = this.zza.zzc() + zzj2;
            do {
                zzknVar.zza(this.zza.zzn());
            } while (this.zza.zzc() < zzc2);
            return;
        }
        do {
            zzknVar.zza(this.zza.zzn());
            if (this.zza.zzt()) {
                return;
            } else {
                zzi2 = this.zza.zzi();
            }
        } while (zzi2 == this.zzb);
        this.zzd = zzi2;
    }

    @Override // com.google.android.gms.internal.measurement.zzlr
    public final long zzl() throws IOException {
        zzb(0);
        return this.zza.zzl();
    }

    @Override // com.google.android.gms.internal.measurement.zzlr
    public final void zzl(List<Integer> list) throws IOException {
        int zzi;
        int zzi2;
        if (!(list instanceof zzjw)) {
            int i11 = this.zzb & 7;
            if (i11 != 0) {
                if (i11 != 2) {
                    throw zzkb.zza();
                }
                int zzc = this.zza.zzc() + this.zza.zzj();
                do {
                    list.add(Integer.valueOf(this.zza.zzh()));
                } while (this.zza.zzc() < zzc);
                zza(zzc);
                return;
            }
            do {
                list.add(Integer.valueOf(this.zza.zzh()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    zzi = this.zza.zzi();
                }
            } while (zzi == this.zzb);
            this.zzd = zzi;
            return;
        }
        zzjw zzjwVar = (zzjw) list;
        int i12 = this.zzb & 7;
        if (i12 != 0) {
            if (i12 != 2) {
                throw zzkb.zza();
            }
            int zzc2 = this.zza.zzc() + this.zza.zzj();
            do {
                zzjwVar.zzd(this.zza.zzh());
            } while (this.zza.zzc() < zzc2);
            zza(zzc2);
            return;
        }
        do {
            zzjwVar.zzd(this.zza.zzh());
            if (this.zza.zzt()) {
                return;
            } else {
                zzi2 = this.zza.zzi();
            }
        } while (zzi2 == this.zzb);
        this.zzd = zzi2;
    }

    @Override // com.google.android.gms.internal.measurement.zzlr
    public final long zzm() throws IOException {
        zzb(1);
        return this.zza.zzn();
    }

    @Override // com.google.android.gms.internal.measurement.zzlr
    public final void zzm(List<Long> list) throws IOException {
        int zzi;
        int zzi2;
        if (!(list instanceof zzkn)) {
            int i11 = this.zzb & 7;
            if (i11 != 0) {
                if (i11 != 2) {
                    throw zzkb.zza();
                }
                int zzc = this.zza.zzc() + this.zza.zzj();
                do {
                    list.add(Long.valueOf(this.zza.zzo()));
                } while (this.zza.zzc() < zzc);
                zza(zzc);
                return;
            }
            do {
                list.add(Long.valueOf(this.zza.zzo()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    zzi = this.zza.zzi();
                }
            } while (zzi == this.zzb);
            this.zzd = zzi;
            return;
        }
        zzkn zzknVar = (zzkn) list;
        int i12 = this.zzb & 7;
        if (i12 != 0) {
            if (i12 != 2) {
                throw zzkb.zza();
            }
            int zzc2 = this.zza.zzc() + this.zza.zzj();
            do {
                zzknVar.zza(this.zza.zzo());
            } while (this.zza.zzc() < zzc2);
            zza(zzc2);
            return;
        }
        do {
            zzknVar.zza(this.zza.zzo());
            if (this.zza.zzt()) {
                return;
            } else {
                zzi2 = this.zza.zzi();
            }
        } while (zzi2 == this.zzb);
        this.zzd = zzi2;
    }

    @Override // com.google.android.gms.internal.measurement.zzlr
    public final long zzn() throws IOException {
        zzb(0);
        return this.zza.zzo();
    }

    @Override // com.google.android.gms.internal.measurement.zzlr
    public final void zzn(List<String> list) throws IOException {
        zza(list, false);
    }

    @Override // com.google.android.gms.internal.measurement.zzlr
    public final long zzo() throws IOException {
        zzb(0);
        return this.zza.zzp();
    }

    @Override // com.google.android.gms.internal.measurement.zzlr
    public final void zzo(List<String> list) throws IOException {
        zza(list, true);
    }

    @Override // com.google.android.gms.internal.measurement.zzlr
    public final zzik zzp() throws IOException {
        zzb(2);
        return this.zza.zzq();
    }

    @Override // com.google.android.gms.internal.measurement.zzlr
    public final void zzp(List<Integer> list) throws IOException {
        int zzi;
        int zzi2;
        if (!(list instanceof zzjw)) {
            int i11 = this.zzb & 7;
            if (i11 != 0) {
                if (i11 != 2) {
                    throw zzkb.zza();
                }
                int zzc = this.zza.zzc() + this.zza.zzj();
                do {
                    list.add(Integer.valueOf(this.zza.zzj()));
                } while (this.zza.zzc() < zzc);
                zza(zzc);
                return;
            }
            do {
                list.add(Integer.valueOf(this.zza.zzj()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    zzi = this.zza.zzi();
                }
            } while (zzi == this.zzb);
            this.zzd = zzi;
            return;
        }
        zzjw zzjwVar = (zzjw) list;
        int i12 = this.zzb & 7;
        if (i12 != 0) {
            if (i12 != 2) {
                throw zzkb.zza();
            }
            int zzc2 = this.zza.zzc() + this.zza.zzj();
            do {
                zzjwVar.zzd(this.zza.zzj());
            } while (this.zza.zzc() < zzc2);
            zza(zzc2);
            return;
        }
        do {
            zzjwVar.zzd(this.zza.zzj());
            if (this.zza.zzt()) {
                return;
            } else {
                zzi2 = this.zza.zzi();
            }
        } while (zzi2 == this.zzb);
        this.zzd = zzi2;
    }

    @Override // com.google.android.gms.internal.measurement.zzlr
    public final String zzq() throws IOException {
        zzb(2);
        return this.zza.zzr();
    }

    @Override // com.google.android.gms.internal.measurement.zzlr
    public final void zzq(List<Long> list) throws IOException {
        int zzi;
        int zzi2;
        if (!(list instanceof zzkn)) {
            int i11 = this.zzb & 7;
            if (i11 != 0) {
                if (i11 != 2) {
                    throw zzkb.zza();
                }
                int zzc = this.zza.zzc() + this.zza.zzj();
                do {
                    list.add(Long.valueOf(this.zza.zzp()));
                } while (this.zza.zzc() < zzc);
                zza(zzc);
                return;
            }
            do {
                list.add(Long.valueOf(this.zza.zzp()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    zzi = this.zza.zzi();
                }
            } while (zzi == this.zzb);
            this.zzd = zzi;
            return;
        }
        zzkn zzknVar = (zzkn) list;
        int i12 = this.zzb & 7;
        if (i12 != 0) {
            if (i12 != 2) {
                throw zzkb.zza();
            }
            int zzc2 = this.zza.zzc() + this.zza.zzj();
            do {
                zzknVar.zza(this.zza.zzp());
            } while (this.zza.zzc() < zzc2);
            zza(zzc2);
            return;
        }
        do {
            zzknVar.zza(this.zza.zzp());
            if (this.zza.zzt()) {
                return;
            } else {
                zzi2 = this.zza.zzi();
            }
        } while (zzi2 == this.zzb);
        this.zzd = zzi2;
    }

    @Override // com.google.android.gms.internal.measurement.zzlr
    public final String zzr() throws IOException {
        zzb(2);
        return this.zza.zzs();
    }

    @Override // com.google.android.gms.internal.measurement.zzlr
    public final boolean zzs() throws IOException {
        zzb(0);
        return this.zza.zzu();
    }

    @Override // com.google.android.gms.internal.measurement.zzlr
    public final boolean zzt() throws IOException {
        int i11;
        if (this.zza.zzt() || (i11 = this.zzb) == this.zzc) {
            return false;
        }
        return this.zza.zze(i11);
    }
}
