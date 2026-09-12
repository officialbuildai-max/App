package com.google.android.libraries.places.internal;

import java.util.Iterator;

/* loaded from: classes4.dex */
final class zzawr implements Iterator {
    final Iterator zza;
    final /* synthetic */ zzaws zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzawr(zzaws zzawsVar) {
        zzaun zzaunVar;
        this.zzb = zzawsVar;
        zzaunVar = zzawsVar.zza;
        this.zza = zzaunVar.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.zza.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
