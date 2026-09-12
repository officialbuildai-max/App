package com.google.android.gms.iid;

import android.util.Base64;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.util.VisibleForTesting;
import java.security.KeyPair;

/* loaded from: classes3.dex */
final class zzo {
    private final KeyPair zzcb;
    private final long zzcc;

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public zzo(KeyPair keyPair, long j11) {
        this.zzcb = keyPair;
        this.zzcc = j11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String zzq() {
        return Base64.encodeToString(this.zzcb.getPublic().getEncoded(), 11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String zzr() {
        return Base64.encodeToString(this.zzcb.getPrivate().getEncoded(), 11);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzo)) {
            return false;
        }
        zzo zzoVar = (zzo) obj;
        return this.zzcc == zzoVar.zzcc && this.zzcb.getPublic().equals(zzoVar.zzcb.getPublic()) && this.zzcb.getPrivate().equals(zzoVar.zzcb.getPrivate());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long getCreationTime() {
        return this.zzcc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final KeyPair getKeyPair() {
        return this.zzcb;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzcb.getPublic(), this.zzcb.getPrivate(), Long.valueOf(this.zzcc));
    }
}
