package com.google.android.libraries.places.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zznm extends zznp {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zznm(Comparable comparable) {
        super(comparable);
        comparable.getClass();
    }

    @Override // com.google.android.libraries.places.internal.zznp
    public final int hashCode() {
        return ~this.zza.hashCode();
    }

    public final String toString() {
        return "/" + this.zza.toString() + "\\";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.libraries.places.internal.zznp
    public final void zzc(StringBuilder sb2) {
        sb2.append('(');
        sb2.append(this.zza);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.libraries.places.internal.zznp
    public final void zzd(StringBuilder sb2) {
        sb2.append(this.zza);
        sb2.append(']');
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.libraries.places.internal.zznp
    public final boolean zze(Comparable comparable) {
        int i11 = zzok.zzc;
        return this.zza.compareTo(comparable) < 0;
    }
}
