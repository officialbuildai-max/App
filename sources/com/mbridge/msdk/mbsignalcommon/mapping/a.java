package com.mbridge.msdk.mbsignalcommon.mapping;

/* loaded from: classes5.dex */
public class a extends Throwable {

    /* renamed from: a, reason: collision with root package name */
    private Class<?> f36553a;

    /* renamed from: b, reason: collision with root package name */
    private String f36554b;

    public a(Exception exc) {
        super(exc);
    }

    public a(String str) {
        super(str);
    }

    public void a(Class<?> cls) {
        this.f36553a = cls;
    }

    public void a(String str) {
        this.f36554b = str;
    }

    @Override // java.lang.Throwable
    public String toString() {
        if (getCause() == null) {
            return super.toString();
        }
        return getClass().getName() + ": " + getCause();
    }
}
