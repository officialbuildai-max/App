package com.transsion.mbwidget.data;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.o;
import com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.video.VideoDetailPlayBean;
import com.transsion.baselib.db.video.VideoDetailPlayDao;
import com.transsion.mbwidget.HotSubjectWidgetProvider;
import com.transsion.mbwidget.PlayWidgetProvider;
import com.transsion.mbwidget.R$string;
import com.transsion.mbwidget.utils.BitmapUtils;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import org.mvel2.ast.ASTNode;

/* loaded from: classes5.dex */
public final class WidgetDataManager {

    /* renamed from: b, reason: collision with root package name */
    private static volatile long f46310b;

    /* renamed from: f, reason: collision with root package name */
    private static VideoDetailPlayBean f46314f;

    /* renamed from: i, reason: collision with root package name */
    private static String f46317i;

    /* renamed from: a, reason: collision with root package name */
    public static final WidgetDataManager f46309a = new WidgetDataManager();

    /* renamed from: c, reason: collision with root package name */
    private static long f46311c = 3540000;

    /* renamed from: d, reason: collision with root package name */
    private static final Lazy f46312d = LazyKt.b(new Function0() { // from class: com.transsion.mbwidget.data.k
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            a x10;
            x10 = WidgetDataManager.x();
            return x10;
        }
    });

    /* renamed from: e, reason: collision with root package name */
    private static final Lazy f46313e = LazyKt.b(new Function0() { // from class: com.transsion.mbwidget.data.l
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            VideoDetailPlayDao C;
            C = WidgetDataManager.C();
            return C;
        }
    });

    /* renamed from: g, reason: collision with root package name */
    private static final CopyOnWriteArrayList f46315g = new CopyOnWriteArrayList();

    /* renamed from: h, reason: collision with root package name */
    private static final CopyOnWriteArrayList f46316h = new CopyOnWriteArrayList();

    /* renamed from: j, reason: collision with root package name */
    private static volatile CopyOnWriteArrayList f46318j = new CopyOnWriteArrayList();

    private WidgetDataManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(14:1|(2:3|(12:5|6|7|8|(1:(2:11|12)(2:76|77))(7:78|79|(1:81)(1:90)|82|(1:84)(1:89)|85|(1:87)(1:88))|13|(9:17|(7:20|(1:37)(1:24)|25|(1:36)(1:29)|(3:31|32|33)(1:35)|34|18)|38|39|(7:42|(1:59)(1:46)|47|(1:58)(1:51)|(3:53|54|55)(1:57)|56|40)|60|61|(1:66)|67)|68|69|(1:71)|72|73))|93|6|7|8|(0)(0)|13|(10:15|17|(1:18)|38|39|(1:40)|60|61|(2:63|66)|67)|68|69|(0)|72|73) */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0032, code lost:
    
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x016e, code lost:
    
        r0 = kotlin.Result.INSTANCE;
        r11 = kotlin.Result.m1185constructorimpl(kotlin.ResultKt.a(r11));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a4 A[Catch: all -> 0x0032, TryCatch #0 {all -> 0x0032, blocks: (B:12:0x002e, B:13:0x0077, B:15:0x0085, B:17:0x008d, B:18:0x009e, B:20:0x00a4, B:22:0x00b1, B:24:0x00b7, B:25:0x00bd, B:27:0x00c3, B:29:0x00c9, B:32:0x00d1, B:39:0x00d5, B:40:0x00e9, B:42:0x00ef, B:44:0x00fc, B:46:0x0102, B:47:0x0108, B:49:0x010e, B:51:0x0114, B:54:0x011c, B:61:0x0120, B:63:0x0129, B:66:0x0130, B:67:0x0136, B:68:0x0167, B:79:0x0040, B:82:0x004f, B:85:0x005c), top: B:8:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ef A[Catch: all -> 0x0032, TryCatch #0 {all -> 0x0032, blocks: (B:12:0x002e, B:13:0x0077, B:15:0x0085, B:17:0x008d, B:18:0x009e, B:20:0x00a4, B:22:0x00b1, B:24:0x00b7, B:25:0x00bd, B:27:0x00c3, B:29:0x00c9, B:32:0x00d1, B:39:0x00d5, B:40:0x00e9, B:42:0x00ef, B:44:0x00fc, B:46:0x0102, B:47:0x0108, B:49:0x010e, B:51:0x0114, B:54:0x011c, B:61:0x0120, B:63:0x0129, B:66:0x0130, B:67:0x0136, B:68:0x0167, B:79:0x0040, B:82:0x004f, B:85:0x005c), top: B:8:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object A(kotlin.coroutines.Continuation r11) {
        /*
            Method dump skipped, instructions count: 410
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.mbwidget.data.WidgetDataManager.A(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void B(DeskWidgetResp deskWidgetResp) {
        kotlinx.coroutines.k.d(o0.a(y0.b()), null, null, new WidgetDataManager$saveToCache$1(deskWidgetResp, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoDetailPlayDao C() {
        AppDatabase.Companion companion = AppDatabase.INSTANCE;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        return companion.b(a11).D1();
    }

    private final void f() {
        DeskWidgetResp i11;
        CopyOnWriteArrayList copyOnWriteArrayList = f46316h;
        if ((copyOnWriteArrayList.isEmpty() || f46315g.isEmpty()) && (i11 = i()) != null) {
            if (copyOnWriteArrayList.isEmpty() && !i11.getInterestList().isEmpty()) {
                copyOnWriteArrayList.addAll(i11.getInterestList());
            }
            CopyOnWriteArrayList copyOnWriteArrayList2 = f46315g;
            if (!copyOnWriteArrayList2.isEmpty() || i11.getHotList().isEmpty()) {
                return;
            }
            copyOnWriteArrayList2.addAll(i11.getHotList());
        }
    }

    private final Object g(List list, Continuation continuation) {
        Object A;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            f46315g.remove(bVar.b());
            f46316h.remove(bVar.b());
        }
        return ((f46315g.isEmpty() || f46316h.isEmpty()) && (A = A(continuation)) == IntrinsicsKt.f()) ? A : Unit.f67184a;
    }

    private final DeskWidgetResp i() {
        String string = com.transsion.mbwidget.d.f46293a.k().getString("hot_widget_cache_key", null);
        lg.a.f68962a.c("DeskWidget_", "widget load cache:" + (string == null), true);
        try {
            Result.Companion companion = Result.INSTANCE;
            return (DeskWidgetResp) o.d(string, DeskWidgetResp.class);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
            return null;
        }
    }

    private final a l() {
        return (a) f46312d.getValue();
    }

    private final PendingIntent n(Context context, boolean z10, String str, Integer num, String str2, String str3, String str4) {
        Intent intent = new Intent(context, (Class<?>) (z10 ? HotSubjectWidgetProvider.class : PlayWidgetProvider.class));
        int i11 = Build.VERSION.SDK_INT >= 31 ? 201326592 : ASTNode.NOJIT;
        intent.putExtra("appWidgetId", num);
        intent.putExtra("key_deeplink_widget", str);
        intent.putExtra("key_subject_id_widget", str2);
        intent.putExtra("key_module_name", str3);
        if (str4 == null) {
            str4 = z10 ? "com.transsion.mbwidget.hot.ACTION_CLICK" : "com.transsion.mbwidget.play.ACTION_CLICK";
        }
        intent.setAction(str4);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, (int) System.currentTimeMillis(), intent, i11);
        Intrinsics.g(broadcast, "getBroadcast(...)");
        return broadcast;
    }

    static /* synthetic */ PendingIntent o(WidgetDataManager widgetDataManager, Context context, boolean z10, String str, Integer num, String str2, String str3, String str4, int i11, Object obj) {
        return widgetDataManager.n(context, z10, str, num, (i11 & 16) != 0 ? null : str2, (i11 & 32) != 0 ? null : str3, (i11 & 64) != 0 ? null : str4);
    }

    private final Subject r(int i11, HashSet hashSet) {
        List m11 = j.f46323a.m();
        Collections.shuffle(m11);
        if (i11 == 0) {
            return z(f46316h, m11, hashSet);
        }
        if (i11 == 1) {
            return z(f46315g, m11, hashSet);
        }
        if (i11 != 2) {
            return null;
        }
        return z(f46316h, m11, hashSet);
    }

    private final VideoDetailPlayDao w() {
        return (VideoDetailPlayDao) f46313e.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a x() {
        return (a) zg.c.f79537e.a().h(a.class);
    }

    private final Subject z(List list, List list2, Set set) {
        Object obj;
        Object obj2;
        Iterator it = list.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it.next();
            if (set.add(((Subject) obj2).getSubjectId())) {
                break;
            }
        }
        Subject subject = (Subject) obj2;
        if (subject != null) {
            return subject;
        }
        Iterator it2 = list2.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            if (set.add(((Subject) next).getSubjectId())) {
                obj = next;
                break;
            }
        }
        return (Subject) obj;
    }

    public final Subject h(String str) {
        Object obj;
        if (str == null) {
            return null;
        }
        Iterator it = f46318j.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.c(((b) obj).b().getSubjectId(), str)) {
                break;
            }
        }
        b bVar = (b) obj;
        if (bVar != null) {
            return bVar.b();
        }
        return null;
    }

    public final VideoDetailPlayBean j() {
        String str;
        Subject subject = (Subject) CollectionsKt.v0(f46315g);
        if (subject == null) {
            subject = (Subject) CollectionsKt.u0(j.f46323a.m());
        }
        String subjectId = subject.getSubjectId();
        String str2 = subjectId == null ? "" : subjectId;
        String subjectId2 = subject.getSubjectId();
        String str3 = subjectId2 == null ? "" : subjectId2;
        String title = subject.getTitle();
        Cover cover = subject.getCover();
        if (cover == null || (str = cover.getUrl()) == null) {
            str = "";
        }
        return new VideoDetailPlayBean(str2, str3, 0, 0, 0L, title, str, null, null, 0L, null, null, null, null, null, false, null, null, null, 0L, null, null, null, false, false, false, null, 134217628, null);
    }

    public final Object k(String str, int i11, Continuation continuation) {
        Integer n11 = j.f46323a.n(str);
        if (n11 != null) {
            return BitmapUtils.f46336a.b(n11.intValue());
        }
        BitmapUtils bitmapUtils = BitmapUtils.f46336a;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        return bitmapUtils.d(a11, str, i11, continuation);
    }

    public final PendingIntent m(Context context, boolean z10, Integer num) {
        Intrinsics.h(context, "context");
        return o(this, context, z10, "oneroom://com.community.oneroom?type=/main/tab&bottomTab=home&channel=desk_widget", num, null, "root", null, 80, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p(kotlin.coroutines.Continuation r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof com.transsion.mbwidget.data.WidgetDataManager$getPlayHistory$1
            if (r0 == 0) goto L13
            r0 = r12
            com.transsion.mbwidget.data.WidgetDataManager$getPlayHistory$1 r0 = (com.transsion.mbwidget.data.WidgetDataManager$getPlayHistory$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.mbwidget.data.WidgetDataManager$getPlayHistory$1 r0 = new com.transsion.mbwidget.data.WidgetDataManager$getPlayHistory$1
            r0.<init>(r11, r12)
        L18:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r12)
            goto L51
        L29:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L31:
            kotlin.ResultKt.b(r12)
            com.transsion.baselib.db.video.VideoDetailPlayBean r12 = com.transsion.mbwidget.data.WidgetDataManager.f46314f
            if (r12 == 0) goto L41
            boolean r12 = r11.y()
            if (r12 != 0) goto L41
            com.transsion.baselib.db.video.VideoDetailPlayBean r12 = com.transsion.mbwidget.data.WidgetDataManager.f46314f
            return r12
        L41:
            com.transsion.baselib.db.video.VideoDetailPlayDao r12 = r11.w()
            r0.label = r3
            r2 = 0
            r4 = 50
            java.lang.Object r12 = r12.d(r2, r4, r0)
            if (r12 != r1) goto L51
            return r1
        L51:
            java.util.List r12 = (java.util.List) r12
            r0 = 0
            if (r12 == 0) goto L95
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.util.Iterator r12 = r12.iterator()
        L5c:
            boolean r1 = r12.hasNext()
            if (r1 == 0) goto L93
            java.lang.Object r1 = r12.next()
            r2 = r1
            com.transsion.baselib.db.video.VideoDetailPlayBean r2 = (com.transsion.baselib.db.video.VideoDetailPlayBean) r2
            java.lang.Long r4 = r2.getTotalDuration()
            r5 = 1
            if (r4 == 0) goto L79
            long r7 = r4.longValue()
            long r5 = kotlin.ranges.RangesKt.g(r7, r5)
        L79:
            long r7 = r2.getProgress()
            r4 = 100
            long r9 = (long) r4
            long r7 = r7 * r9
            long r7 = r7 / r5
            java.lang.String r2 = r2.getId()
            boolean r2 = android.text.TextUtils.isDigitsOnly(r2)
            if (r2 == 0) goto L5c
            r4 = 80
            int r2 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r2 > 0) goto L5c
            r0 = r1
        L93:
            com.transsion.baselib.db.video.VideoDetailPlayBean r0 = (com.transsion.baselib.db.video.VideoDetailPlayBean) r0
        L95:
            com.transsion.mbwidget.data.WidgetDataManager.f46314f = r0
            lg.a$a r12 = lg.a.f68962a
            com.transsion.baselib.db.video.VideoDetailPlayBean r0 = com.transsion.mbwidget.data.WidgetDataManager.f46314f
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "getPlayHistory curHistory: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.String r1 = "DeskWidget_"
            r12.i(r1, r0, r3)
            com.transsion.baselib.db.video.VideoDetailPlayBean r12 = com.transsion.mbwidget.data.WidgetDataManager.f46314f
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.mbwidget.data.WidgetDataManager.p(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final PendingIntent q(Context context, boolean z10, Integer num) {
        Intrinsics.h(context, "context");
        return o(this, context, z10, "oneroom://com.community.oneroom?type=/main/tab&bottomTab=home&channel=desk_widget", num, "refresh_all", ToolBar.REFRESH, null, 64, null);
    }

    public final PendingIntent s(Context context, boolean z10, Integer num) {
        Intrinsics.h(context, "context");
        return o(this, context, z10, "oneroom://com.community.oneroom?type=/search/activity/search_manager&type=3&channel=desk_widget", num, null, "search", null, 80, null);
    }

    public final String t() {
        String str = f46317i;
        if (str != null) {
            return str;
        }
        String string = Utils.a().getString(R$string.widget_search_tips);
        Intrinsics.g(string, "getString(...)");
        return string;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e1 A[LOOP:0: B:27:0x00db->B:29:0x00e1, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x012d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0142 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object u(java.lang.String r12, java.lang.String r13, kotlin.coroutines.Continuation r14) {
        /*
            Method dump skipped, instructions count: 448
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.mbwidget.data.WidgetDataManager.u(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final PendingIntent v(Context context, boolean z10, Integer num, String str) {
        Intrinsics.h(context, "context");
        return o(this, context, z10, "oneroom://com.community.oneroom?type=/movie/detail&channel=desk_widget&id=" + str + "&ops=%7B%22trace_id%22%3A%226516b509cfdb36d11f9026a5b2981871%22%7D", num, str, "subject", null, 64, null);
    }

    public final boolean y() {
        return System.currentTimeMillis() - f46310b > f46311c;
    }
}
