package com.alibaba.fastjson;

import java.io.Closeable;

/* loaded from: classes2.dex */
public abstract class JSONValidator implements Cloneable, Closeable {

    /* renamed from: a, reason: collision with root package name */
    protected boolean f18138a;

    /* renamed from: c, reason: collision with root package name */
    protected char f18140c;

    /* renamed from: d, reason: collision with root package name */
    protected Type f18141d;

    /* renamed from: e, reason: collision with root package name */
    private Boolean f18142e;

    /* renamed from: b, reason: collision with root package name */
    protected int f18139b = -1;

    /* renamed from: f, reason: collision with root package name */
    protected int f18143f = 0;

    /* renamed from: g, reason: collision with root package name */
    protected boolean f18144g = false;

    /* loaded from: classes2.dex */
    public enum Type {
        Object,
        Array,
        Value
    }

    /* loaded from: classes2.dex */
    static class a extends JSONValidator {

        /* renamed from: h, reason: collision with root package name */
        private final String f18145h;

        public a(String str) {
            this.f18145h = str;
            o();
            p();
        }

        @Override // com.alibaba.fastjson.JSONValidator
        protected final void l() {
            char charAt;
            int i11 = this.f18139b;
            do {
                i11++;
                if (i11 >= this.f18145h.length() || (charAt = this.f18145h.charAt(i11)) == '\\') {
                    o();
                    while (true) {
                        char c11 = this.f18140c;
                        if (c11 == '\\') {
                            o();
                            if (this.f18140c == 'u') {
                                o();
                                o();
                                o();
                                o();
                                o();
                            } else {
                                o();
                            }
                        } else if (c11 == '\"') {
                            o();
                            return;
                        } else if (this.f18138a) {
                            return;
                        } else {
                            o();
                        }
                    }
                }
            } while (charAt != '\"');
            int i12 = i11 + 1;
            this.f18140c = this.f18145h.charAt(i12);
            this.f18139b = i12;
        }

        @Override // com.alibaba.fastjson.JSONValidator
        void o() {
            int i11 = this.f18139b + 1;
            this.f18139b = i11;
            if (i11 < this.f18145h.length()) {
                this.f18140c = this.f18145h.charAt(this.f18139b);
            } else {
                this.f18140c = (char) 0;
                this.f18138a = true;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:167:0x0173, code lost:
    
        if (r0 <= '9') goto L181;
     */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0183  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean k() {
        /*
            Method dump skipped, instructions count: 532
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.JSONValidator.k():boolean");
    }

    public static JSONValidator m(String str) {
        return new a(str);
    }

    static final boolean n(char c11) {
        return c11 == ' ' || c11 == '\t' || c11 == '\r' || c11 == '\n' || c11 == '\f' || c11 == '\b';
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    protected void l() {
        o();
        while (true) {
            char c11 = this.f18140c;
            if (c11 == '\\') {
                o();
                if (this.f18140c == 'u') {
                    o();
                    o();
                    o();
                    o();
                    o();
                } else {
                    o();
                }
            } else {
                if (c11 == '\"') {
                    o();
                    return;
                }
                o();
            }
        }
    }

    abstract void o();

    void p() {
        while (n(this.f18140c)) {
            o();
        }
    }

    public boolean q() {
        Boolean bool = this.f18142e;
        if (bool != null) {
            return bool.booleanValue();
        }
        while (k()) {
            p();
            this.f18143f++;
            if (this.f18138a) {
                this.f18142e = Boolean.TRUE;
                return true;
            }
            if (!this.f18144g) {
                this.f18142e = Boolean.FALSE;
                return false;
            }
            p();
            if (this.f18138a) {
                this.f18142e = Boolean.TRUE;
                return true;
            }
        }
        this.f18142e = Boolean.FALSE;
        return false;
    }
}
