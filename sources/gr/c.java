package gr;

import android.app.Application;
import androidx.view.b0;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.search_pugc.bean.UGCEveryoneSearchData;
import com.transsion.search_pugc.bean.UGCRankSearchData;
import com.transsion.search_pugc.bean.UGCSearchSuggestData;
import com.transsion.search_pugc.widget.BoundaryLinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lz.f;

/* loaded from: classes7.dex */
public final class c extends androidx.view.b {

    /* renamed from: b, reason: collision with root package name */
    private final BoundaryLinkedHashMap f64058b;

    /* renamed from: c, reason: collision with root package name */
    private final b0 f64059c;

    /* renamed from: d, reason: collision with root package name */
    private final b0 f64060d;

    /* renamed from: e, reason: collision with root package name */
    private final b0 f64061e;

    /* renamed from: f, reason: collision with root package name */
    private final Lazy f64062f;

    /* renamed from: g, reason: collision with root package name */
    private io.reactivex.rxjava3.disposables.c f64063g;

    /* renamed from: h, reason: collision with root package name */
    private final Lazy f64064h;

    /* loaded from: classes7.dex */
    public static final class a extends sg.a {
        a() {
        }

        @Override // sg.a
        public void a(String str, String str2) {
            c.this.k().n(null);
        }

        @Override // sg.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(UGCEveryoneSearchData uGCEveryoneSearchData) {
            c.this.k().n(uGCEveryoneSearchData);
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends sg.a {
        b() {
        }

        @Override // sg.a
        public void a(String str, String str2) {
            c.this.l().n(null);
        }

        @Override // sg.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(UGCRankSearchData uGCRankSearchData) {
            c.this.l().n(uGCRankSearchData);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: gr.c$c, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0795c implements f {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f64068b;

        C0795c(String str) {
            this.f64068b = str;
        }

        @Override // lz.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void accept(UGCSearchSuggestData data) {
            Intrinsics.h(data, "data");
            c.this.n(this.f64068b, data);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class d implements f {
        d() {
        }

        @Override // lz.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void accept(Throwable it) {
            Intrinsics.h(it, "it");
            c.this.m().n(null);
        }
    }

    /* loaded from: classes7.dex */
    public static final class e extends sg.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f64071e;

        e(String str) {
            this.f64071e = str;
        }

        @Override // sg.a
        public void a(String str, String str2) {
            c.this.m().n(null);
        }

        @Override // sg.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(UGCSearchSuggestData uGCSearchSuggestData) {
            c.this.n(this.f64071e, uGCSearchSuggestData);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.f64058b = new BoundaryLinkedHashMap();
        this.f64059c = new b0();
        this.f64060d = new b0();
        this.f64061e = new b0();
        this.f64062f = LazyKt.b(new Function0() { // from class: gr.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                fr.c s11;
                s11 = c.s();
                return s11;
            }
        });
        this.f64064h = LazyKt.b(new Function0() { // from class: gr.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean p11;
                p11 = c.p();
                return Boolean.valueOf(p11);
            }
        });
    }

    private final fr.c f() {
        return (fr.c) this.f64062f.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(String str, UGCSearchSuggestData uGCSearchSuggestData) {
        if (uGCSearchSuggestData == null) {
            return;
        }
        String keyword = uGCSearchSuggestData.getKeyword();
        if (StringsKt.q0(keyword)) {
            keyword = str;
        }
        this.f64058b.put(str, uGCSearchSuggestData);
        if (!Intrinsics.c(keyword, str)) {
            this.f64058b.put(keyword, uGCSearchSuggestData);
        }
        this.f64061e.n(uGCSearchSuggestData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean p() {
        String value;
        ConfigBean c11 = sm.f.f75530c.a().c("sa_search_suggest_use_google_for_showbox", true);
        if (c11 == null || (value = c11.getValue()) == null) {
            return false;
        }
        return Intrinsics.c(StringsKt.m1(value), Boolean.TRUE);
    }

    private final void q(String str) {
        f().b(str).E(qz.a.c()).B(new C0795c(str), new d());
    }

    private final void r(String str, int i11, String str2) {
        f().g(str, i11, str2).E(qz.a.c()).subscribe(new e(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final fr.c s() {
        return new fr.c();
    }

    private final boolean t() {
        return o();
    }

    public final String g() {
        return o() ? "gp_sug" : "mb_sug";
    }

    public final void h(String pageFrom) {
        Intrinsics.h(pageFrom, "pageFrom");
        f().e(pageFrom).E(qz.a.c()).subscribe(new a());
    }

    public final void i(String pageFrom) {
        Intrinsics.h(pageFrom, "pageFrom");
        f().f(pageFrom).E(qz.a.c()).subscribe(new b());
    }

    public final void j(String keyword, int i11, String pageFrom) {
        Intrinsics.h(keyword, "keyword");
        Intrinsics.h(pageFrom, "pageFrom");
        if (t()) {
            q(keyword);
        } else {
            r(keyword, i11, pageFrom);
        }
    }

    public final b0 k() {
        return this.f64059c;
    }

    public final b0 l() {
        return this.f64060d;
    }

    public final b0 m() {
        return this.f64061e;
    }

    public final boolean o() {
        return ((Boolean) this.f64064h.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.view.t0
    public void onCleared() {
        io.reactivex.rxjava3.disposables.c cVar;
        super.onCleared();
        io.reactivex.rxjava3.disposables.c cVar2 = this.f64063g;
        if (cVar2 == null || cVar2.isDisposed() || (cVar = this.f64063g) == null) {
            return;
        }
        cVar.dispose();
    }
}
