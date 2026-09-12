package com.google.android.libraries.places.internal;

import java.io.IOException;

/* loaded from: classes4.dex */
abstract class zzbrh implements Runnable {
    final /* synthetic */ zzbri zzc;

    @Override // java.lang.Runnable
    public final void run() {
        zzbrj zzbrjVar;
        zzbwq zzbwqVar;
        try {
            zzbwqVar = this.zzc.zzh;
            if (zzbwqVar == null) {
                throw new IOException("Unable to perform write due to unavailable sink.");
            }
            zza();
        } catch (Exception e11) {
            zzbrjVar = this.zzc.zzd;
            zzbrjVar.zzb(e11);
        }
    }

    public abstract void zza() throws IOException;
}
