package hl;

import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.transsion.home.bean.OperateItem;
import com.transsion.moviedetailapi.bean.ExplainBean;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.Subject;
import hj.i;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lg.a;

/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private HashSet f64646a;

    /* renamed from: b, reason: collision with root package name */
    private String f64647b;

    public c(String page) {
        Intrinsics.h(page, "page");
        this.f64647b = page;
    }

    public final void a(BaseProviderMultiAdapter adapter, int i11, long j11) {
        List<ExplainBean> explains;
        Boolean hasResource;
        String subjectId;
        HashSet hashSet;
        Intrinsics.h(adapter, "adapter");
        if (i11 >= adapter.getData().size()) {
            return;
        }
        OperateItem operateItem = (OperateItem) adapter.getItem(i11);
        if (Intrinsics.c(operateItem.getType(), PostItemType.SINGLE_SUBJECT.getValue()) || Intrinsics.c(operateItem.getType(), PostItemType.SUBJECT.getValue())) {
            if (this.f64646a == null) {
                this.f64646a = new HashSet();
            }
            HashMap hashMap = new HashMap();
            HashSet hashSet2 = this.f64646a;
            if (hashSet2 != null) {
                Subject feedsSubject = operateItem.getFeedsSubject();
                if (CollectionsKt.b0(hashSet2, feedsSubject != null ? feedsSubject.getSubjectId() : null)) {
                    a.C0856a c0856a = lg.a.f68962a;
                    Subject feedsSubject2 = operateItem.getFeedsSubject();
                    a.C0856a.f(c0856a, "reportExposure", "trendFragment position:" + i11 + ",subjectId: + " + (feedsSubject2 != null ? feedsSubject2.getSubjectId() : null) + "}", false, 4, null);
                    return;
                }
            }
            Subject feedsSubject3 = operateItem.getFeedsSubject();
            if (feedsSubject3 != null && (subjectId = feedsSubject3.getSubjectId()) != null && subjectId.length() > 0 && (hashSet = this.f64646a) != null) {
                Subject feedsSubject4 = operateItem.getFeedsSubject();
                String subjectId2 = feedsSubject4 != null ? feedsSubject4.getSubjectId() : null;
                Intrinsics.e(subjectId2);
                hashSet.add(subjectId2);
            }
            hashMap.put("sequence", String.valueOf(i11));
            hashMap.put("item_type", "rec");
            Subject feedsSubject5 = operateItem.getFeedsSubject();
            hashMap.put("ops", feedsSubject5 != null ? feedsSubject5.getOps() : null);
            Subject feedsSubject6 = operateItem.getFeedsSubject();
            hashMap.put("subject_id", feedsSubject6 != null ? feedsSubject6.getSubjectId() : null);
            hashMap.put("browse_duration", String.valueOf(j11));
            Subject feedsSubject7 = operateItem.getFeedsSubject();
            hashMap.put("has_resource", (feedsSubject7 == null || (hasResource = feedsSubject7.getHasResource()) == null) ? null : hasResource.toString());
            Subject feedsSubject8 = operateItem.getFeedsSubject();
            hashMap.put("is_cache", String.valueOf(feedsSubject8 != null ? Boolean.valueOf(feedsSubject8.getIsCache()) : null));
            Subject feedsSubject9 = operateItem.getFeedsSubject();
            hashMap.put("load_cover_success", String.valueOf(feedsSubject9 != null ? Boolean.valueOf(feedsSubject9.getLoadCoverSuccess()) : null));
            Subject feedsSubject10 = operateItem.getFeedsSubject();
            hashMap.put("load_cover_duration", String.valueOf(feedsSubject10 != null ? Long.valueOf(feedsSubject10.getLoadCoverDuration()) : null));
            Subject feedsSubject11 = operateItem.getFeedsSubject();
            hashMap.put("cover_cache", String.valueOf(feedsSubject11 != null ? Boolean.valueOf(feedsSubject11.getCoverCache()) : null));
            Subject feedsSubject12 = operateItem.getFeedsSubject();
            hashMap.put("builtin", (feedsSubject12 == null || !feedsSubject12.getBuiltIn()) ? "0" : "1");
            StringBuilder sb2 = new StringBuilder();
            Subject feedsSubject13 = operateItem.getFeedsSubject();
            if (feedsSubject13 != null && (explains = feedsSubject13.getExplains()) != null) {
                Iterator<T> it = explains.iterator();
                while (it.hasNext()) {
                    sb2.append(((ExplainBean) it.next()).getType());
                    sb2.append(",");
                }
            }
            String sb3 = sb2.toString();
            Intrinsics.g(sb3, "toString(...)");
            hashMap.put("rec_explain_type", StringsKt.r1(sb3, ','));
            i.f64628a.D(this.f64647b, hashMap);
        }
    }

    public final void b(int i11, Subject item) {
        Intrinsics.h(item, "item");
        HashMap hashMap = new HashMap();
        hashMap.put("sequence", String.valueOf(i11));
        hashMap.put("item_type", "rec");
        hashMap.put("ops", item.getOps());
        hashMap.put("subject_id", item.getSubjectId());
        hashMap.put("builtin", item.getBuiltIn() ? "1" : "0");
        StringBuilder sb2 = new StringBuilder();
        List<ExplainBean> explains = item.getExplains();
        if (explains != null) {
            Iterator<T> it = explains.iterator();
            while (it.hasNext()) {
                sb2.append(((ExplainBean) it.next()).getType());
                sb2.append(",");
            }
        }
        String sb3 = sb2.toString();
        Intrinsics.g(sb3, "toString(...)");
        hashMap.put("rec_explain_type", StringsKt.r1(sb3, ','));
        i.f64628a.p(this.f64647b, hashMap);
    }
}
