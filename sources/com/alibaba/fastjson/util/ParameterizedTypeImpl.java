package com.alibaba.fastjson.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class ParameterizedTypeImpl implements ParameterizedType {

    /* renamed from: a, reason: collision with root package name */
    private final Type[] f18246a;

    /* renamed from: b, reason: collision with root package name */
    private final Type f18247b;

    /* renamed from: c, reason: collision with root package name */
    private final Type f18248c;

    public ParameterizedTypeImpl(Type[] typeArr, Type type, Type type2) {
        this.f18246a = typeArr;
        this.f18247b = type;
        this.f18248c = type2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ParameterizedTypeImpl parameterizedTypeImpl = (ParameterizedTypeImpl) obj;
        if (!Arrays.equals(this.f18246a, parameterizedTypeImpl.f18246a)) {
            return false;
        }
        Type type = this.f18247b;
        if (type == null ? parameterizedTypeImpl.f18247b != null : !type.equals(parameterizedTypeImpl.f18247b)) {
            return false;
        }
        Type type2 = this.f18248c;
        Type type3 = parameterizedTypeImpl.f18248c;
        return type2 != null ? type2.equals(type3) : type3 == null;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type[] getActualTypeArguments() {
        return this.f18246a;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getOwnerType() {
        return this.f18247b;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getRawType() {
        return this.f18248c;
    }

    public int hashCode() {
        Type[] typeArr = this.f18246a;
        int hashCode = (typeArr != null ? Arrays.hashCode(typeArr) : 0) * 31;
        Type type = this.f18247b;
        int hashCode2 = (hashCode + (type != null ? type.hashCode() : 0)) * 31;
        Type type2 = this.f18248c;
        return hashCode2 + (type2 != null ? type2.hashCode() : 0);
    }
}
