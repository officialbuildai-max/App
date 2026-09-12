package com.alibaba.fastjson.asm;

/* loaded from: classes2.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private final int f18196a;

    /* renamed from: b, reason: collision with root package name */
    private final int f18197b;

    /* renamed from: e, reason: collision with root package name */
    protected boolean f18200e;

    /* renamed from: d, reason: collision with root package name */
    private final StringBuilder f18199d = new StringBuilder();

    /* renamed from: c, reason: collision with root package name */
    private int f18198c = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(int i11, int i12) {
        this.f18197b = i11;
        this.f18196a = i12;
        this.f18200e = i12 == 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String a() {
        return this.f18199d.length() != 0 ? this.f18199d.substring(1) : "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(String str, int i11) {
        int i12 = this.f18197b;
        if (i11 < i12 || i11 >= i12 + this.f18196a) {
            return;
        }
        if (!str.equals("arg" + this.f18198c)) {
            this.f18200e = true;
        }
        this.f18199d.append(',');
        this.f18199d.append(str);
        this.f18198c++;
    }
}
