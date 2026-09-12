package com.google.android.gms.gcm;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes3.dex */
public final class zzh extends com.google.android.gms.internal.gcm.zzd implements zzg {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gcm.INetworkTaskCallback");
    }

    @Override // com.google.android.gms.gcm.zzg
    public final void zzf(int i11) throws RemoteException {
        Parcel zzd = zzd();
        zzd.writeInt(i11);
        zzd(2, zzd);
    }
}
