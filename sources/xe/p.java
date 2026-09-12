package xe;

import android.content.Context;
import android.view.OrientationEventListener;
import android.view.WindowManager;

/* loaded from: classes5.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    private int f78352a;

    /* renamed from: b, reason: collision with root package name */
    private WindowManager f78353b;

    /* renamed from: c, reason: collision with root package name */
    private OrientationEventListener f78354c;

    /* renamed from: d, reason: collision with root package name */
    private o f78355d;

    /* loaded from: classes5.dex */
    class a extends OrientationEventListener {
        a(Context context, int i11) {
            super(context, i11);
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i11) {
            int rotation;
            WindowManager windowManager = p.this.f78353b;
            o oVar = p.this.f78355d;
            if (p.this.f78353b == null || oVar == null || (rotation = windowManager.getDefaultDisplay().getRotation()) == p.this.f78352a) {
                return;
            }
            p.this.f78352a = rotation;
            oVar.a(rotation);
        }
    }

    public void e(Context context, o oVar) {
        f();
        Context applicationContext = context.getApplicationContext();
        this.f78355d = oVar;
        this.f78353b = (WindowManager) applicationContext.getSystemService("window");
        a aVar = new a(applicationContext, 3);
        this.f78354c = aVar;
        aVar.enable();
        this.f78352a = this.f78353b.getDefaultDisplay().getRotation();
    }

    public void f() {
        OrientationEventListener orientationEventListener = this.f78354c;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
        this.f78354c = null;
        this.f78353b = null;
        this.f78355d = null;
    }
}
