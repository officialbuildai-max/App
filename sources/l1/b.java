package l1;

import android.text.Editable;
import androidx.emoji2.text.o;

/* loaded from: classes2.dex */
final class b extends Editable.Factory {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f68576a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static volatile Editable.Factory f68577b;

    /* renamed from: c, reason: collision with root package name */
    private static Class f68578c;

    private b() {
        try {
            f68578c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, b.class.getClassLoader());
        } catch (Throwable unused) {
        }
    }

    public static Editable.Factory getInstance() {
        if (f68577b == null) {
            synchronized (f68576a) {
                try {
                    if (f68577b == null) {
                        f68577b = new b();
                    }
                } finally {
                }
            }
        }
        return f68577b;
    }

    @Override // android.text.Editable.Factory
    public Editable newEditable(CharSequence charSequence) {
        Class cls = f68578c;
        return cls != null ? o.c(cls, charSequence) : super.newEditable(charSequence);
    }
}
