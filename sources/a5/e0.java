package a5;

import com.alibaba.fastjson.JSONException;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public class e0 implements z0 {

    /* renamed from: b, reason: collision with root package name */
    public static final e0 f267b = new e0();

    /* renamed from: a, reason: collision with root package name */
    private final Member f268a;

    public e0() {
        this.f268a = null;
    }

    public e0(Member member) {
        this.f268a = member;
    }

    @Override // a5.z0
    public void d(o0 o0Var, Object obj, Object obj2, Type type, int i11) {
        Member member = this.f268a;
        if (member == null) {
            o0Var.f371k.v((Enum) obj);
            return;
        }
        try {
            o0Var.A(member instanceof Field ? ((Field) member).get(obj) : ((Method) member).invoke(obj, null));
        } catch (Exception e11) {
            throw new JSONException("getEnumValue error", e11);
        }
    }
}
