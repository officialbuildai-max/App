package wa;

import android.os.Build;
import android.view.View;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.NonNull;
import java.util.Objects;

/* loaded from: classes5.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final d f77736a;

    /* renamed from: b, reason: collision with root package name */
    private final wa.b f77737b;

    /* renamed from: c, reason: collision with root package name */
    private final View f77738c;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class b implements d {

        /* renamed from: a, reason: collision with root package name */
        private OnBackInvokedCallback f77739a;

        private b() {
        }

        @Override // wa.c.d
        public void a(@NonNull View view) {
            OnBackInvokedDispatcher findOnBackInvokedDispatcher;
            findOnBackInvokedDispatcher = view.findOnBackInvokedDispatcher();
            if (findOnBackInvokedDispatcher == null) {
                return;
            }
            findOnBackInvokedDispatcher.unregisterOnBackInvokedCallback(this.f77739a);
            this.f77739a = null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:5:0x0005, code lost:
        
            r3 = r3.findOnBackInvokedDispatcher();
         */
        @Override // wa.c.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void b(@androidx.annotation.NonNull wa.b r2, @androidx.annotation.NonNull android.view.View r3, boolean r4) {
            /*
                r1 = this;
                android.window.OnBackInvokedCallback r0 = r1.f77739a
                if (r0 == 0) goto L5
                return
            L5:
                android.window.OnBackInvokedDispatcher r3 = wa.d.a(r3)
                if (r3 != 0) goto Lc
                return
            Lc:
                android.window.OnBackInvokedCallback r2 = r1.c(r2)
                r1.f77739a = r2
                if (r4 == 0) goto L18
                r4 = 1000000(0xf4240, float:1.401298E-39)
                goto L19
            L18:
                r4 = 0
            L19:
                androidx.appcompat.app.t.a(r3, r4, r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: wa.c.b.b(wa.b, android.view.View, boolean):void");
        }

        OnBackInvokedCallback c(final wa.b bVar) {
            Objects.requireNonNull(bVar);
            return new OnBackInvokedCallback() { // from class: wa.e
                public final void onBackInvoked() {
                    b.this.handleBackInvoked();
                }
            };
        }

        boolean d() {
            return this.f77739a != null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: wa.c$c, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0984c extends b {

        /* renamed from: wa.c$c$a */
        /* loaded from: classes5.dex */
        class a implements OnBackAnimationCallback {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ wa.b f77740a;

            a(wa.b bVar) {
                this.f77740a = bVar;
            }

            public void onBackCancelled() {
                if (C0984c.this.d()) {
                    this.f77740a.cancelBackProgress();
                }
            }

            public void onBackInvoked() {
                this.f77740a.handleBackInvoked();
            }

            public void onBackProgressed(BackEvent backEvent) {
                if (C0984c.this.d()) {
                    this.f77740a.updateBackProgress(new androidx.activity.b(backEvent));
                }
            }

            public void onBackStarted(BackEvent backEvent) {
                if (C0984c.this.d()) {
                    this.f77740a.startBackProgress(new androidx.activity.b(backEvent));
                }
            }
        }

        private C0984c() {
            super();
        }

        @Override // wa.c.b
        OnBackInvokedCallback c(wa.b bVar) {
            return new a(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public interface d {
        void a(View view);

        void b(wa.b bVar, View view, boolean z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(View view) {
        this((wa.b) view, view);
    }

    public c(wa.b bVar, View view) {
        this.f77736a = a();
        this.f77737b = bVar;
        this.f77738c = view;
    }

    private static d a() {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 34) {
            return new C0984c();
        }
        if (i11 >= 33) {
            return new b();
        }
        return null;
    }

    private void d(boolean z10) {
        d dVar = this.f77736a;
        if (dVar != null) {
            dVar.b(this.f77737b, this.f77738c, z10);
        }
    }

    public boolean b() {
        return this.f77736a != null;
    }

    public void c() {
        d(false);
    }

    public void e() {
        d(true);
    }

    public void f() {
        d dVar = this.f77736a;
        if (dVar != null) {
            dVar.a(this.f77738c);
        }
    }
}
