package androidx.databinding;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class c implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private List f8625a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private long f8626b = 0;

    /* renamed from: c, reason: collision with root package name */
    private long[] f8627c;

    /* renamed from: d, reason: collision with root package name */
    private int f8628d;

    /* renamed from: e, reason: collision with root package name */
    private final a f8629e;

    /* loaded from: classes.dex */
    public static abstract class a {
        public abstract void a(Object obj, Object obj2, int i11, Object obj3);
    }

    public c(a aVar) {
        this.f8629e = aVar;
    }

    private boolean c(int i11) {
        int i12;
        if (i11 < 64) {
            return ((1 << i11) & this.f8626b) != 0;
        }
        long[] jArr = this.f8627c;
        if (jArr != null && (i12 = (i11 / 64) - 1) < jArr.length) {
            return ((1 << (i11 % 64)) & jArr[i12]) != 0;
        }
        return false;
    }

    private void e(Object obj, int i11, Object obj2, int i12, int i13, long j11) {
        long j12 = 1;
        while (i12 < i13) {
            if ((j11 & j12) == 0) {
                this.f8629e.a(this.f8625a.get(i12), obj, i11, obj2);
            }
            j12 <<= 1;
            i12++;
        }
    }

    private void f(Object obj, int i11, Object obj2) {
        e(obj, i11, obj2, 0, Math.min(64, this.f8625a.size()), this.f8626b);
    }

    private void g(Object obj, int i11, Object obj2) {
        int size = this.f8625a.size();
        int length = this.f8627c == null ? -1 : r0.length - 1;
        i(obj, i11, obj2, length);
        e(obj, i11, obj2, (length + 2) * 64, size, 0L);
    }

    private void i(Object obj, int i11, Object obj2, int i12) {
        if (i12 < 0) {
            f(obj, i11, obj2);
            return;
        }
        long j11 = this.f8627c[i12];
        int i13 = (i12 + 1) * 64;
        int min = Math.min(this.f8625a.size(), i13 + 64);
        i(obj, i11, obj2, i12 - 1);
        e(obj, i11, obj2, i13, min, j11);
    }

    private void k(int i11, long j11) {
        long j12 = Long.MIN_VALUE;
        for (int i12 = i11 + 63; i12 >= i11; i12--) {
            if ((j11 & j12) != 0) {
                this.f8625a.remove(i12);
            }
            j12 >>>= 1;
        }
    }

    private void l(int i11) {
        if (i11 < 64) {
            this.f8626b = (1 << i11) | this.f8626b;
            return;
        }
        int i12 = (i11 / 64) - 1;
        long[] jArr = this.f8627c;
        if (jArr == null) {
            this.f8627c = new long[this.f8625a.size() / 64];
        } else if (jArr.length <= i12) {
            long[] jArr2 = new long[this.f8625a.size() / 64];
            long[] jArr3 = this.f8627c;
            System.arraycopy(jArr3, 0, jArr2, 0, jArr3.length);
            this.f8627c = jArr2;
        }
        long j11 = 1 << (i11 % 64);
        long[] jArr4 = this.f8627c;
        jArr4[i12] = j11 | jArr4[i12];
    }

    public synchronized void a(Object obj) {
        try {
            if (obj == null) {
                throw new IllegalArgumentException("callback cannot be null");
            }
            int lastIndexOf = this.f8625a.lastIndexOf(obj);
            if (lastIndexOf >= 0) {
                if (c(lastIndexOf)) {
                }
            }
            this.f8625a.add(obj);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public synchronized c clone() {
        c cVar;
        CloneNotSupportedException e11;
        try {
            cVar = (c) super.clone();
        } catch (CloneNotSupportedException e12) {
            cVar = null;
            e11 = e12;
        }
        try {
            cVar.f8626b = 0L;
            cVar.f8627c = null;
            cVar.f8628d = 0;
            cVar.f8625a = new ArrayList();
            int size = this.f8625a.size();
            for (int i11 = 0; i11 < size; i11++) {
                if (!c(i11)) {
                    cVar.f8625a.add(this.f8625a.get(i11));
                }
            }
        } catch (CloneNotSupportedException e13) {
            e11 = e13;
            e11.printStackTrace();
            return cVar;
        }
        return cVar;
    }

    public synchronized void d(Object obj, int i11, Object obj2) {
        try {
            this.f8628d++;
            g(obj, i11, obj2);
            int i12 = this.f8628d - 1;
            this.f8628d = i12;
            if (i12 == 0) {
                long[] jArr = this.f8627c;
                if (jArr != null) {
                    for (int length = jArr.length - 1; length >= 0; length--) {
                        long j11 = this.f8627c[length];
                        if (j11 != 0) {
                            k((length + 1) * 64, j11);
                            this.f8627c[length] = 0;
                        }
                    }
                }
                long j12 = this.f8626b;
                if (j12 != 0) {
                    k(0, j12);
                    this.f8626b = 0L;
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void j(Object obj) {
        try {
            if (this.f8628d == 0) {
                this.f8625a.remove(obj);
            } else {
                int lastIndexOf = this.f8625a.lastIndexOf(obj);
                if (lastIndexOf >= 0) {
                    l(lastIndexOf);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
