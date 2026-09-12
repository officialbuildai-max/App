package com.google.android.libraries.places.internal;

import android.location.Location;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.google.android.libraries.places.api.net.FindCurrentPlaceRequest;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzif extends zzik {
    private final Location zza;
    private final zznx zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzif(FindCurrentPlaceRequest findCurrentPlaceRequest, Location location, zznx zznxVar, Locale locale, String str, boolean z10, zzki zzkiVar) {
        super(findCurrentPlaceRequest, locale, str, false, zzkiVar);
        this.zza = location;
        this.zzb = zznxVar;
    }

    @Override // com.google.android.libraries.places.internal.zzik
    protected final String zze() {
        return "findplacefromuserlocation/json";
    }

    @Override // com.google.android.libraries.places.internal.zzik
    public final Map zzf() {
        Integer valueOf;
        FindCurrentPlaceRequest findCurrentPlaceRequest = (FindCurrentPlaceRequest) zzb();
        HashMap hashMap = new HashMap();
        zzik.zzg(hashMap, RequestParameters.SUBRESOURCE_LOCATION, zzjc.zza(this.zza), null);
        zzik.zzg(hashMap, "wifiaccesspoints", zzjc.zze(this.zzb, 4000), null);
        Location location = this.zza;
        if (location != null) {
            float accuracy = location.getAccuracy();
            if (location.hasAccuracy() && accuracy > 0.0f) {
                valueOf = Integer.valueOf(Math.round(accuracy * 100.0f));
                zzik.zzg(hashMap, "precision", valueOf, null);
                zzik.zzg(hashMap, CampaignEx.JSON_KEY_TIMESTAMP, Long.valueOf(this.zza.getTime()), null);
                zzik.zzg(hashMap, "fields", zzjd.zza(findCurrentPlaceRequest.getPlaceFields()), null);
                return hashMap;
            }
        }
        valueOf = null;
        zzik.zzg(hashMap, "precision", valueOf, null);
        zzik.zzg(hashMap, CampaignEx.JSON_KEY_TIMESTAMP, Long.valueOf(this.zza.getTime()), null);
        zzik.zzg(hashMap, "fields", zzjd.zza(findCurrentPlaceRequest.getPlaceFields()), null);
        return hashMap;
    }
}
