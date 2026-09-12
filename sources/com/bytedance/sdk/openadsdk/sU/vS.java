package com.bytedance.sdk.openadsdk.sU;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.core.app.NotificationCompat;
import com.cloud.tmc.component_api_ps.ipc.constants.MiniAppIpcConfig;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.cloud.tmc.kernel.constants.TmcConstants;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class vS {
    private Context Sj;
    private WeakReference<Dq> sP;
    private Map<String, Sj> TKC = new HashMap();
    private SensorEventListener EjP = new SensorEventListener() { // from class: com.bytedance.sdk.openadsdk.sU.vS.1
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i11) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            Dq EjP;
            if (sensorEvent.sensor.getType() != 1 || (EjP = vS.this.EjP()) == null) {
                return;
            }
            float[] fArr = sensorEvent.values;
            float f11 = fArr[0];
            float f12 = fArr[1];
            float f13 = fArr[2];
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("x", f11);
                jSONObject.put("y", f12);
                jSONObject.put("z", f13);
                EjP.Sj("accelerometer_callback", jSONObject);
            } catch (Throwable unused) {
            }
        }
    };
    private SensorEventListener HiB = new SensorEventListener() { // from class: com.bytedance.sdk.openadsdk.sU.vS.12
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i11) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            Dq EjP;
            if (sensorEvent.sensor.getType() != 4 || (EjP = vS.this.EjP()) == null) {
                return;
            }
            float degrees = (float) Math.toDegrees(sensorEvent.values[0]);
            float degrees2 = (float) Math.toDegrees(sensorEvent.values[1]);
            float degrees3 = (float) Math.toDegrees(sensorEvent.values[2]);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("x", degrees);
                jSONObject.put("y", degrees2);
                jSONObject.put("z", degrees3);
                EjP.Sj("gyro_callback", jSONObject);
            } catch (Throwable unused) {
            }
        }
    };
    private SensorEventListener vS = new SensorEventListener() { // from class: com.bytedance.sdk.openadsdk.sU.vS.23
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i11) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            Dq EjP;
            if (sensorEvent.sensor.getType() != 10 || (EjP = vS.this.EjP()) == null) {
                return;
            }
            float[] fArr = sensorEvent.values;
            float f11 = fArr[0];
            float f12 = fArr[1];
            float f13 = fArr[2];
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("x", f11);
                jSONObject.put("y", f12);
                jSONObject.put("z", f13);
                EjP.Sj("accelerometer_grativityless_callback", jSONObject);
            } catch (Throwable unused) {
            }
        }
    };
    private SensorEventListener Jcg = new SensorEventListener() { // from class: com.bytedance.sdk.openadsdk.sU.vS.34
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i11) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.sensor.getType() == 1) {
                float[] fArr = sensorEvent.values;
                float[] fArr2 = TEQ.sP;
                System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            } else if (sensorEvent.sensor.getType() == 2) {
                float[] fArr3 = sensorEvent.values;
                float[] fArr4 = TEQ.TKC;
                System.arraycopy(fArr3, 0, fArr4, 0, fArr4.length);
            }
            float[] fArr5 = TEQ.EjP;
            SensorManager.getRotationMatrix(fArr5, null, TEQ.sP, TEQ.TKC);
            float[] fArr6 = TEQ.HiB;
            SensorManager.getOrientation(fArr5, fArr6);
            Dq EjP = vS.this.EjP();
            if (EjP == null) {
                return;
            }
            float f11 = fArr6[0];
            float f12 = fArr6[1];
            float f13 = fArr6[2];
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("alpha", f11);
                jSONObject.put("beta", f12);
                jSONObject.put("gamma", f13);
                EjP.Sj("rotation_vector_callback", jSONObject);
            } catch (Throwable unused) {
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface Sj {
        JSONObject Sj(JSONObject jSONObject) throws Throwable;
    }

    public vS(Dq dq2) {
        this.Sj = dq2.Sj();
        this.sP = new WeakReference<>(dq2);
        TKC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Dq EjP() {
        WeakReference<Dq> weakReference = this.sP;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.openadsdk.sU.Sj HiB() {
        Dq EjP = EjP();
        if (EjP == null) {
            return null;
        }
        return EjP.dNu();
    }

    private void TKC() {
        this.TKC.put("adInfo", new Sj() { // from class: com.bytedance.sdk.openadsdk.sU.vS.45
            @Override // com.bytedance.sdk.openadsdk.sU.vS.Sj
            public JSONObject Sj(JSONObject jSONObject) throws Throwable {
                Dq EjP = vS.this.EjP();
                if (EjP == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject RiZ = EjP.RiZ();
                if (RiZ != null) {
                    RiZ.put("code", 1);
                    return RiZ;
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("code", -1);
                return jSONObject3;
            }
        });
        this.TKC.put(TmcConstants.EXTRA_APPINFO, new Sj() { // from class: com.bytedance.sdk.openadsdk.sU.vS.56
            @Override // com.bytedance.sdk.openadsdk.sU.vS.Sj
            public JSONObject Sj(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", 1);
                jSONObject2.put(MiniAppIpcConfig.IPC_ADDHOME_APP_NAME, "playable_sdk");
                jSONObject2.put("playableSdkEdition", "6.6.0");
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = vS.this.Sj().iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
                jSONObject2.put("supportList", jSONArray);
                Dq EjP = vS.this.EjP();
                if (EjP != null) {
                    jSONObject2.put("deviceId", EjP.Jcg());
                    jSONObject2.put("netType", EjP.uvD());
                    jSONObject2.put("innerAppName", EjP.EjP());
                    jSONObject2.put(MiniAppIpcConfig.IPC_ADDHOME_APP_NAME, EjP.HiB());
                    jSONObject2.put(TmcStartParams.KEY_APP_VERSION, EjP.vS());
                    Map<String, String> sP = EjP.sP();
                    for (String str : sP.keySet()) {
                        jSONObject2.put(str, sP.get(str));
                    }
                }
                return jSONObject2;
            }
        });
        this.TKC.put("playableSDKInfo", new Sj() { // from class: com.bytedance.sdk.openadsdk.sU.vS.61
            @Override // com.bytedance.sdk.openadsdk.sU.vS.Sj
            public JSONObject Sj(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", 1);
                jSONObject2.put(MiniAppIpcConfig.IPC_ADDHOME_APP_NAME, "playable_sdk");
                jSONObject2.put("playableSdkEdition", "6.6.0");
                jSONObject2.put("os", "android");
                return jSONObject2;
            }
        });
        this.TKC.put("subscribe_app_ad", new Sj() { // from class: com.bytedance.sdk.openadsdk.sU.vS.62
            @Override // com.bytedance.sdk.openadsdk.sU.vS.Sj
            public JSONObject Sj(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.sU.Sj HiB = vS.this.HiB();
                JSONObject jSONObject2 = new JSONObject();
                if (HiB == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.TKC.put("download_app_ad", new Sj() { // from class: com.bytedance.sdk.openadsdk.sU.vS.63
            @Override // com.bytedance.sdk.openadsdk.sU.vS.Sj
            public JSONObject Sj(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.sU.Sj HiB = vS.this.HiB();
                JSONObject jSONObject2 = new JSONObject();
                if (HiB == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.TKC.put("isViewable", new Sj() { // from class: com.bytedance.sdk.openadsdk.sU.vS.2
            @Override // com.bytedance.sdk.openadsdk.sU.vS.Sj
            public JSONObject Sj(JSONObject jSONObject) throws Throwable {
                Dq EjP = vS.this.EjP();
                if (EjP == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("code", 1);
                jSONObject3.put("viewStatus", EjP.uA());
                return jSONObject3;
            }
        });
        this.TKC.put("getVolume", new Sj() { // from class: com.bytedance.sdk.openadsdk.sU.vS.3
            @Override // com.bytedance.sdk.openadsdk.sU.vS.Sj
            public JSONObject Sj(JSONObject jSONObject) throws Throwable {
                Dq EjP = vS.this.EjP();
                if (EjP == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("code", 1);
                jSONObject3.put("endcard_mute", EjP.Dq());
                return jSONObject3;
            }
        });
        this.TKC.put("getScreenSize", new Sj() { // from class: com.bytedance.sdk.openadsdk.sU.vS.4
            @Override // com.bytedance.sdk.openadsdk.sU.vS.Sj
            public JSONObject Sj(JSONObject jSONObject) throws Throwable {
                Dq EjP = vS.this.EjP();
                if (EjP == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject TzV = EjP.TzV();
                TzV.put("code", 1);
                return TzV;
            }
        });
        this.TKC.put("start_accelerometer_observer", new Sj() { // from class: com.bytedance.sdk.openadsdk.sU.vS.5
            @Override // com.bytedance.sdk.openadsdk.sU.vS.Sj
            public JSONObject Sj(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                int i11 = 2;
                if (jSONObject != null) {
                    try {
                        i11 = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th2) {
                        Jcg.Sj("PlayableJsBridge", "invoke start_accelerometer_observer error", th2);
                        jSONObject2.put("code", -1);
                        jSONObject2.put("codeMsg", th2.toString());
                        return jSONObject2;
                    }
                }
                TEQ.Sj(vS.this.Sj, vS.this.EjP, i11);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.TKC.put("close_accelerometer_observer", new Sj() { // from class: com.bytedance.sdk.openadsdk.sU.vS.6
            @Override // com.bytedance.sdk.openadsdk.sU.vS.Sj
            public JSONObject Sj(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    TEQ.Sj(vS.this.Sj, vS.this.EjP);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th2) {
                    Jcg.Sj("PlayableJsBridge", "invoke close_accelerometer_observer error", th2);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th2.toString());
                    return jSONObject2;
                }
            }
        });
        this.TKC.put("start_gyro_observer", new Sj() { // from class: com.bytedance.sdk.openadsdk.sU.vS.7
            @Override // com.bytedance.sdk.openadsdk.sU.vS.Sj
            public JSONObject Sj(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                int i11 = 2;
                if (jSONObject != null) {
                    try {
                        i11 = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th2) {
                        Jcg.Sj("PlayableJsBridge", "invoke start_gyro_observer error", th2);
                        jSONObject2.put("code", -1);
                        jSONObject2.put("codeMsg", th2.toString());
                        return jSONObject2;
                    }
                }
                TEQ.sP(vS.this.Sj, vS.this.HiB, i11);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.TKC.put("close_gyro_observer", new Sj() { // from class: com.bytedance.sdk.openadsdk.sU.vS.8
            @Override // com.bytedance.sdk.openadsdk.sU.vS.Sj
            public JSONObject Sj(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    TEQ.Sj(vS.this.Sj, vS.this.HiB);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th2) {
                    Jcg.Sj("PlayableJsBridge", "invoke close_gyro_observer error", th2);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th2.toString());
                    return jSONObject2;
                }
            }
        });
        this.TKC.put("start_accelerometer_grativityless_observer", new Sj() { // from class: com.bytedance.sdk.openadsdk.sU.vS.9
            @Override // com.bytedance.sdk.openadsdk.sU.vS.Sj
            public JSONObject Sj(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                int i11 = 2;
                if (jSONObject != null) {
                    try {
                        i11 = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th2) {
                        Jcg.Sj("PlayableJsBridge", "invoke start_accelerometer_grativityless_observer error", th2);
                        jSONObject2.put("code", -1);
                        jSONObject2.put("codeMsg", th2.toString());
                        return jSONObject2;
                    }
                }
                TEQ.TKC(vS.this.Sj, vS.this.vS, i11);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.TKC.put("close_accelerometer_grativityless_observer", new Sj() { // from class: com.bytedance.sdk.openadsdk.sU.vS.10
            @Override // com.bytedance.sdk.openadsdk.sU.vS.Sj
            public JSONObject Sj(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    TEQ.Sj(vS.this.Sj, vS.this.vS);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th2) {
                    Jcg.Sj("PlayableJsBridge", "invoke close_accelerometer_grativityless_observer error", th2);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th2.toString());
                    return jSONObject2;
                }
            }
        });
        this.TKC.put("start_rotation_vector_observer", new Sj() { // from class: com.bytedance.sdk.openadsdk.sU.vS.11
            @Override // com.bytedance.sdk.openadsdk.sU.vS.Sj
            public JSONObject Sj(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                int i11 = 2;
                if (jSONObject != null) {
                    try {
                        i11 = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th2) {
                        Jcg.Sj("PlayableJsBridge", "invoke start_rotation_vector_observer error", th2);
                        jSONObject2.put("code", -1);
                        jSONObject2.put("codeMsg", th2.toString());
                        return jSONObject2;
                    }
                }
                TEQ.EjP(vS.this.Sj, vS.this.Jcg, i11);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.TKC.put("close_rotation_vector_observer", new Sj() { // from class: com.bytedance.sdk.openadsdk.sU.vS.13
            @Override // com.bytedance.sdk.openadsdk.sU.vS.Sj
            public JSONObject Sj(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    TEQ.Sj(vS.this.Sj, vS.this.Jcg);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th2) {
                    Jcg.Sj("PlayableJsBridge", "invoke close_rotation_vector_observer error", th2);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th2.toString());
                    return jSONObject2;
                }
            }
        });
        this.TKC.put("device_shake", new Sj() { // from class: com.bytedance.sdk.openadsdk.sU.vS.14
            @Override // com.bytedance.sdk.openadsdk.sU.vS.Sj
            public JSONObject Sj(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    TEQ.Sj(vS.this.Sj, 300L);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th2) {
                    Jcg.Sj("PlayableJsBridge", "invoke device_shake error", th2);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th2.toString());
                    return jSONObject2;
                }
            }
        });
        this.TKC.put("device_shake_short", new Sj() { // from class: com.bytedance.sdk.openadsdk.sU.vS.15
            @Override // com.bytedance.sdk.openadsdk.sU.vS.Sj
            public JSONObject Sj(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    TEQ.Sj(vS.this.Sj, 150L);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th2) {
                    Jcg.Sj("PlayableJsBridge", "invoke device_shake error", th2);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th2.toString());
                    return jSONObject2;
                }
            }
        });
        this.TKC.put("playable_style", new Sj() { // from class: com.bytedance.sdk.openadsdk.sU.vS.16
            @Override // com.bytedance.sdk.openadsdk.sU.vS.Sj
            public JSONObject Sj(JSONObject jSONObject) throws Throwable {
                Dq EjP = vS.this.EjP();
                JSONObject jSONObject2 = new JSONObject();
                if (EjP == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject TKC = EjP.TKC();
                TKC.put("code", 1);
                return TKC;
            }
        });
        this.TKC.put("sendReward", new Sj() { // from class: com.bytedance.sdk.openadsdk.sU.vS.17
            @Override // com.bytedance.sdk.openadsdk.sU.vS.Sj
            public JSONObject Sj(JSONObject jSONObject) throws Throwable {
                Dq EjP = vS.this.EjP();
                JSONObject jSONObject2 = new JSONObject();
                if (EjP == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                EjP.dx();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.TKC.put("webview_time_track", new Sj() { // from class: com.bytedance.sdk.openadsdk.sU.vS.18
            @Override // com.bytedance.sdk.openadsdk.sU.vS.Sj
            public JSONObject Sj(JSONObject jSONObject) throws Throwable {
                return new JSONObject();
            }
        });
        this.TKC.put("playable_event", new Sj() { // from class: com.bytedance.sdk.openadsdk.sU.vS.19
            @Override // com.bytedance.sdk.openadsdk.sU.vS.Sj
            public JSONObject Sj(JSONObject jSONObject) throws Throwable {
                Dq EjP = vS.this.EjP();
                JSONObject jSONObject2 = new JSONObject();
                if (EjP == null || jSONObject == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                EjP.sP(jSONObject.optString(NotificationCompat.CATEGORY_EVENT, null), jSONObject.optJSONObject("params"));
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.TKC.put("reportAd", new Sj() { // from class: com.bytedance.sdk.openadsdk.sU.vS.20
            @Override // com.bytedance.sdk.openadsdk.sU.vS.Sj
            public JSONObject Sj(JSONObject jSONObject) throws Throwable {
                Dq EjP = vS.this.EjP();
                JSONObject jSONObject2 = new JSONObject();
                if (EjP == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.TKC.put("close", new Sj() { // from class: com.bytedance.sdk.openadsdk.sU.vS.21
            @Override // com.bytedance.sdk.openadsdk.sU.vS.Sj
            public JSONObject Sj(JSONObject jSONObject) throws Throwable {
                Dq EjP = vS.this.EjP();
                JSONObject jSONObject2 = new JSONObject();
                if (EjP == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.TKC.put("openAdLandPageLinks", new Sj() { // from class: com.bytedance.sdk.openadsdk.sU.vS.22
            @Override // com.bytedance.sdk.openadsdk.sU.vS.Sj
            public JSONObject Sj(JSONObject jSONObject) throws Throwable {
                Dq EjP = vS.this.EjP();
                JSONObject jSONObject2 = new JSONObject();
                if (EjP == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.TKC.put("get_viewport", new Sj() { // from class: com.bytedance.sdk.openadsdk.sU.vS.24
            @Override // com.bytedance.sdk.openadsdk.sU.vS.Sj
            public JSONObject Sj(JSONObject jSONObject) throws Throwable {
                Dq EjP = vS.this.EjP();
                JSONObject jSONObject2 = new JSONObject();
                if (EjP == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject sU = EjP.sU();
                sU.put("code", 1);
                return sU;
            }
        });
        this.TKC.put("jssdk_load_finish", new Sj() { // from class: com.bytedance.sdk.openadsdk.sU.vS.25
            @Override // com.bytedance.sdk.openadsdk.sU.vS.Sj
            public JSONObject Sj(JSONObject jSONObject) throws Throwable {
                Dq EjP = vS.this.EjP();
                JSONObject jSONObject2 = new JSONObject();
                if (EjP == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                EjP.LD();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.TKC.put("playable_material_render_result", new Sj() { // from class: com.bytedance.sdk.openadsdk.sU.vS.26
            @Override // com.bytedance.sdk.openadsdk.sU.vS.Sj
            public JSONObject Sj(JSONObject jSONObject) throws Throwable {
                Dq EjP = vS.this.EjP();
                JSONObject jSONObject2 = new JSONObject();
                if (EjP == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                EjP.uA(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.TKC.put("detect_change_playable_click", new Sj() { // from class: com.bytedance.sdk.openadsdk.sU.vS.27
            @Override // com.bytedance.sdk.openadsdk.sU.vS.Sj
            public JSONObject Sj(JSONObject jSONObject) throws Throwable {
                Dq EjP = vS.this.EjP();
                JSONObject jSONObject2 = new JSONObject();
                if (EjP == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject TEQ = EjP.TEQ();
                TEQ.put("code", 1);
                return TEQ;
            }
        });
        this.TKC.put("check_camera_permission", new Sj() { // from class: com.bytedance.sdk.openadsdk.sU.vS.28
            @Override // com.bytedance.sdk.openadsdk.sU.vS.Sj
            public JSONObject Sj(JSONObject jSONObject) throws Throwable {
                Dq EjP = vS.this.EjP();
                JSONObject jSONObject2 = new JSONObject();
                if (EjP == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject Fmk = EjP.Fmk();
                Fmk.put("code", 1);
                return Fmk;
            }
        });
        this.TKC.put("check_external_storage", new Sj() { // from class: com.bytedance.sdk.openadsdk.sU.vS.29
            @Override // com.bytedance.sdk.openadsdk.sU.vS.Sj
            public JSONObject Sj(JSONObject jSONObject) throws Throwable {
                Dq EjP = vS.this.EjP();
                JSONObject jSONObject2 = new JSONObject();
                if (EjP == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject sef = EjP.sef();
                if (sef.isNull("result")) {
                    sef.put("code", -1);
                } else {
                    sef.put("code", 1);
                }
                return sef;
            }
        });
        this.TKC.put("playable_open_camera", new Sj() { // from class: com.bytedance.sdk.openadsdk.sU.vS.30
            @Override // com.bytedance.sdk.openadsdk.sU.vS.Sj
            public JSONObject Sj(JSONObject jSONObject) throws Throwable {
                Dq EjP = vS.this.EjP();
                JSONObject jSONObject2 = new JSONObject();
                if (EjP == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.TKC.put("playable_pick_photo", new Sj() { // from class: com.bytedance.sdk.openadsdk.sU.vS.31
            @Override // com.bytedance.sdk.openadsdk.sU.vS.Sj
            public JSONObject Sj(JSONObject jSONObject) throws Throwable {
                Dq EjP = vS.this.EjP();
                JSONObject jSONObject2 = new JSONObject();
                if (EjP == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.TKC.put("playable_download_media_in_photos", new Sj() { // from class: com.bytedance.sdk.openadsdk.sU.vS.32
            @Override // com.bytedance.sdk.openadsdk.sU.vS.Sj
            public JSONObject Sj(JSONObject jSONObject) throws Throwable {
                Dq EjP = vS.this.EjP();
                JSONObject jSONObject2 = new JSONObject();
                if (EjP == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                EjP.Sj(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.TKC.put("playable_preventTouchEvent", new Sj() { // from class: com.bytedance.sdk.openadsdk.sU.vS.33
            @Override // com.bytedance.sdk.openadsdk.sU.vS.Sj
            public JSONObject Sj(JSONObject jSONObject) throws Throwable {
                Dq EjP = vS.this.EjP();
                JSONObject jSONObject2 = new JSONObject();
                if (EjP == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                EjP.sP(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.TKC.put("playable_settings_info", new Sj() { // from class: com.bytedance.sdk.openadsdk.sU.vS.35
            @Override // com.bytedance.sdk.openadsdk.sU.vS.Sj
            public JSONObject Sj(JSONObject jSONObject) throws Throwable {
                Dq EjP = vS.this.EjP();
                JSONObject jSONObject2 = new JSONObject();
                if (EjP == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject Zq = EjP.Zq();
                Zq.put("code", 1);
                return Zq;
            }
        });
        this.TKC.put("playable_load_main_scene", new Sj() { // from class: com.bytedance.sdk.openadsdk.sU.vS.36
            @Override // com.bytedance.sdk.openadsdk.sU.vS.Sj
            public JSONObject Sj(JSONObject jSONObject) throws Throwable {
                Dq EjP = vS.this.EjP();
                JSONObject jSONObject2 = new JSONObject();
                if (EjP == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                EjP.zR();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.TKC.put("playable_enter_section", new Sj() { // from class: com.bytedance.sdk.openadsdk.sU.vS.37
            @Override // com.bytedance.sdk.openadsdk.sU.vS.Sj
            public JSONObject Sj(JSONObject jSONObject) throws Throwable {
                Dq EjP = vS.this.EjP();
                JSONObject jSONObject2 = new JSONObject();
                if (EjP == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                EjP.EjP(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.TKC.put("playable_end", new Sj() { // from class: com.bytedance.sdk.openadsdk.sU.vS.38
            @Override // com.bytedance.sdk.openadsdk.sU.vS.Sj
            public JSONObject Sj(JSONObject jSONObject) throws Throwable {
                Dq EjP = vS.this.EjP();
                JSONObject jSONObject2 = new JSONObject();
                if (EjP == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                EjP.ib();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.TKC.put("playable_finish_play_playable", new Sj() { // from class: com.bytedance.sdk.openadsdk.sU.vS.39
            @Override // com.bytedance.sdk.openadsdk.sU.vS.Sj
            public JSONObject Sj(JSONObject jSONObject) throws Throwable {
                Dq EjP = vS.this.EjP();
                JSONObject jSONObject2 = new JSONObject();
                if (EjP == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                EjP.kF();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.TKC.put("playable_transfrom_module_show", new Sj() { // from class: com.bytedance.sdk.openadsdk.sU.vS.40
            @Override // com.bytedance.sdk.openadsdk.sU.vS.Sj
            public JSONObject Sj(JSONObject jSONObject) throws Throwable {
                Dq EjP = vS.this.EjP();
                JSONObject jSONObject2 = new JSONObject();
                if (EjP == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                EjP.uP();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.TKC.put("playable_transfrom_module_change_color", new Sj() { // from class: com.bytedance.sdk.openadsdk.sU.vS.41
            @Override // com.bytedance.sdk.openadsdk.sU.vS.Sj
            public JSONObject Sj(JSONObject jSONObject) throws Throwable {
                Dq EjP = vS.this.EjP();
                JSONObject jSONObject2 = new JSONObject();
                if (EjP == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                EjP.wE();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.TKC.put("playable_set_scroll_rect", new Sj() { // from class: com.bytedance.sdk.openadsdk.sU.vS.42
            @Override // com.bytedance.sdk.openadsdk.sU.vS.Sj
            public JSONObject Sj(JSONObject jSONObject) throws Throwable {
                Dq EjP = vS.this.EjP();
                JSONObject jSONObject2 = new JSONObject();
                if (EjP == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.TKC.put("playable_click_area", new Sj() { // from class: com.bytedance.sdk.openadsdk.sU.vS.43
            @Override // com.bytedance.sdk.openadsdk.sU.vS.Sj
            public JSONObject Sj(JSONObject jSONObject) throws Throwable {
                Dq EjP = vS.this.EjP();
                JSONObject jSONObject2 = new JSONObject();
                if (EjP == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                EjP.HiB(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.TKC.put("playable_real_play_start", new Sj() { // from class: com.bytedance.sdk.openadsdk.sU.vS.44
            @Override // com.bytedance.sdk.openadsdk.sU.vS.Sj
            public JSONObject Sj(JSONObject jSONObject) throws Throwable {
                Dq EjP = vS.this.EjP();
                JSONObject jSONObject2 = new JSONObject();
                if (EjP == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.TKC.put("playable_material_first_frame_show", new Sj() { // from class: com.bytedance.sdk.openadsdk.sU.vS.46
            @Override // com.bytedance.sdk.openadsdk.sU.vS.Sj
            public JSONObject Sj(JSONObject jSONObject) throws Throwable {
                Dq EjP = vS.this.EjP();
                JSONObject jSONObject2 = new JSONObject();
                if (EjP == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                EjP.ley();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.TKC.put("playable_stuck_check_pong", new Sj() { // from class: com.bytedance.sdk.openadsdk.sU.vS.47
            @Override // com.bytedance.sdk.openadsdk.sU.vS.Sj
            public JSONObject Sj(JSONObject jSONObject) throws Throwable {
                Dq EjP = vS.this.EjP();
                JSONObject jSONObject2 = new JSONObject();
                if (EjP == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                EjP.LqL();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.TKC.put("playable_material_adnormal_mask", new Sj() { // from class: com.bytedance.sdk.openadsdk.sU.vS.48
            @Override // com.bytedance.sdk.openadsdk.sU.vS.Sj
            public JSONObject Sj(JSONObject jSONObject) throws Throwable {
                Dq EjP = vS.this.EjP();
                JSONObject jSONObject2 = new JSONObject();
                if (EjP == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                EjP.vS(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.TKC.put("playable_long_press_panel", new Sj() { // from class: com.bytedance.sdk.openadsdk.sU.vS.49
            @Override // com.bytedance.sdk.openadsdk.sU.vS.Sj
            public JSONObject Sj(JSONObject jSONObject) throws Throwable {
                Dq EjP = vS.this.EjP();
                JSONObject jSONObject2 = new JSONObject();
                if (EjP == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.TKC.put("playable_alpha_player_play", new Sj() { // from class: com.bytedance.sdk.openadsdk.sU.vS.50
            @Override // com.bytedance.sdk.openadsdk.sU.vS.Sj
            public JSONObject Sj(JSONObject jSONObject) throws Throwable {
                Dq EjP = vS.this.EjP();
                JSONObject jSONObject2 = new JSONObject();
                if (EjP == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.TKC.put("playable_transfrom_module_highlight", new Sj() { // from class: com.bytedance.sdk.openadsdk.sU.vS.51
            @Override // com.bytedance.sdk.openadsdk.sU.vS.Sj
            public JSONObject Sj(JSONObject jSONObject) throws Throwable {
                Dq EjP = vS.this.EjP();
                JSONObject jSONObject2 = new JSONObject();
                if (EjP == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.TKC.put("playable_send_click_event", new Sj() { // from class: com.bytedance.sdk.openadsdk.sU.vS.52
            @Override // com.bytedance.sdk.openadsdk.sU.vS.Sj
            public JSONObject Sj(JSONObject jSONObject) throws Throwable {
                Dq EjP = vS.this.EjP();
                JSONObject jSONObject2 = new JSONObject();
                if (EjP == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.TKC.put("playable_query_media_permission_declare", new Sj() { // from class: com.bytedance.sdk.openadsdk.sU.vS.53
            @Override // com.bytedance.sdk.openadsdk.sU.vS.Sj
            public JSONObject Sj(JSONObject jSONObject) throws Throwable {
                Dq EjP = vS.this.EjP();
                JSONObject jSONObject2 = new JSONObject();
                if (EjP == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject Jcg = EjP.Jcg(jSONObject);
                Jcg.put("code", 1);
                return Jcg;
            }
        });
        this.TKC.put("playable_query_media_permission_enable", new Sj() { // from class: com.bytedance.sdk.openadsdk.sU.vS.54
            @Override // com.bytedance.sdk.openadsdk.sU.vS.Sj
            public JSONObject Sj(JSONObject jSONObject) throws Throwable {
                Dq EjP = vS.this.EjP();
                JSONObject jSONObject2 = new JSONObject();
                if (EjP == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject Dq = EjP.Dq(jSONObject);
                Dq.put("code", 1);
                return Dq;
            }
        });
        this.TKC.put("playable_apply_media_permission", new Sj() { // from class: com.bytedance.sdk.openadsdk.sU.vS.55
            @Override // com.bytedance.sdk.openadsdk.sU.vS.Sj
            public JSONObject Sj(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.sU.Sj HiB = vS.this.HiB();
                JSONObject jSONObject2 = new JSONObject();
                if (HiB == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.TKC.put("playable_start_kws", new Sj() { // from class: com.bytedance.sdk.openadsdk.sU.vS.57
            @Override // com.bytedance.sdk.openadsdk.sU.vS.Sj
            public JSONObject Sj(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.sU.Sj HiB = vS.this.HiB();
                JSONObject jSONObject2 = new JSONObject();
                if (HiB == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.TKC.put("playable_close_kws", new Sj() { // from class: com.bytedance.sdk.openadsdk.sU.vS.58
            @Override // com.bytedance.sdk.openadsdk.sU.vS.Sj
            public JSONObject Sj(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.sU.Sj HiB = vS.this.HiB();
                JSONObject jSONObject2 = new JSONObject();
                if (HiB == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.TKC.put("playable_video_preload_task_add", new Sj() { // from class: com.bytedance.sdk.openadsdk.sU.vS.59
            @Override // com.bytedance.sdk.openadsdk.sU.vS.Sj
            public JSONObject Sj(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.sU.Sj HiB = vS.this.HiB();
                JSONObject jSONObject2 = new JSONObject();
                if (HiB == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.TKC.put("playable_video_preload_task_cancel", new Sj() { // from class: com.bytedance.sdk.openadsdk.sU.vS.60
            @Override // com.bytedance.sdk.openadsdk.sU.vS.Sj
            public JSONObject Sj(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.sU.Sj HiB = vS.this.HiB();
                JSONObject jSONObject2 = new JSONObject();
                if (HiB == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
    }

    public Set<String> Sj() {
        return this.TKC.keySet();
    }

    public JSONObject Sj(String str, JSONObject jSONObject) {
        try {
            Sj sj2 = this.TKC.get(str);
            if (sj2 != null) {
                return sj2.Sj(jSONObject);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("code", -1);
            return jSONObject2;
        } catch (Throwable th2) {
            Jcg.Sj("PlayableJsBridge", "invoke error", th2);
            return null;
        }
    }

    public void sP() {
        TEQ.Sj(this.Sj, this.EjP);
        TEQ.Sj(this.Sj, this.HiB);
        TEQ.Sj(this.Sj, this.vS);
        TEQ.Sj(this.Sj, this.Jcg);
    }
}
