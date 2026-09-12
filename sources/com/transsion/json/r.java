package com.transsion.json;

import java.util.Arrays;

/* loaded from: classes.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    final String[] f46150a;

    /* renamed from: b, reason: collision with root package name */
    boolean f46151b;

    /* renamed from: c, reason: collision with root package name */
    boolean f46152c;

    public r(String str, boolean z10) {
        this.f46151b = false;
        this.f46152c = true;
        this.f46150a = str.split("\\.");
        this.f46151b = str.indexOf(42) >= 0;
        this.f46152c = z10;
    }

    public boolean a() {
        return this.f46152c;
    }

    public boolean b(q qVar) {
        int i11 = 0;
        int i12 = 0;
        while (i11 < qVar.c()) {
            String str = (String) qVar.b().get(i11);
            String[] strArr = this.f46150a;
            if (i12 >= strArr.length || !strArr[i12].equals("*")) {
                String[] strArr2 = this.f46150a;
                if (i12 >= strArr2.length || !strArr2[i12].equals(str)) {
                    int i13 = i12 - 1;
                    if (i13 < 0 || !this.f46150a[i13].equals("*")) {
                        return false;
                    }
                    i11++;
                } else {
                    i11++;
                }
            }
            i12++;
        }
        return (i12 <= 0 || !this.f46150a[i12 + (-1)].equals("*")) ? i11 >= qVar.c() && qVar.c() > 0 : i11 >= qVar.c() && i12 >= this.f46150a.length;
    }

    public boolean c() {
        return this.f46151b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || r.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f46150a, ((r) obj).f46150a);
    }

    public int hashCode() {
        String[] strArr = this.f46150a;
        if (strArr != null) {
            return Arrays.hashCode(strArr);
        }
        return 0;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        int i11 = 0;
        while (true) {
            String[] strArr = this.f46150a;
            if (i11 >= strArr.length) {
                sb2.append("]");
                return sb2.toString();
            }
            sb2.append(strArr[i11]);
            if (i11 < this.f46150a.length - 1) {
                sb2.append(",");
            }
            i11++;
        }
    }
}
