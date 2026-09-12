package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.R$layout;
import androidx.appcompat.app.c;
import androidx.appcompat.view.menu.l;

/* loaded from: classes.dex */
class g implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, l.a {

    /* renamed from: a, reason: collision with root package name */
    private f f1540a;

    /* renamed from: b, reason: collision with root package name */
    private androidx.appcompat.app.c f1541b;

    /* renamed from: c, reason: collision with root package name */
    d f1542c;

    /* renamed from: d, reason: collision with root package name */
    private l.a f1543d;

    public g(f fVar) {
        this.f1540a = fVar;
    }

    public void a() {
        androidx.appcompat.app.c cVar = this.f1541b;
        if (cVar != null) {
            cVar.dismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.l.a
    public void b(f fVar, boolean z10) {
        if (z10 || fVar == this.f1540a) {
            a();
        }
        l.a aVar = this.f1543d;
        if (aVar != null) {
            aVar.b(fVar, z10);
        }
    }

    @Override // androidx.appcompat.view.menu.l.a
    public boolean c(f fVar) {
        l.a aVar = this.f1543d;
        if (aVar != null) {
            return aVar.c(fVar);
        }
        return false;
    }

    public void d(IBinder iBinder) {
        f fVar = this.f1540a;
        c.a aVar = new c.a(fVar.w());
        d dVar = new d(aVar.getContext(), R$layout.abc_list_menu_item_layout);
        this.f1542c = dVar;
        dVar.d(this);
        this.f1540a.b(this.f1542c);
        aVar.a(this.f1542c.a(), this);
        View A = fVar.A();
        if (A != null) {
            aVar.b(A);
        } else {
            aVar.c(fVar.y()).setTitle(fVar.z());
        }
        aVar.f(this);
        androidx.appcompat.app.c create = aVar.create();
        this.f1541b = create;
        create.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f1541b.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f1541b.show();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i11) {
        this.f1540a.O((h) this.f1542c.a().getItem(i11), 0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f1542c.b(this.f1540a, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i11, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i11 == 82 || i11 == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f1541b.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f1541b.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f1540a.e(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f1540a.performShortcut(i11, keyEvent, 0);
    }
}
