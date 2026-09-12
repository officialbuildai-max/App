package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
final class zziq implements Callable<List<zzae>> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ zzic zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zziq(zzic zzicVar, String str, String str2, String str3) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = zzicVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzae> call() throws Exception {
        zznv zznvVar;
        zznv zznvVar2;
        zznvVar = this.zzd.zza;
        zznvVar.zzr();
        zznvVar2 = this.zzd.zza;
        return zznvVar2.zzf().zza(this.zza, this.zzb, this.zzc);
    }
}
