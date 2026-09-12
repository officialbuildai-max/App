package z4;

import com.alibaba.fastjson.JSONException;
import com.transsion.gslb.Utils;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes3.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    public final com.alibaba.fastjson.util.d f79366a;

    /* renamed from: b, reason: collision with root package name */
    protected final Class f79367b;

    public l(Class cls, com.alibaba.fastjson.util.d dVar) {
        this.f79367b = cls;
        this.f79366a = dVar;
    }

    private static boolean a(Field field, Method method, Object obj, Object obj2) {
        if (e(field, obj, obj2)) {
            return true;
        }
        try {
            obj.getClass().getDeclaredMethod("set" + method.getName().substring(3), method.getReturnType()).invoke(obj, obj2);
            return true;
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return false;
        }
    }

    private static boolean e(Field field, Object obj, Object obj2) {
        if (field == null || Modifier.isFinal(field.getModifiers())) {
            return false;
        }
        field.set(obj, obj2);
        return true;
    }

    public int b() {
        return 0;
    }

    public Class c() {
        return this.f79367b;
    }

    public abstract void d(y4.a aVar, Object obj, Type type, Map map);

    public void f(Object obj, int i11) {
        h(obj, Integer.valueOf(i11));
    }

    public void g(Object obj, long j11) {
        h(obj, Long.valueOf(j11));
    }

    public void h(Object obj, Object obj2) {
        com.alibaba.fastjson.util.d dVar;
        Method method;
        String str;
        if (obj2 == null && this.f79366a.f18283e.isPrimitive()) {
            return;
        }
        com.alibaba.fastjson.util.d dVar2 = this.f79366a;
        if (dVar2.f18283e == String.class && (str = dVar2.f18298t) != null && str.equals("trim")) {
            obj2 = ((String) obj2).trim();
        }
        try {
            dVar = this.f79366a;
            method = dVar.f18280b;
        } catch (Exception e11) {
            throw new JSONException("set property error, " + this.f79367b.getName() + Utils.SEPARATOR + this.f79366a.f18279a, e11);
        }
        if (method == null) {
            Field field = dVar.f18281c;
            if (!dVar.f18286h) {
                if (field != null) {
                    field.set(obj, obj2);
                    return;
                }
                return;
            }
            Class cls = dVar.f18283e;
            if (cls == AtomicInteger.class) {
                AtomicInteger atomicInteger = (AtomicInteger) field.get(obj);
                if (atomicInteger != null) {
                    atomicInteger.set(((AtomicInteger) obj2).get());
                    return;
                }
                return;
            }
            if (cls == AtomicLong.class) {
                AtomicLong atomicLong = (AtomicLong) field.get(obj);
                if (atomicLong != null) {
                    atomicLong.set(((AtomicLong) obj2).get());
                    return;
                }
                return;
            }
            if (cls == AtomicBoolean.class) {
                AtomicBoolean atomicBoolean = (AtomicBoolean) field.get(obj);
                if (atomicBoolean != null) {
                    atomicBoolean.set(((AtomicBoolean) obj2).get());
                    return;
                }
                return;
            }
            if (Map.class.isAssignableFrom(cls)) {
                Map map = (Map) field.get(obj);
                if (map != null && map != Collections.emptyMap() && !map.getClass().getName().startsWith("java.util.Collections$Unmodifiable")) {
                    map.putAll((Map) obj2);
                    return;
                }
                return;
            }
            Collection collection = (Collection) field.get(obj);
            if (collection != null && obj2 != null && collection != Collections.emptySet() && collection != Collections.emptyList() && !collection.getClass().getName().startsWith("java.util.Collections$Unmodifiable")) {
                collection.clear();
                collection.addAll((Collection) obj2);
                return;
            }
            return;
        }
        if (!dVar.f18286h) {
            method.invoke(obj, obj2);
            return;
        }
        Class cls2 = dVar.f18283e;
        if (cls2 == AtomicInteger.class) {
            AtomicInteger atomicInteger2 = (AtomicInteger) method.invoke(obj, null);
            if (atomicInteger2 != null) {
                atomicInteger2.set(((AtomicInteger) obj2).get());
                return;
            } else {
                a(this.f79366a.f18281c, method, obj, obj2);
                return;
            }
        }
        if (cls2 == AtomicLong.class) {
            AtomicLong atomicLong2 = (AtomicLong) method.invoke(obj, null);
            if (atomicLong2 != null) {
                atomicLong2.set(((AtomicLong) obj2).get());
                return;
            } else {
                a(this.f79366a.f18281c, method, obj, obj2);
                return;
            }
        }
        if (cls2 == AtomicBoolean.class) {
            AtomicBoolean atomicBoolean2 = (AtomicBoolean) method.invoke(obj, null);
            if (atomicBoolean2 != null) {
                atomicBoolean2.set(((AtomicBoolean) obj2).get());
                return;
            } else {
                a(this.f79366a.f18281c, method, obj, obj2);
                return;
            }
        }
        if (Map.class.isAssignableFrom(method.getReturnType())) {
            try {
                Map map2 = (Map) method.invoke(obj, null);
                if (map2 == null) {
                    if (obj2 != null) {
                        a(this.f79366a.f18281c, method, obj, obj2);
                        return;
                    }
                    return;
                } else {
                    if (map2 == Collections.emptyMap()) {
                        return;
                    }
                    if (map2.isEmpty() && ((Map) obj2).isEmpty()) {
                        return;
                    }
                    String name = map2.getClass().getName();
                    if (!name.equals("java.util.ImmutableCollections$Map1") && !name.equals("java.util.ImmutableCollections$MapN") && !name.startsWith("java.util.Collections$Unmodifiable")) {
                        if (map2.getClass().getName().equals("kotlin.collections.EmptyMap")) {
                            a(this.f79366a.f18281c, method, obj, obj2);
                            return;
                        } else {
                            map2.putAll((Map) obj2);
                            return;
                        }
                    }
                    return;
                }
            } catch (InvocationTargetException unused) {
                a(this.f79366a.f18281c, method, obj, obj2);
                return;
            }
        }
        try {
            Collection collection2 = (Collection) method.invoke(obj, null);
            if (collection2 == null || obj2 == null) {
                if (collection2 != null || obj2 == null) {
                    return;
                }
                a(this.f79366a.f18281c, method, obj, obj2);
                return;
            }
            String name2 = collection2.getClass().getName();
            if (collection2 != Collections.emptySet() && collection2 != Collections.emptyList() && name2 != "java.util.ImmutableCollections$ListN" && name2 != "java.util.ImmutableCollections$List12" && !name2.startsWith("java.util.Collections$Unmodifiable")) {
                if (!collection2.isEmpty()) {
                    collection2.clear();
                } else if (((Collection) obj2).isEmpty()) {
                    return;
                }
                if (!name2.equals("kotlin.collections.EmptyList") && !name2.equals("kotlin.collections.EmptySet")) {
                    collection2.addAll((Collection) obj2);
                    return;
                }
                a(this.f79366a.f18281c, method, obj, obj2);
                return;
            }
            return;
        } catch (InvocationTargetException unused2) {
            a(this.f79366a.f18281c, method, obj, obj2);
            return;
        }
        throw new JSONException("set property error, " + this.f79367b.getName() + Utils.SEPARATOR + this.f79366a.f18279a, e11);
    }

    public void i(Object obj, String str) {
        h(obj, str);
    }

    public void j(Object obj, boolean z10) {
        h(obj, Boolean.valueOf(z10));
    }
}
