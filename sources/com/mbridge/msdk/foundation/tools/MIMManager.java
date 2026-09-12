package com.mbridge.msdk.foundation.tools;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public final class MIMManager {

    /* renamed from: i, reason: collision with root package name */
    private static volatile String f35706i;

    /* renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f35707a;

    /* renamed from: b, reason: collision with root package name */
    private int f35708b;

    /* renamed from: c, reason: collision with root package name */
    private CopyOnWriteArrayList<CampaignEx> f35709c;

    /* renamed from: d, reason: collision with root package name */
    private Context f35710d;

    /* renamed from: e, reason: collision with root package name */
    private volatile Boolean f35711e;

    /* renamed from: f, reason: collision with root package name */
    private CampaignEx f35712f;

    /* renamed from: g, reason: collision with root package name */
    private volatile g f35713g;

    /* renamed from: h, reason: collision with root package name */
    private volatile MiOverseaMiniCardBroadcasterReceiver f35714h;

    /* loaded from: classes5.dex */
    public static class MiOverseaMiniCardBroadcasterReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (i0.a("DFKwWgtuDkKwLZPwD+z8H+N/xjK+n3eyNVx6ZVPn5jcincKZx5f5ncN=").equals(intent.getAction())) {
                String stringExtra = intent.getStringExtra("packageName");
                int intExtra = intent.getIntExtra("errorCode", 0);
                int intExtra2 = intExtra < 0 ? intent.getIntExtra("reason", 0) : -1;
                o0.b("MIMManager", stringExtra + " " + intExtra + " " + intExtra2);
                if (intExtra == 1 || intExtra == 2 || intExtra == 3 || intExtra == 4 || intExtra == 7) {
                    try {
                        com.mbridge.msdk.foundation.same.report.metrics.c cVar = new com.mbridge.msdk.foundation.same.report.metrics.c();
                        com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                        eVar.a("key", URLEncoder.encode("m_mini_card", "utf-8"));
                        CampaignEx a11 = MIMManager.b().a(stringExtra);
                        if (a11 != null) {
                            eVar.a("rid", a11.getRequestId());
                            eVar.a("rid_n", a11.getRequestIdNotice());
                            eVar.a(MBridgeConstans.PROPERTIES_UNIT_ID, a11.getCampaignUnitId());
                            eVar.a("u_stid", com.mbridge.msdk.foundation.controller.a.f35048r.get(a11.getCampaignUnitId()));
                            cVar.a(a11);
                        }
                        eVar.a(NotificationCompat.CATEGORY_EVENT, String.valueOf(intExtra));
                        eVar.a("pkg_name", stringExtra);
                        if (intExtra2 != -1) {
                            eVar.a("reasonCode", String.valueOf(intExtra2));
                        }
                        cVar.a("m_mini_card", eVar);
                        com.mbridge.msdk.foundation.same.report.metrics.d.b().a("m_mini_card", cVar);
                    } catch (Exception e11) {
                        o0.b("MIMManager", e11.getMessage());
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f35715a;

        a(Context context) {
            this.f35715a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MIMManager.this.f35707a.compareAndSet(false, true)) {
                try {
                    MIMManager mIMManager = MIMManager.this;
                    mIMManager.f35711e = mIMManager.a();
                } catch (Exception e11) {
                    o0.a("MIMManager", e11.getMessage());
                }
                if (MIMManager.this.f35711e == null || !MIMManager.this.f35711e.booleanValue() || this.f35715a == null) {
                    return;
                }
                try {
                    MIMManager.this.f35713g = new g(null);
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction(i0.a("DFKwWgtuDkKwLZPwD+z8H+N/xj26Vjcdx5KyVj5GxVN="));
                    intentFilter.addAction(i0.a("DFKwWgtuDkKwLZPwD+z8H+N/xj26Vjcdx5KanjKnxVN="));
                    intentFilter.addAction(i0.a("DFKwWgtuDkKwLZPwD+z8H+N/xjQZxVfV+T2SZVe6V2xS5c5n"));
                    this.f35715a.registerReceiver(MIMManager.this.f35713g, intentFilter);
                } catch (Exception e12) {
                    o0.a("MIMManager", e12.getMessage());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f35717a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CampaignEx f35718b;

        b(Context context, CampaignEx campaignEx) {
            this.f35717a = context;
            this.f35718b = campaignEx;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                MIMManager.this.e(this.f35717a, this.f35718b);
            } catch (Exception e11) {
                o0.b("MIMManager", e11.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f35720a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CampaignEx f35721b;

        c(Context context, CampaignEx campaignEx) {
            this.f35720a = context;
            this.f35721b = campaignEx;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                MIMManager.this.d(this.f35720a, this.f35721b);
            } catch (Exception e11) {
                o0.b("MIMManager", e11.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f35723a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CampaignEx f35724b;

        d(Context context, CampaignEx campaignEx) {
            this.f35723a = context;
            this.f35724b = campaignEx;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    MIMManager.this.f(this.f35723a, this.f35724b);
                    if (MIMManager.this.f35709c == null || !MIMManager.this.f35709c.contains(this.f35724b)) {
                        return;
                    }
                } catch (Exception e11) {
                    o0.b("MIMManager", e11.getMessage());
                    if (MIMManager.this.f35709c == null || !MIMManager.this.f35709c.contains(this.f35724b)) {
                        return;
                    }
                }
                MIMManager.this.f35709c.remove(this.f35724b);
            } catch (Throwable th2) {
                if (MIMManager.this.f35709c != null && MIMManager.this.f35709c.contains(this.f35724b)) {
                    MIMManager.this.f35709c.remove(this.f35724b);
                }
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f35726a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f35727b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ CampaignEx f35728c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f35729d;

        e(Context context, String str, CampaignEx campaignEx, int i11) {
            this.f35726a = context;
            this.f35727b = str;
            this.f35728c = campaignEx;
            this.f35729d = i11;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.f35726a == null || TextUtils.isEmpty(this.f35727b) || this.f35728c == null) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("key", "2000100");
                jSONObject.put("network_type", k0.s(this.f35726a));
                jSONObject.put("rid", this.f35728c.getRequestId());
                jSONObject.put("rid_n", this.f35728c.getRequestIdNotice());
                if (!TextUtils.isEmpty(this.f35728c.getCampaignUnitId())) {
                    jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, this.f35728c.getCampaignUnitId());
                    String str = com.mbridge.msdk.foundation.controller.a.f35048r.get(this.f35728c.getCampaignUnitId());
                    if (str == null) {
                        str = "";
                    }
                    jSONObject.put("u_stid", str);
                }
                jSONObject.put(BidResponsedEx.KEY_CID, this.f35728c.getId());
                jSONObject.put(NotificationCompat.CATEGORY_STATUS, this.f35727b);
                jSONObject.put("code", this.f35729d);
                com.mbridge.msdk.foundation.same.report.metrics.d.b().a(jSONObject);
            } catch (Throwable th2) {
                o0.b("MIMManager", th2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class f {

        /* renamed from: a, reason: collision with root package name */
        private static final MIMManager f35731a = new MIMManager(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class g extends BroadcastReceiver {
        private g() {
        }

        /* synthetic */ g(a aVar) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            CampaignEx a11;
            String action = intent.getAction();
            if (TextUtils.isEmpty(action) || action.equals(i0.a("DFKwWgtuDkKwLZPwD+z8H+N/xj26Vjcdx5KyVj5GxVN=")) || action.equals(i0.a("DFKwWgtuDkKwLZPwD+z8H+N/xj26Vjcdx5KanjKnxVN=")) || !action.equals(i0.a("DFKwWgtuDkKwLZPwD+z8H+N/xjQZxVfV+T2SZVe6V2xS5c5n"))) {
                return;
            }
            try {
                Bundle extras = intent.getExtras();
                if (extras == null) {
                    return;
                }
                int i11 = extras.getInt("statusCode", -1);
                String string = extras.getString("packageName", "");
                if (i11 == -1 || TextUtils.isEmpty(string) || (a11 = MIMManager.b().a(string)) == null) {
                    return;
                }
                MIMManager.b().a(context, a11, i11);
                MIMManager.b().a(context, "dm_page_status", i11, MIMManager.b().c());
            } catch (Exception e11) {
                o0.b("MIMManager", e11.getMessage());
            }
        }
    }

    private MIMManager() {
        this.f35708b = 0;
        this.f35709c = new CopyOnWriteArrayList<>();
        this.f35707a = new AtomicBoolean(false);
    }

    /* synthetic */ MIMManager(a aVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CampaignEx a(String str) {
        try {
            CampaignEx campaignEx = this.f35712f;
            if (campaignEx != null && TextUtils.equals(campaignEx.getPackageName(), str)) {
                return this.f35712f;
            }
            CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.f35709c;
            if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
                return null;
            }
            Iterator<CampaignEx> it = this.f35709c.iterator();
            while (it.hasNext()) {
                CampaignEx next = it.next();
                if (next != null && TextUtils.equals(next.getPackageName(), str)) {
                    return next;
                }
            }
            return null;
        } catch (Exception e11) {
            o0.b("MIMManager", e11.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Boolean a() {
        Cursor cursor;
        Context d11 = com.mbridge.msdk.foundation.controller.c.m().d();
        Boolean bool = null;
        if (d11 != null) {
            try {
                if (d11.getContentResolver() != null) {
                    try {
                        cursor = d11.getContentResolver().query(Uri.parse(i0.a("DFK/J75/JaEXWFfXYZP9LkcXYk3/YkcBLF5TWgSBYbHuH75BW3xuhr5UJj2tLkeNhrKFLkxQhl==")), null, null, null, null);
                    } catch (Exception unused) {
                        cursor = null;
                    }
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            try {
                                String string = cursor.getString(cursor.getColumnIndex("support"));
                                if (!TextUtils.isEmpty(string)) {
                                    if (!string.equalsIgnoreCase("null")) {
                                        if (!string.equalsIgnoreCase("false")) {
                                            if (string.equalsIgnoreCase("true")) {
                                            }
                                        }
                                        bool = Boolean.valueOf(Boolean.parseBoolean(string));
                                    }
                                }
                            } catch (Exception e11) {
                                o0.a("MIMManager", e11.getMessage());
                            }
                            try {
                                f35706i = cursor.getString(cursor.getColumnIndex("detailStyle"));
                            } catch (Exception e12) {
                                o0.a("MIMManager", e12.getMessage());
                            }
                        }
                        try {
                            cursor.close();
                        } catch (Exception e13) {
                            o0.a("MIMManager", e13.getMessage());
                        }
                    }
                }
            } catch (Exception e14) {
                o0.b("MIMManager", e14.getMessage());
            }
        }
        return bool;
    }

    private Runnable a(Context context, CampaignEx campaignEx) {
        return new c(context, campaignEx);
    }

    public static MIMManager b() {
        return f.f35731a;
    }

    private Runnable b(Context context, CampaignEx campaignEx) {
        return new b(context, campaignEx);
    }

    private Runnable c(Context context, CampaignEx campaignEx) {
        return new d(context, campaignEx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Context context, CampaignEx campaignEx) {
        String[] u11;
        if (campaignEx != null) {
            try {
                com.mbridge.msdk.foundation.entity.j nativeVideoTracking = campaignEx.getNativeVideoTracking();
                if (nativeVideoTracking == null || (u11 = nativeVideoTracking.u()) == null) {
                    return;
                }
                for (String str : u11) {
                    com.mbridge.msdk.click.a.a(context, campaignEx, campaignEx.getCampaignUnitId(), str, false, false);
                }
            } catch (Exception e11) {
                o0.b("MIMManager", e11.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Context context, CampaignEx campaignEx) {
        String[] v11;
        if (campaignEx != null) {
            try {
                com.mbridge.msdk.foundation.entity.j nativeVideoTracking = campaignEx.getNativeVideoTracking();
                if (nativeVideoTracking == null || (v11 = nativeVideoTracking.v()) == null) {
                    return;
                }
                for (String str : v11) {
                    com.mbridge.msdk.click.a.a(context, campaignEx, campaignEx.getCampaignUnitId(), str, false, false);
                }
            } catch (Exception e11) {
                o0.b("MIMManager", e11.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Context context, CampaignEx campaignEx) {
        String[] w11;
        if (campaignEx != null) {
            try {
                com.mbridge.msdk.foundation.entity.j nativeVideoTracking = campaignEx.getNativeVideoTracking();
                if (nativeVideoTracking == null || (w11 = nativeVideoTracking.w()) == null) {
                    return;
                }
                for (String str : w11) {
                    com.mbridge.msdk.click.a.a(context, campaignEx, campaignEx.getCampaignUnitId(), str, false, false);
                }
            } catch (Exception e11) {
                o0.b("MIMManager", e11.getMessage());
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0020, code lost:
    
        if (r4 != null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0033, code lost:
    
        r3.f35709c = null;
        r3.f35713g = null;
        r3.f35710d = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0030, code lost:
    
        r4.clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002e, code lost:
    
        if (r4 == null) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(android.content.Context r4) {
        /*
            r3 = this;
            java.lang.String r0 = "MIMManager"
            if (r4 == 0) goto L4a
            r1 = 0
            com.mbridge.msdk.foundation.tools.MIMManager$g r2 = r3.f35713g     // Catch: java.lang.Throwable -> Lf java.lang.Exception -> L11
            if (r2 == 0) goto L13
            com.mbridge.msdk.foundation.tools.MIMManager$g r2 = r3.f35713g     // Catch: java.lang.Throwable -> Lf java.lang.Exception -> L11
            r4.unregisterReceiver(r2)     // Catch: java.lang.Throwable -> Lf java.lang.Exception -> L11
            goto L13
        Lf:
            r4 = move-exception
            goto L3a
        L11:
            r4 = move-exception
            goto L23
        L13:
            com.mbridge.msdk.foundation.tools.MIMManager$MiOverseaMiniCardBroadcasterReceiver r2 = r3.f35714h     // Catch: java.lang.Throwable -> Lf java.lang.Exception -> L11
            if (r2 == 0) goto L1c
            com.mbridge.msdk.foundation.tools.MIMManager$MiOverseaMiniCardBroadcasterReceiver r2 = r3.f35714h     // Catch: java.lang.Throwable -> Lf java.lang.Exception -> L11
            r4.unregisterReceiver(r2)     // Catch: java.lang.Throwable -> Lf java.lang.Exception -> L11
        L1c:
            r3.f35712f = r1
            java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> r4 = r3.f35709c
            if (r4 == 0) goto L33
            goto L30
        L23:
            java.lang.String r4 = r4.getMessage()     // Catch: java.lang.Throwable -> Lf
            com.mbridge.msdk.foundation.tools.o0.a(r0, r4)     // Catch: java.lang.Throwable -> Lf
            r3.f35712f = r1
            java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> r4 = r3.f35709c
            if (r4 == 0) goto L33
        L30:
            r4.clear()
        L33:
            r3.f35709c = r1
            r3.f35713g = r1
            r3.f35710d = r1
            goto L4a
        L3a:
            r3.f35712f = r1
            java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> r0 = r3.f35709c
            if (r0 == 0) goto L43
            r0.clear()
        L43:
            r3.f35709c = r1
            r3.f35713g = r1
            r3.f35710d = r1
            throw r4
        L4a:
            r3.i()     // Catch: java.lang.Throwable -> L4e
            goto L56
        L4e:
            r4 = move-exception
            java.lang.String r4 = r4.getMessage()
            com.mbridge.msdk.foundation.tools.o0.b(r0, r4)
        L56:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.MIMManager.a(android.content.Context):void");
    }

    void a(Context context, CampaignEx campaignEx, int i11) {
        Runnable c11 = i11 != 3001 ? i11 != 3002 ? i11 != 3008 ? null : c(context, campaignEx) : a(context, campaignEx) : b(context, campaignEx);
        if (c11 != null) {
            com.mbridge.msdk.foundation.same.threadpool.a.b().execute(c11);
        }
    }

    void a(Context context, String str, int i11, CampaignEx campaignEx) {
        com.mbridge.msdk.foundation.same.threadpool.a.b().execute(new e(context, str, campaignEx, i11));
    }

    public void a(CampaignEx campaignEx) {
        try {
            if (this.f35711e != null && campaignEx != null && this.f35711e.booleanValue()) {
                this.f35712f = campaignEx;
                this.f35709c.add(campaignEx);
            }
            if (com.mbridge.msdk.util.b.b() && campaignEx != null && campaignEx.getDeepLinkURL().startsWith("mimarket")) {
                if (this.f35714h == null) {
                    h();
                }
                this.f35712f = campaignEx;
                this.f35709c.add(campaignEx);
            }
        } catch (Exception e11) {
            o0.b("MIMManager", e11.getMessage());
        }
    }

    public void b(Context context) {
        this.f35710d = context;
        com.mbridge.msdk.foundation.same.threadpool.a.b().execute(new a(context));
    }

    public void b(CampaignEx campaignEx) {
        try {
            if (this.f35711e == null || campaignEx == null || !this.f35711e.booleanValue()) {
                return;
            }
            this.f35712f = null;
            try {
                this.f35709c.remove(campaignEx);
            } catch (Exception e11) {
                o0.a("MIMManager", e11.getMessage());
            }
        } catch (Exception e12) {
            o0.b("MIMManager", e12.getMessage());
        }
    }

    CampaignEx c() {
        return this.f35712f;
    }

    public String d() {
        try {
            return f35706i == null ? "" : String.format("[%s]", f35706i);
        } catch (Exception unused) {
            return "";
        }
    }

    public Boolean e() {
        return this.f35711e;
    }

    public void f() {
        this.f35708b++;
    }

    public void g() {
        int i11 = this.f35708b - 1;
        this.f35708b = i11;
        if (i11 <= 0) {
            a(this.f35710d);
        }
    }

    public void h() {
        try {
            if (this.f35714h == null) {
                this.f35714h = new MiOverseaMiniCardBroadcasterReceiver();
            }
            IntentFilter intentFilter = new IntentFilter(i0.a("DFKwWgtuDkKwLZPwD+z8H+N/xjK+n3eyNVx6ZVPn5jcincKZx5f5ncN="));
            Context d11 = com.mbridge.msdk.foundation.controller.c.m().d();
            if (d11 != null) {
                d11.registerReceiver(this.f35714h, intentFilter);
            }
        } catch (Exception e11) {
            o0.a("MIMManager", e11.getMessage());
        }
    }

    public void i() {
        try {
            if (this.f35714h != null) {
                Context d11 = com.mbridge.msdk.foundation.controller.c.m().d();
                if (d11 != null) {
                    d11.unregisterReceiver(this.f35714h);
                }
                this.f35712f = null;
                CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.f35709c;
                if (copyOnWriteArrayList != null) {
                    copyOnWriteArrayList.clear();
                }
                this.f35709c = null;
                this.f35714h = null;
            }
        } catch (Exception e11) {
            o0.a("MIMManager", e11.getMessage());
        }
    }
}
