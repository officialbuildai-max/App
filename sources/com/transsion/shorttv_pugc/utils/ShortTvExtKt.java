package com.transsion.shorttv_pugc.utils;

import android.content.Context;
import android.os.Build;
import android.text.style.ImageSpan;
import com.blankj.utilcode.util.Utils;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.cloud.tmc.miniutils.constant.TimeConstants;
import com.google.gson.Gson;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.shorttv.R$layout;
import com.transsion.shorttv.R$mipmap;
import com.transsion.shorttv_pugc.ShorttvModel;
import com.transsion.shorttv_pugc.bean.BannerData;
import com.transsion.shorttv_pugc.bean.OperateItem;
import com.transsion.shorttv_pugc.bean.Subject;
import com.transsion.shorttv_pugc.bean.Video;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kt.b;

/* loaded from: classes6.dex */
public abstract class ShortTvExtKt {
    public static final void a(OperateItem operateItem, Map map) {
        Intrinsics.h(operateItem, "<this>");
        Intrinsics.h(map, "map");
        map.put("item_type", "opt");
        String type = operateItem.getType();
        if (type == null) {
            type = "";
        }
        map.put("opt_type", type);
        String title = operateItem.getTitle();
        if (title == null) {
            title = "";
        }
        map.put("opTitle", title);
        String opId = operateItem.getOpId();
        map.put("opId", opId != null ? opId : "");
    }

    public static final void b(BannerData bannerData, Map map) {
        Intrinsics.h(bannerData, "<this>");
        Intrinsics.h(map, "map");
        String subjectId = bannerData.getSubjectId();
        if (subjectId == null) {
            subjectId = "";
        }
        map.put("subject_id", subjectId);
        map.put("has_resource", String.valueOf(bannerData.getHasResource()));
        map.put("subject_type", String.valueOf(bannerData.getSubjectType()));
        map.put(NativeComponentConstants.KEY_COMPONENT_TYPE, String.valueOf(bannerData.getType()));
        String ops = bannerData.getOps();
        if (ops == null) {
            ops = "";
        }
        map.put("ops", ops);
        String content = bannerData.getContent();
        if (content == null) {
            content = "";
        }
        map.put("content", content);
        map.put("builtin", bannerData.getBuiltIn() ? "1" : "0");
        String deepLink = bannerData.getDeepLink();
        map.put("deeplink", deepLink != null ? deepLink : "");
        map.put("seenStatus", String.valueOf(bannerData.getSeenStatus()));
    }

    public static final void c(Subject subject, Map map) {
        Intrinsics.h(subject, "<this>");
        Intrinsics.h(map, "map");
        String subjectId = subject.getSubjectId();
        if (subjectId == null) {
            subjectId = "";
        }
        map.put("subject_id", subjectId);
        map.put("has_resource", String.valueOf(subject.getHasResource()));
        map.put("subject_type", String.valueOf(subject.getSubjectType()));
        String ops = subject.getOps();
        map.put("ops", ops != null ? ops : "");
        map.put("builtin", subject.getBuiltIn() ? "1" : "0");
        map.put("tag", String.valueOf(subject.getTags()));
        map.put("seenStatus", String.valueOf(subject.getSeenStatus()));
    }

    public static final int d(int i11) {
        return i11 - 1;
    }

