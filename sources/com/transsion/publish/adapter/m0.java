package com.transsion.publish.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.publish.R$id;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class m0 extends RecyclerView.b0 {

    /* renamed from: a, reason: collision with root package name */
    private ImageView f50461a;

    /* renamed from: b, reason: collision with root package name */
    private View f50462b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f50463c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f50464d;

    /* renamed from: e, reason: collision with root package name */
    private View f50465e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m0(View itemView) {
        super(itemView);
        Intrinsics.h(itemView, "itemView");
        View findViewById = itemView.findViewById(R$id.sv_item_cover);
        Intrinsics.g(findViewById, "findViewById(...)");
        this.f50461a = (ImageView) findViewById;
        View findViewById2 = itemView.findViewById(R$id.sv_item_layer);
        Intrinsics.g(findViewById2, "findViewById(...)");
        this.f50462b = findViewById2;
        View findViewById3 = itemView.findViewById(R$id.sv_item_duration);
        Intrinsics.g(findViewById3, "findViewById(...)");
        this.f50463c = (TextView) findViewById3;
        View findViewById4 = itemView.findViewById(R$id.tv_select);
        Intrinsics.g(findViewById4, "findViewById(...)");
        this.f50464d = (TextView) findViewById4;
        View findViewById5 = itemView.findViewById(R$id.rl_select);
        Intrinsics.g(findViewById5, "findViewById(...)");
        this.f50465e = findViewById5;
    }

    public final ImageView f() {
        return this.f50461a;
    }

    public final View g() {
        return this.f50462b;
    }

    public final View h() {
        return this.f50465e;
    }

    public final TextView i() {
        return this.f50463c;
    }

    public final TextView j() {
        return this.f50464d;
    }
}
