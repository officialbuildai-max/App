package org.mvel2.util;

import com.cloud.tmc.offline.download.model.TaskResultKt;
import java.io.File;
import java.io.FileWriter;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import org.mvel2.CompileException;
import org.mvel2.OptimizationFailure;
import org.mvel2.ParserContext;
import org.mvel2.ast.ASTNode;
import org.mvel2.compiler.AbstractParser;
import org.mvel2.compiler.BlankLiteral;
import org.mvel2.compiler.CompiledExpression;
import org.mvel2.compiler.ExecutableAccessor;
import org.mvel2.compiler.ExecutableAccessorSafe;
import org.mvel2.compiler.ExecutableLiteral;
import org.mvel2.compiler.ExpressionCompiler;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.integration.impl.ClassImportResolverFactory;

/* loaded from: classes7.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    public static final Object[] f72185a = new Object[0];

    /* renamed from: b, reason: collision with root package name */
    public static final Class[] f72186b = new Class[0];

    /* renamed from: c, reason: collision with root package name */
    private static final Map f72187c = Collections.synchronizedMap(new WeakHashMap(10));

    /* renamed from: d, reason: collision with root package name */
    private static final Map f72188d = Collections.synchronizedMap(new WeakHashMap(1, 1.0f));

    /* renamed from: e, reason: collision with root package name */
    private static final Map f72189e = Collections.synchronizedMap(new WeakHashMap(10));

    /* renamed from: f, reason: collision with root package name */
    private static final HashMap f72190f;

    /* renamed from: g, reason: collision with root package name */
    private static final Map f72191g;

    static {
        HashMap hashMap = new HashMap();
        f72190f = hashMap;
        hashMap.put(BigDecimal.class, 110);
        hashMap.put(BigInteger.class, 111);
        hashMap.put(String.class, 1);
        Class cls = Integer.TYPE;
        hashMap.put(cls, 101);
        hashMap.put(Integer.class, 106);
        Class cls2 = Short.TYPE;
        hashMap.put(cls2, 100);
        hashMap.put(Short.class, 105);
        Class cls3 = Float.TYPE;
        hashMap.put(cls3, 104);
        Integer valueOf = Integer.valueOf(TaskResultKt.ERROR_LOAD_RESPONSE_STR_EMPTY);
        hashMap.put(Float.class, valueOf);
        Class cls4 = Double.TYPE;
        hashMap.put(cls4, 103);
        hashMap.put(Double.class, 109);
        Class cls5 = Long.TYPE;
        hashMap.put(cls5, 102);
        hashMap.put(Long.class, 107);
        Class cls6 = Boolean.TYPE;
        hashMap.put(cls6, 7);
        hashMap.put(Boolean.class, 15);
        Class cls7 = Byte.TYPE;
        hashMap.put(cls7, 9);
        hashMap.put(Byte.class, 113);
        Class cls8 = Character.TYPE;
        hashMap.put(cls8, 8);
        hashMap.put(Character.class, 112);
        hashMap.put(BlankLiteral.class, 200);
        HashMap hashMap2 = new HashMap(30, 0.5f);
        f72191g = hashMap2;
        hashMap2.put(Integer.class, 106);
        hashMap2.put(Double.class, 109);
        hashMap2.put(Boolean.class, 15);
        hashMap2.put(String.class, 1);
        hashMap2.put(Long.class, 107);
        hashMap2.put(Short.class, 105);
        hashMap2.put(Float.class, valueOf);
        hashMap2.put(Byte.class, 113);
        hashMap2.put(Character.class, 112);
        hashMap2.put(BigDecimal.class, 110);
        hashMap2.put(BigInteger.class, 111);
        hashMap2.put(InternalNumber.class, 110);
        hashMap2.put(cls, 101);
        hashMap2.put(cls4, 103);
        hashMap2.put(cls6, 7);
        hashMap2.put(cls5, 102);
        hashMap2.put(cls2, 100);
        hashMap2.put(cls3, 104);
        hashMap2.put(cls7, 9);
        hashMap2.put(cls8, 8);
        hashMap2.put(BlankLiteral.class, 200);
    }

    public static boolean A(char[] cArr, int i11, int i12, char[] cArr2) {
        if (cArr2.length > cArr.length) {
            return false;
        }
        int length = cArr2.length - 1;
        int i13 = (i11 + i12) - 1;
        while (length >= 0) {
            int i14 = i13 - 1;
            int i15 = length - 1;
            if (cArr[i13] != cArr2[length]) {
                return false;
            }
            i13 = i14;
            length = i15;
        }
        return true;
    }

    public static String A0(char c11, int i11) {
        char[] cArr = new char[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            cArr[i12] = c11;
        }
        return new String(cArr);
    }

    public static int B(char[] cArr, int i11, int i12, char c11) {
        int i13 = i12 + i11;
        while (i11 < i13) {
            if (cArr[i11] == c11) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    public static int B0(Object obj) {
        if (obj == null) {
            return 0;
        }
        return a(obj.getClass());
    }

    public static int C(char[] cArr) {
        int i11 = 0;
        for (int length = cArr.length - 1; length >= 0; length--) {
            char c11 = cArr[length];
            if (c11 == ']') {
                i11++;
            }
            if (c11 == '[') {
                i11--;
            }
            if ((i11 == 0 && c11 == '.') || c11 == '[') {
                return length;
            }
        }
        return -1;
    }

    public static int C0(Class cls, Class cls2) {
        Class<?>[] interfaces;
        if (cls.isInterface() && (interfaces = cls2.getInterfaces()) != null) {
            for (Class<?> cls3 : interfaces) {
                if (cls3 == cls) {
                    return 1;
                }
                if (cls.isAssignableFrom(cls3)) {
                    return C0(cls, cls2.getSuperclass());
                }
            }
        }
        return 0;
    }

    public static Class D(VariableResolverFactory variableResolverFactory, String str, ParserContext parserContext) {
        try {
            return AbstractParser.LITERALS.containsKey(str) ? (Class) AbstractParser.LITERALS.get(str) : (variableResolverFactory == null || !variableResolverFactory.isResolveable(str)) ? (parserContext == null || !parserContext.hasImport(str)) ? v(str, parserContext) : parserContext.getImport(str) : (Class) variableResolverFactory.getVariableResolver(str).getValue();
        } catch (ClassNotFoundException e11) {
            throw e11;
        } catch (Exception e12) {
            throw new RuntimeException("class not found: " + str, e12);
        }
    }

    public static float D0(String str, String str2) {
        float length;
        float f11 = 0.0f;
        if (str == null || str2 == null) {
            return (str == null && str2 == null) ? 1.0f : 0.0f;
        }
        char[] charArray = str.toCharArray();
        char[] charArray2 = str2.toCharArray();
        if (charArray.length > charArray2.length) {
            length = charArray.length;
        } else {
            length = charArray2.length;
            charArray2 = charArray;
            charArray = charArray2;
        }
        for (int i11 = 0; i11 < charArray.length && i11 < charArray2.length; i11++) {
            if (charArray[i11] == charArray2[i11]) {
                f11 += 1.0f;
            }
        }
        return f11 / length;
    }

    public static ClassImportResolverFactory E(VariableResolverFactory variableResolverFactory, ParserContext parserContext) {
        if (variableResolverFactory == null) {
            throw new OptimizationFailure("unable to import classes.  no variable resolver factory available.");
        }
        for (VariableResolverFactory variableResolverFactory2 = variableResolverFactory; variableResolverFactory2 != null; variableResolverFactory2 = variableResolverFactory2.getNextFactory()) {
            if (variableResolverFactory2 instanceof ClassImportResolverFactory) {
                return (ClassImportResolverFactory) variableResolverFactory2;
            }
        }
        return (ClassImportResolverFactory) k10.e.a(variableResolverFactory, new ClassImportResolverFactory(null, null, false));
    }

    public static int E0(char[] cArr, int i11) {
        int i12;
        while (i11 != cArr.length) {
            char c11 = cArr[i11];
            if (c11 != '\n' && c11 != '\r') {
                if (c11 != '/' || (i12 = i11 + 1) == cArr.length) {
                    if (!q0(c11)) {
                        break;
                    }
                } else {
                    char c12 = cArr[i12];
                    if (c12 == '*') {
                        int length = cArr.length - 1;
                        cArr[i11] = ' ';
                        i11 = i12;
                        while (i11 != length && (cArr[i11] != '*' || cArr[i11 + 1] != '/')) {
                            cArr[i11] = ' ';
                            i11++;
                        }
                        if (i11 != length) {
                            cArr[i11 + 1] = ' ';
                            cArr[i11] = ' ';
                            i11 += 2;
                        }
                    } else {
                        if (c12 != '/') {
                            break;
                        }
                        cArr[i11] = ' ';
                        i11 = i12;
                        while (i11 != cArr.length && cArr[i11] != '\n') {
                            cArr[i11] = ' ';
                            i11++;
                        }
                        if (i11 != cArr.length) {
                            cArr[i11] = ' ';
                            i11++;
                        }
                    }
                }
            }
            i11++;
        }
        return i11;
    }

    public static Class F(String str, ClassLoader classLoader, ClassNotFoundException classNotFoundException) {
        while (true) {
            int lastIndexOf = str.lastIndexOf(46);
            if (lastIndexOf <= 0) {
                throw classNotFoundException;
            }
            str = str.substring(0, lastIndexOf) + "$" + str.substring(lastIndexOf + 1);
            try {
                return classLoader.loadClass(str);
            } catch (ClassNotFoundException unused) {
            }
        }
    }

    public static char[] F0(char[] cArr, int i11, int i12) {
        if (i11 >= i12) {
            return new char[0];
        }
        int i13 = i12 - i11;
        char[] cArr2 = new char[i13];
        for (int i14 = 0; i14 != i13; i14++) {
            cArr2[i14] = cArr[i14 + i11];
        }
        return cArr2;
    }

    public static int G(char[] cArr, int i11, int i12, char c11) {
        for (int i13 = i12 + i11; i13 >= i11; i13--) {
            if (cArr[i13] == c11) {
                return i13;
            }
        }
        return -1;
    }

    public static Serializable G0(String str, ParserContext parserContext) {
        return b(new ExpressionCompiler(str, parserContext)._compile());
    }

    public static Class H(String str, ClassLoader classLoader) {
        try {
            return classLoader.loadClass(str);
        } catch (ClassNotFoundException e11) {
            return F(str, classLoader, e11);
        }
    }

    public static Serializable H0(char[] cArr) {
        return b(new ExpressionCompiler(cArr)._compile());
    }

    public static Class I(Class cls) {
        while (cls.isArray()) {
            cls = cls.getComponentType();
        }
        return cls;
    }

    public static Serializable I0(char[] cArr, int i11, int i12, ParserContext parserContext) {
        return b(new ExpressionCompiler(cArr, i11, i12, parserContext)._compile());
    }

    public static Method J(Class[] clsArr, String str, Class cls, Method[] methodArr, boolean z10) {
        return K(clsArr, str, cls, methodArr, z10, false);
    }

    public static Serializable J0(char[] cArr, ParserContext parserContext) {
        return b(new ExpressionCompiler(cArr, parserContext)._compile());
    }

    public static Method K(Class[] clsArr, String str, Class cls, Method[] methodArr, boolean z10, boolean z11) {
        int S;
        Method method = null;
        if (methodArr.length == 0) {
            return null;
        }
        int i11 = -1;
        boolean z12 = false;
        while (true) {
            for (Method method2 : methodArr) {
                if ((!z11 || Modifier.isStatic(method2.getModifiers())) && str.equals(method2.getName())) {
                    Class<?>[] parameterTypes = method2.getParameterTypes();
                    if (parameterTypes.length == 0 && clsArr.length == 0) {
                        if (method != null && !e0(method2, method)) {
                        }
                        method = method2;
                    } else {
                        boolean isVarArgs = method2.isVarArgs();
                        if (!Z(clsArr, parameterTypes, isVarArgs) && (S = S(clsArr, z10, parameterTypes, isVarArgs)) != 0) {
                            if (S > i11) {
                                method = method2;
                                i11 = S;
                            } else if (S == i11) {
                                if (e0(method2, method)) {
                                    if (isVarArgs) {
                                    }
                                    method = method2;
                                }
                            }
                        }
                    }
                }
            }
            if (method == null && !z12 && cls.isInterface()) {
                Method[] methods = Object.class.getMethods();
                Method[] methodArr2 = new Method[methodArr.length + methods.length];
                for (int i12 = 0; i12 < methodArr.length; i12++) {
                    methodArr2[i12] = methodArr[i12];
                }
                for (int i13 = 0; i13 < methods.length; i13++) {
                    methodArr2[methodArr.length + i13] = methods[i13];
                }
                z12 = true;
                methodArr = methodArr2;
            }
        }
        return method;
    }

    public static char[] K0(char[] cArr, int i11, int i12) {
        char[] cArr2 = new char[i12];
        for (int i13 = 0; i13 < i12; i13++) {
            cArr2[i13] = cArr[i13 + i11];
        }
        return cArr2;
    }

    public static Method L(Object[] objArr, String str, Class cls, Method[] methodArr, boolean z10) {
        Class[] clsArr = new Class[objArr.length];
        for (int i11 = 0; i11 != objArr.length; i11++) {
            Object obj = objArr[i11];
            clsArr[i11] = obj != null ? obj.getClass() : null;
        }
        return J(clsArr, str, cls, methodArr, z10);
    }

    public static char[] L0(char[] cArr, int i11, int i12) {
        if (i12 <= 0) {
            return new char[0];
        }
        int i13 = i12 + i11;
        while (i13 > 0 && q0(cArr[i13 - 1])) {
            i13--;
        }
        while (q0(cArr[i11]) && i11 < i13) {
            i11++;
        }
        int i14 = i13 - i11;
        return i14 == 0 ? new char[0] : K0(cArr, i11, i14);
    }

    public static Constructor M(Class[] clsArr, Class cls, boolean z10) {
        Constructor constructor = null;
        int i11 = 0;
        for (Constructor constructor2 : P(cls)) {
            boolean isVarArgs = constructor2.isVarArgs();
            Class[] O = O(constructor2);
            if (!Z(clsArr, O, isVarArgs)) {
                if (clsArr.length == 0 && O.length == 0) {
                    return constructor2;
                }
                int S = S(clsArr, z10, O, isVarArgs);
                if (S != 0 && S > i11) {
                    constructor = constructor2;
                    i11 = S;
                }
            }
        }
        return constructor;
    }

    public static int M0(char[] cArr, int i11, int i12) {
        if (i12 > cArr.length) {
            i12 = cArr.length;
        }
        while (i12 != 0 && i12 >= i11 && q0(cArr[i12 - 1])) {
            i12--;
        }
        return i12;
    }

    public static Constructor N(Object[] objArr, Class cls, boolean z10) {
        Class[] clsArr = new Class[objArr.length];
        for (int i11 = 0; i11 != objArr.length; i11++) {
            Object obj = objArr[i11];
            if (obj != null) {
                clsArr[i11] = obj.getClass();
            }
        }
        return M(clsArr, cls, z10);
    }

    public static int N0(char[] cArr, int i11) {
        while (i11 != cArr.length && q0(cArr[i11])) {
            i11++;
        }
        return i11;
    }

    private static Class[] O(Constructor constructor) {
        Class[] clsArr;
        Map map = f72187c;
        WeakReference weakReference = (WeakReference) map.get(constructor);
        if (weakReference != null && (clsArr = (Class[]) weakReference.get()) != null) {
            return clsArr;
        }
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        map.put(constructor, new WeakReference(parameterTypes));
        return parameterTypes;
    }

    public static Class O0(Class cls) {
        return (cls == Integer.class || cls == Integer.TYPE) ? Integer.TYPE : (cls == Integer[].class || cls == int[].class) ? int[].class : (cls == Long.class || cls == Long.TYPE) ? Long.TYPE : (cls == Long[].class || cls == long[].class) ? long[].class : (cls == Character.class || cls == Character.TYPE) ? Character.TYPE : (cls == Character[].class || cls == char[].class) ? char[].class : (cls == Short.class || cls == Short.TYPE) ? Short.TYPE : (cls == Short[].class || cls == short[].class) ? short[].class : (cls == Double.class || cls == Double.TYPE) ? Double.TYPE : (cls == Double[].class || cls == double[].class) ? double[].class : (cls == Float.class || cls == Float.TYPE) ? Float.TYPE : (cls == Float[].class || cls == float[].class) ? float[].class : (cls == Boolean.class || cls == Boolean.TYPE) ? Boolean.TYPE : (cls == Boolean[].class || cls == boolean[].class) ? boolean[].class : (cls == Byte.class || cls == Byte.TYPE) ? Byte.TYPE : (cls == Byte[].class || cls == byte[].class) ? byte[].class : cls;
    }

    public static Constructor[] P(Class cls) {
        Constructor[] constructorArr;
        Map map = f72189e;
        WeakReference weakReference = (WeakReference) map.get(cls);
        if (weakReference != null && (constructorArr = (Constructor[]) weakReference.get()) != null) {
            return constructorArr;
        }
        Constructor<?>[] constructors = cls.getConstructors();
        map.put(cls, new WeakReference(constructors));
        return constructors;
    }

    public static FileWriter Q() {
        return new FileWriter(new File(org.mvel2.d.x()), true);
    }

    public static Method R(String str, Class[] clsArr, Class cls, Class cls2) {
        for (Method method : cls2.getMethods()) {
            if (str.equals(method.getName()) && cls == method.getReturnType()) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == clsArr.length) {
                    for (int i11 = 0; i11 < parameterTypes.length; i11++) {
                        if (parameterTypes[i11] != clsArr[i11]) {
                            break;
                        }
                    }
                    return method;
                }
                continue;
            }
        }
        return null;
    }

    private static int S(Class[] clsArr, boolean z10, Class[] clsArr2, boolean z11) {
        Class cls;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (true) {
            if (i12 == clsArr.length) {
                i11 = i13;
                break;
            }
            Class componentType = (!z11 || i12 < clsArr2.length + (-1)) ? clsArr2[i12] : clsArr2[clsArr2.length - 1].getComponentType();
            Class cls2 = clsArr[i12];
            if (cls2 == null) {
                if (componentType.isPrimitive()) {
                    break;
                }
                i13 += 7;
            } else if (componentType == cls2) {
                i13 += 8;
            } else {
                if ((!componentType.isPrimitive() || f(componentType) != clsArr[i12]) && (!clsArr[i12].isPrimitive() || O0(clsArr[i12]) != componentType)) {
                    if (componentType.isAssignableFrom(clsArr[i12])) {
                        i13 += 6;
                    } else if (l0(clsArr[i12], componentType)) {
                        i13 += 5;
                    } else if (k0(clsArr[i12], componentType)) {
                        i13 += 4;
                    } else if (!f(componentType).isAssignableFrom(f(clsArr[i12])) || Object.class == (cls = clsArr[i12])) {
                        if (z10 || !org.mvel2.b.a(componentType, clsArr[i12])) {
                            if (componentType != Object.class && clsArr[i12] != l.class) {
                                break;
                            }
                        } else if ((componentType.isArray() && clsArr[i12].isArray()) || (componentType == Character.TYPE && clsArr[i12] == String.class)) {
                            i13++;
                        }
                        i13++;
                    } else {
                        i13 += C0(componentType, cls) + 3;
                    }
                }
                i13 += 7;
            }
            i12++;
        }
        return (i11 == 0 && z11 && clsArr2.length + (-1) == clsArr.length) ? i11 + 3 : i11;
    }

    public static Class T(Class cls) {
        return cls.isArray() ? cls.getComponentType() : cls;
    }

    public static Method U(Class cls, Method method) {
        if (Modifier.isStatic(method.getModifiers())) {
            return method;
        }
        Class<?>[] parameterTypes = method.getParameterTypes();
        String name = method.getName();
        Class<?> returnType = method.getReturnType();
        Method method2 = method;
        for (Class cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            for (Class<?> cls3 : cls2.getInterfaces()) {
                Method R = R(name, parameterTypes, returnType, cls3);
                if (R != null) {
                    method2 = R;
                }
            }
        }
        if (method2 != method) {
            return method2;
        }
        while (cls != null) {
            Method R2 = R(name, parameterTypes, returnType, cls);
            if (R2 != null) {
                method2 = R2;
            }
            cls = cls.getSuperclass();
        }
        return method2;
    }

    public static Method V(Method method) {
        return U(method.getDeclaringClass(), method);
    }

    public static int W(char[] cArr, int i11) {
        char c11;
        int i12;
        int i13 = i11 - 1;
        cArr[i13] = 0;
        char c12 = cArr[i11];
        if (c12 == '\"') {
            cArr[i11] = '\"';
            return 1;
        }
        if (c12 == '\'') {
            cArr[i11] = '\'';
            return 1;
        }
        if (c12 == '\\') {
            cArr[i11] = '\\';
            return 1;
        }
        if (c12 == 'b') {
            cArr[i11] = '\b';
            return 1;
        }
        if (c12 == 'f') {
            cArr[i11] = '\f';
            return 1;
        }
        if (c12 == 'n') {
            cArr[i11] = '\n';
            return 1;
        }
        if (c12 == 'r') {
            cArr[i11] = '\r';
            return 1;
        }
        if (c12 == 't') {
            cArr[i11] = '\t';
            return 1;
        }
        if (c12 == 'u') {
            int i14 = i11 + 4;
            if (i14 > cArr.length) {
                throw new CompileException("illegal unicode escape sequence", cArr, i11);
            }
            int i15 = i11;
            while (true) {
                i15++;
                if (i15 - i11 == 5) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("0x");
                    int i16 = i11 + 1;
                    sb2.append(new String(cArr, i16, 4));
                    cArr[i13] = (char) Integer.decode(sb2.toString()).intValue();
                    cArr[i11] = 0;
                    cArr[i16] = 0;
                    cArr[i11 + 2] = 0;
                    cArr[i11 + 3] = 0;
                    cArr[i14] = 0;
                    return 5;
                }
                char c13 = cArr[i15];
                if (c13 <= '/' || c13 >= ':') {
                    if (c13 <= '@' || c13 >= 'G') {
                        break;
                    }
                }
            }
            throw new CompileException("illegal unicode escape sequence", cArr, i15);
        }
        int i17 = i11;
        do {
            c11 = cArr[i17];
            if (c11 < '0' || c11 >= '8') {
                throw new CompileException("illegal escape sequence: " + cArr[i17], cArr, i17);
            }
            if (i17 != i11 && cArr[i11] > '3') {
                cArr[i13] = (char) Integer.decode("0" + new String(cArr, i11, (i17 - i11) + 1)).intValue();
                cArr[i11] = 0;
                cArr[i11 + 1] = 0;
                return 2;
            }
            i12 = i17 - i11;
            if (i12 != 2) {
                i17++;
                if (i17 == cArr.length || c11 < '0') {
                    break;
                }
            } else {
                cArr[i13] = (char) Integer.decode("0" + new String(cArr, i11, i12 + 1)).intValue();
                cArr[i11] = 0;
                cArr[i11 + 1] = 0;
                cArr[i11 + 2] = 0;
                return 3;
            }
        } while (c11 <= '7');
        cArr[i13] = (char) Integer.decode("0" + new String(cArr, i11, i12 + 1)).intValue();
        cArr[i11] = 0;
        return 1;
    }

    public static Object X(char[] cArr, int i11, int i12) {
        if (i12 != 1 && cArr[i11] == '0' && cArr[i11 + 1] != '.') {
            int i13 = (i11 + i12) - 1;
            if (!b0(cArr[i13])) {
                char c11 = cArr[i13];
                if (c11 == 'B') {
                    return new BigDecimal(new String(cArr, i11, i12 - 1));
                }
                if (c11 == 'I') {
                    return new BigInteger(new String(cArr, i11, i12 - 1));
                }
                if (c11 == 'L' || c11 == 'l') {
                    return Long.decode(new String(cArr, i11, i12 - 1));
                }
            }
            return Integer.decode(new String(cArr, i11, i12));
        }
        int i14 = (i11 + i12) - 1;
        if (b0(cArr[i14])) {
            int t02 = t0(cArr, i11, i12);
            if (t02 == 110) {
                return new BigDecimal(cArr, MathContext.DECIMAL128);
            }
            switch (t02) {
                case 101:
                    return Integer.valueOf(Integer.parseInt(new String(cArr, i11, i12)));
                case 102:
                    return Long.valueOf(Long.parseLong(new String(cArr, i11, i12)));
                case 103:
                    return Double.valueOf(Double.parseDouble(new String(cArr, i11, i12)));
                case 104:
                    return Float.valueOf(Float.parseFloat(new String(cArr, i11, i12)));
                default:
                    return new String(cArr, i11, i12);
            }
        }
        char c12 = cArr[i14];
        if (c12 != '.') {
            if (c12 == 'B') {
                return new BigDecimal(new String(cArr, i11, i12 - 1));
            }
            if (c12 != 'D') {
                if (c12 != 'F') {
                    if (c12 == 'I') {
                        return new BigInteger(new String(cArr, i11, i12 - 1));
                    }
                    if (c12 != 'L') {
                        if (c12 != 'd') {
                            if (c12 != 'f') {
                                if (c12 != 'l') {
                                    throw new CompileException("unrecognized numeric literal", cArr, i11);
                                }
                            }
                        }
                    }
                    return Long.valueOf(Long.parseLong(new String(cArr, i11, i12 - 1)));
                }
                return Float.valueOf(Float.parseFloat(new String(cArr, i11, i12 - 1)));
            }
        }
        return Double.valueOf(Double.parseDouble(new String(cArr, i11, i12 - 1)));
    }

    public static String Y(char[] cArr) {
        int i11 = 0;
        int i12 = 0;
        while (i11 < cArr.length) {
            if (cArr[i11] == '\\') {
                i11++;
                i12 += W(cArr, i11);
            }
            i11++;
        }
        if (i12 == 0) {
            return new String(cArr);
        }
        char[] cArr2 = new char[cArr.length - i12];
        int i13 = 0;
        for (char c11 : cArr) {
            if (c11 != 0) {
                cArr2[i13] = c11;
                i13++;
            }
        }
        return new String(cArr2);
    }

    private static boolean Z(Class[] clsArr, Class[] clsArr2, boolean z10) {
        if (!z10 || clsArr2.length - 1 <= clsArr.length) {
            return (z10 || clsArr2.length == clsArr.length) ? false : true;
        }
        return true;
    }

    public static int a(Class cls) {
        Integer num = (Integer) f72191g.get(cls);
        return num == null ? (cls == null || !Collection.class.isAssignableFrom(cls)) ? 0 : 50 : num.intValue();
    }

    public static boolean a0(char[] cArr, int i11, int i12) {
        if (i12 > i11 + 2) {
            int i13 = i12 - 2;
            if (n0(cArr, i11, i13) && cArr[i13] == '[' && cArr[i12 - 1] == ']') {
                return true;
            }
        }
        return false;
    }

    private static Serializable b(CompiledExpression compiledExpression) {
        if (!compiledExpression.isSingleNode()) {
            return compiledExpression;
        }
        ASTNode firstNode = compiledExpression.getFirstNode();
        return (!firstNode.isLiteral() || firstNode.isThisVal()) ? firstNode.canSerializeAccessor() ? new ExecutableAccessorSafe(firstNode, compiledExpression.getKnownEgressType()) : new ExecutableAccessor(firstNode, compiledExpression.getKnownEgressType()) : new ExecutableLiteral(firstNode.getLiteralValue());
    }

    public static boolean b0(int i11) {
        return i11 > 47 && i11 < 58;
    }

    public static int c(char[] cArr, int i11, char c11) {
        return d(cArr, i11, cArr.length, c11);
    }

    public static boolean c0(int i11) {
        return (i11 > 96 && i11 < 123) || (i11 > 64 && i11 < 91) || ((i11 > 47 && i11 < 58) || i11 == 95 || i11 == 36 || Character.isJavaIdentifierPart(i11));
    }

    public static int d(char[] cArr, int i11, int i12, char c11) {
        int i13;
        int i14;
        char c12 = c11 != '(' ? c11 != '[' ? c11 != '{' ? c11 : '}' : ']' : ')';
        if (c11 == c12) {
            i13 = i11 + 1;
            while (i13 < i12) {
                if (cArr[i13] == c11) {
                    return i13;
                }
                i13++;
            }
        } else {
            i13 = i11 + 1;
            int i15 = 1;
            while (i13 < i12) {
                if (i13 < i12 && cArr[i13] == '/') {
                    int i16 = i13 + 1;
                    if (i16 == i12) {
                        return i13;
                    }
                    char c13 = cArr[i16];
                    if (c13 == '/') {
                        i13 = i16;
                        while (i13 < i12 && cArr[i13] != '\n') {
                            i13++;
                        }
                    } else if (c13 == '*') {
                        i13 += 2;
                        while (i13 < i12 && (cArr[i13] != '*' || (i14 = i13 + 1) >= i12 || cArr[i14] != '/')) {
                            i13++;
                        }
                    }
                }
                if (i13 == i12) {
                    return i13;
                }
                char c14 = cArr[i13];
                if (c14 == '\'' || c14 == '\"') {
                    i13 = h(c14, cArr, i13, i12);
                } else if (c14 == c11) {
                    i15++;
                } else if (c14 == c12 && i15 - 1 == 0) {
                    return i13;
                }
                i13++;
            }
        }
        if (c11 == '(') {
            throw new CompileException("unbalanced braces ( ... )", cArr, i13);
        }
        if (c11 == '[') {
            throw new CompileException("unbalanced braces [ ... ]", cArr, i13);
        }
        if (c11 != '{') {
            throw new CompileException("unterminated string literal", cArr, i13);
        }
        throw new CompileException("unbalanced braces { ... }", cArr, i13);
    }

    public static boolean d0(char c11) {
        if (c11 == '(' || c11 == '[') {
            return true;
        }
        return q0(c11);
    }

    public static int e(char[] cArr, int i11, int i12, char c11, ParserContext parserContext) {
        char c12 = c11 != '(' ? c11 != '[' ? c11 != '{' ? c11 : '}' : ']' : ')';
        if (c11 == c12) {
            for (int i13 = i11 + 1; i13 != i12; i13++) {
                if (cArr[i13] == c11) {
                    return i13;
                }
            }
        } else {
            int i14 = i11 + 1;
            int i15 = 0;
            int i16 = 1;
            while (i14 < i12) {
                if (q0(cArr[i14])) {
                    char c13 = cArr[i14];
                    if (c13 == '\n') {
                        if (parserContext != null) {
                            parserContext.setLineOffset((short) i14);
                        }
                        i15++;
                    } else if (c13 == '\r') {
                        continue;
                        i14++;
                    }
                } else if (i14 < i12 && cArr[i14] == '/') {
                    int i17 = i14 + 1;
                    if (i17 == i12) {
                        return i14;
                    }
                    char c14 = cArr[i17];
                    if (c14 == '/') {
                        i14 = i17;
                        while (i14 < i12 && cArr[i14] != '\n') {
                            i14++;
                        }
                    } else if (c14 == '*') {
                        i14 += 2;
                        while (i14 != i12) {
                            char c15 = cArr[i14];
                            if (c15 != '\n' && c15 != '\r') {
                                if (c15 == '*') {
                                    int i18 = i14 + 1;
                                    if (i18 < i12 && cArr[i18] == '/') {
                                        break;
                                    }
                                } else {
                                    continue;
                                    i14++;
                                }
                            }
                            if (parserContext != null) {
                                parserContext.setLineOffset((short) i14);
                            }
                            i15++;
                            i14++;
                        }
                    }
                }
                if (i14 == i12) {
                    return i14;
                }
                char c16 = cArr[i14];
                if (c16 == '\'' || c16 == '\"') {
                    i14 = h(c16, cArr, i14, i12);
                } else if (c16 == c11) {
                    i16++;
                } else if (c16 == c12 && i16 - 1 == 0) {
                    if (parserContext != null) {
                        parserContext.incrementLineCount(i15);
                    }
                    return i14;
                }
                i14++;
            }
        }
        if (c11 == '(') {
            throw new CompileException("unbalanced braces ( ... )", cArr, i11);
        }
        if (c11 == '[') {
            throw new CompileException("unbalanced braces [ ... ]", cArr, i11);
        }
        if (c11 != '{') {
            throw new CompileException("unterminated string literal", cArr, i11);
        }
        throw new CompileException("unbalanced braces { ... }", cArr, i11);
    }

    private static boolean e0(Method method, Method method2) {
        return method2.getReturnType().isAssignableFrom(method.getReturnType()) && method2.getDeclaringClass().isAssignableFrom(method.getDeclaringClass());
    }

    public static Class f(Class cls) {
        Class cls2 = Integer.class;
        if (cls != Integer.TYPE && cls != cls2) {
            cls2 = Integer[].class;
            if (cls != int[].class && cls != cls2) {
                cls2 = Character.class;
                if (cls != Character.TYPE && cls != cls2) {
                    cls2 = Character[].class;
                    if (cls != char[].class && cls != cls2) {
                        cls2 = Long.class;
                        if (cls != Long.TYPE && cls != cls2) {
                            cls2 = Long[].class;
                            if (cls != long[].class && cls != cls2) {
                                cls2 = Short.class;
                                if (cls != Short.TYPE && cls != cls2) {
                                    cls2 = Short[].class;
                                    if (cls != short[].class && cls != cls2) {
                                        cls2 = Double.class;
                                        if (cls != Double.TYPE && cls != cls2) {
                                            cls2 = Double[].class;
                                            if (cls != double[].class && cls != cls2) {
                                                cls2 = Float.class;
                                                if (cls != Float.TYPE && cls != cls2) {
                                                    cls2 = Float[].class;
                                                    if (cls != float[].class && cls != cls2) {
                                                        cls2 = Boolean.class;
                                                        if (cls != Boolean.TYPE && cls != cls2) {
                                                            cls2 = Boolean[].class;
                                                            if (cls != boolean[].class && cls != cls2) {
                                                                cls2 = Byte.class;
                                                                if (cls != Byte.TYPE && cls != cls2) {
                                                                    cls2 = Byte[].class;
                                                                    if (cls != byte[].class && cls != cls2) {
                                                                        return cls;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return cls2;
    }

    public static boolean f0(String str) {
        for (char c11 : str.toCharArray()) {
            if (c11 == '.' || !c0(c11)) {
                return true;
            }
        }
        return false;
    }

    public static String[] g(char[] cArr, int i11, int i12) {
        int i13 = i11 + i12;
        boolean z10 = false;
        int i14 = 0;
        for (int i15 = i11; i15 < i13; i15++) {
            char c11 = cArr[i15];
            if (c11 == '\"') {
                z10 = !z10;
            } else if (c11 == '(') {
                i14++;
            } else if (c11 == ')' && !z10) {
                int i16 = i14 - 1;
                if (1 == i14) {
                    int i17 = i15 + 1;
                    return new String[]{x(cArr, i11, i17 - i11), x(cArr, i17, i13 - i17)};
                }
                i14 = i16;
            }
        }
        return new String[]{new String(cArr, i11, i12)};
    }

    public static boolean g0(Object obj) {
        if (obj == null) {
            return false;
        }
        return obj instanceof String ? h0((String) obj) : obj instanceof char[] ? h0(new String((char[]) obj)) : (obj instanceof Integer) || (obj instanceof BigDecimal) || (obj instanceof BigInteger) || (obj instanceof Float) || (obj instanceof Double) || (obj instanceof Long) || (obj instanceof Short) || (obj instanceof Character);
    }

    public static int h(char c11, char[] cArr, int i11, int i12) {
        int i13;
        char c12;
        while (true) {
            i13 = i11 + 1;
            if (i13 >= i12 || (c12 = cArr[i13]) == c11) {
                break;
            }
            i11 = c12 == '\\' ? i11 + 2 : i13;
        }
        if (i13 >= i12 || cArr[i13] != c11) {
            throw new CompileException("unterminated string literal", cArr, i13);
        }
        return i13;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean h0(java.lang.String r7) {
        /*
            int r0 = r7.length()
            r1 = 1
            r2 = 0
            if (r0 <= r1) goto L24
            char r3 = r7.charAt(r2)
            r4 = 45
            if (r3 != r4) goto L13
        L10:
            r3 = r1
            r4 = r3
            goto L26
        L13:
            char r3 = r7.charAt(r2)
            r5 = 126(0x7e, float:1.77E-43)
            if (r3 != r5) goto L24
            char r3 = r7.charAt(r1)
            if (r3 != r4) goto L10
            r3 = 2
            r4 = r1
            goto L26
        L24:
            r4 = r1
            r3 = r2
        L26:
            if (r3 >= r0) goto L3e
            char r5 = r7.charAt(r3)
            boolean r6 = b0(r5)
            if (r6 != 0) goto L3b
            r6 = 46
            if (r5 != r6) goto L3a
            if (r4 == 0) goto L3a
            r4 = r2
            goto L3b
        L3a:
            return r2
        L3b:
            int r3 = r3 + 1
            goto L26
        L3e:
            if (r0 <= 0) goto L41
            goto L42
        L41:
            r1 = r2
        L42:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mvel2.util.m.h0(java.lang.String):boolean");
    }

    public static int i(char[] cArr, int i11, int i12, ParserContext parserContext) {
        while (i11 != cArr.length) {
            char c11 = cArr[i11];
            if (c11 != '\"') {
                if (c11 != ',' && c11 != ';') {
                    if (c11 != '[' && c11 != '{') {
                        if (c11 != '}') {
                            if (c11 != '\'') {
                                if (c11 != '(') {
                                    continue;
                                    i11++;
                                }
                            }
                        }
                    }
                    i11 = e(cArr, i11, i12, c11, parserContext);
                    if (i11 < cArr.length) {
                        i11++;
                    }
                }
                return i11;
            }
            i11 = h(c11, cArr, i11, cArr.length);
            i11++;
        }
        return i11;
    }

    /* JADX WARN: Code restructure failed: missing block: B:117:0x001a, code lost:
    
        if (r16[r6] == '-') goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0013, code lost:
    
        if (r6 != '~') goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x00e0, code lost:
    
        return false;
     */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:115:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean i0(char[] r16, int r17, int r18) {
        /*
            Method dump skipped, instructions count: 263
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mvel2.util.m.i0(char[], int, int):boolean");
    }

    public static int j(char[] cArr, int i11, int i12, ParserContext parserContext) {
        char c11;
        while (i11 != cArr.length && (c11 = cArr[i11]) != '(') {
            if (c11 == '[') {
                i11 = e(cArr, i11, i12, '[', parserContext);
            } else if (c11 == '{' || q0(c11)) {
                return i11;
            }
            i11++;
        }
        return i11;
    }

    public static boolean j0(Object obj) {
        if (obj == null) {
            return false;
        }
        Class<?> cls = obj instanceof Class ? (Class) obj : obj.getClass();
        return cls == Integer.TYPE || cls == Long.TYPE || cls == Short.TYPE || cls == Double.TYPE || cls == Float.TYPE || Number.class.isAssignableFrom(cls);
    }

    public static void k(String str) {
        if (o0(str)) {
            throw new RuntimeException("illegal use of reserved word: " + str);
        }
        if (b0(str.charAt(0))) {
            throw new RuntimeException("not an identifier: " + str);
        }
    }

    public static boolean k0(Class cls, Class cls2) {
        if ((cls.isPrimitive() ? f(cls) : cls) == null || !Number.class.isAssignableFrom(cls)) {
            return false;
        }
        if (cls2.isPrimitive()) {
            cls2 = f(cls2);
        }
        if (cls2 != null) {
            return Number.class.isAssignableFrom(cls2);
        }
        return false;
    }

    public static boolean l(Object obj, Object obj2) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof String) {
            return ((String) obj).contains(String.valueOf(obj2));
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).contains(obj2);
        }
        if (obj instanceof Map) {
            return ((Map) obj).containsKey(obj2);
        }
        if (obj.getClass().isArray()) {
            if (obj.getClass().getComponentType().isPrimitive()) {
                return t(obj, obj2);
            }
            for (Object obj3 : (Object[]) obj) {
                if ((obj2 == null && obj3 == null) || ((Boolean) m10.a.g(obj3, 18, obj2)).booleanValue()) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean l0(Class cls, Class cls2) {
        Class cls3;
        if (!cls2.isPrimitive()) {
            return false;
        }
        Class O0 = O0(cls);
        if (O0.isPrimitive()) {
            return (cls2 == Double.TYPE && O0 == Float.TYPE) || (cls2 == Float.TYPE && O0 == Long.TYPE) || ((cls2 == Long.TYPE && O0 == Integer.TYPE) || ((cls2 == (cls3 = Integer.TYPE) && O0 == Character.TYPE) || ((cls2 == cls3 && O0 == Short.TYPE) || (cls2 == Short.TYPE && O0 == Byte.TYPE))));
        }
        return false;
    }

    private static boolean m(boolean[] zArr, Boolean bool) {
        boolean booleanValue = bool.booleanValue();
        for (boolean z10 : zArr) {
            if (z10 == booleanValue) {
                return true;
            }
        }
        return false;
    }

    public static boolean m0(Class cls) {
        return cls == Integer.class || cls == Boolean.class || cls == Long.class || cls == Double.class || cls == Float.class || cls == Character.class || cls == Short.class || cls == Byte.class;
    }

    private static boolean n(byte[] bArr, Byte b11) {
        byte byteValue = b11.byteValue();
        for (byte b12 : bArr) {
            if (b12 == byteValue) {
                return true;
            }
        }
        return false;
    }

    public static boolean n0(char[] cArr, int i11, int i12) {
        while (i11 < i12) {
            if (!c0(cArr[i11])) {
                return false;
            }
            i11++;
        }
        return true;
    }

    private static boolean o(char[] cArr, Character ch2) {
        char charValue = ch2.charValue();
        for (char c11 : cArr) {
            if (c11 == charValue) {
                return true;
            }
        }
        return false;
    }

    public static boolean o0(String str) {
        return AbstractParser.LITERALS.containsKey(str) || AbstractParser.OPERATORS.containsKey(str);
    }

    private static boolean p(double[] dArr, Double d11) {
        double doubleValue = d11.doubleValue();
        for (double d12 : dArr) {
            if (d12 == doubleValue) {
                return true;
            }
        }
        return false;
    }

    public static boolean p0(char[] cArr, int i11) {
        if (i11 >= cArr.length) {
            return false;
        }
        while (i11 != cArr.length && q0(cArr[i11])) {
            i11++;
        }
        return i11 == cArr.length || cArr[i11] != ';';
    }

    private static boolean q(float[] fArr, Float f11) {
        float floatValue = f11.floatValue();
        for (float f12 : fArr) {
            if (f12 == floatValue) {
                return true;
            }
        }
        return false;
    }

    public static boolean q0(char c11) {
        return c11 < '!';
    }

    private static boolean r(int[] iArr, Integer num) {
        int intValue = num.intValue();
        for (int i11 : iArr) {
            if (i11 == intValue) {
                return true;
            }
        }
        return false;
    }

    public static Object r0(BigDecimal bigDecimal, int i11) {
        return (i11 == 109 || bigDecimal.scale() > 0) ? Double.valueOf(bigDecimal.doubleValue()) : (i11 == 107 || bigDecimal.longValue() > 2147483647L) ? Long.valueOf(bigDecimal.longValue()) : Integer.valueOf(bigDecimal.intValue());
    }

    private static boolean s(long[] jArr, Long l11) {
        long longValue = l11.longValue();
        for (long j11 : jArr) {
            if (j11 == longValue) {
                return true;
            }
        }
        return false;
    }

    public static int s0(char[] cArr, int i11) {
        if (i11 + 1 >= cArr.length) {
            throw new CompileException("unexpected end of statement", cArr, i11);
        }
        while (i11 != cArr.length && q0(cArr[i11])) {
            i11++;
        }
        return i11;
    }

    private static boolean t(Object obj, Object obj2) {
        Class<?> componentType = obj.getClass().getComponentType();
        if (componentType == Boolean.TYPE) {
            return (obj2 instanceof Boolean) && m((boolean[]) obj, (Boolean) obj2);
        }
        if (componentType == Integer.TYPE) {
            return (obj2 instanceof Integer) && r((int[]) obj, (Integer) obj2);
        }
        if (componentType == Long.TYPE) {
            return (obj2 instanceof Long) && s((long[]) obj, (Long) obj2);
        }
        if (componentType == Double.TYPE) {
            return (obj2 instanceof Double) && p((double[]) obj, (Double) obj2);
        }
        if (componentType == Float.TYPE) {
            return (obj2 instanceof Float) && q((float[]) obj, (Float) obj2);
        }
        if (componentType == Character.TYPE) {
            return (obj2 instanceof Character) && o((char[]) obj, (Character) obj2);
        }
        if (componentType == Short.TYPE) {
            return (obj2 instanceof Short) && u((short[]) obj, (Short) obj2);
        }
        if (componentType == Byte.TYPE) {
            return (obj2 instanceof Byte) && n((byte[]) obj, (Byte) obj2);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0053 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int t0(char[] r8, int r9, int r10) {
        /*
            r0 = 45
            r1 = 1
            if (r10 <= r1) goto L19
            char r2 = r8[r9]
            if (r2 != r0) goto Lc
            int r2 = r9 + 1
            goto L1a
        Lc:
            r3 = 126(0x7e, float:1.77E-43)
            if (r2 != r3) goto L19
            int r2 = r9 + 1
            char r3 = r8[r2]
            if (r3 != r0) goto L1a
            int r2 = r9 + 2
            goto L1a
        L19:
            r2 = r9
        L1a:
            int r9 = r9 + r10
            r3 = 0
        L1c:
            r4 = -1
            r5 = 101(0x65, float:1.42E-43)
            if (r2 >= r9) goto L44
            char r6 = r8[r2]
            boolean r7 = b0(r6)
            if (r7 != 0) goto L42
            r3 = 46
            if (r6 == r3) goto L3e
            r3 = 69
            if (r6 == r3) goto L34
            if (r6 == r5) goto L34
            return r4
        L34:
            int r3 = r2 + 1
            if (r2 >= r9) goto L40
            char r4 = r8[r3]
            if (r4 != r0) goto L40
            int r2 = r2 + 2
        L3e:
            r3 = r1
            goto L42
        L40:
            r2 = r3
            goto L3e
        L42:
            int r2 = r2 + r1
            goto L1c
        L44:
            if (r10 == 0) goto L53
            if (r3 == 0) goto L4b
            r8 = 103(0x67, float:1.44E-43)
            return r8
        L4b:
            r8 = 9
            if (r10 <= r8) goto L52
            r8 = 102(0x66, float:1.43E-43)
            return r8
        L52:
            return r5
        L53:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mvel2.util.m.t0(char[], int, int):int");
    }

    private static boolean u(short[] sArr, Short sh2) {
        short shortValue = sh2.shortValue();
        for (short s11 : sArr) {
            if (s11 == shortValue) {
                return true;
            }
        }
        return false;
    }

    public static int u0(char c11) {
        if (c11 == '%') {
            return 4;
        }
        if (c11 == '&') {
            return 6;
        }
        if (c11 == '*') {
            return 2;
        }
        if (c11 == '+') {
            return 0;
        }
        if (c11 == '/') {
            return 3;
        }
        if (c11 == '^') {
            return 8;
        }
        if (c11 == '|') {
            return 7;
        }
        if (c11 == 187) {
            return 9;
        }
        if (c11 != 171) {
            return c11 != 172 ? -1 : 11;
        }
        return 10;
    }

    public static Class v(String str, ParserContext parserContext) {
        Class<?> cls;
        Class cls2;
        ClassLoader classLoader = parserContext != null ? parserContext.getClassLoader() : Thread.currentThread().getContextClassLoader();
        Map map = f72188d;
        Map map2 = (Map) map.get(classLoader);
        if (map2 == null) {
            map2 = Collections.synchronizedMap(new WeakHashMap(10));
            map.put(classLoader, map2);
        }
        WeakReference weakReference = (WeakReference) map2.get(str);
        if (weakReference != null && (cls2 = (Class) weakReference.get()) != null) {
            return cls2;
        }
        try {
            cls = Class.forName(str, true, classLoader);
        } catch (ClassNotFoundException e11) {
            if (classLoader == Thread.currentThread().getContextClassLoader()) {
                throw e11;
            }
            cls = Class.forName(str, true, Thread.currentThread().getContextClassLoader());
        }
        map2.put(str, new WeakReference(cls));
        return cls;
    }

    public static Serializable v0(CompiledExpression compiledExpression) {
        return (!compiledExpression.isImportInjectionRequired() && compiledExpression.getParserConfiguration().isAllowBootstrapBypass() && compiledExpression.isSingleNode()) ? b(compiledExpression) : compiledExpression;
    }

    public static char[] w(String str, char[] cArr, int i11, int i12, int i13) {
        char c11;
        if (i13 == -1) {
            return cArr;
        }
        if (i13 == 0) {
            c11 = '+';
        } else if (i13 == 1) {
            c11 = '-';
        } else if (i13 == 2) {
            c11 = '*';
        } else if (i13 == 3) {
            c11 = '/';
        } else if (i13 == 4) {
            c11 = '%';
        } else if (i13 == 6) {
            c11 = '&';
        } else if (i13 == 7) {
            c11 = '|';
        } else if (i13 != 20) {
            switch (i13) {
                case 9:
                    c11 = 187;
                    break;
                case 10:
                    c11 = 171;
                    break;
                case 11:
                    c11 = 172;
                    break;
                default:
                    c11 = 0;
                    break;
            }
        } else {
            c11 = '#';
        }
        char[] charArray = str.toCharArray();
        char[] cArr2 = new char[str.length() + i12 + 1];
        System.arraycopy(charArray, 0, cArr2, 0, str.length());
        cArr2[str.length()] = c11;
        System.arraycopy(cArr, i11, cArr2, str.length() + 1, i12);
        return cArr2;
    }

    public static List w0(char[] cArr) {
        int i11;
        int i12 = 0;
        while (true) {
            if (i12 >= cArr.length) {
                i11 = -1;
                break;
            }
            if (cArr[i12] == '(') {
                i11 = i12 + 1;
                break;
            }
            i12++;
        }
        if (i11 == -1) {
            return Collections.emptyList();
        }
        int i13 = i11 - 1;
        return y0(cArr, i11, (c(cArr, i13, '(') - i13) - 1);
    }

    public static String x(char[] cArr, int i11, int i12) {
        int i13 = i12 + i11;
        if (i13 > cArr.length) {
            return new String(cArr);
        }
        while (i11 != i13 && cArr[i11] < '!') {
            i11++;
        }
        while (i13 != i11 && cArr[i13 - 1] < '!') {
            i13--;
        }
        return new String(cArr, i11, i13 - i11);
    }

    public static String[] x0(char[] cArr, int i11, int i12) {
        LinkedList linkedList = new LinkedList();
        if (i12 == -1) {
            i12 = cArr.length;
        }
        int i13 = i11 + i12;
        int i14 = i11;
        while (i11 < i13) {
            char c11 = cArr[i11];
            if (c11 == '\"') {
                i11 = h('\"', cArr, i11, cArr.length);
            } else if (c11 != ',') {
                if (c11 != '[' && c11 != '{') {
                    if (c11 == '\'') {
                        i11 = h('\'', cArr, i11, cArr.length);
                    } else if (c11 != '(') {
                        if (!q0(c11) && !c0(cArr[i11])) {
                            throw new CompileException("expected parameter", cArr, i14);
                        }
                    }
                }
                i11 = c(cArr, i11, c11);
            } else {
                if (i11 > i14) {
                    while (q0(cArr[i14])) {
                        i14++;
                    }
                    String str = new String(cArr, i14, i11 - i14);
                    k(str);
                    linkedList.add(str);
                }
                while (q0(cArr[i11])) {
                    i11++;
                }
                i14 = i11 + 1;
            }
            i11++;
        }
        if (i14 < i13 && i11 > i14) {
            String x10 = x(cArr, i14, i11 - i14);
            if (x10.length() > 0) {
                k(x10);
                linkedList.add(x10);
            }
        } else if (linkedList.size() == 0) {
            String x11 = x(cArr, i14, i12);
            if (x11.length() > 0) {
                k(x11);
                linkedList.add(x11);
            }
        }
        return (String[]) linkedList.toArray(new String[linkedList.size()]);
    }

    private static Method y(Class cls, Method method) {
        String name = method.getName();
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Method method2 : cls2.getMethods()) {
                if (method2.getParameterTypes().length == 0 && name.equals(method2.getName())) {
                    return method2;
                }
            }
        }
        if (cls.getSuperclass() != null) {
            return y(cls.getSuperclass(), method);
        }
        return null;
    }

    public static List y0(char[] cArr, int i11, int i12) {
        ArrayList arrayList = new ArrayList();
        if (i12 == -1) {
            i12 = cArr.length;
        }
        int i13 = i11 + i12;
        int i14 = i11;
        while (i11 < i13) {
            char c11 = cArr[i11];
            if (c11 == '\"') {
                i11 = h('\"', cArr, i11, cArr.length);
            } else if (c11 != ',') {
                if (c11 != '[' && c11 != '{') {
                    if (c11 == '\'') {
                        i11 = h('\'', cArr, i11, cArr.length);
                    } else if (c11 != '(') {
                    }
                }
                i11 = c(cArr, i11, c11);
            } else {
                if (i11 > i14) {
                    while (q0(cArr[i14])) {
                        i14++;
                    }
                    arrayList.add(L0(cArr, i14, i11 - i14));
                }
                while (q0(cArr[i11])) {
                    i11++;
                }
                i14 = i11 + 1;
            }
            i11++;
        }
        if (i14 < i13 && i11 > i14) {
            char[] L0 = L0(cArr, i14, i11 - i14);
            if (L0.length > 0) {
                arrayList.add(L0);
            }
        } else if (arrayList.size() == 0) {
            char[] L02 = L0(cArr, i14, i12);
            if (L02.length > 0) {
                arrayList.add(L02);
            }
        }
        return arrayList;
    }

    public static Method z(Method method) {
        return y(method.getDeclaringClass(), method);
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x014c, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void z0(java.lang.String r17, char[] r18, int r19, int r20, java.lang.Object r21, org.mvel2.integration.VariableResolverFactory r22) {
        /*
            Method dump skipped, instructions count: 474
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mvel2.util.m.z0(java.lang.String, char[], int, int, java.lang.Object, org.mvel2.integration.VariableResolverFactory):void");
    }
}
