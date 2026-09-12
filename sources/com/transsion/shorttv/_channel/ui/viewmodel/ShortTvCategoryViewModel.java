package com.transsion.shorttv._channel.ui.viewmodel;

import android.app.Application;
import androidx.view.b0;
import androidx.view.u0;
import com.transsion.shorttv._channel.model.ShortTvCategoryBean;
import com.transsion.shorttv._channel.model.ShortTvCategoryItemBean;
import com.transsion.shorttv.bean.Subject;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.y0;

/* loaded from: classes6.dex */
public final class ShortTvCategoryViewModel extends androidx.view.b {

    /* renamed from: b, reason: collision with root package name */
    private int f52687b;

    /* renamed from: c, reason: collision with root package name */
    private int f52688c;

    /* renamed from: d, reason: collision with root package name */
    private final Lazy f52689d;

    /* renamed from: e, reason: collision with root package name */
    private final Lazy f52690e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTvCategoryViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.f52687b = 1;
        this.f52688c = 10;
        this.f52689d = LazyKt.b(new Function0() { // from class: com.transsion.shorttv._channel.ui.viewmodel.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                nr.a n11;
                n11 = ShortTvCategoryViewModel.n();
                return n11;
            }
        });
        this.f52690e = LazyKt.b(new Function0() { // from class: com.transsion.shorttv._channel.ui.viewmodel.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                b0 h11;
                h11 = ShortTvCategoryViewModel.h();
                return h11;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 h() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final nr.a l() {
        return (nr.a) this.f52689d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(ShortTvCategoryBean shortTvCategoryBean) {
        List<ShortTvCategoryItemBean> list;
        if (shortTvCategoryBean == null || (list = shortTvCategoryBean.getList()) == null) {
            return;
        }
        for (ShortTvCategoryItemBean shortTvCategoryItemBean : list) {
            Subject subject = shortTvCategoryItemBean.getSubject();
            String ops = subject != null ? subject.getOps() : null;
            if (ops == null || ops.length() == 0) {
                Subject subject2 = shortTvCategoryItemBean.getSubject();
                if (subject2 != null) {
                    subject2.setOps(shortTvCategoryBean.getOps());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final nr.a n() {
        return (nr.a) zg.c.f79537e.a().h(nr.a.class);
    }

    public final void i(String type) {
        Intrinsics.h(type, "type");
        k.d(u0.a(this), y0.b(), null, new ShortTvCategoryViewModel$getCategoryList$1(type, this, null), 2, null);
    }

    public final b0 j() {
        return (b0) this.f52690e.getValue();
    }

    public final int k() {
        return this.f52687b;
    }

    public final void o(int i11) {
        this.f52687b = i11;
    }
}
