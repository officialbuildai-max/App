package a6;

import android.view.SurfaceHolder;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public class b implements SurfaceHolder.Callback {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference f438a;

    public b(SurfaceHolder.Callback callback) {
        this.f438a = new WeakReference(callback);
    }

    public SurfaceHolder.Callback a() {
        return (SurfaceHolder.Callback) this.f438a.get();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i11, int i12, int i13) {
        SurfaceHolder.Callback callback = (SurfaceHolder.Callback) this.f438a.get();
        if (callback != null) {
            callback.surfaceChanged(surfaceHolder, i11, i12, i13);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        SurfaceHolder.Callback callback = (SurfaceHolder.Callback) this.f438a.get();
        if (callback != null) {
            callback.surfaceCreated(surfaceHolder);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        SurfaceHolder.Callback callback = (SurfaceHolder.Callback) this.f438a.get();
        if (callback != null) {
            callback.surfaceDestroyed(surfaceHolder);
        }
    }
}
