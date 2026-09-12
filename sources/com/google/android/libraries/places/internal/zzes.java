package com.google.android.libraries.places.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.model.AutocompleteSessionToken;
import com.google.android.libraries.places.api.model.TypeFilter;
import com.google.android.libraries.places.api.net.FetchPhotoRequest;
import com.google.android.libraries.places.api.net.FetchPlaceRequest;
import com.google.android.libraries.places.api.net.FetchResolvedPhotoUriRequest;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsResponse;
import com.google.android.libraries.places.api.net.FindCurrentPlaceRequest;
import com.google.android.libraries.places.api.net.FindCurrentPlaceResponse;
import com.google.android.libraries.places.api.net.SearchByTextRequest;
import com.google.android.libraries.places.api.net.SearchByTextResponse;
import com.google.android.libraries.places.api.net.SearchNearbyRequest;
import com.google.android.libraries.places.api.net.SearchNearbyResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes4.dex */
public final class zzes implements zzjr {
    private final zzkg zza;
    private final zzkb zzb;
    private final zzjs zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzes(zzkg zzkgVar, zzkb zzkbVar, zzjs zzjsVar) {
        this.zza = zzkgVar;
        this.zzb = zzkbVar;
        this.zzc = zzjsVar;
    }

    static final int zzp(Task task) {
        if (task.isSuccessful()) {
            return 2;
        }
        Exception exception = task.getException();
        exception.getClass();
        int statusCode = (exception instanceof ApiException ? (ApiException) exception : new ApiException(new Status(13, exception.getMessage()))).getStatusCode();
        if (statusCode != 7) {
            return statusCode != 15 ? 1 : 3;
        }
        return 4;
    }

    private final zzahs zzq() {
        Locale zzb = this.zzc.zzb();
        Locale locale = Locale.getDefault();
        zzahs zza = zzahu.zza();
        zza.zze(zzb.toString());
        if (!zzb.equals(locale)) {
            zza.zzb(locale.toString());
        }
        return zza;
    }

    private final void zzr(zzagi zzagiVar) {
        this.zza.zza(zzkh.zza(zzagiVar));
    }

    private final void zzs(zzaez zzaezVar, int i11, int i12) {
        zzagb zzb = zzkh.zzb(this.zzb, i11, i12);
        zzb.zzn(16);
        zzb.zze(zzaezVar);
        zzb.zza(this.zzc.zza());
        zzr((zzagi) zzb.zzt());
    }

    @Override // com.google.android.libraries.places.internal.zzjr
    public final void zza(FetchPhotoRequest fetchPhotoRequest, int i11) {
        zzahk zza = zzahm.zza();
        zza.zza(2);
        zzahm zzahmVar = (zzahm) zza.zzt();
        zzagb zzb = zzkh.zzb(this.zzb, 2, 1);
        zzb.zzn(5);
        zzb.zzg(zzahmVar);
        zzb.zza(this.zzc.zza());
        zzr((zzagi) zzb.zzt());
    }

    @Override // com.google.android.libraries.places.internal.zzjr
    public final void zzb(Task task, long j11, long j12, int i11) {
        zzaeu zza = zzaez.zza();
        zza.zzg(15);
        zza.zzf(zzp(task));
        zza.zzd((int) (j12 - j11));
        zzs((zzaez) zza.zzt(), 2, 1);
    }

    @Override // com.google.android.libraries.places.internal.zzjr
    public final void zzc(FetchResolvedPhotoUriRequest fetchResolvedPhotoUriRequest, int i11) {
        zzahk zza = zzahm.zza();
        zza.zza(2);
        zzahm zzahmVar = (zzahm) zza.zzt();
        zzagb zzb = zzkh.zzb(this.zzb, 3, 1);
        zzb.zzn(5);
        zzb.zzg(zzahmVar);
        zzb.zza(this.zzc.zza());
        zzr((zzagi) zzb.zzt());
    }

    @Override // com.google.android.libraries.places.internal.zzjr
    public final void zzd(Task task, long j11, long j12, int i11) {
        zzaeu zza = zzaez.zza();
        zza.zzg(15);
        zza.zzf(zzp(task));
        zza.zzd((int) (j12 - j11));
        zzs((zzaez) zza.zzt(), 3, 1);
    }

