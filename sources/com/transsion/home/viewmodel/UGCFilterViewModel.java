package com.transsion.home.viewmodel;

import android.app.Application;
import androidx.view.LiveData;
import androidx.view.u0;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.home.bean.ugc.UGCFilterItem;
import com.transsion.home.bean.ugc.UGCFilterResponse;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.y0;

/* loaded from: classes5.dex */
public final class UGCFilterViewModel extends androidx.view.b {

    /* renamed from: f, reason: collision with root package name */
    public static final a f45919f = new a(null);

    /* renamed from: g, reason: collision with root package name */
    public static final int f45920g = 8;

    /* renamed from: b, reason: collision with root package name */
    private final Lazy f45921b;

    /* renamed from: c, reason: collision with root package name */
    private final Lazy f45922c;

    /* renamed from: d, reason: collision with root package name */
    private final Lazy f45923d;

    /* renamed from: e, reason: collision with root package name */
    private final ol.c f45924e;

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UGCFilterViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.f45921b = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.z
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                androidx.view.b0 g11;
                g11 = UGCFilterViewModel.g();
                return g11;
            }
        });
        this.f45922c = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.a0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                androidx.view.b0 q11;
                q11 = UGCFilterViewModel.q();
                return q11;
            }
        });
        this.f45923d = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.b0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                androidx.view.b0 p11;
                p11 = UGCFilterViewModel.p();
                return p11;
            }
        });
        this.f45924e = (ol.c) zg.c.f79537e.a().h(ol.c.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.view.b0 g() {
        return new androidx.view.b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.view.b0 p() {
        return new androidx.view.b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.view.b0 q() {
        return new androidx.view.b0();
    }

    public final UGCFilterItem h(String str) {
        UGCFilterResponse uGCFilterResponse;
        BaseDto baseDto = (BaseDto) k().f();
        Object obj = null;
        List<UGCFilterItem> items = (baseDto == null || (uGCFilterResponse = (UGCFilterResponse) baseDto.getData()) == null) ? null : uGCFilterResponse.getItems();
        if (items == null) {
            return null;
        }
        Iterator<T> it = items.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (Intrinsics.c(((UGCFilterItem) next).getCategoryId(), str)) {
                obj = next;
                break;
            }
        }
        return (UGCFilterItem) obj;
    }

    public final void i(String category) {
        Intrinsics.h(category, "category");
        kotlinx.coroutines.k.d(u0.a(this), y0.b(), null, new UGCFilterViewModel$getFilterItems$1(category, this, null), 2, null);
    }

    public final LiveData j() {
        return k();
    }

    public final androidx.view.b0 k() {
        return (androidx.view.b0) this.f45921b.getValue();
    }

    public final androidx.view.b0 l() {
        return (androidx.view.b0) this.f45923d.getValue();
    }

    public final void m(String category, int i11, int i12, String str, Integer num, Integer num2, Integer num3, String str2, boolean z10) {
        Intrinsics.h(category, "category");
        kotlinx.coroutines.k.d(u0.a(this), y0.b(), null, new UGCFilterViewModel$getUGCContentList$1(category.length() == 0 ? "Education" : category, i11, str, num, num2, num3, z10, this, i12, str2, null), 2, null);
    }

    public final LiveData n() {
        return o();
    }

    public final androidx.view.b0 o() {
        return (androidx.view.b0) this.f45922c.getValue();
    }
}
