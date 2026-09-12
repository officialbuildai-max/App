package ry;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.transsion.moviedetailapi.bean.Subject;
import hj.i;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class f {
    public static /* synthetic */ void b(f fVar, String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            str4 = "minitv_download";
        }
        fVar.a(str, str2, str3, str4);
    }

    public static /* synthetic */ void d(f fVar, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            str3 = "minitv_download";
        }
        fVar.c(str, str2, str3);
    }

    public static /* synthetic */ void g(f fVar, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = "minitv_download";
        }
        fVar.f(str, str2);
    }

    public static /* synthetic */ void i(f fVar, Subject subject, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            str3 = "minitv_download";
        }
        fVar.h(subject, str, str2, str3);
    }

    public final void a(String str, String optType, String position, String pageName) {
        Intrinsics.h(optType, "optType");
        Intrinsics.h(position, "position");
        Intrinsics.h(pageName, "pageName");
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "watch_ad");
        if (str == null) {
            str = "";
        }
        hashMap.put("subject_id", str);
        hashMap.put("opt_type", optType);
        hashMap.put(RequestParameters.POSITION, position);
        i.f64628a.p(pageName, hashMap);
    }

    public final void c(String str, String dialogName, String pageName) {
        Intrinsics.h(dialogName, "dialogName");
        Intrinsics.h(pageName, "pageName");
        HashMap hashMap = new HashMap();
        if (str == null) {
            str = "";
        }
        hashMap.put("subject_id", str);
        hashMap.put("dialog_name", dialogName);
        i.f64628a.r(pageName, hashMap);
    }

    public final void e(String str, String optType, boolean z10, String pageName) {
        Intrinsics.h(optType, "optType");
        Intrinsics.h(pageName, "pageName");
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "favorite");
        if (str == null) {
            str = "";
        }
        hashMap.put("subject_id", str);
        hashMap.put("opt_type", optType);
        hashMap.put("favorite", String.valueOf(!z10));
        i.f64628a.p(pageName, hashMap);
    }

    public final void f(String str, String pageName) {
        Intrinsics.h(pageName, "pageName");
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "share");
        if (str == null) {
            str = "";
        }
        hashMap.put("subject_id", str);
        i.f64628a.p(pageName, hashMap);
    }

    public final void h(Subject subject, String unlockType, String unlockEp, String pageName) {
        String str;
        String ops;
        Intrinsics.h(unlockType, "unlockType");
        Intrinsics.h(unlockEp, "unlockEp");
        Intrinsics.h(pageName, "pageName");
        HashMap hashMap = new HashMap();
        if (subject == null || (str = subject.getSubjectId()) == null) {
            str = "";
        }
        hashMap.put("subject_id", str);
        hashMap.put("unlock_ep", unlockEp);
        hashMap.put("unlock_type", unlockType);
        if (subject != null && (ops = subject.getOps()) != null && ops.length() > 0) {
            String ops2 = subject.getOps();
            hashMap.put("ops", ops2 != null ? ops2 : "");
        }
        i.f64628a.s(pageName, "minitv_unlock", hashMap);
    }
}
