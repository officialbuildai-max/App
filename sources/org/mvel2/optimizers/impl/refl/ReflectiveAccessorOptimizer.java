package org.mvel2.optimizers.impl.refl;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import o10.b;
import o10.c;
import o10.d;
import org.mvel2.CompileException;
import org.mvel2.OptimizationFailure;
import org.mvel2.ParserContext;
import org.mvel2.PropertyAccessException;
import org.mvel2.ast.TypeDescriptor;
import org.mvel2.compiler.AbstractParser;
import org.mvel2.compiler.AccessorNode;
import org.mvel2.compiler.ExecutableStatement;
import org.mvel2.compiler.PropertyVerifier;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.optimizers.AbstractOptimizer;
import org.mvel2.optimizers.a;
import org.mvel2.optimizers.impl.refl.nodes.ArrayAccessor;
import org.mvel2.optimizers.impl.refl.nodes.ArrayAccessorNest;
import org.mvel2.optimizers.impl.refl.nodes.ArrayLength;
import org.mvel2.optimizers.impl.refl.nodes.ConstructorAccessor;
import org.mvel2.optimizers.impl.refl.nodes.DynamicFieldAccessor;
import org.mvel2.optimizers.impl.refl.nodes.DynamicFunctionAccessor;
import org.mvel2.optimizers.impl.refl.nodes.FieldAccessor;
import org.mvel2.optimizers.impl.refl.nodes.FieldAccessorNH;
import org.mvel2.optimizers.impl.refl.nodes.FunctionAccessor;
import org.mvel2.optimizers.impl.refl.nodes.GetterAccessor;
import org.mvel2.optimizers.impl.refl.nodes.GetterAccessorNH;
import org.mvel2.optimizers.impl.refl.nodes.IndexedCharSeqAccessor;
import org.mvel2.optimizers.impl.refl.nodes.IndexedCharSeqAccessorNest;
import org.mvel2.optimizers.impl.refl.nodes.IndexedVariableAccessor;
import org.mvel2.optimizers.impl.refl.nodes.ListAccessor;
import org.mvel2.optimizers.impl.refl.nodes.ListAccessorNest;
import org.mvel2.optimizers.impl.refl.nodes.MapAccessor;
import org.mvel2.optimizers.impl.refl.nodes.MapAccessorNest;
import org.mvel2.optimizers.impl.refl.nodes.MethodAccessor;
import org.mvel2.optimizers.impl.refl.nodes.MethodAccessorNH;
import org.mvel2.optimizers.impl.refl.nodes.Notify;
import org.mvel2.optimizers.impl.refl.nodes.NullSafe;
import org.mvel2.optimizers.impl.refl.nodes.PropertyHandlerAccessor;
import org.mvel2.optimizers.impl.refl.nodes.SetterAccessor;
import org.mvel2.optimizers.impl.refl.nodes.StaticReferenceAccessor;
import org.mvel2.optimizers.impl.refl.nodes.StaticVarAccessor;
import org.mvel2.optimizers.impl.refl.nodes.StaticVarAccessorNH;
import org.mvel2.optimizers.impl.refl.nodes.ThisValueAccessor;
import org.mvel2.optimizers.impl.refl.nodes.VariableAccessor;
import org.mvel2.optimizers.impl.refl.nodes.WithAccessor;
import org.mvel2.util.MethodStub;
import org.mvel2.util.e;
import org.mvel2.util.f;
import org.mvel2.util.m;
import org.mvel2.util.n;
import org.mvel2.util.p;
import org.mvel2.util.s;
import org.mvel2.util.t;

/* loaded from: classes7.dex */
public class ReflectiveAccessorOptimizer extends AbstractOptimizer implements a {
    private static final int DONE = -1;
    private Object ctx;
    private AccessorNode currNode;
    private boolean first;
    private Class ingressType;
    private Class returnType;
    private AccessorNode rootNode;
    private Object thisRef;
    private Object val;
    private VariableResolverFactory variableFactory;
    private static final Logger LOG = Logger.getLogger(ReflectiveAccessorOptimizer.class.getName());
    private static final Object[] EMPTYARG = new Object[0];
    private static final Class[] EMPTYCLS = new Class[0];

    public ReflectiveAccessorOptimizer() {
        this.first = true;
    }

    private ReflectiveAccessorOptimizer(ParserContext parserContext, char[] cArr, int i11, int i12, Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        super(parserContext);
        this.first = true;
        this.expr = cArr;
        this.start = i11;
        i12 = cArr == null ? i11 : i12;
        this.length = i12;
        this.end = i11 + i12;
        this.ctx = obj;
        this.variableFactory = variableResolverFactory;
        this.thisRef = obj2;
    }

