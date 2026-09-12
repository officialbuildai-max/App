package com.transsion.search_pugc.constant;

import ak.k;
import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import androidx.core.content.b;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.transsion.search.R$color;
import com.transsion.search_pugc.constant.ResultCollectItemWrapper;
import com.transsion.ugcvideodetail.api.bean.UGCVerticalRank;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;

/* loaded from: classes6.dex */
public abstract class a {
    public static final Navigator c(Navigator navigator, String str) {
        Navigator K;
        Intrinsics.h(navigator, "<this>");
        return (str == null || (K = navigator.K("ops", str)) == null) ? navigator : K;
    }

    public static final SpannableString d(String str, Context context, String str2) {
        Intrinsics.h(str, "<this>");
        Intrinsics.h(context, "context");
        SpannableString spannableString = new SpannableString(str);
        if (str2 != null && !StringsKt.q0(str2)) {
            int color = b.getColor(context, R$color.color_keyword);
            List<String> split = new Regex("\\s+").split(StringsKt.n1(str2).toString(), 0);
            ArrayList arrayList = new ArrayList();
            for (Object obj : split) {
                if (!StringsKt.q0((String) obj)) {
                    arrayList.add(obj);
                }
            }
            if (arrayList.isEmpty()) {
                return spannableString;
            }
            for (MatchResult matchResult : Regex.findAll$default(new Regex(CollectionsKt.s0(arrayList, "[\\s\\p{Punct}]+", null, null, 0, null, new Function1() { // from class: br.c
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    CharSequence e11;
                    e11 = com.transsion.search_pugc.constant.a.e((String) obj2);
                    return e11;
                }
            }, 30, null), RegexOption.IGNORE_CASE), str, 0, 2, null)) {
                spannableString.setSpan(new ForegroundColorSpan(color), matchResult.b().getFirst(), matchResult.b().getLast() + 1, 33);
            }
        }
        return spannableString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence e(String it) {
        Intrinsics.h(it, "it");
        return Regex.INSTANCE.c(it);
    }

    public static final void f(UGCVerticalRank uGCVerticalRank, String str) {
        UGCVideo uGCVideo;
        Intrinsics.h(uGCVerticalRank, "<this>");
        Navigator K = TheRouter.c("/home/ugc_film_list").K("filmType", uGCVerticalRank.getId()).K("filmListTitle", uGCVerticalRank.getTitle());
        List<UGCVideo> videos = uGCVerticalRank.getVideos();
        K.K("videoType", (videos == null || (uGCVideo = (UGCVideo) CollectionsKt.k0(videos)) == null) ? null : uGCVideo.getCategory());
        k.p(c(K, str));
    }

    public static final void g(UGCVideo uGCVideo, final boolean z10) {
        Intrinsics.h(uGCVideo, "<this>");
        pv.b.a(uGCVideo, new Function1() { // from class: br.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Navigator i11;
                i11 = com.transsion.search_pugc.constant.a.i(z10, (Navigator) obj);
                return i11;
            }
        });
    }

    public static /* synthetic */ void h(UGCVideo uGCVideo, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = false;
        }
        g(uGCVideo, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Navigator i(boolean z10, Navigator navigator) {
        Intrinsics.h(navigator, "navigator");
        return navigator.z("ugc_without_history", z10);
    }

    public static final String j(long j11) {
        long j12 = 60;
        String format = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j11 / j12), Long.valueOf(j11 % j12)}, 2));
        Intrinsics.g(format, "format(...)");
        return format;
    }

    public static final List k(List list) {
        Intrinsics.h(list, "<this>");
        List list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.v(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(new ResultCollectItemWrapper((UGCVideo) it.next(), ResultCollectItemWrapper.Type.DATA));
        }
        return arrayList;
    }

    public static final String l(String str) {
        Intrinsics.h(str, "<this>");
        try {
            int parseInt = Integer.parseInt(str);
            if (parseInt < 1000) {
                str = String.valueOf(parseInt);
            } else if (parseInt < 1000000) {
                String format = String.format("%.1fk", Arrays.copyOf(new Object[]{Double.valueOf(parseInt / 1000.0d)}, 1));
                Intrinsics.g(format, "format(...)");
                str = StringsKt.J0(format, ".0");
            } else if (parseInt < 1000000000) {
                String format2 = String.format("%.1fM", Arrays.copyOf(new Object[]{Double.valueOf(parseInt / 1000000.0d)}, 1));
                Intrinsics.g(format2, "format(...)");
                str = StringsKt.J0(format2, ".0");
            } else {
                str = "999M+";
            }
        } catch (NumberFormatException unused) {
        }
        return str;
    }
}
