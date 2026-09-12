package com.google.android.libraries.places.api.net;

import androidx.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzx extends IsOpenResponse {

    @Nullable
    private final Boolean zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzx(@Nullable Boolean bool) {
        this.zza = bool;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IsOpenResponse)) {
            return false;
        }
        IsOpenResponse isOpenResponse = (IsOpenResponse) obj;
        Boolean bool = this.zza;
        return bool == null ? isOpenResponse.isOpen() == null : bool.equals(isOpenResponse.isOpen());
    }

    public final int hashCode() {
        Boolean bool = this.zza;
        return (bool == null ? 0 : bool.hashCode()) ^ 1000003;
    }

    @Override // com.google.android.libraries.places.api.net.IsOpenResponse
    @Nullable
    public final Boolean isOpen() {
        return this.zza;
    }

    public final String toString() {
        return "IsOpenResponse{isOpen=" + this.zza + "}";
    }
}
