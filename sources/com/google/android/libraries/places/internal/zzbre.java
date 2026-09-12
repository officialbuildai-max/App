package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.net.Socket;

/* loaded from: classes4.dex */
final class zzbre implements Runnable {
    final /* synthetic */ zzbri zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbre(zzbri zzbriVar) {
        this.zza = zzbriVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbrj zzbrjVar;
        zzbrj zzbrjVar2;
        zzbrj zzbrjVar3;
        Socket socket;
        Socket socket2;
        zzbwq zzbwqVar;
        zzbwq zzbwqVar2;
        zzbwq zzbwqVar3;
        zzbwb zzbwbVar;
        zzbwq zzbwqVar4;
        zzbwb zzbwbVar2;
        zzbwb zzbwbVar3;
        try {
            zzbri zzbriVar = this.zza;
            zzbwqVar3 = zzbriVar.zzh;
            if (zzbwqVar3 != null) {
                zzbwbVar = zzbriVar.zzb;
                if (zzbwbVar.zzg() > 0) {
                    zzbwqVar4 = zzbriVar.zzh;
                    zzbwbVar2 = zzbriVar.zzb;
                    zzbwbVar3 = zzbriVar.zzb;
                    zzbwqVar4.zzn(zzbwbVar2, zzbwbVar3.zzg());
                }
            }
        } catch (IOException e11) {
            zzbrjVar = this.zza.zzd;
            zzbrjVar.zzb(e11);
        }
        try {
            zzbri zzbriVar2 = this.zza;
            zzbwqVar = zzbriVar2.zzh;
            if (zzbwqVar != null) {
                zzbwqVar2 = zzbriVar2.zzh;
                zzbwqVar2.close();
            }
        } catch (IOException e12) {
            zzbrjVar2 = this.zza.zzd;
            zzbrjVar2.zzb(e12);
        }
        try {
            zzbri zzbriVar3 = this.zza;
            socket = zzbriVar3.zzi;
            if (socket != null) {
                socket2 = zzbriVar3.zzi;
                socket2.close();
            }
        } catch (IOException e13) {
            zzbrjVar3 = this.zza.zzd;
            zzbrjVar3.zzb(e13);
        }
    }
}
