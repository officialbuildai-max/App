package aq;

import ak.k;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.transsion.home.p004enum.BottomTabType;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.MediaType;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.postdetailapi.IPostDetailApi;
import com.transsion.web.api.WebConstants;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class h {

    /* renamed from: a */
    public static final h f16175a = new h();

    /* renamed from: b */
    private static boolean f16176b;

    /* renamed from: c */
    private static boolean f16177c;

    /* renamed from: d */
    private static String f16178d;

    /* renamed from: e */
    private static String f16179e;

    /* renamed from: f */
    private static String f16180f;

    /* renamed from: g */
    private static boolean f16181g;

    /* renamed from: h */
    private static String f16182h;

    private h() {
    }

    public static /* synthetic */ void i(h hVar, String str, String str2, String str3, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = null;
        }
        if ((i11 & 2) != 0) {
            str2 = null;
        }
        if ((i11 & 4) != 0) {
            str3 = null;
        }
        if ((i11 & 8) != 0) {
            z10 = false;
        }
        hVar.h(str, str2, str3, z10);
    }

    public static /* synthetic */ void k(h hVar, PostSubjectItem postSubjectItem, String str, String str2, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = null;
        }
        if ((i11 & 4) != 0) {
            str2 = null;
        }
        if ((i11 & 8) != 0) {
            z10 = false;
        }
        hVar.j(postSubjectItem, str, str2, z10);
    }

    public final boolean a() {
        return f16176b;
    }

    public final boolean b() {
        return f16177c;
    }

    public final String c() {
        return f16182h;
    }

    public final String d() {
        return f16178d;
    }

    public final String e() {
        return f16179e;
    }

    public final boolean f() {
        return f16181g;
    }

    public final String g() {
        return f16180f;
    }

    public final void h(String str, String str2, String str3, boolean z10) {
        f16178d = str;
        f16179e = str2;
        f16180f = str3;
        if (!f16176b || z10) {
            k.p(TheRouter.c("/room/home"));
        } else {
            k.p(TheRouter.c("/main/tab").K("bottomTab", BottomTabType.TAB_CODE_COMMUNITY).K("topTab", "Community"));
        }
    }

    public final void j(PostSubjectItem item, String str, String str2, boolean z10) {
        Intrinsics.h(item, "item");
        f16179e = str;
        f16180f = str2;
        Media media = item.getMedia();
        String mediaType = media != null ? media.getMediaType() : null;
        MediaType mediaType2 = MediaType.VIDEO;
        if (Intrinsics.c(mediaType, mediaType2.getValue())) {
            IPostDetailApi iPostDetailApi = (IPostDetailApi) TheRouter.d(IPostDetailApi.class, new Object[0]);
            if (iPostDetailApi != null) {
                iPostDetailApi.i(item);
            }
            Media media2 = item.getMedia();
            Navigator K = TheRouter.c(Intrinsics.c(media2 != null ? media2.getMediaType() : null, mediaType2.getValue()) ? "/post/detailVideo" : "/post/detail").K(WebConstants.PAGE_FROM, str2).J("item_object", item).K("id", item.getPostId()).K("rec_ops", item.getOps()).K("item_type", item.getItemType());
            Media media3 = item.getMedia();
            k.p(K.K("media_type", media3 != null ? media3.getMediaType() : null).z("is_build_in", item.getBuiltIn()));
            return;
        }
        Media media4 = item.getMedia();
        if (!Intrinsics.c(media4 != null ? media4.getMediaType() : null, MediaType.IMAGE.getValue())) {
            h(item.getPostId(), str, str2, z10);
            return;
        }
        f16181g = true;
        f16182h = item.getPostId();
        if (!f16176b || z10) {
            k.p(TheRouter.c("/room/home"));
        } else {
            k.p(TheRouter.c("/main/tab").K("bottomTab", BottomTabType.TAB_CODE_COMMUNITY).K("topTab", "Community"));
        }
    }

    public final void l(boolean z10) {
        f16176b = z10;
    }

    public final void m(boolean z10) {
        f16177c = z10;
    }

    public final void n(String str) {
        f16182h = str;
    }

    public final void o(String str) {
        f16178d = str;
    }

    public final void p(String str) {
        f16179e = str;
    }

    public final void q(boolean z10) {
        f16181g = z10;
    }

    public final void r(String str) {
        f16180f = str;
    }
}
