package com.google.android.libraries.places.internal;

import android.support.v4.media.session.PlaybackStateCompat;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;

@SourceDebugExtension
/* loaded from: classes4.dex */
public final class zzbwb implements Cloneable, ByteChannel, zzbwd, zzbwc {

    @JvmField
    public zzbwn zza;
    private long zzb;

    public final /* synthetic */ Object clone() {
        zzbwb zzbwbVar = new zzbwb();
        if (this.zzb != 0) {
            zzbwn zzbwnVar = this.zza;
            Intrinsics.e(zzbwnVar);
            zzbwn zzc = zzbwnVar.zzc();
            zzbwbVar.zza = zzc;
            zzc.zzh = zzc;
            zzc.zzg = zzc;
            for (zzbwn zzbwnVar2 = zzbwnVar.zzg; zzbwnVar2 != zzbwnVar; zzbwnVar2 = zzbwnVar2.zzg) {
                zzbwn zzbwnVar3 = zzc.zzh;
                Intrinsics.e(zzbwnVar3);
                Intrinsics.e(zzbwnVar2);
                zzbwnVar3.zzb(zzbwnVar2.zzc());
            }
            zzbwbVar.zzb = this.zzb;
        }
        return zzbwbVar;
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable, com.google.android.libraries.places.internal.zzbws
    public final void close() {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzbwb) {
            long j11 = this.zzb;
            zzbwb zzbwbVar = (zzbwb) obj;
            if (j11 == zzbwbVar.zzb) {
                if (j11 == 0) {
                    return true;
                }
                zzbwn zzbwnVar = this.zza;
                Intrinsics.e(zzbwnVar);
                zzbwn zzbwnVar2 = zzbwbVar.zza;
                Intrinsics.e(zzbwnVar2);
                int i11 = zzbwnVar.zzc;
                int i12 = zzbwnVar2.zzc;
                long j12 = 0;
                while (j12 < this.zzb) {
                    long min = Math.min(zzbwnVar.zzd - i11, zzbwnVar2.zzd - i12);
                    long j13 = 0;
                    while (j13 < min) {
                        int i13 = i11 + 1;
                        int i14 = i12 + 1;
                        if (zzbwnVar.zzb[i11] == zzbwnVar2.zzb[i12]) {
                            j13++;
                            i11 = i13;
                            i12 = i14;
                        }
                    }
                    if (i11 == zzbwnVar.zzd) {
                        zzbwnVar = zzbwnVar.zzg;
                        Intrinsics.e(zzbwnVar);
                        i11 = zzbwnVar.zzc;
                    }
                    if (i12 == zzbwnVar2.zzd) {
                        zzbwnVar2 = zzbwnVar2.zzg;
                        Intrinsics.e(zzbwnVar2);
                        i12 = zzbwnVar2.zzc;
                    }
                    j12 += min;
                }
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.places.internal.zzbwc, com.google.android.libraries.places.internal.zzbwq, java.io.Flushable
    public final void flush() {
    }

    public final int hashCode() {
        zzbwn zzbwnVar = this.zza;
        if (zzbwnVar == null) {
            return 0;
        }
        int i11 = 1;
        do {
            int i12 = zzbwnVar.zzd;
            for (int i13 = zzbwnVar.zzc; i13 < i12; i13++) {
                i11 = (i11 * 31) + zzbwnVar.zzb[i13];
            }
            zzbwnVar = zzbwnVar.zzg;
            Intrinsics.e(zzbwnVar);
        } while (zzbwnVar != this.zza);
        return i11;
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return true;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer sink) throws IOException {
        Intrinsics.h(sink, "sink");
        zzbwn zzbwnVar = this.zza;
        if (zzbwnVar == null) {
            return -1;
        }
        int min = Math.min(sink.remaining(), zzbwnVar.zzd - zzbwnVar.zzc);
        sink.put(zzbwnVar.zzb, zzbwnVar.zzc, min);
        int i11 = zzbwnVar.zzc + min;
        zzbwnVar.zzc = i11;
        this.zzb -= min;
        if (i11 == zzbwnVar.zzd) {
            this.zza = zzbwnVar.zza();
            zzbwo.zzb(zzbwnVar);
        }
        return min;
    }

    public final String toString() {
        return zzz().toString();
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer source) throws IOException {
        Intrinsics.h(source, "source");
        int remaining = source.remaining();
        int i11 = remaining;
        while (i11 > 0) {
            zzbwn zzB = zzB(1);
            int min = Math.min(i11, 8192 - zzB.zzd);
            source.get(zzB.zzb, zzB.zzd, min);
            i11 -= min;
            zzB.zzd += min;
        }
        this.zzb += remaining;
        return remaining;
    }

    public final zzbwf zzA(int i11) {
        if (i11 == 0) {
            return zzbwf.zzb;
        }
        zzbvv.zzb(this.zzb, 0L, i11);
        zzbwn zzbwnVar = this.zza;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i13 < i11) {
            Intrinsics.e(zzbwnVar);
            int i15 = zzbwnVar.zzd;
            int i16 = zzbwnVar.zzc;
            if (i15 == i16) {
                throw new AssertionError("s.limit == s.pos");
            }
            i13 += i15 - i16;
            i14++;
            zzbwnVar = zzbwnVar.zzg;
        }
        byte[][] bArr = new byte[i14];
        int[] iArr = new int[i14 + i14];
        zzbwn zzbwnVar2 = this.zza;
        int i17 = 0;
        while (i12 < i11) {
            Intrinsics.e(zzbwnVar2);
            bArr[i17] = zzbwnVar2.zzb;
            i12 += zzbwnVar2.zzd - zzbwnVar2.zzc;
            iArr[i17] = Math.min(i12, i11);
            iArr[i17 + i14] = zzbwnVar2.zzc;
            zzbwnVar2.zze = true;
            i17++;
            zzbwnVar2 = zzbwnVar2.zzg;
        }
        return new zzbwp(bArr, iArr);
    }

    public final zzbwn zzB(int i11) {
        if (i11 <= 0) {
            throw new IllegalArgumentException("unexpected capacity");
        }
        zzbwn zzbwnVar = this.zza;
        if (zzbwnVar == null) {
            zzbwn zza = zzbwo.zza();
            this.zza = zza;
            zza.zzh = zza;
            zza.zzg = zza;
            return zza;
        }
        Intrinsics.e(zzbwnVar);
        zzbwn zzbwnVar2 = zzbwnVar.zzh;
        Intrinsics.e(zzbwnVar2);
        if (zzbwnVar2.zzd + i11 <= 8192 && zzbwnVar2.zzf) {
            return zzbwnVar2;
        }
        zzbwn zza2 = zzbwo.zza();
        zzbwnVar2.zzb(zza2);
        return zza2;
    }

    public final short zzC() throws EOFException {
        int i11;
        if (this.zzb < 2) {
            throw new EOFException(null);
        }
        zzbwn zzbwnVar = this.zza;
        Intrinsics.e(zzbwnVar);
        int i12 = zzbwnVar.zzc;
        int i13 = zzbwnVar.zzd;
        if (i13 - i12 < 2) {
            i11 = ((zzc() & 255) << 8) | (zzc() & 255);
        } else {
            byte[] bArr = zzbwnVar.zzb;
            int i14 = (bArr[i12] & 255) << 8;
            int i15 = bArr[i12 + 1] & 255;
            this.zzb -= 2;
            int i16 = i12 + 2;
            if (i16 == i13) {
                this.zza = zzbwnVar.zza();
                zzbwo.zzb(zzbwnVar);
            } else {
                zzbwnVar.zzc = i16;
            }
            i11 = i14 | i15;
        }
        return (short) i11;
    }

    @Override // com.google.android.libraries.places.internal.zzbwd
    public final void zzD(long j11) throws EOFException {
        throw null;
    }

    public final void zzE(long j11) {
        this.zzb = j11;
    }

    @Override // com.google.android.libraries.places.internal.zzbwd
    public final void zzF(long j11) throws EOFException {
        while (j11 > 0) {
            zzbwn zzbwnVar = this.zza;
            if (zzbwnVar == null) {
                throw new EOFException(null);
            }
            int min = (int) Math.min(j11, zzbwnVar.zzd - zzbwnVar.zzc);
            long j12 = min;
            this.zzb -= j12;
            j11 -= j12;
            int i11 = zzbwnVar.zzc + min;
            zzbwnVar.zzc = i11;
            if (i11 == zzbwnVar.zzd) {
                this.zza = zzbwnVar.zza();
                zzbwo.zzb(zzbwnVar);
            }
        }
    }

    public final boolean zzG() {
        return this.zzb == 0;
    }

    public final byte[] zzH(long j11) throws EOFException {
        if (j11 < 0 || j11 > 2147483647L) {
            throw new IllegalArgumentException("byteCount: " + j11);
        }
        if (this.zzb < j11) {
            throw new EOFException(null);
        }
        int i11 = (int) j11;
        byte[] sink = new byte[i11];
        Intrinsics.h(sink, "sink");
        int i12 = 0;
        while (i12 < i11) {
            int zzd = zzd(sink, i12, i11 - i12);
            if (zzd == -1) {
                throw new EOFException(null);
            }
            i12 += zzd;
        }
        return sink;
    }

    @Override // com.google.android.libraries.places.internal.zzbws
    public final long zza(zzbwb sink, long j11) {
        Intrinsics.h(sink, "sink");
        if (j11 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j11);
        }
        long j12 = this.zzb;
        if (j12 == 0) {
            return -1L;
        }
        if (j11 > j12) {
            j11 = j12;
        }
        sink.zzn(this, j11);
        return j11;
    }

    @JvmName
    public final byte zzb(long j11) {
        zzbvv.zzb(this.zzb, j11, 1L);
        zzbwn zzbwnVar = this.zza;
        if (zzbwnVar == null) {
            Intrinsics.e(null);
            throw null;
        }
        long j12 = this.zzb;
        if (j12 - j11 < j11) {
            while (j12 > j11) {
                zzbwnVar = zzbwnVar.zzh;
                Intrinsics.e(zzbwnVar);
                j12 -= zzbwnVar.zzd - zzbwnVar.zzc;
            }
            Intrinsics.e(zzbwnVar);
            return zzbwnVar.zzb[(int) ((zzbwnVar.zzc + j11) - j12)];
        }
        long j13 = 0;
        while (true) {
            long j14 = (zzbwnVar.zzd - zzbwnVar.zzc) + j13;
            if (j14 > j11) {
                Intrinsics.e(zzbwnVar);
                return zzbwnVar.zzb[(int) ((zzbwnVar.zzc + j11) - j13)];
            }
            zzbwnVar = zzbwnVar.zzg;
            Intrinsics.e(zzbwnVar);
            j13 = j14;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbwd
    public final byte zzc() throws EOFException {
        if (this.zzb == 0) {
            throw new EOFException(null);
        }
        zzbwn zzbwnVar = this.zza;
        Intrinsics.e(zzbwnVar);
        int i11 = zzbwnVar.zzc;
        int i12 = zzbwnVar.zzd;
        int i13 = i11 + 1;
        byte b11 = zzbwnVar.zzb[i11];
        this.zzb--;
        if (i13 == i12) {
            this.zza = zzbwnVar.zza();
            zzbwo.zzb(zzbwnVar);
        } else {
            zzbwnVar.zzc = i13;
        }
        return b11;
    }

    public final int zzd(byte[] sink, int i11, int i12) {
        Intrinsics.h(sink, "sink");
        zzbvv.zzb(sink.length, i11, i12);
        zzbwn zzbwnVar = this.zza;
        if (zzbwnVar == null) {
            return -1;
        }
        int min = Math.min(i12, zzbwnVar.zzd - zzbwnVar.zzc);
        int i13 = zzbwnVar.zzc;
        ArraysKt.j(zzbwnVar.zzb, sink, i11, i13, i13 + min);
        int i14 = zzbwnVar.zzc + min;
        zzbwnVar.zzc = i14;
        this.zzb -= min;
        if (i14 != zzbwnVar.zzd) {
            return min;
        }
        this.zza = zzbwnVar.zza();
        zzbwo.zzb(zzbwnVar);
        return min;
    }

    @Override // com.google.android.libraries.places.internal.zzbwd
    public final int zze() throws EOFException {
        if (this.zzb < 4) {
            throw new EOFException(null);
        }
        zzbwn zzbwnVar = this.zza;
        Intrinsics.e(zzbwnVar);
        int i11 = zzbwnVar.zzc;
        int i12 = zzbwnVar.zzd;
        if (i12 - i11 < 4) {
            return ((zzc() & 255) << 24) | ((zzc() & 255) << 16) | ((zzc() & 255) << 8) | (zzc() & 255);
        }
        byte[] bArr = zzbwnVar.zzb;
        int i13 = (bArr[i11] & 255) << 24;
        int i14 = (bArr[i11 + 1] & 255) << 16;
        int i15 = (bArr[i11 + 2] & 255) << 8;
        this.zzb -= 4;
        int i16 = (bArr[i11 + 3] & 255) | i14 | i13 | i15;
        int i17 = i11 + 4;
        if (i17 == i12) {
            this.zza = zzbwnVar.zza();
            zzbwo.zzb(zzbwnVar);
        } else {
            zzbwnVar.zzc = i17;
        }
        return i16;
    }

    public final long zzf() {
        long j11 = this.zzb;
        if (j11 == 0) {
            return 0L;
        }
        zzbwn zzbwnVar = this.zza;
        Intrinsics.e(zzbwnVar);
        zzbwn zzbwnVar2 = zzbwnVar.zzh;
        Intrinsics.e(zzbwnVar2);
        if (zzbwnVar2.zzd < 8192 && zzbwnVar2.zzf) {
            j11 -= r3 - zzbwnVar2.zzc;
        }
        return j11;
    }

    @JvmName
    public final long zzg() {
        return this.zzb;
    }

    public final String zzh(long j11, Charset charset) throws EOFException {
        Intrinsics.h(charset, "charset");
        if (j11 < 0 || j11 > 2147483647L) {
            throw new IllegalArgumentException("byteCount: " + j11);
        }
        if (this.zzb < j11) {
            throw new EOFException();
        }
        if (j11 == 0) {
            return "";
        }
        zzbwn zzbwnVar = this.zza;
        Intrinsics.e(zzbwnVar);
        int i11 = zzbwnVar.zzc;
        int i12 = zzbwnVar.zzd;
        if (i11 + j11 > i12) {
            return new String(zzH(j11), charset);
        }
        int i13 = (int) j11;
        String str = new String(zzbwnVar.zzb, i11, i13, charset);
        int i14 = i11 + i13;
        zzbwnVar.zzc = i14;
        this.zzb -= j11;
        if (i14 == i12) {
            this.zza = zzbwnVar.zza();
            zzbwo.zzb(zzbwnVar);
        }
        return str;
    }

    public final String zzi() {
        return zzh(this.zzb, Charsets.UTF_8);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String zzj(long r17) throws java.io.EOFException {
        /*
            Method dump skipped, instructions count: 413
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzbwb.zzj(long):java.lang.String");
    }

    public final zzbwb zzk(zzbwf byteString) {
        Intrinsics.h(byteString, "byteString");
        byteString.zzj(this, 0, byteString.zzc());
        return this;
    }

    public final zzbwb zzl(byte[] source, int i11, int i12) {
        Intrinsics.h(source, "source");
        long j11 = i12;
        zzbvv.zzb(source.length, i11, j11);
        int i13 = i11;
        while (true) {
            int i14 = i11 + i12;
            if (i13 >= i14) {
                this.zzb += j11;
                return this;
            }
            zzbwn zzB = zzB(1);
            int min = Math.min(i14 - i13, 8192 - zzB.zzd);
            int i15 = i13 + min;
            ArraysKt.j(source, zzB.zzb, zzB.zzd, i13, i15);
            zzB.zzd += min;
            i13 = i15;
        }
    }

    public final zzbwb zzm(int i11) {
        zzbwn zzB = zzB(1);
        byte[] bArr = zzB.zzb;
        int i12 = zzB.zzd;
        zzB.zzd = i12 + 1;
        bArr[i12] = (byte) i11;
        this.zzb++;
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zzbwq
    public final void zzn(zzbwb source, long j11) {
        zzbwn zzbwnVar;
        Intrinsics.h(source, "source");
        if (source == this) {
            throw new IllegalArgumentException("source == this");
        }
        zzbvv.zzb(source.zzb, 0L, j11);
        while (j11 > 0) {
            zzbwn zzbwnVar2 = source.zza;
            Intrinsics.e(zzbwnVar2);
            int i11 = zzbwnVar2.zzd;
            zzbwn zzbwnVar3 = source.zza;
            Intrinsics.e(zzbwnVar3);
            long j12 = i11 - zzbwnVar3.zzc;
            int i12 = 0;
            if (j11 < j12) {
                zzbwn zzbwnVar4 = this.zza;
                if (zzbwnVar4 != null) {
                    Intrinsics.e(zzbwnVar4);
                    zzbwnVar = zzbwnVar4.zzh;
                } else {
                    zzbwnVar = null;
                }
                int i13 = (int) j11;
                if (zzbwnVar != null && zzbwnVar.zzf) {
                    if ((zzbwnVar.zzd + j11) - (zzbwnVar.zze ? 0 : zzbwnVar.zzc) <= PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
                        zzbwn zzbwnVar5 = source.zza;
                        Intrinsics.e(zzbwnVar5);
                        zzbwnVar5.zze(zzbwnVar, i13);
                        source.zzb -= j11;
                        this.zzb += j11;
                        return;
                    }
                }
                zzbwn zzbwnVar6 = source.zza;
                Intrinsics.e(zzbwnVar6);
                source.zza = zzbwnVar6.zzd(i13);
            }
            zzbwn zzbwnVar7 = source.zza;
            Intrinsics.e(zzbwnVar7);
            int i14 = zzbwnVar7.zzd - zzbwnVar7.zzc;
            source.zza = zzbwnVar7.zza();
            zzbwn zzbwnVar8 = this.zza;
            if (zzbwnVar8 == null) {
                this.zza = zzbwnVar7;
                zzbwnVar7.zzh = zzbwnVar7;
                zzbwnVar7.zzg = zzbwnVar7;
            } else {
                Intrinsics.e(zzbwnVar8);
                zzbwn zzbwnVar9 = zzbwnVar8.zzh;
                Intrinsics.e(zzbwnVar9);
                zzbwnVar9.zzb(zzbwnVar7);
                zzbwn zzbwnVar10 = zzbwnVar7.zzh;
                if (zzbwnVar10 == zzbwnVar7) {
                    throw new IllegalStateException("cannot compact");
                }
                Intrinsics.e(zzbwnVar10);
                if (zzbwnVar10.zzf) {
                    int i15 = zzbwnVar7.zzd - zzbwnVar7.zzc;
                    zzbwn zzbwnVar11 = zzbwnVar7.zzh;
                    Intrinsics.e(zzbwnVar11);
                    int i16 = 8192 - zzbwnVar11.zzd;
                    zzbwn zzbwnVar12 = zzbwnVar7.zzh;
                    Intrinsics.e(zzbwnVar12);
                    if (!zzbwnVar12.zze) {
                        zzbwn zzbwnVar13 = zzbwnVar7.zzh;
                        Intrinsics.e(zzbwnVar13);
                        i12 = zzbwnVar13.zzc;
                    }
                    if (i15 <= i16 + i12) {
                        zzbwn zzbwnVar14 = zzbwnVar7.zzh;
                        Intrinsics.e(zzbwnVar14);
                        zzbwnVar7.zze(zzbwnVar14, i15);
                        zzbwnVar7.zza();
                        zzbwo.zzb(zzbwnVar7);
                    }
                }
            }
            long j13 = i14;
            source.zzb -= j13;
            this.zzb += j13;
            j11 -= j13;
        }
    }

    public final zzbwb zzo(long j11) {
        if (j11 == 0) {
            zzm(48);
        } else {
            long j12 = (j11 >>> 1) | j11;
            long j13 = j12 | (j12 >>> 2);
            long j14 = j13 | (j13 >>> 4);
            long j15 = j14 | (j14 >>> 8);
            long j16 = j15 - ((j15 >>> 1) & 6148914691236517205L);
            long j17 = ((j16 >>> 2) & 3689348814741910323L) + (j16 & 3689348814741910323L);
            long j18 = ((j17 >>> 4) + j17) & 1085102592571150095L;
            long j19 = j18 + (j18 >>> 8);
            long j20 = j19 + (j19 >>> 16);
            int i11 = (int) ((((j20 & 63) + ((j20 >>> 32) & 63)) + 3) >> 2);
            zzbwn zzB = zzB(i11);
            byte[] bArr = zzB.zzb;
            int i12 = zzB.zzd;
            int i13 = i12 + i11;
            while (true) {
                i13--;
                if (i13 < i12) {
                    break;
                }
                bArr[i13] = zzbwx.zza()[(int) (15 & j11)];
                j11 >>>= 4;
            }
            zzB.zzd += i11;
            this.zzb += i11;
        }
        return this;
    }

    public final zzbwb zzp(int i11) {
        zzbwn zzB = zzB(4);
        byte[] bArr = zzB.zzb;
        int i12 = zzB.zzd;
        bArr[i12] = (byte) (i11 >> 24);
        bArr[i12 + 1] = (byte) ((i11 >>> 16) & 255);
        bArr[i12 + 2] = (byte) ((i11 >>> 8) & 255);
        bArr[i12 + 3] = (byte) (i11 & 255);
        zzB.zzd = i12 + 4;
        this.zzb += 4;
        return this;
    }

    public final zzbwb zzq(int i11) {
        zzbwn zzB = zzB(2);
        byte[] bArr = zzB.zzb;
        int i12 = zzB.zzd;
        bArr[i12] = (byte) ((i11 >>> 8) & 255);
        bArr[i12 + 1] = (byte) (i11 & 255);
        zzB.zzd = i12 + 2;
        this.zzb += 2;
        return this;
    }

    @JvmOverloads
    public final zzbwb zzr(OutputStream out, long j11) throws IOException {
        Intrinsics.h(out, "out");
        zzbvv.zzb(this.zzb, 0L, j11);
        zzbwn zzbwnVar = this.zza;
        while (j11 > 0) {
            Intrinsics.e(zzbwnVar);
            int min = (int) Math.min(j11, zzbwnVar.zzd - zzbwnVar.zzc);
            out.write(zzbwnVar.zzb, zzbwnVar.zzc, min);
            int i11 = zzbwnVar.zzc + min;
            zzbwnVar.zzc = i11;
            long j12 = min;
            this.zzb -= j12;
            j11 -= j12;
            if (i11 == zzbwnVar.zzd) {
                zzbwn zza = zzbwnVar.zza();
                this.zza = zza;
                zzbwo.zzb(zzbwnVar);
                zzbwnVar = zza;
            }
        }
        return this;
    }

    public final zzbwb zzs(String string) {
        Intrinsics.h(string, "string");
        zzt(string, 0, string.length());
        return this;
    }

    public final zzbwb zzt(String string, int i11, int i12) {
        Intrinsics.h(string, "string");
        if (i12 < 0) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i12 + " < 0");
        }
        if (i12 > string.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i12 + " > " + string.length());
        }
        int i13 = 0;
        while (i13 < i12) {
            int i14 = i13 + 1;
            char charAt = string.charAt(i13);
            if (charAt < 128) {
                zzbwn zzB = zzB(1);
                byte[] bArr = zzB.zzb;
                int i15 = zzB.zzd - i13;
                int min = Math.min(i12, 8192 - i15);
                bArr[i13 + i15] = (byte) charAt;
                i13 = i14;
                while (i13 < min) {
                    char charAt2 = string.charAt(i13);
                    if (charAt2 >= 128) {
                        break;
                    }
                    bArr[i13 + i15] = (byte) charAt2;
                    i13++;
                }
                int i16 = zzB.zzd;
                int i17 = (i15 + i13) - i16;
                zzB.zzd = i16 + i17;
                this.zzb += i17;
            } else {
                if (charAt < 2048) {
                    zzbwn zzB2 = zzB(2);
                    byte[] bArr2 = zzB2.zzb;
                    int i18 = zzB2.zzd;
                    bArr2[i18] = (byte) ((charAt >> 6) | PsExtractor.AUDIO_STREAM);
                    bArr2[i18 + 1] = (byte) ((charAt & '?') | 128);
                    zzB2.zzd = i18 + 2;
                    this.zzb += 2;
                } else if (charAt < 55296 || charAt > 57343) {
                    zzbwn zzB3 = zzB(3);
                    byte[] bArr3 = zzB3.zzb;
                    int i19 = zzB3.zzd;
                    bArr3[i19] = (byte) ((charAt >> '\f') | 224);
                    bArr3[i19 + 1] = (byte) ((63 & (charAt >> 6)) | 128);
                    bArr3[i19 + 2] = (byte) ((charAt & '?') | 128);
                    zzB3.zzd = i19 + 3;
                    this.zzb += 3;
                } else {
                    char charAt3 = i14 < i12 ? string.charAt(i14) : (char) 0;
                    if (charAt > 56319 || charAt3 < 56320 || charAt3 >= 57344) {
                        zzm(63);
                    } else {
                        zzbwn zzB4 = zzB(4);
                        byte[] bArr4 = zzB4.zzb;
                        int i20 = zzB4.zzd;
                        int i21 = (((charAt & 1023) << 10) | (charAt3 & 1023)) + 65536;
                        bArr4[i20] = (byte) ((i21 >> 18) | 240);
                        bArr4[i20 + 1] = (byte) (((i21 >> 12) & 63) | 128);
                        bArr4[i20 + 2] = (byte) (((i21 >> 6) & 63) | 128);
                        bArr4[i20 + 3] = (byte) ((i21 & 63) | 128);
                        zzB4.zzd = i20 + 4;
                        this.zzb += 4;
                        i13 += 2;
                    }
                }
                i13 = i14;
            }
        }
        return this;
    }

    public final zzbwb zzu(int i11) {
        if (i11 < 128) {
            zzm(i11);
        } else if (i11 < 2048) {
            zzbwn zzB = zzB(2);
            byte[] bArr = zzB.zzb;
            int i12 = zzB.zzd;
            bArr[i12] = (byte) ((i11 >> 6) | PsExtractor.AUDIO_STREAM);
            bArr[i12 + 1] = (byte) ((i11 & 63) | 128);
            zzB.zzd = i12 + 2;
            this.zzb += 2;
        } else if (i11 >= 55296 && i11 < 57344) {
            zzm(63);
        } else if (i11 < 65536) {
            zzbwn zzB2 = zzB(3);
            byte[] bArr2 = zzB2.zzb;
            int i13 = zzB2.zzd;
            bArr2[i13] = (byte) ((i11 >> 12) | 224);
            bArr2[i13 + 1] = (byte) (((i11 >> 6) & 63) | 128);
            bArr2[i13 + 2] = (byte) ((i11 & 63) | 128);
            zzB2.zzd = i13 + 3;
            this.zzb += 3;
        } else {
            if (i11 > 1114111) {
                throw new IllegalArgumentException("Unexpected code point: 0x".concat(String.valueOf(zzbvv.zza(i11))));
            }
            zzbwn zzB3 = zzB(4);
            byte[] bArr3 = zzB3.zzb;
            int i14 = zzB3.zzd;
            bArr3[i14] = (byte) ((i11 >> 18) | 240);
            bArr3[i14 + 1] = (byte) (((i11 >> 12) & 63) | 128);
            bArr3[i14 + 2] = (byte) (((i11 >> 6) & 63) | 128);
            bArr3[i14 + 3] = (byte) ((i11 & 63) | 128);
            zzB3.zzd = i14 + 4;
            this.zzb += 4;
        }
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zzbwc
    public final /* bridge */ /* synthetic */ zzbwc zzv(int i11) {
        throw null;
    }

    @Override // com.google.android.libraries.places.internal.zzbwc
    public final /* bridge */ /* synthetic */ zzbwc zzw(int i11) {
        throw null;
    }

    @Override // com.google.android.libraries.places.internal.zzbwc
    public final /* bridge */ /* synthetic */ zzbwc zzx(String str) {
        throw null;
    }

    @Override // com.google.android.libraries.places.internal.zzbwd
    public final zzbwf zzy(long j11) throws EOFException {
        if (j11 < 0 || j11 > 2147483647L) {
            throw new IllegalArgumentException("byteCount: " + j11);
        }
        if (this.zzb < j11) {
            throw new EOFException(null);
        }
        if (j11 < PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
            return new zzbwf(zzH(j11));
        }
        zzbwf zzA = zzA((int) j11);
        zzF(j11);
        return zzA;
    }

    public final zzbwf zzz() {
        long j11 = this.zzb;
        if (j11 <= 2147483647L) {
            return zzA((int) j11);
        }
        throw new IllegalStateException("size > Int.MAX_VALUE: " + j11);
    }
}
