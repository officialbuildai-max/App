package com.google.android.libraries.places.internal;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnTokenCanceledListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.libraries.places.api.model.AutocompleteSessionToken;
import com.google.android.libraries.places.api.model.CircularBounds;
import com.google.android.libraries.places.api.model.LocationBias;
import com.google.android.libraries.places.api.model.LocationRestriction;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.RectangularBounds;
import com.google.android.libraries.places.api.net.FetchPlaceRequest;
import com.google.android.libraries.places.api.net.FetchPlaceResponse;
import com.google.android.libraries.places.api.net.FetchResolvedPhotoUriRequest;
import com.google.android.libraries.places.api.net.FetchResolvedPhotoUriResponse;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsResponse;
import com.google.android.libraries.places.api.net.PlacesStatusCodes;
import com.google.android.libraries.places.api.net.SearchByTextRequest;
import com.google.android.libraries.places.api.net.SearchByTextResponse;
import com.google.android.libraries.places.api.net.SearchNearbyRequest;
import com.google.android.libraries.places.api.net.SearchNearbyResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes4.dex */
public final class zzhc {
    private final zzapv zza;
    private final zzjw zzb;
    private final zzjr zzc;
    private final zzdv zzd;
    private final zzhk zze;
    private final zzhm zzf;
    private final zzgk zzg;
    private final zzgh zzh;
    private final zzgc zzi;
    private final zzho zzj;
    private final zzhe zzk;
    private final zzjs zzl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhc(zzjs zzjsVar, zzapv zzapvVar, zzjr zzjrVar, zzdv zzdvVar, zzhm zzhmVar, zzhk zzhkVar, zzgk zzgkVar, zzgh zzghVar, zzgc zzgcVar, zzhe zzheVar, zzho zzhoVar, zzjw zzjwVar) {
        this.zzl = zzjsVar;
        this.zza = zzapvVar;
        this.zzb = zzjwVar;
        this.zzc = zzjrVar;
        this.zzd = zzdvVar;
        this.zzf = zzhmVar;
        this.zze = zzhkVar;
        this.zzg = zzgkVar;
        this.zzi = zzgcVar;
        this.zzh = zzghVar;
        this.zzk = zzheVar;
        this.zzj = zzhoVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Task zza(zzamn zzamnVar) throws Exception {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        ArrayList arrayList = new ArrayList();
        Iterator it = zzamnVar.zzd().iterator();
        while (it.hasNext()) {
            arrayList.add(this.zzj.zza((zzamm) it.next()));
        }
        taskCompletionSource.setResult(FindAutocompletePredictionsResponse.newInstance(arrayList));
        return taskCompletionSource.getTask();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Task zzb(zzaps zzapsVar) throws Exception {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.setResult(FetchPlaceResponse.newInstance(this.zzk.zza(zzapsVar)));
        return taskCompletionSource.getTask();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Task zzc(zzarr zzarrVar) throws Exception {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        List zzd = zzarrVar.zzd();
        ArrayList arrayList = new ArrayList();
        Iterator it = zzd.iterator();
        while (it.hasNext()) {
            arrayList.add(this.zzk.zza((zzaps) it.next()));
        }
        taskCompletionSource.setResult(SearchByTextResponse.newInstance(arrayList));
        return taskCompletionSource.getTask();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Task zzd(zzarc zzarcVar) throws Exception {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        List zzd = zzarcVar.zzd();
        ArrayList arrayList = new ArrayList();
        Iterator it = zzd.iterator();
        while (it.hasNext()) {
            arrayList.add(this.zzk.zza((zzaps) it.next()));
        }
        taskCompletionSource.setResult(SearchNearbyResponse.newInstance(arrayList));
        return taskCompletionSource.getTask();
    }

    public final Task zze(FindAutocompletePredictionsRequest findAutocompletePredictionsRequest, int i11) {
        final int i12 = 1;
        String regionCode = findAutocompletePredictionsRequest.getRegionCode();
        if (regionCode != null && regionCode.isEmpty()) {
            return Tasks.forException(new ApiException(new Status(PlacesStatusCodes.INVALID_REQUEST, "Region code must not be an empty string.")));
        }
        String query = findAutocompletePredictionsRequest.getQuery();
        if (query == null) {
            return Tasks.forException(new ApiException(new Status(PlacesStatusCodes.INVALID_REQUEST, "Query must not be null.")));
        }
        if (TextUtils.isEmpty(query.trim())) {
            return Tasks.forResult(FindAutocompletePredictionsResponse.newInstance(zznx.zzl()));
        }
        zzdv zzdvVar = this.zzd;
        zzapv zzapvVar = this.zza;
        zzjw zzjwVar = this.zzb;
        zzjs zzjsVar = this.zzl;
        final long zza = zzdvVar.zza();
        zzbur zze = zzapvVar.zze(zzbva.zza(zzjwVar.zza("", zzjsVar.zza())));
        zzalt zza2 = zzaly.zza();
        String query2 = findAutocompletePredictionsRequest.getQuery();
        query2.getClass();
        zza2.zzc(query2);
        Integer inputOffset = findAutocompletePredictionsRequest.getInputOffset();
        if (inputOffset != null) {
            zza2.zzd(inputOffset.intValue());
        }
        String regionCode2 = findAutocompletePredictionsRequest.getRegionCode();
        if (regionCode2 != null) {
            zza2.zzh(regionCode2);
        }
        LocationBias locationBias = findAutocompletePredictionsRequest.getLocationBias();
        if (locationBias != null) {
            boolean z10 = locationBias instanceof CircularBounds;
            zzmt.zze(z10 || (locationBias instanceof RectangularBounds));
            zzalu zza3 = zzalv.zza();
            if (z10) {
                zza3.zza(zzge.zza((CircularBounds) locationBias));
            }
            if (locationBias instanceof RectangularBounds) {
                zza3.zzb(zzge.zzb((RectangularBounds) locationBias));
            }
            zza2.zze((zzalv) zza3.zzt());
        }
        LocationRestriction locationRestriction = findAutocompletePredictionsRequest.getLocationRestriction();
        if (locationRestriction != null) {
            boolean z11 = locationRestriction instanceof CircularBounds;
            zzmt.zze(z11 || (locationRestriction instanceof RectangularBounds));
            zzalw zza4 = zzalx.zza();
            if (z11) {
                zza4.zza(zzge.zza((CircularBounds) locationRestriction));
            }
            if (locationRestriction instanceof RectangularBounds) {
                zza4.zzb(zzge.zzb((RectangularBounds) locationRestriction));
            }
            zza2.zzf((zzalx) zza4.zzt());
        }
        LatLng origin = findAutocompletePredictionsRequest.getOrigin();
        if (origin != null) {
            zzaxo zzf = zzaxp.zzf();
            zzf.zza(origin.latitude);
            zzf.zzb(origin.longitude);
            zza2.zzg((zzaxp) zzf.zzt());
        }
        Iterator<String> it = findAutocompletePredictionsRequest.getCountries().iterator();
        while (it.hasNext()) {
            zza2.zzb(it.next());
        }
        AutocompleteSessionToken sessionToken = findAutocompletePredictionsRequest.getSessionToken();
        if (sessionToken != null) {
            zza2.zzi(sessionToken.toString());
        }
        Iterator<String> it2 = findAutocompletePredictionsRequest.getTypesFilter().iterator();
        while (it2.hasNext()) {
            zza2.zza(it2.next());
        }
        final zzaka zza5 = zzbux.zza(zze.zzd().zza(zzapw.zzb(), zze.zzc()), (zzaly) zza2.zzt());
        CancellationToken cancellationToken = findAutocompletePredictionsRequest.getCancellationToken();
        if (cancellationToken != null) {
            cancellationToken.onCanceledRequested(new OnTokenCanceledListener() { // from class: com.google.android.libraries.places.internal.zzgn
                @Override // com.google.android.gms.tasks.OnTokenCanceledListener
                public final void onCanceled() {
                    zzaka.this.cancel(true);
                }
            });
        }
        return zzed.zza(zza5).onSuccessTask(new SuccessContinuation() { // from class: com.google.android.libraries.places.internal.zzgt
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                return zzhc.this.zza((zzamn) obj);
            }
        }).continueWithTask(new Continuation(zza, i12) { // from class: com.google.android.libraries.places.internal.zzgu
            public final /* synthetic */ long zzb;

            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                zzhc.this.zzh(this.zzb, 1, task);
                return task;
            }
        });
    }

    public final Task zzf(FetchResolvedPhotoUriRequest fetchResolvedPhotoUriRequest, int i11) {
        final long zza = this.zzd.zza();
        final int i12 = 1;
        zzbur zze = this.zza.zze(zzbva.zza(this.zzb.zza("", this.zzl.zza())));
        zzanw zza2 = zzanx.zza();
        String zza3 = fetchResolvedPhotoUriRequest.getPhotoMetadata().zza();
        zza3.getClass();
        zza2.zzc(zza3.concat("/media"));
        Integer maxHeight = fetchResolvedPhotoUriRequest.getMaxHeight();
        if (maxHeight != null) {
            zza2.zza(maxHeight.intValue());
        }
        Integer maxWidth = fetchResolvedPhotoUriRequest.getMaxWidth();
        if (maxWidth != null) {
            zza2.zzb(maxWidth.intValue());
        }
        zza2.zzd(true);
        final zzaka zza4 = zzbux.zza(zze.zzd().zza(zzapw.zzc(), zze.zzc()), (zzanx) zza2.zzt());
        CancellationToken cancellationToken = fetchResolvedPhotoUriRequest.getCancellationToken();
        if (cancellationToken != null) {
            cancellationToken.onCanceledRequested(new OnTokenCanceledListener() { // from class: com.google.android.libraries.places.internal.zzgq
                @Override // com.google.android.gms.tasks.OnTokenCanceledListener
                public final void onCanceled() {
                    zzaka.this.cancel(true);
                }
            });
        }
        return zzed.zza(zza4).onSuccessTask(new SuccessContinuation() { // from class: com.google.android.libraries.places.internal.zzgr
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
                taskCompletionSource.setResult(FetchResolvedPhotoUriResponse.newInstance(Uri.parse(((zzaoj) obj).zzd())));
                return taskCompletionSource.getTask();
            }
        }).continueWithTask(new Continuation(zza, i12) { // from class: com.google.android.libraries.places.internal.zzgs
            public final /* synthetic */ long zzb;

            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                zzhc.this.zzi(this.zzb, 1, task);
                return task;
            }
        });
    }

