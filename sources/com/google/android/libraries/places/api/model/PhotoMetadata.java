package com.google.android.libraries.places.api.model;

import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.libraries.places.internal.zzmt;

/* loaded from: classes4.dex */
public abstract class PhotoMetadata implements Parcelable {

    /* loaded from: classes4.dex */
    public static abstract class Builder {
        @RecentlyNonNull
        public PhotoMetadata build() {
            PhotoMetadata zzc = zzc();
            int width = zzc.getWidth();
            zzmt.zzq(width >= 0, "Width must not be < 0, but was: %s.", width);
            int height = zzc.getHeight();
            zzmt.zzq(height >= 0, "Height must not be < 0, but was: %s.", height);
            zzmt.zzp(!zzc.zzb().isEmpty(), "PhotoReference must not be null or empty.");
            return zzc;
        }

        @RecentlyNonNull
        public abstract String getAttributions();

        @RecentlyNullable
        public abstract AuthorAttributions getAuthorAttributions();

        public abstract int getHeight();

        public abstract int getWidth();

        @RecentlyNonNull
        public abstract Builder setAttributions(@RecentlyNonNull String str);

        @RecentlyNonNull
        public abstract Builder setAuthorAttributions(@Nullable AuthorAttributions authorAttributions);

        @RecentlyNonNull
        public abstract Builder setHeight(int i11);

        @RecentlyNonNull
        public abstract Builder setWidth(int i11);

        @RecentlyNonNull
        public abstract Builder zza(@Nullable String str);

        abstract PhotoMetadata zzc();
    }

    @RecentlyNonNull
    public static Builder builder(@RecentlyNonNull String str) {
        zzu zzuVar = new zzu();
        zzuVar.zzb(str);
        zzuVar.setWidth(0);
        zzuVar.setHeight(0);
        zzuVar.setAttributions("");
        return zzuVar;
    }

    @RecentlyNonNull
    public abstract String getAttributions();

    @RecentlyNullable
    public abstract AuthorAttributions getAuthorAttributions();

    public abstract int getHeight();

    public abstract int getWidth();

    @RecentlyNullable
    public abstract String zza();

    @RecentlyNonNull
    public abstract String zzb();
}
