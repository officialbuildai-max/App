package com.bykv.vk.openvk.preload.geckox;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bykv.vk.openvk.preload.b.d;
import com.bykv.vk.openvk.preload.geckox.logger.GeckoLogger;
import com.bykv.vk.openvk.preload.geckox.model.CheckRequestBodyModel;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private com.bykv.vk.openvk.preload.falconx.a.a f20655a;

    /* renamed from: b, reason: collision with root package name */
    private Queue<String> f20656b;

    /* renamed from: c, reason: collision with root package name */
    private b f20657c;

    /* renamed from: d, reason: collision with root package name */
    private File f20658d;

    private a(b bVar) {
        new ArrayList();
        this.f20655a = new com.bykv.vk.openvk.preload.falconx.a.a();
        this.f20656b = new LinkedBlockingQueue();
        this.f20657c = bVar;
        File n11 = bVar.n();
        this.f20658d = n11;
        n11.mkdirs();
        com.bykv.vk.openvk.preload.geckox.statistic.b.a(this, this.f20657c);
    }

    public static a a(b bVar) {
        List<String> e11 = bVar.e();
        if (e11 == null || e11.isEmpty()) {
            throw new IllegalArgumentException("access key empty");
        }
        bVar.a();
        return new a(bVar);
    }

    private boolean a() {
        List<String> d11 = this.f20657c.d();
        List<String> e11 = this.f20657c.e();
        if (d11 == null || d11.isEmpty() || e11 == null || e11.isEmpty()) {
            return false;
        }
        for (String str : e11) {
            Iterator<String> it = d11.iterator();
            boolean z10 = false;
            while (it.hasNext()) {
                if (TextUtils.equals(str, it.next())) {
                    z10 = true;
                }
            }
            if (!z10) {
                return false;
            }
        }
        return true;
    }

    private boolean b(Map<String, List<CheckRequestBodyModel.TargetChannel>> map) {
        if (map != null && !map.isEmpty()) {
            List<String> e11 = this.f20657c.e();
            for (Map.Entry<String, List<CheckRequestBodyModel.TargetChannel>> entry : map.entrySet()) {
                Iterator<String> it = e11.iterator();
                boolean z10 = false;
                while (it.hasNext()) {
                    if (TextUtils.equals(it.next(), entry.getKey())) {
                        z10 = true;
                    }
                }
                if (!z10) {
                    return false;
                }
            }
        }
        return true;
    }

    static /* synthetic */ void d(a aVar) {
        new ArrayList().addAll(aVar.f20657c.e());
        try {
            String a11 = com.bykv.vk.openvk.preload.geckox.c.b.a().b().a(new com.bykv.vk.openvk.preload.geckox.a.a());
            if (aVar.f20657c.p() != null && aVar.f20657c.p().a()) {
                aVar.f20657c.p();
            } else if (aVar.f20656b.size() < 10) {
                aVar.f20656b.add(a11);
            }
        } catch (Throwable unused) {
        }
    }

    public final void a(Class<? extends d<?, ?>> cls, com.bykv.vk.openvk.preload.b.b.a aVar) {
        this.f20655a.a(cls, aVar);
    }

    public final void a(final Map<String, List<CheckRequestBodyModel.TargetChannel>> map) {
        final String str = "default";
        if (TextUtils.isEmpty("default")) {
            throw new IllegalArgumentException("groupType == null");
        }
        if (!a()) {
            throw new IllegalArgumentException("deployments keys not in local keys");
        }
        if (!b(map)) {
            throw new IllegalArgumentException("target keys not in deployments keys");
        }
        final com.bykv.vk.openvk.preload.geckox.e.a aVar = null;
        final Map map2 = null;
        b.h().execute(new Runnable() { // from class: com.bykv.vk.openvk.preload.geckox.a.1
            @Override // java.lang.Runnable
            public final void run() {
                com.bykv.vk.openvk.preload.geckox.a.a.b bVar;
                GeckoLogger.d("gecko-debug-tag", "start check update...", str);
                if (a.this.f20657c.b() != null) {
                    bVar = a.this.f20657c.b().a();
                    bVar.a(a.this.f20657c.b(), a.this.f20657c.n(), a.this.f20657c.e());
                } else {
                    bVar = null;
                }
                com.bykv.vk.openvk.preload.geckox.a.a.b bVar2 = bVar;
                try {
                    try {
                        a.this.f20657c.a(new JSONObject());
                        GeckoLogger.d("gecko-debug-tag", "update finished", com.bykv.vk.openvk.preload.geckox.h.a.a(aVar, a.this.f20658d, a.this.f20657c, a.this.f20655a, map2, map, str).a((com.bykv.vk.openvk.preload.b.b<Object>) str));
                        if (bVar2 != null) {
                            bVar2.a();
                        }
                        JSONObject f11 = a.this.f20657c.f();
                        if (f11 == null) {
                            f11 = new JSONObject();
                        }
                        try {
                            f11.put("download_duration", SystemClock.elapsedRealtime() - a.this.f20657c.s());
                        } catch (Throwable unused) {
                        }
                        a.this.f20657c.q().upload("download_gecko_end", f11);
                        GeckoLogger.d("gecko-debug-tag", "all channel update finished");
                    } catch (Exception e11) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(NativeComponentConstants.KEY_COMPONENT_RESULT_SUCCESS, false);
                            jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, e11.toString());
                            jSONObject.put("code", 2);
                            a.this.f20657c.a(jSONObject);
                        } catch (Throwable unused2) {
                        }
                        GeckoLogger.w("gecko-debug-tag", "Gecko update failed:", e11);
                        if (bVar2 != null) {
                            bVar2.a();
                        }
                        JSONObject f12 = a.this.f20657c.f();
                        if (f12 == null) {
                            f12 = new JSONObject();
                        }
                        try {
                            f12.put("download_duration", SystemClock.elapsedRealtime() - a.this.f20657c.s());
                        } catch (Throwable unused3) {
                        }
                        a.this.f20657c.q().upload("download_gecko_end", f12);
                        GeckoLogger.d("gecko-debug-tag", "all channel update finished");
                    }
                    a.d(a.this);
                } catch (Throwable th2) {
                    if (bVar2 != null) {
                        bVar2.a();
                    }
                    JSONObject f13 = a.this.f20657c.f();
                    if (f13 == null) {
                        f13 = new JSONObject();
                    }
                    try {
                        f13.put("download_duration", SystemClock.elapsedRealtime() - a.this.f20657c.s());
                    } catch (Throwable unused4) {
                    }
                    a.this.f20657c.q().upload("download_gecko_end", f13);
                    GeckoLogger.d("gecko-debug-tag", "all channel update finished");
                    throw th2;
                }
            }
        });
    }
}
