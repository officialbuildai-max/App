package com.transsion.publish.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.publish.R$id;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class f0 extends RecyclerView.b0 {

    /* renamed from: a, reason: collision with root package name */
    private ImageView f50413a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f50414b;

    /* renamed from: c, reason: collision with root package name */
    private View f50415c;

    /* renamed from: d, reason: collision with root package name */
    private View f50416d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(View itemView) {
        super(itemView);
        Intrinsics.h(itemView, "itemView");
        View findViewById = itemView.findViewById(R$id.sv_item_cover);
        Intrinsics.g(findViewById, "findViewById(...)");
        this.f50413a = (ImageView) findViewById;
        View findViewById2 = itemView.findViewById(R$id.tv_select);
        Intrinsics.g(findViewById2, "findViewById(...)");
        this.f50414b = (TextView) findViewById2;
        View findViewById3 = itemView.findViewById(R$id.view_masking);
        Intrinsics.g(findViewById3, "findViewById(...)");
        this.f50415c = findViewById3;
        View findViewById4 = itemView.findViewById(R$id.rl_select);
        Intrinsics.g(findViewById4, "findViewById(...)");
        this.f50416d = findViewById4;
    }

    public final ImageView f() {
        return this.f50413a;
    }

    public final View g() {
        return this.f50416d;
    }

    public final TextView h() {
        return this.f50414b;
    }

    public final View i() {
        return this.f50415c;
    }
}
