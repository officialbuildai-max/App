package com.transsion.shorttv.ui.adapter.provider;

import android.view.View;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.transsion.shorttv.R$layout;
import com.transsion.shorttv.bean.ShortTvItemType;
import com.transsion.shorttv.ui.widget.ShortTVDiscoverHeaderView;
import com.transsion.shorttv.ui.widget.ShortTvCategoryView;
import com.transsion.shorttv.ui.widget.ShortTvOpAppointmentView;
import com.transsion.shorttv.ui.widget.ShortTvOpCustomView;
import com.transsion.shorttv.ui.widget.ShortTvOpRankingView;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class a extends BaseItemProvider {

    /* renamed from: e, reason: collision with root package name */
    private final String f53227e;

    /* renamed from: com.transsion.shorttv.ui.adapter.provider.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public /* synthetic */ class C0659a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f53228a;

        static {
            int[] iArr = new int[ShortTvItemType.values().length];
            try {
                iArr[ShortTvItemType.APPOINTMENT_LIST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ShortTvItemType.CUSTOM_DATA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ShortTvItemType.OP_SUBJECTS_MOVIE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ShortTvItemType.PLAY_LIST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ShortTvItemType.FILTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f53228a = iArr;
        }
    }

    public a(String pageName) {
        Intrinsics.h(pageName, "pageName");
        this.f53227e = pageName;
    }

    private final boolean z(View view, ShortTvItemType shortTvItemType) {
        int i11 = shortTvItemType == null ? -1 : C0659a.f53228a[shortTvItemType.ordinal()];
        if (i11 == 1) {
            return view instanceof ShortTvOpAppointmentView;
        }
        if (i11 == 2) {
            return view instanceof ShortTvOpCustomView;
        }
        if (i11 == 3) {
            return view instanceof ShortTvOpRankingView;
        }
        if (i11 == 4) {
            return view instanceof ShortTVDiscoverHeaderView;
        }
        if (i11 != 5) {
            return false;
        }
        return view instanceof ShortTvCategoryView;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return 0;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return R$layout.layout_view_container;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(com.chad.library.adapter.base.viewholder.BaseViewHolder r12, xs.a r13) {
        /*
            Method dump skipped, instructions count: 318
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.shorttv.ui.adapter.provider.a.b(com.chad.library.adapter.base.viewholder.BaseViewHolder, xs.a):void");
    }
}
