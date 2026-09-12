package com.transsion.postdetail.comment;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.view.Window;
import android.view.WindowManager;
import com.transsion.moviedetailapi.bean.CommentBean;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.R$style;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class g extends androidx.appcompat.app.w {

    /* renamed from: a, reason: collision with root package name */
    private m f48794a;

    /* renamed from: b, reason: collision with root package name */
    private ro.a f48795b;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final Context f48796a;

        /* renamed from: b, reason: collision with root package name */
        private ro.a f48797b;

        public a(Context context) {
            Intrinsics.h(context, "context");
            this.f48796a = context;
            this.f48797b = new ro.a();
        }

        public final g a() {
            g gVar = new g(this.f48796a, null);
            gVar.k(this.f48797b);
            return gVar;
        }

        public final a b(Editable editable) {
            ro.a aVar = this.f48797b;
            if (aVar != null) {
                aVar.g(editable);
            }
            return this;
        }

        public final a c(i0 i0Var) {
            ro.a aVar = this.f48797b;
            if (aVar != null) {
                aVar.f(i0Var);
            }
            return this;
        }

        public final a d(int i11) {
            ro.a aVar = this.f48797b;
            if (aVar != null) {
                aVar.h(i11);
            }
            return this;
        }

        public final a e(CommentBean commentBean) {
            ro.a aVar = this.f48797b;
            if (aVar != null) {
                aVar.i(commentBean);
            }
            return this;
        }
    }

    private g(Context context) {
        super(context, R$style.CommentEditInputDialogTheme);
        setContentView(R$layout.dialog_comment_input_edit);
        setCancelable(true);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(80);
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (attributes != null) {
                if (attributes.width != -1) {
                    attributes.width = -1;
                }
                if (attributes.height != -2) {
                    attributes.height = -2;
                }
                window.setAttributes(attributes);
                window.setSoftInputMode(4);
            }
        }
        this.f48794a = new m(null, this, null, true, 5, null);
    }

    public /* synthetic */ g(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    private final void i() {
        m mVar = this.f48794a;
        if (mVar != null) {
            mVar.k(this.f48795b);
        }
        m mVar2 = this.f48794a;
        if (mVar2 != null) {
            mVar2.B();
        }
    }

    private final void m() {
        m mVar = this.f48794a;
        if (mVar != null) {
            mVar.z();
        }
    }

    public final void f() {
        m mVar = this.f48794a;
        if (mVar != null) {
            mVar.g();
        }
    }

    public final ro.a g() {
        return this.f48795b;
    }

    public final m h() {
        return this.f48794a;
    }

    public final void j(Editable editable) {
        ro.a aVar = this.f48795b;
        if (aVar != null) {
            aVar.g(editable);
        }
    }

    public final void k(ro.a aVar) {
        this.f48795b = aVar;
    }

    public final void l() {
        m mVar = this.f48794a;
        if (mVar != null) {
            mVar.y();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.w, androidx.activity.q, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.q, android.app.Dialog
    public void onStart() {
        super.onStart();
        i();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.w, androidx.activity.q, android.app.Dialog
    public void onStop() {
        super.onStop();
        m();
    }
}
