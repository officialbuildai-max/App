package org.mvel2.util;

import java.io.UnsupportedEncodingException;

/* loaded from: classes7.dex */
public class s implements CharSequence {

    /* renamed from: a, reason: collision with root package name */
    private char[] f72216a;

    /* renamed from: b, reason: collision with root package name */
    private int f72217b;

    /* renamed from: c, reason: collision with root package name */
    private int f72218c;

    /* renamed from: d, reason: collision with root package name */
    private byte[] f72219d;

    /* renamed from: e, reason: collision with root package name */
    private String f72220e;

    public s() {
        this.f72218c = 0;
        this.f72217b = 15;
        this.f72216a = new char[15];
    }

    public s(String str) {
        this.f72218c = 0;
        char[] charArray = str.toCharArray();
        this.f72216a = charArray;
        int length = charArray.length;
        this.f72218c = length;
        this.f72217b = length;
    }

    private void f(int i11) {
        if (this.f72217b == 0) {
            this.f72217b = 15;
        }
        int i12 = this.f72217b + (i11 * 2);
        this.f72217b = i12;
        char[] cArr = new char[i12];
        System.arraycopy(this.f72216a, 0, cArr, 0, this.f72218c);
        this.f72216a = cArr;
    }

    public s a(char c11) {
        int i11 = this.f72218c;
        if (i11 >= this.f72217b) {
            f(i11);
        }
        char[] cArr = this.f72216a;
        int i12 = this.f72218c;
        this.f72218c = i12 + 1;
        cArr[i12] = c11;
        return this;
    }

    public s b(CharSequence charSequence) {
        if (charSequence.length() > this.f72217b - this.f72218c) {
            f(charSequence.length());
        }
        for (int i11 = 0; i11 < charSequence.length(); i11++) {
            this.f72216a[this.f72218c] = charSequence.charAt(i11);
            this.f72218c++;
        }
        return this;
    }

    public s c(Object obj) {
        return d(String.valueOf(obj));
    }

    @Override // java.lang.CharSequence
    public char charAt(int i11) {
        return this.f72216a[i11];
    }

    public s d(String str) {
        if (str == null) {
            return this;
        }
        int length = str.length();
        if (length > this.f72217b - this.f72218c) {
            f(length);
        }
        str.getChars(0, length, this.f72216a, this.f72218c);
        this.f72218c += length;
        return this;
    }

    public s e(char[] cArr, int i11, int i12) {
        if (i12 > this.f72217b - this.f72218c) {
            f(i12);
        }
        int i13 = i12 + i11;
        while (i11 < i13) {
            char[] cArr2 = this.f72216a;
            int i14 = this.f72218c;
            this.f72218c = i14 + 1;
            cArr2[i14] = cArr[i11];
            i11++;
        }
        return this;
    }

    public CharSequence g(int i11, int i12) {
        return new String(this.f72216a, i11, i12 - i11);
    }

    public char[] h() {
        String str;
        if (this.f72219d == null) {
            int i11 = this.f72218c;
            char[] cArr = new char[i11];
            System.arraycopy(this.f72216a, 0, cArr, 0, i11);
            return cArr;
        }
        if (this.f72220e == null) {
            this.f72220e = System.getProperty("file.encoding");
        }
        try {
            str = new String(this.f72219d, this.f72220e);
        } catch (UnsupportedEncodingException unused) {
            str = new String(this.f72219d);
        }
        return str.toCharArray();
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f72218c;
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i11, int i12) {
        return g(i11, i12);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        if (this.f72219d == null) {
            int i11 = this.f72218c;
            return i11 == this.f72217b ? new String(this.f72216a) : new String(this.f72216a, 0, i11);
        }
        if (this.f72220e == null) {
            this.f72220e = System.getProperty("file.encoding");
        }
        try {
            return new String(this.f72219d, 0, this.f72218c, this.f72220e);
        } catch (UnsupportedEncodingException unused) {
            return new String(this.f72219d, 0, this.f72218c);
        }
    }
}
