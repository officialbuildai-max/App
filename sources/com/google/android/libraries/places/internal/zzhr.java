package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.api.model.PhotoMetadata;
import com.google.android.libraries.places.api.net.FetchPhotoRequest;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzhr extends zzik {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhr(FetchPhotoRequest fetchPhotoRequest, String str, boolean z10, zzki zzkiVar) {
        super(fetchPhotoRequest, null, str, false, zzkiVar);
    }

    @Override // com.google.android.libraries.places.internal.zzik
    protected final String zze() {
        return "photo";
    }

    @Override // com.google.android.libraries.places.internal.zzik
    public final Map zzf() {
        FetchPhotoRequest fetchPhotoRequest = (FetchPhotoRequest) zzb();
        PhotoMetadata photoMetadata = fetchPhotoRequest.getPhotoMetadata();
        HashMap hashMap = new HashMap();
        zzik.zzg(hashMap, "maxheight", fetchPhotoRequest.getMaxHeight(), null);
        zzik.zzg(hashMap, "maxwidth", fetchPhotoRequest.getMaxWidth(), null);
        hashMap.put("photoreference", photoMetadata.zzb());
        return hashMap;
    }
}
