package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes4.dex */
final class zzbtz implements zzbtr {
    final zzbtu zza;
    private final zzbwd zzb;
    private final zzbtx zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbtz(zzbwd zzbwdVar, int i11, boolean z10) {
        this.zzb = zzbwdVar;
        zzbtx zzbtxVar = new zzbtx(zzbwdVar);
        this.zzc = zzbtxVar;
        this.zza = new zzbtu(4096, 4096, zzbtxVar);
    }

    private final List zzb(int i11, short s11, byte b11, int i12) throws IOException {
        zzbtx zzbtxVar = this.zzc;
        zzbtxVar.zzd = i11;
        zzbtxVar.zza = i11;
        zzbtxVar.zze = s11;
        zzbtxVar.zzb = b11;
        zzbtxVar.zzc = i12;
        this.zza.zze();
        return this.zza.zzb();
    }

    private final void zzc(zzbtq zzbtqVar, int i11) throws IOException {
        this.zzb.zze();
        this.zzb.zzc();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.zzb.close();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:64:0x016a. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.places.internal.zzbtr
    public final boolean zza(zzbtq zzbtqVar) throws IOException {
        IOException zzi;
        Logger logger;
        IOException zzi2;
        IOException zzi3;
        IOException zzi4;
        IOException zzi5;
        IOException zzi6;
        IOException zzi7;
        IOException zzi8;
        IOException zzi9;
        IOException zzi10;
        IOException zzi11;
        IOException zzi12;
        IOException zzi13;
        IOException zzi14;
        IOException zzi15;
        IOException zzi16;
        IOException zzi17;
        IOException zzi18;
        IOException zzi19;
        IOException zzi20;
        IOException zzi21;
        IOException zzi22;
        Logger logger2;
        try {
            this.zzb.zzD(9L);
            int zzb = zzbub.zzb(this.zzb);
            if (zzb > 16384) {
                zzi = zzbub.zzi("FRAME_SIZE_ERROR: %s", Integer.valueOf(zzb));
                throw zzi;
            }
            byte zzc = (byte) (this.zzb.zzc() & 255);
            byte zzc2 = (byte) (this.zzb.zzc() & 255);
            int zze = this.zzb.zze() & Integer.MAX_VALUE;
            logger = zzbub.zza;
            Level level = Level.FINE;
            if (logger.isLoggable(level)) {
                logger2 = zzbub.zza;
                logger2.logp(level, "io.grpc.okhttp.internal.framed.Http2$Reader", "nextFrame", zzbty.zza(true, zze, zzb, zzc, zzc2));
            }
            switch (zzc) {
                case 0:
                    boolean z10 = zzc2 & 1;
                    if ((zzc2 & 32) != 0) {
                        zzi2 = zzbub.zzi("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
                        throw zzi2;
                    }
                    int zzc3 = (8 & zzc2) != 0 ? this.zzb.zzc() & 255 : 0;
                    zzbtqVar.zza(1 == z10, zze, this.zzb, zzbub.zza(zzb, zzc2, (short) zzc3), zzb);
                    this.zzb.zzF(zzc3);
                    return true;
                case 1:
                    if (zze == 0) {
                        zzi3 = zzbub.zzi("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
                        throw zzi3;
                    }
                    boolean z11 = zzc2 & 32;
                    boolean z12 = zzc2 & 1;
                    int zzc4 = (8 & zzc2) != 0 ? this.zzb.zzc() & 255 : 0;
                    if (z11 != 0) {
                        zzc(zzbtqVar, zze);
                        zzb -= 5;
                    }
                    short s11 = (short) zzc4;
                    zzbtqVar.zzh(false, 1 == z12, zze, -1, zzb(zzbub.zza(zzb, zzc2, s11), s11, zzc2, zze), 4);
                    return true;
                case 2:
                    if (zzb != 5) {
                        zzi4 = zzbub.zzi("TYPE_PRIORITY length: %d != 5", Integer.valueOf(zzb));
                        throw zzi4;
                    }
                    if (zze != 0) {
                        zzc(zzbtqVar, zze);
                        return true;
                    }
                    zzi5 = zzbub.zzi("TYPE_PRIORITY streamId == 0", new Object[0]);
                    throw zzi5;
                case 3:
                    if (zzb != 4) {
                        zzi6 = zzbub.zzi("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(zzb));
                        throw zzi6;
                    }
                    if (zze == 0) {
                        zzi7 = zzbub.zzi("TYPE_RST_STREAM streamId == 0", new Object[0]);
                        throw zzi7;
                    }
                    int zze2 = this.zzb.zze();
                    zzbtp zza = zzbtp.zza(zze2);
                    if (zza != null) {
                        zzbtqVar.zze(zze, zza);
                        return true;
                    }
                    zzi8 = zzbub.zzi("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(zze2));
                    throw zzi8;
                case 4:
                    if (zze != 0) {
                        zzi9 = zzbub.zzi("TYPE_SETTINGS streamId != 0", new Object[0]);
                        throw zzi9;
                    }
                    if ((zzc2 & 1) == 0) {
                        if (zzb % 6 != 0) {
                            zzi10 = zzbub.zzi("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(zzb));
                            throw zzi10;
                        }
                        zzbue zzbueVar = new zzbue();
                        for (int i11 = 0; i11 < zzb; i11 += 6) {
                            zzbwd zzbwdVar = this.zzb;
                            zzbwl zzbwlVar = (zzbwl) zzbwdVar;
                            zzbwlVar.zzD(2L);
                            short zzC = zzbwlVar.zzb.zzC();
                            int zze3 = zzbwdVar.zze();
                            switch (zzC) {
                                case 1:
                                case 6:
                                    zzbueVar.zze(zzC, 0, zze3);
                                case 2:
                                    if (zze3 != 0 && zze3 != 1) {
                                        zzi11 = zzbub.zzi("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                                        throw zzi11;
                                    }
                                    zzbueVar.zze(zzC, 0, zze3);
                                case 3:
                                    zzC = 4;
                                    zzbueVar.zze(zzC, 0, zze3);
                                case 4:
                                    if (zze3 < 0) {
                                        zzi12 = zzbub.zzi("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                                        throw zzi12;
                                    }
                                    zzC = 7;
                                    zzbueVar.zze(zzC, 0, zze3);
                                case 5:
                                    if (zze3 < 16384 || zze3 > 16777215) {
                                        zzi13 = zzbub.zzi("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(zze3));
                                        throw zzi13;
                                    }
                                    zzbueVar.zze(zzC, 0, zze3);
                                    break;
                                default:
                            }
                        }
                        zzbtqVar.zzf(false, zzbueVar);
                        if (zzbueVar.zzb() >= 0) {
                            this.zza.zzd(zzbueVar.zzb());
                        }
                    } else if (zzb != 0) {
                        zzi14 = zzbub.zzi("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                        throw zzi14;
                    }
                    return true;
                case 5:
                    if (zze == 0) {
                        zzi15 = zzbub.zzi("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
                        throw zzi15;
                    }
                    short zzc5 = (short) ((8 & zzc2) != 0 ? this.zzb.zzc() & 255 : 0);
                    zzbtqVar.zzd(zze, this.zzb.zze() & Integer.MAX_VALUE, zzb(zzbub.zza(zzb - 4, zzc2, zzc5), zzc5, zzc2, zze));
                    return true;
                case 6:
                    if (zzb != 8) {
                        zzi16 = zzbub.zzi("TYPE_PING length != 8: %s", Integer.valueOf(zzb));
                        throw zzi16;
                    }
                    if (zze != 0) {
                        zzi17 = zzbub.zzi("TYPE_PING streamId != 0", new Object[0]);
                        throw zzi17;
                    }
                    boolean z13 = 1 == (zzc2 & 1);
                    zzbwd zzbwdVar2 = this.zzb;
                    zzbtqVar.zzc(z13, zzbwdVar2.zze(), zzbwdVar2.zze());
                    return true;
                case 7:
                    if (zzb < 8) {
                        zzi18 = zzbub.zzi("TYPE_GOAWAY length < 8: %s", Integer.valueOf(zzb));
                        throw zzi18;
                    }
                    if (zze != 0) {
                        zzi19 = zzbub.zzi("TYPE_GOAWAY streamId != 0", new Object[0]);
                        throw zzi19;
                    }
                    zzbwd zzbwdVar3 = this.zzb;
                    int i12 = zzb - 8;
                    int zze4 = zzbwdVar3.zze();
                    int zze5 = zzbwdVar3.zze();
                    zzbtp zza2 = zzbtp.zza(zze5);
                    if (zza2 == null) {
                        zzi20 = zzbub.zzi("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(zze5));
                        throw zzi20;
                    }
                    zzbwf zzbwfVar = zzbwf.zzb;
                    if (i12 > 0) {
                        zzbwfVar = this.zzb.zzy(i12);
                    }
                    zzbtqVar.zzb(zze4, zza2, zzbwfVar);
                    return true;
                case 8:
                    if (zzb != 4) {
                        zzi21 = zzbub.zzi("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(zzb));
                        throw zzi21;
                    }
                    long zze6 = this.zzb.zze() & 2147483647L;
                    if (zze6 != 0) {
                        zzbtqVar.zzg(zze, zze6);
                        return true;
                    }
                    zzi22 = zzbub.zzi("windowSizeIncrement was 0", new Object[0]);
                    throw zzi22;
                default:
                    this.zzb.zzF(zzb);
                    return true;
            }
        } catch (IOException unused) {
            return false;
        }
    }
}
