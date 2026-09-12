package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes4.dex */
public final class zzhe {
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final long zzd;
    private final /* synthetic */ zzha zze;

    private zzhe(zzha zzhaVar, String str, long j11) {
        this.zze = zzhaVar;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkArgument(j11 > 0);
        this.zza = str + ":start";
        this.zzb = str + ":count";
        this.zzc = str + ":value";
        this.zzd = j11;
    }

    private final long zzb() {
        return this.zze.zzg().getLong(this.zza, 0L);
    }

    private final void zzc() {
        this.zze.zzt();
        long currentTimeMillis = this.zze.zzb().currentTimeMillis();
        SharedPreferences.Editor edit = this.zze.zzg().edit();
        edit.remove(this.zzb);
        edit.remove(this.zzc);
        edit.putLong(this.zza, currentTimeMillis);
        edit.apply();
    }

    public final Pair<String, Long> zza() {
        long abs;
        this.zze.zzt();
        this.zze.zzt();
        long zzb = zzb();
        if (zzb == 0) {
            zzc();
            abs = 0;
        } else {
            abs = Math.abs(zzb - this.zze.zzb().currentTimeMillis());
        }
        long j11 = this.zzd;
        if (abs < j11) {
            return null;
        }
        if (abs > (j11 << 1)) {
            zzc();
            return null;
        }
        String string = this.zze.zzg().getString(this.zzc, null);
        long j12 = this.zze.zzg().getLong(this.zzb, 0L);
        zzc();
        return (string == null || j12 <= 0) ? zzha.zza : new Pair<>(string, Long.valueOf(j12));
    }

    public final void zza(String str, long j11) {
        this.zze.zzt();
        if (zzb() == 0) {
            zzc();
        }
        if (str == null) {
            str = "";
        }
        long j12 = this.zze.zzg().getLong(this.zzb, 0L);
        if (j12 <= 0) {
            SharedPreferences.Editor edit = this.zze.zzg().edit();
            edit.putString(this.zzc, str);
            edit.putLong(this.zzb, 1L);
            edit.apply();
            return;
        }
        long j13 = j12 + 1;
        boolean z10 = (this.zze.zzq().zzv().nextLong() & Long.MAX_VALUE) < Long.MAX_VALUE / j13;
        SharedPreferences.Editor edit2 = this.zze.zzg().edit();
        if (z10) {
            edit2.putString(this.zzc, str);
        }
        edit2.putLong(this.zzb, j13);
        edit2.apply();
    }
}
