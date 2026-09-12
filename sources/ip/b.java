package ip;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.w;
import com.blankj.utilcode.util.KeyboardUtils;
import com.transsion.publish.R$layout;
import com.transsion.publish.R$style;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import np.j;

/* loaded from: classes6.dex */
public final class b extends w {

    /* renamed from: a, reason: collision with root package name */
    private j f65712a;

    /* renamed from: b, reason: collision with root package name */
    private InterfaceC0821b f65713b;

    /* renamed from: c, reason: collision with root package name */
    private View f65714c;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final Context f65715a;

        public a(Context context) {
            Intrinsics.h(context, "context");
            this.f65715a = context;
        }

        public final b a(InterfaceC0821b listener, View view) {
            Intrinsics.h(listener, "listener");
            return new b(this.f65715a, listener, view, null);
        }
    }

    /* renamed from: ip.b$b, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0821b {
        void completeLoad();
    }

    private b(Context context, InterfaceC0821b interfaceC0821b, View view) {
        super(context, R$style.CommentEditInputDialogTheme);
        this.f65713b = interfaceC0821b;
        this.f65714c = view;
        setContentView(R$layout.dialog_link_input_edit);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(80);
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (attributes != null) {
                if (attributes.width != -1) {
                    attributes.width = -1;
                }
                if (attributes.height != -2) {
                    attributes.height = -2;
                }
                window.setAttributes(attributes);
                window.setSoftInputMode(4);
            }
        }
        this.f65712a = new j(null, this, interfaceC0821b, this.f65714c, true, 1, null);
        np.b bVar = new np.b();
        j jVar = this.f65712a;
        if (jVar != null) {
            jVar.k(bVar);
        }
        setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: ip.a
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i11, KeyEvent keyEvent) {
                boolean g11;
                g11 = b.g(b.this, dialogInterface, i11, keyEvent);
                return g11;
            }
        });
    }

    public /* synthetic */ b(Context context, InterfaceC0821b interfaceC0821b, View view, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, interfaceC0821b, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean g(b bVar, DialogInterface dialogInterface, int i11, KeyEvent keyEvent) {
        if (i11 != 4 || keyEvent.getRepeatCount() != 0) {
            return false;
        }
        bVar.dismiss();
        return false;
    }

    private final void h() {
    }

    private final void i() {
    }

    @Override // androidx.appcompat.app.w, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        View j11;
        super.dismiss();
        this.f65714c = null;
        j jVar = this.f65712a;
        if (jVar == null || (j11 = jVar.j()) == null) {
            return;
        }
        KeyboardUtils.e(j11);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.w, androidx.activity.q, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.q, android.app.Dialog
    public void onStart() {
        super.onStart();
        h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.w, androidx.activity.q, android.app.Dialog
    public void onStop() {
        super.onStop();
        i();
    }
}
