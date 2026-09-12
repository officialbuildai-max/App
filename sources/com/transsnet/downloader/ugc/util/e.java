package com.transsnet.downloader.ugc.util;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsion.ugcvideodetail.api.bean.UGCVideoBelongToCollection;
import com.transsion.web.api.WebConstants;
import hj.i;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f59970a = new e();

    private e() {
    }

    public final void a(String pageName, UGCVideo item, int i11, long j11) {
        String str;
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(item, "item");
        Pair a11 = TuplesKt.a("browse_duration", String.valueOf(j11));
        Pair a12 = TuplesKt.a("module_name", WebConstants.FIELD_ITEM);
        Pair a13 = TuplesKt.a("page_tab_name", "foryou");
        UGCVideoBelongToCollection belongToCollection = item.getBelongToCollection();
        if (belongToCollection == null || (str = belongToCollection.getCollectionId()) == null) {
            str = "";
        }
        Pair a14 = TuplesKt.a("belong_to_collection_id", str);
        String ugcVideoId = item.getUgcVideoId();
        if (ugcVideoId == null) {
            ugcVideoId = "";
        }
        Pair a15 = TuplesKt.a("content_id", ugcVideoId);
        String subjectId = item.getSubjectId();
        if (subjectId == null) {
            subjectId = "";
        }
        Pair a16 = TuplesKt.a("refer_subject_id", subjectId);
        Pair a17 = TuplesKt.a("content_type", "ugc_video");
        String ops = item.getOps();
        i.f64628a.D(pageName, MapsKt.l(a11, a12, a13, a14, a15, a16, a17, TuplesKt.a("ops", ops != null ? ops : ""), TuplesKt.a(RequestParameters.POSITION, String.valueOf(i11))));
    }

    public final void b(String pageName, UGCVideo item, int i11) {
        String str;
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
        if (belongToCollection == null || (str = belongToCollection.getCollectionId()) == null) {
            str = "";
        }
        Pair a14 = TuplesKt.a("belong_to_collection_id", str);
        Pair a15 = TuplesKt.a("content_type", "ugc_video");
        String subjectId = item.getSubjectId();
        if (subjectId == null) {
            subjectId = "";
        }
        Pair a16 = TuplesKt.a("refer_subject_id", subjectId);
        String ops = item.getOps();
        i.f64628a.p(pageName, MapsKt.l(a11, a12, a13, a14, a15, a16, TuplesKt.a("ops", ops != null ? ops : ""), TuplesKt.a(RequestParameters.POSITION, String.valueOf(i11))));
    }
}
