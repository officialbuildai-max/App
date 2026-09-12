package com.transsion.publish.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.publish.R$id;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class y extends RecyclerView.b0 {

    /* renamed from: a, reason: collision with root package name */
    private ImageView f50491a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f50492b;

    /* renamed from: c, reason: collision with root package name */
    private View f50493c;

    /* renamed from: d, reason: collision with root package name */
    private View f50494d;

    /* renamed from: e, reason: collision with root package name */
    private View f50495e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(View itemView) {
        super(itemView);
        Intrinsics.h(itemView, "itemView");
        View findViewById = itemView.findViewById(R$id.iv_cover);
        Intrinsics.g(findViewById, "findViewById(...)");
        this.f50491a = (ImageView) findViewById;
        View findViewById2 = itemView.findViewById(R$id.tv_title);
        Intrinsics.g(findViewById2, "findViewById(...)");
        this.f50492b = (TextView) findViewById2;
        View findViewById3 = itemView.findViewById(R$id.tv_desc);
        Intrinsics.g(findViewById3, "findViewById(...)");
        this.f50493c = findViewById3;
        View findViewById4 = itemView.findViewById(R$id.rl_close);
        Intrinsics.g(findViewById4, "findViewById(...)");
        this.f50494d = findViewById4;
        View findViewById5 = itemView.findViewById(R$id.layout);
        Intrinsics.g(findViewById5, "findViewById(...)");
        this.f50495e = findViewById5;
    }

    public final View f() {
        return this.f50494d;
    }

    public final TextView g() {
        return this.f50492b;
    }
}
