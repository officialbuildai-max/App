package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzavj implements zzavt {
    private final zzavf zza;
    private final zzawn zzb;
    private final boolean zzc;
    private final zzatg zzd;

    private zzavj(zzawn zzawnVar, zzatg zzatgVar, zzavf zzavfVar) {
        this.zzb = zzawnVar;
        this.zzc = zzatgVar.zzi(zzavfVar);
        this.zzd = zzatgVar;
        this.zza = zzavfVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzavj zzi(zzawn zzawnVar, zzatg zzatgVar, zzavf zzavfVar) {
        return new zzavj(zzawnVar, zzatgVar, zzavfVar);
    }

    @Override // com.google.android.libraries.places.internal.zzavt
    public final int zza(Object obj) {
        zzawn zzawnVar = this.zzb;
        int zzb = zzawnVar.zzb(zzawnVar.zzd(obj));
        return this.zzc ? zzb + this.zzd.zzb(obj).zzc() : zzb;
    }

    @Override // com.google.android.libraries.places.internal.zzavt
    public final int zzb(Object obj) {
        int hashCode = this.zzb.zzd(obj).hashCode();
        return this.zzc ? (hashCode * 53) + this.zzd.zzb(obj).zza.hashCode() : hashCode;
    }

    @Override // com.google.android.libraries.places.internal.zzavt
    public final Object zzc() {
        zzavf zzavfVar = this.zza;
        return zzavfVar instanceof zzatu ? ((zzatu) zzavfVar).zzat() : zzavfVar.zzaI().zzu();
    }

    @Override // com.google.android.libraries.places.internal.zzavt
    public final void zzd(Object obj) {
        this.zzb.zzm(obj);
        this.zzd.zzf(obj);
    }

    @Override // com.google.android.libraries.places.internal.zzavt
    public final void zze(Object obj, Object obj2) {
        zzavv.zzr(this.zzb, obj, obj2);
        if (this.zzc) {
            zzavv.zzq(this.zzd, obj, obj2);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzavt
    public final void zzf(Object obj, zzavs zzavsVar, zzatf zzatfVar) throws IOException {
        boolean zzO;
        zzawn zzawnVar = this.zzb;
        Object zzc = zzawnVar.zzc(obj);
        zzatg zzatgVar = this.zzd;
        zzatk zzc2 = zzatgVar.zzc(obj);
        while (zzavsVar.zzc() != Integer.MAX_VALUE) {
            try {
                int zzd = zzavsVar.zzd();
                if (zzd != 11) {
                    if ((zzd & 7) == 2) {
                        Object zzd2 = zzatgVar.zzd(zzatfVar, this.zza, zzd >>> 3);
                        if (zzd2 != null) {
                            zzatgVar.zzg(zzavsVar, zzd2, zzatfVar, zzc2);
                        } else {
                            zzO = zzawnVar.zzp(zzc, zzavsVar);
                        }
                    } else {
                        zzO = zzavsVar.zzO();
                    }
                    if (!zzO) {
                        break;
                    }
                } else {
                    Object obj2 = null;
                    int i11 = 0;
                    zzask zzaskVar = null;
                    while (zzavsVar.zzc() != Integer.MAX_VALUE) {
                        int zzd3 = zzavsVar.zzd();
                        if (zzd3 == 16) {
                            i11 = zzavsVar.zzj();
                            obj2 = zzatgVar.zzd(zzatfVar, this.zza, i11);
                        } else if (zzd3 == 26) {
                            if (obj2 != null) {
                                zzatgVar.zzg(zzavsVar, obj2, zzatfVar, zzc2);
                            } else {
                                zzaskVar = zzavsVar.zzp();
                            }
                        } else if (!zzavsVar.zzO()) {
                            break;
                        }
                    }
                    if (zzavsVar.zzd() != 12) {
                        throw zzauf.zzb();
                    }
                    if (zzaskVar != null) {
                        if (obj2 != null) {
                            zzatgVar.zzh(zzaskVar, obj2, zzatfVar, zzc2);
                        } else {
                            zzawnVar.zzk(zzc, i11, zzaskVar);
                        }
                    }
                }
            } finally {
                zzawnVar.zzn(obj, zzc);
            }
        }
    }

    @Override // com.google.android.libraries.places.internal.zzavt
    public final boolean zzg(Object obj, Object obj2) {
        zzawn zzawnVar = this.zzb;
        if (!zzawnVar.zzd(obj).equals(zzawnVar.zzd(obj2))) {
            return false;
        }
        if (this.zzc) {
            return this.zzd.zzb(obj).equals(this.zzd.zzb(obj2));
        }
        return true;
    }

    @Override // com.google.android.libraries.places.internal.zzavt
    public final boolean zzh(Object obj) {
        return this.zzd.zzb(obj).zzj();
    }

    @Override // com.google.android.libraries.places.internal.zzavt
    public final void zzj(Object obj, zzasy zzasyVar) throws IOException {
        Iterator zzf = this.zzd.zzb(obj).zzf();
        while (zzf.hasNext()) {
            Map.Entry entry = (Map.Entry) zzf.next();
            zzatj zzatjVar = (zzatj) entry.getKey();
            if (zzatjVar.zze() != zzaxe.MESSAGE || zzatjVar.zzg() || zzatjVar.zzf()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (entry instanceof zzaui) {
                zzasyVar.zzw(zzatjVar.zza(), ((zzaui) entry).zza().zzb());
            } else {
                zzasyVar.zzw(zzatjVar.zza(), entry.getValue());
            }
        }
        zzawn zzawnVar = this.zzb;
        zzawnVar.zzr(zzawnVar.zzd(obj), zzasyVar);
    }
}
