package com.google.android.libraries.places.internal;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.places.api.model.CircularBounds;
import com.google.android.libraries.places.api.model.RectangularBounds;

/* loaded from: classes4.dex */
final class zzge {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final zzamq zza(CircularBounds circularBounds) {
        LatLng center = circularBounds.getCenter();
        zzamp zza = zzamq.zza();
        zzaxo zzf = zzaxp.zzf();
        zzf.zza(center.latitude);
        zzf.zzb(center.longitude);
        zza.zza(zzf);
        zza.zzb(circularBounds.getRadius());
        return (zzamq) zza.zzt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final zzaki zzb(RectangularBounds rectangularBounds) {
        LatLng southwest = rectangularBounds.getSouthwest();
        LatLng northeast = rectangularBounds.getNortheast();
        zzakh zza = zzaki.zza();
        zzaxo zzf = zzaxp.zzf();
        zzf.zza(southwest.latitude);
        zzf.zzb(southwest.longitude);
        zza.zzb((zzaxp) zzf.zzt());
        zzaxo zzf2 = zzaxp.zzf();
        zzf2.zza(northeast.latitude);
        zzf2.zzb(northeast.longitude);
        zza.zza((zzaxp) zzf2.zzt());
        return (zzaki) zza.zzt();
    }
}
