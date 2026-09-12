package l1;

import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import androidx.emoji2.text.EmojiCompat;

/* loaded from: classes2.dex */
final class e implements KeyListener {

    /* renamed from: a, reason: collision with root package name */
    private final KeyListener f68585a;

    /* renamed from: b, reason: collision with root package name */
    private final a f68586b;

    /* loaded from: classes2.dex */
    public static class a {
        public boolean a(Editable editable, int i11, KeyEvent keyEvent) {
            return EmojiCompat.g(editable, i11, keyEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(KeyListener keyListener) {
        this(keyListener, new a());
    }

    e(KeyListener keyListener, a aVar) {
        this.f68585a = keyListener;
        this.f68586b = aVar;
    }

    @Override // android.text.method.KeyListener
    public void clearMetaKeyState(View view, Editable editable, int i11) {
        this.f68585a.clearMetaKeyState(view, editable, i11);
    }

    @Override // android.text.method.KeyListener
    public int getInputType() {
        return this.f68585a.getInputType();
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyDown(View view, Editable editable, int i11, KeyEvent keyEvent) {
        return this.f68586b.a(editable, i11, keyEvent) || this.f68585a.onKeyDown(view, editable, i11, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
        return this.f68585a.onKeyOther(view, editable, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyUp(View view, Editable editable, int i11, KeyEvent keyEvent) {
        return this.f68585a.onKeyUp(view, editable, i11, keyEvent);
    }
}
