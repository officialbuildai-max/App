package org.apache.tools.ant.types;

import org.apache.tools.ant.BuildException;

/* loaded from: classes7.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    protected String f71589a;

    /* renamed from: b, reason: collision with root package name */
    private int f71590b = -1;

    public final int a() {
        return this.f71590b;
    }

    public final String b() {
        return this.f71589a;
    }

    public abstract String[] c();

    public final int d(String str) {
        String[] c11 = c();
        if (c11 != null && str != null) {
            for (int i11 = 0; i11 < c11.length; i11++) {
                if (str.equals(c11[i11])) {
                    return i11;
                }
            }
        }
        return -1;
    }

    public final void e(String str) {
        int d11 = d(str);
        if (d11 != -1) {
            this.f71590b = d11;
            this.f71589a = str;
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(" is not a legal value for this attribute");
            throw new BuildException(stringBuffer.toString());
        }
    }

    public String toString() {
        return b();
    }
}
