package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$attr;
import androidx.appcompat.app.AlertController;

/* loaded from: classes.dex */
public class c extends w implements DialogInterface {

    /* renamed from: a, reason: collision with root package name */
    final AlertController f1192a;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final AlertController.b f1193a;

        /* renamed from: b, reason: collision with root package name */
        private final int f1194b;

        public a(Context context) {
            this(context, c.g(context, 0));
        }

        public a(@NonNull Context context, int i11) {
            this.f1193a = new AlertController.b(new ContextThemeWrapper(context, c.g(context, i11)));
            this.f1194b = i11;
        }

        public a a(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f1193a;
            bVar.f1071w = listAdapter;
            bVar.f1072x = onClickListener;
            return this;
        }

        public a b(View view) {
            this.f1193a.f1055g = view;
            return this;
        }

        public a c(Drawable drawable) {
            this.f1193a.f1052d = drawable;
            return this;
        }

        @NonNull
        public c create() {
            c cVar = new c(this.f1193a.f1049a, this.f1194b);
            this.f1193a.a(cVar.f1192a);
            cVar.setCancelable(this.f1193a.f1066r);
            if (this.f1193a.f1066r) {
                cVar.setCanceledOnTouchOutside(true);
            }
            cVar.setOnCancelListener(this.f1193a.f1067s);
            cVar.setOnDismissListener(this.f1193a.f1068t);
            DialogInterface.OnKeyListener onKeyListener = this.f1193a.f1069u;
            if (onKeyListener != null) {
                cVar.setOnKeyListener(onKeyListener);
            }
            return cVar;
        }

        public a d(CharSequence charSequence) {
            this.f1193a.f1056h = charSequence;
            return this;
        }

        public a e(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f1193a;
            bVar.f1060l = charSequence;
            bVar.f1062n = onClickListener;
            return this;
        }

        public a f(DialogInterface.OnKeyListener onKeyListener) {
            this.f1193a.f1069u = onKeyListener;
            return this;
        }

        public a g(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f1193a;
            bVar.f1057i = charSequence;
            bVar.f1059k = onClickListener;
            return this;
        }

        @NonNull
        public Context getContext() {
            return this.f1193a.f1049a;
        }

        public a h(ListAdapter listAdapter, int i11, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f1193a;
            bVar.f1071w = listAdapter;
            bVar.f1072x = onClickListener;
            bVar.I = i11;
            bVar.H = true;
            return this;
        }

        public a setNegativeButton(int i11, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f1193a;
            bVar.f1060l = bVar.f1049a.getText(i11);
            this.f1193a.f1062n = onClickListener;
            return this;
        }

        public a setPositiveButton(int i11, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f1193a;
            bVar.f1057i = bVar.f1049a.getText(i11);
            this.f1193a.f1059k = onClickListener;
            return this;
        }

        public a setTitle(@Nullable CharSequence charSequence) {
            this.f1193a.f1054f = charSequence;
            return this;
        }

        public a setView(View view) {
            AlertController.b bVar = this.f1193a;
            bVar.f1074z = view;
            bVar.f1073y = 0;
            bVar.E = false;
            return this;
        }
    }

    protected c(Context context, int i11) {
        super(context, g(context, i11));
        this.f1192a = new AlertController(getContext(), this, getWindow());
    }

    static int g(Context context, int i11) {
        if (((i11 >>> 24) & 255) >= 1) {
            return i11;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView f() {
        return this.f1192a.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.w, androidx.activity.q, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1192a.e();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i11, KeyEvent keyEvent) {
        if (this.f1192a.g(i11, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i11, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i11, KeyEvent keyEvent) {
        if (this.f1192a.h(i11, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i11, keyEvent);
    }

    @Override // androidx.appcompat.app.w, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f1192a.q(charSequence);
    }
}
