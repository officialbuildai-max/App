package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.lazy.layout.b;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
public final class c0 implements b {

    /* renamed from: a, reason: collision with root package name */
    private final androidx.compose.runtime.collection.b f3109a = new androidx.compose.runtime.collection.b(new b.a[16], 0);

    /* renamed from: b, reason: collision with root package name */
    private int f3110b;

    /* renamed from: c, reason: collision with root package name */
    private b.a f3111c;

    private final void c(int i11) {
        if (i11 < 0 || i11 >= getSize()) {
            throw new IndexOutOfBoundsException("Index " + i11 + ", size " + getSize());
        }
    }

    private final boolean d(b.a aVar, int i11) {
        return i11 < aVar.b() + aVar.a() && aVar.b() <= i11;
    }

    private final b.a e(int i11) {
        int b11;
        b.a aVar = this.f3111c;
        if (aVar != null && d(aVar, i11)) {
            return aVar;
        }
        androidx.compose.runtime.collection.b bVar = this.f3109a;
        b11 = c.b(bVar, i11);
        b.a aVar2 = (b.a) bVar.m()[b11];
        this.f3111c = aVar2;
        return aVar2;
    }

    @Override // androidx.compose.foundation.lazy.layout.b
    public void a(int i11, int i12, Function1 function1) {
        int b11;
        c(i11);
        c(i12);
        if (i12 < i11) {
            throw new IllegalArgumentException(("toIndex (" + i12 + ") should be not smaller than fromIndex (" + i11 + ')').toString());
        }
        b11 = c.b(this.f3109a, i11);
        int b12 = ((b.a) this.f3109a.m()[b11]).b();
        while (b12 <= i12) {
            b.a aVar = (b.a) this.f3109a.m()[b11];
            function1.invoke(aVar);
            b12 += aVar.a();
            b11++;
        }
    }

    public final void b(int i11, Object obj) {
        if (i11 < 0) {
            throw new IllegalArgumentException(("size should be >=0, but was " + i11).toString());
        }
        if (i11 == 0) {
            return;
        }
        b.a aVar = new b.a(getSize(), i11, obj);
        this.f3110b = getSize() + i11;
        this.f3109a.b(aVar);
    }

    @Override // androidx.compose.foundation.lazy.layout.b
    public b.a get(int i11) {
        c(i11);
        return e(i11);
    }

    @Override // androidx.compose.foundation.lazy.layout.b
    public int getSize() {
        return this.f3110b;
    }
}
