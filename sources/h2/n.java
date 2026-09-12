package h2;

import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public interface n {

    /* renamed from: a, reason: collision with root package name */
    public static final n f64474a = new a();

    /* loaded from: classes2.dex */
    class a implements n {
        a() {
        }

        @Override // h2.n
        public long a() {
            throw new NoSuchElementException();
        }

        @Override // h2.n
        public long b() {
            throw new NoSuchElementException();
        }

        @Override // h2.n
        public boolean next() {
            return false;
        }
    }

    long a();

    long b();

    boolean next();
}
