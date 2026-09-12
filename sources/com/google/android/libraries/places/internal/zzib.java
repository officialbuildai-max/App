package com.google.android.libraries.places.internal;

import android.text.TextUtils;
import com.google.android.libraries.places.api.model.TypeFilter;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzib extends zzik {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzib(FindAutocompletePredictionsRequest findAutocompletePredictionsRequest, Locale locale, String str, boolean z10, zzki zzkiVar) {
        super(findAutocompletePredictionsRequest, locale, str, false, zzkiVar);
    }

    @Override // com.google.android.libraries.places.internal.zzik
    protected final String zze() {
        return "autocomplete/json";
    }

    @Override // com.google.android.libraries.places.internal.zzik
    public final Map zzf() {
        HashMap hashMap = new HashMap();
        FindAutocompletePredictionsRequest findAutocompletePredictionsRequest = (FindAutocompletePredictionsRequest) zzb();
        TypeFilter typeFilter = findAutocompletePredictionsRequest.getTypeFilter();
        List<String> typesFilter = findAutocompletePredictionsRequest.getTypesFilter();
        String query = findAutocompletePredictionsRequest.getQuery();
        zzik.zzg(hashMap, "input", query == null ? null : query.replaceFirst("^\\s+", "").replaceFirst("\\s+$", " "), null);
        if (typesFilter.isEmpty()) {
            zzik.zzg(hashMap, "types", typeFilter != null ? zzje.zza(typeFilter) : null, null);
        } else {
            zzik.zzg(hashMap, "types", TextUtils.join("|", typesFilter), null);
        }
        zzik.zzg(hashMap, "sessiontoken", findAutocompletePredictionsRequest.getSessionToken(), null);
        zzik.zzg(hashMap, "origin", zzjc.zzb(findAutocompletePredictionsRequest.getOrigin()), null);
        zzik.zzg(hashMap, "locationbias", zzjc.zzc(findAutocompletePredictionsRequest.getLocationBias()), null);
        zzik.zzg(hashMap, "locationrestriction", zzjc.zzd(findAutocompletePredictionsRequest.getLocationRestriction()), null);
        List<String> countries = findAutocompletePredictionsRequest.getCountries();
        StringBuilder sb2 = new StringBuilder();
        for (String str : countries) {
            String concat = TextUtils.isEmpty(str) ? null : "country:".concat(String.valueOf(str.toLowerCase(Locale.US)));
            if (concat != null) {
                if (sb2.length() != 0) {
                    sb2.append('|');
                }
                sb2.append(concat);
            }
        }
        zzik.zzg(hashMap, "components", sb2.length() == 0 ? null : sb2.toString(), null);
        return hashMap;
    }
}
