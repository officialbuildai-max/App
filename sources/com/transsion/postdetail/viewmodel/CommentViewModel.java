package com.transsion.postdetail.viewmodel;

import android.app.Application;
import androidx.view.b0;
import androidx.view.u0;
import com.transsion.postdetail.bean.CommentBody;
import com.transsion.postdetail.bean.CommentLikeBody;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes6.dex */
public final class CommentViewModel extends androidx.view.b {

    /* renamed from: i, reason: collision with root package name */
    public static final a f50240i = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private final b0 f50241b;

    /* renamed from: c, reason: collision with root package name */
    private final b0 f50242c;

    /* renamed from: d, reason: collision with root package name */
    private final b0 f50243d;

    /* renamed from: e, reason: collision with root package name */
    private final b0 f50244e;

    /* renamed from: f, reason: collision with root package name */
    private final b0 f50245f;

    /* renamed from: g, reason: collision with root package name */
    private final b0 f50246g;

    /* renamed from: h, reason: collision with root package name */
    private final Lazy f50247h;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommentViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.f50241b = new b0();
        this.f50242c = new b0();
        this.f50243d = new b0();
        this.f50244e = new b0();
        this.f50245f = new b0();
        this.f50246g = new b0();
        this.f50247h = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.viewmodel.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                xo.a f11;
                f11 = CommentViewModel.f();
                return f11;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final xo.a f() {
        return (xo.a) zg.c.f79537e.a().h(xo.a.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final xo.a i() {
        return (xo.a) this.f50247h.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(String str) {
        a.C0856a.f(lg.a.f68962a, "CommentViewModel", str, false, 4, null);
    }

    public final void g(String topicType, String commentId) {
        Intrinsics.h(topicType, "topicType");
        Intrinsics.h(commentId, "commentId");
        kotlinx.coroutines.k.d(u0.a(this), null, null, new CommentViewModel$deleteComment$1(topicType, this, commentId, null), 3, null);
    }

    public final void h(String postId, String topicType, String rootCommentId, String page, int i11, String locCommentId) {
        Intrinsics.h(postId, "postId");
        Intrinsics.h(topicType, "topicType");
        Intrinsics.h(rootCommentId, "rootCommentId");
        Intrinsics.h(page, "page");
        Intrinsics.h(locCommentId, "locCommentId");
        kotlinx.coroutines.k.d(u0.a(this), null, null, new CommentViewModel$getCommentList$1(this, postId, topicType, rootCommentId, page, locCommentId, i11, null), 3, null);
    }

    public final b0 j() {
        return this.f50245f;
    }

    public final b0 k() {
        return this.f50242c;
    }

    public final b0 l() {
        return this.f50243d;
    }

    public final b0 m() {
        return this.f50244e;
    }

    public final b0 n() {
        return this.f50241b;
    }

    public final b0 o() {
        return this.f50246g;
    }

    public final void p(qo.a info, String topicType, String page, int i11) {
        Intrinsics.h(info, "info");
        Intrinsics.h(topicType, "topicType");
        Intrinsics.h(page, "page");
        kotlinx.coroutines.k.d(u0.a(this), null, null, new CommentViewModel$getSubCommentList$1(this, info, topicType, page, i11, null), 3, null);
    }

    public final void q(CommentLikeBody commentBody) {
        Intrinsics.h(commentBody, "commentBody");
        kotlinx.coroutines.k.d(u0.a(this), null, null, new CommentViewModel$likeComment$1(commentBody, this, null), 3, null);
    }

    public final void s(String topicType, CommentBody commentBody) {
        Intrinsics.h(topicType, "topicType");
        Intrinsics.h(commentBody, "commentBody");
        kotlinx.coroutines.k.d(u0.a(this), null, null, new CommentViewModel$postComment$1(commentBody, topicType, this, null), 3, null);
    }

    public final void t(String commentId) {
        Intrinsics.h(commentId, "commentId");
        this.f50246g.q(commentId);
    }
}
