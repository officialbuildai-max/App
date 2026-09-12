package com.transsion.ugcvideodetail.api;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.blankj.utilcode.util.o;
import com.google.gson.reflect.TypeToken;
import com.transsion.baseui.R$drawable;
import com.transsion.baseui.R$string;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsion.ugcvideodetail.api.bean.UGCVideoCategory;
import ej.f;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import sm.f;

/* loaded from: classes6.dex */
public abstract class UGCVideoTypeKt {

    /* renamed from: a */
    private static String f56129a;

    /* renamed from: b */
    private static Map f56130b;

    /* renamed from: c */
    private static final Lazy f56131c = LazyKt.b(new Function0() { // from class: com.transsion.ugcvideodetail.api.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            int b11;
            b11 = UGCVideoTypeKt.b();
            return Integer.valueOf(b11);
        }
    });

    public static final int b() {
        return dk.a.b(12);
    }

    private static final Map c() {
        Map map = null;
        ConfigBean d11 = f.d(f.f75530c.a(), "sa_ugc_category_icon_config", false, 2, null);
        String value = d11 != null ? d11.getValue() : null;
        if (value == null || value.length() == 0) {
            return null;
        }
        if (Intrinsics.c(value, f56129a)) {
            return f56130b;
        }
        try {
            Object e11 = o.e(value, new TypeToken<Map<String, ? extends String>>() { // from class: com.transsion.ugcvideodetail.api.UGCVideoTypeKt$getCachedIconMap$type$1
            }.getType());
            Intrinsics.g(e11, "fromJson(...)");
            Map map2 = (Map) e11;
            f56129a = value;
            f56130b = map2;
            map = map2;
        } catch (Throwable unused) {
        }
        return map;
    }

    private static final int d() {
        return ((Number) f56131c.getValue()).intValue();
    }

    public static final int e(String str) {
        if (Intrinsics.c(str, UGCVideoType.MOVIE.getValue())) {
            return R$drawable.ic_tag_movie;
        }
        if (Intrinsics.c(str, UGCVideoType.TV.getValue())) {
            return R$drawable.ic_tag_tv;
        }
        if (Intrinsics.c(str, UGCVideoType.MUSIC.getValue())) {
            return R$drawable.ic_tag_music;
        }
        if (Intrinsics.c(str, UGCVideoType.EDUCATION.getValue())) {
            return R$drawable.ic_tag_edu;
        }
        if (Intrinsics.c(str, UGCVideoType.SHORT_TV.getValue())) {
            return R$drawable.ic_tag_short_tv;
        }
        if (Intrinsics.c(str, UGCVideoType.SPORT.getValue())) {
            return R$drawable.ic_tag_sport;
        }
        if (!Intrinsics.c(str, UGCVideoType.ROOM.getValue()) && !Intrinsics.c(str, UGCVideoType.POST.getValue())) {
            return Intrinsics.c(str, UGCVideoType.NOVEL.getValue()) ? R$drawable.ic_tag_novel : Intrinsics.c(str, UGCVideoType.LIVE.getValue()) ? R$drawable.ic_tag_live : Intrinsics.c(str, UGCVideoType.KIDS.getValue()) ? R$drawable.ic_tag_kids : Intrinsics.c(str, UGCVideoType.RECREATION.getValue()) ? R$drawable.ic_tag_breakdown : R$drawable.ic_tag_default;
        }
        return R$drawable.ic_tag_room;
    }

    private static final String f(UGCVideo uGCVideo) {
        Map c11 = c();
        if (c11 == null) {
            return null;
        }
        UGCVideoCategory cateLev4 = uGCVideo.getCateLev4();
        Integer id2 = cateLev4 != null ? cateLev4.getId() : null;
        UGCVideoCategory cateLev3 = uGCVideo.getCateLev3();
        Integer id3 = cateLev3 != null ? cateLev3.getId() : null;
        UGCVideoCategory cateLev2 = uGCVideo.getCateLev2();
        Integer id4 = cateLev2 != null ? cateLev2.getId() : null;
        UGCVideoCategory cateLev1 = uGCVideo.getCateLev1();
        Iterator it = CollectionsKt.p(id2, id3, id4, cateLev1 != null ? cateLev1.getId() : null).iterator();
        while (it.hasNext()) {
            String str = (String) c11.get(String.valueOf(((Number) it.next()).intValue()));
            if (str != null) {
                return str;
            }
        }
        return null;
    }

    public static final int g(String str) {
        if (Intrinsics.c(str, UGCVideoType.MOVIE.getValue())) {
            return R$string.ugc_video_movie;
        }
        if (Intrinsics.c(str, UGCVideoType.TV.getValue())) {
            return R$string.ugc_video_tv_shows;
        }
        if (Intrinsics.c(str, UGCVideoType.MUSIC.getValue())) {
            return R$string.ugc_video_music;
        }
        if (Intrinsics.c(str, UGCVideoType.EDUCATION.getValue())) {
            return R$string.ugc_video_education;
        }
        if (Intrinsics.c(str, UGCVideoType.SHORT_TV.getValue())) {
            return R$string.ugc_video_short_tv;
        }
        if (Intrinsics.c(str, UGCVideoType.SPORT.getValue())) {
            return R$string.ugc_video_sports;
        }
        if (!Intrinsics.c(str, UGCVideoType.ROOM.getValue()) && !Intrinsics.c(str, UGCVideoType.POST.getValue())) {
            return Intrinsics.c(str, UGCVideoType.NOVEL.getValue()) ? R$string.ugc_video_novel : Intrinsics.c(str, UGCVideoType.LIVE.getValue()) ? R$string.ugc_video_live : Intrinsics.c(str, UGCVideoType.KIDS.getValue()) ? R$string.ugc_video_kids : Intrinsics.c(str, UGCVideoType.RECREATION.getValue()) ? R$string.ugc_video_recreation : R$string.ugc_video_video;
        }
        return R$string.ugc_video_buzzbox;
    }

    public static final void h(ImageView imageView, UGCVideo ugcVideo, Integer num) {
        Intrinsics.h(imageView, "imageView");
        Intrinsics.h(ugcVideo, "ugcVideo");
        int e11 = e(ugcVideo.getCategory());
        String f11 = f(ugcVideo);
        if (f11 == null || f11.length() == 0) {
            imageView.setImageResource(e11);
            return;
        }
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        layoutParams.width = num != null ? num.intValue() : d();
        layoutParams.height = num != null ? num.intValue() : d();
        imageView.setLayoutParams(layoutParams);
        f.a aVar = ej.f.f62005a;
        Context context = imageView.getContext();
        Intrinsics.g(context, "getContext(...)");
        aVar.m(context).g(f11).i(e11).d(imageView);
    }

    public static /* synthetic */ void i(ImageView imageView, UGCVideo uGCVideo, Integer num, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            num = null;
        }
        h(imageView, uGCVideo, num);
    }

    public static final void j(ImageView imageView, Integer num, Integer num2, Integer num3, Integer num4, String str) {
        String str2;
        Intrinsics.h(imageView, "imageView");
        int e11 = e(str);
        Map c11 = c();
        Iterator it = CollectionsKt.p(num4, num3, num2, num).iterator();
        do {
            str2 = null;
            if (!it.hasNext()) {
                break;
            }
            int intValue = ((Number) it.next()).intValue();
            if (c11 != null) {
                str2 = (String) c11.get(String.valueOf(intValue));
            }
        } while (str2 == null);
        if (str2 == null || str2.length() == 0) {
            imageView.setImageResource(e11);
            return;
        }
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        layoutParams.width = d();
        layoutParams.height = d();
        imageView.setLayoutParams(layoutParams);
        f.a aVar = ej.f.f62005a;
        Context context = imageView.getContext();
        Intrinsics.g(context, "getContext(...)");
        aVar.m(context).g(str2).i(e11).d(imageView);
    }
}
