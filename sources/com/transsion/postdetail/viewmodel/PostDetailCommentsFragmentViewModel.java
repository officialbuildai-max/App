package com.transsion.postdetail.viewmodel;

import androidx.view.b0;
import androidx.view.t0;
import androidx.view.u0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class PostDetailCommentsFragmentViewModel extends t0 {

    /* renamed from: a, reason: collision with root package name */
    private final Lazy f50261a = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.viewmodel.c
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            xo.a d11;
            d11 = PostDetailCommentsFragmentViewModel.d();
            return d11;
        }
    });

    /* renamed from: b, reason: collision with root package name */
    private final b0 f50262b = new b0();

    /* JADX INFO: Access modifiers changed from: private */
    public static final xo.a d() {
        return (xo.a) zg.c.f79537e.a().h(xo.a.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final xo.a f() {
        return (xo.a) this.f50261a.getValue();
    }

    public final void e(String postId, String rootCommentId, String page, int i11) {
        Intrinsics.h(postId, "postId");
        Intrinsics.h(rootCommentId, "rootCommentId");
        Intrinsics.h(page, "page");
        kotlinx.coroutines.k.d(u0.a(this), null, null, new PostDetailCommentsFragmentViewModel$getCommentList$1(this, postId, rootCommentId, page, i11, null), 3, null);
    }

    public final b0 g() {
        return this.f50262b;
    }
}
