package com.google.android.libraries.places.internal;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzbfi {
    static final Logger zza = Logger.getLogger(zzaym.class.getName());
    private final Object zzb = new Object();
    private final zzbap zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbfi(zzbap zzbapVar, int i11, long j11, String str) {
        zzmt.zzc(zzbapVar, "logId");
        this.zzc = zzbapVar;
        zzbab zzbabVar = new zzbab();
        zzbabVar.zza(str.concat(" created"));
        zzbabVar.zzb(zzbac.CT_INFO);
        zzbabVar.zzd(j11);
        zzc(zzbabVar.zze());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzb(zzbap zzbapVar, Level level, String str) {
        Logger logger = zza;
        if (logger.isLoggable(level)) {
            LogRecord logRecord = new LogRecord(level, "[" + zzbapVar.toString() + "] " + str);
            logRecord.setLoggerName(logger.getName());
            logRecord.setSourceClassName(logger.getName());
            logRecord.setSourceMethodName("log");
            logger.log(logRecord);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzbap zza() {
        return this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzc(zzbae zzbaeVar) {
        zzbac zzbacVar = zzbac.CT_UNKNOWN;
        int ordinal = zzbaeVar.zzb.ordinal();
        Level level = ordinal != 2 ? ordinal != 3 ? Level.FINEST : Level.FINE : Level.FINER;
        synchronized (this.zzb) {
        }
        zzb(this.zzc, level, zzbaeVar.zza);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzd() {
        synchronized (this.zzb) {
        }
        return false;
    }
}
