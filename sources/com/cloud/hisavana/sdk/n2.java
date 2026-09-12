package com.cloud.hisavana.sdk;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* loaded from: classes3.dex */
public class n2 {

    /* renamed from: d, reason: collision with root package name */
    static Object[] f22823d;

    /* renamed from: e, reason: collision with root package name */
    static int f22824e;

    /* renamed from: f, reason: collision with root package name */
    static Object[] f22825f;

    /* renamed from: g, reason: collision with root package name */
    static int f22826g;

    /* renamed from: a, reason: collision with root package name */
    int[] f22827a = o1.f22886a;

    /* renamed from: b, reason: collision with root package name */
    Object[] f22828b = o1.f22888c;

    /* renamed from: c, reason: collision with root package name */
    int f22829c = 0;

    private static int e(int[] iArr, int i11, int i12) {
        try {
            return o1.a(iArr, i11, i12);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    private void h(int i11) {
        if (i11 == 8) {
            synchronized (c5.class) {
                try {
                    Object[] objArr = f22825f;
                    if (objArr != null) {
                        this.f22828b = objArr;
                        f22825f = (Object[]) objArr[0];
                        this.f22827a = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        f22826g--;
                        return;
                    }
                } finally {
                }
            }
        } else if (i11 == 4) {
            synchronized (c5.class) {
                try {
                    Object[] objArr2 = f22823d;
                    if (objArr2 != null) {
                        this.f22828b = objArr2;
                        f22823d = (Object[]) objArr2[0];
                        this.f22827a = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        f22824e--;
                        return;
                    }
                } finally {
                }
            }
        }
        this.f22827a = new int[i11];
        this.f22828b = new Object[i11 << 1];
    }

    private static void i(int[] iArr, Object[] objArr, int i11) {
        if (iArr.length == 8) {
            synchronized (c5.class) {
                try {
                    if (f22826g < 10) {
                        objArr[0] = f22825f;
                        objArr[1] = iArr;
                        for (int i12 = (i11 << 1) - 1; i12 >= 2; i12--) {
                            objArr[i12] = null;
                        }
                        f22825f = objArr;
                        f22826g++;
                    }
                } finally {
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (c5.class) {
                try {
                    if (f22824e < 10) {
                        objArr[0] = f22823d;
                        objArr[1] = iArr;
                        for (int i13 = (i11 << 1) - 1; i13 >= 2; i13--) {
                            objArr[i13] = null;
                        }
                        f22823d = objArr;
                        f22824e++;
                    }
                } finally {
                }
            }
        }
    }

    int a() {
        int i11 = this.f22829c;
        if (i11 == 0) {
            return -1;
        }
        int e11 = e(this.f22827a, i11, 0);
        if (e11 < 0 || this.f22828b[e11 << 1] == null) {
            return e11;
        }
        int i12 = e11 + 1;
        while (i12 < i11 && this.f22827a[i12] == 0) {
            if (this.f22828b[i12 << 1] == null) {
                return i12;
            }
            i12++;
        }
        for (int i13 = e11 - 1; i13 >= 0 && this.f22827a[i13] == 0; i13--) {
            if (this.f22828b[i13 << 1] == null) {
                return i13;
            }
        }
        return ~i12;
    }

    public int c(Object obj) {
        return obj == null ? a() : d(obj, obj.hashCode());
    }

    public void clear() {
        int i11 = this.f22829c;
        if (i11 > 0) {
            int[] iArr = this.f22827a;
            Object[] objArr = this.f22828b;
            this.f22827a = o1.f22886a;
            this.f22828b = o1.f22888c;
            this.f22829c = 0;
            i(iArr, objArr, i11);
        }
        if (this.f22829c > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return c(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return j(obj) >= 0;
    }

    int d(Object obj, int i11) {
        int i12 = this.f22829c;
        if (i12 == 0) {
            return -1;
        }
        int e11 = e(this.f22827a, i12, i11);
        if (e11 < 0 || obj.equals(this.f22828b[e11 << 1])) {
            return e11;
        }
        int i13 = e11 + 1;
        while (i13 < i12 && this.f22827a[i13] == i11) {
            if (obj.equals(this.f22828b[i13 << 1])) {
                return i13;
            }
            i13++;
        }
        for (int i14 = e11 - 1; i14 >= 0 && this.f22827a[i14] == i11; i14--) {
            if (obj.equals(this.f22828b[i14 << 1])) {
                return i14;
            }
        }
        return ~i13;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof n2) {
            n2 n2Var = (n2) obj;
            if (size() != n2Var.size()) {
                return false;
            }
            for (int i11 = 0; i11 < this.f22829c; i11++) {
                try {
                    Object l11 = l(i11);
                    Object n11 = n(i11);
                    Object obj2 = n2Var.get(l11);
                    if (n11 == null) {
                        if (obj2 != null || !n2Var.containsKey(l11)) {
                            return false;
                        }
                    } else if (!n11.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            for (int i12 = 0; i12 < this.f22829c; i12++) {
                try {
                    Object l12 = l(i12);
                    Object n12 = n(i12);
                    Object obj3 = map.get(l12);
                    if (n12 == null) {
                        if (obj3 != null || !map.containsKey(l12)) {
                            return false;
                        }
                    } else if (!n12.equals(obj3)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public Object f(int i11, Object obj) {
        int i12 = (i11 << 1) + 1;
        Object[] objArr = this.f22828b;
        Object obj2 = objArr[i12];
        objArr[i12] = obj;
        return obj2;
    }

    public Object get(Object obj) {
        int c11 = c(obj);
        if (c11 >= 0) {
            return this.f22828b[(c11 << 1) + 1];
        }
        return null;
    }

    public int hashCode() {
        int[] iArr = this.f22827a;
        Object[] objArr = this.f22828b;
        int i11 = this.f22829c;
        int i12 = 1;
        int i13 = 0;
        int i14 = 0;
        while (i13 < i11) {
            Object obj = objArr[i12];
            i14 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i13];
            i13++;
            i12 += 2;
        }
        return i14;
    }

    public boolean isEmpty() {
        return this.f22829c <= 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j(Object obj) {
        int i11 = this.f22829c * 2;
        Object[] objArr = this.f22828b;
        if (obj == null) {
            for (int i12 = 1; i12 < i11; i12 += 2) {
                if (objArr[i12] == null) {
                    return i12 >> 1;
                }
            }
            return -1;
        }
        for (int i13 = 1; i13 < i11; i13 += 2) {
            if (obj.equals(objArr[i13])) {
                return i13 >> 1;
            }
        }
        return -1;
    }

    public void k(int i11) {
        int i12 = this.f22829c;
        int[] iArr = this.f22827a;
        if (iArr.length < i11) {
            Object[] objArr = this.f22828b;
            h(i11);
            if (this.f22829c > 0) {
                System.arraycopy(iArr, 0, this.f22827a, 0, i12);
                System.arraycopy(objArr, 0, this.f22828b, 0, i12 << 1);
            }
            i(iArr, objArr, i12);
        }
        if (this.f22829c != i12) {
            throw new ConcurrentModificationException();
        }
    }

    public Object l(int i11) {
        return this.f22828b[i11 << 1];
    }

    public Object m(int i11) {
        Object[] objArr = this.f22828b;
        int i12 = i11 << 1;
        Object obj = objArr[i12 + 1];
        int i13 = this.f22829c;
        int i14 = 0;
        if (i13 <= 1) {
            i(this.f22827a, objArr, i13);
            this.f22827a = o1.f22886a;
            this.f22828b = o1.f22888c;
        } else {
            int i15 = i13 - 1;
            int[] iArr = this.f22827a;
            if (iArr.length <= 8 || i13 >= iArr.length / 3) {
                if (i11 < i15) {
                    int i16 = i11 + 1;
                    int i17 = i15 - i11;
                    System.arraycopy(iArr, i16, iArr, i11, i17);
                    Object[] objArr2 = this.f22828b;
                    System.arraycopy(objArr2, i16 << 1, objArr2, i12, i17 << 1);
                }
                Object[] objArr3 = this.f22828b;
                int i18 = i15 << 1;
                objArr3[i18] = null;
                objArr3[i18 + 1] = null;
            } else {
                h(i13 > 8 ? i13 + (i13 >> 1) : 8);
                if (i13 != this.f22829c) {
                    throw new ConcurrentModificationException();
                }
                if (i11 > 0) {
                    System.arraycopy(iArr, 0, this.f22827a, 0, i11);
                    System.arraycopy(objArr, 0, this.f22828b, 0, i12);
                }
                if (i11 < i15) {
                    int i19 = i11 + 1;
                    int i20 = i15 - i11;
                    System.arraycopy(iArr, i19, this.f22827a, i11, i20);
                    System.arraycopy(objArr, i19 << 1, this.f22828b, i12, i20 << 1);
                }
            }
            i14 = i15;
        }
        if (i13 != this.f22829c) {
            throw new ConcurrentModificationException();
        }
        this.f22829c = i14;
        return obj;
    }

    public Object n(int i11) {
        return this.f22828b[(i11 << 1) + 1];
    }

    public Object put(Object obj, Object obj2) {
        int i11;
        int d11;
        int i12 = this.f22829c;
        if (obj == null) {
            d11 = a();
            i11 = 0;
        } else {
            int hashCode = obj.hashCode();
            i11 = hashCode;
            d11 = d(obj, hashCode);
        }
        if (d11 >= 0) {
            int i13 = (d11 << 1) + 1;
            Object[] objArr = this.f22828b;
            Object obj3 = objArr[i13];
            objArr[i13] = obj2;
            return obj3;
        }
        int i14 = ~d11;
        int[] iArr = this.f22827a;
        if (i12 >= iArr.length) {
            int i15 = 8;
            if (i12 >= 8) {
                i15 = (i12 >> 1) + i12;
            } else if (i12 < 4) {
                i15 = 4;
            }
            Object[] objArr2 = this.f22828b;
            h(i15);
            if (i12 != this.f22829c) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.f22827a;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.f22828b, 0, objArr2.length);
            }
            i(iArr, objArr2, i12);
        }
        if (i14 < i12) {
            int[] iArr3 = this.f22827a;
            int i16 = i14 + 1;
            System.arraycopy(iArr3, i14, iArr3, i16, i12 - i14);
            Object[] objArr3 = this.f22828b;
            System.arraycopy(objArr3, i14 << 1, objArr3, i16 << 1, (this.f22829c - i14) << 1);
        }
        int i17 = this.f22829c;
        if (i12 == i17) {
            int[] iArr4 = this.f22827a;
            if (i14 < iArr4.length) {
                iArr4[i14] = i11;
                Object[] objArr4 = this.f22828b;
                int i18 = i14 << 1;
                objArr4[i18] = obj;
                objArr4[i18 + 1] = obj2;
                this.f22829c = i17 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public Object remove(Object obj) {
        int c11 = c(obj);
        if (c11 >= 0) {
            return m(c11);
        }
        return null;
    }

    public int size() {
        return this.f22829c;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f22829c * 28);
        sb2.append('{');
        for (int i11 = 0; i11 < this.f22829c; i11++) {
            if (i11 > 0) {
                sb2.append(", ");
            }
            Object l11 = l(i11);
            if (l11 != this) {
                sb2.append(l11);
            } else {
                sb2.append("(this Map)");
            }
            sb2.append('=');
            Object n11 = n(i11);
            if (n11 != this) {
                sb2.append(n11);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append('}');
        return sb2.toString();
    }
}
