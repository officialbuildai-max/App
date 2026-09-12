package com.google.android.libraries.places.internal;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.nio.charset.Charset;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes4.dex */
public final class zzbfq extends zzayo {
    private static final Logger zza = Logger.getLogger(zzbfq.class.getName());
    private static final byte[] zzb = "gzip".getBytes(Charset.forName(C.ASCII_NAME));
    private static final double zzc = TimeUnit.SECONDS.toNanos(1);
    private final zzbcl zzd;
    private final zzbvs zze;
    private final Executor zzf;
    private final boolean zzg;
    private final zzbfg zzh;
    private final zzazj zzi;
    private zzbfj zzj;
    private final boolean zzk;
    private zzayj zzl;
    private zzbfr zzm;
    private boolean zzn;
    private boolean zzo;
    private final zzbfp zzp;
    private final ScheduledExecutorService zzq;
    private zzazq zzr = zzazq.zzb();
    private zzazd zzs = zzazd.zza();

    public zzbfq(zzbcl zzbclVar, Executor executor, zzayj zzayjVar, zzbfp zzbfpVar, ScheduledExecutorService scheduledExecutorService, zzbfg zzbfgVar, zzbam zzbamVar) {
        this.zzd = zzbclVar;
        this.zze = zzbvr.zzc(zzbclVar.zzf(), System.identityHashCode(this));
        if (executor == zzakb.zza()) {
            this.zzf = new zzbpx();
            this.zzg = true;
        } else {
            this.zzf = new zzbqe(executor);
            this.zzg = false;
        }
        this.zzh = zzbfgVar;
        this.zzi = zzazj.zzb();
        this.zzk = zzbclVar.zzb() == zzbcj.UNARY || zzbclVar.zzb() == zzbcj.SERVER_STREAMING;
        this.zzl = zzayjVar;
        this.zzp = zzbfpVar;
        this.zzq = scheduledExecutorService;
    }

    public final zzazn zzr() {
        zzazn zzi = this.zzl.zzi();
        if (zzi == null) {
            return null;
        }
        return zzi;
    }

    private final void zzs(Object obj) {
        zzmt.zzp(this.zzm != null, "Not started");
        zzmt.zzp(!this.zzn, "call was cancelled");
        zzmt.zzp(!this.zzo, "call was half-closed");
        try {
            zzbfr zzbfrVar = this.zzm;
            if (zzbfrVar instanceof zzbpo) {
                ((zzbpo) zzbfrVar).zzab(obj);
            } else {
                zzbfrVar.zzw(this.zzd.zzc(obj));
            }
            if (this.zzk) {
                return;
            }
            this.zzm.zzr();
        } catch (Error e11) {
            this.zzm.zzh(zzbdo.zzb.zzg("Client sendMessage() failed with Error"));
            throw e11;
        } catch (RuntimeException e12) {
            this.zzm.zzh(zzbdo.zzb.zzf(e12).zzg("Failed to stream message"));
        }
    }

    public final String toString() {
        zzmm zzb2 = zzmn.zzb(this);
        zzb2.zzd("method", this.zzd);
        return zzb2.toString();
    }

    @Override // com.google.android.libraries.places.internal.zzayo
    public final void zza(String str, Throwable th2) {
        int i11 = zzbvr.zza;
        if (str == null && th2 == null) {
            th2 = new CancellationException("Cancelled without a message or cause");
            zza.logp(Level.WARNING, "io.grpc.internal.ClientCallImpl", "cancelInternal", "Cancelling without a message or cause is suboptimal", th2);
        }
        if (this.zzn) {
            return;
        }
        this.zzn = true;
        try {
            if (this.zzm != null) {
                zzbdo zzbdoVar = zzbdo.zzb;
                zzbdo zzg = str != null ? zzbdoVar.zzg(str) : zzbdoVar.zzg("Call cancelled without message");
                if (th2 != null) {
                    zzg = zzg.zzf(th2);
                }
                this.zzm.zzh(zzg);
            }
            zzbfj zzbfjVar = this.zzj;
            if (zzbfjVar != null) {
                zzbfjVar.zzd();
            }
        } catch (Throwable th3) {
            zzbfj zzbfjVar2 = this.zzj;
            if (zzbfjVar2 != null) {
                zzbfjVar2.zzd();
            }
            throw th3;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzayo
    public final void zzb() {
        int i11 = zzbvr.zza;
        zzmt.zzp(this.zzm != null, "Not started");
        zzmt.zzp(!this.zzn, "call was cancelled");
        zzmt.zzp(!this.zzo, "call already half-closed");
        this.zzo = true;
        this.zzm.zzj();
    }

    @Override // com.google.android.libraries.places.internal.zzayo
    public final void zzc(int i11) {
        int i12 = zzbvr.zza;
        zzmt.zzp(this.zzm != null, "Not started");
        this.zzm.zzu(2);
    }

    @Override // com.google.android.libraries.places.internal.zzayo
    public final void zzd(Object obj) {
        int i11 = zzbvr.zza;
        zzs(obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01ab  */
    @Override // com.google.android.libraries.places.internal.zzayo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zze(com.google.android.libraries.places.internal.zzayn r14, com.google.android.libraries.places.internal.zzbcf r15) {
        /*
            Method dump skipped, instructions count: 465
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzbfq.zze(com.google.android.libraries.places.internal.zzayn, com.google.android.libraries.places.internal.zzbcf):void");
    }

    public final zzbfq zzm(zzazd zzazdVar) {
        this.zzs = zzazdVar;
        return this;
    }

    public final zzbfq zzn(zzazq zzazqVar) {
        this.zzr = zzazqVar;
        return this;
    }
}
