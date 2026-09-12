package com.transsnet.downloader.manager;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.blankj.utilcode.util.a0;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class u {

    /* renamed from: c, reason: collision with root package name */
    public static final a f59626c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private boolean f59627a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f59628b;

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public u() {
        this.f59627a = true;
        this.f59627a = ti.b.f76376a.c();
    }

    private final View c(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R$layout.layout_downloading_play_guide, (ViewGroup) null);
        Intrinsics.g(inflate, "inflate(...)");
        return inflate;
    }

    private final void e(FrameLayout frameLayout, View view) {
        int a11 = a0.a(106.0f);
        int a12 = a0.a(16.0f);
        Context context = view.getContext();
        Intrinsics.f(context, "null cannot be cast to non-null type android.app.Activity");
        final View c11 = c((Activity) context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a0.a(230.0f), -2);
        layoutParams.topMargin = a11;
        layoutParams.setMarginStart(a12);
        frameLayout.addView(c11, layoutParams);
        c11.postDelayed(new Runnable() { // from class: com.transsnet.downloader.manager.s
            @Override // java.lang.Runnable
            public final void run() {
                u.f(c11);
            }
        }, 3000L);
        c11.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.manager.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                u.g(c11, view2);
            }
        });
        this.f59627a = false;
        ti.b.f76376a.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(View view) {
        if (view.getParent() != null) {
            ViewParent parent = view.getParent();
            Intrinsics.f(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeView(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(View view, View view2) {
        if (view.getParent() != null) {
            ViewParent parent = view.getParent();
            Intrinsics.f(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeView(view);
        }
    }

    public final void d(FrameLayout fragmentRootView, BaseViewHolder holder, long j11) {
        View viewOrNull;
        Intrinsics.h(fragmentRootView, "fragmentRootView");
        Intrinsics.h(holder, "holder");
        if (this.f59627a && !this.f59628b && (viewOrNull = holder.getViewOrNull(R$id.iv_cover)) != null && jg.c.i(viewOrNull)) {
            this.f59628b = true;
            e(fragmentRootView, viewOrNull);
        }
    }
}
