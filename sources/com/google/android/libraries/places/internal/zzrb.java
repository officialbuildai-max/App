package com.google.android.libraries.places.internal;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;

/* loaded from: classes4.dex */
public final class zzrb extends zzqp {
    private static final Set zza;
    private static final zzqh zzb;
    private static final zzqy zzc;
    private final String zzd;
    private final zzpu zze;
    private final Level zzf;
    private final Set zzg;
    private final zzqh zzh;

    static {
        Set unmodifiableSet = Collections.unmodifiableSet(new HashSet(Arrays.asList(zzpo.zza, zzpt.zza)));
        zza = unmodifiableSet;
        zzb = zzqk.zza(unmodifiableSet).zzd();
        zzc = new zzqy();
    }

    public /* synthetic */ zzrb(String str, String str2, boolean z10, zzpu zzpuVar, Level level, Set set, zzqh zzqhVar, zzra zzraVar) {
        super(str2);
        if (str2.length() > 23) {
            int i11 = -1;
            for (int length = str2.length() - 1; length >= 0; length--) {
                char charAt = str2.charAt(length);
                if (charAt == '.' || charAt == '$') {
                    i11 = length;
                    break;
                }
            }
            str2 = str2.substring(i11 + 1);
        }
        String concat = "".concat(String.valueOf(str2));
        this.zzd = concat.substring(0, Math.min(concat.length(), 23));
        this.zze = zzpuVar;
        this.zzf = level;
        this.zzg = set;
        this.zzh = zzqhVar;
    }

    public static zzqy zzc() {
        return zzc;
    }
}
