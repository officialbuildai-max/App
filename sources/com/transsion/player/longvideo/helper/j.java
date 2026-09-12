package com.transsion.player.longvideo.helper;

import android.util.Log;
import android.view.ViewGroup;
import com.transsion.player.longvideo.ui.LongVodUiType;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class j {

    /* renamed from: e, reason: collision with root package name */
    public static final a f48052e = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final ho.j f48053a;

    /* renamed from: b, reason: collision with root package name */
    private int f48054b;

    /* renamed from: c, reason: collision with root package name */
    private int f48055c;

    /* renamed from: d, reason: collision with root package name */
    private int f48056d;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public j(ho.j viewBinding) {
        Intrinsics.h(viewBinding, "viewBinding");
        this.f48053a = viewBinding;
        this.f48054b = com.blankj.utilcode.util.y.c();
        int e11 = com.blankj.utilcode.util.y.e();
        this.f48055c = e11;
        int i11 = this.f48054b;
        if (e11 < i11) {
            this.f48055c = i11;
            this.f48054b = e11;
        }
        int a11 = com.blankj.utilcode.util.d.a();
        if (a11 > 10) {
            this.f48055c -= a11;
        }
    }

    public final int a() {
        return this.f48056d;
    }

    public final void b(int i11, int i12) {
        com.blankj.utilcode.util.d.c();
    }

    public final void c() {
        this.f48056d = 0;
    }

    public final void d(LongVodUiType uiType, int i11) {
        Intrinsics.h(uiType, "uiType");
        if (this.f48056d == 0) {
            this.f48056d = com.blankj.utilcode.util.d.c();
        }
        LongVodUiType longVodUiType = LongVodUiType.LAND;
        int i12 = 0;
        int i13 = (uiType == longVodUiType && i11 == 1) ? this.f48056d : 0;
        if (uiType == longVodUiType && i11 == 3) {
            i12 = this.f48056d;
        }
        Log.e("LongVodLandSpace", "setSpace  uiType:" + uiType + "  rotation:" + i11 + "  spaceLeft:" + i13 + "  spaceRight:" + i12);
        ViewGroup.LayoutParams layoutParams = this.f48053a.f64743j.f64732i.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.f48053a.f64741h.C.getLayoutParams();
        layoutParams.width = i13;
        layoutParams2.width = i13;
        this.f48053a.f64743j.f64732i.setLayoutParams(layoutParams);
        this.f48053a.f64741h.C.setLayoutParams(layoutParams2);
        ViewGroup.LayoutParams layoutParams3 = this.f48053a.f64743j.f64731h.getLayoutParams();
        ViewGroup.LayoutParams layoutParams4 = this.f48053a.f64741h.B.getLayoutParams();
        layoutParams3.width = i12;
        layoutParams4.width = i12;
        this.f48053a.f64743j.f64731h.setLayoutParams(layoutParams3);
        this.f48053a.f64741h.B.setLayoutParams(layoutParams4);
    }
}
