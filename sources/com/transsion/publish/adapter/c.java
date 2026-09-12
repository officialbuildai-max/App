package com.transsion.publish.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.publish.R$id;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class c extends RecyclerView.b0 {

    /* renamed from: a, reason: collision with root package name */
    private ImageView f50380a;

    /* renamed from: b, reason: collision with root package name */
    private View f50381b;

    /* renamed from: c, reason: collision with root package name */
    private View f50382c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f50383d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(View view) {
        super(view);
        Intrinsics.e(view);
        this.f50380a = (ImageView) view.findViewById(R$id.iv_photo);
        this.f50381b = view.findViewById(R$id.iv_clear);
        this.f50382c = view.findViewById(R$id.rl_add);
        this.f50383d = (TextView) view.findViewById(R$id.tv_number);
    }

    public final View f() {
        return this.f50382c;
    }

    public final View g() {
        return this.f50381b;
    }

    public final ImageView h() {
        return this.f50380a;
    }

    public final TextView i() {
        return this.f50383d;
    }
}
