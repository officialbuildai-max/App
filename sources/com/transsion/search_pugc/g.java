package com.transsion.search_pugc;

import android.content.Context;
import androidx.view.Lifecycle;
import androidx.view.u;
import androidx.view.w;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.search_pugc.bean.SearchResultItem;
import com.transsion.search_pugc.bean.SearchSuggestItem;
import com.transsion.search_pugc.bean.SearchTab;
import com.transsion.search_pugc.bean.SecondTab;
import com.transsion.search_pugc.fragment.hot.SearchHotFragment;
import com.transsion.ugcvideodetail.api.bean.UGCCollection;
import com.transsion.ugcvideodetail.api.bean.UGCVerticalRank;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsion.ugcvideodetail.api.bean.UGCVideoBelongToCollection;
import com.transsion.ugcvideodetail.api.bean.UGCVideoHashTag;
import com.transsion.web.api.WebConstants;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class g {

    /* renamed from: h, reason: collision with root package name */
    public static final b f52532h = new b(null);

    /* renamed from: i, reason: collision with root package name */
    private static final Map f52533i = new LinkedHashMap();

    /* renamed from: j, reason: collision with root package name */
    private static final Lazy f52534j = LazyKt.b(new Function0() { // from class: com.transsion.search_pugc.f
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            g d11;
            d11 = g.d();
            return d11;
        }
    });

    /* renamed from: a, reason: collision with root package name */
    private final u f52535a;

    /* renamed from: b, reason: collision with root package name */
    private final Map f52536b;

    /* renamed from: c, reason: collision with root package name */
    private final String f52537c;

    /* renamed from: d, reason: collision with root package name */
    private String f52538d;

    /* renamed from: e, reason: collision with root package name */
    private final String f52539e;

    /* renamed from: f, reason: collision with root package name */
    private String f52540f;

    /* renamed from: g, reason: collision with root package name */
    private String f52541g;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class a implements u {

        /* renamed from: a, reason: collision with root package name */
        public static final a f52542a;

        /* renamed from: b, reason: collision with root package name */
        private static final w f52543b;

        static {
            a aVar = new a();
            f52542a = aVar;
            f52543b = new w(aVar);
        }

        private a() {
        }

        @Override // androidx.view.u
        public Lifecycle getLifecycle() {
            return f52543b;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b {

        /* loaded from: classes6.dex */
        public static final class a implements androidx.view.f {
            a() {
            }

            @Override // androidx.view.f
            public /* synthetic */ void onCreate(u uVar) {
                androidx.view.e.a(this, uVar);
            }

            @Override // androidx.view.f
            public void onDestroy(u owner) {
                Intrinsics.h(owner, "owner");
                g.f52533i.remove(owner);
            }

            @Override // androidx.view.f
            public /* synthetic */ void onPause(u uVar) {
                androidx.view.e.c(this, uVar);
            }

            @Override // androidx.view.f
            public /* synthetic */ void onResume(u uVar) {
                androidx.view.e.d(this, uVar);
            }

            @Override // androidx.view.f
            public /* synthetic */ void onStart(u uVar) {
                androidx.view.e.e(this, uVar);
            }

            @Override // androidx.view.f
            public /* synthetic */ void onStop(u uVar) {
                androidx.view.e.f(this, uVar);
            }
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final g c() {
            return (g) g.f52534j.getValue();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final g a(Context context) {
            if (context != 0) {
                g b11 = context instanceof u ? g.f52532h.b((u) context) : g.f52532h.c();
                if (b11 != null) {
                    return b11;
                }
            }
            return c();
        }

        public final g b(u uVar) {
            g gVar = (g) g.f52533i.get(uVar);
            return gVar == null ? c() : gVar;
        }

        public final g d(u lifecycleOwner) {
            Intrinsics.h(lifecycleOwner, "lifecycleOwner");
            Map map = g.f52533i;
            Object obj = map.get(lifecycleOwner);
            if (obj == null) {
                obj = new g(lifecycleOwner, null);
                lifecycleOwner.getLifecycle().a(new a());
                map.put(lifecycleOwner, obj);
            }
            return (g) obj;
        }
    }

    private g(u uVar) {
        this.f52535a = uVar;
        this.f52536b = new LinkedHashMap();
        this.f52537c = hj.i.f64628a.i();
        this.f52538d = "mb_sug";
        String uuid = UUID.randomUUID().toString();
        Intrinsics.g(uuid, "toString(...)");
        this.f52539e = uuid;
    }

    public /* synthetic */ g(u uVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(uVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final g d() {
        return new g(a.f52542a);
    }

    private final HashMap h() {
        HashMap hashMap = new HashMap();
        hashMap.put("search_id", this.f52539e);
        hashMap.put("sug_source", this.f52538d);
        return hashMap;
    }

    public final void A(SearchSuggestItem searchSuggestItem, Integer num, String keyWord, String str) {
        String str2;
        Intrinsics.h(keyWord, "keyWord");
        HashMap h11 = h();
        h11.put("keyword", keyWord);
        if (searchSuggestItem == null || (str2 = searchSuggestItem.getWord()) == null) {
            str2 = "";
        }
        h11.put(CampaignEx.JSON_KEY_TITLE, str2);
        h11.put(RequestParameters.POSITION, String.valueOf(num));
        if (str == null) {
            str = "";
        }
        h11.put("ops", str);
        hj.i.f64628a.D("/ugc_search/search_suggest", h11);
    }

    public final void B(SearchSuggestItem searchSuggestItem, int i11, String keyWord, String str) {
        String str2;
        Intrinsics.h(keyWord, "keyWord");
        HashMap h11 = h();
        h11.put("keyword", keyWord);
        if (searchSuggestItem == null || (str2 = searchSuggestItem.getWord()) == null) {
            str2 = "";
        }
        h11.put(CampaignEx.JSON_KEY_TITLE, str2);
        h11.put(RequestParameters.POSITION, String.valueOf(i11));
        if (str == null) {
            str = "";
        }
        h11.put("ops", str);
        hj.i.f64628a.p("/ugc_search/search_suggest", h11);
    }

    public final void C(String str, SearchTab searchTab, String str2) {
        String str3;
        HashMap h11 = h();
        if (str == null) {
            str = "";
        }
        h11.put("keyword", str);
        if (searchTab == null || (str3 = searchTab.getName()) == null) {
            str3 = "";
        }
        h11.put("page_tab_name", str3);
        h11.put("module_name", "result_tab_click");
        h11.put("search_from", String.valueOf(this.f52540f));
        h11.put("content_type", "ugc_video");
        if (str2 == null) {
            str2 = "";
        }
        h11.put("ops", str2);
        com.transsion.baselib.helper.a.f43316a.f("/ugc_search/search_result", h11);
    }

    public final void D(hj.b bVar) {
        if (bVar != null) {
            bVar.g().put("search_from", this.f52540f);
            bVar.g().put("keyword", this.f52541g);
        }
    }

    public final void E(String searchFrom, String keyword) {
        Intrinsics.h(searchFrom, "searchFrom");
        Intrinsics.h(keyword, "keyword");
        this.f52540f = searchFrom;
        this.f52541g = keyword;
    }

    public final void F(String str) {
        Intrinsics.h(str, "<set-?>");
        this.f52538d = str;
    }

    public final String e() {
        return this.f52541g;
    }

    public final String f() {
        return this.f52537c;
    }

    public final hj.b g(String pageName) {
        Intrinsics.h(pageName, "pageName");
        hj.b bVar = new hj.b(pageName, false, 2, null);
        bVar.g().put("search_id", this.f52539e);
        bVar.g().put("sug_source", this.f52538d);
        return bVar;
    }

    public final void i(hj.b bVar) {
        Long l11;
        if (bVar == null || (l11 = (Long) this.f52536b.remove(bVar)) == null) {
            return;
        }
        bVar.g().put("load_duration", String.valueOf(System.currentTimeMillis() - l11.longValue()));
    }

    public final void j(hj.b bVar) {
        if (bVar != null) {
            Map map = this.f52536b;
            Object obj = map.get(bVar);
            if (obj == null) {
                obj = Long.valueOf(System.currentTimeMillis());
                map.put(bVar, obj);
            }
            ((Number) obj).longValue();
        }
    }

    public final void k(UGCVideo uGCVideo, int i11, String str, SearchTab tab, SecondTab secondTab) {
        String str2;
        String str3;
        String str4;
        String ops;
        UGCVideoBelongToCollection belongToCollection;
        Intrinsics.h(tab, "tab");
        HashMap h11 = h();
        String str5 = "";
        if (str == null) {
            str = "";
        }
        h11.put("keyword", str);
        h11.put(RequestParameters.POSITION, String.valueOf(i11));
        String valueOf = String.valueOf(tab.getName());
        if (secondTab != null) {
            valueOf = ((Object) valueOf) + "/" + secondTab.getTagValue();
        }
        h11.put("page_tab_name", valueOf);
        h11.put("content_type", "ugc_video");
        h11.put("search_from", String.valueOf(this.f52540f));
        h11.put("module_name", WebConstants.FIELD_ITEM);
        if (uGCVideo == null || (str2 = uGCVideo.getUgcVideoId()) == null) {
            str2 = "";
        }
        h11.put("content_id", str2);
        if (uGCVideo == null || (str3 = uGCVideo.getSubjectId()) == null) {
            str3 = "";
        }
        h11.put("refer_subject_id", str3);
        if (uGCVideo == null || (belongToCollection = uGCVideo.getBelongToCollection()) == null || (str4 = belongToCollection.getCollectionId()) == null) {
            str4 = "";
        }
        h11.put("belong_to_collection_id", str4);
        if (uGCVideo != null && (ops = uGCVideo.getOps()) != null) {
            str5 = ops;
        }
        h11.put("ops", str5);
        com.transsion.baselib.helper.a.f43316a.e("/ugc_search/search_result", h11);
    }

    public final void l(UGCVideo uGCVideo, int i11, String str, SearchTab tab, SecondTab secondTab) {
        String str2;
        String str3;
        String str4;
        String ops;
        UGCVideoBelongToCollection belongToCollection;
        Intrinsics.h(tab, "tab");
        HashMap h11 = h();
        String str5 = "";
        if (str == null) {
            str = "";
        }
        h11.put("keyword", str);
        h11.put(RequestParameters.POSITION, String.valueOf(i11));
        String valueOf = String.valueOf(tab.getName());
        if (secondTab != null) {
            valueOf = ((Object) valueOf) + "/" + secondTab.getTagValue();
        }
        h11.put("page_tab_name", valueOf);
        h11.put("content_type", "ugc_video");
        h11.put("search_from", String.valueOf(this.f52540f));
        h11.put("module_name", WebConstants.FIELD_ITEM);
        if (uGCVideo == null || (str2 = uGCVideo.getUgcVideoId()) == null) {
            str2 = "";
        }
        h11.put("content_id", str2);
        if (uGCVideo == null || (str3 = uGCVideo.getSubjectId()) == null) {
            str3 = "";
        }
        h11.put("refer_subject_id", str3);
        if (uGCVideo == null || (belongToCollection = uGCVideo.getBelongToCollection()) == null || (str4 = belongToCollection.getCollectionId()) == null) {
            str4 = "";
        }
        h11.put("belong_to_collection_id", str4);
        if (uGCVideo != null && (ops = uGCVideo.getOps()) != null) {
            str5 = ops;
        }
        h11.put("ops", str5);
        com.transsion.baselib.helper.a.f43316a.f("/ugc_search/search_result", h11);
    }

    public final void m() {
        HashMap h11 = h();
        h11.put("module_name", "history_delete");
        com.transsion.baselib.helper.a.f43316a.f(SearchHotFragment.PAGE_NAME, h11);
    }

    public final void n(boolean z10) {
        HashMap h11 = h();
        h11.put("isExpand", String.valueOf(z10));
        h11.put("module_name", "history_expand");
        com.transsion.baselib.helper.a.f43316a.f(SearchHotFragment.PAGE_NAME, h11);
    }

    public final void o(String str, int i11) {
        HashMap h11 = h();
        if (str == null) {
            str = "";
        }
        h11.put("keyword", str);
        h11.put(RequestParameters.POSITION, String.valueOf(i11));
        h11.put("module_name", "history_browse");
        h11.put("content_type", "ugc_video");
        com.transsion.baselib.helper.a.f43316a.a(SearchHotFragment.PAGE_NAME, h11);
    }

    public final void p(String keyWord, int i11) {
        Intrinsics.h(keyWord, "keyWord");
        HashMap h11 = h();
        h11.put("keyword", keyWord);
        h11.put(RequestParameters.POSITION, String.valueOf(i11));
        h11.put("module_name", "history_click");
        h11.put("content_type", "ugc_video");
        com.transsion.baselib.helper.a.f43316a.f(SearchHotFragment.PAGE_NAME, h11);
    }

    public final void q(String str, int i11) {
        HashMap h11 = h();
        if (str == null) {
            str = "";
        }
        h11.put("keyword", str);
        h11.put(RequestParameters.POSITION, String.valueOf(i11));
        h11.put("module_name", "hot_word_browse");
        h11.put("content_type", "ugc_video");
        com.transsion.baselib.helper.a.f43316a.e(SearchHotFragment.PAGE_NAME, h11);
    }

    public final void r(String keyword, int i11) {
        Intrinsics.h(keyword, "keyword");
        HashMap h11 = h();
        h11.put("keyword", keyword);
        h11.put(RequestParameters.POSITION, String.valueOf(i11));
        h11.put("module_name", "hot_word_click");
        h11.put("content_type", "ugc_video");
        com.transsion.baselib.helper.a.f43316a.f(SearchHotFragment.PAGE_NAME, h11);
    }

    public final void s(UGCVideo ugcVideo, int i11, String tabName, int i12) {
        String str;
        Intrinsics.h(ugcVideo, "ugcVideo");
        Intrinsics.h(tabName, "tabName");
        HashMap h11 = h();
        h11.put("module_name", "hot_rank_browse");
        String ugcVideoId = ugcVideo.getUgcVideoId();
        if (ugcVideoId == null) {
            ugcVideoId = "";
        }
        h11.put("content_id", ugcVideoId);
        h11.put(RequestParameters.POSITION, String.valueOf(i11));
        String subjectId = ugcVideo.getSubjectId();
        if (subjectId == null) {
            subjectId = "";
        }
        h11.put("refer_subject_id", subjectId);
        UGCVideoBelongToCollection belongToCollection = ugcVideo.getBelongToCollection();
        if (belongToCollection == null || (str = belongToCollection.getCollectionId()) == null) {
            str = "";
        }
        h11.put("belong_to_collection_id", str);
        h11.put("content_type", "ugc_video");
        h11.put("page_tab_name", tabName);
        String ops = ugcVideo.getOps();
        h11.put("ops", ops != null ? ops : "");
        com.transsion.baselib.helper.a.f43316a.a(SearchHotFragment.PAGE_NAME, h11);
    }

    public final void t(UGCVideo ugcVideo, int i11, String tabName, int i12) {
        String str;
        Intrinsics.h(ugcVideo, "ugcVideo");
        Intrinsics.h(tabName, "tabName");
        HashMap h11 = h();
        h11.put("module_name", "hot_rank_click");
        String ugcVideoId = ugcVideo.getUgcVideoId();
        if (ugcVideoId == null) {
            ugcVideoId = "";
        }
        h11.put("content_id", ugcVideoId);
        h11.put(RequestParameters.POSITION, String.valueOf(i11));
        String subjectId = ugcVideo.getSubjectId();
        if (subjectId == null) {
            subjectId = "";
        }
        h11.put("refer_subject_id", subjectId);
        UGCVideoBelongToCollection belongToCollection = ugcVideo.getBelongToCollection();
        if (belongToCollection == null || (str = belongToCollection.getCollectionId()) == null) {
            str = "";
        }
        h11.put("belong_to_collection_id", str);
        h11.put("content_type", "ugc_video");
        h11.put("page_tab_name", tabName);
        String ops = ugcVideo.getOps();
        h11.put("ops", ops != null ? ops : "");
        com.transsion.baselib.helper.a.f43316a.f(SearchHotFragment.PAGE_NAME, h11);
    }

    public final void u(UGCVideo ugcVideo, int i11, String str, SearchTab tab, SecondTab secondTab) {
        String str2;
        Intrinsics.h(ugcVideo, "ugcVideo");
        Intrinsics.h(tab, "tab");
        HashMap h11 = h();
        if (str == null) {
            str = "";
        }
        h11.put("keyword", str);
        h11.put(RequestParameters.POSITION, String.valueOf(i11));
        h11.put("content_type", "ugc_video");
        h11.put("module_name", WebConstants.FIELD_ITEM);
        String ugcVideoId = ugcVideo.getUgcVideoId();
        if (ugcVideoId == null) {
            ugcVideoId = "";
        }
        h11.put("content_id", ugcVideoId);
        String subjectId = ugcVideo.getSubjectId();
        if (subjectId == null) {
            subjectId = "";
        }
        h11.put("refer_subject_id", subjectId);
        UGCVideoBelongToCollection belongToCollection = ugcVideo.getBelongToCollection();
        if (belongToCollection == null || (str2 = belongToCollection.getCollectionId()) == null) {
            str2 = "";
        }
        h11.put("belong_to_collection_id", str2);
        String valueOf = String.valueOf(tab.getName());
        if (secondTab != null) {
            valueOf = ((Object) valueOf) + "/" + secondTab.getTagValue();
        }
        h11.put("page_tab_name", valueOf);
        h11.put("search_from", String.valueOf(this.f52540f));
        String ops = ugcVideo.getOps();
        h11.put("ops", ops != null ? ops : "");
        com.transsion.baselib.helper.a.f43316a.f("/ugc_search/search_result", h11);
    }

    public final void v(SearchResultItem item, int i11, long j11, String str, SearchTab searchTab, SecondTab secondTab) {
        String str2;
        String str3;
        String str4;
        String ops;
        UGCVideoBelongToCollection belongToCollection;
        String collectionId;
        String str5;
        String title;
        String id2;
        Intrinsics.h(item, "item");
        HashMap h11 = h();
        String str6 = "";
        if (str == null) {
            str = "";
        }
        h11.put("keyword", str);
        h11.put(RequestParameters.POSITION, String.valueOf(i11));
        String valueOf = String.valueOf(searchTab != null ? searchTab.getName() : null);
        if (secondTab != null) {
            valueOf = ((Object) valueOf) + "/" + secondTab.getTagValue();
        }
        h11.put("page_tab_name", valueOf);
        h11.put("search_from", String.valueOf(this.f52540f));
        String topicType = item.getTopicType();
        if (topicType != null) {
            switch (topicType.hashCode()) {
                case -1989652851:
                    if (topicType.equals("UGC_VIDEO")) {
                        h11.put("module_name", WebConstants.FIELD_ITEM);
                        h11.put("content_type", "ugc_video");
                        UGCVideo video = item.getVideo();
                        if (video == null || (str2 = video.getUgcVideoId()) == null) {
                            str2 = "";
                        }
                        h11.put("content_id", str2);
                        UGCVideo video2 = item.getVideo();
                        if (video2 == null || (str3 = video2.getSubjectId()) == null) {
                            str3 = "";
                        }
                        h11.put("refer_subject_id", str3);
                        UGCVideo video3 = item.getVideo();
                        if (video3 == null || (belongToCollection = video3.getBelongToCollection()) == null || (str4 = belongToCollection.getCollectionId()) == null) {
                            str4 = "";
                        }
                        h11.put("belong_to_collection_id", str4);
                        UGCVideo video4 = item.getVideo();
                        if (video4 != null && (ops = video4.getOps()) != null) {
                            str6 = ops;
                        }
                        h11.put("ops", str6);
                        break;
                    }
                    break;
                case 511113132:
                    if (topicType.equals("UGC_COLLECTION")) {
                        h11.put("module_name", "collection");
                        h11.put("content_type", "collection");
                        UGCCollection collection = item.getCollection();
                        if (collection != null && (collectionId = collection.getCollectionId()) != null) {
                            str6 = collectionId;
                        }
                        h11.put("content_id", str6);
                        h11.put("ops", item.getOps());
                        break;
                    }
                    break;
                case 932115657:
                    if (topicType.equals("HASH_TAG")) {
                        h11.put("module_name", "hashtag");
                        h11.put("content_type", "hashtag");
                        UGCVideoHashTag hashTag = item.getHashTag();
                        if (hashTag == null || (str5 = hashTag.getReferId()) == null) {
                            str5 = "";
                        }
                        h11.put("content_id", str5);
                        UGCVideoHashTag hashTag2 = item.getHashTag();
                        if (hashTag2 != null && (title = hashTag2.getTitle()) != null) {
                            str6 = title;
                        }
                        h11.put(CampaignEx.JSON_KEY_TITLE, str6);
                        break;
                    }
                    break;
                case 2033770325:
                    if (topicType.equals("VERTICAL_RANK")) {
                        h11.put("module_name", "verticalRank");
                        h11.put("content_type", "vertical_rank");
                        UGCVerticalRank verticalRank = item.getVerticalRank();
                        if (verticalRank != null && (id2 = verticalRank.getId()) != null) {
                            str6 = id2;
                        }
                        h11.put("content_id", str6);
                        h11.put("ops", item.getOps());
                        break;
                    }
                    break;
            }
        }
        com.transsion.baselib.helper.a.f43316a.e("/ugc_search/search_result", h11);
    }

    public final void w(SearchResultItem item, int i11, String str, SearchTab tab, SecondTab secondTab) {
        String str2;
        String str3;
        String str4;
        String ops;
        UGCVideoBelongToCollection belongToCollection;
        String collectionId;
        String str5;
        String title;
        String str6;
        String ops2;
        Intrinsics.h(item, "item");
        Intrinsics.h(tab, "tab");
        HashMap h11 = h();
        String str7 = "";
        if (str == null) {
            str = "";
        }
        h11.put("keyword", str);
        h11.put(RequestParameters.POSITION, String.valueOf(i11));
        String valueOf = String.valueOf(tab.getName());
        if (secondTab != null) {
            valueOf = ((Object) valueOf) + "/" + secondTab.getTagValue();
        }
        h11.put("page_tab_name", valueOf);
        h11.put("content_type", "ugc_video");
        h11.put("search_from", String.valueOf(this.f52540f));
        String topicType = item.getTopicType();
        if (topicType != null) {
            switch (topicType.hashCode()) {
                case -1989652851:
                    if (topicType.equals("UGC_VIDEO")) {
                        h11.put("module_name", WebConstants.FIELD_ITEM);
                        UGCVideo video = item.getVideo();
                        if (video == null || (str2 = video.getUgcVideoId()) == null) {
                            str2 = "";
                        }
                        h11.put("content_id", str2);
                        UGCVideo video2 = item.getVideo();
                        if (video2 == null || (str3 = video2.getSubjectId()) == null) {
                            str3 = "";
                        }
                        h11.put("refer_subject_id", str3);
                        UGCVideo video3 = item.getVideo();
                        if (video3 == null || (belongToCollection = video3.getBelongToCollection()) == null || (str4 = belongToCollection.getCollectionId()) == null) {
                            str4 = "";
                        }
                        h11.put("belong_to_collection_id", str4);
                        UGCVideo video4 = item.getVideo();
                        if (video4 != null && (ops = video4.getOps()) != null) {
                            str7 = ops;
                        }
                        h11.put("ops", str7);
                        break;
                    }
                    break;
                case 511113132:
                    if (topicType.equals("UGC_COLLECTION")) {
                        h11.put("module_name", "collection");
                        UGCCollection collection = item.getCollection();
                        if (collection != null && (collectionId = collection.getCollectionId()) != null) {
                            str7 = collectionId;
                        }
                        h11.put("content_id", str7);
                        h11.put("ops", item.getOps());
                        break;
                    }
                    break;
                case 932115657:
                    if (topicType.equals("HASH_TAG")) {
                        h11.put("module_name", "hashtag");
                        UGCVideoHashTag hashTag = item.getHashTag();
                        if (hashTag == null || (str5 = hashTag.getReferId()) == null) {
                            str5 = "";
                        }
                        h11.put("content_id", str5);
                        UGCVideoHashTag hashTag2 = item.getHashTag();
                        if (hashTag2 != null && (title = hashTag2.getTitle()) != null) {
                            str7 = title;
                        }
                        h11.put(CampaignEx.JSON_KEY_TITLE, str7);
                        h11.put("ops", item.getOps());
                        break;
                    }
                    break;
                case 2033770325:
                    if (topicType.equals("VERTICAL_RANK")) {
                        h11.put("module_name", "verticalRank");
                        UGCVerticalRank verticalRank = item.getVerticalRank();
                        if (verticalRank == null || (str6 = verticalRank.getId()) == null) {
                            str6 = "";
                        }
                        h11.put("content_id", str6);
                        UGCVideo video5 = item.getVideo();
                        if (video5 != null && (ops2 = video5.getOps()) != null) {
                            str7 = ops2;
                        }
                        h11.put("ops", str7);
                        h11.put("ops", item.getOps());
                        break;
                    }
                    break;
            }
        }
        com.transsion.baselib.helper.a.f43316a.f("/ugc_search/search_result", h11);
    }

    public final void x(String searchResult, String str) {
        Intrinsics.h(searchResult, "searchResult");
        HashMap h11 = h();
        h11.put("keyword", String.valueOf(this.f52541g));
        h11.put("search_from", String.valueOf(this.f52540f));
        h11.put("search_result", searchResult);
        if (str != null) {
            h11.put("ops", str);
        }
        hj.i.f64628a.F(SearchHotFragment.PAGE_NAME, "search", h11);
    }

    public final void y(UGCVideo ugcVideo, int i11, String str, SearchTab tab, SecondTab secondTab) {
        String str2;
        Intrinsics.h(ugcVideo, "ugcVideo");
        Intrinsics.h(tab, "tab");
        HashMap h11 = h();
        if (str == null) {
            str = "";
        }
        h11.put("keyword", str);
        h11.put(RequestParameters.POSITION, String.valueOf(i11));
        h11.put("content_type", "ugc_video");
        h11.put("module_name", WebConstants.FIELD_ITEM);
        String ugcVideoId = ugcVideo.getUgcVideoId();
        if (ugcVideoId == null) {
            ugcVideoId = "";
        }
        h11.put("content_id", ugcVideoId);
        String subjectId = ugcVideo.getSubjectId();
        if (subjectId == null) {
            subjectId = "";
        }
        h11.put("refer_subject_id", subjectId);
        UGCVideoBelongToCollection belongToCollection = ugcVideo.getBelongToCollection();
        if (belongToCollection == null || (str2 = belongToCollection.getCollectionId()) == null) {
            str2 = "";
        }
        h11.put("belong_to_collection_id", str2);
        String valueOf = String.valueOf(tab.getName());
        if (secondTab != null) {
            valueOf = ((Object) valueOf) + "/" + secondTab.getTagValue();
        }
        h11.put("page_tab_name", valueOf);
        h11.put("search_from", String.valueOf(this.f52540f));
        String ops = ugcVideo.getOps();
        h11.put("ops", ops != null ? ops : "");
        com.transsion.baselib.helper.a.f43316a.f("/ugc_search/search_result", h11);
    }

    public final void z(String str, SearchTab searchTab, SecondTab secondTab, String str2) {
        HashMap h11 = h();
        if (str == null) {
            str = "";
        }
        h11.put("keyword", str);
        String valueOf = String.valueOf(searchTab != null ? searchTab.getName() : null);
        if (secondTab != null) {
            valueOf = ((Object) valueOf) + "/" + secondTab.getTagValue();
        }
        h11.put("page_tab_name", valueOf);
        h11.put("module_name", "result_second_tab_click");
        h11.put("search_from", String.valueOf(this.f52540f));
        h11.put("content_type", "ugc_video");
        if (str2 == null) {
            str2 = "";
        }
        h11.put("ops", str2);
        com.transsion.baselib.helper.a.f43316a.f("/ugc_search/search_result", h11);
    }
}
