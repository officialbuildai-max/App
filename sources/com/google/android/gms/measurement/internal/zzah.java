package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.zzje;
import java.util.EnumMap;

/* loaded from: classes4.dex */
final class zzah {
    private final EnumMap<zzje.zza, zzak> zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzah() {
        this.zza = new EnumMap<>(zzje.zza.class);
    }

    private zzah(EnumMap<zzje.zza, zzak> enumMap) {
        EnumMap<zzje.zza, zzak> enumMap2 = new EnumMap<>((Class<zzje.zza>) zzje.zza.class);
        this.zza = enumMap2;
        enumMap2.putAll(enumMap);
    }

    public static zzah zza(String str) {
        EnumMap enumMap = new EnumMap(zzje.zza.class);
        if (str.length() >= zzje.zza.values().length) {
            int i11 = 0;
            if (str.charAt(0) == '1') {
                zzje.zza[] values = zzje.zza.values();
                int length = values.length;
                int i12 = 1;
                while (i11 < length) {
                    enumMap.put((EnumMap) values[i11], (zzje.zza) zzak.zza(str.charAt(i12)));
                    i11++;
                    i12++;
                }
                return new zzah(enumMap);
            }
        }
        return new zzah();
    }

    public final String toString() {
        char c11;
        StringBuilder sb2 = new StringBuilder("1");
        for (zzje.zza zzaVar : zzje.zza.values()) {
            zzak zzakVar = this.zza.get(zzaVar);
            if (zzakVar == null) {
                zzakVar = zzak.UNSET;
            }
            c11 = zzakVar.zzl;
            sb2.append(c11);
        }
        return sb2.toString();
    }

    public final zzak zza(zzje.zza zzaVar) {
        zzak zzakVar = this.zza.get(zzaVar);
        return zzakVar == null ? zzak.UNSET : zzakVar;
    }

    public final void zza(zzje.zza zzaVar, int i11) {
        zzak zzakVar = zzak.UNSET;
        if (i11 != -30) {
            if (i11 != -20) {
                if (i11 == -10) {
                    zzakVar = zzak.MANIFEST;
                } else if (i11 != 0) {
                    if (i11 == 30) {
                        zzakVar = zzak.INITIALIZATION;
                    }
                }
            }
            zzakVar = zzak.API;
        } else {
            zzakVar = zzak.TCF;
        }
        this.zza.put((EnumMap<zzje.zza, zzak>) zzaVar, (zzje.zza) zzakVar);
    }

    public final void zza(zzje.zza zzaVar, zzak zzakVar) {
        this.zza.put((EnumMap<zzje.zza, zzak>) zzaVar, (zzje.zza) zzakVar);
    }
}
