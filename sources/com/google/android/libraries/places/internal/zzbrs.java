package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
final class zzbrs implements Runnable {
    final /* synthetic */ zzben zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbrs(zzbru zzbruVar, zzben zzbenVar) {
        this.zza = zzbenVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zza();
    }
}
