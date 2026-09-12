package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

/* loaded from: classes4.dex */
final class zze extends com.google.android.gms.maps.internal.zzag {
    private final /* synthetic */ GoogleMap.OnInfoWindowLongClickListener zzm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zze(GoogleMap googleMap, GoogleMap.OnInfoWindowLongClickListener onInfoWindowLongClickListener) {
        this.zzm = onInfoWindowLongClickListener;
    }

    @Override // com.google.android.gms.maps.internal.zzaf
    public final void zzf(com.google.android.gms.internal.maps.zzt zztVar) {
        this.zzm.onInfoWindowLongClick(new Marker(zztVar));
    }
}
