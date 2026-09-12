package androidx.media3.exoplayer.video.spherical;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.view.Display;
import com.vungle.ads.internal.protos.Sdk$SDKError;

/* loaded from: classes2.dex */
final class b implements SensorEventListener {

    /* renamed from: a, reason: collision with root package name */
    private final float[] f13331a = new float[16];

    /* renamed from: b, reason: collision with root package name */
    private final float[] f13332b = new float[16];

    /* renamed from: c, reason: collision with root package name */
    private final float[] f13333c = new float[16];

    /* renamed from: d, reason: collision with root package name */
    private final float[] f13334d = new float[3];

    /* renamed from: e, reason: collision with root package name */
    private final Display f13335e;

    /* renamed from: f, reason: collision with root package name */
    private final a[] f13336f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f13337g;

    /* loaded from: classes2.dex */
    public interface a {
        void a(float[] fArr, float f11);
    }

    public b(Display display, a... aVarArr) {
        this.f13335e = display;
        this.f13336f = aVarArr;
    }

    private float a(float[] fArr) {
        SensorManager.remapCoordinateSystem(fArr, 1, Sdk$SDKError.Reason.MRAID_JS_WRITE_FAILED_VALUE, this.f13332b);
        SensorManager.getOrientation(this.f13332b, this.f13334d);
        return this.f13334d[2];
    }

    private void b(float[] fArr, float f11) {
        for (a aVar : this.f13336f) {
            aVar.a(fArr, f11);
        }
    }

    private void c(float[] fArr) {
        if (!this.f13337g) {
            androidx.media3.exoplayer.video.spherical.a.a(this.f13333c, fArr);
            this.f13337g = true;
        }
        float[] fArr2 = this.f13332b;
        System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
        Matrix.multiplyMM(fArr, 0, this.f13332b, 0, this.f13333c, 0);
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
            float[] fArr2 = this.f13332b;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            SensorManager.remapCoordinateSystem(this.f13332b, i12, i13, fArr);
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
        SensorManager.getRotationMatrixFromVector(this.f13331a, sensorEvent.values);
        d(this.f13331a, this.f13335e.getRotation());
        float a11 = a(this.f13331a);
        e(this.f13331a);
        c(this.f13331a);
        b(this.f13331a, a11);
    }
}
