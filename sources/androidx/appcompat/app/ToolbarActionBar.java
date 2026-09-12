package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.n0;
import androidx.core.view.ViewCompat;
import com.cloud.tmc.offline.download.model.TaskResultKt;
import java.util.ArrayList;

/* loaded from: classes.dex */
class ToolbarActionBar extends androidx.appcompat.app.a {

    /* renamed from: a, reason: collision with root package name */
    final androidx.appcompat.widget.t f1165a;

    /* renamed from: b, reason: collision with root package name */
    final Window.Callback f1166b;

    /* renamed from: c, reason: collision with root package name */
    final AppCompatDelegateImpl.e f1167c;

    /* renamed from: d, reason: collision with root package name */
    boolean f1168d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f1169e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f1170f;

    /* renamed from: g, reason: collision with root package name */
    private ArrayList f1171g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    private final Runnable f1172h = new Runnable() { // from class: androidx.appcompat.app.ToolbarActionBar.1
        @Override // java.lang.Runnable
        public void run() {
            ToolbarActionBar.this.x();
        }
    };

    /* renamed from: i, reason: collision with root package name */
    private final Toolbar.g f1173i;

    /* loaded from: classes.dex */
    class a implements Toolbar.g {
        a() {
        }

        @Override // androidx.appcompat.widget.Toolbar.g
        public boolean onMenuItemClick(MenuItem menuItem) {
            return ToolbarActionBar.this.f1166b.onMenuItemSelected(0, menuItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class b implements l.a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f1175a;

        b() {
        }

        @Override // androidx.appcompat.view.menu.l.a
        public void b(androidx.appcompat.view.menu.f fVar, boolean z10) {
            if (this.f1175a) {
                return;
            }
            this.f1175a = true;
            ToolbarActionBar.this.f1165a.k();
            ToolbarActionBar.this.f1166b.onPanelClosed(TaskResultKt.ERROR_LOAD_RESPONSE_STR_EMPTY, fVar);
            this.f1175a = false;
        }

        @Override // androidx.appcompat.view.menu.l.a
        public boolean c(androidx.appcompat.view.menu.f fVar) {
            ToolbarActionBar.this.f1166b.onMenuOpened(TaskResultKt.ERROR_LOAD_RESPONSE_STR_EMPTY, fVar);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class c implements f.a {
        c() {
        }

        @Override // androidx.appcompat.view.menu.f.a
        public boolean a(androidx.appcompat.view.menu.f fVar, MenuItem menuItem) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.f.a
        public void b(androidx.appcompat.view.menu.f fVar) {
            if (ToolbarActionBar.this.f1165a.isOverflowMenuShowing()) {
                ToolbarActionBar.this.f1166b.onPanelClosed(TaskResultKt.ERROR_LOAD_RESPONSE_STR_EMPTY, fVar);
            } else if (ToolbarActionBar.this.f1166b.onPreparePanel(0, null, fVar)) {
                ToolbarActionBar.this.f1166b.onMenuOpened(TaskResultKt.ERROR_LOAD_RESPONSE_STR_EMPTY, fVar);
            }
        }
    }

    /* loaded from: classes.dex */
    private class d implements AppCompatDelegateImpl.e {
        d() {
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.e
        public boolean a(int i11) {
            if (i11 != 0) {
                return false;
            }
            ToolbarActionBar toolbarActionBar = ToolbarActionBar.this;
            if (toolbarActionBar.f1168d) {
                return false;
            }
            toolbarActionBar.f1165a.setMenuPrepared();
            ToolbarActionBar.this.f1168d = true;
            return false;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.e
        public View onCreatePanelView(int i11) {
            if (i11 == 0) {
                return new View(ToolbarActionBar.this.f1165a.getContext());
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ToolbarActionBar(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        a aVar = new a();
        this.f1173i = aVar;
        androidx.core.util.i.g(toolbar);
        n0 n0Var = new n0(toolbar, false);
        this.f1165a = n0Var;
        this.f1166b = (Window.Callback) androidx.core.util.i.g(callback);
        n0Var.setWindowCallback(callback);
        toolbar.setOnMenuItemClickListener(aVar);
        n0Var.setWindowTitle(charSequence);
        this.f1167c = new d();
    }

    private Menu w() {
        if (!this.f1169e) {
            this.f1165a.o(new b(), new c());
            this.f1169e = true;
        }
        return this.f1165a.c();
    }

    @Override // androidx.appcompat.app.a
    public boolean g() {
        return this.f1165a.hideOverflowMenu();
    }

    @Override // androidx.appcompat.app.a
    public boolean h() {
        if (!this.f1165a.a()) {
            return false;
        }
        this.f1165a.collapseActionView();
        return true;
    }

    @Override // androidx.appcompat.app.a
    public void i(boolean z10) {
        if (z10 == this.f1170f) {
            return;
        }
        this.f1170f = z10;
        if (this.f1171g.size() <= 0) {
            return;
        }
        android.support.v4.media.session.c.a(this.f1171g.get(0));
        throw null;
    }

    @Override // androidx.appcompat.app.a
    public int j() {
        return this.f1165a.r();
    }

    @Override // androidx.appcompat.app.a
    public Context k() {
        return this.f1165a.getContext();
    }

    @Override // androidx.appcompat.app.a
    public void l() {
        this.f1165a.setVisibility(8);
    }

    @Override // androidx.appcompat.app.a
    public boolean m() {
        this.f1165a.g().removeCallbacks(this.f1172h);
        ViewCompat.postOnAnimation(this.f1165a.g(), this.f1172h);
        return true;
    }

    @Override // androidx.appcompat.app.a
    public void n(Configuration configuration) {
        super.n(configuration);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.app.a
    public void o() {
        this.f1165a.g().removeCallbacks(this.f1172h);
    }

    @Override // androidx.appcompat.app.a
    public boolean p(int i11, KeyEvent keyEvent) {
        Menu w11 = w();
        if (w11 == null) {
            return false;
        }
        w11.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return w11.performShortcut(i11, keyEvent, 0);
    }

    @Override // androidx.appcompat.app.a
    public boolean q(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            r();
        }
        return true;
    }

    @Override // androidx.appcompat.app.a
    public boolean r() {
        return this.f1165a.showOverflowMenu();
    }

    @Override // androidx.appcompat.app.a
    public void s(boolean z10) {
    }

    @Override // androidx.appcompat.app.a
    public void t(boolean z10) {
    }

    @Override // androidx.appcompat.app.a
    public void u(CharSequence charSequence) {
        this.f1165a.setWindowTitle(charSequence);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void x() {
        /*
            r5 = this;
            android.view.Menu r0 = r5.w()
            boolean r1 = r0 instanceof androidx.appcompat.view.menu.f
            r2 = 0
            if (r1 == 0) goto Ld
            r1 = r0
            androidx.appcompat.view.menu.f r1 = (androidx.appcompat.view.menu.f) r1
            goto Le
        Ld:
            r1 = r2
        Le:
            if (r1 == 0) goto L13
            r1.i0()
        L13:
            r0.clear()     // Catch: java.lang.Throwable -> L28
            android.view.Window$Callback r3 = r5.f1166b     // Catch: java.lang.Throwable -> L28
            r4 = 0
            boolean r3 = r3.onCreatePanelMenu(r4, r0)     // Catch: java.lang.Throwable -> L28
            if (r3 == 0) goto L2a
            android.view.Window$Callback r3 = r5.f1166b     // Catch: java.lang.Throwable -> L28
            boolean r2 = r3.onPreparePanel(r4, r2, r0)     // Catch: java.lang.Throwable -> L28
            if (r2 != 0) goto L2d
            goto L2a
        L28:
            r0 = move-exception
            goto L33
        L2a:
            r0.clear()     // Catch: java.lang.Throwable -> L28
        L2d:
            if (r1 == 0) goto L32
            r1.h0()
        L32:
            return
        L33:
            if (r1 == 0) goto L38
            r1.h0()
        L38:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.ToolbarActionBar.x():void");
    }
}
