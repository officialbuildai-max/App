package com.transsion.wrapperad.view.cardpage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.wrapperad.R$id;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class e extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    private List f58464a;

    /* renamed from: b, reason: collision with root package name */
    private final int f58465b;

    /* loaded from: classes7.dex */
    public static final class a extends RecyclerView.b0 {

        /* renamed from: a, reason: collision with root package name */
        private final CardView f58466a;

        /* renamed from: b, reason: collision with root package name */
        private final FrameLayout f58467b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View itemView) {
            super(itemView);
            Intrinsics.h(itemView, "itemView");
            View findViewById = itemView.findViewById(R$id.cardView);
            Intrinsics.g(findViewById, "findViewById(...)");
            this.f58466a = (CardView) findViewById;
            View findViewById2 = itemView.findViewById(R$id.ad_container);
            Intrinsics.g(findViewById2, "findViewById(...)");
            this.f58467b = (FrameLayout) findViewById2;
        }

        public final Object f(f pageData) {
            Object m1185constructorimpl;
            Intrinsics.h(pageData, "pageData");
            try {
                Result.Companion companion = Result.INSTANCE;
                NativeCardPageAdHelper c11 = pageData.c();
                if (c11 != null) {
                    c11.w(pageData);
                }
                ViewParent parent = pageData.d().getParent();
                ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                if (viewGroup != null) {
                    viewGroup.removeView(pageData.d());
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                pageData.d().setAlpha(0.0f);
                pageData.d().setScaleX(1.05f);
                this.f58467b.addView(pageData.d(), layoutParams);
                pageData.d().animate().alpha(1.0f).scaleX(1.0f).setDuration(600L).setListener(null).start();
                NativeCardPageAdHelper c12 = pageData.c();
                if (c12 != null) {
                    c12.s(pageData);
                }
                m1185constructorimpl = Result.m1185constructorimpl(Boolean.TRUE);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
            }
            Result.m1188exceptionOrNullimpl(m1185constructorimpl);
            return m1185constructorimpl;
        }

        public final FrameLayout g() {
            return this.f58467b;
        }

        public final CardView h() {
            return this.f58466a;
        }
    }

    public e(List pageItemDataList, int i11) {
        Intrinsics.h(pageItemDataList, "pageItemDataList");
        this.f58464a = pageItemDataList;
        this.f58465b = i11;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a holder, int i11) {
        Intrinsics.h(holder, "holder");
        holder.h().getLayoutParams().width = this.f58465b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f58464a.isEmpty() ? 0 : Integer.MAX_VALUE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup parent, int i11) {
        Intrinsics.h(parent, "parent");
        ey.c c11 = ey.c.c(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.g(c11, "inflate(...)");
        FrameLayout root = c11.getRoot();
        Intrinsics.g(root, "getRoot(...)");
        return new a(root);
    }
}
