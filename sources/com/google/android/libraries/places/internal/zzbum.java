package com.google.android.libraries.places.internal;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes4.dex */
final class zzbum extends InputStream implements zzazr, zzbav {
    private zzavf zza;
    private final zzavn zzb;
    private ByteArrayInputStream zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbum(zzavf zzavfVar, zzavn zzavnVar) {
        this.zza = zzavfVar;
        this.zzb = zzavnVar;
    }

    @Override // java.io.InputStream
    public final int available() {
        zzavf zzavfVar = this.zza;
        if (zzavfVar != null) {
            return zzavfVar.zzaq();
        }
        ByteArrayInputStream byteArrayInputStream = this.zzc;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.available();
        }
        return 0;
    }

    @Override // java.io.InputStream
    public final int read() {
        zzavf zzavfVar = this.zza;
        if (zzavfVar != null) {
            this.zzc = new ByteArrayInputStream(zzavfVar.zzao());
            this.zza = null;
        }
        ByteArrayInputStream byteArrayInputStream = this.zzc;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.read();
        }
        return -1;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i11, int i12) throws IOException {
        zzavf zzavfVar = this.zza;
        if (zzavfVar != null) {
            int zzaq = zzavfVar.zzaq();
            if (zzaq == 0) {
                this.zza = null;
                this.zzc = null;
                return -1;
            }
            if (i12 >= zzaq) {
                zzasx zzD = zzasx.zzD(bArr, i11, zzaq);
                this.zza.zzaK(zzD);
                zzD.zzE();
                this.zza = null;
                this.zzc = null;
                return zzaq;
            }
            this.zzc = new ByteArrayInputStream(this.zza.zzao());
            this.zza = null;
        }
        ByteArrayInputStream byteArrayInputStream = this.zzc;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.read(bArr, i11, i12);
        }
        return -1;
    }

    @Override // com.google.android.libraries.places.internal.zzazr
    public final int zza(OutputStream outputStream) throws IOException {
        zzavf zzavfVar = this.zza;
        if (zzavfVar != null) {
            int zzaq = zzavfVar.zzaq();
            this.zza.zzan(outputStream);
            this.zza = null;
            return zzaq;
        }
        ByteArrayInputStream byteArrayInputStream = this.zzc;
        if (byteArrayInputStream == null) {
            return 0;
        }
        zzmt.zzc(outputStream, "outputStream cannot be null!");
        byte[] bArr = new byte[8192];
        long j11 = 0;
        while (true) {
            int read = byteArrayInputStream.read(bArr);
            if (read == -1) {
                int i11 = (int) j11;
                this.zzc = null;
                return i11;
            }
            outputStream.write(bArr, 0, read);
            j11 += read;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzavf zzb() {
        zzavf zzavfVar = this.zza;
        if (zzavfVar != null) {
            return zzavfVar;
        }
        throw new IllegalStateException("message not available");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzavn zzc() {
        return this.zzb;
    }
}
