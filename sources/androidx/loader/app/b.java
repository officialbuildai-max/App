package androidx.loader.app;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.collection.y0;
import androidx.loader.app.a;
import androidx.loader.content.a;
import androidx.view.b0;
import androidx.view.c0;
import androidx.view.t0;
import androidx.view.u;
import androidx.view.v0;
import androidx.view.w0;
import androidx.view.x0;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import kotlin.reflect.KClass;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends androidx.loader.app.a {

    /* renamed from: c, reason: collision with root package name */
    static boolean f9761c;

    /* renamed from: a, reason: collision with root package name */
    private final u f9762a;

    /* renamed from: b, reason: collision with root package name */
    private final c f9763b;

    /* loaded from: classes.dex */
    public static class a extends b0 implements a.b {

        /* renamed from: l, reason: collision with root package name */
        private final int f9764l;

        /* renamed from: m, reason: collision with root package name */
        private final Bundle f9765m;

        /* renamed from: n, reason: collision with root package name */
        private final androidx.loader.content.a f9766n;

        /* renamed from: o, reason: collision with root package name */
        private u f9767o;

        /* renamed from: p, reason: collision with root package name */
        private C0093b f9768p;

        /* renamed from: q, reason: collision with root package name */
        private androidx.loader.content.a f9769q;

        a(int i11, Bundle bundle, androidx.loader.content.a aVar, androidx.loader.content.a aVar2) {
            this.f9764l = i11;
            this.f9765m = bundle;
            this.f9766n = aVar;
            this.f9769q = aVar2;
            aVar.registerListener(i11, this);
        }

        @Override // androidx.loader.content.a.b
        public void a(androidx.loader.content.a aVar, Object obj) {
            if (b.f9761c) {
                Log.v("LoaderManager", "onLoadComplete: " + this);
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                q(obj);
                return;
            }
            if (b.f9761c) {
                Log.w("LoaderManager", "onLoadComplete was incorrectly called on a background thread");
            }
            n(obj);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.view.LiveData
        public void l() {
            if (b.f9761c) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            this.f9766n.startLoading();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.view.LiveData
        public void m() {
            if (b.f9761c) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.f9766n.stopLoading();
        }

        @Override // androidx.view.LiveData
        public void o(c0 c0Var) {
            super.o(c0Var);
            this.f9767o = null;
            this.f9768p = null;
        }

        @Override // androidx.view.b0, androidx.view.LiveData
        public void q(Object obj) {
            super.q(obj);
            androidx.loader.content.a aVar = this.f9769q;
            if (aVar != null) {
                aVar.reset();
                this.f9769q = null;
            }
        }

        androidx.loader.content.a r(boolean z10) {
            if (b.f9761c) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.f9766n.cancelLoad();
            this.f9766n.abandon();
            C0093b c0093b = this.f9768p;
            if (c0093b != null) {
                o(c0093b);
                if (z10) {
                    c0093b.c();
                }
            }
            this.f9766n.unregisterListener(this);
            if ((c0093b == null || c0093b.b()) && !z10) {
                return this.f9766n;
            }
            this.f9766n.reset();
            return this.f9769q;
        }

        public void s(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f9764l);
            printWriter.print(" mArgs=");
            printWriter.println(this.f9765m);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.f9766n);
            this.f9766n.dump(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.f9768p != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.f9768p);
                this.f9768p.a(str + "  ", printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(t().dataToString(f()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(h());
        }

        androidx.loader.content.a t() {
            return this.f9766n;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder(64);
            sb2.append("LoaderInfo{");
            sb2.append(Integer.toHexString(System.identityHashCode(this)));
            sb2.append(" #");
            sb2.append(this.f9764l);
            sb2.append(" : ");
            androidx.core.util.b.a(this.f9766n, sb2);
            sb2.append("}}");
            return sb2.toString();
        }

        void u() {
            u uVar = this.f9767o;
            C0093b c0093b = this.f9768p;
            if (uVar == null || c0093b == null) {
                return;
            }
            super.o(c0093b);
            j(uVar, c0093b);
        }

        androidx.loader.content.a v(u uVar, a.InterfaceC0092a interfaceC0092a) {
            C0093b c0093b = new C0093b(this.f9766n, interfaceC0092a);
            j(uVar, c0093b);
            c0 c0Var = this.f9768p;
            if (c0Var != null) {
                o(c0Var);
            }
            this.f9767o = uVar;
            this.f9768p = c0093b;
            return this.f9766n;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.loader.app.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0093b implements c0 {

        /* renamed from: a, reason: collision with root package name */
        private final androidx.loader.content.a f9770a;

        /* renamed from: b, reason: collision with root package name */
        private final a.InterfaceC0092a f9771b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f9772c = false;

        C0093b(androidx.loader.content.a aVar, a.InterfaceC0092a interfaceC0092a) {
            this.f9770a = aVar;
            this.f9771b = interfaceC0092a;
        }

        public void a(String str, PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.f9772c);
        }

        boolean b() {
            return this.f9772c;
        }

        void c() {
            if (this.f9772c) {
                if (b.f9761c) {
                    Log.v("LoaderManager", "  Resetting: " + this.f9770a);
                }
                this.f9771b.onLoaderReset(this.f9770a);
            }
        }

        @Override // androidx.view.c0
        public void onChanged(Object obj) {
            if (b.f9761c) {
                Log.v("LoaderManager", "  onLoadFinished in " + this.f9770a + ": " + this.f9770a.dataToString(obj));
            }
            this.f9771b.onLoadFinished(this.f9770a, obj);
            this.f9772c = true;
        }

        public String toString() {
            return this.f9771b.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c extends t0 {

        /* renamed from: c, reason: collision with root package name */
        private static final v0.c f9773c = new a();

        /* renamed from: a, reason: collision with root package name */
        private y0 f9774a = new y0();

        /* renamed from: b, reason: collision with root package name */
        private boolean f9775b = false;

        /* loaded from: classes.dex */
        static class a implements v0.c {
            a() {
            }

            @Override // androidx.lifecycle.v0.c
            public t0 create(Class cls) {
                return new c();
            }

            @Override // androidx.lifecycle.v0.c
            public /* synthetic */ t0 create(Class cls, p1.a aVar) {
                return w0.b(this, cls, aVar);
            }

            @Override // androidx.lifecycle.v0.c
            public /* synthetic */ t0 create(KClass kClass, p1.a aVar) {
                return w0.c(this, kClass, aVar);
            }
        }

        c() {
        }

        static c d(x0 x0Var) {
            return (c) new v0(x0Var, f9773c).a(c.class);
        }

        public void b(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f9774a.p() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i11 = 0; i11 < this.f9774a.p(); i11++) {
                    a aVar = (a) this.f9774a.q(i11);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f9774a.k(i11));
                    printWriter.print(": ");
                    printWriter.println(aVar.toString());
                    aVar.s(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }

        void c() {
            this.f9775b = false;
        }

        a e(int i11) {
            return (a) this.f9774a.f(i11);
        }

        boolean f() {
            return this.f9775b;
        }

        void g() {
            int p11 = this.f9774a.p();
            for (int i11 = 0; i11 < p11; i11++) {
                ((a) this.f9774a.q(i11)).u();
            }
        }

        void h(int i11, a aVar) {
            this.f9774a.l(i11, aVar);
        }

        void i() {
            this.f9775b = true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.view.t0
        public void onCleared() {
            super.onCleared();
            int p11 = this.f9774a.p();
            for (int i11 = 0; i11 < p11; i11++) {
                ((a) this.f9774a.q(i11)).r(true);
            }
            this.f9774a.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(u uVar, x0 x0Var) {
        this.f9762a = uVar;
        this.f9763b = c.d(x0Var);
    }

    private androidx.loader.content.a e(int i11, Bundle bundle, a.InterfaceC0092a interfaceC0092a, androidx.loader.content.a aVar) {
        try {
            this.f9763b.i();
            androidx.loader.content.a onCreateLoader = interfaceC0092a.onCreateLoader(i11, bundle);
            if (onCreateLoader == null) {
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
            }
            if (onCreateLoader.getClass().isMemberClass() && !Modifier.isStatic(onCreateLoader.getClass().getModifiers())) {
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + onCreateLoader);
            }
            a aVar2 = new a(i11, bundle, onCreateLoader, aVar);
            if (f9761c) {
                Log.v("LoaderManager", "  Created new loader " + aVar2);
            }
            this.f9763b.h(i11, aVar2);
            this.f9763b.c();
            return aVar2.v(this.f9762a, interfaceC0092a);
        } catch (Throwable th2) {
            this.f9763b.c();
            throw th2;
        }
    }

    @Override // androidx.loader.app.a
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f9763b.b(str, fileDescriptor, printWriter, strArr);
    }

    @Override // androidx.loader.app.a
    public androidx.loader.content.a c(int i11, Bundle bundle, a.InterfaceC0092a interfaceC0092a) {
        if (this.f9763b.f()) {
            throw new IllegalStateException("Called while creating a loader");
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("initLoader must be called on the main thread");
        }
        a e11 = this.f9763b.e(i11);
        if (f9761c) {
            Log.v("LoaderManager", "initLoader in " + this + ": args=" + bundle);
        }
        if (e11 == null) {
            return e(i11, bundle, interfaceC0092a, null);
        }
        if (f9761c) {
            Log.v("LoaderManager", "  Re-using existing loader " + e11);
        }
        return e11.v(this.f9762a, interfaceC0092a);
    }

    @Override // androidx.loader.app.a
    public void d() {
        this.f9763b.g();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("LoaderManager{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append(" in ");
        androidx.core.util.b.a(this.f9762a, sb2);
        sb2.append("}}");
        return sb2.toString();
    }
}
