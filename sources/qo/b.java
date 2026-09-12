package qo;

import com.transsion.postdetail.bean.CommentListBean;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private a f73789a;

    /* renamed from: b, reason: collision with root package name */
    private CommentListBean f73790b;

    public b(a commentBean, CommentListBean commentListBean) {
        Intrinsics.h(commentBean, "commentBean");
        this.f73789a = commentBean;
        this.f73790b = commentListBean;
    }

    public final a a() {
        return this.f73789a;
    }

    public final CommentListBean b() {
        return this.f73790b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Intrinsics.c(this.f73789a, bVar.f73789a) && Intrinsics.c(this.f73790b, bVar.f73790b);
    }

    public int hashCode() {
        int hashCode = this.f73789a.hashCode() * 31;
        CommentListBean commentListBean = this.f73790b;
        return hashCode + (commentListBean == null ? 0 : commentListBean.hashCode());
    }

    public String toString() {
        return "SubCommentData(commentBean=" + this.f73789a + ", commentListBean=" + this.f73790b + ")";
    }
}
