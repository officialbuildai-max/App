package l1;

import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.widget.TextView;
import androidx.emoji2.text.EmojiCompat;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
final class d implements InputFilter {

    /* renamed from: a, reason: collision with root package name */
    private final TextView f68581a;

    /* renamed from: b, reason: collision with root package name */
    private EmojiCompat.f f68582b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a extends EmojiCompat.f {

        /* renamed from: a, reason: collision with root package name */
        private final Reference f68583a;

        /* renamed from: b, reason: collision with root package name */
        private final Reference f68584b;

        a(TextView textView, d dVar) {
            this.f68583a = new WeakReference(textView);
            this.f68584b = new WeakReference(dVar);
        }

        private boolean c(TextView textView, InputFilter inputFilter) {
            InputFilter[] filters;
            if (inputFilter == null || textView == null || (filters = textView.getFilters()) == null) {
                return false;
            }
            for (InputFilter inputFilter2 : filters) {
                if (inputFilter2 == inputFilter) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.emoji2.text.EmojiCompat.f
        public void b() {
            CharSequence text;
            CharSequence p11;
            super.b();
            TextView textView = (TextView) this.f68583a.get();
            if (c(textView, (InputFilter) this.f68584b.get()) && textView.isAttachedToWindow() && text != (p11 = EmojiCompat.c().p((text = textView.getText())))) {
                int selectionStart = Selection.getSelectionStart(p11);
                int selectionEnd = Selection.getSelectionEnd(p11);
                textView.setText(p11);
                if (p11 instanceof Spannable) {
                    d.b((Spannable) p11, selectionStart, selectionEnd);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(TextView textView) {
        this.f68581a = textView;
    }

    private EmojiCompat.f a() {
        if (this.f68582b == null) {
            this.f68582b = new a(this.f68581a, this);
        }
        return this.f68582b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Spannable spannable, int i11, int i12) {
        if (i11 >= 0 && i12 >= 0) {
            Selection.setSelection(spannable, i11, i12);
        } else if (i11 >= 0) {
            Selection.setSelection(spannable, i11);
        } else if (i12 >= 0) {
            Selection.setSelection(spannable, i12);
        }
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i11, int i12, Spanned spanned, int i13, int i14) {
        if (this.f68581a.isInEditMode()) {
            return charSequence;
        }
        int e11 = EmojiCompat.c().e();
        if (e11 != 0) {
            if (e11 == 1) {
                if ((i14 == 0 && i13 == 0 && spanned.length() == 0 && charSequence == this.f68581a.getText()) || charSequence == null) {
                    return charSequence;
                }
                if (i11 != 0 || i12 != charSequence.length()) {
                    charSequence = charSequence.subSequence(i11, i12);
                }
                return EmojiCompat.c().q(charSequence, 0, charSequence.length());
            }
            if (e11 != 3) {
                return charSequence;
            }
        }
        EmojiCompat.c().t(a());
        return charSequence;
    }
}
