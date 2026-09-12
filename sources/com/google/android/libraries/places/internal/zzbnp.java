package com.google.android.libraries.places.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/* loaded from: classes4.dex */
final class zzbnp extends zzbbm {
    private final zzbbd zzf;
    private zzbbj zzg;
    private zzaze zzh = zzaze.IDLE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbnp(zzbbd zzbbdVar) {
        this.zzf = zzbbdVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzh(zzbnp zzbnpVar, zzbbj zzbbjVar, zzazf zzazfVar) {
        zzbbk zzbnmVar;
        zzaze zza = zzazfVar.zza();
        if (zza == zzaze.SHUTDOWN) {
            return;
        }
        zzaze zzazeVar = zzaze.TRANSIENT_FAILURE;
        if (zza == zzazeVar || zza == zzaze.IDLE) {
            zzbnpVar.zzf.zzd();
        }
        if (zzbnpVar.zzh == zzazeVar) {
            if (zza == zzaze.CONNECTING) {
                return;
            }
            if (zza == zzaze.IDLE) {
                zzbnpVar.zzd();
                return;
            }
        }
        int ordinal = zza.ordinal();
        if (ordinal == 0) {
            zzbnmVar = new zzbnm(zzbbe.zzc());
        } else if (ordinal == 1) {
            zzbnmVar = new zzbnm(zzbbe.zzd(zzbbjVar, null));
        } else if (ordinal == 2) {
            zzbnmVar = new zzbnm(zzbbe.zzb(zzazfVar.zzd()));
        } else {
            if (ordinal != 3) {
                throw new IllegalArgumentException("Unsupported state:".concat(zza.toString()));
            }
            zzbnmVar = new zzbno(zzbnpVar, zzbbjVar);
        }
        zzbnpVar.zzi(zza, zzbnmVar);
    }

    private final void zzi(zzaze zzazeVar, zzbbk zzbbkVar) {
        this.zzh = zzazeVar;
        this.zzf.zze(zzazeVar, zzbbkVar);
    }

    @Override // com.google.android.libraries.places.internal.zzbbm
    public final zzbdo zza(zzbbi zzbbiVar) {
        Boolean bool;
        List zze = zzbbiVar.zze();
        if (zze.isEmpty()) {
            zzbdo zzg = zzbdo.zzp.zzg("NameResolver returned no usable address. addrs=" + String.valueOf(zzbbiVar.zze()) + ", attrs=" + zzbbiVar.zza().toString());
            zzb(zzg);
            return zzg;
        }
        if ((zzbbiVar.zzd() instanceof zzbnl) && (bool = ((zzbnl) zzbbiVar.zzd()).zza) != null && bool.booleanValue()) {
            ArrayList arrayList = new ArrayList(zze);
            Collections.shuffle(arrayList, new Random());
            zze = arrayList;
        }
        zzbbj zzbbjVar = this.zzg;
        if (zzbbjVar == null) {
            zzbbd zzbbdVar = this.zzf;
            zzbax zzb = zzbba.zzb();
            zzb.zzb(zze);
            zzbbj zza = zzbbdVar.zza(zzb.zzc());
            zza.zzc(new zzbnk(this, zza));
            this.zzg = zza;
            zzi(zzaze.CONNECTING, new zzbnm(zzbbe.zzd(zza, null)));
            zza.zza();
        } else {
            zzbbjVar.zzd(zze);
        }
        return zzbdo.zza;
    }

    @Override // com.google.android.libraries.places.internal.zzbbm
    public final void zzb(zzbdo zzbdoVar) {
        zzbbj zzbbjVar = this.zzg;
        if (zzbbjVar != null) {
            zzbbjVar.zzb();
            this.zzg = null;
        }
        zzi(zzaze.TRANSIENT_FAILURE, new zzbnm(zzbbe.zzb(zzbdoVar)));
    }

    @Override // com.google.android.libraries.places.internal.zzbbm
    public final void zzd() {
        zzbbj zzbbjVar = this.zzg;
        if (zzbbjVar != null) {
            zzbbjVar.zza();
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbbm
    public final void zze() {
        zzbbj zzbbjVar = this.zzg;
        if (zzbbjVar != null) {
            zzbbjVar.zzb();
        }
    }
}
