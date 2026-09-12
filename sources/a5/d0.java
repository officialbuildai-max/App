package a5;

import com.alibaba.fastjson.serializer.SerializerFeature;
import java.lang.reflect.Type;
import java.text.DecimalFormat;

/* loaded from: classes2.dex */
public class d0 implements z0 {

    /* renamed from: b, reason: collision with root package name */
    public static final d0 f264b = new d0();

    /* renamed from: a, reason: collision with root package name */
    private DecimalFormat f265a;

    public d0() {
        this.f265a = null;
    }

    public d0(String str) {
        this(new DecimalFormat(str));
    }

    public d0(DecimalFormat decimalFormat) {
        this.f265a = decimalFormat;
    }

    @Override // a5.z0
    public void d(o0 o0Var, Object obj, Object obj2, Type type, int i11) {
        j1 j1Var = o0Var.f371k;
        if (obj == null) {
            j1Var.p0(SerializerFeature.WriteNullNumberAsZero);
            return;
        }
        double doubleValue = ((Double) obj).doubleValue();
        if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
            j1Var.m0();
            return;
        }
        DecimalFormat decimalFormat = this.f265a;
        if (decimalFormat == null) {
            j1Var.u(doubleValue, true);
        } else {
            j1Var.write(decimalFormat.format(doubleValue));
        }
    }
}
