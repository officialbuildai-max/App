package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes4.dex */
public abstract class zzasx extends zzarz {
    private static final Logger zza = Logger.getLogger(zzasx.class.getName());
    private static final boolean zzb = zzawx.zzx();
    public static final /* synthetic */ int zzf = 0;
    zzasy zze;

    private zzasx() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzasx(zzasw zzaswVar) {
    }

    public static int zzA(String str) {
        int length;
        try {
            length = zzaxc.zzc(str);
        } catch (zzaxb unused) {
            length = str.getBytes(zzaud.zzb).length;
        }
        return zzB(length) + length;
    }

    public static int zzB(int i11) {
        return (352 - (Integer.numberOfLeadingZeros(i11) * 9)) >>> 6;
    }

    public static int zzC(long j11) {
        return (640 - (Long.numberOfLeadingZeros(j11) * 9)) >>> 6;
    }

    public static zzasx zzD(byte[] bArr, int i11, int i12) {
        return new zzast(bArr, i11, i12);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public static int zzy(int i11, zzavf zzavfVar, zzavt zzavtVar) {
        int zzB = zzB(i11 << 3);
        return zzB + zzB + ((zzart) zzavfVar).zzak(zzavtVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzz(zzavf zzavfVar, zzavt zzavtVar) {
        int zzak = ((zzart) zzavfVar).zzak(zzavtVar);
        return zzB(zzak) + zzak;
    }

    public final void zzE() {
        if (zzb() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzF(String str, zzaxb zzaxbVar) throws IOException {
        zza.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzaxbVar);
        byte[] bytes = str.getBytes(zzaud.zzb);
        try {
            int length = bytes.length;
            zzu(length);
            zza(bytes, 0, length);
        } catch (IndexOutOfBoundsException e11) {
            throw new zzasu(e11);
        }
    }

    public abstract void zzJ() throws IOException;

    public abstract void zzK(byte b11) throws IOException;

    public abstract void zzL(int i11, boolean z10) throws IOException;

    public abstract void zzM(int i11, zzask zzaskVar) throws IOException;

    @Override // com.google.android.libraries.places.internal.zzarz
    public abstract void zza(byte[] bArr, int i11, int i12) throws IOException;

    public abstract int zzb();

    public abstract void zzh(int i11, int i12) throws IOException;

    public abstract void zzi(int i11) throws IOException;

    public abstract void zzj(int i11, long j11) throws IOException;

    public abstract void zzk(long j11) throws IOException;

    public abstract void zzl(int i11, int i12) throws IOException;

    public abstract void zzm(int i11) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzn(int i11, zzavf zzavfVar, zzavt zzavtVar) throws IOException;

    public abstract void zzo(int i11, zzavf zzavfVar) throws IOException;

    public abstract void zzp(int i11, zzask zzaskVar) throws IOException;

    public abstract void zzq(int i11, String str) throws IOException;

    public abstract void zzs(int i11, int i12) throws IOException;

    public abstract void zzt(int i11, int i12) throws IOException;

    public abstract void zzu(int i11) throws IOException;

    public abstract void zzv(int i11, long j11) throws IOException;

    public abstract void zzw(long j11) throws IOException;
}
