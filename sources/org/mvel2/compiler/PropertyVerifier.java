package org.mvel2.compiler;

import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.mvel2.CompileException;
import org.mvel2.ParserContext;
import org.mvel2.d;
import org.mvel2.optimizers.AbstractOptimizer;
import org.mvel2.optimizers.impl.refl.nodes.WithAccessor;
import org.mvel2.util.m;
import org.mvel2.util.n;

/* loaded from: classes7.dex */
public class PropertyVerifier extends AbstractOptimizer {
    private static final int COL = 2;
    private static final int DONE = -1;
    private static final int METH = 1;
    private static final int NORM = 0;
    private static final int WITH = 3;
    private boolean classLiteral;
    private Class ctx;
    private boolean deepProperty;
    private boolean first;
    private boolean fqcn;
    private List<String> inputs;
    private boolean methodCall;
    private Map<String, Type> paramTypes;
    private boolean resolvedExternally;

    public PropertyVerifier(String str, ParserContext parserContext) {
        this.inputs = new LinkedList();
        this.first = false;
        this.classLiteral = false;
        this.methodCall = false;
        this.deepProperty = false;
        this.fqcn = false;
        this.ctx = null;
        char[] charArray = str.toCharArray();
        this.expr = charArray;
        int length = charArray.length;
        this.end = length;
        this.length = length;
        this.pCtx = parserContext;
    }

    public PropertyVerifier(String str, ParserContext parserContext, Class cls) {
        this.inputs = new LinkedList();
        this.first = false;
        this.classLiteral = false;
        this.methodCall = false;
        this.deepProperty = false;
        this.fqcn = false;
        this.ctx = null;
        char[] charArray = str.toCharArray();
        this.expr = charArray;
        int length = charArray.length;
        this.length = length;
        this.end = length;
        if (str.length() > 0 && str.charAt(0) == '.') {
            this.start = 1;
            this.f72083st = 1;
            this.cursor = 1;
        }
        this.pCtx = parserContext;
        this.ctx = cls;
    }

    public PropertyVerifier(char[] cArr, int i11, int i12, ParserContext parserContext) {
        this.inputs = new LinkedList();
        this.first = false;
        this.classLiteral = false;
        this.methodCall = false;
        this.deepProperty = false;
        this.fqcn = false;
        this.ctx = null;
        this.expr = cArr;
        this.start = i11;
        this.length = i12;
        this.end = i11 + i12;
        this.pCtx = parserContext;
    }

    public PropertyVerifier(char[] cArr, ParserContext parserContext) {
        this.inputs = new LinkedList();
        this.first = false;
        this.classLiteral = false;
        this.methodCall = false;
        this.deepProperty = false;
        this.fqcn = false;
        this.ctx = null;
        this.expr = cArr;
        int length = cArr.length;
        this.end = length;
        this.length = length;
        this.pCtx = parserContext;
    }

