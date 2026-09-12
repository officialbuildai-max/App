package com.transsion.postdetail.util;

import com.transsion.moviedetailapi.bean.FirstFrame;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.MediaType;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.User;
import com.transsion.moviedetailapi.bean.Video;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import ej.f;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes6.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f50219a = new g();

    /* renamed from: b, reason: collision with root package name */
    private static boolean f50220b;

    private g() {
    }

    private final void a(PostSubjectItem postSubjectItem) {
        List<Image> image;
        Media media = postSubjectItem.getMedia();
        if (media == null || (image = media.getImage()) == null) {
            return;
        }
        Iterator<T> it = image.iterator();
        while (it.hasNext()) {
            String url = ((Image) it.next()).getUrl();
            if (url != null) {
                f.a aVar = ej.f.f62005a;
                String e11 = f.a.e(aVar, url, aVar.c(), false, true, 4, null);
                a.C0856a.r(lg.a.f68962a, "PostImage", new String[]{"3----preloadImage:" + e11}, false, 4, null);
                f.a.j(aVar, e11, url, aVar.c(), null, 8, null);
            }
        }
    }

    private final void c(PostSubjectItem postSubjectItem) {
        List<Video> video;
        Video video2;
        FirstFrame firstFrame;
        String url;
        Media media = postSubjectItem.getMedia();
        if (media == null || (video = media.getVideo()) == null || (video2 = (Video) CollectionsKt.k0(video)) == null) {
            return;
        }
        Integer height = video2.getHeight();
        int intValue = height != null ? height.intValue() : 0;
        Integer width = video2.getWidth();
        boolean z10 = intValue > (width != null ? width.intValue() : 0);
        if (z10) {
            dk.a.b(280);
        } else {
            dk.a.b(162);
        }
        int b11 = dk.a.b(z10 ? Sdk$SDKError.Reason.MRAID_JS_DOES_NOT_EXIST_VALUE : 280);
        Media media2 = postSubjectItem.getMedia();
        if (media2 == null || (firstFrame = media2.getFirstFrame()) == null || (url = firstFrame.getUrl()) == null) {
            return;
        }
        f.a aVar = ej.f.f62005a;
        String e11 = f.a.e(aVar, url, b11, false, true, 4, null);
        a.C0856a.r(lg.a.f68962a, "PostImage", new String[]{"4-----preloadVideoImage:" + e11}, false, 4, null);
        f.a.j(aVar, e11, url, b11, null, 8, null);
    }

    public final void b(List dataList) {
        String avatar;
        String avatar2;
        Intrinsics.h(dataList, "dataList");
        Iterator it = dataList.iterator();
        while (it.hasNext()) {
            PostSubjectItem postSubjectItem = (PostSubjectItem) it.next();
            Group group = postSubjectItem.getGroup();
            if (group != null && (avatar2 = group.getAvatar()) != null) {
                f.a aVar = ej.f.f62005a;
                String e11 = f.a.e(aVar, avatar2, dk.a.b(36), false, true, 4, null);
                a.C0856a.r(lg.a.f68962a, "PostImage", new String[]{"1--preloadRoomAvatar:" + e11}, false, 4, null);
                f.a.j(aVar, e11, avatar2, dk.a.b(36), null, 8, null);
            }
            User user = postSubjectItem.getUser();
            if (user != null && (avatar = user.getAvatar()) != null) {
                f.a aVar2 = ej.f.f62005a;
                String e12 = f.a.e(aVar2, avatar, dk.a.b(16), false, true, 4, null);
                a.C0856a.r(lg.a.f68962a, "PostImage", new String[]{"2---preloadUserAvatar:" + e12}, false, 4, null);
                f.a.j(aVar2, f.a.e(aVar2, avatar, dk.a.b(16), false, true, 4, null), avatar, dk.a.b(16), null, 8, null);
            }
            Media media = postSubjectItem.getMedia();
            String mediaType = media != null ? media.getMediaType() : null;
            if (Intrinsics.c(mediaType, MediaType.IMAGE.getValue())) {
                f50219a.a(postSubjectItem);
            } else if (Intrinsics.c(mediaType, MediaType.VIDEO.getValue())) {
                f50219a.c(postSubjectItem);
            }
        }
    }

    public final void d(boolean z10) {
        f50220b = z10;
    }
}
