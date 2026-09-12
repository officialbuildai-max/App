package com.transsion.home.adapter.trending.provider;

import android.view.View;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsnet.downloader.widget.DownloadView;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* loaded from: classes5.dex */
public final class SubjectSingleImgItemProvider extends b {

    /* renamed from: e, reason: collision with root package name */
    private final boolean f44764e;

    /* renamed from: f, reason: collision with root package name */
    private final int f44765f;

    /* renamed from: g, reason: collision with root package name */
    private final double f44766g;

    /* renamed from: h, reason: collision with root package name */
    private BaseViewHolder f44767h;

    public SubjectSingleImgItemProvider(boolean z10) {
        this.f44764e = z10;
        int min = Math.min(com.blankj.utilcode.util.y.e(), com.blankj.utilcode.util.y.c());
        this.f44765f = min;
        this.f44766g = min * 0.5d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(Subject subject, boolean z10, boolean z11, long j11) {
        subject.setLoadCoverSuccess(z10);
        subject.setCoverCache(z11);
        subject.setLoadCoverDuration(j11);
        return Unit.f67184a;
    }

    private final String G(int i11) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.f67412a;
        String format = String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i11 / 3600), Integer.valueOf((i11 % 3600) / 60), Integer.valueOf(i11 % 60)}, 3));
        Intrinsics.g(format, "format(...)");
        return format;
    }

    /* JADX WARN: Code restructure failed: missing block: B:93:0x0111, code lost:
    
        if (r0.intValue() != r2) goto L57;
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0245  */
    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(com.chad.library.adapter.base.viewholder.BaseViewHolder r14, com.transsion.home.bean.OperateItem r15) {
        /*
            Method dump skipped, instructions count: 592
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.home.adapter.trending.provider.SubjectSingleImgItemProvider.b(com.chad.library.adapter.base.viewholder.BaseViewHolder, com.transsion.home.bean.OperateItem):void");
    }

    public final View H() {
        BaseViewHolder baseViewHolder = this.f44767h;
        if (baseViewHolder != null) {
            return (DownloadView) baseViewHolder.getViewOrNull(R$id.ll_download);
        }
        return null;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return PostItemType.SINGLE_SUBJECT.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return R$layout.post_list_item_subject_single_img;
    }
}
