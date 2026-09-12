package com.google.android.libraries.places.internal;

import java.io.IOException;

/* loaded from: classes4.dex */
public final class zzatp extends zzarv {
    private final zzatu zza;

    public zzatp(zzatu zzatuVar) {
        this.zza = zzatuVar;
    }

    @Override // com.google.android.libraries.places.internal.zzavn
    public final /* synthetic */ Object zzb(zzasq zzasqVar, zzatf zzatfVar) throws zzauf {
        int i11 = zzatu.zzd;
        zzatu zzat = this.zza.zzat();
        try {
            zzavt zzb = zzavp.zza().zzb(zzat.getClass());
            zzb.zzf(zzat, zzasr.zzq(zzasqVar), zzatfVar);
            zzb.zzd(zzat);
            return zzat;
        } catch (zzauf e11) {
            e = e11;
            if (e.zzl()) {
                e = new zzauf(e);
            }
            e.zzh(zzat);
            throw e;
        } catch (zzawm e12) {
            zzauf zza = e12.zza();
            zza.zzh(zzat);
            throw zza;
        } catch (IOException e13) {
            if (e13.getCause() instanceof zzauf) {
                throw ((zzauf) e13.getCause());
            }
            zzauf zzaufVar = new zzauf(e13);
            zzaufVar.zzh(zzat);
            throw zzaufVar;
        } catch (RuntimeException e14) {
            if (e14.getCause() instanceof zzauf) {
                throw ((zzauf) e14.getCause());
            }
            throw e14;
        }
    }
}
