package com.transsion.publish.viewmodel;

import com.transsion.baselib.db.place.PlaceDBBean;
import com.transsion.baselib.db.place.PlaceDao;
import com.transsion.room.api.bean.LocationPlace;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;
import lg.a;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.publish.viewmodel.LocationPlaceViewModel$insertCache$1", f = "LocationPlaceViewModel.kt", l = {127}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class LocationPlaceViewModel$insertCache$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<LocationPlace> $list;
    int label;
    final /* synthetic */ LocationPlaceViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocationPlaceViewModel$insertCache$1(List<LocationPlace> list, LocationPlaceViewModel locationPlaceViewModel, Continuation<? super LocationPlaceViewModel$insertCache$1> continuation) {
        super(2, continuation);
        this.$list = list;
        this.this$0 = locationPlaceViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocationPlaceViewModel$insertCache$1(this.$list, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((LocationPlaceViewModel$insertCache$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        PlaceDao m11;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            ArrayList arrayList = new ArrayList();
            for (LocationPlace locationPlace : this.$list) {
                Double lat = locationPlace.getLat();
                double doubleValue = lat != null ? lat.doubleValue() : 0.0d;
                Double lon = locationPlace.getLon();
                PlaceDBBean placeDBBean = new PlaceDBBean(doubleValue, lon != null ? lon.doubleValue() : 0.0d, locationPlace.getName(), locationPlace.getAddress(), locationPlace.getDistance());
                a.C0856a.f(lg.a.f68962a, "SelectLocation", "insertCache latitude:" + placeDBBean.getLatitude() + ", longitude:" + placeDBBean.getLongitude() + ", name:" + placeDBBean.getName(), false, 4, null);
                arrayList.add(placeDBBean);
            }
            m11 = this.this$0.m();
            this.label = 1;
            if (m11.c(arrayList, this) == f11) {
                return f11;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f67184a;
    }
}