    private org.mvel2.compiler.a _getAccessor(Object obj, Class cls) {
        int i11;
        int i12 = 0;
        if (obj instanceof List) {
            List list = (List) obj;
            org.mvel2.compiler.a[] aVarArr = new org.mvel2.compiler.a[list.size()];
            Iterator it = list.iterator();
            while (it.hasNext()) {
                aVarArr[i12] = _getAccessor(it.next(), cls);
                i12++;
            }
            this.returnType = List.class;
            return new c(aVarArr);
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            int size = map.size();
            org.mvel2.compiler.a[] aVarArr2 = new org.mvel2.compiler.a[size];
            org.mvel2.compiler.a[] aVarArr3 = new org.mvel2.compiler.a[size];
            for (Object obj2 : map.keySet()) {
                aVarArr2[i12] = _getAccessor(obj2, cls);
                aVarArr3[i12] = _getAccessor(map.get(obj2), cls);
                i12++;
            }
            this.returnType = Map.class;
            return new d(aVarArr2, aVarArr3);
        }
        if (!(obj instanceof Object[])) {
            if (this.returnType == null) {
                this.returnType = Object.class;
            }
            return cls.isArray() ? new b((String) obj, cls, this.ctx, this.variableFactory, this.pCtx) : new b((String) obj, Object.class, this.ctx, this.variableFactory, this.pCtx);
        }
        org.mvel2.compiler.a[] aVarArr4 = new org.mvel2.compiler.a[((Object[]) obj).length];
        if (cls != null) {
            i11 = 0;
            while (cls.getName().charAt(i11) == '[') {
                i11++;
            }
        } else {
            cls = Object[].class;
            i11 = 1;
        }
        try {
            Class I = m.I(cls);
            Class D = i11 > 1 ? m.D(null, m.A0('[', i11 - 1) + "L" + I.getName() + ";", this.pCtx) : cls;
            Object[] objArr = (Object[]) obj;
            int length = objArr.length;
            int i13 = 0;
            while (i12 < length) {
                Object obj3 = objArr[i12];
                ParserContext parserContext = this.pCtx;
                org.mvel2.compiler.a _getAccessor = _getAccessor(obj3, D);
                aVarArr4[i13] = _getAccessor;
                e.c(parserContext, _getAccessor, I, true);
                i12++;
                i13++;
            }
            return new o10.a(aVarArr4, m.T(cls));
        } catch (ClassNotFoundException e11) {
            throw new RuntimeException("this error should never throw:" + m.I(cls).getName(), e11);
        }
    }

    private void addAccessorNode(AccessorNode accessorNode) {
        if (this.rootNode != null) {
            this.currNode = this.currNode.setNextNode(accessorNode);
        } else {
            this.currNode = accessorNode;
            this.rootNode = accessorNode;
        }
    }

    private AccessorNode compileConstructor(char[] cArr, Object obj, VariableResolverFactory variableResolverFactory) throws InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException {
        String[] g11 = m.g(cArr, this.start, this.length);
        int i11 = 0;
        List w02 = m.w0(g11[0].toCharArray());
        if (w02 == null) {
            ParserContext parserContext = this.pCtx;
            Constructor<?> constructor = Class.forName(new String(cArr), true, parserContext != null ? parserContext.getClassLoader() : Thread.currentThread().getContextClassLoader()).getConstructor(EMPTYCLS);
            ConstructorAccessor constructorAccessor = new ConstructorAccessor(constructor, null);
            if (g11.length <= 1) {
                return constructorAccessor;
            }
            ReflectiveAccessorOptimizer reflectiveAccessorOptimizer = new ReflectiveAccessorOptimizer(this.pCtx, g11[1].toCharArray(), 0, g11[1].length(), constructor.newInstance(null), obj, variableResolverFactory);
            reflectiveAccessorOptimizer.setRootNode(constructorAccessor);
            reflectiveAccessorOptimizer.compileGetChain();
            AccessorNode rootNode = reflectiveAccessorOptimizer.getRootNode();
            this.val = reflectiveAccessorOptimizer.getResultOptPass();
            return rootNode;
        }
        Class D = m.D(variableResolverFactory, new String(m.K0(cArr, 0, org.mvel2.util.b.a('(', this.start, this.length, cArr))), this.pCtx);
        ExecutableStatement[] executableStatementArr = new ExecutableStatement[w02.size()];
        for (int i12 = 0; i12 < w02.size(); i12++) {
            executableStatementArr[i12] = (ExecutableStatement) m.J0((char[]) w02.get(i12), this.pCtx);
        }
        int size = w02.size();
        Object[] objArr = new Object[size];
        for (int i13 = 0; i13 < w02.size(); i13++) {
            objArr[i13] = executableStatementArr[i13].getValue(obj, variableResolverFactory);
        }
        Constructor N = m.N(objArr, D, this.pCtx.isStrongTyping());
        if (N == null) {
            StringBuilder sb2 = new StringBuilder();
            while (i11 < size) {
                sb2.append(objArr[i11].getClass().getName());
                i11++;
                if (i11 < size) {
                    sb2.append(", ");
                }
            }
            throw new CompileException("unable to find constructor: " + D.getName() + "(" + sb2.toString() + ")", this.expr, this.start);
        }
        while (i11 < size) {
            objArr[i11] = org.mvel2.b.b(objArr[i11], t.b(N.getParameterTypes(), i11, N.isVarArgs()));
            i11++;
        }
        Object[] a11 = t.a(N.getParameterTypes(), objArr, N.isVarArgs());
        ConstructorAccessor constructorAccessor2 = new ConstructorAccessor(N, executableStatementArr);
        if (g11.length <= 1) {
            return constructorAccessor2;
        }
        ReflectiveAccessorOptimizer reflectiveAccessorOptimizer2 = new ReflectiveAccessorOptimizer(this.pCtx, g11[1].toCharArray(), 0, g11[1].length(), N.newInstance(a11), obj, variableResolverFactory);
        reflectiveAccessorOptimizer2.ingressType = N.getDeclaringClass();
        reflectiveAccessorOptimizer2.setRootNode(constructorAccessor2);
        reflectiveAccessorOptimizer2.compileGetChain();
        AccessorNode rootNode2 = reflectiveAccessorOptimizer2.getRootNode();
        this.val = reflectiveAccessorOptimizer2.getResultOptPass();
        return rootNode2;
    }

