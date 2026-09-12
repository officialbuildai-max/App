package o10;

import java.lang.reflect.Array;
import org.mvel2.integration.VariableResolverFactory;

/* loaded from: classes7.dex */
public class a implements org.mvel2.compiler.a {

    /* renamed from: a, reason: collision with root package name */
    public org.mvel2.compiler.a[] f70770a;

    /* renamed from: b, reason: collision with root package name */
    private Class f70771b;

    public a(org.mvel2.compiler.a[] aVarArr, Class cls) {
        this.f70770a = aVarArr;
        this.f70771b = cls;
    }

    @Override // org.mvel2.compiler.a
    public Class getKnownEgressType() {
        return this.f70771b;
    }

    @Override // org.mvel2.compiler.a
    public Object getValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        int i11 = 0;
        if (Object.class.equals(this.f70771b)) {
            int length = this.f70770a.length;
            Object[] objArr = new Object[length];
            while (i11 < length) {
                objArr[i11] = this.f70770a[i11].getValue(obj, obj2, variableResolverFactory);
                i11++;
            }
            return objArr;
        }
        Object newInstance = Array.newInstance((Class<?>) this.f70771b, this.f70770a.length);
        while (true) {
            org.mvel2.compiler.a[] aVarArr = this.f70770a;
            if (i11 >= aVarArr.length) {
                return newInstance;
            }
            Array.set(newInstance, i11, aVarArr[i11].getValue(obj, obj2, variableResolverFactory));
            i11++;
        }
    }

    @Override // org.mvel2.compiler.a
    public Object setValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory, Object obj3) {
        return null;
    }
}
