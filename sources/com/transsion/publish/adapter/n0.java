package com.transsion.publish.adapter;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.publish.R$id;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class n0 extends RecyclerView.b0 {

    /* renamed from: a, reason: collision with root package name */
    private ShapeableImageView f50468a;

    /* renamed from: b, reason: collision with root package name */
    private AppCompatTextView f50469b;

    /* renamed from: c, reason: collision with root package name */
    private AppCompatTextView f50470c;

    /* renamed from: d, reason: collision with root package name */
    private AppCompatImageView f50471d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n0(View itemView) {
        super(itemView);
        Intrinsics.h(itemView, "itemView");
        View findViewById = itemView.findViewById(R$id.ivCover);
        Intrinsics.g(findViewById, "findViewById(...)");
        this.f50468a = (ShapeableImageView) findViewById;
        View findViewById2 = itemView.findViewById(R$id.tvSubjectTitle);
        Intrinsics.g(findViewById2, "findViewById(...)");
        this.f50469b = (AppCompatTextView) findViewById2;
        View findViewById3 = itemView.findViewById(R$id.tvSubjectYear);
        Intrinsics.g(findViewById3, "findViewById(...)");
        this.f50470c = (AppCompatTextView) findViewById3;
        View findViewById4 = itemView.findViewById(R$id.iv_publish_subject_delete);
        Intrinsics.g(findViewById4, "findViewById(...)");
        this.f50471d = (AppCompatImageView) findViewById4;
    }

    public final ShapeableImageView f() {
        return this.f50468a;
    }

    public final AppCompatImageView g() {
        return this.f50471d;
    }

    public final AppCompatTextView h() {
        return this.f50470c;
    }

    public final AppCompatTextView i() {
        return this.f50469b;
    }
}
