package com.google.android.libraries.places.internal;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.ParseError;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.g;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.net.PlacesStatusCodes;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzeu {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static ApiException zza(VolleyError volleyError) {
        int i11 = volleyError instanceof NetworkError ? 7 : volleyError instanceof TimeoutError ? 15 : ((volleyError instanceof ServerError) || (volleyError instanceof ParseError)) ? 8 : volleyError instanceof AuthFailureError ? PlacesStatusCodes.REQUEST_DENIED : 13;
        g gVar = volleyError.networkResponse;
        return new ApiException(new Status(i11, String.format("Unexpected server error (HTTP Code: %s. Message: %s.)", gVar == null ? "N/A" : String.valueOf(gVar.f19316a), volleyError)));
    }
}
