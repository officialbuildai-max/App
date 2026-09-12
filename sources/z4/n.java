package z4;

import com.alibaba.fastjson.JSONException;
import java.lang.reflect.Type;

/* loaded from: classes3.dex */
public class n implements b2 {

    /* renamed from: a, reason: collision with root package name */
    public static final n f79369a = new n();

    @Override // z4.b2
    public int b() {
        return 0;
    }

    @Override // z4.b2
    public Object c(y4.a aVar, Type type, Object obj) {
        int q02;
        y4.c cVar = (y4.c) aVar.s();
        String w11 = cVar.w(aVar.v());
        cVar.Z();
        int q03 = cVar.q0();
        if (q03 == 25) {
            String str = w11 + ".";
            w11 = str + cVar.w(aVar.v());
            cVar.Z();
            q03 = cVar.q0();
        }
        com.alibaba.fastjson.c cVar2 = new com.alibaba.fastjson.c(w11);
        if (q03 != 10) {
            throw new JSONException("illegal jsonp : " + cVar.k());
        }
        cVar.Z();
        while (true) {
            cVar2.b(aVar.T());
            q02 = cVar.q0();
            if (q02 != 16) {
                break;
            }
            cVar.Z();
        }
        if (q02 == 11) {
            cVar.Z();
            if (cVar.q0() == 24) {
                cVar.Z();
            }
            return cVar2;
        }
        throw new JSONException("illegal jsonp : " + cVar.k());
    }
}
