package com.transsion.postdetail.viewmodel;

import android.net.Uri;
import androidx.view.LiveData;
import androidx.view.b0;
import androidx.view.t0;
import com.transsion.moviedetailapi.bean.ShortTVRespData;
import com.transsion.postdetail.ui.fragment.preload.ShortTvVideoImmersiveDataLoader;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class x extends t0 {

    /* renamed from: d, reason: collision with root package name */
    private ShortTvVideoImmersiveDataLoader f50329d;

    /* renamed from: a, reason: collision with root package name */
    private final String f50326a = "ShortTvDetailViewModel";

    /* renamed from: b, reason: collision with root package name */
    private final Lazy f50327b = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.viewmodel.r
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            xo.b t11;
            t11 = x.t();
            return t11;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    private final Lazy f50328c = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0() { // from class: com.transsion.postdetail.viewmodel.s
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            kn.a h11;
            h11 = x.h();
            return h11;
        }
    });

    /* renamed from: e, reason: collision with root package name */
    private final Lazy f50330e = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.viewmodel.t
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            b0 p11;
            p11 = x.p();
            return p11;
        }
    });

    /* renamed from: f, reason: collision with root package name */
    private final Lazy f50331f = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.viewmodel.u
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            b0 r11;
            r11 = x.r();
            return r11;
        }
    });

    /* renamed from: g, reason: collision with root package name */
    private final Lazy f50332g = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.viewmodel.v
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            b0 i11;
            i11 = x.i();
            return i11;
        }
    });

    /* renamed from: h, reason: collision with root package name */
    private final Lazy f50333h = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.viewmodel.w
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            b0 s11;
            s11 = x.s();
            return s11;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final kn.a h() {
        return (kn.a) zg.c.f79537e.a().h(kn.a.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 i() {
        return new b0();
    }

    private final b0 m() {
        return (b0) this.f50330e.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 p() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 r() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 s() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final xo.b t() {
        return (xo.b) zg.c.f79537e.a().h(xo.b.class);
    }

    public final b0 j() {
        return (b0) this.f50332g.getValue();
    }

    public final void k(String postId, int i11, String nextPage, int i12, int i13) {
        String str;
        Intrinsics.h(postId, "postId");
        Intrinsics.h(nextPage, "nextPage");
        ImmVideoRequestEntity immVideoRequestEntity = new ImmVideoRequestEntity();
        immVideoRequestEntity.setPage(nextPage);
        immVideoRequestEntity.setPerPage(i12);
        immVideoRequestEntity.setSessionId(yg.b.f79132a.h());
        Uri c11 = com.transsion.baselib.report.h.f43402a.c();
        if (c11 == null || (str = c11.toString()) == null) {
            str = "";
        }
        immVideoRequestEntity.setDeepLink(str);
        immVideoRequestEntity.setUserPrefer("");
        immVideoRequestEntity.setLatest_events(new wj.a(wj.b.f77816a.e()));
        if (postId.length() == 0) {
            postId = "0";
        }
        immVideoRequestEntity.setPostId(postId);
        immVideoRequestEntity.setTabId(i11);
        immVideoRequestEntity.setImmersiveRecType(i13);
        ShortTvVideoImmersiveDataLoader shortTvVideoImmersiveDataLoader = this.f50329d;
        if (shortTvVideoImmersiveDataLoader != null) {
            shortTvVideoImmersiveDataLoader.r(immVideoRequestEntity);
        }
        ShortTvVideoImmersiveDataLoader shortTvVideoImmersiveDataLoader2 = this.f50329d;
        if (shortTvVideoImmersiveDataLoader2 != null) {
            shortTvVideoImmersiveDataLoader2.f(m());
        }
    }

    public final LiveData l() {
        return m();
    }

    public final ShortTVRespData n() {
        ShortTvVideoImmersiveDataLoader shortTvVideoImmersiveDataLoader = this.f50329d;
        if (shortTvVideoImmersiveDataLoader != null) {
            return (ShortTVRespData) shortTvVideoImmersiveDataLoader.a();
        }
        return null;
    }

    public final b0 o() {
        return (b0) this.f50333h.getValue();
    }

    public final void q(Integer num) {
        List list;
        qm.b bVar;
        Object obj;
        if (num != null) {
            list = qm.e.f73767a.a(num.intValue());
        } else {
            list = null;
        }
        if (list != null) {
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it.next();
                    if (((qm.b) obj) instanceof ShortTvVideoImmersiveDataLoader) {
                        break;
                    }
                }
            }
            bVar = (qm.b) obj;
        } else {
            bVar = null;
        }
        ShortTvVideoImmersiveDataLoader shortTvVideoImmersiveDataLoader = (ShortTvVideoImmersiveDataLoader) bVar;
        if (shortTvVideoImmersiveDataLoader == null) {
            shortTvVideoImmersiveDataLoader = new ShortTvVideoImmersiveDataLoader(null, 1, null);
        }
        this.f50329d = shortTvVideoImmersiveDataLoader;
    }
}
