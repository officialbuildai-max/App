package com.google.android.libraries.places.internal;

import androidx.core.app.NotificationCompat;
import java.util.logging.Level;

/* loaded from: classes4.dex */
public abstract class zzbee extends zzbei {
    private final zzbqo zza;
    private boolean zzb;
    private zzbft zzc;
    private zzazq zzd;
    private boolean zze;
    private Runnable zzf;
    private volatile boolean zzg;
    private boolean zzh;
    private boolean zzi;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzbee(int i11, zzbqo zzbqoVar, zzbqz zzbqzVar, zzayj zzayjVar) {
        super(i11, zzbqoVar, zzbqzVar);
        this.zzd = zzazq.zzb();
        this.zze = false;
        this.zza = zzbqoVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzA(zzbdo zzbdoVar, zzbfs zzbfsVar, zzbcf zzbcfVar) {
        if (this.zzb) {
            return;
        }
        this.zzb = true;
        this.zza.zzm(zzbdoVar);
        zzm().zze(zzbdoVar.zzl());
        this.zzc.zzd(zzbdoVar, zzbfsVar, zzbcfVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzc(zzbee zzbeeVar, zzazq zzazqVar) {
        zzmt.zzp(zzbeeVar.zzc == null, "Already called start");
        zzmt.zzc(zzazqVar, "decompressorRegistry");
        zzbeeVar.zzd = zzazqVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbei
    protected final /* synthetic */ zzbqr zza() {
        return this.zzc;
    }

    @Override // com.google.android.libraries.places.internal.zzbmm
    public void zze(boolean z10) {
        zzmt.zzp(this.zzh, "status should have been reported on deframer closed");
        this.zze = true;
        if (this.zzi && z10) {
            zzj(zzbdo.zzo.zzg("Encountered end-of-stream mid-frame"), zzbfs.PROCESSED, true, new zzbcf());
        }
        Runnable runnable = this.zzf;
        if (runnable != null) {
            runnable.run();
            this.zzf = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzf(zzbnv zzbnvVar) {
        boolean z10 = true;
        try {
            if (this.zzh) {
                zzbef.zzf().logp(Level.INFO, "io.grpc.internal.AbstractClientStream$TransportState", "inboundDataReceived", "Received data on closed stream");
                zzbnvVar.close();
                return;
            }
            try {
                zzq(zzbnvVar);
            } catch (Throwable th2) {
                th = th2;
                z10 = false;
                if (z10) {
                    zzbnvVar.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzg(zzbcf zzbcfVar) {
        zzmt.zzp(!this.zzh, "Received headers on closed stream");
        this.zza.zzb();
        String str = (String) zzbcfVar.zzb(zzbjd.zzc);
        if (str != null) {
            zzazo zza = this.zzd.zza(str);
            if (zza == null) {
                zzF(new zzbdq(zzbdo.zzo.zzg(String.format("Can't find decompressor for %s", str)), null));
                return;
            } else if (zza != zzaza.zza) {
                zzw(zza);
            }
        }
        this.zzc.zze(zzbcfVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzh(zzbcf zzbcfVar, zzbdo zzbdoVar) {
        if (this.zzh) {
            zzbef.zzf().logp(Level.INFO, "io.grpc.internal.AbstractClientStream$TransportState", "inboundTrailersReceived", "Received trailers on closed stream:\n {1}\n {2}", new Object[]{zzbdoVar, zzbcfVar});
        } else {
            this.zza.zzc(zzbcfVar);
            zzj(zzbdoVar, zzbfs.PROCESSED, false, zzbcfVar);
        }
    }

    public final void zzi(zzbft zzbftVar) {
        zzmt.zzp(this.zzc == null, "Already called setListener");
        this.zzc = zzbftVar;
    }

    public final void zzj(zzbdo zzbdoVar, zzbfs zzbfsVar, boolean z10, zzbcf zzbcfVar) {
        zzmt.zzc(zzbdoVar, NotificationCompat.CATEGORY_STATUS);
        zzmt.zzc(zzbcfVar, "trailers");
        if (this.zzh) {
            if (!z10) {
                return;
            } else {
                z10 = true;
            }
        }
        this.zzh = true;
        this.zzi = zzbdoVar.zzl();
        zzu();
        if (this.zze) {
            this.zzf = null;
            zzA(zzbdoVar, zzbfsVar, zzbcfVar);
        } else {
            this.zzf = new zzbed(this, zzbdoVar, zzbfsVar, zzbcfVar);
            zzp(z10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean zzk() {
        return this.zzg;
    }
}
