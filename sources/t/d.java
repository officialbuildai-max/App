package t;

import java.util.List;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes.dex */
public interface d extends List, b, KMappedMarker {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class a extends AbstractList implements d {

        /* renamed from: a, reason: collision with root package name */
        private final d f76082a;

        /* renamed from: b, reason: collision with root package name */
        private final int f76083b;

        /* renamed from: c, reason: collision with root package name */
        private final int f76084c;

        /* renamed from: d, reason: collision with root package name */
        private int f76085d;

        public a(d dVar, int i11, int i12) {
            this.f76082a = dVar;
            this.f76083b = i11;
            this.f76084c = i12;
            w.d.c(i11, i12, dVar.size());
            this.f76085d = i12 - i11;
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public d subList(int i11, int i12) {
            w.d.c(i11, i12, this.f76085d);
            d dVar = this.f76082a;
            int i13 = this.f76083b;
            return new a(dVar, i11 + i13, i13 + i12);
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public Object get(int i11) {
            w.d.a(i11, this.f76085d);
            return this.f76082a.get(this.f76083b + i11);
        }

        @Override // kotlin.collections.AbstractCollection
        /* renamed from: getSize */
        public int get_size() {
            return this.f76085d;
        }
    }
}
