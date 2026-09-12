package androidx.compose.ui.platform;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.sequences.Sequence;

/* loaded from: classes.dex */
public final class l2 implements Sequence {

    /* renamed from: a, reason: collision with root package name */
    private final List f5916a = new ArrayList();

    public final void c(String str, Object obj) {
        this.f5916a.add(new k2(str, obj));
    }

    @Override // kotlin.sequences.Sequence
    public Iterator iterator() {
        return this.f5916a.iterator();
    }
}
