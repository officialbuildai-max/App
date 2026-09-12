package z4;

import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.util.ParameterizedTypeImpl;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes3.dex */
public class c extends l {

    /* renamed from: c, reason: collision with root package name */
    private final Type f79343c;

    /* renamed from: d, reason: collision with root package name */
    private int f79344d;

    /* renamed from: e, reason: collision with root package name */
    private b2 f79345e;

    public c(y4.h hVar, Class cls, com.alibaba.fastjson.util.d dVar) {
        super(cls, dVar);
        Type type = dVar.f18284f;
        if (!(type instanceof ParameterizedType)) {
            this.f79343c = Object.class;
            return;
        }
        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
        if (type2 instanceof WildcardType) {
            Type[] upperBounds = ((WildcardType) type2).getUpperBounds();
            if (upperBounds.length == 1) {
                type2 = upperBounds[0];
            }
        }
        this.f79343c = type2;
    }

    @Override // z4.l
    public int b() {
        return 14;
    }

    @Override // z4.l
    public void d(y4.a aVar, Object obj, Type type, Map map) {
        y4.b bVar = aVar.f78954f;
        int q02 = bVar.q0();
        if (q02 == 8 || (q02 == 4 && bVar.k0().length() == 0)) {
            if (obj == null) {
                map.put(this.f79366a.f18279a, null);
                return;
            } else {
                i(obj, null);
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        y4.g n11 = aVar.n();
        aVar.z0(n11, obj, this.f79366a.f18279a);
        k(aVar, type, arrayList);
        aVar.B0(n11);
        if (obj == null) {
            map.put(this.f79366a.f18279a, arrayList);
        } else {
            h(obj, arrayList);
        }
    }

    public final void k(y4.a aVar, Type type, Collection collection) {
        Class cls;
        int i11;
        int i12;
        Type type2 = this.f79343c;
        b2 b2Var = this.f79345e;
        int i13 = 0;
        if (type instanceof ParameterizedType) {
            if (type2 instanceof TypeVariable) {
                TypeVariable typeVariable = (TypeVariable) type2;
                ParameterizedType parameterizedType = (ParameterizedType) type;
                cls = parameterizedType.getRawType() instanceof Class ? (Class) parameterizedType.getRawType() : null;
                if (cls != null) {
                    int length = cls.getTypeParameters().length;
                    i12 = 0;
                    while (i12 < length) {
                        if (cls.getTypeParameters()[i12].getName().equals(typeVariable.getName())) {
                            break;
                        } else {
                            i12++;
                        }
                    }
                }
                i12 = -1;
                if (i12 != -1) {
                    type2 = parameterizedType.getActualTypeArguments()[i12];
                    if (!type2.equals(this.f79343c)) {
                        b2Var = aVar.m().p(type2);
                    }
                }
            } else if (type2 instanceof ParameterizedType) {
                ParameterizedType parameterizedType2 = (ParameterizedType) type2;
                Type[] actualTypeArguments = parameterizedType2.getActualTypeArguments();
                if (actualTypeArguments.length == 1) {
                    Type type3 = actualTypeArguments[0];
                    if (type3 instanceof TypeVariable) {
                        TypeVariable typeVariable2 = (TypeVariable) type3;
                        ParameterizedType parameterizedType3 = (ParameterizedType) type;
                        cls = parameterizedType3.getRawType() instanceof Class ? (Class) parameterizedType3.getRawType() : null;
                        if (cls != null) {
                            int length2 = cls.getTypeParameters().length;
                            i11 = 0;
                            while (i11 < length2) {
                                if (cls.getTypeParameters()[i11].getName().equals(typeVariable2.getName())) {
                                    break;
                                } else {
                                    i11++;
                                }
                            }
                        }
                        i11 = -1;
                        if (i11 != -1) {
                            actualTypeArguments[0] = parameterizedType3.getActualTypeArguments()[i11];
                            type2 = com.alibaba.fastjson.g.b(new ParameterizedTypeImpl(actualTypeArguments, parameterizedType2.getOwnerType(), parameterizedType2.getRawType()));
                        }
                    }
                }
            }
        } else if ((type2 instanceof TypeVariable) && (type instanceof Class)) {
            Class cls2 = (Class) type;
            TypeVariable typeVariable3 = (TypeVariable) type2;
            cls2.getTypeParameters();
            int length3 = cls2.getTypeParameters().length;
            int i14 = 0;
            while (true) {
                if (i14 >= length3) {
                    break;
                }
                TypeVariable typeVariable4 = cls2.getTypeParameters()[i14];
                if (typeVariable4.getName().equals(typeVariable3.getName())) {
                    Type[] bounds = typeVariable4.getBounds();
                    if (bounds.length == 1) {
                        type2 = bounds[0];
                    }
                } else {
                    i14++;
                }
            }
        }
        y4.b bVar = aVar.f78954f;
        int q02 = bVar.q0();
        if (q02 != 14) {
            if (q02 == 4 && this.f79366a.f18297s) {
                String k02 = bVar.k0();
                bVar.Z();
                new y4.a(k02).d0(collection);
                return;
            } else {
                if (b2Var == null) {
                    b2Var = aVar.m().p(type2);
                    this.f79345e = b2Var;
                }
                collection.add(b2Var.c(aVar, type2, 0));
                aVar.k(collection);
                return;
            }
        }
        if (b2Var == null) {
            b2Var = aVar.m().p(type2);
            this.f79345e = b2Var;
            this.f79344d = b2Var.b();
        }
        b2 b2Var2 = b2Var;
        bVar.c0(this.f79344d);
        while (true) {
            if (bVar.n(Feature.AllowArbitraryCommas)) {
                while (bVar.q0() == 16) {
                    bVar.Z();
                }
            }
            if (bVar.q0() == 15) {
                bVar.c0(16);
                return;
            }
            collection.add(b2Var2.c(aVar, type2, Integer.valueOf(i13)));
            aVar.k(collection);
            if (bVar.q0() == 16) {
                bVar.c0(this.f79344d);
            }
            i13++;
        }
    }
}
