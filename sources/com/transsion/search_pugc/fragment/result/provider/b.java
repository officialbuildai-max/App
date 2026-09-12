package com.transsion.search_pugc.fragment.result.provider;

import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.transsion.search.R$layout;
import com.transsion.search_pugc.constant.ResultCollectItemWrapper;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes6.dex */
public final class b extends BaseItemProvider {

    /* renamed from: e, reason: collision with root package name */
    private final boolean f52481e;

    /* renamed from: f, reason: collision with root package name */
    private final int f52482f;

    public b() {
        this(false, 1, null);
    }

    public b(boolean z10) {
        this.f52481e = z10;
        this.f52482f = ResultCollectItemWrapper.Type.DATA.ordinal();
    }

    public /* synthetic */ b(boolean z10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? false : z10);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return this.f52482f;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return R$layout.item_search_collection;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0097, code lost:
    
        if (r1 == null) goto L38;
     */
    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(com.chad.library.adapter.base.viewholder.BaseViewHolder r7, com.transsion.search_pugc.constant.ResultCollectItemWrapper r8) {
        /*
            Method dump skipped, instructions count: 308
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.search_pugc.fragment.result.provider.b.b(com.chad.library.adapter.base.viewholder.BaseViewHolder, com.transsion.search_pugc.constant.ResultCollectItemWrapper):void");
    }
}
