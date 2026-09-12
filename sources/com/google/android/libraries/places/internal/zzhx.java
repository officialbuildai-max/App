package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.api.net.FetchPlaceRequest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzhx extends zzik {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhx(FetchPlaceRequest fetchPlaceRequest, Locale locale, String str, boolean z10, zzki zzkiVar) {
        super(fetchPlaceRequest, locale, str, false, zzkiVar);
    }

    @Override // com.google.android.libraries.places.internal.zzik
    protected final String zze() {
        return "details/json";
    }

    @Override // com.google.android.libraries.places.internal.zzik
    public final Map zzf() {
        FetchPlaceRequest fetchPlaceRequest = (FetchPlaceRequest) zzb();
        HashMap hashMap = new HashMap();
        zzik.zzg(hashMap, "placeid", fetchPlaceRequest.getPlaceId(), null);
        zzik.zzg(hashMap, "sessiontoken", fetchPlaceRequest.getSessionToken(), null);
        zzik.zzg(hashMap, "fields", zzjd.zza(fetchPlaceRequest.getPlaceFields()), null);
        return hashMap;
    }
}
