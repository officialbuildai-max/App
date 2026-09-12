package z4;

import com.alibaba.fastjson.JSONException;
import java.lang.reflect.Type;

/* loaded from: classes3.dex */
public class g3 implements b2 {

    /* renamed from: a, reason: collision with root package name */
    public final Class f79351a;

    public g3(Class cls) {
        this.f79351a = cls;
    }

    @Override // z4.b2
    public int b() {
        return 12;
    }

    @Override // z4.b2
    public Object c(y4.a aVar, Type type, Object obj) {
        try {
            android.support.v4.media.session.c.a(this.f79351a.newInstance());
            return aVar.V(null, obj);
        } catch (Exception unused) {
            throw new JSONException("craete instance error");
        }
    }
}
