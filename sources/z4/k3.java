package z4;

import java.lang.reflect.Constructor;

/* loaded from: classes3.dex */
public class k3 extends o {
    public k3(y4.h hVar, Class cls) {
        super(hVar, cls, cls);
    }

    private Throwable s(String str, Throwable th2, Class cls) {
        Constructor<?> constructor = null;
        Constructor<?> constructor2 = null;
        Constructor<?> constructor3 = null;
        for (Constructor<?> constructor4 : cls.getConstructors()) {
            Class<?>[] parameterTypes = constructor4.getParameterTypes();
            if (parameterTypes.length == 0) {
                constructor3 = constructor4;
            } else if (parameterTypes.length == 1 && parameterTypes[0] == String.class) {
                constructor2 = constructor4;
            } else if (parameterTypes.length == 2 && parameterTypes[0] == String.class && parameterTypes[1] == Throwable.class) {
                constructor = constructor4;
            }
        }
        if (constructor != null) {
            return (Throwable) constructor.newInstance(str, th2);
        }
        if (constructor2 != null) {
            return (Throwable) constructor2.newInstance(str);
        }
        if (constructor3 != null) {
            return (Throwable) constructor3.newInstance(null);
        }
        return null;
    }

    @Override // z4.o, z4.b2
    public int b() {
        return 12;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0039, code lost:
    
        if (java.lang.Throwable.class.isAssignableFrom(r2) != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00f2, code lost:
    
        if (r2 != null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00f4, code lost:
    
        r3 = new java.lang.Exception(r10, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x010e, code lost:
    
        if (r11 == null) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0110, code lost:
    
        r3.setStackTrace(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0113, code lost:
    
        if (r7 == null) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0115, code lost:
    
        if (r2 == null) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0119, code lost:
    
        if (r2 != r16.f79372c) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x011b, code lost:
    
        r5 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x011d, code lost:
    
        r2 = r17.m().p(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0127, code lost:
    
        if ((r2 instanceof z4.o) == false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0129, code lost:
    
        r5 = (z4.o) r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x012c, code lost:
    
        if (r5 == null) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x012e, code lost:
    
        r2 = r7.entrySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x013a, code lost:
    
        if (r2.hasNext() == false) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x013c, code lost:
    
        r4 = (java.util.Map.Entry) r2.next();
        r6 = (java.lang.String) r4.getKey();
        r4 = r4.getValue();
        r6 = r5.j(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0150, code lost:
    
        if (r6 == null) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0152, code lost:
    
        r7 = r6.f79366a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x015a, code lost:
    
        if (r7.f18283e.isInstance(r4) != false) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x015c, code lost:
    
        r4 = com.alibaba.fastjson.util.TypeUtils.h(r4, r7.f18284f, r17.m());
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0166, code lost:
    
        r6.h(r3, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x016a, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00fe, code lost:
    
        if (java.lang.Throwable.class.isAssignableFrom(r2) == false) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x018d, code lost:
    
        throw new com.alibaba.fastjson.JSONException("type not match, not Throwable. " + r2.getName());
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0100, code lost:
    
        r3 = s(r10, r9, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0104, code lost:
    
        if (r3 != null) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0106, code lost:
    
        r3 = new java.lang.Exception(r10, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x010c, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0172, code lost:
    
        throw new com.alibaba.fastjson.JSONException("create instance error", r0);
     */
    @Override // z4.o, z4.b2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object c(y4.a r17, java.lang.reflect.Type r18, java.lang.Object r19) {
        /*
            Method dump skipped, instructions count: 404
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z4.k3.c(y4.a, java.lang.reflect.Type, java.lang.Object):java.lang.Object");
    }
}
