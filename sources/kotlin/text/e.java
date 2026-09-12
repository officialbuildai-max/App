package kotlin.text;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes7.dex */
final class e implements Iterator, KMappedMarker {

    /* renamed from: f, reason: collision with root package name */
    private static final a f67683f = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final CharSequence f67684a;

    /* renamed from: b, reason: collision with root package name */
    private int f67685b;

    /* renamed from: c, reason: collision with root package name */
    private int f67686c;

    /* renamed from: d, reason: collision with root package name */
    private int f67687d;

    /* renamed from: e, reason: collision with root package name */
    private int f67688e;

    /* loaded from: classes7.dex */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public e(CharSequence string) {
        Intrinsics.h(string, "string");
        this.f67684a = string;
    }

    @Override // java.util.Iterator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f67685b = 0;
        int i11 = this.f67687d;
        int i12 = this.f67686c;
        this.f67686c = this.f67688e + i11;
        return this.f67684a.subSequence(i12, i11).toString();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        int i11;
        int i12;
        int i13 = this.f67685b;
        if (i13 != 0) {
            return i13 == 1;
        }
        if (this.f67688e < 0) {
            this.f67685b = 2;
            return false;
        }
        int length = this.f67684a.length();
        int length2 = this.f67684a.length();
        for (int i14 = this.f67686c; i14 < length2; i14++) {
            char charAt = this.f67684a.charAt(i14);
            if (charAt == '\n' || charAt == '\r') {
                i11 = (charAt == '\r' && (i12 = i14 + 1) < this.f67684a.length() && this.f67684a.charAt(i12) == '\n') ? 2 : 1;
                length = i14;
                this.f67685b = 1;
                this.f67688e = i11;
                this.f67687d = length;
                return true;
            }
        }
        i11 = -1;
        this.f67685b = 1;
        this.f67688e = i11;
        this.f67687d = length;
        return true;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
