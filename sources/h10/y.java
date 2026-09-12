package h10;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* loaded from: classes7.dex */
public final class y {

    /* renamed from: e, reason: collision with root package name */
    public static final y f64374e = new y(0, "VZCBSIFJD", 0, 1);

    /* renamed from: f, reason: collision with root package name */
    public static final y f64375f = new y(1, "VZCBSIFJD", 1, 2);

    /* renamed from: g, reason: collision with root package name */
    public static final y f64376g = new y(2, "VZCBSIFJD", 2, 3);

    /* renamed from: h, reason: collision with root package name */
    public static final y f64377h = new y(3, "VZCBSIFJD", 3, 4);

    /* renamed from: i, reason: collision with root package name */
    public static final y f64378i = new y(4, "VZCBSIFJD", 4, 5);

    /* renamed from: j, reason: collision with root package name */
    public static final y f64379j = new y(5, "VZCBSIFJD", 5, 6);

    /* renamed from: k, reason: collision with root package name */
    public static final y f64380k = new y(6, "VZCBSIFJD", 6, 7);

    /* renamed from: l, reason: collision with root package name */
    public static final y f64381l = new y(7, "VZCBSIFJD", 7, 8);

    /* renamed from: m, reason: collision with root package name */
    public static final y f64382m = new y(8, "VZCBSIFJD", 8, 9);

    /* renamed from: a, reason: collision with root package name */
    private final int f64383a;

    /* renamed from: b, reason: collision with root package name */
    private final String f64384b;

    /* renamed from: c, reason: collision with root package name */
    private final int f64385c;

    /* renamed from: d, reason: collision with root package name */
    private final int f64386d;

    private y(int i11, String str, int i12, int i13) {
        this.f64383a = i11;
        this.f64384b = str;
        this.f64385c = i12;
        this.f64386d = i13;
    }

    private static void a(Class cls, StringBuilder sb2) {
        char c11;
        while (cls.isArray()) {
            sb2.append('[');
            cls = cls.getComponentType();
        }
        if (!cls.isPrimitive()) {
            sb2.append('L');
            String name = cls.getName();
            int length = name.length();
            for (int i11 = 0; i11 < length; i11++) {
                char charAt = name.charAt(i11);
                if (charAt == '.') {
                    charAt = '/';
                }
                sb2.append(charAt);
            }
            sb2.append(';');
            return;
        }
        if (cls == Integer.TYPE) {
            c11 = 'I';
        } else if (cls == Void.TYPE) {
            c11 = 'V';
        } else if (cls == Boolean.TYPE) {
            c11 = 'Z';
        } else if (cls == Byte.TYPE) {
            c11 = 'B';
        } else if (cls == Character.TYPE) {
            c11 = 'C';
        } else if (cls == Short.TYPE) {
            c11 = 'S';
        } else if (cls == Double.TYPE) {
            c11 = 'D';
        } else if (cls == Float.TYPE) {
            c11 = 'F';
        } else {
            if (cls != Long.TYPE) {
                throw new AssertionError();
            }
            c11 = 'J';
        }
        sb2.append(c11);
    }

    public static y[] b(String str) {
        int i11 = 0;
        int i12 = 0;
        int i13 = 1;
        while (str.charAt(i13) != ')') {
            while (str.charAt(i13) == '[') {
                i13++;
            }
            int i14 = i13 + 1;
            i13 = str.charAt(i13) == 'L' ? str.indexOf(59, i14) + 1 : i14;
            i12++;
        }
        y[] yVarArr = new y[i12];
        int i15 = 1;
        while (str.charAt(i15) != ')') {
            int i16 = i15;
            while (str.charAt(i16) == '[') {
                i16++;
            }
            int i17 = i16 + 1;
            if (str.charAt(i16) == 'L') {
                i17 = str.indexOf(59, i17) + 1;
            }
            yVarArr[i11] = o(str, i15, i17);
            i11++;
            i15 = i17;
        }
        return yVarArr;
    }

    public static int c(String str) {
        char charAt = str.charAt(1);
        int i11 = 1;
        int i12 = 1;
        while (charAt != ')') {
            if (charAt == 'J' || charAt == 'D') {
                i11++;
                i12 += 2;
            } else {
                while (str.charAt(i11) == '[') {
                    i11++;
                }
                int i13 = i11 + 1;
                if (str.charAt(i11) == 'L') {
                    i13 = str.indexOf(59, i13) + 1;
                }
                i12++;
                i11 = i13;
            }
            charAt = str.charAt(i11);
        }
        char charAt2 = str.charAt(i11 + 1);
        if (charAt2 == 'V') {
            return i12 << 2;
        }
        return (i12 << 2) | ((charAt2 == 'J' || charAt2 == 'D') ? 2 : 1);
    }

