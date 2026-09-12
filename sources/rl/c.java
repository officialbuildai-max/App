package rl;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.home.bean.BannerData;
import com.transsion.home.bean.HomePreferencesConfig;
import com.transsion.home.bean.LiveListItem;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.web.api.WebConstants;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a */
    public static final c f74670a = new c();

    /* renamed from: b */
    private static final HashSet f74671b = new HashSet();

    /* renamed from: c */
    private static final HashSet f74672c = new HashSet();

    /* renamed from: d */
    private static final HashSet f74673d = new HashSet();

    /* renamed from: e */
    private static final HashSet f74674e = new HashSet();

    /* renamed from: f */
    public static final int f74675f = 8;

    private c() {
    }

    public final void a() {
        f74671b.clear();
        f74672c.clear();
        f74673d.clear();
    }

    public final void b(OperateItem operateItem, String str, List bannerData, long j11, int i11) {
        Intrinsics.h(operateItem, "operateItem");
        Intrinsics.h(bannerData, "bannerData");
        HashSet hashSet = f74674e;
        if (CollectionsKt.b0(hashSet, operateItem.getOpId())) {
            return;
        }
        String opId = operateItem.getOpId();
        if (opId == null) {
            opId = "";
        }
        hashSet.add(opId);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("item_type", "opt");
        if (str == null) {
            str = "";
        }
        linkedHashMap.put("opt_type", str);
        String opId2 = operateItem.getOpId();
        if (opId2 == null) {
            opId2 = "";
        }
        linkedHashMap.put("op_id", opId2);
        String title = operateItem.getTitle();
        linkedHashMap.put(CampaignEx.JSON_KEY_TITLE, title != null ? title : "");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i11);
        linkedHashMap.put(RequestParameters.POSITION, sb2.toString());
        linkedHashMap.put("browse_duration", String.valueOf(j11));
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = new StringBuilder();
        int i12 = 0;
        for (Object obj : bannerData) {
            int i13 = i12 + 1;
            if (i12 < 0) {
                CollectionsKt.u();
            }
            BannerData bannerData2 = (BannerData) obj;
            String subjectId = bannerData2 != null ? bannerData2.getSubjectId() : null;
            if (subjectId == null || subjectId.length() == 0) {
                sb4.append(bannerData2 != null ? bannerData2.getDeepLink() : null);
                sb4.append(",");
            } else {
                sb3.append(bannerData2 != null ? bannerData2.getSubjectId() : null);
                sb3.append(",");
            }
            i12 = i13;
        }
        String sb5 = sb3.toString();
        Intrinsics.g(sb5, "toString(...)");
        linkedHashMap.put("subject_ids", StringsKt.r1(sb5, ','));
        String sb6 = sb4.toString();
        Intrinsics.g(sb6, "toString(...)");
        linkedHashMap.put("deeplinks", StringsKt.r1(sb6, ','));
    }

    public final void c(String str, String str2, String str3, String str4, String str5, String str6, Boolean bool, Boolean bool2, String str7, Integer num, String str8, Boolean bool3, String str9, String str10, String str11) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("item_type", str2 == null ? "" : str2);
        linkedHashMap.put("opt_type", str3 == null ? "" : str3);
        linkedHashMap.put("subject_id", str4 == null ? "" : str4);
        linkedHashMap.put("group_id", str5 == null ? "" : str5);
        linkedHashMap.put("ops", str6 == null ? "" : str6);
        linkedHashMap.put("has_resource", String.valueOf(bool));
        linkedHashMap.put("check_in", String.valueOf(bool2));
        linkedHashMap.put("deeplink", str7);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(num);
        linkedHashMap.put(RequestParameters.POSITION, sb2.toString());
        linkedHashMap.put("cover", str8);
        linkedHashMap.put("builtin", Intrinsics.c(bool3, Boolean.TRUE) ? "1" : "0");
        linkedHashMap.put("tag", String.valueOf(str9));
        linkedHashMap.put("opTitle", str10 == null ? "" : str10);
        linkedHashMap.put("opId", str11 == null ? "" : str11);
        com.transsion.baselib.helper.a.f43316a.f(str != null ? str : "", linkedHashMap);
    }

    public final void e(int i11, long j11, OperateItem operateItem) {
        String str;
        String str2;
        String title;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("item_type", "opt");
        String str3 = "";
        if (operateItem == null || (str = operateItem.getType()) == null) {
            str = "";
        }
        linkedHashMap.put("opt_type", str);
        if (operateItem == null || (str2 = operateItem.getOpId()) == null) {
            str2 = "";
        }
        linkedHashMap.put("opId", str2);
        if (operateItem != null && (title = operateItem.getTitle()) != null) {
            str3 = title;
        }
        linkedHashMap.put("opTitle", str3);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i11);
        linkedHashMap.put(RequestParameters.POSITION, sb2.toString());
        linkedHashMap.put("browse_duration", String.valueOf(j11));
        hj.i.f64628a.D("Trending", linkedHashMap);
    }

    public final void f(int i11, OperateItem operateItem) {
        String str;
        String str2;
        String title;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("item_type", "opt");
        String str3 = "";
        if (operateItem == null || (str = operateItem.getType()) == null) {
            str = "";
        }
        linkedHashMap.put("opt_type", str);
        if (operateItem == null || (str2 = operateItem.getOpId()) == null) {
            str2 = "";
        }
        linkedHashMap.put("opId", str2);
        if (operateItem != null && (title = operateItem.getTitle()) != null) {
            str3 = title;
        }
        linkedHashMap.put("opTitle", str3);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i11);
        linkedHashMap.put(RequestParameters.POSITION, sb2.toString());
        hj.i.f64628a.p("Trending", linkedHashMap);
    }

    public final void g(Subject subject, int i11, OperateItem operateItem) {
        String str;
        String str2;
        String title;
        Intrinsics.h(subject, "subject");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("item_type", "opt");
        String str3 = "";
        if (operateItem == null || (str = operateItem.getType()) == null) {
            str = "";
        }
        linkedHashMap.put("opt_type", str);
        String subjectId = subject.getSubjectId();
        if (subjectId == null) {
            subjectId = "";
        }
        linkedHashMap.put("subject_id", subjectId);
        String ops = subject.getOps();
        if (ops == null) {
            ops = "";
        }
        linkedHashMap.put("ops", ops);
        linkedHashMap.put("has_resource", String.valueOf(subject.getHasResource()));
        if (operateItem == null || (str2 = operateItem.getOpId()) == null) {
            str2 = "";
        }
        linkedHashMap.put("opId", str2);
        if (operateItem != null && (title = operateItem.getTitle()) != null) {
            str3 = title;
        }
        linkedHashMap.put("opTitle", str3);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i11);
        linkedHashMap.put(RequestParameters.POSITION, sb2.toString());
        hj.i.f64628a.D("Trending", linkedHashMap);
    }

    public final void h(Subject subject, int i11, OperateItem operateItem) {
        String str;
        String str2;
        String title;
        Intrinsics.h(subject, "subject");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("item_type", "opt");
        String str3 = "";
        if (operateItem == null || (str = operateItem.getType()) == null) {
            str = "";
        }
        linkedHashMap.put("opt_type", str);
        String subjectId = subject.getSubjectId();
        if (subjectId == null) {
            subjectId = "";
        }
        linkedHashMap.put("subject_id", subjectId);
        String ops = subject.getOps();
        if (ops == null) {
            ops = "";
        }
        linkedHashMap.put("ops", ops);
        linkedHashMap.put("has_resource", String.valueOf(subject.getHasResource()));
        if (operateItem == null || (str2 = operateItem.getOpId()) == null) {
            str2 = "";
        }
        linkedHashMap.put("opId", str2);
        if (operateItem != null && (title = operateItem.getTitle()) != null) {
            str3 = title;
        }
        linkedHashMap.put("opTitle", str3);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i11);
        linkedHashMap.put(RequestParameters.POSITION, sb2.toString());
        hj.i.f64628a.p("Trending", linkedHashMap);
    }

    public final void i(OperateItem operateItem, Integer num) {
        String str;
        String str2;
        String str3;
        String title;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("item_type", "opt");
        String str4 = "";
        if (operateItem == null || (str = operateItem.getType()) == null) {
            str = "";
        }
        linkedHashMap.put("opt_type", str + "_RANK_MORE");
        if (operateItem == null || (str2 = operateItem.getDeepLink()) == null) {
            str2 = "";
        }
        linkedHashMap.put("deeplink", str2);
        if (operateItem == null || (str3 = operateItem.getOpId()) == null) {
            str3 = "";
        }
        linkedHashMap.put("op_id", str3);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(num);
        linkedHashMap.put(RequestParameters.POSITION, sb2.toString());
        if (operateItem != null && (title = operateItem.getTitle()) != null) {
            str4 = title;
        }
        linkedHashMap.put("opTitle", str4);
        hj.i.f64628a.p("Trending", linkedHashMap);
    }

    public final void j(int i11, String tabCode, HomePreferencesConfig config) {
        Intrinsics.h(tabCode, "tabCode");
        Intrinsics.h(config, "config");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("dialog_name", "preference");
        linkedHashMap.put("tab_id", String.valueOf(i11));
        linkedHashMap.put(WebConstants.TAB_CODE, tabCode);
        linkedHashMap.put("dialog_id", config.getLabelId());
        linkedHashMap.put("module_name", "close");
        String showStyle = config.getShowStyle();
        if (showStyle == null) {
            showStyle = "";
        }
        linkedHashMap.put("show_style", showStyle);
        hj.i.f64628a.p(SubTabFragment.INSTANCE.a(i11), linkedHashMap);
    }

    public final void k(int i11, String tabCode, HomePreferencesConfig config, List selectedOptions) {
        Intrinsics.h(tabCode, "tabCode");
        Intrinsics.h(config, "config");
        Intrinsics.h(selectedOptions, "selectedOptions");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("dialog_name", "preference");
        linkedHashMap.put("tab_id", String.valueOf(i11));
        linkedHashMap.put(WebConstants.TAB_CODE, tabCode);
        linkedHashMap.put("dialog_id", config.getLabelId());
        String showStyle = config.getShowStyle();
        if (showStyle == null) {
            showStyle = "";
        }
        linkedHashMap.put("show_style", showStyle);
        linkedHashMap.put("module_name", "confirm");
        linkedHashMap.put("select_content", CollectionsKt.s0(selectedOptions, "/", null, null, 0, null, null, 62, null));
        hj.i.f64628a.p(SubTabFragment.INSTANCE.a(i11), linkedHashMap);
    }

    public final void l(int i11, String tabCode, HomePreferencesConfig config) {
        Intrinsics.h(tabCode, "tabCode");
        Intrinsics.h(config, "config");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("dialog_name", "preference");
        linkedHashMap.put("tab_id", String.valueOf(i11));
        linkedHashMap.put(WebConstants.TAB_CODE, tabCode);
        linkedHashMap.put("dialog_id", config.getLabelId());
        String showStyle = config.getShowStyle();
        if (showStyle == null) {
            showStyle = "";
        }
        linkedHashMap.put("show_style", showStyle);
        hj.i.f64628a.r(SubTabFragment.INSTANCE.a(i11), linkedHashMap);
    }

    public final void m(HomePreferencesConfig config, List selectedOptions) {
        Intrinsics.h(config, "config");
        Intrinsics.h(selectedOptions, "selectedOptions");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("dialog_name", "preference_enter_pop");
        linkedHashMap.put("dialog_id", config.getLabelId());
        linkedHashMap.put("show_style", config.getShowStyle());
        linkedHashMap.put("module_name", "confirm");
        linkedHashMap.put("select_content", CollectionsKt.s0(selectedOptions, "/", null, null, 0, null, null, 62, null));
        hj.i.f64628a.p("Trending", linkedHashMap);
    }

    public final void n(HomePreferencesConfig config) {
        Intrinsics.h(config, "config");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("dialog_name", "preference_enter_pop");
        linkedHashMap.put("dialog_id", config.getLabelId());
        linkedHashMap.put("show_style", config.getShowStyle());
        hj.i.f64628a.r("Trending", linkedHashMap);
    }

    public final void o(HomePreferencesConfig config) {
        Intrinsics.h(config, "config");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("dialog_name", "preference_enter_pop");
        linkedHashMap.put("dialog_id", config.getLabelId());
        linkedHashMap.put("show_style", config.getShowStyle());
        linkedHashMap.put("module_name", "skip");
        hj.i.f64628a.p("Trending", linkedHashMap);
    }

    public final void p(int i11, String tabCode, HomePreferencesConfig config) {
        Intrinsics.h(tabCode, "tabCode");
        Intrinsics.h(config, "config");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("tab_id", String.valueOf(i11));
        linkedHashMap.put(WebConstants.TAB_CODE, tabCode);
        linkedHashMap.put("opId", config.getLabelId());
        linkedHashMap.put("opt_id", config.getLabelId());
        linkedHashMap.put("item_type", "opt");
        linkedHashMap.put("opt_type", "Preferences");
        linkedHashMap.put("module_name", "close");
        String showStyle = config.getShowStyle();
        if (showStyle == null) {
            showStyle = "";
        }
        linkedHashMap.put("show_style", showStyle);
        hj.i.f64628a.p(SubTabFragment.INSTANCE.a(i11), linkedHashMap);
    }

    public final void q(int i11, String tabCode, HomePreferencesConfig config) {
        Intrinsics.h(tabCode, "tabCode");
        Intrinsics.h(config, "config");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("tab_id", String.valueOf(i11));
        linkedHashMap.put(WebConstants.TAB_CODE, tabCode);
        linkedHashMap.put("opId", config.getLabelId());
        linkedHashMap.put("opt_id", config.getLabelId());
        linkedHashMap.put("item_type", "opt");
        linkedHashMap.put("opt_type", "Preferences");
        String showStyle = config.getShowStyle();
        if (showStyle == null) {
            showStyle = "";
        }
        linkedHashMap.put("show_style", showStyle);
        hj.i.f64628a.D(SubTabFragment.INSTANCE.a(i11), linkedHashMap);
    }

    public final void r(int i11, String tabCode, HomePreferencesConfig config, List selectedOptions) {
        Intrinsics.h(tabCode, "tabCode");
        Intrinsics.h(config, "config");
        Intrinsics.h(selectedOptions, "selectedOptions");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("tab_id", String.valueOf(i11));
        linkedHashMap.put(WebConstants.TAB_CODE, tabCode);
        linkedHashMap.put("opId", config.getLabelId());
        linkedHashMap.put("opt_id", config.getLabelId());
        linkedHashMap.put("item_type", "opt");
        linkedHashMap.put("opt_type", "Preferences");
        String showStyle = config.getShowStyle();
        if (showStyle == null) {
            showStyle = "";
        }
        linkedHashMap.put("show_style", showStyle);
        linkedHashMap.put("module_name", "confirm");
        linkedHashMap.put("select_content", CollectionsKt.s0(selectedOptions, ",", null, null, 0, null, null, 62, null));
        hj.i.f64628a.p(SubTabFragment.INSTANCE.a(i11), linkedHashMap);
    }

    public final void s(OperateItem operateItem, String str, List subjects, long j11, int i11) {
        Intrinsics.h(operateItem, "operateItem");
        Intrinsics.h(subjects, "subjects");
        HashSet hashSet = f74674e;
        if (CollectionsKt.b0(hashSet, operateItem.getOpId())) {
            return;
        }
        String opId = operateItem.getOpId();
        if (opId == null) {
            opId = "";
        }
        hashSet.add(opId);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("item_type", "opt");
        if (str == null) {
            str = "";
        }
        linkedHashMap.put("opt_type", str);
        String opId2 = operateItem.getOpId();
        if (opId2 == null) {
            opId2 = "";
        }
        linkedHashMap.put("op_id", opId2);
        StringBuilder sb2 = new StringBuilder();
        int i12 = 0;
        for (Object obj : subjects) {
            int i13 = i12 + 1;
            if (i12 < 0) {
                CollectionsKt.u();
            }
            sb2.append(((Subject) obj).getSubjectId());
            sb2.append(",");
            i12 = i13;
        }
        String sb3 = sb2.toString();
        Intrinsics.g(sb3, "toString(...)");
        linkedHashMap.put("subject_ids", StringsKt.r1(sb3, ','));
        String title = operateItem.getTitle();
        linkedHashMap.put(CampaignEx.JSON_KEY_TITLE, title != null ? title : "");
        StringBuilder sb4 = new StringBuilder();
        sb4.append(i11);
        linkedHashMap.put(RequestParameters.POSITION, sb4.toString());
        linkedHashMap.put("browse_duration", String.valueOf(j11));
        com.transsion.baselib.helper.a.f43316a.e("Trending", linkedHashMap);
    }

    public final void t(OperateItem operateItem, String str, List liveList, long j11, int i11) {
        Intrinsics.h(operateItem, "operateItem");
        Intrinsics.h(liveList, "liveList");
        HashSet hashSet = f74674e;
        if (CollectionsKt.b0(hashSet, operateItem.getOpId())) {
            return;
        }
        String opId = operateItem.getOpId();
        if (opId == null) {
            opId = "";
        }
        hashSet.add(opId);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("item_type", "opt");
        if (str == null) {
            str = "";
        }
        linkedHashMap.put("opt_type", str);
        String opId2 = operateItem.getOpId();
        if (opId2 == null) {
            opId2 = "";
        }
        linkedHashMap.put("op_id", opId2);
        String title = operateItem.getTitle();
        linkedHashMap.put(CampaignEx.JSON_KEY_TITLE, title != null ? title : "");
        StringBuilder sb2 = new StringBuilder();
        int i12 = 0;
        for (Object obj : liveList) {
            int i13 = i12 + 1;
            if (i12 < 0) {
                CollectionsKt.u();
            }
            sb2.append(((LiveListItem) obj).getMatchId());
            sb2.append(",");
            i12 = i13;
        }
        String sb3 = sb2.toString();
        Intrinsics.g(sb3, "toString(...)");
        linkedHashMap.put("match_ids", StringsKt.r1(sb3, ','));
        StringBuilder sb4 = new StringBuilder();
        sb4.append(i11);
        linkedHashMap.put(RequestParameters.POSITION, sb4.toString());
        linkedHashMap.put("browse_duration", String.valueOf(j11));
        com.transsion.baselib.helper.a.f43316a.e("Trending", linkedHashMap);
    }
}
