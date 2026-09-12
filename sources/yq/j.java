package yq;

import com.google.gson.JsonObject;
import com.transsion.search.bean.GoogleSuggestResponse;
import com.transsion.search.bean.SearchSuggestEntity;
import com.transsion.search.bean.SuggestEntity;
import com.transsion.search.net.RequestJoinGroupEntity;
import com.transsion.search.net.RequestSearchEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import yq.g;

/* loaded from: classes6.dex */
public final class j {

    /* renamed from: b, reason: collision with root package name */
    public static final a f79176b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final Lazy f79177a = LazyKt.b(new Function0() { // from class: yq.i
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            g j11;
            j11 = j.j();
            return j11;
        }
    });

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    static final class b implements lz.h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f79178a;

        b(String str) {
            this.f79178a = str;
        }

        @Override // lz.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final SearchSuggestEntity apply(ResponseBody body) {
            Intrinsics.h(body, "body");
            GoogleSuggestResponse e11 = yq.b.f79170a.e(body.string());
            String keyword = e11.getKeyword();
            String str = this.f79178a;
            if (StringsKt.q0(keyword)) {
                keyword = str;
            }
            List<String> suggestions = e11.getSuggestions();
            ArrayList arrayList = new ArrayList(CollectionsKt.v(suggestions, 10));
            Iterator<T> it = suggestions.iterator();
            while (it.hasNext()) {
                arrayList.add(new SuggestEntity(0, (String) it.next(), null, null, null));
            }
            return new SearchSuggestEntity(arrayList, keyword, "");
        }
    }

    private final String c() {
        return vg.a.f77447a.a();
    }

    private final g f() {
        return (g) this.f79177a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final g j() {
        return (g) zg.c.f79537e.a().h(g.class);
    }

    public final io.reactivex.rxjava3.core.j b(String keyword) {
        Intrinsics.h(keyword, "keyword");
        io.reactivex.rxjava3.core.j u11 = f.f79171a.f(keyword).u(new b(keyword));
        Intrinsics.g(u11, "map(...)");
        return u11;
    }

    public final io.reactivex.rxjava3.core.j d() {
        return g.a.a(f(), 1, 0, 2, null);
    }

    public final io.reactivex.rxjava3.core.j e(String keyword) {
        Intrinsics.h(keyword, "keyword");
        return g.a.b(f(), keyword, 0, 0, 6, null);
    }

    public final io.reactivex.rxjava3.core.j g(RequestJoinGroupEntity entity) {
        Intrinsics.h(entity, "entity");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("groupId", entity.getGroupId());
        RequestBody.Companion companion = RequestBody.INSTANCE;
        String jsonElement = jsonObject.toString();
        Intrinsics.g(jsonElement, "toString(...)");
        return f().b(c(), companion.create(jsonElement, MediaType.INSTANCE.parse("application/json")));
    }

    public final io.reactivex.rxjava3.core.j h(RequestSearchEntity entity) {
        Intrinsics.h(entity, "entity");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("page", Integer.valueOf(entity.getPage()));
        jsonObject.addProperty("keyword", entity.getKeyword());
        RequestBody.Companion companion = RequestBody.INSTANCE;
        String jsonElement = jsonObject.toString();
        Intrinsics.g(jsonElement, "toString(...)");
        companion.create(jsonElement, MediaType.INSTANCE.parse("application/json"));
        return f().a(c(), entity.getPage(), entity.getKeyword());
    }

    public final Object i(RequestSearchEntity requestSearchEntity, Continuation continuation) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("page", Boxing.d(requestSearchEntity.getPage()));
        jsonObject.addProperty("perPage", Boxing.d(requestSearchEntity.getPerPage()));
        jsonObject.addProperty("keyword", requestSearchEntity.getKeyword());
        jsonObject.addProperty("subjectType", Boxing.d(requestSearchEntity.getSubjectType()));
        jsonObject.addProperty("resultMode", Boxing.d(1));
        RequestBody.Companion companion = RequestBody.INSTANCE;
        String jsonElement = jsonObject.toString();
        Intrinsics.g(jsonElement, "toString(...)");
        return f().e(c(), companion.create(jsonElement, MediaType.INSTANCE.parse("application/json")), continuation);
    }
}
