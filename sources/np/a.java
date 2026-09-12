package np;

import android.text.Editable;
import android.text.TextWatcher;

/* loaded from: classes6.dex */
public interface a extends TextWatcher {

    /* renamed from: np.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0881a {
        public static void a(a aVar, Editable editable) {
        }

        public static void b(a aVar, CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    @Override // android.text.TextWatcher
    void afterTextChanged(Editable editable);

    @Override // android.text.TextWatcher
    void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13);
}
