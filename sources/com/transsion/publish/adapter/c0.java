package com.transsion.publish.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.publish.R$id;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class c0 extends RecyclerView.b0 {

    /* renamed from: a, reason: collision with root package name */
    private ImageView f50384a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f50385b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f50386c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f50387d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f50388e;

    /* renamed from: f, reason: collision with root package name */
    private View f50389f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(View itemView) {
        super(itemView);
        Intrinsics.h(itemView, "itemView");
        View findViewById = itemView.findViewById(R$id.sv_item_cover);
        Intrinsics.g(findViewById, "findViewById(...)");
        this.f50384a = (ImageView) findViewById;
        View findViewById2 = itemView.findViewById(R$id.tv_title);
        Intrinsics.g(findViewById2, "findViewById(...)");
        this.f50385b = (TextView) findViewById2;
        View findViewById3 = itemView.findViewById(R$id.tv_desc);
        Intrinsics.g(findViewById3, "findViewById(...)");
        this.f50386c = (TextView) findViewById3;
        View findViewById4 = itemView.findViewById(R$id.tv_select);
        Intrinsics.g(findViewById4, "findViewById(...)");
        this.f50387d = (TextView) findViewById4;
        View findViewById5 = itemView.findViewById(R$id.iv_play);
        Intrinsics.g(findViewById5, "findViewById(...)");
        this.f50388e = (ImageView) findViewById5;
        View findViewById6 = itemView.findViewById(R$id.view_masking);
        Intrinsics.g(findViewById6, "findViewById(...)");
        this.f50389f = findViewById6;
    }

    public final ImageView f() {
        return this.f50388e;
    }

    public final TextView g() {
        return this.f50386c;
    }

    public final TextView h() {
        return this.f50387d;
    }

    public final TextView i() {
        return this.f50385b;
    }

    public final View j() {
        return this.f50389f;
    }
}
