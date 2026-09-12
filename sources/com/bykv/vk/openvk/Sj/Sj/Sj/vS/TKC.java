package com.bykv.vk.openvk.Sj.Sj.Sj.vS;

import a6.b;
import android.content.Context;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.Sj.Sj.Sj.vS.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class TKC extends HiB implements SurfaceHolder.Callback, a {

    /* renamed from: c, reason: collision with root package name */
    private static final ArrayList f20237c = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    private WeakReference f20238a;

    /* renamed from: b, reason: collision with root package name */
    private b f20239b;

    public TKC(Context context) {
        super(context);
        a();
    }

    private void a() {
        b bVar = new b(this);
        this.f20239b = bVar;
        f20237c.add(bVar);
    }

    @Override // com.bykv.vk.openvk.Sj.Sj.Sj.vS.a
    public void Sj(int i11, int i12) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i12;
        layoutParams.width = i11;
        setLayoutParams(layoutParams);
    }

    @Override // com.bykv.vk.openvk.Sj.Sj.Sj.vS.a
    public void Sj(a6.a aVar) {
        this.f20238a = new WeakReference(aVar);
        SurfaceHolder holder = getHolder();
        holder.setFormat(-3);
        Iterator it = f20237c.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar != null && bVar.a() == null) {
                holder.removeCallback(bVar);
                it.remove();
            }
        }
        holder.addCallback(this.f20239b);
    }

    @Override // com.bykv.vk.openvk.Sj.Sj.Sj.vS.a
    public View getView() {
        return this;
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onWindowVisibilityChanged(int i11) {
        super.onWindowVisibilityChanged(i11);
    }

    public void setWindowVisibilityChangedListener(a.InterfaceC0195a interfaceC0195a) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i11, int i12, int i13) {
        WeakReference weakReference = this.f20238a;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        ((a6.a) this.f20238a.get()).Sj(surfaceHolder, i11, i12, i13);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        WeakReference weakReference = this.f20238a;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        ((a6.a) this.f20238a.get()).Sj(surfaceHolder);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        WeakReference weakReference = this.f20238a;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        ((a6.a) this.f20238a.get()).sP(surfaceHolder);
    }
}
