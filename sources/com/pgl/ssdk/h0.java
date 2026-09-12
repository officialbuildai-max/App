package com.pgl.ssdk;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public class h0 implements SensorEventListener {

    /* renamed from: a, reason: collision with root package name */
    private static final float[] f40192a = {999999.0f, 999999.0f, 999999.0f};

    /* renamed from: b, reason: collision with root package name */
    public static boolean f40193b = true;

    /* renamed from: c, reason: collision with root package name */
    private static volatile h0 f40194c;

    /* renamed from: i, reason: collision with root package name */
    private final Context f40200i;

    /* renamed from: d, reason: collision with root package name */
    private Sensor f40195d = null;

    /* renamed from: e, reason: collision with root package name */
    private Sensor f40196e = null;

    /* renamed from: f, reason: collision with root package name */
    private Sensor f40197f = null;

    /* renamed from: g, reason: collision with root package name */
    private volatile boolean f40198g = false;

    /* renamed from: h, reason: collision with root package name */
    private volatile boolean f40199h = false;

    /* renamed from: j, reason: collision with root package name */
    private AtomicReference<a> f40201j = new AtomicReference<>();

    /* renamed from: k, reason: collision with root package name */
    private long f40202k = 999999;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public long f40203a;

        /* renamed from: b, reason: collision with root package name */
        public float[] f40204b = null;

        /* renamed from: c, reason: collision with root package name */
        public float[] f40205c = null;

        /* renamed from: d, reason: collision with root package name */
        public float[] f40206d = null;

        public a(long j11) {
            this.f40203a = j11;
        }
    }

    private h0(Context context) {
        this.f40200i = context;
    }

    public static h0 a(Context context) {
        if (f40194c == null) {
            synchronized (h0.class) {
                try {
                    if (f40194c == null) {
                        f40194c = new h0(context);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        if (f40193b) {
            f40194c.c();
        }
        return f40194c;
    }

    private static void a(Object[] objArr) {
        Float valueOf = Float.valueOf(999999.0f);
        objArr[0] = valueOf;
        objArr[1] = valueOf;
        objArr[2] = valueOf;
        objArr[3] = 999999L;
        float[] fArr = f40192a;
        objArr[4] = fArr;
        objArr[5] = fArr;
    }

    private static void a(Object[] objArr, a aVar) {
        float[] fArr = aVar.f40204b;
        if (fArr != null) {
            float[] fArr2 = aVar.f40205c;
            float[] a11 = fArr2 != null ? a(objArr, fArr, fArr2) : a(objArr, fArr);
            objArr[0] = Float.valueOf(a11[0]);
            objArr[1] = Float.valueOf(a11[1]);
            objArr[2] = Float.valueOf(a11[2]);
            objArr[4] = aVar.f40204b;
        } else {
            objArr[0] = Float.valueOf(999999.0f);
            objArr[1] = Float.valueOf(999999.0f);
            objArr[2] = Float.valueOf(999999.0f);
            objArr[4] = f40192a;
        }
        objArr[3] = Long.valueOf(aVar.f40203a);
        float[] fArr3 = aVar.f40206d;
        if (fArr3 != null) {
            objArr[5] = fArr3;
        } else {
            objArr[5] = f40192a;
        }
    }

    private static float[] a(Object[] objArr, float[] fArr) {
        float f11 = fArr[0];
        float f12 = fArr[1];
        float f13 = fArr[2];
        float sqrt = 1.0f / ((float) Math.sqrt(((f11 * f11) + (f12 * f12)) + (f13 * f13)));
        return new float[]{999999.0f, (((float) Math.toDegrees((float) Math.asin(-(f12 * sqrt)))) + 360.0f) % 360.0f, (((float) Math.toDegrees((float) Math.atan2(-(f11 * sqrt), f13 * sqrt))) + 360.0f) % 360.0f};
    }

    private static float[] a(Object[] objArr, float[] fArr, float[] fArr2) {
        float[] fArr3 = new float[9];
        SensorManager.getRotationMatrix(fArr3, new float[9], fArr, fArr2);
        SensorManager.getOrientation(fArr3, new float[3]);
        return new float[]{(((float) Math.toDegrees(r2[0])) + 360.0f) % 360.0f, (((float) Math.toDegrees(r2[1])) + 360.0f) % 360.0f, (((float) Math.toDegrees(r2[2])) + 360.0f) % 360.0f};
    }

    private void c() {
        if (this.f40199h) {
            return;
        }
        try {
            SensorManager sensorManager = (SensorManager) this.f40200i.getApplicationContext().getSystemService("sensor");
            if (sensorManager != null) {
                this.f40195d = sensorManager.getDefaultSensor(1);
                this.f40196e = sensorManager.getDefaultSensor(2);
                this.f40197f = sensorManager.getDefaultSensor(4);
            }
        } catch (Exception unused) {
        }
        this.f40199h = true;
    }

    private void e() {
        this.f40202k = -1L;
        this.f40198g = false;
        try {
            SensorManager sensorManager = (SensorManager) this.f40200i.getApplicationContext().getSystemService("sensor");
            if (sensorManager != null) {
                sensorManager.unregisterListener(this);
            }
        } catch (Exception unused) {
        }
    }

    public void a() {
        if (!f40193b || this.f40198g) {
            return;
        }
        d();
    }

    public Object[] b() {
        Object[] objArr = new Object[6];
        a aVar = this.f40201j.get();
        if (!f40193b || aVar == null) {
            a(objArr);
            return objArr;
        }
        int i11 = 0;
        do {
            if ((this.f40195d == null || aVar.f40204b != null) && ((this.f40196e == null || aVar.f40205c != null) && (this.f40197f == null || aVar.f40206d != null))) {
                break;
            }
            w0.a(50L);
            i11++;
        } while (i11 <= 20);
        e();
        this.f40198g = false;
        a(objArr, aVar);
        this.f40201j.set(null);
        return objArr;
    }

    public boolean d() {
        if (this.f40195d != null) {
            try {
                SensorManager sensorManager = (SensorManager) this.f40200i.getApplicationContext().getSystemService("sensor");
                if (sensorManager != null) {
                    boolean registerListener = sensorManager.registerListener(this, this.f40195d, 1);
                    Sensor sensor = this.f40196e;
                    if (sensor != null) {
                        sensorManager.registerListener(this, sensor, 1);
                    }
                    Sensor sensor2 = this.f40197f;
                    if (sensor2 != null) {
                        sensorManager.registerListener(this, sensor2, 1);
                    }
                    if (registerListener) {
                        long currentTimeMillis = System.currentTimeMillis();
                        this.f40202k = currentTimeMillis;
                        this.f40201j.set(new a(currentTimeMillis));
                        this.f40198g = true;
                    } else {
                        e();
                    }
                }
            } catch (Throwable unused) {
                e();
            }
        }
        return this.f40198g;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i11) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        a aVar = this.f40201j.get();
        if (aVar == null) {
            return;
        }
        int type = sensorEvent.sensor.getType();
        if (type == 1) {
            if (aVar.f40204b == null) {
                aVar.f40204b = sensorEvent.values;
            }
        } else if (type == 2) {
            if (aVar.f40205c == null) {
                aVar.f40205c = sensorEvent.values;
            }
        } else if (type == 4 && aVar.f40206d == null) {
            aVar.f40206d = sensorEvent.values;
        }
    }
}
