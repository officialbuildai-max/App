package com.google.common.base;

import com.google.common.base.Suppliers;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* loaded from: classes4.dex */
public abstract class Suppliers {

    /* loaded from: classes4.dex */
    static class MemoizingSupplier<T> implements q, Serializable {
        private static final long serialVersionUID = 0;

        /* renamed from: a, reason: collision with root package name */
        private transient Object f30267a = new Object();
        final q delegate;
        volatile transient boolean initialized;
        transient T value;

        MemoizingSupplier(q qVar) {
            this.delegate = (q) m.o(qVar);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.f30267a = new Object();
        }

        @Override // com.google.common.base.q
        public T get() {
            if (!this.initialized) {
                synchronized (this.f30267a) {
                    try {
                        if (!this.initialized) {
                            T t11 = (T) this.delegate.get();
                            this.value = t11;
                            this.initialized = true;
                            return t11;
                        }
                    } finally {
                    }
                }
            }
            return (T) i.a(this.value);
        }

        public String toString() {
            Object obj;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Suppliers.memoize(");
            if (this.initialized) {
                obj = "<supplier that returned " + this.value + ">";
            } else {
                obj = this.delegate;
            }
            sb2.append(obj);
            sb2.append(")");
            return sb2.toString();
        }
    }

    /* loaded from: classes4.dex */
    private static class SupplierOfInstance<T> implements q, Serializable {
        private static final long serialVersionUID = 0;
        final T instance;

        SupplierOfInstance(T t11) {
            this.instance = t11;
        }

        public boolean equals(Object obj) {
            if (obj instanceof SupplierOfInstance) {
                return j.a(this.instance, ((SupplierOfInstance) obj).instance);
            }
            return false;
        }

        @Override // com.google.common.base.q
        public T get() {
            return this.instance;
        }

        public int hashCode() {
            return j.b(this.instance);
        }

        public String toString() {
            return "Suppliers.ofInstance(" + this.instance + ")";
        }
    }

    /* loaded from: classes4.dex */
    static class a implements q {

        /* renamed from: d, reason: collision with root package name */
        private static final q f30268d = new q() { // from class: com.google.common.base.r
            @Override // com.google.common.base.q
            public final Object get() {
                Void b11;
                b11 = Suppliers.a.b();
                return b11;
            }
        };

        /* renamed from: a, reason: collision with root package name */
        private final Object f30269a = new Object();

        /* renamed from: b, reason: collision with root package name */
        private volatile q f30270b;

        /* renamed from: c, reason: collision with root package name */
        private Object f30271c;

        a(q qVar) {
            this.f30270b = (q) m.o(qVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Void b() {
            throw new IllegalStateException();
        }

        @Override // com.google.common.base.q
        public Object get() {
            q qVar = this.f30270b;
            q qVar2 = f30268d;
            if (qVar != qVar2) {
                synchronized (this.f30269a) {
                    try {
                        if (this.f30270b != qVar2) {
                            Object obj = this.f30270b.get();
                            this.f30271c = obj;
                            this.f30270b = qVar2;
                            return obj;
                        }
                    } finally {
                    }
                }
            }
            return i.a(this.f30271c);
        }

        public String toString() {
            Object obj = this.f30270b;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Suppliers.memoize(");
            if (obj == f30268d) {
                obj = "<supplier that returned " + this.f30271c + ">";
            }
            sb2.append(obj);
            sb2.append(")");
            return sb2.toString();
        }
    }

    public static q a(q qVar) {
        return ((qVar instanceof a) || (qVar instanceof MemoizingSupplier)) ? qVar : qVar instanceof Serializable ? new MemoizingSupplier(qVar) : new a(qVar);
    }

    public static q b(Object obj) {
        return new SupplierOfInstance(obj);
    }
}