    private org.mvel2.compiler.a compileGetChain() {
        Object obj = this.ctx;
        this.cursor = this.start;
        try {
            if (org.mvel2.d.f72091h) {
                while (this.cursor < this.end) {
                    int nextSubToken = nextSubToken();
                    if (nextSubToken == 0) {
                        obj = getBeanPropertyAO(obj, capture());
                    } else if (nextSubToken == 1) {
                        obj = getMethod(obj, capture());
                    } else if (nextSubToken == 2) {
                        obj = getCollectionPropertyAO(obj, capture());
                    } else if (nextSubToken == 3) {
                        obj = getWithProperty(obj);
                    }
                    this.first = false;
                    if (obj != null) {
                        this.returnType = obj.getClass();
                    }
                    int i11 = this.cursor;
                    if (i11 < this.end) {
                        if (this.nullSafe) {
                            char[] cArr = this.expr;
                            int i12 = cArr[i11] == '.' ? 1 : 0;
                            addAccessorNode(new NullSafe(cArr, i11 + i12, (this.length - i11) - i12, this.pCtx));
                            if (obj == null) {
                                break;
                            }
                        }
                        if (obj == null) {
                            throw new NullPointerException();
                        }
                    }
                    this.staticAccess = false;
                }
            } else {
                while (this.cursor < this.end) {
                    int nextSubToken2 = nextSubToken();
                    if (nextSubToken2 == 0) {
                        obj = getBeanProperty(obj, capture());
                    } else if (nextSubToken2 == 1) {
                        obj = getMethod(obj, capture());
                    } else if (nextSubToken2 == 2) {
                        obj = getCollectionProperty(obj, capture());
                    } else if (nextSubToken2 == 3) {
                        obj = getWithProperty(obj);
                    }
                    this.first = false;
                    if (obj != null) {
                        this.returnType = obj.getClass();
                    }
                    int i13 = this.cursor;
                    int i14 = this.end;
                    if (i13 < i14) {
                        if (this.nullSafe) {
                            char[] cArr2 = this.expr;
                            int i15 = cArr2[i13] == '.' ? 1 : 0;
                            addAccessorNode(new NullSafe(cArr2, i13 + i15, (i14 - i13) - i15, this.pCtx));
                            if (obj == null) {
                                break;
                            }
                        }
                        if (obj == null) {
                            throw new NullPointerException();
                        }
                    }
                    this.staticAccess = false;
                }
            }
            this.val = obj;
            return this.rootNode;
        } catch (IllegalAccessException e11) {
            throw new PropertyAccessException(new String(this.expr, this.start, this.length) + ": " + e11.getMessage(), this.expr, this.f72083st, e11, this.pCtx);
        } catch (IndexOutOfBoundsException e12) {
            throw new PropertyAccessException(new String(this.expr, this.start, this.length) + ": array index out of bounds.", this.expr, this.f72083st, e12, this.pCtx);
        } catch (NullPointerException e13) {
            throw new PropertyAccessException("null pointer: " + new String(this.expr, this.start, this.length), this.expr, this.f72083st, e13, this.pCtx);
        } catch (InvocationTargetException e14) {
            if (org.mvel2.d.f72089f) {
                if (e14.getTargetException() instanceof RuntimeException) {
                    throw ((RuntimeException) e14.getTargetException());
                }
                throw new RuntimeException(e14);
            }
            throw new PropertyAccessException(new String(this.expr, this.start, this.length) + ": " + e14.getTargetException().getMessage(), this.expr, this.f72083st, e14, this.pCtx);
        } catch (CompileException e15) {
            throw e15;
        } catch (Exception e16) {
            LOG.log(Level.WARNING, "", (Throwable) e16);
            throw new CompileException(e16.getMessage(), this.expr, this.f72083st, e16);
        }
    }

