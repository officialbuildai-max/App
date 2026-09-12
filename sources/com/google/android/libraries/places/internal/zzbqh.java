package com.google.android.libraries.places.internal;

import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
public final class zzbqh {
    private zzbqh() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Set zza(Map map) {
        Set zzc = zzc(map, "nonFatalStatusCodes");
        if (zzc == null) {
            return Collections.unmodifiableSet(EnumSet.noneOf(zzbdj.class));
        }
        zzng.zza(!zzc.contains(zzbdj.OK), "%s must not contain OK", "nonFatalStatusCodes");
        return zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Set zzb(Map map) {
        Set zzc = zzc(map, "retryableStatusCodes");
        zzng.zza(zzc != null, "%s is required in retry policy", "retryableStatusCodes");
        zzng.zza(true ^ zzc.contains(zzbdj.OK), "%s must not contain OK", "retryableStatusCodes");
        return zzc;
    }

    private static Set zzc(Map map, String str) {
        zzbdj zzbdjVar;
        List zzg = zzbkg.zzg(map, str);
        if (zzg == null) {
            return null;
        }
        EnumSet noneOf = EnumSet.noneOf(zzbdj.class);
        for (Object obj : zzg) {
            if (obj instanceof Double) {
                Double d11 = (Double) obj;
                int intValue = d11.intValue();
                zzng.zza(((double) intValue) == d11.doubleValue(), "Status code %s is not integral", obj);
                zzbdjVar = zzbdo.zzd(intValue).zza();
                zzng.zza(zzbdjVar.zza() == d11.intValue(), "Status code %s is not valid", obj);
            } else {
                if (!(obj instanceof String)) {
                    throw new zznh("Can not convert status code " + String.valueOf(obj) + " to Status.Code, because its type is " + String.valueOf(obj.getClass()));
                }
                try {
                    zzbdjVar = (zzbdj) Enum.valueOf(zzbdj.class, (String) obj);
                } catch (IllegalArgumentException e11) {
                    throw new zznh("Status code " + String.valueOf(obj) + " is not valid", e11);
                }
            }
            noneOf.add(zzbdjVar);
        }
        return Collections.unmodifiableSet(noneOf);
    }
}
