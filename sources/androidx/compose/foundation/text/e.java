package androidx.compose.foundation.text;

import androidx.compose.ui.text.input.v;

/* loaded from: classes.dex */
final class e implements v {

    /* renamed from: b, reason: collision with root package name */
    private final v f3278b;

    /* renamed from: c, reason: collision with root package name */
    private final int f3279c;

    /* renamed from: d, reason: collision with root package name */
    private final int f3280d;

    public e(v vVar, int i11, int i12) {
        this.f3278b = vVar;
        this.f3279c = i11;
        this.f3280d = i12;
    }

    @Override // androidx.compose.ui.text.input.v
    public int a(int i11) {
        int a11 = this.f3278b.a(i11);
        if (i11 >= 0 && i11 <= this.f3279c) {
            f.c(a11, this.f3280d, i11);
        }
        return a11;
    }
}
