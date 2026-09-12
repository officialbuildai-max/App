package l1;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.emoji2.text.EmojiCompat;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
final class g implements TextWatcher {

    /* renamed from: a, reason: collision with root package name */
    private final EditText f68592a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f68593b;

    /* renamed from: c, reason: collision with root package name */
    private EmojiCompat.f f68594c;

    /* renamed from: d, reason: collision with root package name */
    private int f68595d = Integer.MAX_VALUE;

    /* renamed from: e, reason: collision with root package name */
    private int f68596e = 0;

    /* renamed from: f, reason: collision with root package name */
    private boolean f68597f = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a extends EmojiCompat.f {

        /* renamed from: a, reason: collision with root package name */
        private final Reference f68598a;

        a(EditText editText) {
            this.f68598a = new WeakReference(editText);
        }

        @Override // androidx.emoji2.text.EmojiCompat.f
        public void b() {
            super.b();
            g.c((EditText) this.f68598a.get(), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(EditText editText, boolean z10) {
        this.f68592a = editText;
        this.f68593b = z10;
    }

    private EmojiCompat.f a() {
        if (this.f68594c == null) {
            this.f68594c = new a(this.f68592a);
        }
        return this.f68594c;
    }

    static void c(EditText editText, int i11) {
        if (i11 == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            EmojiCompat.c().p(editableText);
            d.b(editableText, selectionStart, selectionEnd);
        }
    }

    private boolean e() {
        return (this.f68597f && (this.f68593b || EmojiCompat.i())) ? false : true;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    public boolean b() {
        return this.f68597f;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
    }

    public void d(boolean z10) {
        if (this.f68597f != z10) {
            if (this.f68594c != null) {
                EmojiCompat.c().u(this.f68594c);
            }
            this.f68597f = z10;
            if (z10) {
                c(this.f68592a, EmojiCompat.c().e());
            }
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        if (this.f68592a.isInEditMode() || e() || i12 > i13 || !(charSequence instanceof Spannable)) {
            return;
        }
        int e11 = EmojiCompat.c().e();
        if (e11 != 0) {
            if (e11 == 1) {
                EmojiCompat.c().s((Spannable) charSequence, i11, i11 + i13, this.f68595d, this.f68596e);
                return;
            } else if (e11 != 3) {
                return;
            }
        }
        EmojiCompat.c().t(a());
    }
}
