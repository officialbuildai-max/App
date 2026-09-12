package com.transsion.postdetail.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.recyclerview.widget.RecyclerView;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.R$drawable;
import com.transsion.postdetail.bean.ReportReason;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import so.x;

/* loaded from: classes6.dex */
public final class h extends RecyclerView.Adapter {

    /* renamed from: d, reason: collision with root package name */
    public static final a f49454d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final List f49455a;

    /* renamed from: b, reason: collision with root package name */
    private Integer f49456b;

    /* renamed from: c, reason: collision with root package name */
    private Function1 f49457c;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public final class b extends RecyclerView.b0 {

        /* renamed from: a, reason: collision with root package name */
        private final x f49458a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ h f49459b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(h hVar, x binding) {
            super(binding.getRoot());
            Intrinsics.h(binding, "binding");
            this.f49459b = hVar;
            this.f49458a = binding;
        }

        public final x f() {
            return this.f49458a;
        }
    }

    public h(List reasons) {
        Intrinsics.h(reasons, "reasons");
        this.f49455a = reasons;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(h hVar, int i11, x xVar, View view) {
        int intValue;
        Integer num = hVar.f49456b;
        Integer valueOf = (num != null && num.intValue() == i11) ? null : Integer.valueOf(i11);
        hVar.f49456b = valueOf;
        xVar.f75883b.setSelected(valueOf != null && valueOf.intValue() == i11);
        if (num != null && (intValue = num.intValue()) != i11) {
            hVar.notifyItemChanged(intValue, "selection_changed");
        }
        Function1 function1 = hVar.f49457c;
        if (function1 != null) {
            Integer num2 = hVar.f49456b;
            function1.invoke(num2 != null ? (ReportReason) hVar.f49455a.get(num2.intValue()) : null);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f49455a.size();
    }

    public final Integer h() {
        return this.f49456b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b holder, final int i11) {
        Intrinsics.h(holder, "holder");
        ReportReason reportReason = (ReportReason) this.f49455a.get(i11);
        Integer num = this.f49456b;
        boolean z10 = num != null && num.intValue() == i11;
        final x f11 = holder.f();
        f11.f75884c.setText(reportReason.getTitle());
        f11.f75883b.setSelected(z10);
        if (i11 == this.f49455a.size() - 1) {
            f11.getRoot().setBackgroundResource(R$drawable.bg_radius_bottom_6_color_white_6p);
        } else if (i11 == 0) {
            f11.getRoot().setBackgroundResource(R$drawable.bg_radius_top_6_color_white_6p);
        } else {
            f11.getRoot().setBackgroundResource(R$color.white_6);
        }
        f11.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.adapter.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.k(h.this, i11, f11, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b holder, int i11, List payloads) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(payloads, "payloads");
        if (payloads.isEmpty()) {
            super.onBindViewHolder(holder, i11, payloads);
            return;
        }
        AppCompatCheckBox appCompatCheckBox = holder.f().f75883b;
        Integer num = this.f49456b;
        appCompatCheckBox.setSelected(num != null && num.intValue() == i11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup parent, int i11) {
        Intrinsics.h(parent, "parent");
        x c11 = x.c(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.g(c11, "inflate(...)");
        return new b(this, c11);
    }

    public final void m(Function1 function1) {
        this.f49457c = function1;
    }
}
