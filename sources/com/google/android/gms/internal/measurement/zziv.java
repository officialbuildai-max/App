package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class zziv extends zzis {
    protected final byte[] zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zziv(byte[] bArr) {
        super();
        bArr.getClass();
        this.zzb = bArr;
    }

    @Override // com.google.android.gms.internal.measurement.zzik
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzik) || zzb() != ((zzik) obj).zzb()) {
            return false;
        }
        if (zzb() == 0) {
            return true;
        }
        if (!(obj instanceof zziv)) {
            return obj.equals(this);
        }
        zziv zzivVar = (zziv) obj;
        int zza = zza();
        int zza2 = zzivVar.zza();
        if (zza == 0 || zza2 == 0 || zza == zza2) {
            return zza(zzivVar, 0, zzb());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzik
    public byte zza(int i11) {
        return this.zzb[i11];
    }

    @Override // com.google.android.gms.internal.measurement.zzik
    public final zzik zza(int i11, int i12) {
        int zza = zzik.zza(0, i12, zzb());
        return zza == 0 ? zzik.zza : new zzio(this.zzb, zzc(), zza);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzik
    public final void zza(zzil zzilVar) throws IOException {
        zzilVar.zza(this.zzb, zzc(), zzb());
    }

    @Override // com.google.android.gms.internal.measurement.zzis
    final boolean zza(zzik zzikVar, int i11, int i12) {
        if (i12 > zzikVar.zzb()) {
            throw new IllegalArgumentException("Length too large: " + i12 + zzb());
        }
        if (i12 > zzikVar.zzb()) {
            throw new IllegalArgumentException("Ran off end of other: 0, " + i12 + ", " + zzikVar.zzb());
        }
        if (!(zzikVar instanceof zziv)) {
            return zzikVar.zza(0, i12).equals(zza(0, i12));
        }
        zziv zzivVar = (zziv) zzikVar;
        byte[] bArr = this.zzb;
        byte[] bArr2 = zzivVar.zzb;
        int zzc = zzc() + i12;
        int zzc2 = zzc();
        int zzc3 = zzivVar.zzc();
        while (zzc2 < zzc) {
            if (bArr[zzc2] != bArr2[zzc3]) {
                return false;
            }
            zzc2++;
            zzc3++;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzik
    public byte zzb(int i11) {
        return this.zzb[i11];
    }

    @Override // com.google.android.gms.internal.measurement.zzik
    public int zzb() {
        return this.zzb.length;
    }

    @Override // com.google.android.gms.internal.measurement.zzik
    protected final int zzb(int i11, int i12, int i13) {
        return zzjv.zza(i11, this.zzb, zzc(), i13);
    }

    protected int zzc() {
        return 0;
    }
}
