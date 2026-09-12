package com.transsion.usercenter.setting.labelsfeedback;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.R$drawable;
import com.transsion.usercenter.setting.labelsfeedback.model.FbDataModel;
import com.transsion.usercenter.setting.labelsfeedback.model.FbOption;
import fw.f0;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class c extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    private final FbDataModel f57547a;

    /* renamed from: b, reason: collision with root package name */
    private d f57548b;

    /* renamed from: c, reason: collision with root package name */
    private zw.a f57549c;

    /* loaded from: classes7.dex */
    public final class a extends RecyclerView.b0 {

        /* renamed from: a, reason: collision with root package name */
        private final ConstraintLayout f57550a;

        /* renamed from: b, reason: collision with root package name */
        private final AppCompatTextView f57551b;

        /* renamed from: c, reason: collision with root package name */
        private final AppCompatCheckBox f57552c;

        /* renamed from: d, reason: collision with root package name */
        private final View f57553d;

        /* renamed from: e, reason: collision with root package name */
        private final View f57554e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ c f57555f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c cVar, f0 binding) {
            super(binding.getRoot());
            Intrinsics.h(binding, "binding");
            this.f57555f = cVar;
            ConstraintLayout root = binding.getRoot();
            Intrinsics.g(root, "getRoot(...)");
            this.f57550a = root;
            AppCompatTextView textView = binding.f62777e;
            Intrinsics.g(textView, "textView");
            this.f57551b = textView;
            AppCompatCheckBox radioButton = binding.f62776d;
            Intrinsics.g(radioButton, "radioButton");
            this.f57552c = radioButton;
            View bgView = binding.f62774b;
            Intrinsics.g(bgView, "bgView");
            this.f57553d = bgView;
            View divider = binding.f62775c;
            Intrinsics.g(divider, "divider");
            this.f57554e = divider;
        }

        public final View f() {
            return this.f57553d;
        }

        public final View g() {
            return this.f57554e;
        }

        public final AppCompatCheckBox h() {
            return this.f57552c;
        }

        public final AppCompatTextView i() {
            return this.f57551b;
        }
    }

    public c(FbDataModel model) {
        Intrinsics.h(model, "model");
        this.f57547a = model;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(int i11, c cVar, View view) {
        Set h11 = SetsKt.h(Integer.valueOf(i11));
        Integer selectedIndex = cVar.f57547a.getSelectedIndex();
        if (selectedIndex != null) {
            h11.add(Integer.valueOf(selectedIndex.intValue()));
        }
        FbDataModel fbDataModel = cVar.f57547a;
        Integer selectedIndex2 = fbDataModel.getSelectedIndex();
        fbDataModel.setSelectedIndex((selectedIndex2 != null && selectedIndex2.intValue() == i11) ? null : Integer.valueOf(i11));
        Iterator it = h11.iterator();
        while (it.hasNext()) {
            cVar.notifyItemChanged(((Number) it.next()).intValue());
        }
        cVar.f57547a.setSelectedId(null);
        Integer selectedIndex3 = cVar.f57547a.getSelectedIndex();
        if (selectedIndex3 != null) {
            int intValue = selectedIndex3.intValue();
            FbDataModel fbDataModel2 = cVar.f57547a;
            fbDataModel2.setSelectedId(Integer.valueOf(fbDataModel2.getOptions().get(intValue).getId()));
        }
        d dVar = cVar.f57548b;
        if (dVar != null) {
            dVar.m(cVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f57547a.getOptions().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i11) {
        return super.getItemViewType(i11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a holder, final int i11) {
        int i12;
        Intrinsics.h(holder, "holder");
        FbOption fbOption = this.f57547a.getOptions().get(i11);
        Integer selectedIndex = this.f57547a.getSelectedIndex();
        boolean z10 = selectedIndex != null && selectedIndex.intValue() == i11;
        holder.i().setText(fbOption.getName());
        holder.h().setChecked(z10);
        View f11 = holder.f();
        if (i11 == 0) {
            jg.c.g(holder.g());
            i12 = R$drawable.bg_radius_top_6_color_white_6p;
        } else {
            i12 = i11 == this.f57547a.getOptions().size() - 1 ? R$drawable.bg_radius_bottom_6_color_white_6p : R$color.white_6;
        }
        f11.setBackgroundResource(i12);
        holder.i().setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.setting.labelsfeedback.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.i(i11, this, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup parent, int i11) {
        Intrinsics.h(parent, "parent");
        f0 c11 = f0.c(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.g(c11, "inflate(...)");
        return new a(this, c11);
    }

    public final void k(zw.a aVar) {
        this.f57549c = aVar;
    }

    public final void l(d dVar) {
        this.f57548b = dVar;
    }
}
