package gd;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import com.journeyapps.barcodescanner.camera.CameraSettings;

/* loaded from: classes5.dex */
public final class b implements SensorEventListener {

    /* renamed from: a, reason: collision with root package name */
    private com.journeyapps.barcodescanner.camera.h f63654a;

    /* renamed from: b, reason: collision with root package name */
    private CameraSettings f63655b;

    /* renamed from: c, reason: collision with root package name */
    private Sensor f63656c;

    /* renamed from: d, reason: collision with root package name */
    private Context f63657d;

    /* renamed from: e, reason: collision with root package name */
    private Handler f63658e = new Handler();

    public b(Context context, com.journeyapps.barcodescanner.camera.h hVar, CameraSettings cameraSettings) {
        this.f63657d = context;
        this.f63654a = hVar;
        this.f63655b = cameraSettings;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(boolean z10) {
        this.f63654a.u(z10);
    }

    private void c(final boolean z10) {
        this.f63658e.post(new Runnable() { // from class: gd.a
            @Override // java.lang.Runnable
            public final void run() {
                b.this.b(z10);
            }
        });
    }

    public void d() {
        if (this.f63655b.d()) {
            SensorManager sensorManager = (SensorManager) this.f63657d.getSystemService("sensor");
            Sensor defaultSensor = sensorManager.getDefaultSensor(5);
            this.f63656c = defaultSensor;
            if (defaultSensor != null) {
                sensorManager.registerListener(this, defaultSensor, 3);
            }
        }
    }

    public void e() {
        if (this.f63656c != null) {
            ((SensorManager) this.f63657d.getSystemService("sensor")).unregisterListener(this);
            this.f63656c = null;
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i11) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        float f11 = sensorEvent.values[0];
        if (this.f63654a != null) {
            if (f11 <= 45.0f) {
                c(true);
            } else if (f11 >= 450.0f) {
                c(false);
            }
        }
    }
}
