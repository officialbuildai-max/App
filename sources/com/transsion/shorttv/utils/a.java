package com.transsion.shorttv.utils;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.transsion.shorttv.bean.ShortTvItemType;
import java.util.HashSet;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class a {

    /* renamed from: e, reason: collision with root package name */
    public static final C0662a f53696e = new C0662a(null);

    /* renamed from: a, reason: collision with root package name */
    private final String f53697a;

    /* renamed from: b, reason: collision with root package name */
    private final HashSet f53698b;

    /* renamed from: c, reason: collision with root package name */
    private final HashSet f53699c;

    /* renamed from: d, reason: collision with root package name */
    private final HashSet f53700d;

    /* renamed from: com.transsion.shorttv.utils.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0662a {
        private C0662a() {
        }

        public /* synthetic */ C0662a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a(String pageName) {
        Intrinsics.h(pageName, "pageName");
        this.f53697a = pageName;
        this.f53698b = new HashSet();
        this.f53699c = new HashSet();
        this.f53700d = new HashSet();
    }

    public final void a(String str, String str2, String str3, String str4, String str5, String str6, Boolean bool, String str7, Integer num, String str8, long j11, Boolean bool2, String str9) {
        boolean contains;
        String str10 = str4;
        if (str == null || str.length() == 0) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("item_type", str2 == null ? "" : str2);
        linkedHashMap.put("opt_type", str3 == null ? "" : str3);
        if (Intrinsics.c(str3, ShortTvItemType.OP_SUBJECTS_MOVIE.getValue())) {
            if (str10 != null) {
                contains = this.f53698b.contains(str4);
                this.f53698b.add(str4);
            }
            contains = false;
        } else if (Intrinsics.c(str3, ShortTvItemType.BANNER.getValue())) {
            if (num != null) {
                contains = this.f53699c.contains(num);
                this.f53699c.add(num);
            }
            contains = false;
        } else {
            if (Intrinsics.c(str3, ShortTvItemType.OP_RANKING.getValue()) && str10 != null) {
                contains = this.f53700d.contains(str4);
                this.f53700d.add(str4);
            }
            contains = false;
        }
        if (contains) {
            return;
        }
        if (str10 == null) {
            str10 = "";
        }
        linkedHashMap.put("subject_id", str10);
        linkedHashMap.put("group_id", str5 == null ? "" : str5);
        linkedHashMap.put("ops", str6 != null ? str6 : "");
        linkedHashMap.put("has_resource", String.valueOf(bool));
        linkedHashMap.put("deeplink", str7);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(num);
        linkedHashMap.put(RequestParameters.POSITION, sb2.toString());
        linkedHashMap.put("cover", str8);
        linkedHashMap.put("browse_duration", String.valueOf(j11));
        linkedHashMap.put("builtin", Intrinsics.c(bool2, Boolean.TRUE) ? "1" : "0");
        linkedHashMap.put("tag", String.valueOf(str9));
        ks.b.f68513a.a();
        hj.i.f64628a.D(str, linkedHashMap);
    }

    public final void c(String str, String str2, String str3, String str4, String str5, String str6, Boolean bool, Boolean bool2, String str7, Integer num, String str8, Boolean bool3, String str9) {
        if (str == null || str.length() == 0) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("item_type", str2 == null ? "" : str2);
        linkedHashMap.put("opt_type", str3 == null ? "" : str3);
        linkedHashMap.put("subject_id", str4 == null ? "" : str4);
        linkedHashMap.put("group_id", str5 == null ? "" : str5);
        linkedHashMap.put("ops", str6 != null ? str6 : "");
        linkedHashMap.put("has_resource", String.valueOf(bool));
        linkedHashMap.put("check_in", String.valueOf(bool2));
        linkedHashMap.put("deeplink", str7);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(num);
        linkedHashMap.put(RequestParameters.POSITION, sb2.toString());
        linkedHashMap.put("cover", str8);
        linkedHashMap.put("builtin", Intrinsics.c(bool3, Boolean.TRUE) ? "1" : "0");
        linkedHashMap.put("tag", String.valueOf(str9));
        ks.b.f68513a.a();
        hj.i.f64628a.p(str, linkedHashMap);
    }
}