    @Override // com.google.android.libraries.places.internal.zzjr
    public final void zze(FindCurrentPlaceRequest findCurrentPlaceRequest, Task task, long j11, long j12, int i11) {
        boolean isSuccessful = task.isSuccessful();
        zzagu zza = zzagw.zza();
        zzahn zza2 = zzaho.zza();
        zza2.zza(zzjd.zzb(findCurrentPlaceRequest.getPlaceFields()));
        zza.zzb((zzaho) zza2.zzt());
        zza.zza((int) (j12 - j11));
        zza.zzc(true != isSuccessful ? 1 : 2);
        zzagw zzagwVar = (zzagw) zza.zzt();
        zzagb zzb = zzkh.zzb(this.zzb, 2, 1);
        zzb.zzn(6);
        zzb.zzd(zzagwVar);
        zzb.zza(this.zzc.zza());
        zzr((zzagi) zzb.zzt());
    }

    @Override // com.google.android.libraries.places.internal.zzjr
    public final void zzf(Task task, long j11, long j12, int i11) {
        int size = task.isSuccessful() ? ((FindCurrentPlaceResponse) task.getResult()).getPlaceLikelihoods().size() : 0;
        zzaea zza = zzaeb.zza();
        zza.zza(size);
        zzaeb zzaebVar = (zzaeb) zza.zzt();
        zzaeu zza2 = zzaez.zza();
        zza2.zzg(4);
        zza2.zza(zzaebVar);
        zza2.zzf(zzp(task));
        zza2.zzd((int) (j12 - j11));
        zzs((zzaez) zza2.zzt(), 2, 1);
    }

    @Override // com.google.android.libraries.places.internal.zzjr
    public final void zzg(SearchByTextRequest searchByTextRequest, int i11) {
        zzaib zza = zzaid.zza();
        zza.zze(searchByTextRequest.isOpenNow());
        zzahn zza2 = zzaho.zza();
        zza2.zza(zzhg.zza(searchByTextRequest.getPlaceFields()));
        zza.zzf((zzaho) zza2.zzt());
        SearchByTextRequest.RankPreference rankPreference = searchByTextRequest.getRankPreference();
        zza.zzh(rankPreference == null ? 1 : true != rankPreference.equals(SearchByTextRequest.RankPreference.DISTANCE) ? 3 : 2);
        zza.zzg(searchByTextRequest.isStrictTypeFiltering());
        String includedType = searchByTextRequest.getIncludedType();
        if (includedType != null) {
            zza.zzb(includedType);
        }
        Double minRating = searchByTextRequest.getMinRating();
        if (minRating != null) {
            zza.zzd(minRating.doubleValue());
        }
        Integer maxResultCount = searchByTextRequest.getMaxResultCount();
        if (maxResultCount != null) {
            zza.zzc(maxResultCount.intValue());
        }
        ArrayList arrayList = new ArrayList();
        for (Integer num : searchByTextRequest.getPriceLevels()) {
            if (num != null) {
                arrayList.add(num);
            }
        }
        zza.zza(arrayList);
        zzahs zzq = zzq();
        zzq.zzh(2);
        zzq.zzf((zzaid) zza.zzt());
        zzahu zzahuVar = (zzahu) zzq.zzt();
        zzagb zzb = zzkh.zzb(this.zzb, 3, 1);
        zzb.zzn(1);
        zzb.zzh(zzahuVar);
        zzb.zza(this.zzc.zza());
        zzr((zzagi) zzb.zzt());
    }

    @Override // com.google.android.libraries.places.internal.zzjr
    public final void zzh(SearchByTextRequest searchByTextRequest, Task task, long j11, long j12, int i11) {
        int size = task.isSuccessful() ? ((SearchByTextResponse) task.getResult()).getPlaces().size() : 0;
        Integer maxResultCount = searchByTextRequest.getMaxResultCount();
        zzaiy zza = zzaiz.zza();
        zza.zza(maxResultCount != null ? maxResultCount.intValue() : 0);
        zza.zzb(size);
        zzaiz zzaizVar = (zzaiz) zza.zzt();
        zzaeu zza2 = zzaez.zza();
        zza2.zzg(10);
        zza2.zze(zzaizVar);
        zza2.zzf(zzp(task));
        zza2.zzd((int) (j12 - j11));
        zzs((zzaez) zza2.zzt(), 3, 1);
    }

