package com.google.android.libraries.places.api;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.internal.zzjo;
import com.google.android.libraries.places.internal.zzjp;
import com.google.android.libraries.places.internal.zzjq;
import com.google.android.libraries.places.internal.zzjs;
import com.google.android.libraries.places.internal.zzkb;
import com.google.android.libraries.places.internal.zzkd;
import com.google.android.libraries.places.internal.zzmt;
import java.util.Locale;

/* loaded from: classes4.dex */
public final class Places {
    private static final zzjs zza = new zzjs();

    @Nullable
    private static volatile zzjq zzb;

    private Places() {
    }

    @RecentlyNonNull
    public static synchronized PlacesClient createClient(@RecentlyNonNull Context context) {
        PlacesClient zza2;
        synchronized (Places.class) {
            try {
                zzmt.zzc(context, "Context must not be null.");
                zza2 = zza(context, zzkb.zzd(context).zze());
            } catch (Error | RuntimeException e11) {
                zzkd.zzb(e11);
                throw e11;
            }
        }
        return zza2;
    }

    public static synchronized void deinitialize() {
        synchronized (Places.class) {
            zza.zzc();
        }
    }

    public static void initialize(@RecentlyNonNull Context context, @RecentlyNonNull String str) {
        try {
            zzb(context, str, null, false, false);
        } catch (Error | RuntimeException e11) {
            zzkd.zzb(e11);
            throw e11;
        }
    }

    public static void initialize(@RecentlyNonNull Context context, @RecentlyNonNull String str, @Nullable Locale locale) {
        try {
            zzb(context, str, locale, false, false);
        } catch (Error | RuntimeException e11) {
            zzkd.zzb(e11);
            throw e11;
        }
    }

    public static void initializeWithNewPlacesApiEnabled(@RecentlyNonNull Context context, @RecentlyNonNull String str) {
        try {
            zzb(context, str, null, false, true);
        } catch (Error | RuntimeException e11) {
            zzkd.zzb(e11);
            throw e11;
        }
    }

    public static void initializeWithNewPlacesApiEnabled(@RecentlyNonNull Context context, @RecentlyNonNull String str, @Nullable Locale locale) {
        try {
            zzb(context, str, locale, false, true);
        } catch (Error | RuntimeException e11) {
            zzkd.zzb(e11);
            throw e11;
        }
    }

    public static synchronized boolean isInitialized() {
        boolean zzg;
        synchronized (Places.class) {
            try {
                zzg = zza.zzg();
            } catch (Error | RuntimeException e11) {
                zzkd.zzb(e11);
                throw e11;
            }
        }
        return zzg;
    }

    public static synchronized PlacesClient zza(Context context, zzkb zzkbVar) {
        PlacesClient zza2;
        synchronized (Places.class) {
            try {
                zzmt.zzc(context, "Context must not be null.");
                zzmt.zzp(isInitialized(), "Places must be initialized first.");
                zzjp zza3 = zzjo.zza();
                zza3.zzc(context);
                zza3.zza(zza);
                zza3.zzb(zzkbVar);
                zza2 = zza3.zzd().zza();
            } catch (Error | RuntimeException e11) {
                zzkd.zzb(e11);
                throw e11;
            }
        }
        return zza2;
    }

    public static synchronized void zzb(@RecentlyNonNull Context context, @RecentlyNonNull String str, @Nullable Locale locale, boolean z10, boolean z11) {
        synchronized (Places.class) {
            try {
                zzmt.zzc(context, "Application context must not be null.");
                zzmt.zzc(str, "API Key must not be null.");
                zzmt.zzf(!str.isEmpty(), "API Key must not be empty.");
                zzkd.zza(context.getApplicationContext(), false);
                if (z11) {
                    zza.zze(str, locale, false);
                } else {
                    zza.zzd(str, locale, false);
                }
            } catch (Error | RuntimeException e11) {
                zzkd.zzb(e11);
                throw e11;
            }
        }
    }

    public static synchronized zzjs zzc() {
        zzjs zzjsVar;
        synchronized (Places.class) {
            zzjsVar = zza;
        }
        return zzjsVar;
    }
}
