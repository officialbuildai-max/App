package com.google.android.libraries.places.internal;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes4.dex */
abstract class zzik extends zzfi {

    @Nullable
    private final Locale zza;
    private final String zzb;
    private final zzki zzc;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzik(zzjt zzjtVar, @Nullable Locale locale, String str, boolean z10, zzki zzkiVar) {
        super(zzjtVar);
        this.zza = locale;
        this.zzb = str;
        this.zzc = zzkiVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void zzg(Map map, String str, @Nullable Object obj, @Nullable Object obj2) {
        String obj3 = obj != null ? obj.toString() : null;
        if (TextUtils.isEmpty(obj3)) {
            return;
        }
        map.put(str, obj3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.libraries.places.internal.zzfi
    public final String zzc() {
        zziw zziwVar = new zziw(zze(), this.zzb);
        zziwVar.zza(this.zza);
        zziwVar.zzb(zzf());
        return zziwVar.zzc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.libraries.places.internal.zzfi
    public final Map zzd() {
        HashMap hashMap = new HashMap();
        hashMap.putAll(this.zzc.zza());
        hashMap.put("X-Places-Android-Sdk", "3.5.0");
        return hashMap;
    }

    protected abstract String zze();

    protected abstract Map zzf();
}
