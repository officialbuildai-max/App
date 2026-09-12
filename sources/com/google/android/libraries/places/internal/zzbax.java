package com.google.android.libraries.places.internal;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzbax {
    private List zza;
    private final zzaye zzb = zzaye.zza;
    private Object[][] zzc = (Object[][]) Array.newInstance((Class<?>) Object.class, 0, 2);

    public final zzbax zza(zzbay zzbayVar, Object obj) {
        int i11 = 0;
        while (true) {
            Object[][] objArr = this.zzc;
            if (i11 >= objArr.length) {
                i11 = -1;
                break;
            }
            if (zzbayVar.equals(objArr[i11][0])) {
                break;
            }
            i11++;
        }
        if (i11 == -1) {
            Object[][] objArr2 = this.zzc;
            int length = objArr2.length;
            Object[][] objArr3 = (Object[][]) Array.newInstance((Class<?>) Object.class, length + 1, 2);
            System.arraycopy(objArr2, 0, objArr3, 0, length);
            this.zzc = objArr3;
            i11 = objArr3.length - 1;
        }
        Object[][] objArr4 = this.zzc;
        Object[] objArr5 = new Object[2];
        objArr5[0] = zzbayVar;
        objArr5[1] = obj;
        objArr4[i11] = objArr5;
        return this;
    }

    public final zzbax zzb(List list) {
        zzmt.zzf(!list.isEmpty(), "addrs is empty");
        this.zza = Collections.unmodifiableList(new ArrayList(list));
        return this;
    }

    public final zzbba zzc() {
        return new zzbba(this.zza, this.zzb, this.zzc, null);
    }
}
