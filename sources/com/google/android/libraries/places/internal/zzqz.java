package com.google.android.libraries.places.internal;

import java.util.Set;
import java.util.logging.Level;

/* loaded from: classes4.dex */
final class zzqz extends zzqp {
    private final zzpu zza;
    private final Level zzb;
    private final Set zzc;
    private final zzqh zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzqz(String str, String str2, boolean z10, zzpu zzpuVar, boolean z11, boolean z12) {
        super(str2);
        Set set;
        zzqh zzqhVar;
        Level level = Level.ALL;
        set = zzrb.zza;
        zzqhVar = zzrb.zzb;
        this.zza = zzpuVar;
        this.zzb = level;
        this.zzc = set;
        this.zzd = zzqhVar;
    }
}
