package com.alibaba.fastjson.util;

/* loaded from: classes2.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private final a[] f18318a;

    /* renamed from: b, reason: collision with root package name */
    private final int f18319b;

    /* loaded from: classes2.dex */
    protected static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f18320a;

        /* renamed from: b, reason: collision with root package name */
        public final Object f18321b;

        /* renamed from: c, reason: collision with root package name */
        public Object f18322c;

        /* renamed from: d, reason: collision with root package name */
        public final a f18323d;

        public a(Object obj, Object obj2, int i11, a aVar) {
            this.f18321b = obj;
            this.f18322c = obj2;
            this.f18323d = aVar;
            this.f18320a = i11;
        }
    }

    public g() {
        this(8192);
    }

    public g(int i11) {
        this.f18319b = i11 - 1;
        this.f18318a = new a[i11];
    }

    public Class a(String str) {
        int i11 = 0;
        while (true) {
            a[] aVarArr = this.f18318a;
            if (i11 >= aVarArr.length) {
                return null;
            }
            a aVar = aVarArr[i11];
            if (aVar != null) {
                for (a aVar2 = aVar; aVar2 != null; aVar2 = aVar2.f18323d) {
                    Object obj = aVar.f18321b;
                    if (obj instanceof Class) {
                        Class cls = (Class) obj;
                        if (cls.getName().equals(str)) {
                            return cls;
                        }
                    }
                }
            }
            i11++;
        }
    }

    public final Object b(Object obj) {
        for (a aVar = this.f18318a[System.identityHashCode(obj) & this.f18319b]; aVar != null; aVar = aVar.f18323d) {
            if (obj == aVar.f18321b) {
                return aVar.f18322c;
            }
        }
        return null;
    }

    public boolean c(Object obj, Object obj2) {
        int identityHashCode = System.identityHashCode(obj);
        int i11 = this.f18319b & identityHashCode;
        for (a aVar = this.f18318a[i11]; aVar != null; aVar = aVar.f18323d) {
            if (obj == aVar.f18321b) {
                aVar.f18322c = obj2;
                return true;
            }
        }
        this.f18318a[i11] = new a(obj, obj2, identityHashCode, this.f18318a[i11]);
        return false;
    }
}
