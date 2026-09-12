package com.transsion.search.viewmodel;

import android.app.Application;
import androidx.view.b0;
import androidx.view.t0;
import androidx.view.u0;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.video.VideoDetailPlayDao;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.y0;

/* loaded from: classes6.dex */
public final class SearchWorkViewModel extends t0 {

    /* renamed from: e */
    private int f52308e;

    /* renamed from: a */
    private boolean f52304a = true;

    /* renamed from: b */
    private final b0 f52305b = new b0();

    /* renamed from: c */
    private final List f52306c = new ArrayList();

    /* renamed from: d */
    private final Lazy f52307d = LazyKt.b(new Function0() { // from class: com.transsion.search.viewmodel.c
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            VideoDetailPlayDao n11;
            n11 = SearchWorkViewModel.n();
            return n11;
        }
    });

    /* renamed from: f */
    private int f52309f = 50;

    public final VideoDetailPlayDao j() {
        return (VideoDetailPlayDao) this.f52307d.getValue();
    }

    public static /* synthetic */ void l(SearchWorkViewModel searchWorkViewModel, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = false;
        }
        searchWorkViewModel.k(z10);
    }

    public static final VideoDetailPlayDao n() {
        AppDatabase.Companion companion = AppDatabase.INSTANCE;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        return companion.b(a11).D1();
    }

    public final boolean g() {
        return this.f52304a;
    }

    public final b0 h() {
        return this.f52305b;
    }

    public final int i() {
        return this.f52308e;
    }

    public final void k(boolean z10) {
        k.d(u0.a(this), y0.b(), null, new SearchWorkViewModel$getVideoHistoryList$1(z10, this, null), 2, null);
    }

    public final void m(int i11) {
        this.f52308e = i11;
    }
}
