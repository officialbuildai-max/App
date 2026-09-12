package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.R$styleable;

/* loaded from: classes.dex */
class h {

    /* renamed from: a, reason: collision with root package name */
    private final TextView f2107a;

    /* renamed from: b, reason: collision with root package name */
    private final l1.f f2108b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(TextView textView) {
        this.f2107a = textView;
        this.f2108b = new l1.f(textView, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InputFilter[] a(InputFilter[] inputFilterArr) {
        return this.f2108b.a(inputFilterArr);
    }

    public boolean b() {
        return this.f2108b.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(AttributeSet attributeSet, int i11) {
        TypedArray obtainStyledAttributes = this.f2107a.getContext().obtainStyledAttributes(attributeSet, R$styleable.AppCompatTextView, i11, 0);
        try {
            boolean z10 = obtainStyledAttributes.hasValue(R$styleable.AppCompatTextView_emojiCompatEnabled) ? obtainStyledAttributes.getBoolean(R$styleable.AppCompatTextView_emojiCompatEnabled, true) : true;
            obtainStyledAttributes.recycle();
            e(z10);
        } catch (Throwable th2) {
            obtainStyledAttributes.recycle();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(boolean z10) {
        this.f2108b.c(z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(boolean z10) {
        this.f2108b.d(z10);
    }

    public TransformationMethod f(TransformationMethod transformationMethod) {
        return this.f2108b.e(transformationMethod);
    }
}
