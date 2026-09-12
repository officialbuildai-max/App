package org.apache.tools.ant;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes7.dex */
public final class o {
    static /* synthetic */ Class A;
    static /* synthetic */ Class B;

    /* renamed from: h, reason: collision with root package name */
    private static final Map f71399h = new Hashtable();

    /* renamed from: i, reason: collision with root package name */
    private static final Map f71400i = new HashMap(8);

    /* renamed from: j, reason: collision with root package name */
    static /* synthetic */ Class f71401j;

    /* renamed from: k, reason: collision with root package name */
    static /* synthetic */ Class f71402k;

    /* renamed from: l, reason: collision with root package name */
    static /* synthetic */ Class f71403l;

    /* renamed from: m, reason: collision with root package name */
    static /* synthetic */ Class f71404m;

    /* renamed from: n, reason: collision with root package name */
    static /* synthetic */ Class f71405n;

    /* renamed from: o, reason: collision with root package name */
    static /* synthetic */ Class f71406o;

    /* renamed from: p, reason: collision with root package name */
    static /* synthetic */ Class f71407p;

    /* renamed from: q, reason: collision with root package name */
    static /* synthetic */ Class f71408q;

    /* renamed from: r, reason: collision with root package name */
    static /* synthetic */ Class f71409r;

    /* renamed from: s, reason: collision with root package name */
    static /* synthetic */ Class f71410s;

    /* renamed from: t, reason: collision with root package name */
    static /* synthetic */ Class f71411t;

    /* renamed from: u, reason: collision with root package name */
    static /* synthetic */ Class f71412u;

    /* renamed from: v, reason: collision with root package name */
    static /* synthetic */ Class f71413v;

    /* renamed from: w, reason: collision with root package name */
    static /* synthetic */ Class f71414w;

    /* renamed from: x, reason: collision with root package name */
    static /* synthetic */ Class f71415x;

    /* renamed from: y, reason: collision with root package name */
    static /* synthetic */ Class f71416y;

    /* renamed from: z, reason: collision with root package name */
    static /* synthetic */ Class f71417z;

    /* renamed from: a, reason: collision with root package name */
    private Hashtable f71418a = new Hashtable();

    /* renamed from: b, reason: collision with root package name */
    private Hashtable f71419b = new Hashtable();

    /* renamed from: c, reason: collision with root package name */
    private Hashtable f71420c = new Hashtable();

    /* renamed from: d, reason: collision with root package name */
    private Hashtable f71421d = new Hashtable();

    /* renamed from: e, reason: collision with root package name */
    private List f71422e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private Method f71423f;

    /* renamed from: g, reason: collision with root package name */
    private Class f71424g;

    /* loaded from: classes7.dex */
    private static class a extends e {

        /* renamed from: b, reason: collision with root package name */
        private Constructor f71425b;

        /* renamed from: c, reason: collision with root package name */
        private int f71426c;

        a(Method method, Constructor constructor, int i11) {
            super(method);
            this.f71425b = constructor;
            this.f71426c = i11;
        }

        private void e(Object obj, Object obj2) {
            b().invoke(obj, obj2);
        }

        @Override // org.apache.tools.ant.o.e
        Object a(Project project, Object obj, Object obj2) {
            if (obj2 == null) {
                Constructor constructor = this.f71425b;
                obj2 = constructor.newInstance(constructor.getParameterTypes().length == 0 ? new Object[0] : new Object[]{project});
            }
            if (this.f71426c == 1) {
                e(obj, obj2);
            }
            return obj2;
        }

        @Override // org.apache.tools.ant.o.e
        boolean c() {
            return true;
        }

