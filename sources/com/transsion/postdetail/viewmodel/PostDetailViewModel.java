package com.transsion.postdetail.viewmodel;

import android.text.TextUtils;
import androidx.view.LiveData;
import androidx.view.b0;
import androidx.view.t0;
import androidx.view.u0;
import com.transsion.moviedetailapi.bean.PostSubjectBean;
import com.transsion.postdetail.ui.fragment.preload.VideoDataLoader;
import com.transsion.postdetail.ui.fragment.preload.VideoImmersiveDataLoaderV2;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class PostDetailViewModel extends t0 {

    /* renamed from: d, reason: collision with root package name */
    private VideoDataLoader f50267d;

    /* renamed from: e, reason: collision with root package name */
    private VideoImmersiveDataLoaderV2 f50268e;

    /* renamed from: a, reason: collision with root package name */
    private final String f50264a = "PostDetailViewModel";

    /* renamed from: b, reason: collision with root package name */
    private final Lazy f50265b = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.viewmodel.d
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            xo.b L;
            L = PostDetailViewModel.L();
            return L;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    private final Lazy f50266c = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0() { // from class: com.transsion.postdetail.viewmodel.e
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            kn.a p11;
            p11 = PostDetailViewModel.p();
            return p11;
        }
    });

    /* renamed from: f, reason: collision with root package name */
    private final Lazy f50269f = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.viewmodel.f
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            b0 J;
            J = PostDetailViewModel.J();
            return J;
        }
    });

    /* renamed from: g, reason: collision with root package name */
    private final Lazy f50270g = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.viewmodel.g
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            b0 I;
            I = PostDetailViewModel.I();
            return I;
        }
    });

    /* renamed from: h, reason: collision with root package name */
    private final Lazy f50271h = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.viewmodel.h
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            b0 E;
            E = PostDetailViewModel.E();
            return E;
        }
    });

    /* renamed from: i, reason: collision with root package name */
    private final Lazy f50272i = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.viewmodel.i
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            b0 H;
            H = PostDetailViewModel.H();
            return H;
        }
    });

    /* renamed from: j, reason: collision with root package name */
    private final Lazy f50273j = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.viewmodel.j
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            b0 q11;
            q11 = PostDetailViewModel.q();
            return q11;
        }
    });

    /* renamed from: k, reason: collision with root package name */
    private final Lazy f50274k = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.viewmodel.k
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            b0 K;
            K = PostDetailViewModel.K();
            return K;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public final xo.b D() {
        return (xo.b) this.f50265b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 E() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 H() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 I() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 J() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 K() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final xo.b L() {
        return (xo.b) zg.c.f79537e.a().h(xo.b.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kn.a p() {
        return (kn.a) zg.c.f79537e.a().h(kn.a.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 q() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kn.a s() {
        return (kn.a) this.f50266c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b0 w() {
        return (b0) this.f50271h.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b0 z() {
        return (b0) this.f50269f.getValue();
    }

    public final LiveData A() {
        return z();
    }

    public final PostSubjectBean B() {
        VideoImmersiveDataLoaderV2 videoImmersiveDataLoaderV2 = this.f50268e;
        if (videoImmersiveDataLoaderV2 != null) {
            return (PostSubjectBean) videoImmersiveDataLoaderV2.a();
        }
        return null;
    }

    public final b0 C() {
        return (b0) this.f50274k.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public final void F(Integer num, String str) {
        List list;
        qm.b bVar;
        Object obj;
        ?? r02 = 0;
        Object obj2 = null;
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
                    if (((qm.b) obj) instanceof VideoDataLoader) {
                        break;
                    }
                }
            }
            bVar = (qm.b) obj;
        } else {
            bVar = null;
        }
        VideoDataLoader videoDataLoader = (VideoDataLoader) bVar;
        if (videoDataLoader == null) {
            videoDataLoader = new VideoDataLoader(r02, 1, r02);
        }
        this.f50267d = videoDataLoader;
        if (list != null) {
            Iterator it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next = it2.next();
                if (((qm.b) next) instanceof VideoImmersiveDataLoaderV2) {
                    obj2 = next;
                    break;
                }
            }
            r02 = (qm.b) obj2;
        }
        VideoImmersiveDataLoaderV2 videoImmersiveDataLoaderV2 = (VideoImmersiveDataLoaderV2) r02;
        if (videoImmersiveDataLoaderV2 == null) {
            videoImmersiveDataLoaderV2 = new VideoImmersiveDataLoaderV2(str, null, null, 0, 14, null);
        }
        this.f50268e = videoImmersiveDataLoaderV2;
    }

    public void G(String str, int i11) {
        kotlinx.coroutines.k.d(u0.a(this), null, null, new PostDetailViewModel$like$1(str, i11, this, null), 3, null);
    }

    public final void r(String postId) {
        Intrinsics.h(postId, "postId");
        kotlinx.coroutines.k.d(u0.a(this), null, null, new PostDetailViewModel$deletePost$1(postId, this, null), 3, null);
    }

    public final b0 t() {
        return (b0) this.f50273j.getValue();
    }

    public final void u(String postId, int i11, String nextPage, int i12, boolean z10, int i13) {
        Intrinsics.h(postId, "postId");
        Intrinsics.h(nextPage, "nextPage");
        if (!z10) {
            kotlinx.coroutines.k.d(u0.a(this), null, null, new PostDetailViewModel$getImmVideoList$1(this, postId, null), 3, null);
            return;
        }
        VideoImmersiveDataLoaderV2 videoImmersiveDataLoaderV2 = this.f50268e;
        if (videoImmersiveDataLoaderV2 != null) {
            videoImmersiveDataLoaderV2.u(postId);
        }
        VideoImmersiveDataLoaderV2 videoImmersiveDataLoaderV22 = this.f50268e;
        if (videoImmersiveDataLoaderV22 != null) {
            videoImmersiveDataLoaderV22.s(nextPage);
        }
        VideoImmersiveDataLoaderV2 videoImmersiveDataLoaderV23 = this.f50268e;
        if (videoImmersiveDataLoaderV23 != null) {
            videoImmersiveDataLoaderV23.t(i12);
        }
        VideoImmersiveDataLoaderV2 videoImmersiveDataLoaderV24 = this.f50268e;
        if (videoImmersiveDataLoaderV24 != null) {
            videoImmersiveDataLoaderV24.f(w());
        }
    }

    public final LiveData v() {
        return w();
    }

    public final void x(String postId) {
        Intrinsics.h(postId, "postId");
        if (TextUtils.isEmpty(postId)) {
            return;
        }
        kotlinx.coroutines.k.d(u0.a(this), null, null, new PostDetailViewModel$getPostDetail$1(this, postId, null), 3, null);
    }

    public final b0 y() {
        return (b0) this.f50270g.getValue();
    }
}
