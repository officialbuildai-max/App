package com.transsion.shorttv_pugc.viewmodel;

import androidx.view.b0;
import androidx.view.t0;
import androidx.view.u0;
import com.transsion.shorttv_pugc.bean.ShortTVFavInfo;
import com.transsion.shorttv_pugc.bean.Subject;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;

/* loaded from: classes6.dex */
public final class ShortTvDownloadViewModel extends t0 {

    /* renamed from: k, reason: collision with root package name */
    public static final a f54509k = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final Lazy f54510a = LazyKt.b(new Function0() { // from class: com.transsion.shorttv_pugc.viewmodel.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            rt.a p11;
            p11 = ShortTvDownloadViewModel.p();
            return p11;
        }
    });

    /* renamed from: b, reason: collision with root package name */
    private final b0 f54511b = new b0();

    /* renamed from: c, reason: collision with root package name */
    private final b0 f54512c = new b0();

    /* renamed from: d, reason: collision with root package name */
    private final b0 f54513d = new b0();

    /* renamed from: e, reason: collision with root package name */
    private final b0 f54514e = new b0();

    /* renamed from: f, reason: collision with root package name */
    private final b0 f54515f = new b0();

    /* renamed from: g, reason: collision with root package name */
    private final b0 f54516g = new b0();

    /* renamed from: h, reason: collision with root package name */
    private final b0 f54517h = new b0();

    /* renamed from: i, reason: collision with root package name */
    private final b0 f54518i = new b0();

    /* renamed from: j, reason: collision with root package name */
    private final b0 f54519j = new b0();

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final rt.a f() {
        return (rt.a) this.f54510a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final rt.a p() {
        return (rt.a) zg.c.f79537e.a().h(rt.a.class);
    }

    public final void d(Subject subject) {
        ShortTVFavInfo shortTVFavInfo;
        if (subject == null || (shortTVFavInfo = subject.getShortTVFavInfo()) == null) {
            return;
        }
        k.d(u0.a(this), null, null, new ShortTvDownloadViewModel$favorite$1(subject, shortTVFavInfo.getHasFavorite(), this, shortTVFavInfo, null), 3, null);
    }

    public final b0 e() {
        return this.f54511b;
    }

    public final void g(String subjectId, int i11, int i12) {
        Intrinsics.h(subjectId, "subjectId");
    }

    public final b0 h() {
        return this.f54515f;
    }

    public final b0 i() {
        return this.f54518i;
    }

    public final b0 j() {
        return this.f54517h;
    }

    public final b0 k() {
        return this.f54519j;
    }

    public final b0 l() {
        return this.f54512c;
    }

    public final b0 m() {
        return this.f54513d;
    }

    public final b0 n() {
        return this.f54516g;
    }

    public final b0 o() {
        return this.f54514e;
    }

    public final void q(ot.c item) {
        Intrinsics.h(item, "item");
        Map map = (Map) this.f54512c.f();
        if (map == null) {
            map = new LinkedHashMap();
        }
        if (item.d()) {
            map.remove(Integer.valueOf(item.a()));
        } else {
            map.put(Integer.valueOf(item.a()), item);
        }
        this.f54512c.q(map);
    }
}
