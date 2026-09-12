package com.transsion.moviedetailapi;

import android.app.Application;
import android.os.Bundle;
import androidx.view.LiveData;
import androidx.view.b0;
import androidx.view.u0;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.moviedetailapi.bean.Link;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.MediaType;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.User;
import com.transsion.moviedetailapi.p006enum.PostListSource;
import com.transsion.moviedetailapi.p006enum.ProfileSubSource;
import com.transsion.web.api.WebConstants;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;

/* loaded from: classes.dex */
public abstract class AbsSubjectListViewModel extends androidx.view.b {

    /* renamed from: j, reason: collision with root package name */
    public static final a f47506j = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private final Lazy f47507b;

    /* renamed from: c, reason: collision with root package name */
    private final Lazy f47508c;

    /* renamed from: d, reason: collision with root package name */
    private final Lazy f47509d;

    /* renamed from: e, reason: collision with root package name */
    private final Lazy f47510e;

    /* renamed from: f, reason: collision with root package name */
    private final Lazy f47511f;

    /* renamed from: g, reason: collision with root package name */
    private final Lazy f47512g;

    /* renamed from: h, reason: collision with root package name */
    private String f47513h;

    /* renamed from: i, reason: collision with root package name */
    private PostRankType f47514i;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsSubjectListViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.f47507b = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0() { // from class: com.transsion.moviedetailapi.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                kn.a L;
                L = AbsSubjectListViewModel.L();
                return L;
            }
        });
        this.f47508c = LazyKt.b(new Function0() { // from class: com.transsion.moviedetailapi.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                b0 G;
                G = AbsSubjectListViewModel.G();
                return G;
            }
        });
        this.f47509d = LazyKt.b(new Function0() { // from class: com.transsion.moviedetailapi.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                b0 j11;
                j11 = AbsSubjectListViewModel.j();
                return j11;
            }
        });
        this.f47510e = LazyKt.b(new Function0() { // from class: com.transsion.moviedetailapi.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                b0 k11;
                k11 = AbsSubjectListViewModel.k();
                return k11;
            }
        });
        this.f47511f = LazyKt.b(new Function0() { // from class: com.transsion.moviedetailapi.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                b0 D;
                D = AbsSubjectListViewModel.D();
                return D;
            }
        });
        this.f47512g = LazyKt.b(new Function0() { // from class: com.transsion.moviedetailapi.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                b0 l11;
                l11 = AbsSubjectListViewModel.l();
                return l11;
            }
        });
        this.f47513h = "";
        this.f47514i = PostRankType.POST_RANK_TYPE_DEFAULT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 D() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 G() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kn.a L() {
        return (kn.a) zg.c.f79537e.a().h(kn.a.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 j() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 k() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 l() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kn.a z() {
        return (kn.a) this.f47507b.getValue();
    }

    public abstract PostListSource A();

    public ProfileSubSource B() {
        return null;
    }

    public void C(String str, int i11) {
        k.d(u0.a(this), null, null, new AbsSubjectListViewModel$like$1(str, i11, this, null), 3, null);
    }

    public abstract void E(boolean z10);

    public abstract void F(Bundle bundle);

    public void H(PostSubjectItem postSubjectItem, int i11) {
        String str;
        String value;
        String str2;
        String str3;
        String str4;
        String str5;
        Intrinsics.h(postSubjectItem, "postSubjectItem");
        HashMap hashMap = new HashMap();
        Subject subject = postSubjectItem.getSubject();
        if (subject == null || (str = subject.getSubjectId()) == null) {
            str = "";
        }
        hashMap.put("subject_id", str);
        Subject subject2 = postSubjectItem.getSubject();
        hashMap.put("has_resource", String.valueOf(subject2 != null ? subject2.getHasResource() : null));
        String postId = postSubjectItem.getPostId();
        if (postId == null) {
            postId = "";
        }
        hashMap.put("post_id", postId);
        Media media = postSubjectItem.getMedia();
        if (media == null || (value = media.getMediaType()) == null) {
            value = MediaType.TEXT.getValue();
        }
        hashMap.put("post_media_type", value);
        Group group = postSubjectItem.getGroup();
        if (group == null || (str2 = group.getGroupId()) == null) {
            str2 = "";
        }
        hashMap.put("group_id", str2);
        Subject subject3 = postSubjectItem.getSubject();
        if (subject3 == null || (str3 = subject3.getSubjectId()) == null) {
            str3 = "";
        }
        hashMap.put("subject_id", str3);
        String content = postSubjectItem.getContent();
        if (content == null) {
            content = "";
        }
        hashMap.put("link_url", content);
        Link link = postSubjectItem.getLink();
        if (link == null || (str4 = link.getUrl()) == null) {
            str4 = "";
        }
        hashMap.put("link_url", str4);
        User user = postSubjectItem.getUser();
        if (user == null || (str5 = user.getUserId()) == null) {
            str5 = "";
        }
        hashMap.put("avatar_user_id", str5);
        hashMap.put("sequence", String.valueOf(i11));
        String ops = postSubjectItem.getOps();
        if (ops == null) {
            ops = "";
        }
        hashMap.put("ops", ops);
        hashMap.put(WebConstants.PAGE_FROM, this.f47513h);
        Map q11 = q(this.f47514i.ordinal());
        if (q11 != null) {
            for (Map.Entry entry : q11.entrySet()) {
                String str6 = (String) entry.getKey();
                String str7 = (String) entry.getValue();
                if (str7 == null) {
                    str7 = "";
                }
                hashMap.put(str6, str7);
            }
        }
        com.transsion.baselib.helper.a.f43316a.e(w(this.f47514i.ordinal()), hashMap);
    }

    public void I(PostSubjectItem postSubjectItem, int i11, String subPageName) {
        String str;
        String value;
        String str2;
        String str3;
        String str4;
        String str5;
        Intrinsics.h(postSubjectItem, "postSubjectItem");
        Intrinsics.h(subPageName, "subPageName");
        HashMap hashMap = new HashMap();
        Subject subject = postSubjectItem.getSubject();
        if (subject == null || (str = subject.getSubjectId()) == null) {
            str = "";
        }
        hashMap.put("subject_id", str);
        Subject subject2 = postSubjectItem.getSubject();
        hashMap.put("has_resource", String.valueOf(subject2 != null ? subject2.getHasResource() : null));
        String postId = postSubjectItem.getPostId();
        if (postId == null) {
            postId = "";
        }
        hashMap.put("post_id", postId);
        Media media = postSubjectItem.getMedia();
        if (media == null || (value = media.getMediaType()) == null) {
            value = MediaType.TEXT.getValue();
        }
        hashMap.put("post_media_type", value);
        Group group = postSubjectItem.getGroup();
        if (group == null || (str2 = group.getGroupId()) == null) {
            str2 = "";
        }
        hashMap.put("group_id", str2);
        Subject subject3 = postSubjectItem.getSubject();
        if (subject3 == null || (str3 = subject3.getSubjectId()) == null) {
            str3 = "";
        }
        hashMap.put("subject_id", str3);
        String title = postSubjectItem.getTitle();
        if (title == null) {
            title = "";
        }
        hashMap.put(CampaignEx.JSON_KEY_TITLE, title);
        Link link = postSubjectItem.getLink();
        if (link == null || (str4 = link.getUrl()) == null) {
            str4 = "";
        }
        hashMap.put("link_url", str4);
        User user = postSubjectItem.getUser();
        if (user == null || (str5 = user.getUserId()) == null) {
            str5 = "";
        }
        hashMap.put("avatar_user_id", str5);
        hashMap.put("sequence", String.valueOf(i11));
        String ops = postSubjectItem.getOps();
        if (ops == null) {
            ops = "";
        }
        hashMap.put("ops", ops);
        hashMap.put(WebConstants.PAGE_FROM, this.f47513h);
        hashMap.put("module_name", WebConstants.FIELD_ITEM);
        hashMap.put("subpage_name", subPageName);
        Map q11 = q(this.f47514i.ordinal());
        if (q11 != null) {
            for (Map.Entry entry : q11.entrySet()) {
                String str6 = (String) entry.getKey();
                String str7 = (String) entry.getValue();
                if (str7 == null) {
                    str7 = "";
                }
                hashMap.put(str6, str7);
            }
        }
        com.transsion.baselib.helper.a.f43316a.f(w(this.f47514i.ordinal()), hashMap);
    }

    public void J(PostSubjectItem postSubjectItem, int i11, String moduleName, String subPageName) {
        Intrinsics.h(postSubjectItem, "postSubjectItem");
        Intrinsics.h(moduleName, "moduleName");
        Intrinsics.h(subPageName, "subPageName");
        Link link = postSubjectItem.getLink();
        K(postSubjectItem, i11, moduleName, link != null ? link.getUrl() : null, subPageName);
    }

    public void K(PostSubjectItem postSubjectItem, int i11, String moduleName, String str, String str2) {
        String str3;
        String value;
        String value2;
        String str4;
        String str5;
        Intrinsics.h(postSubjectItem, "postSubjectItem");
        Intrinsics.h(moduleName, "moduleName");
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", moduleName);
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("subpage_name", str2);
        Subject subject = postSubjectItem.getSubject();
        if (subject == null || (str3 = subject.getSubjectId()) == null) {
            str3 = "";
        }
        hashMap.put("subject_id", str3);
        Subject subject2 = postSubjectItem.getSubject();
        hashMap.put("has_resource", String.valueOf(subject2 != null ? subject2.getHasResource() : null));
        String postId = postSubjectItem.getPostId();
        if (postId == null) {
            postId = "";
        }
        hashMap.put("post_id", postId);
        Media media = postSubjectItem.getMedia();
        if (media == null || (value = media.getMediaType()) == null) {
            value = MediaType.TEXT.getValue();
        }
        hashMap.put("post_media_type", value);
        String itemType = postSubjectItem.getItemType();
        if (itemType == null) {
            itemType = PostItemType.SUBJECT.getValue();
        }
        hashMap.put("item_type", itemType);
        Media media2 = postSubjectItem.getMedia();
        if (media2 == null || (value2 = media2.getMediaType()) == null) {
            value2 = MediaType.TEXT.getValue();
        }
        hashMap.put("post_media_type", value2);
        Group group = postSubjectItem.getGroup();
        if (group == null || (str4 = group.getGroupId()) == null) {
            str4 = "";
        }
        hashMap.put("group_id", str4);
        String title = postSubjectItem.getTitle();
        if (title == null) {
            title = "";
        }
        hashMap.put(CampaignEx.JSON_KEY_TITLE, title);
        if (str == null) {
            str = "";
        }
        hashMap.put("link_url", str);
        String ops = postSubjectItem.getOps();
        if (ops == null) {
            ops = "";
        }
        hashMap.put("ops", ops);
        hashMap.put(WebConstants.PAGE_FROM, this.f47513h);
        User user = postSubjectItem.getUser();
        if (user == null || (str5 = user.getUserId()) == null) {
            str5 = "";
        }
        hashMap.put("avatar_user_id", str5);
        hashMap.put("sequence", String.valueOf(i11));
        Map u11 = u(this.f47514i.ordinal());
        if (u11 != null) {
            for (Map.Entry entry : u11.entrySet()) {
                String str6 = (String) entry.getKey();
                String str7 = (String) entry.getValue();
                if (str7 == null) {
                    str7 = "";
                }
                hashMap.put(str6, str7);
            }
        }
        com.transsion.baselib.helper.a.f43316a.g(w(this.f47514i.ordinal()), hashMap);
    }

    public final void M(PostRankType postRankType) {
        Intrinsics.h(postRankType, "<set-?>");
        this.f47514i = postRankType;
    }

    public final void N(String str) {
        Intrinsics.h(str, "<set-?>");
        this.f47513h = str;
    }

    public final void m(String str) {
        k.d(u0.a(this), null, null, new AbsSubjectListViewModel$deletePost$1(str, this, null), 3, null);
    }

    public final LiveData n() {
        return o();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final b0 o() {
        return (b0) this.f47509d.getValue();
    }

    public final b0 p() {
        return (b0) this.f47512g.getValue();
    }

    public Map q(int i11) {
        return null;
    }

    public final LiveData r() {
        return s();
    }

    protected final b0 s() {
        return (b0) this.f47511f.getValue();
    }

    public final PostRankType t() {
        return this.f47514i;
    }

    public Map u(int i11) {
        return null;
    }

    public final String v() {
        return this.f47513h;
    }

    public String w(int i11) {
        return "";
    }

    public final LiveData x() {
        return y();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final b0 y() {
        return (b0) this.f47508c.getValue();
    }
}