        @Override // org.apache.tools.ant.o.e
        void d(Object obj, Object obj2) {
            if (this.f71426c == 2) {
                e(obj, obj2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static abstract class b {

        /* renamed from: a, reason: collision with root package name */
        private Method f71427a;

        /* JADX INFO: Access modifiers changed from: protected */
        public b(Method method) {
            this.f71427a = method;
        }

        abstract void a(Project project, Object obj, String str);
    }

    /* loaded from: classes7.dex */
    private static class c extends e {
        c(Method method) {
            super(method);
        }

        @Override // org.apache.tools.ant.o.e
        Object a(Project project, Object obj, Object obj2) {
            return b().invoke(obj, null);
        }
    }

    /* loaded from: classes7.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        private e f71428a;

        /* renamed from: b, reason: collision with root package name */
        private Object f71429b;

        /* renamed from: c, reason: collision with root package name */
        private Project f71430c;

        /* renamed from: d, reason: collision with root package name */
        private Object f71431d;

        /* renamed from: e, reason: collision with root package name */
        private String f71432e;

        private d(Project project, Object obj, e eVar) {
            this.f71430c = project;
            this.f71429b = obj;
            this.f71428a = eVar;
        }

        /* synthetic */ d(Project project, Object obj, e eVar, g gVar) {
            this(project, obj, eVar);
        }

        public Object a() {
            if (this.f71432e != null) {
                if (!this.f71428a.c()) {
                    throw new BuildException("Not allowed to use the polymorphic form for this element");
                }
                Object d11 = ComponentHelper.j(this.f71430c).d(this.f71432e);
                this.f71431d = d11;
                if (d11 == null) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Unable to create object of type ");
                    stringBuffer.append(this.f71432e);
                    throw new BuildException(stringBuffer.toString());
                }
            }
            try {
                Object a11 = this.f71428a.a(this.f71430c, this.f71429b, this.f71431d);
                this.f71431d = a11;
                Project project = this.f71430c;
                if (project != null) {
                    project.K(a11);
                }
                return this.f71431d;
            } catch (IllegalAccessException e11) {
                throw new BuildException(e11);
            } catch (IllegalArgumentException e12) {
                if (this.f71432e == null) {
                    throw e12;
                }
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Invalid type used ");
                stringBuffer2.append(this.f71432e);
                throw new BuildException(stringBuffer2.toString());
            } catch (InstantiationException e13) {
                throw new BuildException(e13);
            } catch (InvocationTargetException e14) {
                throw o.g(e14);
            }
        }

        public void b(String str) {
            this.f71432e = str;
        }

        public void c() {
            try {
                this.f71428a.d(this.f71429b, this.f71431d);
            } catch (IllegalAccessException e11) {
                throw new BuildException(e11);
            } catch (IllegalArgumentException e12) {
                if (this.f71432e == null) {
                    throw e12;
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Invalid type used ");
                stringBuffer.append(this.f71432e);
                throw new BuildException(stringBuffer.toString());
            } catch (InstantiationException e13) {
                throw new BuildException(e13);
            } catch (InvocationTargetException e14) {
                throw o.g(e14);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static abstract class e {

        /* renamed from: a, reason: collision with root package name */
        private Method f71433a;

        /* JADX INFO: Access modifiers changed from: protected */
        public e(Method method) {
            this.f71433a = method;
        }

        abstract Object a(Project project, Object obj, Object obj2);

        /* JADX INFO: Access modifiers changed from: package-private */
        public Method b() {
            return this.f71433a;
        }

        boolean c() {
            return false;
        }

        void d(Object obj, Object obj2) {
        }
    }

    static {
        Class[] clsArr = {Boolean.TYPE, Byte.TYPE, Character.TYPE, Short.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE};
        Class cls = f71401j;
        if (cls == null) {
            cls = c("java.lang.Boolean");
            f71401j = cls;
        }
        Class cls2 = f71402k;
        if (cls2 == null) {
            cls2 = c("java.lang.Byte");
            f71402k = cls2;
        }
        Class cls3 = f71403l;
        if (cls3 == null) {
            cls3 = c("java.lang.Character");
            f71403l = cls3;
        }
        Class cls4 = f71404m;
        if (cls4 == null) {
            cls4 = c("java.lang.Short");
            f71404m = cls4;
        }
        Class cls5 = f71405n;
        if (cls5 == null) {
            cls5 = c("java.lang.Integer");
            f71405n = cls5;
        }
        Class cls6 = f71406o;
        if (cls6 == null) {
            cls6 = c("java.lang.Long");
            f71406o = cls6;
        }
        Class cls7 = f71407p;
        if (cls7 == null) {
            cls7 = c("java.lang.Float");
            f71407p = cls7;
        }
        Class cls8 = f71408q;
        if (cls8 == null) {
            cls8 = c("java.lang.Double");
            f71408q = cls8;
        }
        Class[] clsArr2 = {cls, cls2, cls3, cls4, cls5, cls6, cls7, cls8};
        for (int i11 = 0; i11 < 8; i11++) {
            f71400i.put(clsArr[i11], clsArr2[i11]);
        }
    }

    private o(Class cls) {
        Constructor<?> constructor;
        Constructor<?> constructor2;
        int i11 = 1;
        this.f71423f = null;
        this.f71424g = cls;
        Method[] methods = cls.getMethods();
        for (int i12 = 0; i12 < methods.length; i12 += i11) {
            Method method = methods[i12];
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length == i11 && Void.TYPE.equals(returnType) && ("add".equals(name) || "addConfigured".equals(name))) {
                n(method);
            } else {
                Class cls2 = f71409r;
                if (cls2 == null) {
                    cls2 = c("org.apache.tools.ant.ProjectComponent");
                    f71409r = cls2;
                }
                if (!cls2.isAssignableFrom(cls) || parameterTypes.length != i11 || !q(name, parameterTypes[0])) {
                    if (o() && parameterTypes.length == i11 && "addTask".equals(name)) {
                        Class cls3 = f71410s;
                        if (cls3 == null) {
                            cls3 = c("org.apache.tools.ant.Task");
                            f71410s = cls3;
                        }
                        if (cls3.equals(parameterTypes[0])) {
                        }
                    }
                    if ("addText".equals(name) && Void.TYPE.equals(returnType) && parameterTypes.length == i11) {
                        Class cls4 = f71411t;
                        if (cls4 == null) {
                            cls4 = c("java.lang.String");
                            f71411t = cls4;
                        }
                        if (cls4.equals(parameterTypes[0])) {
                            this.f71423f = methods[i12];
                        }
                    }
                    if (name.startsWith("set") && Void.TYPE.equals(returnType) && parameterTypes.length == i11 && !parameterTypes[0].isArray()) {
                        String m11 = m(name, "set");
                        if (this.f71419b.get(m11) != null) {
                            Class cls5 = f71411t;
                            if (cls5 == null) {
                                cls5 = c("java.lang.String");
                                f71411t = cls5;
                            }
                            if (cls5.equals(parameterTypes[0])) {
                            }
                        }
                        b f11 = f(method, parameterTypes[0], m11);
                        if (f11 != null) {
                            this.f71418a.put(m11, parameterTypes[0]);
                            this.f71419b.put(m11, f11);
                        }
                    } else if (!name.startsWith("create") || returnType.isArray() || returnType.isPrimitive() || parameterTypes.length != 0) {
                        if (name.startsWith("addConfigured") && Void.TYPE.equals(returnType) && parameterTypes.length == i11) {
                            Class cls6 = f71411t;
                            if (cls6 == null) {
                                cls6 = c("java.lang.String");
                                f71411t = cls6;
                            }
                            if (!cls6.equals(parameterTypes[0]) && !parameterTypes[0].isArray() && !parameterTypes[0].isPrimitive()) {
                                try {
                                    try {
                                        constructor2 = parameterTypes[0].getConstructor(null);
                                    } catch (NoSuchMethodException unused) {
                                        Class<?> cls7 = parameterTypes[0];
                                        Class<?> cls8 = f71412u;
                                        if (cls8 == null) {
                                            cls8 = c("org.apache.tools.ant.Project");
                                            f71412u = cls8;
                                        }
                                        constructor2 = cls7.getConstructor(cls8);
                                    }
                                    String m12 = m(name, "addConfigured");
                                    this.f71420c.put(m12, parameterTypes[0]);
                                    this.f71421d.put(m12, new a(method, constructor2, 2));
                                } catch (NoSuchMethodException unused2) {
                                }
                                i11 = 1;
                            }
                        }
                        if (name.startsWith("add") && Void.TYPE.equals(returnType)) {
                            if (parameterTypes.length == 1) {
                                Class cls9 = f71411t;
                                if (cls9 == null) {
                                    cls9 = c("java.lang.String");
                                    f71411t = cls9;
                                }
                                if (!cls9.equals(parameterTypes[0]) && !parameterTypes[0].isArray() && !parameterTypes[0].isPrimitive()) {
                                    try {
                                        constructor = parameterTypes[0].getConstructor(null);
                                    } catch (NoSuchMethodException unused3) {
                                        Class<?> cls10 = parameterTypes[0];
                                        Class<?> cls11 = f71412u;
                                        if (cls11 == null) {
                                            cls11 = c("org.apache.tools.ant.Project");
                                            f71412u = cls11;
                                        }
                                        constructor = cls10.getConstructor(cls11);
                                    }
                                    String m13 = m(name, "add");
                                    if (this.f71420c.get(m13) == null) {
                                        this.f71420c.put(m13, parameterTypes[0]);
                                        this.f71421d.put(m13, new a(method, constructor, 1));
                                    }
                                }
                            } else {
                                i11 = 1;
                            }
                        }
                        i11 = 1;
                    } else {
                        String m14 = m(name, "create");
                        if (this.f71421d.get(m14) == null) {
                            this.f71420c.put(m14, returnType);
                            this.f71421d.put(m14, new c(method));
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Class c(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e11) {
            throw new NoClassDefFoundError(e11.getMessage());
        }
    }

    private String d(String str) {
        return str.length() <= 20 ? str : new StringBuffer(str).replace(8, str.length() - 8, "...").toString();
    }

    private e e(Project project, Object obj, String str) {
        ComponentHelper j11;
        Class i11;
        Method h11;
        Object d11;
        if (this.f71422e.size() == 0 || (i11 = (j11 = ComponentHelper.j(project)).i(str)) == null || (h11 = h(i11, this.f71422e)) == null || (d11 = j11.d(str)) == null) {
            return null;
        }
        return new f(this, h11, d11, d11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private b f(Method method, Class cls, String str) {
        Constructor constructor;
        boolean z10;
        Map map = f71400i;
        if (map.containsKey(cls)) {
            cls = (Class) map.get(cls);
        }
        Class cls2 = f71411t;
        if (cls2 == null) {
            cls2 = c("java.lang.String");
            f71411t = cls2;
        }
        if (cls2.equals(cls)) {
            return new h(this, method, method);
        }
        Class cls3 = f71403l;
        if (cls3 == null) {
            cls3 = c("java.lang.Character");
            f71403l = cls3;
        }
        if (cls3.equals(cls)) {
            return new i(this, method, str, method);
        }
        Class cls4 = f71401j;
        if (cls4 == null) {
            cls4 = c("java.lang.Boolean");
            f71401j = cls4;
        }
        if (cls4.equals(cls)) {
            return new j(this, method, method);
        }
        Class cls5 = f71417z;
        if (cls5 == null) {
            cls5 = c("java.lang.Class");
            f71417z = cls5;
        }
        if (cls5.equals(cls)) {
            return new k(this, method, method);
        }
        Class cls6 = A;
        if (cls6 == null) {
            cls6 = c("java.io.File");
            A = cls6;
        }
        if (cls6.equals(cls)) {
            return new l(this, method, method);
        }
        Class cls7 = B;
        Class cls8 = cls7;
        if (cls7 == null) {
            Class c11 = c("org.apache.tools.ant.types.EnumeratedAttribute");
            B = c11;
            cls8 = c11;
        }
        if (cls8.isAssignableFrom(cls)) {
            return new m(this, method, cls, method);
        }
        if (Enum.class != 0 && Enum.class.isAssignableFrom(cls)) {
            return new n(this, method, method, cls);
        }
        Class cls9 = f71406o;
        if (cls9 == null) {
            cls9 = c("java.lang.Long");
            f71406o = cls9;
        }
        if (cls9.equals(cls)) {
            return new org.apache.tools.ant.d(this, method, method);
        }
        try {
            try {
                Class<?> cls10 = f71412u;
                if (cls10 == null) {
                    cls10 = c("org.apache.tools.ant.Project");
                    f71412u = cls10;
                }
                Class<?> cls11 = f71411t;
                if (cls11 == null) {
                    cls11 = c("java.lang.String");
                    f71411t = cls11;
                }
                constructor = cls.getConstructor(cls10, cls11);
                z10 = true;
            } catch (NoSuchMethodException unused) {
                return null;
            }
        } catch (NoSuchMethodException unused2) {
            Class<?> cls12 = f71411t;
            if (cls12 == null) {
                cls12 = c("java.lang.String");
                f71411t = cls12;
            }
            constructor = cls.getConstructor(cls12);
            z10 = false;
        }
        return new org.apache.tools.ant.e(this, method, z10, constructor, method);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static BuildException g(InvocationTargetException invocationTargetException) {
        Throwable targetException = invocationTargetException.getTargetException();
        return targetException instanceof BuildException ? (BuildException) targetException : new BuildException(targetException);
    }

    private Method h(Class cls, List list) {
        Method method = null;
        Class<?> cls2 = null;
        for (int i11 = 0; i11 < list.size(); i11++) {
            Method method2 = (Method) list.get(i11);
            Class<?> cls3 = method2.getParameterTypes()[0];
            if (cls3.isAssignableFrom(cls)) {
                if (cls2 == null) {
                    method = method2;
                    cls2 = cls3;
                } else if (!cls3.isAssignableFrom(cls2)) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("ambiguous: types ");
                    stringBuffer.append(cls2.getName());
                    stringBuffer.append(" and ");
                    stringBuffer.append(cls3.getName());
                    stringBuffer.append(" match ");
                    stringBuffer.append(cls.getName());
                    throw new BuildException(stringBuffer.toString());
                }
            }
        }
        return method;
    }

    private String j(Project project, Object obj) {
        return project.p(obj);
    }

    public static o k(Project project, Class cls) {
        Map map = f71399h;
        o oVar = (o) map.get(cls.getName());
        if (oVar == null || oVar.f71424g != cls) {
            oVar = new o(cls);
            if (project != null) {
                map.put(cls.getName(), oVar);
            }
        }
        return oVar;
    }

    private e l(Project project, String str, Object obj, String str2, w wVar) {
        String d11 = r.d(str2);
        String c11 = r.c(str2);
        if (d11.equals("antlib:org.apache.tools.ant")) {
            d11 = "";
        }
        if (str.equals("antlib:org.apache.tools.ant")) {
            str = "";
        }
        e eVar = (d11.equals(str) || d11.length() == 0) ? (e) this.f71421d.get(c11.toLowerCase(Locale.US)) : null;
        if (eVar == null) {
            eVar = e(project, obj, str2);
        }
        if (eVar == null) {
            t(project, obj, str2);
        }
        return eVar;
    }

    private static String m(String str, String str2) {
        return str.substring(str2.length()).toLowerCase(Locale.US);
    }

    private void n(Method method) {
        Class<?> cls = method.getParameterTypes()[0];
        for (int i11 = 0; i11 < this.f71422e.size(); i11++) {
            Method method2 = (Method) this.f71422e.get(i11);
            if (method2.getParameterTypes()[0].equals(cls)) {
                if (method.getName().equals("addConfigured")) {
                    this.f71422e.set(i11, method);
                    return;
                }
                return;
            } else {
                if (method2.getParameterTypes()[0].isAssignableFrom(cls)) {
                    this.f71422e.add(i11, method);
                    return;
                }
            }
        }
        this.f71422e.add(method);
    }

    private boolean q(String str, Class cls) {
        if ("setLocation".equals(str)) {
            Class cls2 = f71413v;
            if (cls2 == null) {
                cls2 = c("org.apache.tools.ant.Location");
                f71413v = cls2;
            }
            if (cls2.equals(cls)) {
                return true;
            }
        }
        if (!"setTaskType".equals(str)) {
            return false;
        }
        Class cls3 = f71411t;
        if (cls3 == null) {
            cls3 = c("java.lang.String");
            f71411t = cls3;
        }
        return cls3.equals(cls);
    }

    public void b(Project project, Object obj, String str) {
        Method method = this.f71423f;
        if (method != null) {
            try {
                method.invoke(obj, str);
                return;
            } catch (IllegalAccessException e11) {
                throw new BuildException(e11);
            } catch (InvocationTargetException e12) {
                throw g(e12);
            }
        }
        String trim = str.trim();
        if (trim.length() == 0) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(project.p(obj));
        stringBuffer.append(" doesn't support nested text data (\"");
        stringBuffer.append(d(trim));
        stringBuffer.append("\").");
        throw new BuildException(stringBuffer.toString());
    }

    public d i(Project project, String str, Object obj, String str2, w wVar) {
        return new d(project, obj, l(project, str, obj, str2, wVar), null);
    }

    public boolean o() {
        Class cls = f71416y;
        if (cls == null) {
            cls = c("org.apache.tools.ant.TaskContainer");
            f71416y = cls;
        }
        return cls.isAssignableFrom(this.f71424g);
    }

    public boolean p() {
        Class cls = f71414w;
        if (cls == null) {
            cls = c("org.apache.tools.ant.DynamicElement");
            f71414w = cls;
        }
        if (!cls.isAssignableFrom(this.f71424g)) {
            Class cls2 = f71415x;
            if (cls2 == null) {
                cls2 = c("org.apache.tools.ant.DynamicElementNS");
                f71415x = cls2;
            }
            if (!cls2.isAssignableFrom(this.f71424g)) {
                return false;
            }
        }
        return true;
    }

    public void r(Project project, Object obj, String str, String str2) {
        b bVar = (b) this.f71419b.get(str.toLowerCase(Locale.US));
        if (bVar != null) {
            try {
                bVar.a(project, obj, str2);
                return;
            } catch (IllegalAccessException e11) {
                throw new BuildException(e11);
            } catch (InvocationTargetException e12) {
                throw g(e12);
            }
        }
        if (str.indexOf(58) != -1) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(j(project, obj));
        stringBuffer.append(" doesn't support the \"");
        stringBuffer.append(str);
        stringBuffer.append("\" attribute.");
        throw new UnsupportedAttributeException(stringBuffer.toString(), str);
    }

    public boolean s(String str, String str2) {
        if (p() || this.f71422e.size() > 0) {
            return true;
        }
        if (!this.f71421d.containsKey(r.c(str2).toLowerCase(Locale.US))) {
            return false;
        }
        String d11 = r.d(str2);
        if (d11.equals("antlib:org.apache.tools.ant")) {
            d11 = "";
        }
        if ("".equals(d11)) {
            return true;
        }
        if (str.equals("antlib:org.apache.tools.ant")) {
            str = "";
        }
        return d11.equals(str);
    }

    public void t(Project project, Object obj, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(project.p(obj));
        stringBuffer.append(" doesn't support the nested \"");
        stringBuffer.append(str);
        stringBuffer.append("\" element.");
        throw new UnsupportedElementException(stringBuffer.toString(), str);
    }
}
