package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
final class zzbbw extends zzbca {
    private final zzbbx zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzbbw(String str, boolean z10, zzbbx zzbbxVar, zzbbv zzbbvVar) {
        super(str, false, zzbbxVar, null);
        zzmt.zzl(!str.endsWith("-bin"), "ASCII header is named %s.  Only binary headers may end with %s", str, "-bin");
        zzmt.zzc(zzbbxVar, "marshaller");
        this.zza = zzbbxVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbca
    final Object zza(byte[] bArr) {
        return this.zza.zza(new String(bArr, zzmb.zza));
    }

    @Override // com.google.android.libraries.places.internal.zzbca
    final byte[] zzb(Object obj) {
        String zzb = this.zza.zzb(obj);
        zzmt.zzc(zzb, "null marshaller.toAsciiString()");
        return zzb.getBytes(zzmb.zza);
    }
}
