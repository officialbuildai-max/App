package com.transsion.postdetail.viewmodel;

import android.net.Uri;
import android.text.TextUtils;
import androidx.view.LiveData;
import androidx.view.b0;
import androidx.view.t0;
import androidx.view.u0;
import bh.b;
import com.transsion.publish.R$string;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.RequestBody;

/* loaded from: classes6.dex */
public final class PostRecommendFragmentViewModel extends t0 {

    /* renamed from: d, reason: collision with root package name */
    public static final a f50277d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final Lazy f50278a = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.viewmodel.l
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            xo.b j11;
            j11 = PostRecommendFragmentViewModel.j();
            return j11;
        }
    });

    /* renamed from: b, reason: collision with root package name */
    private final b0 f50279b = new b0();

    /* renamed from: c, reason: collision with root package name */
    private final Lazy f50280c = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.viewmodel.m
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            b0 f11;
            f11 = PostRecommendFragmentViewModel.f();
            return f11;
        }
    });

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 f() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final xo.b i() {
        return (xo.b) this.f50278a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final xo.b j() {
        return (xo.b) zg.c.f79537e.a().h(xo.b.class);
    }

    public final void g(String postId, int i11, int i12, int i13) {
        String str;
        Intrinsics.h(postId, "postId");
        if (TextUtils.isEmpty(postId)) {
            return;
        }
        if (!nh.m.f70597a.e()) {
            uh.b.f76876a.d(R$string.upload_no_network);
            this.f50279b.n(null);
            return;
        }
        ImmVideoRequestEntity immVideoRequestEntity = new ImmVideoRequestEntity();
        immVideoRequestEntity.setPage(String.valueOf(i12));
        immVideoRequestEntity.setPerPage(i13);
        immVideoRequestEntity.setSessionId(yg.b.f79132a.h());
        Uri c11 = com.transsion.baselib.report.h.f43402a.c();
        if (c11 == null || (str = c11.toString()) == null) {
            str = "";
        }
        immVideoRequestEntity.setDeepLink(str);
        immVideoRequestEntity.setUserPrefer("");
        immVideoRequestEntity.setLatest_events(wj.b.f77816a.e());
        immVideoRequestEntity.setPostId(postId);
        immVideoRequestEntity.setTabId(i11);
        b.a aVar = bh.b.f16553a;
        String j11 = com.blankj.utilcode.util.o.j(immVideoRequestEntity);
        Intrinsics.g(j11, "toJson(...)");
        RequestBody a11 = aVar.a(j11);
        if (a11 != null) {
            kotlinx.coroutines.k.d(u0.a(this), null, null, new PostRecommendFragmentViewModel$getImmVideoList$1$1(this, a11, null), 3, null);
        }
    }

    public final LiveData h() {
        return this.f50279b;
    }
}