    public static String d(Constructor constructor) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('(');
        for (Class<?> cls : constructor.getParameterTypes()) {
            a(cls, sb2);
        }
        sb2.append(")V");
        return sb2.toString();
    }

    public static String f(Class cls) {
        StringBuilder sb2 = new StringBuilder();
        a(cls, sb2);
        return sb2.toString();
    }

    public static String h(Class cls) {
        return cls.getName().replace('.', '/');
    }

    public static String i(Method method) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('(');
        for (Class<?> cls : method.getParameterTypes()) {
            a(cls, sb2);
        }
        sb2.append(')');
        a(method.getReturnType(), sb2);
        return sb2.toString();
    }

    public static y j(String str) {
        return new y(11, str, 0, str.length());
    }

    public static y k(String str) {
        return new y(str.charAt(0) == '[' ? 9 : 12, str, 0, str.length());
    }

    public static y m(Class cls) {
        if (!cls.isPrimitive()) {
            return n(f(cls));
        }
        if (cls == Integer.TYPE) {
            return f64379j;
        }
        if (cls == Void.TYPE) {
            return f64374e;
        }
        if (cls == Boolean.TYPE) {
            return f64375f;
        }
        if (cls == Byte.TYPE) {
            return f64377h;
        }
        if (cls == Character.TYPE) {
            return f64376g;
        }
        if (cls == Short.TYPE) {
            return f64378i;
        }
        if (cls == Double.TYPE) {
            return f64382m;
        }
        if (cls == Float.TYPE) {
            return f64380k;
        }
        if (cls == Long.TYPE) {
            return f64381l;
        }
        throw new AssertionError();
    }

    public static y n(String str) {
        return o(str, 0, str.length());
    }

    private static y o(String str, int i11, int i12) {
        char charAt = str.charAt(i11);
        if (charAt == '(') {
            return new y(11, str, i11, i12);
        }
        if (charAt == 'F') {
            return f64380k;
        }
        if (charAt == 'L') {
            return new y(10, str, i11 + 1, i12 - 1);
        }
        if (charAt == 'S') {
            return f64378i;
        }
        if (charAt == 'V') {
            return f64374e;
        }
        if (charAt == 'I') {
            return f64379j;
        }
        if (charAt == 'J') {
            return f64381l;
        }
        if (charAt == 'Z') {
            return f64375f;
        }
        if (charAt == '[') {
            return new y(9, str, i11, i12);
        }
        switch (charAt) {
            case 'B':
                return f64377h;
            case 'C':
                return f64376g;
            case 'D':
                return f64382m;
            default:
                throw new IllegalArgumentException();
        }
    }

    public String e() {
        int i11 = this.f64383a;
        if (i11 == 10) {
            return this.f64384b.substring(this.f64385c - 1, this.f64386d + 1);
        }
        if (i11 != 12) {
            return this.f64384b.substring(this.f64385c, this.f64386d);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append('L');
        sb2.append((CharSequence) this.f64384b, this.f64385c, this.f64386d);
        sb2.append(';');
        return sb2.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        int i11 = this.f64383a;
        if (i11 == 12) {
            i11 = 10;
        }
        int i12 = yVar.f64383a;
        if (i11 != (i12 != 12 ? i12 : 10)) {
            return false;
        }
        int i13 = this.f64385c;
        int i14 = this.f64386d;
        int i15 = yVar.f64385c;
        if (i14 - i13 != yVar.f64386d - i15) {
            return false;
        }
        while (i13 < i14) {
            if (this.f64384b.charAt(i13) != yVar.f64384b.charAt(i15)) {
                return false;
            }
            i13++;
            i15++;
        }
        return true;
    }

    public String g() {
        return this.f64384b.substring(this.f64385c, this.f64386d);
    }

    public int hashCode() {
        int i11 = this.f64383a;
        int i12 = (i11 == 12 ? 10 : i11) * 13;
        if (i11 >= 9) {
            int i13 = this.f64386d;
            for (int i14 = this.f64385c; i14 < i13; i14++) {
                i12 = (i12 + this.f64384b.charAt(i14)) * 17;
            }
        }
        return i12;
    }

    public int l() {
        int i11 = this.f64383a;
        if (i11 == 12) {
            return 10;
        }
        return i11;
    }

    public String toString() {
        return e();
    }
}