    private Object getBeanProperty(Object obj, String str) throws Exception {
        Class<?> cls;
        boolean z10;
        Object obj2;
        Object obj3;
        ParserContext parserContext = this.pCtx;
        if ((parserContext == null ? this.currType : parserContext.getVarOrInputTypeOrNull(str)) == Object.class && !this.pCtx.isStrongTyping()) {
            this.currType = null;
        }
        if (this.first) {
            if ("this".equals(str)) {
                addAccessorNode(new ThisValueAccessor());
                return this.thisRef;
            }
            VariableResolverFactory variableResolverFactory = this.variableFactory;
            if (variableResolverFactory != null && variableResolverFactory.isResolveable(str)) {
                if (!this.variableFactory.isIndexedFactory() || !this.variableFactory.isTarget(str)) {
                    addAccessorNode(new VariableAccessor(str));
                    return this.variableFactory.getVariableResolver(str).getValue();
                }
                int variableIndexOf = this.variableFactory.variableIndexOf(str);
                addAccessorNode(new IndexedVariableAccessor(variableIndexOf));
                if (this.variableFactory.getIndexedVariableResolver(variableIndexOf) == null) {
                    VariableResolverFactory variableResolverFactory2 = this.variableFactory;
                    variableResolverFactory2.setIndexedVariableResolver(variableIndexOf, variableResolverFactory2.getVariableResolver(str));
                }
                return this.variableFactory.getIndexedVariableResolver(variableIndexOf).getValue();
            }
        }
        boolean z11 = obj instanceof Class;
        if (!z11) {
            cls = obj != null ? obj.getClass() : this.currType;
            z10 = false;
        } else {
            if (org.mvel2.d.f72093j && "class".equals(str)) {
                return obj;
            }
            cls = (Class) obj;
            z10 = true;
        }
        if (k10.d.f(cls)) {
            k10.d.c(cls);
            PropertyHandlerAccessor propertyHandlerAccessor = new PropertyHandlerAccessor(str, cls, null);
            addAccessorNode(propertyHandlerAccessor);
            return propertyHandlerAccessor.getValue(obj, this.thisRef, this.variableFactory);
        }
        Member b11 = cls != null ? n.b(cls, str) : null;
        if (b11 != null && z10 && (b11.getModifiers() & 8) == 0) {
            b11 = null;
        }
        if (b11 instanceof Method) {
            if (obj != null) {
                try {
                    obj3 = ((Method) b11).invoke(obj, EMPTYARG);
                } catch (IllegalAccessException unused) {
                    Method method = (Method) b11;
                    Method z12 = m.z(method);
                    if (z12 == null) {
                        throw new PropertyAccessException("could not access field: " + cls.getName() + "." + str, this.expr, this.start, this.pCtx);
                    }
                    Object invoke = z12.invoke(obj, EMPTYARG);
                    if (k10.d.e()) {
                        k10.d.a();
                        addAccessorNode(new GetterAccessorNH(method, null));
                        if (invoke == null) {
                            k10.d.a();
                            b11.getName();
                            throw null;
                        }
                    } else {
                        addAccessorNode(new GetterAccessor(z12));
                    }
                    obj3 = invoke;
                } catch (IllegalArgumentException e11) {
                    if (b11.getDeclaringClass().equals(obj)) {
                        try {
                            throw new CompileException("name collision between innerclass: " + Class.forName(b11.getDeclaringClass().getName() + "$" + str).getCanonicalName() + "; and bean accessor: " + str + " (" + b11.toString() + ")", this.expr, this.tkStart);
                        } catch (ClassNotFoundException unused2) {
                            throw e11;
                        }
                    }
                    throw e11;
                }
            } else {
                obj3 = null;
            }
            if (k10.d.e()) {
                k10.d.b();
                addAccessorNode(new GetterAccessorNH((Method) b11, null));
                if (obj3 == null) {
                    k10.d.b();
                    b11.getName();
                    throw null;
                }
            } else {
                addAccessorNode(new GetterAccessor((Method) b11));
            }
            this.currType = p.i(((Method) b11).getReturnType());
            return obj3;
        }
        if (b11 != null) {
            Field field = (Field) b11;
            if ((field.getModifiers() & 8) != 0) {
                obj2 = field.get(null);
                if (k10.d.e()) {
                    k10.d.a();
                    addAccessorNode(new StaticVarAccessorNH(field, null));
                    if (obj2 == null) {
                        k10.d.a();
                        b11.getName();
                        throw null;
                    }
                } else {
                    addAccessorNode(new StaticVarAccessor(field));
                }
            } else {
                obj2 = obj != null ? field.get(obj) : null;
                if (k10.d.e()) {
                    k10.d.a();
                    addAccessorNode(new FieldAccessorNH(field, null));
                    if (obj2 == null) {
                        k10.d.a();
                        b11.getName();
                        throw null;
                    }
                } else {
                    addAccessorNode(new FieldAccessor(field));
                }
            }
            this.currType = p.i(field.getType());
            return obj2;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (map.containsKey(str) || this.nullSafe) {
                addAccessorNode(new MapAccessor(str));
                return map.get(str);
            }
        }
        if (obj != null && "length".equals(str) && obj.getClass().isArray()) {
            addAccessorNode(new ArrayLength());
            return Integer.valueOf(Array.getLength(obj));
        }
        if (AbstractParser.LITERALS.containsKey(str)) {
            Object obj4 = AbstractParser.LITERALS.get(str);
            addAccessorNode(new StaticReferenceAccessor(obj4));
            return obj4;
        }
        Object tryStaticAccess = tryStaticAccess();
        this.staticAccess = true;
        if (tryStaticAccess != null) {
            if (tryStaticAccess instanceof Class) {
                addAccessorNode(new StaticReferenceAccessor(tryStaticAccess));
                return tryStaticAccess;
            }
            if (!(tryStaticAccess instanceof Field)) {
                addAccessorNode(new StaticReferenceAccessor(tryStaticAccess));
                return tryStaticAccess;
            }
            Field field2 = (Field) tryStaticAccess;
            addAccessorNode(new StaticVarAccessor(field2));
            return field2.get(null);
        }
        if (z11) {
            Class cls2 = (Class) obj;
            for (Method method2 : cls2.getMethods()) {
                if (str.equals(method2.getName())) {
                    ParserContext parserContext2 = this.pCtx;
                    if (parserContext2 == null || parserContext2.getParserConfiguration() == null ? !org.mvel2.d.f72090g : !this.pCtx.getParserConfiguration().isAllowNakedMethCall()) {
                        addAccessorNode(new StaticReferenceAccessor(method2));
                        return method2;
                    }
                    Object invoke2 = method2.invoke(null, m.f72185a);
                    if (k10.d.d()) {
                        k10.d.a();
                        addAccessorNode(new MethodAccessorNH(method2, new ExecutableStatement[0], null));
                        if (invoke2 == null) {
                            k10.d.a();
                            method2.getName();
                            throw null;
                        }
                    } else {
                        addAccessorNode(new MethodAccessor(method2, new ExecutableStatement[0]));
                    }
                    return invoke2;
                }
            }
            try {
                Class D = m.D(this.variableFactory, cls2.getName() + "$" + str, this.pCtx);
                addAccessorNode(new StaticReferenceAccessor(D));
                return D;
            } catch (ClassNotFoundException unused3) {
            }
        } else {
            ParserContext parserContext3 = this.pCtx;
            if (parserContext3 == null || parserContext3.getParserConfiguration() == null ? org.mvel2.d.f72090g : this.pCtx.getParserConfiguration().isAllowNakedMethCall()) {
                return getMethod(obj, str);
            }
        }
        if (obj == null) {
            throw new PropertyAccessException("unresolvable property or identifier: " + str, this.expr, this.start, this.pCtx);
        }
        throw new PropertyAccessException("could not access: " + str + "; in class: " + obj.getClass().getName(), this.expr, this.start, this.pCtx);
    }

    private Object getBeanPropertyAO(Object obj, String str) throws Exception {
        if (k10.a.a()) {
            k10.a.c(obj, str, this.variableFactory);
            addAccessorNode(new Notify(str));
        }
        return (obj == null || !k10.d.f(obj.getClass())) ? getBeanProperty(obj, str) : propHandler(str, obj, obj.getClass());
    }

