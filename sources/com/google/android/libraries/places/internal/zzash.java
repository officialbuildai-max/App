package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class zzash extends zzasg {
    protected final byte[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzash(byte[] bArr) {
        super(null);
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.libraries.places.internal.zzask
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzask) || zzd() != ((zzask) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzash)) {
            return obj.equals(this);
        }
        zzash zzashVar = (zzash) obj;
        int zzk = zzk();
        int zzk2 = zzashVar.zzk();
        if (zzk != 0 && zzk2 != 0 && zzk != zzk2) {
            return false;
        }
        int zzd = zzd();
        if (zzd > zzashVar.zzd()) {
            throw new IllegalArgumentException("Length too large: " + zzd + zzd());
        }
        if (zzd > zzashVar.zzd()) {
            throw new IllegalArgumentException("Ran off end of other: 0, " + zzd + ", " + zzashVar.zzd());
        }
        byte[] bArr = this.zza;
        byte[] bArr2 = zzashVar.zza;
        zzashVar.zzc();
        int i11 = 0;
        int i12 = 0;
        while (i11 < zzd) {
            if (bArr[i11] != bArr2[i12]) {
                return false;
            }
            i11++;
            i12++;
        }
        return true;
    }

    @Override // com.google.android.libraries.places.internal.zzask
    public byte zza(int i11) {
        return this.zza[i11];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.libraries.places.internal.zzask
    public byte zzb(int i11) {
        return this.zza[i11];
    }

    protected int zzc() {
        return 0;
    }

    @Override // com.google.android.libraries.places.internal.zzask
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.libraries.places.internal.zzask
    protected final int zze(int i11, int i12, int i13) {
        return zzaud.zzb(i11, this.zza, 0, i13);
    }

    @Override // com.google.android.libraries.places.internal.zzask
    public final zzask zzf(int i11, int i12) {
        int zzj = zzask.zzj(0, i12, zzd());
        return zzj == 0 ? zzask.zzb : new zzasd(this.zza, 0, zzj);
    }

    @Override // com.google.android.libraries.places.internal.zzask
    protected final String zzg(Charset charset) {
        return new String(this.zza, 0, zzd(), charset);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.libraries.places.internal.zzask
    public final void zzh(zzarz zzarzVar) throws IOException {
        zzarzVar.zza(this.zza, 0, zzd());
    }

    @Override // com.google.android.libraries.places.internal.zzask
    public final boolean zzi() {
        return zzaxc.zzf(this.zza, 0, zzd());
    }
}
