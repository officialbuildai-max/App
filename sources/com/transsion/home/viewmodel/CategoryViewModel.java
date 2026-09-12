package com.transsion.home.viewmodel;

import android.app.Application;
import androidx.view.u0;
import com.transsion.home.bean.CategoryBean;
import com.transsion.moviedetailapi.bean.CategoryItemBean;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.y0;

/* loaded from: classes5.dex */
public final class CategoryViewModel extends androidx.view.b {

    /* renamed from: b, reason: collision with root package name */
    private int f45842b;

    /* renamed from: c, reason: collision with root package name */
    private int f45843c;

    /* renamed from: d, reason: collision with root package name */
    private final Lazy f45844d;

    /* renamed from: e, reason: collision with root package name */
    private final Lazy f45845e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CategoryViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.f45842b = 1;
        this.f45843c = 10;
        this.f45844d = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ol.b n11;
                n11 = CategoryViewModel.n();
                return n11;
            }
        });
        this.f45845e = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                androidx.view.b0 h11;
                h11 = CategoryViewModel.h();
                return h11;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.view.b0 h() {
        return new androidx.view.b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ol.b l() {
        return (ol.b) this.f45844d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(CategoryBean categoryBean) {
        List<CategoryItemBean> list;
        if (categoryBean == null || (list = categoryBean.getList()) == null) {
            return;
        }
        for (CategoryItemBean categoryItemBean : list) {
            Subject subject = categoryItemBean.getSubject();
            String ops = subject != null ? subject.getOps() : null;
            if (ops == null || ops.length() == 0) {
                Subject subject2 = categoryItemBean.getSubject();
                if (subject2 != null) {
                    subject2.setOps(categoryBean.getOps());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ol.b n() {
        return (ol.b) zg.c.f79537e.a().h(ol.b.class);
    }

    public final void i(String type) {
        Intrinsics.h(type, "type");
        kotlinx.coroutines.k.d(u0.a(this), y0.b(), null, new CategoryViewModel$getCategoryList$1(type, this, null), 2, null);
    }

    public final androidx.view.b0 j() {
        return (androidx.view.b0) this.f45845e.getValue();
    }

    public final int k() {
        return this.f45842b;
    }

    public final void o(int i11) {
        this.f45842b = i11;
    }
}
