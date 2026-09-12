package com.transsion.baseui.widget.jumpingbeans;

import android.text.SpannableStringBuilder;
import android.widget.TextView;
import java.lang.ref.WeakReference;

/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final JumpingBeansSpan[] f43706a;

    /* renamed from: b, reason: collision with root package name */
    private final WeakReference f43707b;

    /* renamed from: com.transsion.baseui.widget.jumpingbeans.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0611a {

        /* renamed from: a, reason: collision with root package name */
        private final TextView f43708a;

        /* renamed from: b, reason: collision with root package name */
        private int f43709b;

        /* renamed from: c, reason: collision with root package name */
        private int f43710c;

        /* renamed from: d, reason: collision with root package name */
        private float f43711d = 0.65f;

        /* renamed from: e, reason: collision with root package name */
        private int f43712e = 1300;

        /* renamed from: f, reason: collision with root package name */
        private int f43713f = -1;

        /* renamed from: g, reason: collision with root package name */
        private CharSequence f43714g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f43715h;

        C0611a(TextView textView) {
            this.f43708a = textView;
        }

        private JumpingBeansSpan[] b(SpannableStringBuilder spannableStringBuilder) {
            JumpingBeansSpan[] jumpingBeansSpanArr = {new JumpingBeansSpan(this.f43708a, this.f43712e, 0, 0, this.f43711d)};
            spannableStringBuilder.setSpan(jumpingBeansSpanArr[0], this.f43709b, this.f43710c, 33);
            return jumpingBeansSpanArr;
        }

        private JumpingBeansSpan[] c(SpannableStringBuilder spannableStringBuilder) {
            if (this.f43713f == -1) {
                this.f43713f = this.f43712e / ((this.f43710c - this.f43709b) * 3);
            }
            int i11 = this.f43710c;
            int i12 = this.f43709b;
            JumpingBeansSpan[] jumpingBeansSpanArr = new JumpingBeansSpan[i11 - i12];
            while (i12 < this.f43710c) {
                JumpingBeansSpan jumpingBeansSpan = new JumpingBeansSpan(this.f43708a, this.f43712e, i12 - this.f43709b, this.f43713f, this.f43711d);
                int i13 = i12 + 1;
                spannableStringBuilder.setSpan(jumpingBeansSpan, i12, i13, 33);
                jumpingBeansSpanArr[i12 - this.f43709b] = jumpingBeansSpan;
                i12 = i13;
            }
            return jumpingBeansSpanArr;
        }

        private static CharSequence d(int i11, int i12, CharSequence charSequence) {
            if (charSequence == null) {
                throw new NullPointerException("The textView text must not be null");
            }
            if (i12 < i11) {
                throw new IllegalArgumentException("The start position must be smaller than the end position");
            }
            if (i11 < 0) {
                throw new IndexOutOfBoundsException("The start position must be non-negative");
            }
            if (i12 <= charSequence.length()) {
                return charSequence;
            }
            throw new IndexOutOfBoundsException("The end position must be smaller than the text length");
        }

        public a a() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f43714g);
            JumpingBeansSpan[] c11 = this.f43715h ? c(spannableStringBuilder) : b(spannableStringBuilder);
            this.f43708a.setText(spannableStringBuilder);
            return new a(c11, this.f43708a);
        }

        public C0611a e(int i11, int i12) {
            CharSequence text = this.f43708a.getText();
            d(i11, i12, text);
            this.f43714g = text;
            this.f43715h = true;
            this.f43709b = i11;
            this.f43710c = i12;
            return this;
        }

        public C0611a f(float f11) {
            if (f11 <= 0.0f || f11 > 1.0f) {
                throw new IllegalArgumentException("The animated range must be in the (0, 1] range");
            }
            this.f43711d = f11;
            return this;
        }

        public C0611a g(boolean z10) {
            this.f43715h = z10;
            return this;
        }

        public C0611a h(int i11) {
            if (i11 < 1) {
                throw new IllegalArgumentException("The loop duration must be bigger than zero");
            }
            this.f43712e = i11;
            return this;
        }

        public C0611a i(int i11) {
            if (i11 < 0) {
                throw new IllegalArgumentException("The wave char offset must be non-negative");
            }
            this.f43713f = i11;
            return this;
        }
    }

    private a(JumpingBeansSpan[] jumpingBeansSpanArr, TextView textView) {
        this.f43706a = jumpingBeansSpanArr;
        this.f43707b = new WeakReference(textView);
    }

    public static C0611a a(TextView textView) {
        return new C0611a(textView);
    }
}
