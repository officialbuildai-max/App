package com.google.android.gms.internal.measurement;

/* loaded from: classes4.dex */
public enum zzs {
    DEBUG(3),
    ERROR(6),
    INFO(4),
    VERBOSE(2),
    WARN(5);

    zzs(int i11) {
    }

    public static zzs zza(int i11) {
        return i11 != 2 ? i11 != 3 ? i11 != 5 ? i11 != 6 ? INFO : ERROR : WARN : DEBUG : VERBOSE;
    }
}
