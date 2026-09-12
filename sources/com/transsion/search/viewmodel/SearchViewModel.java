package com.transsion.search.viewmodel;

import android.app.Application;
import android.text.TextUtils;
import androidx.view.b0;
import androidx.view.u0;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.widget.toast.core.h;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.search.bean.HotSubjectEntity;
import com.transsion.search.bean.JoinGroupEntity;
import com.transsion.search.bean.SearchSuggestEntity;
import com.transsion.search.net.RequestJoinGroupEntity;
import com.transsion.search.net.RequestSearchEntity;
import com.transsion.search.widget.BoundaryLinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.k;
import yq.j;

/* loaded from: classes6.dex */
public final class SearchViewModel extends androidx.view.b {

    /* renamed from: b, reason: collision with root package name */
    private final b0 f52283b;

    /* renamed from: c, reason: collision with root package name */
    private final b0 f52284c;

    /* renamed from: d, reason: collision with root package name */
    private final b0 f52285d;

    /* renamed from: e, reason: collision with root package name */
    private final b0 f52286e;

    /* renamed from: f, reason: collision with root package name */
    private final b0 f52287f;

    /* renamed from: g, reason: collision with root package name */
    private final b0 f52288g;

    /* renamed from: h, reason: collision with root package name */
    private final Lazy f52289h;

    /* renamed from: i, reason: collision with root package name */
    private io.reactivex.rxjava3.disposables.c f52290i;

    /* renamed from: j, reason: collision with root package name */
    private final BoundaryLinkedHashMap f52291j;

    /* renamed from: k, reason: collision with root package name */
    private final BoundaryLinkedHashMap f52292k;

    /* renamed from: l, reason: collision with root package name */
    private final b0 f52293l;

    /* renamed from: m, reason: collision with root package name */
    private final Lazy f52294m;

    /* loaded from: classes6.dex */
    public static final class a extends sg.a {
        a() {
        }

        @Override // sg.a
        public void a(String str, String str2) {
            SearchViewModel.this.l().n(null);
        }

        @Override // sg.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(HotSubjectEntity hotSubjectEntity) {
            SearchViewModel.this.l().n(hotSubjectEntity);
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends sg.a {
        b() {
        }

        @Override // sg.a
        public void a(String str, String str2) {
            if (str2 != null) {
                h.f41533a.l(str2);
            }
            SearchViewModel.this.f52286e.n("");
        }

        @Override // sg.a
        public void d(BaseDto baseDto) {
            Intrinsics.h(baseDto, "baseDto");
        }

        @Override // sg.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(JoinGroupEntity joinGroupEntity) {
            if (TextUtils.isEmpty(joinGroupEntity != null ? joinGroupEntity.getM() : null)) {
                SearchViewModel.this.f52286e.n("succeed");
            } else {
                SearchViewModel.this.f52286e.n(joinGroupEntity != null ? joinGroupEntity.getM() : null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class c implements lz.f {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f52298b;

        c(String str) {
            this.f52298b = str;
        }

        @Override // lz.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void accept(SearchSuggestEntity data) {
            Intrinsics.h(data, "data");
            SearchViewModel.this.v(this.f52298b, data);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class d implements lz.f {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f52300b;

        d(String str) {
            this.f52300b = str;
        }

        @Override // lz.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void accept(Throwable it) {
            Intrinsics.h(it, "it");
            SearchViewModel.this.t().n(this.f52300b);
        }
    }

    /* loaded from: classes6.dex */
    public static final class e extends sg.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f52302e;

        e(String str) {
            this.f52302e = str;
        }

        @Override // sg.a
        public void a(String str, String str2) {
            SearchViewModel.this.t().n(this.f52302e);
        }

        @Override // sg.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(SearchSuggestEntity searchSuggestEntity) {
            SearchViewModel.this.v(this.f52302e, searchSuggestEntity);
        }
    }

    /* loaded from: classes6.dex */
    public static final class f extends sg.a {
        f() {
        }

        @Override // sg.a
        public void a(String str, String str2) {
            if (str2 != null) {
                h.f41533a.l(str2);
            }
            SearchViewModel.this.f52283b.n(null);
        }

        @Override // sg.a
        public void d(BaseDto baseDto) {
            Intrinsics.h(baseDto, "baseDto");
            SearchViewModel.this.f52283b.n(baseDto.getData());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.f52283b = new b0();
        this.f52284c = new b0();
        this.f52285d = new b0();
        this.f52286e = new b0();
        this.f52287f = new b0();
        this.f52288g = new b0();
        this.f52289h = LazyKt.b(new Function0() { // from class: com.transsion.search.viewmodel.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                j B;
                B = SearchViewModel.B();
                return B;
            }
        });
        this.f52291j = new BoundaryLinkedHashMap();
        this.f52292k = new BoundaryLinkedHashMap();
        this.f52293l = new b0();
        this.f52294m = LazyKt.b(new Function0() { // from class: com.transsion.search.viewmodel.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean x10;
                x10 = SearchViewModel.x();
                return Boolean.valueOf(x10);
            }
        });
    }

