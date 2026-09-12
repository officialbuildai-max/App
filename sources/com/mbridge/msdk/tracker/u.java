package com.mbridge.msdk.tracker;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class u {

    /* renamed from: g, reason: collision with root package name */
    private static volatile u f38782g;

    /* renamed from: a, reason: collision with root package name */
    private m f38783a;

    /* renamed from: b, reason: collision with root package name */
    private x f38784b;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f38785c = false;

    /* renamed from: d, reason: collision with root package name */
    private int f38786d = 30000;

    /* renamed from: e, reason: collision with root package name */
    private final HashMap<String, String> f38787e = new HashMap<>();

    /* renamed from: f, reason: collision with root package name */
    Handler f38788f = new a(Looper.getMainLooper());

    /* loaded from: classes5.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 1) {
                return;
            }
            try {
                u.this.b();
                u.this.f38788f.removeMessages(1);
                u.this.d();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    private u() {
    }

    public static u a() {
        if (f38782g == null) {
            synchronized (u.class) {
                try {
                    if (f38782g == null) {
                        f38782g = new u();
                    }
                } finally {
                }
            }
        }
        return f38782g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        try {
            this.f38788f.sendEmptyMessageDelayed(1, this.f38786d);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void a(Context context, x xVar, int i11, JSONObject jSONObject) {
        this.f38784b = xVar;
        this.f38786d = i11;
        m a11 = m.a("monitor", context, xVar);
        this.f38783a = a11;
        if (a11 != null) {
            a11.a(jSONObject);
            this.f38783a.h();
        }
        c();
    }

    public void b() {
        m[] b11 = m.b();
        if (b11.length == 0) {
            return;
        }
        try {
            for (m mVar : b11) {
                String f11 = mVar.f();
                if (!"monitor".equals(f11)) {
                    String d11 = mVar.d();
                    long[] e11 = mVar.e();
                    long j11 = e11[1];
                    if (j11 != 0) {
                        long j12 = e11[0];
                        if (this.f38787e.containsKey(f11)) {
                            if ((j12 + "").equals(this.f38787e.get(f11))) {
                            }
                        }
                        this.f38787e.put(f11, j12 + "");
                        if (this.f38783a != null) {
                            try {
                                e eVar = new e("event_lib_monitor");
                                eVar.a(1);
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("key", "m_report_rate");
                                jSONObject.put("task_name", f11);
                                jSONObject.put("task_count", j11);
                                jSONObject.put("task_session_id", d11);
                                jSONObject.put("task_ts", j12);
                                eVar.a(jSONObject);
                                this.f38783a.d(eVar);
                            } catch (Exception e12) {
                                e12.printStackTrace();
                            }
                        }
                    }
                }
            }
        } catch (Exception e13) {
            e13.printStackTrace();
        }
    }

    public synchronized void c() {
        if (this.f38785c) {
            return;
        }
        this.f38785c = true;
        d();
    }
}
