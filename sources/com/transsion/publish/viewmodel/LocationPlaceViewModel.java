package com.transsion.publish.viewmodel;

import android.app.Application;
import androidx.view.b0;
import androidx.view.t0;
import androidx.view.u0;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.place.PlaceDao;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.y0;

/* loaded from: classes6.dex */
public final class LocationPlaceViewModel extends t0 {

    /* renamed from: a, reason: collision with root package name */
    private final Lazy f50822a = LazyKt.b(new Function0() { // from class: com.transsion.publish.viewmodel.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            lp.a q11;
            q11 = LocationPlaceViewModel.q();
            return q11;
        }
    });

    /* renamed from: b, reason: collision with root package name */
    private final Lazy f50823b = LazyKt.b(new Function0() { // from class: com.transsion.publish.viewmodel.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            PlaceDao p11;
            p11 = LocationPlaceViewModel.p();
            return p11;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    private final b0 f50824c = new b0();

    /* renamed from: d, reason: collision with root package name */
    private final b0 f50825d = new b0();

    /* JADX INFO: Access modifiers changed from: private */
    public final PlaceDao m() {
        return (PlaceDao) this.f50823b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final lp.a n() {
        return (lp.a) this.f50822a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PlaceDao p() {
        AppDatabase.Companion companion = AppDatabase.INSTANCE;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        return companion.b(a11).u1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lp.a q() {
        return (lp.a) zg.c.f79537e.a().h(lp.a.class);
    }

    public final void h() {
        k.d(u0.a(this), y0.b(), null, new LocationPlaceViewModel$clearCache$1(this, null), 2, null);
    }

    public final void i() {
        k.d(u0.a(this), null, null, new LocationPlaceViewModel$getCache$1(this, null), 3, null);
    }

    public final b0 j() {
        return this.f50825d;
    }

    public final void k(Double d11, Double d12) {
        k.d(u0.a(this), null, null, new LocationPlaceViewModel$getLocationPlaceList$1(this, d11, d12, null), 3, null);
    }

    public final b0 l() {
        return this.f50824c;
    }

    public final void o(List list) {
        Intrinsics.h(list, "list");
        k.d(u0.a(this), y0.b(), null, new LocationPlaceViewModel$insertCache$1(list, this, null), 2, null);
    }
}
