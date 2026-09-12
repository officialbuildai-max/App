package androidx.compose.animation.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
public abstract class w0 {

    /* loaded from: classes.dex */
    public static final class a implements q {

        /* renamed from: a, reason: collision with root package name */
        private final List f2587a;

        a(o oVar, float f11, float f12) {
            IntRange t11 = RangesKt.t(0, oVar.b());
            ArrayList arrayList = new ArrayList(CollectionsKt.v(t11, 10));
            Iterator<Integer> it = t11.iterator();
            while (it.hasNext()) {
                arrayList.add(new f0(f11, f12, oVar.a(((IntIterator) it).a())));
            }
            this.f2587a = arrayList;
        }

        @Override // androidx.compose.animation.core.q
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public f0 get(int i11) {
            return (f0) this.f2587a.get(i11);
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements q {

        /* renamed from: a, reason: collision with root package name */
        private final f0 f2588a;

        b(float f11, float f12) {
            this.f2588a = new f0(f11, f12, 0.0f, 4, null);
        }

        @Override // androidx.compose.animation.core.q
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public f0 get(int i11) {
            return this.f2588a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final q b(o oVar, float f11, float f12) {
        return oVar != null ? new a(oVar, f11, f12) : new b(f11, f12);
    }
}
