package com.google.android.libraries.places.internal;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzavp {
    private static final zzavp zza = new zzavp();
    private final ConcurrentMap zzc = new ConcurrentHashMap();
    private final zzavu zzb = new zzaux();

    private zzavp() {
    }

    public static zzavp zza() {
        return zza;
    }

    public final zzavt zzb(Class cls) {
        zzaud.zzc(cls, "messageType");
        zzavt zzavtVar = (zzavt) this.zzc.get(cls);
        if (zzavtVar == null) {
            zzavtVar = this.zzb.zza(cls);
            zzaud.zzc(cls, "messageType");
            zzavt zzavtVar2 = (zzavt) this.zzc.putIfAbsent(cls, zzavtVar);
            if (zzavtVar2 != null) {
                return zzavtVar2;
            }
        }
        return zzavtVar;
    }
}
