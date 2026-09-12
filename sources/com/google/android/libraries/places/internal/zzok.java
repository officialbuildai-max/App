package com.google.android.libraries.places.internal;

import java.io.Serializable;

/* loaded from: classes4.dex */
public final class zzok extends zzol implements Serializable {
    public static final /* synthetic */ int zzc = 0;
    private static final zzok zzd;
    final zznp zza;
    final zznp zzb;

    static {
        zznn zznnVar;
        zznl zznlVar;
        zznnVar = zznn.zzb;
        zznlVar = zznl.zzb;
        zzd = new zzok(zznnVar, zznlVar);
    }

    private zzok(zznp zznpVar, zznp zznpVar2) {
        zznl zznlVar;
        zznn zznnVar;
        this.zza = zznpVar;
        this.zzb = zznpVar2;
        if (zznpVar.compareTo(zznpVar2) <= 0) {
            zznlVar = zznl.zzb;
            if (zznpVar != zznlVar) {
                zznnVar = zznn.zzb;
                if (zznpVar2 != zznnVar) {
                    return;
                }
            }
        }
        throw new IllegalArgumentException("Invalid range: ".concat(zze(zznpVar, zznpVar2)));
    }

    public static zzok zza(Comparable comparable) {
        zznl zznlVar;
        zzno zznoVar = new zzno(comparable);
        zznlVar = zznl.zzb;
        return new zzok(zznoVar, zznlVar);
    }

    public static zzok zzb(Comparable comparable, Comparable comparable2) {
        return new zzok(new zzno(comparable), new zznm(comparable2));
    }

    public static zzok zzc(Comparable comparable, Comparable comparable2) {
        return new zzok(new zzno(comparable), new zzno(comparable2));
    }

    private static String zze(zznp zznpVar, zznp zznpVar2) {
        StringBuilder sb2 = new StringBuilder(16);
        zznpVar.zzc(sb2);
        sb2.append("..");
        zznpVar2.zzd(sb2);
        return sb2.toString();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzok) {
            zzok zzokVar = (zzok) obj;
            if (this.zza.equals(zzokVar.zza) && this.zzb.equals(zzokVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.zza.hashCode() * 31) + this.zzb.hashCode();
    }

    public final String toString() {
        return zze(this.zza, this.zzb);
    }

    public final boolean zzd(Comparable comparable) {
        comparable.getClass();
        return this.zza.zze(comparable) && !this.zzb.zze(comparable);
    }
}
