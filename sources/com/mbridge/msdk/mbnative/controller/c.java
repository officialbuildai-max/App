package com.mbridge.msdk.mbnative.controller;

import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import com.mbridge.msdk.foundation.tools.b1;
import com.mbridge.msdk.foundation.tools.o0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<ViewTreeObserver> f36386a;

    /* renamed from: b, reason: collision with root package name */
    private List<View> f36387b;

    /* renamed from: c, reason: collision with root package name */
    private ViewTreeObserver.OnPreDrawListener f36388c;

    /* renamed from: d, reason: collision with root package name */
    private d f36389d;

    /* renamed from: e, reason: collision with root package name */
    private Handler f36390e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f36391f;

    /* renamed from: g, reason: collision with root package name */
    private int f36392g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements ViewTreeObserver.OnPreDrawListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            c.this.b();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.d();
        }
    }

    /* renamed from: com.mbridge.msdk.mbnative.controller.c$c, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    class RunnableC0509c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f36395a;

        RunnableC0509c(View view) {
            this.f36395a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewTreeObserver viewTreeObserver = this.f36395a.getViewTreeObserver();
            if (viewTreeObserver == null || viewTreeObserver.isAlive()) {
                c.this.f36386a = new WeakReference(viewTreeObserver);
                if (c.this.f36388c != null) {
                    viewTreeObserver.addOnPreDrawListener(c.this.f36388c);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface d {
        void a(ArrayList<View> arrayList, ArrayList<View> arrayList2);
    }

    public c(List<View> list, d dVar, Handler handler, int i11) {
        ArrayList arrayList = new ArrayList();
        this.f36387b = arrayList;
        this.f36388c = null;
        this.f36389d = dVar;
        this.f36390e = handler;
        this.f36392g = i11;
        if (list != null) {
            this.f36387b = list;
        } else {
            arrayList.clear();
        }
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.f36391f) {
            return;
        }
        Handler handler = this.f36390e;
        if (handler != null) {
            if (this.f36392g == 1) {
                d();
            } else {
                handler.postDelayed(new b(), 100L);
            }
        }
        this.f36391f = true;
    }

    private boolean b(View view) {
        return !b1.a(view, this.f36392g);
    }

    private void c() {
        try {
            b();
        } catch (Throwable th2) {
            o0.b("ImpressionTracker", th2.getMessage(), th2);
        }
        try {
            this.f36388c = new a();
        } catch (Throwable th3) {
            o0.b("ImpressionTracker", th3.getMessage(), th3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        try {
            this.f36391f = false;
            List<View> list = this.f36387b;
            if (list == null || list.size() <= 0) {
                return;
            }
            ArrayList<View> arrayList = new ArrayList<>();
            ArrayList<View> arrayList2 = new ArrayList<>();
            for (int i11 = 0; i11 < this.f36387b.size(); i11++) {
                View view = this.f36387b.get(i11);
                if (b(view)) {
                    arrayList.add(view);
                } else {
                    arrayList2.add(view);
                }
            }
            d dVar = this.f36389d;
            if (dVar != null) {
                dVar.a(arrayList, arrayList2);
            }
            if (arrayList.size() > 0) {
                a();
            }
            arrayList.clear();
            arrayList2.clear();
        } catch (Exception unused) {
        }
    }

    public void a() {
        try {
            this.f36391f = false;
            WeakReference<ViewTreeObserver> weakReference = this.f36386a;
            if (weakReference != null && weakReference.get() != null) {
                ViewTreeObserver viewTreeObserver = this.f36386a.get();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnPreDrawListener(this.f36388c);
                }
                this.f36386a.clear();
            }
            this.f36389d = null;
            this.f36388c = null;
            List<View> list = this.f36387b;
            if (list != null) {
                list.clear();
            }
            this.f36387b = null;
        } catch (Throwable unused) {
        }
    }

    public void a(View view) {
        View view2;
        View view3;
        if (view != null) {
            view2 = f.a(view.getContext(), view);
            this.f36387b.add(view);
        } else {
            List<View> list = this.f36387b;
            view2 = null;
            if (list != null && list.size() > 0) {
                for (int i11 = 0; i11 < this.f36387b.size() && ((view3 = this.f36387b.get(i11)) == null || (view2 = f.a(view3.getContext(), view3)) == null); i11++) {
                }
            }
        }
        if (view2 == null) {
            return;
        }
        view2.post(new RunnableC0509c(view2));
    }
}
