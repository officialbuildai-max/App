package com.transsion.search_pugc.fragment.result;

import android.app.Application;
import androidx.view.b0;
import androidx.view.u0;
import com.transsion.search_pugc.bean.SecondTab;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class SearchResultViewModel extends androidx.view.b {

    /* renamed from: i, reason: collision with root package name */
    public static final a f52456i = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private final Lazy f52457b;

    /* renamed from: c, reason: collision with root package name */
    private final b0 f52458c;

    /* renamed from: d, reason: collision with root package name */
    private final b0 f52459d;

    /* renamed from: e, reason: collision with root package name */
    private final b0 f52460e;

    /* renamed from: f, reason: collision with root package name */
    private String f52461f;

    /* renamed from: g, reason: collision with root package name */
    private final b0 f52462g;

    /* renamed from: h, reason: collision with root package name */
    private int f52463h;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchResultViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.f52457b = LazyKt.b(new Function0() { // from class: com.transsion.search_pugc.fragment.result.o
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                fr.a o11;
                o11 = SearchResultViewModel.o();
                return o11;
            }
        });
        this.f52458c = new b0();
        this.f52459d = new b0();
        this.f52460e = new b0();
        this.f52462g = new b0(Boolean.FALSE);
        this.f52463h = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final fr.a j() {
        return (fr.a) this.f52457b.getValue();
    }

    public static /* synthetic */ void n(SearchResultViewModel searchResultViewModel, String str, String str2, String str3, boolean z10, SecondTab secondTab, int i11, Object obj) {
        String str4 = (i11 & 2) != 0 ? null : str2;
        if ((i11 & 8) != 0) {
            z10 = false;
        }
        searchResultViewModel.m(str, str4, str3, z10, (i11 & 16) != 0 ? null : secondTab);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final fr.a o() {
        return (fr.a) zg.c.f79537e.a().h(fr.a.class);
    }

    public final String g() {
        return this.f52461f;
    }

    public final b0 h() {
        return this.f52460e;
    }

    public final b0 i() {
        return this.f52462g;
    }

    public final b0 k() {
        return this.f52459d;
    }

    public final b0 l() {
        return this.f52458c;
    }

    public final void m(String keyword, String str, String pageFrom, boolean z10, SecondTab secondTab) {
        Intrinsics.h(keyword, "keyword");
        Intrinsics.h(pageFrom, "pageFrom");
        kotlinx.coroutines.k.d(u0.a(this), null, null, new SearchResultViewModel$requestUGCSearchResult$1(this, keyword, pageFrom, str, secondTab, z10, null), 3, null);
    }

    public final void p(String str) {
        this.f52461f = str;
    }

    public final void q(int i11) {
        this.f52463h = i11;
    }
}