    private Object getCollectionProperty(Object obj, String str) throws Exception {
        Integer num;
        boolean z10;
        ExecutableStatement executableStatement;
        Object value;
        if (str.length() > 0) {
            obj = getBeanProperty(obj, str);
        }
        this.currType = null;
        if (obj == null) {
            return null;
        }
        int i11 = this.cursor + 1;
        this.cursor = i11;
        skipWhitespace();
        if (this.cursor == this.end) {
            throw new CompileException("unterminated '['", this.expr, this.start);
        }
        if (scanTo(']')) {
            throw new CompileException("unterminated '['", this.expr, this.start);
        }
        String str2 = new String(this.expr, i11, this.cursor - i11);
        try {
            num = Integer.valueOf(Integer.parseInt(str2));
            z10 = false;
        } catch (Exception unused) {
            num = null;
            z10 = true;
        }
        if (z10) {
            try {
                executableStatement = (ExecutableStatement) m.J0(str2.toCharArray(), this.pCtx);
                Object obj2 = this.thisRef;
                value = executableStatement.getValue(obj2, obj2, this.variableFactory);
            } catch (CompileException e11) {
                e11.setExpr(this.expr);
                e11.setCursor(i11);
                throw e11;
            }
        } else {
            value = num;
            executableStatement = null;
        }
        this.cursor++;
        if (obj instanceof Map) {
            if (z10) {
                addAccessorNode(new MapAccessorNest(executableStatement, (Class) null));
            } else {
                addAccessorNode(new MapAccessor(Integer.valueOf(Integer.parseInt(str2))));
            }
            return ((Map) obj).get(value);
        }
        if (obj instanceof List) {
            if (z10) {
                addAccessorNode(new ListAccessorNest(executableStatement, (Class) null));
            } else {
                addAccessorNode(new ListAccessor(Integer.parseInt(str2)));
            }
            return ((List) obj).get(((Integer) value).intValue());
        }
        if (obj.getClass().isArray()) {
            if (z10) {
                addAccessorNode(new ArrayAccessorNest(executableStatement));
            } else {
                addAccessorNode(new ArrayAccessor(Integer.parseInt(str2)));
            }
            return Array.get(obj, ((Integer) value).intValue());
        }
        if (obj instanceof CharSequence) {
            if (z10) {
                addAccessorNode(new IndexedCharSeqAccessorNest(executableStatement));
            } else {
                addAccessorNode(new IndexedCharSeqAccessor(Integer.parseInt(str2)));
            }
            return Character.valueOf(((CharSequence) obj).charAt(((Integer) value).intValue()));
        }
        if (obj instanceof Class) {
            TypeDescriptor typeDescriptor = new TypeDescriptor(this.expr, this.start, this.length, 0);
            if (typeDescriptor.isArray()) {
                Class classReference = TypeDescriptor.getClassReference((Class) obj, typeDescriptor, this.variableFactory, this.pCtx);
                this.rootNode = new StaticReferenceAccessor(classReference);
                return classReference;
            }
        }
        throw new CompileException("illegal use of []: unknown type: " + obj.getClass().getName(), this.expr, this.start);
    }

    private Object getCollectionPropertyAO(Object obj, String str) throws Exception {
        Integer num;
        boolean z10;
        Object obj2;
        ExecutableStatement executableStatement;
        if (str.length() > 0) {
            obj = getBeanPropertyAO(obj, str);
        }
        this.currType = null;
        if (obj == null) {
            return null;
        }
        int i11 = this.cursor + 1;
        this.cursor = i11;
        skipWhitespace();
        if (this.cursor == this.end) {
            throw new CompileException("unterminated '['", this.expr, this.start);
        }
        if (scanTo(']')) {
            throw new CompileException("unterminated '['", this.expr, this.start);
        }
        String str2 = new String(this.expr, i11, this.cursor - i11);
        try {
            num = Integer.valueOf(Integer.parseInt(str2));
            z10 = false;
        } catch (Exception unused) {
            num = null;
            z10 = true;
        }
        if (z10) {
            executableStatement = (ExecutableStatement) m.J0(str2.toCharArray(), this.pCtx);
            Object obj3 = this.thisRef;
            obj2 = executableStatement.getValue(obj3, obj3, this.variableFactory);
        } else {
            obj2 = num;
            executableStatement = null;
        }
        this.cursor++;
        if (obj instanceof Map) {
            if (k10.d.f(Map.class)) {
                return propHandler(str2, obj, Map.class);
            }
            if (z10) {
                addAccessorNode(new MapAccessorNest(executableStatement, (Class) null));
            } else {
                addAccessorNode(new MapAccessor(Integer.valueOf(Integer.parseInt(str2))));
            }
            return ((Map) obj).get(obj2);
        }
        if (obj instanceof List) {
            if (k10.d.f(List.class)) {
                return propHandler(str2, obj, List.class);
            }
            if (z10) {
                addAccessorNode(new ListAccessorNest(executableStatement, (Class) null));
            } else {
                addAccessorNode(new ListAccessor(Integer.parseInt(str2)));
            }
            return ((List) obj).get(((Integer) obj2).intValue());
        }
        if (obj.getClass().isArray()) {
            if (k10.d.f(Array.class)) {
                return propHandler(str2, obj, Array.class);
            }
            if (z10) {
                addAccessorNode(new ArrayAccessorNest(executableStatement));
            } else {
                addAccessorNode(new ArrayAccessor(Integer.parseInt(str2)));
            }
            return Array.get(obj, ((Integer) obj2).intValue());
        }
        if (obj instanceof CharSequence) {
            if (k10.d.f(CharSequence.class)) {
                return propHandler(str2, obj, CharSequence.class);
            }
            if (z10) {
                addAccessorNode(new IndexedCharSeqAccessorNest(executableStatement));
            } else {
                addAccessorNode(new IndexedCharSeqAccessor(Integer.parseInt(str2)));
            }
            return Character.valueOf(((CharSequence) obj).charAt(((Integer) obj2).intValue()));
        }
        char[] cArr = this.expr;
        int i12 = this.start;
        TypeDescriptor typeDescriptor = new TypeDescriptor(cArr, i12, this.end - i12, 0);
        if (typeDescriptor.isArray()) {
            Class classReference = TypeDescriptor.getClassReference((Class) obj, typeDescriptor, this.variableFactory, this.pCtx);
            this.rootNode = new StaticReferenceAccessor(classReference);
            return classReference;
        }
        throw new CompileException("illegal use of []: unknown type: " + obj.getClass().getName(), this.expr, this.f72083st);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.Object getMethod(java.lang.Object r14, java.lang.String r15) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 241
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mvel2.optimizers.impl.refl.ReflectiveAccessorOptimizer.getMethod(java.lang.Object, java.lang.String):java.lang.Object");
    }

