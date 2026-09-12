package ss;

import com.cloud.tmc.integration.event.EventConstants;
import com.hisavana.common.tracking.TrackingKey;
import com.transsion.shorttv.bean.Subject;
import com.transsion.web.api.WebConstants;
import hj.i;
import java.util.HashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f75981a = new b();

    private b() {
    }

    public static /* synthetic */ void b(b bVar, String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            str4 = "minitv_play";
        }
        bVar.a(str, str2, str3, str4);
    }

    public static /* synthetic */ void g(b bVar, String str, String str2, String str3, boolean z10, String str4, String str5, int i11, Object obj) {
        if ((i11 & 16) != 0) {
            str4 = "minitv_play";
        }
        String str6 = str4;
        if ((i11 & 32) != 0) {
            str5 = null;
        }
        bVar.f(str, str2, str3, z10, str6, str5);
    }

    public static /* synthetic */ void n(b bVar, String str, String str2, Integer num, String str3, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            str3 = "minitv_play";
        }
        bVar.m(str, str2, num, str3);
    }

    public final void a(String str, String str2, String dialogName, String pageName) {
        Intrinsics.h(dialogName, "dialogName");
        Intrinsics.h(pageName, "pageName");
        HashMap hashMap = new HashMap();
        if (str == null) {
            str = "";
        }
        hashMap.put("subject_id", str);
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("ops", str2);
        hashMap.put("dialog_name", dialogName);
        i.f64628a.s(pageName, "dialog_show", hashMap);
    }

    public final void c(Subject subject, int i11, boolean z10, boolean z11, String unlockWay) {
        String str;
        Intrinsics.h(unlockWay, "unlockWay");
        HashMap hashMap = new HashMap();
        hashMap.put("page_name", "minitv_play");
        hashMap.put("from", "minitv_sdk");
        if (subject == null || (str = subject.getSubjectId()) == null) {
            str = "";
        }
        hashMap.put("subject_id", str);
        hashMap.put("ep_num", String.valueOf(i11));
        hashMap.put("minitv_type", (subject == null || subject.getMiniTvType() != 2) ? "short" : "long");
        hashMap.put("is_free", String.valueOf(z10));
        hashMap.put("is_unlock", String.valueOf(z11));
        hashMap.put("unlock_way", unlockWay);
        hashMap.put("opt_type", "minitv_download");
        i.f64628a.p("minitv_play", hashMap);
    }

    public final void d(Subject subject, int i11, String optType) {
        String str;
        Intrinsics.h(optType, "optType");
        HashMap hashMap = new HashMap();
        hashMap.put("page_name", "minitv_download");
        hashMap.put("from", "minitv_sdk");
        if (subject == null || (str = subject.getSubjectId()) == null) {
            str = "";
        }
        hashMap.put("subject_id", str);
        hashMap.put("ep_num", String.valueOf(i11));
        hashMap.put("minitv_type", (subject == null || subject.getMiniTvType() != 2) ? "short" : "long");
        hashMap.put("opt_type", optType);
        i.f64628a.p("minitv_download", hashMap);
    }

    public final void e(Subject subject, int i11) {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put("page_name", "minitv_download");
        hashMap.put("from", "minitv_sdk");
        if (subject == null || (str = subject.getSubjectId()) == null) {
            str = "";
        }
        hashMap.put("subject_id", str);
        hashMap.put("ep_num", String.valueOf(i11));
        hashMap.put("minitv_type", (subject == null || subject.getMiniTvType() != 2) ? "short" : "long");
        hashMap.put("dialog_name", "dialog_minitv_download");
        i.f64628a.s("minitv_download", "dialog_show", hashMap);
    }

    public final void f(String str, String str2, String optType, boolean z10, String pageName, String str3) {
        Intrinsics.h(optType, "optType");
        Intrinsics.h(pageName, "pageName");
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "favorite");
        if (str == null) {
            str = "";
        }
        hashMap.put("subject_id", str);
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("ops", str2);
        hashMap.put("opt_type", optType);
        hashMap.put("favorite", String.valueOf(!z10));
        if (str3 != null && str3.length() != 0) {
            hashMap.put(WebConstants.PAGE_FROM, str3);
        }
        i.f64628a.p(pageName, hashMap);
    }

    public final void h(Subject subject, int i11, String optType, String adUnlockType) {
        String str;
        Intrinsics.h(optType, "optType");
        Intrinsics.h(adUnlockType, "adUnlockType");
        HashMap hashMap = new HashMap();
        hashMap.put("page_name", "minitv_lock");
        hashMap.put("from", "minitv_sdk");
        if (subject == null || (str = subject.getSubjectId()) == null) {
            str = "";
        }
        hashMap.put("subject_id", str);
        hashMap.put("ep_num", String.valueOf(i11));
        hashMap.put("minitv_type", (subject == null || subject.getMiniTvType() != 2) ? "short" : "long");
        hashMap.put("opt_type", optType);
        hashMap.put("ad_unlock_type", adUnlockType);
        i.f64628a.p("minitv_lock", hashMap);
    }

    public final void i(Subject subject, int i11) {
        String str;
        List l11;
        HashMap hashMap = new HashMap();
        hashMap.put("page_name", "minitv_lock");
        hashMap.put("from", "minitv_sdk");
        if (subject == null || (str = subject.getSubjectId()) == null) {
            str = "";
        }
        hashMap.put("subject_id", str);
        hashMap.put("ep_num", String.valueOf(i11));
        hashMap.put("minitv_type", (subject == null || subject.getMiniTvType() != 2) ? "short" : "long");
        if (subject == null || (l11 = subject.getUnlockType()) == null) {
            l11 = CollectionsKt.l();
        }
        if (subject == null || subject.getMiniTvType() != 2) {
            hashMap.put("minitv_pay", l11.contains(1) ? "1" : "0");
            hashMap.put("minitv_ad", l11.contains(2) ? "1" : "0");
        } else {
            hashMap.put("minitv_pay", l11.contains(1) ? "1" : "0");
            hashMap.put("minitv_ad", (l11.contains(1) || !l11.contains(2)) ? "0" : "1");
        }
        i.f64628a.s("minitv_lock", "pt", hashMap);
    }

    public final void j(Subject subject, int i11, String unlockResult, String errorMessage, String errorCode, String source) {
        String str;
        Intrinsics.h(unlockResult, "unlockResult");
        Intrinsics.h(errorMessage, "errorMessage");
        Intrinsics.h(errorCode, "errorCode");
        Intrinsics.h(source, "source");
        HashMap hashMap = new HashMap();
        hashMap.put("page_name", "minitv_play");
        hashMap.put("from", "minitv_sdk");
        if (subject == null || (str = subject.getSubjectId()) == null) {
            str = "";
        }
        hashMap.put("subject_id", str);
        hashMap.put("ep_num", String.valueOf(i11));
        hashMap.put("minitv_type", (subject == null || subject.getMiniTvType() != 2) ? "short" : "long");
        hashMap.put("unlock_result", unlockResult);
        hashMap.put(TrackingKey.ERROR_MESSAGE, errorMessage);
        hashMap.put("error_code", errorCode);
        hashMap.put(EventConstants.KEY_SOURCE, source);
        i.f64628a.s("minitv_play", "minitv_pay", hashMap);
    }

    public final void k(Subject subject, int i11, boolean z10, boolean z11, String unlockWay) {
        String str;
        Intrinsics.h(unlockWay, "unlockWay");
        HashMap hashMap = new HashMap();
        hashMap.put("page_name", "minitv_play");
        hashMap.put("from", "minitv_sdk");
        if (subject == null || (str = subject.getSubjectId()) == null) {
            str = "";
        }
        hashMap.put("subject_id", str);
        hashMap.put("ep_num", String.valueOf(i11));
        hashMap.put("minitv_type", (subject == null || subject.getMiniTvType() != 2) ? "short" : "long");
        hashMap.put("is_free", String.valueOf(z10));
        hashMap.put("is_unlock", String.valueOf(z11));
        hashMap.put("unlock_way", unlockWay);
        i.f64628a.s("minitv_play", "minitv_play", hashMap);
    }

    public final void l(Subject subject, int i11, String unlockResult, String errorMessage, String errorCode, String source) {
        String str;
        Intrinsics.h(unlockResult, "unlockResult");
        Intrinsics.h(errorMessage, "errorMessage");
        Intrinsics.h(errorCode, "errorCode");
        Intrinsics.h(source, "source");
        HashMap hashMap = new HashMap();
        hashMap.put("page_name", "minitv_play");
        hashMap.put("from", "minitv_sdk");
        if (subject == null || (str = subject.getSubjectId()) == null) {
            str = "";
        }
        hashMap.put("subject_id", str);
        hashMap.put("ep_num", String.valueOf(i11));
        hashMap.put("minitv_type", (subject == null || subject.getMiniTvType() != 2) ? "short" : "long");
        hashMap.put("unlock_result", unlockResult);
        hashMap.put(TrackingKey.ERROR_MESSAGE, errorMessage);
        hashMap.put("error_code", errorCode);
        hashMap.put(EventConstants.KEY_SOURCE, source);
        i.f64628a.s("minitv_play", "minitv_unlock", hashMap);
    }

    public final void m(String str, String str2, Integer num, String pageName) {
        String num2;
        Intrinsics.h(pageName, "pageName");
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "share");
        String str3 = "";
        if (str == null) {
            str = "";
        }
        hashMap.put("subject_id", str);
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("ops", str2);
        if (num != null && (num2 = num.toString()) != null) {
            str3 = num2;
        }
        hashMap.put("ep", str3);
        i.f64628a.p(pageName, hashMap);
    }
}