    public static final List e(List list, List other) {
        Intrinsics.h(list, "<this>");
        Intrinsics.h(other, "other");
        List list2 = list;
        ArrayList arrayList = new ArrayList();
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            String ugcVideoId = ((ShorttvModel.UGCVideo) it.next()).getUgcVideoId();
            if (ugcVideoId != null) {
                arrayList.add(ugcVideoId);
            }
        }
        Set V0 = CollectionsKt.V0(arrayList);
        ArrayList arrayList2 = new ArrayList(CollectionsKt.v(list2, 10));
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            arrayList2.add(Integer.valueOf(((ShorttvModel.UGCVideo) it2.next()).getEp()));
        }
        Set V02 = CollectionsKt.V0(arrayList2);
        ArrayList arrayList3 = new ArrayList();
        Iterator it3 = other.iterator();
        while (it3.hasNext()) {
            ShorttvModel.UGCVideo uGCVideo = (ShorttvModel.UGCVideo) it3.next();
            String ugcVideoId2 = uGCVideo.getUgcVideoId();
            int ep2 = uGCVideo.getEp();
            if (ugcVideoId2 == null || !V0.contains(ugcVideoId2)) {
                int i11 = 0;
                if (V02.contains(Integer.valueOf(ep2))) {
                    Iterator it4 = list.iterator();
                    while (true) {
                        if (!it4.hasNext()) {
                            i11 = -1;
                            break;
                        }
                        if (((ShorttvModel.UGCVideo) it4.next()).getEp() == ep2) {
                            break;
                        }
                        i11++;
                    }
                    if (i11 != -1 && ((ShorttvModel.UGCVideo) list.get(i11)).getUgcVideoId() == null) {
                        list.set(i11, uGCVideo);
                        arrayList3.add(uGCVideo);
                        if (ugcVideoId2 != null) {
                            V0.add(ugcVideoId2);
                        }
                    }
                } else {
                    Iterator it5 = list.iterator();
                    while (true) {
                        if (!it5.hasNext()) {
                            i11 = -1;
                            break;
                        }
                        if (((ShorttvModel.UGCVideo) it5.next()).getEp() > ep2) {
                            break;
                        }
                        i11++;
                    }
                    Integer valueOf = Integer.valueOf(i11);
                    if (valueOf.intValue() == -1) {
                        valueOf = null;
                    }
                    list.add(valueOf != null ? valueOf.intValue() : list.size(), uGCVideo);
                    arrayList3.add(uGCVideo);
                    if (ugcVideoId2 != null) {
                        V0.add(ugcVideoId2);
                    }
                    V02.add(Integer.valueOf(ep2));
                }
            }
        }
        return CollectionsKt.I0(arrayList3, new Comparator() { // from class: com.transsion.shorttv_pugc.utils.ShortTvExtKt$fillPlaceholdersAndInsertSorted$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t11, T t12) {
                return ComparisonsKt.d(Integer.valueOf(((ShorttvModel.UGCVideo) t11).getEp()), Integer.valueOf(((ShorttvModel.UGCVideo) t12).getEp()));
            }
        });
    }

    public static final ImageSpan f(Context context) {
        Intrinsics.h(context, "context");
        int i11 = R$mipmap.short_tv_ic_split;
        return Build.VERSION.SDK_INT >= 29 ? new ImageSpan(context, i11, 2) : new ImageSpan(context, i11, 1);
    }

    public static final Video g(List list, int i11) {
        Object obj;
        Object obj2;
        Intrinsics.h(list, "<this>");
        List list2 = list;
        Iterator it = list2.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it.next();
            if (Intrinsics.c(((Video) obj2).getResolution(), String.valueOf(i11))) {
                break;
            }
        }
        Video video = (Video) obj2;
        if (video != null) {
            return video;
        }
        Iterator it2 = list2.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            if (Intrinsics.c(((Video) next).getResolution(), "480")) {
                obj = next;
                break;
            }
        }
        Video video2 = (Video) obj;
        return video2 == null ? (Video) CollectionsKt.k0(list) : video2;
    }

    public static final List h(List list, List other) {
        Intrinsics.h(list, "<this>");
        Intrinsics.h(other, "other");
        ArrayList arrayList = new ArrayList();
        List list2 = list;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.v(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList2.add(((ShorttvModel.UGCVideo) it.next()).getUgcVideoId());
        }
        Set V0 = CollectionsKt.V0(arrayList2);
        ArrayList arrayList3 = new ArrayList(CollectionsKt.v(list2, 10));
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            arrayList3.add(Integer.valueOf(((ShorttvModel.UGCVideo) it2.next()).getEp()));
        }
        Set V02 = CollectionsKt.V0(arrayList3);
        Iterator it3 = other.iterator();
        while (it3.hasNext()) {
            ShorttvModel.UGCVideo uGCVideo = (ShorttvModel.UGCVideo) it3.next();
            int ep2 = uGCVideo.getEp();
            String ugcVideoId = uGCVideo.getUgcVideoId();
            if (!V0.contains(ugcVideoId) && !V02.contains(Integer.valueOf(ep2))) {
                Iterator it4 = list.iterator();
                int i11 = 0;
                while (true) {
                    if (!it4.hasNext()) {
                        i11 = -1;
                        break;
                    }
                    if (((ShorttvModel.UGCVideo) it4.next()).getEp() > ep2) {
                        break;
                    }
                    i11++;
                }
                Integer valueOf = Integer.valueOf(i11);
                if (valueOf.intValue() == -1) {
                    valueOf = null;
                }
                int intValue = valueOf != null ? valueOf.intValue() : list.size();
                list.add(intValue, uGCVideo);
                arrayList.add(Integer.valueOf(intValue));
                V0.add(ugcVideoId);
                V02.add(Integer.valueOf(ep2));
            }
        }
        return arrayList;
    }

    public static final List i(List list, List other) {
        Intrinsics.h(list, "<this>");
        Intrinsics.h(other, "other");
        ArrayList arrayList = new ArrayList();
        if (other.isEmpty()) {
            return arrayList;
        }
        List list2 = list;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.v(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList2.add(((ShorttvModel.UGCVideo) it.next()).getUgcVideoId());
        }
        Set V0 = CollectionsKt.V0(arrayList2);
        ArrayList arrayList3 = new ArrayList(CollectionsKt.v(list2, 10));
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            arrayList3.add(Integer.valueOf(((ShorttvModel.UGCVideo) it2.next()).getEp()));
        }
        Set V02 = CollectionsKt.V0(arrayList3);
        ArrayList<ShorttvModel.UGCVideo> arrayList4 = new ArrayList();
        for (Object obj : other) {
            ShorttvModel.UGCVideo uGCVideo = (ShorttvModel.UGCVideo) obj;
            String ugcVideoId = uGCVideo.getUgcVideoId();
            int ep2 = uGCVideo.getEp();
            if (!V0.contains(ugcVideoId) && !V02.contains(Integer.valueOf(ep2))) {
                arrayList4.add(obj);
            }
        }
        if (arrayList4.isEmpty()) {
            return arrayList;
        }
        int i11 = 0;
        if (arrayList4.size() == other.size()) {
            Iterator it3 = list.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    i11 = -1;
                    break;
                }
                if (((ShorttvModel.UGCVideo) it3.next()).getEp() > ((ShorttvModel.UGCVideo) CollectionsKt.i0(arrayList4)).getEp()) {
                    break;
                }
                i11++;
            }
            Integer valueOf = Integer.valueOf(i11);
            Integer num = valueOf.intValue() != -1 ? valueOf : null;
            int intValue = num != null ? num.intValue() : list.size();
            list.addAll(intValue, arrayList4);
            k(arrayList, intValue, arrayList4.size());
        } else {
            for (ShorttvModel.UGCVideo uGCVideo2 : arrayList4) {
                Iterator it4 = list.iterator();
                int i12 = 0;
                while (true) {
                    if (!it4.hasNext()) {
                        i12 = -1;
                        break;
                    }
                    if (((ShorttvModel.UGCVideo) it4.next()).getEp() > uGCVideo2.getEp()) {
                        break;
                    }
                    i12++;
                }
                Integer valueOf2 = Integer.valueOf(i12);
                if (valueOf2.intValue() == -1) {
                    valueOf2 = null;
                }
                int intValue2 = valueOf2 != null ? valueOf2.intValue() : list.size();
                list.add(intValue2, uGCVideo2);
                arrayList.add(Integer.valueOf(intValue2));
            }
        }
        ArrayList arrayList5 = new ArrayList(CollectionsKt.v(arrayList4, 10));
        Iterator it5 = arrayList4.iterator();
        while (it5.hasNext()) {
            arrayList5.add(((ShorttvModel.UGCVideo) it5.next()).getUgcVideoId());
        }
        V0.addAll(arrayList5);
        ArrayList arrayList6 = new ArrayList(CollectionsKt.v(arrayList4, 10));
        Iterator it6 = arrayList4.iterator();
        while (it6.hasNext()) {
            arrayList6.add(Integer.valueOf(((ShorttvModel.UGCVideo) it6.next()).getEp()));
        }
        V02.addAll(arrayList6);
        return arrayList;
    }

    private static final String j(String str) {
        if (str == null) {
            return str;
        }
        switch (str.hashCode()) {
            case AD_VALIDATION_TO_PRESENT_DURATION_MS_VALUE:
                return !str.equals("1") ? str : "TAG_GENRE";
            case 50:
                return !str.equals("2") ? str : "TAG_COUNTRY";
            case AD_REWARD_USER_VALUE:
                return !str.equals("3") ? str : "TAG_YEAR";
            case AD_REQUIRED_DOWNLOAD_DURATION_MS_VALUE:
                return !str.equals("4") ? str : "TAG_STAFF";
            default:
                return str;
        }
    }

    private static final void k(List list, int i11, int i12) {
        list.clear();
        CollectionsKt.B(list, RangesKt.t(i11, i12 + i11));
    }

    public static final int l(int i11) {
        return i11 + 1;
    }

    public static final void m(int i11) {
        try {
            Result.Companion companion = Result.INSTANCE;
            b.a aVar = kt.b.f68514a;
            int i12 = R$layout.short_tv_base_layout_new_success_toast;
            String string = Utils.a().getString(i11);
            Intrinsics.g(string, "getString(...)");
            aVar.f(i12, string, (r13 & 4) != 0 ? 0 : 0, (r13 & 8) != 0 ? 0 : 0, (r13 & 16) != 0 ? 0 : 0);
            Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }

    public static final String n(Integer num) {
        int intValue = num != null ? num.intValue() : 0;
        if (1 > intValue || intValue >= 10) {
            return String.valueOf(intValue);
        }
        return "0" + intValue;
    }

    public static final String o(List list, ShorttvModel.UGCVideoHasTag mainTag) {
        Intrinsics.h(list, "<this>");
        Intrinsics.h(mainTag, "mainTag");
        Map l11 = MapsKt.l(TuplesKt.a("tag", mainTag.getTag()), TuplesKt.a(CampaignEx.JSON_KEY_TITLE, mainTag.getTitle()), TuplesKt.a("tag_type", j(mainTag.getTagType())));
        ArrayList<ShorttvModel.UGCVideoHasTag> arrayList = new ArrayList();
        for (Object obj : list) {
            if (!Intrinsics.c((ShorttvModel.UGCVideoHasTag) obj, mainTag)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.v(arrayList, 10));
        for (ShorttvModel.UGCVideoHasTag uGCVideoHasTag : arrayList) {
            arrayList2.add(MapsKt.l(TuplesKt.a("tag", uGCVideoHasTag.getTag()), TuplesKt.a(CampaignEx.JSON_KEY_TITLE, uGCVideoHasTag.getTitle()), TuplesKt.a("tag_type", j(uGCVideoHasTag.getTagType()))));
        }
        String json = new Gson().toJson(MapsKt.l(TuplesKt.a("main_hashtag", l11), TuplesKt.a("sub_hashtag", arrayList2)));
        Intrinsics.g(json, "toJson(...)");
        return json;
    }

    public static final String p(long j11) {
        long j12 = 60;
        String format = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j11 / j12), Long.valueOf(j11 % j12)}, 2));
        Intrinsics.g(format, "format(...)");
        return format;
    }

    public static final String q(String str) {
        Long valueOf;
        Date parse;
        Intrinsics.h(str, "<this>");
        if (new Regex("^\\d+$").matches(str)) {
            Long x10 = StringsKt.x(str);
            if (x10 == null) {
                return null;
            }
            long longValue = x10.longValue();
            if (longValue < 1000000000000L) {
                longValue *= 1000;
            }
            valueOf = Long.valueOf(longValue);
        } else {
            valueOf = (!new Regex("^\\d{4}-\\d{2}-\\d{2}$").matches(str) || (parse = new SimpleDateFormat("yyyy-MM-dd", Locale.US).parse(str)) == null) ? null : Long.valueOf(parse.getTime());
        }
        if (valueOf == null) {
            return null;
        }
        long abs = Math.abs(System.currentTimeMillis() - valueOf.longValue());
        if (abs < 60000) {
            return "Just now";
        }
        if (abs < TmcConstants.DEBUG_REQUEST_TIME_INTERVAL) {
            return "< 1 minute";
        }
        if (abs < 3600000) {
            return "< 1 hour";
        }
        if (abs < 7200000) {
            return "1 hour ago";
        }
        if (abs < 86400000) {
            return (abs / 60000) + " minutes ago";
        }
        if (abs < TmcConstants.MINI_POPWINDOW_ADD_HOME_INTERVAL) {
            return "1 day ago";
        }
        if (abs < 604800000) {
            return (abs / TimeConstants.DAY) + " days ago";
        }
        if (abs < 1209600000) {
            return "1 week ago";
        }
        if (abs < 2592000000L) {
            return (abs / MiniAppConfigHelper.DEFAULT_MINI_SCOPE_REQUEST_DIFF) + " weeks ago";
        }
        if (abs < 5184000000L) {
            return "1 month ago";
        }
        if (abs < 31536000000L) {
            return (abs / 2592000000L) + " months ago";
        }
        if (abs < 63072000000L) {
            return "1 year ago";
        }
        return (abs / 31536000000L) + " years ago";
    }

    public static final List r(int i11, int i12) {
        ArrayList arrayList = new ArrayList();
        int i13 = 1;
        if (i11 <= i12) {
            arrayList.add(new IntRange(1, i12));
            return arrayList;
        }
        int i14 = i12;
        while (i14 < i11) {
            arrayList.add(new IntRange(i13, i14));
            i13 += i12;
            i14 += i12;
        }
        arrayList.add(new IntRange(i13, i14));
        return arrayList;
    }

    public static /* synthetic */ List s(int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i12 = 50;
        }
        return r(i11, i12);
    }

    public static final String t(String str) {
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

    public static final void u(List list, List list2) {
        String playUrl;
        Intrinsics.h(list, "<this>");
        List list3 = list2;
        if (list3 == null || list3.isEmpty()) {
            return;
        }
        List list4 = list2;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.e(CollectionsKt.v(list4, 10)), 16));
        for (Object obj : list4) {
            linkedHashMap.put(((ShorttvModel.UGCVideo) obj).getUgcVideoId(), obj);
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ShorttvModel.UGCVideo uGCVideo = (ShorttvModel.UGCVideo) it.next();
            ShorttvModel.UGCVideo uGCVideo2 = (ShorttvModel.UGCVideo) linkedHashMap.get(uGCVideo.getUgcVideoId());
            if (uGCVideo2 != null && (playUrl = uGCVideo2.getPlayUrl()) != null) {
                if (StringsKt.q0(playUrl)) {
                    playUrl = null;
                }
                if (playUrl != null) {
                    uGCVideo.setPlayUrl(playUrl);
                }
            }
        }
    }
}
