package com.mbridge.msdk.shake;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.same.report.metrics.d;
import com.mbridge.msdk.foundation.tools.o0;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private SensorManager f37412a;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        static a f37413a = new a();
    }

    private a() {
    }

    public static a a() {
        return b.f37413a;
    }

    private static void a(Context context, String str) {
        if (context != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("key", "2000106");
                if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.V)) {
                    jSONObject.put(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, com.mbridge.msdk.foundation.same.a.V);
                }
                if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.f35389g)) {
                    jSONObject.put("c", com.mbridge.msdk.foundation.same.a.f35389g);
                }
                jSONObject.put("reason", str);
                d.b().a(jSONObject);
            } catch (Throwable th2) {
                o0.b("NativeShakeManager", th2.getMessage());
            }
        }
    }

    public void a(SensorEventListener sensorEventListener) {
        a(sensorEventListener, null, 2);
    }

    public void a(SensorEventListener sensorEventListener, Sensor sensor, int i11) {
        Context d11 = c.m().d();
        if (d11 != null) {
            try {
                if (this.f37412a == null) {
                    this.f37412a = (SensorManager) d11.getSystemService("sensor");
                }
                if (sensor == null) {
                    sensor = this.f37412a.getDefaultSensor(1);
                }
                this.f37412a.registerListener(sensorEventListener, sensor, i11);
            } catch (Exception e11) {
                e11.printStackTrace();
                a(d11, e11.getMessage());
            }
        }
    }

    public void b(SensorEventListener sensorEventListener) {
        SensorManager sensorManager = this.f37412a;
        if (sensorManager != null) {
            try {
                sensorManager.unregisterListener(sensorEventListener);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }
}