    @Override // com.google.android.libraries.places.internal.zzjr
    public final void zzi(SearchNearbyRequest searchNearbyRequest, int i11) {
        zzaie zza = zzaig.zza();
        zzahn zza2 = zzaho.zza();
        zza2.zza(zzhg.zza(searchNearbyRequest.getPlaceFields()));
        zza.zzf((zzaho) zza2.zzt());
        SearchNearbyRequest.RankPreference rankPreference = searchNearbyRequest.getRankPreference();
        zza.zzg(rankPreference == null ? 1 : true != rankPreference.equals(SearchNearbyRequest.RankPreference.DISTANCE) ? 3 : 2);
        List<String> includedTypes = searchNearbyRequest.getIncludedTypes();
        if (includedTypes != null) {
            zza.zzd(includedTypes);
        }
        List<String> excludedTypes = searchNearbyRequest.getExcludedTypes();
        if (excludedTypes != null) {
            zza.zzb(excludedTypes);
        }
        List<String> includedPrimaryTypes = searchNearbyRequest.getIncludedPrimaryTypes();
        if (includedPrimaryTypes != null) {
            zza.zzc(includedPrimaryTypes);
        }
        List<String> excludedPrimaryTypes = searchNearbyRequest.getExcludedPrimaryTypes();
        if (excludedPrimaryTypes != null) {
            zza.zza(excludedPrimaryTypes);
        }
        Integer maxResultCount = searchNearbyRequest.getMaxResultCount();
        if (maxResultCount != null) {
            zza.zze(maxResultCount.intValue());
        }
        zzahs zzq = zzq();
        zzq.zzh(2);
        zzq.zzg((zzaig) zza.zzt());
        zzahu zzahuVar = (zzahu) zzq.zzt();
        zzagb zzb = zzkh.zzb(this.zzb, 3, 1);
        zzb.zzn(1);
        zzb.zzh(zzahuVar);
        zzb.zza(this.zzc.zza());
        zzr((zzagi) zzb.zzt());
    }

    @Override // com.google.android.libraries.places.internal.zzjr
    public final void zzj(SearchNearbyRequest searchNearbyRequest, Task task, long j11, long j12, int i11) {
        int size = task.isSuccessful() ? ((SearchNearbyResponse) task.getResult()).getPlaces().size() : 0;
        Integer maxResultCount = searchNearbyRequest.getMaxResultCount();
        zzaiy zza = zzaiz.zza();
        zza.zza(maxResultCount != null ? maxResultCount.intValue() : 0);
        zza.zzb(size);
        zzaiz zzaizVar = (zzaiz) zza.zzt();
        zzaeu zza2 = zzaez.zza();
        zza2.zzg(10);
        zza2.zze(zzaizVar);
        zza2.zzf(zzp(task));
        zza2.zzd((int) (j12 - j11));
        zzs((zzaez) zza2.zzt(), 3, 1);
    }

    @Override // com.google.android.libraries.places.internal.zzjr
    public final void zzk(FetchPlaceRequest fetchPlaceRequest, int i11, int i12) {
        zzago zza = zzagp.zza();
        zza.zza(1);
        zzahn zza2 = zzaho.zza();
        zza2.zza(zzjd.zzb(fetchPlaceRequest.getPlaceFields()));
        zza.zzb((zzaho) zza2.zzt());
        zzagp zzagpVar = (zzagp) zza.zzt();
        zzahs zzq = zzq();
        zzq.zzh(5);
        zzq.zzc(zzagpVar);
        zzahu zzahuVar = (zzahu) zzq.zzt();
        zzagb zzb = zzkh.zzb(this.zzb, i11, i12);
        zzb.zzn(1);
        zzb.zzh(zzahuVar);
        zzb.zza(this.zzc.zza());
        AutocompleteSessionToken sessionToken = fetchPlaceRequest.getSessionToken();
        if (sessionToken != null) {
            zzb.zzj(sessionToken.toString());
        }
        zzr((zzagi) zzb.zzt());
    }

