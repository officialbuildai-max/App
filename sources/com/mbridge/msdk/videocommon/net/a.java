package com.mbridge.msdk.videocommon.net;

import android.content.Context;
import android.text.TextUtils;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.mbridge.msdk.foundation.same.net.wrapper.d;
import com.mbridge.msdk.foundation.same.report.metrics.e;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.setting.h;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f40015a = "com.mbridge.msdk.videocommon.net.a";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mbridge.msdk.videocommon.net.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0576a extends d {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f40016b;

        C0576a(String str) {
            this.f40016b = str;
        }

        @Override // com.mbridge.msdk.foundation.same.net.wrapper.d
        public void a(String str) {
            com.mbridge.msdk.videocommon.setting.b.b().b(false);
            o0.b(a.f40015a, str);
            a.this.a(2, 2, str);
        }

        @Override // com.mbridge.msdk.foundation.same.net.wrapper.d
        public void a(JSONObject jSONObject) {
            try {
                if (t0.a(jSONObject)) {
                    com.mbridge.msdk.videocommon.setting.b.b().b(false);
                    if (jSONObject.optInt("vtag_status", 0) == 1) {
                        String d11 = com.mbridge.msdk.videocommon.setting.b.b().d(this.f40016b);
                        if (!TextUtils.isEmpty(d11)) {
                            try {
                                jSONObject = h.b().a(new JSONObject(d11), jSONObject);
                            } catch (Exception e11) {
                                o0.b(a.f40015a, e11.getMessage());
                            }
                        }
                    }
                    try {
                        jSONObject.put("current_time", System.currentTimeMillis());
                        com.mbridge.msdk.videocommon.setting.b.b().f(this.f40016b, jSONObject.toString());
                    } catch (JSONException e12) {
                        o0.b(a.f40015a, e12.getMessage());
                    }
                } else {
                    com.mbridge.msdk.videocommon.setting.b.b().f(this.f40016b);
                }
                a.this.a(1, 2, "");
            } catch (Throwable th2) {
                o0.b(a.f40015a, th2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b extends d {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f40018b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f40019c;

        /* renamed from: com.mbridge.msdk.videocommon.net.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        class RunnableC0577a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ JSONObject f40021a;

            RunnableC0577a(JSONObject jSONObject) {
                this.f40021a = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.mbridge.msdk.videocommon.setting.b b11 = com.mbridge.msdk.videocommon.setting.b.b();
                b bVar = b.this;
                b11.a(bVar.f40018b, bVar.unitId, this.f40021a.toString());
            }
        }

        b(String str, c cVar) {
            this.f40018b = str;
            this.f40019c = cVar;
        }

        @Override // com.mbridge.msdk.foundation.same.net.wrapper.d
        public void a(String str) {
            try {
                com.mbridge.msdk.videocommon.setting.b.b().e(this.unitId);
            } catch (Exception e11) {
                o0.b(a.f40015a, e11.getMessage());
            }
            if (TextUtils.isEmpty(str)) {
                c cVar = this.f40019c;
                if (cVar != null) {
                    cVar.onFailed("request error");
                }
            } else {
                c cVar2 = this.f40019c;
                if (cVar2 != null) {
                    cVar2.onFailed(str);
                }
            }
            a.this.a(2, 3, str);
        }

        @Override // com.mbridge.msdk.foundation.same.net.wrapper.d
        public void a(JSONObject jSONObject) {
            try {
                try {
                    com.mbridge.msdk.videocommon.setting.b.b().e(this.unitId);
                } catch (Exception e11) {
                    o0.b(a.f40015a, e11.getMessage());
                }
                if (t0.a(jSONObject)) {
                    if (jSONObject.optInt("vtag_status", 0) == 1) {
                        String b11 = com.mbridge.msdk.videocommon.setting.b.b().b(this.f40018b, this.unitId);
                        if (!TextUtils.isEmpty(b11)) {
                            try {
                                jSONObject = h.b().a(new JSONObject(b11), jSONObject);
                            } catch (Exception e12) {
                                o0.b(a.f40015a, e12.getMessage());
                            }
                        }
                    }
                    if (com.mbridge.msdk.videocommon.setting.b.c(jSONObject.toString())) {
                        jSONObject.put("current_time", System.currentTimeMillis());
                        RunnableC0577a runnableC0577a = new RunnableC0577a(jSONObject);
                        if (com.mbridge.msdk.foundation.controller.d.a().e()) {
                            com.mbridge.msdk.foundation.same.threadpool.a.b().execute(runnableC0577a);
                        } else {
                            runnableC0577a.run();
                        }
                        c cVar = this.f40019c;
                        if (cVar != null) {
                            cVar.a("request success");
                        }
                    } else {
                        c cVar2 = this.f40019c;
                        if (cVar2 != null) {
                            cVar2.onFailed("data error");
                        }
                    }
                } else {
                    com.mbridge.msdk.videocommon.setting.b.b().g(this.f40018b, this.unitId);
                }
                a.this.a(1, 3, "");
            } catch (Throwable th2) {
                o0.b(a.f40015a, th2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i11, int i12, String str) {
        try {
            com.mbridge.msdk.foundation.same.report.metrics.c cVar = new com.mbridge.msdk.foundation.same.report.metrics.c();
            e eVar = new e();
            eVar.a("key", "2000112");
            eVar.a("st_net", Integer.valueOf(com.mbridge.msdk.foundation.same.net.utils.d.h().f35541t));
            eVar.a("result", Integer.valueOf(i11));
            eVar.a(NativeComponentConstants.KEY_COMPONENT_TYPE, Integer.valueOf(i12));
            eVar.a("url", com.mbridge.msdk.foundation.same.net.utils.d.h().f35540s ? com.mbridge.msdk.foundation.same.net.utils.d.h().U : com.mbridge.msdk.foundation.same.net.utils.d.h().T);
            eVar.a("reason", str);
            cVar.a("2000112", eVar);
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000112", cVar);
        } catch (Throwable th2) {
            o0.b(f40015a, th2.getMessage());
        }
    }

    public void a(Context context, String str, String str2) {
        com.mbridge.msdk.foundation.same.net.wrapper.e eVar = new com.mbridge.msdk.foundation.same.net.wrapper.e();
        eVar.a("app_id", str);
        eVar.a(TmcConstants.EXTRA_APP_DEV_TOKEN, SameMD5.getMD5(str + str2));
        try {
            com.mbridge.msdk.videocommon.setting.a d11 = com.mbridge.msdk.videocommon.setting.b.b().d();
            if (d11 == null) {
                eVar.a("vtag", "");
            } else {
                String j11 = d11.j();
                if (TextUtils.isEmpty(j11)) {
                    j11 = "";
                }
                eVar.a("vtag", j11);
            }
        } catch (Throwable th2) {
            o0.b(f40015a, th2.getMessage());
        }
        new com.mbridge.msdk.videocommon.net.b(context).get(1, com.mbridge.msdk.foundation.same.net.utils.d.h().T, eVar, new C0576a(str), "setting", 60000L);
        a(3, 2, "");
    }

    public void a(Context context, String str, String str2, String str3, c cVar) {
        com.mbridge.msdk.foundation.same.net.wrapper.e eVar = new com.mbridge.msdk.foundation.same.net.wrapper.e();
        eVar.a("app_id", str);
        eVar.a(TmcConstants.EXTRA_APP_DEV_TOKEN, SameMD5.getMD5(str + str2));
        eVar.a("unit_ids", "[" + str3 + "]");
        try {
            com.mbridge.msdk.videocommon.setting.c d11 = com.mbridge.msdk.videocommon.setting.b.b().d(str, str3);
            if (d11 == null) {
                eVar.a("vtag", "");
            } else {
                String G = d11.G();
                if (TextUtils.isEmpty(G)) {
                    G = "";
                }
                eVar.a("vtag", G);
            }
        } catch (Throwable th2) {
            o0.b(f40015a, th2.getMessage());
        }
        b bVar = new b(str, cVar);
        bVar.setUnitId(str3);
        new com.mbridge.msdk.videocommon.net.b(context).get(1, com.mbridge.msdk.foundation.same.net.utils.d.h().T, eVar, bVar, "setting", 60000L);
        a(3, 3, "");
    }
}
