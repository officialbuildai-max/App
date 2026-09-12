package com.mbridge.msdk.click.retry;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.f;
import com.mbridge.msdk.foundation.tools.z0;
import com.mbridge.msdk.setting.g;
import com.mbridge.msdk.setting.h;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: e, reason: collision with root package name */
    public static String f34464e = "mtg_retry_report=1";

    /* renamed from: f, reason: collision with root package name */
    public static int f34465f = 10000;

    /* renamed from: g, reason: collision with root package name */
    public static int f34466g = 3;

    /* renamed from: h, reason: collision with root package name */
    public static int f34467h = 50;

    /* renamed from: i, reason: collision with root package name */
    public static int f34468i = 600000;

    /* renamed from: j, reason: collision with root package name */
    private static int f34469j = 0;

    /* renamed from: k, reason: collision with root package name */
    private static int f34470k = 0;

    /* renamed from: l, reason: collision with root package name */
    public static int f34471l = 0;

    /* renamed from: m, reason: collision with root package name */
    public static int f34472m = 1;

    /* renamed from: n, reason: collision with root package name */
    public static int f34473n = 2;

    /* renamed from: o, reason: collision with root package name */
    public static int f34474o = 3;

    /* renamed from: p, reason: collision with root package name */
    public static int f34475p = 4;

    /* renamed from: q, reason: collision with root package name */
    public static int f34476q = 5;

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<String, com.mbridge.msdk.click.retry.b> f34477a;

    /* renamed from: b, reason: collision with root package name */
    private com.mbridge.msdk.click.retry.c f34478b;

    /* renamed from: c, reason: collision with root package name */
    private BroadcastReceiver f34479c;

    /* renamed from: d, reason: collision with root package name */
    private final Handler f34480d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mbridge.msdk.click.retry.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0475a extends BroadcastReceiver {
        C0475a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                a.this.f34480d.sendEmptyMessage(2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static a f34482a = new a(null);
    }

    /* loaded from: classes5.dex */
    private static class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            int i11 = message.what;
            if (i11 != 1) {
                if (i11 != 2) {
                    return;
                }
                a.b().c();
            } else {
                Object obj = message.obj;
                if (obj instanceof String) {
                    a.b().a((String) obj, com.mbridge.msdk.click.retry.b.f34483k);
                }
            }
        }
    }

    private a() {
        this.f34477a = new ConcurrentHashMap<>();
        this.f34478b = new com.mbridge.msdk.click.retry.c(f34467h);
        this.f34480d = new c(Looper.getMainLooper());
        g b11 = h.b().b(com.mbridge.msdk.foundation.controller.c.m().b());
        f34466g = b11.d0();
        f34465f = b11.f0() * 1000;
        f34468i = b11.g0() * 1000;
        f34469j = b11.c0();
        f34470k = b11.e0();
        a();
    }

    /* synthetic */ a(C0475a c0475a) {
        this();
    }

    private void a() {
        try {
            if (this.f34479c == null) {
                this.f34479c = new C0475a();
                Context d11 = com.mbridge.msdk.foundation.controller.c.m().d();
                if (d11 != null) {
                    d11.registerReceiver(this.f34479c, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    private static void a(Context context, String str, String str2, String str3, String str4, int i11) {
        f.a().a(context, str, str2, str3, str4, i11);
    }

    private void a(com.mbridge.msdk.click.retry.b bVar) {
        String str;
        String str2;
        try {
            CampaignEx a11 = bVar.a();
            if (a11 != null) {
                String requestId = a11.getRequestId();
                str2 = a11.getRequestIdNotice();
                str = requestId;
            } else {
                str = "";
                str2 = str;
            }
            a(com.mbridge.msdk.foundation.controller.c.m().d(), bVar.b().toString(), bVar.g(), str, str2, bVar.h());
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    private void a(String str) {
        Message obtainMessage = this.f34480d.obtainMessage();
        obtainMessage.what = 1;
        obtainMessage.obj = str;
        this.f34480d.sendMessageDelayed(obtainMessage, f34465f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i11) {
        String str2;
        com.mbridge.msdk.click.retry.c cVar = this.f34478b;
        if (cVar != null) {
            com.mbridge.msdk.click.retry.b a11 = cVar.a(str);
            this.f34478b.b(str);
            if (a11 == null) {
                com.mbridge.msdk.click.retry.b bVar = this.f34477a.get(str);
                if (bVar == null || System.currentTimeMillis() > bVar.c() + f34468i || bVar.e() >= f34466g || i11 == com.mbridge.msdk.click.retry.b.f34484l) {
                    return;
                }
                a(str);
                return;
            }
            if (System.currentTimeMillis() > a11.c() + f34468i) {
                if (i11 != com.mbridge.msdk.click.retry.b.f34484l) {
                    a(a11);
                    return;
                }
                return;
            }
            a11.a(i11);
            this.f34477a.put(str, a11);
            if (z0.c(str) == 0) {
                str2 = str + UrlUtils.QUESTION_MARK + f34464e;
            } else {
                str2 = str + UrlUtils.AND_MARK + f34464e;
            }
            com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), a11.a(), a11.f(), str2, a11.i(), a11.j(), a11.h());
        }
    }

    private void a(String str, com.mbridge.msdk.click.retry.b bVar) {
        if (this.f34478b == null) {
            this.f34478b = new com.mbridge.msdk.click.retry.c(f34467h);
        }
        this.f34478b.a(str, bVar);
    }

    private boolean a(int i11) {
        return i11 == f34475p || i11 == f34474o;
    }

    public static a b() {
        return b.f34482a;
    }

    private boolean b(int i11) {
        return i11 == f34472m || i11 == f34473n;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        com.mbridge.msdk.click.retry.c cVar = this.f34478b;
        if (cVar != null) {
            Iterator<String> it = cVar.a().iterator();
            while (it.hasNext()) {
                a(it.next(), com.mbridge.msdk.click.retry.b.f34484l);
            }
        }
    }

    private boolean c(int i11) {
        return a(i11) || b(i11) || i11 == f34476q;
    }

    public void a(String str, String str2, CampaignEx campaignEx, String str3, boolean z10, boolean z11, int i11) {
        if (!c(i11) || TextUtils.isEmpty(str)) {
            return;
        }
        String replace = str.replace(UrlUtils.QUESTION_MARK + f34464e, "").replace(UrlUtils.AND_MARK + f34464e, "");
        if (this.f34477a == null) {
            this.f34477a = new ConcurrentHashMap<>();
        }
        com.mbridge.msdk.click.retry.b remove = this.f34477a.remove(replace);
        if (remove == null) {
            remove = new com.mbridge.msdk.click.retry.b(str, str2);
            remove.b(i11);
            remove.a(z10);
            remove.b(z11);
            remove.a(campaignEx);
            remove.b(str3);
        } else if (remove.d() != com.mbridge.msdk.click.retry.b.f34484l) {
            remove.a(str2);
        }
        if ((!a(i11) || f34469j == 0) && ((!b(i11) || f34470k == 0) && i11 != f34476q)) {
            a(remove);
            return;
        }
        if (System.currentTimeMillis() >= remove.c() + f34468i) {
            if (remove.d() == com.mbridge.msdk.click.retry.b.f34483k) {
                a(remove);
                return;
            }
            return;
        }
        a(replace, remove);
        if (remove.d() == com.mbridge.msdk.click.retry.b.f34483k) {
            if (remove.e() <= f34466g) {
                a(replace);
            } else {
                a(remove);
            }
        }
    }
}
