package com.transsion.postdetail.comment.ui;

import android.app.Application;
import androidx.view.b0;
import androidx.view.u0;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;

/* loaded from: classes6.dex */
public final class CommentListViewModel extends androidx.view.b {

    /* renamed from: b, reason: collision with root package name */
    private final Lazy f48840b;

    /* renamed from: c, reason: collision with root package name */
    private final b0 f48841c;

    /* renamed from: d, reason: collision with root package name */
    private final List f48842d;

    /* renamed from: e, reason: collision with root package name */
    private String f48843e;

    /* renamed from: f, reason: collision with root package name */
    private int f48844f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f48845g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommentListViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.f48840b = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.comment.ui.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                xo.a j11;
                j11 = CommentListViewModel.j();
                return j11;
            }
        });
        this.f48841c = new b0();
        this.f48842d = new ArrayList();
        this.f48843e = "1";
        this.f48844f = 20;
        this.f48845g = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final xo.a j() {
        return (xo.a) zg.c.f79537e.a().h(xo.a.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final xo.a l() {
        return (xo.a) this.f48840b.getValue();
    }

    public final void k(boolean z10) {
        if (z10) {
            this.f48843e = "1";
            this.f48842d.clear();
            this.f48845g = true;
        }
        k.d(u0.a(this), null, null, new CommentListViewModel$getCommentList$1(this, null), 3, null);
    }

    public final b0 m() {
        return this.f48841c;
    }

    public final boolean n() {
        return this.f48845g;
    }
}
