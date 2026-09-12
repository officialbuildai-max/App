package com.transsnet.login.interest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsnet.login.R$id;
import com.transsnet.login.R$layout;
import com.transsnet.login.R$mipmap;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class f extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    private final List f60503a;

    /* renamed from: b, reason: collision with root package name */
    private final Function1 f60504b;

    /* renamed from: c, reason: collision with root package name */
    private final ArrayList f60505c;

    /* renamed from: d, reason: collision with root package name */
    private final ArrayList f60506d;

    /* loaded from: classes7.dex */
    public static final class a extends RecyclerView.b0 {

        /* renamed from: a, reason: collision with root package name */
        private final AppCompatTextView f60507a;

        /* renamed from: b, reason: collision with root package name */
        private final AppCompatImageView f60508b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            Intrinsics.h(view, "view");
            View findViewById = view.findViewById(R$id.tv_interest);
            Intrinsics.g(findViewById, "findViewById(...)");
            this.f60507a = (AppCompatTextView) findViewById;
            View findViewById2 = view.findViewById(R$id.iv_interest);
            Intrinsics.g(findViewById2, "findViewById(...)");
            this.f60508b = (AppCompatImageView) findViewById2;
        }

        public final AppCompatImageView f() {
            return this.f60508b;
        }

        public final AppCompatTextView g() {
            return this.f60507a;
        }
    }

    public f(List dataList, Function1 listener) {
        Intrinsics.h(dataList, "dataList");
        Intrinsics.h(listener, "listener");
        this.f60503a = dataList;
        this.f60504b = listener;
        this.f60505c = new ArrayList();
        this.f60506d = CollectionsKt.h(Integer.valueOf(R$mipmap.login_interest_animal_plant), Integer.valueOf(R$mipmap.login_interest_sport), Integer.valueOf(R$mipmap.login_interest_food), Integer.valueOf(R$mipmap.login_interest_game), Integer.valueOf(R$mipmap.login_interest_transportation), Integer.valueOf(R$mipmap.login_interest_fitness), Integer.valueOf(R$mipmap.login_interest_music), Integer.valueOf(R$mipmap.login_interest_animation), Integer.valueOf(R$mipmap.login_interest_art), Integer.valueOf(R$mipmap.login_interest_travel), Integer.valueOf(R$mipmap.login_interest_comedy), Integer.valueOf(R$mipmap.login_interest_fashion));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(f fVar, int i11, View view) {
        boolean isSelected = view.isSelected();
        boolean z10 = !isSelected;
        if (isSelected) {
            fVar.f60505c.remove(Integer.valueOf(i11));
        } else {
            fVar.f60505c.add(Integer.valueOf(i11));
        }
        view.setSelected(z10);
        fVar.f60504b.invoke(fVar.f60505c);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f60503a.size();
    }

    public final List h() {
        return this.f60505c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a holder, final int i11) {
        Intrinsics.h(holder, "holder");
        holder.g().setText((String) this.f60503a.get(i11));
        AppCompatImageView f11 = holder.f();
        Object obj = this.f60506d.get(i11);
        Intrinsics.g(obj, "get(...)");
        f11.setImageResource(((Number) obj).intValue());
        holder.itemView.setSelected(this.f60505c.contains(Integer.valueOf(i11)));
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.login.interest.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.j(f.this, i11, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup parent, int i11) {
        Intrinsics.h(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R$layout.login_item_interest, parent, false);
        Intrinsics.g(inflate, "inflate(...)");
        return new a(inflate);
    }
}
