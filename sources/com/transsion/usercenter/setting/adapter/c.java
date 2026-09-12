package com.transsion.usercenter.setting.adapter;

import android.widget.TextView;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class c extends BaseItemProvider {

    /* renamed from: e, reason: collision with root package name */
    private final int f57493e = 2;

    /* renamed from: f, reason: collision with root package name */
    private final int f57494f = R$layout.dialog_locale_language_item;

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return this.f57493e;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return this.f57494f;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder holder, vw.a item) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        ((TextView) holder.getView(R$id.tv_language)).setText(item.a());
    }
}
