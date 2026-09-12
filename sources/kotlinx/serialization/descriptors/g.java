package kotlinx.serialization.descriptors;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes7.dex */
public abstract class g {

    /* loaded from: classes7.dex */
    public static final class a implements Iterator, KMappedMarker {

        /* renamed from: a, reason: collision with root package name */
        private int f68185a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ f f68186b;

        a(f fVar) {
            this.f68186b = fVar;
            this.f68185a = fVar.e();
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public f next() {
            f fVar = this.f68186b;
            int e11 = fVar.e();
            int i11 = this.f68185a;
            this.f68185a = i11 - 1;
            return fVar.h(e11 - i11);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f68185a > 0;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements Iterator, KMappedMarker {

        /* renamed from: a, reason: collision with root package name */
        private int f68187a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ f f68188b;

        b(f fVar) {
            this.f68188b = fVar;
            this.f68187a = fVar.e();
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String next() {
            f fVar = this.f68188b;
            int e11 = fVar.e();
            int i11 = this.f68187a;
            this.f68187a = i11 - 1;
            return fVar.f(e11 - i11);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f68187a > 0;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* loaded from: classes7.dex */
    public static final class c implements Iterable, KMappedMarker {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f68189a;

        public c(f fVar) {
            this.f68189a = fVar;
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return new a(this.f68189a);
        }
    }

    /* loaded from: classes7.dex */
    public static final class d implements Iterable, KMappedMarker {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f68190a;

        public d(f fVar) {
            this.f68190a = fVar;
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return new b(this.f68190a);
        }
    }

    public static final Iterable a(f fVar) {
        Intrinsics.h(fVar, "<this>");
        return new c(fVar);
    }

    public static final Iterable b(f fVar) {
        Intrinsics.h(fVar, "<this>");
        return new d(fVar);
    }
}
