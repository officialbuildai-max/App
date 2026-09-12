package com.google.android.libraries.places.internal;

import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.api.model.Place;

/* loaded from: classes4.dex */
final class zzkp extends zzkv {

    @Nullable
    private final String zza;

    @Nullable
    private final zznx zzb;

    @Nullable
    private final Place zzc;

    @Nullable
    private final AutocompletePrediction zzd;

    @Nullable
    private final Status zze;
    private final int zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzkp(int i11, String str, zznx zznxVar, Place place, AutocompletePrediction autocompletePrediction, Status status, zzko zzkoVar) {
        this.zzf = i11;
        this.zza = str;
        this.zzb = zznxVar;
        this.zzc = place;
        this.zzd = autocompletePrediction;
        this.zze = status;
    }

    public final boolean equals(Object obj) {
        String str;
        zznx zznxVar;
        Place place;
        AutocompletePrediction autocompletePrediction;
        Status status;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzkv) {
            zzkv zzkvVar = (zzkv) obj;
            if (this.zzf == zzkvVar.zzf() && ((str = this.zza) != null ? str.equals(zzkvVar.zze()) : zzkvVar.zze() == null) && ((zznxVar = this.zzb) != null ? zznxVar.equals(zzkvVar.zzd()) : zzkvVar.zzd() == null) && ((place = this.zzc) != null ? place.equals(zzkvVar.zzc()) : zzkvVar.zzc() == null) && ((autocompletePrediction = this.zzd) != null ? autocompletePrediction.equals(zzkvVar.zzb()) : zzkvVar.zzb() == null) && ((status = this.zze) != null ? status.equals(zzkvVar.zza()) : zzkvVar.zza() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.zza;
        int hashCode = str == null ? 0 : str.hashCode();
        int i11 = this.zzf;
        zznx zznxVar = this.zzb;
        int hashCode2 = zznxVar == null ? 0 : zznxVar.hashCode();
        int i12 = hashCode ^ ((i11 ^ 1000003) * 1000003);
        Place place = this.zzc;
        int hashCode3 = ((((i12 * 1000003) ^ hashCode2) * 1000003) ^ (place == null ? 0 : place.hashCode())) * 1000003;
        AutocompletePrediction autocompletePrediction = this.zzd;
        int hashCode4 = (hashCode3 ^ (autocompletePrediction == null ? 0 : autocompletePrediction.hashCode())) * 1000003;
        Status status = this.zze;
        return hashCode4 ^ (status != null ? status.hashCode() : 0);
    }

    public final String toString() {
        String str;
        switch (this.zzf) {
            case 1:
                str = "START";
                break;
            case 2:
                str = "RESET";
                break;
            case 3:
                str = "LOADING";
                break;
            case 4:
                str = "TRY_AGAIN_PROGRESS_LOADING";
                break;
            case 5:
                str = "SUCCESS_PREDICTIONS";
                break;
            case 6:
                str = "FAILURE_NO_PREDICTIONS";
                break;
            case 7:
                str = "FAILURE_PREDICTIONS";
                break;
            case 8:
                str = "SUCCESS_SELECTION";
                break;
            case 9:
                str = "FAILURE_SELECTION";
                break;
            default:
                str = "FAILURE_UNRESOLVABLE";
                break;
        }
        String str2 = this.zza;
        zznx zznxVar = this.zzb;
        Place place = this.zzc;
        AutocompletePrediction autocompletePrediction = this.zzd;
        Status status = this.zze;
        return "AutocompleteState{type=" + str + ", query=" + str2 + ", predictions=" + String.valueOf(zznxVar) + ", place=" + String.valueOf(place) + ", prediction=" + String.valueOf(autocompletePrediction) + ", status=" + String.valueOf(status) + "}";
    }

    @Override // com.google.android.libraries.places.internal.zzkv
    @Nullable
    public final Status zza() {
        return this.zze;
    }

    @Override // com.google.android.libraries.places.internal.zzkv
    @Nullable
    public final AutocompletePrediction zzb() {
        return this.zzd;
    }

    @Override // com.google.android.libraries.places.internal.zzkv
    @Nullable
    public final Place zzc() {
        return this.zzc;
    }

    @Override // com.google.android.libraries.places.internal.zzkv
    @Nullable
    public final zznx zzd() {
        return this.zzb;
    }

    @Override // com.google.android.libraries.places.internal.zzkv
    @Nullable
    public final String zze() {
        return this.zza;
    }

    @Override // com.google.android.libraries.places.internal.zzkv
    public final int zzf() {
        return this.zzf;
    }
}
