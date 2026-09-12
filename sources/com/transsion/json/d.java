package com.transsion.json;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private final String f46096a;

    /* renamed from: b, reason: collision with root package name */
    private String f46097b;

    /* renamed from: c, reason: collision with root package name */
    private final c f46098c;

    /* renamed from: d, reason: collision with root package name */
    private Class f46099d;

    /* renamed from: e, reason: collision with root package name */
    protected final Field f46100e;

    /* renamed from: f, reason: collision with root package name */
    protected Method f46101f;

    /* renamed from: g, reason: collision with root package name */
    protected Method f46102g;

    /* renamed from: h, reason: collision with root package name */
    protected final Map f46103h = new HashMap();

    /* renamed from: i, reason: collision with root package name */
    protected g f46104i = null;

    /* renamed from: j, reason: collision with root package name */
    protected g f46105j = null;

    /* renamed from: k, reason: collision with root package name */
    protected Boolean f46106k = null;

    public d(String str, c cVar) {
        this.f46097b = str;
        this.f46096a = str;
        this.f46098c = cVar;
        Field b11 = cVar.b(str);
        this.f46100e = b11;
        if (b11 == null || !b11.isAnnotationPresent(fm.a.class)) {
            return;
        }
        c((fm.a) b11.getAnnotation(fm.a.class));
    }

    public d(Field field, c cVar) {
        String name = field.getName();
        this.f46097b = name;
        this.f46096a = name;
        this.f46098c = cVar;
        this.f46100e = field;
        this.f46099d = field.getType();
        if (field.isAnnotationPresent(fm.a.class)) {
            c((fm.a) field.getAnnotation(fm.a.class));
        }
    }

    private void c(fm.a aVar) {
        this.f46097b = aVar.name().length() > 0 ? aVar.name() : this.f46096a;
        this.f46104i = aVar.transformer() == com.transsion.json.b.n.class ? null : new g(aVar.transformer());
        this.f46105j = aVar.objectFactory() != o.class ? new g(aVar.objectFactory()) : null;
        this.f46106k = Boolean.valueOf(aVar.include());
    }

    public Object a(Object obj) {
        try {
            Method i11 = i();
            if (i11 != null) {
                return i11.invoke(obj, null);
            }
            Field field = this.f46100e;
            if (field != null) {
                return field.get(obj);
            }
            return null;
        } catch (IllegalAccessException e11) {
            e = e11;
            throw new k("Error while reading property " + this.f46099d.getName() + "." + this.f46096a, e);
        } catch (InvocationTargetException e12) {
            e = e12;
            throw new k("Error while reading property " + this.f46099d.getName() + "." + this.f46096a, e);
        }
    }

    public String b() {
        return this.f46097b;
    }

    public void d(Method method) {
        Class<?> cls = method.getParameterTypes()[0];
        if (this.f46099d == null) {
            this.f46099d = cls;
        }
        this.f46103h.put(cls, method);
        method.setAccessible(true);
    }

    public String e() {
        return this.f46096a;
    }

    public void f(Method method) {
        if (this.f46099d == null) {
            this.f46099d = method.getReturnType();
            this.f46101f = method;
            method.setAccessible(true);
        } else if (method.getReturnType().isAssignableFrom(this.f46099d)) {
            this.f46101f = method;
            method.setAccessible(true);
        }
        Method method2 = this.f46101f;
        if (method2 == null || !method2.isAnnotationPresent(fm.a.class)) {
            return;
        }
        c((fm.a) this.f46101f.getAnnotation(fm.a.class));
    }

    public Field g() {
        return this.f46100e;
    }

    public Class h() {
        return this.f46099d;
    }

    public Method i() {
        return (this.f46101f == null && this.f46098c.e() != null && this.f46098c.e().h(this.f46096a)) ? this.f46098c.e().f(this.f46096a).i() : this.f46101f;
    }

    public com.transsion.json.b.n j() {
        g gVar = this.f46104i;
        if (gVar != null) {
            return (com.transsion.json.b.n) gVar.a();
        }
        return null;
    }

    public Method k() {
        if (this.f46102g == null) {
            Method method = (Method) this.f46103h.get(this.f46099d);
            this.f46102g = method;
            if (method == null && this.f46098c.e() != null && this.f46098c.e().h(this.f46096a)) {
                return this.f46098c.e().f(this.f46096a).k();
            }
        }
        return this.f46102g;
    }

    public Boolean l() {
        return this.f46106k;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean m() {
        return i() == null && k() == null && !Modifier.isPublic(this.f46100e.getModifiers());
    }

    public Boolean n() {
        Field field;
        Method i11 = i();
        return Boolean.valueOf(((i11 == null || Modifier.isStatic(i11.getModifiers())) && ((field = this.f46100e) == null || Modifier.isStatic(field.getModifiers()) || Modifier.isTransient(this.f46100e.getModifiers()))) ? false : true);
    }

    public Boolean o() {
        Field field = this.f46100e;
        return Boolean.valueOf(field != null && Modifier.isTransient(field.getModifiers()));
    }

    public Boolean p() {
        Field field;
        return Boolean.valueOf((k() == null && ((field = this.f46100e) == null || !Modifier.isPublic(field.getModifiers()) || Modifier.isTransient(this.f46100e.getModifiers()))) ? false : true);
    }
}
