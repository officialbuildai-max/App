package ut;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.shorttv_pugc.ShorttvModel;
import com.transsion.web.api.WebConstants;
import hj.i;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f77014a = new a();

    private a() {
    }

    public static /* synthetic */ void b(a aVar, String str, ShorttvModel.UGCVideo uGCVideo, String str2, String str3, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            str2 = null;
        }
        aVar.a(str, uGCVideo, str2, str3);
    }

    public final void a(String moduleName, ShorttvModel.UGCVideo uGCVideo, String str, String str2) {
        String str3;
        String str4;
        String str5;
        ShorttvModel.UGCVideoCollection belongToCollection;
        Intrinsics.h(moduleName, "moduleName");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("module_name", moduleName);
        if (uGCVideo == null || (str3 = uGCVideo.getTitle()) == null) {
            str3 = "";
        }
        linkedHashMap.put(CampaignEx.JSON_KEY_TITLE, str3);
        if (str != null) {
            linkedHashMap.put("page_tab_name", str);
        }
        String str6 = null;
        linkedHashMap.put(RequestParameters.POSITION, String.valueOf(uGCVideo != null ? Integer.valueOf(uGCVideo.getEp()) : null));
        if (uGCVideo != null && (belongToCollection = uGCVideo.getBelongToCollection()) != null) {
            str6 = belongToCollection.getCollectionId();
        }
        linkedHashMap.put("belong_to_collection_id", String.valueOf(str6));
        if (uGCVideo == null || (str4 = uGCVideo.getSubjectId()) == null) {
            str4 = "";
        }
        linkedHashMap.put("refer_subject_id", str4);
        if (uGCVideo == null || (str5 = uGCVideo.getUgcVideoId()) == null) {
            str5 = "";
        }
        linkedHashMap.put("content_id", str5);
        if (str2 == null) {
            str2 = "";
        }
        linkedHashMap.put("ops", str2);
        linkedHashMap.put("content_type", "ugc_video");
        i.f64628a.p("/ugc_shorts/detail", linkedHashMap);
    }

    public final void c(ShorttvModel.UGCVideoHasTag uGCVideoHasTag, int i11, String str) {
        String str2;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("module_name", "hashtag");
        if (uGCVideoHasTag == null || (str2 = uGCVideoHasTag.getTitle()) == null) {
            str2 = "";
        }
        linkedHashMap.put(CampaignEx.JSON_KEY_TITLE, str2);
        linkedHashMap.put(RequestParameters.POSITION, String.valueOf(i11));
        if (str == null) {
            str = "";
        }
        linkedHashMap.put("ops", str);
        linkedHashMap.put("content_type", "ugc_video");
        i.f64628a.p("/ugc_shorts/detail", linkedHashMap);
    }

    public final void d(long j11, ShorttvModel.UGCVideo uGCVideo, String pageTabName, String ops) {
        String str;
        String subjectId;
        ShorttvModel.UGCVideoCollection belongToCollection;
        Intrinsics.h(pageTabName, "pageTabName");
        Intrinsics.h(ops, "ops");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("browse_duration", String.valueOf(j11));
        linkedHashMap.put("module_name", WebConstants.FIELD_ITEM);
        linkedHashMap.put("page_tab_name", pageTabName);
        String str2 = null;
        linkedHashMap.put(RequestParameters.POSITION, String.valueOf(uGCVideo != null ? Integer.valueOf(uGCVideo.getEp()) : null));
        linkedHashMap.put("ops", ops);
        if (uGCVideo != null && (belongToCollection = uGCVideo.getBelongToCollection()) != null) {
            str2 = belongToCollection.getCollectionId();
        }
        linkedHashMap.put("belong_to_collection_id", String.valueOf(str2));
        String str3 = "";
        if (uGCVideo == null || (str = uGCVideo.getUgcVideoId()) == null) {
            str = "";
        }
        linkedHashMap.put("content_id", str);
        if (uGCVideo != null && (subjectId = uGCVideo.getSubjectId()) != null) {
            str3 = subjectId;
        }
        linkedHashMap.put("refer_subject_id", str3);
        linkedHashMap.put("content_type", "ugc_video");
        i.f64628a.D("/ugc_shorts/detail", linkedHashMap);
    }
}
