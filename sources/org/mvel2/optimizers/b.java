package org.mvel2.optimizers;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mvel2.optimizers.dynamic.DynamicOptimizer;
import org.mvel2.optimizers.impl.asm.ASMAccessorOptimizer;
import org.mvel2.optimizers.impl.refl.ReflectiveAccessorOptimizer;

/* loaded from: classes7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static String f72117a = "dynamic";

    /* renamed from: b, reason: collision with root package name */
    public static String f72118b = "reflective";

    /* renamed from: c, reason: collision with root package name */
    private static final Logger f72119c = Logger.getLogger(b.class.getName());

    /* renamed from: d, reason: collision with root package name */
    private static String f72120d;

    /* renamed from: e, reason: collision with root package name */
    private static final Map f72121e;

    /* renamed from: f, reason: collision with root package name */
    private static ThreadLocal f72122f;

    static {
        HashMap hashMap = new HashMap();
        f72121e = hashMap;
        f72122f = new ThreadLocal();
        hashMap.put(f72118b, new ReflectiveAccessorOptimizer());
        hashMap.put(f72117a, new DynamicOptimizer());
        try {
            if (b.class.getClassLoader() != null) {
                b.class.getClassLoader().loadClass("org.mvel2.asm.ClassWriter");
            } else {
                ClassLoader.getSystemClassLoader().loadClass("org.mvel2.asm.ClassWriter");
            }
            hashMap.put("ASM", new ASMAccessorOptimizer());
        } catch (ClassNotFoundException unused) {
            f72120d = f72118b;
        } catch (Throwable th2) {
            f72119c.log(Level.WARNING, "[MVEL] Notice: Possible incorrect version of ASM present (3.0 required).  Disabling JIT compiler.  Reflective Optimizer will be used.", th2);
            f72120d = f72118b;
        }
        if (Boolean.getBoolean("mvel2.disable.jit")) {
            e(f72118b);
        } else {
            e(f72117a);
        }
    }

    public static void a() {
        f72122f.set(null);
        f72122f.remove();
    }

    public static a b(String str) {
        try {
            return (a) ((a) f72121e.get(str)).getClass().newInstance();
        } catch (Exception e11) {
            throw new RuntimeException("unable to instantiate accessor compiler", e11);
        }
    }

    public static a c() {
        try {
            return (a) ((a) f72121e.get(f72120d)).getClass().newInstance();
        } catch (Exception e11) {
            throw new RuntimeException("unable to instantiate accessor compiler", e11);
        }
    }

    public static a d() {
        if (f72122f.get() == null) {
            f72122f.set(c().getClass());
        }
        try {
            return (a) ((Class) f72122f.get()).newInstance();
        } catch (Exception e11) {
            throw new RuntimeException("unable to instantiate accessor compiler", e11);
        }
    }

    public static void e(String str) {
        try {
            Map map = f72121e;
            f72120d = str;
            ((a) map.get(str)).init();
            f72122f.set(null);
        } catch (Exception e11) {
            throw new RuntimeException("unable to instantiate accessor compiler", e11);
        }
    }

    public static void f(Class cls) {
        if (cls == null) {
            throw new RuntimeException("null optimizer");
        }
        f72122f.set(cls);
    }
}
