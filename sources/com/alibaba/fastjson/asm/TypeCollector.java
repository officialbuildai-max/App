package com.alibaba.fastjson.asm;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class TypeCollector {

    /* renamed from: e, reason: collision with root package name */
    private static String f18147e = com.alibaba.fastjson.util.b.b(x4.d.class);

    /* renamed from: f, reason: collision with root package name */
    private static final Map f18148f = new HashMap<String, String>() { // from class: com.alibaba.fastjson.asm.TypeCollector.1
        {
            put("int", "I");
            put("boolean", "Z");
            put("byte", "B");
            put("char", "C");
            put("short", "S");
            put("float", "F");
            put("long", "J");
            put("double", "D");
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final String f18149a;

    /* renamed from: b, reason: collision with root package name */
    private final Class[] f18150b;

    /* renamed from: c, reason: collision with root package name */
    protected g f18151c = null;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f18152d;

    public TypeCollector(String str, Class[] clsArr) {
        this.f18149a = str;
        this.f18150b = clsArr;
    }

    private boolean a(j jVar, String str) {
        String c11 = jVar.c();
        StringBuilder sb2 = new StringBuilder();
        while (c11.endsWith("[]")) {
            sb2.append('[');
            c11 = c11.substring(0, c11.length() - 2);
        }
        if (sb2.length() != 0) {
            Map map = f18148f;
            if (map.containsKey(c11)) {
                sb2.append((String) map.get(c11));
                c11 = sb2.toString();
            } else {
                sb2.append('L');
                sb2.append(c11);
                sb2.append(';');
                c11 = sb2.toString();
            }
        }
        return c11.equals(str);
    }

    public String[] b() {
        g gVar = this.f18151c;
        return (gVar == null || !gVar.f18200e) ? new String[0] : gVar.a().split(",");
    }

    public boolean c() {
        return this.f18152d;
    }

    public void d(String str) {
        if (f18147e.equals(str)) {
            this.f18152d = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g e(int i11, String str, String str2) {
        if (this.f18151c != null || !str.equals(this.f18149a)) {
            return null;
        }
        j[] a11 = j.a(str2);
        int i12 = 0;
        for (j jVar : a11) {
            String c11 = jVar.c();
            if (c11.equals("long") || c11.equals("double")) {
                i12++;
            }
        }
        if (a11.length != this.f18150b.length) {
            return null;
        }
        for (int i13 = 0; i13 < a11.length; i13++) {
            if (!a(a11[i13], this.f18150b[i13].getName())) {
                return null;
            }
        }
        g gVar = new g(!Modifier.isStatic(i11) ? 1 : 0, a11.length + i12);
        this.f18151c = gVar;
        return gVar;
    }
}
