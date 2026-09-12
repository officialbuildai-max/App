package com.transsion.ugcvideodetail.hepler;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsion.ugcvideodetail.api.bean.UGCVideoBelongToCollection;
import com.transsion.web.api.WebConstants;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f56490a = new h();

    private h() {
    }

    public final void a(String str, String moduleName, UGCVideo uGCVideo, String str2, String str3, String str4, String str5, Boolean bool, Integer num) {
        String str6;
        String str7;
        Intrinsics.h(moduleName, "moduleName");
        if (str == null || uGCVideo == null) {
            return;
        }
        Pair a11 = TuplesKt.a("module_name", moduleName);
        String ugcVideoId = uGCVideo.getUgcVideoId();
        String str8 = "";
        if (ugcVideoId == null) {
            ugcVideoId = "";
        }
        Pair a12 = TuplesKt.a("content_id", ugcVideoId);
        UGCVideoBelongToCollection belongToCollection = uGCVideo.getBelongToCollection();
        if (belongToCollection == null || (str6 = belongToCollection.getCollectionId()) == null) {
            str6 = "";
        }
        Pair a13 = TuplesKt.a("belong_to_collection_id", str6);
        Pair a14 = TuplesKt.a("content_type", "ugc_video");
        String ops = uGCVideo.getOps();
        if (ops == null) {
            ops = "";
        }
        Map m11 = MapsKt.m(a11, a12, a13, a14, TuplesKt.a("ops", ops));
        if (Intrinsics.c(moduleName, "hash_tag") && str2 != null && str2.length() != 0) {
            m11.put("tag_name", str2);
        }
        if (Intrinsics.c(moduleName, "search") && str2 != null && str2.length() != 0) {
            List<String> searchWord = uGCVideo.getSearchWord();
            if (searchWord != null && (str7 = (String) CollectionsKt.k0(searchWord)) != null) {
                str8 = str7;
            }
            m11.put("keyword", str8);
        }
        if (str3 != null) {
            m11.put("track_id", str3);
        }
        if (bool != null) {
            m11.put("is_collection", String.valueOf(bool.booleanValue()));
        }
        if (str4 != null) {
            m11.put("parent_track_id", str4);
        }
        if (str5 != null) {
            m11.put("parent_content_id", str5);
        }
        if (num != null) {
            m11.put(RequestParameters.POSITION, String.valueOf(num.intValue()));
        }
        hj.i.f64628a.p(str, m11);
    }

    public final void c(String pageName, UGCVideo item, int i11, String str, String str2, String str3, String str4) {
        String str5;
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(item, "item");
        Pair a11 = TuplesKt.a("module_name", WebConstants.FIELD_ITEM);
        Pair a12 = TuplesKt.a("page_tab_name", "foryou");
        String ugcVideoId = item.getUgcVideoId();
        if (ugcVideoId == null) {
            ugcVideoId = "";
        }
        Pair a13 = TuplesKt.a("content_id", ugcVideoId);
        UGCVideoBelongToCollection belongToCollection = item.getBelongToCollection();
        if (belongToCollection == null || (str5 = belongToCollection.getCollectionId()) == null) {
            str5 = "";
        }
        Pair a14 = TuplesKt.a("belong_to_collection_id", str5);
        Pair a15 = TuplesKt.a("content_type", "ugc_video");
        String subjectId = item.getSubjectId();
        if (subjectId == null) {
            subjectId = "";
        }
        Pair a16 = TuplesKt.a("refer_subject_id", subjectId);
        String ops = item.getOps();
        if (ops == null) {
            ops = "";
        }
        Pair a17 = TuplesKt.a("ops", ops);
        Pair a18 = TuplesKt.a(RequestParameters.POSITION, String.valueOf(i11));
        if (str == null) {
            str = "";
        }
        Map m11 = MapsKt.m(a11, a12, a13, a14, a15, a16, a17, a18, TuplesKt.a("entrance_content_id", str));
        if (str2 != null) {
            m11.put("track_id", str2);
        }
        if (str3 != null) {
            m11.put("parent_track_id", str3);
        }
        if (str4 != null) {
            m11.put("parent_content_id", str4);
        }
        hj.i.f64628a.p(pageName, m11);
    }

    public final void d(String pageName, UGCVideo item, int i11, long j11, String str, String str2, String str3, String str4) {
        String str5;
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(item, "item");
        Pair a11 = TuplesKt.a("module_name", WebConstants.FIELD_ITEM);
        Pair a12 = TuplesKt.a("browse_duration", String.valueOf(j11));
        Pair a13 = TuplesKt.a("page_tab_name", "foryou");
        String ugcVideoId = item.getUgcVideoId();
        if (ugcVideoId == null) {
            ugcVideoId = "";
        }
        Pair a14 = TuplesKt.a("content_id", ugcVideoId);
        UGCVideoBelongToCollection belongToCollection = item.getBelongToCollection();
        if (belongToCollection == null || (str5 = belongToCollection.getCollectionId()) == null) {
            str5 = "";
        }
        Pair a15 = TuplesKt.a("belong_to_collection_id", str5);
        String subjectId = item.getSubjectId();
        if (subjectId == null) {
            subjectId = "";
        }
        Pair a16 = TuplesKt.a("refer_subject_id", subjectId);
        Pair a17 = TuplesKt.a("content_type", "ugc_video");
        String ops = item.getOps();
        if (ops == null) {
            ops = "";
        }
        Map m11 = MapsKt.m(a11, a12, a13, a14, a15, a16, a17, TuplesKt.a("ops", ops), TuplesKt.a(RequestParameters.POSITION, String.valueOf(i11)), TuplesKt.a("entrance_content_id", str != null ? str : ""));
        if (str2 != null) {
            m11.put("track_id", str2);
        }
        if (str3 != null) {
            m11.put("parent_track_id", str3);
        }
        if (str4 != null) {
            m11.put("parent_content_id", str4);
        }
        hj.i.f64628a.D(pageName, m11);
    }

    public final void e(String str, String moduleName, DownloadBean downloadBean, String str2, String str3, String str4) {
        Intrinsics.h(moduleName, "moduleName");
        if (str == null || downloadBean == null) {
            return;
        }
        Pair a11 = TuplesKt.a("module_name", moduleName);
        String ugcVideoId = downloadBean.getUgcVideoId();
        if (ugcVideoId == null) {
            ugcVideoId = "";
        }
        Pair a12 = TuplesKt.a("content_id", ugcVideoId);
        String ugcVideoCollectionId = downloadBean.getUgcVideoCollectionId();
        if (ugcVideoCollectionId == null) {
            ugcVideoCollectionId = "";
        }
        Pair a13 = TuplesKt.a("belong_to_collection_id", ugcVideoCollectionId);
        Pair a14 = TuplesKt.a("content_type", "ugc_video");
        String ops = downloadBean.getOps();
        Map m11 = MapsKt.m(a11, a12, a13, a14, TuplesKt.a("ops", ops != null ? ops : ""));
        if (str2 != null) {
            m11.put("track_id", str2);
        }
        if (str3 != null) {
            m11.put("parent_track_id", str3);
        }
        if (str4 != null) {
            m11.put("parent_content_id", str4);
        }
        hj.i.f64628a.p(str, m11);
    }

    public final void f(String pageName, UGCVideo item, int i11, String str, String str2, String str3) {
        String str4;
        Intrinsics.h(pageName, "pageName");
        String str5 = WebConstants.FIELD_ITEM;
        Intrinsics.h(item, "item");
        if (!Intrinsics.c(pageName, "/ugc_video/immersive_detail")) {
            str5 = "play_list";
        }
        Pair a11 = TuplesKt.a("module_name", str5);
        Pair a12 = TuplesKt.a("module_name", "play_list");
        String ugcVideoId = item.getUgcVideoId();
        if (ugcVideoId == null) {
            ugcVideoId = "";
        }
        Pair a13 = TuplesKt.a("content_id", ugcVideoId);
        UGCVideoBelongToCollection belongToCollection = item.getBelongToCollection();
        if (belongToCollection == null || (str4 = belongToCollection.getCollectionId()) == null) {
            str4 = "";
        }
        Pair a14 = TuplesKt.a("belong_to_collection_id", str4);
        Pair a15 = TuplesKt.a("content_type", "ugc_video");
        String ops = item.getOps();
        if (ops == null) {
            ops = "";
        }
        Pair a16 = TuplesKt.a("ops", ops);
        Pair a17 = TuplesKt.a(RequestParameters.POSITION, String.valueOf(i11));
        String subjectId = item.getSubjectId();
        Map m11 = MapsKt.m(a11, a12, a13, a14, a15, a16, a17, TuplesKt.a("refer_subject_id", subjectId != null ? subjectId : ""));
        if (str != null) {
            m11.put("track_id", str);
        }
        if (str2 != null) {
            m11.put("parent_track_id", str2);
        }
        if (str3 != null) {
            m11.put("parent_content_id", str3);
        }
        hj.i.f64628a.p(pageName, m11);
    }

    public final void g(String pageName, UGCVideo item, int i11, long j11, String str, String str2, String str3, Boolean bool) {
        String str4;
        Intrinsics.h(pageName, "pageName");
        String str5 = WebConstants.FIELD_ITEM;
        Intrinsics.h(item, "item");
        if (!Intrinsics.c(pageName, "/ugc_video/immersive_detail")) {
            str5 = "play_list";
        }
        Pair a11 = TuplesKt.a("module_name", str5);
        Pair a12 = TuplesKt.a("browse_duration", String.valueOf(j11));
        String ugcVideoId = item.getUgcVideoId();
        if (ugcVideoId == null) {
            ugcVideoId = "";
        }
        Pair a13 = TuplesKt.a("content_id", ugcVideoId);
        UGCVideoBelongToCollection belongToCollection = item.getBelongToCollection();
        if (belongToCollection == null || (str4 = belongToCollection.getCollectionId()) == null) {
            str4 = "";
        }
        Pair a14 = TuplesKt.a("belong_to_collection_id", str4);
        Pair a15 = TuplesKt.a("content_type", "ugc_video");
        String ops = item.getOps();
        if (ops == null) {
            ops = "";
        }
        Pair a16 = TuplesKt.a("ops", ops);
        Pair a17 = TuplesKt.a(RequestParameters.POSITION, String.valueOf(i11));
        String subjectId = item.getSubjectId();
        Map m11 = MapsKt.m(a11, a12, a13, a14, a15, a16, a17, TuplesKt.a("refer_subject_id", subjectId != null ? subjectId : ""));
        if (bool != null) {
            m11.put("is_collection", String.valueOf(bool.booleanValue()));
        }
        if (str != null) {
            m11.put("track_id", str);
        }
        if (str2 != null) {
            m11.put("parent_track_id", str2);
        }
        if (str3 != null) {
            m11.put("parent_content_id", str3);
        }
        hj.i.f64628a.D(pageName, m11);
    }
}
