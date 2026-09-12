package com.google.android.libraries.places.api.net;

import android.net.Uri;
import androidx.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzl extends FetchResolvedPhotoUriResponse {

    @Nullable
    private final Uri zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzl(@Nullable Uri uri) {
        this.zza = uri;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FetchResolvedPhotoUriResponse)) {
            return false;
        }
        FetchResolvedPhotoUriResponse fetchResolvedPhotoUriResponse = (FetchResolvedPhotoUriResponse) obj;
        Uri uri = this.zza;
        return uri == null ? fetchResolvedPhotoUriResponse.getUri() == null : uri.equals(fetchResolvedPhotoUriResponse.getUri());
    }

    @Override // com.google.android.libraries.places.api.net.FetchResolvedPhotoUriResponse
    @Nullable
    public final Uri getUri() {
        return this.zza;
    }

    public final int hashCode() {
        Uri uri = this.zza;
        return (uri == null ? 0 : uri.hashCode()) ^ 1000003;
    }

    public final String toString() {
        return "FetchResolvedPhotoUriResponse{uri=" + String.valueOf(this.zza) + "}";
    }
}
