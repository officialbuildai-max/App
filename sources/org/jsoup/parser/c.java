package org.jsoup.parser;

/* loaded from: classes7.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private int f71952a;

    /* renamed from: b, reason: collision with root package name */
    private String f71953b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(int i11, String str) {
        this.f71952a = i11;
        this.f71953b = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(int i11, String str, Object... objArr) {
        this.f71953b = String.format(str, objArr);
        this.f71952a = i11;
    }

    public String toString() {
        return this.f71952a + ": " + this.f71953b;
    }
}
