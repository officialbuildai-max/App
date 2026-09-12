package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
final class zzasd extends zzash {
    private final int zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzasd(byte[] bArr, int i11, int i12) {
        super(bArr);
        zzask.zzj(0, i12, bArr.length);
        this.zzc = i12;
    }

    @Override // com.google.android.libraries.places.internal.zzash, com.google.android.libraries.places.internal.zzask
    public final byte zza(int i11) {
        int i12 = this.zzc;
        if (((i12 - (i11 + 1)) | i11) >= 0) {
            return this.zza[i11];
        }
        if (i11 < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i11);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i11 + ", " + i12);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.libraries.places.internal.zzash, com.google.android.libraries.places.internal.zzask
    public final byte zzb(int i11) {
        return this.zza[i11];
    }

    @Override // com.google.android.libraries.places.internal.zzash
    protected final int zzc() {
        return 0;
    }

    @Override // com.google.android.libraries.places.internal.zzash, com.google.android.libraries.places.internal.zzask
    public final int zzd() {
        return this.zzc;
    }
}
