package com.google.android.libraries.places.internal;

import androidx.annotation.Nullable;

/* loaded from: classes4.dex */
final class zzhq {

    @Nullable
    private String description;

    @Nullable
    private Integer distanceMeters;

    @Nullable
    private zzb[] matchedSubstrings;

    @Nullable
    private String placeId;

    @Nullable
    private zza structuredFormatting;

    @Nullable
    private String[] types;

    /* loaded from: classes4.dex */
    class zza {

        @Nullable
        private String mainText;

        @Nullable
        private zzb[] mainTextMatchedSubstrings;

        @Nullable
        private String secondaryText;

        @Nullable
        private zzb[] secondaryTextMatchedSubstrings;

        zza() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final zznx zza() {
            zzb[] zzbVarArr = this.mainTextMatchedSubstrings;
            return zzbVarArr != null ? zznx.zzk(zzbVarArr) : zznx.zzl();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final zznx zzb() {
            zzb[] zzbVarArr = this.secondaryTextMatchedSubstrings;
            return zzbVarArr != null ? zznx.zzk(zzbVarArr) : zznx.zzl();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Nullable
        public final String zzc() {
            return this.mainText;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Nullable
        public final String zzd() {
            return this.secondaryText;
        }
    }

    /* loaded from: classes4.dex */
    class zzb {

        @Nullable
        Integer length;

        @Nullable
        Integer offset;

        zzb() {
        }
    }

    zzhq() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final zza zza() {
        return this.structuredFormatting;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zznx zzb() {
        zzb[] zzbVarArr = this.matchedSubstrings;
        return zzbVarArr != null ? zznx.zzk(zzbVarArr) : zznx.zzl();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zznx zzc() {
        String[] strArr = this.types;
        return strArr != null ? zznx.zzk(strArr) : zznx.zzl();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final Integer zzd() {
        return this.distanceMeters;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final String zze() {
        return this.description;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final String zzf() {
        return this.placeId;
    }
}
