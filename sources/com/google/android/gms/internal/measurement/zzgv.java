package com.google.android.gms.internal.measurement;

import android.content.Context;
import com.google.common.base.q;

/* loaded from: classes4.dex */
final class zzgv extends zzhu {
    private final Context zza;
    private final q zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgv(Context context, q qVar) {
        if (context == null) {
            throw new NullPointerException("Null context");
        }
        this.zza = context;
        this.zzb = qVar;
    }

    public final boolean equals(Object obj) {
        q qVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzhu) {
            zzhu zzhuVar = (zzhu) obj;
            if (this.zza.equals(zzhuVar.zza()) && ((qVar = this.zzb) != null ? qVar.equals(zzhuVar.zzb()) : zzhuVar.zzb() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (this.zza.hashCode() ^ 1000003) * 1000003;
        q qVar = this.zzb;
        return hashCode ^ (qVar == null ? 0 : qVar.hashCode());
    }

    public final String toString() {
        return "FlagsContext{context=" + String.valueOf(this.zza) + ", hermeticFileOverrides=" + String.valueOf(this.zzb) + "}";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzhu
    public final Context zza() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzhu
    public final q zzb() {
        return this.zzb;
    }
}
