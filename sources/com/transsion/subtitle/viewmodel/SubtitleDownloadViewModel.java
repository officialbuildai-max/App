package com.transsion.subtitle.viewmodel;

import android.app.Application;
import androidx.view.b0;
import androidx.view.t0;
import androidx.view.u0;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.subtitle.fragment.i;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import lj.d1;
import zg.c;

/* loaded from: classes6.dex */
public final class SubtitleDownloadViewModel extends t0 {

    /* renamed from: a, reason: collision with root package name */
    private final Lazy f55091a = LazyKt.b(new Function0() { // from class: com.transsion.subtitle.viewmodel.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            iu.a v11;
            v11 = SubtitleDownloadViewModel.v();
            return v11;
        }
    });

    /* renamed from: b, reason: collision with root package name */
    private final Lazy f55092b = LazyKt.b(new Function0() { // from class: com.transsion.subtitle.viewmodel.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            d1 w11;
            w11 = SubtitleDownloadViewModel.w();
            return w11;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    private final b0 f55093c = new b0();

    /* renamed from: d, reason: collision with root package name */
    private final b0 f55094d = new b0();

    /* renamed from: e, reason: collision with root package name */
    private final b0 f55095e = new b0();

    /* renamed from: f, reason: collision with root package name */
    private final b0 f55096f = new b0();

    /* renamed from: g, reason: collision with root package name */
    private final b0 f55097g = new b0();

    /* renamed from: h, reason: collision with root package name */
    private final b0 f55098h = new b0();

    /* renamed from: i, reason: collision with root package name */
    private final b0 f55099i = new b0();

    /* renamed from: j, reason: collision with root package name */
    private final b0 f55100j = new b0();

    /* renamed from: k, reason: collision with root package name */
    private final b0 f55101k = new b0();

    private final iu.a p() {
        return (iu.a) this.f55091a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final d1 q() {
        return (d1) this.f55092b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object r(com.transsion.subtitle.fragment.i r18, java.lang.String r19, com.transsion.baselib.db.download.DownloadBean r20, java.lang.String r21, int r22, kotlin.coroutines.Continuation r23) {
        /*
            Method dump skipped, instructions count: 324
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subtitle.viewmodel.SubtitleDownloadViewModel.r(com.transsion.subtitle.fragment.i, java.lang.String, com.transsion.baselib.db.download.DownloadBean, java.lang.String, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:37:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object s(com.transsion.baselib.db.download.DownloadBean r10, com.transsion.subtitle.fragment.i r11, java.util.List r12, kotlin.coroutines.Continuation r13) {
        /*
            Method dump skipped, instructions count: 310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subtitle.viewmodel.SubtitleDownloadViewModel.s(com.transsion.baselib.db.download.DownloadBean, com.transsion.subtitle.fragment.i, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ void u(SubtitleDownloadViewModel subtitleDownloadViewModel, i iVar, String str, List list, DownloadBean downloadBean, String str2, int i11, int i12, Object obj) {
        if ((i12 & 16) != 0) {
            str2 = "1";
        }
        String str3 = str2;
        if ((i12 & 32) != 0) {
            i11 = 20;
        }
        subtitleDownloadViewModel.t(iVar, str, list, downloadBean, str3, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final iu.a v() {
        return (iu.a) c.f79537e.a().h(iu.a.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final d1 w() {
        Application a11 = Utils.a();
        if (a11 != null) {
            return AppDatabase.INSTANCE.b(a11).A1();
        }
        return null;
    }

    public final void g(String subtitleResId) {
        Intrinsics.h(subtitleResId, "subtitleResId");
        k.d(u0.a(this), null, null, new SubtitleDownloadViewModel$getDownloadedList$1(subtitleResId, this, null), 3, null);
    }

    public final b0 h() {
        return this.f55094d;
    }

    public final void i() {
        k.d(o0.a(y0.b()), null, null, new SubtitleDownloadViewModel$getLanguageAllList$1(this, null), 3, null);
    }

    public final b0 j() {
        return this.f55096f;
    }

    public final void k(eu.a item) {
        Intrinsics.h(item, "item");
        k.d(u0.a(this), y0.b(), null, new SubtitleDownloadViewModel$getOpenSubNewApiDownloadInfo$1(item, this, null), 2, null);
    }

    public final b0 l() {
        return this.f55100j;
    }

    public final b0 m() {
        return this.f55101k;
    }

    public final b0 n() {
        return this.f55095e;
    }

    public final b0 o() {
        return this.f55099i;
    }

    public final void t(i iVar, String languages, List languageList, DownloadBean downloadBean, String nextPage, int i11) {
        Intrinsics.h(languages, "languages");
        Intrinsics.h(languageList, "languageList");
        Intrinsics.h(nextPage, "nextPage");
        k.d(u0.a(this), y0.b(), null, new SubtitleDownloadViewModel$searchSubtitleList$1(this, downloadBean, iVar, languageList, languages, nextPage, i11, null), 2, null);
    }
}
