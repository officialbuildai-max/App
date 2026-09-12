package kr;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.a0;
import com.blankj.utilcode.util.y;
import com.transsion.share.R$id;
import com.transsion.share.R$layout;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class c extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    private List f68494a;

    /* renamed from: b, reason: collision with root package name */
    private kr.a f68495b;

    /* loaded from: classes7.dex */
    public static final class a extends RecyclerView.b0 {

        /* renamed from: a, reason: collision with root package name */
        private TextView f68496a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            Intrinsics.h(view, "view");
            View findViewById = this.itemView.findViewById(R$id.tv_share);
            Intrinsics.g(findViewById, "findViewById(...)");
            this.f68496a = (TextView) findViewById;
        }

        public final TextView f() {
            return this.f68496a;
        }
    }

    public c(List mDatas) {
        Intrinsics.h(mDatas, "mDatas");
        this.f68494a = mDatas;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(c cVar, jr.a aVar, View view) {
        kr.a aVar2;
        if (o.e(o.f68507a, view.hashCode(), 0L, 2, null) || (aVar2 = cVar.f68495b) == null) {
            return;
        }
        aVar2.a(aVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f68494a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a holder, int i11) {
        Intrinsics.h(holder, "holder");
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        Intrinsics.f(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        RecyclerView.n nVar = (RecyclerView.n) layoutParams;
        int e11 = (y.e() - a0.a(286.0f)) / 4;
        if (i11 == 0) {
            nVar.setMarginStart(a0.a(16.0f));
            nVar.setMarginEnd(e11);
        } else if (i11 == getItemCount() - 1) {
            nVar.setMarginStart(0);
            nVar.setMarginEnd(a0.a(16.0f));
        } else {
            nVar.setMarginStart(0);
            nVar.setMarginEnd(e11);
        }
        final jr.a aVar = (jr.a) this.f68494a.get(i11);
        holder.f().setText(aVar.b());
        holder.f().setCompoundDrawablesRelativeWithIntrinsicBounds(0, aVar.a(), 0, 0);
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: kr.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.i(c.this, aVar, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup parent, int i11) {
        Intrinsics.h(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R$layout.adapter_share, parent, false);
        Intrinsics.e(inflate);
        return new a(inflate);
    }

    public final void k(kr.a onItemClickListener) {
        Intrinsics.h(onItemClickListener, "onItemClickListener");
        this.f68495b = onItemClickListener;
    }
}
