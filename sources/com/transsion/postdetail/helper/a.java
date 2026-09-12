package com.transsion.postdetail.helper;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.moviedetailapi.bean.Link;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.MediaType;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.User;
import com.transsion.player.mediasession.MediaItem;
import com.transsion.web.api.WebConstants;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a */
    public static final a f48920a = new a();

    private a() {
    }

    public static /* synthetic */ void B(a aVar, PostSubjectItem postSubjectItem, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = "postdetail";
        }
        if ((i11 & 4) != 0) {
            str2 = null;
        }
        aVar.A(postSubjectItem, str, str2);
    }

    public static /* synthetic */ void D(a aVar, PostSubjectItem postSubjectItem, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = "postdetail";
        }
        if ((i11 & 4) != 0) {
            str2 = null;
        }
        aVar.C(postSubjectItem, str, str2);
    }

    public static /* synthetic */ void b(a aVar, PostSubjectItem postSubjectItem, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = "postdetail";
        }
        if ((i11 & 4) != 0) {
            str2 = null;
        }
        aVar.a(postSubjectItem, str, str2);
    }

    public static /* synthetic */ void d(a aVar, PostSubjectItem postSubjectItem, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = "postdetail";
        }
        if ((i11 & 4) != 0) {
            str2 = null;
        }
        aVar.c(postSubjectItem, str, str2);
    }

    public static /* synthetic */ void f(a aVar, PostSubjectItem postSubjectItem, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = "postdetail";
        }
        if ((i11 & 4) != 0) {
            str2 = null;
        }
        aVar.e(postSubjectItem, str, str2);
    }

    public static /* synthetic */ void j(a aVar, PostSubjectItem postSubjectItem, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = "postdetail";
        }
        if ((i11 & 4) != 0) {
            str2 = null;
        }
        aVar.i(postSubjectItem, str, str2);
    }

    public static /* synthetic */ void n(a aVar, PostSubjectItem postSubjectItem, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = "postdetail";
        }
        if ((i11 & 4) != 0) {
            str2 = null;
        }
        aVar.m(postSubjectItem, str, str2);
    }

    public static /* synthetic */ void q(a aVar, PostSubjectItem postSubjectItem, boolean z10, String str, String str2, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            str = "postdetail";
        }
        if ((i11 & 8) != 0) {
            str2 = null;
        }
        aVar.p(postSubjectItem, z10, str, str2);
    }

    private final void r(PostSubjectItem postSubjectItem, String str, String str2, String str3) {
        String str4;
        String str5;
        String value;
        String value2;
        String value3;
        String str6;
        String str7;
        String str8;
        String str9;
        User user;
        String userId;
        Link link;
        Group group;
        Media media;
        Media media2;
        Subject subject;
        Subject subject2;
        HashMap hashMap = new HashMap();
        if (str3 != null && str3.length() != 0) {
            hashMap.put(WebConstants.PAGE_FROM, str3);
        }
        hashMap.put("module_name", str);
        String str10 = "";
        if (postSubjectItem == null || (subject2 = postSubjectItem.getSubject()) == null || (str4 = subject2.getSubjectId()) == null) {
            str4 = "";
        }
        hashMap.put("subject_id", str4);
        hashMap.put("has_resource", String.valueOf((postSubjectItem == null || (subject = postSubjectItem.getSubject()) == null) ? null : subject.getHasResource()));
        if (postSubjectItem == null || (str5 = postSubjectItem.getPostId()) == null) {
            str5 = "";
        }
        hashMap.put("post_id", str5);
        if (postSubjectItem == null || (media2 = postSubjectItem.getMedia()) == null || (value = media2.getMediaType()) == null) {
            value = MediaType.TEXT.getValue();
        }
        hashMap.put("post_media_type", value);
        if (postSubjectItem == null || (value2 = postSubjectItem.getItemType()) == null) {
            value2 = PostItemType.SUBJECT.getValue();
        }
        hashMap.put("item_type", value2);
        if (postSubjectItem == null || (media = postSubjectItem.getMedia()) == null || (value3 = media.getMediaType()) == null) {
            value3 = MediaType.TEXT.getValue();
        }
        hashMap.put("post_media_type", value3);
        if (postSubjectItem == null || (group = postSubjectItem.getGroup()) == null || (str6 = group.getGroupId()) == null) {
            str6 = "";
        }
        hashMap.put("group_id", str6);
        if (postSubjectItem == null || (str7 = postSubjectItem.getTitle()) == null) {
            str7 = "";
        }
        hashMap.put(CampaignEx.JSON_KEY_TITLE, str7);
        if (postSubjectItem == null || (link = postSubjectItem.getLink()) == null || (str8 = link.getUrl()) == null) {
            str8 = "";
        }
        hashMap.put("link_url", str8);
        if (postSubjectItem == null || (str9 = postSubjectItem.getOps()) == null) {
            str9 = "";
        }
        hashMap.put("ops", str9);
        if (postSubjectItem != null && (user = postSubjectItem.getUser()) != null && (userId = user.getUserId()) != null) {
            str10 = userId;
        }
        hashMap.put("avatar_user_id", str10);
        com.transsion.baselib.helper.a.f43316a.g(str2, hashMap);
    }

    public static /* synthetic */ void t(a aVar, PostSubjectItem postSubjectItem, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = "postdetail";
        }
        if ((i11 & 4) != 0) {
            str2 = null;
        }
        aVar.s(postSubjectItem, str, str2);
    }

    public static /* synthetic */ void v(a aVar, PostSubjectItem postSubjectItem, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = "postdetail";
        }
        if ((i11 & 4) != 0) {
            str2 = null;
        }
        aVar.u(postSubjectItem, str, str2);
    }

    public static /* synthetic */ void x(a aVar, String str, String str2, String str3, int i11, long j11, PostSubjectItem postSubjectItem, String str4, int i12, Object obj) {
        aVar.w(str, str2, str3, i11, j11, postSubjectItem, (i12 & 64) != 0 ? null : str4);
    }

    public final void A(PostSubjectItem postSubjectItem, String pageName, String str) {
        Intrinsics.h(pageName, "pageName");
        r(postSubjectItem, "share", pageName, str);
    }

    public final void C(PostSubjectItem postSubjectItem, String pageName, String str) {
        Intrinsics.h(pageName, "pageName");
        r(postSubjectItem, "subject", pageName, str);
    }

    public final void a(PostSubjectItem postSubjectItem, String pageName, String str) {
        Intrinsics.h(pageName, "pageName");
        r(postSubjectItem, "audio_play", pageName, str);
    }

    public final void c(PostSubjectItem postSubjectItem, String pageName, String str) {
        Intrinsics.h(pageName, "pageName");
        r(postSubjectItem, "avatar", pageName, str);
    }

    public final void e(PostSubjectItem postSubjectItem, String pageName, String str) {
        Intrinsics.h(pageName, "pageName");
        r(postSubjectItem, "comment", pageName, str);
    }

    public final void g(String pageName, int i11, long j11, String str, String str2, String commentType, String str3, String str4, String str5, String str6, String str7, String str8) {
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(commentType, "commentType");
        if (str == null) {
            str = "";
        }
        Pair a11 = TuplesKt.a("comment_id", str);
        Pair a12 = TuplesKt.a(RequestParameters.POSITION, String.valueOf(i11));
        Pair a13 = TuplesKt.a("browse_duration", String.valueOf(j11));
        Pair a14 = TuplesKt.a("module_name", "comment");
        if (str2 == null) {
            str2 = "";
        }
        Map m11 = MapsKt.m(a11, a12, a13, a14, TuplesKt.a("topic_id", str2), TuplesKt.a("comment_type", commentType));
        if (str3 != null && str3.length() != 0) {
            m11.put(WebConstants.PAGE_FROM, str3);
        }
        if (str4 != null) {
            m11.put("track_id", str4);
        }
        if (str5 != null) {
            m11.put("parent_track_id", str5);
        }
        if (str6 != null) {
            m11.put("parent_content_id", str6);
        }
        if (str7 != null) {
            m11.put("content_id", str7);
        }
        if (str8 != null) {
            m11.put("belong_to_collection_id", str8);
        }
        hj.i.f64628a.D(pageName, m11);
    }

    public final void h(String postId, String moduleName, String pageName, String str, String commentType, String str2, String str3, String str4, String str5, String str6) {
        Intrinsics.h(postId, "postId");
        Intrinsics.h(moduleName, "moduleName");
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(commentType, "commentType");
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", moduleName);
        hashMap.put("topic_id", postId);
        hashMap.put("comment_type", commentType);
        if (str != null && str.length() != 0) {
            hashMap.put(WebConstants.PAGE_FROM, str);
        }
        if (str2 != null) {
            hashMap.put("track_id", str2);
        }
        if (str3 != null) {
            hashMap.put("parent_track_id", str3);
        }
        if (str4 != null) {
            hashMap.put("parent_content_id", str4);
        }
        if (str5 != null) {
            hashMap.put("content_id", str5);
        }
        if (str6 != null) {
            hashMap.put("belong_to_collection_id", str6);
        }
        com.transsion.baselib.helper.a.f43316a.g(pageName, hashMap);
    }

    public final void i(PostSubjectItem postSubjectItem, String pageName, String str) {
        Intrinsics.h(pageName, "pageName");
        r(postSubjectItem, "download", pageName, str);
    }

    public final void k(PostSubjectItem postSubjectItem, String pageName, String str) {
        Intrinsics.h(pageName, "pageName");
        r(postSubjectItem, "downloaded", pageName, str);
    }

    public final void l(PostSubjectItem postSubjectItem, String pageName, String str) {
        Intrinsics.h(pageName, "pageName");
        r(postSubjectItem, "post_feedback", pageName, str);
    }

    public final void m(PostSubjectItem postSubjectItem, String pageName, String str) {
        Intrinsics.h(pageName, "pageName");
        r(postSubjectItem, "group", pageName, str);
    }

    public final void o(PostSubjectItem postSubjectItem, String pageName, String str) {
        Intrinsics.h(pageName, "pageName");
        r(postSubjectItem, "image", pageName, str);
    }

    public final void p(PostSubjectItem postSubjectItem, boolean z10, String pageName, String str) {
        Intrinsics.h(pageName, "pageName");
        r(postSubjectItem, z10 ? "dislike" : "like", pageName, str);
    }

    public final void s(PostSubjectItem postSubjectItem, String pageName, String str) {
        Intrinsics.h(pageName, "pageName");
        r(postSubjectItem, "pause", pageName, str);
    }

    public final void u(PostSubjectItem postSubjectItem, String pageName, String str) {
        Intrinsics.h(pageName, "pageName");
        r(postSubjectItem, MediaItem.MUSIC_FLOAT_STATE_PLAY, pageName, str);
    }

    public final void w(String str, String pageName, String subpageName, int i11, long j11, PostSubjectItem item, String str2) {
        String str3;
        String str4;
        String str5;
        String str6;
        String value;
        Integer subjectType;
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(subpageName, "subpageName");
        Intrinsics.h(item, "item");
        String postId = item.getPostId();
        if (postId == null) {
            postId = "";
        }
        Pair a11 = TuplesKt.a("post_id", postId);
        Pair a12 = TuplesKt.a(RequestParameters.POSITION, String.valueOf(i11));
        Pair a13 = TuplesKt.a(WebConstants.PAGE_FROM, str);
        Pair a14 = TuplesKt.a("browse_duration", String.valueOf(j11));
        Pair a15 = TuplesKt.a("subpage_name", subpageName);
        Pair a16 = TuplesKt.a("module_name", WebConstants.FIELD_ITEM);
        Pair a17 = TuplesKt.a("is_cache_post", String.valueOf(item.isRoomCache()));
        User user = item.getUser();
        if (user == null || (str3 = user.getUserId()) == null) {
            str3 = "";
        }
        Pair a18 = TuplesKt.a("user_id", str3);
        if (str2 == null) {
            Group group = item.getGroup();
            str4 = group != null ? group.getGroupId() : null;
            if (str4 == null) {
                str4 = "";
            }
        } else {
            str4 = str2;
        }
        Pair a19 = TuplesKt.a("group_id", str4);
        Subject subject = item.getSubject();
        if (subject == null || (str5 = subject.getSubjectId()) == null) {
            str5 = "";
        }
        Pair a20 = TuplesKt.a("subject_id", str5);
        Subject subject2 = item.getSubject();
        if (subject2 == null || (subjectType = subject2.getSubjectType()) == null || (str6 = subjectType.toString()) == null) {
            str6 = "";
        }
        Pair a21 = TuplesKt.a("subject_type", str6);
        Pair a22 = TuplesKt.a("builtin", item.getBuiltIn() ? "1" : "0");
        Media media = item.getMedia();
        if (media == null || (value = media.getMediaType()) == null) {
            value = MediaType.TEXT.getValue();
        }
        Pair a23 = TuplesKt.a("post_media_type", value);
        String ops = item.getOps();
        hj.i.f64628a.D(pageName, MapsKt.m(a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21, a22, a23, TuplesKt.a("ops", ops != null ? ops : "")));
    }

    public final void y(String str, String pageName, String subpageName, int i11, String moduleName, PostSubjectItem item, String str2) {
        String str3;
        String str4;
        String value;
        Integer subjectType;
        String num;
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(subpageName, "subpageName");
        Intrinsics.h(moduleName, "moduleName");
        Intrinsics.h(item, "item");
        String postId = item.getPostId();
        String str5 = "";
        if (postId == null) {
            postId = "";
        }
        Pair a11 = TuplesKt.a("post_id", postId);
        Pair a12 = TuplesKt.a(RequestParameters.POSITION, String.valueOf(i11));
        Pair a13 = TuplesKt.a(WebConstants.PAGE_FROM, str);
        Pair a14 = TuplesKt.a("subpage_name", subpageName);
        Pair a15 = TuplesKt.a("module_name", moduleName);
        Pair a16 = TuplesKt.a("is_cache_post", String.valueOf(item.isRoomCache()));
        User user = item.getUser();
        if (user == null || (str3 = user.getUserId()) == null) {
            str3 = "";
        }
        Pair a17 = TuplesKt.a("user_id", str3);
        if (str2 == null) {
            Group group = item.getGroup();
            str2 = group != null ? group.getGroupId() : null;
            if (str2 == null) {
                str2 = "";
            }
        }
        Pair a18 = TuplesKt.a("group_id", str2);
        Subject subject = item.getSubject();
        if (subject == null || (str4 = subject.getSubjectId()) == null) {
            str4 = "";
        }
        Pair a19 = TuplesKt.a("subject_id", str4);
        Subject subject2 = item.getSubject();
        if (subject2 != null && (subjectType = subject2.getSubjectType()) != null && (num = subjectType.toString()) != null) {
            str5 = num;
        }
        Pair a20 = TuplesKt.a("subject_type", str5);
        Media media = item.getMedia();
        if (media == null || (value = media.getMediaType()) == null) {
            value = MediaType.TEXT.getValue();
        }
        hj.i.f64628a.p(pageName, MapsKt.m(a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, TuplesKt.a("post_media_type", value), TuplesKt.a("ops", item.getOps())));
    }
}
