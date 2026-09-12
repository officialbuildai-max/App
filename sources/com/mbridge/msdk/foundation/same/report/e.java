package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.BatchReportDao;
import com.mbridge.msdk.foundation.tools.k0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.q0;
import com.mbridge.msdk.foundation.tools.w0;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import com.mbridge.msdk.tracker.p;
import com.mbridge.msdk.tracker.x;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public final class e {

    /* renamed from: l, reason: collision with root package name */
    private static final String f35595l = "e";

    /* renamed from: m, reason: collision with root package name */
    private static String f35596m = "roas";

    /* renamed from: n, reason: collision with root package name */
    private static volatile e f35597n;

    /* renamed from: a, reason: collision with root package name */
    private AtomicInteger f35598a;

    /* renamed from: b, reason: collision with root package name */
    private BatchReportDao f35599b;

    /* renamed from: c, reason: collision with root package name */
    private int f35600c = 1;

    /* renamed from: d, reason: collision with root package name */
    private long f35601d = 0;

    /* renamed from: e, reason: collision with root package name */
    private String f35602e = com.mbridge.msdk.foundation.same.net.utils.d.h().O;

    /* renamed from: f, reason: collision with root package name */
    private volatile int f35603f = 0;

    /* renamed from: g, reason: collision with root package name */
    private boolean f35604g = false;

    /* renamed from: h, reason: collision with root package name */
    private Executor f35605h = Executors.newSingleThreadExecutor();

    /* renamed from: i, reason: collision with root package name */
    private Handler f35606i;

    /* renamed from: j, reason: collision with root package name */
    private Stack<Long> f35607j;

    /* renamed from: k, reason: collision with root package name */
    private com.mbridge.msdk.tracker.m f35608k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i11 = message.what;
            if (i11 == 1) {
                Bundle data = message.getData();
                if (e.this.f35606i == null || e.this.f35599b == null || data == null) {
                    return;
                }
                e.this.f35606i.removeMessages(2);
                long currentTimeMillis = System.currentTimeMillis();
                ArrayList<BatchReportMessage> batchReportMessages = e.this.f35599b.getBatchReportMessages(currentTimeMillis, 2);
                e.this.b(batchReportMessages, currentTimeMillis);
                e.this.f35598a.set(0);
                String str = e.f35595l;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("超时上报触发了，需要上报的数据： ");
                sb2.append(batchReportMessages != null ? batchReportMessages.size() : 0);
                o0.a(str, sb2.toString());
                return;
            }
            if (i11 == 2) {
                Bundle data2 = message.getData();
                if (e.this.f35606i == null || e.this.f35599b == null || data2 == null) {
                    return;
                }
                e.this.f35606i.removeMessages(1);
                long j11 = data2.getLong("last_report_time");
                ArrayList<BatchReportMessage> batchReportMessages2 = e.this.f35599b.getBatchReportMessages(j11, 2);
                e.this.b(batchReportMessages2, j11);
                String str2 = e.f35595l;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("队列上报触发了，需要上报的数据： ");
                sb3.append(batchReportMessages2 != null ? batchReportMessages2.size() : 0);
                o0.a(str2, sb3.toString());
                return;
            }
            if (i11 == 3) {
                Bundle data3 = message.getData();
                if (data3 != null) {
                    e.this.a((ArrayList<BatchReportMessage>) data3.getParcelableArrayList("report_message"), data3.getLong("last_report_time"));
                    return;
                }
                return;
            }
            if (i11 != 4) {
                return;
            }
            Bundle data4 = message.getData();
            if (e.this.f35606i == null || e.this.f35599b == null || data4 == null || !e.this.f35604g) {
                return;
            }
            e.this.f35606i.removeMessages(4);
            ArrayList<BatchReportMessage> batchReportMessages3 = e.this.f35599b.getBatchReportMessages(System.currentTimeMillis(), 2);
            if (batchReportMessages3 != null && batchReportMessages3.size() > 0) {
                for (int i12 = 0; i12 < batchReportMessages3.size(); i12++) {
                    BatchReportMessage batchReportMessage = batchReportMessages3.get(i12);
                    e.this.a(batchReportMessage.getReportMessage(), batchReportMessage.getTimestamp());
                }
            }
            String str3 = e.f35595l;
            StringBuilder sb4 = new StringBuilder();
            sb4.append("切换上报lib，需要上报的数据： ");
            sb4.append(batchReportMessages3 != null ? batchReportMessages3.size() : 0);
            o0.a(str3, sb4.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b extends com.mbridge.msdk.foundation.same.report.net.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f35610b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ArrayList f35611c;

        b(long j11, ArrayList arrayList) {
            this.f35610b = j11;
            this.f35611c = arrayList;
        }

        @Override // com.mbridge.msdk.foundation.same.report.net.b
        public void a(String str) {
            Stack stack;
            o0.a(e.f35595l, "批量上报失败： " + str);
            e.this.a(2, str);
            synchronized (e.this.f35607j) {
                try {
                    e.this.f35607j.add(Long.valueOf(this.f35610b));
                    if (e.this.f35599b != null) {
                        e.this.f35599b.updateMessagesReportState(this.f35611c);
                    }
                    if (e.this.f35607j.size() >= 5) {
                        o0.a(e.f35595l, "批量上报失败，上报失败的数据超过阈值");
                        try {
                            try {
                                e.this.f35607j.pop();
                                long longValue = ((Long) e.this.f35607j.pop()).longValue();
                                e.this.f35607j.clear();
                                if (e.this.f35599b != null) {
                                    e.this.f35599b.deleteBatchReportMessagesByTimestamp(longValue);
                                }
                                stack = e.this.f35607j;
                            } catch (Throwable th2) {
                                e.this.f35607j.clear();
                                throw th2;
                            }
                        } catch (Exception e11) {
                            o0.b(e.f35595l, e11.getMessage());
                            stack = e.this.f35607j;
                        }
                        stack.clear();
                    }
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        }

        @Override // com.mbridge.msdk.foundation.same.report.net.b
        public void b(String str) {
            o0.a(e.f35595l, "批量上报成功");
            e.this.a(1, "");
            try {
                if (e.this.f35599b != null) {
                    e.this.f35599b.deleteBatchReportMessagesByTimestamp(this.f35610b);
                }
            } catch (Exception e11) {
                o0.b(e.f35595l, e11.getMessage());
            }
            synchronized (e.this.f35607j) {
                e.this.f35607j.clear();
            }
        }
    }

    /* loaded from: classes5.dex */
    class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f35613a;

        c(String str) {
            this.f35613a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f35599b == null) {
                return;
            }
            o0.a(e.f35595l, "接收到上报数据： " + this.f35613a);
            if (!e.this.f35604g) {
                if (e.this.f35603f != 1) {
                    e.this.c(this.f35613a);
                }
            } else {
                e.this.a(this.f35613a, 0L);
                if (((Integer) w0.a(com.mbridge.msdk.foundation.controller.c.m().d(), "roas_use_event", 0)).intValue() == 0) {
                    w0.b(com.mbridge.msdk.foundation.controller.c.m().d(), "roas_use_event", 1);
                    e.this.f35606i.sendEmptyMessage(4);
                }
            }
        }
    }

    private e() {
        d();
    }

    private p a(int i11) {
        return i11 == 1 ? new p(new m((byte) 2), com.mbridge.msdk.foundation.same.net.utils.d.h().f35533l, com.mbridge.msdk.foundation.same.net.utils.d.h().f35537p) : new p(new com.mbridge.msdk.tracker.network.toolbox.h(), com.mbridge.msdk.foundation.same.net.utils.d.h().O, 0);
    }

    private JSONObject a(String str) {
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            return jSONObject;
        }
        try {
            for (String str2 : str.split(UrlUtils.AND_MARK)) {
                String[] split = str2.split(UrlUtils.EQUAL_MARK);
                if (split.length == 2) {
                    jSONObject.put(split[0], split[1]);
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i11, String str) {
        com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
        eVar.a("state", Integer.valueOf(i11));
        if (i11 == 2) {
            eVar.a("reason", str);
        }
        com.mbridge.msdk.foundation.same.report.metrics.c cVar = new com.mbridge.msdk.foundation.same.report.metrics.c();
        cVar.a("m_ad_rev_s_s", eVar);
        com.mbridge.msdk.foundation.same.report.metrics.d.b().a("m_ad_rev_s_s", cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, long j11) {
        if (this.f35608k != null) {
            com.mbridge.msdk.tracker.e eVar = new com.mbridge.msdk.tracker.e("roas");
            eVar.a(true);
            if (j11 != 0) {
                eVar.c(j11);
            }
            eVar.a(1);
            try {
                eVar.a(a(str));
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            this.f35608k.d(eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ArrayList<BatchReportMessage> arrayList, long j11) {
        if (arrayList == null || arrayList.size() <= 0) {
            o0.a(f35595l, "需要上报的数据条数： 0");
            return;
        }
        o0.a(f35595l, "需要上报的数据条数： " + arrayList.size());
        Context d11 = com.mbridge.msdk.foundation.controller.c.m().d();
        if (d11 == null) {
            return;
        }
        com.mbridge.msdk.foundation.same.net.wrapper.e a11 = j.a(d11);
        a11.a("app_id", com.mbridge.msdk.foundation.controller.c.m().b());
        a11.a("m_sdk", "msdk");
        a11.a("lqswt", String.valueOf(1));
        a11.a("device_type", k0.E(d11) ? "pad" : "phone");
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_OTHER)) {
            a11.a(com.mbridge.msdk.foundation.same.net.wrapper.e.f35557j, k0.u());
        }
        StringBuilder sb2 = new StringBuilder();
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            try {
                BatchReportMessage batchReportMessage = arrayList.get(i11);
                if (batchReportMessage != null) {
                    sb2.append(batchReportMessage.getReportMessage() + "&ts=" + batchReportMessage.getTimestamp());
                    if (i11 >= 0 && i11 < size - 1) {
                        sb2.append("\n");
                    }
                }
            } catch (Throwable th2) {
                o0.b(f35595l, th2.getMessage());
            }
        }
        try {
            String encode = URLEncoder.encode(sb2.toString(), "utf-8");
            a11.a("data", encode);
            o0.a(f35595l, "需要批量上报的数据： " + encode);
            com.mbridge.msdk.foundation.same.report.net.a aVar = new com.mbridge.msdk.foundation.same.report.net.a(com.mbridge.msdk.foundation.controller.c.m().d());
            a(0, "");
            aVar.post(0, this.f35602e, a11, new b(j11, arrayList), "roas", 60000L);
        } catch (Exception e11) {
            o0.b(f35595l, e11.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ArrayList<BatchReportMessage> arrayList, long j11) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Message obtain = Message.obtain();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("report_message", arrayList);
        bundle.putLong("last_report_time", j11);
        obtain.setData(bundle);
        obtain.what = 3;
        this.f35606i.sendMessage(obtain);
    }

    public static synchronized e c() {
        e eVar;
        synchronized (e.class) {
            try {
                if (f35597n == null) {
                    f35597n = new e();
                }
                eVar = f35597n;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        this.f35599b.addReportMessage(str, 2);
        Handler handler = this.f35606i;
        if (handler != null && !handler.hasMessages(1)) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            this.f35606i.sendMessageDelayed(obtain, this.f35601d);
        }
        if (this.f35598a.incrementAndGet() < this.f35600c || this.f35606i == null) {
            return;
        }
        Message obtain2 = Message.obtain();
        Bundle bundle = new Bundle();
        bundle.putLong("last_report_time", System.currentTimeMillis());
        obtain2.setData(bundle);
        obtain2.what = 2;
        this.f35606i.sendMessage(obtain2);
        this.f35598a.set(0);
    }

    private void d() {
        com.mbridge.msdk.setting.a j11;
        com.mbridge.msdk.setting.g d11 = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
        if (d11 != null && (j11 = d11.j()) != null) {
            this.f35600c = j11.a();
            this.f35601d = j11.c() * 1000;
            this.f35602e = com.mbridge.msdk.foundation.same.net.utils.d.h().O;
            this.f35603f = j11.b();
            boolean z10 = j11.d() == 1;
            this.f35604g = z10;
            if (z10 && this.f35603f != 1) {
                int b11 = q0.a().b("bcp", NativeComponentConstants.KEY_COMPONENT_TYPE, q0.a().b("t_r_t", 1));
                if (b11 != 0 && b11 != 1) {
                    b11 = 0;
                }
                this.f35608k = com.mbridge.msdk.tracker.m.a(f35596m, com.mbridge.msdk.foundation.controller.c.m().d(), new x.b().a(new d()).a(new n()).a(b11, a(b11)).a(q0.a().b("t_m_e_t", MiniAppConfigHelper.DEFAULT_MINI_SCOPE_REQUEST_DIFF)).b(q0.a().b("t_m_e_s", 50)).d(q0.a().b("t_m_r_c", 50)).c(q0.a().b("t_m_t", DefaultLoadControl.DEFAULT_MIN_BUFFER_MS)).e(q0.a().b("t_m_r_t_s", 1)).a());
                JSONObject b12 = com.mbridge.msdk.foundation.same.report.c.b();
                try {
                    b12.put("device_type", k0.E(com.mbridge.msdk.foundation.controller.c.m().d()) ? "pad" : "phone");
                    if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_OTHER)) {
                        b12.put(com.mbridge.msdk.foundation.same.net.wrapper.e.f35557j, k0.u());
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
                this.f35608k.a(b12);
                this.f35608k.h();
            }
        }
        o0.a(f35595l, "初始化批量上报： " + this.f35602e + " " + this.f35600c + " " + this.f35601d + " " + this.f35603f);
        this.f35598a = new AtomicInteger(0);
        this.f35607j = new Stack<>();
        this.f35599b = BatchReportDao.getInstance(com.mbridge.msdk.foundation.controller.c.m().d());
        HandlerThread handlerThread = new HandlerThread("mb_revenue_batch_report_thread");
        handlerThread.start();
        this.f35606i = new a(handlerThread.getLooper());
    }

    public void b() {
        Handler handler = this.f35606i;
        if (handler == null || handler.hasMessages(1) || this.f35603f == 1 || this.f35604g) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 1;
        this.f35606i.sendMessageDelayed(obtain, 5000L);
    }

    public synchronized void b(String str) {
        try {
            if (this.f35603f == 1) {
                return;
            }
            c cVar = new c(str);
            if (com.mbridge.msdk.foundation.controller.d.a().e()) {
                Executor executor = this.f35605h;
                if (executor != null) {
                    executor.execute(cVar);
                } else {
                    cVar.run();
                }
            } else {
                cVar.run();
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
