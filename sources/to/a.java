package to;

import com.transsion.moviedetailapi.bean.Group;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.postdetail.ui.adapter.f;
import hj.i;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private HashSet f76452a;

    /* renamed from: b, reason: collision with root package name */
    private String f76453b;

    /* renamed from: c, reason: collision with root package name */
    private String f76454c;

    public a(String page, String postId) {
        Intrinsics.h(page, "page");
        Intrinsics.h(postId, "postId");
        this.f76453b = page;
        this.f76454c = postId;
    }

    public final void a(f adapter, int i11, long j11) {
        Boolean hasResource;
        Intrinsics.h(adapter, "adapter");
        if (i11 >= adapter.getData().size()) {
            return;
        }
        PostSubjectItem postSubjectItem = (PostSubjectItem) adapter.getItem(i11);
        if (this.f76452a == null) {
            this.f76452a = new HashSet();
        }
        HashMap hashMap = new HashMap();
        HashSet hashSet = this.f76452a;
        if (hashSet != null && hashSet.contains(postSubjectItem)) {
            a.C0856a c0856a = lg.a.f68962a;
            String postId = postSubjectItem.getPostId();
            Media media = postSubjectItem.getMedia();
            a.C0856a.f(c0856a, "reportExposure", "trendFragment position:" + i11 + ",videoId: + " + postId + "  mediaType: " + (media != null ? media.getMediaType() : null), false, 4, null);
            return;
        }
        HashSet hashSet2 = this.f76452a;
        if (hashSet2 != null) {
            hashSet2.add(postSubjectItem);
        }
        hashMap.put("post_id", postSubjectItem.getPostId());
        hashMap.put("origin_post_id", this.f76454c);
        hashMap.put("sequence", String.valueOf(i11));
        hashMap.put("item_type", postSubjectItem.getItemType());
        hashMap.put("ops", postSubjectItem.getOps());
        Media media2 = postSubjectItem.getMedia();
        hashMap.put("post_media_type", media2 != null ? media2.getMediaType() : null);
        Subject subject = postSubjectItem.getSubject();
        hashMap.put("subject_id", subject != null ? subject.getSubjectId() : null);
        Group group = postSubjectItem.getGroup();
        hashMap.put("group_id", group != null ? group.getGroupId() : null);
        hashMap.put("browse_duration", String.valueOf(j11));
        Subject subject2 = postSubjectItem.getSubject();
        if (subject2 != null && (hasResource = subject2.getHasResource()) != null) {
            r2 = hasResource.toString();
        }
        hashMap.put("has_resource", r2);
        i.f64628a.D(this.f76453b, hashMap);
    }

    public final void b(int i11, PostSubjectItem item) {
        Intrinsics.h(item, "item");
        HashMap hashMap = new HashMap();
        hashMap.put("post_id", item.getPostId());
        hashMap.put("origin_post_id", this.f76454c);
        hashMap.put("sequence", String.valueOf(i11));
        hashMap.put("item_type", item.getItemType());
        hashMap.put("ops", item.getOps());
        Media media = item.getMedia();
        hashMap.put("post_media_type", media != null ? media.getMediaType() : null);
        Subject subject = item.getSubject();
        hashMap.put("subject_id", subject != null ? subject.getSubjectId() : null);
        Group group = item.getGroup();
        hashMap.put("group_id", group != null ? group.getGroupId() : null);
        i.f64628a.p(this.f76453b, hashMap);
    }
}
