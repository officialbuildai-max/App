package kotlin.sequences;

import java.util.HashSet;
import java.util.Iterator;
import kotlin.collections.AbstractIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
final class a extends AbstractIterator {

    /* renamed from: c, reason: collision with root package name */
    private final Iterator f67593c;

    /* renamed from: d, reason: collision with root package name */
    private final Function1 f67594d;

    /* renamed from: e, reason: collision with root package name */
    private final HashSet f67595e;

    public a(Iterator source, Function1 keySelector) {
        Intrinsics.h(source, "source");
        Intrinsics.h(keySelector, "keySelector");
        this.f67593c = source;
        this.f67594d = keySelector;
        this.f67595e = new HashSet();
    }

    @Override // kotlin.collections.AbstractIterator
    protected void a() {
        while (this.f67593c.hasNext()) {
            Object next = this.f67593c.next();
            if (this.f67595e.add(this.f67594d.invoke(next))) {
                e(next);
                return;
            }
        }
        c();
    }
}
