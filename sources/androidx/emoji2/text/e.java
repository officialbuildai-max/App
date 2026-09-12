package androidx.emoji2.text;

import android.text.TextPaint;
import androidx.emoji2.text.EmojiCompat;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements EmojiCompat.e {

    /* renamed from: b, reason: collision with root package name */
    private static final ThreadLocal f9153b = new ThreadLocal();

    /* renamed from: a, reason: collision with root package name */
    private final TextPaint f9154a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e() {
        TextPaint textPaint = new TextPaint();
        this.f9154a = textPaint;
        textPaint.setTextSize(10.0f);
    }

    private static StringBuilder b() {
        ThreadLocal threadLocal = f9153b;
        if (threadLocal.get() == null) {
            threadLocal.set(new StringBuilder());
        }
        return (StringBuilder) threadLocal.get();
    }

    @Override // androidx.emoji2.text.EmojiCompat.e
    public boolean a(CharSequence charSequence, int i11, int i12, int i13) {
        StringBuilder b11 = b();
        b11.setLength(0);
        while (i11 < i12) {
            b11.append(charSequence.charAt(i11));
            i11++;
        }
        return z0.d.a(this.f9154a, b11.toString());
    }
}
