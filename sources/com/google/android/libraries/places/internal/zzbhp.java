package com.google.android.libraries.places.internal;

import java.io.InputStream;

/* loaded from: classes4.dex */
final class zzbhp implements Runnable {
    final /* synthetic */ InputStream zza;
    final /* synthetic */ zzbhy zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbhp(zzbhy zzbhyVar, InputStream inputStream) {
        this.zza = inputStream;
        this.zzb = zzbhyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbfr zzbfrVar;
        zzbfrVar = this.zzb.zzc;
        zzbfrVar.zzw(this.zza);
    }
}
