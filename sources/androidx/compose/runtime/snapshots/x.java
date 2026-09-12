package androidx.compose.runtime.snapshots;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableMap;

/* loaded from: classes.dex */
final class x extends y implements Iterator, KMutableIterator {

    /* loaded from: classes.dex */
    public static final class a implements Map.Entry, KMutableMap.Entry {

        /* renamed from: a, reason: collision with root package name */
        private final Object f4108a;

        /* renamed from: b, reason: collision with root package name */
        private Object f4109b;

        a() {
            Map.Entry f11 = x.this.f();
            Intrinsics.e(f11);
            this.f4108a = f11.getKey();
            Map.Entry f12 = x.this.f();
            Intrinsics.e(f12);
            this.f4109b = f12.getValue();
        }

        public void a(Object obj) {
            this.f4109b = obj;
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.f4108a;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f4109b;
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            x xVar = x.this;
            if (xVar.h().e() != ((y) xVar).f4113c) {
                throw new ConcurrentModificationException();
            }
            Object value = getValue();
            xVar.h().put(getKey(), obj);
            a(obj);
            return value;
        }
    }

    public x(t tVar, Iterator it) {
        super(tVar, it);
    }

    @Override // java.util.Iterator
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Map.Entry next() {
        e();
        if (f() != null) {
            return new a();
        }
        throw new IllegalStateException();
    }
}
