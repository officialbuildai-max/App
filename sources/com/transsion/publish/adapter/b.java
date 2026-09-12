package com.transsion.publish.adapter;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.publish.R$id;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class b extends RecyclerView.b0 {

    /* renamed from: a, reason: collision with root package name */
    private TextView f50371a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f50372b;

    /* renamed from: c, reason: collision with root package name */
    private FrameLayout f50373c;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f50374d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(View itemView) {
        super(itemView);
        Intrinsics.h(itemView, "itemView");
        View findViewById = itemView.findViewById(R$id.tv_title);
        Intrinsics.g(findViewById, "findViewById(...)");
        this.f50371a = (TextView) findViewById;
        View findViewById2 = itemView.findViewById(R$id.tv_desc);
        Intrinsics.g(findViewById2, "findViewById(...)");
        this.f50372b = (TextView) findViewById2;
        View findViewById3 = itemView.findViewById(R$id.rl_close);
        Intrinsics.g(findViewById3, "findViewById(...)");
        this.f50373c = (FrameLayout) findViewById3;
        View findViewById4 = itemView.findViewById(R$id.iv_play);
        Intrinsics.g(findViewById4, "findViewById(...)");
        this.f50374d = (ImageView) findViewById4;
    }

    public final ImageView f() {
        return this.f50374d;
    }

    public final FrameLayout g() {
        return this.f50373c;
    }

    public final TextView h() {
        return this.f50372b;
    }

    public final TextView i() {
        return this.f50371a;
    }
}
