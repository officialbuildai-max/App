package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzbms extends OutputStream {
    final /* synthetic */ zzbmw zza;
    private final List zzb = new ArrayList();
    private zzbra zzc;

    public /* synthetic */ zzbms(zzbmw zzbmwVar, zzbmr zzbmrVar) {
        this.zza = zzbmwVar;
    }

    public static /* bridge */ /* synthetic */ int zza(zzbms zzbmsVar) {
        Iterator it = zzbmsVar.zzb.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            i11 += ((zzbra) it.next()).zza();
        }
        return i11;
    }

    public static /* bridge */ /* synthetic */ List zzb(zzbms zzbmsVar) {
        return zzbmsVar.zzb;
    }

    @Override // java.io.OutputStream
    public final void write(int i11) throws IOException {
        zzbra zzbraVar = this.zzc;
        byte b11 = (byte) i11;
        if (zzbraVar == null || zzbraVar.zzb() <= 0) {
            write(new byte[]{b11}, 0, 1);
        } else {
            zzbraVar.zzc(b11);
        }
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i11, int i12) {
        zzbrb zzbrbVar;
        zzbrb zzbrbVar2;
        if (this.zzc == null) {
            zzbrbVar2 = this.zza.zzg;
            zzbra zza = zzbrbVar2.zza(i12);
            this.zzc = zza;
            this.zzb.add(zza);
        }
        while (i12 > 0) {
            int min = Math.min(i12, this.zzc.zzb());
            if (min == 0) {
                int zza2 = this.zzc.zza();
                int max = Math.max(i12, zza2 + zza2);
                zzbrbVar = this.zza.zzg;
                zzbra zza3 = zzbrbVar.zza(max);
                this.zzc = zza3;
                this.zzb.add(zza3);
            } else {
                this.zzc.zzd(bArr, i11, min);
                i11 += min;
                i12 -= min;
            }
        }
    }
}