    private final void A(String str) {
        n().e(str).E(qz.a.c()).subscribe(new e(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final j B() {
        return new j();
    }

    private final boolean F() {
        return w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final j n() {
        return (j) this.f52289h.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0010, code lost:
    
        if (r0 == null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void v(java.lang.String r3, com.transsion.search.bean.SearchSuggestEntity r4) {
        /*
            r2 = this;
            if (r4 != 0) goto L3
            return
        L3:
            java.lang.String r0 = r4.getKeyword()
            if (r0 == 0) goto L12
            boolean r1 = kotlin.text.StringsKt.q0(r0)
            if (r1 == 0) goto L10
            r0 = r3
        L10:
            if (r0 != 0) goto L13
        L12:
            r0 = r3
        L13:
            com.transsion.search.widget.BoundaryLinkedHashMap r1 = r2.f52291j
            r1.put(r3, r4)
            boolean r1 = kotlin.jvm.internal.Intrinsics.c(r0, r3)
            if (r1 != 0) goto L23
            com.transsion.search.widget.BoundaryLinkedHashMap r1 = r2.f52291j
            r1.put(r0, r4)
        L23:
            androidx.lifecycle.b0 r1 = r2.f52293l
            r1.n(r3)
            java.util.List r3 = r4.getItems()
            if (r3 == 0) goto L83
            boolean r3 = r3.isEmpty()
            r1 = 1
            if (r3 != r1) goto L83
            int r3 = r0.length()
            r1 = 2
            if (r3 < r1) goto L83
            com.transsion.search.widget.BoundaryLinkedHashMap r3 = r2.f52292k
            boolean r3 = r3.containsKey(r0)
            if (r3 != 0) goto L83
            com.transsion.search.widget.BoundaryLinkedHashMap r3 = r2.f52292k
            r1 = 0
            r3.put(r0, r1)
            com.transsion.search.activity.SearchManagerActivity$a r3 = com.transsion.search.activity.SearchManagerActivity.INSTANCE
            java.lang.String r1 = "no associative word results when the user enters query longer than 2 characters"
            r3.a(r1)
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.lang.String r1 = "key_word"
            r3.put(r1, r0)
            java.lang.String r4 = r4.getOps()
            if (r4 != 0) goto L63
            java.lang.String r4 = ""
        L63:
            java.lang.String r0 = "ops"
            r3.put(r0, r4)
            java.lang.String r4 = "sug_source"
            java.lang.String r0 = r2.s()
            r3.put(r4, r0)
            com.transsion.search.fragment.BaseSearchMainFragment$a r4 = com.transsion.search.fragment.BaseSearchMainFragment.INSTANCE
            java.lang.String r4 = r4.a()
            java.lang.String r0 = "search_id"
            r3.put(r0, r4)
            hj.i r4 = hj.i.f64628a
            java.lang.String r0 = "search_suggest"
            r4.D(r0, r3)
        L83:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.search.viewmodel.SearchViewModel.v(java.lang.String, com.transsion.search.bean.SearchSuggestEntity):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean x() {
        String value;
        ConfigBean c11 = sm.f.f75530c.a().c("sa_search_suggest_use_google", true);
        if (c11 == null || (value = c11.getValue()) == null) {
            return false;
        }
        return Intrinsics.c(StringsKt.m1(value), Boolean.TRUE);
    }

    private final void z(String str) {
        n().b(str).E(qz.a.c()).B(new c(str), new d(str));
    }

    public final void C(int i11, int i12, String keyword) {
        Intrinsics.h(keyword, "keyword");
        n().h(new RequestSearchEntity(i11, i12, keyword)).E(qz.a.c()).subscribe(new f());
    }

    public final void D(int i11, int i12, String keyword) {
        Intrinsics.h(keyword, "keyword");
        k.d(u0.a(this), null, null, new SearchViewModel$searchWork$1(this, new RequestSearchEntity(i11, i12, keyword), null), 3, null);
    }

    public final void E(int i11, int i12, String keyword, int i13) {
        Intrinsics.h(keyword, "keyword");
        k.d(u0.a(this), null, null, new SearchViewModel$searchWorkV2$1(this, new RequestSearchEntity(i11, i12, keyword, i13), null), 3, null);
    }

    public final void k() {
        n().d().E(qz.a.c()).subscribe(new a());
    }

    public final b0 l() {
        return this.f52288g;
    }

    public final b0 m() {
        return this.f52286e;
    }

    public final b0 o() {
        return this.f52283b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.view.t0
    public void onCleared() {
        io.reactivex.rxjava3.disposables.c cVar;
        super.onCleared();
        io.reactivex.rxjava3.disposables.c cVar2 = this.f52290i;
        if (cVar2 == null || cVar2.isDisposed() || (cVar = this.f52290i) == null) {
            return;
        }
        cVar.dispose();
    }

    public final void p(String keyword) {
        Intrinsics.h(keyword, "keyword");
        if (F()) {
            z(keyword);
        } else {
            A(keyword);
        }
    }

    public final b0 q() {
        return this.f52284c;
    }

    public final b0 r() {
        return this.f52285d;
    }

    public final String s() {
        return w() ? "gp_sug" : "mb_sug";
    }

    public final b0 t() {
        return this.f52293l;
    }

    public final BoundaryLinkedHashMap u() {
        return this.f52291j;
    }

    public final boolean w() {
        return ((Boolean) this.f52294m.getValue()).booleanValue();
    }

    public final void y(String groupId) {
        Intrinsics.h(groupId, "groupId");
        n().g(new RequestJoinGroupEntity(groupId)).E(qz.a.c()).subscribe(new b());
    }
}
