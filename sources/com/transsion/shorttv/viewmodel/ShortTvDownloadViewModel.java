package com.transsion.shorttv.viewmodel;

import android.app.Application;
import androidx.view.b0;
import androidx.view.t0;
import androidx.view.u0;
import com.blankj.utilcode.util.Utils;
import com.transsion.shorttv.bean.ShortTVFavInfo;
import com.transsion.shorttv.bean.Subject;
import com.transsion.shorttv.db.ShortTvAdUnlockDao;
import com.transsion.shorttv.db.ShortTvDatabase;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.y0;
import lg.a;

/* loaded from: classes6.dex */
public final class ShortTvDownloadViewModel extends t0 {

    /* renamed from: k, reason: collision with root package name */
    public static final a f53717k = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final Lazy f53718a = LazyKt.b(new Function0() { // from class: com.transsion.shorttv.viewmodel.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            os.a u11;
            u11 = ShortTvDownloadViewModel.u();
            return u11;
        }
    });

    /* renamed from: b, reason: collision with root package name */
    private final Lazy f53719b = LazyKt.b(new Function0() { // from class: com.transsion.shorttv.viewmodel.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            ShortTvAdUnlockDao f11;
            f11 = ShortTvDownloadViewModel.f(ShortTvDownloadViewModel.this);
            return f11;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    private final b0 f53720c = new b0();

    /* renamed from: d, reason: collision with root package name */
    private final b0 f53721d = new b0();

    /* renamed from: e, reason: collision with root package name */
    private final b0 f53722e = new b0();

    /* renamed from: f, reason: collision with root package name */
    private final b0 f53723f = new b0();

    /* renamed from: g, reason: collision with root package name */
    private final b0 f53724g = new b0();

    /* renamed from: h, reason: collision with root package name */
    private final b0 f53725h = new b0();

    /* renamed from: i, reason: collision with root package name */
    private final b0 f53726i = new b0();

    /* renamed from: j, reason: collision with root package name */
    private final b0 f53727j = new b0();

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ShortTvAdUnlockDao f(ShortTvDownloadViewModel shortTvDownloadViewModel) {
        Object m1185constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            ShortTvDatabase.Companion companion2 = ShortTvDatabase.INSTANCE;
            Application a11 = Utils.a();
            Intrinsics.g(a11, "getApp(...)");
            m1185constructorimpl = Result.m1185constructorimpl(companion2.b(a11).j0());
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl != null) {
            a.C0856a.l(lg.a.f68962a, "ShortTvDownload", "adUnlockDao init failed: " + m1188exceptionOrNullimpl, false, 4, null);
        }
        if (Result.m1191isFailureimpl(m1185constructorimpl)) {
            m1185constructorimpl = null;
        }
        return (ShortTvAdUnlockDao) m1185constructorimpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ShortTvAdUnlockDao h() {
        return (ShortTvAdUnlockDao) this.f53719b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final os.a k() {
        return (os.a) this.f53718a.getValue();
    }

    public static /* synthetic */ void o(ShortTvDownloadViewModel shortTvDownloadViewModel, String str, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        shortTvDownloadViewModel.n(str, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final os.a u() {
        return (os.a) zg.c.f79537e.a().h(os.a.class);
    }

    public final void g(Subject subject) {
        ShortTVFavInfo shortTVFavInfo;
        if (subject == null || (shortTVFavInfo = subject.getShortTVFavInfo()) == null) {
            return;
        }
        kotlinx.coroutines.k.d(u0.a(this), null, null, new ShortTvDownloadViewModel$favorite$1(subject, shortTVFavInfo.getHasFavorite(), this, shortTVFavInfo, null), 3, null);
    }

    public final void i(String subjectId, int i11, int i12) {
        Intrinsics.h(subjectId, "subjectId");
        kotlinx.coroutines.k.d(u0.a(this), y0.b(), null, new ShortTvDownloadViewModel$getEpisodeList$1(this, subjectId, i11, i12, null), 2, null);
    }

    public final b0 j() {
        return this.f53727j;
    }

    public final b0 l() {
        return this.f53725h;
    }

    public final b0 m() {
        return this.f53724g;
    }

    public final void n(String subjectId, boolean z10) {
        Intrinsics.h(subjectId, "subjectId");
        kotlinx.coroutines.k.d(u0.a(this), y0.b(), null, new ShortTvDownloadViewModel$getShortTvInfo$1(subjectId, this, z10, null), 2, null);
    }

    public final b0 p() {
        return this.f53726i;
    }

    public final b0 q() {
        return this.f53720c;
    }

    public final b0 r() {
        return this.f53721d;
    }

    public final void s(int i11) {
        Subject subject = (Subject) this.f53726i.f();
        if (subject != null) {
            subject.setPaid(i11);
        }
        this.f53726i.n(subject);
    }

    public final void t(String subjectId) {
        Set adUnlockedEps;
        Intrinsics.h(subjectId, "subjectId");
        a.C0856a c0856a = lg.a.f68962a;
        Subject subject = (Subject) this.f53726i.f();
        a.C0856a.r(c0856a, "ShortTvDownload", new String[]{"will saveAdUnlockedEps, eps: " + (subject != null ? subject.getAdUnlockedEps() : null)}, false, 4, null);
        Subject subject2 = (Subject) this.f53726i.f();
        if (subject2 == null || (adUnlockedEps = subject2.getAdUnlockedEps()) == null || adUnlockedEps.isEmpty()) {
            return;
        }
        kotlinx.coroutines.k.d(u0.a(this), null, null, new ShortTvDownloadViewModel$saveAdUnlockedEps$1(subjectId, adUnlockedEps, this, null), 3, null);
    }

    public final void v(js.d item) {
        Intrinsics.h(item, "item");
        Map map = (Map) this.f53720c.f();
        if (map == null) {
            map = new LinkedHashMap();
        }
        if (item.d()) {
            map.remove(Integer.valueOf(item.b()));
        } else {
            map.put(Integer.valueOf(item.b()), item);
        }
        this.f53720c.q(map);
    }

    public final void w(String str, List list) {
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        kotlinx.coroutines.k.d(u0.a(this), y0.b(), null, new ShortTvDownloadViewModel$startDownloadResource$1(list, this, str, null), 2, null);
    }
}
