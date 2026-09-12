package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.api.model.Place;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzho {
    private final zzhh zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzho(zzhh zzhhVar) {
        this.zza = zzhhVar;
    }

    static final List zzb(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzamj zzamjVar = (zzamj) it.next();
            int zzc = zzamjVar.zzc();
            int zza = zzamjVar.zza() - zzamjVar.zzc();
            com.google.android.libraries.places.api.model.zzbx zzc2 = com.google.android.libraries.places.api.model.zzby.zzc();
            zzc2.zzb(zzc);
            zzc2.zza(zza);
            arrayList.add(zzc2.zzc());
        }
        return arrayList;
    }

    public final AutocompletePrediction zza(zzamm zzammVar) {
        zzamf zza = zzammVar.zza();
        if (!zzammVar.zzd()) {
            throw new IllegalArgumentException("Suggestion does not contain a PlacePrediction.");
        }
        List<Place.Type> zza2 = this.zza.zza(zza.zzh());
        if (zza2 == null) {
            zza2 = zznx.zzl();
        }
        AutocompletePrediction.Builder builder = AutocompletePrediction.builder(zza.zzg());
        builder.setDistanceMeters(Integer.valueOf(zza.zza()));
        builder.setPlaceTypes(zza2);
        builder.setTypes(zznx.zzj(zza.zzh()));
        builder.setFullText(zza.zzc().zzd());
        builder.zza(zzb(zza.zzc().zze()));
        builder.setPrimaryText(zza.zzf().zza().zzd());
        builder.zzc(zzb(zza.zzf().zza().zze()));
        builder.setSecondaryText(zza.zzf().zzc().zzd());
        builder.zzd(zzb(zza.zzf().zzc().zze()));
        return builder.build();
    }
}
