package com.transsion.usercenter.setting.labelsfeedback;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import fw.h0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class j extends RecyclerView.Adapter {

    /* loaded from: classes7.dex */
    public final class a extends RecyclerView.b0 {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ j f57572a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(j jVar, h0 binding) {
            super(binding.getRoot());
            Intrinsics.h(binding, "binding");
            this.f57572a = jVar;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a holder, int i11) {
        Intrinsics.h(holder, "holder");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup parent, int i11) {
        Intrinsics.h(parent, "parent");
        h0 c11 = h0.c(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.g(c11, "inflate(...)");
        return new a(this, c11);
    }
}
