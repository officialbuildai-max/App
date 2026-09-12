package com.google.android.libraries.places.internal;

import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzmw implements Iterable {
    final /* synthetic */ CharSequence zza;
    final /* synthetic */ zzmy zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmw(zzmy zzmyVar, CharSequence charSequence) {
        this.zza = charSequence;
        this.zzb = zzmyVar;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        Iterator zzg;
        zzg = this.zzb.zzg(this.zza);
        return zzg;
    }

    public final String toString() {
        zzmh zzc = zzmh.zzc(", ");
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        zzc.zzg(sb2, iterator());
        sb2.append(']');
        return sb2.toString();
    }
}
