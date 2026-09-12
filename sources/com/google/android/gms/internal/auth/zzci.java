package com.google.android.gms.internal.auth;

import android.net.Uri;
import androidx.collection.x0;

/* loaded from: classes3.dex */
public final class zzci {
    private final x0 zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzci(x0 x0Var) {
        this.zza = x0Var;
    }

    public final String zza(Uri uri, String str, String str2, String str3) {
        if (uri == null) {
            return null;
        }
        x0 x0Var = (x0) this.zza.get(uri.toString());
        if (x0Var == null) {
            return null;
        }
        return (String) x0Var.get("".concat(String.valueOf(str3)));
    }
}
