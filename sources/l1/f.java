package l1;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;
import androidx.core.util.i;
import androidx.emoji2.text.EmojiCompat;

/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private final b f68587a;

    /* loaded from: classes2.dex */
    private static class a extends b {

        /* renamed from: a, reason: collision with root package name */
        private final TextView f68588a;

        /* renamed from: b, reason: collision with root package name */
        private final d f68589b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f68590c = true;

        a(TextView textView) {
            this.f68588a = textView;
            this.f68589b = new d(textView);
        }

        private InputFilter[] f(InputFilter[] inputFilterArr) {
            int length = inputFilterArr.length;
            for (InputFilter inputFilter : inputFilterArr) {
                if (inputFilter == this.f68589b) {
                    return inputFilterArr;
                }
            }
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length + 1];
            System.arraycopy(inputFilterArr, 0, inputFilterArr2, 0, length);
            inputFilterArr2[length] = this.f68589b;
            return inputFilterArr2;
        }

        private SparseArray g(InputFilter[] inputFilterArr) {
            SparseArray sparseArray = new SparseArray(1);
            for (int i11 = 0; i11 < inputFilterArr.length; i11++) {
                InputFilter inputFilter = inputFilterArr[i11];
                if (inputFilter instanceof d) {
                    sparseArray.put(i11, inputFilter);
                }
            }
            return sparseArray;
        }

        private InputFilter[] h(InputFilter[] inputFilterArr) {
            SparseArray g11 = g(inputFilterArr);
            if (g11.size() == 0) {
                return inputFilterArr;
            }
            int length = inputFilterArr.length;
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length - g11.size()];
            int i11 = 0;
            for (int i12 = 0; i12 < length; i12++) {
                if (g11.indexOfKey(i12) < 0) {
                    inputFilterArr2[i11] = inputFilterArr[i12];
                    i11++;
                }
            }
            return inputFilterArr2;
        }

        private TransformationMethod j(TransformationMethod transformationMethod) {
            return transformationMethod instanceof h ? ((h) transformationMethod).a() : transformationMethod;
        }

        private void k() {
            this.f68588a.setFilters(a(this.f68588a.getFilters()));
        }

        private TransformationMethod m(TransformationMethod transformationMethod) {
            return ((transformationMethod instanceof h) || (transformationMethod instanceof PasswordTransformationMethod)) ? transformationMethod : new h(transformationMethod);
        }

        @Override // l1.f.b
        InputFilter[] a(InputFilter[] inputFilterArr) {
            return !this.f68590c ? h(inputFilterArr) : f(inputFilterArr);
        }

        @Override // l1.f.b
        public boolean b() {
            return this.f68590c;
        }

        @Override // l1.f.b
        void c(boolean z10) {
            if (z10) {
                l();
            }
        }

        @Override // l1.f.b
        void d(boolean z10) {
            this.f68590c = z10;
            l();
            k();
        }

        @Override // l1.f.b
        TransformationMethod e(TransformationMethod transformationMethod) {
            return this.f68590c ? m(transformationMethod) : j(transformationMethod);
        }

        void i(boolean z10) {
            this.f68590c = z10;
        }

        void l() {
            this.f68588a.setTransformationMethod(e(this.f68588a.getTransformationMethod()));
        }
    }

    /* loaded from: classes2.dex */
    static class b {
        b() {
        }

        abstract InputFilter[] a(InputFilter[] inputFilterArr);

        public abstract boolean b();

        abstract void c(boolean z10);

        abstract void d(boolean z10);

        abstract TransformationMethod e(TransformationMethod transformationMethod);
    }

    /* loaded from: classes2.dex */
    private static class c extends b {

        /* renamed from: a, reason: collision with root package name */
        private final a f68591a;

        c(TextView textView) {
            this.f68591a = new a(textView);
        }

        private boolean f() {
            return !EmojiCompat.i();
        }

        @Override // l1.f.b
        InputFilter[] a(InputFilter[] inputFilterArr) {
            return f() ? inputFilterArr : this.f68591a.a(inputFilterArr);
        }

        @Override // l1.f.b
        public boolean b() {
            return this.f68591a.b();
        }

        @Override // l1.f.b
        void c(boolean z10) {
            if (f()) {
                return;
            }
            this.f68591a.c(z10);
        }

        @Override // l1.f.b
        void d(boolean z10) {
            if (f()) {
                this.f68591a.i(z10);
            } else {
                this.f68591a.d(z10);
            }
        }

        @Override // l1.f.b
        TransformationMethod e(TransformationMethod transformationMethod) {
            return f() ? transformationMethod : this.f68591a.e(transformationMethod);
        }
    }

    public f(TextView textView, boolean z10) {
        i.h(textView, "textView cannot be null");
        if (z10) {
            this.f68587a = new a(textView);
        } else {
            this.f68587a = new c(textView);
        }
    }

    public InputFilter[] a(InputFilter[] inputFilterArr) {
        return this.f68587a.a(inputFilterArr);
    }

    public boolean b() {
        return this.f68587a.b();
    }

    public void c(boolean z10) {
        this.f68587a.c(z10);
    }

    public void d(boolean z10) {
        this.f68587a.d(z10);
    }

    public TransformationMethod e(TransformationMethod transformationMethod) {
        return this.f68587a.e(transformationMethod);
    }
}
