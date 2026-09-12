package com.transsion.postdetail.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;
import so.v;

/* loaded from: classes6.dex */
public final class d extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    private final String f49441a;

    /* loaded from: classes6.dex */
    public final class a extends RecyclerView.b0 {

        /* renamed from: a, reason: collision with root package name */
        private final v f49442a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f49443b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d dVar, v binding) {
            super(binding.getRoot());
            Intrinsics.h(binding, "binding");
            this.f49443b = dVar;
            this.f49442a = binding;
        }

        public final v f() {
            return this.f49442a;
        }
    }

    public d(String str) {
        this.f49441a = str;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a holder, int i11) {
        Intrinsics.h(holder, "holder");
        holder.f().f75855b.setText(this.f49441a);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup parent, int i11) {
        Intrinsics.h(parent, "parent");
        v c11 = v.c(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.g(c11, "inflate(...)");
        return new a(this, c11);
    }
}