    public final Task zzg(FetchPlaceRequest fetchPlaceRequest, int i11) {
        final int i12 = 1;
        if (fetchPlaceRequest.getPlaceId().isEmpty()) {
            return Tasks.forException(new ApiException(new Status(PlacesStatusCodes.INVALID_REQUEST, "Place id must not be an empty string.")));
        }
        List<Place.Field> placeFields = fetchPlaceRequest.getPlaceFields();
        if (placeFields.isEmpty()) {
            return Tasks.forException(new ApiException(new Status(PlacesStatusCodes.INVALID_REQUEST, "Place fields must not be empty.")));
        }
        String regionCode = fetchPlaceRequest.getRegionCode();
        if (regionCode != null && regionCode.isEmpty()) {
            return Tasks.forException(new ApiException(new Status(PlacesStatusCodes.INVALID_REQUEST, "Region code must not be an empty string.")));
        }
        final long zza = this.zzd.zza();
        zzbur zze = this.zza.zze(zzbva.zza(this.zzb.zza(zzjv.zzb(zzhg.zza(placeFields)), this.zzl.zza())));
        Locale zzb = this.zzl.zzb();
        zzanz zza2 = zzaoa.zza();
        zza2.zzb("places/".concat(String.valueOf(fetchPlaceRequest.getPlaceId())));
        String regionCode2 = fetchPlaceRequest.getRegionCode();
        if (regionCode2 != null) {
            zza2.zzc(regionCode2);
        }
        AutocompleteSessionToken sessionToken = fetchPlaceRequest.getSessionToken();
        if (sessionToken != null) {
            zza2.zzd(sessionToken.toString());
        }
        zza2.zza(zzb.toLanguageTag());
        final zzaka zza3 = zzbux.zza(zze.zzd().zza(zzapw.zzd(), zze.zzc()), (zzaoa) zza2.zzt());
        CancellationToken cancellationToken = fetchPlaceRequest.getCancellationToken();
        if (cancellationToken != null) {
            cancellationToken.onCanceledRequested(new OnTokenCanceledListener() { // from class: com.google.android.libraries.places.internal.zzgv
                @Override // com.google.android.gms.tasks.OnTokenCanceledListener
                public final void onCanceled() {
                    zzaka.this.cancel(true);
                }
            });
        }
        return zzed.zza(zza3).onSuccessTask(new SuccessContinuation() { // from class: com.google.android.libraries.places.internal.zzgw
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                return zzhc.this.zzb((zzaps) obj);
            }
        }).continueWithTask(new Continuation(zza, i12) { // from class: com.google.android.libraries.places.internal.zzgx
            public final /* synthetic */ long zzb;

            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                zzhc.this.zzj(this.zzb, 1, task);
                return task;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Task zzh(long j11, int i11, Task task) throws Exception {
        if (task.isCanceled()) {
            return task;
        }
        this.zzc.zzn(task, j11, this.zzd.zza(), 3, 1);
        return task;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Task zzi(long j11, int i11, Task task) throws Exception {
        if (task.isCanceled()) {
            return task;
        }
        this.zzc.zzd(task, j11, this.zzd.zza(), 1);
        return task;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Task zzj(long j11, int i11, Task task) throws Exception {
        if (task.isCanceled()) {
            return task;
        }
        this.zzc.zzl(task, j11, this.zzd.zza(), 3, 1);
        return task;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Task zzk(SearchByTextRequest searchByTextRequest, long j11, int i11, Task task) throws Exception {
        if (task.isCanceled()) {
            return task;
        }
        this.zzc.zzh(searchByTextRequest, task, j11, this.zzd.zza(), 1);
        return task;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Task zzl(SearchNearbyRequest searchNearbyRequest, long j11, int i11, Task task) throws Exception {
        if (task.isCanceled()) {
            return task;
        }
        this.zzc.zzj(searchNearbyRequest, task, j11, this.zzd.zza(), 1);
        return task;
    }

    public final Task zzm(final SearchByTextRequest searchByTextRequest, int i11) {
        int i12;
        List<Place.Field> placeFields = searchByTextRequest.getPlaceFields();
        if (placeFields.isEmpty()) {
            return Tasks.forException(new ApiException(new Status(PlacesStatusCodes.INVALID_REQUEST, "Place fields must not be empty.")));
        }
        if (searchByTextRequest.getTextQuery().isEmpty()) {
            return Tasks.forException(new ApiException(new Status(PlacesStatusCodes.INVALID_REQUEST, "Text query must not be an empty string.")));
        }
        String includedType = searchByTextRequest.getIncludedType();
        if (includedType != null && includedType.isEmpty()) {
            return Tasks.forException(new ApiException(new Status(PlacesStatusCodes.INVALID_REQUEST, "Included type must not be an empty string.")));
        }
        String regionCode = searchByTextRequest.getRegionCode();
        if (regionCode != null && regionCode.isEmpty()) {
            return Tasks.forException(new ApiException(new Status(PlacesStatusCodes.INVALID_REQUEST, "Region code must not be an empty string.")));
        }
        final long zza = this.zzd.zza();
        zzbur zze = this.zza.zze(zzbva.zza(this.zzb.zza(zzjv.zza(zzhg.zza(placeFields)), this.zzl.zza())));
        Locale zzb = this.zzl.zzb();
        zzare zza2 = zzaro.zza();
        String includedType2 = searchByTextRequest.getIncludedType();
        if (includedType2 != null) {
            zza2.zzb(includedType2);
        }
        LocationBias locationBias = searchByTextRequest.getLocationBias();
        if (locationBias != null) {
            boolean z10 = locationBias instanceof RectangularBounds;
            zzmt.zzf(z10 || (locationBias instanceof CircularBounds), "LocationBias must be of type RectangularBounds or CircularBounds.");
            zzari zza3 = zzarj.zza();
            if (z10) {
                zza3.zzb(zzge.zzb((RectangularBounds) locationBias));
            } else {
                zza3.zza(zzge.zza((CircularBounds) locationBias));
            }
            zza2.zzd((zzarj) zza3.zzt());
        }
        LocationRestriction locationRestriction = searchByTextRequest.getLocationRestriction();
        if (locationRestriction != null) {
            zzmt.zzf(locationRestriction instanceof RectangularBounds, "LocationRestriction must be of type RectangularBounds.");
            zzark zza4 = zzarl.zza();
            zza4.zza(zzge.zzb((RectangularBounds) locationRestriction));
            zza2.zze((zzarl) zza4.zzt());
        }
        Integer maxResultCount = searchByTextRequest.getMaxResultCount();
        if (maxResultCount != null) {
            zza2.zzf(maxResultCount.intValue());
        }
        Double minRating = searchByTextRequest.getMinRating();
        if (minRating != null) {
            zza2.zzg(minRating.doubleValue());
        }
        zza2.zzh(searchByTextRequest.isOpenNow());
        List<Integer> priceLevels = searchByTextRequest.getPriceLevels();
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = priceLevels.iterator();
        while (true) {
            i12 = 4;
            if (!it.hasNext()) {
                break;
            }
            int intValue = it.next().intValue();
            if (intValue == 0) {
                arrayList.add(zzaqb.PRICE_LEVEL_FREE);
            } else if (intValue == 1) {
                arrayList.add(zzaqb.PRICE_LEVEL_INEXPENSIVE);
            } else if (intValue == 2) {
                arrayList.add(zzaqb.PRICE_LEVEL_MODERATE);
            } else if (intValue == 3) {
                arrayList.add(zzaqb.PRICE_LEVEL_EXPENSIVE);
            } else if (intValue == 4) {
                arrayList.add(zzaqb.PRICE_LEVEL_VERY_EXPENSIVE);
            }
        }
        zza2.zza(arrayList);
        SearchByTextRequest.RankPreference rankPreference = searchByTextRequest.getRankPreference();
        if (rankPreference == null) {
            i12 = 2;
        } else if (rankPreference.ordinal() == 0) {
            i12 = 3;
        }
        zza2.zzl(i12);
        String regionCode2 = searchByTextRequest.getRegionCode();
        if (regionCode2 != null) {
            zza2.zzi(regionCode2);
        }
        zza2.zzj(searchByTextRequest.isStrictTypeFiltering());
        zza2.zzk(searchByTextRequest.getTextQuery());
        zza2.zzc(zzb.toLanguageTag());
        final zzaka zza5 = zzbux.zza(zze.zzd().zza(zzapw.zzf(), zze.zzc()), (zzaro) zza2.zzt());
        CancellationToken cancellationToken = searchByTextRequest.getCancellationToken();
        if (cancellationToken != null) {
            cancellationToken.onCanceledRequested(new OnTokenCanceledListener() { // from class: com.google.android.libraries.places.internal.zzhb
                @Override // com.google.android.gms.tasks.OnTokenCanceledListener
                public final void onCanceled() {
                    zzaka.this.cancel(true);
                }
            });
        }
        final int i13 = 1;
        return zzed.zza(zza5).onSuccessTask(new SuccessContinuation() { // from class: com.google.android.libraries.places.internal.zzgo
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                return zzhc.this.zzc((zzarr) obj);
            }
        }).continueWithTask(new Continuation(searchByTextRequest, zza, i13) { // from class: com.google.android.libraries.places.internal.zzgp
            public final /* synthetic */ SearchByTextRequest zzb;
            public final /* synthetic */ long zzc;

            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                zzhc.this.zzk(this.zzb, this.zzc, 1, task);
                return task;
            }
        });
    }

    public final Task zzn(final SearchNearbyRequest searchNearbyRequest, int i11) {
        List<Place.Field> placeFields = searchNearbyRequest.getPlaceFields();
        if (placeFields.isEmpty()) {
            return Tasks.forException(new ApiException(new Status(PlacesStatusCodes.INVALID_REQUEST, "Place fields must not be empty.")));
        }
        String regionCode = searchNearbyRequest.getRegionCode();
        if (regionCode != null && regionCode.isEmpty()) {
            return Tasks.forException(new ApiException(new Status(PlacesStatusCodes.INVALID_REQUEST, "Region code must not be an empty string.")));
        }
        final long zza = this.zzd.zza();
        zzbur zze = this.zza.zze(zzbva.zza(this.zzb.zza(zzjv.zza(zzhg.zza(placeFields)), this.zzl.zza())));
        Locale zzb = this.zzl.zzb();
        zzaqu zza2 = zzaqz.zza();
        zza2.zze(zzb.toLanguageTag());
        String regionCode2 = searchNearbyRequest.getRegionCode();
        if (regionCode2 != null) {
            zza2.zzh(regionCode2);
        }
        List<String> includedTypes = searchNearbyRequest.getIncludedTypes();
        if (includedTypes != null) {
            zza2.zzd(includedTypes);
        }
        List<String> excludedTypes = searchNearbyRequest.getExcludedTypes();
        if (excludedTypes != null) {
            zza2.zzb(excludedTypes);
        }
        List<String> includedPrimaryTypes = searchNearbyRequest.getIncludedPrimaryTypes();
        if (includedPrimaryTypes != null) {
            zza2.zzc(includedPrimaryTypes);
        }
        List<String> excludedPrimaryTypes = searchNearbyRequest.getExcludedPrimaryTypes();
        if (excludedPrimaryTypes != null) {
            zza2.zza(excludedPrimaryTypes);
        }
        Integer maxResultCount = searchNearbyRequest.getMaxResultCount();
        if (maxResultCount != null) {
            zza2.zzg(maxResultCount.intValue());
        }
        zzaqx zza3 = zzaqy.zza();
        zza3.zza(zzge.zza((CircularBounds) searchNearbyRequest.getLocationRestriction()));
        zza2.zzf((zzaqy) zza3.zzt());
        SearchNearbyRequest.RankPreference rankPreference = searchNearbyRequest.getRankPreference();
        zza2.zzi(rankPreference == null ? 2 : rankPreference.ordinal() != 0 ? 4 : 3);
        final zzaka zza4 = zzbux.zza(zze.zzd().zza(zzapw.zze(), zze.zzc()), (zzaqz) zza2.zzt());
        CancellationToken cancellationToken = searchNearbyRequest.getCancellationToken();
        if (cancellationToken != null) {
            cancellationToken.onCanceledRequested(new OnTokenCanceledListener() { // from class: com.google.android.libraries.places.internal.zzgy
                @Override // com.google.android.gms.tasks.OnTokenCanceledListener
                public final void onCanceled() {
                    zzaka.this.cancel(true);
                }
            });
        }
        final int i12 = 1;
        return zzed.zza(zza4).onSuccessTask(new SuccessContinuation() { // from class: com.google.android.libraries.places.internal.zzgz
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                return zzhc.this.zzd((zzarc) obj);
            }
        }).continueWithTask(new Continuation(searchNearbyRequest, zza, i12) { // from class: com.google.android.libraries.places.internal.zzha
            public final /* synthetic */ SearchNearbyRequest zzb;
            public final /* synthetic */ long zzc;

            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                zzhc.this.zzl(this.zzb, this.zzc, 1, task);
                return task;
            }
        });
    }
}
