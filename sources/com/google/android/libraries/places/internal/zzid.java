package com.google.android.libraries.places.internal;

import android.text.TextUtils;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsResponse;
import com.google.android.libraries.places.api.net.PlacesStatusCodes;
import com.google.android.libraries.places.internal.zzhq;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzid {
    public static final FindAutocompletePredictionsResponse zza(zzic zzicVar) throws ApiException {
        int zza = zzjb.zza(zzicVar.status);
        if (PlacesStatusCodes.isError(zza)) {
            throw new ApiException(new Status(zza, zzjb.zzb(zzicVar.status, zzicVar.errorMessage)));
        }
        ArrayList arrayList = new ArrayList();
        zzhq[] zzhqVarArr = zzicVar.predictions;
        if (zzhqVarArr != null) {
            for (zzhq zzhqVar : zzhqVarArr) {
                if (zzhqVar == null || TextUtils.isEmpty(zzhqVar.zzf())) {
                    throw new ApiException(new Status(8, "Unexpected server error: Place ID not provided for an autocomplete prediction result"));
                }
                AutocompletePrediction.Builder builder = AutocompletePrediction.builder(zzhqVar.zzf());
                builder.setDistanceMeters(zzhqVar.zzd());
                builder.setPlaceTypes(zzix.zzd(zzix.zze(zzhqVar.zzc())));
                builder.setTypes(zzix.zzd(zzix.zzf(zzhqVar.zzc())));
                builder.setFullText(zznb.zzc(zzhqVar.zze()));
                builder.zza(zzb(zzhqVar.zzb()));
                zzhq.zza zza2 = zzhqVar.zza();
                if (zza2 != null) {
                    builder.setPrimaryText(zznb.zzc(zza2.zzc()));
                    builder.zzc(zzb(zza2.zza()));
                    builder.setSecondaryText(zznb.zzc(zza2.zzd()));
                    builder.zzd(zzb(zza2.zzb()));
                }
                arrayList.add(builder.build());
            }
        }
        return FindAutocompletePredictionsResponse.newInstance(arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static List zzb(List list) throws ApiException {
        ArrayList arrayList = new ArrayList();
        zzoy listIterator = ((zznx) list).listIterator(0);
        while (listIterator.hasNext()) {
            zzhq.zzb zzbVar = (zzhq.zzb) listIterator.next();
            Status status = new Status(8, "Unexpected server error: Place ID not provided for an autocomplete prediction result");
            if (zzbVar == null) {
                throw new ApiException(status);
            }
            Integer num = zzbVar.offset;
            Integer num2 = zzbVar.length;
            if (num == null || num2 == null) {
                throw new ApiException(status);
            }
            com.google.android.libraries.places.api.model.zzbx zzc = com.google.android.libraries.places.api.model.zzby.zzc();
            zzc.zzb(num.intValue());
            zzc.zza(num2.intValue());
            arrayList.add(zzc.zzc());
        }
        return arrayList;
    }
}