    private Object getMethod(Object obj, String str, Object[] objArr, Class[] clsArr, ExecutableStatement[] executableStatementArr) throws Exception {
        boolean z10;
        VariableResolverFactory variableResolverFactory;
        Class<?> cls = obj;
        String str2 = str;
        int i11 = 0;
        if (this.first && (variableResolverFactory = this.variableFactory) != null && variableResolverFactory.isResolveable(str2)) {
            Object value = this.variableFactory.getVariableResolver(str2).getValue();
            if (value instanceof Method) {
                Method method = (Method) value;
                cls = method.getDeclaringClass();
                str2 = method.getName();
            } else {
                if (!(value instanceof MethodStub)) {
                    if (value instanceof org.mvel2.ast.b) {
                        org.mvel2.ast.b bVar = (org.mvel2.ast.b) value;
                        if (str2.equals(bVar.b().getName())) {
                            addAccessorNode(new FunctionAccessor(bVar, executableStatementArr));
                        } else {
                            getBeanProperty(obj, str);
                            addAccessorNode(new DynamicFunctionAccessor(executableStatementArr));
                        }
                        return bVar.a(cls, this.thisRef, this.variableFactory, objArr);
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("attempt to optimize a method call for a reference that does not point to a method: ");
                    sb2.append(str2);
                    sb2.append(" (reference is type: ");
                    sb2.append(cls != null ? obj.getClass().getName() : null);
                    sb2.append(")");
                    throw new OptimizationFailure(sb2.toString());
                }
                MethodStub methodStub = (MethodStub) value;
                cls = methodStub.getClassReference();
                str2 = methodStub.getMethodName();
            }
            this.first = false;
        }
        if (cls == null && this.currType == null) {
            throw new PropertyAccessException("null pointer or function not found: " + str2, this.expr, this.start, this.pCtx);
        }
        Class<?> cls2 = this.currType;
        if (cls2 != null) {
            z10 = false;
        } else {
            boolean z11 = cls instanceof Class;
            z10 = z11;
            cls2 = z11 ? cls : cls.getClass();
        }
        this.currType = null;
        Method K = m.K(clsArr, str2, cls2, cls2.getMethods(), false, z10);
        Class<?>[] parameterTypes = K != null ? K.getParameterTypes() : null;
        if (K == null && z10) {
            K = m.J(clsArr, str2, cls2, Class.class.getMethods(), false);
            if (K != null) {
                parameterTypes = K.getParameterTypes();
            }
        }
        Class<?>[] clsArr2 = parameterTypes;
        if (K == null && cls != null && cls2 != cls.getClass() && !(cls instanceof Class)) {
            cls2 = cls.getClass();
            K = m.K(clsArr, str2, cls2, cls2.getMethods(), false, z10);
            if (K != null) {
                clsArr2 = K.getParameterTypes();
            }
        }
        if (K == null) {
            s sVar = new s();
            if ("size".equals(str2) && objArr.length == 0 && cls2.isArray()) {
                addAccessorNode(new ArrayLength());
                return Integer.valueOf(Array.getLength(cls));
            }
            while (i11 < objArr.length) {
                Object obj2 = objArr[i11];
                sVar.d(obj2 != null ? obj2.getClass().getName() : null);
                if (i11 < objArr.length - 1) {
                    sVar.d(", ");
                }
                i11++;
            }
            throw new PropertyAccessException("unable to resolve method: " + cls2.getName() + "." + str2 + "(" + sVar.toString() + ") [arglength=" + objArr.length + "]", this.expr, this.f72083st, this.pCtx);
        }
        if (executableStatementArr != null) {
            while (i11 < executableStatementArr.length) {
                ExecutableStatement executableStatement = executableStatementArr[i11];
                if (executableStatement.getKnownIngressType() == null) {
                    executableStatement.setKnownIngressType(t.b(clsArr2, i11, K.isVarArgs()));
                    executableStatement.computeTypeConversionRule();
                }
                if (!executableStatement.isConvertableIngressEgress()) {
                    objArr[i11] = org.mvel2.b.b(objArr[i11], t.b(clsArr2, i11, K.isVarArgs()));
                }
                i11++;
            }
        } else {
            while (i11 < objArr.length) {
                objArr[i11] = org.mvel2.b.b(objArr[i11], t.b(clsArr2, i11, K.isVarArgs()));
                i11++;
            }
        }
        Method U = m.U(cls2, K);
        Object invoke = cls != null ? U.invoke(cls, t.a(clsArr2, objArr, K.isVarArgs())) : null;
        if (k10.d.d()) {
            k10.d.a();
            addAccessorNode(new MethodAccessorNH(U, executableStatementArr, null));
            if (invoke == null) {
                k10.d.a();
                K.getName();
                throw null;
            }
        } else {
            addAccessorNode(new MethodAccessor(U, executableStatementArr));
        }
        this.currType = p.i(U.getReturnType());
        return invoke;
    }

    private AccessorNode getRootNode() {
        return this.rootNode;
    }

    private Object getWithProperty(Object obj) {
        this.currType = null;
        int i11 = this.start;
        int i12 = this.cursor;
        String trim = i11 != i12 ? new String(this.expr, i11, i12 - 1).trim() : null;
        int i13 = this.cursor;
        int i14 = i13 + 1;
        int e11 = m.e(this.expr, i13, this.end, '{', this.pCtx);
        ParserContext parserContext = this.pCtx;
        char[] cArr = this.expr;
        this.cursor = e11 + 1;
        WithAccessor withAccessor = new WithAccessor(parserContext, trim, cArr, i14, e11 - i14, this.ingressType);
        addAccessorNode(withAccessor);
        return withAccessor.getValue(obj, this.thisRef, this.variableFactory);
    }

    private Object propHandler(String str, Object obj, Class cls) {
        k10.d.c(cls);
        addAccessorNode(new PropertyHandlerAccessor(str, cls, null));
        throw null;
    }

    private void setRootNode(AccessorNode accessorNode) {
        this.currNode = accessorNode;
        this.rootNode = accessorNode;
    }

    @Override // org.mvel2.optimizers.a
    public Class getEgressType() {
        return this.returnType;
    }

    @Override // org.mvel2.optimizers.a
    public Object getResultOptPass() {
        return this.val;
    }

    public Object getValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) throws Exception {
        return this.rootNode.getValue(obj, obj2, variableResolverFactory);
    }

