package com.google.android.libraries.places.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzbcd extends zzbca {
    private final zzbce zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzbcd(String str, boolean z10, zzbce zzbceVar, zzbcc zzbccVar) {
        super(str, z10, zzbceVar, null);
        zzmt.zzl(!str.endsWith("-bin"), "ASCII header is named %s.  Only binary headers may end with %s", str, "-bin");
        zzmt.zzc(zzbceVar, "marshaller");
        this.zza = zzbceVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.libraries.places.internal.zzbca
    public final Object zza(byte[] bArr) {
        return this.zza.zza(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.libraries.places.internal.zzbca
    public final byte[] zzb(Object obj) {
        byte[] zzb = this.zza.zzb(obj);
        zzmt.zzc(zzb, "null marshaller.toAsciiString()");
        return zzb;
    }
}
