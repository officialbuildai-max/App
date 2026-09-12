package com.mbridge.msdk.click;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.click.entity.JumpLoaderResult;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.k0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.s0;
import com.mbridge.msdk.foundation.tools.z0;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.LoadingActivity;
import com.mbridge.msdk.out.NativeListener;
import com.mbridge.msdk.scheme.applet.AppletSchemeCallBack;
import com.mbridge.msdk.scheme.applet.AppletsModel;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;
import org.mvel2.ast.ASTNode;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: n, reason: collision with root package name */
    public static boolean f34320n;

    /* renamed from: o, reason: collision with root package name */
    public static Map<String, Long> f34321o = new HashMap();

    /* renamed from: p, reason: collision with root package name */
    public static Set<String> f34322p = new HashSet();

    /* renamed from: a, reason: collision with root package name */
    private String f34323a;

    /* renamed from: b, reason: collision with root package name */
    private long f34324b;

    /* renamed from: c, reason: collision with root package name */
    private com.mbridge.msdk.foundation.db.g f34325c;

    /* renamed from: d, reason: collision with root package name */
    private Context f34326d;

    /* renamed from: e, reason: collision with root package name */
    private com.mbridge.msdk.click.e f34327e;

    /* renamed from: g, reason: collision with root package name */
    private final com.mbridge.msdk.foundation.same.report.h f34329g;

    /* renamed from: h, reason: collision with root package name */
    private com.mbridge.msdk.setting.g f34330h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f34331i;

    /* renamed from: l, reason: collision with root package name */
    private boolean f34334l;

    /* renamed from: m, reason: collision with root package name */
    private j f34335m;

    /* renamed from: f, reason: collision with root package name */
    private NativeListener.NativeTrackingListener f34328f = null;

    /* renamed from: j, reason: collision with root package name */
    private boolean f34332j = false;

    /* renamed from: k, reason: collision with root package name */
    private boolean f34333k = true;

    /* renamed from: com.mbridge.msdk.click.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    class C0474a implements g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f34336a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f34337b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f34338c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CampaignEx f34339d;

        C0474a(int i11, String str, int i12, CampaignEx campaignEx) {
            this.f34336a = i11;
            this.f34337b = str;
            this.f34338c = i12;
            this.f34339d = campaignEx;
        }

        @Override // com.mbridge.msdk.click.g
        public void a(Object obj) {
            try {
                com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                eVar.a("result", 2);
                eVar.a("net_ty", String.valueOf(this.f34336a));
                if (obj != null && (obj instanceof JumpLoaderResult)) {
                    JumpLoaderResult jumpLoaderResult = (JumpLoaderResult) obj;
                    String str = jumpLoaderResult.getStatusCode() + "";
                    eVar.a("status_code", str);
                    if (str.startsWith("2")) {
                        eVar.a("result", 1);
                    } else {
                        String exceptionMsg = jumpLoaderResult.getExceptionMsg();
                        if (TextUtils.isEmpty(exceptionMsg)) {
                            exceptionMsg = "UNKNOWN EXCEPTION and Status Code is : " + str;
                        }
                        eVar.a("failingURL", z0.d(this.f34337b));
                        eVar.a("reason", exceptionMsg);
                    }
                }
                String b11 = a.b(this.f34338c);
                if (this.f34339d != null) {
                    com.mbridge.msdk.foundation.same.report.metrics.d.b().a(b11, this.f34339d, eVar);
                }
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("CommonClickControl", e11.getMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.click.g
        public void a(Object obj, String str) {
            try {
                String b11 = a.b(this.f34338c);
                com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                eVar.a("result", 2);
                if (obj instanceof JumpLoaderResult) {
                    JumpLoaderResult jumpLoaderResult = (JumpLoaderResult) obj;
                    String exceptionMsg = jumpLoaderResult.getExceptionMsg();
                    if (!TextUtils.isEmpty(exceptionMsg)) {
                        str = exceptionMsg;
                    }
                    eVar.a("reason", str);
                    eVar.a("status_code", Integer.valueOf(jumpLoaderResult.getStatusCode()));
                }
                eVar.a("code", "");
                eVar.a("failingURL", z0.d(this.f34337b));
                eVar.a("net_ty", String.valueOf(this.f34336a));
                if (this.f34339d != null) {
                    com.mbridge.msdk.foundation.same.report.metrics.d.b().a(b11, this.f34339d, eVar);
                }
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("CommonClickControl", e11.getMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.click.g
        public void b(Object obj) {
        }
    }

    /* loaded from: classes5.dex */
    class b implements g {
        b() {
        }

        @Override // com.mbridge.msdk.click.g
        public void a(Object obj) {
        }

        @Override // com.mbridge.msdk.click.g
        public void a(Object obj, String str) {
        }

        @Override // com.mbridge.msdk.click.g
        public void b(Object obj) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f34340a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f34341b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ CampaignEx f34342c;

        c(boolean z10, boolean z11, CampaignEx campaignEx) {
            this.f34340a = z10;
            this.f34341b = z11;
            this.f34342c = campaignEx;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f34340a && !a.f34320n && !a.this.f34334l && MBridgeConstans.NATIVE_SHOW_LOADINGPAGER && !this.f34341b) {
                a.this.c(this.f34342c);
            }
            if (this.f34340a || a.this.f34328f == null || a.f34320n || a.this.f34334l || !MBridgeConstans.NATIVE_SHOW_LOADINGPAGER) {
                return;
            }
            a.this.f34328f.onShowLoading(this.f34342c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class d implements g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignEx f34344a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f34345b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Boolean f34346c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f34347d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f34348e;

        d(CampaignEx campaignEx, boolean z10, Boolean bool, List list, boolean z11) {
            this.f34344a = campaignEx;
            this.f34345b = z10;
            this.f34346c = bool;
            this.f34347d = list;
            this.f34348e = z11;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0086 A[Catch: all -> 0x0080, TryCatch #0 {all -> 0x0080, blocks: (B:7:0x0064, B:9:0x0072, B:10:0x0082, B:12:0x0086, B:14:0x0090, B:15:0x0098), top: B:6:0x0064 }] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0072 A[Catch: all -> 0x0080, TryCatch #0 {all -> 0x0080, blocks: (B:7:0x0064, B:9:0x0072, B:10:0x0082, B:12:0x0086, B:14:0x0090, B:15:0x0098), top: B:6:0x0064 }] */
        /* JADX WARN: Type inference failed for: r1v15 */
        /* JADX WARN: Type inference failed for: r1v16, types: [int] */
        /* JADX WARN: Type inference failed for: r1v25 */
        @Override // com.mbridge.msdk.click.g
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void a(java.lang.Object r12) {
            /*
                r11 = this;
                java.util.Set<java.lang.String> r0 = com.mbridge.msdk.click.a.f34322p
                if (r0 == 0) goto Ld
                com.mbridge.msdk.foundation.entity.CampaignEx r1 = r11.f34344a
                java.lang.String r1 = r1.getId()
                r0.remove(r1)
            Ld:
                java.lang.String r0 = "CommonClickControl"
                r1 = 0
                if (r12 == 0) goto L64
                boolean r2 = r12 instanceof com.mbridge.msdk.click.entity.JumpLoaderResult     // Catch: java.lang.Throwable -> L58
                if (r2 == 0) goto L64
                com.mbridge.msdk.click.entity.JumpLoaderResult r12 = (com.mbridge.msdk.click.entity.JumpLoaderResult) r12     // Catch: java.lang.Throwable -> L58
                com.mbridge.msdk.foundation.entity.CampaignEx r1 = r11.f34344a     // Catch: java.lang.Throwable -> L4b
                r1.setJumpResult(r12)     // Catch: java.lang.Throwable -> L4b
                com.mbridge.msdk.click.a r3 = com.mbridge.msdk.click.a.this     // Catch: java.lang.Throwable -> L4b
                com.mbridge.msdk.foundation.entity.CampaignEx r4 = r11.f34344a     // Catch: java.lang.Throwable -> L4b
                boolean r6 = r11.f34345b     // Catch: java.lang.Throwable -> L4b
                boolean r7 = com.mbridge.msdk.click.a.d(r3)     // Catch: java.lang.Throwable -> L4b
                java.lang.Boolean r8 = r11.f34346c     // Catch: java.lang.Throwable -> L4b
                java.util.List r9 = r11.f34347d     // Catch: java.lang.Throwable -> L4b
                r5 = r12
                com.mbridge.msdk.click.a.a(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L4b
                boolean r1 = r12.isjumpDone()     // Catch: java.lang.Throwable -> L4b
                if (r1 == 0) goto L4d
                com.mbridge.msdk.click.a r1 = com.mbridge.msdk.click.a.this     // Catch: java.lang.Throwable -> L4b
                com.mbridge.msdk.foundation.db.g r1 = com.mbridge.msdk.click.a.e(r1)     // Catch: java.lang.Throwable -> L4b
                com.mbridge.msdk.foundation.db.d r1 = com.mbridge.msdk.foundation.db.d.a(r1)     // Catch: java.lang.Throwable -> L4b
                com.mbridge.msdk.foundation.entity.CampaignEx r2 = r11.f34344a     // Catch: java.lang.Throwable -> L4b
                com.mbridge.msdk.click.a r3 = com.mbridge.msdk.click.a.this     // Catch: java.lang.Throwable -> L4b
                java.lang.String r3 = com.mbridge.msdk.click.a.f(r3)     // Catch: java.lang.Throwable -> L4b
                com.mbridge.msdk.click.b.a(r1, r2, r3)     // Catch: java.lang.Throwable -> L4b
                goto L4d
            L4b:
                r1 = move-exception
                goto L5c
            L4d:
                com.mbridge.msdk.click.a r1 = com.mbridge.msdk.click.a.this     // Catch: java.lang.Throwable -> L4b
                boolean r2 = r11.f34348e     // Catch: java.lang.Throwable -> L4b
                com.mbridge.msdk.foundation.entity.CampaignEx r3 = r11.f34344a     // Catch: java.lang.Throwable -> L4b
                com.mbridge.msdk.click.a.a(r1, r2, r3)     // Catch: java.lang.Throwable -> L4b
            L56:
                r1 = r12
                goto L64
            L58:
                r12 = move-exception
                r10 = r1
                r1 = r12
                r12 = r10
            L5c:
                java.lang.String r1 = r1.getMessage()
                com.mbridge.msdk.foundation.tools.o0.b(r0, r1)
                goto L56
            L64:
                com.mbridge.msdk.foundation.same.report.metrics.e r12 = new com.mbridge.msdk.foundation.same.report.metrics.e     // Catch: java.lang.Throwable -> L80
                r12.<init>()     // Catch: java.lang.Throwable -> L80
                java.lang.String r2 = "result"
                java.lang.String r3 = "1"
                r12.a(r2, r3)     // Catch: java.lang.Throwable -> L80
                if (r1 == 0) goto L82
                java.lang.String r2 = "status_code"
                int r1 = r1.getStatusCode()     // Catch: java.lang.Throwable -> L80
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Throwable -> L80
                r12.a(r2, r1)     // Catch: java.lang.Throwable -> L80
                goto L82
            L80:
                r12 = move-exception
                goto Lad
            L82:
                com.mbridge.msdk.foundation.entity.CampaignEx r1 = r11.f34344a     // Catch: java.lang.Throwable -> L80
                if (r1 == 0) goto L97
                java.lang.String r1 = r1.getClickURL()     // Catch: java.lang.Throwable -> L80
                boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L80
                if (r2 != 0) goto L97
                java.lang.String r2 = "tcp"
                boolean r1 = r1.startsWith(r2)     // Catch: java.lang.Throwable -> L80
                goto L98
            L97:
                r1 = -1
            L98:
                java.lang.String r2 = "net_ty"
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Throwable -> L80
                r12.a(r2, r1)     // Catch: java.lang.Throwable -> L80
                com.mbridge.msdk.foundation.same.report.metrics.d r1 = com.mbridge.msdk.foundation.same.report.metrics.d.b()     // Catch: java.lang.Throwable -> L80
                java.lang.String r2 = "2000138"
                com.mbridge.msdk.foundation.entity.CampaignEx r3 = r11.f34344a     // Catch: java.lang.Throwable -> L80
                r1.a(r2, r3, r12)     // Catch: java.lang.Throwable -> L80
                goto Lb8
            Lad:
                boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG
                if (r1 == 0) goto Lb8
                java.lang.String r12 = r12.getMessage()
                com.mbridge.msdk.foundation.tools.o0.b(r0, r12)
            Lb8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.a.d.a(java.lang.Object):void");
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0052 A[Catch: all -> 0x0063, TryCatch #0 {all -> 0x0063, blocks: (B:11:0x004e, B:13:0x0052, B:15:0x005c, B:16:0x0066, B:18:0x007d, B:19:0x008a), top: B:10:0x004e }] */
        /* JADX WARN: Removed duplicated region for block: B:18:0x007d A[Catch: all -> 0x0063, TryCatch #0 {all -> 0x0063, blocks: (B:11:0x004e, B:13:0x0052, B:15:0x005c, B:16:0x0066, B:18:0x007d, B:19:0x008a), top: B:10:0x004e }] */
        /* JADX WARN: Type inference failed for: r6v10, types: [int] */
        /* JADX WARN: Type inference failed for: r6v21 */
        /* JADX WARN: Type inference failed for: r6v9 */
        @Override // com.mbridge.msdk.click.g
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void a(java.lang.Object r6, java.lang.String r7) {
            /*
                r5 = this;
                java.util.Set<java.lang.String> r0 = com.mbridge.msdk.click.a.f34322p
                if (r0 == 0) goto Ld
                com.mbridge.msdk.foundation.entity.CampaignEx r1 = r5.f34344a
                java.lang.String r1 = r1.getId()
                r0.remove(r1)
            Ld:
                java.lang.String r0 = "CommonClickControl"
                r1 = 0
                if (r6 == 0) goto L2a
                boolean r2 = r6 instanceof com.mbridge.msdk.click.entity.JumpLoaderResult     // Catch: java.lang.Throwable -> L28
                if (r2 == 0) goto L2a
                r2 = r6
                com.mbridge.msdk.click.entity.JumpLoaderResult r2 = (com.mbridge.msdk.click.entity.JumpLoaderResult) r2     // Catch: java.lang.Throwable -> L28
                com.mbridge.msdk.click.a r1 = com.mbridge.msdk.click.a.this     // Catch: java.lang.Throwable -> L25
                com.mbridge.msdk.click.entity.JumpLoaderResult r6 = (com.mbridge.msdk.click.entity.JumpLoaderResult) r6     // Catch: java.lang.Throwable -> L25
                com.mbridge.msdk.foundation.entity.CampaignEx r3 = r5.f34344a     // Catch: java.lang.Throwable -> L25
                r4 = 1
                com.mbridge.msdk.click.a.a(r1, r6, r3, r4)     // Catch: java.lang.Throwable -> L25
                r1 = r2
                goto L2a
            L25:
                r6 = move-exception
                r1 = r2
                goto L47
            L28:
                r6 = move-exception
                goto L47
            L2a:
                com.mbridge.msdk.click.a r6 = com.mbridge.msdk.click.a.this     // Catch: java.lang.Throwable -> L28
                com.mbridge.msdk.out.NativeListener$NativeTrackingListener r6 = com.mbridge.msdk.click.a.c(r6)     // Catch: java.lang.Throwable -> L28
                if (r6 == 0) goto L3d
                com.mbridge.msdk.click.a r6 = com.mbridge.msdk.click.a.this     // Catch: java.lang.Throwable -> L28
                com.mbridge.msdk.out.NativeListener$NativeTrackingListener r6 = com.mbridge.msdk.click.a.c(r6)     // Catch: java.lang.Throwable -> L28
                com.mbridge.msdk.foundation.entity.CampaignEx r2 = r5.f34344a     // Catch: java.lang.Throwable -> L28
                r6.onRedirectionFailed(r2, r7)     // Catch: java.lang.Throwable -> L28
            L3d:
                com.mbridge.msdk.click.a r6 = com.mbridge.msdk.click.a.this     // Catch: java.lang.Throwable -> L28
                boolean r7 = r5.f34348e     // Catch: java.lang.Throwable -> L28
                com.mbridge.msdk.foundation.entity.CampaignEx r2 = r5.f34344a     // Catch: java.lang.Throwable -> L28
                com.mbridge.msdk.click.a.a(r6, r7, r2)     // Catch: java.lang.Throwable -> L28
                goto L4e
            L47:
                java.lang.String r6 = r6.getMessage()
                com.mbridge.msdk.foundation.tools.o0.b(r0, r6)
            L4e:
                com.mbridge.msdk.foundation.entity.CampaignEx r6 = r5.f34344a     // Catch: java.lang.Throwable -> L63
                if (r6 == 0) goto L65
                java.lang.String r6 = r6.getClickURL()     // Catch: java.lang.Throwable -> L63
                boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Throwable -> L63
                if (r7 != 0) goto L65
                java.lang.String r7 = "tcp"
                boolean r6 = r6.startsWith(r7)     // Catch: java.lang.Throwable -> L63
                goto L66
            L63:
                r6 = move-exception
                goto L96
            L65:
                r6 = -1
            L66:
                com.mbridge.msdk.foundation.same.report.metrics.e r7 = new com.mbridge.msdk.foundation.same.report.metrics.e     // Catch: java.lang.Throwable -> L63
                r7.<init>()     // Catch: java.lang.Throwable -> L63
                java.lang.String r2 = "result"
                java.lang.String r3 = "2"
                r7.a(r2, r3)     // Catch: java.lang.Throwable -> L63
                java.lang.String r2 = "net_ty"
                java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> L63
                r7.a(r2, r6)     // Catch: java.lang.Throwable -> L63
                if (r1 == 0) goto L8a
                java.lang.String r6 = "status_code"
                int r1 = r1.getStatusCode()     // Catch: java.lang.Throwable -> L63
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Throwable -> L63
                r7.a(r6, r1)     // Catch: java.lang.Throwable -> L63
            L8a:
                com.mbridge.msdk.foundation.same.report.metrics.d r6 = com.mbridge.msdk.foundation.same.report.metrics.d.b()     // Catch: java.lang.Throwable -> L63
                java.lang.String r1 = "2000138"
                com.mbridge.msdk.foundation.entity.CampaignEx r2 = r5.f34344a     // Catch: java.lang.Throwable -> L63
                r6.a(r1, r2, r7)     // Catch: java.lang.Throwable -> L63
                goto La1
            L96:
                boolean r7 = com.mbridge.msdk.MBridgeConstans.DEBUG
                if (r7 == 0) goto La1
                java.lang.String r6 = r6.getMessage()
                com.mbridge.msdk.foundation.tools.o0.b(r0, r6)
            La1:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.a.d.a(java.lang.Object, java.lang.String):void");
        }

        @Override // com.mbridge.msdk.click.g
        public void b(Object obj) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f34350a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Campaign f34351b;

        e(boolean z10, Campaign campaign) {
            this.f34350a = z10;
            this.f34351b = campaign;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f34350a && !a.f34320n && MBridgeConstans.NATIVE_SHOW_LOADINGPAGER) {
                a.this.a();
            }
            if (a.this.f34328f == null || a.f34320n || !MBridgeConstans.NATIVE_SHOW_LOADINGPAGER) {
                return;
            }
            a.this.f34328f.onDismissLoading(this.f34351b);
        }
    }

    public a(Context context, String str) {
        this.f34325c = null;
        this.f34326d = null;
        com.mbridge.msdk.setting.g d11 = com.mbridge.msdk.setting.h.b().d(str);
        this.f34330h = d11;
        if (d11 == null) {
            this.f34330h = com.mbridge.msdk.setting.h.b().a();
        }
        this.f34331i = this.f34330h.J0();
        Context applicationContext = context.getApplicationContext();
        this.f34326d = applicationContext;
        this.f34323a = str;
        if (this.f34325c == null) {
            this.f34325c = com.mbridge.msdk.foundation.db.g.a(applicationContext);
        }
        this.f34329g = new com.mbridge.msdk.foundation.same.report.h(this.f34326d);
    }

    private AppletSchemeCallBack a(NativeListener.NativeTrackingListener nativeTrackingListener, CampaignEx campaignEx, AppletsModel appletsModel, a aVar) {
        return new h(nativeTrackingListener, campaignEx, appletsModel, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        try {
            Intent intent = new Intent();
            intent.setAction("ExitApp");
            this.f34326d.sendBroadcast(intent);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.b("CommonClickControl", "Exception", e11);
            }
        }
    }

    private static void a(int i11, CampaignEx campaignEx, int i12) {
        if (campaignEx != null) {
            try {
                String b11 = b(i11);
                com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                eVar.a("net_ty", Integer.valueOf(i12));
                eVar.a("result", 3);
                com.mbridge.msdk.foundation.same.report.metrics.d.b().a(b11, campaignEx, eVar);
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    e11.printStackTrace();
                }
            }
        }
    }

    private void a(int i11, String str, CampaignEx campaignEx, NativeListener.NativeTrackingListener nativeTrackingListener, List<String> list) {
        try {
            if (!TextUtils.isEmpty(str)) {
                if (i11 == 2) {
                    s0.a(this.f34326d, str, campaignEx, nativeTrackingListener, list);
                } else {
                    s0.a(this.f34326d, str, nativeTrackingListener, campaignEx, list);
                }
            }
        } catch (Throwable th2) {
            if (MBridgeConstans.DEBUG) {
                o0.b("CommonClickControl", th2.getMessage(), th2);
            }
        }
    }

    public static void a(Context context, CampaignEx campaignEx, String str, String str2, boolean z10, boolean z11) {
        if (context == null) {
            return;
        }
        new com.mbridge.msdk.click.e(context.getApplicationContext()).a(str, campaignEx, null, str2, z10, z11, com.mbridge.msdk.click.retry.a.f34471l);
    }

    public static void a(Context context, CampaignEx campaignEx, String str, String str2, boolean z10, boolean z11, int i11) {
        if (context == null) {
            return;
        }
        int i12 = TextUtils.isEmpty(str2) ? -1 : str2.startsWith("tcp") ? 1 : 0;
        a(i11, campaignEx, i12);
        new com.mbridge.msdk.click.e(context.getApplicationContext()).a(str, campaignEx, new C0474a(i12, str2, i11, campaignEx), str2, z10, z11, i11);
    }

    public static void a(Context context, CampaignEx campaignEx, String str, String[] strArr, boolean z10, boolean z11) {
        if (context == null || campaignEx == null || TextUtils.isEmpty(str) || strArr == null) {
            return;
        }
        com.mbridge.msdk.click.e eVar = new com.mbridge.msdk.click.e(context.getApplicationContext());
        for (String str2 : strArr) {
            eVar.a(str, campaignEx, new b(), str2, z10, z11, com.mbridge.msdk.click.retry.a.f34471l);
        }
    }

    private void a(Context context, CampaignEx campaignEx, List<String> list) {
        if (context == null) {
            com.mbridge.msdk.foundation.same.report.j.a(com.mbridge.msdk.foundation.controller.c.m().d(), campaignEx, 2, "context is null", this.f34323a);
            return;
        }
        boolean z10 = k0.D() == 1;
        boolean z11 = k0.D(context) == 1;
        if (!z10 || !z11) {
            com.mbridge.msdk.foundation.same.report.j.a(context, campaignEx, 2, "integrated:" + z10 + "-hasWx:" + z11, this.f34323a);
            a(campaignEx, list);
            return;
        }
        String ghId = campaignEx.getGhId();
        String ghPath = campaignEx.getGhPath();
        String bindId = campaignEx.getBindId();
        String i11 = com.mbridge.msdk.foundation.controller.c.m().i();
        if (TextUtils.isEmpty(ghId)) {
            a(campaignEx, list);
            com.mbridge.msdk.foundation.same.report.j.a(context, campaignEx, 2, "ghid is empty", this.f34323a);
            return;
        }
        try {
            if (!TextUtils.isEmpty(i11)) {
                bindId = i11;
            }
            Object d11 = k0.d(bindId);
            Class<?> cls = Class.forName("com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram$Req");
            Object newInstance = cls.newInstance();
            cls.getField("userName").set(newInstance, ghId);
            cls.getField("path").set(newInstance, ghPath);
            cls.getField("miniprogramType").set(newInstance, cls.getField("MINIPTOGRAM_TYPE_RELEASE").get(null));
            Class.forName("com.tencent.mm.opensdk.openapi.IWXAPI").getMethod("sendReq", Class.forName("com.tencent.mm.opensdk.modelbase.BaseReq")).invoke(d11, newInstance);
            com.mbridge.msdk.foundation.same.report.j.a(context, campaignEx, 1, "", this.f34323a);
        } catch (Throwable th2) {
            com.mbridge.msdk.foundation.same.report.j.a(context, campaignEx, 2, th2.getMessage(), this.f34323a);
            a(campaignEx, list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JumpLoaderResult jumpLoaderResult, CampaignEx campaignEx, boolean z10) {
        a(jumpLoaderResult, campaignEx, 1, z10);
    }

    private void a(CampaignEx campaignEx, int i11, int i12, List<String> list) {
        try {
            com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
            eVar.a(NativeComponentConstants.KEY_COMPONENT_TYPE, Integer.valueOf(i11));
            eVar.a("result", Integer.valueOf(i12));
            if (list != null) {
                eVar.a("click_path", list.toString());
            }
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000150", campaignEx, eVar);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.b("CommonClickControl", e11.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00f2, code lost:
    
        if (com.mbridge.msdk.foundation.tools.s0.a.a(r16.f34326d, com.cloud.tmc.integration.MiniAppConfigHelper.DEFAULT_JUMP_STORE_DEEPLINK + r17.getPackageName(), r16.f34328f) == false) goto L48;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(com.mbridge.msdk.foundation.entity.CampaignEx r17, com.mbridge.msdk.click.entity.JumpLoaderResult r18, boolean r19, boolean r20, java.lang.Boolean r21, java.util.List<java.lang.String> r22) {
        /*
            Method dump skipped, instructions count: 432
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.entity.CampaignEx, com.mbridge.msdk.click.entity.JumpLoaderResult, boolean, boolean, java.lang.Boolean, java.util.List):void");
    }

    private void a(CampaignEx campaignEx, List<String> list) {
        if (b() == 2) {
            s0.a(this.f34326d, campaignEx.getClickURL(), campaignEx, this.f34328f, list);
        } else {
            s0.a(this.f34326d, campaignEx.getClickURL(), this.f34328f, campaignEx, list);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0102 A[Catch: Exception -> 0x0023, TryCatch #0 {Exception -> 0x0023, blocks: (B:3:0x0006, B:6:0x0013, B:7:0x0027, B:10:0x0033, B:11:0x0042, B:12:0x0047, B:14:0x0059, B:18:0x005f, B:21:0x0076, B:23:0x007b, B:25:0x00ed, B:27:0x0102, B:28:0x0105, B:30:0x0109, B:32:0x0113, B:34:0x0117, B:37:0x0124, B:39:0x0128, B:40:0x012f, B:42:0x008c, B:44:0x0098, B:46:0x00a2, B:49:0x00ab, B:51:0x00ca, B:53:0x00d1, B:54:0x00d4, B:57:0x00da, B:58:0x00e3, B:60:0x00e8), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0128 A[Catch: Exception -> 0x0023, TryCatch #0 {Exception -> 0x0023, blocks: (B:3:0x0006, B:6:0x0013, B:7:0x0027, B:10:0x0033, B:11:0x0042, B:12:0x0047, B:14:0x0059, B:18:0x005f, B:21:0x0076, B:23:0x007b, B:25:0x00ed, B:27:0x0102, B:28:0x0105, B:30:0x0109, B:32:0x0113, B:34:0x0117, B:37:0x0124, B:39:0x0128, B:40:0x012f, B:42:0x008c, B:44:0x0098, B:46:0x00a2, B:49:0x00ab, B:51:0x00ca, B:53:0x00d1, B:54:0x00d4, B:57:0x00da, B:58:0x00e3, B:60:0x00e8), top: B:2:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(com.mbridge.msdk.foundation.entity.CampaignEx r15, boolean r16, java.lang.Boolean r17, java.util.List<java.lang.String> r18) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.entity.CampaignEx, boolean, java.lang.Boolean, java.util.List):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z10, Campaign campaign) {
        new Handler(Looper.getMainLooper()).post(new e(z10, campaign));
    }

    private boolean a(int i11, String str) {
        try {
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        if (i11 == 2) {
            if (s0.a.b(str)) {
            }
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return true;
    }

    private boolean a(CampaignEx campaignEx, JumpLoaderResult jumpLoaderResult, boolean z10, int i11, List<String> list) {
        boolean z11 = true;
        boolean z12 = false;
        if (z10) {
            try {
                int parseInt = Integer.parseInt(campaignEx.getLandingType());
                if (parseInt == 1) {
                    s0.a(this.f34326d, jumpLoaderResult.getUrl(), this.f34328f, campaignEx, list);
                } else if (parseInt == 2) {
                    s0.a(this.f34326d, jumpLoaderResult.getUrl(), campaignEx, this.f34328f, list);
                } else if (campaignEx.getPackageName() != null) {
                    if (s0.a.a(this.f34326d, MiniAppConfigHelper.DEFAULT_JUMP_STORE_DEEPLINK + campaignEx.getPackageName(), this.f34328f)) {
                        if (list != null) {
                            try {
                                list.add("google_play");
                            } catch (Throwable th2) {
                                th = th2;
                                if (MBridgeConstans.DEBUG) {
                                    o0.b("CommonClickControl", th.getMessage(), th);
                                }
                                return z11;
                            }
                        }
                        a(campaignEx, 1, 1, list);
                    } else {
                        a(i11, jumpLoaderResult.getUrl(), campaignEx, this.f34328f, list);
                    }
                } else {
                    a(i11, jumpLoaderResult.getUrl(), campaignEx, this.f34328f, list);
                }
                z12 = true;
            } catch (Throwable th3) {
                th = th3;
                z11 = false;
            }
        }
        if (z12) {
            a(jumpLoaderResult, campaignEx, true);
            NativeListener.NativeTrackingListener nativeTrackingListener = this.f34328f;
            if (nativeTrackingListener == null) {
                return z12;
            }
            nativeTrackingListener.onFinishRedirection(campaignEx, jumpLoaderResult.getUrl());
            return z12;
        }
        a(jumpLoaderResult, campaignEx, true);
        NativeListener.NativeTrackingListener nativeTrackingListener2 = this.f34328f;
        if (nativeTrackingListener2 == null || !z10) {
            return z12;
        }
        nativeTrackingListener2.onRedirectionFailed(campaignEx, jumpLoaderResult.getUrl());
        return z12;
    }

    private boolean a(CampaignEx campaignEx, JumpLoaderResult jumpLoaderResult, boolean z10, List<String> list) {
        boolean z11 = false;
        if (z10) {
            try {
                if (com.mbridge.msdk.util.b.a()) {
                    com.mbridge.msdk.click.b.a(this.f34326d, this.f34323a, campaignEx, campaignEx.getNoticeUrl(), com.mbridge.msdk.foundation.same.a.M);
                }
                s0.a(this.f34326d, campaignEx.getClickURL(), this.f34328f, campaignEx, list);
                z11 = true;
            } catch (Throwable th2) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("CommonClickControl", th2.getMessage(), th2);
                }
            }
        }
        a(jumpLoaderResult, campaignEx, true);
        if (z11) {
            NativeListener.NativeTrackingListener nativeTrackingListener = this.f34328f;
            if (nativeTrackingListener != null) {
                nativeTrackingListener.onFinishRedirection(campaignEx, jumpLoaderResult.getUrl());
            }
        } else {
            if (com.mbridge.msdk.util.b.a()) {
                a(jumpLoaderResult, campaignEx, true);
            }
            NativeListener.NativeTrackingListener nativeTrackingListener2 = this.f34328f;
            if (nativeTrackingListener2 != null) {
                nativeTrackingListener2.onRedirectionFailed(campaignEx, jumpLoaderResult.getUrl());
            }
        }
        return z11;
    }

    private int b() {
        try {
            com.mbridge.msdk.setting.g gVar = this.f34330h;
            if (gVar != null) {
                return gVar.V();
            }
            return 1;
        } catch (Exception e11) {
            e11.printStackTrace();
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(int i11) {
        return i11 != 1 ? i11 != 2 ? i11 != 3 ? i11 != 4 ? "" : "2000138" : "2000139" : "2000137" : "2000136";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(CampaignEx campaignEx) {
        try {
            Intent intent = new Intent(this.f34326d, (Class<?>) LoadingActivity.class);
            intent.setFlags(ASTNode.DEOP);
            intent.putExtra("icon_url", campaignEx.getIconUrl());
            this.f34326d.startActivity(intent);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.b("CommonClickControl", "Exception", e11);
            }
        }
    }

    public void a(JumpLoaderResult jumpLoaderResult, CampaignEx campaignEx, int i11, boolean z10) {
        if (campaignEx == null || jumpLoaderResult == null) {
            return;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis() - this.f34324b;
            com.mbridge.msdk.foundation.entity.e eVar = new com.mbridge.msdk.foundation.entity.e();
            int s11 = k0.s(this.f34326d);
            eVar.e(s11);
            eVar.h(k0.a(this.f34326d, s11));
            eVar.i(campaignEx.getRequestId());
            eVar.j(campaignEx.getRequestIdNotice());
            eVar.a(i11);
            eVar.c(currentTimeMillis + "");
            eVar.a(campaignEx.getId());
            eVar.f(jumpLoaderResult.getType());
            if (!TextUtils.isEmpty(jumpLoaderResult.getUrl())) {
                eVar.g(URLEncoder.encode(jumpLoaderResult.getUrl(), "utf-8"));
            }
            eVar.b((this.f34324b / 1000) + "");
            eVar.c(Integer.parseInt(campaignEx.getLandingType()));
            eVar.d(campaignEx.getLinkType());
            eVar.k(this.f34323a);
            eVar.f(jumpLoaderResult.getType());
            if (!TextUtils.isEmpty(jumpLoaderResult.getUrl())) {
                eVar.g(URLEncoder.encode(jumpLoaderResult.getUrl(), "utf-8"));
            }
            if (this.f34331i) {
                eVar.b(jumpLoaderResult.getStatusCode());
                if (!TextUtils.isEmpty(jumpLoaderResult.getHeader())) {
                    eVar.f(URLEncoder.encode(jumpLoaderResult.getHeader(), "utf-8"));
                }
                if (!TextUtils.isEmpty(jumpLoaderResult.getContent())) {
                    eVar.d(URLEncoder.encode(jumpLoaderResult.getContent(), "UTF-8"));
                }
                if (!TextUtils.isEmpty(jumpLoaderResult.getExceptionMsg())) {
                    eVar.e(URLEncoder.encode(jumpLoaderResult.getExceptionMsg(), "utf-8"));
                }
            }
            if (z10) {
                this.f34329g.a("click_jump_error", eVar, this.f34323a);
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(eVar);
            ArrayList<JSONObject> a11 = com.mbridge.msdk.foundation.entity.e.a(arrayList);
            if (a11 == null || a11.isEmpty()) {
                return;
            }
            Iterator<JSONObject> it = a11.iterator();
            while (it.hasNext()) {
                com.mbridge.msdk.foundation.same.report.metrics.d.b().a(it.next());
            }
        } catch (Throwable th2) {
            o0.b("CommonClickControl", th2.getMessage());
        }
    }

    public void a(j jVar) {
        this.f34335m = jVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:139:0x02aa A[Catch: all -> 0x003d, TryCatch #1 {all -> 0x003d, blocks: (B:6:0x0009, B:9:0x0010, B:11:0x0033, B:13:0x0039, B:14:0x0040, B:15:0x0048, B:18:0x0062, B:20:0x007a, B:22:0x007e, B:23:0x0085, B:25:0x00a2, B:26:0x00a9, B:28:0x00ad, B:29:0x00c3, B:31:0x00cc, B:33:0x00d0, B:34:0x00d7, B:36:0x00e7, B:40:0x00f1, B:42:0x00f7, B:44:0x00fd, B:46:0x0109, B:48:0x010d, B:49:0x0114, B:51:0x0118, B:53:0x0122, B:56:0x0129, B:58:0x012d, B:59:0x0134, B:61:0x0151, B:64:0x0159, B:65:0x0169, B:67:0x016f, B:69:0x0173, B:70:0x017a, B:72:0x0184, B:74:0x018a, B:76:0x0190, B:78:0x019a, B:79:0x01a2, B:81:0x01a6, B:82:0x01ad, B:84:0x01b7, B:86:0x01bd, B:87:0x01c4, B:89:0x01ca, B:91:0x01d6, B:93:0x01e5, B:94:0x01ee, B:96:0x01f2, B:97:0x01f9, B:99:0x01ff, B:100:0x0208, B:102:0x020c, B:105:0x0205, B:106:0x0219, B:109:0x0229, B:116:0x0240, B:118:0x024a, B:120:0x0252, B:122:0x025a, B:124:0x0263, B:125:0x026a, B:127:0x0278, B:129:0x027f, B:130:0x0286, B:132:0x028a, B:134:0x029f, B:139:0x02aa, B:141:0x02b2, B:142:0x02b5, B:144:0x02bb, B:146:0x02bf, B:147:0x02c2, B:150:0x02c8, B:152:0x02ce, B:154:0x02d8, B:156:0x02dc, B:158:0x02e0, B:159:0x02e3, B:160:0x02fc, B:162:0x02ee, B:164:0x02f9, B:166:0x0302, B:168:0x0310, B:173:0x0318, B:174:0x0320, B:175:0x0327, B:177:0x032b, B:178:0x032e, B:181:0x0335, B:183:0x033b, B:185:0x0341, B:189:0x0348, B:191:0x0353, B:193:0x035c, B:195:0x0360, B:197:0x0368, B:198:0x036b, B:200:0x0371, B:202:0x0375, B:203:0x0378, B:205:0x037c, B:207:0x0380, B:208:0x0383, B:210:0x0390, B:212:0x0394), top: B:5:0x0009, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0333  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(com.mbridge.msdk.foundation.entity.CampaignEx r18) {
        /*
            Method dump skipped, instructions count: 932
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.entity.CampaignEx):void");
    }

    public void a(CampaignEx campaignEx, NativeListener.NativeAdListener nativeAdListener) {
        if (nativeAdListener != null && campaignEx != null) {
            nativeAdListener.onAdClick(campaignEx);
        }
        a(campaignEx);
    }

    public void a(Campaign campaign, String str) {
        try {
            if (!TextUtils.isEmpty(str) && campaign != null) {
                CampaignEx campaignEx = campaign instanceof CampaignEx ? (CampaignEx) campaign : null;
                if (!str.startsWith("market://") && !str.startsWith("https://play.google.com/")) {
                    com.mbridge.msdk.click.b.a(str, this.f34326d, this.f34323a, campaignEx, this.f34328f);
                    return;
                }
                if (s0.a.a(this.f34326d, str, this.f34328f) || campaignEx == null) {
                    return;
                }
                if (TextUtils.isEmpty(campaignEx.getPackageName())) {
                    if (b() == 2) {
                        s0.a(this.f34326d, campaignEx.getClickURL(), campaignEx, this.f34328f, new ArrayList());
                        return;
                    } else {
                        s0.a(this.f34326d, campaignEx.getClickURL(), this.f34328f, campaignEx, new ArrayList());
                        return;
                    }
                }
                s0.a.a(this.f34326d, MiniAppConfigHelper.DEFAULT_JUMP_STORE_DEEPLINK + campaignEx.getPackageName(), this.f34328f);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void a(NativeListener.NativeTrackingListener nativeTrackingListener) {
        this.f34328f = nativeTrackingListener;
    }

    public void a(String str) {
        this.f34323a = str;
    }

    public void a(boolean z10) {
        this.f34333k = z10;
    }

    public boolean b(CampaignEx campaignEx) {
        Long l11;
        if (campaignEx == null) {
            return true;
        }
        try {
            if (2 != campaignEx.getLinkType() && 3 != campaignEx.getLinkType()) {
                return true;
            }
            String id2 = campaignEx.getId();
            Map<String, Long> map = f34321o;
            if (map == null) {
                return true;
            }
            if (map.containsKey(id2) && (l11 = f34321o.get(id2)) != null) {
                if (l11.longValue() > System.currentTimeMillis() || f34322p.contains(campaignEx.getId())) {
                    return false;
                }
            }
            f34321o.put(campaignEx.getId(), Long.valueOf(System.currentTimeMillis() + (campaignEx.getClickTimeOutInterval() * 1000)));
            return true;
        } catch (Exception e11) {
            if (!MBridgeConstans.DEBUG) {
                return true;
            }
            e11.printStackTrace();
            return true;
        }
    }

    public void c() {
        try {
            this.f34328f = null;
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }
}