    @Override // org.mvel2.optimizers.a
    public void init() {
    }

    @Override // org.mvel2.optimizers.a
    public boolean isLiteralOnly() {
        return false;
    }

    @Override // org.mvel2.optimizers.a
    public org.mvel2.compiler.a optimizeAccessor(ParserContext parserContext, char[] cArr, int i11, int i12, Object obj, Object obj2, VariableResolverFactory variableResolverFactory, boolean z10, Class cls) {
        this.currNode = null;
        this.rootNode = null;
        this.expr = cArr;
        this.start = i11;
        int i13 = i12 + i11;
        this.end = i13;
        this.length = i13 - i11;
        this.first = true;
        this.ctx = obj;
        this.thisRef = obj2;
        this.variableFactory = variableResolverFactory;
        this.ingressType = cls;
        this.pCtx = parserContext;
        return compileGetChain();
    }

    @Override // org.mvel2.optimizers.a
    public org.mvel2.compiler.a optimizeCollection(ParserContext parserContext, Object obj, Class cls, char[] cArr, int i11, int i12, Object obj2, Object obj3, VariableResolverFactory variableResolverFactory) {
        this.cursor = i11;
        this.start = i11;
        this.length = i11 + i12;
        this.returnType = cls;
        this.ctx = obj2;
        this.variableFactory = variableResolverFactory;
        this.pCtx = parserContext;
        org.mvel2.compiler.a _getAccessor = _getAccessor(obj, cls);
        return (cArr == null || this.length <= i11) ? _getAccessor : new org.mvel2.optimizers.impl.refl.nodes.a(parserContext, _getAccessor, cArr, this.cursor, i12);
    }

    @Override // org.mvel2.optimizers.a
    public org.mvel2.compiler.a optimizeObjectCreation(ParserContext parserContext, char[] cArr, int i11, int i12, Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        this.length = i12 + i11;
        this.start = i11;
        this.cursor = i11;
        this.pCtx = parserContext;
        try {
            return compileConstructor(cArr, obj, variableResolverFactory);
        } catch (ClassNotFoundException e11) {
            throw new CompileException("could not resolve class: " + e11.getMessage(), cArr, this.start, e11);
        } catch (CompileException e12) {
            throw f.a(e12, cArr, this.start);
        } catch (Exception e13) {
            throw new CompileException("could not create constructor: " + e13.getMessage(), cArr, this.start, e13);
        }
    }

