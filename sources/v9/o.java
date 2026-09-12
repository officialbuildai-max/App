package v9;

import java.util.NoSuchElementException;

/* loaded from: classes3.dex */
public interface o {

    /* renamed from: a, reason: collision with root package name */
    public static final o f77307a = new a();

    /* loaded from: classes4.dex */
    class a implements o {
        a() {
        }

        @Override // v9.o
        public long a() {
            throw new NoSuchElementException();
        }

        @Override // v9.o
        public long b() {
            throw new NoSuchElementException();
        }

        @Override // v9.o
        public boolean next() {
            return false;
        }
    }

    long a();

    long b();

    boolean next();
}
