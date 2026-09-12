package com.transsion.room.helper;

import ak.s;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.PlaceLikelihood;
import com.google.android.libraries.places.api.net.FindCurrentPlaceRequest;
import com.google.android.libraries.places.api.net.FindCurrentPlaceResponse;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.transsion.room.api.bean.LocationPlace;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;
import lg.a;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/n0;", "", "Lcom/transsion/room/api/bean/LocationPlace;", "<anonymous>", "(Lkotlinx/coroutines/n0;)Ljava/util/List;"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.room.helper.LocationPlaceHelper$getNearbyPlacesWithDetailApi$1$result$1", f = "LocationPlaceHelper.kt", l = {TTAdConstant.IMAGE_CODE}, m = "invokeSuspend")
/* loaded from: classes6.dex */
final class LocationPlaceHelper$getNearbyPlacesWithDetailApi$1$result$1 extends SuspendLambda implements Function2<n0, Continuation<? super List<LocationPlace>>, Object> {
    final /* synthetic */ LatLng $currentLatLng;
    final /* synthetic */ FindCurrentPlaceRequest $request;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class a implements OnCompleteListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation f51668a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ LatLng f51669b;

        a(Continuation continuation, LatLng latLng) {
            this.f51668a = continuation;
            this.f51669b = latLng;
        }

        @Override // com.google.android.gms.tasks.OnCompleteListener
        public final void onComplete(Task task) {
            Iterator<PlaceLikelihood> it;
            String str;
            Intrinsics.h(task, "task");
            if (!task.isSuccessful()) {
                Exception exception = task.getException();
                if (exception != null) {
                    Continuation continuation = this.f51668a;
                    a.C0856a.f(lg.a.f68962a, "LocationP", "place fail: " + exception.getMessage(), false, 4, null);
                    continuation.resumeWith(Result.m1185constructorimpl(null));
                    return;
                }
                return;
            }
            FindCurrentPlaceResponse findCurrentPlaceResponse = (FindCurrentPlaceResponse) task.getResult();
            if (findCurrentPlaceResponse == null) {
                a.C0856a.f(lg.a.f68962a, "LocationP", "place fail:response null", false, 4, null);
                this.f51668a.resumeWith(Result.m1185constructorimpl(null));
                return;
            }
            try {
                ArrayList arrayList = new ArrayList();
                a.C0856a.f(lg.a.f68962a, "LocationP", "getNearbyPlaces --size:" + findCurrentPlaceResponse.getPlaceLikelihoods().size(), false, 4, null);
                Iterator<PlaceLikelihood> it2 = findCurrentPlaceResponse.getPlaceLikelihoods().iterator();
                while (it2.hasNext()) {
                    try {
                        Place place = it2.next().getPlace();
                        LatLng latLng = place.getLatLng();
                        String name = place.getName();
                        String address = place.getAddress();
                        if (latLng != null) {
                            s sVar = s.f726a;
                            LatLng latLng2 = this.f51669b;
                            it = it2;
                            try {
                                str = sVar.a(latLng2.latitude, latLng2.longitude, latLng.latitude, latLng.longitude);
                            } catch (Throwable th2) {
                                th = th2;
                                a.C0856a.l(lg.a.f68962a, "LocationP", "place error2 :" + th, false, 4, null);
                                th.printStackTrace();
                                it2 = it;
                            }
                        } else {
                            it = it2;
                            str = "<0.1m";
                        }
                        a.C0856a.f(lg.a.f68962a, "LocationP", "place list 名称: " + name + ", 距离: " + str + ", 地址: " + address + ",lat:" + (latLng != null ? Double.valueOf(latLng.latitude) : null), false, 4, null);
                        LocationPlace locationPlace = new LocationPlace(null, null, null, null, 15, null);
                        locationPlace.setName(name);
                        locationPlace.setAddress(address);
                        locationPlace.setDistance(str);
                        locationPlace.setLat(latLng != null ? Double.valueOf(latLng.latitude) : null);
                        locationPlace.setLon(latLng != null ? Double.valueOf(latLng.longitude) : null);
                        arrayList.add(locationPlace);
                    } catch (Throwable th3) {
                        th = th3;
                        it = it2;
                    }
                    it2 = it;
                }
                this.f51668a.resumeWith(Result.m1185constructorimpl(arrayList));
            } catch (Throwable th4) {
                a.C0856a.l(lg.a.f68962a, "LocationP", "place error1 :" + th4, false, 4, null);
                this.f51668a.resumeWith(Result.m1185constructorimpl(null));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocationPlaceHelper$getNearbyPlacesWithDetailApi$1$result$1(FindCurrentPlaceRequest findCurrentPlaceRequest, LatLng latLng, Continuation<? super LocationPlaceHelper$getNearbyPlacesWithDetailApi$1$result$1> continuation) {
        super(2, continuation);
        this.$request = findCurrentPlaceRequest;
        this.$currentLatLng = latLng;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocationPlaceHelper$getNearbyPlacesWithDetailApi$1$result$1(this.$request, this.$currentLatLng, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super List<LocationPlace>> continuation) {
        return ((LocationPlaceHelper$getNearbyPlacesWithDetailApi$1$result$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        PlacesClient placesClient;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            FindCurrentPlaceRequest findCurrentPlaceRequest = this.$request;
            LatLng latLng = this.$currentLatLng;
            this.L$0 = findCurrentPlaceRequest;
            this.L$1 = latLng;
            this.label = 1;
            SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.c(this));
            placesClient = LocationPlaceHelper.f51665b;
            Task<FindCurrentPlaceResponse> findCurrentPlace = placesClient != null ? placesClient.findCurrentPlace(findCurrentPlaceRequest) : null;
            a.C0856a.f(lg.a.f68962a, "LocationP", "getNearbyPlaces --findCurrentPlace", false, 4, null);
            if (findCurrentPlace != null) {
                findCurrentPlace.addOnCompleteListener(new a(safeContinuation, latLng));
            }
            obj = safeContinuation.a();
            if (obj == IntrinsicsKt.f()) {
                DebugProbesKt.c(this);
            }
            if (obj == f11) {
                return f11;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return obj;
    }
}
