package a5;

import com.alibaba.fastjson.serializer.SerializerFeature;
import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public class k implements z0 {

    /* renamed from: a, reason: collision with root package name */
    public static final k f360a = new k();

    @Override // a5.z0
    public void d(o0 o0Var, Object obj, Object obj2, Type type, int i11) {
        if (obj == null) {
            o0Var.f371k.p0(SerializerFeature.WriteNullStringAsEmpty);
        } else {
            o0Var.B(obj.toString());
        }
    }
}
