package wk;

import com.transsion.moviedetailapi.bean.Subject;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public abstract class a {
    public static final void a(Subject subject, String pageName, String moduleName) {
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(moduleName, "moduleName");
        if (subject == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", "click_rank_list_item");
        hashMap.put("module_name", moduleName);
        hashMap.put("seenStatus", String.valueOf(subject.getSeenStatus()));
        String subjectId = subject.getSubjectId();
        if (subjectId == null) {
            subjectId = "";
        }
        hashMap.put("subject_id", subjectId);
        hashMap.put("has_resource", String.valueOf(subject.getHasResource()));
        hashMap.put("subject_type", String.valueOf(subject.getSubjectType()));
        String ops = subject.getOps();
        hashMap.put("ops", ops != null ? ops : "");
        hashMap.put("tag", String.valueOf(subject.getTags()));
        com.transsion.baselib.helper.a.f43316a.e(pageName, hashMap);
    }

    public static final void b(Subject subject, String pageName, String moduleName) {
        String str;
        String ops;
        Integer seenStatus;
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(moduleName, "moduleName");
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", (subject == null || (seenStatus = subject.getSeenStatus()) == null || seenStatus.intValue() != 1) ? "click_course_subscribe" : "click_course_unsubscribe");
        hashMap.put("module_name", moduleName);
        String str2 = "";
        if (subject == null || (str = subject.getSubjectId()) == null) {
            str = "";
        }
        hashMap.put("subject_id", str);
        hashMap.put("has_resource", String.valueOf(subject != null ? subject.getHasResource() : null));
        hashMap.put("subject_type", String.valueOf(subject != null ? subject.getSubjectType() : null));
        if (subject != null && (ops = subject.getOps()) != null) {
            str2 = ops;
        }
        hashMap.put("ops", str2);
        hashMap.put("tag", String.valueOf(subject != null ? subject.getTags() : null));
        hashMap.put("seenStatus", String.valueOf(subject != null ? subject.getSeenStatus() : null));
        com.transsion.baselib.helper.a.f43316a.b(pageName, hashMap);
    }
}
