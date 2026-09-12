package com.google.android.libraries.places.internal;

import java.net.SocketAddress;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzbnd {
    private List zza;
    private int zzb;
    private int zzc;

    public zzbnd(List list) {
        this.zza = list == null ? Collections.emptyList() : list;
    }

    public final int zza() {
        List list = this.zza;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public final zzaye zzb() {
        if (zzg()) {
            return ((zzazs) this.zza.get(this.zzb)).zza();
        }
        throw new IllegalStateException("Index is off the end of the address group list");
    }

    public final SocketAddress zzc() {
        if (zzg()) {
            return (SocketAddress) ((zzazs) this.zza.get(this.zzb)).zzb().get(this.zzc);
        }
        throw new IllegalStateException("Index is past the end of the address group list");
    }

    public final void zzd() {
        this.zzb = 0;
        this.zzc = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
    
        r1 = r1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zze(com.google.android.libraries.places.internal.zznx r1) {
        /*
            r0 = this;
            if (r1 != 0) goto L6
            java.util.List r1 = java.util.Collections.emptyList()
        L6:
            r0.zza = r1
            r0.zzd()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzbnd.zze(com.google.android.libraries.places.internal.zznx):void");
    }

    public final boolean zzf() {
        if (!zzg()) {
            return false;
        }
        zzazs zzazsVar = (zzazs) this.zza.get(this.zzb);
        int i11 = this.zzc + 1;
        this.zzc = i11;
        if (i11 < zzazsVar.zzb().size()) {
            return true;
        }
        int i12 = this.zzb + 1;
        this.zzb = i12;
        this.zzc = 0;
        return i12 < this.zza.size();
    }

    public final boolean zzg() {
        return this.zzb < this.zza.size();
    }

    public final boolean zzh(SocketAddress socketAddress) {
        for (int i11 = 0; i11 < this.zza.size(); i11++) {
            int indexOf = ((zzazs) this.zza.get(i11)).zzb().indexOf(socketAddress);
            if (indexOf != -1) {
                this.zzb = i11;
                this.zzc = indexOf;
                return true;
            }
        }
        return false;
    }
}
