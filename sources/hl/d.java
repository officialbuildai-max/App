package hl;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.transsion.home.bean.BannerData;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsion.web.api.WebConstants;
import hj.i;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class d {

    /* renamed from: c, reason: collision with root package name */
    public static final a f64648c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    public static final int f64649d = 8;

    /* renamed from: a, reason: collision with root package name */
    private HashSet f64650a;

    /* renamed from: b, reason: collision with root package name */
    private String f64651b;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void e(a aVar, int i11, int i12, OperateItem operateItem, UGCVideo uGCVideo, Map map, int i13, Object obj) {
            if ((i13 & 16) != 0) {
                map = null;
            }
            aVar.d(i11, i12, operateItem, uGCVideo, map);
        }

        public static /* synthetic */ void g(a aVar, int i11, int i12, OperateItem operateItem, UGCVideo uGCVideo, Map map, int i13, Object obj) {
            if ((i13 & 16) != 0) {
                map = null;
            }
            aVar.f(i11, i12, operateItem, uGCVideo, map);
        }

        public final void a(int i11, int i12, OperateItem operateItem, BannerData bannerData) {
            Intrinsics.h(operateItem, "operateItem");
            HashMap hashMap = new HashMap();
            if (bannerData != null) {
                il.b.c(bannerData, hashMap);
            }
            il.b.a(operateItem, hashMap);
            hashMap.put("module_name", WebConstants.FIELD_ITEM);
            hashMap.put(RequestParameters.POSITION, String.valueOf(i12));
            hashMap.put("tabId", String.valueOf(i11));
            i.f64628a.D(SubTabFragment.INSTANCE.a(i11), hashMap);
        }

        public final void b(int i11, int i12, OperateItem operateItem, BannerData bannerData) {
            Intrinsics.h(operateItem, "operateItem");
            HashMap hashMap = new HashMap();
            if (bannerData != null) {
                il.b.c(bannerData, hashMap);
            }
            il.b.a(operateItem, hashMap);
            hashMap.put("module_name", WebConstants.FIELD_ITEM);
            hashMap.put(RequestParameters.POSITION, String.valueOf(i12));
            hashMap.put("tabId", String.valueOf(i11));
            i.f64628a.p(SubTabFragment.INSTANCE.a(i11), hashMap);
        }

        public final void c(int i11, OperateItem operateItem, int i12) {
            Intrinsics.h(operateItem, "operateItem");
            HashMap hashMap = new HashMap();
            UGCVideo feedsUGCVideo = operateItem.getFeedsUGCVideo();
            if (feedsUGCVideo != null) {
                il.b.f(feedsUGCVideo, hashMap);
            }
            OperateItem originalOperateItem = operateItem.getOriginalOperateItem();
            if (originalOperateItem != null) {
                il.b.a(originalOperateItem, hashMap);
            }
            hashMap.put("module_name", WebConstants.FIELD_ITEM);
            hashMap.put(RequestParameters.POSITION, String.valueOf(i11));
            hashMap.put("card_type", Intrinsics.c(operateItem.getType(), PostItemType.TRENDING_FEES_GRID.getValue()) ? "grid" : "big");
            i.f64628a.p(SubTabFragment.INSTANCE.a(i12), hashMap);
        }

        public final void d(int i11, int i12, OperateItem operateItem, UGCVideo uGCVideo, Map map) {
            OperateItem originalOperateItem;
            HashMap hashMap = new HashMap();
            if (uGCVideo != null) {
                il.b.f(uGCVideo, hashMap);
            }
            if (operateItem != null) {
                il.b.a(operateItem, hashMap);
            }
            if (operateItem != null && (originalOperateItem = operateItem.getOriginalOperateItem()) != null) {
                il.b.a(originalOperateItem, hashMap);
            }
            if (map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    hashMap.put((String) entry.getKey(), (String) entry.getValue());
                }
            }
            hashMap.put("module_name", WebConstants.FIELD_ITEM);
            hashMap.put(RequestParameters.POSITION, String.valueOf(i12));
            hashMap.put("tabId", String.valueOf(i11));
            i.f64628a.D(SubTabFragment.INSTANCE.a(i11), hashMap);
        }

        public final void f(int i11, int i12, OperateItem operateItem, UGCVideo uGCVideo, Map map) {
            HashMap hashMap = new HashMap();
            if (uGCVideo != null) {
                il.b.f(uGCVideo, hashMap);
            }
            if (operateItem != null) {
                il.b.a(operateItem, hashMap);
            }
            if (map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    hashMap.put((String) entry.getKey(), (String) entry.getValue());
                }
            }
            hashMap.put("module_name", WebConstants.FIELD_ITEM);
            hashMap.put(RequestParameters.POSITION, String.valueOf(i12));
            hashMap.put("tabId", String.valueOf(i11));
            i.f64628a.p(SubTabFragment.INSTANCE.a(i11), hashMap);
        }
    }

    public d(String page) {
        Intrinsics.h(page, "page");
        this.f64650a = new HashSet();
        this.f64651b = page;
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x0158, code lost:
    
        if (r2 == null) goto L75;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(com.transsion.home.bean.OperateItem r15, int r16, long r17) {
        /*
            Method dump skipped, instructions count: 379
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: hl.d.a(com.transsion.home.bean.OperateItem, int, long):void");
    }
}
