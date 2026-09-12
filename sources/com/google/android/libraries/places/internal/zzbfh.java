package com.google.android.libraries.places.internal;

import com.cloud.tmc.integration.event.EventConstants;
import java.text.MessageFormat;
import java.util.logging.Level;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzbfh extends zzaym {
    private final zzbfi zza;
    private final zzbqt zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbfh(zzbfi zzbfiVar, zzbqt zzbqtVar) {
        zzmt.zzc(zzbfiVar, "tracer");
        this.zza = zzbfiVar;
        zzmt.zzc(zzbqtVar, EventConstants.KEY_TIME);
        this.zzb = zzbqtVar;
    }

    private static Level zzc(int i11) {
        int i12 = i11 - 1;
        return i12 != 1 ? (i12 == 2 || i12 == 3) ? Level.FINE : Level.FINEST : Level.FINER;
    }

    private final boolean zzd(int i11) {
        if (i11 == 1) {
            return false;
        }
        this.zza.zzd();
        return false;
    }

    @Override // com.google.android.libraries.places.internal.zzaym
    public final void zza(int i11, String str) {
        zzbap zza = this.zza.zza();
        Level zzc = zzc(i11);
        if (zzbfi.zza.isLoggable(zzc)) {
            zzbfi.zzb(zza, zzc, str);
        }
        zzd(i11);
    }

    @Override // com.google.android.libraries.places.internal.zzaym
    public final void zzb(int i11, String str, Object... objArr) {
        Level zzc = zzc(i11);
        zzd(i11);
        zza(i11, zzbfi.zza.isLoggable(zzc) ? MessageFormat.format(str, objArr) : null);
    }
}
