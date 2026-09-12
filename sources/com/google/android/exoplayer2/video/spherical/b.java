package com.google.android.exoplayer2.video.spherical;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.view.Display;
import com.vungle.ads.internal.protos.Sdk$SDKError;

/* loaded from: classes3.dex */
final class b implements SensorEventListener {

    /* renamed from: a, reason: collision with root package name */
    private final float[] f27997a = new float[16];

    /* renamed from: b, reason: collision with root package name */
    private final float[] f27998b = new float[16];

    /* renamed from: c, reason: collision with root package name */
    private final float[] f27999c = new float[16];

    /* renamed from: d, reason: collision with root package name */
    private final float[] f28000d = new float[3];

    /* renamed from: e, reason: collision with root package name */
    private final Display f28001e;

    /* renamed from: f, reason: collision with root package name */
    private final a[] f28002f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f28003g;

    /* loaded from: classes3.dex */
    public interface a {
        void a(float[] fArr, float f11);
    }

    public b(Display display, a... aVarArr) {
        this.f28001e = display;
        this.f28002f = aVarArr;
    }

    private float a(float[] fArr) {
        SensorManager.remapCoordinateSystem(fArr, 1, Sdk$SDKError.Reason.MRAID_JS_WRITE_FAILED_VALUE, this.f27998b);
        SensorManager.getOrientation(this.f27998b, this.f28000d);
        return this.f28000d[2];
    }

    private void b(float[] fArr, float f11) {
        for (a aVar : this.f28002f) {
            aVar.a(fArr, f11);
        }
    }

    private void c(float[] fArr) {
        if (!this.f28003g) {
            com.google.android.exoplayer2.video.spherical.a.a(this.f27999c, fArr);
            this.f28003g = true;
        }
        float[] fArr2 = this.f27998b;
        System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
        Matrix.multiplyMM(fArr, 0, this.f27998b, 0, this.f27999c, 0);
    }

    private void d(float[] fArr, int i11) {
        if (i11 != 0) {
            int i12 = 129;
            int i13 = 1;
            if (i11 == 1) {
                i13 = 129;
                i12 = 2;
            } else if (i11 == 2) {
                i13 = 130;
            } else {
                if (i11 != 3) {
                    throw new IllegalStateException();
                }
                i12 = 130;
            }
            float[] fArr2 = this.f27998b;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            SensorManager.remapCoordinateSystem(this.f27998b, i12, i13, fArr);
        }
    }

    private static void e(float[] fArr) {
        Matrix.rotateM(fArr, 0, 90.0f, 1.0f, 0.0f, 0.0f);
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i11) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        SensorManager.getRotationMatrixFromVector(this.f27997a, sensorEvent.values);
        d(this.f27997a, this.f28001e.getRotation());
        float a11 = a(this.f27997a);
        e(this.f27997a);
        c(this.f27997a);
        b(this.f27997a, a11);
    }
}