    @Override // org.mvel2.optimizers.a
    public org.mvel2.compiler.a optimizeSetAccessor(ParserContext parserContext, char[] cArr, int i11, int i12, Object obj, Object obj2, VariableResolverFactory variableResolverFactory, boolean z10, Object obj3, Class cls) {
        char[] cArr2;
        Class cls2 = null;
        this.currNode = null;
        this.rootNode = null;
        this.expr = cArr;
        this.start = i11;
        this.first = true;
        this.length = i11 + i12;
        this.ctx = obj;
        this.thisRef = obj2;
        this.variableFactory = variableResolverFactory;
        this.ingressType = cls;
        int findLastUnion = findLastUnion();
        this.pCtx = parserContext;
        PropertyVerifier propertyVerifier = new PropertyVerifier(cArr, parserContext);
        if (findLastUnion != -1) {
            int i13 = findLastUnion + 1;
            cArr2 = m.K0(cArr, 0, findLastUnion);
            cArr = m.K0(cArr, i13, cArr.length - i13);
        } else {
            cArr2 = null;
        }
        if (cArr2 != null) {
            this.expr = cArr2;
            int length = cArr2.length;
            this.end = length;
            this.length = length;
            compileGetChain();
            obj = this.val;
        }
        if (obj == null) {
            throw new PropertyAccessException("could not access property: " + new String(cArr, this.start, Math.min(this.length, cArr.length)) + "; parent is null: " + new String(this.expr), this.expr, this.start, parserContext);
        }
        try {
            this.expr = cArr;
            int length2 = cArr.length;
            this.end = length2;
            this.length = length2;
            this.cursor = 0;
            skipWhitespace();
            if (this.collection) {
                int i14 = this.cursor;
                if (i14 == this.end) {
                    throw new PropertyAccessException("unterminated '['", this.expr, this.start, parserContext);
                }
                if (scanTo(']')) {
                    throw new PropertyAccessException("unterminated '['", this.expr, this.start, parserContext);
                }
                String str = new String(cArr, i14, this.cursor - i14);
                if (obj instanceof Map) {
                    if (org.mvel2.d.f72091h && k10.d.f(Map.class)) {
                        propHandlerSet(str, obj, Map.class, obj3);
                    } else {
                        Map map = (Map) obj;
                        Object n11 = org.mvel2.d.n(str, obj, this.variableFactory);
                        Class analyze = propertyVerifier.analyze();
                        this.returnType = analyze;
                        map.put(n11, org.mvel2.b.b(obj3, analyze));
                        addAccessorNode(new MapAccessorNest(str, this.returnType));
                    }
                    return this.rootNode;
                }
                if (obj instanceof List) {
                    if (org.mvel2.d.f72091h && k10.d.f(List.class)) {
                        propHandlerSet(str, obj, List.class, obj3);
                    } else {
                        List list = (List) obj;
                        int intValue = ((Integer) org.mvel2.d.o(str, obj, this.variableFactory, Integer.class)).intValue();
                        Class analyze2 = propertyVerifier.analyze();
                        this.returnType = analyze2;
                        list.set(intValue, org.mvel2.b.b(obj3, analyze2));
                        addAccessorNode(new ListAccessorNest(str, this.returnType));
                    }
                    return this.rootNode;
                }
                if (org.mvel2.d.f72091h && k10.d.f(obj.getClass())) {
                    propHandlerSet(str, obj, obj.getClass(), obj3);
                    return this.rootNode;
                }
                if (obj.getClass().isArray()) {
                    if (org.mvel2.d.f72091h && k10.d.f(Array.class)) {
                        propHandlerSet(str, obj, Array.class, obj3);
                    } else {
                        Array.set(obj, ((Integer) org.mvel2.d.o(str, obj, this.variableFactory, Integer.class)).intValue(), org.mvel2.b.b(obj3, m.I(obj.getClass())));
                        addAccessorNode(new ArrayAccessorNest(str));
                    }
                    return this.rootNode;
                }
                throw new PropertyAccessException("cannot bind to collection property: " + new String(cArr) + ": not a recognized collection type: " + obj.getClass(), this.expr, this.f72083st, parserContext);
            }
            if (org.mvel2.d.f72091h && k10.d.f(obj.getClass())) {
                propHandlerSet(new String(cArr), obj, obj.getClass(), obj3);
                return this.rootNode;
            }
            String trim = new String(cArr, 0, this.length).trim();
            if (k10.a.b()) {
                k10.a.d(obj, trim, this.variableFactory, obj3);
                addAccessorNode(new Notify(trim));
            }
            Class<?> cls3 = obj.getClass();
            if (obj3 != null) {
                cls2 = cls;
            }
            Member d11 = n.d(cls3, trim, cls2);
            if (d11 instanceof Field) {
                Field field = (Field) d11;
                if (obj3 == null || field.getType().isAssignableFrom(obj3.getClass())) {
                    if (obj3 == null && field.getType().isPrimitive()) {
                        field.set(obj, n.g(field.getType()));
                        addAccessorNode(new FieldAccessor(field));
                    } else {
                        field.set(obj, obj3);
                        addAccessorNode(new FieldAccessor(field));
                    }
                } else {
                    if (!org.mvel2.b.a(field.getType(), obj3.getClass())) {
                        throw new CompileException("cannot convert type: " + obj3.getClass() + ": to " + field.getType(), this.expr, this.start);
                    }
                    field.set(obj, org.mvel2.b.b(obj3, field.getType()));
                    addAccessorNode(new DynamicFieldAccessor(field));
                }
            } else if (d11 != null) {
                Method method = (Method) d11;
                if (obj3 == null || method.getParameterTypes()[0].isAssignableFrom(obj3.getClass())) {
                    if (obj3 == null && method.getParameterTypes()[0].isPrimitive()) {
                        method.invoke(obj, n.g(method.getParameterTypes()[0]));
                    } else {
                        method.invoke(obj, obj3);
                    }
                } else {
                    if (!org.mvel2.b.a(method.getParameterTypes()[0], obj3.getClass())) {
                        throw new CompileException("cannot convert type: " + obj3.getClass() + ": to " + method.getParameterTypes()[0], this.expr, this.start);
                    }
                    method.invoke(obj, org.mvel2.b.b(obj3, method.getParameterTypes()[0]));
                }
                addAccessorNode(new SetterAccessor(method));
            } else {
                if (!(obj instanceof Map)) {
                    throw new PropertyAccessException("could not access property (" + trim + ") in: " + cls.getName(), this.expr, this.start, parserContext);
                }
                ((Map) obj).put(trim, obj3);
                addAccessorNode(new MapAccessor(trim));
            }
            return this.rootNode;
        } catch (IllegalAccessException e11) {
            throw new PropertyAccessException("could not access property: " + new String(cArr), this.expr, this.f72083st, e11, parserContext);
        } catch (IllegalArgumentException e12) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("error binding property: ");
            sb2.append(new String(cArr));
            sb2.append(" (value <<");
            sb2.append(obj3);
            sb2.append(">>::");
            sb2.append(obj3 == null ? "null" : obj3.getClass().getCanonicalName());
            sb2.append(")");
            throw new PropertyAccessException(sb2.toString(), this.expr, this.f72083st, e12, parserContext);
        } catch (InvocationTargetException e13) {
            throw new PropertyAccessException("could not access property: " + new String(cArr), this.expr, this.f72083st, e13, parserContext);
        }
    }

    public void propHandlerSet(String str, Object obj, Class cls, Object obj2) {
        k10.d.c(cls);
        addAccessorNode(new PropertyHandlerAccessor(str, cls, null));
        throw null;
    }
}
