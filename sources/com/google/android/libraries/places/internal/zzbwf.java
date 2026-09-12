package com.google.android.libraries.places.internal;

import java.io.Serializable;
import java.util.Arrays;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@SourceDebugExtension
/* loaded from: classes4.dex */
public class zzbwf implements Serializable, Comparable {
    public static final zzbwe zza = new zzbwe(null);

    @JvmField
    public static final zzbwf zzb = new zzbwf(new byte[0]);
    private final byte[] zzc;
    private transient int zzd;
    private transient String zze;

    public zzbwf(byte[] data) {
        Intrinsics.h(data, "data");
        this.zzc = data;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0033, code lost:
    
        return 1;
     */
    @Override // java.lang.Comparable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final /* bridge */ /* synthetic */ int compareTo(java.lang.Object r9) {
        /*
            r8 = this;
            com.google.android.libraries.places.internal.zzbwf r9 = (com.google.android.libraries.places.internal.zzbwf) r9
            java.lang.String r0 = "other"
            kotlin.jvm.internal.Intrinsics.h(r9, r0)
            int r0 = r8.zzc()
            int r1 = r9.zzc()
            int r2 = java.lang.Math.min(r0, r1)
            r3 = 0
            r4 = r3
        L15:
            r5 = 1
            if (r4 >= r2) goto L2d
            byte r6 = r8.zza(r4)
            r6 = r6 & 255(0xff, float:3.57E-43)
            byte r7 = r9.zza(r4)
            r7 = r7 & 255(0xff, float:3.57E-43)
            if (r6 != r7) goto L29
            int r4 = r4 + 1
            goto L15
        L29:
            if (r6 < r7) goto L34
        L2b:
            r3 = r5
            goto L33
        L2d:
            if (r0 != r1) goto L30
            goto L33
        L30:
            if (r0 < r1) goto L34
            goto L2b
        L33:
            return r3
        L34:
            r9 = -1
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzbwf.compareTo(java.lang.Object):int");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzbwf) {
            zzbwf zzbwfVar = (zzbwf) obj;
            int zzc = zzbwfVar.zzc();
            byte[] bArr = this.zzc;
            int length = bArr.length;
            if (zzc == length && zzbwfVar.zzl(0, bArr, 0, length)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i11 = this.zzd;
        if (i11 != 0) {
            return i11;
        }
        int hashCode = Arrays.hashCode(this.zzc);
        this.zzd = hashCode;
        return hashCode;
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x00bd, code lost:
    
        if (r8 != 64) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x00e4, code lost:
    
        if (r8 != 64) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x00e8, code lost:
    
        if (r8 != 64) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x009e, code lost:
    
        if (r8 != 64) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0073, code lost:
    
        if (r8 != 64) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x008d, code lost:
    
        if (r8 != 64) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0063, code lost:
    
        if (r8 != 64) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0129, code lost:
    
        if (r8 != 64) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0131, code lost:
    
        if (r8 != 64) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0121, code lost:
    
        if (r8 != 64) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0145, code lost:
    
        if (r8 != 64) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0149, code lost:
    
        if (r8 != 64) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x014d, code lost:
    
        if (r8 != 64) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00f4, code lost:
    
        if (r8 != 64) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0151, code lost:
    
        if (r8 != 64) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x00c5, code lost:
    
        if (r8 != 64) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            Method dump skipped, instructions count: 567
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzbwf.toString():java.lang.String");
    }

    public byte zza(int i11) {
        return this.zzc[i11];
    }

    public final int zzb() {
        return this.zzd;
    }

    public int zzc() {
        return this.zzc.length;
    }

    public final String zzd() {
        return zzbvu.zza(this.zzc, null, 1, null);
    }

    public String zze() {
        byte[] bArr = this.zzc;
        int length = bArr.length;
        char[] cArr = new char[length + length];
        int i11 = 0;
        for (byte b11 : bArr) {
            cArr[i11] = zzbwy.zza()[(b11 >> 4) & 15];
            cArr[i11 + 1] = zzbwy.zza()[b11 & 15];
            i11 += 2;
        }
        return StringsKt.B(cArr);
    }

    public final String zzf() {
        String str = this.zze;
        if (str != null) {
            return str;
        }
        String zza2 = zzbww.zza(zzo());
        this.zze = zza2;
        return zza2;
    }

    public zzbwf zzg() {
        int i11 = 0;
        while (true) {
            byte[] bArr = this.zzc;
            int length = bArr.length;
            if (i11 >= length) {
                return this;
            }
            int i12 = i11 + 1;
            byte b11 = bArr[i11];
            if (b11 >= 65 && b11 <= 90) {
                byte[] copyOf = Arrays.copyOf(bArr, length);
                Intrinsics.g(copyOf, "copyOf(...)");
                copyOf[i11] = (byte) (b11 + 32);
                while (i12 < copyOf.length) {
                    int i13 = i12 + 1;
                    byte b12 = copyOf[i12];
                    if (b12 >= 65 && b12 <= 90) {
                        copyOf[i12] = (byte) (b12 + 32);
                    }
                    i12 = i13;
                }
                return new zzbwf(copyOf);
            }
            i11 = i12;
        }
    }

    public final void zzh(int i11) {
        this.zzd = i11;
    }

    public final void zzi(String str) {
        this.zze = str;
    }

    public void zzj(zzbwb buffer, int i11, int i12) {
        Intrinsics.h(buffer, "buffer");
        int i13 = zzbwy.zza;
        Intrinsics.h(this, "<this>");
        Intrinsics.h(buffer, "buffer");
        buffer.zzl(this.zzc, 0, i12);
    }

    public boolean zzk(int i11, zzbwf other, int i12, int i13) {
        Intrinsics.h(other, "other");
        return other.zzl(0, this.zzc, 0, i13);
    }

    public boolean zzl(int i11, byte[] other, int i12, int i13) {
        Intrinsics.h(other, "other");
        if (i11 < 0) {
            return false;
        }
        byte[] bArr = this.zzc;
        return i11 <= bArr.length - i13 && i12 >= 0 && i12 <= other.length - i13 && zzbvv.zzc(bArr, i11, other, i12, i13);
    }

    public final boolean zzm(zzbwf prefix) {
        Intrinsics.h(prefix, "prefix");
        return zzk(0, prefix, 0, prefix.zzc.length);
    }

    public final byte[] zzn() {
        return this.zzc;
    }

    public byte[] zzo() {
        return this.zzc;
    }

    public byte[] zzp() {
        byte[] bArr = this.zzc;
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.g(copyOf, "copyOf(...)");
        return copyOf;
    }
}