    private Class getBeanProperty(Class cls, String str) {
        char c11;
        if (this.first) {
            if (this.pCtx.hasVarOrInput(str)) {
                if (this.pCtx.isStrictTypeEnforcement()) {
                    recordTypeParmsForProperty(str);
                }
                return this.pCtx.getVarOrInputType(str);
            }
            if (this.pCtx.hasImport(str)) {
                this.resolvedExternally = false;
                return this.pCtx.getImport(str);
            }
            if (!this.pCtx.isStrongTyping()) {
                return Object.class;
            }
            if (this.pCtx.hasVarOrInput("this")) {
                if (this.pCtx.isStrictTypeEnforcement()) {
                    recordTypeParmsForProperty("this");
                }
                cls = this.pCtx.getVarOrInputType("this");
                this.resolvedExternally = false;
            }
        }
        this.f72083st = this.cursor;
        Member b11 = cls != null ? n.b(cls, str) : null;
        if (d.f72093j && "class".equals(str)) {
            return Class.class;
        }
        if (b11 instanceof Field) {
            if (!this.pCtx.isStrictTypeEnforcement()) {
                return ((Field) b11).getType();
            }
            Field field = (Field) b11;
            if (field.getGenericType() != null) {
                if (field.getGenericType() instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) field.getGenericType();
                    this.pCtx.setLastTypeParameters(parameterizedType.getActualTypeArguments());
                    Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                    TypeVariable[] typeParameters = type2Class(parameterizedType.getRawType()).getTypeParameters();
                    if (actualTypeArguments.length > 0 && this.paramTypes == null) {
                        this.paramTypes = new HashMap();
                    }
                    for (int i11 = 0; i11 < actualTypeArguments.length; i11++) {
                        this.paramTypes.put(typeParameters[i11].toString(), actualTypeArguments[i11]);
                    }
                } else if (field.getGenericType() instanceof TypeVariable) {
                    Type remove = this.paramTypes.remove(((TypeVariable) field.getGenericType()).getName());
                    if (remove != null && (remove instanceof Class)) {
                        return (Class) remove;
                    }
                }
            }
            return field.getType();
        }
        if (b11 != null) {
            return getReturnType(cls, (Method) b11);
        }
        ParserContext parserContext = this.pCtx;
        if (parserContext != null && this.first && parserContext.hasImport(str) && this.pCtx.getImport(str) != null) {
            return this.pCtx.getImport(str);
        }
        ParserContext parserContext2 = this.pCtx;
        if (parserContext2 != null && parserContext2.getLastTypeParameters() != null && this.pCtx.getLastTypeParameters().length != 0) {
            if (!Collection.class.isAssignableFrom(cls)) {
                c11 = Map.class.isAssignableFrom(cls) ? (char) 1 : (char) 0;
            }
            Type type = this.pCtx.getLastTypeParameters()[c11];
            this.pCtx.setLastTypeParameters(null);
            return type instanceof ParameterizedType ? Object.class : (Class) type;
        }
        if (this.pCtx != null && "length".equals(str) && cls.isArray()) {
            return Integer.class;
        }
        Object tryStaticAccess = tryStaticAccess();
        if (tryStaticAccess != null) {
            this.fqcn = true;
            this.resolvedExternally = false;
            if (tryStaticAccess instanceof Class) {
                boolean z10 = (d.f72093j && new String(this.expr, this.end - 6, 6).equals(".class")) ? false : true;
                this.classLiteral = z10;
                return z10 ? (Class) tryStaticAccess : Class.class;
            }
            if (tryStaticAccess instanceof Field) {
                try {
                    return ((Field) tryStaticAccess).get(null).getClass();
                } catch (Exception e11) {
                    throw new CompileException("in verifier: ", this.expr, this.start, e11);
                }
            }
            try {
                return ((Method) tryStaticAccess).getReturnType();
            } catch (Exception e12) {
                throw new CompileException("in verifier: ", this.expr, this.start, e12);
            }
        }
        if (cls != null) {
            try {
                return m.D(this.variableFactory, cls.getName() + "$" + str, this.pCtx);
            } catch (ClassNotFoundException unused) {
            }
        }
        ParserContext parserContext3 = this.pCtx;
        if (parserContext3 == null || parserContext3.getParserConfiguration() == null ? d.f72090g : this.pCtx.getParserConfiguration().isAllowNakedMethCall()) {
            Class method = getMethod(cls, str);
            if (method != Object.class) {
                return method;
            }
        }
        if (!this.pCtx.isStrictTypeEnforcement()) {
            return Object.class;
        }
        throw new CompileException("unqualified type in strict mode for: " + str, this.expr, this.tkStart);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r5v25, types: [java.lang.reflect.Type[]] */
    private Class getCollectionProperty(Class cls, String str) {
        Class<Object> cls2 = Object.class;
        if (this.first) {
            if (this.pCtx.hasVarOrInput(str)) {
                cls = m.T(this.pCtx.getVarOrInputType(str));
            } else if (this.pCtx.hasImport(str)) {
                this.resolvedExternally = false;
                cls = m.T(this.pCtx.getImport(str));
            } else {
                cls = cls2;
            }
        }
        Class cls3 = cls2;
        if (this.pCtx.isStrictTypeEnforcement()) {
            if (str.length() != 0) {
                cls = getBeanProperty(cls, str);
            }
            if (Map.class.isAssignableFrom(cls)) {
                Class<Object> cls4 = cls2;
                if (this.pCtx.getLastTypeParameters() != null) {
                    cls4 = cls2;
                    if (this.pCtx.getLastTypeParameters().length != 0) {
                        cls4 = this.pCtx.getLastTypeParameters()[1];
                    }
                }
                cls3 = type2Class(cls4);
            } else if (Collection.class.isAssignableFrom(cls)) {
                cls3 = cls2;
                if (this.pCtx.getLastTypeParameters() != null) {
                    cls3 = cls2;
                    if (this.pCtx.getLastTypeParameters().length != 0) {
                        cls3 = type2Class(this.pCtx.getLastTypeParameters()[0]);
                    }
                }
            } else if (cls.isArray()) {
                cls3 = cls.getComponentType();
            } else {
                if (this.pCtx.isStrongTyping()) {
                    throw new CompileException("unknown collection type: " + cls + "; property=" + str, this.expr, this.start);
                }
                cls3 = cls;
            }
        }
        this.cursor++;
        skipWhitespace();
        int i11 = this.cursor;
        if (scanTo(']')) {
            addFatalError("unterminated [ in token");
        }
        d.a(new String(this.expr, i11, this.cursor - i11), this.pCtx);
        this.cursor++;
        return cls3;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0354  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x037e  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0095  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.Class getMethod(java.lang.Class r21, java.lang.String r22) {
        /*
            Method dump skipped, instructions count: 961
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mvel2.compiler.PropertyVerifier.getMethod(java.lang.Class, java.lang.String):java.lang.Class");
    }

    private Class getReturnType(Class cls, Method method) {
        Class<?> declaringClass = method.getDeclaringClass();
        if (cls == declaringClass) {
            return returnGenericType(method);
        }
        Type genericReturnType = method.getGenericReturnType();
        if (genericReturnType instanceof TypeVariable) {
            String name = ((TypeVariable) genericReturnType).getName();
            Type genericSuperclass = cls.getGenericSuperclass();
            Class<? super Object> superclass = cls.getSuperclass();
            while (superclass != null && superclass != declaringClass) {
                genericSuperclass = superclass.getGenericSuperclass();
                superclass = superclass.getSuperclass();
            }
            if (superclass == null) {
                return returnGenericType(method);
            }
            if (genericSuperclass instanceof ParameterizedType) {
                TypeVariable<Class<? super Object>>[] typeParameters = superclass.getTypeParameters();
                int i11 = 0;
                while (true) {
                    if (i11 >= typeParameters.length) {
                        i11 = -1;
                        break;
                    }
                    if (typeParameters[i11].getName().equals(name)) {
                        break;
                    }
                    i11++;
                }
                if (i11 < 0) {
                    return returnGenericType(method);
                }
                Type type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[i11];
                return type instanceof Class ? (Class) type : returnGenericType(method);
            }
        }
        return returnGenericType(method);
    }

    private Class getWithProperty(Class cls) {
        String trim = new String(this.expr, 0, this.cursor - 1).trim();
        int i11 = this.cursor;
        int i12 = i11 + 1;
        int e11 = m.e(this.expr, i11, this.end, '{', this.pCtx);
        ParserContext parserContext = this.pCtx;
        char[] cArr = this.expr;
        this.cursor = e11 + 1;
        new WithAccessor(parserContext, trim, cArr, i12, e11 - i12, cls);
        return cls;
    }

    private void recordParametricReturnedType(Type type) {
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.pCtx.setLastTypeParameters(parameterizedType.getActualTypeArguments());
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            TypeVariable[] typeParameters = type2Class(parameterizedType.getRawType()).getTypeParameters();
            if (actualTypeArguments.length > 0 && this.paramTypes == null) {
                this.paramTypes = new HashMap();
            }
            for (int i11 = 0; i11 < actualTypeArguments.length; i11++) {
                this.paramTypes.put(typeParameters[i11].toString(), actualTypeArguments[i11]);
            }
        }
    }

    private void recordTypeParmsForProperty(String str) {
        if (this.pCtx.isStrictTypeEnforcement()) {
            ParserContext parserContext = this.pCtx;
            parserContext.setLastTypeParameters(parserContext.getTypeParametersAsArray(str));
        }
    }

    private Class<?> returnGenericType(Method method) {
        Type genericReturnType = method.getGenericReturnType();
        recordParametricReturnedType(genericReturnType);
        String obj = genericReturnType.toString();
        if (genericReturnType instanceof ParameterizedType) {
            this.pCtx.setLastTypeParameters(((ParameterizedType) genericReturnType).getActualTypeArguments());
        }
        Map<String, Type> map = this.paramTypes;
        return (map == null || !map.containsKey(obj)) ? method.getReturnType() : type2Class(this.paramTypes.get(obj));
    }

    private static Class type2Class(Type type) {
        if (!(type instanceof Class)) {
            type = ((ParameterizedType) type).getRawType();
        }
        return (Class) type;
    }

    public Class analyze() {
        this.cursor = this.start;
        this.resolvedExternally = true;
        if (this.ctx == null) {
            this.ctx = Object.class;
            this.first = true;
        }
        while (this.cursor < this.end) {
            this.classLiteral = false;
            int nextSubToken = nextSubToken();
            if (nextSubToken == 0) {
                this.ctx = getBeanProperty(this.ctx, capture());
            } else if (nextSubToken == 1) {
                this.ctx = getMethod(this.ctx, capture());
            } else if (nextSubToken == 2) {
                this.ctx = getCollectionProperty(this.ctx, capture());
            } else if (nextSubToken == 3) {
                this.ctx = getWithProperty(this.ctx);
            }
            if (this.cursor < this.length && !this.first) {
                this.deepProperty = true;
            }
            this.first = false;
        }
        return this.ctx;
    }

    public Class getCtx() {
        return this.ctx;
    }

    public List<String> getInputs() {
        return this.inputs;
    }

    public boolean isClassLiteral() {
        return this.classLiteral;
    }

    public boolean isDeepProperty() {
        return this.deepProperty;
    }

    public boolean isFqcn() {
        return this.fqcn;
    }

    public boolean isInput() {
        return this.resolvedExternally && !this.methodCall;
    }

    public boolean isMethodCall() {
        return this.methodCall;
    }

    public boolean isResolvedExternally() {
        return this.resolvedExternally;
    }

    public void setCtx(Class cls) {
        this.ctx = cls;
    }

    public void setInputs(List<String> list) {
        this.inputs = list;
    }
}
