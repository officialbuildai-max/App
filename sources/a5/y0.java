package a5;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import z4.b2;

/* loaded from: classes2.dex */
public class y0 implements z0, b2 {

    /* renamed from: a, reason: collision with root package name */
    public static final y0 f436a = new y0();

    /* JADX WARN: Removed duplicated region for block: B:33:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.Object e(y4.a r12, java.lang.Class r13, com.alibaba.fastjson.JSONArray r14) {
        /*
            r11 = this;
            r0 = 0
            if (r14 != 0) goto L4
            return r0
        L4:
            int r1 = r14.size()
            java.lang.Object r2 = java.lang.reflect.Array.newInstance(r13, r1)
            r3 = 0
            r4 = r3
        Le:
            if (r4 >= r1) goto L65
            java.lang.Object r5 = r14.get(r4)
            if (r5 != r14) goto L1a
            java.lang.reflect.Array.set(r2, r4, r2)
            goto L62
        L1a:
            boolean r6 = r13.isArray()
            if (r6 == 0) goto L31
            boolean r6 = r13.isInstance(r5)
            if (r6 == 0) goto L27
            goto L2d
        L27:
            com.alibaba.fastjson.JSONArray r5 = (com.alibaba.fastjson.JSONArray) r5
            java.lang.Object r5 = r11.e(r12, r13, r5)
        L2d:
            java.lang.reflect.Array.set(r2, r4, r5)
            goto L62
        L31:
            boolean r6 = r5 instanceof com.alibaba.fastjson.JSONArray
            if (r6 == 0) goto L54
            r6 = r5
            com.alibaba.fastjson.JSONArray r6 = (com.alibaba.fastjson.JSONArray) r6
            int r7 = r6.size()
            r8 = r3
            r9 = r8
        L3e:
            if (r8 >= r7) goto L4d
            java.lang.Object r10 = r6.get(r8)
            if (r10 != r14) goto L4a
            r6.set(r4, r2)
            r9 = 1
        L4a:
            int r8 = r8 + 1
            goto L3e
        L4d:
            if (r9 == 0) goto L54
            java.lang.Object[] r6 = r6.toArray()
            goto L55
        L54:
            r6 = r0
        L55:
            if (r6 != 0) goto L5f
            y4.h r6 = r12.m()
            java.lang.Object r6 = com.alibaba.fastjson.util.TypeUtils.f(r5, r13, r6)
        L5f:
            java.lang.reflect.Array.set(r2, r4, r6)
        L62:
            int r4 = r4 + 1
            goto Le
        L65:
            r14.setRelatedArray(r2)
            r14.setComponentType(r13)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: a5.y0.e(y4.a, java.lang.Class, com.alibaba.fastjson.JSONArray):java.lang.Object");
    }

    @Override // z4.b2
    public int b() {
        return 14;
    }

    @Override // z4.b2
    public Object c(y4.a aVar, Type type, Object obj) {
        Class<?> cls;
        Type type2;
        y4.b bVar = aVar.f78954f;
        int q02 = bVar.q0();
        Type type3 = null;
        if (q02 == 8) {
            bVar.c0(16);
            return null;
        }
        if (q02 == 4 || q02 == 26) {
            byte[] h02 = bVar.h0();
            bVar.c0(16);
            if (h02.length != 0 || type == byte[].class) {
                return h02;
            }
            return null;
        }
        if (type instanceof GenericArrayType) {
            Type genericComponentType = ((GenericArrayType) type).getGenericComponentType();
            if (genericComponentType instanceof TypeVariable) {
                TypeVariable typeVariable = (TypeVariable) genericComponentType;
                Type type4 = aVar.n().f78993e;
                if (type4 instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) type4;
                    Type rawType = parameterizedType.getRawType();
                    if (rawType instanceof Class) {
                        TypeVariable[] typeParameters = ((Class) rawType).getTypeParameters();
                        for (int i11 = 0; i11 < typeParameters.length; i11++) {
                            if (typeParameters[i11].getName().equals(typeVariable.getName())) {
                                type3 = parameterizedType.getActualTypeArguments()[i11];
                            }
                        }
                    }
                    if (type3 instanceof Class) {
                        cls = (Class) type3;
                        type2 = genericComponentType;
                    } else {
                        cls = Object.class;
                        type2 = genericComponentType;
                    }
                } else {
                    cls = TypeUtils.Q(typeVariable.getBounds()[0]);
                    type2 = genericComponentType;
                }
            } else {
                cls = TypeUtils.Q(genericComponentType);
                type2 = genericComponentType;
            }
        } else {
            Class<?> componentType = ((Class) type).getComponentType();
            cls = componentType;
            type2 = componentType;
        }
        JSONArray jSONArray = new JSONArray();
        aVar.c0(type2, jSONArray, obj);
        return e(aVar, cls, jSONArray);
    }

    @Override // a5.z0
    public final void d(o0 o0Var, Object obj, Object obj2, Type type, int i11) {
        j1 j1Var = o0Var.f371k;
        Object[] objArr = (Object[]) obj;
        if (obj == null) {
            j1Var.p0(SerializerFeature.WriteNullListAsEmpty);
            return;
        }
        int length = objArr.length;
        int i12 = length - 1;
        if (i12 == -1) {
            j1Var.append("[]");
            return;
        }
        e1 e1Var = o0Var.f378r;
        o0Var.w(e1Var, obj, obj2, 0);
        try {
            j1Var.append('[');
            if (j1Var.q(SerializerFeature.PrettyFormat)) {
                o0Var.s();
                o0Var.v();
                for (int i13 = 0; i13 < length; i13++) {
                    if (i13 != 0) {
                        j1Var.write(44);
                        o0Var.v();
                    }
                    o0Var.E(objArr[i13], Integer.valueOf(i13));
                }
                o0Var.l();
                o0Var.v();
                j1Var.write(93);
                o0Var.f378r = e1Var;
                return;
            }
            Class<?> cls = null;
            z0 z0Var = null;
            for (int i14 = 0; i14 < i12; i14++) {
                Object obj3 = objArr[i14];
                if (obj3 == null) {
                    j1Var.append("null,");
                } else {
                    if (o0Var.k(obj3)) {
                        o0Var.D(obj3);
                    } else {
                        Class<?> cls2 = obj3.getClass();
                        if (cls2 == cls) {
                            z0Var.d(o0Var, obj3, Integer.valueOf(i14), null, 0);
                        } else {
                            z0Var = o0Var.q(cls2);
                            z0Var.d(o0Var, obj3, Integer.valueOf(i14), null, 0);
                            cls = cls2;
                        }
                    }
                    j1Var.append(',');
                }
            }
            Object obj4 = objArr[i12];
            if (obj4 == null) {
                j1Var.append("null]");
            } else {
                if (o0Var.k(obj4)) {
                    o0Var.D(obj4);
                } else {
                    o0Var.E(obj4, Integer.valueOf(i12));
                }
                j1Var.append(']');
            }
            o0Var.f378r = e1Var;
        } catch (Throwable th2) {
            o0Var.f378r = e1Var;
            throw th2;
        }
    }
}
