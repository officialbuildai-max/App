package i7;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.cloud.tmc.integration.params.TmcStartParams;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class e implements SensorEventListener {

    /* renamed from: a, reason: collision with root package name */
    private final SensorManager f65142a;

    /* renamed from: b, reason: collision with root package name */
    private float[] f65143b;

    /* renamed from: c, reason: collision with root package name */
    private float f65144c;

    /* renamed from: d, reason: collision with root package name */
    private float[] f65145d;

    /* renamed from: e, reason: collision with root package name */
    private float f65146e;

    /* renamed from: f, reason: collision with root package name */
    private float f65147f;

    /* renamed from: g, reason: collision with root package name */
    private float[] f65148g;

    /* renamed from: h, reason: collision with root package name */
    private float f65149h;

    /* renamed from: i, reason: collision with root package name */
    private float[] f65150i;

    /* renamed from: j, reason: collision with root package name */
    private float[] f65151j;

    /* renamed from: k, reason: collision with root package name */
    private final AtomicBoolean f65152k;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final e f65153a = new e();
    }

    private e() {
        this.f65143b = new float[0];
        this.f65145d = new float[0];
        this.f65148g = new float[0];
        this.f65150i = new float[0];
        this.f65151j = new float[0];
        this.f65152k = new AtomicBoolean(false);
        this.f65142a = (SensorManager) com.cloud.sdk.commonutil.util.e.a().getSystemService("sensor");
    }

    public static e e() {
        return b.f65153a;
    }

    public static Bundle k() {
        Bundle bundle = new Bundle();
        try {
            bundle.putFloatArray("ots", e().h());
            bundle.putFloat(TmcStartParams.KEY_LANDSCAPE_SHORT, e().f());
            bundle.putFloatArray("ms", e().g());
            bundle.putFloat("pxs", e().j());
            bundle.putFloat("tps", e().l());
            bundle.putFloatArray("gs", e().d());
            bundle.putFloat("pss", e().i());
            bundle.putFloatArray("gvs", e().c());
            bundle.putFloatArray("ams", e().b());
        } catch (Exception e11) {
            i7.a.r0(Log.getStackTraceString(e11));
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n() {
        this.f65152k.set(true);
        this.f65142a.unregisterListener(this);
    }

    public static void q() {
        try {
            try {
                try {
                    e().o();
                    e().p();
                } catch (Exception e11) {
                    i7.a.r0(Log.getStackTraceString(e11));
                    e().p();
                }
            } catch (Exception e12) {
                i7.a.r0(Log.getStackTraceString(e12));
            }
        } catch (Throwable th2) {
            try {
                e().p();
            } catch (Exception e13) {
                i7.a.r0(Log.getStackTraceString(e13));
            }
            throw th2;
        }
    }

    public float[] b() {
        return this.f65151j;
    }

    public float[] c() {
        return this.f65150i;
    }

    public float[] d() {
        return this.f65148g;
    }

    public float f() {
        return this.f65144c;
    }

    public float[] g() {
        return this.f65145d;
    }

    public float[] h() {
        return this.f65143b;
    }

    public float i() {
        return this.f65149h;
    }

    public float j() {
        return this.f65146e;
    }

    public float l() {
        return this.f65147f;
    }

    public boolean m() {
        return this.f65152k.get();
    }

    public void o() {
        SensorManager sensorManager = this.f65142a;
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(3), 3);
        SensorManager sensorManager2 = this.f65142a;
        sensorManager2.registerListener(this, sensorManager2.getDefaultSensor(4), 3);
        SensorManager sensorManager3 = this.f65142a;
        sensorManager3.registerListener(this, sensorManager3.getDefaultSensor(9), 3);
        SensorManager sensorManager4 = this.f65142a;
        sensorManager4.registerListener(this, sensorManager4.getDefaultSensor(1), 3);
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i11) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        Sensor sensor;
        float[] fArr;
        if (sensorEvent == null || (sensor = sensorEvent.sensor) == null || (fArr = sensorEvent.values) == null || fArr.length < 1) {
            return;
        }
        switch (sensor.getType()) {
            case 1:
                this.f65151j = sensorEvent.values;
                return;
            case 2:
                this.f65145d = sensorEvent.values;
                return;
            case 3:
                this.f65143b = sensorEvent.values;
                return;
            case 4:
                this.f65148g = sensorEvent.values;
                return;
            case 5:
                this.f65144c = sensorEvent.values[0];
                return;
            case 6:
                this.f65149h = sensorEvent.values[0];
                return;
            case 7:
                this.f65147f = sensorEvent.values[0];
                return;
            case 8:
                this.f65146e = sensorEvent.values[0];
                return;
            case 9:
                this.f65150i = sensorEvent.values;
                return;
            default:
                return;
        }
    }

    public void p() {
        if (Looper.myLooper() == null) {
            return;
        }
        new Handler(Looper.myLooper()).postDelayed(new Runnable() { // from class: i7.d
            @Override // java.lang.Runnable
            public final void run() {
                e.this.n();
            }
        }, 1000L);
    }
}
