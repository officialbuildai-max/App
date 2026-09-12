package com.google.android.libraries.places.internal;

import java.io.OutputStream;

/* loaded from: classes4.dex */
final class zzbmu extends OutputStream {
    final /* synthetic */ zzbmw zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzbmu(zzbmw zzbmwVar, zzbmt zzbmtVar) {
        this.zza = zzbmwVar;
    }

    @Override // java.io.OutputStream
    public final void write(int i11) {
        zzbmw.zzh(this.zza, new byte[]{(byte) i11}, 0, 1);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i11, int i12) {
        zzbmw.zzh(this.zza, bArr, i11, i12);
    }
}
