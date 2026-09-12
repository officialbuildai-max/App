package org.mvel2;

/* loaded from: classes7.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private char[] f72077a;

    /* renamed from: b, reason: collision with root package name */
    private int f72078b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f72079c;

    /* renamed from: d, reason: collision with root package name */
    private String f72080d;

    /* renamed from: e, reason: collision with root package name */
    private int f72081e;

    /* renamed from: f, reason: collision with root package name */
    private int f72082f;

    public c(char[] cArr, int i11, boolean z10, String str) {
        this.f72077a = cArr;
        this.f72078b = i11;
        this.f72079c = z10;
        this.f72080d = str;
        a();
    }

    public void a() {
        char[] cArr;
        if ((this.f72081e != 0 && this.f72082f != 0) || (cArr = this.f72077a) == null || cArr.length == 0) {
            return;
        }
        int i11 = 1;
        int i12 = 1;
        for (int i13 = 0; i13 < this.f72078b; i13++) {
            char c11 = this.f72077a[i13];
            if (c11 == '\n') {
                i11++;
                i12 = 0;
            } else if (c11 != '\r') {
                i12++;
            }
        }
        this.f72081e = i11;
        this.f72082f = i12;
    }

    public int b() {
        return this.f72082f;
    }

    public int c() {
        return this.f72078b;
    }

    public char[] d() {
        return this.f72077a;
    }

    public int e() {
        return this.f72081e;
    }

    public String f() {
        return this.f72080d;
    }

    public boolean g() {
        return this.f72079c;
    }

    public void h(int i11) {
        this.f72082f = i11;
    }

    public void i(int i11) {
        this.f72078b = i11;
    }

    public void j(char[] cArr) {
        this.f72077a = cArr;
    }

    public void k(int i11) {
        this.f72081e = i11;
    }

    public String toString() {
        if (this.f72079c) {
            return "(" + this.f72081e + "," + this.f72082f + ") " + this.f72080d;
        }
        return "(" + this.f72081e + "," + this.f72082f + ") WARNING: " + this.f72080d;
    }
}