    @Override // com.google.android.libraries.places.internal.zzjr
    public final void zzl(Task task, long j11, long j12, int i11, int i12) {
        boolean isSuccessful = task.isSuccessful();
        zzaem zza = zzaen.zza();
        zza.zza(1);
        zza.zzb(isSuccessful ? 1 : 0);
        zzaen zzaenVar = (zzaen) zza.zzt();
        zzaeu zza2 = zzaez.zza();
        zza2.zzg(8);
        zza2.zzc(zzaenVar);
        zza2.zzf(zzp(task));
        zza2.zzd((int) (j12 - j11));
        zzs((zzaez) zza2.zzt(), i11, i12);
    }

    @Override // com.google.android.libraries.places.internal.zzjr
    public final void zzm(FindAutocompletePredictionsRequest findAutocompletePredictionsRequest, int i11, int i12) {
        zzafd zza = zzafe.zza();
        List<String> typesFilter = findAutocompletePredictionsRequest.getTypesFilter();
        TypeFilter typeFilter = findAutocompletePredictionsRequest.getTypeFilter();
        Integer inputOffset = findAutocompletePredictionsRequest.getInputOffset();
        if (!typesFilter.isEmpty()) {
            Iterator<String> it = typesFilter.iterator();
            while (it.hasNext()) {
                zza.zza(it.next());
            }
        } else if (typeFilter != null) {
            zza.zza(zzje.zza(typeFilter));
        }
        if (inputOffset != null) {
            zza.zzb(inputOffset.intValue());
        }
        zzafe zzafeVar = (zzafe) zza.zzt();
        zzafp zza2 = zzafq.zza();
        if (zzafeVar != null) {
            zza2.zza(zzafeVar);
        }
        zzafq zzafqVar = (zzafq) zza2.zzt();
        zzahs zzq = zzq();
        zzq.zzh(6);
        zzq.zza(zzafqVar);
        zzahu zzahuVar = (zzahu) zzq.zzt();
        zzagb zzb = zzkh.zzb(this.zzb, i11, i12);
        zzb.zzn(1);
        zzb.zzh(zzahuVar);
        zzb.zza(this.zzc.zza());
        AutocompleteSessionToken sessionToken = findAutocompletePredictionsRequest.getSessionToken();
        if (sessionToken != null) {
            zzb.zzj(sessionToken.toString());
        }
        zzr((zzagi) zzb.zzt());
    }

    @Override // com.google.android.libraries.places.internal.zzjr
    public final void zzn(Task task, long j11, long j12, int i11, int i12) {
        int size = task.isSuccessful() ? ((FindAutocompletePredictionsResponse) task.getResult()).getAutocompletePredictions().size() : 0;
        zzaeh zza = zzaei.zza();
        zza.zza(size);
        zzaei zzaeiVar = (zzaei) zza.zzt();
        zzaeu zza2 = zzaez.zza();
        zza2.zzg(6);
        zza2.zzb(zzaeiVar);
        zza2.zzf(zzp(task));
        zza2.zzd((int) (j12 - j11));
        zzs((zzaez) zza2.zzt(), i11, i12);
    }

    @Override // com.google.android.libraries.places.internal.zzjr
    public final void zzo(FetchPlaceRequest fetchPlaceRequest, int i11, int i12) {
        zzago zza = zzagp.zza();
        zza.zza(1);
        zzahn zza2 = zzaho.zza();
        zza2.zza(zzjd.zzb(fetchPlaceRequest.getPlaceFields()));
        zza.zzb((zzaho) zza2.zzt());
        zzagp zzagpVar = (zzagp) zza.zzt();
        zzahs zzq = zzq();
        zzq.zzh(5);
        zzq.zzd(zzagpVar);
        zzahu zzahuVar = (zzahu) zzq.zzt();
        zzagb zzb = zzkh.zzb(this.zzb, i11, 1);
        zzb.zzn(1);
        zzb.zzh(zzahuVar);
        zzb.zza(this.zzc.zza());
        zzr((zzagi) zzb.zzt());
    }
}
