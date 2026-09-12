package com.cloud.hisavana.sdk;

import android.database.Cursor;
import android.util.Log;
import com.cloud.hisavana.sdk.common.bean.DiskTrackingBean;
import com.cloud.hisavana.sdk.database.HSRoomDatabase;
import com.cloud.sdk.commonutil.gsonutil.GsonUtil;
import com.cloud.sdk.commonutil.util.HSScopeHelper;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.google.gson.reflect.TypeToken;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class R0 {

    /* renamed from: e, reason: collision with root package name */
    public static final a f21617e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    private static final R0 f21618f = new R0();

    /* renamed from: a, reason: collision with root package name */
    private final long f21619a = TmcConstants.MINI_POPWINDOW_ADD_HOME_INTERVAL;

    /* renamed from: b, reason: collision with root package name */
    private final int f21620b = 400;

    /* renamed from: c, reason: collision with root package name */
    private final int f21621c = 500;

    /* renamed from: d, reason: collision with root package name */
    private final String f21622d = "RetryTrackingDbManager";

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final R0 a() {
            return R0.f21618f;
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/cloud/hisavana/sdk/R0$b", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/cloud/hisavana/sdk/common/bean/DiskTrackingBean;", "api_release"}, k = 1, mv = {1, 9, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* loaded from: classes3.dex */
    public static final class b extends TypeToken<List<? extends DiskTrackingBean>> {
        b() {
        }
    }

    private final q1 c(DiskTrackingBean diskTrackingBean) {
        return q1.f22931f.a(diskTrackingBean);
    }

    private final List d(Integer num) {
        Pair a11 = num != null ? TuplesKt.a("SELECT tracking_data FROM retry_tracking_table_room LIMIT ?", new Integer[]{num}) : TuplesKt.a("SELECT tracking_data FROM retry_tracking_table_room", new Integer[0]);
        Cursor a12 = HSRoomDatabase.v0().x0().a(new a4.a((String) a11.component1(), (Integer[]) a11.component2()));
        ArrayList arrayList = new ArrayList();
        while (a12.moveToNext()) {
            String string = a12.getString(0);
            Intrinsics.e(string);
            arrayList.add(string);
        }
        a12.close();
        if (arrayList.isEmpty()) {
            return new ArrayList();
        }
        Object b11 = GsonUtil.b(arrayList.toString(), new b().getType());
        Intrinsics.g(b11, "fromJson(...)");
        return (List) b11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(DiskTrackingBean diskTrackingBean, R0 this$0) {
        Intrinsics.h(this$0, "this$0");
        if (diskTrackingBean != null) {
            HSRoomDatabase.v0().x0().b(this$0.c(diskTrackingBean));
        }
    }

    private final void g(List list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        HSRoomDatabase.v0().x0().d((String[]) list.toArray(new String[0]));
        e4.b().d(this.f21622d, "deleteByUUIDs ," + list + ' ');
    }

    private final void i() {
        HSRoomDatabase.v0().x0().a(System.currentTimeMillis() - this.f21619a);
    }

    private final List n() {
        return d(null);
    }

    public final void f(String uuid) {
        Intrinsics.h(uuid, "uuid");
        try {
            HSRoomDatabase.v0().x0().d(new String[]{uuid});
        } catch (Exception e11) {
            e4.b().e(this.f21622d, "deleteByUUID " + Log.getStackTraceString(e11));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x007c, code lost:
    
        if (r8 == null) goto L32;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0084  */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v4, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.cloud.hisavana.sdk.common.bean.DiskTrackingBean h(java.lang.String r8) {
        /*
            r7 = this;
            java.lang.String r0 = "uuid"
            kotlin.jvm.internal.Intrinsics.h(r8, r0)
            r0 = 0
            a4.a r1 = new a4.a     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L5c
            java.lang.String r2 = "SELECT tracking_data FROM retry_tracking_table_room WHERE uuid = ?"
            java.lang.String[] r8 = new java.lang.String[]{r8}     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L5c
            r1.<init>(r2, r8)     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L5c
            com.cloud.hisavana.sdk.database.HSRoomDatabase r8 = com.cloud.hisavana.sdk.database.HSRoomDatabase.v0()     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L5c
            com.cloud.hisavana.sdk.m1 r8 = r8.x0()     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L5c
            android.database.Cursor r8 = r8.a(r1)     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L5c
            boolean r1 = r8.moveToNext()     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            if (r1 == 0) goto L7e
            int r1 = r8.getColumnCount()     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            if (r1 > 0) goto L2d
            r8.close()
            return r0
        L2d:
            java.lang.String r1 = "tracking_data"
            int r1 = r8.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            if (r1 >= 0) goto L39
            r8.close()
            return r0
        L39:
            java.lang.String r1 = r8.getString(r1)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            if (r2 == 0) goto L47
            r8.close()
            return r0
        L47:
            java.lang.Class<com.cloud.hisavana.sdk.common.bean.DiskTrackingBean> r2 = com.cloud.hisavana.sdk.common.bean.DiskTrackingBean.class
            java.lang.Object r1 = com.cloud.sdk.commonutil.gsonutil.GsonUtil.a(r1, r2)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            com.cloud.hisavana.sdk.common.bean.DiskTrackingBean r1 = (com.cloud.hisavana.sdk.common.bean.DiskTrackingBean) r1     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            r8.close()
            return r1
        L53:
            r0 = move-exception
            goto L82
        L55:
            r1 = move-exception
            goto L5e
        L57:
            r8 = move-exception
            r6 = r0
            r0 = r8
            r8 = r6
            goto L82
        L5c:
            r1 = move-exception
            r8 = r0
        L5e:
            com.cloud.hisavana.sdk.e4 r2 = com.cloud.hisavana.sdk.e4.b()     // Catch: java.lang.Throwable -> L53
            java.lang.String r3 = r7.f21622d     // Catch: java.lang.Throwable -> L53
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L53
            r4.<init>()     // Catch: java.lang.Throwable -> L53
            java.lang.String r5 = "queryByMd5 "
            r4.append(r5)     // Catch: java.lang.Throwable -> L53
            java.lang.String r1 = android.util.Log.getStackTraceString(r1)     // Catch: java.lang.Throwable -> L53
            r4.append(r1)     // Catch: java.lang.Throwable -> L53
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Throwable -> L53
            r2.e(r3, r1)     // Catch: java.lang.Throwable -> L53
            if (r8 == 0) goto L81
        L7e:
            r8.close()
        L81:
            return r0
        L82:
            if (r8 == 0) goto L87
            r8.close()
        L87:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.hisavana.sdk.R0.h(java.lang.String):com.cloud.hisavana.sdk.common.bean.DiskTrackingBean");
    }

    public final void j(final DiskTrackingBean diskTrackingBean) {
        try {
            HSScopeHelper.f23249a.i(new Runnable() { // from class: com.cloud.hisavana.sdk.p1
                @Override // java.lang.Runnable
                public final void run() {
                    R0.e(DiskTrackingBean.this, this);
                }
            });
        } catch (Exception e11) {
            e4.b().e(this.f21622d, "saveTrackingBean " + Log.getStackTraceString(e11));
        }
    }

    public final void k() {
        try {
            List a11 = HSRoomDatabase.v0().x0().a();
            int size = (a11 == null || a11.size() < this.f21621c) ? 0 : a11.size() - this.f21620b;
            e4 b11 = e4.b();
            String str = this.f21622d;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("deleteTrackingBeanToSafeSpace count : ");
            sb2.append(size);
            sb2.append(",query?.count : ");
            sb2.append(a11 != null ? Integer.valueOf(a11.size()) : null);
            sb2.append(' ');
            b11.e(str, sb2.toString());
            if (size > 0) {
                List d11 = d(Integer.valueOf(size));
                ArrayList arrayList = new ArrayList();
                Iterator it = d11.iterator();
                while (it.hasNext()) {
                    arrayList.add(((DiskTrackingBean) it.next()).getUuid());
                }
                g(arrayList);
            }
        } catch (Exception e11) {
            e4.b().e(this.f21622d, "deleteTrackingBeanToSafeSpace " + Log.getStackTraceString(e11));
        }
    }

    public final void l(DiskTrackingBean diskTrackingBean) {
        if (diskTrackingBean != null) {
            try {
                HSRoomDatabase.v0().x0().c(c(diskTrackingBean));
            } catch (Exception e11) {
                e4.b().e(this.f21622d, "updateTrackingBean " + Log.getStackTraceString(e11));
            }
        }
    }

    public final List m() {
        try {
            i();
            return n();
        } catch (Exception e11) {
            e4.b().e(this.f21622d, "getAllTrackingBeans " + Log.getStackTraceString(e11));
            return new ArrayList();
        }
    }
}
