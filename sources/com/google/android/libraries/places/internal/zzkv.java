package com.google.android.libraries.places.internal;

import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.api.model.Place;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class zzkv {
    public static zzkv zzg() {
        return zzr(3).zzf();
    }

    public static zzkv zzh(String str) {
        str.getClass();
        zzku zzr = zzr(6);
        zzr.zzd(str);
        return zzr.zzf();
    }

    public static zzkv zzi(String str, Status status) {
        str.getClass();
        status.getClass();
        zzku zzr = zzr(7);
        zzr.zzd(str);
        zzr.zze(status);
        return zzr.zzf();
    }

    public static zzkv zzj(List list) {
        list.getClass();
        zzku zzr = zzr(5);
        zzr.zzc(list);
        return zzr.zzf();
    }

    public static zzkv zzk() {
        return zzr(2).zzf();
    }

    public static zzkv zzl() {
        zzku zzr = zzr(10);
        zzr.zze(new Status(16));
        return zzr.zzf();
    }

    public static zzkv zzm(AutocompletePrediction autocompletePrediction, Status status) {
        status.getClass();
        zzku zzr = zzr(9);
        zzr.zzb(autocompletePrediction);
        zzr.zze(status);
        return zzr.zzf();
    }

    public static zzkv zzn(Place place) {
        place.getClass();
        zzku zzr = zzr(8);
        zzr.zza(place);
        return zzr.zzf();
    }

    public static zzkv zzo() {
        return zzr(1).zzf();
    }

    public static zzkv zzp() {
        return zzr(4).zzf();
    }

    public static zzkv zzq(Status status) {
        status.getClass();
        zzku zzr = zzr(10);
        zzr.zze(status);
        return zzr.zzf();
    }

    private static zzku zzr(int i11) {
        zzkn zzknVar = new zzkn();
        zzknVar.zzg(i11);
        return zzknVar;
    }

    @Nullable
    public abstract Status zza();

    @Nullable
    public abstract AutocompletePrediction zzb();

    @Nullable
    public abstract Place zzc();

    @Nullable
    public abstract zznx zzd();

    @Nullable
    public abstract String zze();

    public abstract int zzf();
}
