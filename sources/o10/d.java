package o10;

import java.util.HashMap;
import java.util.Map;
import org.mvel2.integration.VariableResolverFactory;

/* loaded from: classes7.dex */
public class d implements org.mvel2.compiler.a {

    /* renamed from: a, reason: collision with root package name */
    private org.mvel2.compiler.a[] f70774a;

    /* renamed from: b, reason: collision with root package name */
    private org.mvel2.compiler.a[] f70775b;

    /* renamed from: c, reason: collision with root package name */
    private int f70776c;

    public d(org.mvel2.compiler.a[] aVarArr, org.mvel2.compiler.a[] aVarArr2) {
        this.f70774a = aVarArr;
        this.f70776c = aVarArr.length;
        this.f70775b = aVarArr2;
    }

    @Override // org.mvel2.compiler.a
    public Class getKnownEgressType() {
        return Map.class;
    }

    @Override // org.mvel2.compiler.a
    public Object getValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        HashMap hashMap = new HashMap(this.f70776c * 2);
        int i11 = this.f70776c;
        while (true) {
            i11--;
            if (i11 == -1) {
                return hashMap;
            }
            hashMap.put(this.f70774a[i11].getValue(obj, obj2, variableResolverFactory), this.f70775b[i11].getValue(obj, obj2, variableResolverFactory));
        }
    }

    @Override // org.mvel2.compiler.a
    public Object setValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory, Object obj3) {
        return null;
    }
}
