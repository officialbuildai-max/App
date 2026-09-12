package bz;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class a extends PasswordTransformationMethod {

    /* renamed from: bz.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private final class C0158a implements CharSequence {

        /* renamed from: a, reason: collision with root package name */
        private final CharSequence f17038a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f17039b;

        public C0158a(a aVar, CharSequence mSource) {
            Intrinsics.h(mSource, "mSource");
            this.f17039b = aVar;
            this.f17038a = mSource;
        }

        public char a(int i11) {
            return '*';
        }

        public int b() {
            return this.f17038a.length();
        }

        @Override // java.lang.CharSequence
        public final /* bridge */ char charAt(int i11) {
            return a(i11);
        }

        @Override // java.lang.CharSequence
        public final /* bridge */ int length() {
            return b();
        }

        @Override // java.lang.CharSequence
        public CharSequence subSequence(int i11, int i12) {
            return this.f17038a.subSequence(i11, i12);
        }
    }

    @Override // android.text.method.PasswordTransformationMethod, android.text.method.TransformationMethod
    public CharSequence getTransformation(CharSequence source, View view) {
        Intrinsics.h(source, "source");
        Intrinsics.h(view, "view");
        return new C0158a(this, source);
    }
}
