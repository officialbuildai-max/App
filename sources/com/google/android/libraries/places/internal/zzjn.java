package com.google.android.libraries.places.internal;

import android.content.Context;
import com.android.volley.h;
import com.android.volley.toolbox.o;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.libraries.places.api.net.PlacesClient;

/* loaded from: classes4.dex */
final class zzjn implements zzjq {
    private final zzjs zza;
    private final Context zzb;
    private final zzkb zzc;
    private final zzjn zzd = this;
    private final zzaxy zze = zzaxz.zza(zzdx.zza());
    private final zzaxy zzf;
    private final zzaxy zzg;
    private final zzaxy zzh;
    private final zzaxy zzi;
    private final zzaxy zzj;
    private final zzaxy zzk;
    private final zzaxy zzl;
    private final zzaxy zzm;
    private final zzaxy zzn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzjn(Context context, zzjs zzjsVar, zzkb zzkbVar, zzjm zzjmVar) {
        this.zza = zzjsVar;
        this.zzb = context;
        this.zzc = zzkbVar;
        zzaxy zza = zzaxw.zza(zzgg.zza());
        this.zzf = zza;
        this.zzg = zzaxw.zza(new zzhn(zza));
        this.zzh = zzaxw.zza(new zzhl(zza));
        this.zzi = zzaxw.zza(zzgm.zza());
        this.zzj = zzaxw.zza(zzgj.zza());
        this.zzk = zzaxw.zza(new zzgd(zza));
        zzaxy zza2 = zzaxw.zza(zzhj.zza());
        this.zzl = zza2;
        this.zzm = zzaxw.zza(new zzhf(zza2));
        this.zzn = zzaxw.zza(new zzhp(zza2));
    }

    private final zzes zzb() {
        return zzet.zza(new zzkf(this.zzb), this.zzc, this.zza);
    }

    @Override // com.google.android.libraries.places.internal.zzjq
    public final PlacesClient zza() {
        zzki zzkiVar = new zzki(this.zzb);
        Context applicationContext = this.zzb.getApplicationContext();
        zzaxx.zza(applicationContext);
        h a11 = o.a(applicationContext);
        zzaxx.zza(a11);
        zzfa zza = zzfb.zza(a11, new zzij());
        Context applicationContext2 = this.zzb.getApplicationContext();
        zzaxx.zza(applicationContext2);
        h a12 = o.a(applicationContext2);
        zzaxx.zza(a12);
        zzfg zza2 = zzfh.zza(a12);
        zzaxy zzaxyVar = this.zze;
        zziu zza3 = zziv.zza(this.zza, zzkiVar, zza, zza2, zzb(), (zzdv) zzaxyVar.zzb(), zzhw.zza(), zzia.zza(zziy.zza()), zzie.zza(), zzii.zza(zziy.zza()));
        Context context = this.zzb;
        Context applicationContext3 = context.getApplicationContext();
        zzaxx.zza(applicationContext3);
        Context applicationContext4 = context.getApplicationContext();
        zzaxx.zza(applicationContext4);
        FusedLocationProviderClient fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(applicationContext4);
        zzaxx.zza(fusedLocationProviderClient);
        zzel zza4 = zzem.zza(applicationContext3, fusedLocationProviderClient, new zzjj(new zzjf()));
        Context applicationContext5 = this.zzb.getApplicationContext();
        zzaxx.zza(applicationContext5);
        zzeq zza5 = zzer.zza(applicationContext5, (zzdv) this.zze.zzb());
        zzaxy zzaxyVar2 = this.zze;
        zzes zzb = zzb();
        zzdv zzdvVar = (zzdv) zzaxyVar2.zzb();
        zzbrv zze = zzbrv.zze("places.googleapis.com", 443);
        zze.zzf();
        zzapv zza6 = zzapw.zza(zze.zza());
        zzaxy zzaxyVar3 = this.zze;
        zzes zzb2 = zzb();
        zzdv zzdvVar2 = (zzdv) zzaxyVar3.zzb();
        zzaxy zzaxyVar4 = this.zzn;
        zzaxy zzaxyVar5 = this.zzm;
        zzaxy zzaxyVar6 = this.zzk;
        zzaxy zzaxyVar7 = this.zzj;
        zzaxy zzaxyVar8 = this.zzi;
        zzaxy zzaxyVar9 = this.zzh;
        Object zzb3 = this.zzg.zzb();
        Object zzb4 = zzaxyVar9.zzb();
        Object zzb5 = zzaxyVar8.zzb();
        Object zzb6 = zzaxyVar7.zzb();
        Object zzb7 = zzaxyVar6.zzb();
        Object zzb8 = zzaxyVar5.zzb();
        Object zzb9 = zzaxyVar4.zzb();
        Context applicationContext6 = this.zzb.getApplicationContext();
        zzaxx.zza(applicationContext6);
        return zzgb.zza(this.zza, zza3, zza4, zza5, zzb, zzdvVar, zzhd.zza(this.zza, zza6, zzb2, zzdvVar2, zzb3, zzb4, zzb5, zzb6, zzb7, zzb8, zzb9, new zzjw(applicationContext6)));
    }
}
