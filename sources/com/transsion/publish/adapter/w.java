package com.transsion.publish.adapter;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.publish.R$id;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class w extends RecyclerView.b0 {

    /* renamed from: a, reason: collision with root package name */
    private TextView f50489a;

    /* renamed from: b, reason: collision with root package name */
    private View f50490b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(View itemView) {
        super(itemView);
        Intrinsics.h(itemView, "itemView");
        View findViewById = itemView.findViewById(R$id.tvGroup);
        Intrinsics.g(findViewById, "findViewById(...)");
        this.f50489a = (TextView) findViewById;
        View findViewById2 = itemView.findViewById(R$id.iv_publish_group_delete);
        Intrinsics.g(findViewById2, "findViewById(...)");
        this.f50490b = findViewById2;
    }

    public final View f() {
        return this.f50490b;
    }

    public final TextView g() {
        return this.f50489a;
    }
}
