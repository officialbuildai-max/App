package l1;

import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.core.util.i;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final b f68571a;

    /* renamed from: b, reason: collision with root package name */
    private int f68572b = Integer.MAX_VALUE;

    /* renamed from: c, reason: collision with root package name */
    private int f68573c = 0;

    /* renamed from: l1.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class C0849a extends b {

        /* renamed from: a, reason: collision with root package name */
        private final EditText f68574a;

        /* renamed from: b, reason: collision with root package name */
        private final g f68575b;

        C0849a(EditText editText, boolean z10) {
            this.f68574a = editText;
            g gVar = new g(editText, z10);
            this.f68575b = gVar;
            editText.addTextChangedListener(gVar);
            editText.setEditableFactory(l1.b.getInstance());
        }

        @Override // l1.a.b
        KeyListener a(KeyListener keyListener) {
            if (keyListener instanceof e) {
                return keyListener;
            }
            if (keyListener == null) {
                return null;
            }
            return keyListener instanceof NumberKeyListener ? keyListener : new e(keyListener);
        }

        @Override // l1.a.b
        boolean b() {
            return this.f68575b.b();
        }

        @Override // l1.a.b
        InputConnection c(InputConnection inputConnection, EditorInfo editorInfo) {
            return inputConnection instanceof c ? inputConnection : new c(this.f68574a, inputConnection, editorInfo);
        }

        @Override // l1.a.b
        void d(boolean z10) {
            this.f68575b.d(z10);
        }
    }

    /* loaded from: classes2.dex */
    static class b {
        b() {
        }

        abstract KeyListener a(KeyListener keyListener);

        abstract boolean b();

        abstract InputConnection c(InputConnection inputConnection, EditorInfo editorInfo);

        abstract void d(boolean z10);
    }

    public a(EditText editText, boolean z10) {
        i.h(editText, "editText cannot be null");
        this.f68571a = new C0849a(editText, z10);
    }

    public KeyListener a(KeyListener keyListener) {
        return this.f68571a.a(keyListener);
    }

    public boolean b() {
        return this.f68571a.b();
    }

    public InputConnection c(InputConnection inputConnection, EditorInfo editorInfo) {
        if (inputConnection == null) {
            return null;
        }
        return this.f68571a.c(inputConnection, editorInfo);
    }

    public void d(boolean z10) {
        this.f68571a.d(z10);
    }
}
