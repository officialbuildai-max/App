package com.google.android.libraries.places.internal;

import com.cloud.tmc.integration.event.EventConstants;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import okhttp3.internal.http2.Settings;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzbsu {
    private final zzbsr zza;
    private final zzbts zzb;
    private int zzc;
    private final zzbsq zzd;

    public zzbsu(zzbsr zzbsrVar, zzbts zzbtsVar) {
        this.zza = zzbsrVar;
        zzmt.zzc(zzbtsVar, "frameWriter");
        this.zzb = zzbtsVar;
        this.zzc = Settings.DEFAULT_INITIAL_WINDOW_SIZE;
        this.zzd = new zzbsq(this, 0, Settings.DEFAULT_INITIAL_WINDOW_SIZE, null);
    }

    public final int zza(zzbsq zzbsqVar, int i11) {
        if (zzbsqVar == null) {
            int zzb = this.zzd.zzb(i11);
            zzg();
            return zzb;
        }
        int zzb2 = zzbsqVar.zzb(i11);
        zzbst zzbstVar = new zzbst(null);
        zzbsqVar.zzf(zzbsqVar.zze(), zzbstVar);
        if (!zzbstVar.zza()) {
            return zzb2;
        }
        zzf();
        return zzb2;
    }

    public final zzbsq zzc(zzbsp zzbspVar, int i11) {
        return new zzbsq(this, i11, this.zzc, zzbspVar);
    }

    public final void zze(boolean z10, zzbsq zzbsqVar, zzbwb zzbwbVar, boolean z11) {
        zzmt.zzc(zzbwbVar, EventConstants.KEY_SOURCE);
        int zze = zzbsqVar.zze();
        boolean zzk = zzbsqVar.zzk();
        int zzg = (int) zzbwbVar.zzg();
        if (zzk || zze < zzg) {
            if (!zzk && zze > 0) {
                zzbsqVar.zzj(zzbwbVar, zze, false);
            }
            zzbsqVar.zzi(zzbwbVar, (int) zzbwbVar.zzg(), z10);
        } else {
            zzbsqVar.zzj(zzbwbVar, zzg, z10);
        }
        if (z11) {
            zzf();
        }
    }

    public final void zzf() {
        try {
            this.zzb.zzg();
        } catch (IOException e11) {
            throw new RuntimeException(e11);
        }
    }

    public final void zzg() {
        int i11;
        zzbsq[] zzV = this.zza.zzV();
        Collections.shuffle(Arrays.asList(zzV));
        int length = zzV.length;
        int zzd = this.zzd.zzd();
        while (true) {
            i11 = 0;
            if (length <= 0 || zzd <= 0) {
                break;
            }
            int ceil = (int) Math.ceil(zzd / length);
            for (int i12 = 0; i12 < length && zzd > 0; i12++) {
                zzbsq zzbsqVar = zzV[i12];
                int min = Math.min(zzd, Math.min(zzbsqVar.zzc(), ceil));
                if (min > 0) {
                    zzbsqVar.zzg(min);
                    zzd -= min;
                }
                if (zzbsqVar.zzc() > 0) {
                    zzV[i11] = zzbsqVar;
                    i11++;
                }
            }
            length = i11;
        }
        zzbst zzbstVar = new zzbst(null);
        zzbsq[] zzV2 = this.zza.zzV();
        int length2 = zzV2.length;
        while (i11 < length2) {
            zzbsq zzbsqVar2 = zzV2[i11];
            zzbsqVar2.zzf(zzbsqVar2.zza(), zzbstVar);
            zzbsqVar2.zzh();
            i11++;
        }
        if (zzbstVar.zza()) {
            zzf();
        }
    }

    public final boolean zzh(int i11) {
        if (i11 < 0) {
            throw new IllegalArgumentException("Invalid initial window size: " + i11);
        }
        int i12 = i11 - this.zzc;
        this.zzc = i11;
        for (zzbsq zzbsqVar : this.zza.zzV()) {
            zzbsqVar.zzb(i12);
        }
        return i12 > 0;
    }
}
