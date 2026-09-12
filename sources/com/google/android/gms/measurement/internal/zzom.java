package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzfy;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzom {
    private long zza;
    private zzfy.zzj zzb;
    private String zzc;
    private Map<String, String> zzd;
    private zznt zze;

    public final zzoj zza() {
        return new zzoj(this.zza, this.zzb, this.zzc, this.zzd, this.zze);
    }

    public final zzom zza(long j11) {
        this.zza = j11;
        return this;
    }

    public final zzom zza(zzfy.zzj zzjVar) {
        this.zzb = zzjVar;
        return this;
    }

    public final zzom zza(zznt zzntVar) {
        this.zze = zzntVar;
        return this;
    }

    public final zzom zza(String str) {
        this.zzc = str;
        return this;
    }

    public final zzom zza(Map<String, String> map) {
        this.zzd = map;
        return this;
    }
}
