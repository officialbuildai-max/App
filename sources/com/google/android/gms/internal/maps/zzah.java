package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.Tile;

/* loaded from: classes4.dex */
public final class zzah extends zza implements zzaf {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzah(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.ITileProviderDelegate");
    }

    @Override // com.google.android.gms.internal.maps.zzaf
    public final Tile getTile(int i11, int i12, int i13) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i11);
        zza.writeInt(i12);
        zza.writeInt(i13);
        Parcel zza2 = zza(1, zza);
        Tile tile = (Tile) zzc.zza(zza2, Tile.CREATOR);
        zza2.recycle();
        return tile;
    }
}
