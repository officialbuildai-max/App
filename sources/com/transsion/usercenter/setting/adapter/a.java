package com.transsion.usercenter.setting.adapter;

import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.usercenter.R$layout;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class a extends BaseItemProvider {

    /* renamed from: e, reason: collision with root package name */
    private final int f57491e = 1;

    /* renamed from: f, reason: collision with root package name */
    private final int f57492f = R$layout.dialog_locale_language_item_auto;

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return this.f57491e;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return this.f57492f;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder holder, vw.a item) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
    }
}
