package fr;

import com.transsion.search.bean.GoogleSuggestResponse;
import com.transsion.search_pugc.bean.SearchSuggestItem;
import com.transsion.search_pugc.bean.UGCSearchSuggestData;
import io.reactivex.rxjava3.core.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lz.h;
import okhttp3.ResponseBody;
import yq.f;

/* loaded from: classes7.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name */
    public static final a f62579b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final Lazy f62580a = LazyKt.b(new Function0() { // from class: fr.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            a h11;
            h11 = c.h();
            return h11;
        }
    });

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class b implements h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f62581a;

        b(String str) {
            this.f62581a = str;
        }

        @Override // lz.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final UGCSearchSuggestData apply(ResponseBody body) {
            Intrinsics.h(body, "body");
            GoogleSuggestResponse e11 = yq.b.f79170a.e(body.string());
            String keyword = e11.getKeyword();
            String str = this.f62581a;
            if (StringsKt.q0(keyword)) {
                keyword = str;
            }
            List<String> suggestions = e11.getSuggestions();
            ArrayList arrayList = new ArrayList(CollectionsKt.v(suggestions, 10));
            Iterator<T> it = suggestions.iterator();
            while (it.hasNext()) {
                arrayList.add(new SearchSuggestItem("", (String) it.next(), null));
            }
            return new UGCSearchSuggestData(arrayList, keyword, "");
        }
    }

    private final String c() {
        return vg.a.f77447a.a();
    }

    private final fr.a d() {
        return (fr.a) this.f62580a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final fr.a h() {
        return (fr.a) zg.c.f79537e.a().h(fr.a.class);
    }

    public final j b(String keyword) {
        Intrinsics.h(keyword, "keyword");
        j u11 = f.f79171a.f(keyword).u(new b(keyword));
        Intrinsics.g(u11, "map(...)");
        return u11;
    }

    public final j e(String pageFrom) {
        Intrinsics.h(pageFrom, "pageFrom");
        return d().d(c(), pageFrom);
    }

    public final j f(String pageFrom) {
        Intrinsics.h(pageFrom, "pageFrom");
        return d().c(c(), pageFrom);
    }

    public final j g(String keyword, int i11, String pageFrom) {
        Intrinsics.h(keyword, "keyword");
        Intrinsics.h(pageFrom, "pageFrom");
        return d().a(c(), keyword, i11, pageFrom);
    }
}
