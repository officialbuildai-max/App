package ro;

import android.text.Editable;
import com.transsion.moviedetailapi.bean.CommentBean;
import com.transsion.postdetail.comment.i0;

/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private int f74713a = 300;

    /* renamed from: b, reason: collision with root package name */
    private i0 f74714b;

    /* renamed from: c, reason: collision with root package name */
    private Editable f74715c;

    /* renamed from: d, reason: collision with root package name */
    private CommentBean f74716d;

    public final i0 a() {
        return this.f74714b;
    }

    public final Editable b() {
        return this.f74715c;
    }

    public final int c() {
        return this.f74713a;
    }

    public final CommentBean d() {
        return this.f74716d;
    }

    public final void e() {
        this.f74716d = null;
        this.f74715c = null;
    }

    public final void f(i0 i0Var) {
        this.f74714b = i0Var;
    }

    public final void g(Editable editable) {
        this.f74715c = editable;
    }

    public final void h(int i11) {
        this.f74713a = i11;
    }

    public final void i(CommentBean commentBean) {
        this.f74716d = commentBean;
    }
}
