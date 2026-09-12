package e7;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;

/* loaded from: classes3.dex */
public class n extends GestureDetector {

    /* renamed from: a, reason: collision with root package name */
    private a f61724a;

    /* loaded from: classes3.dex */
    public static class a extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: a, reason: collision with root package name */
        boolean f61725a = false;

        boolean a() {
            return this.f61725a;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            this.f61725a = true;
            return super.onSingleTapUp(motionEvent);
        }
    }

    public n(Context context) {
        this(context, new a());
    }

    private n(Context context, a aVar) {
        super(context, aVar);
        this.f61724a = aVar;
        setIsLongpressEnabled(false);
    }

    public boolean a() {
        return this.f61724a.a();
    }
}
