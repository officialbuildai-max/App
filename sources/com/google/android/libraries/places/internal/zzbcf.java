package com.google.android.libraries.places.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.logging.Logger;

/* loaded from: classes4.dex */
public final class zzbcf {
    private Object[] zze;
    private int zzf;
    private static final Logger zzd = Logger.getLogger(zzbcf.class.getName());
    public static final zzbby zza = new zzbbt();
    public static final zzbbx zzb = new zzbbu();
    static final zzsi zzc = zzsi.zzj().zzf();

    public zzbcf() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbcf(int i11, Object[] objArr) {
        this.zzf = i11;
        this.zze = objArr;
    }

    private final int zzh() {
        Object[] objArr = this.zze;
        if (objArr != null) {
            return objArr.length;
        }
        return 0;
    }

    private final Object zzi(int i11) {
        return this.zze[i11 + i11 + 1];
    }

    private final void zzj(int i11) {
        Object[] objArr = new Object[i11];
        if (!zzk()) {
            Object[] objArr2 = this.zze;
            int i12 = this.zzf;
            System.arraycopy(objArr2, 0, objArr, 0, i12 + i12);
        }
        this.zze = objArr;
    }

    private final boolean zzk() {
        return this.zzf == 0;
    }

    private final byte[] zzl(int i11) {
        return (byte[]) this.zze[i11 + i11];
    }

    private final byte[] zzm(int i11) {
        Object zzi = zzi(i11);
        if (zzi instanceof byte[]) {
            return (byte[]) zzi;
        }
        throw null;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Metadata(");
        for (int i11 = 0; i11 < this.zzf; i11++) {
            if (i11 != 0) {
                sb2.append(',');
            }
            byte[] zzl = zzl(i11);
            Charset charset = zzmb.zza;
            String str = new String(zzl, charset);
            sb2.append(str);
            sb2.append('=');
            if (str.endsWith("-bin")) {
                zzsi zzsiVar = zzc;
                byte[] zzm = zzm(i11);
                sb2.append(zzsiVar.zzk(zzm, 0, zzm.length));
            } else {
                sb2.append(new String(zzm(i11), charset));
            }
        }
        sb2.append(')');
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zza() {
        return this.zzf;
    }

    public final Object zzb(zzbca zzbcaVar) {
        int i11 = this.zzf;
        do {
            i11--;
            if (i11 < 0) {
                return null;
            }
        } while (!Arrays.equals(zzbcaVar.zze(), zzl(i11)));
        Object zzi = zzi(i11);
        if (zzi instanceof byte[]) {
            return zzbcaVar.zza((byte[]) zzi);
        }
        throw null;
    }

    public final void zzd(zzbca zzbcaVar) {
        if (zzk()) {
            return;
        }
        int i11 = 0;
        int i12 = 0;
        while (true) {
            int i13 = this.zzf;
            if (i11 >= i13) {
                Arrays.fill(this.zze, i12 + i12, i13 + i13, (Object) null);
                this.zzf = i12;
                return;
            }
            if (!Arrays.equals(zzbcaVar.zze(), zzl(i11))) {
                int i14 = i12 + i12;
                this.zze[i14] = zzl(i11);
                Object zzi = zzi(i11);
                if (this.zze instanceof byte[][]) {
                    zzj(zzh());
                }
                this.zze[i14 + 1] = zzi;
                i12++;
            }
            i11++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0018, code lost:
    
        if (r0 < (r2 + r2)) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zze(com.google.android.libraries.places.internal.zzbcf r6) {
        /*
            r5 = this;
            boolean r0 = r6.zzk()
            if (r0 == 0) goto L7
            return
        L7:
            int r0 = r5.zzh()
            int r1 = r5.zzf
            int r1 = r1 + r1
            int r0 = r0 - r1
            boolean r2 = r5.zzk()
            if (r2 != 0) goto L1a
            int r2 = r6.zzf
            int r2 = r2 + r2
            if (r0 >= r2) goto L21
        L1a:
            int r0 = r6.zzf
            int r0 = r0 + r0
            int r1 = r1 + r0
            r5.zzj(r1)
        L21:
            java.lang.Object[] r0 = r6.zze
            java.lang.Object[] r1 = r5.zze
            int r2 = r5.zzf
            int r2 = r2 + r2
            int r3 = r6.zzf
            int r3 = r3 + r3
            r4 = 0
            java.lang.System.arraycopy(r0, r4, r1, r2, r3)
            int r0 = r5.zzf
            int r6 = r6.zzf
            int r0 = r0 + r6
            r5.zzf = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzbcf.zze(com.google.android.libraries.places.internal.zzbcf):void");
    }

    public final void zzf(zzbca zzbcaVar, Object obj) {
        zzmt.zzc(zzbcaVar, "key");
        zzmt.zzc(obj, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        int i11 = this.zzf;
        int i12 = i11 + i11;
        if (i12 == 0 || i12 == zzh()) {
            zzj(Math.max(i12 + i12, 8));
        }
        int i13 = this.zzf;
        this.zze[i13 + i13] = zzbcaVar.zze();
        int i14 = this.zzf;
        this.zze[i14 + i14 + 1] = zzbcaVar.zzb(obj);
        this.zzf++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final byte[][] zzg() {
        int i11 = this.zzf;
        int i12 = i11 + i11;
        byte[][] bArr = new byte[i12];
        Object[] objArr = this.zze;
        if (objArr instanceof byte[][]) {
            System.arraycopy(objArr, 0, bArr, 0, i12);
        } else {
            for (int i13 = 0; i13 < this.zzf; i13++) {
                int i14 = i13 + i13;
                bArr[i14] = zzl(i13);
                bArr[i14 + 1] = zzm(i13);
            }
        }
        return bArr;
    }
}
